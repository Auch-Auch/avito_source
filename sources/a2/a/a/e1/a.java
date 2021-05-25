package a2.a.a.e1;

import android.content.DialogInterface;
import com.avito.android.imv.ImvWebViewBottomSheetActivity;
public final class a implements DialogInterface.OnDismissListener {
    public final /* synthetic */ ImvWebViewBottomSheetActivity a;

    public a(ImvWebViewBottomSheetActivity imvWebViewBottomSheetActivity) {
        this.a = imvWebViewBottomSheetActivity;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        this.a.finish();
    }
}
