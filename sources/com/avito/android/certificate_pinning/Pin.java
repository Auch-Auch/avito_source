package com.avito.android.certificate_pinning;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/avito/android/certificate_pinning/Pin;", "", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getHostPattern", "()Ljava/lang/String;", "hostPattern", "", AuthSource.BOOKING_ORDER, "J", "getValidThroughTimestamp", "()J", "validThroughTimestamp", "c", "getHash", "hash", "<init>", "(Ljava/lang/String;JLjava/lang/String;)V", "unsafe-network_release"}, k = 1, mv = {1, 4, 2})
public final class Pin {
    @NotNull
    public final String a;
    public final long b;
    @NotNull
    public final String c;

    public Pin(@NotNull String str, long j, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "hostPattern");
        Intrinsics.checkNotNullParameter(str2, "hash");
        this.a = str;
        this.b = j;
        this.c = str2;
    }

    @NotNull
    public final String getHash() {
        return this.c;
    }

    @NotNull
    public final String getHostPattern() {
        return this.a;
    }

    public final long getValidThroughTimestamp() {
        return this.b;
    }
}
