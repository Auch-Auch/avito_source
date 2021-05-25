package a2.a.a.o.b;

import com.avito.android.autoteka_details.core.AutotekaDetailsInteractorImpl;
import com.avito.android.remote.model.AutotekaDetailsResponse;
import io.reactivex.functions.Consumer;
public final class b<T> implements Consumer<AutotekaDetailsResponse> {
    public final /* synthetic */ AutotekaDetailsInteractorImpl a;

    public b(AutotekaDetailsInteractorImpl autotekaDetailsInteractorImpl) {
        this.a = autotekaDetailsInteractorImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(AutotekaDetailsResponse autotekaDetailsResponse) {
        this.a.setAutotekaDetails(autotekaDetailsResponse);
    }
}
