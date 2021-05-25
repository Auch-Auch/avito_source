package a2.a.a.b2;

import com.avito.android.profile.UserProfilePresenterImpl;
import com.avito.android.profile.UserProfileView;
import io.reactivex.functions.Consumer;
public final class d<T> implements Consumer<Throwable> {
    public final /* synthetic */ UserProfilePresenterImpl a;

    public d(UserProfilePresenterImpl userProfilePresenterImpl) {
        this.a = userProfilePresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        UserProfileView userProfileView = this.a.a;
        if (userProfileView != null) {
            userProfileView.showError();
        }
    }
}
