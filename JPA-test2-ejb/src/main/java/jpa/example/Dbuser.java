/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.example;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Pawel
 */
@Entity
@Table(name = "Dbuser")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dbuser.findAll", query = "SELECT d FROM Dbuser d"),
    @NamedQuery(name = "Dbuser.findByUserId", query = "SELECT d FROM Dbuser d WHERE d.userId = :userId"),
    @NamedQuery(name = "Dbuser.findByUsername", query = "SELECT d FROM Dbuser d WHERE d.username = :username"),
    @NamedQuery(name = "Dbuser.findByPassword", query = "SELECT d FROM Dbuser d WHERE d.password = :password")})
public class Dbuser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "USER_ID")
    private Integer userId;
    @Size(max = 20)
    @Column(name = "USERNAME")
    private String username;
    @Size(max = 20)
    @Column(name = "PASSWORD")
    private String password;

    public Dbuser() {
    }

    public Dbuser(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dbuser)) {
            return false;
        }
        Dbuser other = (Dbuser) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.example.Dbuser[ userId=" + userId + " ]";
    }
    
}
