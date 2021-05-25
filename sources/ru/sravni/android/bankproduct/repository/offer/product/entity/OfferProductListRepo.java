package ru.sravni.android.bankproduct.repository.offer.product.entity;

import a2.b.a.a.a;
import a2.g.r.g;
import com.avito.android.publish.residential_complex_search.di.ResidentialComplexModuleKt;
import com.avito.android.remote.auth.AuthSource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.domain.offer.entity.OfferFilterDomain;
import ru.sravni.android.bankproduct.domain.offer.product.entity.OfferProductItemDomain;
import ru.sravni.android.bankproduct.domain.offer.product.entity.OfferProductListDomain;
import ru.sravni.android.bankproduct.domain.offer.product.entity.detail.OfferProductDetailDomain;
import ru.sravni.android.bankproduct.domain.offer.product.entity.detail.OfferProductDetailInfoDomain;
import ru.sravni.android.bankproduct.domain.offer.product.entity.detail.OfferProductDetailItemDomain;
import ru.sravni.android.bankproduct.repository.offer.entity.OfferFilterRepo;
import t6.n.e;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\b\b\u0018\u00002\u00020\u0001:\u00010B;\u0012\u0006\u0010\u0014\u001a\u00020\n\u0012\u0006\u0010\u0015\u001a\u00020\n\u0012\u0006\u0010\u0016\u001a\u00020\n\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0002\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u0002¢\u0006\u0004\b.\u0010/J)\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\r\u0010\fJ\u0010\u0010\u000e\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000e\u0010\fJ\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0011JN\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0014\u001a\u00020\n2\b\b\u0002\u0010\u0015\u001a\u00020\n2\b\b\u0002\u0010\u0016\u001a\u00020\n2\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00022\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u0002HÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u001a\u0010\fJ\u0010\u0010\u001c\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010 \u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b \u0010!R\u001f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\u0011R\u0019\u0010\u0015\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\fR\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00028\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010#\u001a\u0004\b)\u0010\u0011R\u0019\u0010\u0016\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010&\u001a\u0004\b+\u0010\fR\u0019\u0010\u0014\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010&\u001a\u0004\b-\u0010\f¨\u00061"}, d2 = {"Lru/sravni/android/bankproduct/repository/offer/product/entity/OfferProductListRepo;", "", "", "Lru/sravni/android/bankproduct/domain/offer/product/entity/OfferProductItemDomain;", "listOffers", "Lru/sravni/android/bankproduct/domain/offer/entity/OfferFilterDomain;", "filters", "Lru/sravni/android/bankproduct/domain/offer/product/entity/OfferProductListDomain;", "toOfferProductListDomain", "(Ljava/util/List;Ljava/util/List;)Lru/sravni/android/bankproduct/domain/offer/product/entity/OfferProductListDomain;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "Lru/sravni/android/bankproduct/repository/offer/entity/OfferFilterRepo;", "component4", "()Ljava/util/List;", "Lru/sravni/android/bankproduct/repository/offer/product/entity/OfferProductListRepo$OfferGroupRepo;", "component5", "topHeaderTitle", "conversationID", "savedSearchID", "offerGroups", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)Lru/sravni/android/bankproduct/repository/offer/product/entity/OfferProductListRepo;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "e", "Ljava/util/List;", "getOfferGroups", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getConversationID", "d", "getFilters", "c", "getSavedSearchID", AuthSource.SEND_ABUSE, "getTopHeaderTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "OfferGroupRepo", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OfferProductListRepo {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @NotNull
    public final String c;
    @NotNull
    public final List<OfferFilterRepo> d;
    @NotNull
    public final List<OfferGroupRepo> e;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\b\b\u0018\u00002\u00020\u0001:\u0003!\"#B%\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ4\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\tR\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001b\u001a\u0004\b\u001e\u0010\u0004¨\u0006$"}, d2 = {"Lru/sravni/android/bankproduct/repository/offer/product/entity/OfferProductListRepo$OfferGroupRepo;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "Lru/sravni/android/bankproduct/repository/offer/product/entity/OfferProductListRepo$OfferGroupRepo$OfferRepo;", "component3", "()Ljava/util/List;", "titleGroup", "description", "offerList", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lru/sravni/android/bankproduct/repository/offer/product/entity/OfferProductListRepo$OfferGroupRepo;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "c", "Ljava/util/List;", "getOfferList", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getDescription", AuthSource.SEND_ABUSE, "getTitleGroup", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "DetailParamRepo", "MainParamRepo", "OfferRepo", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
    public static final class OfferGroupRepo {
        @NotNull
        public final String a;
        @NotNull
        public final String b;
        @NotNull
        public final List<OfferRepo> c;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001B'\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\u001f\u0010 J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ6\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u001b\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0018\u001a\u0004\b\u001b\u0010\u0004R\u001f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\t¨\u0006!"}, d2 = {"Lru/sravni/android/bankproduct/repository/offer/product/entity/OfferProductListRepo$OfferGroupRepo$DetailParamRepo;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "Lru/sravni/android/bankproduct/repository/offer/product/entity/OfferProductListRepo$OfferGroupRepo$MainParamRepo;", "component3", "()Ljava/util/List;", "detailTitle", "detailType", ResidentialComplexModuleKt.VALUES, "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lru/sravni/android/bankproduct/repository/offer/product/entity/OfferProductListRepo$OfferGroupRepo$DetailParamRepo;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getDetailType", AuthSource.SEND_ABUSE, "getDetailTitle", "c", "Ljava/util/List;", "getValues", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
        public static final class DetailParamRepo {
            @Nullable
            public final String a;
            @NotNull
            public final String b;
            @NotNull
            public final List<MainParamRepo> c;

            public DetailParamRepo(@Nullable String str, @NotNull String str2, @NotNull List<MainParamRepo> list) {
                Intrinsics.checkParameterIsNotNull(str2, "detailType");
                Intrinsics.checkParameterIsNotNull(list, ResidentialComplexModuleKt.VALUES);
                this.a = str;
                this.b = str2;
                this.c = list;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: ru.sravni.android.bankproduct.repository.offer.product.entity.OfferProductListRepo$OfferGroupRepo$DetailParamRepo */
            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ DetailParamRepo copy$default(DetailParamRepo detailParamRepo, String str, String str2, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = detailParamRepo.a;
                }
                if ((i & 2) != 0) {
                    str2 = detailParamRepo.b;
                }
                if ((i & 4) != 0) {
                    list = detailParamRepo.c;
                }
                return detailParamRepo.copy(str, str2, list);
            }

            @Nullable
            public final String component1() {
                return this.a;
            }

            @NotNull
            public final String component2() {
                return this.b;
            }

            @NotNull
            public final List<MainParamRepo> component3() {
                return this.c;
            }

            @NotNull
            public final DetailParamRepo copy(@Nullable String str, @NotNull String str2, @NotNull List<MainParamRepo> list) {
                Intrinsics.checkParameterIsNotNull(str2, "detailType");
                Intrinsics.checkParameterIsNotNull(list, ResidentialComplexModuleKt.VALUES);
                return new DetailParamRepo(str, str2, list);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof DetailParamRepo)) {
                    return false;
                }
                DetailParamRepo detailParamRepo = (DetailParamRepo) obj;
                return Intrinsics.areEqual(this.a, detailParamRepo.a) && Intrinsics.areEqual(this.b, detailParamRepo.b) && Intrinsics.areEqual(this.c, detailParamRepo.c);
            }

            @Nullable
            public final String getDetailTitle() {
                return this.a;
            }

            @NotNull
            public final String getDetailType() {
                return this.b;
            }

            @NotNull
            public final List<MainParamRepo> getValues() {
                return this.c;
            }

            public int hashCode() {
                String str = this.a;
                int i = 0;
                int hashCode = (str != null ? str.hashCode() : 0) * 31;
                String str2 = this.b;
                int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
                List<MainParamRepo> list = this.c;
                if (list != null) {
                    i = list.hashCode();
                }
                return hashCode2 + i;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("DetailParamRepo(detailTitle=");
                L.append(this.a);
                L.append(", detailType=");
                L.append(this.b);
                L.append(", values=");
                return a.w(L, this.c, ")");
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J.\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0015\u001a\u0004\b\u0018\u0010\u0004R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0015\u001a\u0004\b\u001a\u0010\u0004¨\u0006\u001d"}, d2 = {"Lru/sravni/android/bankproduct/repository/offer/product/entity/OfferProductListRepo$OfferGroupRepo$MainParamRepo;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "fontType", "name", "value", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lru/sravni/android/bankproduct/repository/offer/product/entity/OfferProductListRepo$OfferGroupRepo$MainParamRepo;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "c", "Ljava/lang/String;", "getValue", AuthSource.SEND_ABUSE, "getFontType", AuthSource.BOOKING_ORDER, "getName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
        public static final class MainParamRepo {
            @NotNull
            public final String a;
            @NotNull
            public final String b;
            @NotNull
            public final String c;

            public MainParamRepo(@NotNull String str, @NotNull String str2, @NotNull String str3) {
                a.a1(str, "fontType", str2, "name", str3, "value");
                this.a = str;
                this.b = str2;
                this.c = str3;
            }

            public static /* synthetic */ MainParamRepo copy$default(MainParamRepo mainParamRepo, String str, String str2, String str3, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = mainParamRepo.a;
                }
                if ((i & 2) != 0) {
                    str2 = mainParamRepo.b;
                }
                if ((i & 4) != 0) {
                    str3 = mainParamRepo.c;
                }
                return mainParamRepo.copy(str, str2, str3);
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
            public final MainParamRepo copy(@NotNull String str, @NotNull String str2, @NotNull String str3) {
                Intrinsics.checkParameterIsNotNull(str, "fontType");
                Intrinsics.checkParameterIsNotNull(str2, "name");
                Intrinsics.checkParameterIsNotNull(str3, "value");
                return new MainParamRepo(str, str2, str3);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof MainParamRepo)) {
                    return false;
                }
                MainParamRepo mainParamRepo = (MainParamRepo) obj;
                return Intrinsics.areEqual(this.a, mainParamRepo.a) && Intrinsics.areEqual(this.b, mainParamRepo.b) && Intrinsics.areEqual(this.c, mainParamRepo.c);
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
                StringBuilder L = a.L("MainParamRepo(fontType=");
                L.append(this.a);
                L.append(", name=");
                L.append(this.b);
                L.append(", value=");
                return a.t(L, this.c, ")");
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\bC\b\b\u0018\u00002\u00020\u0001B±\u0001\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010&\u001a\u00020\r\u0012\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00100\t\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010)\u001a\u00020\u0005\u0012\b\u0010*\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010+\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010,\u001a\u00020\u0005\u0012\b\u0010-\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010.\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010/\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u00100\u001a\u00020\u0005\u0012\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u001d\u0012\b\b\u0002\u00102\u001a\u00020 ¢\u0006\u0004\ba\u0010bJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\tHÆ\u0003¢\u0006\u0004\b\u0011\u0010\fJ\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0007J\u0010\u0010\u0013\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0007J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0007J\u0010\u0010\u0018\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0007J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0007J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0007J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0007J\u0010\u0010\u001c\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u0007J\u001c\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u001dHÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010!\u001a\u00020 HÆ\u0003¢\u0006\u0004\b!\u0010\"JØ\u0001\u00103\u001a\u00020\u00002\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010%\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010&\u001a\u00020\r2\u000e\b\u0002\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00100\t2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010)\u001a\u00020\u00052\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010,\u001a\u00020\u00052\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u00100\u001a\u00020\u00052\u0014\b\u0002\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u001d2\b\b\u0002\u00102\u001a\u00020 HÆ\u0001¢\u0006\u0004\b3\u00104J\u0010\u00105\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b5\u0010\u0007J\u0010\u00106\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b6\u00107J\u001a\u00109\u001a\u00020 2\b\u00108\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b9\u0010:R\u0019\u0010,\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010\u0007R\u001b\u0010.\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b>\u0010<\u001a\u0004\b?\u0010\u0007R\u001f\u0010%\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010\fR%\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u001d8\u0006@\u0006¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010\u001fR\u0019\u0010)\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\bF\u0010<\u001a\u0004\bG\u0010\u0007R\u0019\u00102\u001a\u00020 8\u0006@\u0006¢\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010\"R\u0019\u00100\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\bK\u0010<\u001a\u0004\bL\u0010\u0007R\u0019\u0010&\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bO\u0010\u000fR\u001b\u0010*\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010\u0016R\u001b\u0010-\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\bS\u0010<\u001a\u0004\bT\u0010\u0007R\u001b\u0010/\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\bU\u0010<\u001a\u0004\bV\u0010\u0007R\u001b\u0010$\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\bW\u0010<\u001a\u0004\bX\u0010\u0007R\u001b\u0010+\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\bY\u0010<\u001a\u0004\bZ\u0010\u0007R\u001b\u0010#\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b[\u0010<\u001a\u0004\b\\\u0010\u0007R\u001f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00100\t8\u0006@\u0006¢\u0006\f\n\u0004\b]\u0010A\u001a\u0004\b^\u0010\fR\u001b\u0010(\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b_\u0010<\u001a\u0004\b`\u0010\u0007¨\u0006c"}, d2 = {"Lru/sravni/android/bankproduct/repository/offer/product/entity/OfferProductListRepo$OfferGroupRepo$OfferRepo;", "", "Lru/sravni/android/bankproduct/domain/offer/product/entity/detail/OfferProductDetailDomain;", "toOfferProductDetailDomain", "()Lru/sravni/android/bankproduct/domain/offer/product/entity/detail/OfferProductDetailDomain;", "", "component1", "()Ljava/lang/String;", "component2", "", "Lru/sravni/android/bankproduct/repository/offer/product/entity/OfferProductListRepo$OfferGroupRepo$DetailParamRepo;", "component3", "()Ljava/util/List;", "Lru/sravni/android/bankproduct/repository/offer/product/entity/OfferProductDisplaySettingsRepo;", "component4", "()Lru/sravni/android/bankproduct/repository/offer/product/entity/OfferProductDisplaySettingsRepo;", "Lru/sravni/android/bankproduct/repository/offer/product/entity/OfferProductListRepo$OfferGroupRepo$MainParamRepo;", "component5", "component6", "component7", "", "component8", "()Ljava/lang/Integer;", "component9", "component10", "component11", "component12", "component13", "component14", "", "component15", "()Ljava/util/Map;", "", "component16", "()Z", "bankId", "orderID", "detailParams", "displaySettings", "mainParams", "productId", "productType", "profitability", "profitabilityText", "status", "statusText", "url", "urlText", "requestParams", "requestParamsV2", "extraInfoRequest", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lru/sravni/android/bankproduct/repository/offer/product/entity/OfferProductDisplaySettingsRepo;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Z)Lru/sravni/android/bankproduct/repository/offer/product/entity/OfferProductListRepo$OfferGroupRepo$OfferRepo;", "toString", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "j", "Ljava/lang/String;", "getStatus", "l", "getUrl", "c", "Ljava/util/List;", "getDetailParams", "o", "Ljava/util/Map;", "getRequestParamsV2", g.a, "getProductType", "p", "Z", "getExtraInfoRequest", "n", "getRequestParams", "d", "Lru/sravni/android/bankproduct/repository/offer/product/entity/OfferProductDisplaySettingsRepo;", "getDisplaySettings", "h", "Ljava/lang/Integer;", "getProfitability", "k", "getStatusText", AuthSource.OPEN_CHANNEL_LIST, "getUrlText", AuthSource.BOOKING_ORDER, "getOrderID", "i", "getProfitabilityText", AuthSource.SEND_ABUSE, "getBankId", "e", "getMainParams", "f", "getProductId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lru/sravni/android/bankproduct/repository/offer/product/entity/OfferProductDisplaySettingsRepo;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Z)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
        public static final class OfferRepo {
            @Nullable
            public final String a;
            @Nullable
            public final String b;
            @NotNull
            public final List<DetailParamRepo> c;
            @NotNull
            public final OfferProductDisplaySettingsRepo d;
            @NotNull
            public final List<MainParamRepo> e;
            @Nullable
            public final String f;
            @NotNull
            public final String g;
            @Nullable
            public final Integer h;
            @Nullable
            public final String i;
            @NotNull
            public final String j;
            @Nullable
            public final String k;
            @Nullable
            public final String l;
            @Nullable
            public final String m;
            @NotNull
            public final String n;
            @NotNull
            public final Map<String, String> o;
            public final boolean p;

            public OfferRepo(@Nullable String str, @Nullable String str2, @NotNull List<DetailParamRepo> list, @NotNull OfferProductDisplaySettingsRepo offerProductDisplaySettingsRepo, @NotNull List<MainParamRepo> list2, @Nullable String str3, @NotNull String str4, @Nullable Integer num, @Nullable String str5, @NotNull String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @NotNull String str10, @NotNull Map<String, String> map, boolean z) {
                Intrinsics.checkParameterIsNotNull(list, "detailParams");
                Intrinsics.checkParameterIsNotNull(offerProductDisplaySettingsRepo, "displaySettings");
                Intrinsics.checkParameterIsNotNull(list2, "mainParams");
                Intrinsics.checkParameterIsNotNull(str4, "productType");
                Intrinsics.checkParameterIsNotNull(str6, "status");
                Intrinsics.checkParameterIsNotNull(str10, "requestParams");
                Intrinsics.checkParameterIsNotNull(map, "requestParamsV2");
                this.a = str;
                this.b = str2;
                this.c = list;
                this.d = offerProductDisplaySettingsRepo;
                this.e = list2;
                this.f = str3;
                this.g = str4;
                this.h = num;
                this.i = str5;
                this.j = str6;
                this.k = str7;
                this.l = str8;
                this.m = str9;
                this.n = str10;
                this.o = map;
                this.p = z;
            }

            public static /* synthetic */ OfferRepo copy$default(OfferRepo offerRepo, String str, String str2, List list, OfferProductDisplaySettingsRepo offerProductDisplaySettingsRepo, List list2, String str3, String str4, Integer num, String str5, String str6, String str7, String str8, String str9, String str10, Map map, boolean z, int i2, Object obj) {
                return offerRepo.copy((i2 & 1) != 0 ? offerRepo.a : str, (i2 & 2) != 0 ? offerRepo.b : str2, (i2 & 4) != 0 ? offerRepo.c : list, (i2 & 8) != 0 ? offerRepo.d : offerProductDisplaySettingsRepo, (i2 & 16) != 0 ? offerRepo.e : list2, (i2 & 32) != 0 ? offerRepo.f : str3, (i2 & 64) != 0 ? offerRepo.g : str4, (i2 & 128) != 0 ? offerRepo.h : num, (i2 & 256) != 0 ? offerRepo.i : str5, (i2 & 512) != 0 ? offerRepo.j : str6, (i2 & 1024) != 0 ? offerRepo.k : str7, (i2 & 2048) != 0 ? offerRepo.l : str8, (i2 & 4096) != 0 ? offerRepo.m : str9, (i2 & 8192) != 0 ? offerRepo.n : str10, (i2 & 16384) != 0 ? offerRepo.o : map, (i2 & 32768) != 0 ? offerRepo.p : z);
            }

            @Nullable
            public final String component1() {
                return this.a;
            }

            @NotNull
            public final String component10() {
                return this.j;
            }

            @Nullable
            public final String component11() {
                return this.k;
            }

            @Nullable
            public final String component12() {
                return this.l;
            }

            @Nullable
            public final String component13() {
                return this.m;
            }

            @NotNull
            public final String component14() {
                return this.n;
            }

            @NotNull
            public final Map<String, String> component15() {
                return this.o;
            }

            public final boolean component16() {
                return this.p;
            }

            @Nullable
            public final String component2() {
                return this.b;
            }

            @NotNull
            public final List<DetailParamRepo> component3() {
                return this.c;
            }

            @NotNull
            public final OfferProductDisplaySettingsRepo component4() {
                return this.d;
            }

            @NotNull
            public final List<MainParamRepo> component5() {
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

            @Nullable
            public final Integer component8() {
                return this.h;
            }

            @Nullable
            public final String component9() {
                return this.i;
            }

            @NotNull
            public final OfferRepo copy(@Nullable String str, @Nullable String str2, @NotNull List<DetailParamRepo> list, @NotNull OfferProductDisplaySettingsRepo offerProductDisplaySettingsRepo, @NotNull List<MainParamRepo> list2, @Nullable String str3, @NotNull String str4, @Nullable Integer num, @Nullable String str5, @NotNull String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @NotNull String str10, @NotNull Map<String, String> map, boolean z) {
                Intrinsics.checkParameterIsNotNull(list, "detailParams");
                Intrinsics.checkParameterIsNotNull(offerProductDisplaySettingsRepo, "displaySettings");
                Intrinsics.checkParameterIsNotNull(list2, "mainParams");
                Intrinsics.checkParameterIsNotNull(str4, "productType");
                Intrinsics.checkParameterIsNotNull(str6, "status");
                Intrinsics.checkParameterIsNotNull(str10, "requestParams");
                Intrinsics.checkParameterIsNotNull(map, "requestParamsV2");
                return new OfferRepo(str, str2, list, offerProductDisplaySettingsRepo, list2, str3, str4, num, str5, str6, str7, str8, str9, str10, map, z);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof OfferRepo)) {
                    return false;
                }
                OfferRepo offerRepo = (OfferRepo) obj;
                return Intrinsics.areEqual(this.a, offerRepo.a) && Intrinsics.areEqual(this.b, offerRepo.b) && Intrinsics.areEqual(this.c, offerRepo.c) && Intrinsics.areEqual(this.d, offerRepo.d) && Intrinsics.areEqual(this.e, offerRepo.e) && Intrinsics.areEqual(this.f, offerRepo.f) && Intrinsics.areEqual(this.g, offerRepo.g) && Intrinsics.areEqual(this.h, offerRepo.h) && Intrinsics.areEqual(this.i, offerRepo.i) && Intrinsics.areEqual(this.j, offerRepo.j) && Intrinsics.areEqual(this.k, offerRepo.k) && Intrinsics.areEqual(this.l, offerRepo.l) && Intrinsics.areEqual(this.m, offerRepo.m) && Intrinsics.areEqual(this.n, offerRepo.n) && Intrinsics.areEqual(this.o, offerRepo.o) && this.p == offerRepo.p;
            }

            @Nullable
            public final String getBankId() {
                return this.a;
            }

            @NotNull
            public final List<DetailParamRepo> getDetailParams() {
                return this.c;
            }

            @NotNull
            public final OfferProductDisplaySettingsRepo getDisplaySettings() {
                return this.d;
            }

            public final boolean getExtraInfoRequest() {
                return this.p;
            }

            @NotNull
            public final List<MainParamRepo> getMainParams() {
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
            public final String getProductType() {
                return this.g;
            }

            @Nullable
            public final Integer getProfitability() {
                return this.h;
            }

            @Nullable
            public final String getProfitabilityText() {
                return this.i;
            }

            @NotNull
            public final String getRequestParams() {
                return this.n;
            }

            @NotNull
            public final Map<String, String> getRequestParamsV2() {
                return this.o;
            }

            @NotNull
            public final String getStatus() {
                return this.j;
            }

            @Nullable
            public final String getStatusText() {
                return this.k;
            }

            @Nullable
            public final String getUrl() {
                return this.l;
            }

            @Nullable
            public final String getUrlText() {
                return this.m;
            }

            public int hashCode() {
                String str = this.a;
                int i2 = 0;
                int hashCode = (str != null ? str.hashCode() : 0) * 31;
                String str2 = this.b;
                int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
                List<DetailParamRepo> list = this.c;
                int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 0)) * 31;
                OfferProductDisplaySettingsRepo offerProductDisplaySettingsRepo = this.d;
                int hashCode4 = (hashCode3 + (offerProductDisplaySettingsRepo != null ? offerProductDisplaySettingsRepo.hashCode() : 0)) * 31;
                List<MainParamRepo> list2 = this.e;
                int hashCode5 = (hashCode4 + (list2 != null ? list2.hashCode() : 0)) * 31;
                String str3 = this.f;
                int hashCode6 = (hashCode5 + (str3 != null ? str3.hashCode() : 0)) * 31;
                String str4 = this.g;
                int hashCode7 = (hashCode6 + (str4 != null ? str4.hashCode() : 0)) * 31;
                Integer num = this.h;
                int hashCode8 = (hashCode7 + (num != null ? num.hashCode() : 0)) * 31;
                String str5 = this.i;
                int hashCode9 = (hashCode8 + (str5 != null ? str5.hashCode() : 0)) * 31;
                String str6 = this.j;
                int hashCode10 = (hashCode9 + (str6 != null ? str6.hashCode() : 0)) * 31;
                String str7 = this.k;
                int hashCode11 = (hashCode10 + (str7 != null ? str7.hashCode() : 0)) * 31;
                String str8 = this.l;
                int hashCode12 = (hashCode11 + (str8 != null ? str8.hashCode() : 0)) * 31;
                String str9 = this.m;
                int hashCode13 = (hashCode12 + (str9 != null ? str9.hashCode() : 0)) * 31;
                String str10 = this.n;
                int hashCode14 = (hashCode13 + (str10 != null ? str10.hashCode() : 0)) * 31;
                Map<String, String> map = this.o;
                if (map != null) {
                    i2 = map.hashCode();
                }
                int i3 = (hashCode14 + i2) * 31;
                boolean z = this.p;
                if (z) {
                    z = true;
                }
                int i4 = z ? 1 : 0;
                int i5 = z ? 1 : 0;
                int i6 = z ? 1 : 0;
                return i3 + i4;
            }

            @NotNull
            public final OfferProductDetailDomain toOfferProductDetailDomain() {
                OfferProductDetailInfoDomain createDetailInfo = OfferProductListCreatorKt.createDetailInfo(this);
                List<OfferProductDetailItemDomain> createListOfferProductDetailItem = OfferProductListCreatorKt.createListOfferProductDetailItem(this, createDetailInfo);
                String str = this.a;
                String str2 = this.b;
                List<MainParamRepo> list = this.e;
                ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(OfferProductListCreatorKt.createMainParam(it.next()));
                }
                return new OfferProductDetailDomain(str, str2, createListOfferProductDetailItem, createDetailInfo, arrayList, this.f, this.n, this.o, this.p);
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("OfferRepo(bankId=");
                L.append(this.a);
                L.append(", orderID=");
                L.append(this.b);
                L.append(", detailParams=");
                L.append(this.c);
                L.append(", displaySettings=");
                L.append(this.d);
                L.append(", mainParams=");
                L.append(this.e);
                L.append(", productId=");
                L.append(this.f);
                L.append(", productType=");
                L.append(this.g);
                L.append(", profitability=");
                L.append(this.h);
                L.append(", profitabilityText=");
                L.append(this.i);
                L.append(", status=");
                L.append(this.j);
                L.append(", statusText=");
                L.append(this.k);
                L.append(", url=");
                L.append(this.l);
                L.append(", urlText=");
                L.append(this.m);
                L.append(", requestParams=");
                L.append(this.n);
                L.append(", requestParamsV2=");
                L.append(this.o);
                L.append(", extraInfoRequest=");
                return a.B(L, this.p, ")");
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ OfferRepo(String str, String str2, List list, OfferProductDisplaySettingsRepo offerProductDisplaySettingsRepo, List list2, String str3, String str4, Integer num, String str5, String str6, String str7, String str8, String str9, String str10, Map map, boolean z, int i2, j jVar) {
                this(str, str2, list, offerProductDisplaySettingsRepo, list2, str3, str4, num, str5, str6, str7, str8, str9, str10, map, (i2 & 32768) != 0 ? false : z);
            }
        }

        public OfferGroupRepo(@NotNull String str, @NotNull String str2, @NotNull List<OfferRepo> list) {
            Intrinsics.checkParameterIsNotNull(str, "titleGroup");
            Intrinsics.checkParameterIsNotNull(str2, "description");
            Intrinsics.checkParameterIsNotNull(list, "offerList");
            this.a = str;
            this.b = str2;
            this.c = list;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: ru.sravni.android.bankproduct.repository.offer.product.entity.OfferProductListRepo$OfferGroupRepo */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ OfferGroupRepo copy$default(OfferGroupRepo offerGroupRepo, String str, String str2, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = offerGroupRepo.a;
            }
            if ((i & 2) != 0) {
                str2 = offerGroupRepo.b;
            }
            if ((i & 4) != 0) {
                list = offerGroupRepo.c;
            }
            return offerGroupRepo.copy(str, str2, list);
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
        public final List<OfferRepo> component3() {
            return this.c;
        }

        @NotNull
        public final OfferGroupRepo copy(@NotNull String str, @NotNull String str2, @NotNull List<OfferRepo> list) {
            Intrinsics.checkParameterIsNotNull(str, "titleGroup");
            Intrinsics.checkParameterIsNotNull(str2, "description");
            Intrinsics.checkParameterIsNotNull(list, "offerList");
            return new OfferGroupRepo(str, str2, list);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OfferGroupRepo)) {
                return false;
            }
            OfferGroupRepo offerGroupRepo = (OfferGroupRepo) obj;
            return Intrinsics.areEqual(this.a, offerGroupRepo.a) && Intrinsics.areEqual(this.b, offerGroupRepo.b) && Intrinsics.areEqual(this.c, offerGroupRepo.c);
        }

        @NotNull
        public final String getDescription() {
            return this.b;
        }

        @NotNull
        public final List<OfferRepo> getOfferList() {
            return this.c;
        }

        @NotNull
        public final String getTitleGroup() {
            return this.a;
        }

        public int hashCode() {
            String str = this.a;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.b;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            List<OfferRepo> list = this.c;
            if (list != null) {
                i = list.hashCode();
            }
            return hashCode2 + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("OfferGroupRepo(titleGroup=");
            L.append(this.a);
            L.append(", description=");
            L.append(this.b);
            L.append(", offerList=");
            return a.w(L, this.c, ")");
        }
    }

    public OfferProductListRepo(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull List<OfferFilterRepo> list, @NotNull List<OfferGroupRepo> list2) {
        Intrinsics.checkParameterIsNotNull(str, "topHeaderTitle");
        Intrinsics.checkParameterIsNotNull(str2, "conversationID");
        Intrinsics.checkParameterIsNotNull(str3, "savedSearchID");
        Intrinsics.checkParameterIsNotNull(list, "filters");
        Intrinsics.checkParameterIsNotNull(list2, "offerGroups");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = list;
        this.e = list2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: ru.sravni.android.bankproduct.repository.offer.product.entity.OfferProductListRepo */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OfferProductListRepo copy$default(OfferProductListRepo offerProductListRepo, String str, String str2, String str3, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = offerProductListRepo.a;
        }
        if ((i & 2) != 0) {
            str2 = offerProductListRepo.b;
        }
        if ((i & 4) != 0) {
            str3 = offerProductListRepo.c;
        }
        if ((i & 8) != 0) {
            list = offerProductListRepo.d;
        }
        if ((i & 16) != 0) {
            list2 = offerProductListRepo.e;
        }
        return offerProductListRepo.copy(str, str2, str3, list, list2);
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
    public final List<OfferFilterRepo> component4() {
        return this.d;
    }

    @NotNull
    public final List<OfferGroupRepo> component5() {
        return this.e;
    }

    @NotNull
    public final OfferProductListRepo copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull List<OfferFilterRepo> list, @NotNull List<OfferGroupRepo> list2) {
        Intrinsics.checkParameterIsNotNull(str, "topHeaderTitle");
        Intrinsics.checkParameterIsNotNull(str2, "conversationID");
        Intrinsics.checkParameterIsNotNull(str3, "savedSearchID");
        Intrinsics.checkParameterIsNotNull(list, "filters");
        Intrinsics.checkParameterIsNotNull(list2, "offerGroups");
        return new OfferProductListRepo(str, str2, str3, list, list2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OfferProductListRepo)) {
            return false;
        }
        OfferProductListRepo offerProductListRepo = (OfferProductListRepo) obj;
        return Intrinsics.areEqual(this.a, offerProductListRepo.a) && Intrinsics.areEqual(this.b, offerProductListRepo.b) && Intrinsics.areEqual(this.c, offerProductListRepo.c) && Intrinsics.areEqual(this.d, offerProductListRepo.d) && Intrinsics.areEqual(this.e, offerProductListRepo.e);
    }

    @NotNull
    public final String getConversationID() {
        return this.b;
    }

    @NotNull
    public final List<OfferFilterRepo> getFilters() {
        return this.d;
    }

    @NotNull
    public final List<OfferGroupRepo> getOfferGroups() {
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
        List<OfferFilterRepo> list = this.d;
        int hashCode4 = (hashCode3 + (list != null ? list.hashCode() : 0)) * 31;
        List<OfferGroupRepo> list2 = this.e;
        if (list2 != null) {
            i = list2.hashCode();
        }
        return hashCode4 + i;
    }

    @NotNull
    public final OfferProductListDomain toOfferProductListDomain(@NotNull List<OfferProductItemDomain> list, @NotNull List<OfferFilterDomain> list2) {
        Intrinsics.checkParameterIsNotNull(list, "listOffers");
        Intrinsics.checkParameterIsNotNull(list2, "filters");
        return new OfferProductListDomain(this.a, this.b, this.c, list2, list);
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("OfferProductListRepo(topHeaderTitle=");
        L.append(this.a);
        L.append(", conversationID=");
        L.append(this.b);
        L.append(", savedSearchID=");
        L.append(this.c);
        L.append(", filters=");
        L.append(this.d);
        L.append(", offerGroups=");
        return a.w(L, this.e, ")");
    }
}
