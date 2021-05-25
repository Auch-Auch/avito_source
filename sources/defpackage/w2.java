package defpackage;

import com.avito.android.util.Logs;
import io.reactivex.functions.Action;
/* compiled from: java-style lambda group */
/* renamed from: w2  reason: default package */
public final class w2 implements Action {
    public static final w2 b = new w2(0);
    public static final w2 c = new w2(1);
    public static final w2 d = new w2(2);
    public final /* synthetic */ int a;

    public w2(int i) {
        this.a = i;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        int i = this.a;
        if (i == 0) {
            Logs.verbose$default("PendingMessageSendingTask", "Canceled send pending messages work", null, 4, null);
        } else if (i == 1) {
            Logs.verbose$default("PendingMessageSendingTask", "Scheduled send pending message work", null, 4, null);
        } else if (i == 2) {
            Logs.verbose$default("PendingMessageSendingTask", "Scheduled send pending message work with delay", null, 4, null);
        } else {
            throw null;
        }
    }
}
