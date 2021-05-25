package a2.a.a.r.b.b.a;

import com.avito.android.basket_legacy.viewmodels.vas.performance.LegacyPerformanceVasViewModelImpl;
import com.avito.android.vas_performance.ui.items.info_action.InfoActionItem;
import io.reactivex.functions.Consumer;
public final class a<T> implements Consumer<InfoActionItem> {
    public final /* synthetic */ LegacyPerformanceVasViewModelImpl a;

    public a(LegacyPerformanceVasViewModelImpl legacyPerformanceVasViewModelImpl) {
        this.a = legacyPerformanceVasViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(InfoActionItem infoActionItem) {
        LegacyPerformanceVasViewModelImpl.access$openUri(this.a, infoActionItem.getDeepLink());
    }
}
