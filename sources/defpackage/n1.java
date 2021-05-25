package defpackage;

import android.content.DialogInterface;
import com.avito.android.lastclick.LastClick;
import com.avito.android.version_conflict.ResolveAppVersionConflictActivity;
/* compiled from: java-style lambda group */
/* renamed from: n1  reason: default package */
public final class n1 implements DialogInterface.OnClickListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public n1(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        int i2 = this.a;
        if (i2 == 0) {
            LastClick.Updater.update();
            ResolveAppVersionConflictActivity.access$openMarket((ResolveAppVersionConflictActivity) this.b);
        } else if (i2 == 1) {
            LastClick.Updater.update();
            ((ResolveAppVersionConflictActivity) this.b).finishAffinity();
        } else {
            throw null;
        }
    }
}
