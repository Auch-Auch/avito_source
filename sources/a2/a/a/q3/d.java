package a2.a.a.q3;

import com.avito.android.vas_performance.VisualVasViewModelImpl;
import com.avito.android.vas_performance.ui.items.visual.VisualVasItem;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class d<T> implements Consumer<VisualVasItem> {
    public final /* synthetic */ VisualVasViewModelImpl a;

    public d(VisualVasViewModelImpl visualVasViewModelImpl) {
        this.a = visualVasViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(VisualVasItem visualVasItem) {
        VisualVasItem visualVasItem2 = visualVasItem;
        VisualVasViewModelImpl visualVasViewModelImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(visualVasItem2, "it");
        VisualVasViewModelImpl.access$selectItem(visualVasViewModelImpl, visualVasItem2);
    }
}
