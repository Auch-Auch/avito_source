package com.avito.android;

import com.avito.android.remote.model.Category;
import io.reactivex.rxjava3.core.Observable;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00022\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/CategoriesInteractor;", "", "Lio/reactivex/rxjava3/core/Observable;", "", "Lcom/avito/android/remote/model/Category;", "getCategories", "()Lio/reactivex/rxjava3/core/Observable;", "", "categoryId", "getCategoryById", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "getCategoryByIdImmediately", "(Ljava/lang/String;)Lcom/avito/android/remote/model/Category;", "categories_release"}, k = 1, mv = {1, 4, 2})
public interface CategoriesInteractor {
    @NotNull
    Observable<List<Category>> getCategories();

    @NotNull
    Observable<Category> getCategoryById(@NotNull String str);

    @Nullable
    Category getCategoryByIdImmediately(@NotNull String str);
}
