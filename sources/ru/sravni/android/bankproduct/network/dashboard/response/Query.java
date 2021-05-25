package ru.sravni.android.bankproduct.network.dashboard.response;

import a2.b.a.a.a;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0007\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004R\u001c\u0010\u0006\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lru/sravni/android/bankproduct/network/dashboard/response/Query;", "", "", "component1", "()Ljava/lang/String;", "component2", "summ", FirebaseAnalytics.Param.TERM, "copy", "(Ljava/lang/String;Ljava/lang/String;)Lru/sravni/android/bankproduct/network/dashboard/response/Query;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTerm", "getSumm", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class Query {
    @SerializedName("summ")
    @NotNull
    private final String summ;
    @SerializedName(FirebaseAnalytics.Param.TERM)
    @NotNull
    private final String term;

    public Query(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "summ");
        Intrinsics.checkParameterIsNotNull(str2, FirebaseAnalytics.Param.TERM);
        this.summ = str;
        this.term = str2;
    }

    public static /* synthetic */ Query copy$default(Query query, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = query.summ;
        }
        if ((i & 2) != 0) {
            str2 = query.term;
        }
        return query.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return this.summ;
    }

    @NotNull
    public final String component2() {
        return this.term;
    }

    @NotNull
    public final Query copy(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "summ");
        Intrinsics.checkParameterIsNotNull(str2, FirebaseAnalytics.Param.TERM);
        return new Query(str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Query)) {
            return false;
        }
        Query query = (Query) obj;
        return Intrinsics.areEqual(this.summ, query.summ) && Intrinsics.areEqual(this.term, query.term);
    }

    @NotNull
    public final String getSumm() {
        return this.summ;
    }

    @NotNull
    public final String getTerm() {
        return this.term;
    }

    public int hashCode() {
        String str = this.summ;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.term;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("Query(summ=");
        L.append(this.summ);
        L.append(", term=");
        return a.t(L, this.term, ")");
    }
}
