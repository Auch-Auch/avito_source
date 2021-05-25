package x6.c.b.d;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.junit.runner.Request;
import org.junit.runner.Runner;
public abstract class a extends Request {
    public final Lock a = new ReentrantLock();
    public volatile Runner b;

    public abstract Runner createRunner();

    @Override // org.junit.runner.Request
    public final Runner getRunner() {
        if (this.b == null) {
            this.a.lock();
            try {
                if (this.b == null) {
                    this.b = createRunner();
                }
            } finally {
                this.a.unlock();
            }
        }
        return this.b;
    }
}
