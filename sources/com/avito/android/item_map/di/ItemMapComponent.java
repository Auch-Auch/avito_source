package com.avito.android.item_map.di;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import com.avito.android.di.PerFragment;
import com.avito.android.item_map.ItemMapFragment;
import com.avito.android.item_map.view.ItemMapView;
import com.avito.android.ui.ActivityInteractor;
import com.avito.android.util.Kundle;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/item_map/di/ItemMapComponent;", "", "Lcom/avito/android/item_map/ItemMapFragment;", "fragment", "", "inject", "(Lcom/avito/android/item_map/ItemMapFragment;)V", "Builder", "item-map_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {ItemMapDependencies.class}, modules = {ItemMapModule.class})
@PerFragment
public interface ItemMapComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\bH'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0010H'¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0014H'¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u001a\u001a\u00020\u00002\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H'¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001cH'¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u001fH'¢\u0006\u0004\b \u0010!¨\u0006\""}, d2 = {"Lcom/avito/android/item_map/di/ItemMapComponent$Builder;", "", "Lcom/avito/android/item_map/di/ItemMapComponent;", "build", "()Lcom/avito/android/item_map/di/ItemMapComponent;", "Lcom/avito/android/item_map/di/ItemMapDependencies;", "dependencies", "(Lcom/avito/android/item_map/di/ItemMapDependencies;)Lcom/avito/android/item_map/di/ItemMapComponent$Builder;", "Lcom/avito/android/item_map/view/ItemMapView$ItemMapState;", "itemMapState", "savedState", "(Lcom/avito/android/item_map/view/ItemMapView$ItemMapState;)Lcom/avito/android/item_map/di/ItemMapComponent$Builder;", "Lcom/avito/android/ui/ActivityInteractor;", "activityInteractor", "withActivityInteractor", "(Lcom/avito/android/ui/ActivityInteractor;)Lcom/avito/android/item_map/di/ItemMapComponent$Builder;", "Landroid/app/Activity;", "activity", "withActivity", "(Landroid/app/Activity;)Lcom/avito/android/item_map/di/ItemMapComponent$Builder;", "Landroidx/fragment/app/Fragment;", "fragment", "withFragment", "(Landroidx/fragment/app/Fragment;)Lcom/avito/android/item_map/di/ItemMapComponent$Builder;", "Lcom/avito/android/util/Kundle;", "state", "savedAmenityState", "(Lcom/avito/android/util/Kundle;)Lcom/avito/android/item_map/di/ItemMapComponent$Builder;", "Landroid/content/res/Resources;", "resources", "(Landroid/content/res/Resources;)Lcom/avito/android/item_map/di/ItemMapComponent$Builder;", "Landroid/content/Context;", "context", "(Landroid/content/Context;)Lcom/avito/android/item_map/di/ItemMapComponent$Builder;", "item-map_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        ItemMapComponent build();

        @BindsInstance
        @NotNull
        Builder context(@NotNull Context context);

        @NotNull
        Builder dependencies(@NotNull ItemMapDependencies itemMapDependencies);

        @BindsInstance
        @NotNull
        Builder resources(@NotNull Resources resources);

        @BindsInstance
        @NotNull
        Builder savedAmenityState(@Nullable Kundle kundle);

        @BindsInstance
        @NotNull
        Builder savedState(@NotNull ItemMapView.ItemMapState itemMapState);

        @BindsInstance
        @NotNull
        Builder withActivity(@NotNull Activity activity);

        @BindsInstance
        @NotNull
        Builder withActivityInteractor(@NotNull ActivityInteractor activityInteractor);

        @BindsInstance
        @NotNull
        Builder withFragment(@NotNull Fragment fragment);
    }

    void inject(@NotNull ItemMapFragment itemMapFragment);
}
