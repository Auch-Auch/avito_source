package com.avito.android.di.component;

import com.avito.android.analytics.clickstream.ClickStreamSender;
import com.avito.android.di.ClickStreamSendDependencies;
import com.avito.android.di.PerService;
import com.avito.android.di.module.ClickStreamSendingModule;
import com.avito.android.remote.DeviceIdProvider;
import com.avito.android.service.short_task.clickstream.SendClickStreamEventsTask;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\rJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/avito/android/di/component/ClickStreamSendComponent;", "", "Lcom/avito/android/service/short_task/clickstream/SendClickStreamEventsTask;", "task", "", "inject", "(Lcom/avito/android/service/short_task/clickstream/SendClickStreamEventsTask;)V", "Lcom/avito/android/analytics/clickstream/ClickStreamSender;", "clickStreamSender", "()Lcom/avito/android/analytics/clickstream/ClickStreamSender;", "Lcom/avito/android/remote/DeviceIdProvider;", "deviceId", "()Lcom/avito/android/remote/DeviceIdProvider;", "Builder", "application_release"}, k = 1, mv = {1, 4, 2})
@PerService
@Component(dependencies = {ClickStreamSendDependencies.class}, modules = {ClickStreamSendingModule.class})
public interface ClickStreamSendComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/di/component/ClickStreamSendComponent$Builder;", "", "Lcom/avito/android/di/ClickStreamSendDependencies;", "dependencies", "(Lcom/avito/android/di/ClickStreamSendDependencies;)Lcom/avito/android/di/component/ClickStreamSendComponent$Builder;", "Lcom/avito/android/di/component/ClickStreamSendComponent;", "build", "()Lcom/avito/android/di/component/ClickStreamSendComponent;", "application_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        ClickStreamSendComponent build();

        @NotNull
        Builder dependencies(@NotNull ClickStreamSendDependencies clickStreamSendDependencies);
    }

    @NotNull
    ClickStreamSender clickStreamSender();

    @NotNull
    DeviceIdProvider deviceId();

    void inject(@NotNull SendClickStreamEventsTask sendClickStreamEventsTask);
}
