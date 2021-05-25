package ru.sravni.android.bankproduct.repository.offer.product.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.domain.offer.product.entity.OfferProductDisplaySettingsDomain;
import ru.sravni.android.bankproduct.domain.offer.product.entity.OfferProductItemDomain;
import ru.sravni.android.bankproduct.domain.offer.product.entity.OfferProductItemEnum;
import ru.sravni.android.bankproduct.domain.offer.product.entity.detail.OfferProductDetailDomain;
import ru.sravni.android.bankproduct.domain.offer.product.entity.detail.OfferProductDetailInfoDomain;
import ru.sravni.android.bankproduct.domain.offer.product.entity.detail.OfferProductDetailItemDomain;
import ru.sravni.android.bankproduct.repository.offer.product.entity.OfferProductListRepo;
import ru.sravni.android.bankproduct.repository.offer.product.entity.util.OfferProductUtilKt;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\t\u001a#\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00012\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\r\u001a\u0015\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lru/sravni/android/bankproduct/repository/offer/product/entity/OfferProductListRepo;", "", "Lru/sravni/android/bankproduct/domain/offer/product/entity/OfferProductItemDomain;", "createOfferProductDomain", "(Lru/sravni/android/bankproduct/repository/offer/product/entity/OfferProductListRepo;)Ljava/util/List;", "Lru/sravni/android/bankproduct/repository/offer/product/entity/OfferProductListRepo$OfferGroupRepo$OfferRepo;", "offerRepo", "Lru/sravni/android/bankproduct/domain/offer/product/entity/detail/OfferProductDetailInfoDomain;", "createDetailInfo", "(Lru/sravni/android/bankproduct/repository/offer/product/entity/OfferProductListRepo$OfferGroupRepo$OfferRepo;)Lru/sravni/android/bankproduct/domain/offer/product/entity/detail/OfferProductDetailInfoDomain;", "detailInfo", "Lru/sravni/android/bankproduct/domain/offer/product/entity/detail/OfferProductDetailItemDomain;", "createListOfferProductDetailItem", "(Lru/sravni/android/bankproduct/repository/offer/product/entity/OfferProductListRepo$OfferGroupRepo$OfferRepo;Lru/sravni/android/bankproduct/domain/offer/product/entity/detail/OfferProductDetailInfoDomain;)Ljava/util/List;", "Lru/sravni/android/bankproduct/repository/offer/product/entity/OfferProductListRepo$OfferGroupRepo$MainParamRepo;", "mainParamRepo", "Lru/sravni/android/bankproduct/domain/offer/product/entity/detail/OfferProductDetailDomain$MainParam;", "createMainParam", "(Lru/sravni/android/bankproduct/repository/offer/product/entity/OfferProductListRepo$OfferGroupRepo$MainParamRepo;)Lru/sravni/android/bankproduct/domain/offer/product/entity/detail/OfferProductDetailDomain$MainParam;", "sravnichat_release"}, k = 2, mv = {1, 4, 0})
public final class OfferProductListCreatorKt {
    @NotNull
    public static final OfferProductDetailInfoDomain createDetailInfo(@NotNull OfferProductListRepo.OfferGroupRepo.OfferRepo offerRepo) {
        Intrinsics.checkParameterIsNotNull(offerRepo, "offerRepo");
        OfferProductDisplaySettingsDomain createDisplaySettings = OfferProductUtilKt.createDisplaySettings(offerRepo.getDisplaySettings(), offerRepo.getProductType());
        Integer profitability = offerRepo.getProfitability();
        return new OfferProductDetailInfoDomain(createDisplaySettings, profitability != null ? profitability.intValue() : 0, offerRepo.getProfitabilityText(), OfferProductUtilKt.statusParse(offerRepo.getStatus()), offerRepo.getStatusText(), offerRepo.getUrl(), offerRepo.getUrlText());
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x008e A[LOOP:1: B:18:0x0088->B:20:0x008e, LOOP_END] */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.util.List<ru.sravni.android.bankproduct.domain.offer.product.entity.detail.OfferProductDetailItemDomain> createListOfferProductDetailItem(@org.jetbrains.annotations.NotNull ru.sravni.android.bankproduct.repository.offer.product.entity.OfferProductListRepo.OfferGroupRepo.OfferRepo r13, @org.jetbrains.annotations.NotNull ru.sravni.android.bankproduct.domain.offer.product.entity.detail.OfferProductDetailInfoDomain r14) {
        /*
            java.lang.String r0 = "offerRepo"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r13, r0)
            java.lang.String r0 = "detailInfo"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r14, r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            ru.sravni.android.bankproduct.domain.offer.product.entity.detail.OfferProductDetailItemDomain r8 = new ru.sravni.android.bankproduct.domain.offer.product.entity.detail.OfferProductDetailItemDomain
            ru.sravni.android.bankproduct.domain.offer.product.entity.detail.TypeProductInfoEnum r2 = ru.sravni.android.bankproduct.domain.offer.product.entity.detail.TypeProductInfoEnum.HEADER
            r4 = 0
            r5 = 0
            r6 = 12
            r7 = 0
            r1 = r8
            r3 = r14
            r1.<init>(r2, r3, r4, r5, r6, r7)
            r0.add(r8)
            java.util.List r13 = r13.getDetailParams()
            java.util.Iterator r13 = r13.iterator()
        L_0x0028:
            boolean r14 = r13.hasNext()
            if (r14 == 0) goto L_0x00c9
            java.lang.Object r14 = r13.next()
            ru.sravni.android.bankproduct.repository.offer.product.entity.OfferProductListRepo$OfferGroupRepo$DetailParamRepo r14 = (ru.sravni.android.bankproduct.repository.offer.product.entity.OfferProductListRepo.OfferGroupRepo.DetailParamRepo) r14
            java.lang.String r4 = r14.getDetailTitle()
            if (r4 == 0) goto L_0x004a
            ru.sravni.android.bankproduct.domain.offer.product.entity.detail.OfferProductDetailItemDomain r8 = new ru.sravni.android.bankproduct.domain.offer.product.entity.detail.OfferProductDetailItemDomain
            ru.sravni.android.bankproduct.domain.offer.product.entity.detail.TypeProductInfoEnum r2 = ru.sravni.android.bankproduct.domain.offer.product.entity.detail.TypeProductInfoEnum.TITLE
            r3 = 0
            r5 = 0
            r6 = 10
            r7 = 0
            r1 = r8
            r1.<init>(r2, r3, r4, r5, r6, r7)
            r0.add(r8)
        L_0x004a:
            java.lang.String r1 = r14.getDetailType()
            int r2 = r1.hashCode()
            r3 = -314765822(0xffffffffed3d0e02, float:-3.65685E27)
            if (r2 == r3) goto L_0x0068
            r3 = 1312628429(0x4e3d1ecd, float:7.932281E8)
            if (r2 == r3) goto L_0x005d
            goto L_0x0073
        L_0x005d:
            java.lang.String r2 = "standart"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0073
            ru.sravni.android.bankproduct.domain.offer.product.entity.detail.TypeProductInfoEnum r1 = ru.sravni.android.bankproduct.domain.offer.product.entity.detail.TypeProductInfoEnum.INFO
            goto L_0x0075
        L_0x0068:
            java.lang.String r2 = "primary"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0073
            ru.sravni.android.bankproduct.domain.offer.product.entity.detail.TypeProductInfoEnum r1 = ru.sravni.android.bankproduct.domain.offer.product.entity.detail.TypeProductInfoEnum.MAIN_INFO
            goto L_0x0075
        L_0x0073:
            ru.sravni.android.bankproduct.domain.offer.product.entity.detail.TypeProductInfoEnum r1 = ru.sravni.android.bankproduct.domain.offer.product.entity.detail.TypeProductInfoEnum.INFO
        L_0x0075:
            java.util.List r2 = r14.getValues()
            java.util.ArrayList r9 = new java.util.ArrayList
            r3 = 10
            int r3 = t6.n.e.collectionSizeOrDefault(r2, r3)
            r9.<init>(r3)
            java.util.Iterator r10 = r2.iterator()
        L_0x0088:
            boolean r2 = r10.hasNext()
            if (r2 == 0) goto L_0x00c4
            java.lang.Object r2 = r10.next()
            ru.sravni.android.bankproduct.repository.offer.product.entity.OfferProductListRepo$OfferGroupRepo$MainParamRepo r2 = (ru.sravni.android.bankproduct.repository.offer.product.entity.OfferProductListRepo.OfferGroupRepo.MainParamRepo) r2
            ru.sravni.android.bankproduct.domain.offer.product.entity.detail.OfferProductDetailItemDomain r11 = new ru.sravni.android.bankproduct.domain.offer.product.entity.detail.OfferProductDetailItemDomain
            r4 = 0
            r5 = 0
            ru.sravni.android.bankproduct.domain.offer.product.entity.detail.OfferProductDetailItemDomain$ItemParam r6 = new ru.sravni.android.bankproduct.domain.offer.product.entity.detail.OfferProductDetailItemDomain$ItemParam
            java.lang.String r3 = r2.getName()
            java.lang.String r7 = r2.getValue()
            java.lang.String r8 = r2.getFontType()
            java.util.List r12 = r14.getValues()
            java.lang.Object r12 = kotlin.collections.CollectionsKt___CollectionsKt.last(r12)
            ru.sravni.android.bankproduct.repository.offer.product.entity.OfferProductListRepo$OfferGroupRepo$MainParamRepo r12 = (ru.sravni.android.bankproduct.repository.offer.product.entity.OfferProductListRepo.OfferGroupRepo.MainParamRepo) r12
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r12, r2)
            r2 = r2 ^ 1
            r6.<init>(r8, r3, r7, r2)
            r7 = 6
            r8 = 0
            r2 = r11
            r3 = r1
            r2.<init>(r3, r4, r5, r6, r7, r8)
            r9.add(r11)
            goto L_0x0088
        L_0x00c4:
            r0.addAll(r9)
            goto L_0x0028
        L_0x00c9:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.sravni.android.bankproduct.repository.offer.product.entity.OfferProductListCreatorKt.createListOfferProductDetailItem(ru.sravni.android.bankproduct.repository.offer.product.entity.OfferProductListRepo$OfferGroupRepo$OfferRepo, ru.sravni.android.bankproduct.domain.offer.product.entity.detail.OfferProductDetailInfoDomain):java.util.List");
    }

    @NotNull
    public static final OfferProductDetailDomain.MainParam createMainParam(@NotNull OfferProductListRepo.OfferGroupRepo.MainParamRepo mainParamRepo) {
        Intrinsics.checkParameterIsNotNull(mainParamRepo, "mainParamRepo");
        return new OfferProductDetailDomain.MainParam(mainParamRepo.getFontType(), mainParamRepo.getName(), mainParamRepo.getValue());
    }

    @NotNull
    public static final List<OfferProductItemDomain> createOfferProductDomain(@NotNull OfferProductListRepo offerProductListRepo) {
        Intrinsics.checkParameterIsNotNull(offerProductListRepo, "$this$createOfferProductDomain");
        ArrayList arrayList = new ArrayList();
        for (T t : offerProductListRepo.getOfferGroups()) {
            if (t.getOfferList().isEmpty()) {
                arrayList.add(new OfferProductItemDomain(OfferProductItemEnum.EMPTY, null, null, null, 14, null));
            } else {
                arrayList.add(new OfferProductItemDomain(OfferProductItemEnum.HEADER, t.getTitleGroup(), t.getDescription(), null, 8, null));
                List<OfferProductListRepo.OfferGroupRepo.OfferRepo> offerList = t.getOfferList();
                ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(offerList, 10));
                for (T t2 : offerList) {
                    OfferProductDetailInfoDomain createDetailInfo = createDetailInfo(t2);
                    List<OfferProductDetailItemDomain> createListOfferProductDetailItem = createListOfferProductDetailItem(t2, createDetailInfo);
                    String bankId = t2.getBankId();
                    String productId = t2.getProductId();
                    String orderID = t2.getOrderID();
                    List<OfferProductListRepo.OfferGroupRepo.MainParamRepo> mainParams = t2.getMainParams();
                    ArrayList arrayList3 = new ArrayList(e.collectionSizeOrDefault(mainParams, 10));
                    Iterator<T> it = mainParams.iterator();
                    while (it.hasNext()) {
                        arrayList3.add(createMainParam(it.next()));
                    }
                    arrayList2.add(new OfferProductItemDomain(OfferProductItemEnum.ELEMENT, null, null, new OfferProductDetailDomain(bankId, orderID, createListOfferProductDetailItem, createDetailInfo, arrayList3, productId, t2.getRequestParams(), t2.getRequestParamsV2(), t2.getExtraInfoRequest()), 6, null));
                }
                arrayList.addAll(arrayList2);
            }
        }
        return CollectionsKt___CollectionsKt.toList(arrayList);
    }
}
