package com.avito.android.analytics.event;

import com.avito.android.analytics.provider.crashlytics.FirebaseCrashlyticsEvent;
import com.avito.android.analytics.provider.crashlytics.FirebaseCrashlyticsEventTracker;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Deprecated(message = "Use com.avito.android.analytics.event.NonFatalError")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u001b\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\u0012\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/analytics/event/ExceptionEvent;", "Lcom/avito/android/analytics/provider/crashlytics/FirebaseCrashlyticsEvent;", "Lcom/avito/android/analytics/provider/crashlytics/FirebaseCrashlyticsEventTracker;", "tracker", "", "accept", "(Lcom/avito/android/analytics/provider/crashlytics/FirebaseCrashlyticsEventTracker;)V", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "message", "", AuthSource.SEND_ABUSE, "Ljava/lang/Throwable;", "getCause", "()Ljava/lang/Throwable;", "cause", "<init>", "(Ljava/lang/Throwable;Ljava/lang/String;)V", "analytics_release"}, k = 1, mv = {1, 4, 2})
public final class ExceptionEvent implements FirebaseCrashlyticsEvent {
    @NotNull
    public final Throwable a;
    @Nullable
    public final String b;

    @JvmOverloads
    public ExceptionEvent(@NotNull Throwable th) {
        this(th, null, 2, null);
    }

    @JvmOverloads
    public ExceptionEvent(@NotNull Throwable th, @Nullable String str) {
        Intrinsics.checkNotNullParameter(th, "cause");
        this.a = th;
        this.b = str;
    }

    @Override // com.avito.android.analytics.provider.crashlytics.FirebaseCrashlyticsEvent
    public void accept(@NotNull FirebaseCrashlyticsEventTracker firebaseCrashlyticsEventTracker) {
        Intrinsics.checkNotNullParameter(firebaseCrashlyticsEventTracker, "tracker");
        FirebaseCrashlyticsEventTracker.DefaultImpls.trackException$default(firebaseCrashlyticsEventTracker, this.b, this.a, null, 4, null);
    }

    @NotNull
    public final Throwable getCause() {
        return this.a;
    }

    @Nullable
    public final String getMessage() {
        return this.b;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ExceptionEvent(Throwable th, String str, int i, j jVar) {
        this(th, (i & 2) != 0 ? null : str);
    }
}
