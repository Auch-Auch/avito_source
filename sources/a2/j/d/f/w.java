package a2.j.d.f;

import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import com.google.common.graph.EndpointPair;
import java.util.Iterator;
import java.util.Set;
public abstract class w<N> extends AbstractIterator<EndpointPair<N>> {
    public final k<N> c;
    public final Iterator<N> d;
    public N e = null;
    public Iterator<N> f = ImmutableSet.of().mo99iterator();

    public static final class b<N> extends w<N> {
        public b(k kVar, a aVar) {
            super(kVar, null);
        }

        @Override // com.google.common.collect.AbstractIterator
        public Object computeNext() {
            while (!this.f.hasNext()) {
                if (!a()) {
                    return (EndpointPair) endOfData();
                }
            }
            return EndpointPair.ordered(this.e, this.f.next());
        }
    }

    public static final class c<N> extends w<N> {
        public Set<N> g;

        public c(k kVar, a aVar) {
            super(kVar, null);
            this.g = Sets.newHashSetWithExpectedSize(kVar.nodes().size());
        }

        @Override // com.google.common.collect.AbstractIterator
        public Object computeNext() {
            while (true) {
                if (this.f.hasNext()) {
                    N next = this.f.next();
                    if (!this.g.contains(next)) {
                        return EndpointPair.unordered(this.e, next);
                    }
                } else {
                    this.g.add(this.e);
                    if (!a()) {
                        this.g = null;
                        return (EndpointPair) endOfData();
                    }
                }
            }
        }
    }

    public w(k kVar, a aVar) {
        this.c = kVar;
        this.d = kVar.nodes().iterator();
    }

    public final boolean a() {
        Preconditions.checkState(!this.f.hasNext());
        if (!this.d.hasNext()) {
            return false;
        }
        N next = this.d.next();
        this.e = next;
        this.f = this.c.mo140successors((k<N>) next).iterator();
        return true;
    }
}
