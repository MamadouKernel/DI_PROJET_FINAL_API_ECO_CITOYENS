package com.dibootcampfinal.apiecocitoyens.models;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "pro_role", schema = "public", catalog = "eco_citoyens")
public class ProRoleEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idrole", nullable = false)
    private int idrole;
    @Basic
    @Column(name = "libelle", nullable = false, length = 45)
    private String libelle;
    @Basic
    @Column(name = "create_date", nullable = false)
    private Date createDate;
    @OneToMany(mappedBy = "proRoleByIdrole")
    private Collection<ProUtilisateurEntity> proUtilisateursByIdrole;

    public int getIdrole() {
        return idrole;
    }

    public void setIdrole(int idrole) {
        this.idrole = idrole;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProRoleEntity that = (ProRoleEntity) o;
        return idrole == that.idrole && Objects.equals(libelle, that.libelle) && Objects.equals(createDate, that.createDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idrole, libelle, createDate);
    }

    public Collection<ProUtilisateurEntity> getProUtilisateursByIdrole() {
        return proUtilisateursByIdrole;
    }

    public void setProUtilisateursByIdrole(Collection<ProUtilisateurEntity> proUtilisateursByIdrole) {
        this.proUtilisateursByIdrole = proUtilisateursByIdrole;
    }
}
