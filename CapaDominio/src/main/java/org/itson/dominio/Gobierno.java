
package org.itson.dominio;

import java.util.List;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 * Clase de dominio de Gobierno.
 * @author Luis Ayón, Mario Díaz, Gabriel Mancinas, Ángel Valenzuela
 */
public class Gobierno {
    
    private ObjectId id;
    private List<Productor> catalogoProductores;
    private List<Residuo> catalogoResiduos;
    private List<Transportista> catalogoTransportistas;
    
    /**
     * Método constructor por defecto.
     */
    public Gobierno() {
    }
    
    /**
     * Método constructor que inicializa el catálogo de productores, residuos y transportistas.
     * @param catalogoProductores Lista de productores.
     * @param catalogoResiduos Lista de residuos.
     * @param catalogoTransportistas Lista de transportistas.
     */
    public Gobierno(List<Productor> catalogoProductores, List<Residuo> catalogoResiduos, List<Transportista> catalogoTransportistas) {
        this.catalogoProductores = catalogoProductores;
        this.catalogoResiduos = catalogoResiduos;
        this.catalogoTransportistas = catalogoTransportistas;
    }
    
    /**
     * Método constructor que inicializa todos los atributos.
     * @param id ID del gobierno.
     * @param catalogoProductores Lista de productores.
     * @param catalogoResiduos Lista de residuos.
     * @param catalogoTransportistas Lista de transportistas.
     */
    public Gobierno(ObjectId id, List<Productor> catalogoProductores, List<Residuo> catalogoResiduos, List<Transportista> catalogoTransportistas) {
        this.id = id;
        this.catalogoProductores = catalogoProductores;
        this.catalogoResiduos = catalogoResiduos;
        this.catalogoTransportistas = catalogoTransportistas;
    }
    
    /**
     * Método get que regresa el ID del gobierno.
     * @return el ID del gobierno.
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Método set que asigna el ID al gobierno.
     * @param id ID a asginar.
     */
    public void setId(ObjectId id) {
        this.id = id;
    }
    
    /**
     * Método get que regresa el catálogo de productores.
     * @return Catálogo de productores.
     */
    public List<Productor> getCatalogoProductores() {
        return catalogoProductores;
    }

    /**
     * Método set que asgina el catálogo de productores.
     * @param catalogoProductores Cátalogo de productores.
     */
    public void setCatalogoProductores(List<Productor> catalogoProductores) {
        this.catalogoProductores = catalogoProductores;
    }

    /**
     * Método get que regresa el catálogo de residuos.
     * @return Catálogo de residuos.
     */
    public List<Residuo> getCatalogoResiduos() {
        return catalogoResiduos;
    }

    /**
     * Método set que asigna el catálogo de residuos.
     * @param catalogoResiduos Catálogo de residuos.
     */
    public void setCatalogoResiduos(List<Residuo> catalogoResiduos) {
        this.catalogoResiduos = catalogoResiduos;
    }

    /**
     * Método get que regresa el catálogo de transportistas.
     * @return Catálogo de transportistas.
     */
    public List<Transportista> getCatalogoTransportistas() {
        return catalogoTransportistas;
    }
    
    /**
     * Método set que regresa el catálogo de transportistas.
     * @param catalogoTransportistas Catálogo de transportistas.
     */
    public void setCatalogoTransportistas(List<Transportista> catalogoTransportistas) {
        this.catalogoTransportistas = catalogoTransportistas;
    }

    /**
     * Método hashcode.
     * @return hashcode del objeto.
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.id);
        return hash;
    }

    /**
     * Método equals.
     * @param obj Objeto a comparar.
     * @return Verdadero si coincide, falso en caso contrario.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Gobierno other = (Gobierno) obj;
        return Objects.equals(this.id, other.id);
    }
    /**
     * Método toString.
     * @return Cadena con todos los atributos.
     */
    @Override
    public String toString() {
        return "Gobierno{" + "id=" + id + ", catalogoProductores=" + catalogoProductores + ", catalogoResiduos=" + catalogoResiduos + ", catalogoTransportistas=" + catalogoTransportistas + '}';
    }
    
    
}
