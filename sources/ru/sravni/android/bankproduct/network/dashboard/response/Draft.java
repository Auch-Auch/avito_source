package ru.sravni.android.bankproduct.network.dashboard.response;

import a2.b.a.a.a;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u000f\u0010\bJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\u000b\u001a\u00020\u00068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0014\u001a\u0004\b\u0015\u0010\bR\u001c\u0010\t\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u001c\u0010\n\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0018\u0010\u0004¨\u0006\u001b"}, d2 = {"Lru/sravni/android/bankproduct/network/dashboard/response/Draft;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()I", "id", "name", "percentsPassed", "copy", "(Ljava/lang/String;Ljava/lang/String;I)Lru/sravni/android/bankproduct/network/dashboard/response/Draft;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getPercentsPassed", "Ljava/lang/String;", "getId", "getName", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class Draft {
    @SerializedName("_id")
    @NotNull
    private final String id;
    @SerializedName("name")
    @NotNull
    private final String name;
    @SerializedName("percentsPassed")
    private final int percentsPassed;

    public Draft(@NotNull String str, @NotNull String str2, int i) {
        Intrinsics.checkParameterIsNotNull(str, "id");
        Intrinsics.checkParameterIsNotNull(str2, "name");
        this.id = str;
        this.name = str2;
        this.percentsPassed = i;
    }

    public static /* synthetic */ Draft copy$default(Draft draft, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = draft.id;
        }
        if ((i2 & 2) != 0) {
            str2 = draft.name;
        }
        if ((i2 & 4) != 0) {
            i = draft.percentsPassed;
        }
        return draft.copy(str, str2, i);
    }

    @NotNull
    public final String component1() {
        return this.id;
    }

    @NotNull
    public final String component2() {
        return this.name;
    }

    public final int component3() {
        return this.percentsPassed;
    }

    @NotNull
    public final Draft copy(@NotNull String str, @NotNull String str2, int i) {
        Intrinsics.checkParameterIsNotNull(str, "id");
        Intrinsics.checkParameterIsNotNull(str2, "name");
        return new Draft(str, str2, i);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Draft)) {
            return false;
        }
        Draft draft = (Draft) obj;
        return Intrinsics.areEqual(this.id, draft.id) && Intrinsics.areEqual(this.name, draft.name) && this.percentsPassed == draft.percentsPassed;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final int getPercentsPassed() {
        return this.percentsPassed;
    }

    public int hashCode() {
        String str = this.id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.name;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return ((hashCode + i) * 31) + this.percentsPassed;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("Draft(id=");
        L.append(this.id);
        L.append(", name=");
        L.append(this.name);
        L.append(", percentsPassed=");
        return a.j(L, this.percentsPassed, ")");
    }
}
