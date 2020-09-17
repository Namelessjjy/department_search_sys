package scu.stomatology.departmentsearchsys.db.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "image")
@DynamicInsert
@DynamicUpdate
@Data
public class Image {

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column
    private String type;

    @Column
    private String url;

}
