package a2.q.a.d.a;

import android.view.View;
import com.sumsub.sns.presentation.screen.SNSAppActivity;
public final class a implements View.OnClickListener {
    public final /* synthetic */ SNSAppActivity a;

    public a(SNSAppActivity sNSAppActivity) {
        this.a = sNSAppActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.onBackPressed();
    }
}
