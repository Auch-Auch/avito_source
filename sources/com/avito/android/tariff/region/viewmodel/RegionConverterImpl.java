package com.avito.android.tariff.region.viewmodel;

import com.avito.android.conveyor_shared_item.paid_services.PaidServiceHeaderItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.TariffRegion;
import com.avito.android.remote.model.TariffRegionResult;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.tariff.region.item.RegionItem;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/tariff/region/viewmodel/RegionConverterImpl;", "Lcom/avito/android/tariff/region/viewmodel/RegionConverter;", "Lcom/avito/android/remote/model/TariffRegionResult;", "regionResult", "", "Lcom/avito/conveyor_item/Item;", "convert", "(Lcom/avito/android/remote/model/TariffRegionResult;)Ljava/util/List;", "Lcom/avito/android/util/text/AttributedTextFormatter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "<init>", "(Lcom/avito/android/util/text/AttributedTextFormatter;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class RegionConverterImpl implements RegionConverter {
    public final AttributedTextFormatter a;

    @Inject
    public RegionConverterImpl(@NotNull AttributedTextFormatter attributedTextFormatter) {
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        this.a = attributedTextFormatter;
    }

    @Override // com.avito.android.tariff.region.viewmodel.RegionConverter
    @NotNull
    public List<Item> convert(@NotNull TariffRegionResult tariffRegionResult) {
        Intrinsics.checkNotNullParameter(tariffRegionResult, "regionResult");
        AttributedText description = tariffRegionResult.getDescription();
        List<Item> mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new PaidServiceHeaderItem("headerId", tariffRegionResult.getTitle(), description != null ? this.a.format(description) : null));
        List<TariffRegion> list = tariffRegionResult.getList();
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        for (T t : list) {
            arrayList.add(new RegionItem(t.getId(), t.getTitle(), t.isSelected()));
        }
        h.addAll(mutableListOf, arrayList);
        return mutableListOf;
    }
}
