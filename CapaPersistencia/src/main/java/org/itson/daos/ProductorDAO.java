/**
 * Clase ProductorDAO.java creado el 13/05/2023.
 */
package org.itson.daos;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.result.DeleteResult;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.bson.types.ObjectId;
import org.itson.dominio.ConstituyenteQuimico;
import org.itson.dominio.Destino;
import org.itson.dominio.Productor;
import org.itson.dominio.Residuo;
import org.itson.enums.ResiduoUnidadMedida;
import org.itson.registros.Interface.IConexionBD;

/**
 * 
 * @author Equipo 3 
 * Luis Pablo Ayón Figueroa
 * Mario Díaz Padilla
 * Gabriel Alberto Mancinas Cota
 * Ángel de Jesús Valenzuela García
 */
public class ProductorDAO extends DAOGeneral<Productor>{
    private final String NOMBRE_COLECCION = "productores";
    private final MongoDatabase BASE_DATOS;
    /**
     * Método constructor por defecto que inicializa el atributo al valor del parámetro enviado
     * @param CONEXION Conexión con la base de datos.
     */
    public ProductorDAO(IConexionBD CONEXION) {
        this.BASE_DATOS = CONEXION.getBaseDatos();
    }
    /**
     * Método que consulta a un productor a partir de la id enviada como parámetro.
     * @param idProductor Id del productor. 
     * @return Productor si se encontró, null en caso contrario.
     */
    @Override
    public Productor consultar(ObjectId idProductor) {
        MongoCollection<Productor> collection = BASE_DATOS.getCollection(NOMBRE_COLECCION, Productor.class);
        List<Productor> transportistas = new LinkedList<>();
        collection.find(eq("_id", idProductor)).into(transportistas);
        return transportistas.isEmpty() ? null : transportistas.get(0);
    }
    /**
     * Método que consulta todos los productores de la base de datos.
     * @return Lista de productores.
     */
    @Override
    public List<Productor> consultarTodos() {
        MongoCollection<Productor> collection = BASE_DATOS.getCollection(NOMBRE_COLECCION, Productor.class);
        List<Productor> productores = new LinkedList<>();
        collection.find().into(productores);
        return productores;
    }
    /**
     * Método que agrega un productor a la base de datos.
     * @return Productor registrado.
     */
    public Productor agregarProductorPredeterminado() {
           MongoCollection<Productor> collection = BASE_DATOS.getCollection(NOMBRE_COLECCION,Productor.class);
           ConstituyenteQuimico plomo = new ConstituyenteQuimico("Plomo");
           ConstituyenteQuimico litio = new ConstituyenteQuimico("Litio");
           ConstituyenteQuimico mercurio = new ConstituyenteQuimico("Mercurio");
           ConstituyenteQuimico tolueno = new ConstituyenteQuimico("Tolueno");
           ConstituyenteQuimico uranio = new ConstituyenteQuimico("Uranio");
           ConstituyenteQuimico plutonio = new ConstituyenteQuimico("Plutonio");
           ConstituyenteQuimico cadmio = new ConstituyenteQuimico("Cadmio");
           List<ConstituyenteQuimico> consituyentesQuimicosBaterias = new ArrayList<>();
           consituyentesQuimicosBaterias.add(litio);
           consituyentesQuimicosBaterias.add(cadmio);
           consituyentesQuimicosBaterias.add(plomo);
           consituyentesQuimicosBaterias.add(mercurio);
           List<ConstituyenteQuimico> consituyentesQuimicosDisolventes = new ArrayList<>();
           consituyentesQuimicosDisolventes.add(tolueno);
           List<ConstituyenteQuimico> consituyentesQuimicosPinturas = new ArrayList<>();
           consituyentesQuimicosPinturas.add(cadmio);
           consituyentesQuimicosPinturas.add(plomo);
           consituyentesQuimicosPinturas.add(mercurio);
           List<ConstituyenteQuimico> consituyentesQuimicosMedicos = new ArrayList<>();
           consituyentesQuimicosMedicos.add(litio);
           consituyentesQuimicosMedicos.add(plomo);
           consituyentesQuimicosMedicos.add(mercurio);
           List<ConstituyenteQuimico> consituyentesQuimicosElectronicos = new ArrayList<>();
           consituyentesQuimicosElectronicos.add(litio);
           consituyentesQuimicosElectronicos.add(plomo);
           consituyentesQuimicosElectronicos.add(mercurio);
           consituyentesQuimicosElectronicos.add(cadmio);
           List<ConstituyenteQuimico> consituyentesQuimicosRadioactivos = new ArrayList<>();
           consituyentesQuimicosRadioactivos.add(uranio);
           consituyentesQuimicosRadioactivos.add(plutonio);
           Residuo residuo = new Residuo("Baterías", "2022-BATCH-ABC-001", consituyentesQuimicosBaterias, ResiduoUnidadMedida.KG);
           Residuo residuo2 = new Residuo("Disolventes", "2022-BATCH-ABC-002", consituyentesQuimicosDisolventes, ResiduoUnidadMedida.LT);
           Residuo residuo3 = new Residuo("Pinturas", "2022-BATCH-ABC-003", consituyentesQuimicosPinturas, ResiduoUnidadMedida.LT);
           Residuo residuo4 = new Residuo("Residuos médicos", "2022-BATCH-ABC-004", consituyentesQuimicosMedicos, ResiduoUnidadMedida.KG);
           Residuo residuo5 = new Residuo("Electrónicos", "2022-BATCH-ABC-005", consituyentesQuimicosElectronicos, ResiduoUnidadMedida.KG);
           Residuo residuo6 = new Residuo("Residuos radioactivos", "2022-BATCH-ABC-006", consituyentesQuimicosRadioactivos, ResiduoUnidadMedida.LT);
           List<Residuo> residuos = new ArrayList<>();
           residuos.add(residuo);
           residuos.add(residuo2);
           residuos.add(residuo3);
           residuos.add(residuo4);
           residuos.add(residuo5);
           residuos.add(residuo6);
           List<Destino> listaDestinos = new ArrayList<>();
           Destino destino1 = new Destino("Bodega norte", "Mexico", "Sonora", "Tamazula", "Callejones", "Tamazula", "325", 125);
           Destino destino2 = new Destino("Basuron", "Mexico", "Sonora", "Obregon", "Casa blanca", "Pacifico", "A2523", 12);
           Destino destino3 = new Destino("Desechos Allende", "Mexico", "Sonora", "Navojoa", "Jacarandas", "Jacarandas", "231", 50);
           Destino destino4 = new Destino("Recolector Publico", "Mexico", "Sonora", "Obregon", "Nainari", "Nainari", "A32", 40);
           listaDestinos.add(destino1);
           listaDestinos.add(destino2);
           listaDestinos.add(destino3);
           listaDestinos.add(destino4);
           Productor productor = new Productor("Productor de residuos S.A. de C.V.", residuos,listaDestinos);
           collection.insertOne(productor);
           return productor;
    }
    /**
     * Método que consulta el productor predeterminado registrado.
     * @return Productor predeterminado.
     */
    public Productor consultarProductorPredeterminado(){
        String nombreBuscado = "Productor de residuos S.A. de C.V.";
        MongoCollection<Productor> collection = BASE_DATOS.getCollection(NOMBRE_COLECCION, Productor.class);

        BasicDBObject query = new BasicDBObject();
        query.put("nombre", nombreBuscado);

        List<Productor> productores = collection.find(query).into(new ArrayList<>());
        if (productores.size() > 0) {
            return productores.get(0);
        } else {
            return null;
        }
    }
    /**
     * Método que agrega un productor a la base de datos.
     * @param productor Productor a agregar.
     * @return Productor agregado.
     */
    @Override
    public Productor agregar(Productor productor) {
        MongoCollection<Productor> collection = BASE_DATOS.getCollection(NOMBRE_COLECCION, Productor.class);
        collection.insertOne(productor);
        return productor;
    }
    /**
     * Método que actualiza un productor.
     * @param productor Productor a actualizar.
     * @return Productor actualizado.
     */
    @Override
    public Productor actualizar(Productor productor) {
        MongoCollection<Productor> coleccion = BASE_DATOS.getCollection(NOMBRE_COLECCION, Productor.class);
        coleccion.replaceOne(eq("_id", productor.getId()), productor);
        return productor;
    }
    /**
     * Método que elimina un productor.
     * @param idProductor Id del productor.
     * @return Valor booleano, true si se eliminó, false en caso contrario.
     */
     public Boolean eliminarProductor(ObjectId idProductor){
         MongoCollection<Productor> coleccion = BASE_DATOS.getCollection(NOMBRE_COLECCION, Productor.class);
        DeleteResult resultado = coleccion.deleteOne(eq("_id", idProductor));
        return resultado.getDeletedCount() > 0;
     }
    /**
     * Método que regresa una lista de residuos de un productor en específico.
     * @param idProductor Id del productor.
     * @return Lista de residuos del productor.
     */
    public List<Residuo> consultarListaResiduosProductor(ObjectId idProductor){
        Productor productorConsultado = this.consultar(idProductor);
        if(productorConsultado==null){
            return null;
        }else{
            return productorConsultado.getListaResiduos();
        }
    }
    /**
     * Método que consulta la lista de destinos del productor.
     * @param idProductor Id del productor.
     * @return Lista de destinos del productor.
     */
    public List<Destino> consultarListaDestinosProductor(ObjectId idProductor){
        Productor productorConsultado = this.consultar(idProductor);
        if(productorConsultado==null){
            return null;
        }else{
            return productorConsultado.getListaDestinos();
        }
    }
    
}
