package a2.a.a.g.e.i;

import android.view.View;
import com.avito.android.advert_core.contactbar.feedback.FeedbackDialog;
import com.avito.android.lib.design.input.Input;
import com.avito.android.util.Keyboards;
public final class a implements View.OnClickListener {
    public final /* synthetic */ FeedbackDialog a;

    public a(FeedbackDialog feedbackDialog) {
        this.a = feedbackDialog;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        FeedbackDialog.Listener listener = this.a.v;
        Input input = this.a.getInput();
        String deformattedText = input != null ? input.getDeformattedText() : null;
        if (deformattedText == null) {
            deformattedText = "";
        }
        listener.onFeedbackSend(deformattedText, this.a.u.getFeedbackSource());
        Input input2 = this.a.getInput();
        if (input2 != null) {
            Keyboards.hideKeyboardWithAttempt$default(input2, 0, 10, 1, null);
        }
        this.a.close();
    }
}
