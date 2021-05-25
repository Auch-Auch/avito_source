package com.avito.android.analytics.event;

import com.avito.android.analytics.ErrorEvent;
import com.avito.android.analytics.ErrorSummary;
import com.avito.android.analytics.provider.crashlytics.FirebaseCrashlyticsEvent;
import com.avito.android.analytics.provider.crashlytics.FirebaseCrashlyticsEventTracker;
import com.avito.android.analytics.provider.crashlytics.NonFatalException;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.applinks.AppLinkData;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongycastle.i18n.ErrorBundle;
import t6.n.r;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B1\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0012\u0012\u0014\b\u0002\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\u0004\b\u001b\u0010\u001cB\u0011\b\u0016\u0012\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001b\u0010\u001fJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u001c\u0010\u0011\u001a\u00020\f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\"\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00170\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006 "}, d2 = {"Lcom/avito/android/analytics/event/NonFatalError;", "Lcom/avito/android/analytics/provider/crashlytics/FirebaseCrashlyticsEvent;", "Lcom/avito/android/analytics/ErrorEvent;", "Lcom/avito/android/analytics/provider/crashlytics/FirebaseCrashlyticsEventTracker;", "tracker", "", "accept", "(Lcom/avito/android/analytics/provider/crashlytics/FirebaseCrashlyticsEventTracker;)V", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "message", "Lcom/avito/android/analytics/ErrorSummary;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics/ErrorSummary;", "getSummary", "()Lcom/avito/android/analytics/ErrorSummary;", ErrorBundle.SUMMARY_ENTRY, "", "c", "Ljava/lang/Throwable;", "cause", "", "", "d", "Ljava/util/Map;", AppLinkData.ARGUMENTS_EXTRAS_KEY, "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;Ljava/util/Map;)V", "Lcom/avito/android/analytics/event/ErrorWithExtras;", "errorWithExtras", "(Lcom/avito/android/analytics/event/ErrorWithExtras;)V", "analytics-firebase-crashlytics_release"}, k = 1, mv = {1, 4, 2})
public final class NonFatalError implements FirebaseCrashlyticsEvent, ErrorEvent {
    @NotNull
    public final ErrorSummary a;
    public final String b;
    public final Throwable c;
    public final Map<String, Object> d;

    public NonFatalError(@NotNull String str, @Nullable Throwable th, @NotNull Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(map, AppLinkData.ARGUMENTS_EXTRAS_KEY);
        this.b = str;
        this.c = th;
        this.d = map;
        this.a = new ErrorSummary(1, th, str);
    }

    @Override // com.avito.android.analytics.provider.crashlytics.FirebaseCrashlyticsEvent
    public void accept(@NotNull FirebaseCrashlyticsEventTracker firebaseCrashlyticsEventTracker) {
        Intrinsics.checkNotNullParameter(firebaseCrashlyticsEventTracker, "tracker");
        Throwable th = this.c;
        if (th != null) {
            firebaseCrashlyticsEventTracker.trackException(this.b, th, this.d);
        } else {
            firebaseCrashlyticsEventTracker.trackException(this.b, new NonFatalException(this.b, this.c), this.d);
        }
    }

    @Override // com.avito.android.analytics.ErrorEvent
    @NotNull
    public ErrorSummary getSummary() {
        return this.a;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NonFatalError(String str, Throwable th, Map map, int i, j jVar) {
        this(str, (i & 2) != 0 ? null : th, (i & 4) != 0 ? r.emptyMap() : map);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public NonFatalError(@NotNull ErrorWithExtras errorWithExtras) {
        this(errorWithExtras.getMessage(), errorWithExtras, errorWithExtras.getExtras());
        Intrinsics.checkNotNullParameter(errorWithExtras, "errorWithExtras");
    }
}
