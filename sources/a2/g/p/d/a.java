package a2.g.p.d;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.logging.FLog;
import java.util.LinkedList;
import java.util.Queue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
@VisibleForTesting
@NotThreadSafe
public class a<V> {
    public final int a;
    public final int b;
    public final Queue c;
    public final boolean d;
    public int e;

    public a(int i, int i2, int i3, boolean z) {
        boolean z2 = true;
        Preconditions.checkState(i > 0);
        Preconditions.checkState(i2 >= 0);
        Preconditions.checkState(i3 < 0 ? false : z2);
        this.a = i;
        this.b = i2;
        this.c = new LinkedList();
        this.e = i3;
        this.d = z;
    }

    public void a(V v) {
        this.c.add(v);
    }

    public void b() {
        Preconditions.checkState(this.e > 0);
        this.e--;
    }

    public int c() {
        return this.c.size();
    }

    @Nullable
    public V d() {
        return (V) this.c.poll();
    }

    public void e(V v) {
        Preconditions.checkNotNull(v);
        boolean z = false;
        if (this.d) {
            if (this.e > 0) {
                z = true;
            }
            Preconditions.checkState(z);
            this.e--;
            a(v);
            return;
        }
        int i = this.e;
        if (i > 0) {
            this.e = i - 1;
            a(v);
            return;
        }
        FLog.e("BUCKET", "Tried to release value %s from an empty bucket!", v);
    }
}
