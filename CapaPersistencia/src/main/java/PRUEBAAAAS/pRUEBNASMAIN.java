/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PRUEBAAAAS;

import org.itson.daos.ConexionBD;
import org.itson.daos.ProductorDAO;
import org.itson.daos.ResiduoDAO;
import org.itson.dominio.Productor;

/**
 *
 * @author Zaurus
 */
public class pRUEBNASMAIN {
    public static void main(String[] args) {
        ConexionBD conexion = new ConexionBD("residuos");
        ProductorDAO productordao = new ProductorDAO(conexion);
        ResiduoDAO residuo = new ResiduoDAO(conexion);
        productordao.agregarProductorPredeterminado();
        System.out.println(productordao.consultarProductorPredeterminado());
        Productor productor = productordao.consultarProductorPredeterminado();
        System.out.println(productor.getListaDestinos());
        System.out.println(productor.getListaResiduos());
    }
}
