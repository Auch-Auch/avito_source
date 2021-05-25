package com.avito.android.vas_performance.ui.items.tabs;

import com.avito.konveyor.blueprint.ItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\n\u001a\u00020\u00052\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\bH&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/vas_performance/ui/items/tabs/TabsItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "Lcom/avito/android/vas_performance/ui/items/tabs/Tab;", "tabs", "", "setTabs", "(Ljava/util/List;)V", "Lkotlin/Function1;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setTabSelectedListener", "(Lkotlin/jvm/functions/Function1;)V", "vas-performance_release"}, k = 1, mv = {1, 4, 2})
public interface TabsItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull TabsItemView tabsItemView) {
            ItemView.DefaultImpls.onUnbind(tabsItemView);
        }
    }

    void setTabSelectedListener(@NotNull Function1<? super Tab, Unit> function1);

    void setTabs(@NotNull List<Tab> list);
}
