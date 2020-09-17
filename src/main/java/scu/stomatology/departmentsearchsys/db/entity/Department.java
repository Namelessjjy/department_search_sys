package scu.stomatology.departmentsearchsys.db.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "department")
@DynamicInsert
@DynamicUpdate
@Data
public class Department {

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private String info;

    @Column
    private String symptom;

    @Column
    private String subDepartment;
}
