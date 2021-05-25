package a2.a.a.y;

import com.avito.android.call_feedback.CallFeedbackPresenter;
import com.avito.android.call_feedback.CallFeedbackRouter;
import com.avito.android.call_feedback.CallFeedbackView;
import com.avito.android.remote.model.CallFeedbackResult;
import io.reactivex.functions.Consumer;
public final class a<T> implements Consumer<CallFeedbackResult> {
    public final /* synthetic */ CallFeedbackPresenter.Impl a;

    public a(CallFeedbackPresenter.Impl impl) {
        this.a = impl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(CallFeedbackResult callFeedbackResult) {
        CallFeedbackResult callFeedbackResult2 = callFeedbackResult;
        CallFeedbackView callFeedbackView = this.a.f;
        if (callFeedbackView != null) {
            callFeedbackView.showMessage(callFeedbackResult2.getMessage());
        }
        CallFeedbackRouter callFeedbackRouter = this.a.e;
        if (callFeedbackRouter != null) {
            callFeedbackRouter.close();
        }
    }
}
