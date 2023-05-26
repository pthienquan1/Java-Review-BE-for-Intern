package review.controller;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import review.dto.DepartmentDTO;
import review.entity.Department;
import review.form.CreatingDepartmentForm;
import review.form.DepartmentFilterForm;
import review.form.UpdateDepartmentForm;
import review.service.IDepartmentService;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 * Created by quan0
 * Date 5/26/2023 - 1:32 PM
 * Description: ...
 */
@RestController
@RequestMapping(value="/api/v1/departments")
public class DepartmentController {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private IDepartmentService service;

    @GetMapping()
    public Page<DepartmentDTO> getAllDepartments(
            Pageable pageable,
            @RequestParam(name = "search", required = false) String search,
            DepartmentFilterForm filterForm) {
        Page<Department> entityPages = service.getAllDepartments(pageable, search, filterForm);

        // convert entities --> dtos
        List<DepartmentDTO> dtos = modelMapper.map(
                entityPages.getContent(),
                new TypeToken<List<DepartmentDTO>>() {}.getType());




        Page<DepartmentDTO> dtoPages = new PageImpl<>(dtos, pageable, entityPages.getTotalElements());

        return dtoPages;
    }

    @GetMapping(value="/{id}")
    public DepartmentDTO getDepartmentByID(@PathVariable(value = "id") int id){
        Department entity = service.getDepartmentById(id);
        DepartmentDTO dto = modelMapper.map(entity,DepartmentDTO.class);

        return dto;

    }

    @PostMapping()
    public void createDepartment(@RequestBody CreatingDepartmentForm creatingDepartmentForm){
        service.createDepartment(creatingDepartmentForm);
    }
    @PutMapping(value = "/{id}")
    public void updateDepartment(@PathVariable(value = "id") int id, @RequestBody UpdateDepartmentForm updateDepartmentForm){
        updateDepartmentForm.setId(id);
        service.updateDepartment(updateDepartmentForm);
    }
}
