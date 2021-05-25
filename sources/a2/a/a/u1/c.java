package a2.a.a.u1;

import com.avito.android.permissions.LocationPermissionDialogPresenter;
import com.avito.android.permissions.LocationPermissionDialogPresenterImpl;
import com.avito.android.util.Logs;
import io.reactivex.rxjava3.functions.Consumer;
public final class c<T> implements Consumer<Throwable> {
    public final /* synthetic */ LocationPermissionDialogPresenterImpl a;

    public c(LocationPermissionDialogPresenterImpl locationPermissionDialogPresenterImpl) {
        this.a = locationPermissionDialogPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Throwable th) {
        Throwable th2 = th;
        LocationPermissionDialogPresenter.Subscriber subscriber = this.a.c;
        if (subscriber != null) {
            subscriber.onLocationNotFound(th2.getMessage());
        }
        Logs.error(th2);
    }
}
