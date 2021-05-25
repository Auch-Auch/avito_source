package a2.a.a.i2.a.c;

import android.content.DialogInterface;
import androidx.fragment.app.FragmentActivity;
import com.avito.android.lib.design.bottom_sheet.BottomSheetDialog;
import com.avito.android.safedeal.delivery_courier.time_interval_select.DeliveryCourierTimeIntervalSelectFragment;
import com.avito.android.safedeal.delivery_courier.time_interval_select.model.DialogData;
import java.util.List;
import java.util.ListIterator;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
public final class d implements DialogInterface.OnDismissListener {
    public final /* synthetic */ BottomSheetDialog a;
    public final /* synthetic */ DeliveryCourierTimeIntervalSelectFragment b;

    public d(BottomSheetDialog bottomSheetDialog, DeliveryCourierTimeIntervalSelectFragment deliveryCourierTimeIntervalSelectFragment, DialogData dialogData) {
        this.a = bottomSheetDialog;
        this.b = deliveryCourierTimeIntervalSelectFragment;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        int i;
        List list = this.b.c;
        ListIterator listIterator = list.listIterator(list.size());
        while (true) {
            if (listIterator.hasPrevious()) {
                if (Intrinsics.areEqual((BottomSheetDialog) ((Pair) listIterator.previous()).getFirst(), this.a)) {
                    i = listIterator.nextIndex();
                    break;
                }
            } else {
                i = -1;
                break;
            }
        }
        if (i == 0) {
            FragmentActivity activity = this.b.getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        this.b.c.remove(i);
        this.b.getViewModel().onDialogDismissed(i);
    }
}
