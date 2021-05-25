package a2.a.a.v2.b;

import com.avito.android.remote.model.hotels.HotelsLocation;
import com.avito.android.short_term_rent.hotels.HotelsActivity;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class e extends Lambda implements Function1<HotelsLocation, Unit> {
    public final /* synthetic */ HotelsActivity a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(HotelsActivity hotelsActivity) {
        super(1);
        this.a = hotelsActivity;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(HotelsLocation hotelsLocation) {
        HotelsActivity.access$getViewModel$p(this.a).locationChanged(hotelsLocation);
        return Unit.INSTANCE;
    }
}
