package com.alonsocorp.aleyumy.Controlador;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/convertidor")
public class ConvertidorController {

    @GetMapping("/convertir")
    public double convertir(@RequestParam String destino,
                            @RequestParam double monto) {
        double tasa;

        switch (destino.toUpperCase()) {
            case "USD":
                tasa = 3.37; // 1 USD = 3.37 PEN
                break;
            case "EUR":
                tasa = 3.93; // 1 EUR = 3.93 PEN
                break;
            case "PEN":
            default:
                tasa = 1.0; // PEN base
                break;
        }

        // monto está en soles (PEN), lo convertimos a la moneda destino
        return monto / tasa;
    }
}
