package defpackage;

import com.avito.android.util.Logs;
import io.reactivex.functions.Consumer;
/* compiled from: java-style lambda group */
/* renamed from: s0  reason: default package */
public final class s0<T> implements Consumer<Throwable> {
    public static final s0 b = new s0(0);
    public static final s0 c = new s0(1);
    public final /* synthetic */ int a;

    public s0(int i) {
        this.a = i;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public final void accept(Throwable th) {
        int i = this.a;
        if (i == 0) {
            Logs.error("Failed on observe reload click", th);
        } else if (i == 1) {
            Logs.error("Failed on observe switcher value changed", th);
        } else {
            throw null;
        }
    }
}
