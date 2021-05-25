package com.avito.android.remote.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
public class TargetingParams {
    @Nullable
    private Category mCategory;
    @Nullable
    private Location mLocation;
    @NonNull
    private final String mPageType;
    @Nullable
    private String mSearchQuery;

    @Retention(RetentionPolicy.SOURCE)
    public @interface PageType {
        public static final String ITEM = "item";
        public static final String SEARCH = "search_page";
    }

    public TargetingParams(@NonNull String str) {
        this.mPageType = str;
    }

    @Nullable
    public Category getCategory() {
        return this.mCategory;
    }

    @Nullable
    public Location getLocation() {
        return this.mLocation;
    }

    @NonNull
    public String getPageType() {
        return this.mPageType;
    }

    @Nullable
    public String getSearchQuery() {
        return this.mSearchQuery;
    }

    public TargetingParams setCategory(@Nullable Category category) {
        this.mCategory = category;
        return this;
    }

    public TargetingParams setLocation(@Nullable Location location) {
        this.mLocation = location;
        return this;
    }

    public TargetingParams setSearchQuery(@Nullable String str) {
        this.mSearchQuery = str;
        return this;
    }
}
