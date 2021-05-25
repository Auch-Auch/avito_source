package defpackage;

import com.avito.android.util.Logs;
import io.reactivex.rxjava3.functions.Consumer;
/* compiled from: java-style lambda group */
/* renamed from: u3  reason: default package */
public final class u3<T> implements Consumer<Throwable> {
    public static final u3 b = new u3(0);
    public static final u3 c = new u3(1);
    public static final u3 d = new u3(2);
    public static final u3 e = new u3(3);
    public static final u3 f = new u3(4);
    public static final u3 g = new u3(5);
    public final /* synthetic */ int a;

    public u3(int i) {
        this.a = i;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public final void accept(Throwable th) {
        int i = this.a;
        if (i == 0) {
            Logs.error("Failed to observe main button clicks", th);
        } else if (i == 1) {
            Logs.error("Failed to observe clear button clicks", th);
        } else if (i == 2) {
            Logs.error("Failed to observe back click events", th);
        } else if (i == 3) {
            Logs.error("Failed to observe clear search events", th);
        } else if (i == 4) {
            Logs.error("Failed to observe search focus events", th);
        } else if (i == 5) {
            Logs.error("Failed to observe search text changes", th);
        } else {
            throw null;
        }
    }
}
