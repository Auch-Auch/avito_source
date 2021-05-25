package ru.sravni.android.bankproduct.presentation.offer.product.info.entity;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lru/sravni/android/bankproduct/presentation/offer/product/info/entity/OfferProductDetailInfoFromChat;", "", "Lru/sravni/android/bankproduct/presentation/offer/product/info/entity/DataToOpenChat;", "component1", "()Lru/sravni/android/bankproduct/presentation/offer/product/info/entity/DataToOpenChat;", "dataToOpenChat", "copy", "(Lru/sravni/android/bankproduct/presentation/offer/product/info/entity/DataToOpenChat;)Lru/sravni/android/bankproduct/presentation/offer/product/info/entity/OfferProductDetailInfoFromChat;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lru/sravni/android/bankproduct/presentation/offer/product/info/entity/DataToOpenChat;", "getDataToOpenChat", "<init>", "(Lru/sravni/android/bankproduct/presentation/offer/product/info/entity/DataToOpenChat;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OfferProductDetailInfoFromChat {
    @NotNull
    public final DataToOpenChat a;

    public OfferProductDetailInfoFromChat(@NotNull DataToOpenChat dataToOpenChat) {
        Intrinsics.checkParameterIsNotNull(dataToOpenChat, "dataToOpenChat");
        this.a = dataToOpenChat;
    }

    public static /* synthetic */ OfferProductDetailInfoFromChat copy$default(OfferProductDetailInfoFromChat offerProductDetailInfoFromChat, DataToOpenChat dataToOpenChat, int i, Object obj) {
        if ((i & 1) != 0) {
            dataToOpenChat = offerProductDetailInfoFromChat.a;
        }
        return offerProductDetailInfoFromChat.copy(dataToOpenChat);
    }

    @NotNull
    public final DataToOpenChat component1() {
        return this.a;
    }

    @NotNull
    public final OfferProductDetailInfoFromChat copy(@NotNull DataToOpenChat dataToOpenChat) {
        Intrinsics.checkParameterIsNotNull(dataToOpenChat, "dataToOpenChat");
        return new OfferProductDetailInfoFromChat(dataToOpenChat);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof OfferProductDetailInfoFromChat) && Intrinsics.areEqual(this.a, ((OfferProductDetailInfoFromChat) obj).a);
        }
        return true;
    }

    @NotNull
    public final DataToOpenChat getDataToOpenChat() {
        return this.a;
    }

    public int hashCode() {
        DataToOpenChat dataToOpenChat = this.a;
        if (dataToOpenChat != null) {
            return dataToOpenChat.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("OfferProductDetailInfoFromChat(dataToOpenChat=");
        L.append(this.a);
        L.append(")");
        return L.toString();
    }
}
