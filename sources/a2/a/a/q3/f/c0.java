package a2.a.a.q3.f;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.vas_performance.ui.PerformanceVasViewModelImpl;
import com.avito.android.vas_performance.ui.items.vas.PerformanceVasItem;
import io.reactivex.functions.Consumer;
public final class c0<T> implements Consumer<PerformanceVasItem> {
    public final /* synthetic */ PerformanceVasViewModelImpl a;

    public c0(PerformanceVasViewModelImpl performanceVasViewModelImpl) {
        this.a = performanceVasViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.avito.android.util.architecture_components.SingleLiveEvent */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Consumer
    public void accept(PerformanceVasItem performanceVasItem) {
        DeepLink deepLink = performanceVasItem.getDeepLink();
        if (deepLink != null) {
            this.a.h.postValue(deepLink);
        }
    }
}
