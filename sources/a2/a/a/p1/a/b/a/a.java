package a2.a.a.p1.a.b.a;

import com.avito.android.notification_center.landing.recommends.review.NcRecommendsReviewPresenterImpl;
import com.avito.android.notification_center.landing.recommends.review.NcRecommendsReviewRouter;
import com.avito.android.notification_center.landing.recommends.review.NcRecommendsReviewView;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.model.notification_center.NcRecommendsFeedbackResult;
import com.avito.android.util.LoadingState;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class a extends Lambda implements Function1<LoadingState<? super NcRecommendsFeedbackResult>, Unit> {
    public final /* synthetic */ NcRecommendsReviewPresenterImpl a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(NcRecommendsReviewPresenterImpl ncRecommendsReviewPresenterImpl) {
        super(1);
        this.a = ncRecommendsReviewPresenterImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(LoadingState<? super NcRecommendsFeedbackResult> loadingState) {
        LoadingState<? super NcRecommendsFeedbackResult> loadingState2 = loadingState;
        if (loadingState2 instanceof LoadingState.Loading) {
            NcRecommendsReviewView ncRecommendsReviewView = this.a.c;
            if (ncRecommendsReviewView != null) {
                ncRecommendsReviewView.showProgressDialog();
            }
        } else if (loadingState2 instanceof LoadingState.Loaded) {
            this.a.d = null;
            NcRecommendsReviewView ncRecommendsReviewView2 = this.a.c;
            if (ncRecommendsReviewView2 != null) {
                ncRecommendsReviewView2.hideProgressDialog();
            }
            NcRecommendsReviewView ncRecommendsReviewView3 = this.a.c;
            if (ncRecommendsReviewView3 != null) {
                ncRecommendsReviewView3.showMessage(((NcRecommendsFeedbackResult) ((LoadingState.Loaded) loadingState2).getData()).getMessage());
            }
            NcRecommendsReviewRouter ncRecommendsReviewRouter = this.a.b;
            if (ncRecommendsReviewRouter != null) {
                ncRecommendsReviewRouter.backToRecommends();
            }
        } else if (loadingState2 instanceof LoadingState.Error) {
            this.a.d = null;
            TypedError error = ((LoadingState.Error) loadingState2).getError();
            if (error instanceof ErrorResult) {
                NcRecommendsReviewView ncRecommendsReviewView4 = this.a.c;
                if (ncRecommendsReviewView4 != null) {
                    ncRecommendsReviewView4.hideProgressDialog();
                }
                NcRecommendsReviewView ncRecommendsReviewView5 = this.a.c;
                if (ncRecommendsReviewView5 != null) {
                    ncRecommendsReviewView5.showMessage(((ErrorResult) error).getMessage());
                }
            }
        }
        return Unit.INSTANCE;
    }
}
