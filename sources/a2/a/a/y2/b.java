package a2.a.a.y2;

import com.avito.android.social_management.SocialManagementPresenterImpl;
import com.avito.android.social_management.SocialManagementView;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
public final class b<T> implements Consumer<Disposable> {
    public final /* synthetic */ SocialManagementPresenterImpl a;

    public b(SocialManagementPresenterImpl socialManagementPresenterImpl) {
        this.a = socialManagementPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Disposable disposable) {
        SocialManagementView socialManagementView = this.a.a;
        if (socialManagementView != null) {
            socialManagementView.showProgress();
        }
    }
}
