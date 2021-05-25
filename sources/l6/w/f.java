package l6.w;

import androidx.annotation.NonNull;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;
public class f implements Executor {
    public final Executor a;
    public final ArrayDeque<Runnable> b = new ArrayDeque<>();
    public Runnable c;

    public class a implements Runnable {
        public final /* synthetic */ Runnable a;

        public a(Runnable runnable) {
            this.a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.a.run();
            } finally {
                f.this.a();
            }
        }
    }

    public f(@NonNull Executor executor) {
        this.a = executor;
    }

    public synchronized void a() {
        Runnable poll = this.b.poll();
        this.c = poll;
        if (poll != null) {
            this.a.execute(poll);
        }
    }

    @Override // java.util.concurrent.Executor
    public synchronized void execute(Runnable runnable) {
        this.b.offer(new a(runnable));
        if (this.c == null) {
            a();
        }
    }
}
