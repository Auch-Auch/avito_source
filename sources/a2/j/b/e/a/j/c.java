package a2.j.b.e.a.j;

import com.google.android.play.core.tasks.OnFailureListener;
import com.google.android.play.core.tasks.Task;
public final class c implements Runnable {
    public final /* synthetic */ Task a;
    public final /* synthetic */ d b;

    public c(d dVar, Task task) {
        this.b = dVar;
        this.a = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.b.b) {
            OnFailureListener onFailureListener = this.b.c;
            if (onFailureListener != null) {
                onFailureListener.onFailure(this.a.getException());
            }
        }
    }
}
