package a2.a.a.b.i;

import com.avito.android.authorization.select_profile.SelectProfilePresenterImpl;
import com.avito.android.authorization.select_profile.SelectProfileView;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
public final class a<T> implements Consumer<Disposable> {
    public final /* synthetic */ SelectProfilePresenterImpl a;

    public a(SelectProfilePresenterImpl selectProfilePresenterImpl) {
        this.a = selectProfilePresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Disposable disposable) {
        SelectProfileView selectProfileView = this.a.a;
        if (selectProfileView != null) {
            selectProfileView.showProgress();
        }
    }
}
