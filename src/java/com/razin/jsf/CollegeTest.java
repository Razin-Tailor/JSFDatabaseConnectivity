/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.razin.jsf;

import com.mysql.jdbc.PreparedStatement;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
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
 * @author razintailor
 */
@ManagedBean
@Entity
@Table(name = "college_test")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CollegeTest.findAll", query = "SELECT c FROM CollegeTest c"),
    @NamedQuery(name = "CollegeTest.findById", query = "SELECT c FROM CollegeTest c WHERE c.id = :id"),
    @NamedQuery(name = "CollegeTest.findByName", query = "SELECT c FROM CollegeTest c WHERE c.name = :name")})
public class CollegeTest implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "name")
    private String name;

    public CollegeTest() {
    }

    public CollegeTest(Integer id) {
        this.id = id;
    }

    public CollegeTest(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void add() throws ClassNotFoundException, SQLException
    {
        Class.forName("com.mysql.jdbc.Driver");
        
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsf_college", "root", "");
        String str = "INSERT INTO college_test (name) values (?)";
        PreparedStatement ps = (PreparedStatement) con.prepareStatement(str);
        ps.setString(1, name);
        
        int i = 0;
        
        i = ps.executeUpdate();
        System.out.println("Data Added Successfully");
        
        
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
        if (!(object instanceof CollegeTest)) {
            return false;
        }
        CollegeTest other = (CollegeTest) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.razin.jsf.CollegeTest[ id=" + id + " ]";
    }
    
}
