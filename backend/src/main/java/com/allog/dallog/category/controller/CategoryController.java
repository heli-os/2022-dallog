package com.allog.dallog.category.controller;

import com.allog.dallog.auth.dto.LoginMember;
import com.allog.dallog.auth.support.AuthenticationPrincipal;
import com.allog.dallog.category.dto.request.CategoryCreateRequest;
import com.allog.dallog.category.dto.response.CategoriesResponse;
import com.allog.dallog.category.dto.response.CategoryResponse;
import com.allog.dallog.category.service.CategoryService;
import java.net.URI;
import java.util.List;
import javax.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/categories")
@RestController
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(final CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> save(@AuthenticationPrincipal final LoginMember loginMember,
                                                 @Valid @RequestBody final CategoryCreateRequest request) {
        CategoryResponse categoryResponse = categoryService.save(loginMember.getId(), request);
        return ResponseEntity.created(URI.create("/api/categories/" + categoryResponse.getId())).body(categoryResponse);
    }

    @GetMapping
    public ResponseEntity<CategoriesResponse> findAll(Pageable pageable) {
        int pageNumber = pageable.getPageNumber();
        List<CategoryResponse> categoryResponses = categoryService.findAll(pageable);
        return ResponseEntity.ok(new CategoriesResponse(pageNumber, categoryResponses));
    }

    @GetMapping("/me")
    public ResponseEntity<CategoriesResponse> findMine(@AuthenticationPrincipal final LoginMember loginMember,
                                                       Pageable pageable) {
        int pageNumber = pageable.getPageNumber();
        List<CategoryResponse> categoryResponses = categoryService.findMine(loginMember.getId(), pageable);
        return ResponseEntity.ok(new CategoriesResponse(pageNumber, categoryResponses));
    }
}
