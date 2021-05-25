package ru.sravni.android.bankproduct.network.profile.request;

import a2.b.a.a.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J.\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0016\u0010\u0004R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0017\u0010\u0004¨\u0006\u001a"}, d2 = {"Lru/sravni/android/bankproduct/network/profile/request/UpdateAccountElementRequest;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "value", "oldValue", "fullname", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lru/sravni/android/bankproduct/network/profile/request/UpdateAccountElementRequest;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getFullname", "getOldValue", "getValue", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class UpdateAccountElementRequest {
    @NotNull
    private final String fullname;
    @NotNull
    private final String oldValue;
    @NotNull
    private final String value;

    public UpdateAccountElementRequest(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        a.a1(str, "value", str2, "oldValue", str3, "fullname");
        this.value = str;
        this.oldValue = str2;
        this.fullname = str3;
    }

    public static /* synthetic */ UpdateAccountElementRequest copy$default(UpdateAccountElementRequest updateAccountElementRequest, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = updateAccountElementRequest.value;
        }
        if ((i & 2) != 0) {
            str2 = updateAccountElementRequest.oldValue;
        }
        if ((i & 4) != 0) {
            str3 = updateAccountElementRequest.fullname;
        }
        return updateAccountElementRequest.copy(str, str2, str3);
    }

    @NotNull
    public final String component1() {
        return this.value;
    }

    @NotNull
    public final String component2() {
        return this.oldValue;
    }

    @NotNull
    public final String component3() {
        return this.fullname;
    }

    @NotNull
    public final UpdateAccountElementRequest copy(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkParameterIsNotNull(str, "value");
        Intrinsics.checkParameterIsNotNull(str2, "oldValue");
        Intrinsics.checkParameterIsNotNull(str3, "fullname");
        return new UpdateAccountElementRequest(str, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UpdateAccountElementRequest)) {
            return false;
        }
        UpdateAccountElementRequest updateAccountElementRequest = (UpdateAccountElementRequest) obj;
        return Intrinsics.areEqual(this.value, updateAccountElementRequest.value) && Intrinsics.areEqual(this.oldValue, updateAccountElementRequest.oldValue) && Intrinsics.areEqual(this.fullname, updateAccountElementRequest.fullname);
    }

    @NotNull
    public final String getFullname() {
        return this.fullname;
    }

    @NotNull
    public final String getOldValue() {
        return this.oldValue;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        String str = this.value;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.oldValue;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.fullname;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("UpdateAccountElementRequest(value=");
        L.append(this.value);
        L.append(", oldValue=");
        L.append(this.oldValue);
        L.append(", fullname=");
        return a.t(L, this.fullname, ")");
    }
}
