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
import org.itson.dominio.ConstituyenteQuimico;
import org.itson.dominio.Residuo;

/**
 * 
 * @author Equipo 3 
 * Luis Pablo Ayón Figueroa
 * Mario Díaz Padilla
 * Gabriel Alberto Mancinas Cota
 * Ángel de Jesús Valenzuela García
 */
public class ResiduoDAO extends DAOGeneral<Residuo>{
    private final String NOMBRE_COLECCION = "residuos";
    private final MongoDatabase BASE_DATOS;

    public ResiduoDAO(ConexionBD CONEXION) {
        this.BASE_DATOS = CONEXION.getBaseDatos();
    }
    @Override
    protected MongoCollection<Residuo> getColeccion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Residuo consultar(ObjectId id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Residuo consultar(Residuo parametros) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Residuo> consultarTodos() {
        MongoCollection<Residuo> collection = BASE_DATOS.getCollection(NOMBRE_COLECCION,Residuo.class);
        List<Residuo> residuos = new LinkedList<>();
        collection.find().into(residuos);
        return residuos;
    }
    
    @Override
    public Residuo agregar(Residuo entidad) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public void agregarPredeterminados() {
           MongoCollection<Residuo> collection = BASE_DATOS.getCollection(NOMBRE_COLECCION,Residuo.class);
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
           Residuo residuo = new Residuo("Baterías", "2022-BATCH-ABC-001", consituyentesQuimicosBaterias);
           Residuo residuo2 = new Residuo("Disolventes", "2022-BATCH-ABC-002", consituyentesQuimicosDisolventes);
           Residuo residuo3 = new Residuo("Pinturas", "2022-BATCH-ABC-003", consituyentesQuimicosPinturas);
           Residuo residuo4 = new Residuo("Residuos médicos", "2022-BATCH-ABC-004", consituyentesQuimicosMedicos);
           Residuo residuo5 = new Residuo("Electrónicos", "2022-BATCH-ABC-005", consituyentesQuimicosElectronicos);
           Residuo residuo6 = new Residuo("Residuos radioactivos", "2022-BATCH-ABC-006", consituyentesQuimicosRadioactivos);
           List<Residuo> residuos = new ArrayList<>();
           residuos.add(residuo);
           residuos.add(residuo2);
           residuos.add(residuo3);
           residuos.add(residuo4);
           residuos.add(residuo5);
           residuos.add(residuo6);
           collection.insertMany(residuos);
    }
    @Override
    public Residuo actualizar(Residuo entidad) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
