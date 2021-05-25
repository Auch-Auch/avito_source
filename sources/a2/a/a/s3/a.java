package a2.a.a.s3;

import android.content.DialogInterface;
import com.avito.android.lastclick.LastClick;
import com.avito.android.version_conflict.ResolveAppVersionConflictActivity;
public final class a implements DialogInterface.OnClickListener {
    public final /* synthetic */ ResolveAppVersionConflictActivity a;

    public a(ResolveAppVersionConflictActivity resolveAppVersionConflictActivity) {
        this.a = resolveAppVersionConflictActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        LastClick.Updater.update();
        ResolveAppVersionConflictActivity.access$openMobileVersion(this.a);
    }
}
