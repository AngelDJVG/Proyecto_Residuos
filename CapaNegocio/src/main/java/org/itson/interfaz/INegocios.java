/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaz;

import java.util.List;
import org.bson.types.ObjectId;
import org.itson.dominio.Destino;
import org.itson.dominio.Productor;
import org.itson.dominio.Residuo;

/**
 *
 * @author Gabriel Mancinas
 */
public interface INegocios {
    public Productor consultarProductor(ObjectId id);
    public List<Destino> consultarListaDestinosProcutor(ObjectId idProductor);
    public List<Residuo> consultarListaResiduosProductor(ObjectId idProductor);
     public Productor consultarProductorPredeterminado();
     public Productor agregarProductorPredeterminado();
    
     public List<String> consultarListaCorreosTransportistas();
     
}
