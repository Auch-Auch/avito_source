package com.avito.android.basket.checkout.viewmodel;

import a2.b.a.a.a;
import com.avito.android.basket.checkout.item.checkout.CheckoutItem;
import com.avito.android.basket.checkout.item.price.PriceItem;
import com.avito.android.basket.checkout.item.prolongation.ProlongationItem;
import com.avito.android.basket.checkout.utils.PriceItemCreator;
import com.avito.android.component.disclaimer.DisclaimerItem;
import com.avito.android.conveyor_shared_item.paid_services.PaidServiceHeaderItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.CheckoutContentsResult;
import com.avito.android.remote.model.CheckoutElement;
import com.avito.android.remote.model.CheckoutService;
import com.avito.android.remote.model.Prolongation;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.tariff.tariff_package_info.viewmodel.TariffPackageInfoConverterKt;
import com.avito.android.util.LoadingState;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.conveyor_item.ParcelableItem;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
import t6.n.d;
import t6.n.e;
import t6.n.h;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/basket/checkout/viewmodel/CheckoutConverterImpl;", "Lcom/avito/android/basket/checkout/viewmodel/CheckoutConverter;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/remote/model/CheckoutContentsResult;", "loadingState", "Lcom/avito/android/basket/checkout/viewmodel/CheckoutContent;", "convertContentResponse", "(Lcom/avito/android/util/LoadingState;)Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/basket/checkout/utils/PriceItemCreator;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/basket/checkout/utils/PriceItemCreator;", "priceItemCreator", "Lcom/avito/android/util/text/AttributedTextFormatter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "<init>", "(Lcom/avito/android/util/text/AttributedTextFormatter;Lcom/avito/android/basket/checkout/utils/PriceItemCreator;)V", "basket_release"}, k = 1, mv = {1, 4, 2})
public final class CheckoutConverterImpl implements CheckoutConverter {
    public final AttributedTextFormatter a;
    public final PriceItemCreator b;

    @Inject
    public CheckoutConverterImpl(@NotNull AttributedTextFormatter attributedTextFormatter, @NotNull PriceItemCreator priceItemCreator) {
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        Intrinsics.checkNotNullParameter(priceItemCreator, "priceItemCreator");
        this.a = attributedTextFormatter;
        this.b = priceItemCreator;
    }

    public static final List access$toItems(CheckoutConverterImpl checkoutConverterImpl, CheckoutElement checkoutElement, int i) {
        Objects.requireNonNull(checkoutConverterImpl);
        ProlongationItem prolongationItem = null;
        if (checkoutElement instanceof CheckoutService) {
            CheckoutService checkoutService = (CheckoutService) checkoutElement;
            String id = checkoutService.getId();
            String title = checkoutService.getTitle();
            String price = checkoutService.getPrice();
            Integer priceValue = checkoutService.getPriceValue();
            AttributedText oldPrice = checkoutService.getOldPrice();
            CharSequence format = oldPrice != null ? checkoutConverterImpl.a.format(oldPrice) : null;
            Boolean cancellable = checkoutService.getCancellable();
            CheckoutItem checkoutItem = new CheckoutItem(id, title, price, format, checkoutService.getIcon(), checkoutService.getProlongation() != null, cancellable != null ? cancellable.booleanValue() : false, true, priceValue);
            Prolongation prolongation = checkoutService.getProlongation();
            if (prolongation != null) {
                StringBuilder L = a.L(AnalyticFieldsName.prolongation);
                L.append(checkoutService.getId());
                prolongationItem = new ProlongationItem(L.toString(), prolongation.getTitle(), prolongation.getDescription(), prolongation.isSwitchOn(), checkoutService.getId());
            }
            return CollectionsKt__CollectionsKt.listOfNotNull((Object[]) new ParcelableItem[]{checkoutItem, prolongationItem});
        } else if (!(checkoutElement instanceof Prolongation)) {
            return null;
        } else {
            StringBuilder L2 = a.L(AnalyticFieldsName.prolongation);
            L2.append(String.valueOf(i));
            Prolongation prolongation2 = (Prolongation) checkoutElement;
            return d.listOf(new ProlongationItem(L2.toString(), prolongation2.getTitle(), prolongation2.getDescription(), prolongation2.isSwitchOn(), null));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r12v0, resolved type: com.avito.android.util.LoadingState<? super com.avito.android.remote.model.CheckoutContentsResult> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.avito.android.basket.checkout.viewmodel.CheckoutConverter
    @NotNull
    public LoadingState<CheckoutContent> convertContentResponse(@NotNull LoadingState<? super CheckoutContentsResult> loadingState) {
        Integer priceValue;
        Intrinsics.checkNotNullParameter(loadingState, "loadingState");
        if (loadingState instanceof LoadingState.Loaded) {
            CheckoutContentsResult checkoutContentsResult = (CheckoutContentsResult) ((LoadingState.Loaded) loadingState).getData();
            String title = checkoutContentsResult.getTitle();
            AttributedText description = checkoutContentsResult.getDescription();
            List mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new PaidServiceHeaderItem(TariffPackageInfoConverterKt.HEADER_STRING_ID, title, description != null ? this.a.format(description) : null));
            h.addAll(mutableListOf, SequencesKt___SequencesKt.toList(SequencesKt__SequencesKt.flattenSequenceOfIterable(SequencesKt___SequencesKt.mapIndexedNotNull(CollectionsKt___CollectionsKt.asSequence(checkoutContentsResult.getList()), new a2.a.a.q.a.i.a(this)))));
            List<CheckoutElement> list = checkoutContentsResult.getList();
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
            for (T t : list) {
                arrayList.add(Integer.valueOf((!(t instanceof CheckoutService) || (priceValue = t.getPriceValue()) == null) ? 0 : priceValue.intValue()));
            }
            PriceItem createPriceItem = this.b.createPriceItem(checkoutContentsResult.getPrice(), CollectionsKt___CollectionsKt.sumOfInt(arrayList));
            if (createPriceItem != null) {
                mutableListOf.add(createPriceItem);
            }
            AttributedText offer = checkoutContentsResult.getOffer();
            if (offer != null) {
                mutableListOf.add(new DisclaimerItem(BaseAnalyticKt.ANALYTIC_MODULE_OFFER, offer));
            }
            return new LoadingState.Loaded(new CheckoutContent(checkoutContentsResult.getActionTitle(), checkoutContentsResult.getCloseButtonTitle(), checkoutContentsResult.getEmptyActionTitle(), mutableListOf, checkoutContentsResult.getPrice(), checkoutContentsResult.getDelayedAction()));
        } else if ((loadingState instanceof LoadingState.Error) || (loadingState instanceof LoadingState.Loading)) {
            return loadingState;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
