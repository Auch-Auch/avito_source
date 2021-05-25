package a2.a.a.g.m;

import com.avito.android.advert_core.short_term_rent.AdvertStrBlockViewImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class e extends Lambda implements Function1<Boolean, Unit> {
    public final /* synthetic */ AdvertStrBlockViewImpl a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(AdvertStrBlockViewImpl advertStrBlockViewImpl) {
        super(1);
        this.a = advertStrBlockViewImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Boolean bool) {
        this.a.b.onSwitchChanged(bool.booleanValue());
        return Unit.INSTANCE;
    }
}
