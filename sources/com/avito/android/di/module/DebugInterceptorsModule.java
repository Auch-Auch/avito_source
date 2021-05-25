package com.avito.android.di.module;

import com.avito.android.util.OkHttpInjector;
import dagger.Module;
import dagger.Provides;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Qualifier;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u0001:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/avito/android/di/module/DebugInterceptorsModule;", "", "Lcom/avito/android/util/OkHttpInjector;", "provideInjector", "()Lcom/avito/android/util/OkHttpInjector;", "<init>", "()V", "Logging", "avito-release_release"}, k = 1, mv = {1, 4, 2})
@Module
public class DebugInterceptorsModule {

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/di/module/DebugInterceptorsModule$Logging;", "", "<init>", "()V", "avito-release_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.CLASS)
    public @interface Logging {
    }

    @Provides
    @Nullable
    public final OkHttpInjector provideInjector() {
        return null;
    }
}
