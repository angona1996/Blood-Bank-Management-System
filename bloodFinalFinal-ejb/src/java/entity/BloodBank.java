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
@Table(name = "blood_bank")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BloodBank.findAll", query = "SELECT b FROM BloodBank b")
    , @NamedQuery(name = "BloodBank.findByBankId", query = "SELECT b FROM BloodBank b WHERE b.bankId = :bankId")
    , @NamedQuery(name = "BloodBank.findByBankName", query = "SELECT b FROM BloodBank b WHERE b.bankName = :bankName")
    , @NamedQuery(name = "BloodBank.findByBankAddress", query = "SELECT b FROM BloodBank b WHERE b.bankAddress = :bankAddress")
    , @NamedQuery(name = "BloodBank.findByBankContactNo", query = "SELECT b FROM BloodBank b WHERE b.bankContactNo = :bankContactNo")
    , @NamedQuery(name = "BloodBank.findByBankEmail", query = "SELECT b FROM BloodBank b WHERE b.bankEmail = :bankEmail")
    , @NamedQuery(name = "BloodBank.findByPassword", query = "SELECT b FROM BloodBank b WHERE b.password = :password")
    , @NamedQuery(name = "BloodBank.findByAve", query = "SELECT b FROM BloodBank b WHERE b.ave = :ave")
    , @NamedQuery(name = "BloodBank.findByAvel", query = "SELECT b FROM BloodBank b WHERE b.avel = :avel")
    , @NamedQuery(name = "BloodBank.findByBve", query = "SELECT b FROM BloodBank b WHERE b.bve = :bve")
    , @NamedQuery(name = "BloodBank.findByBvel", query = "SELECT b FROM BloodBank b WHERE b.bvel = :bvel")
    , @NamedQuery(name = "BloodBank.findByABve", query = "SELECT b FROM BloodBank b WHERE b.aBve = :aBve")
    , @NamedQuery(name = "BloodBank.findByABvel", query = "SELECT b FROM BloodBank b WHERE b.aBvel = :aBvel")
    , @NamedQuery(name = "BloodBank.findByOve", query = "SELECT b FROM BloodBank b WHERE b.ove = :ove")
    , @NamedQuery(name = "BloodBank.findByOvel", query = "SELECT b FROM BloodBank b WHERE b.ovel = :ovel")})
public class BloodBank implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bank_id")
    private Integer bankId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "bank_name")
    private String bankName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "bank_address")
    private String bankAddress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "bank_contact_no")
    private String bankContactNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "bank_email")
    private String bankEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Ave")
    private int ave;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Avel")
    private int avel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Bve")
    private int bve;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Bvel")
    private int bvel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ABve")
    private int aBve;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ABvel")
    private int aBvel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Ove")
    private int ove;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Ovel")
    private int ovel;

    public BloodBank() {
    }

    public BloodBank(Integer bankId) {
        this.bankId = bankId;
    }

    public BloodBank(Integer bankId, String bankName, String bankAddress, String bankContactNo, String bankEmail, String password, int ave, int avel, int bve, int bvel, int aBve, int aBvel, int ove, int ovel) {
        this.bankId = bankId;
        this.bankName = bankName;
        this.bankAddress = bankAddress;
        this.bankContactNo = bankContactNo;
        this.bankEmail = bankEmail;
        this.password = password;
        this.ave = ave;
        this.avel = avel;
        this.bve = bve;
        this.bvel = bvel;
        this.aBve = aBve;
        this.aBvel = aBvel;
        this.ove = ove;
        this.ovel = ovel;
    }

    public Integer getBankId() {
        return bankId;
    }

    public void setBankId(Integer bankId) {
        this.bankId = bankId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankAddress() {
        return bankAddress;
    }

    public void setBankAddress(String bankAddress) {
        this.bankAddress = bankAddress;
    }

    public String getBankContactNo() {
        return bankContactNo;
    }

    public void setBankContactNo(String bankContactNo) {
        this.bankContactNo = bankContactNo;
    }

    public String getBankEmail() {
        return bankEmail;
    }

    public void setBankEmail(String bankEmail) {
        this.bankEmail = bankEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAve() {
        return ave;
    }

    public void setAve(int ave) {
        this.ave = ave;
    }

    public int getAvel() {
        return avel;
    }

    public void setAvel(int avel) {
        this.avel = avel;
    }

    public int getBve() {
        return bve;
    }

    public void setBve(int bve) {
        this.bve = bve;
    }

    public int getBvel() {
        return bvel;
    }

    public void setBvel(int bvel) {
        this.bvel = bvel;
    }

    public int getABve() {
        return aBve;
    }

    public void setABve(int aBve) {
        this.aBve = aBve;
    }

    public int getABvel() {
        return aBvel;
    }

    public void setABvel(int aBvel) {
        this.aBvel = aBvel;
    }

    public int getOve() {
        return ove;
    }

    public void setOve(int ove) {
        this.ove = ove;
    }

    public int getOvel() {
        return ovel;
    }

    public void setOvel(int ovel) {
        this.ovel = ovel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bankId != null ? bankId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BloodBank)) {
            return false;
        }
        BloodBank other = (BloodBank) object;
        if ((this.bankId == null && other.bankId != null) || (this.bankId != null && !this.bankId.equals(other.bankId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.BloodBank[ bankId=" + bankId + " ]";
    }
    
}
