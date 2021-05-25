package ru.sravni.android.bankproduct.domain.offer.product.entity.detail;

import a2.b.a.a.a;
import a2.g.r.g;
import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b \b\b\u0018\u00002\u00020\u0001:\u0001BBo\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\u001a\u001a\u00020\n\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\r0\u0006\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u0002\u0012\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0011\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0014¢\u0006\u0004\b@\u0010AJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u0006HÆ\u0003¢\u0006\u0004\b\u000e\u0010\tJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0004J\u001c\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0001\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00022\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\u001a\u001a\u00020\n2\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\r0\u00062\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u001d\u001a\u00020\u00022\u0014\b\u0002\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00112\b\b\u0002\u0010\u001f\u001a\u00020\u0014HÆ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\"\u0010\u0004J\u0010\u0010$\u001a\u00020#HÖ\u0001¢\u0006\u0004\b$\u0010%J\u001a\u0010'\u001a\u00020\u00142\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b'\u0010(R\u001f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010\tR\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010\u0004R\u001f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\r0\u00068\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010*\u001a\u0004\b0\u0010\tR\u0019\u0010\u001a\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u0010\fR\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b4\u0010-\u001a\u0004\b5\u0010\u0004R\u0019\u0010\u001f\u001a\u00020\u00148\u0006@\u0006¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u0010\u0016R\u0019\u0010\u001d\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b9\u0010-\u001a\u0004\b:\u0010\u0004R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b;\u0010-\u001a\u0004\b<\u0010\u0004R%\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010\u0013¨\u0006C"}, d2 = {"Lru/sravni/android/bankproduct/domain/offer/product/entity/detail/OfferProductDetailDomain;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "Lru/sravni/android/bankproduct/domain/offer/product/entity/detail/OfferProductDetailItemDomain;", "component3", "()Ljava/util/List;", "Lru/sravni/android/bankproduct/domain/offer/product/entity/detail/OfferProductDetailInfoDomain;", "component4", "()Lru/sravni/android/bankproduct/domain/offer/product/entity/detail/OfferProductDetailInfoDomain;", "Lru/sravni/android/bankproduct/domain/offer/product/entity/detail/OfferProductDetailDomain$MainParam;", "component5", "component6", "component7", "", "component8", "()Ljava/util/Map;", "", "component9", "()Z", "bankId", "orderID", "detailParams", "detailInfo", "mainParams", "productId", "requestParams", "requestParamsV2", "extraInfoRequest", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lru/sravni/android/bankproduct/domain/offer/product/entity/detail/OfferProductDetailInfoDomain;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Z)Lru/sravni/android/bankproduct/domain/offer/product/entity/detail/OfferProductDetailDomain;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "c", "Ljava/util/List;", "getDetailParams", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getOrderID", "e", "getMainParams", "d", "Lru/sravni/android/bankproduct/domain/offer/product/entity/detail/OfferProductDetailInfoDomain;", "getDetailInfo", "f", "getProductId", "i", "Z", "getExtraInfoRequest", g.a, "getRequestParams", AuthSource.SEND_ABUSE, "getBankId", "h", "Ljava/util/Map;", "getRequestParamsV2", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lru/sravni/android/bankproduct/domain/offer/product/entity/detail/OfferProductDetailInfoDomain;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Z)V", "MainParam", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OfferProductDetailDomain {
    @Nullable
    public final String a;
    @Nullable
    public final String b;
    @NotNull
    public final List<OfferProductDetailItemDomain> c;
    @NotNull
    public final OfferProductDetailInfoDomain d;
    @NotNull
    public final List<MainParam> e;
    @Nullable
    public final String f;
    @NotNull
    public final String g;
    @NotNull
    public final Map<String, String> h;
    public final boolean i;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J.\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0015\u001a\u0004\b\u0018\u0010\u0004R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0015\u001a\u0004\b\u001a\u0010\u0004¨\u0006\u001d"}, d2 = {"Lru/sravni/android/bankproduct/domain/offer/product/entity/detail/OfferProductDetailDomain$MainParam;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "fontType", "name", "value", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lru/sravni/android/bankproduct/domain/offer/product/entity/detail/OfferProductDetailDomain$MainParam;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getName", "c", "getValue", AuthSource.SEND_ABUSE, "getFontType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
    public static final class MainParam {
        @NotNull
        public final String a;
        @NotNull
        public final String b;
        @NotNull
        public final String c;

        public MainParam(@NotNull String str, @NotNull String str2, @NotNull String str3) {
            a.a1(str, "fontType", str2, "name", str3, "value");
            this.a = str;
            this.b = str2;
            this.c = str3;
        }

        public static /* synthetic */ MainParam copy$default(MainParam mainParam, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = mainParam.a;
            }
            if ((i & 2) != 0) {
                str2 = mainParam.b;
            }
            if ((i & 4) != 0) {
                str3 = mainParam.c;
            }
            return mainParam.copy(str, str2, str3);
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
        public final MainParam copy(@NotNull String str, @NotNull String str2, @NotNull String str3) {
            Intrinsics.checkParameterIsNotNull(str, "fontType");
            Intrinsics.checkParameterIsNotNull(str2, "name");
            Intrinsics.checkParameterIsNotNull(str3, "value");
            return new MainParam(str, str2, str3);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MainParam)) {
                return false;
            }
            MainParam mainParam = (MainParam) obj;
            return Intrinsics.areEqual(this.a, mainParam.a) && Intrinsics.areEqual(this.b, mainParam.b) && Intrinsics.areEqual(this.c, mainParam.c);
        }

        @NotNull
        public final String getFontType() {
            return this.a;
        }

        @NotNull
        public final String getName() {
            return this.b;
        }

        @NotNull
        public final String getValue() {
            return this.c;
        }

        public int hashCode() {
            String str = this.a;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.b;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.c;
            if (str3 != null) {
                i = str3.hashCode();
            }
            return hashCode2 + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("MainParam(fontType=");
            L.append(this.a);
            L.append(", name=");
            L.append(this.b);
            L.append(", value=");
            return a.t(L, this.c, ")");
        }
    }

    public OfferProductDetailDomain(@Nullable String str, @Nullable String str2, @NotNull List<OfferProductDetailItemDomain> list, @NotNull OfferProductDetailInfoDomain offerProductDetailInfoDomain, @NotNull List<MainParam> list2, @Nullable String str3, @NotNull String str4, @NotNull Map<String, String> map, boolean z) {
        Intrinsics.checkParameterIsNotNull(list, "detailParams");
        Intrinsics.checkParameterIsNotNull(offerProductDetailInfoDomain, "detailInfo");
        Intrinsics.checkParameterIsNotNull(list2, "mainParams");
        Intrinsics.checkParameterIsNotNull(str4, "requestParams");
        Intrinsics.checkParameterIsNotNull(map, "requestParamsV2");
        this.a = str;
        this.b = str2;
        this.c = list;
        this.d = offerProductDetailInfoDomain;
        this.e = list2;
        this.f = str3;
        this.g = str4;
        this.h = map;
        this.i = z;
    }

    public static /* synthetic */ OfferProductDetailDomain copy$default(OfferProductDetailDomain offerProductDetailDomain, String str, String str2, List list, OfferProductDetailInfoDomain offerProductDetailInfoDomain, List list2, String str3, String str4, Map map, boolean z, int i2, Object obj) {
        return offerProductDetailDomain.copy((i2 & 1) != 0 ? offerProductDetailDomain.a : str, (i2 & 2) != 0 ? offerProductDetailDomain.b : str2, (i2 & 4) != 0 ? offerProductDetailDomain.c : list, (i2 & 8) != 0 ? offerProductDetailDomain.d : offerProductDetailInfoDomain, (i2 & 16) != 0 ? offerProductDetailDomain.e : list2, (i2 & 32) != 0 ? offerProductDetailDomain.f : str3, (i2 & 64) != 0 ? offerProductDetailDomain.g : str4, (i2 & 128) != 0 ? offerProductDetailDomain.h : map, (i2 & 256) != 0 ? offerProductDetailDomain.i : z);
    }

    @Nullable
    public final String component1() {
        return this.a;
    }

    @Nullable
    public final String component2() {
        return this.b;
    }

    @NotNull
    public final List<OfferProductDetailItemDomain> component3() {
        return this.c;
    }

    @NotNull
    public final OfferProductDetailInfoDomain component4() {
        return this.d;
    }

    @NotNull
    public final List<MainParam> component5() {
        return this.e;
    }

    @Nullable
    public final String component6() {
        return this.f;
    }

    @NotNull
    public final String component7() {
        return this.g;
    }

    @NotNull
    public final Map<String, String> component8() {
        return this.h;
    }

    public final boolean component9() {
        return this.i;
    }

    @NotNull
    public final OfferProductDetailDomain copy(@Nullable String str, @Nullable String str2, @NotNull List<OfferProductDetailItemDomain> list, @NotNull OfferProductDetailInfoDomain offerProductDetailInfoDomain, @NotNull List<MainParam> list2, @Nullable String str3, @NotNull String str4, @NotNull Map<String, String> map, boolean z) {
        Intrinsics.checkParameterIsNotNull(list, "detailParams");
        Intrinsics.checkParameterIsNotNull(offerProductDetailInfoDomain, "detailInfo");
        Intrinsics.checkParameterIsNotNull(list2, "mainParams");
        Intrinsics.checkParameterIsNotNull(str4, "requestParams");
        Intrinsics.checkParameterIsNotNull(map, "requestParamsV2");
        return new OfferProductDetailDomain(str, str2, list, offerProductDetailInfoDomain, list2, str3, str4, map, z);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OfferProductDetailDomain)) {
            return false;
        }
        OfferProductDetailDomain offerProductDetailDomain = (OfferProductDetailDomain) obj;
        return Intrinsics.areEqual(this.a, offerProductDetailDomain.a) && Intrinsics.areEqual(this.b, offerProductDetailDomain.b) && Intrinsics.areEqual(this.c, offerProductDetailDomain.c) && Intrinsics.areEqual(this.d, offerProductDetailDomain.d) && Intrinsics.areEqual(this.e, offerProductDetailDomain.e) && Intrinsics.areEqual(this.f, offerProductDetailDomain.f) && Intrinsics.areEqual(this.g, offerProductDetailDomain.g) && Intrinsics.areEqual(this.h, offerProductDetailDomain.h) && this.i == offerProductDetailDomain.i;
    }

    @Nullable
    public final String getBankId() {
        return this.a;
    }

    @NotNull
    public final OfferProductDetailInfoDomain getDetailInfo() {
        return this.d;
    }

    @NotNull
    public final List<OfferProductDetailItemDomain> getDetailParams() {
        return this.c;
    }

    public final boolean getExtraInfoRequest() {
        return this.i;
    }

    @NotNull
    public final List<MainParam> getMainParams() {
        return this.e;
    }

    @Nullable
    public final String getOrderID() {
        return this.b;
    }

    @Nullable
    public final String getProductId() {
        return this.f;
    }

    @NotNull
    public final String getRequestParams() {
        return this.g;
    }

    @NotNull
    public final Map<String, String> getRequestParamsV2() {
        return this.h;
    }

    public int hashCode() {
        String str = this.a;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        List<OfferProductDetailItemDomain> list = this.c;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        OfferProductDetailInfoDomain offerProductDetailInfoDomain = this.d;
        int hashCode4 = (hashCode3 + (offerProductDetailInfoDomain != null ? offerProductDetailInfoDomain.hashCode() : 0)) * 31;
        List<MainParam> list2 = this.e;
        int hashCode5 = (hashCode4 + (list2 != null ? list2.hashCode() : 0)) * 31;
        String str3 = this.f;
        int hashCode6 = (hashCode5 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.g;
        int hashCode7 = (hashCode6 + (str4 != null ? str4.hashCode() : 0)) * 31;
        Map<String, String> map = this.h;
        if (map != null) {
            i2 = map.hashCode();
        }
        int i3 = (hashCode7 + i2) * 31;
        boolean z = this.i;
        if (z) {
            z = true;
        }
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = z ? 1 : 0;
        return i3 + i4;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("OfferProductDetailDomain(bankId=");
        L.append(this.a);
        L.append(", orderID=");
        L.append(this.b);
        L.append(", detailParams=");
        L.append(this.c);
        L.append(", detailInfo=");
        L.append(this.d);
        L.append(", mainParams=");
        L.append(this.e);
        L.append(", productId=");
        L.append(this.f);
        L.append(", requestParams=");
        L.append(this.g);
        L.append(", requestParamsV2=");
        L.append(this.h);
        L.append(", extraInfoRequest=");
        return a.B(L, this.i, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OfferProductDetailDomain(String str, String str2, List list, OfferProductDetailInfoDomain offerProductDetailInfoDomain, List list2, String str3, String str4, Map map, boolean z, int i2, j jVar) {
        this(str, str2, list, offerProductDetailInfoDomain, list2, str3, str4, map, (i2 & 256) != 0 ? false : z);
    }
}
