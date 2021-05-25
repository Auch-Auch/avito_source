package a2.j.b.e.a.j;

import com.google.android.play.core.tasks.OnSuccessListener;
import com.google.android.play.core.tasks.Task;
import java.util.concurrent.Executor;
public final class f<ResultT> implements g<ResultT> {
    public final Executor a;
    public final Object b = new Object();
    public final OnSuccessListener<? super ResultT> c;

    public f(Executor executor, OnSuccessListener<? super ResultT> onSuccessListener) {
        this.a = executor;
        this.c = onSuccessListener;
    }

    @Override // a2.j.b.e.a.j.g
    public final void a(Task<ResultT> task) {
        if (task.isSuccessful()) {
            synchronized (this.b) {
                if (this.c != null) {
                    this.a.execute(new e(this, task));
                }
            }
        }
    }
}
