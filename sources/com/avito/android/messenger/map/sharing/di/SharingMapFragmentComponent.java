package com.avito.android.messenger.map.sharing.di;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import com.avito.android.messenger.map.sharing.SharingMapFragment;
import com.avito.android.messenger.map.sharing.SharingMapView;
import dagger.BindsInstance;
import dagger.Component;
import javax.inject.Named;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Component(dependencies = {SharingMapFragmentDependencies.class}, modules = {SharingMapFragmentModule.class})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/messenger/map/sharing/di/SharingMapFragmentComponent;", "", "Lcom/avito/android/messenger/map/sharing/SharingMapFragment;", "fragment", "", "inject", "(Lcom/avito/android/messenger/map/sharing/SharingMapFragment;)V", "Builder", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface SharingMapFragmentComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H'¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\bH'¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\f\u001a\u00020\u00002\b\b\u0001\u0010\f\u001a\u00020\u000bH'¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000e\u001a\u00020\u00002\b\b\u0001\u0010\u000e\u001a\u00020\u000bH'¢\u0006\u0004\b\u000e\u0010\rJ\u0019\u0010\u0010\u001a\u00020\u00002\b\b\u0001\u0010\u0010\u001a\u00020\u000fH'¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0012\u001a\u00020\u00002\b\b\u0001\u0010\u0012\u001a\u00020\u000fH'¢\u0006\u0004\b\u0012\u0010\u0011J\u0019\u0010\u0013\u001a\u00020\u00002\b\b\u0001\u0010\u0013\u001a\u00020\u000fH'¢\u0006\u0004\b\u0013\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH&¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/avito/android/messenger/map/sharing/di/SharingMapFragmentComponent$Builder;", "", "Lcom/avito/android/messenger/map/sharing/SharingMapFragment;", "fragment", "(Lcom/avito/android/messenger/map/sharing/SharingMapFragment;)Lcom/avito/android/messenger/map/sharing/di/SharingMapFragmentComponent$Builder;", "Landroid/app/Activity;", "activity", "(Landroid/app/Activity;)Lcom/avito/android/messenger/map/sharing/di/SharingMapFragmentComponent$Builder;", "Landroidx/fragment/app/Fragment;", "withFragment", "(Landroidx/fragment/app/Fragment;)Lcom/avito/android/messenger/map/sharing/di/SharingMapFragmentComponent$Builder;", "Lcom/avito/android/messenger/map/sharing/SharingMapView$State;", "sharingMapDefaultViewState", "(Lcom/avito/android/messenger/map/sharing/SharingMapView$State;)Lcom/avito/android/messenger/map/sharing/di/SharingMapFragmentComponent$Builder;", "sharingMapInitialViewState", "", SharingMapFragmentModule.ADDRESS_NOT_FOUND_TITLE, "(Ljava/lang/String;)Lcom/avito/android/messenger/map/sharing/di/SharingMapFragmentComponent$Builder;", SharingMapFragmentModule.ADDRESS_NOT_FOUND_ERROR_MESSAGE, SharingMapFragmentModule.RETRY_LABEL, "Lcom/avito/android/messenger/map/sharing/di/SharingMapFragmentDependencies;", "sharingMapFragmentDependencies", "(Lcom/avito/android/messenger/map/sharing/di/SharingMapFragmentDependencies;)Lcom/avito/android/messenger/map/sharing/di/SharingMapFragmentComponent$Builder;", "Lcom/avito/android/messenger/map/sharing/di/SharingMapFragmentModule;", "sharingMapFragmentModule", "(Lcom/avito/android/messenger/map/sharing/di/SharingMapFragmentModule;)Lcom/avito/android/messenger/map/sharing/di/SharingMapFragmentComponent$Builder;", "Lcom/avito/android/messenger/map/sharing/di/SharingMapFragmentComponent;", "build", "()Lcom/avito/android/messenger/map/sharing/di/SharingMapFragmentComponent;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @BindsInstance
        @NotNull
        Builder activity(@NotNull Activity activity);

        @BindsInstance
        @NotNull
        Builder addressNotFoundErrorMessage(@Named("addressNotFoundErrorMessage") @NotNull String str);

        @BindsInstance
        @NotNull
        Builder addressNotFoundTitle(@Named("addressNotFoundTitle") @NotNull String str);

        @NotNull
        SharingMapFragmentComponent build();

        @BindsInstance
        @NotNull
        Builder fragment(@NotNull SharingMapFragment sharingMapFragment);

        @BindsInstance
        @NotNull
        Builder retryLabel(@Named("retryLabel") @NotNull String str);

        @BindsInstance
        @NotNull
        Builder sharingMapDefaultViewState(@Named("default") @NotNull SharingMapView.State state);

        @NotNull
        Builder sharingMapFragmentDependencies(@NotNull SharingMapFragmentDependencies sharingMapFragmentDependencies);

        @NotNull
        Builder sharingMapFragmentModule(@NotNull SharingMapFragmentModule sharingMapFragmentModule);

        @BindsInstance
        @NotNull
        Builder sharingMapInitialViewState(@Named("initial") @NotNull SharingMapView.State state);

        @BindsInstance
        @NotNull
        Builder withFragment(@NotNull Fragment fragment);
    }

    void inject(@NotNull SharingMapFragment sharingMapFragment);
}
