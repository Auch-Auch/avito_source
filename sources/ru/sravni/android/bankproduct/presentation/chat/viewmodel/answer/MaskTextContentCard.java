package ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u001d\b\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\n¢\u0006\u0004\b%\u0010&J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJB\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\nHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004J\u0010\u0010\u0015\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0007J\u001a\u0010\u0017\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0011\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0011\u0010\fR\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001c\u001a\u0004\b\u001f\u0010\u0004R\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\u001c\u001a\u0004\b!\u0010\u0004R\u0019\u0010\u000e\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\u0007¨\u0006'"}, d2 = {"Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/MaskTextContentCard;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()I", "component3", "component4", "", "component5", "()Z", "conversationID", "cardID", "fieldContentName", "mask", "isPhone", "copy", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Z)Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/MaskTextContentCard;", "toString", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "e", "Z", "c", "Ljava/lang/String;", "getFieldContentName", AuthSource.SEND_ABUSE, "getConversationID", "d", "getMask", AuthSource.BOOKING_ORDER, "I", "getCardID", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Z)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class MaskTextContentCard {
    @NotNull
    public final String a;
    public final int b;
    @NotNull
    public final String c;
    @NotNull
    public final String d;
    public final boolean e;

    public MaskTextContentCard(@NotNull String str, int i, @NotNull String str2, @NotNull String str3, boolean z) {
        a.a1(str, "conversationID", str2, "fieldContentName", str3, "mask");
        this.a = str;
        this.b = i;
        this.c = str2;
        this.d = str3;
        this.e = z;
    }

    public static /* synthetic */ MaskTextContentCard copy$default(MaskTextContentCard maskTextContentCard, String str, int i, String str2, String str3, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = maskTextContentCard.a;
        }
        if ((i2 & 2) != 0) {
            i = maskTextContentCard.b;
        }
        if ((i2 & 4) != 0) {
            str2 = maskTextContentCard.c;
        }
        if ((i2 & 8) != 0) {
            str3 = maskTextContentCard.d;
        }
        if ((i2 & 16) != 0) {
            z = maskTextContentCard.e;
        }
        return maskTextContentCard.copy(str, i, str2, str3, z);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    public final int component2() {
        return this.b;
    }

    @NotNull
    public final String component3() {
        return this.c;
    }

    @NotNull
    public final String component4() {
        return this.d;
    }

    public final boolean component5() {
        return this.e;
    }

    @NotNull
    public final MaskTextContentCard copy(@NotNull String str, int i, @NotNull String str2, @NotNull String str3, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "conversationID");
        Intrinsics.checkParameterIsNotNull(str2, "fieldContentName");
        Intrinsics.checkParameterIsNotNull(str3, "mask");
        return new MaskTextContentCard(str, i, str2, str3, z);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MaskTextContentCard)) {
            return false;
        }
        MaskTextContentCard maskTextContentCard = (MaskTextContentCard) obj;
        return Intrinsics.areEqual(this.a, maskTextContentCard.a) && this.b == maskTextContentCard.b && Intrinsics.areEqual(this.c, maskTextContentCard.c) && Intrinsics.areEqual(this.d, maskTextContentCard.d) && this.e == maskTextContentCard.e;
    }

    public final int getCardID() {
        return this.b;
    }

    @NotNull
    public final String getConversationID() {
        return this.a;
    }

    @NotNull
    public final String getFieldContentName() {
        return this.c;
    }

    @NotNull
    public final String getMask() {
        return this.d;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (((str != null ? str.hashCode() : 0) * 31) + this.b) * 31;
        String str2 = this.c;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.d;
        if (str3 != null) {
            i = str3.hashCode();
        }
        int i2 = (hashCode2 + i) * 31;
        boolean z = this.e;
        if (z) {
            z = true;
        }
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        return i2 + i3;
    }

    public final boolean isPhone() {
        return this.e;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("MaskTextContentCard(conversationID=");
        L.append(this.a);
        L.append(", cardID=");
        L.append(this.b);
        L.append(", fieldContentName=");
        L.append(this.c);
        L.append(", mask=");
        L.append(this.d);
        L.append(", isPhone=");
        return a.B(L, this.e, ")");
    }
}
