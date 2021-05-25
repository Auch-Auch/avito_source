package com.avito.android.app.task;

import android.app.Application;
import com.avito.android.Features;
import com.avito.android.analytics.screens.Timer;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.task.StartupAnalyticsTracker;
import com.avito.android.analytics.task.StartupAnalyticsTrackerKt;
import com.avito.android.app.task.ApplicationBlockingStartupTask;
import com.avito.android.app.task.ApplicationStartupTask;
import com.avito.android.connection_quality.BandwidthSamplerRequestListener;
import com.avito.android.image_loader.fresco.FrescoLoggingListener;
import com.avito.android.image_loader.fresco.FrescoMemoryTrimmableRegistry;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.ForegroundStatusCallbacks;
import com.facebook.drawee.backends.pipeline.DraweeConfig;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.backends.okhttp3.OkHttpNetworkFetcher;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.listener.RequestListener;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.y;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/avito/android/app/task/InitFrescoTask;", "Lcom/avito/android/app/task/ApplicationBlockingStartupTask;", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "Lcom/avito/android/app/task/ApplicationStartupTask$ExecutionResult;", "execute", "(Landroid/app/Application;)Lcom/avito/android/app/task/ApplicationStartupTask$ExecutionResult;", "Lcom/facebook/imagepipeline/backends/okhttp3/OkHttpNetworkFetcher;", "networkFetcher", "Lcom/facebook/imagepipeline/backends/okhttp3/OkHttpNetworkFetcher;", "Lcom/avito/android/util/ForegroundStatusCallbacks;", "foregroundStatusCallbacks", "Lcom/avito/android/util/ForegroundStatusCallbacks;", "Lcom/avito/android/analytics/task/StartupAnalyticsTracker;", "tracker", "Lcom/avito/android/analytics/task/StartupAnalyticsTracker;", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/Features;", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "Lcom/avito/android/util/BuildInfo;", "Lcom/avito/android/connection_quality/BandwidthSamplerRequestListener;", "samplerRequestListener", "Lcom/avito/android/connection_quality/BandwidthSamplerRequestListener;", "Lcom/avito/android/image_loader/fresco/FrescoMemoryTrimmableRegistry;", "memoryRegistry", "Lcom/avito/android/image_loader/fresco/FrescoMemoryTrimmableRegistry;", "<init>", "(Lcom/avito/android/util/BuildInfo;Lcom/avito/android/connection_quality/BandwidthSamplerRequestListener;Lcom/avito/android/image_loader/fresco/FrescoMemoryTrimmableRegistry;Lcom/avito/android/util/ForegroundStatusCallbacks;Lcom/facebook/imagepipeline/backends/okhttp3/OkHttpNetworkFetcher;Lcom/avito/android/Features;Lcom/avito/android/analytics/task/StartupAnalyticsTracker;)V", "application_release"}, k = 1, mv = {1, 4, 2})
public final class InitFrescoTask implements ApplicationBlockingStartupTask {
    public final BuildInfo buildInfo;
    public final Features features;
    public final ForegroundStatusCallbacks foregroundStatusCallbacks;
    public final FrescoMemoryTrimmableRegistry memoryRegistry;
    public final OkHttpNetworkFetcher networkFetcher;
    public final BandwidthSamplerRequestListener samplerRequestListener;
    public final StartupAnalyticsTracker tracker;

    public InitFrescoTask(@NotNull BuildInfo buildInfo2, @NotNull BandwidthSamplerRequestListener bandwidthSamplerRequestListener, @NotNull FrescoMemoryTrimmableRegistry frescoMemoryTrimmableRegistry, @NotNull ForegroundStatusCallbacks foregroundStatusCallbacks2, @NotNull OkHttpNetworkFetcher okHttpNetworkFetcher, @NotNull Features features2, @NotNull StartupAnalyticsTracker startupAnalyticsTracker) {
        Intrinsics.checkNotNullParameter(buildInfo2, "buildInfo");
        Intrinsics.checkNotNullParameter(bandwidthSamplerRequestListener, "samplerRequestListener");
        Intrinsics.checkNotNullParameter(frescoMemoryTrimmableRegistry, "memoryRegistry");
        Intrinsics.checkNotNullParameter(foregroundStatusCallbacks2, "foregroundStatusCallbacks");
        Intrinsics.checkNotNullParameter(okHttpNetworkFetcher, "networkFetcher");
        Intrinsics.checkNotNullParameter(features2, "features");
        Intrinsics.checkNotNullParameter(startupAnalyticsTracker, "tracker");
        this.buildInfo = buildInfo2;
        this.samplerRequestListener = bandwidthSamplerRequestListener;
        this.memoryRegistry = frescoMemoryTrimmableRegistry;
        this.foregroundStatusCallbacks = foregroundStatusCallbacks2;
        this.networkFetcher = okHttpNetworkFetcher;
        this.features = features2;
        this.tracker = startupAnalyticsTracker;
    }

    @Override // com.avito.android.app.task.ApplicationBlockingStartupTask
    @NotNull
    public ApplicationStartupTask.ExecutionResult execute(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        Timer timer = new TimerFactory().timer();
        timer.start();
        this.foregroundStatusCallbacks.setListener(this.memoryRegistry);
        application.registerActivityLifecycleCallbacks(this.foregroundStatusCallbacks);
        application.registerComponentCallbacks(this.memoryRegistry);
        ImagePipelineConfig.Builder newBuilder = ImagePipelineConfig.newBuilder(application);
        newBuilder.setNetworkFetcher(this.networkFetcher);
        newBuilder.setMemoryTrimmableRegistry(this.memoryRegistry);
        Set<RequestListener> mutableSetOf = y.mutableSetOf(this.samplerRequestListener);
        if (this.buildInfo.isDebug()) {
            mutableSetOf.add(new FrescoLoggingListener());
        }
        newBuilder.setRequestListeners(mutableSetOf);
        newBuilder.setDownsampleEnabled(true);
        ImagePipelineConfig build = newBuilder.build();
        DraweeConfig build2 = this.features.getFrescoDebugOverlayEnabled().invoke().booleanValue() ? DraweeConfig.newBuilder().setDrawDebugOverlay(true).build() : null;
        this.tracker.track(StartupAnalyticsTrackerKt.FRESCO_PREPARE, timer.elapsed());
        Timer timer2 = new TimerFactory().timer();
        timer2.start();
        Fresco.initialize(application, build, build2);
        this.tracker.track(StartupAnalyticsTrackerKt.FRESCO_INIT, timer2.elapsed());
        return ApplicationStartupTask.ExecutionResult.Success.INSTANCE;
    }

    @Override // com.avito.android.app.task.ApplicationBlockingStartupTask
    @NotNull
    public ApplicationBlockingStartupTask.Priority getPriority() {
        return ApplicationBlockingStartupTask.DefaultImpls.getPriority(this);
    }
}
