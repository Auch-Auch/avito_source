package a2.a.a.r.b.b.b;

import com.avito.android.basket_legacy.viewmodels.vas.visual.LegacyVisualVasViewModelImpl;
import com.avito.android.vas_performance.ui.items.visual.VisualVasItem;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class d<T> implements Consumer<VisualVasItem> {
    public final /* synthetic */ LegacyVisualVasViewModelImpl a;

    public d(LegacyVisualVasViewModelImpl legacyVisualVasViewModelImpl) {
        this.a = legacyVisualVasViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(VisualVasItem visualVasItem) {
        VisualVasItem visualVasItem2 = visualVasItem;
        LegacyVisualVasViewModelImpl legacyVisualVasViewModelImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(visualVasItem2, "it");
        LegacyVisualVasViewModelImpl.access$selectItem(legacyVisualVasViewModelImpl, visualVasItem2);
    }
}
