package com.avito.android.di.component;

import com.avito.android.di.PerService;
import com.avito.android.di.SendDataSizeDependencies;
import com.avito.android.di.module.SendDataSizeModule;
import com.avito.android.service.short_task.metrics.SendDataSizeTask;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/di/component/SendDataSizeComponent;", "", "Lcom/avito/android/service/short_task/metrics/SendDataSizeTask;", "task", "", "inject", "(Lcom/avito/android/service/short_task/metrics/SendDataSizeTask;)V", "Builder", "application_release"}, k = 1, mv = {1, 4, 2})
@PerService
@Component(dependencies = {SendDataSizeDependencies.class}, modules = {SendDataSizeModule.class})
public interface SendDataSizeComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/di/component/SendDataSizeComponent$Builder;", "", "Lcom/avito/android/di/SendDataSizeDependencies;", "dependencies", "(Lcom/avito/android/di/SendDataSizeDependencies;)Lcom/avito/android/di/component/SendDataSizeComponent$Builder;", "Lcom/avito/android/di/component/SendDataSizeComponent;", "build", "()Lcom/avito/android/di/component/SendDataSizeComponent;", "application_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        SendDataSizeComponent build();

        @NotNull
        Builder dependencies(@NotNull SendDataSizeDependencies sendDataSizeDependencies);
    }

    void inject(@NotNull SendDataSizeTask sendDataSizeTask);
}
