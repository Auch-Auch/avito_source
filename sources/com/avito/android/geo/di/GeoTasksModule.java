package com.avito.android.geo.di;

import com.avito.android.app.task.ApplicationBlockingStartupTask;
import com.avito.android.app.task.RegisterGeoPositionCheckingCallbacksTask;
import com.avito.android.version_conflict.di.module.PersistenceVersionConflictModule;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoSet;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/geo/di/GeoTasksModule;", "", "Lcom/avito/android/app/task/RegisterGeoPositionCheckingCallbacksTask;", "task", "Lcom/avito/android/app/task/ApplicationBlockingStartupTask;", "bindGeoPositionTask", "(Lcom/avito/android/app/task/RegisterGeoPositionCheckingCallbacksTask;)Lcom/avito/android/app/task/ApplicationBlockingStartupTask;", "geo_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {PersistenceVersionConflictModule.class})
public interface GeoTasksModule {
    @Binds
    @IntoSet
    @NotNull
    ApplicationBlockingStartupTask bindGeoPositionTask(@NotNull RegisterGeoPositionCheckingCallbacksTask registerGeoPositionCheckingCallbacksTask);
}
