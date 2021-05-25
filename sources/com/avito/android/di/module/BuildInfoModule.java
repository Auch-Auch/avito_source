package com.avito.android.di.module;

import android.app.Application;
import com.avito.android.configuration.AvitoBuildInfoImpl;
import com.avito.android.util.AvitoBuildInfo;
import com.avito.android.util.BuildInfo;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/di/module/BuildInfoModule;", "", "Landroid/app/Application;", "app", "Lcom/avito/android/util/AvitoBuildInfo;", "provideAvitoBuildInfo", "(Landroid/app/Application;)Lcom/avito/android/util/AvitoBuildInfo;", "<init>", "()V", "Bindings", "avito-103.5-(1342)_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Bindings.class})
public class BuildInfoModule {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/di/module/BuildInfoModule$Bindings;", "", "Lcom/avito/android/util/AvitoBuildInfo;", "info", "Lcom/avito/android/util/BuildInfo;", "bindsBuildInfo", "(Lcom/avito/android/util/AvitoBuildInfo;)Lcom/avito/android/util/BuildInfo;", "avito-103.5-(1342)_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Bindings {
        @Reusable
        @Binds
        @NotNull
        BuildInfo bindsBuildInfo(@NotNull AvitoBuildInfo avitoBuildInfo);
    }

    @Provides
    @Reusable
    @NotNull
    public AvitoBuildInfo provideAvitoBuildInfo(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, "app");
        return new AvitoBuildInfoImpl(application);
    }
}
