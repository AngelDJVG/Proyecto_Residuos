/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.capanegocio;

import java.util.List;
import org.bson.types.ObjectId;
import org.itson.dominio.Destino;
import org.itson.dominio.Productor;
import org.itson.dominio.Residuo;
import org.itson.interfaz.INegocios;

/**
 *
 * @author Gabriel Mancinas
 */
public class ObjetoNegocio implements INegocios{
    ControlProductor controlProductor;
    ControlTransportista controlTransportista;
    
    public ObjetoNegocio(){
        controlProductor = new ControlProductor();
        controlTransportista = new ControlTransportista();
        
    }
    @Override
    public Productor consultarProductor(ObjectId id) {
        return controlProductor.consultarProductor(id);
    }
    @Override
    public List<Destino> consultarListaDestinosProcutor(ObjectId idProductor) {
       return controlProductor.consultarListaDestinosProcutor(idProductor);
    }

    @Override
    public List<Residuo> consultarListaResiduosProductor(ObjectId idProductor) {
        return controlProductor.consultarListaResiduosProductor(idProductor);
    }

    @Override
    public List<String> consultarListaCorreosTransportistas() {
        return controlTransportista.consultarListaCorreosTransportistas();
    }

    @Override
    public Productor consultarProductorPredeterminado() {
        return controlProductor.consultarProductorPredeterminado();
    }

    @Override
    public Productor agregarProductorPredeterminado() {
        return controlProductor.agregarProductorPredeterminado();
    }
   
    
    
}
