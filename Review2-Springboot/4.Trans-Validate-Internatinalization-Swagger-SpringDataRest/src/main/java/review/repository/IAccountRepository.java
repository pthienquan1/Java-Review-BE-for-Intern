package review.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import review.dto.DepartmentDTO;
import review.entity.Account;

/**
 * Created by quan0
 * Date 5/25/2023 - 4:10 PM
 * Description: ...
 */
public interface IAccountRepository extends JpaRepository<Account, Integer>, JpaSpecificationExecutor<Account> {
    boolean existsByUsername(String username);
}
