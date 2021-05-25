package defpackage;

import com.avito.android.util.Logs;
import io.reactivex.functions.Consumer;
/* compiled from: java-style lambda group */
/* renamed from: w0  reason: default package */
public final class w0<T> implements Consumer<Throwable> {
    public static final w0 b = new w0(0);
    public static final w0 c = new w0(1);
    public final /* synthetic */ int a;

    public w0(int i) {
        this.a = i;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public final void accept(Throwable th) {
        int i = this.a;
        if (i == 0) {
            Logs.error(th);
        } else if (i == 1) {
            Logs.error(th);
        } else {
            throw null;
        }
    }
}
