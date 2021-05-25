package a2.j.d.l.a;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.errorprone.annotations.ForOverride;
import com.google.errorprone.annotations.OverridingMethodsMustInvokeSuper;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible
public abstract class g<InputT, OutputT> extends AbstractFuture.j<OutputT> {
    public static final Logger i = Logger.getLogger(g.class.getName());
    @NullableDecl
    public g<InputT, OutputT>.a h;

    public abstract class a extends h implements Runnable {
        public ImmutableCollection<? extends ListenableFuture<? extends InputT>> e;
        public final boolean f;
        public final boolean g;

        public a(ImmutableCollection<? extends ListenableFuture<? extends InputT>> immutableCollection, boolean z, boolean z2) {
            super(immutableCollection.size());
            this.e = (ImmutableCollection) Preconditions.checkNotNull(immutableCollection);
            this.f = z;
            this.g = z2;
        }

        @Override // a2.j.d.l.a.h
        public final void e(Set<Throwable> set) {
            if (!g.this.isCancelled()) {
                g.o(set, g.this.tryInternalFastPathGetFailure());
            }
        }

        public abstract void g(boolean z, int i, @NullableDecl InputT inputt);

        public final void h() {
            int b = h.c.b(this);
            int i = 0;
            Preconditions.checkState(b >= 0, "Less than 0 remaining futures");
            if (b == 0) {
                if (this.g && (true ^ this.f)) {
                    UnmodifiableIterator<? extends ListenableFuture<? extends InputT>> it = this.e.iterator();
                    while (it.hasNext()) {
                        k(i, (ListenableFuture) it.next());
                        i++;
                    }
                }
                i();
            }
        }

        public abstract void i();

        /* JADX WARNING: Removed duplicated region for block: B:10:0x0029  */
        /* JADX WARNING: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void j(java.lang.Throwable r6) {
            /*
                r5 = this;
                com.google.common.base.Preconditions.checkNotNull(r6)
                boolean r0 = r5.f
                r1 = 1
                if (r0 == 0) goto L_0x001d
                a2.j.d.l.a.g r0 = a2.j.d.l.a.g.this
                boolean r0 = r0.setException(r6)
                if (r0 == 0) goto L_0x0014
                r5.m()
                goto L_0x001e
            L_0x0014:
                java.util.Set r2 = r5.f()
                boolean r2 = a2.j.d.l.a.g.o(r2, r6)
                goto L_0x001f
            L_0x001d:
                r0 = 0
            L_0x001e:
                r2 = 1
            L_0x001f:
                boolean r3 = r6 instanceof java.lang.Error
                boolean r4 = r5.f
                r0 = r0 ^ r1
                r0 = r0 & r4
                r0 = r0 & r2
                r0 = r0 | r3
                if (r0 == 0) goto L_0x0037
                if (r3 == 0) goto L_0x002e
                java.lang.String r0 = "Input Future failed with Error"
                goto L_0x0030
            L_0x002e:
                java.lang.String r0 = "Got more than one input Future failure. Logging failures after the first"
            L_0x0030:
                java.util.logging.Logger r1 = a2.j.d.l.a.g.i
                java.util.logging.Level r2 = java.util.logging.Level.SEVERE
                r1.log(r2, r0, r6)
            L_0x0037:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: a2.j.d.l.a.g.a.j(java.lang.Throwable):void");
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: a2.j.d.l.a.g$a */
        /* JADX WARN: Multi-variable type inference failed */
        public final void k(int i, Future<? extends InputT> future) {
            Preconditions.checkState(this.f || !g.this.isDone() || g.this.isCancelled(), "Future was done before all dependencies completed");
            try {
                Preconditions.checkState(future.isDone(), "Tried to set value from future which is not done");
                if (this.f) {
                    if (future.isCancelled()) {
                        g gVar = g.this;
                        gVar.h = null;
                        gVar.cancel(false);
                        return;
                    }
                    Object done = Futures.getDone(future);
                    if (this.g) {
                        g(this.f, i, done);
                    }
                } else if (this.g && !future.isCancelled()) {
                    g(this.f, i, Futures.getDone(future));
                }
            } catch (ExecutionException e2) {
                j(e2.getCause());
            } catch (Throwable th) {
                j(th);
            }
        }

        public void l() {
        }

        @ForOverride
        @OverridingMethodsMustInvokeSuper
        public abstract void m();

        @Override // java.lang.Runnable
        public final void run() {
            h();
        }
    }

    public static boolean o(Set set, Throwable th) {
        while (th != null) {
            if (!set.add(th)) {
                return false;
            }
            th = th.getCause();
        }
        return true;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public final void afterDone() {
        super.afterDone();
        q();
    }

    public final void p(g<InputT, OutputT>.a aVar) {
        this.h = aVar;
        if (aVar.e.isEmpty()) {
            aVar.i();
        } else if (aVar.f) {
            int i2 = 0;
            UnmodifiableIterator<? extends ListenableFuture<? extends InputT>> it = aVar.e.iterator();
            while (it.hasNext()) {
                ListenableFuture listenableFuture = (ListenableFuture) it.next();
                listenableFuture.addListener(new f(aVar, i2, listenableFuture), MoreExecutors.directExecutor());
                i2++;
            }
        } else {
            UnmodifiableIterator<? extends ListenableFuture<? extends InputT>> it2 = aVar.e.iterator();
            while (it2.hasNext()) {
                ((ListenableFuture) it2.next()).addListener(aVar, MoreExecutors.directExecutor());
            }
        }
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public String pendingToString() {
        ImmutableCollection<? extends ListenableFuture<? extends InputT>> immutableCollection;
        g<InputT, OutputT>.a aVar = this.h;
        if (aVar == null || (immutableCollection = aVar.e) == null) {
            return null;
        }
        return "futures=[" + immutableCollection + "]";
    }

    public final void q() {
        g<InputT, OutputT>.a aVar = this.h;
        if (aVar != null) {
            this.h = null;
            ImmutableCollection<? extends ListenableFuture<? extends InputT>> immutableCollection = aVar.e;
            boolean wasInterrupted = wasInterrupted();
            if (wasInterrupted) {
                aVar.l();
            }
            if (isCancelled() && (immutableCollection != null)) {
                UnmodifiableIterator<? extends ListenableFuture<? extends InputT>> it = immutableCollection.iterator();
                while (it.hasNext()) {
                    ((ListenableFuture) it.next()).cancel(wasInterrupted);
                }
            }
        }
    }
}
