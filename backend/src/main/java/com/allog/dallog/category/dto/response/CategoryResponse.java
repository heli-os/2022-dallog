package com.allog.dallog.category.dto.response;

import com.allog.dallog.category.domain.Category;
import com.allog.dallog.member.dto.MemberResponse;
import java.time.LocalDateTime;

public class CategoryResponse {

    private Long id;
    private String name;
    private MemberResponse creator;
    private LocalDateTime createdAt;

    private CategoryResponse() {
    }

    public CategoryResponse(final Category category) {
        this(category.getId(), category.getName(), new MemberResponse(category.getMember()), category.getCreatedAt());
    }

    public CategoryResponse(final Long id, final String name, final MemberResponse creator,
                            final LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.creator = creator;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public MemberResponse getCreator() {
        return creator;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
