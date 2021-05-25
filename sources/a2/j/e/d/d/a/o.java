package a2.j.e.d.d.a;

import java.util.concurrent.Callable;
public class o implements Callable<Void> {
    public final /* synthetic */ u a;

    public o(u uVar) {
        this.a = uVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        u.b(this.a);
        return null;
    }
}
