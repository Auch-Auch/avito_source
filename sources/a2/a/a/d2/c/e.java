package a2.a.a.d2.c;

import com.avito.android.public_profile.ui.SubscriptionsPresenter;
import com.avito.android.public_profile.ui.SubscriptionsPresenterImpl;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Unit;
public final class e<T> implements Consumer<Unit> {
    public final /* synthetic */ SubscriptionsPresenterImpl a;

    public e(SubscriptionsPresenterImpl subscriptionsPresenterImpl) {
        this.a = subscriptionsPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Unit unit) {
        SubscriptionsPresenter.Router router = this.a.d;
        if (router != null) {
            router.openNotificationsSettings();
        }
    }
}
