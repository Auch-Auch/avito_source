package com.avito.android.in_app_calls.di;

import com.avito.android.in_app_calls.logging.SendCallLogsWorker;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Component(dependencies = {SendCallLogsDependencies.class})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/in_app_calls/di/SendCallLogsComponent;", "", "Lcom/avito/android/in_app_calls/logging/SendCallLogsWorker;", "worker", "", "inject", "(Lcom/avito/android/in_app_calls/logging/SendCallLogsWorker;)V", "Factory", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public interface SendCallLogsComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/in_app_calls/di/SendCallLogsComponent$Factory;", "", "Lcom/avito/android/in_app_calls/di/SendCallLogsDependencies;", "dependencies", "Lcom/avito/android/in_app_calls/di/SendCallLogsComponent;", "create", "(Lcom/avito/android/in_app_calls/di/SendCallLogsDependencies;)Lcom/avito/android/in_app_calls/di/SendCallLogsComponent;", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    @Component.Factory
    public interface Factory {
        @NotNull
        SendCallLogsComponent create(@NotNull SendCallLogsDependencies sendCallLogsDependencies);
    }

    void inject(@NotNull SendCallLogsWorker sendCallLogsWorker);
}
