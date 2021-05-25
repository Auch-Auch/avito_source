package a2.a.a.i3.b;

import com.avito.android.user_adverts.items_search.ProfileItemsSearchViewModelImpl;
import io.reactivex.functions.Consumer;
public final class f<T> implements Consumer<Throwable> {
    public final /* synthetic */ ProfileItemsSearchViewModelImpl a;

    public f(ProfileItemsSearchViewModelImpl profileItemsSearchViewModelImpl) {
        this.a = profileItemsSearchViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        ProfileItemsSearchViewModelImpl.access$onFatalErrorReceived(this.a);
    }
}
