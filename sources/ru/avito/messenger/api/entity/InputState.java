package ru.avito.messenger.api.entity;

import a2.b.a.a.a;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\f\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J2\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0007J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\t\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\t\u0010\u0004R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007R\u001e\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0018\u0010\u0007¨\u0006\u001b"}, d2 = {"Lru/avito/messenger/api/entity/InputState;", "", "", "component1", "()Z", "", "component2", "()Ljava/lang/String;", "component3", "isDisabled", "reason", "description", "copy", "(ZLjava/lang/String;Ljava/lang/String;)Lru/avito/messenger/api/entity/InputState;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "Ljava/lang/String;", "getDescription", "getReason", "<init>", "(ZLjava/lang/String;Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class InputState {
    @SerializedName("description")
    @Nullable
    private final String description;
    @SerializedName("isDisabled")
    private final boolean isDisabled;
    @SerializedName("reason")
    @Nullable
    private final String reason;

    public InputState(boolean z, @Nullable String str, @Nullable String str2) {
        this.isDisabled = z;
        this.reason = str;
        this.description = str2;
    }

    public static /* synthetic */ InputState copy$default(InputState inputState, boolean z, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = inputState.isDisabled;
        }
        if ((i & 2) != 0) {
            str = inputState.reason;
        }
        if ((i & 4) != 0) {
            str2 = inputState.description;
        }
        return inputState.copy(z, str, str2);
    }

    public final boolean component1() {
        return this.isDisabled;
    }

    @Nullable
    public final String component2() {
        return this.reason;
    }

    @Nullable
    public final String component3() {
        return this.description;
    }

    @NotNull
    public final InputState copy(boolean z, @Nullable String str, @Nullable String str2) {
        return new InputState(z, str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InputState)) {
            return false;
        }
        InputState inputState = (InputState) obj;
        return this.isDisabled == inputState.isDisabled && Intrinsics.areEqual(this.reason, inputState.reason) && Intrinsics.areEqual(this.description, inputState.description);
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final String getReason() {
        return this.reason;
    }

    public int hashCode() {
        boolean z = this.isDisabled;
        if (z) {
            z = true;
        }
        int i = z ? 1 : 0;
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = i * 31;
        String str = this.reason;
        int i5 = 0;
        int hashCode = (i4 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.description;
        if (str2 != null) {
            i5 = str2.hashCode();
        }
        return hashCode + i5;
    }

    public final boolean isDisabled() {
        return this.isDisabled;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("InputState(isDisabled=");
        L.append(this.isDisabled);
        L.append(", reason=");
        L.append(this.reason);
        L.append(", description=");
        return a.t(L, this.description, ")");
    }
}
