package defpackage;

import com.avito.android.util.Logs;
import io.reactivex.functions.Action;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: java-style lambda group */
/* renamed from: o  reason: default package */
public final class o implements Action {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public o(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        int i = this.a;
        if (i == 0) {
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            sb2.append('[');
            Thread currentThread = Thread.currentThread();
            Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
            sb2.append(currentThread.getName());
            sb2.append(']');
            sb.append(sb2.toString());
            sb.append(" Subscription to getReadLocallyMessageIds");
            sb.append(" completed (");
            sb.append((String) this.b);
            sb.append(')');
            Logs.verbose$default("MessageSyncAgent", sb.toString(), null, 4, null);
        } else if (i == 1) {
            StringBuilder sb3 = new StringBuilder();
            StringBuilder sb4 = new StringBuilder();
            sb4.append('[');
            Thread currentThread2 = Thread.currentThread();
            Intrinsics.checkNotNullExpressionValue(currentThread2, "Thread.currentThread()");
            sb4.append(currentThread2.getName());
            sb4.append(']');
            sb3.append(sb4.toString());
            sb3.append(" Subscription to ChatEvent stream disposed (");
            sb3.append((String) this.b);
            sb3.append(')');
            Logs.verbose$default("MessageSyncAgent", sb3.toString(), null, 4, null);
        } else if (i == 2) {
            StringBuilder sb5 = new StringBuilder();
            StringBuilder sb6 = new StringBuilder();
            sb6.append('[');
            Thread currentThread3 = Thread.currentThread();
            Intrinsics.checkNotNullExpressionValue(currentThread3, "Thread.currentThread()");
            sb6.append(currentThread3.getName());
            sb6.append(']');
            sb5.append(sb6.toString());
            sb5.append(" Subscription to ChatEvent stream completed (");
            sb5.append((String) this.b);
            sb5.append(')');
            Logs.verbose$default("MessageSyncAgent", sb5.toString(), null, 4, null);
        } else {
            throw null;
        }
    }
}
