package review.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by quan0
 * Date 5/25/2023 - 1:58 PM
 * Description: ...
 */
@Data
@NoArgsConstructor
@Entity
@Table(name="`Account`")
public class Account implements Serializable {
    private static final long serialVersionUid = 1L;

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="username",length = 50,nullable = false,unique = true, updatable = false)
    private String username;

    @ManyToOne
    @JoinColumn(name="department_id",nullable = false)
    private Department department;

}
