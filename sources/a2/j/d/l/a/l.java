package a2.j.d.l.a;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible(emulated = true)
public abstract class l<V, C> extends g<V, C> {

    public abstract class a extends g<V, C>.a {
        public List<Optional<V>> i;

        public a(ImmutableCollection<? extends ListenableFuture<? extends V>> immutableCollection, boolean z) {
            super(immutableCollection, z, true);
            List<Optional<V>> list;
            if (immutableCollection.isEmpty()) {
                list = ImmutableList.of();
            } else {
                list = Lists.newArrayListWithCapacity(immutableCollection.size());
            }
            this.i = list;
            for (int i2 = 0; i2 < immutableCollection.size(); i2++) {
                this.i.add(null);
            }
        }

        @Override // a2.j.d.l.a.g.a
        public final void g(boolean z, int i2, @NullableDecl V v) {
            List<Optional<V>> list = this.i;
            if (list != null) {
                list.set(i2, Optional.fromNullable(v));
            } else {
                Preconditions.checkState(z || l.this.isCancelled(), "Future was done before all dependencies completed");
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: a2.j.d.l.a.l */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // a2.j.d.l.a.g.a
        public final void i() {
            List<Optional<V>> list = this.i;
            if (list != null) {
                l lVar = l.this;
                ArrayList newArrayListWithCapacity = Lists.newArrayListWithCapacity(list.size());
                Iterator<Optional<V>> it = list.iterator();
                while (it.hasNext()) {
                    Optional<V> next = it.next();
                    newArrayListWithCapacity.add(next != null ? next.orNull() : null);
                }
                lVar.set(Collections.unmodifiableList(newArrayListWithCapacity));
                return;
            }
            Preconditions.checkState(l.this.isDone());
        }

        @Override // a2.j.d.l.a.g.a
        public void m() {
            this.e = null;
            this.i = null;
        }
    }

    public static final class b<V> extends l<V, List<V>> {

        public final class a extends l<V, List<V>>.a {
            public a(b bVar, ImmutableCollection<? extends ListenableFuture<? extends V>> immutableCollection, boolean z) {
                super(immutableCollection, z);
            }
        }

        public b(ImmutableCollection<? extends ListenableFuture<? extends V>> immutableCollection, boolean z) {
            p(new a(this, immutableCollection, z));
        }
    }
}
