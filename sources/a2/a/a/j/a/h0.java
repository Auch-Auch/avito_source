package a2.a.a.j.a;

import com.avito.android.app.task.MessageSendingTracker;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
public final class h0<T> implements Consumer<Disposable> {
    public final /* synthetic */ MessageSendingTracker a;

    public h0(MessageSendingTracker messageSendingTracker) {
        this.a = messageSendingTracker;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Disposable disposable) {
        this.a.trackSendingStarted();
    }
}
