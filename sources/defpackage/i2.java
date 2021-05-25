package defpackage;

import com.avito.android.util.Logs;
import io.reactivex.functions.Consumer;
/* compiled from: java-style lambda group */
/* renamed from: i2  reason: default package */
public final class i2<T> implements Consumer<Throwable> {
    public static final i2 b = new i2(0);
    public static final i2 c = new i2(1);
    public final /* synthetic */ int a;

    public i2(int i) {
        this.a = i;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public final void accept(Throwable th) {
        int i = this.a;
        if (i == 0) {
            Logs.error("Failed on observe soa animation collapse", th);
        } else if (i == 1) {
            Logs.error("Failed on observe header click", th);
        } else {
            throw null;
        }
    }
}
