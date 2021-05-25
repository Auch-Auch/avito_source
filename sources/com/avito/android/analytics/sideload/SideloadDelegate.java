package com.avito.android.analytics.sideload;

import a2.b.a.a.a;
import android.app.Application;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.NonFatalError;
import com.avito.android.analytics.statsd.StatsdEvent;
import com.avito.android.remote.auth.AuthSource;
import com.google.android.exoplayer2.util.MimeTypes;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0017\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0012¢\u0006\u0004\b\u0018\u0010\u0019J3\u0010\n\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\u0010\b\u001a\u00060\u0006j\u0002`\u0007¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u001b"}, d2 = {"Lcom/avito/android/analytics/sideload/SideloadDelegate;", "", "obj", "", "method", "resourceName", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "", "catchException", "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Exception;)V", "trackIfSideload", "()V", "Lcom/avito/android/analytics/sideload/SideloadChecker;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics/sideload/SideloadChecker;", "sideloadChecker", "Lcom/avito/android/analytics/Analytics;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/analytics/Analytics;", "analytics", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "<init>", "(Landroid/app/Application;Lcom/avito/android/analytics/Analytics;)V", "Companion", "core_release"}, k = 1, mv = {1, 4, 2})
public final class SideloadDelegate {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public final SideloadChecker a;
    public final Analytics b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/analytics/sideload/SideloadDelegate$Companion;", "", "", "SIDELOAD_EVENT_STATSD", "Ljava/lang/String;", "<init>", "()V", "core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public SideloadDelegate(@NotNull Application application, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.b = analytics;
        this.a = new SideloadChecker(application);
    }

    public static /* synthetic */ void catchException$default(SideloadDelegate sideloadDelegate, Object obj, String str, String str2, Exception exc, int i, Object obj2) {
        if ((i & 4) != 0) {
            str2 = "";
        }
        sideloadDelegate.catchException(obj, str, str2, exc);
    }

    public final void catchException(@NotNull Object obj, @NotNull String str, @NotNull String str2, @NotNull Exception exc) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        Intrinsics.checkNotNullParameter(str, "method");
        Intrinsics.checkNotNullParameter(str2, "resourceName");
        Intrinsics.checkNotNullParameter(exc, "e");
        Analytics analytics = this.b;
        String simpleName = obj.getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "obj::class.java.simpleName");
        analytics.track(new NonFatalError(new SideloadResourceNotFoundError(simpleName, str, str2, this.a.isSideload(), exc)));
    }

    public final void trackIfSideload() {
        Analytics analytics = this.b;
        StringBuilder L = a.L("sideload.");
        L.append(this.a.isSideload());
        analytics.track(new StatsdEvent.CountEvent(L.toString(), 1));
    }
}
