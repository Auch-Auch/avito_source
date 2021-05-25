package defpackage;

import android.view.View;
import com.avito.android.lib.design.bottom_sheet.BottomSheetDialog;
import com.avito.android.profile.sessions.list.SessionLogoutConfirmationViewImpl;
import kotlin.Unit;
/* compiled from: java-style lambda group */
/* renamed from: e0  reason: default package */
public final class e0 implements View.OnClickListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public e0(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.a;
        if (i == 0) {
            ((SessionLogoutConfirmationViewImpl) this.b).d.accept(Unit.INSTANCE);
        } else if (i == 1) {
            BottomSheetDialog bottomSheetDialog = ((SessionLogoutConfirmationViewImpl) this.b).a;
            if (bottomSheetDialog != null) {
                bottomSheetDialog.dismiss();
            }
        } else {
            throw null;
        }
    }
}
