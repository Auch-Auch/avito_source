package a2.a.a.x.b.c;

import com.avito.android.bundles.vas_union.item.tabs.TabsInfo;
import com.avito.android.bundles.vas_union.viewmodel.VasUnionViewModel;
import com.avito.android.bundles.vas_union.viewmodel.VasUnionViewState;
import com.avito.android.design.widget.tab.CommonTab;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
public final class g<T> implements Consumer<CommonTab> {
    public final /* synthetic */ VasUnionViewModel a;

    public g(VasUnionViewModel vasUnionViewModel) {
        this.a = vasUnionViewModel;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(CommonTab commonTab) {
        VasUnionViewState copy$default;
        CommonTab commonTab2 = commonTab;
        TabsInfo tabsInfo = VasUnionViewModel.access$getVasUnionConvertInfo$p(this.a).getTabsInfo();
        Intrinsics.checkNotNullExpressionValue(commonTab2, "tab");
        tabsInfo.setSelectedTab(commonTab2);
        List list = this.a.c(tabsInfo.getItemsForTab(commonTab2), VasUnionViewModel.access$getVasUnionConvertInfo$p(this.a).getTabsItem().getSelectedPerformanceTabsTitle());
        VasUnionViewState value = this.a.getViewState().getValue();
        if (!(value == null || (copy$default = VasUnionViewState.copy$default(value, null, CollectionsKt___CollectionsKt.plus((Collection) VasUnionViewModel.access$getHeaderItems$p(this.a), (Iterable) list), 1, null)) == null)) {
            this.a.getViewState().postValue(copy$default);
        }
        this.a.d();
    }
}
