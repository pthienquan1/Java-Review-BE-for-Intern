package review.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by quan0
 * Date 5/25/2023 - 1:59 PM
 * Description: ...
 */
@Entity
@Table(name = "Department")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Department implements Serializable {
    private static final long serialVersionUid = 1L;

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name",nullable = false,length = 50, unique = true)
    @NonNull
    private String name;

    @Column(name="total_member", nullable = false)
    private int totalMember;

    @Column(name="`type`", nullable = false)
    @Convert(converter = DepartmentTypeConvert.class)
    private Type type;

    @Column(name="created_date",updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date created_date;

    @OneToMany(mappedBy = "department")
    private List<Account> accounts;

    public enum Type{
        DEV("Dev"), TEST("Test"), SCRUMMASTER("ScrumMaster"), PM("PM");
        private String value;

        private Type(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public static Type toEnum(String sqlValue){
            for(Type type : Type.values()){
                if(type.getValue().equals(sqlValue)){
                    return type;
                }
            }
            return null;
        }
    }



}
