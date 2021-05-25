package a2.a.a.o1.d.a0.m;

import com.avito.android.messenger.analytics.MessageType;
import com.avito.android.messenger.analytics.SendMessageEvent;
import com.avito.android.messenger.conversation.mvi.send.SendMessagePresenterImpl;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
public final class d<T> implements Consumer<Unit> {
    public final /* synthetic */ SendMessagePresenterImpl.FilePickedAction.c a;

    public d(SendMessagePresenterImpl.FilePickedAction.c cVar) {
        this.a = cVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Unit unit) {
        this.a.a.d.A.track(new SendMessageEvent.Send(this.a.a.d.C, MessageType.FILE, false));
    }
}
