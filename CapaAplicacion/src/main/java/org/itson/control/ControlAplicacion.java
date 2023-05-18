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
import org.itson.dominio.Destino;
import org.itson.dominio.OrdenTraslado;
import org.itson.dominio.Productor;
import org.itson.dominio.Residuo;
import org.itson.excepciones.PersistenciaException;
import org.itson.subsistema_admtraslado.FachadaAdmTraslado;
import org.itson.subsistema_admtraslado.IRegistrarTraslado;

/**
 * Control de la aplicación.
 * 
 * @author Equipo 3 
 * Luis Pablo Ayón Figueroa
 * Mario Díaz Padilla
 * Gabriel Alberto Mancinas Cota
 * Ángel de Jesús Valenzuela García
 */
public class ControlAplicacion {

    ObjetoNegocio objetoNegocio;
    Productor productor;

    private IRegistrarTraslado admTraslados;

    /**
     * Constructor por defecto.
     */
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

    /**
     * Método que llama al subsistema de registro de traslados para hacer un
     * registro.
     * @param orden Orden de traslado a ser registrada.
     * @return Regresa true en caso de éxito, false en caso contrario.
     * @throws PersistenciaException Se lanza esta excepción en la capa de
     * persistencia.
     */
    public boolean registrarOrdenTraslado(OrdenTraslado orden) throws PersistenciaException {
        try {
            return admTraslados.registrarTraslado(orden);
        } catch (PersistenciaException ex) {
            throw new PersistenciaException(ex.getMessage());
        }
    }

    /**
     * Método que consulta a un productor a partir de la id enviada como parámetro.
     * @param id Id del productor. 
     * @return Productor si se encontró, null en caso contrario.
     */
    public Productor obtenerProductor(ObjectId id) {
        return objetoNegocio.consultarProductor(id);
    }

    /**
     * Método que regresa una lista de residuos de un productor en específico.
     * @param id Id del productor.
     * @return Lista de residuos del productor.
     */
    public List<Residuo> obtenerListaResiduos(ObjectId id) {
        return objetoNegocio.consultarListaResiduosProductor(id);
    }

    /**
     * Método que consulta la lista de destinos del productor.
     * @param id Id del productor.
     * @return Lista de destinos del productor.
     */
    public List<Destino> obtenerListaDestinos(ObjectId id) {
        return objetoNegocio.consultarListaDestinosProcutor(id);
    }

    /**
     * Método que regresa una lista de los correos de los transportistas.
     * @return Lista de correos electrónicos de los transportistas.
     */
    public List<String> consultarListaCorreosTransportistas() {
        return objetoNegocio.consultarListaCorreosTransportistas();
    }

    /**
     * Método que consulta el productor predeterminado registrado.
     * @return Productor predeterminado.
     */
    public Productor consultarProductorPredeterminado() {
        return objetoNegocio.consultarProductorPredeterminado();
    }

    /**
     * Método que llena una ComboBox con la lista de residuos del productor
     * correspondiente al id recibido en el parámetro.
     * @param id Id del Productor.
     * @param cbx ComboBox a llenar.
     */
    public void llenarComboBoxListaResiduos(ObjectId id, JComboBox cbx) {
        List<Residuo> lista = obtenerListaResiduos(id);
        DefaultComboBoxModel comboBox = new DefaultComboBoxModel<>();
        comboBox.addAll(lista);
        cbx.setModel(comboBox);
        cbx.setSelectedIndex(0);
    }

    /**
     * Método que llena una ComboBox con la lista de destinos del productor
     * correspondiente al id recibido en el parámetro.
     * @param id Id del Productor.
     * @param cbx ComboBox a llenar.
     */
    public void llenarComboBoxListaDestinos(ObjectId id, JComboBox cbx) {
        List<Destino> lista = obtenerListaDestinos(id);
        DefaultComboBoxModel comboBox = new DefaultComboBoxModel<>();
        comboBox.addAll(lista);
        cbx.setModel(comboBox);
        cbx.setSelectedIndex(0);
    }

    /**
     * Método que devuelve una lista de ordenes de traslado.
     *
     * @return lista de ordenes de traslado.
     */
    public List<OrdenTraslado> consultarOrdenesTraslado() {
        return objetoNegocio.consultarTodosOrdenTraslado();
    }

    /**
     * Este método devuelve el productor de la sesión actual.
     * @return El productor de la sesión actual.
     */
    public Productor getProductor() {
        return this.productor;
    }

    /**
     * Método que consulta un residuo a partir de su id.
     * @param idResiduo El id del residuo a consultar.
     * @return El residuo consultado en caso de encontrarlo, null en caso contrario.
     */
    public Residuo consultarResiduo(ObjectId idResiduo) {
        return objetoNegocio.consultarResiduo(idResiduo);
    }

    /**
     * Método que consulta un destino a partir de su id.
     * @param idDestino El id del destino a consultar.
     * @return El destino consultado en caso de encontrarlo, null en caso contrario.
     */
    public Destino consultarDestino(ObjectId idDestino) {
        return objetoNegocio.consultarDestino(idDestino);
    }

}
