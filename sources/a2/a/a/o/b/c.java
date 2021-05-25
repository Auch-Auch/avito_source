package a2.a.a.o.b;

import com.avito.android.autoteka_details.core.AutotekaTeaserInteractorImpl;
import com.avito.android.remote.model.AutotekaTeaserResponse;
import io.reactivex.functions.Consumer;
public final class c<T> implements Consumer<AutotekaTeaserResponse> {
    public final /* synthetic */ AutotekaTeaserInteractorImpl a;

    public c(AutotekaTeaserInteractorImpl autotekaTeaserInteractorImpl) {
        this.a = autotekaTeaserInteractorImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(AutotekaTeaserResponse autotekaTeaserResponse) {
        this.a.a = autotekaTeaserResponse;
    }
}
