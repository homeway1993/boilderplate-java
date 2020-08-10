package boilerplate.springboot.datawithoracle.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "IV_INVNT")
public class IvInvnt {

    @Id
    @Column(name = "INVNT_ID")
    private String invntId;

    @Column(name = "INVNT_STAT_CDE")
    private String invntStatCde;

    @Column(name = "LAST_MOD_USER")
    private String lastModUser;

    @Column(name = "LAST_MOD_DTE")
    private LocalDate lastModDte;
}
