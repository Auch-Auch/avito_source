package com.avito.android.deep_linking.di;

import com.avito.android.deep_linking.DeepLinkingActivity;
import com.avito.android.deep_linking.DeepLinkingRouter;
import com.avito.android.di.PerActivity;
import com.avito.android.location.di.LocationDependencies;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/deep_linking/di/DeepLinkingComponent;", "", "Lcom/avito/android/deep_linking/DeepLinkingActivity;", "activity", "", "inject", "(Lcom/avito/android/deep_linking/DeepLinkingActivity;)V", "Builder", "deep-linking_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {DeepLinkingDependencies.class, LocationDependencies.class}, modules = {DeepLinkingModule.class})
@PerActivity
public interface DeepLinkingComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tH'¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/deep_linking/di/DeepLinkingComponent$Builder;", "", "Lcom/avito/android/deep_linking/di/DeepLinkingDependencies;", "dependencies", "deepLinkDependencies", "(Lcom/avito/android/deep_linking/di/DeepLinkingDependencies;)Lcom/avito/android/deep_linking/di/DeepLinkingComponent$Builder;", "Lcom/avito/android/location/di/LocationDependencies;", "locationDependencies", "(Lcom/avito/android/location/di/LocationDependencies;)Lcom/avito/android/deep_linking/di/DeepLinkingComponent$Builder;", "Lcom/avito/android/deep_linking/DeepLinkingRouter;", "router", "withRouter", "(Lcom/avito/android/deep_linking/DeepLinkingRouter;)Lcom/avito/android/deep_linking/di/DeepLinkingComponent$Builder;", "Lcom/avito/android/deep_linking/di/DeepLinkingComponent;", "build", "()Lcom/avito/android/deep_linking/di/DeepLinkingComponent;", "deep-linking_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        DeepLinkingComponent build();

        @NotNull
        Builder deepLinkDependencies(@NotNull DeepLinkingDependencies deepLinkingDependencies);

        @NotNull
        Builder locationDependencies(@NotNull LocationDependencies locationDependencies);

        @BindsInstance
        @NotNull
        Builder withRouter(@NotNull DeepLinkingRouter deepLinkingRouter);
    }

    void inject(@NotNull DeepLinkingActivity deepLinkingActivity);
}
