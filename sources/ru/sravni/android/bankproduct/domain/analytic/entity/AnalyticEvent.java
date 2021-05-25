package ru.sravni.android.bankproduct.domain.analytic.entity;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005\u0012\u001a\b\u0002\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\b0\u0005¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\"\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\b0\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007JL\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00052\u001a\b\u0002\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\b0\u0005HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R%\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007R+\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\b0\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0018\u001a\u0004\b\u001b\u0010\u0007R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004¨\u0006!"}, d2 = {"Lru/sravni/android/bankproduct/domain/analytic/entity/AnalyticEvent;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/util/Map;", "", "component3", "id", "params", "massiveParams", "copy", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)Lru/sravni/android/bankproduct/domain/analytic/entity/AnalyticEvent;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/util/Map;", "getParams", "c", "getMassiveParams", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getId", "<init>", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class AnalyticEvent {
    @NotNull
    public final String a;
    @NotNull
    public final Map<String, String> b;
    @NotNull
    public final Map<String, List<String>> c;

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.Map<java.lang.String, ? extends java.util.List<java.lang.String>> */
    /* JADX WARN: Multi-variable type inference failed */
    public AnalyticEvent(@NotNull String str, @NotNull Map<String, String> map, @NotNull Map<String, ? extends List<String>> map2) {
        Intrinsics.checkParameterIsNotNull(str, "id");
        Intrinsics.checkParameterIsNotNull(map, "params");
        Intrinsics.checkParameterIsNotNull(map2, "massiveParams");
        this.a = str;
        this.b = map;
        this.c = map2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: ru.sravni.android.bankproduct.domain.analytic.entity.AnalyticEvent */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AnalyticEvent copy$default(AnalyticEvent analyticEvent, String str, Map map, Map map2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = analyticEvent.a;
        }
        if ((i & 2) != 0) {
            map = analyticEvent.b;
        }
        if ((i & 4) != 0) {
            map2 = analyticEvent.c;
        }
        return analyticEvent.copy(str, map, map2);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    @NotNull
    public final Map<String, String> component2() {
        return this.b;
    }

    @NotNull
    public final Map<String, List<String>> component3() {
        return this.c;
    }

    @NotNull
    public final AnalyticEvent copy(@NotNull String str, @NotNull Map<String, String> map, @NotNull Map<String, ? extends List<String>> map2) {
        Intrinsics.checkParameterIsNotNull(str, "id");
        Intrinsics.checkParameterIsNotNull(map, "params");
        Intrinsics.checkParameterIsNotNull(map2, "massiveParams");
        return new AnalyticEvent(str, map, map2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AnalyticEvent)) {
            return false;
        }
        AnalyticEvent analyticEvent = (AnalyticEvent) obj;
        return Intrinsics.areEqual(this.a, analyticEvent.a) && Intrinsics.areEqual(this.b, analyticEvent.b) && Intrinsics.areEqual(this.c, analyticEvent.c);
    }

    @NotNull
    public final String getId() {
        return this.a;
    }

    @NotNull
    public final Map<String, List<String>> getMassiveParams() {
        return this.c;
    }

    @NotNull
    public final Map<String, String> getParams() {
        return this.b;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Map<String, String> map = this.b;
        int hashCode2 = (hashCode + (map != null ? map.hashCode() : 0)) * 31;
        Map<String, List<String>> map2 = this.c;
        if (map2 != null) {
            i = map2.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("AnalyticEvent(id=");
        L.append(this.a);
        L.append(", params=");
        L.append(this.b);
        L.append(", massiveParams=");
        return a.x(L, this.c, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AnalyticEvent(String str, Map map, Map map2, int i, j jVar) {
        this(str, (i & 2) != 0 ? r.emptyMap() : map, (i & 4) != 0 ? r.emptyMap() : map2);
    }
}
