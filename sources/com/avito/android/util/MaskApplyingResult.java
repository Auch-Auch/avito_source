package com.avito.android.util;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.category_parameters.MaskInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0012\b\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\t¢\u0006\u0004\b'\u0010(J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\f\u0010\u000bJB\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\t2\b\b\u0002\u0010\u0011\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004J\u0010\u0010\u0015\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u000bJ\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004R\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001b\u001a\u0004\b\u001e\u0010\u0004R\u0019\u0010\u0010\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u000bR\u0019\u0010\u0011\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010 \u001a\u0004\b#\u0010\u000bR\u0019\u0010\u000e\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010\u0007¨\u0006)"}, d2 = {"Lcom/avito/android/util/MaskApplyingResult;", "", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/category_parameters/MaskInfo;", "component2", "()Lcom/avito/android/remote/model/category_parameters/MaskInfo;", "component3", "", "component4", "()I", "component5", "sourceText", "mask", "resultText", "cursorPosition", "matchedStartLength", "copy", "(Ljava/lang/String;Lcom/avito/android/remote/model/category_parameters/MaskInfo;Ljava/lang/String;II)Lcom/avito/android/util/MaskApplyingResult;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getSourceText", "c", "getResultText", "d", "I", "getCursorPosition", "e", "getMatchedStartLength", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/category_parameters/MaskInfo;", "getMask", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/category_parameters/MaskInfo;Ljava/lang/String;II)V", "formatters_release"}, k = 1, mv = {1, 4, 2})
public final class MaskApplyingResult {
    @NotNull
    public final String a;
    @NotNull
    public final MaskInfo b;
    @NotNull
    public final String c;
    public final int d;
    public final int e;

    public MaskApplyingResult(@NotNull String str, @NotNull MaskInfo maskInfo, @NotNull String str2, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "sourceText");
        Intrinsics.checkNotNullParameter(maskInfo, "mask");
        Intrinsics.checkNotNullParameter(str2, "resultText");
        this.a = str;
        this.b = maskInfo;
        this.c = str2;
        this.d = i;
        this.e = i2;
    }

    public static /* synthetic */ MaskApplyingResult copy$default(MaskApplyingResult maskApplyingResult, String str, MaskInfo maskInfo, String str2, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = maskApplyingResult.a;
        }
        if ((i3 & 2) != 0) {
            maskInfo = maskApplyingResult.b;
        }
        if ((i3 & 4) != 0) {
            str2 = maskApplyingResult.c;
        }
        if ((i3 & 8) != 0) {
            i = maskApplyingResult.d;
        }
        if ((i3 & 16) != 0) {
            i2 = maskApplyingResult.e;
        }
        return maskApplyingResult.copy(str, maskInfo, str2, i, i2);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    @NotNull
    public final MaskInfo component2() {
        return this.b;
    }

    @NotNull
    public final String component3() {
        return this.c;
    }

    public final int component4() {
        return this.d;
    }

    public final int component5() {
        return this.e;
    }

    @NotNull
    public final MaskApplyingResult copy(@NotNull String str, @NotNull MaskInfo maskInfo, @NotNull String str2, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "sourceText");
        Intrinsics.checkNotNullParameter(maskInfo, "mask");
        Intrinsics.checkNotNullParameter(str2, "resultText");
        return new MaskApplyingResult(str, maskInfo, str2, i, i2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MaskApplyingResult)) {
            return false;
        }
        MaskApplyingResult maskApplyingResult = (MaskApplyingResult) obj;
        return Intrinsics.areEqual(this.a, maskApplyingResult.a) && Intrinsics.areEqual(this.b, maskApplyingResult.b) && Intrinsics.areEqual(this.c, maskApplyingResult.c) && this.d == maskApplyingResult.d && this.e == maskApplyingResult.e;
    }

    public final int getCursorPosition() {
        return this.d;
    }

    @NotNull
    public final MaskInfo getMask() {
        return this.b;
    }

    public final int getMatchedStartLength() {
        return this.e;
    }

    @NotNull
    public final String getResultText() {
        return this.c;
    }

    @NotNull
    public final String getSourceText() {
        return this.a;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        MaskInfo maskInfo = this.b;
        int hashCode2 = (hashCode + (maskInfo != null ? maskInfo.hashCode() : 0)) * 31;
        String str2 = this.c;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return ((((hashCode2 + i) * 31) + this.d) * 31) + this.e;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("MaskApplyingResult(sourceText=");
        L.append(this.a);
        L.append(", mask=");
        L.append(this.b);
        L.append(", resultText=");
        L.append(this.c);
        L.append(", cursorPosition=");
        L.append(this.d);
        L.append(", matchedStartLength=");
        return a.j(L, this.e, ")");
    }
}
