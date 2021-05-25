package a2.a.a.b2;

import com.avito.android.profile.UserProfilePresenterImpl;
import com.avito.android.profile.UserProfileView;
import io.reactivex.functions.Action;
public final class b1 implements Action {
    public final /* synthetic */ UserProfilePresenterImpl a;

    public b1(UserProfilePresenterImpl userProfilePresenterImpl) {
        this.a = userProfilePresenterImpl;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        UserProfileView userProfileView = this.a.a;
        if (userProfileView != null) {
            userProfileView.showContent();
        }
    }
}
