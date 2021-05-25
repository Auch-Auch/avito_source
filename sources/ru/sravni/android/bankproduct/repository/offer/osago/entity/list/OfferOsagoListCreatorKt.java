package ru.sravni.android.bankproduct.repository.offer.osago.entity.list;

import com.avito.android.remote.auth.AuthSource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import ru.sravni.android.bankproduct.domain.offer.osago.entity.list.OfferOsagoDetailDomain;
import ru.sravni.android.bankproduct.domain.offer.osago.entity.list.OfferOsagoItemDomain;
import ru.sravni.android.bankproduct.domain.offer.osago.entity.list.OfferOsagoItemEnum;
import ru.sravni.android.bankproduct.domain.offer.osago.entity.list.OsagoCompanyDetailEnum;
import ru.sravni.android.bankproduct.repository.offer.osago.entity.list.OfferOsagoListRepo;
import t6.n.d;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\b\u001a\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lru/sravni/android/bankproduct/repository/offer/osago/entity/list/OfferOsagoListRepo;", "", "Lru/sravni/android/bankproduct/domain/offer/osago/entity/list/OfferOsagoItemDomain;", "createOfferOsagoDomain", "(Lru/sravni/android/bankproduct/repository/offer/osago/entity/list/OfferOsagoListRepo;)Ljava/util/List;", "", "title", AuthSource.SEND_ABUSE, "(Ljava/lang/String;)Ljava/util/List;", "Lru/sravni/android/bankproduct/repository/offer/osago/entity/list/OfferOsagoListRepo$OfferGroupRepo$OfferRepo;", "offerRepo", "", "isProlongation", "Lru/sravni/android/bankproduct/domain/offer/osago/entity/list/OfferOsagoDetailDomain;", AuthSource.BOOKING_ORDER, "(Lru/sravni/android/bankproduct/repository/offer/osago/entity/list/OfferOsagoListRepo$OfferGroupRepo$OfferRepo;Z)Lru/sravni/android/bankproduct/domain/offer/osago/entity/list/OfferOsagoDetailDomain;", "sravnichat_release"}, k = 2, mv = {1, 4, 0})
public final class OfferOsagoListCreatorKt {
    public static final List<OfferOsagoItemDomain> a(String str) {
        List<OfferOsagoItemDomain> listOf = str != null ? d.listOf(new OfferOsagoItemDomain(OfferOsagoItemEnum.HEADER, str, null, 4, null)) : null;
        return listOf != null ? listOf : CollectionsKt__CollectionsKt.emptyList();
    }

    public static final OfferOsagoDetailDomain b(OfferOsagoListRepo.OfferGroupRepo.OfferRepo offerRepo, boolean z) {
        return new OfferOsagoDetailDomain(offerRepo.getProductID(), offerRepo.getProductType(), z, offerRepo.getDisplaySettings().toOfferOsagoDisplaySettingsDomain(), null, OsagoCompanyDetailEnum.OSAGO_WAIT, 16, null);
    }

    @NotNull
    public static final List<OfferOsagoItemDomain> createOfferOsagoDomain(@NotNull OfferOsagoListRepo offerOsagoListRepo) {
        List list;
        Intrinsics.checkParameterIsNotNull(offerOsagoListRepo, "$this$createOfferOsagoDomain");
        List<OfferOsagoListRepo.OfferGroupRepo> offerGroups = offerOsagoListRepo.getOfferGroups();
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(offerGroups, 10));
        for (T t : offerGroups) {
            String typeGroup = t.getTypeGroup();
            if (typeGroup != null && typeGroup.hashCode() == -1624825364 && typeGroup.equals(AnalyticFieldsName.prolongation)) {
                List<OfferOsagoItemDomain> a = a(t.getTitleGroup());
                List<OfferOsagoListRepo.OfferGroupRepo.OfferRepo> offerList = t.getOfferList();
                ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(offerList, 10));
                Iterator<T> it = offerList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(new OfferOsagoItemDomain(OfferOsagoItemEnum.PROLONGATION, null, b(it.next(), true), 2, null));
                }
                list = CollectionsKt___CollectionsKt.plus((Collection) a, (Iterable) arrayList2);
            } else {
                List<OfferOsagoItemDomain> a3 = a(t.getTitleGroup());
                List<OfferOsagoListRepo.OfferGroupRepo.OfferRepo> offerList2 = t.getOfferList();
                ArrayList arrayList3 = new ArrayList(e.collectionSizeOrDefault(offerList2, 10));
                Iterator<T> it2 = offerList2.iterator();
                while (it2.hasNext()) {
                    arrayList3.add(new OfferOsagoItemDomain(OfferOsagoItemEnum.ELEMENT, null, b(it2.next(), false), 2, null));
                }
                list = CollectionsKt___CollectionsKt.plus((Collection) a3, (Iterable) arrayList3);
            }
            arrayList.add(list);
        }
        return e.flatten(arrayList);
    }
}
