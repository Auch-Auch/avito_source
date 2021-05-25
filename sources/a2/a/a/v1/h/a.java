package a2.a.a.v1.h;

import com.avito.android.phone_confirmation.view.PhoneConfirmationView;
import com.jakewharton.rxrelay2.Relay;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class a extends Lambda implements Function0<Unit> {
    public final /* synthetic */ PhoneConfirmationView.d a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(PhoneConfirmationView.d dVar) {
        super(0);
        this.a = dVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        Relay relay = this.a.a.g;
        Unit unit = Unit.INSTANCE;
        relay.accept(unit);
        return unit;
    }
}
