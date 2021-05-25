package a2.a.a.b2;

import com.avito.android.profile.UserProfilePresenterImpl;
import com.avito.android.profile.UserProfileView;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
public final class a1<T> implements Consumer<Disposable> {
    public final /* synthetic */ UserProfilePresenterImpl a;

    public a1(UserProfilePresenterImpl userProfilePresenterImpl) {
        this.a = userProfilePresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Disposable disposable) {
        UserProfileView userProfileView = this.a.a;
        if (userProfileView != null) {
            userProfileView.showLogoutProgress();
        }
    }
}
