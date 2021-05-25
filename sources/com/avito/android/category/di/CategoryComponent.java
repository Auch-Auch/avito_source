package com.avito.android.category.di;

import android.content.res.Resources;
import com.avito.android.category.CategoryActivity;
import com.avito.android.category.CategoryArguments;
import com.avito.android.category.CategoryInteractorState;
import com.avito.android.category.CategoryPresenterState;
import com.avito.android.di.PerActivity;
import com.avito.android.location.di.LocationDependencies;
import com.avito.android.location.di.SavedLocationInteractorModule;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/category/di/CategoryComponent;", "", "Lcom/avito/android/category/CategoryActivity;", "activity", "", "inject", "(Lcom/avito/android/category/CategoryActivity;)V", "Builder", "category_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {CategoryDependencies.class, LocationDependencies.class}, modules = {CategoryModule.class, SavedLocationInteractorModule.class})
@PerActivity
public interface CategoryComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H'¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\nH'¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH'¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H&¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/avito/android/category/di/CategoryComponent$Builder;", "", "Landroid/content/res/Resources;", "resources", "bindResources", "(Landroid/content/res/Resources;)Lcom/avito/android/category/di/CategoryComponent$Builder;", "Lcom/avito/android/category/CategoryArguments;", "arguments", "bindArguments", "(Lcom/avito/android/category/CategoryArguments;)Lcom/avito/android/category/di/CategoryComponent$Builder;", "Lcom/avito/android/category/CategoryPresenterState;", "categoryPresenterState", "bindCategoryPresenterState", "(Lcom/avito/android/category/CategoryPresenterState;)Lcom/avito/android/category/di/CategoryComponent$Builder;", "Lcom/avito/android/category/CategoryInteractorState;", "categoryInteractorState", "bindCategoryInteractorState", "(Lcom/avito/android/category/CategoryInteractorState;)Lcom/avito/android/category/di/CategoryComponent$Builder;", "Lcom/avito/android/category/di/CategoryDependencies;", "categoryDependencies", "(Lcom/avito/android/category/di/CategoryDependencies;)Lcom/avito/android/category/di/CategoryComponent$Builder;", "Lcom/avito/android/location/di/LocationDependencies;", "locationDependencies", "(Lcom/avito/android/location/di/LocationDependencies;)Lcom/avito/android/category/di/CategoryComponent$Builder;", "Lcom/avito/android/category/di/CategoryComponent;", "build", "()Lcom/avito/android/category/di/CategoryComponent;", "category_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @BindsInstance
        @NotNull
        Builder bindArguments(@NotNull CategoryArguments categoryArguments);

        @BindsInstance
        @NotNull
        Builder bindCategoryInteractorState(@Nullable CategoryInteractorState categoryInteractorState);

        @BindsInstance
        @NotNull
        Builder bindCategoryPresenterState(@Nullable CategoryPresenterState categoryPresenterState);

        @BindsInstance
        @NotNull
        Builder bindResources(@NotNull Resources resources);

        @NotNull
        CategoryComponent build();

        @NotNull
        Builder categoryDependencies(@NotNull CategoryDependencies categoryDependencies);

        @NotNull
        Builder locationDependencies(@NotNull LocationDependencies locationDependencies);
    }

    void inject(@NotNull CategoryActivity categoryActivity);
}
