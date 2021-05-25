package com.avito.android.in_app_calls.workers;

import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Component(dependencies = {CallAvailabilityComponentDependencies.class})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/in_app_calls/workers/CallAvailabilityComponent;", "", "Lcom/avito/android/in_app_calls/workers/CallAvailabilityWorker;", "worker", "", "inject", "(Lcom/avito/android/in_app_calls/workers/CallAvailabilityWorker;)V", "Factory", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
public interface CallAvailabilityComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/in_app_calls/workers/CallAvailabilityComponent$Factory;", "", "Lcom/avito/android/in_app_calls/workers/CallAvailabilityComponentDependencies;", "dependencies", "Lcom/avito/android/in_app_calls/workers/CallAvailabilityComponent;", "create", "(Lcom/avito/android/in_app_calls/workers/CallAvailabilityComponentDependencies;)Lcom/avito/android/in_app_calls/workers/CallAvailabilityComponent;", "in-app-calls_release"}, k = 1, mv = {1, 4, 2})
    @Component.Factory
    public interface Factory {
        @NotNull
        CallAvailabilityComponent create(@NotNull CallAvailabilityComponentDependencies callAvailabilityComponentDependencies);
    }

    void inject(@NotNull CallAvailabilityWorker callAvailabilityWorker);
}
