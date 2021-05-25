package a7.c.a.a.n.c;

import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ru.sravni.android.bankproduct.network.dashboard.response.OfferCalculationItem;
import ru.sravni.android.bankproduct.network.dashboard.response.OfferCalculationListResponse;
import ru.sravni.android.bankproduct.network.dashboard.response.OfferCalculationListResponseKt;
import t6.n.e;
public final class b<T, R> implements Function<T, R> {
    public static final b a = new b();

    @Override // io.reactivex.functions.Function
    public Object apply(Object obj) {
        OfferCalculationListResponse offerCalculationListResponse = (OfferCalculationListResponse) obj;
        Intrinsics.checkParameterIsNotNull(offerCalculationListResponse, "it");
        List<OfferCalculationItem> items = offerCalculationListResponse.getItems();
        if (items == null) {
            items = CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(items, 10));
        Iterator<T> it = items.iterator();
        while (it.hasNext()) {
            arrayList.add(OfferCalculationListResponseKt.toOfferCalculatedElementRepo(it.next()));
        }
        return arrayList;
    }
}
