package kotlin.text;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004¨\u0006\u001c"}, d2 = {"Lkotlin/text/MatchGroup;", "", "", "component1", "()Ljava/lang/String;", "Lkotlin/ranges/IntRange;", "component2", "()Lkotlin/ranges/IntRange;", "value", "range", "copy", "(Ljava/lang/String;Lkotlin/ranges/IntRange;)Lkotlin/text/MatchGroup;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Lkotlin/ranges/IntRange;", "getRange", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getValue", "<init>", "(Ljava/lang/String;Lkotlin/ranges/IntRange;)V", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
public final class MatchGroup {
    @NotNull
    public final String a;
    @NotNull
    public final IntRange b;

    public MatchGroup(@NotNull String str, @NotNull IntRange intRange) {
        Intrinsics.checkNotNullParameter(str, "value");
        Intrinsics.checkNotNullParameter(intRange, "range");
        this.a = str;
        this.b = intRange;
    }

    public static /* synthetic */ MatchGroup copy$default(MatchGroup matchGroup, String str, IntRange intRange, int i, Object obj) {
        if ((i & 1) != 0) {
            str = matchGroup.a;
        }
        if ((i & 2) != 0) {
            intRange = matchGroup.b;
        }
        return matchGroup.copy(str, intRange);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    @NotNull
    public final IntRange component2() {
        return this.b;
    }

    @NotNull
    public final MatchGroup copy(@NotNull String str, @NotNull IntRange intRange) {
        Intrinsics.checkNotNullParameter(str, "value");
        Intrinsics.checkNotNullParameter(intRange, "range");
        return new MatchGroup(str, intRange);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MatchGroup)) {
            return false;
        }
        MatchGroup matchGroup = (MatchGroup) obj;
        return Intrinsics.areEqual(this.a, matchGroup.a) && Intrinsics.areEqual(this.b, matchGroup.b);
    }

    @NotNull
    public final IntRange getRange() {
        return this.b;
    }

    @NotNull
    public final String getValue() {
        return this.a;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        IntRange intRange = this.b;
        if (intRange != null) {
            i = intRange.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("MatchGroup(value=");
        L.append(this.a);
        L.append(", range=");
        L.append(this.b);
        L.append(")");
        return L.toString();
    }
}
