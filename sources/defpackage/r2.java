package defpackage;

import com.avito.android.util.Logs;
import io.reactivex.functions.Consumer;
/* compiled from: java-style lambda group */
/* renamed from: r2  reason: default package */
public final class r2<T> implements Consumer<Throwable> {
    public static final r2 b = new r2(0);
    public static final r2 c = new r2(1);
    public static final r2 d = new r2(2);
    public static final r2 e = new r2(3);
    public final /* synthetic */ int a;

    public r2(int i) {
        this.a = i;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public final void accept(Throwable th) {
        int i = this.a;
        if (i == 0) {
            Logs.debug("MessageBodyResolver", "Failed to resolve images for Link messages", th);
        } else if (i == 1) {
            Logs.debug("MessageBodyResolver", "Failed to resolve item references", th);
        } else if (i == 2) {
            Logs.debug("MessageBodyResolver", "Failed to resolve image references", th);
        } else if (i == 3) {
            Logs.debug("MessageBodyResolver", "Failed to resolve unknown types", th);
        } else {
            throw null;
        }
    }
}
