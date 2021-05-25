package a2.a.a.e2.g0;

import com.avito.android.publish.view.ItemDetailsViewImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class a extends Lambda implements Function0<Unit> {
    public final /* synthetic */ ItemDetailsViewImpl a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(ItemDetailsViewImpl itemDetailsViewImpl) {
        super(0);
        this.a = itemDetailsViewImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        this.a.n.onMainButtonClicked();
        return Unit.INSTANCE;
    }
}
