package com.avito.android.di.module;

import com.avito.android.TypedLazy;
import com.avito.android.app.task.ApplicationBackgroundStartupTask;
import com.avito.android.app.task.DeleteOldClickstreamStorageTask;
import com.avito.android.app.task.ScheduleAppDataSendingTask;
import com.avito.android.app.task.SendCrashRecordsToClickStreamTask;
import com.avito.android.app.task.UpdateVersionTask;
import com.avito.android.app.task.UserIdentifierAnalyticsTask;
import com.avito.android.app.task.UserKeysAnalyticsTask;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.List;
import javax.inject.Provider;
public final class AnalyticsTasksModule_ProvideBackgroundTasksFactory implements Factory<List<TypedLazy<? extends ApplicationBackgroundStartupTask>>> {
    public final Provider<SendCrashRecordsToClickStreamTask> a;
    public final Provider<DeleteOldClickstreamStorageTask> b;
    public final Provider<UpdateVersionTask> c;
    public final Provider<UserKeysAnalyticsTask> d;
    public final Provider<UserIdentifierAnalyticsTask> e;
    public final Provider<ScheduleAppDataSendingTask> f;

    public AnalyticsTasksModule_ProvideBackgroundTasksFactory(Provider<SendCrashRecordsToClickStreamTask> provider, Provider<DeleteOldClickstreamStorageTask> provider2, Provider<UpdateVersionTask> provider3, Provider<UserKeysAnalyticsTask> provider4, Provider<UserIdentifierAnalyticsTask> provider5, Provider<ScheduleAppDataSendingTask> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static AnalyticsTasksModule_ProvideBackgroundTasksFactory create(Provider<SendCrashRecordsToClickStreamTask> provider, Provider<DeleteOldClickstreamStorageTask> provider2, Provider<UpdateVersionTask> provider3, Provider<UserKeysAnalyticsTask> provider4, Provider<UserIdentifierAnalyticsTask> provider5, Provider<ScheduleAppDataSendingTask> provider6) {
        return new AnalyticsTasksModule_ProvideBackgroundTasksFactory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static List<TypedLazy<? extends ApplicationBackgroundStartupTask>> provideBackgroundTasks(Lazy<SendCrashRecordsToClickStreamTask> lazy, Lazy<DeleteOldClickstreamStorageTask> lazy2, Lazy<UpdateVersionTask> lazy3, Lazy<UserKeysAnalyticsTask> lazy4, Lazy<UserIdentifierAnalyticsTask> lazy5, Lazy<ScheduleAppDataSendingTask> lazy6) {
        return (List) Preconditions.checkNotNullFromProvides(AnalyticsTasksModule.INSTANCE.provideBackgroundTasks(lazy, lazy2, lazy3, lazy4, lazy5, lazy6));
    }

    @Override // javax.inject.Provider
    public List<TypedLazy<? extends ApplicationBackgroundStartupTask>> get() {
        return provideBackgroundTasks(DoubleCheck.lazy(this.a), DoubleCheck.lazy(this.b), DoubleCheck.lazy(this.c), DoubleCheck.lazy(this.d), DoubleCheck.lazy(this.e), DoubleCheck.lazy(this.f));
    }
}
