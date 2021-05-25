package a2.j.b.e.a.d;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
public final class z extends WeakReference<Throwable> {
    public final int a;

    public z(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        this.a = System.identityHashCode(th);
    }

    @Override // java.lang.Object
    public final boolean equals(Object obj) {
        if (obj == null || obj.getClass() != z.class) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        z zVar = (z) obj;
        return this.a == zVar.a && get() == zVar.get();
    }

    @Override // java.lang.Object
    public final int hashCode() {
        return this.a;
    }
}
