package a2.a.a.v2.b.i.b;

import com.avito.android.short_term_rent.hotels.data.BookingPeople;
import com.avito.android.short_term_rent.hotels.dialogs.guests.HotelsGuestsDialog;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class c extends Lambda implements Function1<BookingPeople, Unit> {
    public final /* synthetic */ HotelsGuestsDialog a;
    public final /* synthetic */ Function0 b;
    public final /* synthetic */ Function1 c;
    public final /* synthetic */ Function0 d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(HotelsGuestsDialog hotelsGuestsDialog, Function0 function0, Function1 function1, Function0 function02) {
        super(1);
        this.a = hotelsGuestsDialog;
        this.b = function0;
        this.c = function1;
        this.d = function02;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(BookingPeople bookingPeople) {
        BookingPeople bookingPeople2 = bookingPeople;
        Intrinsics.checkNotNullParameter(bookingPeople2, "result");
        this.c.invoke(bookingPeople2);
        this.a.performDismiss();
        return Unit.INSTANCE;
    }
}
