package a2.a.a.o1.d.a0.n;

import a2.b.a.a.a;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import com.avito.android.util.Logs;
import io.reactivex.functions.Consumer;
public final class p<T> implements Consumer<LocalMessage> {
    public static final p a = new p();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(LocalMessage localMessage) {
        LocalMessage localMessage2 = localMessage;
        StringBuilder sb = new StringBuilder();
        a.f1("Thread.currentThread()", a.I('['), ']', sb, " Message received: channelId=");
        sb.append(localMessage2.channelId);
        sb.append(", remoteId=");
        sb.append(localMessage2.remoteId);
        sb.append(", localId=");
        sb.append(localMessage2.localId);
        Logs.verbose$default("MessageSyncAgent", sb.toString(), null, 4, null);
    }
}
