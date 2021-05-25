package a2.q.a.b.d.a;

import android.view.View;
import com.sumsub.sns.camera.video.presentation.SNSVideoSelfieActivity;
public final class a implements View.OnClickListener {
    public final /* synthetic */ SNSVideoSelfieActivity a;

    public a(SNSVideoSelfieActivity sNSVideoSelfieActivity) {
        this.a = sNSVideoSelfieActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.finish();
    }
}
