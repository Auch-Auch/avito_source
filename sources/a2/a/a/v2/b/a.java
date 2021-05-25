package a2.a.a.v2.b;

import com.avito.android.short_term_rent.hotels.HotelsActivity;
import com.avito.android.str_calendar.utils.DateRange;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class a extends Lambda implements Function1<DateRange, Unit> {
    public final /* synthetic */ HotelsActivity a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(HotelsActivity hotelsActivity) {
        super(1);
        this.a = hotelsActivity;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(DateRange dateRange) {
        HotelsActivity.access$getViewModel$p(this.a).datesChanged(dateRange);
        return Unit.INSTANCE;
    }
}
