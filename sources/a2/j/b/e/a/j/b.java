package a2.j.b.e.a.j;

import com.google.android.play.core.tasks.OnCompleteListener;
import com.google.android.play.core.tasks.Task;
import java.util.concurrent.Executor;
public final class b<ResultT> implements g<ResultT> {
    public final Executor a;
    public final Object b = new Object();
    public final OnCompleteListener<ResultT> c;

    public b(Executor executor, OnCompleteListener<ResultT> onCompleteListener) {
        this.a = executor;
        this.c = onCompleteListener;
    }

    @Override // a2.j.b.e.a.j.g
    public final void a(Task<ResultT> task) {
        synchronized (this.b) {
            if (this.c != null) {
                this.a.execute(new a(this, task));
            }
        }
    }
}
