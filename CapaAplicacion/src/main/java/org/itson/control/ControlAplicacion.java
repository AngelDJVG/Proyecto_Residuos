/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.control;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import org.bson.types.ObjectId;
import org.itson.capanegocio.ObjetoNegocio;
import org.itson.daos.FachadaPersistencia;
import org.itson.dominio.Destino;
import org.itson.dominio.OrdenTraslado;
import org.itson.dominio.Productor;
import org.itson.dominio.Residuo;
import org.itson.excepciones.PersistenciaException;
import org.itson.registros.Interface.IPersistencia;
import org.itson.subsistema_admtraslado.FachadaAdmTraslado;
import org.itson.subsistema_admtraslado.IRegistrarTraslado;

/**
 *
 * @author Gabriel Mancinas
 */
public class ControlAplicacion {

    ObjetoNegocio objetoNegocio;
    Productor productor;

    private IRegistrarTraslado admTraslados;

    public ControlAplicacion() {
        objetoNegocio = new ObjetoNegocio();
        admTraslados = new FachadaAdmTraslado("marioproxd14@gmail.com", "gywpjzckozhqtbrd");
        if (consultarProductorPredeterminado() != null) {
            productor = consultarProductorPredeterminado();
        } else {
            productor = objetoNegocio.agregarProductorPredeterminado();
            objetoNegocio.agregarTransportistasPredeterminados();
        }

    }

    public boolean registrarOrdenTraslado(OrdenTraslado orden) throws PersistenciaException {
        try {
            return admTraslados.registrarTraslado(orden);
        } catch (PersistenciaException ex) {
            throw new PersistenciaException(ex.getMessage());
        }
    }

    public Productor obtenerProductor(ObjectId id) {
        return objetoNegocio.consultarProductor(id);
    }

    public List<Residuo> obtenerListaResiduos(ObjectId id) {
        return objetoNegocio.consultarListaResiduosProductor(id);
    }

    public List<Destino> obtenerListaDestinos(ObjectId id) {
        return objetoNegocio.consultarListaDestinosProcutor(id);
    }

    public List<String> consultarListaCorreosTransportistas() {
        return objetoNegocio.consultarListaCorreosTransportistas();
    }

    public Productor consultarProductorPredeterminado() {
        return objetoNegocio.consultarProductorPredeterminado();
    }

    public void llenarComboBoxListaResiduos(ObjectId id, JComboBox cbx) {
        List<Residuo> lista = obtenerListaResiduos(id);
        DefaultComboBoxModel comboBox = new DefaultComboBoxModel<>();
        comboBox.addAll(lista);
        cbx.setModel(comboBox);
        cbx.setSelectedIndex(0);
    }

    public void llenarComboBoxListaDestinos(ObjectId id, JComboBox cbx) {
        List<Destino> lista = obtenerListaDestinos(id);
        DefaultComboBoxModel comboBox = new DefaultComboBoxModel<>();
        comboBox.addAll(lista);
        cbx.setModel(comboBox);
        cbx.setSelectedIndex(0);
    }

    public List<OrdenTraslado> consultarOrdenesTraslado() {
        return objetoNegocio.consultarTodosOrdenTraslado();
    }

    public Productor getProductor() {
        return this.productor;
    }

    public Residuo consultarResiduo(ObjectId idResiduo) {
        return objetoNegocio.consultarResiduo(idResiduo);
    }

    public Destino consultarDestino(ObjectId idDestino) {
        return objetoNegocio.consultarDestino(idDestino);
    }

}
