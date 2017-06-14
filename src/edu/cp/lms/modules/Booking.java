/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cp.lms.modules;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Deepesh
 */
@Entity
@Table(name = "booking")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Booking.findAll", query = "SELECT b FROM Booking b")
    , @NamedQuery(name = "Booking.findById", query = "SELECT b FROM Booking b WHERE b.id = :id")
    , @NamedQuery(name = "Booking.findByBorroweddate", query = "SELECT b FROM Booking b WHERE b.borroweddate = :borroweddate")
    , @NamedQuery(name = "Booking.findByReturndate", query = "SELECT b FROM Booking b WHERE b.returndate = :returndate")
    , @NamedQuery(name = "Booking.findByActualreturneddate", query = "SELECT b FROM Booking b WHERE b.actualreturneddate = :actualreturneddate")
    , @NamedQuery(name = "Booking.findByNoofcopies", query = "SELECT b FROM Booking b WHERE b.noofcopies = :noofcopies")
    , @NamedQuery(name = "Booking.findByStatus", query = "SELECT b FROM Booking b WHERE b.status = :status")
    , @NamedQuery(name = "Booking.findByPrice", query = "SELECT b FROM Booking b WHERE b.price = :price")})
public class Booking implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "borroweddate")
    @Temporal(TemporalType.DATE)
    private Date borroweddate;
    @Basic(optional = false)
    @Column(name = "returndate")
    @Temporal(TemporalType.DATE)
    private Date returndate;
    @Column(name = "actualreturneddate")
    @Temporal(TemporalType.DATE)
    private Date actualreturneddate;
    @Basic(optional = false)
    @Column(name = "noofcopies")
    private int noofcopies;
    @Column(name = "status")
    private String status;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price")
    private Float price;
    @JoinColumn(name = "bookid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Book bookid;
    @JoinColumn(name = "userid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User userid;

    public Booking() {
    }

    public Booking(Integer id) {
        this.id = id;
    }

    public Booking(Integer id, Date borroweddate, Date returndate, int noofcopies) {
        this.id = id;
        this.borroweddate = borroweddate;
        this.returndate = returndate;
        this.noofcopies = noofcopies;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getBorroweddate() {
        return borroweddate;
    }

    public void setBorroweddate(Date borroweddate) {
        this.borroweddate = borroweddate;
    }

    public Date getReturndate() {
        return returndate;
    }

    public void setReturndate(Date returndate) {
        this.returndate = returndate;
    }

    public Date getActualreturneddate() {
        return actualreturneddate;
    }

    public void setActualreturneddate(Date actualreturneddate) {
        this.actualreturneddate = actualreturneddate;
    }

    public int getNoofcopies() {
        return noofcopies;
    }

    public void setNoofcopies(int noofcopies) {
        this.noofcopies = noofcopies;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Book getBookid() {
        return bookid;
    }

    public void setBookid(Book bookid) {
        this.bookid = bookid;
    }

    public User getUserid() {
        return userid;
    }

    public void setUserid(User userid) {
        this.userid = userid;
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
        if (!(object instanceof Booking)) {
            return false;
        }
        Booking other = (Booking) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.cp.lms.modules.Booking[ id=" + id + " ]";
    }
    
}
