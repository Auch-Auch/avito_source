package a2.a.a.f.x.u;

import com.avito.android.advert.item.domoteka.DomotekaTeaserInteractorImpl;
import com.avito.android.remote.DomotekaTeaserResponse;
import io.reactivex.rxjava3.functions.Consumer;
public final class a<T> implements Consumer<DomotekaTeaserResponse> {
    public final /* synthetic */ DomotekaTeaserInteractorImpl a;

    public a(DomotekaTeaserInteractorImpl domotekaTeaserInteractorImpl) {
        this.a = domotekaTeaserInteractorImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(DomotekaTeaserResponse domotekaTeaserResponse) {
        this.a.a.set(domotekaTeaserResponse);
    }
}
