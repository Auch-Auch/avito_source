package defpackage;

import com.avito.android.util.Logs;
import io.reactivex.functions.Consumer;
/* compiled from: java-style lambda group */
/* renamed from: y  reason: default package */
public final class y<T> implements Consumer<Throwable> {
    public static final y b = new y(0);
    public static final y c = new y(1);
    public final /* synthetic */ int a;

    public y(int i) {
        this.a = i;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public final void accept(Throwable th) {
        int i = this.a;
        if (i == 0) {
            Logs.error("Failed to handle deepLink from slot", th);
        } else if (i == 1) {
            Logs.error("Failed to handle deepLink from slot", th);
        } else {
            throw null;
        }
    }
}
