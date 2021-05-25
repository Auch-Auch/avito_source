package com.avito.android.vas_performance;

import com.avito.android.conveyor_shared_item.paid_services.PaidServiceHeaderItem;
import com.avito.android.remote.model.vas.visual.VasVisualResult;
import com.avito.android.remote.model.vas.visual.VisualVas;
import com.avito.android.vas_performance.ui.items.visual.VisualVasItem;
import com.avito.conveyor_item.Item;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/avito/android/vas_performance/VisualVasConverterImpl;", "Lcom/avito/android/vas_performance/VisualVasConverter;", "Lcom/avito/android/remote/model/vas/visual/VasVisualResult;", "vasResult", "", "Lcom/avito/conveyor_item/Item;", "convert", "(Lcom/avito/android/remote/model/vas/visual/VasVisualResult;)Ljava/util/List;", "<init>", "()V", "vas-performance_release"}, k = 1, mv = {1, 4, 2})
public final class VisualVasConverterImpl implements VisualVasConverter {
    @Override // com.avito.android.vas_performance.VisualVasConverter
    @NotNull
    public List<Item> convert(@NotNull VasVisualResult vasVisualResult) {
        Intrinsics.checkNotNullParameter(vasVisualResult, "vasResult");
        List<VisualVas> vasList = vasVisualResult.getVasList();
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(vasList, 10));
        for (T t : vasList) {
            arrayList.add(new VisualVasItem(t.getId(), t.getTitle(), t.getDescription(), t.getPrice(), t.getOldPrice(), t.getIcon(), t.getPriceValue(), t.getSelected()));
        }
        List<Item> mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
        mutableList.add(0, new PaidServiceHeaderItem("visual_vas_title", vasVisualResult.getTitle(), vasVisualResult.getDescription()));
        return mutableList;
    }
}
