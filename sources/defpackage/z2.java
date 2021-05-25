package defpackage;

import com.avito.android.util.Logs;
import io.reactivex.functions.Consumer;
/* compiled from: java-style lambda group */
/* renamed from: z2  reason: default package */
public final class z2<T> implements Consumer<Throwable> {
    public static final z2 b = new z2(0);
    public static final z2 c = new z2(1);
    public static final z2 d = new z2(2);
    public final /* synthetic */ int a;

    public z2(int i) {
        this.a = i;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public final void accept(Throwable th) {
        int i = this.a;
        if (i == 0) {
            Logs.error("Failed to date selection click observe", th);
        } else if (i == 1) {
            Logs.error("Failed to date selection click observe", th);
        } else if (i == 2) {
            Logs.error("Failed to date selection click observe", th);
        } else {
            throw null;
        }
    }
}
