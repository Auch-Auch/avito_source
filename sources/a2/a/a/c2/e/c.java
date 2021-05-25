package a2.a.a.c2.e;

import com.avito.android.profile_phones.phone_management.PhoneManagementPresenterImpl;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
public final class c<T> implements Consumer<Disposable> {
    public final /* synthetic */ PhoneManagementPresenterImpl a;

    public c(PhoneManagementPresenterImpl phoneManagementPresenterImpl) {
        this.a = phoneManagementPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Disposable disposable) {
        PhoneManagementPresenterImpl.access$handleRequestStarted(this.a);
    }
}
