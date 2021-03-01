/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.itq.lenguajeprogramacion2.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Marcos
 */
@Entity
@Table(name = "habitacion")
@NamedQueries({
    @NamedQuery(name = "Habitacion.findAll", query = "SELECT h FROM Habitacion h")})
public class Habitacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_habitacion")
    private Integer idHabitacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private boolean estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "capacidad")
    private short capacidad;
    @OneToMany(mappedBy = "idHabitacion", fetch = FetchType.LAZY)
    private List<FechasDisponibles> fechasDisponiblesList;
    @JoinColumn(name = "id_tipo_habitacion", referencedColumnName = "id_tipo_habitacion")
    @ManyToOne(fetch = FetchType.LAZY)
    private TipoHabitacion idTipoHabitacion;
    @OneToMany(mappedBy = "idHabitacion", fetch = FetchType.LAZY)
    private List<Reservacion> reservacionList;
    @OneToMany(mappedBy = "idHabitacion", fetch = FetchType.LAZY)
    private List<CarcacteristicaHabitacion> carcacteristicaHabitacionList;

    public Habitacion() {
    }

    public Habitacion(Integer idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public Habitacion(Integer idHabitacion, String nombre, boolean estado, short capacidad) {
        this.idHabitacion = idHabitacion;
        this.nombre = nombre;
        this.estado = estado;
        this.capacidad = capacidad;
    }

    public Integer getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(Integer idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public short getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(short capacidad) {
        this.capacidad = capacidad;
    }

    public List<FechasDisponibles> getFechasDisponiblesList() {
        return fechasDisponiblesList;
    }

    public void setFechasDisponiblesList(List<FechasDisponibles> fechasDisponiblesList) {
        this.fechasDisponiblesList = fechasDisponiblesList;
    }

    public TipoHabitacion getIdTipoHabitacion() {
        return idTipoHabitacion;
    }

    public void setIdTipoHabitacion(TipoHabitacion idTipoHabitacion) {
        this.idTipoHabitacion = idTipoHabitacion;
    }

    public List<Reservacion> getReservacionList() {
        return reservacionList;
    }

    public void setReservacionList(List<Reservacion> reservacionList) {
        this.reservacionList = reservacionList;
    }

    public List<CarcacteristicaHabitacion> getCarcacteristicaHabitacionList() {
        return carcacteristicaHabitacionList;
    }

    public void setCarcacteristicaHabitacionList(List<CarcacteristicaHabitacion> carcacteristicaHabitacionList) {
        this.carcacteristicaHabitacionList = carcacteristicaHabitacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHabitacion != null ? idHabitacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Habitacion)) {
            return false;
        }
        Habitacion other = (Habitacion) object;
        if ((this.idHabitacion == null && other.idHabitacion != null) || (this.idHabitacion != null && !this.idHabitacion.equals(other.idHabitacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.itq.lenguajeprogramacion2.modelo.Habitacion[ idHabitacion=" + idHabitacion + " ]";
    }
    
}
