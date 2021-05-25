package com.google.common.util.concurrent;

import a2.j.d.l.a.w;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Monitor;
import com.google.common.util.concurrent.Service;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.ForOverride;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@Beta
@GwtIncompatible
public abstract class AbstractService implements Service {
    public static final w.a<Service.Listener> h = new a();
    public static final w.a<Service.Listener> i = new b();
    public static final w.a<Service.Listener> j;
    public static final w.a<Service.Listener> k;
    public static final w.a<Service.Listener> l = new a2.j.d.l.a.b(Service.State.NEW);
    public static final w.a<Service.Listener> m;
    public static final w.a<Service.Listener> n;
    public static final w.a<Service.Listener> o = new a2.j.d.l.a.b(Service.State.STOPPING);
    public final Monitor a = new Monitor();
    public final Monitor.Guard b = new d();
    public final Monitor.Guard c = new e();
    public final Monitor.Guard d = new c();
    public final Monitor.Guard e = new f();
    public final w<Service.Listener> f = new w<>();
    public volatile g g = new g(Service.State.NEW);

    public static class a implements w.a<Service.Listener> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // a2.j.d.l.a.w.a
        public void a(Service.Listener listener) {
            listener.starting();
        }

        public String toString() {
            return "starting()";
        }
    }

    public static class b implements w.a<Service.Listener> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // a2.j.d.l.a.w.a
        public void a(Service.Listener listener) {
            listener.running();
        }

        public String toString() {
            return "running()";
        }
    }

    public final class c extends Monitor.Guard {
        public c() {
            super(AbstractService.this.a);
        }

        @Override // com.google.common.util.concurrent.Monitor.Guard
        public boolean isSatisfied() {
            return AbstractService.this.state().compareTo(Service.State.RUNNING) >= 0;
        }
    }

    public final class d extends Monitor.Guard {
        public d() {
            super(AbstractService.this.a);
        }

        @Override // com.google.common.util.concurrent.Monitor.Guard
        public boolean isSatisfied() {
            return AbstractService.this.state() == Service.State.NEW;
        }
    }

    public final class e extends Monitor.Guard {
        public e() {
            super(AbstractService.this.a);
        }

        @Override // com.google.common.util.concurrent.Monitor.Guard
        public boolean isSatisfied() {
            return AbstractService.this.state().compareTo(Service.State.RUNNING) <= 0;
        }
    }

    public final class f extends Monitor.Guard {
        public f() {
            super(AbstractService.this.a);
        }

        @Override // com.google.common.util.concurrent.Monitor.Guard
        public boolean isSatisfied() {
            return AbstractService.this.state().a();
        }
    }

    public static final class g {
        public final Service.State a;
        public final boolean b;
        @NullableDecl
        public final Throwable c;

        public g(Service.State state) {
            this(state, false, null);
        }

        public g(Service.State state, boolean z, @NullableDecl Throwable th) {
            boolean z2 = false;
            Preconditions.checkArgument(!z || state == Service.State.STARTING, "shutdownWhenStartupFinishes can only be set if state is STARTING. Got %s instead.", state);
            Preconditions.checkArgument(!((state == Service.State.FAILED ? true : z2) ^ (th != null)), "A failure cause should be set if and only if the state is failed.  Got %s and %s instead.", state, th);
            this.a = state;
            this.b = z;
            this.c = th;
        }
    }

    static {
        Service.State state = Service.State.STARTING;
        j = new a2.j.d.l.a.c(state);
        Service.State state2 = Service.State.RUNNING;
        k = new a2.j.d.l.a.c(state2);
        m = new a2.j.d.l.a.b(state);
        n = new a2.j.d.l.a.b(state2);
    }

    @GuardedBy("monitor")
    public final void a(Service.State state) {
        Service.State state2 = state();
        if (state2 == state) {
            return;
        }
        if (state2 == Service.State.FAILED) {
            throw new IllegalStateException("Expected the service " + this + " to be " + state + ", but the service has FAILED", failureCause());
        }
        throw new IllegalStateException("Expected the service " + this + " to be " + state + ", but was " + state2);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void addListener(Service.Listener listener, Executor executor) {
        w<Service.Listener> wVar = this.f;
        Objects.requireNonNull(wVar);
        Preconditions.checkNotNull(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Preconditions.checkNotNull(executor, "executor");
        wVar.a.add(new w.b<>(listener, executor));
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning() {
        this.a.enterWhenUninterruptibly(this.d);
        try {
            a(Service.State.RUNNING);
        } finally {
            this.a.leave();
        }
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated() {
        this.a.enterWhenUninterruptibly(this.e);
        try {
            a(Service.State.TERMINATED);
        } finally {
            this.a.leave();
        }
    }

    public final void b() {
        if (!this.a.isOccupiedByCurrentThread()) {
            this.f.a();
        }
    }

    public final void c(Service.State state) {
        if (state == Service.State.STARTING) {
            this.f.b(j);
        } else if (state == Service.State.RUNNING) {
            this.f.b(k);
        } else {
            throw new AssertionError();
        }
    }

    public final void d(Service.State state) {
        int ordinal = state.ordinal();
        if (ordinal == 0) {
            this.f.b(l);
        } else if (ordinal == 1) {
            this.f.b(m);
        } else if (ordinal == 2) {
            this.f.b(n);
        } else if (ordinal == 3) {
            this.f.b(o);
        } else if (ordinal == 4 || ordinal == 5) {
            throw new AssertionError();
        }
    }

    @ForOverride
    public void doCancelStart() {
    }

    @ForOverride
    public abstract void doStart();

    @ForOverride
    public abstract void doStop();

    @Override // com.google.common.util.concurrent.Service
    public final Throwable failureCause() {
        g gVar = this.g;
        Service.State state = gVar.a;
        Preconditions.checkState(state == Service.State.FAILED, "failureCause() is only valid if the service has failed, service is %s", state);
        return gVar.c;
    }

    @Override // com.google.common.util.concurrent.Service
    public final boolean isRunning() {
        return state() == Service.State.RUNNING;
    }

    public final void notifyFailed(Throwable th) {
        Preconditions.checkNotNull(th);
        this.a.enter();
        try {
            Service.State state = state();
            int ordinal = state.ordinal();
            if (ordinal != 0) {
                if (ordinal == 1 || ordinal == 2 || ordinal == 3) {
                    this.g = new g(Service.State.FAILED, false, th);
                    this.f.b(new a2.j.d.l.a.d(this, state, th));
                } else if (ordinal != 4) {
                }
                return;
            }
            throw new IllegalStateException("Failed while in state:" + state, th);
        } finally {
            this.a.leave();
            b();
        }
    }

    public final void notifyStarted() {
        this.a.enter();
        try {
            if (this.g.a == Service.State.STARTING) {
                if (this.g.b) {
                    this.g = new g(Service.State.STOPPING);
                    doStop();
                } else {
                    this.g = new g(Service.State.RUNNING);
                    this.f.b(i);
                }
                return;
            }
            IllegalStateException illegalStateException = new IllegalStateException("Cannot notifyStarted() when the service is " + this.g.a);
            notifyFailed(illegalStateException);
            throw illegalStateException;
        } finally {
            this.a.leave();
            b();
        }
    }

    public final void notifyStopped() {
        this.a.enter();
        try {
            Service.State state = state();
            int ordinal = state.ordinal();
            if (ordinal != 0) {
                if (ordinal == 1 || ordinal == 2 || ordinal == 3) {
                    this.g = new g(Service.State.TERMINATED);
                    d(state);
                } else if (!(ordinal == 4 || ordinal == 5)) {
                }
                return;
            }
            throw new IllegalStateException("Cannot notifyStopped() when the service is " + state);
        } finally {
            this.a.leave();
            b();
        }
    }

    @Override // com.google.common.util.concurrent.Service
    @CanIgnoreReturnValue
    public final Service startAsync() {
        if (this.a.enterIf(this.b)) {
            try {
                this.g = new g(Service.State.STARTING);
                this.f.b(h);
                doStart();
            } catch (Throwable th) {
                this.a.leave();
                b();
                throw th;
            }
            this.a.leave();
            b();
            return this;
        }
        throw new IllegalStateException("Service " + this + " has already been started");
    }

    @Override // com.google.common.util.concurrent.Service
    public final Service.State state() {
        g gVar = this.g;
        if (!gVar.b || gVar.a != Service.State.STARTING) {
            return gVar.a;
        }
        return Service.State.STOPPING;
    }

    @Override // com.google.common.util.concurrent.Service
    @CanIgnoreReturnValue
    public final Service stopAsync() {
        if (this.a.enterIf(this.c)) {
            try {
                Service.State state = state();
                int ordinal = state.ordinal();
                if (ordinal == 0) {
                    this.g = new g(Service.State.TERMINATED);
                    d(Service.State.NEW);
                } else if (ordinal == 1) {
                    Service.State state2 = Service.State.STARTING;
                    this.g = new g(state2, true, null);
                    c(state2);
                    doCancelStart();
                } else if (ordinal == 2) {
                    this.g = new g(Service.State.STOPPING);
                    c(Service.State.RUNNING);
                    doStop();
                } else if (ordinal == 3 || ordinal == 4 || ordinal == 5) {
                    throw new AssertionError("isStoppable is incorrectly implemented, saw: " + state);
                }
            } catch (Throwable th) {
                this.a.leave();
                b();
                throw th;
            }
            this.a.leave();
            b();
        }
        return this;
    }

    public String toString() {
        return getClass().getSimpleName() + " [" + state() + "]";
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning(long j2, TimeUnit timeUnit) throws TimeoutException {
        if (this.a.enterWhenUninterruptibly(this.d, j2, timeUnit)) {
            try {
                a(Service.State.RUNNING);
            } finally {
                this.a.leave();
            }
        } else {
            throw new TimeoutException("Timed out waiting for " + this + " to reach the RUNNING state.");
        }
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated(long j2, TimeUnit timeUnit) throws TimeoutException {
        if (this.a.enterWhenUninterruptibly(this.e, j2, timeUnit)) {
            try {
                a(Service.State.TERMINATED);
            } finally {
                this.a.leave();
            }
        } else {
            throw new TimeoutException("Timed out waiting for " + this + " to reach a terminal state. Current state: " + state());
        }
    }
}
