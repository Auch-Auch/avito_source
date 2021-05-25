package defpackage;

import com.avito.android.util.Logs;
import io.reactivex.functions.Consumer;
/* compiled from: java-style lambda group */
/* renamed from: h  reason: default package */
public final class h<T> implements Consumer<Throwable> {
    public static final h b = new h(0);
    public static final h c = new h(1);
    public static final h d = new h(2);
    public static final h e = new h(3);
    public static final h f = new h(4);
    public static final h g = new h(5);
    public final /* synthetic */ int a;

    public h(int i) {
        this.a = i;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public final void accept(Throwable th) {
        int i = this.a;
        if (i == 0) {
            Logs.error("Failed to observe select clicks", th);
        } else if (i == 1) {
            Logs.error("Failed to delete button clicks", th);
        } else if (i == 2) {
            Logs.error("Failed to observe input value changes", th);
        } else if (i == 3) {
            Logs.error("Failed to observe chips select clicks", th);
        } else if (i == 4) {
            Logs.error("Failed to observe chips select clicks", th);
        } else if (i == 5) {
            Logs.error("Failed to observe radiogroup select clicks", th);
        } else {
            throw null;
        }
    }
}
