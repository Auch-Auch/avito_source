package com.avito.android.di.component;

import com.avito.android.di.PerService;
import com.avito.android.di.SendMetricsServiceDependencies;
import com.avito.android.di.module.GooglePlayServicesInfoModule;
import com.avito.android.di.module.SendMetricsModule;
import com.avito.android.service.short_task.metrics.SendMetricTask;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/di/component/SendMetricsServiceComponent;", "", "Lcom/avito/android/service/short_task/metrics/SendMetricTask;", "task", "", "inject", "(Lcom/avito/android/service/short_task/metrics/SendMetricTask;)V", "Builder", "application_release"}, k = 1, mv = {1, 4, 2})
@PerService
@Component(dependencies = {SendMetricsServiceDependencies.class}, modules = {SendMetricsModule.class, GooglePlayServicesInfoModule.class})
public interface SendMetricsServiceComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/di/component/SendMetricsServiceComponent$Builder;", "", "Lcom/avito/android/di/SendMetricsServiceDependencies;", "dependencies", "(Lcom/avito/android/di/SendMetricsServiceDependencies;)Lcom/avito/android/di/component/SendMetricsServiceComponent$Builder;", "Lcom/avito/android/di/component/SendMetricsServiceComponent;", "build", "()Lcom/avito/android/di/component/SendMetricsServiceComponent;", "application_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        SendMetricsServiceComponent build();

        @NotNull
        Builder dependencies(@NotNull SendMetricsServiceDependencies sendMetricsServiceDependencies);
    }

    void inject(@NotNull SendMetricTask sendMetricTask);
}
