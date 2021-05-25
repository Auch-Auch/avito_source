package ru.sravni.android.bankproduct.network.di;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\b\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ8\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0010\u0010\tJ\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\r\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\tR\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001c\u001a\u0004\b\u001f\u0010\u0004R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\u001c\u001a\u0004\b!\u0010\u0004¨\u0006$"}, d2 = {"Lru/sravni/android/bankproduct/network/di/SravniNetworkConfiguration;", "", "", "component1", "()J", "component2", "component3", "", "component4", "()Ljava/lang/String;", "connectionTimeout", "readTimeout", "callTimeout", "baseUrl", "copy", "(JJJLjava/lang/String;)Lru/sravni/android/bankproduct/network/di/SravniNetworkConfiguration;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "d", "Ljava/lang/String;", "getBaseUrl", "c", "J", "getCallTimeout", AuthSource.SEND_ABUSE, "getConnectionTimeout", AuthSource.BOOKING_ORDER, "getReadTimeout", "<init>", "(JJJLjava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class SravniNetworkConfiguration {
    public final long a;
    public final long b;
    public final long c;
    @NotNull
    public final String d;

    public SravniNetworkConfiguration(long j, long j2, long j3, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "baseUrl");
        this.a = j;
        this.b = j2;
        this.c = j3;
        this.d = str;
    }

    public static /* synthetic */ SravniNetworkConfiguration copy$default(SravniNetworkConfiguration sravniNetworkConfiguration, long j, long j2, long j3, String str, int i, Object obj) {
        return sravniNetworkConfiguration.copy((i & 1) != 0 ? sravniNetworkConfiguration.a : j, (i & 2) != 0 ? sravniNetworkConfiguration.b : j2, (i & 4) != 0 ? sravniNetworkConfiguration.c : j3, (i & 8) != 0 ? sravniNetworkConfiguration.d : str);
    }

    public final long component1() {
        return this.a;
    }

    public final long component2() {
        return this.b;
    }

    public final long component3() {
        return this.c;
    }

    @NotNull
    public final String component4() {
        return this.d;
    }

    @NotNull
    public final SravniNetworkConfiguration copy(long j, long j2, long j3, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "baseUrl");
        return new SravniNetworkConfiguration(j, j2, j3, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SravniNetworkConfiguration)) {
            return false;
        }
        SravniNetworkConfiguration sravniNetworkConfiguration = (SravniNetworkConfiguration) obj;
        return this.a == sravniNetworkConfiguration.a && this.b == sravniNetworkConfiguration.b && this.c == sravniNetworkConfiguration.c && Intrinsics.areEqual(this.d, sravniNetworkConfiguration.d);
    }

    @NotNull
    public final String getBaseUrl() {
        return this.d;
    }

    public final long getCallTimeout() {
        return this.c;
    }

    public final long getConnectionTimeout() {
        return this.a;
    }

    public final long getReadTimeout() {
        return this.b;
    }

    public int hashCode() {
        int a3 = ((((c.a(this.a) * 31) + c.a(this.b)) * 31) + c.a(this.c)) * 31;
        String str = this.d;
        return a3 + (str != null ? str.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("SravniNetworkConfiguration(connectionTimeout=");
        L.append(this.a);
        L.append(", readTimeout=");
        L.append(this.b);
        L.append(", callTimeout=");
        L.append(this.c);
        L.append(", baseUrl=");
        return a.t(L, this.d, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SravniNetworkConfiguration(long j, long j2, long j3, String str, int i, j jVar) {
        this((i & 1) != 0 ? 30 : j, (i & 2) != 0 ? 30 : j2, (i & 4) != 0 ? 30 : j3, str);
    }
}
