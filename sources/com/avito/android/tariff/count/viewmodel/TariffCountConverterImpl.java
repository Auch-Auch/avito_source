package com.avito.android.tariff.count.viewmodel;

import com.avito.android.conveyor_shared_item.paid_services.PaidServiceHeaderItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.TariffCount;
import com.avito.android.remote.model.TariffCountPrice;
import com.avito.android.remote.model.TariffCountResult;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.tariff.count.item.CountItem;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.conveyor_item.Item;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
import t6.n.h;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/tariff/count/viewmodel/TariffCountConverterImpl;", "Lcom/avito/android/tariff/count/viewmodel/TariffCountConverter;", "Lcom/avito/android/remote/model/TariffCountResult;", "tariffCountResult", "", "Lcom/avito/conveyor_item/Item;", "convert", "(Lcom/avito/android/remote/model/TariffCountResult;)Ljava/util/List;", "Lcom/avito/android/tariff/count/viewmodel/PriceConverter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/tariff/count/viewmodel/PriceConverter;", "priceConverter", "Lcom/avito/android/util/text/AttributedTextFormatter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "<init>", "(Lcom/avito/android/util/text/AttributedTextFormatter;Lcom/avito/android/tariff/count/viewmodel/PriceConverter;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class TariffCountConverterImpl implements TariffCountConverter {
    public final AttributedTextFormatter a;
    public final PriceConverter b;

    @Inject
    public TariffCountConverterImpl(@NotNull AttributedTextFormatter attributedTextFormatter, @NotNull PriceConverter priceConverter) {
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        Intrinsics.checkNotNullParameter(priceConverter, "priceConverter");
        this.a = attributedTextFormatter;
        this.b = priceConverter;
    }

    @Override // com.avito.android.tariff.count.viewmodel.TariffCountConverter
    @NotNull
    public List<Item> convert(@NotNull TariffCountResult tariffCountResult) {
        Intrinsics.checkNotNullParameter(tariffCountResult, "tariffCountResult");
        AttributedText description = tariffCountResult.getDescription();
        List<Item> mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new PaidServiceHeaderItem("headerId", tariffCountResult.getTitle(), description != null ? this.a.format(description) : null));
        List<TariffCount> list = tariffCountResult.getList();
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        for (T t : list) {
            TariffCountPrice countPrice = t.getCountPrice();
            arrayList.add(new CountItem(t.getId(), t.getTitle(), t.getDescription(), countPrice != null ? this.b.convertPrice(countPrice) : null, t.isSelected(), false, 32, null));
        }
        h.addAll(mutableListOf, arrayList);
        return mutableListOf;
    }
}
