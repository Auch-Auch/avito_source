package a2.a.a.u.a;

import com.avito.android.booking.info.ActionButtonState;
import com.avito.android.booking.info.BookingInfoFragment;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class a extends Lambda implements Function0<Unit> {
    public final /* synthetic */ BookingInfoFragment a;
    public final /* synthetic */ ActionButtonState b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(BookingInfoFragment bookingInfoFragment, ActionButtonState actionButtonState) {
        super(0);
        this.a = bookingInfoFragment;
        this.b = actionButtonState;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        BookingInfoFragment.access$getViewModel$p(this.a).onButtonClicked(this.b.getDeepLink());
        return Unit.INSTANCE;
    }
}
