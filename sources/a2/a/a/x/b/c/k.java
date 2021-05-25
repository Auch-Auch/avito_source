package a2.a.a.x.b.c;

import com.avito.android.bundles.vas_union.item.tabs.Tab;
import com.avito.android.bundles.vas_union.item.tabs.TabsInfo;
import com.avito.android.bundles.vas_union.viewmodel.VasUnionViewModel;
import com.avito.android.bundles.vas_union.viewmodel.VasUnionViewState;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
public final class k<T> implements Consumer<Tab> {
    public final /* synthetic */ VasUnionViewModel a;

    public k(VasUnionViewModel vasUnionViewModel) {
        this.a = vasUnionViewModel;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Tab tab) {
        VasUnionViewState copy$default;
        TabsInfo tabsInfo = VasUnionViewModel.access$getVasUnionConvertInfo$p(this.a).getTabsInfo();
        VasUnionViewModel.access$getVasUnionConvertInfo$p(this.a).getTabsItem().setSelectedPerformanceTabsTitle(tab.getTitle());
        List list = this.a.c(tabsInfo.getItemsForTab(tabsInfo.getSelectedTab()), VasUnionViewModel.access$getVasUnionConvertInfo$p(this.a).getTabsItem().getSelectedPerformanceTabsTitle());
        VasUnionViewState value = this.a.getViewState().getValue();
        if (value != null && (copy$default = VasUnionViewState.copy$default(value, null, CollectionsKt___CollectionsKt.plus((Collection) VasUnionViewModel.access$getHeaderItems$p(this.a), (Iterable) list), 1, null)) != null) {
            this.a.getViewState().postValue(copy$default);
        }
    }
}
