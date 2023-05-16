/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.daos;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.bson.types.ObjectId;
import org.itson.dominio.Transportista;
import org.itson.registros.Interface.IConexionBD;

/**
 *
 * @author Equipo 3 Luis Pablo Ayón Figueroa Mario Díaz Padilla Gabriel Alberto
 * Mancinas Cota Ángel de Jesús Valenzuela García
 */
public class TransportistaDAO extends DAOGeneral<Transportista> {

    private final String NOMBRE_COLECCION = "transportistas";
    private final MongoDatabase BASE_DATOS;

    public TransportistaDAO(IConexionBD CONEXION) {
        this.BASE_DATOS = CONEXION.getBaseDatos();
    }

    @Override
    public Transportista agregar(Transportista transportista) {
        MongoCollection<Transportista> collection = BASE_DATOS.getCollection(NOMBRE_COLECCION, Transportista.class);
        collection.insertOne(transportista);
        return transportista;
    }

    public void agregarPredeterminados() {
        MongoCollection<Transportista> collection = BASE_DATOS.getCollection(NOMBRE_COLECCION, Transportista.class);
        Transportista transportista = new Transportista("Mario Diaz", "mario.diaz233259@potros.itson.edu.mx");
        Transportista transportista1 = new Transportista("Julio Chon", "julio.chon233242@potros.itson.edu.mx");
        Transportista transportista3 = new Transportista("Angel Valenzuela", "angel.valenzuela233109@potros.itson.edu.mx");
        Transportista transportista4 = new Transportista("Gabriel Mancinas", "gabriel.mancinas233410@potros.itson.edu.mx");
        List<Transportista> transportistas = new ArrayList<>();
        transportistas.add(transportista);
        transportistas.add(transportista1);

        transportistas.add(transportista3);
        transportistas.add(transportista4);

        collection.insertMany(transportistas);
    }

    @Override
    public Transportista actualizar(Transportista entidad) {
        MongoCollection<Transportista> coleccion = BASE_DATOS.getCollection(NOMBRE_COLECCION, Transportista.class);
        coleccion.replaceOne(eq("_id", entidad.getId()), entidad);
        return entidad;
    }

    @Override
    public Transportista consultar(ObjectId id) {
        MongoCollection<Transportista> collection = BASE_DATOS.getCollection(NOMBRE_COLECCION, Transportista.class);
        List<Transportista> transportistas = new LinkedList<>();
        collection.find(eq("_id", id)).into(transportistas);
        return transportistas.isEmpty() ? null : transportistas.get(0);
    }

    @Override
    public List<Transportista> consultarTodos() {
        MongoCollection<Transportista> collection = BASE_DATOS.getCollection(NOMBRE_COLECCION, Transportista.class);
        List<Transportista> transportistas = new LinkedList<>();
        collection.find().into(transportistas);

        return transportistas;
    }

    public List<String> consultarCorreosTransportistas() {
        List<String> correos = new LinkedList<>();
        MongoCollection<Transportista> collection = BASE_DATOS.getCollection(NOMBRE_COLECCION, Transportista.class);
        List<Transportista> transportistas = new LinkedList<>();
        collection.find().into(transportistas);
        for (Transportista transportista : transportistas) {
            correos.add(transportista.getEmail());
        }
        return correos;
    }

}
