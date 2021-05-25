package a2.a.a.p1.a.b.b;

import com.avito.android.notification_center.landing.recommends.review_list.NcRecommendsReviewListPresenterImpl;
import com.avito.android.notification_center.landing.recommends.review_list.NcRecommendsReviewListRouter;
import com.avito.android.notification_center.landing.recommends.review_list.NcRecommendsReviewListView;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.model.notification_center.NcRecommendsFeedbackResult;
import com.avito.android.util.LoadingState;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class a extends Lambda implements Function1<LoadingState<? super NcRecommendsFeedbackResult>, Unit> {
    public final /* synthetic */ NcRecommendsReviewListPresenterImpl a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(NcRecommendsReviewListPresenterImpl ncRecommendsReviewListPresenterImpl) {
        super(1);
        this.a = ncRecommendsReviewListPresenterImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(LoadingState<? super NcRecommendsFeedbackResult> loadingState) {
        LoadingState<? super NcRecommendsFeedbackResult> loadingState2 = loadingState;
        if (loadingState2 instanceof LoadingState.Loading) {
            NcRecommendsReviewListView ncRecommendsReviewListView = this.a.e;
            if (ncRecommendsReviewListView != null) {
                ncRecommendsReviewListView.showProgressDialog();
            }
        } else if (loadingState2 instanceof LoadingState.Loaded) {
            this.a.c = null;
            NcRecommendsReviewListView ncRecommendsReviewListView2 = this.a.e;
            if (ncRecommendsReviewListView2 != null) {
                ncRecommendsReviewListView2.hideProgressDialog();
            }
            NcRecommendsReviewListView ncRecommendsReviewListView3 = this.a.e;
            if (ncRecommendsReviewListView3 != null) {
                ncRecommendsReviewListView3.showMessage(((NcRecommendsFeedbackResult) ((LoadingState.Loaded) loadingState2).getData()).getMessage());
            }
            NcRecommendsReviewListRouter ncRecommendsReviewListRouter = this.a.d;
            if (ncRecommendsReviewListRouter != null) {
                ncRecommendsReviewListRouter.closeScreen();
            }
        } else if (loadingState2 instanceof LoadingState.Error) {
            this.a.c = null;
            TypedError error = ((LoadingState.Error) loadingState2).getError();
            if (error instanceof ErrorResult) {
                NcRecommendsReviewListView ncRecommendsReviewListView4 = this.a.e;
                if (ncRecommendsReviewListView4 != null) {
                    ncRecommendsReviewListView4.hideProgressDialog();
                }
                NcRecommendsReviewListView ncRecommendsReviewListView5 = this.a.e;
                if (ncRecommendsReviewListView5 != null) {
                    ncRecommendsReviewListView5.showMessage(((ErrorResult) error).getMessage());
                }
            }
        }
        return Unit.INSTANCE;
    }
}
