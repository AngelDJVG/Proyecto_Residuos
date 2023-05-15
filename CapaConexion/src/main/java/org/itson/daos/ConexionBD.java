/**
 * Clase ConexionBD.java creado el 13/05/2023.
 */
package org.itson.daos;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.itson.registros.Interface.IConexionBD;

/**
 * 
 * @author Equipo 3 
 * Luis Pablo Ayón Figueroa
 * Mario Díaz Padilla
 * Gabriel Alberto Mancinas Cota
 * Ángel de Jesús Valenzuela García
 */
public class ConexionBD implements IConexionBD{
    private final String BASE_DATOS;
    
    public ConexionBD(String nombrebd){
        this.BASE_DATOS=nombrebd;
    }

    @Override
    public MongoDatabase getBaseDatos() { 
       CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));

        MongoClientSettings settings = MongoClientSettings.builder()
                .codecRegistry(pojoCodecRegistry)
                .build();
        MongoClient mongoClient = MongoClients.create(settings);

        MongoDatabase baseDeDatos = mongoClient.getDatabase(BASE_DATOS);
        //MongoCollection<Restaurante> collection = baseDeDatos.getCollection("restaurantes", Restaurante.class);
        return baseDeDatos;
    }
}
