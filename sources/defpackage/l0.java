package defpackage;

import a2.a.a.b3.c.b.o;
import com.avito.android.util.Views;
/* compiled from: java-style lambda group */
/* renamed from: l0  reason: default package */
public final class l0 implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public l0(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.a;
        if (i == 0) {
            Views.hide(((o) this.b).a.c);
        } else if (i == 1) {
            Views.show(((o) this.b).a.c);
        } else {
            throw null;
        }
    }
}
