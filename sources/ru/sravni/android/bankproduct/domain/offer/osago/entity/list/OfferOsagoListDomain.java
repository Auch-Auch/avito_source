package ru.sravni.android.bankproduct.domain.offer.osago.entity.list;

import a2.b.a.a.a;
import a2.g.r.g;
import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.domain.offer.entity.OfferFilterDomain;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0018\b\b\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\t\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00100\f¢\u0006\u0004\b7\u00108J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\fHÆ\u0003¢\u0006\u0004\b\u0011\u0010\u000fJl\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\t2\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00100\fHÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0004J\u0010\u0010\u001e\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010\"\u001a\u00020!2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\"\u0010#R\u0019\u0010\u0017\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010\u000bR\u0019\u0010\u0014\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010\u0004R\u0019\u0010\u0015\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010(\u001a\u0004\b+\u0010\u0004R\u001f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00100\f8\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010\u000fR\u0019\u0010\u0016\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010(\u001a\u0004\b0\u0010\u0004R\u0019\u0010\u0013\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b1\u0010(\u001a\u0004\b2\u0010\u0004R\u0019\u0010\u0012\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b3\u0010(\u001a\u0004\b4\u0010\u0004R\u001f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006@\u0006¢\u0006\f\n\u0004\b5\u0010-\u001a\u0004\b6\u0010\u000f¨\u00069"}, d2 = {"Lru/sravni/android/bankproduct/domain/offer/osago/entity/list/OfferOsagoListDomain;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "", "component6", "()J", "", "Lru/sravni/android/bankproduct/domain/offer/entity/OfferFilterDomain;", "component7", "()Ljava/util/List;", "Lru/sravni/android/bankproduct/domain/offer/osago/entity/list/OfferOsagoItemDomain;", "component8", "topHeaderTitle", "recommendedDate", "conversationID", "savedSearchID", "pollingID", "pollingInterval", "filters", "listOffers", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/util/List;Ljava/util/List;)Lru/sravni/android/bankproduct/domain/offer/osago/entity/list/OfferOsagoListDomain;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "f", "J", "getPollingInterval", "c", "Ljava/lang/String;", "getConversationID", "d", "getSavedSearchID", "h", "Ljava/util/List;", "getListOffers", "e", "getPollingID", AuthSource.BOOKING_ORDER, "getRecommendedDate", AuthSource.SEND_ABUSE, "getTopHeaderTitle", g.a, "getFilters", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/util/List;Ljava/util/List;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OfferOsagoListDomain {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @NotNull
    public final String c;
    @NotNull
    public final String d;
    @NotNull
    public final String e;
    public final long f;
    @NotNull
    public final List<OfferFilterDomain> g;
    @NotNull
    public final List<OfferOsagoItemDomain> h;

    public OfferOsagoListDomain(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, long j, @NotNull List<OfferFilterDomain> list, @NotNull List<OfferOsagoItemDomain> list2) {
        Intrinsics.checkParameterIsNotNull(str, "topHeaderTitle");
        Intrinsics.checkParameterIsNotNull(str2, "recommendedDate");
        Intrinsics.checkParameterIsNotNull(str3, "conversationID");
        Intrinsics.checkParameterIsNotNull(str4, "savedSearchID");
        Intrinsics.checkParameterIsNotNull(str5, "pollingID");
        Intrinsics.checkParameterIsNotNull(list, "filters");
        Intrinsics.checkParameterIsNotNull(list2, "listOffers");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = j;
        this.g = list;
        this.h = list2;
    }

    public static /* synthetic */ OfferOsagoListDomain copy$default(OfferOsagoListDomain offerOsagoListDomain, String str, String str2, String str3, String str4, String str5, long j, List list, List list2, int i, Object obj) {
        return offerOsagoListDomain.copy((i & 1) != 0 ? offerOsagoListDomain.a : str, (i & 2) != 0 ? offerOsagoListDomain.b : str2, (i & 4) != 0 ? offerOsagoListDomain.c : str3, (i & 8) != 0 ? offerOsagoListDomain.d : str4, (i & 16) != 0 ? offerOsagoListDomain.e : str5, (i & 32) != 0 ? offerOsagoListDomain.f : j, (i & 64) != 0 ? offerOsagoListDomain.g : list, (i & 128) != 0 ? offerOsagoListDomain.h : list2);
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
    public final String component4() {
        return this.d;
    }

    @NotNull
    public final String component5() {
        return this.e;
    }

    public final long component6() {
        return this.f;
    }

    @NotNull
    public final List<OfferFilterDomain> component7() {
        return this.g;
    }

    @NotNull
    public final List<OfferOsagoItemDomain> component8() {
        return this.h;
    }

    @NotNull
    public final OfferOsagoListDomain copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, long j, @NotNull List<OfferFilterDomain> list, @NotNull List<OfferOsagoItemDomain> list2) {
        Intrinsics.checkParameterIsNotNull(str, "topHeaderTitle");
        Intrinsics.checkParameterIsNotNull(str2, "recommendedDate");
        Intrinsics.checkParameterIsNotNull(str3, "conversationID");
        Intrinsics.checkParameterIsNotNull(str4, "savedSearchID");
        Intrinsics.checkParameterIsNotNull(str5, "pollingID");
        Intrinsics.checkParameterIsNotNull(list, "filters");
        Intrinsics.checkParameterIsNotNull(list2, "listOffers");
        return new OfferOsagoListDomain(str, str2, str3, str4, str5, j, list, list2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OfferOsagoListDomain)) {
            return false;
        }
        OfferOsagoListDomain offerOsagoListDomain = (OfferOsagoListDomain) obj;
        return Intrinsics.areEqual(this.a, offerOsagoListDomain.a) && Intrinsics.areEqual(this.b, offerOsagoListDomain.b) && Intrinsics.areEqual(this.c, offerOsagoListDomain.c) && Intrinsics.areEqual(this.d, offerOsagoListDomain.d) && Intrinsics.areEqual(this.e, offerOsagoListDomain.e) && this.f == offerOsagoListDomain.f && Intrinsics.areEqual(this.g, offerOsagoListDomain.g) && Intrinsics.areEqual(this.h, offerOsagoListDomain.h);
    }

    @NotNull
    public final String getConversationID() {
        return this.c;
    }

    @NotNull
    public final List<OfferFilterDomain> getFilters() {
        return this.g;
    }

    @NotNull
    public final List<OfferOsagoItemDomain> getListOffers() {
        return this.h;
    }

    @NotNull
    public final String getPollingID() {
        return this.e;
    }

    public final long getPollingInterval() {
        return this.f;
    }

    @NotNull
    public final String getRecommendedDate() {
        return this.b;
    }

    @NotNull
    public final String getSavedSearchID() {
        return this.d;
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
        String str4 = this.d;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.e;
        int hashCode5 = (((hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31) + c.a(this.f)) * 31;
        List<OfferFilterDomain> list = this.g;
        int hashCode6 = (hashCode5 + (list != null ? list.hashCode() : 0)) * 31;
        List<OfferOsagoItemDomain> list2 = this.h;
        if (list2 != null) {
            i = list2.hashCode();
        }
        return hashCode6 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("OfferOsagoListDomain(topHeaderTitle=");
        L.append(this.a);
        L.append(", recommendedDate=");
        L.append(this.b);
        L.append(", conversationID=");
        L.append(this.c);
        L.append(", savedSearchID=");
        L.append(this.d);
        L.append(", pollingID=");
        L.append(this.e);
        L.append(", pollingInterval=");
        L.append(this.f);
        L.append(", filters=");
        L.append(this.g);
        L.append(", listOffers=");
        return a.w(L, this.h, ")");
    }
}
