package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.MapMaker;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.j2objc.annotations.Weak;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@Beta
@GwtIncompatible
@CanIgnoreReturnValue
public class CycleDetectingLockFactory {
    public static final ConcurrentMap<Class<? extends Enum>, Map<? extends Enum, h>> b = new MapMaker().weakKeys().makeMap();
    public static final Logger c = Logger.getLogger(CycleDetectingLockFactory.class.getName());
    public static final ThreadLocal<ArrayList<h>> d = new a();
    public final Policy a;

    @Beta
    public enum Policies implements Policy {
        THROW {
            @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.Policy
            public void handlePotentialDeadlock(PotentialDeadlockException potentialDeadlockException) {
                throw potentialDeadlockException;
            }
        },
        WARN {
            @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.Policy
            public void handlePotentialDeadlock(PotentialDeadlockException potentialDeadlockException) {
                CycleDetectingLockFactory.c.log(Level.SEVERE, "Detected potential deadlock", (Throwable) potentialDeadlockException);
            }
        },
        DISABLED {
            @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.Policy
            public void handlePotentialDeadlock(PotentialDeadlockException potentialDeadlockException) {
            }
        };

        /* access modifiers changed from: public */
        Policies(a aVar) {
        }
    }

    @Beta
    public interface Policy {
        void handlePotentialDeadlock(PotentialDeadlockException potentialDeadlockException);
    }

    @Beta
    public static final class PotentialDeadlockException extends g {
        public final g c;

        public PotentialDeadlockException(h hVar, h hVar2, g gVar, a aVar) {
            super(hVar, hVar2);
            this.c = gVar;
            initCause(gVar);
        }

        public g getConflictingStackTrace() {
            return this.c;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            StringBuilder sb = new StringBuilder(super.getMessage());
            for (Throwable th = this.c; th != null; th = th.getCause()) {
                sb.append(", ");
                sb.append(th.getMessage());
            }
            return sb.toString();
        }
    }

    @Beta
    public static final class WithExplicitOrdering<E extends Enum<E>> extends CycleDetectingLockFactory {
        public final Map<E, h> e;

        @VisibleForTesting
        public WithExplicitOrdering(Policy policy, Map<E, h> map) {
            super(policy, null);
            this.e = map;
        }

        public ReentrantLock newReentrantLock(E e2) {
            return newReentrantLock((WithExplicitOrdering<E>) e2, false);
        }

        public ReentrantReadWriteLock newReentrantReadWriteLock(E e2) {
            return newReentrantReadWriteLock((WithExplicitOrdering<E>) e2, false);
        }

        public ReentrantLock newReentrantLock(E e2, boolean z) {
            if (this.a == Policies.DISABLED) {
                return new ReentrantLock(z);
            }
            return new c(this.e.get(e2), z, null);
        }

        public ReentrantReadWriteLock newReentrantReadWriteLock(E e2, boolean z) {
            if (this.a == Policies.DISABLED) {
                return new ReentrantReadWriteLock(z);
            }
            return new e(this, this.e.get(e2), z, null);
        }
    }

