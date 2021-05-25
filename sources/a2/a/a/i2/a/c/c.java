package a2.a.a.i2.a.c;

import androidx.lifecycle.Observer;
import com.avito.android.lib.design.bottom_sheet.BottomSheetDialog;
import com.avito.android.safedeal.delivery_courier.time_interval_select.DeliveryCourierTimeIntervalSelectFragment;
import com.avito.android.safedeal.delivery_courier.time_interval_select.DeliveryCourierTimeIntervalSelectView;
import com.avito.android.safedeal.delivery_courier.time_interval_select.model.DialogData;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
public final class c<T> implements Observer<List<? extends DialogData>> {
    public final /* synthetic */ DeliveryCourierTimeIntervalSelectFragment a;

    public c(DeliveryCourierTimeIntervalSelectFragment deliveryCourierTimeIntervalSelectFragment) {
        this.a = deliveryCourierTimeIntervalSelectFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(List<? extends DialogData> list) {
        int size;
        int i;
        Pair pair;
        DeliveryCourierTimeIntervalSelectView deliveryCourierTimeIntervalSelectView;
        List<? extends DialogData> list2 = list;
        if (list2 != null) {
            if (list2.size() > this.a.c.size()) {
                int size2 = list2.size();
                for (int size3 = this.a.c.size(); size3 < size2; size3++) {
                    DeliveryCourierTimeIntervalSelectFragment.access$showDialog(this.a, (DialogData) list2.get(size3));
                }
            } else if (list2.size() == this.a.c.size()) {
                DialogData dialogData = (DialogData) CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) list2);
                if (!(dialogData == null || (pair = (Pair) CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) this.a.c)) == null || (deliveryCourierTimeIntervalSelectView = (DeliveryCourierTimeIntervalSelectView) pair.getSecond()) == null)) {
                    deliveryCourierTimeIntervalSelectView.bindData(dialogData);
                }
            } else if (list2.size() < this.a.c.size() && this.a.c.size() - 1 >= (size = list2.size())) {
                while (true) {
                    ((BottomSheetDialog) ((Pair) this.a.c.get(i)).getFirst()).dismiss();
                    if (i != size) {
                        i--;
                    } else {
                        return;
                    }
                }
            }
        }
    }
}
