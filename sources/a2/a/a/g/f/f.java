package a2.a.a.g.f;

import com.avito.android.advert_core.delivery.AdvertDeliveryBlockView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class f extends Lambda implements Function1<Boolean, Unit> {
    public final /* synthetic */ AdvertDeliveryBlockView a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(AdvertDeliveryBlockView advertDeliveryBlockView) {
        super(1);
        this.a = advertDeliveryBlockView;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Boolean bool) {
        this.a.c.onSwitchChanged(bool.booleanValue());
        return Unit.INSTANCE;
    }
}
