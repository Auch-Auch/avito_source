package a2.a.a.b2;

import com.avito.android.profile.UserProfilePresenter;
import com.avito.android.profile.UserProfilePresenterImpl;
import io.reactivex.functions.Action;
public final class c implements Action {
    public final /* synthetic */ UserProfilePresenterImpl a;

    public c(UserProfilePresenterImpl userProfilePresenterImpl) {
        this.a = userProfilePresenterImpl;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        UserProfilePresenter.Router router = this.a.b;
        if (router != null) {
            router.closeScreen();
        }
    }
}
