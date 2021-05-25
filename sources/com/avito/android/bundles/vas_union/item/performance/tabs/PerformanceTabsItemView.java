package com.avito.android.bundles.vas_union.item.performance.tabs;

import com.avito.android.bundles.vas_union.item.tabs.Tab;
import com.avito.konveyor.blueprint.ItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J%\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ#\u0010\f\u001a\u00020\u00072\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\nH&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/bundles/vas_union/item/performance/tabs/PerformanceTabsItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "Lcom/avito/android/bundles/vas_union/item/tabs/Tab;", "tabs", "", "selectedPosition", "", "setTabs", "(Ljava/util/List;I)V", "Lkotlin/Function1;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setTabSelectedListener", "(Lkotlin/jvm/functions/Function1;)V", "vas-bundles_release"}, k = 1, mv = {1, 4, 2})
public interface PerformanceTabsItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull PerformanceTabsItemView performanceTabsItemView) {
            ItemView.DefaultImpls.onUnbind(performanceTabsItemView);
        }
    }

    void setTabSelectedListener(@NotNull Function1<? super Tab, Unit> function1);

    void setTabs(@NotNull List<Tab> list, int i);
}
