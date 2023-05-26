package review.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import review.entity.Department;
import review.form.CreatingDepartmentForm;
import review.form.DepartmentFilterForm;
import review.form.UpdateDepartmentForm;
import review.repository.IDepartmentRepository;
import review.specification.department.DepartmentSpecification;

/**
 * Created by quan0
 * Date 5/25/2023 - 4:28 PM
 * Description: ...
 */
@Service
public class DepartmentService implements IDepartmentService{
    @Autowired
    private IDepartmentRepository repository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public Page<Department> getAllDepartments(Pageable pageable, String search, DepartmentFilterForm filterForm) {
        Specification<Department> where = DepartmentSpecification.buildWhere(search,filterForm);
        return repository.findAll(where,pageable);
    }

    @Override
    public Department getDepartmentById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public void createDepartment(CreatingDepartmentForm creatingDepartmentForm){
        Department department = modelMapper.map(creatingDepartmentForm,Department.class);
        repository.save(department);
    }
    @Override
    public void updateDepartment(UpdateDepartmentForm updateDepartmentForm){
        Department department = modelMapper.map(updateDepartmentForm,Department.class);
        repository.save(department);
    }
}
