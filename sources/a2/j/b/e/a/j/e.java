package a2.j.b.e.a.j;

import com.google.android.play.core.tasks.OnSuccessListener;
import com.google.android.play.core.tasks.Task;
public final class e implements Runnable {
    public final /* synthetic */ Task a;
    public final /* synthetic */ f b;

    public e(f fVar, Task task) {
        this.b = fVar;
        this.a = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.b.b) {
            OnSuccessListener<? super ResultT> onSuccessListener = this.b.c;
            if (onSuccessListener != null) {
                onSuccessListener.onSuccess((Object) this.a.getResult());
            }
        }
    }
}
