package com.example.review3.controller;

import com.example.review3.dto.DepartmentDTO;
import com.example.review3.entity.Department;
import com.example.review3.form.DepartmentFilterFormm;
import com.example.review3.service.IDepartmentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by quan0
 * Date 5/22/2023 - 5:15 PM
 * Description: ...
 */@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {
    @Autowired
    private IDepartmentService service;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping()
    public Page<DepartmentDTO> getAllDepartments(
            Pageable pageable,
            @RequestParam(name = "search", required = false) String search,
            DepartmentFilterFormm filterForm) {
        Page<Department> entityPages = service.getAllDepartments(pageable, search, filterForm);

        // convert entities --> dtos
        List<DepartmentDTO> dtos = modelMapper.map(
                entityPages.getContent(),
                new TypeToken<List<DepartmentDTO>>() {}.getType());

        Page<DepartmentDTO> dtoPages = new PageImpl<>(dtos, pageable, entityPages.getTotalElements());

        return dtoPages;

    }
}
