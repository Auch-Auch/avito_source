package a2.a.a.q3.f;

import com.avito.android.vas_performance.ui.PerformanceVasViewModelImpl;
import com.avito.android.vas_performance.ui.items.info_action.InfoActionItem;
import io.reactivex.functions.Consumer;
public final class a0<T> implements Consumer<InfoActionItem> {
    public final /* synthetic */ PerformanceVasViewModelImpl a;

    public a0(PerformanceVasViewModelImpl performanceVasViewModelImpl) {
        this.a = performanceVasViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(InfoActionItem infoActionItem) {
        PerformanceVasViewModelImpl.access$openUri(this.a, infoActionItem.getDeepLink());
    }
}
