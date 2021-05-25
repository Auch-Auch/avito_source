package ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u000f\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J8\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0011\u0010\bJ\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u0019\u0010\f\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\bR\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u0004R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0017\u001a\u0004\b\u001f\u0010\u0004¨\u0006\""}, d2 = {"Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/InitMaskElementInfo;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()I", "component4", "hint", "mask", "inputType", "suggestText", "copy", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/InitMaskElementInfo;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getHint", "c", "I", "getInputType", AuthSource.BOOKING_ORDER, "getMask", "d", "getSuggestText", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class InitMaskElementInfo {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    public final int c;
    @NotNull
    public final String d;

    public InitMaskElementInfo(@NotNull String str, @NotNull String str2, int i, @NotNull String str3) {
        a.a1(str, "hint", str2, "mask", str3, "suggestText");
        this.a = str;
        this.b = str2;
        this.c = i;
        this.d = str3;
    }

    public static /* synthetic */ InitMaskElementInfo copy$default(InitMaskElementInfo initMaskElementInfo, String str, String str2, int i, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = initMaskElementInfo.a;
        }
        if ((i2 & 2) != 0) {
            str2 = initMaskElementInfo.b;
        }
        if ((i2 & 4) != 0) {
            i = initMaskElementInfo.c;
        }
        if ((i2 & 8) != 0) {
            str3 = initMaskElementInfo.d;
        }
        return initMaskElementInfo.copy(str, str2, i, str3);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    @NotNull
    public final String component2() {
        return this.b;
    }

    public final int component3() {
        return this.c;
    }

    @NotNull
    public final String component4() {
        return this.d;
    }

    @NotNull
    public final InitMaskElementInfo copy(@NotNull String str, @NotNull String str2, int i, @NotNull String str3) {
        Intrinsics.checkParameterIsNotNull(str, "hint");
        Intrinsics.checkParameterIsNotNull(str2, "mask");
        Intrinsics.checkParameterIsNotNull(str3, "suggestText");
        return new InitMaskElementInfo(str, str2, i, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InitMaskElementInfo)) {
            return false;
        }
        InitMaskElementInfo initMaskElementInfo = (InitMaskElementInfo) obj;
        return Intrinsics.areEqual(this.a, initMaskElementInfo.a) && Intrinsics.areEqual(this.b, initMaskElementInfo.b) && this.c == initMaskElementInfo.c && Intrinsics.areEqual(this.d, initMaskElementInfo.d);
    }

    @NotNull
    public final String getHint() {
        return this.a;
    }

    public final int getInputType() {
        return this.c;
    }

    @NotNull
    public final String getMask() {
        return this.b;
    }

    @NotNull
    public final String getSuggestText() {
        return this.d;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        int hashCode2 = (((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.c) * 31;
        String str3 = this.d;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("InitMaskElementInfo(hint=");
        L.append(this.a);
        L.append(", mask=");
        L.append(this.b);
        L.append(", inputType=");
        L.append(this.c);
        L.append(", suggestText=");
        return a.t(L, this.d, ")");
    }
}
