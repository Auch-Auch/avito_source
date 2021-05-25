package a2.a.a.v2.a;

import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.short_term_rent.confirm_booking.StrConfirmBookingViewImpl;
import com.avito.android.ui.VerticalListItemDecoration;
import java.util.Iterator;
import java.util.List;
public final class g<T> implements Observer<List<? extends Integer>> {
    public final /* synthetic */ StrConfirmBookingViewImpl a;

    public g(StrConfirmBookingViewImpl strConfirmBookingViewImpl) {
        this.a = strConfirmBookingViewImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(List<? extends Integer> list) {
        List<? extends Integer> list2 = list;
        if (list2 != null) {
            RecyclerView.ItemDecoration itemDecoration = this.a.h;
            if (itemDecoration != null) {
                this.a.d.removeItemDecoration(itemDecoration);
            }
            StrConfirmBookingViewImpl strConfirmBookingViewImpl = this.a;
            VerticalListItemDecoration.Builder builder = new VerticalListItemDecoration.Builder(null, 1, null);
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                builder.setDividerForItemAt(it.next().intValue(), this.a.f);
            }
            VerticalListItemDecoration build = builder.setPadding(this.a.g, this.a.g).drawForLastItem(false).build();
            this.a.d.addItemDecoration(build);
            strConfirmBookingViewImpl.h = build;
        }
    }
}
