package com.avito.android.enabler;

import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.statsd.StatsdEvent;
import com.avito.android.lib.design.input.FormatterType;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.SchedulersFactory;
import com.yandex.mobile.ads.video.tracking.Tracker;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010\u0005\u001a\u00020\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\u0007\u001a\u00020\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\r\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/avito/android/enabler/RemoteFeaturesTouchMonitor;", "", "Lcom/avito/android/enabler/RemoteFeature;", "feature", "", "reportTouchedFeatureValue", "(Lcom/avito/android/enabler/RemoteFeature;)V", "reportTouchedFeatureCacheState", Tracker.Events.CREATIVE_START, "()V", "Lcom/avito/android/enabler/AnalyticFeatures;", "analyticFeatures", "Lcom/avito/android/enabler/AnalyticFeatures;", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "Lcom/avito/android/util/BuildInfo;", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/util/SchedulersFactory;", "Lio/reactivex/disposables/CompositeDisposable;", "disposable", "Lio/reactivex/disposables/CompositeDisposable;", "Lcom/avito/android/enabler/RemoteFeaturesCrashlyticsMonitor;", "crashlytics", "Lcom/avito/android/enabler/RemoteFeaturesCrashlyticsMonitor;", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "<init>", "(Lcom/avito/android/enabler/AnalyticFeatures;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/enabler/RemoteFeaturesCrashlyticsMonitor;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/util/BuildInfo;)V", "features-enabler_release"}, k = 1, mv = {1, 4, 2})
public final class RemoteFeaturesTouchMonitor {
    private final AnalyticFeatures analyticFeatures;
    private final Analytics analytics;
    private final BuildInfo buildInfo;
    private final RemoteFeaturesCrashlyticsMonitor crashlytics;
    private final CompositeDisposable disposable = new CompositeDisposable();
    private final SchedulersFactory schedulers;

    public RemoteFeaturesTouchMonitor(@NotNull AnalyticFeatures analyticFeatures2, @NotNull Analytics analytics2, @NotNull RemoteFeaturesCrashlyticsMonitor remoteFeaturesCrashlyticsMonitor, @NotNull SchedulersFactory schedulersFactory, @NotNull BuildInfo buildInfo2) {
        Intrinsics.checkNotNullParameter(analyticFeatures2, "analyticFeatures");
        Intrinsics.checkNotNullParameter(analytics2, "analytics");
        Intrinsics.checkNotNullParameter(remoteFeaturesCrashlyticsMonitor, "crashlytics");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(buildInfo2, "buildInfo");
        this.analyticFeatures = analyticFeatures2;
        this.analytics = analytics2;
        this.crashlytics = remoteFeaturesCrashlyticsMonitor;
        this.schedulers = schedulersFactory;
        this.buildInfo = buildInfo2;
    }

    /* access modifiers changed from: private */
    public final void reportTouchedFeatureCacheState(RemoteFeature<?> remoteFeature) {
        String str = this.analyticFeatures.getHasCacheForCurrentVersion() ? "hit" : "miss";
        this.analytics.track(new StatsdEvent.CountEvent(MonitorsKt.basePrefix(this.buildInfo) + ".cache." + remoteFeature.getKey() + FormatterType.defaultDecimalSeparator + str, 0, 2, null));
    }

    /* access modifiers changed from: private */
    public final void reportTouchedFeatureValue(RemoteFeature<?> remoteFeature) {
        String invoke = remoteFeature.invoke();
        if (invoke instanceof Boolean) {
            invoke = ((Boolean) invoke).booleanValue() ? "enabled" : "disabled";
        }
        this.analytics.track(new StatsdEvent.CountEvent(MonitorsKt.basePrefix(this.buildInfo) + ".toggles." + remoteFeature.getKey() + FormatterType.defaultDecimalSeparator + invoke, 0, 2, null));
    }

    public final void start() {
        this.disposable.clear();
        this.disposable.add(this.analyticFeatures.getTouchedFeatures().doOnNext(new Consumer<RemoteFeature<Object>>(this) { // from class: com.avito.android.enabler.RemoteFeaturesTouchMonitor$start$1
            public final /* synthetic */ RemoteFeaturesTouchMonitor this$0;

            {
                this.this$0 = r1;
            }

            public final void accept(RemoteFeature<Object> remoteFeature) {
                RemoteFeaturesTouchMonitor remoteFeaturesTouchMonitor = this.this$0;
                Intrinsics.checkNotNullExpressionValue(remoteFeature, "it");
                remoteFeaturesTouchMonitor.reportTouchedFeatureValue(remoteFeature);
                this.this$0.reportTouchedFeatureCacheState(remoteFeature);
                this.this$0.crashlytics.onTouched(remoteFeature);
            }
        }).subscribeOn(this.schedulers.io()).subscribe(RemoteFeaturesTouchMonitor$start$2.INSTANCE, RemoteFeaturesTouchMonitor$start$3.INSTANCE));
    }
}
