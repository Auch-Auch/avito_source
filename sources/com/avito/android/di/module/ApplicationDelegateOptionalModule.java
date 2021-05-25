package com.avito.android.di.module;

import com.avito.android.Features;
import com.avito.android.app.task.ApplicationBlockingStartupTask;
import com.avito.android.app.task.InitTimberLoggerTask;
import dagger.Module;
import dagger.Provides;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import javax.inject.Qualifier;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.d;
import timber.log.Timber;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/di/module/ApplicationDelegateOptionalModule;", "", "Lcom/avito/android/app/task/InitTimberLoggerTask;", "initTimberLoggerTask", "", "Lcom/avito/android/app/task/ApplicationBlockingStartupTask;", "provideDebugTasks$avito_release_release", "(Lcom/avito/android/app/task/InitTimberLoggerTask;)Ljava/util/List;", "provideDebugTasks", "Ltimber/log/Timber$Tree;", "bufferingTree", "Lcom/avito/android/Features;", "features", "provideInitTimberLoggerTask", "(Ltimber/log/Timber$Tree;Lcom/avito/android/Features;)Lcom/avito/android/app/task/InitTimberLoggerTask;", "<init>", "()V", "OptionalTasks", "avito-release_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class ApplicationDelegateOptionalModule {

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/di/module/ApplicationDelegateOptionalModule$OptionalTasks;", "", "<init>", "()V", "avito-release_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.CLASS)
    public @interface OptionalTasks {
    }

    @Provides
    @NotNull
    @OptionalTasks
    public final List<ApplicationBlockingStartupTask> provideDebugTasks$avito_release_release(@NotNull InitTimberLoggerTask initTimberLoggerTask) {
        Intrinsics.checkNotNullParameter(initTimberLoggerTask, "initTimberLoggerTask");
        return d.listOf(initTimberLoggerTask);
    }

    @Provides
    @NotNull
    public final InitTimberLoggerTask provideInitTimberLoggerTask(@NotNull Timber.Tree tree, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(tree, "bufferingTree");
        Intrinsics.checkNotNullParameter(features, "features");
        return new InitTimberLoggerTask(tree, features);
    }
}
