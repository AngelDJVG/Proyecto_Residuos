/**
 * Clase TransportistaDAO.java creado el 13/05/2023.
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
 * DAO de Transportistas.
 * @author Equipo 3 Luis Pablo Ayón Figueroa Mario Díaz Padilla Gabriel Alberto
 * Mancinas Cota Ángel de Jesús Valenzuela García
 */
public class TransportistaDAO extends DAOGeneral<Transportista> {

    private final String NOMBRE_COLECCION = "transportistas";
    private final MongoDatabase BASE_DATOS;
    /**
     * Método constructor por defecto que inicializa el atributo al valor del parámetro enviado
     * @param CONEXION Conexión con la base de datos.
     */
    public TransportistaDAO(IConexionBD CONEXION) {
        this.BASE_DATOS = CONEXION.getBaseDatos();
    }
    /**
     * Método que agrega a un transportista a la base de datos.
     * @param transportista Transportista a agregar.
     * @return Transportista agregado.
     */
    @Override
    public Transportista agregar(Transportista transportista) {
        MongoCollection<Transportista> collection = BASE_DATOS.getCollection(NOMBRE_COLECCION, Transportista.class);
        collection.insertOne(transportista);
        return transportista;
    }
    /**
     * Método para agregar transportistas determinados.
     */
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
    /**
     * Método para actualizar un transportista.
     * @param transportista Transportista a actualizar.
     * @return Transportista actualizado.
     */
    @Override
    public Transportista actualizar(Transportista transportista) {
        MongoCollection<Transportista> coleccion = BASE_DATOS.getCollection(NOMBRE_COLECCION, Transportista.class);
        coleccion.replaceOne(eq("_id", transportista.getId()), transportista);
        return transportista;
    }
    /**
     * Método para consultar un transportista a partir de su Id.
     * @param idTransportista Id del transportista.
     * @return Transportista encontrado, null en caso contrario.
     */
    @Override
    public Transportista consultar(ObjectId idTransportista) {
        MongoCollection<Transportista> collection = BASE_DATOS.getCollection(NOMBRE_COLECCION, Transportista.class);
        List<Transportista> transportistas = new LinkedList<>();
        collection.find(eq("_id", idTransportista)).into(transportistas);
        return transportistas.isEmpty() ? null : transportistas.get(0);
    }
    /**
     * Método que consulta la lista de transportistas de la base de datos.
     * @return Lista de transportistas.
     */
    @Override
    public List<Transportista> consultarTodos() {
        MongoCollection<Transportista> collection = BASE_DATOS.getCollection(NOMBRE_COLECCION, Transportista.class);
        List<Transportista> transportistas = new LinkedList<>();
        collection.find().into(transportistas);

        return transportistas;
    }
    /**
     * Método que regresa una lista de los correos de los transportistas.
     * @return Lista de correos electrónicos de los transportistas.
     */
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
