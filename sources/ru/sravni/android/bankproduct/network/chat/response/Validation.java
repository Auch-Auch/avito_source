package ru.sravni.android.bankproduct.network.chat.response;

import a2.b.a.a.a;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B3\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J>\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\u000b\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u001e\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0018\u0010\u0004R\u001e\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0019\u0010\u0004R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u001a\u0010\u0004¨\u0006\u001d"}, d2 = {"Lru/sravni/android/bankproduct/network/chat/response/Validation;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "mask", "maskPlaceholder", "regexp", "required", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lru/sravni/android/bankproduct/network/chat/response/Validation;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getRequired", "getMaskPlaceholder", "getRegexp", "getMask", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class Validation {
    @SerializedName("mask")
    @Nullable
    private final String mask;
    @SerializedName("maskPlaceholder")
    @Nullable
    private final String maskPlaceholder;
    @SerializedName("regexp")
    @Nullable
    private final String regexp;
    @SerializedName("required")
    @NotNull
    private final String required;

    public Validation(@Nullable String str, @Nullable String str2, @Nullable String str3, @NotNull String str4) {
        Intrinsics.checkParameterIsNotNull(str4, "required");
        this.mask = str;
        this.maskPlaceholder = str2;
        this.regexp = str3;
        this.required = str4;
    }

    public static /* synthetic */ Validation copy$default(Validation validation, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = validation.mask;
        }
        if ((i & 2) != 0) {
            str2 = validation.maskPlaceholder;
        }
        if ((i & 4) != 0) {
            str3 = validation.regexp;
        }
        if ((i & 8) != 0) {
            str4 = validation.required;
        }
        return validation.copy(str, str2, str3, str4);
    }

    @Nullable
    public final String component1() {
        return this.mask;
    }

    @Nullable
    public final String component2() {
        return this.maskPlaceholder;
    }

    @Nullable
    public final String component3() {
        return this.regexp;
    }

    @NotNull
    public final String component4() {
        return this.required;
    }

    @NotNull
    public final Validation copy(@Nullable String str, @Nullable String str2, @Nullable String str3, @NotNull String str4) {
        Intrinsics.checkParameterIsNotNull(str4, "required");
        return new Validation(str, str2, str3, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Validation)) {
            return false;
        }
        Validation validation = (Validation) obj;
        return Intrinsics.areEqual(this.mask, validation.mask) && Intrinsics.areEqual(this.maskPlaceholder, validation.maskPlaceholder) && Intrinsics.areEqual(this.regexp, validation.regexp) && Intrinsics.areEqual(this.required, validation.required);
    }

    @Nullable
    public final String getMask() {
        return this.mask;
    }

    @Nullable
    public final String getMaskPlaceholder() {
        return this.maskPlaceholder;
    }

    @Nullable
    public final String getRegexp() {
        return this.regexp;
    }

    @NotNull
    public final String getRequired() {
        return this.required;
    }

    public int hashCode() {
        String str = this.mask;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.maskPlaceholder;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.regexp;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.required;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode3 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("Validation(mask=");
        L.append(this.mask);
        L.append(", maskPlaceholder=");
        L.append(this.maskPlaceholder);
        L.append(", regexp=");
        L.append(this.regexp);
        L.append(", required=");
        return a.t(L, this.required, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Validation(String str, String str2, String str3, String str4, int i, j jVar) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? "*" : str2, (i & 4) != 0 ? null : str3, str4);
    }
}
