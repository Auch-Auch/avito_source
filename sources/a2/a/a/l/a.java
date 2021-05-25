package a2.a.a.l;

import com.avito.android.async_phone.AsyncPhonePresenterImpl;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
public final class a<T> implements Consumer<Disposable> {
    public final /* synthetic */ AsyncPhonePresenterImpl a;

    public a(AsyncPhonePresenterImpl asyncPhonePresenterImpl) {
        this.a = asyncPhonePresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Disposable disposable) {
        this.a.f.startLoadingPhone();
    }
}
