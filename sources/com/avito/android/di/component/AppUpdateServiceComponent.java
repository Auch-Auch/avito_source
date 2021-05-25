package com.avito.android.di.component;

import com.avito.android.di.AppUpdateServiceDependencies;
import com.avito.android.di.PerService;
import com.avito.android.di.module.AppUpdateModule;
import com.avito.android.service.short_task.app_update.AppUpdateTask;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/di/component/AppUpdateServiceComponent;", "", "Lcom/avito/android/service/short_task/app_update/AppUpdateTask;", "task", "", "inject", "(Lcom/avito/android/service/short_task/app_update/AppUpdateTask;)V", "Builder", "application_release"}, k = 1, mv = {1, 4, 2})
@PerService
@Component(dependencies = {AppUpdateServiceDependencies.class}, modules = {AppUpdateModule.class})
public interface AppUpdateServiceComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/di/component/AppUpdateServiceComponent$Builder;", "", "Lcom/avito/android/di/AppUpdateServiceDependencies;", "dependencies", "(Lcom/avito/android/di/AppUpdateServiceDependencies;)Lcom/avito/android/di/component/AppUpdateServiceComponent$Builder;", "Lcom/avito/android/di/component/AppUpdateServiceComponent;", "build", "()Lcom/avito/android/di/component/AppUpdateServiceComponent;", "application_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        AppUpdateServiceComponent build();

        @NotNull
        Builder dependencies(@NotNull AppUpdateServiceDependencies appUpdateServiceDependencies);
    }

    void inject(@NotNull AppUpdateTask appUpdateTask);
}
