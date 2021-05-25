package a2.a.a.p3.a.a;

import com.avito.android.lib.design.bottom_sheet.BottomSheetDialog;
import com.avito.android.vas_discount.ui.dialog.DiscountDialogFragment;
public final class a implements Runnable {
    public final /* synthetic */ b a;

    public a(b bVar) {
        this.a = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (DiscountDialogFragment.access$getLayoutManager$p(this.a.a).findLastCompletelyVisibleItemPosition() == DiscountDialogFragment.access$getLayoutManager$p(this.a.a).getItemCount() - 1) {
            BottomSheetDialog bottomSheetDialog = this.a.a.d;
            if (bottomSheetDialog != null) {
                bottomSheetDialog.expand();
            }
            BottomSheetDialog bottomSheetDialog2 = this.a.a.d;
            if (bottomSheetDialog2 != null) {
                bottomSheetDialog2.setSkipCollapsed(true);
            }
        }
    }
}
