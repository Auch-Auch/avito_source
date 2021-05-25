package ru.sravni.android.bankproduct.presentation.offer.product.info.entity;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.domain.offer.entity.OfferFilterInfoDomain;
import ru.sravni.android.bankproduct.domain.offer.product.entity.detail.OfferProductDetailDomain;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0011\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\f¢\u0006\u0004\b+\u0010,J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ>\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\fHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u0004R\u0019\u0010\u0011\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\u000bR\u001f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\bR\u0019\u0010\u0012\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010\u000e¨\u0006-"}, d2 = {"Lru/sravni/android/bankproduct/presentation/offer/product/info/entity/OfferProductDetailInfoFromList;", "", "Lru/sravni/android/bankproduct/presentation/offer/product/info/entity/OfferProductDetailInfoAnalytic;", "component1", "()Lru/sravni/android/bankproduct/presentation/offer/product/info/entity/OfferProductDetailInfoAnalytic;", "", "Lru/sravni/android/bankproduct/domain/offer/entity/OfferFilterInfoDomain;", "component2", "()Ljava/util/List;", "Lru/sravni/android/bankproduct/domain/offer/product/entity/detail/OfferProductDetailDomain;", "component3", "()Lru/sravni/android/bankproduct/domain/offer/product/entity/detail/OfferProductDetailDomain;", "Lru/sravni/android/bankproduct/presentation/offer/product/info/entity/DataToOpenChat;", "component4", "()Lru/sravni/android/bankproduct/presentation/offer/product/info/entity/DataToOpenChat;", "analyticInfo", "listFilter", "offerInfoForDomain", "dataToOpenChat", "copy", "(Lru/sravni/android/bankproduct/presentation/offer/product/info/entity/OfferProductDetailInfoAnalytic;Ljava/util/List;Lru/sravni/android/bankproduct/domain/offer/product/entity/detail/OfferProductDetailDomain;Lru/sravni/android/bankproduct/presentation/offer/product/info/entity/DataToOpenChat;)Lru/sravni/android/bankproduct/presentation/offer/product/info/entity/OfferProductDetailInfoFromList;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lru/sravni/android/bankproduct/presentation/offer/product/info/entity/OfferProductDetailInfoAnalytic;", "getAnalyticInfo", "c", "Lru/sravni/android/bankproduct/domain/offer/product/entity/detail/OfferProductDetailDomain;", "getOfferInfoForDomain", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "getListFilter", "d", "Lru/sravni/android/bankproduct/presentation/offer/product/info/entity/DataToOpenChat;", "getDataToOpenChat", "<init>", "(Lru/sravni/android/bankproduct/presentation/offer/product/info/entity/OfferProductDetailInfoAnalytic;Ljava/util/List;Lru/sravni/android/bankproduct/domain/offer/product/entity/detail/OfferProductDetailDomain;Lru/sravni/android/bankproduct/presentation/offer/product/info/entity/DataToOpenChat;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OfferProductDetailInfoFromList {
    @NotNull
    public final OfferProductDetailInfoAnalytic a;
    @NotNull
    public final List<OfferFilterInfoDomain> b;
    @NotNull
    public final OfferProductDetailDomain c;
    @NotNull
    public final DataToOpenChat d;

    public OfferProductDetailInfoFromList(@NotNull OfferProductDetailInfoAnalytic offerProductDetailInfoAnalytic, @NotNull List<OfferFilterInfoDomain> list, @NotNull OfferProductDetailDomain offerProductDetailDomain, @NotNull DataToOpenChat dataToOpenChat) {
        Intrinsics.checkParameterIsNotNull(offerProductDetailInfoAnalytic, "analyticInfo");
        Intrinsics.checkParameterIsNotNull(list, "listFilter");
        Intrinsics.checkParameterIsNotNull(offerProductDetailDomain, "offerInfoForDomain");
        Intrinsics.checkParameterIsNotNull(dataToOpenChat, "dataToOpenChat");
        this.a = offerProductDetailInfoAnalytic;
        this.b = list;
        this.c = offerProductDetailDomain;
        this.d = dataToOpenChat;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: ru.sravni.android.bankproduct.presentation.offer.product.info.entity.OfferProductDetailInfoFromList */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OfferProductDetailInfoFromList copy$default(OfferProductDetailInfoFromList offerProductDetailInfoFromList, OfferProductDetailInfoAnalytic offerProductDetailInfoAnalytic, List list, OfferProductDetailDomain offerProductDetailDomain, DataToOpenChat dataToOpenChat, int i, Object obj) {
        if ((i & 1) != 0) {
            offerProductDetailInfoAnalytic = offerProductDetailInfoFromList.a;
        }
        if ((i & 2) != 0) {
            list = offerProductDetailInfoFromList.b;
        }
        if ((i & 4) != 0) {
            offerProductDetailDomain = offerProductDetailInfoFromList.c;
        }
        if ((i & 8) != 0) {
            dataToOpenChat = offerProductDetailInfoFromList.d;
        }
        return offerProductDetailInfoFromList.copy(offerProductDetailInfoAnalytic, list, offerProductDetailDomain, dataToOpenChat);
    }

    @NotNull
    public final OfferProductDetailInfoAnalytic component1() {
        return this.a;
    }

    @NotNull
    public final List<OfferFilterInfoDomain> component2() {
        return this.b;
    }

    @NotNull
    public final OfferProductDetailDomain component3() {
        return this.c;
    }

    @NotNull
    public final DataToOpenChat component4() {
        return this.d;
    }

    @NotNull
    public final OfferProductDetailInfoFromList copy(@NotNull OfferProductDetailInfoAnalytic offerProductDetailInfoAnalytic, @NotNull List<OfferFilterInfoDomain> list, @NotNull OfferProductDetailDomain offerProductDetailDomain, @NotNull DataToOpenChat dataToOpenChat) {
        Intrinsics.checkParameterIsNotNull(offerProductDetailInfoAnalytic, "analyticInfo");
        Intrinsics.checkParameterIsNotNull(list, "listFilter");
        Intrinsics.checkParameterIsNotNull(offerProductDetailDomain, "offerInfoForDomain");
        Intrinsics.checkParameterIsNotNull(dataToOpenChat, "dataToOpenChat");
        return new OfferProductDetailInfoFromList(offerProductDetailInfoAnalytic, list, offerProductDetailDomain, dataToOpenChat);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OfferProductDetailInfoFromList)) {
            return false;
        }
        OfferProductDetailInfoFromList offerProductDetailInfoFromList = (OfferProductDetailInfoFromList) obj;
        return Intrinsics.areEqual(this.a, offerProductDetailInfoFromList.a) && Intrinsics.areEqual(this.b, offerProductDetailInfoFromList.b) && Intrinsics.areEqual(this.c, offerProductDetailInfoFromList.c) && Intrinsics.areEqual(this.d, offerProductDetailInfoFromList.d);
    }

    @NotNull
    public final OfferProductDetailInfoAnalytic getAnalyticInfo() {
        return this.a;
    }

    @NotNull
    public final DataToOpenChat getDataToOpenChat() {
        return this.d;
    }

    @NotNull
    public final List<OfferFilterInfoDomain> getListFilter() {
        return this.b;
    }

    @NotNull
    public final OfferProductDetailDomain getOfferInfoForDomain() {
        return this.c;
    }

    public int hashCode() {
        OfferProductDetailInfoAnalytic offerProductDetailInfoAnalytic = this.a;
        int i = 0;
        int hashCode = (offerProductDetailInfoAnalytic != null ? offerProductDetailInfoAnalytic.hashCode() : 0) * 31;
        List<OfferFilterInfoDomain> list = this.b;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        OfferProductDetailDomain offerProductDetailDomain = this.c;
        int hashCode3 = (hashCode2 + (offerProductDetailDomain != null ? offerProductDetailDomain.hashCode() : 0)) * 31;
        DataToOpenChat dataToOpenChat = this.d;
        if (dataToOpenChat != null) {
            i = dataToOpenChat.hashCode();
        }
        return hashCode3 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("OfferProductDetailInfoFromList(analyticInfo=");
        L.append(this.a);
        L.append(", listFilter=");
        L.append(this.b);
        L.append(", offerInfoForDomain=");
        L.append(this.c);
        L.append(", dataToOpenChat=");
        L.append(this.d);
        L.append(")");
        return L.toString();
    }
}
