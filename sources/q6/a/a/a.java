package q6.a.a;

import android.os.Handler;
import android.os.Message;
import eu.davidea.flexibleadapter.FlexibleAdapter;
public class a implements Handler.Callback {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ FlexibleAdapter c;

    public a(FlexibleAdapter flexibleAdapter, int i, int i2) {
        this.c = flexibleAdapter;
        this.a = i;
        this.b = i2;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        FlexibleAdapter flexibleAdapter = this.c;
        if (flexibleAdapter.mRecyclerView == null) {
            return false;
        }
        int findFirstCompletelyVisibleItemPosition = flexibleAdapter.getFlexibleLayoutManager().findFirstCompletelyVisibleItemPosition();
        int findLastCompletelyVisibleItemPosition = this.c.getFlexibleLayoutManager().findLastCompletelyVisibleItemPosition();
        int i = this.a;
        int i2 = this.b;
        if ((i + i2) - findLastCompletelyVisibleItemPosition > 0) {
            int min = Math.min(i - findFirstCompletelyVisibleItemPosition, Math.max(0, (i + i2) - findLastCompletelyVisibleItemPosition));
            int spanCount = this.c.getFlexibleLayoutManager().getSpanCount();
            if (spanCount > 1) {
                min = (min % spanCount) + spanCount;
            }
            FlexibleAdapter.b(this.c, findFirstCompletelyVisibleItemPosition + min);
        } else if (i < findFirstCompletelyVisibleItemPosition) {
            FlexibleAdapter.b(this.c, i);
        }
        return true;
    }
}
