package com.dibootcampfinal.apiecocitoyens.models;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "pro_planificationdelacollette", schema = "public", catalog = "eco_citoyens")
public class ProPlanificationdelacolletteEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idplanification", nullable = false)
    private int idplanification;
    @Basic
    @Column(name = "dateplanification", nullable = false)
    private Date dateplanification;
    @Basic
    @Column(name = "quantiteestimee", nullable = false, precision = 0)
    private BigInteger quantiteestimee;
    @OneToMany(mappedBy = "proPlanificationdelacolletteByIdplanification")
    private Collection<ProColletteEntity> proCollettesByIdplanification;
    @ManyToOne
    @JoinColumn(name = "idsite", referencedColumnName = "idsite", nullable = false)
    private ProSitedecolletteEntity proSitedecolletteByIdsite;

    public int getIdplanification() {
        return idplanification;
    }

    public void setIdplanification(int idplanification) {
        this.idplanification = idplanification;
    }

    public Date getDateplanification() {
        return dateplanification;
    }

    public void setDateplanification(Date dateplanification) {
        this.dateplanification = dateplanification;
    }

    public BigInteger getQuantiteestimee() {
        return quantiteestimee;
    }

    public void setQuantiteestimee(BigInteger quantiteestimee) {
        this.quantiteestimee = quantiteestimee;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idplanification, dateplanification, quantiteestimee);
    }

    public Collection<ProColletteEntity> getProCollettesByIdplanification() {
        return proCollettesByIdplanification;
    }

    public void setProCollettesByIdplanification(Collection<ProColletteEntity> proCollettesByIdplanification) {
        this.proCollettesByIdplanification = proCollettesByIdplanification;
    }

    public ProSitedecolletteEntity getProSitedecolletteByIdsite() {
        return proSitedecolletteByIdsite;
    }

    public void setProSitedecolletteByIdsite(ProSitedecolletteEntity proSitedecolletteByIdsite) {
        this.proSitedecolletteByIdsite = proSitedecolletteByIdsite;
    }
}
