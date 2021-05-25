package a2.a.a.v2.b;

import com.avito.android.short_term_rent.hotels.HotelsActivity;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class d extends Lambda implements Function0<Unit> {
    public final /* synthetic */ HotelsActivity a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(HotelsActivity hotelsActivity) {
        super(0);
        this.a = hotelsActivity;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        HotelsActivity.access$getGuestsDialog$p(this.a).dismiss();
        return Unit.INSTANCE;
    }
}
