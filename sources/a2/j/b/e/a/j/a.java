package a2.j.b.e.a.j;

import com.google.android.play.core.tasks.OnCompleteListener;
import com.google.android.play.core.tasks.Task;
public final class a implements Runnable {
    public final /* synthetic */ Task a;
    public final /* synthetic */ b b;

    public a(b bVar, Task task) {
        this.b = bVar;
        this.a = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.b.b) {
            OnCompleteListener<ResultT> onCompleteListener = this.b.c;
            if (onCompleteListener != null) {
                onCompleteListener.onComplete(this.a);
            }
        }
    }
}
