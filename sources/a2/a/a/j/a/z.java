package a2.a.a.j.a;

import a2.b.a.a.a;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import com.avito.android.util.Logs;
import io.reactivex.functions.Consumer;
public final class z<T> implements Consumer<Throwable> {
    public final /* synthetic */ LocalMessage a;

    public z(LocalMessage localMessage) {
        this.a = localMessage;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        StringBuilder L = a.L("Error handling message: ");
        L.append(this.a.localId);
        Logs.error("PendingMessageHandler", L.toString(), th);
    }
}
