package defpackage;

import android.content.DialogInterface;
import com.sumsub.sns.camera.SNSCameraActivity;
import com.sumsub.sns.core.common.ExtensionsKt;
/* compiled from: java-style lambda group */
/* renamed from: c3  reason: default package */
public final class c3 implements DialogInterface.OnClickListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public c3(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        int i2 = this.a;
        if (i2 == 0) {
            ((SNSCameraActivity) this.b).finish();
        } else if (i2 == 1) {
            ExtensionsKt.openAppSettings((SNSCameraActivity) this.b);
        } else {
            throw null;
        }
    }
}
