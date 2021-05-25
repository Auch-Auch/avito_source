package com.avito.android.publish.di;

import com.avito.android.publish.analytics.PublishEventTracker;
import com.avito.android.publish.analytics.PublishEventTrackerImpl;
import com.avito.android.publish.drafts.di.AnalyticsParametersSerializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/avito/android/publish/di/PublishAnalyticModule;", "", "Lcom/google/gson/Gson;", "provideAnalyticsSerializer", "()Lcom/google/gson/Gson;", "<init>", "()V", "Declarations", "publish_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class PublishAnalyticModule {
    @NotNull
    public static final PublishAnalyticModule INSTANCE = new PublishAnalyticModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/publish/di/PublishAnalyticModule$Declarations;", "", "Lcom/avito/android/publish/analytics/PublishEventTrackerImpl;", "eventTrackerImpl", "Lcom/avito/android/publish/analytics/PublishEventTracker;", "providePublishEventTracker", "(Lcom/avito/android/publish/analytics/PublishEventTrackerImpl;)Lcom/avito/android/publish/analytics/PublishEventTracker;", "publish_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Binds
        @NotNull
        PublishEventTracker providePublishEventTracker(@NotNull PublishEventTrackerImpl publishEventTrackerImpl);
    }

    @AnalyticsParametersSerializer
    @Provides
    @JvmStatic
    @NotNull
    public static final Gson provideAnalyticsSerializer() {
        Gson create = new GsonBuilder().create();
        Intrinsics.checkNotNullExpressionValue(create, "GsonBuilder().create()");
        return create;
    }
}
