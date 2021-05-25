package com.avito.android.advert_core.di.module;

import com.avito.android.TypedLazy;
import com.avito.android.advert_core.task.FirstTimeRunTask;
import com.avito.android.app.task.ApplicationBackgroundStartupTask;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import javax.inject.Qualifier;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.d;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\fB\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ+\u0010\b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u00060\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/advert_core/di/module/AdvertCoreTasksModule;", "", "Ldagger/Lazy;", "Lcom/avito/android/advert_core/task/FirstTimeRunTask;", "firstTimeRunTask", "", "Lcom/avito/android/TypedLazy;", "Lcom/avito/android/app/task/ApplicationBackgroundStartupTask;", "provideBackgroundTasks", "(Ldagger/Lazy;)Ljava/util/List;", "<init>", "()V", "AdvertCoreTasks", "advert-core_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class AdvertCoreTasksModule {
    @NotNull
    public static final AdvertCoreTasksModule INSTANCE = new AdvertCoreTasksModule();

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/advert_core/di/module/AdvertCoreTasksModule$AdvertCoreTasks;", "", "<init>", "()V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.CLASS)
    @kotlin.annotation.Retention(AnnotationRetention.BINARY)
    public @interface AdvertCoreTasks {
    }

    @AdvertCoreTasks
    @Provides
    @NotNull
    public final List<TypedLazy<? extends ApplicationBackgroundStartupTask>> provideBackgroundTasks(@NotNull Lazy<FirstTimeRunTask> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "firstTimeRunTask");
        return d.listOf(new TypedLazy(FirstTimeRunTask.class, lazy));
    }
}
