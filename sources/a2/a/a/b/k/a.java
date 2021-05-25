package a2.a.a.b.k;

import com.avito.android.authorization.start_registration.StartRegistrationPresenterImpl;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
public final class a<T> implements Consumer<Disposable> {
    public final /* synthetic */ StartRegistrationPresenterImpl a;

    public a(StartRegistrationPresenterImpl startRegistrationPresenterImpl) {
        this.a = startRegistrationPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Disposable disposable) {
        StartRegistrationPresenterImpl.access$handleRequestStarted(this.a);
    }
}
