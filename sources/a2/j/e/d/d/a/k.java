package a2.j.e.d.d.a;

import java.util.concurrent.Callable;
public class k implements Callable<Void> {
    public final /* synthetic */ long a;
    public final /* synthetic */ String b;
    public final /* synthetic */ u c;

    public k(u uVar, long j, String str) {
        this.c = uVar;
        this.a = j;
        this.b = str;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        if (this.c.n()) {
            return null;
        }
        this.c.m.writeToLog(this.a, this.b);
        return null;
    }
}
