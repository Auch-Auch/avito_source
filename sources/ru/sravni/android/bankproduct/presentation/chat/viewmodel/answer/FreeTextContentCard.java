package ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0007J\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u0019\u0010\n\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0004¨\u0006\u001e"}, d2 = {"Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/FreeTextContentCard;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()I", "component3", "conversationID", "cardID", "fieldContentName", "copy", "(Ljava/lang/String;ILjava/lang/String;)Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/FreeTextContentCard;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getConversationID", AuthSource.BOOKING_ORDER, "I", "getCardID", "c", "getFieldContentName", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class FreeTextContentCard {
    @NotNull
    public final String a;
    public final int b;
    @NotNull
    public final String c;

    public FreeTextContentCard(@NotNull String str, int i, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "conversationID");
        Intrinsics.checkParameterIsNotNull(str2, "fieldContentName");
        this.a = str;
        this.b = i;
        this.c = str2;
    }

    public static /* synthetic */ FreeTextContentCard copy$default(FreeTextContentCard freeTextContentCard, String str, int i, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = freeTextContentCard.a;
        }
        if ((i2 & 2) != 0) {
            i = freeTextContentCard.b;
        }
        if ((i2 & 4) != 0) {
            str2 = freeTextContentCard.c;
        }
        return freeTextContentCard.copy(str, i, str2);
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
    public final FreeTextContentCard copy(@NotNull String str, int i, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "conversationID");
        Intrinsics.checkParameterIsNotNull(str2, "fieldContentName");
        return new FreeTextContentCard(str, i, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FreeTextContentCard)) {
            return false;
        }
        FreeTextContentCard freeTextContentCard = (FreeTextContentCard) obj;
        return Intrinsics.areEqual(this.a, freeTextContentCard.a) && this.b == freeTextContentCard.b && Intrinsics.areEqual(this.c, freeTextContentCard.c);
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

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (((str != null ? str.hashCode() : 0) * 31) + this.b) * 31;
        String str2 = this.c;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("FreeTextContentCard(conversationID=");
        L.append(this.a);
        L.append(", cardID=");
        L.append(this.b);
        L.append(", fieldContentName=");
        return a.t(L, this.c, ")");
    }
}
