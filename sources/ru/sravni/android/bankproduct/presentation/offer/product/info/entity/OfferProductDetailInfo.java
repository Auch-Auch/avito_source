package ru.sravni.android.bankproduct.presentation.offer.product.info.entity;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007R\u001b\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004¨\u0006\u001e"}, d2 = {"Lru/sravni/android/bankproduct/presentation/offer/product/info/entity/OfferProductDetailInfo;", "", "Lru/sravni/android/bankproduct/presentation/offer/product/info/entity/OfferProductDetailInfoFromChat;", "component1", "()Lru/sravni/android/bankproduct/presentation/offer/product/info/entity/OfferProductDetailInfoFromChat;", "Lru/sravni/android/bankproduct/presentation/offer/product/info/entity/OfferProductDetailInfoFromList;", "component2", "()Lru/sravni/android/bankproduct/presentation/offer/product/info/entity/OfferProductDetailInfoFromList;", "detailInfoFromChat", "detailInfoFromList", "copy", "(Lru/sravni/android/bankproduct/presentation/offer/product/info/entity/OfferProductDetailInfoFromChat;Lru/sravni/android/bankproduct/presentation/offer/product/info/entity/OfferProductDetailInfoFromList;)Lru/sravni/android/bankproduct/presentation/offer/product/info/entity/OfferProductDetailInfo;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Lru/sravni/android/bankproduct/presentation/offer/product/info/entity/OfferProductDetailInfoFromList;", "getDetailInfoFromList", AuthSource.SEND_ABUSE, "Lru/sravni/android/bankproduct/presentation/offer/product/info/entity/OfferProductDetailInfoFromChat;", "getDetailInfoFromChat", "<init>", "(Lru/sravni/android/bankproduct/presentation/offer/product/info/entity/OfferProductDetailInfoFromChat;Lru/sravni/android/bankproduct/presentation/offer/product/info/entity/OfferProductDetailInfoFromList;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OfferProductDetailInfo {
    @Nullable
    public final OfferProductDetailInfoFromChat a;
    @Nullable
    public final OfferProductDetailInfoFromList b;

    public OfferProductDetailInfo() {
        this(null, null, 3, null);
    }

    public OfferProductDetailInfo(@Nullable OfferProductDetailInfoFromChat offerProductDetailInfoFromChat, @Nullable OfferProductDetailInfoFromList offerProductDetailInfoFromList) {
        this.a = offerProductDetailInfoFromChat;
        this.b = offerProductDetailInfoFromList;
    }

    public static /* synthetic */ OfferProductDetailInfo copy$default(OfferProductDetailInfo offerProductDetailInfo, OfferProductDetailInfoFromChat offerProductDetailInfoFromChat, OfferProductDetailInfoFromList offerProductDetailInfoFromList, int i, Object obj) {
        if ((i & 1) != 0) {
            offerProductDetailInfoFromChat = offerProductDetailInfo.a;
        }
        if ((i & 2) != 0) {
            offerProductDetailInfoFromList = offerProductDetailInfo.b;
        }
        return offerProductDetailInfo.copy(offerProductDetailInfoFromChat, offerProductDetailInfoFromList);
    }

    @Nullable
    public final OfferProductDetailInfoFromChat component1() {
        return this.a;
    }

    @Nullable
    public final OfferProductDetailInfoFromList component2() {
        return this.b;
    }

    @NotNull
    public final OfferProductDetailInfo copy(@Nullable OfferProductDetailInfoFromChat offerProductDetailInfoFromChat, @Nullable OfferProductDetailInfoFromList offerProductDetailInfoFromList) {
        return new OfferProductDetailInfo(offerProductDetailInfoFromChat, offerProductDetailInfoFromList);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OfferProductDetailInfo)) {
            return false;
        }
        OfferProductDetailInfo offerProductDetailInfo = (OfferProductDetailInfo) obj;
        return Intrinsics.areEqual(this.a, offerProductDetailInfo.a) && Intrinsics.areEqual(this.b, offerProductDetailInfo.b);
    }

    @Nullable
    public final OfferProductDetailInfoFromChat getDetailInfoFromChat() {
        return this.a;
    }

    @Nullable
    public final OfferProductDetailInfoFromList getDetailInfoFromList() {
        return this.b;
    }

    public int hashCode() {
        OfferProductDetailInfoFromChat offerProductDetailInfoFromChat = this.a;
        int i = 0;
        int hashCode = (offerProductDetailInfoFromChat != null ? offerProductDetailInfoFromChat.hashCode() : 0) * 31;
        OfferProductDetailInfoFromList offerProductDetailInfoFromList = this.b;
        if (offerProductDetailInfoFromList != null) {
            i = offerProductDetailInfoFromList.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("OfferProductDetailInfo(detailInfoFromChat=");
        L.append(this.a);
        L.append(", detailInfoFromList=");
        L.append(this.b);
        L.append(")");
        return L.toString();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OfferProductDetailInfo(OfferProductDetailInfoFromChat offerProductDetailInfoFromChat, OfferProductDetailInfoFromList offerProductDetailInfoFromList, int i, j jVar) {
        this((i & 1) != 0 ? null : offerProductDetailInfoFromChat, (i & 2) != 0 ? null : offerProductDetailInfoFromList);
    }
}
