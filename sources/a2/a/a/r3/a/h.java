package a2.a.a.r3.a;

import android.view.View;
import com.avito.android.verification.verification_status.VerificationStatusScreenData;
import com.avito.android.verification.verification_status.VerificationStatusViewImpl;
public final class h implements View.OnClickListener {
    public final /* synthetic */ VerificationStatusScreenData.Button a;
    public final /* synthetic */ VerificationStatusViewImpl b;

    public h(VerificationStatusScreenData.Button button, VerificationStatusViewImpl verificationStatusViewImpl) {
        this.a = button;
        this.b = verificationStatusViewImpl;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.b.q.invoke(this.a.getDeeplink());
    }
}
