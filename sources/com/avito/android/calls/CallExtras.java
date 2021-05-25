package com.avito.android.calls;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J&\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004R\u001b\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0013\u001a\u0004\b\u0016\u0010\u0004¨\u0006\u0019"}, d2 = {"Lcom/avito/android/calls/CallExtras;", "", "", "component1", "()Ljava/lang/String;", "component2", "itemId", "scenario", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/calls/CallExtras;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getScenario", AuthSource.SEND_ABUSE, "getItemId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "calls_release"}, k = 1, mv = {1, 4, 2})
public final class CallExtras {
    @Nullable
    public final String a;
    @NotNull
    public final String b;

    public CallExtras(@Nullable String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str2, "scenario");
        this.a = str;
        this.b = str2;
    }

    public static /* synthetic */ CallExtras copy$default(CallExtras callExtras, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = callExtras.a;
        }
        if ((i & 2) != 0) {
            str2 = callExtras.b;
        }
        return callExtras.copy(str, str2);
    }

    @Nullable
    public final String component1() {
        return this.a;
    }

    @NotNull
    public final String component2() {
        return this.b;
    }

    @NotNull
    public final CallExtras copy(@Nullable String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str2, "scenario");
        return new CallExtras(str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CallExtras)) {
            return false;
        }
        CallExtras callExtras = (CallExtras) obj;
        return Intrinsics.areEqual(this.a, callExtras.a) && Intrinsics.areEqual(this.b, callExtras.b);
    }

    @Nullable
    public final String getItemId() {
        return this.a;
    }

    @NotNull
    public final String getScenario() {
        return this.b;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("CallExtras(itemId=");
        L.append(this.a);
        L.append(", scenario=");
        return a.t(L, this.b, ")");
    }
}
