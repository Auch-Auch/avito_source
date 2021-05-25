package a2.a.a.h2.a;

import androidx.core.app.NotificationCompat;
import com.avito.android.remote.notification.NotificationIdentifier;
import com.avito.android.remote.notification.NotificationImages;
import com.avito.android.remote.notification.NotificationInteractorImpl;
import com.avito.android.remote.notification.NotificationParameters;
import com.avito.android.util.LoadingState;
import io.reactivex.functions.Consumer;
public final class a<T> implements Consumer<LoadingState<? super NotificationImages>> {
    public final /* synthetic */ NotificationInteractorImpl a;
    public final /* synthetic */ NotificationIdentifier b;
    public final /* synthetic */ NotificationParameters c;
    public final /* synthetic */ NotificationCompat.Action d;

    public a(NotificationInteractorImpl notificationInteractorImpl, NotificationIdentifier notificationIdentifier, NotificationParameters notificationParameters, NotificationCompat.Action action) {
        this.a = notificationInteractorImpl;
        this.b = notificationIdentifier;
        this.c = notificationParameters;
        this.d = action;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(LoadingState<? super NotificationImages> loadingState) {
        LoadingState<? super NotificationImages> loadingState2 = loadingState;
        this.a.f(this.b);
        if (loadingState2 instanceof LoadingState.Error) {
            this.a.e(this.b, this.c, this.d);
        } else if (loadingState2 instanceof LoadingState.Loaded) {
            NotificationInteractorImpl.access$showWithBigImage(this.a, (NotificationImages) ((LoadingState.Loaded) loadingState2).getData(), this.b, this.c, this.d);
        }
    }
}
