package com.avito.android.push;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.google.firebase.messaging.Constants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0015\b\b\u0018\u00002\u00020\u0001BQ\u0012\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\b\u0012\b\b\u0002\u0010\u0013\u001a\u00020\b\u0012\b\b\u0002\u0010\u0014\u001a\u00020\b\u0012\b\b\u0002\u0010\u0015\u001a\u00020\r¢\u0006\u0004\b.\u0010/J\u001e\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ\u0010\u0010\f\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\f\u0010\nJ\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\\\u0010\u0016\u001a\u00020\u00002\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\b2\b\b\u0002\u0010\u0014\u001a\u00020\b2\b\b\u0002\u0010\u0015\u001a\u00020\rHÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0007J\u0010\u0010\u0019\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0019\u0010\nJ\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u0019\u0010\u0013\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\nR\u0019\u0010\u0014\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\u001f\u001a\u0004\b\"\u0010\nR\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\u0007R'\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010\u0005R\u0019\u0010\u0012\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010\u001f\u001a\u0004\b*\u0010\nR\u0019\u0010\u0015\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010\u000f¨\u00060"}, d2 = {"Lcom/avito/android/push/Push;", "", "", "", "component1", "()Ljava/util/Map;", "component2", "()Ljava/lang/String;", "", "component3", "()I", "component4", "component5", "", "component6", "()J", "data", "from", "originalPriority", "deliveredPriority", Constants.FirelogAnalytics.PARAM_TTL, "sentTimestamp", "copy", "(Ljava/util/Map;Ljava/lang/String;IIIJ)Lcom/avito/android/push/Push;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "d", "I", "getDeliveredPriority", "e", "getTtl", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getFrom", AuthSource.SEND_ABUSE, "Ljava/util/Map;", "getData", "c", "getOriginalPriority", "f", "J", "getSentTimestamp", "<init>", "(Ljava/util/Map;Ljava/lang/String;IIIJ)V", "core_release"}, k = 1, mv = {1, 4, 2})
public final class Push {
    @Nullable
    public final Map<String, String> a;
    @Nullable
    public final String b;
    public final int c;
    public final int d;
    public final int e;
    public final long f;

    public Push(@Nullable Map<String, String> map, @Nullable String str, int i, int i2, int i3, long j) {
        this.a = map;
        this.b = str;
        this.c = i;
        this.d = i2;
        this.e = i3;
        this.f = j;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.avito.android.push.Push */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Push copy$default(Push push, Map map, String str, int i, int i2, int i3, long j, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            map = push.a;
        }
        if ((i4 & 2) != 0) {
            str = push.b;
        }
        if ((i4 & 4) != 0) {
            i = push.c;
        }
        if ((i4 & 8) != 0) {
            i2 = push.d;
        }
        if ((i4 & 16) != 0) {
            i3 = push.e;
        }
        if ((i4 & 32) != 0) {
            j = push.f;
        }
        return push.copy(map, str, i, i2, i3, j);
    }

    @Nullable
    public final Map<String, String> component1() {
        return this.a;
    }

    @Nullable
    public final String component2() {
        return this.b;
    }

    public final int component3() {
        return this.c;
    }

    public final int component4() {
        return this.d;
    }

    public final int component5() {
        return this.e;
    }

    public final long component6() {
        return this.f;
    }

    @NotNull
    public final Push copy(@Nullable Map<String, String> map, @Nullable String str, int i, int i2, int i3, long j) {
        return new Push(map, str, i, i2, i3, j);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Push)) {
            return false;
        }
        Push push = (Push) obj;
        return Intrinsics.areEqual(this.a, push.a) && Intrinsics.areEqual(this.b, push.b) && this.c == push.c && this.d == push.d && this.e == push.e && this.f == push.f;
    }

    @Nullable
    public final Map<String, String> getData() {
        return this.a;
    }

    public final int getDeliveredPriority() {
        return this.d;
    }

    @Nullable
    public final String getFrom() {
        return this.b;
    }

    public final int getOriginalPriority() {
        return this.c;
    }

    public final long getSentTimestamp() {
        return this.f;
    }

    public final int getTtl() {
        return this.e;
    }

    public int hashCode() {
        Map<String, String> map = this.a;
        int i = 0;
        int hashCode = (map != null ? map.hashCode() : 0) * 31;
        String str = this.b;
        if (str != null) {
            i = str.hashCode();
        }
        return ((((((((hashCode + i) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31) + c.a(this.f);
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("Push(data=");
        L.append(this.a);
        L.append(", from=");
        L.append(this.b);
        L.append(", originalPriority=");
        L.append(this.c);
        L.append(", deliveredPriority=");
        L.append(this.d);
        L.append(", ttl=");
        L.append(this.e);
        L.append(", sentTimestamp=");
        return a.l(L, this.f, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Push(Map map, String str, int i, int i2, int i3, long j, int i4, j jVar) {
        this(map, (i4 & 2) != 0 ? null : str, (i4 & 4) != 0 ? 0 : i, (i4 & 8) != 0 ? 0 : i2, (i4 & 16) == 0 ? i3 : 0, (i4 & 32) != 0 ? 0 : j);
    }
}
