package a2.a.a.d.a;

import com.avito.android.abuse.details.AbuseDetailsPresenterImpl;
import com.avito.android.abuse.details.AbuseDetailsView;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
public final class a<T> implements Consumer<Disposable> {
    public final /* synthetic */ AbuseDetailsPresenterImpl a;

    public a(AbuseDetailsPresenterImpl abuseDetailsPresenterImpl) {
        this.a = abuseDetailsPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Disposable disposable) {
        AbuseDetailsView abuseDetailsView = this.a.b;
        if (abuseDetailsView != null) {
            AbuseDetailsPresenterImpl.access$showProgress(this.a, abuseDetailsView);
        }
    }
}
