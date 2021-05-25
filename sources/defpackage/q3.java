package defpackage;

import com.avito.android.util.Logs;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: java-style lambda group */
/* renamed from: q3  reason: default package */
public final class q3<T> implements Consumer<Throwable> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public q3(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public final void accept(Throwable th) {
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
            sb.append(" Subscription to ChatEvent stream encountered an error (");
            sb.append((String) this.b);
            sb.append(')');
            Logs.error("MessageSyncAgent", sb.toString(), th);
        } else if (i == 1) {
            StringBuilder sb3 = new StringBuilder();
            StringBuilder sb4 = new StringBuilder();
            sb4.append('[');
            Thread currentThread2 = Thread.currentThread();
            Intrinsics.checkNotNullExpressionValue(currentThread2, "Thread.currentThread()");
            sb4.append(currentThread2.getName());
            sb4.append(']');
            sb3.append(sb4.toString());
            sb3.append(" Subscription to getReadLocallyMessageIds");
            sb3.append(" encountered an error (");
            sb3.append((String) this.b);
            sb3.append(')');
            Logs.error("MessageSyncAgent", sb3.toString(), th);
        } else {
            throw null;
        }
    }
}
