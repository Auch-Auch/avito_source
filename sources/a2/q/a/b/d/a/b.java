package a2.q.a.b.d.a;

import android.content.DialogInterface;
import com.sumsub.sns.camera.video.presentation.SNSVideoSelfieActivity;
public final class b implements DialogInterface.OnCancelListener {
    public final /* synthetic */ SNSVideoSelfieActivity a;

    public b(SNSVideoSelfieActivity sNSVideoSelfieActivity) {
        this.a = sNSVideoSelfieActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        this.a.finish();
    }
}
