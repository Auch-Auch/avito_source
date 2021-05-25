package a2.a.a.k1.a.a;

import android.widget.FrameLayout;
import com.avito.android.lib.design.bottom_sheet.ModalBottomSheetViewImpl;
import com.avito.android.util.Keyboards;
public final class c implements Runnable {
    public final /* synthetic */ ModalBottomSheetViewImpl a;

    public c(ModalBottomSheetViewImpl modalBottomSheetViewImpl) {
        this.a = modalBottomSheetViewImpl;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Keyboards.hideKeyboardWithAttempt$default(this.a.x, 0, 0, 2, null);
        FrameLayout frameLayout = this.a.m;
        if (frameLayout != null) {
            Keyboards.hideKeyboardWithAttempt$default(frameLayout, 0, 0, 2, null);
        }
    }
}
