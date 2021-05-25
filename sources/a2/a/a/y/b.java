package a2.a.a.y;

import com.avito.android.call_feedback.CallFeedbackPresenter;
import com.avito.android.call_feedback.CallFeedbackView;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.error.TypedError;
import com.avito.android.util.TypedResultException;
import io.reactivex.functions.Consumer;
public final class b<T> implements Consumer<Throwable> {
    public final /* synthetic */ CallFeedbackPresenter.Impl a;

    public b(CallFeedbackPresenter.Impl impl) {
        this.a = impl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        CallFeedbackView callFeedbackView;
        Throwable th2 = th;
        CallFeedbackView callFeedbackView2 = this.a.f;
        if (callFeedbackView2 != null) {
            callFeedbackView2.hideDialog();
        }
        if (th2 instanceof TypedResultException) {
            TypedError errorResult = ((TypedResultException) th2).getErrorResult();
            if ((errorResult instanceof ErrorWithMessage) && (callFeedbackView = this.a.f) != null) {
                callFeedbackView.showMessage(((ErrorWithMessage) errorResult).getMessage());
            }
        }
    }
}
