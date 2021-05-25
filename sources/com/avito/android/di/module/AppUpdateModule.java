package com.avito.android.di.module;

import com.avito.android.di.PerService;
import com.avito.android.service.short_task.app_update.AppUpdateInteractor;
import com.avito.android.service.short_task.app_update.AppUpdateInteractorImpl;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/di/module/AppUpdateModule;", "", "Lcom/avito/android/service/short_task/app_update/AppUpdateInteractorImpl;", "interactor", "Lcom/avito/android/service/short_task/app_update/AppUpdateInteractor;", "bindsAppUpdateInteractor", "(Lcom/avito/android/service/short_task/app_update/AppUpdateInteractorImpl;)Lcom/avito/android/service/short_task/app_update/AppUpdateInteractor;", "<init>", "()V", "application_release"}, k = 1, mv = {1, 4, 2})
@Module
public abstract class AppUpdateModule {
    @PerService
    @Binds
    @NotNull
    public abstract AppUpdateInteractor bindsAppUpdateInteractor(@NotNull AppUpdateInteractorImpl appUpdateInteractorImpl);
}
