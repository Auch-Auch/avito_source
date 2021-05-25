package com.google.common.eventbus;

import a2.j.d.e.a;
import a2.j.d.e.c;
import a2.j.d.e.d;
import com.google.common.annotations.Beta;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.UncheckedExecutionException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;
@Beta
public class EventBus {
    public static final Logger f = Logger.getLogger(EventBus.class.getName());
    public final String a;
    public final Executor b;
    public final SubscriberExceptionHandler c;
    public final d d;
    public final a2.j.d.e.a e;

    public static final class a implements SubscriberExceptionHandler {
        public static final a a = new a();

        @Override // com.google.common.eventbus.SubscriberExceptionHandler
        public void handleException(Throwable th, SubscriberExceptionContext subscriberExceptionContext) {
            Logger logger = Logger.getLogger(EventBus.class.getName() + "." + subscriberExceptionContext.getEventBus().identifier());
            Level level = Level.SEVERE;
            if (logger.isLoggable(level)) {
                Method subscriberMethod = subscriberExceptionContext.getSubscriberMethod();
                StringBuilder L = a2.b.a.a.a.L("Exception thrown by subscriber method ");
                L.append(subscriberMethod.getName());
                L.append('(');
                L.append(subscriberMethod.getParameterTypes()[0].getName());
                L.append(')');
                L.append(" on subscriber ");
                L.append(subscriberExceptionContext.getSubscriber());
                L.append(" when dispatching event: ");
                L.append(subscriberExceptionContext.getEvent());
                logger.log(level, L.toString(), th);
            }
        }
    }

    public EventBus() {
        this("default");
    }

    public final String identifier() {
        return this.a;
    }

    public void post(Object obj) {
        d dVar = this.d;
        Objects.requireNonNull(dVar);
        try {
            ImmutableSet<Class<?>> unchecked = d.d.getUnchecked(obj.getClass());
            ArrayList newArrayListWithCapacity = Lists.newArrayListWithCapacity(unchecked.size());
            UnmodifiableIterator<Class<?>> it = unchecked.mo99iterator();
            while (it.hasNext()) {
                CopyOnWriteArraySet<c> copyOnWriteArraySet = dVar.a.get(it.next());
                if (copyOnWriteArraySet != null) {
                    newArrayListWithCapacity.add(copyOnWriteArraySet.iterator());
                }
            }
            Iterator<c> concat = Iterators.concat(newArrayListWithCapacity.iterator());
            if (concat.hasNext()) {
                this.e.a(obj, concat);
            } else if (!(obj instanceof DeadEvent)) {
                post(new DeadEvent(this, obj));
            }
        } catch (UncheckedExecutionException e2) {
            throw Throwables.propagate(e2.getCause());
        }
    }

    public void register(Object obj) {
        d dVar = this.d;
        for (Map.Entry<Class<?>, Collection<c>> entry : dVar.a(obj).asMap().entrySet()) {
            Class<?> key = entry.getKey();
            Collection<c> value = entry.getValue();
            CopyOnWriteArraySet<c> copyOnWriteArraySet = dVar.a.get(key);
            if (copyOnWriteArraySet == null) {
                CopyOnWriteArraySet<c> copyOnWriteArraySet2 = new CopyOnWriteArraySet<>();
                copyOnWriteArraySet = (CopyOnWriteArraySet) MoreObjects.firstNonNull(dVar.a.putIfAbsent(key, copyOnWriteArraySet2), copyOnWriteArraySet2);
            }
            copyOnWriteArraySet.addAll(value);
        }
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).addValue(this.a).toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x0018  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void unregister(java.lang.Object r6) {
        /*
            r5 = this;
            a2.j.d.e.d r0 = r5.d
            com.google.common.collect.Multimap r1 = r0.a(r6)
            java.util.Map r1 = r1.asMap()
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x0012:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0057
            java.lang.Object r2 = r1.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getKey()
            java.lang.Class r3 = (java.lang.Class) r3
            java.lang.Object r2 = r2.getValue()
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.concurrent.ConcurrentMap<java.lang.Class<?>, java.util.concurrent.CopyOnWriteArraySet<a2.j.d.e.c>> r4 = r0.a
            java.lang.Object r3 = r4.get(r3)
            java.util.concurrent.CopyOnWriteArraySet r3 = (java.util.concurrent.CopyOnWriteArraySet) r3
            if (r3 == 0) goto L_0x003b
            boolean r2 = r3.removeAll(r2)
            if (r2 == 0) goto L_0x003b
            goto L_0x0012
        L_0x003b:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "missing event subscriber for an annotated method. Is "
            r1.append(r2)
            r1.append(r6)
            java.lang.String r6 = " registered?"
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            r0.<init>(r6)
            throw r0
        L_0x0057:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.eventbus.EventBus.unregister(java.lang.Object):void");
    }

    public EventBus(String str) {
        this(str, MoreExecutors.directExecutor(), new a.c(null), a.a);
    }

    public EventBus(SubscriberExceptionHandler subscriberExceptionHandler) {
        this("default", MoreExecutors.directExecutor(), new a.c(null), subscriberExceptionHandler);
    }

    public EventBus(String str, Executor executor, a2.j.d.e.a aVar, SubscriberExceptionHandler subscriberExceptionHandler) {
        this.d = new d(this);
        this.a = (String) Preconditions.checkNotNull(str);
        this.b = (Executor) Preconditions.checkNotNull(executor);
        this.e = (a2.j.d.e.a) Preconditions.checkNotNull(aVar);
        this.c = (SubscriberExceptionHandler) Preconditions.checkNotNull(subscriberExceptionHandler);
    }
}
