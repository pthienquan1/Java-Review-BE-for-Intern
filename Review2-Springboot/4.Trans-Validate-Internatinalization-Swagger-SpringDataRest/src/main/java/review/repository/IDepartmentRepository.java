package review.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import review.entity.Department;

/**
 * Created by quan0
 * Date 5/25/2023 - 4:10 PM
 * Description: ...
 */
public interface IDepartmentRepository extends JpaRepository<Department, Integer>, JpaSpecificationExecutor<Department> {
    boolean existsByName(String name);
}
