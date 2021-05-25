package com.avito.android.analytics.di;

import com.avito.android.analytics.ClickStreamDeepLinkActivity;
import com.avito.android.di.PerActivity;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/analytics/di/ClickStreamDeepLinkingComponent;", "", "Lcom/avito/android/analytics/ClickStreamDeepLinkActivity;", "activity", "", "inject", "(Lcom/avito/android/analytics/ClickStreamDeepLinkActivity;)V", "Factory", "deep-linking_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {ClickStreamDeepLinkingDependencies.class}, modules = {ClickStreamDeepLinkingModule.class})
@PerActivity
public interface ClickStreamDeepLinkingComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/analytics/di/ClickStreamDeepLinkingComponent$Factory;", "", "Lcom/avito/android/analytics/di/ClickStreamDeepLinkingDependencies;", "dependencies", "Lcom/avito/android/analytics/di/ClickStreamDeepLinkingComponent;", "create", "(Lcom/avito/android/analytics/di/ClickStreamDeepLinkingDependencies;)Lcom/avito/android/analytics/di/ClickStreamDeepLinkingComponent;", "deep-linking_release"}, k = 1, mv = {1, 4, 2})
    @Component.Factory
    public interface Factory {
        @NotNull
        ClickStreamDeepLinkingComponent create(@NotNull ClickStreamDeepLinkingDependencies clickStreamDeepLinkingDependencies);
    }

    void inject(@NotNull ClickStreamDeepLinkActivity clickStreamDeepLinkActivity);
}
