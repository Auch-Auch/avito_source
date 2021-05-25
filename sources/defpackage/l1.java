package defpackage;

import io.reactivex.rxjava3.functions.Consumer;
/* compiled from: java-style lambda group */
/* renamed from: l1  reason: default package */
public final class l1<T> implements Consumer<Throwable> {
    public static final l1 b = new l1(0);
    public static final l1 c = new l1(1);
    public static final l1 d = new l1(2);
    public final /* synthetic */ int a;

    public l1(int i) {
        this.a = i;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public final void accept(Throwable th) {
        int i = this.a;
        if (i == 0) {
            return;
        }
        if (i == 1) {
            return;
        }
        if (i != 2) {
            throw null;
        }
    }
}
