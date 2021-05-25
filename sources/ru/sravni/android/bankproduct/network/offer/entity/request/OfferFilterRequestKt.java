package ru.sravni.android.bankproduct.network.offer.entity.request;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.network.offer.entity.request.OfferFilterRequest;
import ru.sravni.android.bankproduct.repository.offer.entity.OfferFilterInfoRepo;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001b\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"", "Lru/sravni/android/bankproduct/repository/offer/entity/OfferFilterInfoRepo;", "filtersInfoRepo", "Lru/sravni/android/bankproduct/network/offer/entity/request/OfferFilterRequest;", "makeOfferFilterRequest", "(Ljava/util/List;)Lru/sravni/android/bankproduct/network/offer/entity/request/OfferFilterRequest;", "sravnichat_release"}, k = 2, mv = {1, 4, 0})
public final class OfferFilterRequestKt {
    @NotNull
    public static final OfferFilterRequest makeOfferFilterRequest(@NotNull List<OfferFilterInfoRepo> list) {
        Intrinsics.checkParameterIsNotNull(list, "filtersInfoRepo");
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        for (T t : list) {
            arrayList.add(new OfferFilterRequest.OfferFilterInfoRequest(t.getName(), t.getValue()));
        }
        return new OfferFilterRequest(arrayList);
    }
}
