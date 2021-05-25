package a2.a.a.o1.d.a0.m;

import com.avito.android.messenger.conversation.mvi.send.SendMessagePresenterImpl;
import com.avito.android.util.Logs;
import io.reactivex.functions.Consumer;
public final class e<T> implements Consumer<Throwable> {
    public final /* synthetic */ SendMessagePresenterImpl.FilePickedAction.c a;

    public e(SendMessagePresenterImpl.FilePickedAction.c cVar) {
        this.a = cVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Throwable th) {
        Logs.debug(this.a.a.d.getTAG(), "Failed to create file message", th);
    }
}
