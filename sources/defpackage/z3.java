package defpackage;

import com.avito.android.util.Logs;
import io.reactivex.rxjava3.functions.Consumer;
/* compiled from: java-style lambda group */
/* renamed from: z3  reason: default package */
public final class z3<T> implements Consumer<Throwable> {
    public static final z3 b = new z3(0);
    public static final z3 c = new z3(1);
    public static final z3 d = new z3(2);
    public static final z3 e = new z3(3);
    public static final z3 f = new z3(4);
    public static final z3 g = new z3(5);
    public final /* synthetic */ int a;

    public z3(int i) {
        this.a = i;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public final void accept(Throwable th) {
        int i = this.a;
        if (i == 0) {
            Logs.error("HomePresenter", "Error allCategoriesClicks", th);
        } else if (i == 1) {
            Logs.error("HomePresenter", "Error snippetClickObservable", th);
        } else if (i == 2) {
            Logs.error("HomePresenter", "Error submitCallbacks", th);
        } else if (i == 3) {
            Logs.error("HomePresenter", "Error openCallbacks", th);
        } else if (i == 4) {
            Logs.error("HomePresenter", "Error searchSuggestsCallbacks", th);
        } else if (i == 5) {
            Logs.error("HomePresenter", "Error shortcutClicks", th);
        } else {
            throw null;
        }
    }
}
