package com.dibootcampfinal.apiecocitoyens.models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "pro_alerte", schema = "public", catalog = "eco_citoyens")
public class ProAlerteEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idalert", nullable = false)
    private int idalert;
    @Basic
    @Column(name = "dateheurealerte", nullable = false)
    private Timestamp dateheurealerte;
    @Basic
    @Column(name = "typealerte", nullable = false, length = 45)
    private String typealerte;
    @Basic
    @Column(name = "descriptionalerte", nullable = false, length = 45)
    private String descriptionalerte;

    @ManyToOne
    @JoinColumn(name = "idsite", referencedColumnName = "idsite", nullable = false)
    private ProSitedecolletteEntity proSitedecolletteByIdsite;

    public int getIdalert() {
        return idalert;
    }

    public void setIdalert(int idalert) {
        this.idalert = idalert;
    }

    public Timestamp getDateheurealerte() {
        return dateheurealerte;
    }

    public void setDateheurealerte(Timestamp dateheurealerte) {
        this.dateheurealerte = dateheurealerte;
    }

    public String getTypealerte() {
        return typealerte;
    }

    public void setTypealerte(String typealerte) {
        this.typealerte = typealerte;
    }

    public String getDescriptionalerte() {
        return descriptionalerte;
    }

    public void setDescriptionalerte(String descriptionalerte) {
        this.descriptionalerte = descriptionalerte;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idalert, dateheurealerte, typealerte, descriptionalerte);
    }

    public ProSitedecolletteEntity getProSitedecolletteByIdsite() {
        return proSitedecolletteByIdsite;
    }

    public void setProSitedecolletteByIdsite(ProSitedecolletteEntity proSitedecolletteByIdsite) {
        this.proSitedecolletteByIdsite = proSitedecolletteByIdsite;
    }
}
