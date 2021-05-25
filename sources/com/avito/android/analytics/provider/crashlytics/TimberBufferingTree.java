package com.avito.android.analytics.provider.crashlytics;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.server_time.TimeSource;
import com.google.firebase.messaging.Constants;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.v.e;
import timber.log.Timber;
@Singleton
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001&B\u0011\b\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u0019¢\u0006\u0004\b$\u0010%J\u0015\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J3\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014¢\u0006\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0019\u0010\u001e\u001a\u00020\u00198\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010 ¨\u0006'"}, d2 = {"Lcom/avito/android/analytics/provider/crashlytics/TimberBufferingTree;", "Ltimber/log/Timber$Tree;", "Lcom/avito/android/analytics/provider/crashlytics/LogBufferProvider;", "", "", "getBufferedLogs", "()Ljava/util/List;", "", Constants.FirelogAnalytics.PARAM_PRIORITY, "tag", "message", "", "throwable", "", "log", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", "", "Lcom/avito/android/analytics/provider/crashlytics/TimberBufferingTree$a;", "e", "[Lcom/avito/android/analytics/provider/crashlytics/TimberBufferingTree$LogEntry;", "logs", "", AuthSource.BOOKING_ORDER, "Ljava/lang/Object;", "logsLock", "Lcom/avito/android/server_time/TimeSource;", "f", "Lcom/avito/android/server_time/TimeSource;", "getTimeSource", "()Lcom/avito/android/server_time/TimeSource;", "timeSource", "d", "I", "endIndex", "c", "count", "<init>", "(Lcom/avito/android/server_time/TimeSource;)V", AuthSource.SEND_ABUSE, "analytics-firebase-crashlytics_release"}, k = 1, mv = {1, 4, 2})
public final class TimberBufferingTree extends Timber.Tree implements LogBufferProvider {
    public final Object b = new Object();
    public int c;
    public int d;
    public final a[] e = new a[500];
    @NotNull
    public final TimeSource f;

    public static final class a {
        @JvmField
        public final long a;
        @JvmField
        @Nullable
        public final String b;
        @JvmField
        @Nullable
        public final String c;

        public a(long j, @Nullable String str, @Nullable String str2) {
            this.a = j;
            this.b = str;
            this.c = str2;
        }
    }

    @Inject
    public TimberBufferingTree(@NotNull TimeSource timeSource) {
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        this.f = timeSource;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00c4 A[LOOP:0: B:6:0x002b->B:32:0x00c4, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0150  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x016d  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x017d  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x019e A[LOOP:1: B:36:0x0105->B:62:0x019e, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00d1 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01ab A[SYNTHETIC] */
    @Override // com.avito.android.analytics.provider.crashlytics.LogBufferProvider
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<java.lang.String> getBufferedLogs() {
        /*
        // Method dump skipped, instructions count: 440
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.analytics.provider.crashlytics.TimberBufferingTree.getBufferedLogs():java.util.List");
    }

    @NotNull
    public final TimeSource getTimeSource() {
        return this.f;
    }

    @Override // timber.log.Timber.Tree
    public void log(int i, @Nullable String str, @NotNull String str2, @Nullable Throwable th) {
        Intrinsics.checkNotNullParameter(str2, "message");
        if (!Intrinsics.areEqual(str, "CrashlyticsEventTracker")) {
            synchronized (this.b) {
                this.e[this.d] = new a(this.f.now(), str, str2);
                a[] aVarArr = this.e;
                this.d = (this.d + 1) % aVarArr.length;
                this.c = e.coerceAtMost(this.c + 1, aVarArr.length);
                Unit unit = Unit.INSTANCE;
            }
        }
    }
}
