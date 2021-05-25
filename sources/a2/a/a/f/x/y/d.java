package a2.a.a.f.x.y;

import android.view.View;
import com.avito.android.lib.design.bottom_sheet.BottomSheetDialog;
public final class d implements View.OnClickListener {
    public final /* synthetic */ BottomSheetDialog a;

    public d(BottomSheetDialog bottomSheetDialog) {
        this.a = bottomSheetDialog;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.close();
    }
}
