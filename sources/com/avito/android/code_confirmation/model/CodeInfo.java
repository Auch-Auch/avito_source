package com.avito.android.code_confirmation.model;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ.\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0011\u0010\nJ\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\nR\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0007R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004¨\u0006!"}, d2 = {"Lcom/avito/android/code_confirmation/model/CodeInfo;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()J", "", "component3", "()I", "text", "timeout", "length", "copy", "(Ljava/lang/String;JI)Lcom/avito/android/code_confirmation/model/CodeInfo;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "c", "I", "getLength", AuthSource.BOOKING_ORDER, "J", "getTimeout", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getText", "<init>", "(Ljava/lang/String;JI)V", "code-confirmation_release"}, k = 1, mv = {1, 4, 2})
public final class CodeInfo {
    @NotNull
    public final String a;
    public final long b;
    public final int c;

    public CodeInfo(@NotNull String str, long j, int i) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.a = str;
        this.b = j;
        this.c = i;
    }

    public static /* synthetic */ CodeInfo copy$default(CodeInfo codeInfo, String str, long j, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = codeInfo.a;
        }
        if ((i2 & 2) != 0) {
            j = codeInfo.b;
        }
        if ((i2 & 4) != 0) {
            i = codeInfo.c;
        }
        return codeInfo.copy(str, j, i);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    public final long component2() {
        return this.b;
    }

    public final int component3() {
        return this.c;
    }

    @NotNull
    public final CodeInfo copy(@NotNull String str, long j, int i) {
        Intrinsics.checkNotNullParameter(str, "text");
        return new CodeInfo(str, j, i);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CodeInfo)) {
            return false;
        }
        CodeInfo codeInfo = (CodeInfo) obj;
        return Intrinsics.areEqual(this.a, codeInfo.a) && this.b == codeInfo.b && this.c == codeInfo.c;
    }

    public final int getLength() {
        return this.c;
    }

    @NotNull
    public final String getText() {
        return this.a;
    }

    public final long getTimeout() {
        return this.b;
    }

    public int hashCode() {
        String str = this.a;
        return ((((str != null ? str.hashCode() : 0) * 31) + c.a(this.b)) * 31) + this.c;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("CodeInfo(text=");
        L.append(this.a);
        L.append(", timeout=");
        L.append(this.b);
        L.append(", length=");
        return a.j(L, this.c, ")");
    }
}
