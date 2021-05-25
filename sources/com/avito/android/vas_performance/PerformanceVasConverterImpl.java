package com.avito.android.vas_performance;

import com.avito.android.conveyor_shared_item.paid_services.PaidServiceHeaderItem;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.vas.performance.VasPerformanceResult;
import com.avito.android.vas_performance.ui.items.info_action.InfoActionItem;
import com.avito.android.vas_performance.ui.items.tabs.Tab;
import com.avito.android.vas_performance.ui.items.tabs.TabsItem;
import com.avito.android.vas_performance.ui.items.vas.PerformanceVasItem;
import com.avito.conveyor_item.Item;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/avito/android/vas_performance/PerformanceVasConverterImpl;", "Lcom/avito/android/vas_performance/PerformanceVasConverter;", "Lcom/avito/android/remote/model/vas/performance/VasPerformanceResult;", "performanceResult", "", "Lcom/avito/conveyor_item/Item;", "convert", "(Lcom/avito/android/remote/model/vas/performance/VasPerformanceResult;)Ljava/util/List;", "<init>", "()V", "vas-performance_release"}, k = 1, mv = {1, 4, 2})
public final class PerformanceVasConverterImpl implements PerformanceVasConverter {
    @Override // com.avito.android.vas_performance.PerformanceVasConverter
    @NotNull
    public List<Item> convert(@NotNull VasPerformanceResult vasPerformanceResult) {
        Intrinsics.checkNotNullParameter(vasPerformanceResult, "performanceResult");
        List<Item> mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new PaidServiceHeaderItem("vas_title", vasPerformanceResult.getTitle(), vasPerformanceResult.getDescription()));
        ArrayList arrayList = new ArrayList();
        for (T t : vasPerformanceResult.getTabs()) {
            arrayList.add(new Tab(t.getTitle(), t.getSelected()));
            for (T t2 : t.getVasList()) {
                mutableListOf.add(new PerformanceVasItem(t2.getId(), t2.getTitle(), t2.getPrice(), t2.getOldPrice(), t2.getIcon(), t2.getPriceValue(), t2.getName(), t.getTitle(), t2.getDeepLink()));
            }
        }
        mutableListOf.add(1, new TabsItem("vas_tabs", arrayList));
        Action infoAction = vasPerformanceResult.getInfoAction();
        InfoActionItem infoActionItem = infoAction != null ? new InfoActionItem("vas_info_action", infoAction.getTitle(), infoAction.getDeepLink()) : null;
        if (infoActionItem != null) {
            mutableListOf.add(infoActionItem);
        }
        return mutableListOf;
    }
}
