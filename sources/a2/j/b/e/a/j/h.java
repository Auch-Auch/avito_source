package a2.j.b.e.a.j;

import com.google.android.play.core.tasks.Task;
import java.util.ArrayDeque;
import java.util.Queue;
public final class h<ResultT> {
    public final Object a = new Object();
    public Queue<g<ResultT>> b;
    public boolean c;

    public final void a(Task<ResultT> task) {
        g<ResultT> poll;
        synchronized (this.a) {
            if (this.b != null && !this.c) {
                this.c = true;
            } else {
                return;
            }
        }
        while (true) {
            synchronized (this.a) {
                poll = this.b.poll();
                if (poll == null) {
                    this.c = false;
                    return;
                }
            }
            poll.a(task);
        }
    }

    public final void b(g<ResultT> gVar) {
        synchronized (this.a) {
            if (this.b == null) {
                this.b = new ArrayDeque();
            }
            this.b.add(gVar);
        }
    }
}
