package ru.sravni.android.bankproduct.repository.offer.entity;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.domain.analytic.IErrorLogger;
import ru.sravni.android.bankproduct.domain.analytic.entity.MessagePriority;
import ru.sravni.android.bankproduct.domain.offer.entity.OfferFilterDomain;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a9\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00022\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"", "savedSearchID", "", "Lru/sravni/android/bankproduct/repository/offer/entity/OfferFilterRepo;", "filters", "Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;", "errorLogger", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "wrapper", "Lru/sravni/android/bankproduct/domain/offer/entity/OfferFilterDomain;", "createListOfferFilter", "(Ljava/lang/String;Ljava/util/List;Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;)Ljava/util/List;", "sravnichat_release"}, k = 2, mv = {1, 4, 0})
public final class OfferFilterCreatorKt {
    @NotNull
    public static final List<OfferFilterDomain> createListOfferFilter(@NotNull String str, @NotNull List<OfferFilterRepo> list, @NotNull IErrorLogger iErrorLogger, @NotNull IThrowableWrapper iThrowableWrapper) {
        Intrinsics.checkParameterIsNotNull(str, "savedSearchID");
        Intrinsics.checkParameterIsNotNull(list, "filters");
        Intrinsics.checkParameterIsNotNull(iErrorLogger, "errorLogger");
        Intrinsics.checkParameterIsNotNull(iThrowableWrapper, "wrapper");
        ArrayList<OfferFilterRepo> arrayList = new ArrayList();
        for (T t : list) {
            if (t.getFilterDetails().isEmpty()) {
                arrayList.add(t);
            }
        }
        ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(arrayList, 10));
        for (OfferFilterRepo offerFilterRepo : arrayList) {
            iErrorLogger.logError(MessagePriority.WARN, iThrowableWrapper.wrap(new ListDetailFilterError(offerFilterRepo.getFilterName(), str)));
            arrayList2.add(Unit.INSTANCE);
        }
        ArrayList<OfferFilterRepo> arrayList3 = new ArrayList();
        for (T t2 : list) {
            if (!t2.getFilterDetails().isEmpty()) {
                arrayList3.add(t2);
            }
        }
        ArrayList arrayList4 = new ArrayList(e.collectionSizeOrDefault(arrayList3, 10));
        for (OfferFilterRepo offerFilterRepo2 : arrayList3) {
            arrayList4.add(offerFilterRepo2.toOfferFilterDomain());
        }
        return arrayList4;
    }
}
