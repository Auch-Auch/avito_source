package com.avito.android.di.component;

import com.avito.android.analytics.provider.statsd.SendStatsdEventsTask;
import com.avito.android.di.PerService;
import com.avito.android.di.StatsdSendDependencies;
import com.avito.android.di.module.StatsdSendingModule;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/di/component/StatsdSendComponent;", "", "Lcom/avito/android/analytics/provider/statsd/SendStatsdEventsTask;", "task", "", "inject", "(Lcom/avito/android/analytics/provider/statsd/SendStatsdEventsTask;)V", "Builder", "application_release"}, k = 1, mv = {1, 4, 2})
@PerService
@Component(dependencies = {StatsdSendDependencies.class}, modules = {StatsdSendingModule.class})
public interface StatsdSendComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/di/component/StatsdSendComponent$Builder;", "", "Lcom/avito/android/di/StatsdSendDependencies;", "dependencies", "(Lcom/avito/android/di/StatsdSendDependencies;)Lcom/avito/android/di/component/StatsdSendComponent$Builder;", "Lcom/avito/android/di/component/StatsdSendComponent;", "build", "()Lcom/avito/android/di/component/StatsdSendComponent;", "application_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        StatsdSendComponent build();

        @NotNull
        Builder dependencies(@NotNull StatsdSendDependencies statsdSendDependencies);
    }

    void inject(@NotNull SendStatsdEventsTask sendStatsdEventsTask);
}
