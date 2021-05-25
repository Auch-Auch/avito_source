package com.google.common.util.concurrent;

import a2.j.d.l.a.b0;
import a2.j.d.l.a.c0;
import a2.j.d.l.a.w;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicates;
import com.google.common.base.Stopwatch;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSetMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.MultimapBuilder;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Multiset;
import com.google.common.collect.Ordering;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.util.concurrent.Monitor;
import com.google.common.util.concurrent.Service;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import com.vk.sdk.api.VKApiConst;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
@Beta
@GwtIncompatible
public final class ServiceManager {
    public static final Logger c = Logger.getLogger(ServiceManager.class.getName());
    public static final w.a<Listener> d = new a();
    public static final w.a<Listener> e = new b();
    public final f a;
    public final ImmutableList<Service> b;

    @Beta
    public static abstract class Listener {
        public void failure(Service service) {
        }

        public void healthy() {
        }

        public void stopped() {
        }
    }

    public static class a implements w.a<Listener> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // a2.j.d.l.a.w.a
        public void a(Listener listener) {
            listener.healthy();
        }

        public String toString() {
            return "healthy()";
        }
    }

    public static class b implements w.a<Listener> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // a2.j.d.l.a.w.a
        public void a(Listener listener) {
            listener.stopped();
        }

        public String toString() {
            return "stopped()";
        }
    }

    public static final class c extends Throwable {
        public c(a aVar) {
        }
    }

    public static final class d extends AbstractService {
        public d() {
        }

        @Override // com.google.common.util.concurrent.AbstractService
        public void doStart() {
            notifyStarted();
        }

        @Override // com.google.common.util.concurrent.AbstractService
        public void doStop() {
            notifyStopped();
        }

        public d(a aVar) {
        }
    }

    public static final class e extends Service.Listener {
        public final Service a;
        public final WeakReference<f> b;

        public e(Service service, WeakReference<f> weakReference) {
            this.a = service;
            this.b = weakReference;
        }

        @Override // com.google.common.util.concurrent.Service.Listener
        public void failed(Service.State state, Throwable th) {
            f fVar = this.b.get();
            if (fVar != null) {
                if (!(this.a instanceof d)) {
                    Logger logger = ServiceManager.c;
                    Level level = Level.SEVERE;
                    StringBuilder L = a2.b.a.a.a.L("Service ");
                    L.append(this.a);
                    L.append(" has failed in the ");
                    L.append(state);
                    L.append(" state.");
                    logger.log(level, L.toString(), th);
                }
                fVar.e(this.a, state, Service.State.FAILED);
            }
        }

        @Override // com.google.common.util.concurrent.Service.Listener
        public void running() {
            f fVar = this.b.get();
            if (fVar != null) {
                fVar.e(this.a, Service.State.STARTING, Service.State.RUNNING);
            }
        }

        @Override // com.google.common.util.concurrent.Service.Listener
        public void starting() {
            f fVar = this.b.get();
            if (fVar != null) {
                fVar.e(this.a, Service.State.NEW, Service.State.STARTING);
                Service service = this.a;
                if (!(service instanceof d)) {
                    ServiceManager.c.log(Level.FINE, "Starting {0}.", service);
                }
            }
        }

        @Override // com.google.common.util.concurrent.Service.Listener
        public void stopping(Service.State state) {
            f fVar = this.b.get();
            if (fVar != null) {
                fVar.e(this.a, state, Service.State.STOPPING);
            }
        }

        @Override // com.google.common.util.concurrent.Service.Listener
        public void terminated(Service.State state) {
            f fVar = this.b.get();
            if (fVar != null) {
                Service service = this.a;
                if (!(service instanceof d)) {
                    ServiceManager.c.log(Level.FINE, "Service {0} has terminated. Previous state was: {1}", new Object[]{service, state});
                }
                fVar.e(this.a, state, Service.State.TERMINATED);
            }
        }
    }

    public static final class f {
        public final Monitor a = new Monitor();
        @GuardedBy("monitor")
        public final SetMultimap<Service.State, Service> b;
        @GuardedBy("monitor")
        public final Multiset<Service.State> c;
        @GuardedBy("monitor")
        public final Map<Service, Stopwatch> d;
        @GuardedBy("monitor")
        public boolean e;
        @GuardedBy("monitor")
        public boolean f;
        public final int g;
        public final Monitor.Guard h;
        public final Monitor.Guard i;
        public final w<Listener> j;

        public final class a extends Monitor.Guard {
            public a() {
                super(f.this.a);
            }

            @Override // com.google.common.util.concurrent.Monitor.Guard
            @GuardedBy("ServiceManagerState.this.monitor")
            public boolean isSatisfied() {
                int count = f.this.c.count(Service.State.RUNNING);
                f fVar = f.this;
                return count == fVar.g || fVar.c.contains(Service.State.STOPPING) || f.this.c.contains(Service.State.TERMINATED) || f.this.c.contains(Service.State.FAILED);
            }
        }

        public final class b extends Monitor.Guard {
            public b() {
                super(f.this.a);
            }

            @Override // com.google.common.util.concurrent.Monitor.Guard
            @GuardedBy("ServiceManagerState.this.monitor")
            public boolean isSatisfied() {
                return f.this.c.count(Service.State.FAILED) + f.this.c.count(Service.State.TERMINATED) == f.this.g;
            }
        }

        public f(ImmutableCollection<Service> immutableCollection) {
            SetMultimap<Service.State, Service> build = MultimapBuilder.enumKeys(Service.State.class).linkedHashSetValues().mo108build();
            this.b = build;
            this.c = build.keys();
            this.d = Maps.newIdentityHashMap();
            this.h = new a();
            this.i = new b();
            this.j = new w<>();
            this.g = immutableCollection.size();
            build.putAll(Service.State.NEW, immutableCollection);
        }

        public void a(Listener listener, Executor executor) {
            w<Listener> wVar = this.j;
            Objects.requireNonNull(wVar);
            Preconditions.checkNotNull(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            Preconditions.checkNotNull(executor, "executor");
            wVar.a.add(new w.b<>(listener, executor));
        }

        @GuardedBy("monitor")
        public void b() {
            Multiset<Service.State> multiset = this.c;
            Service.State state = Service.State.RUNNING;
            if (multiset.count(state) != this.g) {
                StringBuilder L = a2.b.a.a.a.L("Expected to be healthy after starting. The following services are not running: ");
                L.append(Multimaps.filterKeys((SetMultimap) this.b, Predicates.not(Predicates.equalTo(state))));
                throw new IllegalStateException(L.toString());
            }
        }

        public void c() {
            Preconditions.checkState(!this.a.isOccupiedByCurrentThread(), "It is incorrect to execute listeners with the monitor held.");
            this.j.a();
        }

        /* JADX INFO: finally extract failed */
        public ImmutableMultimap<Service.State, Service> d() {
            ImmutableSetMultimap.Builder builder = ImmutableSetMultimap.builder();
            this.a.enter();
            try {
                for (Map.Entry<Service.State, Service> entry : this.b.entries()) {
                    if (!(entry.getValue() instanceof d)) {
                        builder.put((Map.Entry) entry);
                    }
                }
                this.a.leave();
                return builder.build();
            } catch (Throwable th) {
                this.a.leave();
                throw th;
            }
        }

        public void e(Service service, Service.State state, Service.State state2) {
            Preconditions.checkNotNull(service);
            Preconditions.checkArgument(state != state2);
            this.a.enter();
            try {
                this.f = true;
                if (this.e) {
                    Preconditions.checkState(this.b.remove(state, service), "Service %s not at the expected location in the state map %s", service, state);
                    Preconditions.checkState(this.b.put(state2, service), "Service %s in the state map unexpectedly at %s", service, state2);
                    Stopwatch stopwatch = this.d.get(service);
                    if (stopwatch == null) {
                        stopwatch = Stopwatch.createStarted();
                        this.d.put(service, stopwatch);
                    }
                    Service.State state3 = Service.State.RUNNING;
                    if (state2.compareTo(state3) >= 0 && stopwatch.isRunning()) {
                        stopwatch.stop();
                        if (!(service instanceof d)) {
                            ServiceManager.c.log(Level.FINE, "Started {0} in {1}.", new Object[]{service, stopwatch});
                        }
                    }
                    Service.State state4 = Service.State.FAILED;
                    if (state2 == state4) {
                        this.j.b(new c0(this, service));
                    }
                    if (this.c.count(state3) == this.g) {
                        this.j.b(ServiceManager.d);
                    } else if (this.c.count(Service.State.TERMINATED) + this.c.count(state4) == this.g) {
                        this.j.b(ServiceManager.e);
                    }
                    this.a.leave();
                    c();
                }
            } finally {
                this.a.leave();
                c();
            }
        }
    }

    public ServiceManager(Iterable<? extends Service> iterable) {
        ImmutableList<Service> copyOf = ImmutableList.copyOf(iterable);
        if (copyOf.isEmpty()) {
            c.log(Level.WARNING, "ServiceManager configured with no services.  Is your application configured properly?", (Throwable) new c(null));
            copyOf = ImmutableList.of(new d(null));
        }
        f fVar = new f(copyOf);
        this.a = fVar;
        this.b = copyOf;
        WeakReference weakReference = new WeakReference(fVar);
        UnmodifiableIterator<Service> it = copyOf.mo99iterator();
        while (true) {
            boolean z = true;
            if (!it.hasNext()) {
                break;
            }
            Service next = it.next();
            next.addListener(new e(next, weakReference), MoreExecutors.directExecutor());
            if (next.state() != Service.State.NEW) {
                z = false;
            }
            Preconditions.checkArgument(z, "Can only manage NEW services, %s", next);
        }
        f fVar2 = this.a;
        fVar2.a.enter();
        try {
            if (!fVar2.f) {
                fVar2.e = true;
                return;
            }
            ArrayList newArrayList = Lists.newArrayList();
            UnmodifiableIterator<Service> it2 = fVar2.d().values().iterator();
            while (it2.hasNext()) {
                Service next2 = it2.next();
                if (next2.state() != Service.State.NEW) {
                    newArrayList.add(next2);
                }
            }
            throw new IllegalArgumentException("Services started transitioning asynchronously before the ServiceManager was constructed: " + newArrayList);
        } finally {
            fVar2.a.leave();
        }
    }

    public void addListener(Listener listener, Executor executor) {
        this.a.a(listener, executor);
    }

    public void awaitHealthy() {
        f fVar = this.a;
        fVar.a.enterWhenUninterruptibly(fVar.h);
        try {
            fVar.b();
        } finally {
            fVar.a.leave();
        }
    }

    public void awaitStopped() {
        f fVar = this.a;
        fVar.a.enterWhenUninterruptibly(fVar.i);
        fVar.a.leave();
    }

    public boolean isHealthy() {
        UnmodifiableIterator<Service> it = this.b.mo99iterator();
        while (it.hasNext()) {
            if (!it.next().isRunning()) {
                return false;
            }
        }
        return true;
    }

    public ImmutableMultimap<Service.State, Service> servicesByState() {
        return this.a.d();
    }

    /* JADX INFO: finally extract failed */
    @CanIgnoreReturnValue
    public ServiceManager startAsync() {
        UnmodifiableIterator<Service> it = this.b.mo99iterator();
        while (it.hasNext()) {
            Service next = it.next();
            Service.State state = next.state();
            Preconditions.checkState(state == Service.State.NEW, "Service %s is %s, cannot start it.", next, state);
        }
        UnmodifiableIterator<Service> it2 = this.b.mo99iterator();
        while (it2.hasNext()) {
            Service next2 = it2.next();
            try {
                f fVar = this.a;
                fVar.a.enter();
                try {
                    if (fVar.d.get(next2) == null) {
                        fVar.d.put(next2, Stopwatch.createStarted());
                    }
                    fVar.a.leave();
                    next2.startAsync();
                } catch (Throwable th) {
                    fVar.a.leave();
                    throw th;
                }
            } catch (IllegalStateException e2) {
                Logger logger = c;
                Level level = Level.WARNING;
                logger.log(level, "Unable to start Service " + next2, (Throwable) e2);
            }
        }
        return this;
    }

    /* JADX INFO: finally extract failed */
    public ImmutableMap<Service, Long> startupTimes() {
        f fVar = this.a;
        fVar.a.enter();
        try {
            ArrayList newArrayListWithCapacity = Lists.newArrayListWithCapacity(fVar.d.size());
            for (Map.Entry<Service, Stopwatch> entry : fVar.d.entrySet()) {
                Service key = entry.getKey();
                Stopwatch value = entry.getValue();
                if (!value.isRunning() && !(key instanceof d)) {
                    newArrayListWithCapacity.add(Maps.immutableEntry(key, Long.valueOf(value.elapsed(TimeUnit.MILLISECONDS))));
                }
            }
            fVar.a.leave();
            Collections.sort(newArrayListWithCapacity, Ordering.natural().onResultOf(new b0(fVar)));
            return ImmutableMap.copyOf(newArrayListWithCapacity);
        } catch (Throwable th) {
            fVar.a.leave();
            throw th;
        }
    }

    @CanIgnoreReturnValue
    public ServiceManager stopAsync() {
        UnmodifiableIterator<Service> it = this.b.mo99iterator();
        while (it.hasNext()) {
            it.next().stopAsync();
        }
        return this;
    }

    public String toString() {
        return MoreObjects.toStringHelper((Class<?>) ServiceManager.class).add(VKApiConst.SERVICES, Collections2.filter(this.b, Predicates.not(Predicates.instanceOf(d.class)))).toString();
    }

    public void addListener(Listener listener) {
        this.a.a(listener, MoreExecutors.directExecutor());
    }

    public void awaitStopped(long j, TimeUnit timeUnit) throws TimeoutException {
        f fVar = this.a;
        fVar.a.enter();
        try {
            if (!fVar.a.waitForUninterruptibly(fVar.i, j, timeUnit)) {
                throw new TimeoutException("Timeout waiting for the services to stop. The following services have not stopped: " + Multimaps.filterKeys((SetMultimap) fVar.b, Predicates.not(Predicates.in(EnumSet.of(Service.State.TERMINATED, Service.State.FAILED)))));
            }
        } finally {
            fVar.a.leave();
        }
    }

    public void awaitHealthy(long j, TimeUnit timeUnit) throws TimeoutException {
        f fVar = this.a;
        fVar.a.enter();
        try {
            if (fVar.a.waitForUninterruptibly(fVar.h, j, timeUnit)) {
                fVar.b();
                return;
            }
            throw new TimeoutException("Timeout waiting for the services to become healthy. The following services have not started: " + Multimaps.filterKeys((SetMultimap) fVar.b, Predicates.in(ImmutableSet.of(Service.State.NEW, Service.State.STARTING))));
        } finally {
            fVar.a.leave();
        }
    }
}
