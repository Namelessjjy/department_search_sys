package scu.stomatology.departmentsearchsys.db.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "healthknowledge")
@DynamicInsert
@DynamicUpdate
@Data
public class HealthKnowledge {

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column
    private String icon;

    @Column
    private String color;

    @Column
    private String info;

    @Column
    private String img;

    @Column
    private String name;

}
