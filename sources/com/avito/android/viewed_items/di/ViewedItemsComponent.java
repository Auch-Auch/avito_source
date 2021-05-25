package com.avito.android.viewed_items.di;

import android.content.res.Resources;
import com.avito.android.di.PerFragment;
import com.avito.android.util.Kundle;
import com.avito.android.viewed_items.ViewedItemsFragment;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\ba\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/viewed_items/di/ViewedItemsComponent;", "", "Lcom/avito/android/viewed_items/ViewedItemsFragment;", "fragment", "", "inject", "(Lcom/avito/android/viewed_items/ViewedItemsFragment;)V", "Builder", "favorites_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {ViewedItemsDependencies.class}, modules = {ViewedItemsModule.class})
@PerFragment
public interface ViewedItemsComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H'¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\nH'¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/viewed_items/di/ViewedItemsComponent$Builder;", "", "Lcom/avito/android/viewed_items/di/ViewedItemsDependencies;", "dependencies", "dependentOn", "(Lcom/avito/android/viewed_items/di/ViewedItemsDependencies;)Lcom/avito/android/viewed_items/di/ViewedItemsComponent$Builder;", "Landroid/content/res/Resources;", "resources", "withResources", "(Landroid/content/res/Resources;)Lcom/avito/android/viewed_items/di/ViewedItemsComponent$Builder;", "Lcom/avito/android/util/Kundle;", "state", "withPresenterState", "(Lcom/avito/android/util/Kundle;)Lcom/avito/android/viewed_items/di/ViewedItemsComponent$Builder;", "Lcom/avito/android/viewed_items/di/ViewedItemsComponent;", "build", "()Lcom/avito/android/viewed_items/di/ViewedItemsComponent;", "favorites_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        ViewedItemsComponent build();

        @NotNull
        Builder dependentOn(@NotNull ViewedItemsDependencies viewedItemsDependencies);

        @BindsInstance
        @NotNull
        Builder withPresenterState(@Nullable Kundle kundle);

        @BindsInstance
        @NotNull
        Builder withResources(@NotNull Resources resources);
    }

    void inject(@NotNull ViewedItemsFragment viewedItemsFragment);
}
