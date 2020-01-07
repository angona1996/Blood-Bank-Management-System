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
@Table(name = "donor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Donor.findAll", query = "SELECT d FROM Donor d")
    , @NamedQuery(name = "Donor.findByDonorId", query = "SELECT d FROM Donor d WHERE d.donorId = :donorId")
    , @NamedQuery(name = "Donor.findByDonorName", query = "SELECT d FROM Donor d WHERE d.donorName = :donorName")
    , @NamedQuery(name = "Donor.findByDonorEmail", query = "SELECT d FROM Donor d WHERE d.donorEmail = :donorEmail")
    , @NamedQuery(name = "Donor.findByDonorPassword", query = "SELECT d FROM Donor d WHERE d.donorPassword = :donorPassword")
    , @NamedQuery(name = "Donor.findByDonorContactNo", query = "SELECT d FROM Donor d WHERE d.donorContactNo = :donorContactNo")
    , @NamedQuery(name = "Donor.findByDonorArea", query = "SELECT d FROM Donor d WHERE d.donorArea = :donorArea")
    , @NamedQuery(name = "Donor.findByDonorAvailability", query = "SELECT d FROM Donor d WHERE d.donorAvailability = :donorAvailability")
    , @NamedQuery(name = "Donor.findByDonorBloodGroup", query = "SELECT d FROM Donor d WHERE d.donorBloodGroup = :donorBloodGroup")})
public class Donor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "donor_id")
    private Integer donorId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "donor_name")
    private String donorName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "donor_email")
    private String donorEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "donor_password")
    private String donorPassword;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "donor_contact_no")
    private String donorContactNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "donor_area")
    private String donorArea;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "donor_availability")
    private String donorAvailability;
    @Basic(optional = false)
    @NotNull
    @Column(name = "donor_blood_group")
    private String donorBloodGroup;

    public Donor() {
    }

    public Donor(Integer donorId) {
        this.donorId = donorId;
    }

    public Donor(Integer donorId, String donorName, String donorEmail, String donorPassword, String donorContactNo, String donorArea, String donorAvailability, String donorBloodGroup) {
        this.donorId = donorId;
        this.donorName = donorName;
        this.donorEmail = donorEmail;
        this.donorPassword = donorPassword;
        this.donorContactNo = donorContactNo;
        this.donorArea = donorArea;
        this.donorAvailability = donorAvailability;
        this.donorBloodGroup = donorBloodGroup;
    }

    public Integer getDonorId() {
        return donorId;
    }

    public void setDonorId(Integer donorId) {
        this.donorId = donorId;
    }

    public String getDonorName() {
        return donorName;
    }

    public void setDonorName(String donorName) {
        this.donorName = donorName;
    }

    public String getDonorEmail() {
        return donorEmail;
    }

    public void setDonorEmail(String donorEmail) {
        this.donorEmail = donorEmail;
    }

    public String getDonorPassword() {
        return donorPassword;
    }

    public void setDonorPassword(String donorPassword) {
        this.donorPassword = donorPassword;
    }

    public String getDonorContactNo() {
        return donorContactNo;
    }

    public void setDonorContactNo(String donorContactNo) {
        this.donorContactNo = donorContactNo;
    }

    public String getDonorArea() {
        return donorArea;
    }

    public void setDonorArea(String donorArea) {
        this.donorArea = donorArea;
    }

    public String getDonorAvailability() {
        return donorAvailability;
    }

    public void setDonorAvailability(String donorAvailability) {
        this.donorAvailability = donorAvailability;
    }

    public String getDonorBloodGroup() {
        return donorBloodGroup;
    }

    public void setDonorBloodGroup(String donorBloodGroup) {
        this.donorBloodGroup = donorBloodGroup;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (donorId != null ? donorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Donor)) {
            return false;
        }
        Donor other = (Donor) object;
        if ((this.donorId == null && other.donorId != null) || (this.donorId != null && !this.donorId.equals(other.donorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Donor[ donorId=" + donorId + " ]";
    }
    
}
