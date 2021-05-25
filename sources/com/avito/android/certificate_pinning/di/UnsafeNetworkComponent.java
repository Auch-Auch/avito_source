package com.avito.android.certificate_pinning.di;

import com.avito.android.certificate_pinning.UnsafeNetworkActivity;
import com.avito.android.di.PerActivity;
import com.avito.android.util.Kundle;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/certificate_pinning/di/UnsafeNetworkComponent;", "", "Lcom/avito/android/certificate_pinning/UnsafeNetworkActivity;", "activity", "", "inject", "(Lcom/avito/android/certificate_pinning/UnsafeNetworkActivity;)V", "Builder", "unsafe-network_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {UnsafeNetworkDependencies.class}, modules = {UnsafeNetworkModule.class})
@PerActivity
public interface UnsafeNetworkComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\b\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H'¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nH'¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/certificate_pinning/di/UnsafeNetworkComponent$Builder;", "", "Lcom/avito/android/certificate_pinning/di/UnsafeNetworkDependencies;", "dependencies", "dependentOn", "(Lcom/avito/android/certificate_pinning/di/UnsafeNetworkDependencies;)Lcom/avito/android/certificate_pinning/di/UnsafeNetworkComponent$Builder;", "Lcom/avito/android/util/Kundle;", "state", "withPresenterState", "(Lcom/avito/android/util/Kundle;)Lcom/avito/android/certificate_pinning/di/UnsafeNetworkComponent$Builder;", "", "showErrorScreen", "withShowErrorScreen", "(Z)Lcom/avito/android/certificate_pinning/di/UnsafeNetworkComponent$Builder;", "Lcom/avito/android/certificate_pinning/di/UnsafeNetworkComponent;", "build", "()Lcom/avito/android/certificate_pinning/di/UnsafeNetworkComponent;", "unsafe-network_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        UnsafeNetworkComponent build();

        @NotNull
        Builder dependentOn(@NotNull UnsafeNetworkDependencies unsafeNetworkDependencies);

        @BindsInstance
        @NotNull
        Builder withPresenterState(@Nullable Kundle kundle);

        @BindsInstance
        @NotNull
        Builder withShowErrorScreen(boolean z);
    }

    void inject(@NotNull UnsafeNetworkActivity unsafeNetworkActivity);
}
