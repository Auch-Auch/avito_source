package defpackage;

import com.avito.android.util.Logs;
import io.reactivex.rxjava3.functions.Consumer;
/* compiled from: java-style lambda group */
/* renamed from: o1  reason: default package */
public final class o1<T> implements Consumer<Throwable> {
    public static final o1 b = new o1(0);
    public static final o1 c = new o1(1);
    public static final o1 d = new o1(2);
    public final /* synthetic */ int a;

    public o1(int i) {
        this.a = i;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public final void accept(Throwable th) {
        int i = this.a;
        if (i == 0) {
            Logs.wtf("BottomNavigation", "Error favorites badge", th);
        } else if (i == 1) {
            Logs.wtf("BottomNavigation", "Error message badge", th);
        } else if (i == 2) {
            Logs.wtf("BottomNavigation", "Error profile badge", th);
        } else {
            throw null;
        }
    }
}
