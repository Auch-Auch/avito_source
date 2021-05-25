package a2.a.a.k;

import com.avito.android.app_rater.AppRaterInteractorImpl;
import com.avito.android.remote.model.AppRaterSession;
import java.util.concurrent.Callable;
public final class a<V> implements Callable<AppRaterSession> {
    public final /* synthetic */ AppRaterInteractorImpl a;

    public a(AppRaterInteractorImpl appRaterInteractorImpl) {
        this.a = appRaterInteractorImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public AppRaterSession call() {
        return this.a.a.getLastSession();
    }
}
