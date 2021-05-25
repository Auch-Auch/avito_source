package a2.a.a.g.f;

import android.net.Uri;
import com.avito.android.advert_core.delivery.AdvertDeliveryBlockView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class a extends Lambda implements Function0<Unit> {
    public final /* synthetic */ Uri a;
    public final /* synthetic */ AdvertDeliveryBlockView b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Uri uri, AdvertDeliveryBlockView advertDeliveryBlockView) {
        super(0);
        this.a = uri;
        this.b = advertDeliveryBlockView;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        this.b.e.followUri(this.a);
        return Unit.INSTANCE;
    }
}
