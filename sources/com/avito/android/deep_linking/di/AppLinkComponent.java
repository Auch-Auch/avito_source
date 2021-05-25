package com.avito.android.deep_linking.di;

import com.avito.android.deep_linking.AppLinkActivity;
import com.avito.android.di.PerActivity;
import com.avito.android.location.di.LocationDependencies;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/deep_linking/di/AppLinkComponent;", "", "Lcom/avito/android/deep_linking/AppLinkActivity;", "activity", "", "inject", "(Lcom/avito/android/deep_linking/AppLinkActivity;)V", "Builder", "deep-linking_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {AppLinkDependencies.class, LocationDependencies.class}, modules = {AppLinkModule.class})
@PerActivity
public interface AppLinkComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/deep_linking/di/AppLinkComponent$Builder;", "", "Lcom/avito/android/deep_linking/di/AppLinkDependencies;", "dependencies", "(Lcom/avito/android/deep_linking/di/AppLinkDependencies;)Lcom/avito/android/deep_linking/di/AppLinkComponent$Builder;", "Lcom/avito/android/location/di/LocationDependencies;", "locationDependencies", "(Lcom/avito/android/location/di/LocationDependencies;)Lcom/avito/android/deep_linking/di/AppLinkComponent$Builder;", "Lcom/avito/android/deep_linking/di/AppLinkComponent;", "build", "()Lcom/avito/android/deep_linking/di/AppLinkComponent;", "deep-linking_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        AppLinkComponent build();

        @NotNull
        Builder dependencies(@NotNull AppLinkDependencies appLinkDependencies);

        @NotNull
        Builder locationDependencies(@NotNull LocationDependencies locationDependencies);
    }

    void inject(@NotNull AppLinkActivity appLinkActivity);
}
