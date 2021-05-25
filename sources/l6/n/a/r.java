package l6.n.a;

import java.util.ArrayList;
public final class r implements Runnable {
    public final /* synthetic */ ArrayList a;

    public r(ArrayList arrayList) {
        this.a = arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        w.p(this.a, 4);
    }
}
