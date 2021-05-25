package com.avito.android.di;

import com.avito.android.server_time.TimeSource;
import com.avito.android.service.short_task.TimeDiffAnalyticsInterceptor;
import com.google.gson.Gson;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/di/CheckRequestModule;", "", "Lcom/google/gson/Gson;", "gson", "Lcom/avito/android/service/short_task/TimeDiffAnalyticsInterceptor;", "provideTimeDiffAnalyticsInterceptor", "(Lcom/google/gson/Gson;)Lcom/avito/android/service/short_task/TimeDiffAnalyticsInterceptor;", "<init>", "()V", "application_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class CheckRequestModule {
    @NotNull
    public static final CheckRequestModule INSTANCE = new CheckRequestModule();

    @Provides
    @JvmStatic
    @NotNull
    @PerService
    public static final TimeDiffAnalyticsInterceptor provideTimeDiffAnalyticsInterceptor(@NotNull Gson gson) {
        Intrinsics.checkNotNullParameter(gson, "gson");
        return new TimeDiffAnalyticsInterceptor(TimeSource.DEFAULT, gson);
    }
}
