package a2.a.a.y2;

import com.avito.android.social_management.SocialManagementPresenterImpl;
import com.avito.android.social_management.SocialManagementView;
import io.reactivex.functions.Action;
public final class c implements Action {
    public final /* synthetic */ SocialManagementPresenterImpl a;

    public c(SocialManagementPresenterImpl socialManagementPresenterImpl) {
        this.a = socialManagementPresenterImpl;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        SocialManagementView socialManagementView = this.a.a;
        if (socialManagementView != null) {
            socialManagementView.hideProgress();
        }
    }
}
