package com.alonsocorp.aleyumy.servicio;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.alonsocorp.aleyumy.modelo.Usuarios;
import com.alonsocorp.aleyumy.repository.UsuariosRepository;

@Service
public class UsuariosServicio {
    @Autowired
    private UsuariosRepository usuariosRepository;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private final Random random = new Random();

    // Registrar usuario
    public Usuarios guardar(Usuarios usuario) {
        usuario.setContrasena(passwordEncoder.encode(usuario.getContrasena()));
        return usuariosRepository.save(usuario);
    }

    // Listar todos
    public List<Usuarios> listar() {
        return usuariosRepository.obtenerUsuarios();
    }

    // Buscar por ID
    public Optional<Usuarios> buscarPorId(Integer id) {
        return usuariosRepository.findById(id);
    }

    // Eliminar por ID
    public void eliminar(Integer id) {
        usuariosRepository.deleteById(id);
    }

    // Buscar por correo
    public Usuarios buscarPorCorreo(String correo) {
        return usuariosRepository.findByCorreo(correo);
    }

    

    // ============================================================
    // LOGIN (1) VALIDAR CREDENCIALES
    // ============================================================

    public Usuarios validarCredenciales(String correo, String contrasena) {
        Usuarios u = usuariosRepository.findByCorreo(correo);
        if (u == null) return null;

        if (!passwordEncoder.matches(contrasena, u.getContrasena())) {
            return null;
        }

        return u;
    }

    // ============================================================
    // LOGIN (2) GENERAR TOKEN
    // ============================================================

    public void generarTokenLogin(Usuarios usuario) {
        String token = generarCodigo();
        usuario.setTokenLogin(token);
        usuario.setTokenLoginExpira(LocalDateTime.now().plusMinutes(5));
        usuariosRepository.save(usuario);

        enviarCorreo(usuario.getCorreo(),
                "Código de inicio de sesión",
                "Tu código para iniciar sesión es: " + token);
    }

    // ============================================================
    // LOGIN (3) VALIDAR TOKEN
    // ============================================================

    public Usuarios validarTokenLogin(String token) {
        Usuarios u = usuariosRepository.findByTokenLogin(token);
        if (u == null) return null;

        if (u.getTokenLoginExpira().isBefore(LocalDateTime.now()))
            return null;

        // token válido → eliminar
        u.setTokenLogin(null);
        u.setTokenLoginExpira(null);
        usuariosRepository.save(u);

        return u;
    }

    // ============================================================
    // RECUPERAR CONTRASEÑA (1) GENERAR TOKEN
    // ============================================================

    public boolean generarTokenRecuperar(String correo) {
        Usuarios u = usuariosRepository.findByCorreo(correo);
        if (u == null) return false;

        String token = generarCodigo();
        u.setTokenRecuperar(token);
        u.setTokenRecuperarExpira(LocalDateTime.now().plusMinutes(10));
        usuariosRepository.save(u);

        enviarCorreo(correo,
                "Código para recuperar contraseña",
                "Tu código para recuperar tu cuenta es: " + token);

        return true;
    }

    // ============================================================
    // RECUPERAR CONTRASEÑA (2) VALIDAR TOKEN
    // ============================================================

    public Usuarios validarTokenRecuperar(String token) {
        Usuarios u = usuariosRepository.findByTokenRecuperar(token);
        if (u == null) return null;

        if (u.getTokenRecuperarExpira().isBefore(LocalDateTime.now()))
            return null;

        return u;
    }

    // ============================================================
    // RECUPERAR CONTRASEÑA (3) ACTUALIZAR CONTRASEÑA
    // ============================================================

    public void actualizarContrasena(String correo, String nuevaContrasena) {
        Usuarios u = usuariosRepository.findByCorreo(correo);
        u.setContrasena(passwordEncoder.encode(nuevaContrasena));
        u.setTokenRecuperar(null);
        u.setTokenRecuperarExpira(null);
        usuariosRepository.save(u);
    }

    // ============================================================
    // CORREO
    // ============================================================

    private void enviarCorreo(String para, String asunto, String cuerpo) {
        SimpleMailMessage mensaje = new SimpleMailMessage();
        mensaje.setTo(para);
        mensaje.setSubject(asunto);
        mensaje.setText(cuerpo);
        mailSender.send(mensaje);
    }

    // ============================================================
    // GENERAR TOKEN NUMÉRICO DE 6 DÍGITOS
    // ============================================================

    private String generarCodigo() {
        int codigo = random.nextInt(900000) + 100000;
        return String.valueOf(codigo);
    }





    
    





}
