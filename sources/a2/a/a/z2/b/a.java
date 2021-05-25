package a2.a.a.z2.b;

import android.content.DialogInterface;
import android.view.View;
import com.avito.android.spare_parts.bottom_sheet.SparePartsBottomSheetActivity;
public final class a implements DialogInterface.OnDismissListener {
    public final /* synthetic */ SparePartsBottomSheetActivity a;
    public final /* synthetic */ View b;

    public a(SparePartsBottomSheetActivity sparePartsBottomSheetActivity, View view) {
        this.a = sparePartsBottomSheetActivity;
        this.b = view;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        this.a.finish();
    }
}
