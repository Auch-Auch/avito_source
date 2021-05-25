package defpackage;

import com.avito.android.rating.user_review_details.UserReviewDetailsPresenterImpl;
import com.avito.android.rating.user_review_details.UserReviewDetailsView;
import io.reactivex.rxjava3.functions.Action;
/* compiled from: java-style lambda group */
/* renamed from: r  reason: default package */
public final class r implements Action {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public r(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // io.reactivex.rxjava3.functions.Action
    public final void run() {
        int i = this.a;
        if (i == 0) {
            UserReviewDetailsView userReviewDetailsView = ((UserReviewDetailsPresenterImpl) this.b).a;
            if (userReviewDetailsView != null) {
                userReviewDetailsView.hideProgress();
            }
        } else if (i == 1) {
            UserReviewDetailsPresenterImpl.access$handleReviewDeleted((UserReviewDetailsPresenterImpl) this.b);
        } else {
            throw null;
        }
    }
}
