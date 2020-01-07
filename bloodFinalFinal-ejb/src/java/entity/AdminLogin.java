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
@Table(name = "admin_login")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdminLogin.findAll", query = "SELECT a FROM AdminLogin a")
    , @NamedQuery(name = "AdminLogin.findByAdminId", query = "SELECT a FROM AdminLogin a WHERE a.adminId = :adminId")
    , @NamedQuery(name = "AdminLogin.findByAdminEmail", query = "SELECT a FROM AdminLogin a WHERE a.adminEmail = :adminEmail")
    , @NamedQuery(name = "AdminLogin.findByAdminPassword", query = "SELECT a FROM AdminLogin a WHERE a.adminPassword = :adminPassword")})
public class AdminLogin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "admin_id")
    private Integer adminId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "admin_email")
    private String adminEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "admin_password")
    private String adminPassword;

    public AdminLogin() {
    }

    public AdminLogin(Integer adminId) {
        this.adminId = adminId;
    }

    public AdminLogin(Integer adminId, String adminEmail, String adminPassword) {
        this.adminId = adminId;
        this.adminEmail = adminEmail;
        this.adminPassword = adminPassword;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adminId != null ? adminId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdminLogin)) {
            return false;
        }
        AdminLogin other = (AdminLogin) object;
        if ((this.adminId == null && other.adminId != null) || (this.adminId != null && !this.adminId.equals(other.adminId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AdminLogin[ adminId=" + adminId + " ]";
    }
    
}
