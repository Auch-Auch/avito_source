package ru.sravni.android.bankproduct.network.dashboard.response;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.repository.dashboard.entity.OfferCalculationElementRepo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lru/sravni/android/bankproduct/network/dashboard/response/OfferCalculationItem;", "Lru/sravni/android/bankproduct/repository/dashboard/entity/OfferCalculationElementRepo;", "toOfferCalculatedElementRepo", "(Lru/sravni/android/bankproduct/network/dashboard/response/OfferCalculationItem;)Lru/sravni/android/bankproduct/repository/dashboard/entity/OfferCalculationElementRepo;", "sravnichat_release"}, k = 2, mv = {1, 4, 0})
public final class OfferCalculationListResponseKt {
    @NotNull
    public static final OfferCalculationElementRepo toOfferCalculatedElementRepo(@NotNull OfferCalculationItem offerCalculationItem) {
        Intrinsics.checkParameterIsNotNull(offerCalculationItem, "$this$toOfferCalculatedElementRepo");
        return new OfferCalculationElementRepo(offerCalculationItem.getConversation(), offerCalculationItem.getDateCreated(), offerCalculationItem.getName(), offerCalculationItem.getProductName(), offerCalculationItem.getQueryTitle(), offerCalculationItem.getOffersCount(), offerCalculationItem.getRequestsCounts(), offerCalculationItem.getOffersCountTitle(), offerCalculationItem.getRequestsCountsTitle(), offerCalculationItem.getSavedSearchID());
    }
}
