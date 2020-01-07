/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Acer
 */
@Entity
@Table(name = "shoutbox")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Shoutbox.findAll", query = "SELECT s FROM Shoutbox s")
    , @NamedQuery(name = "Shoutbox.findByShoutId", query = "SELECT s FROM Shoutbox s WHERE s.shoutId = :shoutId")
    , @NamedQuery(name = "Shoutbox.findByBloodGroup", query = "SELECT s FROM Shoutbox s WHERE s.bloodGroup = :bloodGroup")
    , @NamedQuery(name = "Shoutbox.findByContactNo", query = "SELECT s FROM Shoutbox s WHERE s.contactNo = :contactNo")
    , @NamedQuery(name = "Shoutbox.findByAddress", query = "SELECT s FROM Shoutbox s WHERE s.address = :address")
    , @NamedQuery(name = "Shoutbox.findByMessage", query = "SELECT s FROM Shoutbox s WHERE s.message = :message")})
public class Shoutbox implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "shout_id")
    private Integer shoutId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "blood_group")
    private String bloodGroup;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "contact_no")
    private String contactNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "message")
    private String message;

    public Shoutbox() {
    }

    public Shoutbox(Integer shoutId) {
        this.shoutId = shoutId;
    }

    public Shoutbox(Integer shoutId, String bloodGroup, String contactNo, String address, String message) {
        this.shoutId = shoutId;
        this.bloodGroup = bloodGroup;
        this.contactNo = contactNo;
        this.address = address;
        this.message = message;
    }

    public Integer getShoutId() {
        return shoutId;
    }

    public void setShoutId(Integer shoutId) {
        this.shoutId = shoutId;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (shoutId != null ? shoutId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Shoutbox)) {
            return false;
        }
        Shoutbox other = (Shoutbox) object;
        if ((this.shoutId == null && other.shoutId != null) || (this.shoutId != null && !this.shoutId.equals(other.shoutId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Shoutbox[ shoutId=" + shoutId + " ]";
    }
    
}
