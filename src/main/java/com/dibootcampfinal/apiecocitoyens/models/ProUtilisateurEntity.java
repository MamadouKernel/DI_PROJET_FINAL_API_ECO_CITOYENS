package com.dibootcampfinal.apiecocitoyens.models;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "pro_utilisateur", schema = "public", catalog = "eco_citoyens")
public class ProUtilisateurEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idutilisateur", nullable = false)
    private int idutilisateur;
    @Basic
    @Column(name = "nom", nullable = false, length = 45)
    private String nom;
    @Basic
    @Column(name = "prenom", nullable = false, length = 45)
    private String prenom;
    @Basic
    @Column(name = "email", nullable = false, length = 45)
    private String email;
    @Basic
    @Column(name = "nomutilisateur", nullable = false, length = 45)
    private String nomutilisateur;
    @Basic
    @Column(name = "motdepasse", nullable = false, length = 255)
    private String motdepasse;
    @OneToMany(mappedBy = "proUtilisateurByIdutilisateur")
    private Collection<ProSitedecolletteEntity> proSitedecollettesByIdutilisateur;
    @ManyToOne
    @JoinColumn(name = "idrole", referencedColumnName = "idrole", nullable = false)
    private ProRoleEntity proRoleByIdrole;

    public int getIdutilisateur() {
        return idutilisateur;
    }

    public void setIdutilisateur(int idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomutilisateur() {
        return nomutilisateur;
    }

    public void setNomutilisateur(String nomutilisateur) {
        this.nomutilisateur = nomutilisateur;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProUtilisateurEntity that = (ProUtilisateurEntity) o;
        return idutilisateur == that.idutilisateur && Objects.equals(prenom, that.prenom) && Objects.equals(email, that.email) && Objects.equals(nomutilisateur, that.nomutilisateur) && Objects.equals(motdepasse, that.motdepasse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idutilisateur, nom, prenom, email, nomutilisateur, motdepasse);
    }

    public Collection<ProSitedecolletteEntity> getProSitedecollettesByIdutilisateur() {
        return proSitedecollettesByIdutilisateur;
    }

    public void setProSitedecollettesByIdutilisateur(Collection<ProSitedecolletteEntity> proSitedecollettesByIdutilisateur) {
        this.proSitedecollettesByIdutilisateur = proSitedecollettesByIdutilisateur;
    }

    public ProRoleEntity getProRoleByIdrole() {
        return proRoleByIdrole;
    }

    public void setProRoleByIdrole(ProRoleEntity proRoleByIdrole) {
        this.proRoleByIdrole = proRoleByIdrole;
    }
}
