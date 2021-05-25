package a2.a.a.r.b.b.a;

import com.avito.android.basket_legacy.event.PerformanceVasClickEvent;
import com.avito.android.basket_legacy.repositories.BasketRepository;
import com.avito.android.basket_legacy.utils.VasService;
import com.avito.android.basket_legacy.viewmodels.vas.performance.LegacyPerformanceVasViewModelImpl;
import com.avito.android.deep_linking.links.LegacyPaidServicesLink;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
public final class d<T> implements Consumer<VasService> {
    public final /* synthetic */ LegacyPerformanceVasViewModelImpl a;

    public d(LegacyPerformanceVasViewModelImpl legacyPerformanceVasViewModelImpl) {
        this.a = legacyPerformanceVasViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r3v6, resolved type: com.avito.android.util.architecture_components.SingleLiveEvent */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Consumer
    public void accept(VasService vasService) {
        VasService vasService2 = vasService;
        BasketRepository basketRepository = this.a.s;
        Intrinsics.checkNotNullExpressionValue(vasService2, "it");
        basketRepository.addVas(vasService2);
        if (Intrinsics.areEqual(this.a.x, LegacyPaidServicesLink.FROM_CREATION)) {
            this.a.w.track(new PerformanceVasClickEvent(this.a.q));
        }
        this.a.g.postValue(Unit.INSTANCE);
    }
}
