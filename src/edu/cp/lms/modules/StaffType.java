/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cp.lms.modules;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Deepesh
 */
@Entity
@Table(name = "staff_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StaffType.findAll", query = "SELECT s FROM StaffType s")
    , @NamedQuery(name = "StaffType.findById", query = "SELECT s FROM StaffType s WHERE s.id = :id")
    , @NamedQuery(name = "StaffType.findByType", query = "SELECT s FROM StaffType s WHERE s.type = :type")})
public class StaffType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "type")
    private String type;

    public StaffType() {
    }

    public StaffType(Integer id) {
        this.id = id;
    }

    public StaffType(Integer id, String type) {
        this.id = id;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StaffType)) {
            return false;
        }
        StaffType other = (StaffType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.cp.lms.modules.StaffType[ id=" + id + " ]";
    }
    
}
