package com.avito.android.location_list.di;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import com.avito.android.di.PerFragment;
import com.avito.android.location_list.LocationListFragment;
import com.avito.android.ui.ActivityInteractor;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/location_list/di/LocationListComponent;", "", "Lcom/avito/android/location_list/LocationListFragment;", "locationListFragment", "", "inject", "(Lcom/avito/android/location_list/LocationListFragment;)V", "Builder", "location-list_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {LocationListDependencies.class}, modules = {LocationListModule.class})
@PerFragment
public interface LocationListComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tH'¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\rH'¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0011H'¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/avito/android/location_list/di/LocationListComponent$Builder;", "", "Lcom/avito/android/location_list/di/LocationListDependencies;", "dependencies", "dependentOn", "(Lcom/avito/android/location_list/di/LocationListDependencies;)Lcom/avito/android/location_list/di/LocationListComponent$Builder;", "Lcom/avito/android/location_list/di/LocationListModule;", "locationListModule", "(Lcom/avito/android/location_list/di/LocationListModule;)Lcom/avito/android/location_list/di/LocationListComponent$Builder;", "Landroid/app/Activity;", "activity", "withActivity", "(Landroid/app/Activity;)Lcom/avito/android/location_list/di/LocationListComponent$Builder;", "Landroidx/fragment/app/Fragment;", "fragment", "withFragment", "(Landroidx/fragment/app/Fragment;)Lcom/avito/android/location_list/di/LocationListComponent$Builder;", "Lcom/avito/android/ui/ActivityInteractor;", "activityInteractor", "withActivityInteractor", "(Lcom/avito/android/ui/ActivityInteractor;)Lcom/avito/android/location_list/di/LocationListComponent$Builder;", "Lcom/avito/android/location_list/di/LocationListComponent;", "build", "()Lcom/avito/android/location_list/di/LocationListComponent;", "location-list_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        LocationListComponent build();

        @NotNull
        Builder dependentOn(@NotNull LocationListDependencies locationListDependencies);

        @NotNull
        Builder locationListModule(@NotNull LocationListModule locationListModule);

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

    void inject(@NotNull LocationListFragment locationListFragment);
}
