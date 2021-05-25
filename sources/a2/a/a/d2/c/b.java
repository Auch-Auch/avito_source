package a2.a.a.d2.c;

import com.avito.android.public_profile.ui.PublicProfilePresenterImpl;
import com.avito.android.public_profile.ui.PublicProfileView;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
public final class b<T> implements Consumer<Disposable> {
    public final /* synthetic */ PublicProfilePresenterImpl a;

    public b(PublicProfilePresenterImpl publicProfilePresenterImpl) {
        this.a = publicProfilePresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Disposable disposable) {
        PublicProfileView publicProfileView = this.a.d;
        if (publicProfileView != null) {
            publicProfileView.showProgress();
        }
        this.a.v.onStartProfileLoading();
    }
}
