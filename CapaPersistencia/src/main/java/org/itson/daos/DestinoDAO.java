/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.daos;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.*;
import org.bson.types.ObjectId;
import org.itson.dominio.Destino;
import org.itson.dominio.Productor;
import org.itson.registros.Interface.IConexionBD;

/**
 * 
 * @author Equipo 3 
 * Luis Pablo Ayón Figueroa
 * Mario Díaz Padilla
 * Gabriel Alberto Mancinas Cota
 * Ángel de Jesús Valenzuela García
 */
public class DestinoDAO {
    
    private final String NOMBRE_COLECCION = "productores";
    private final MongoDatabase BASE_DATOS;
    
    public DestinoDAO(IConexionBD CONEXION) {
        this.BASE_DATOS = CONEXION.getBaseDatos();
    }
    
    public Destino consultar(ObjectId id) {
        MongoCollection<Productor> collection = BASE_DATOS.getCollection(NOMBRE_COLECCION, Productor.class);
        Productor productor = collection.find(eq("listaDestinos._id", id)).first();
        return productor == null ? null : productor.getListaDestinos().stream().filter(residuo -> residuo.getId().equals(id)).findFirst().orElse(null);
    }
}
