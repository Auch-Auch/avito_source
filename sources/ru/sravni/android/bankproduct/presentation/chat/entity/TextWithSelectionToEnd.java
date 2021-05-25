package ru.sravni.android.bankproduct.presentation.chat.entity;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004¨\u0006\u001b"}, d2 = {"Lru/sravni/android/bankproduct/presentation/chat/entity/TextWithSelectionToEnd;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()Z", "text", "needMoveSelectionToEnd", "copy", "(Ljava/lang/String;Z)Lru/sravni/android/bankproduct/presentation/chat/entity/TextWithSelectionToEnd;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Z", "getNeedMoveSelectionToEnd", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getText", "<init>", "(Ljava/lang/String;Z)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class TextWithSelectionToEnd {
    @NotNull
    public final String a;
    public final boolean b;

    public TextWithSelectionToEnd(@NotNull String str, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "text");
        this.a = str;
        this.b = z;
    }

    public static /* synthetic */ TextWithSelectionToEnd copy$default(TextWithSelectionToEnd textWithSelectionToEnd, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = textWithSelectionToEnd.a;
        }
        if ((i & 2) != 0) {
            z = textWithSelectionToEnd.b;
        }
        return textWithSelectionToEnd.copy(str, z);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    public final boolean component2() {
        return this.b;
    }

    @NotNull
    public final TextWithSelectionToEnd copy(@NotNull String str, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "text");
        return new TextWithSelectionToEnd(str, z);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextWithSelectionToEnd)) {
            return false;
        }
        TextWithSelectionToEnd textWithSelectionToEnd = (TextWithSelectionToEnd) obj;
        return Intrinsics.areEqual(this.a, textWithSelectionToEnd.a) && this.b == textWithSelectionToEnd.b;
    }

    public final boolean getNeedMoveSelectionToEnd() {
        return this.b;
    }

    @NotNull
    public final String getText() {
        return this.a;
    }

    public int hashCode() {
        String str = this.a;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        boolean z = this.b;
        if (z) {
            z = true;
        }
        int i = z ? 1 : 0;
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("TextWithSelectionToEnd(text=");
        L.append(this.a);
        L.append(", needMoveSelectionToEnd=");
        return a.B(L, this.b, ")");
    }
}
