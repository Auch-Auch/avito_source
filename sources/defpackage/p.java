package defpackage;

import android.content.DialogInterface;
import com.sumsub.sns.camera.video.presentation.SNSVideoSelfieActivity;
import com.sumsub.sns.core.common.ExtensionsKt;
/* compiled from: java-style lambda group */
/* renamed from: p  reason: default package */
public final class p implements DialogInterface.OnClickListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public p(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        int i2 = this.a;
        if (i2 == 0) {
            ((SNSVideoSelfieActivity) this.b).finish();
        } else if (i2 == 1) {
            ExtensionsKt.openAppSettings((SNSVideoSelfieActivity) this.b);
        } else {
            throw null;
        }
    }
}
