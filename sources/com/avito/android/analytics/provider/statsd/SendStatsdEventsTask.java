package com.avito.android.analytics.provider.statsd;

import android.os.Bundle;
import com.avito.android.BaseApp;
import com.avito.android.analytics.statsd.SendStatsdEventsTaskDelegate;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.di.StatsdSendDependencies;
import com.avito.android.di.component.DaggerStatsdSendComponent;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.service.short_task.ShortTask;
import com.yandex.mobile.ads.video.tracking.Tracker;
import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0010\u001a\u00020\u000b8\u0016@\u0016XD¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0016\u001a\u00020\u00118\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lcom/avito/android/analytics/provider/statsd/SendStatsdEventsTask;", "Lcom/avito/android/service/short_task/ShortTask;", "Landroid/os/Bundle;", "bundle", "", "initialize", "(Landroid/os/Bundle;)V", "Lio/reactivex/Single;", "Lcom/avito/android/service/short_task/ShortTask$Status;", Tracker.Events.CREATIVE_START, "()Lio/reactivex/Single;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "tag", "Lcom/avito/android/service/short_task/ShortTask$NetworkState;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/service/short_task/ShortTask$NetworkState;", "getRequiredNetworkState", "()Lcom/avito/android/service/short_task/ShortTask$NetworkState;", "requiredNetworkState", "Lcom/avito/android/analytics/statsd/SendStatsdEventsTaskDelegate;", "delegate", "Lcom/avito/android/analytics/statsd/SendStatsdEventsTaskDelegate;", "getDelegate", "()Lcom/avito/android/analytics/statsd/SendStatsdEventsTaskDelegate;", "setDelegate", "(Lcom/avito/android/analytics/statsd/SendStatsdEventsTaskDelegate;)V", "<init>", "()V", "application_release"}, k = 1, mv = {1, 4, 2})
public class SendStatsdEventsTask implements ShortTask {
    @NotNull
    public final String a = SendStatsdEventsTaskKt.SEND_STATSD_EVENTS_TASK;
    @NotNull
    public final ShortTask.NetworkState b = ShortTask.NetworkState.CONNECTED;
    @Inject
    public SendStatsdEventsTaskDelegate delegate;

    @NotNull
    public final SendStatsdEventsTaskDelegate getDelegate() {
        SendStatsdEventsTaskDelegate sendStatsdEventsTaskDelegate = this.delegate;
        if (sendStatsdEventsTaskDelegate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("delegate");
        }
        return sendStatsdEventsTaskDelegate;
    }

    @Override // com.avito.android.service.short_task.ShortTask
    @NotNull
    public ShortTask.NetworkState getRequiredNetworkState() {
        return this.b;
    }

    @Override // com.avito.android.service.short_task.ShortTask
    @NotNull
    public String getTag() {
        return this.a;
    }

    @Override // com.avito.android.service.short_task.ShortTask
    public void initialize(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        DaggerStatsdSendComponent.builder().dependencies((StatsdSendDependencies) ComponentDependenciesKt.getDependencies(StatsdSendDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(BaseApp.Companion.getInstance()))).build().inject(this);
    }

    public final void setDelegate(@NotNull SendStatsdEventsTaskDelegate sendStatsdEventsTaskDelegate) {
        Intrinsics.checkNotNullParameter(sendStatsdEventsTaskDelegate, "<set-?>");
        this.delegate = sendStatsdEventsTaskDelegate;
    }

    @Override // com.avito.android.service.short_task.ShortTask
    @NotNull
    public Single<ShortTask.Status> start() {
        SendStatsdEventsTaskDelegate sendStatsdEventsTaskDelegate = this.delegate;
        if (sendStatsdEventsTaskDelegate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("delegate");
        }
        return sendStatsdEventsTaskDelegate.start();
    }
}
