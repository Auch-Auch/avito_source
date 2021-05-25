package com.avito.android.fps;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.view.Choreographer;
import com.avito.android.app.SimpleActivityLifecycleCallbacks;
import com.avito.android.fps.FramesListener;
import com.avito.android.fps.di.FpsCommunication;
import com.avito.android.remote.auth.AuthSource;
import com.google.android.exoplayer2.util.MimeTypes;
import com.yandex.mobile.ads.video.tracking.Tracker;
import io.reactivex.functions.Consumer;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u000eB!\b\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u000e\b\u0001\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/avito/android/fps/FramesListener;", "Landroid/view/Choreographer$FrameCallback;", "", Tracker.Events.CREATIVE_START, "()V", "", "frameTimeNanos", "doFrame", "(J)V", "Landroid/view/Choreographer;", AuthSource.BOOKING_ORDER, "Landroid/view/Choreographer;", "choreographer", "Lcom/avito/android/fps/FramesListener$a;", AuthSource.SEND_ABUSE, "Lcom/avito/android/fps/FramesListener$a;", "state", "Lio/reactivex/functions/Consumer;", "e", "Lio/reactivex/functions/Consumer;", "frameConsumer", "c", "J", "lastFrameNs", "Landroid/app/Application;", "d", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "<init>", "(Landroid/app/Application;Lio/reactivex/functions/Consumer;)V", "analytics-screens_release"}, k = 1, mv = {1, 4, 2})
public final class FramesListener implements Choreographer.FrameCallback {
    public a a = a.APPLICATION_START;
    public Choreographer b;
    public long c = -1;
    public final Application d;
    public final Consumer<Long> e;

    public enum a {
        WORKING,
        PAUSED,
        APPLICATION_START
    }

    @Inject
    public FramesListener(@NotNull Application application, @FpsCommunication @NotNull Consumer<Long> consumer) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        Intrinsics.checkNotNullParameter(consumer, "frameConsumer");
        this.d = application;
        this.e = consumer;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        long j2 = this.c;
        if (j2 == -1) {
            this.c = j;
        } else {
            long j3 = j - j2;
            this.c = j;
            if (this.a != a.PAUSED) {
                this.e.accept(Long.valueOf(j3));
            }
        }
        Choreographer choreographer = this.b;
        if (choreographer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("choreographer");
        }
        choreographer.postFrameCallback(this);
    }

    public final void start() {
        this.d.registerActivityLifecycleCallbacks(new SimpleActivityLifecycleCallbacks() { // from class: com.avito.android.fps.FramesListener$registerActivityCallbacks$1
            @Override // com.avito.android.app.SimpleActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(@NotNull Activity activity, @Nullable Bundle bundle) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                FramesListener.this.a = FramesListener.a.WORKING;
            }

            @Override // com.avito.android.app.SimpleActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(@NotNull Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                FramesListener.this.a = FramesListener.a.PAUSED;
            }

            @Override // com.avito.android.app.SimpleActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(@NotNull Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                FramesListener.this.a = FramesListener.a.WORKING;
            }

            @Override // com.avito.android.app.SimpleActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(@NotNull Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                FramesListener.this.a = FramesListener.a.WORKING;
            }
        });
        Choreographer instance = Choreographer.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "Choreographer.getInstance()");
        this.b = instance;
        if (instance == null) {
            Intrinsics.throwUninitializedPropertyAccessException("choreographer");
        }
        instance.postFrameCallback(this);
    }
}
