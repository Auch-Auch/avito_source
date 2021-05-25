package ru.sravni.android.bankproduct.domain.offer.product.entity;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.domain.offer.entity.OfferFilterDomain;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0011\b\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0007¢\u0006\u0004\b(\u0010)J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0007HÆ\u0003¢\u0006\u0004\b\f\u0010\nJN\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0007HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u001f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\nR\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u0004R\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010 \u001a\u0004\b#\u0010\u0004R\u001f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010\u001d\u001a\u0004\b%\u0010\nR\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010 \u001a\u0004\b'\u0010\u0004¨\u0006*"}, d2 = {"Lru/sravni/android/bankproduct/domain/offer/product/entity/OfferProductListDomain;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "", "Lru/sravni/android/bankproduct/domain/offer/entity/OfferFilterDomain;", "component4", "()Ljava/util/List;", "Lru/sravni/android/bankproduct/domain/offer/product/entity/OfferProductItemDomain;", "component5", "topHeaderTitle", "conversationID", "savedSearchID", "filters", "listOffers", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)Lru/sravni/android/bankproduct/domain/offer/product/entity/OfferProductListDomain;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "e", "Ljava/util/List;", "getListOffers", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getConversationID", "c", "getSavedSearchID", "d", "getFilters", AuthSource.SEND_ABUSE, "getTopHeaderTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OfferProductListDomain {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @NotNull
    public final String c;
    @NotNull
    public final List<OfferFilterDomain> d;
    @NotNull
    public final List<OfferProductItemDomain> e;

    public OfferProductListDomain(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull List<OfferFilterDomain> list, @NotNull List<OfferProductItemDomain> list2) {
        Intrinsics.checkParameterIsNotNull(str, "topHeaderTitle");
        Intrinsics.checkParameterIsNotNull(str2, "conversationID");
        Intrinsics.checkParameterIsNotNull(str3, "savedSearchID");
        Intrinsics.checkParameterIsNotNull(list, "filters");
        Intrinsics.checkParameterIsNotNull(list2, "listOffers");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = list;
        this.e = list2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: ru.sravni.android.bankproduct.domain.offer.product.entity.OfferProductListDomain */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OfferProductListDomain copy$default(OfferProductListDomain offerProductListDomain, String str, String str2, String str3, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = offerProductListDomain.a;
        }
        if ((i & 2) != 0) {
            str2 = offerProductListDomain.b;
        }
        if ((i & 4) != 0) {
            str3 = offerProductListDomain.c;
        }
        if ((i & 8) != 0) {
            list = offerProductListDomain.d;
        }
        if ((i & 16) != 0) {
            list2 = offerProductListDomain.e;
        }
        return offerProductListDomain.copy(str, str2, str3, list, list2);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    @NotNull
    public final String component2() {
        return this.b;
    }

    @NotNull
    public final String component3() {
        return this.c;
    }

    @NotNull
    public final List<OfferFilterDomain> component4() {
        return this.d;
    }

    @NotNull
    public final List<OfferProductItemDomain> component5() {
        return this.e;
    }

    @NotNull
    public final OfferProductListDomain copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull List<OfferFilterDomain> list, @NotNull List<OfferProductItemDomain> list2) {
        Intrinsics.checkParameterIsNotNull(str, "topHeaderTitle");
        Intrinsics.checkParameterIsNotNull(str2, "conversationID");
        Intrinsics.checkParameterIsNotNull(str3, "savedSearchID");
        Intrinsics.checkParameterIsNotNull(list, "filters");
        Intrinsics.checkParameterIsNotNull(list2, "listOffers");
        return new OfferProductListDomain(str, str2, str3, list, list2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OfferProductListDomain)) {
            return false;
        }
        OfferProductListDomain offerProductListDomain = (OfferProductListDomain) obj;
        return Intrinsics.areEqual(this.a, offerProductListDomain.a) && Intrinsics.areEqual(this.b, offerProductListDomain.b) && Intrinsics.areEqual(this.c, offerProductListDomain.c) && Intrinsics.areEqual(this.d, offerProductListDomain.d) && Intrinsics.areEqual(this.e, offerProductListDomain.e);
    }

    @NotNull
    public final String getConversationID() {
        return this.b;
    }

    @NotNull
    public final List<OfferFilterDomain> getFilters() {
        return this.d;
    }

    @NotNull
    public final List<OfferProductItemDomain> getListOffers() {
        return this.e;
    }

    @NotNull
    public final String getSavedSearchID() {
        return this.c;
    }

    @NotNull
    public final String getTopHeaderTitle() {
        return this.a;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.c;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        List<OfferFilterDomain> list = this.d;
        int hashCode4 = (hashCode3 + (list != null ? list.hashCode() : 0)) * 31;
        List<OfferProductItemDomain> list2 = this.e;
        if (list2 != null) {
            i = list2.hashCode();
        }
        return hashCode4 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("OfferProductListDomain(topHeaderTitle=");
        L.append(this.a);
        L.append(", conversationID=");
        L.append(this.b);
        L.append(", savedSearchID=");
        L.append(this.c);
        L.append(", filters=");
        L.append(this.d);
        L.append(", listOffers=");
        return a.w(L, this.e, ")");
    }
}
