package ru.sravni.android.bankproduct.utils.filter.entity;

import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lru/sravni/android/bankproduct/domain/offer/entity/OfferFilterDomain;", "offerFilter", "Lru/sravni/android/bankproduct/utils/filter/entity/FilterItem;", "createFilterItem", "(Lru/sravni/android/bankproduct/domain/offer/entity/OfferFilterDomain;)Lru/sravni/android/bankproduct/utils/filter/entity/FilterItem;", "sravnichat_release"}, k = 2, mv = {1, 4, 0})
public final class FilterItemKt {
    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00c1 A[LOOP:0: B:36:0x00bb->B:38:0x00c1, LOOP_END] */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final ru.sravni.android.bankproduct.utils.filter.entity.FilterItem createFilterItem(@org.jetbrains.annotations.NotNull ru.sravni.android.bankproduct.domain.offer.entity.OfferFilterDomain r11) {
        /*
            java.lang.String r0 = "offerFilter"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r11, r0)
            java.lang.String r0 = r11.getFilterTitle()
            java.lang.String r1 = r11.getFilterIcon()
            int r2 = r1.hashCode()
            switch(r2) {
                case 98260: goto L_0x0037;
                case 3560141: goto L_0x002b;
                case 99639597: goto L_0x0020;
                case 104079552: goto L_0x0015;
                default: goto L_0x0014;
            }
        L_0x0014:
            goto L_0x0042
        L_0x0015:
            java.lang.String r2 = "money"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0042
            int r1 = ru.sravni.android.bankproduct.R.drawable.ic_money_sravni
            goto L_0x0043
        L_0x0020:
            java.lang.String r2 = "human"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0042
            int r1 = ru.sravni.android.bankproduct.R.drawable.ic_human_sravni
            goto L_0x0043
        L_0x002b:
            java.lang.String r2 = "time"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0042
            int r1 = ru.sravni.android.bankproduct.R.drawable.ic_time_sravni
            goto L_0x0043
        L_0x0037:
            java.lang.String r2 = "car"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0042
            int r1 = ru.sravni.android.bankproduct.R.drawable.ic_car_sravni
            goto L_0x0043
        L_0x0042:
            r1 = 0
        L_0x0043:
            ru.sravni.android.bankproduct.domain.offer.entity.OfferFilterDomain$DetailDomain r2 = r11.getFilterDetail()
            java.lang.String r2 = r2.getFilterType()
            if (r2 != 0) goto L_0x004e
            goto L_0x008e
        L_0x004e:
            int r3 = r2.hashCode()
            switch(r3) {
                case -2109556403: goto L_0x0083;
                case -899647263: goto L_0x0078;
                case 1345325676: goto L_0x006d;
                case 1755222815: goto L_0x0061;
                case 1968488982: goto L_0x0056;
                default: goto L_0x0055;
            }
        L_0x0055:
            goto L_0x008e
        L_0x0056:
            java.lang.String r3 = "barrelDay"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x008e
            ru.sravni.android.bankproduct.utils.filter.entity.FilterTypeEnum r2 = ru.sravni.android.bankproduct.utils.filter.entity.FilterTypeEnum.BARREL_DAY
            goto L_0x0090
        L_0x0061:
            java.lang.String r3 = "switcherList"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x008e
            ru.sravni.android.bankproduct.utils.filter.entity.FilterTypeEnum r2 = ru.sravni.android.bankproduct.utils.filter.entity.FilterTypeEnum.SWITCHER
            goto L_0x0090
        L_0x006d:
            java.lang.String r3 = "listInfo"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x008e
            ru.sravni.android.bankproduct.utils.filter.entity.FilterTypeEnum r2 = ru.sravni.android.bankproduct.utils.filter.entity.FilterTypeEnum.LIST_INFO
            goto L_0x0090
        L_0x0078:
            java.lang.String r3 = "slider"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x008e
            ru.sravni.android.bankproduct.utils.filter.entity.FilterTypeEnum r2 = ru.sravni.android.bankproduct.utils.filter.entity.FilterTypeEnum.SLIDER
            goto L_0x0090
        L_0x0083:
            java.lang.String r3 = "snapPoints"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x008e
            ru.sravni.android.bankproduct.utils.filter.entity.FilterTypeEnum r2 = ru.sravni.android.bankproduct.utils.filter.entity.FilterTypeEnum.SNAP_POINT
            goto L_0x0090
        L_0x008e:
            ru.sravni.android.bankproduct.utils.filter.entity.FilterTypeEnum r2 = ru.sravni.android.bankproduct.utils.filter.entity.FilterTypeEnum.DEFAULT
        L_0x0090:
            java.lang.String r3 = r11.getFilterName()
            ru.sravni.android.bankproduct.domain.offer.entity.OfferFilterDomain$DetailDomain r4 = r11.getFilterDetail()
            java.lang.String r4 = r4.getDetailTitle()
            ru.sravni.android.bankproduct.domain.offer.entity.OfferFilterDomain$DetailDomain r5 = r11.getFilterDetail()
            boolean r5 = r5.getEditable()
            ru.sravni.android.bankproduct.domain.offer.entity.OfferFilterDomain$DetailDomain r11 = r11.getFilterDetail()
            java.util.List r11 = r11.getValues()
            java.util.ArrayList r6 = new java.util.ArrayList
            r7 = 10
            int r7 = t6.n.e.collectionSizeOrDefault(r11, r7)
            r6.<init>(r7)
            java.util.Iterator r11 = r11.iterator()
        L_0x00bb:
            boolean r7 = r11.hasNext()
            if (r7 == 0) goto L_0x00dc
            java.lang.Object r7 = r11.next()
            ru.sravni.android.bankproduct.domain.offer.entity.OfferFilterDomain$DetailDomain$ValueDomain r7 = (ru.sravni.android.bankproduct.domain.offer.entity.OfferFilterDomain.DetailDomain.ValueDomain) r7
            ru.sravni.android.bankproduct.utils.filter.entity.FilterItem$FilterInfo$DetailFilter r8 = new ru.sravni.android.bankproduct.utils.filter.entity.FilterItem$FilterInfo$DetailFilter
            java.lang.String r9 = r7.getCode()
            java.lang.String r10 = r7.getTitle()
            java.lang.String r7 = r7.getValue()
            r8.<init>(r9, r10, r7)
            r6.add(r8)
            goto L_0x00bb
        L_0x00dc:
            ru.sravni.android.bankproduct.utils.filter.entity.FilterItem$FilterInfo r11 = new ru.sravni.android.bankproduct.utils.filter.entity.FilterItem$FilterInfo
            r11.<init>(r3, r4, r5, r6)
            ru.sravni.android.bankproduct.utils.filter.entity.FilterItem r3 = new ru.sravni.android.bankproduct.utils.filter.entity.FilterItem
            r3.<init>(r0, r2, r1, r11)
            return r3
            switch-data {98260->0x0037, 3560141->0x002b, 99639597->0x0020, 104079552->0x0015, }
            switch-data {-2109556403->0x0083, -899647263->0x0078, 1345325676->0x006d, 1755222815->0x0061, 1968488982->0x0056, }
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.sravni.android.bankproduct.utils.filter.entity.FilterItemKt.createFilterItem(ru.sravni.android.bankproduct.domain.offer.entity.OfferFilterDomain):ru.sravni.android.bankproduct.utils.filter.entity.FilterItem");
    }
}
