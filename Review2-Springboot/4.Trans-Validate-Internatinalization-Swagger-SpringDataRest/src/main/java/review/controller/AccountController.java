package review.controller;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import review.dto.AccountDTO;
import review.entity.Account;
import review.form.AccountFilterForm;
import review.repository.IAccountRepository;
import review.service.IAccountService;
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
@RequestMapping(value = "/api/v1/accounts")
public class AccountController {
    @Autowired
    private IAccountService service;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping()
    public Page<AccountDTO> getAllAcounts(Pageable pageable, @RequestParam(value="search", required = false) String search,
                                          AccountFilterForm filterForm){
        Page<Account> entityPages = service.getAllAccounts(pageable,filterForm,search );
        List<AccountDTO> dtos = modelMapper.map(entityPages.getContent(), new TypeToken<List<AccountDTO>>() {}.getType());
        Page<AccountDTO> dtoPages = new PageImpl<>(dtos,pageable,entityPages.getTotalElements());
        return dtoPages;
    }

    @GetMapping(value = "/{id}")
    public AccountDTO getAccountByID(@PathVariable(name = "id") int id) {
        Account entity = service.getAccountById(id);

        // convert entity to dto
        AccountDTO dto = modelMapper.map(entity, AccountDTO.class);

        dto.add(linkTo(methodOn(AccountController.class).getAccountByID(id)).withSelfRel());

        return dto;
    }
}
