package a2.g.p.d;

import com.facebook.common.references.OOMSoftReference;
import java.util.LinkedList;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
public class b<V> extends a<V> {
    public LinkedList<OOMSoftReference<V>> f = new LinkedList<>();

    public b(int i, int i2, int i3) {
        super(i, i2, i3, false);
    }

    @Override // a2.g.p.d.a
    public void a(V v) {
        OOMSoftReference<V> poll = this.f.poll();
        if (poll == null) {
            poll = new OOMSoftReference<>();
        }
        poll.set(v);
        this.c.add(poll);
    }

    @Override // a2.g.p.d.a
    public V d() {
        OOMSoftReference<V> oOMSoftReference = (OOMSoftReference) this.c.poll();
        V v = oOMSoftReference.get();
        oOMSoftReference.clear();
        this.f.add(oOMSoftReference);
        return v;
    }
}
