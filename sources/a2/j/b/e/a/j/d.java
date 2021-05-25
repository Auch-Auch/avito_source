package a2.j.b.e.a.j;

import com.google.android.play.core.tasks.OnFailureListener;
import com.google.android.play.core.tasks.Task;
import java.util.concurrent.Executor;
public final class d<ResultT> implements g<ResultT> {
    public final Executor a;
    public final Object b = new Object();
    public final OnFailureListener c;

    public d(Executor executor, OnFailureListener onFailureListener) {
        this.a = executor;
        this.c = onFailureListener;
    }

    @Override // a2.j.b.e.a.j.g
    public final void a(Task<ResultT> task) {
        if (!task.isSuccessful()) {
            synchronized (this.b) {
                if (this.c != null) {
                    this.a.execute(new c(this, task));
                }
            }
        }
    }
}
