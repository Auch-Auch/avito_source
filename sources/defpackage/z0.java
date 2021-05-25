package defpackage;

import com.avito.android.util.Logs;
import io.reactivex.functions.Consumer;
/* compiled from: java-style lambda group */
/* renamed from: z0  reason: default package */
public final class z0<T> implements Consumer<Throwable> {
    public static final z0 b = new z0(0);
    public static final z0 c = new z0(1);
    public static final z0 d = new z0(2);
    public final /* synthetic */ int a;

    public z0(int i) {
        this.a = i;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public final void accept(Throwable th) {
        int i = this.a;
        if (i == 0) {
            Logs.error("Failed to loadAutoParamsByVin", th);
        } else if (i == 1) {
            Logs.error("Failed to loadAutoParamsByVin", th);
        } else if (i == 2) {
            Logs.error("Failed to loadAutoParamsByVin", th);
        } else {
            throw null;
        }
    }
}
