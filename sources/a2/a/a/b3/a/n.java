package a2.a.a.b3.a;

import com.avito.android.str_calendar.booking.CalendarViewImpl;
import com.jakewharton.rxrelay2.Relay;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class n extends Lambda implements Function0<Unit> {
    public final /* synthetic */ CalendarViewImpl a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n(CalendarViewImpl calendarViewImpl) {
        super(0);
        this.a = calendarViewImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        Relay relay = this.a.c;
        Unit unit = Unit.INSTANCE;
        relay.accept(unit);
        return unit;
    }
}
