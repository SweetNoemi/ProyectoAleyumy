import Axios from "axios"
import { useState } from "react"

export default function App1(){
    const [nfac, setNfac]=useState("");
    const [factura, setFactura] = useState([])
    const [existeFactura, setExisteFactura] = useState(false); //Para validar si existe o no.

    const buscarFactura = (nfac) =>{
        Axios.get(`http://localhost:8009/facturas/${nfac}`).then((res)=>{
            setFactura(res.data);
            setExisteFactura(true); //Osea que sí existe.
        })
    }

    const totalCompra = () =>{
        let suma=0;
        for (let i = 0; i < factura.length; i++) {
            suma+=factura[i].subtotal;
        }
        return suma;
    }

    return(
        <div className="container p-4">
            <div className="row">
                <div className="col-12 col-md-3 col-xl-3">
                    <div className="form-group">
                        <label className="form-label fw-bold">Ingresa el número de factura:</label>
                        <input className="form-control" value={nfac} onChange={(e)=>setNfac(e.target.value)} required></input>
                    </div>
                    <button className="btn btn-danger mt-2" onClick={()=>buscarFactura(nfac)}>Consultar</button>
                </div>
            </div>
            <div className="row mt-5">
                <div className="col-12 col-md-12 col-xl-12">
                    {factura.length > 0 ? (
                        <>
                        <div class="card border-danger shadow">
                            <div class="card-body">
                                <div>
                                    <h3 className="text-danger text-center fw-bold">Factura</h3>
                                    <hr></hr>
                                    <p><strong>Cliente: </strong><span>{factura[0].nombre}</span></p>
                                    <p><strong>Fecha: </strong><span>{factura[0].fecha}</span></p>
                                </div>
                                <table class="table text-center">
                                    <thead className="table-danger">
                                        <tr>
                                            <th>Producto</th>
                                            <th>Precio</th>
                                            <th>Cantidad</th>
                                            <th>Subtotal</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        {factura.map((f, index)=>(
                                            <tr key={index}>
                                                <td>{f.nomProducto}</td>
                                                <td>S/. {f.precioUnitario}</td>
                                                <td>{f.cantidad}</td>
                                                <td>S/. {f.subtotal}</td>
                                            </tr>
                                        ))}
                                    </tbody>
                                </table>
                                <hr></hr>
                                <h5><strong className="text-danger">Total del compra: </strong><span>S/. {totalCompra()}</span></h5>
                            </div>
                        </div>
                        </>
                    ):(
                        existeFactura && (
                            <p className="text-danger mt-2 fw-bold">No existe la factura 😢</p>
                        )
                    )}
                </div>
            </div>
        </div>
    )
}
