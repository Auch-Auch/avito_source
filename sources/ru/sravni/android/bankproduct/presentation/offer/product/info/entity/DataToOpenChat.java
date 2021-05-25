package ru.sravni.android.bankproduct.presentation.offer.product.info.entity;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\r\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007¨\u0006\u001b"}, d2 = {"Lru/sravni/android/bankproduct/presentation/offer/product/info/entity/DataToOpenChat;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/lang/Integer;", "conversationID", "cardID", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Lru/sravni/android/bankproduct/presentation/offer/product/info/entity/DataToOpenChat;", "toString", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getConversationID", AuthSource.BOOKING_ORDER, "Ljava/lang/Integer;", "getCardID", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class DataToOpenChat {
    @NotNull
    public final String a;
    @Nullable
    public final Integer b;

    public DataToOpenChat(@NotNull String str, @Nullable Integer num) {
        Intrinsics.checkParameterIsNotNull(str, "conversationID");
        this.a = str;
        this.b = num;
    }

    public static /* synthetic */ DataToOpenChat copy$default(DataToOpenChat dataToOpenChat, String str, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = dataToOpenChat.a;
        }
        if ((i & 2) != 0) {
            num = dataToOpenChat.b;
        }
        return dataToOpenChat.copy(str, num);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    @Nullable
    public final Integer component2() {
        return this.b;
    }

    @NotNull
    public final DataToOpenChat copy(@NotNull String str, @Nullable Integer num) {
        Intrinsics.checkParameterIsNotNull(str, "conversationID");
        return new DataToOpenChat(str, num);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DataToOpenChat)) {
            return false;
        }
        DataToOpenChat dataToOpenChat = (DataToOpenChat) obj;
        return Intrinsics.areEqual(this.a, dataToOpenChat.a) && Intrinsics.areEqual(this.b, dataToOpenChat.b);
    }

    @Nullable
    public final Integer getCardID() {
        return this.b;
    }

    @NotNull
    public final String getConversationID() {
        return this.a;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Integer num = this.b;
        if (num != null) {
            i = num.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("DataToOpenChat(conversationID=");
        L.append(this.a);
        L.append(", cardID=");
        return a.p(L, this.b, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DataToOpenChat(String str, Integer num, int i, j jVar) {
        this(str, (i & 2) != 0 ? null : num);
    }
}
