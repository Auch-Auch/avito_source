package com.redmadrobot.inputmask.model;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0010\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ.\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0007J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0015\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\r\u0010\n¨\u0006!"}, d2 = {"Lcom/redmadrobot/inputmask/model/Notation;", "", "", "component1", "()C", "", "component2", "()Ljava/lang/String;", "", "component3", "()Z", FirebaseAnalytics.Param.CHARACTER, "characterSet", "isOptional", "copy", "(CLjava/lang/String;Z)Lcom/redmadrobot/inputmask/model/Notation;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getCharacterSet", AuthSource.SEND_ABUSE, "C", "getCharacter", "c", "Z", "<init>", "(CLjava/lang/String;Z)V", "input-mask-android_release"}, k = 1, mv = {1, 4, 0})
public final class Notation {
    public final char a;
    @NotNull
    public final String b;
    public final boolean c;

    public Notation(char c2, @NotNull String str, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "characterSet");
        this.a = c2;
        this.b = str;
        this.c = z;
    }

    @NotNull
    public static /* synthetic */ Notation copy$default(Notation notation, char c2, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            c2 = notation.a;
        }
        if ((i & 2) != 0) {
            str = notation.b;
        }
        if ((i & 4) != 0) {
            z = notation.c;
        }
        return notation.copy(c2, str, z);
    }

    public final char component1() {
        return this.a;
    }

    @NotNull
    public final String component2() {
        return this.b;
    }

    public final boolean component3() {
        return this.c;
    }

    @NotNull
    public final Notation copy(char c2, @NotNull String str, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "characterSet");
        return new Notation(c2, str, z);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof Notation) {
                Notation notation = (Notation) obj;
                if ((this.a == notation.a) && Intrinsics.areEqual(this.b, notation.b)) {
                    if (this.c == notation.c) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final char getCharacter() {
        return this.a;
    }

    @NotNull
    public final String getCharacterSet() {
        return this.b;
    }

    public int hashCode() {
        int i = this.a * 31;
        String str = this.b;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        boolean z = this.c;
        if (z) {
            z = true;
        }
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        return hashCode + i2;
    }

    public final boolean isOptional() {
        return this.c;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("Notation(character=");
        L.append(this.a);
        L.append(", characterSet=");
        L.append(this.b);
        L.append(", isOptional=");
        return a.B(L, this.c, ")");
    }
}
