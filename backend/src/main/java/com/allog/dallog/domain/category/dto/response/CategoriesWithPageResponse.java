package com.allog.dallog.domain.category.dto.response;

import com.allog.dallog.domain.category.domain.Category;
import java.util.List;
import java.util.stream.Collectors;

public class CategoriesWithPageResponse {

    private int page;
    private List<CategoryResponse> categories;

    public CategoriesWithPageResponse() {
    }

    public CategoriesWithPageResponse(final int page, final List<Category> categories) {
        this.page = page;
        this.categories = toResponses(categories);
    }

    private List<CategoryResponse> toResponses(final List<Category> categories) {
        return categories.stream()
                .map(CategoryResponse::new)
                .collect(Collectors.toList());
    }

    public int getPage() {
        return page;
    }

    public List<CategoryResponse> getCategories() {
        return categories;
    }
}
