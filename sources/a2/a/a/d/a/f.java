package a2.a.a.d.a;

import com.avito.android.abuse.details.AbuseDetailsPresenter;
import com.avito.android.abuse.details.AbuseDetailsPresenterImpl;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Unit;
public final class f<T> implements Consumer<Unit> {
    public final /* synthetic */ AbuseDetailsPresenterImpl a;

    public f(AbuseDetailsPresenterImpl abuseDetailsPresenterImpl) {
        this.a = abuseDetailsPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Unit unit) {
        AbuseDetailsPresenter.Router router = this.a.a;
        if (router != null) {
            router.openAuthQueryScreen();
        }
    }
}
