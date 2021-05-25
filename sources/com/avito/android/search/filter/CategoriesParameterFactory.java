package com.avito.android.search.filter;

import com.avito.android.remote.model.Category;
import com.avito.android.remote.model.category_parameters.base.CategoryParameter;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\tJ-\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/avito/android/search/filter/CategoriesParameterFactory;", "", "", "Lcom/avito/android/remote/model/Category;", "categories", "selectedCategory", "Lcom/avito/android/remote/model/category_parameters/base/CategoryParameter;", "create", "(Ljava/util/List;Lcom/avito/android/remote/model/Category;)Ljava/util/List;", "TitleProvider", "filter_release"}, k = 1, mv = {1, 4, 2})
public interface CategoriesParameterFactory {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/avito/android/search/filter/CategoriesParameterFactory$TitleProvider;", "", "", "getCategoriesTitle", "()Ljava/lang/String;", "getSubcategoriesTitle", "filter_release"}, k = 1, mv = {1, 4, 2})
    public interface TitleProvider {
        @NotNull
        String getCategoriesTitle();

        @NotNull
        String getSubcategoriesTitle();
    }

    @NotNull
    List<CategoryParameter> create(@NotNull List<Category> list, @Nullable Category category);
}
