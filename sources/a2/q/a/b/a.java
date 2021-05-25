package a2.q.a.b;

import android.content.DialogInterface;
import com.sumsub.sns.camera.SNSCameraActivity;
public final class a implements DialogInterface.OnCancelListener {
    public final /* synthetic */ SNSCameraActivity a;

    public a(SNSCameraActivity sNSCameraActivity) {
        this.a = sNSCameraActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        this.a.finish();
    }
}