    public static class a extends ThreadLocal<ArrayList<h>> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.lang.ThreadLocal
        public ArrayList<h> initialValue() {
            return Lists.newArrayListWithCapacity(3);
        }
    }

    public interface b {
        h a();

        boolean b();
    }

    public final class e extends ReentrantReadWriteLock implements b {
        public final d a;
        public final f b;
        public final h c;

        public e(CycleDetectingLockFactory cycleDetectingLockFactory, h hVar, boolean z, a aVar) {
            super(z);
            this.a = new d(this);
            this.b = new f(this);
            this.c = (h) Preconditions.checkNotNull(hVar);
        }

        @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.b
        public h a() {
            return this.c;
        }

        @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.b
        public boolean b() {
            return isWriteLockedByCurrentThread() || getReadHoldCount() > 0;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock, java.util.concurrent.locks.ReadWriteLock
        public Lock readLock() {
            return this.a;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock, java.util.concurrent.locks.ReadWriteLock
        public Lock writeLock() {
            return this.b;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock, java.util.concurrent.locks.ReadWriteLock
        /* renamed from: readLock  reason: collision with other method in class */
        public ReentrantReadWriteLock.ReadLock mo145readLock() {
            return this.a;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock, java.util.concurrent.locks.ReadWriteLock
        /* renamed from: writeLock  reason: collision with other method in class */
        public ReentrantReadWriteLock.WriteLock mo146writeLock() {
            return this.b;
        }
    }

    public static class g extends IllegalStateException {
        public static final StackTraceElement[] a = new StackTraceElement[0];
        public static final ImmutableSet<String> b = ImmutableSet.of(CycleDetectingLockFactory.class.getName(), g.class.getName(), h.class.getName());

        public g(h hVar, h hVar2) {
            super(hVar.c + " -> " + hVar2.c);
            StackTraceElement[] stackTrace = getStackTrace();
            int length = stackTrace.length;
            for (int i = 0; i < length; i++) {
                if (WithExplicitOrdering.class.getName().equals(stackTrace[i].getClassName())) {
                    setStackTrace(a);
                    return;
                } else if (!b.contains(stackTrace[i].getClassName())) {
                    setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i, length));
                    return;
                }
            }
        }
    }

    public static class h {
        public final Map<h, g> a = new MapMaker().weakKeys().makeMap();
        public final Map<h, PotentialDeadlockException> b = new MapMaker().weakKeys().makeMap();
        public final String c;

        public h(String str) {
            this.c = (String) Preconditions.checkNotNull(str);
        }

        public void a(Policy policy, List<h> list) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                h hVar = list.get(i);
                Preconditions.checkState(this != hVar, "Attempted to acquire multiple locks with the same rank %s", hVar.c);
                if (!this.a.containsKey(hVar)) {
                    PotentialDeadlockException potentialDeadlockException = this.b.get(hVar);
                    if (potentialDeadlockException != null) {
                        policy.handlePotentialDeadlock(new PotentialDeadlockException(hVar, this, potentialDeadlockException.getConflictingStackTrace(), null));
                    } else {
                        g b2 = hVar.b(this, Sets.newIdentityHashSet());
                        if (b2 == null) {
                            this.a.put(hVar, new g(hVar, this));
                        } else {
                            PotentialDeadlockException potentialDeadlockException2 = new PotentialDeadlockException(hVar, this, b2, null);
                            this.b.put(hVar, potentialDeadlockException2);
                            policy.handlePotentialDeadlock(potentialDeadlockException2);
                        }
                    }
                }
            }
        }

        @NullableDecl
        public final g b(h hVar, Set<h> set) {
            if (!set.add(this)) {
                return null;
            }
            g gVar = this.a.get(hVar);
            if (gVar != null) {
                return gVar;
            }
            for (Map.Entry<h, g> entry : this.a.entrySet()) {
                h key = entry.getKey();
                g b2 = key.b(hVar, set);
                if (b2 != null) {
                    g gVar2 = new g(key, this);
                    gVar2.setStackTrace(entry.getValue().getStackTrace());
                    gVar2.initCause(b2);
                    return gVar2;
                }
            }
            return null;
        }
    }

    public CycleDetectingLockFactory(Policy policy) {
        this.a = (Policy) Preconditions.checkNotNull(policy);
    }

    public static void a(CycleDetectingLockFactory cycleDetectingLockFactory, b bVar) {
        Objects.requireNonNull(cycleDetectingLockFactory);
        if (!bVar.b()) {
            ArrayList<h> arrayList = d.get();
            h a3 = bVar.a();
            a3.a(cycleDetectingLockFactory.a, arrayList);
            arrayList.add(a3);
        }
    }

    public static void b(b bVar) {
        if (!bVar.b()) {
            ArrayList<h> arrayList = d.get();
            h a3 = bVar.a();
            int size = arrayList.size();
            do {
                size--;
                if (size < 0) {
                    return;
                }
            } while (arrayList.get(size) != a3);
            arrayList.remove(size);
        }
    }

    public static CycleDetectingLockFactory newInstance(Policy policy) {
        return new CycleDetectingLockFactory(policy);
    }

    public static <E extends Enum<E>> WithExplicitOrdering<E> newInstanceWithExplicitOrdering(Class<E> cls, Policy policy) {
        Preconditions.checkNotNull(cls);
        Preconditions.checkNotNull(policy);
        Map<? extends Enum, h> map = b.get(cls);
        if (map == null) {
            EnumMap newEnumMap = Maps.newEnumMap(cls);
            E[] enumConstants = cls.getEnumConstants();
            int length = enumConstants.length;
            ArrayList newArrayListWithCapacity = Lists.newArrayListWithCapacity(length);
            int i = 0;
            for (E e2 : enumConstants) {
                h hVar = new h(e2.getDeclaringClass().getSimpleName() + "." + e2.name());
                newArrayListWithCapacity.add(hVar);
                newEnumMap.put((EnumMap) e2, (E) hVar);
            }
            for (int i2 = 1; i2 < length; i2++) {
                ((h) newArrayListWithCapacity.get(i2)).a(Policies.THROW, newArrayListWithCapacity.subList(0, i2));
            }
            while (i < length - 1) {
                i++;
                ((h) newArrayListWithCapacity.get(i)).a(Policies.DISABLED, newArrayListWithCapacity.subList(i, length));
            }
            Map<? extends Enum, h> unmodifiableMap = Collections.unmodifiableMap(newEnumMap);
            map = (Map) MoreObjects.firstNonNull(b.putIfAbsent(cls, unmodifiableMap), unmodifiableMap);
        }
        return new WithExplicitOrdering<>(policy, map);
    }

    public ReentrantLock newReentrantLock(String str) {
        return newReentrantLock(str, false);
    }

    public ReentrantReadWriteLock newReentrantReadWriteLock(String str) {
        return newReentrantReadWriteLock(str, false);
    }

    public ReentrantLock newReentrantLock(String str, boolean z) {
        return this.a == Policies.DISABLED ? new ReentrantLock(z) : new c(new h(str), z, null);
    }

    public ReentrantReadWriteLock newReentrantReadWriteLock(String str, boolean z) {
        return this.a == Policies.DISABLED ? new ReentrantReadWriteLock(z) : new e(this, new h(str), z, null);
    }

    public CycleDetectingLockFactory(Policy policy, a aVar) {
        this.a = (Policy) Preconditions.checkNotNull(policy);
    }

    public final class c extends ReentrantLock implements b {
        public final h a;

        public c(h hVar, boolean z, a aVar) {
            super(z);
            this.a = (h) Preconditions.checkNotNull(hVar);
        }

        @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.b
        public h a() {
            return this.a;
        }

        @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.b
        public boolean b() {
            return isHeldByCurrentThread();
        }

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public void lock() {
            CycleDetectingLockFactory.a(CycleDetectingLockFactory.this, this);
            try {
                super.lock();
            } finally {
                CycleDetectingLockFactory.b(this);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public void lockInterruptibly() throws InterruptedException {
            CycleDetectingLockFactory.a(CycleDetectingLockFactory.this, this);
            try {
                super.lockInterruptibly();
            } finally {
                CycleDetectingLockFactory.b(this);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public boolean tryLock() {
            CycleDetectingLockFactory.a(CycleDetectingLockFactory.this, this);
            try {
                return super.tryLock();
            } finally {
                CycleDetectingLockFactory.b(this);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public void unlock() {
            try {
                super.unlock();
            } finally {
                CycleDetectingLockFactory.b(this);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public boolean tryLock(long j, TimeUnit timeUnit) throws InterruptedException {
            CycleDetectingLockFactory.a(CycleDetectingLockFactory.this, this);
            try {
                return super.tryLock(j, timeUnit);
            } finally {
                CycleDetectingLockFactory.b(this);
            }
        }
    }

    public class d extends ReentrantReadWriteLock.ReadLock {
        @Weak
        public final e a;

        public d(e eVar) {
            super(eVar);
            this.a = eVar;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
        public void lock() {
            CycleDetectingLockFactory.a(CycleDetectingLockFactory.this, this.a);
            try {
                super.lock();
            } finally {
                CycleDetectingLockFactory.b(this.a);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
        public void lockInterruptibly() throws InterruptedException {
            CycleDetectingLockFactory.a(CycleDetectingLockFactory.this, this.a);
            try {
                super.lockInterruptibly();
            } finally {
                CycleDetectingLockFactory.b(this.a);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
        public boolean tryLock() {
            CycleDetectingLockFactory.a(CycleDetectingLockFactory.this, this.a);
            try {
                return super.tryLock();
            } finally {
                CycleDetectingLockFactory.b(this.a);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
        public void unlock() {
            try {
                super.unlock();
            } finally {
                CycleDetectingLockFactory.b(this.a);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
        public boolean tryLock(long j, TimeUnit timeUnit) throws InterruptedException {
            CycleDetectingLockFactory.a(CycleDetectingLockFactory.this, this.a);
            try {
                return super.tryLock(j, timeUnit);
            } finally {
                CycleDetectingLockFactory.b(this.a);
            }
        }
    }

    public class f extends ReentrantReadWriteLock.WriteLock {
        @Weak
        public final e a;

        public f(e eVar) {
            super(eVar);
            this.a = eVar;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
        public void lock() {
            CycleDetectingLockFactory.a(CycleDetectingLockFactory.this, this.a);
            try {
                super.lock();
            } finally {
                CycleDetectingLockFactory.b(this.a);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
        public void lockInterruptibly() throws InterruptedException {
            CycleDetectingLockFactory.a(CycleDetectingLockFactory.this, this.a);
            try {
                super.lockInterruptibly();
            } finally {
                CycleDetectingLockFactory.b(this.a);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
        public boolean tryLock() {
            CycleDetectingLockFactory.a(CycleDetectingLockFactory.this, this.a);
            try {
                return super.tryLock();
            } finally {
                CycleDetectingLockFactory.b(this.a);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
        public void unlock() {
            try {
                super.unlock();
            } finally {
                CycleDetectingLockFactory.b(this.a);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
        public boolean tryLock(long j, TimeUnit timeUnit) throws InterruptedException {
            CycleDetectingLockFactory.a(CycleDetectingLockFactory.this, this.a);
            try {
                return super.tryLock(j, timeUnit);
            } finally {
                CycleDetectingLockFactory.b(this.a);
            }
        }
    }
}
