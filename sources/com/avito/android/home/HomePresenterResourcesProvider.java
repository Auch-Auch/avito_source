package com.avito.android.home;

import com.avito.android.remote.model.SerpDisplayType;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\r\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u0016\u0010\u0011\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\fR\u0016\u0010\u0013\u001a\u00020\u00128&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/avito/android/home/HomePresenterResourcesProvider;", "Lcom/avito/android/home/ColumnsCountProvider;", "", "locality", "getEmptyScreenTitle", "(Ljava/lang/String;)Ljava/lang/String;", "Lcom/avito/android/remote/model/SerpDisplayType;", "displayType", "", "getColumnsCount", "(Lcom/avito/android/remote/model/SerpDisplayType;)I", "getDividerTitle", "()Ljava/lang/String;", "dividerTitle", "getAllCategories", "allCategories", "getSelectCategory", "selectCategory", "", "isTablet", "()Z", "getAllCategoriesLarge", "allCategoriesLarge", "serp_release"}, k = 1, mv = {1, 4, 2})
public interface HomePresenterResourcesProvider extends ColumnsCountProvider {
    @NotNull
    String getAllCategories();

    @NotNull
    String getAllCategoriesLarge();

    int getColumnsCount(@NotNull SerpDisplayType serpDisplayType);

    @NotNull
    String getDividerTitle();

    @NotNull
    String getEmptyScreenTitle(@NotNull String str);

    @NotNull
    String getSelectCategory();

    boolean isTablet();
}
