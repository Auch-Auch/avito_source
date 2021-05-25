package a2.d.a.d.b.u;

import a2.d.a.d.b.u.e;
import com.bumptech.glide.util.Util;
import java.util.Queue;
public abstract class b<T extends e> {
    public final Queue<T> a = Util.createQueue(20);

    public abstract T a();

    public T b() {
        T poll = this.a.poll();
        return poll == null ? a() : poll;
    }

    public void c(T t) {
        if (this.a.size() < 20) {
            this.a.offer(t);
        }
    }
}
