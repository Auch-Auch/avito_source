package a2.m.a.b.k;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
public final class c implements Runnable {
    public final /* synthetic */ OnCompleteListener a;
    public final /* synthetic */ Task b;

    public c(OnCompleteListener onCompleteListener, Task task) {
        this.a = onCompleteListener;
        this.b = task;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.onComplete(this.b);
    }
}
