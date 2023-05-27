package review.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import review.entity.Department;
import review.form.CreatingDepartmentForm;
import review.form.DepartmentFilterForm;
import review.form.UpdateDepartmentForm;

/**
 * Created by quan0
 * Date 5/25/2023 - 4:27 PM
 * Description: ...
 */
public interface IDepartmentService {
    public Page<Department> getAllDepartments(Pageable pageable, String search, DepartmentFilterForm filterForm);
    public Department getDepartmentById(int id);

    public void createDepartment(CreatingDepartmentForm creatingDepartmentForm);
    public void updateDepartment(UpdateDepartmentForm updateDepartmentForm);
    public boolean isDepartmentExistsByName(String name);
}
