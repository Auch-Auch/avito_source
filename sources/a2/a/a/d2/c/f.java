package a2.a.a.d2.c;

import com.avito.android.public_profile.ui.SubscribeButtonsView;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
public final class f<T> implements Consumer<Disposable> {
    public final /* synthetic */ SubscribeButtonsView a;

    public f(SubscribeButtonsView subscribeButtonsView) {
        this.a = subscribeButtonsView;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Disposable disposable) {
        this.a.setNotificationLoading(true);
    }
}
