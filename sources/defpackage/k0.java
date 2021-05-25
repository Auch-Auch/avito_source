package defpackage;

import com.avito.android.util.Logs;
import io.reactivex.functions.Consumer;
/* compiled from: java-style lambda group */
/* renamed from: k0  reason: default package */
public final class k0<T> implements Consumer<Throwable> {
    public static final k0 b = new k0(0);
    public static final k0 c = new k0(1);
    public static final k0 d = new k0(2);
    public final /* synthetic */ int a;

    public k0(int i) {
        this.a = i;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public final void accept(Throwable th) {
        int i = this.a;
        if (i == 0) {
            Logs.error("PendingMessageSendingTask", "Failed to cancel work", th);
        } else if (i == 1) {
            Logs.error("PendingMessageSendingTask", "Failed to enqueue work", th);
        } else if (i == 2) {
            Logs.error("PendingMessageSendingTask", "Failed to enqueue work", th);
        } else {
            throw null;
        }
    }
}
