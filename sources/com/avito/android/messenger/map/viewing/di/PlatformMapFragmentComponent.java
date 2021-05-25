package com.avito.android.messenger.map.viewing.di;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.avito.android.messenger.map.viewing.PlatformMapFragment;
import com.avito.android.remote.model.messenger.geo.GeoMarker;
import com.avito.android.remote.model.messenger.geo.MarkersRequest;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Component(dependencies = {PlatformMapFragmentDependencies.class}, modules = {PlatformMapFragmentModule.class})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/messenger/map/viewing/di/PlatformMapFragmentComponent;", "", "Lcom/avito/android/messenger/map/viewing/PlatformMapFragment;", "fragment", "", "inject", "(Lcom/avito/android/messenger/map/viewing/PlatformMapFragment;)V", "Builder", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface PlatformMapFragmentComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H'¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nH'¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000eH'¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0012H'¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0016H'¢\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\u001d\u001a\u00020\u00002\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH'¢\u0006\u0004\b\u001d\u0010\u001eJ\u0019\u0010!\u001a\u00020\u00002\b\u0010 \u001a\u0004\u0018\u00010\u001fH'¢\u0006\u0004\b!\u0010\"J\u0017\u0010%\u001a\u00020\u00002\u0006\u0010$\u001a\u00020#H'¢\u0006\u0004\b%\u0010&J\u000f\u0010(\u001a\u00020'H&¢\u0006\u0004\b(\u0010)¨\u0006*"}, d2 = {"Lcom/avito/android/messenger/map/viewing/di/PlatformMapFragmentComponent$Builder;", "", "Lcom/avito/android/messenger/map/viewing/di/PlatformMapFragmentDependencies;", "dependencies", "platformMapFragmentDependencies", "(Lcom/avito/android/messenger/map/viewing/di/PlatformMapFragmentDependencies;)Lcom/avito/android/messenger/map/viewing/di/PlatformMapFragmentComponent$Builder;", "Landroid/content/res/Resources;", "resources", "withResources", "(Landroid/content/res/Resources;)Lcom/avito/android/messenger/map/viewing/di/PlatformMapFragmentComponent$Builder;", "Landroidx/fragment/app/Fragment;", "fragment", "withFragment", "(Landroidx/fragment/app/Fragment;)Lcom/avito/android/messenger/map/viewing/di/PlatformMapFragmentComponent$Builder;", "Landroid/app/Activity;", "activity", "withActivity", "(Landroid/app/Activity;)Lcom/avito/android/messenger/map/viewing/di/PlatformMapFragmentComponent$Builder;", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "withFragmentManager", "(Landroidx/fragment/app/FragmentManager;)Lcom/avito/android/messenger/map/viewing/di/PlatformMapFragmentComponent$Builder;", "Landroid/view/View;", "fragmentRootView", "withFragmentRootView", "(Landroid/view/View;)Lcom/avito/android/messenger/map/viewing/di/PlatformMapFragmentComponent$Builder;", "", "Lcom/avito/android/remote/model/messenger/geo/GeoMarker;", "initialGeoMarkers", "withInitialGeoMarkers", "([Lcom/avito/android/remote/model/messenger/geo/GeoMarker;)Lcom/avito/android/messenger/map/viewing/di/PlatformMapFragmentComponent$Builder;", "Lcom/avito/android/remote/model/messenger/geo/MarkersRequest;", "markersRequest", "withMarkersRequest", "(Lcom/avito/android/remote/model/messenger/geo/MarkersRequest;)Lcom/avito/android/messenger/map/viewing/di/PlatformMapFragmentComponent$Builder;", "", "lockBottomSheet", "withLockBottomSheet", "(Z)Lcom/avito/android/messenger/map/viewing/di/PlatformMapFragmentComponent$Builder;", "Lcom/avito/android/messenger/map/viewing/di/PlatformMapFragmentComponent;", "build", "()Lcom/avito/android/messenger/map/viewing/di/PlatformMapFragmentComponent;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        PlatformMapFragmentComponent build();

        @NotNull
        Builder platformMapFragmentDependencies(@NotNull PlatformMapFragmentDependencies platformMapFragmentDependencies);

        @BindsInstance
        @NotNull
        Builder withActivity(@NotNull Activity activity);

        @BindsInstance
        @NotNull
        Builder withFragment(@NotNull Fragment fragment);

        @BindsInstance
        @NotNull
        Builder withFragmentManager(@NotNull FragmentManager fragmentManager);

        @BindsInstance
        @NotNull
        Builder withFragmentRootView(@NotNull View view);

        @BindsInstance
        @NotNull
        Builder withInitialGeoMarkers(@NotNull GeoMarker[] geoMarkerArr);

        @BindsInstance
        @NotNull
        Builder withLockBottomSheet(boolean z);

        @BindsInstance
        @NotNull
        Builder withMarkersRequest(@Nullable MarkersRequest markersRequest);

        @BindsInstance
        @NotNull
        Builder withResources(@NotNull Resources resources);
    }

    void inject(@NotNull PlatformMapFragment platformMapFragment);
}
