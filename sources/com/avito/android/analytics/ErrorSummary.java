package com.avito.android.analytics;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\r\u001a\u00020\b\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/analytics/ErrorSummary;", "", "", "c", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "message", "", AuthSource.SEND_ABUSE, "I", "getType", "()I", "type", "", AuthSource.BOOKING_ORDER, "Ljava/lang/Throwable;", "getError", "()Ljava/lang/Throwable;", "error", "<init>", "(ILjava/lang/Throwable;Ljava/lang/String;)V", "analytics-core_release"}, k = 1, mv = {1, 4, 2})
public final class ErrorSummary {
    public final int a;
    @Nullable
    public final Throwable b;
    @Nullable
    public final String c;

    public ErrorSummary(int i, @Nullable Throwable th, @Nullable String str) {
        this.a = i;
        this.b = th;
        this.c = str;
    }

    @Nullable
    public final Throwable getError() {
        return this.b;
    }

    @Nullable
    public final String getMessage() {
        return this.c;
    }

    public final int getType() {
        return this.a;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ErrorSummary(int i, Throwable th, String str, int i2, j jVar) {
        this(i, th, (i2 & 4) != 0 ? null : str);
    }
}
