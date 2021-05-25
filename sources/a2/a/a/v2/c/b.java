package a2.a.a.v2.c;

import androidx.lifecycle.Observer;
import com.avito.android.short_term_rent.start_booking.StrStartBookingViewImpl;
import java.util.List;
import kotlin.ranges.IntRange;
public final class b<T> implements Observer<List<? extends IntRange>> {
    public final /* synthetic */ StrStartBookingViewImpl a;

    public b(StrStartBookingViewImpl strStartBookingViewImpl) {
        this.a = strStartBookingViewImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(List<? extends IntRange> list) {
        List<? extends IntRange> list2 = list;
        if (list2 != null) {
            StrStartBookingViewImpl.access$setGroupsBounds(this.a, list2);
        }
    }
}
