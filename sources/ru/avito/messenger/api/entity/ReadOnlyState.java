package ru.avito.messenger.api.entity;

import a2.b.a.a.a;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J&\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0006\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lru/avito/messenger/api/entity/ReadOnlyState;", "", "", "component1", "()Ljava/lang/String;", "component2", "reason", "description", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lru/avito/messenger/api/entity/ReadOnlyState;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getReason", "getDescription", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ReadOnlyState {
    @SerializedName("description")
    @Nullable
    private final String description;
    @SerializedName("reason")
    @NotNull
    private final String reason;

    public ReadOnlyState(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "reason");
        this.reason = str;
        this.description = str2;
    }

    public static /* synthetic */ ReadOnlyState copy$default(ReadOnlyState readOnlyState, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = readOnlyState.reason;
        }
        if ((i & 2) != 0) {
            str2 = readOnlyState.description;
        }
        return readOnlyState.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return this.reason;
    }

    @Nullable
    public final String component2() {
        return this.description;
    }

    @NotNull
    public final ReadOnlyState copy(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "reason");
        return new ReadOnlyState(str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReadOnlyState)) {
            return false;
        }
        ReadOnlyState readOnlyState = (ReadOnlyState) obj;
        return Intrinsics.areEqual(this.reason, readOnlyState.reason) && Intrinsics.areEqual(this.description, readOnlyState.description);
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final String getReason() {
        return this.reason;
    }

    public int hashCode() {
        String str = this.reason;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.description;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ReadOnlyState(reason=");
        L.append(this.reason);
        L.append(", description=");
        return a.t(L, this.description, ")");
    }
}
