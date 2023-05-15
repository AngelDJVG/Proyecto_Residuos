/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.daos;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.bson.types.ObjectId;
import org.itson.dominio.Transportista;

/**
 * 
 * @author Equipo 3 
 * Luis Pablo Ayón Figueroa
 * Mario Díaz Padilla
 * Gabriel Alberto Mancinas Cota
 * Ángel de Jesús Valenzuela García
 */
public class TransportistaDAO extends DAOGeneral<Transportista>{
    private final String NOMBRE_COLECCION = "transportistas";
    private final MongoDatabase BASE_DATOS;

    public TransportistaDAO(ConexionBD CONEXION) {
        this.BASE_DATOS = CONEXION.getBaseDatos();
    }
    @Override
    protected MongoCollection<Transportista> getColeccion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Transportista agregar(Transportista transportista) {
           MongoCollection<Transportista> collection = BASE_DATOS.getCollection(NOMBRE_COLECCION,Transportista.class);
           collection.insertOne(transportista);
           return transportista;
    }
    
    public void agregarPredeterminados() {
           MongoCollection<Transportista> collection = BASE_DATOS.getCollection(NOMBRE_COLECCION,Transportista.class);
           Transportista transportista = new Transportista("Mario Diaz", "mario.diaz233259@potros.itson.edu.mx");
           Transportista transportista1 = new Transportista("Julio Chon", "julio.chon233242@potros.itson.edu.mx");
           Transportista transportista2 = new Transportista("Adrian Macias", "adrian.macias@itson.edu.mx");
           Transportista transportista3 = new Transportista("Angel Valenzuela", "angel.valenzuela233109@potros.itson.edu.mx");
           Transportista transportista4 = new Transportista("Gabriel Mancinas", "gabriel.mancinas233410@potros.itson.edu.mx");
           List<Transportista> transportistas = new ArrayList<>();
           transportistas.add(transportista);
           transportistas.add(transportista1);
           transportistas.add(transportista2);
           transportistas.add(transportista3);
           transportistas.add(transportista4);
           collection.insertMany(transportistas);
    }

    @Override
    public Transportista actualizar(Transportista entidad) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Transportista consultar(ObjectId id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Transportista consultar(Transportista parametros) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Transportista> consultarTodos() {
        MongoCollection<Transportista> collection = BASE_DATOS.getCollection(NOMBRE_COLECCION,Transportista.class);
        List<Transportista> restaurantes = new LinkedList<>();
        collection.find().into(restaurantes);
        
        return restaurantes;
    }

}
