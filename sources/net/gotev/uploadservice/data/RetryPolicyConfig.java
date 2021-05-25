package net.gotev.uploadservice.data;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0010\u0010\n\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\n\u0010\u0007J8\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0007J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\u000e\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007R\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0017\u001a\u0004\b\u001a\u0010\u0007R\u0019\u0010\r\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0017\u001a\u0004\b\u001c\u0010\u0007R\u0019\u0010\u000b\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0017\u001a\u0004\b\u001e\u0010\u0007¨\u0006!"}, d2 = {"Lnet/gotev/uploadservice/data/RetryPolicyConfig;", "", "", "toString", "()Ljava/lang/String;", "", "component1", "()I", "component2", "component3", "component4", "initialWaitTimeSeconds", "maxWaitTimeSeconds", "multiplier", "defaultMaxRetries", "copy", "(IIII)Lnet/gotev/uploadservice/data/RetryPolicyConfig;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "d", "I", "getDefaultMaxRetries", AuthSource.BOOKING_ORDER, "getMaxWaitTimeSeconds", "c", "getMultiplier", AuthSource.SEND_ABUSE, "getInitialWaitTimeSeconds", "<init>", "(IIII)V", "uploadservice_release"}, k = 1, mv = {1, 4, 0})
public final class RetryPolicyConfig {
    public final int a;
    public final int b;
    public final int c;
    public final int d;

    public RetryPolicyConfig(int i, int i2, int i3, int i4) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }

    public static /* synthetic */ RetryPolicyConfig copy$default(RetryPolicyConfig retryPolicyConfig, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = retryPolicyConfig.a;
        }
        if ((i5 & 2) != 0) {
            i2 = retryPolicyConfig.b;
        }
        if ((i5 & 4) != 0) {
            i3 = retryPolicyConfig.c;
        }
        if ((i5 & 8) != 0) {
            i4 = retryPolicyConfig.d;
        }
        return retryPolicyConfig.copy(i, i2, i3, i4);
    }

    public final int component1() {
        return this.a;
    }

    public final int component2() {
        return this.b;
    }

    public final int component3() {
        return this.c;
    }

    public final int component4() {
        return this.d;
    }

    @NotNull
    public final RetryPolicyConfig copy(int i, int i2, int i3, int i4) {
        return new RetryPolicyConfig(i, i2, i3, i4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RetryPolicyConfig)) {
            return false;
        }
        RetryPolicyConfig retryPolicyConfig = (RetryPolicyConfig) obj;
        return this.a == retryPolicyConfig.a && this.b == retryPolicyConfig.b && this.c == retryPolicyConfig.c && this.d == retryPolicyConfig.d;
    }

    public final int getDefaultMaxRetries() {
        return this.d;
    }

    public final int getInitialWaitTimeSeconds() {
        return this.a;
    }

    public final int getMaxWaitTimeSeconds() {
        return this.b;
    }

    public final int getMultiplier() {
        return this.c;
    }

    public int hashCode() {
        return (((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("{\"initialWaitTimeSeconds\": ");
        L.append(this.a);
        L.append(", \"maxWaitTimeSeconds\": ");
        L.append(this.b);
        L.append(", \"multiplier\": ");
        L.append(this.c);
        L.append(", \"defaultMaxRetries\": ");
        return a.i(L, this.d, '}');
    }
}
