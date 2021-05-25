package com.avito.android.di.module;

import com.avito.android.TypedLazy;
import com.avito.android.app.task.ApplicationBackgroundStartupTask;
import com.avito.android.app.task.SerpDbDeleteTask;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.d;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ+\u0010\b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u00060\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/avito/android/di/module/SerpTasksModule;", "", "Ldagger/Lazy;", "Lcom/avito/android/app/task/SerpDbDeleteTask;", "serpDbDeleteTask", "", "Lcom/avito/android/TypedLazy;", "Lcom/avito/android/app/task/ApplicationBackgroundStartupTask;", "provideBackgroundTasks", "(Ldagger/Lazy;)Ljava/util/List;", "<init>", "()V", "serp_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class SerpTasksModule {
    @NotNull
    public static final SerpTasksModule INSTANCE = new SerpTasksModule();

    @Provides
    @SerpTasks
    @NotNull
    public final List<TypedLazy<? extends ApplicationBackgroundStartupTask>> provideBackgroundTasks(@NotNull Lazy<SerpDbDeleteTask> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "serpDbDeleteTask");
        return d.listOf(new TypedLazy(SerpDbDeleteTask.class, lazy));
    }
}
