package a2.d.a.d.b.v;

import com.bumptech.glide.util.Preconditions;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public final class a {
    public final Map<String, C0016a> a = new HashMap();
    public final b b = new b();

    /* renamed from: a2.d.a.d.b.v.a$a  reason: collision with other inner class name */
    public static class C0016a {
        public final Lock a = new ReentrantLock();
        public int b;
    }

    public static class b {
        public final Queue<C0016a> a = new ArrayDeque();
    }

    public void a(String str) {
        C0016a aVar;
        synchronized (this) {
            aVar = (C0016a) Preconditions.checkNotNull(this.a.get(str));
            int i = aVar.b;
            if (i >= 1) {
                int i2 = i - 1;
                aVar.b = i2;
                if (i2 == 0) {
                    C0016a remove = this.a.remove(str);
                    if (remove.equals(aVar)) {
                        b bVar = this.b;
                        synchronized (bVar.a) {
                            if (bVar.a.size() < 10) {
                                bVar.a.offer(remove);
                            }
                        }
                    } else {
                        throw new IllegalStateException("Removed the wrong lock, expected to remove: " + aVar + ", but actually removed: " + remove + ", safeKey: " + str);
                    }
                }
            } else {
                throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + aVar.b);
            }
        }
        aVar.a.unlock();
    }
}
