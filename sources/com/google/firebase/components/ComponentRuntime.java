package com.google.firebase.components;

import a2.j.e.c.a;
import a2.j.e.c.g;
import a2.j.e.c.i;
import a2.j.e.c.j;
import a2.j.e.c.l;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRuntime;
import com.google.firebase.components.Lazy;
import com.google.firebase.events.Event;
import com.google.firebase.events.Publisher;
import com.google.firebase.events.Subscriber;
import com.google.firebase.inject.Provider;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Executor;
public class ComponentRuntime extends a {
    public static final /* synthetic */ int e = 0;
    public final Map<Component<?>, Lazy<?>> a = new HashMap();
    public final Map<Class<?>, Lazy<?>> b = new HashMap();
    public final Map<Class<?>, Lazy<Set<?>>> c = new HashMap();
    public final l d;

    public ComponentRuntime(Executor executor, Iterable<ComponentRegistrar> iterable, Component<?>... componentArr) {
        Set<i> set;
        l lVar = new l(executor);
        this.d = lVar;
        ArrayList arrayList = new ArrayList();
        arrayList.add(Component.of(lVar, l.class, Subscriber.class, Publisher.class));
        for (ComponentRegistrar componentRegistrar : iterable) {
            arrayList.addAll(componentRegistrar.getComponents());
        }
        for (Component<?> component : componentArr) {
            if (component != null) {
                arrayList.add(component);
            }
        }
        HashMap hashMap = new HashMap(arrayList.size());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Component component2 = (Component) it.next();
            i iVar = new i(component2);
            Iterator it2 = component2.getProvidedInterfaces().iterator();
            while (true) {
                if (it2.hasNext()) {
                    Class cls = (Class) it2.next();
                    j jVar = new j(cls, !component2.isValue(), null);
                    if (!hashMap.containsKey(jVar)) {
                        hashMap.put(jVar, new HashSet());
                    }
                    Set set2 = (Set) hashMap.get(jVar);
                    if (set2.isEmpty() || jVar.b) {
                        set2.add(iVar);
                    } else {
                        throw new IllegalArgumentException(String.format("Multiple components provide %s.", cls));
                    }
                }
            }
        }
        for (Set<i> set3 : hashMap.values()) {
            for (i iVar2 : set3) {
                for (Dependency dependency : iVar2.a.getDependencies()) {
                    if (dependency.isDirectInjection() && (set = (Set) hashMap.get(new j(dependency.getInterface(), dependency.isSet(), null))) != null) {
                        for (i iVar3 : set) {
                            iVar2.b.add(iVar3);
                            iVar3.c.add(iVar2);
                        }
                    }
                }
            }
        }
        HashSet hashSet = new HashSet();
        for (Set set4 : hashMap.values()) {
            hashSet.addAll(set4);
        }
        HashSet hashSet2 = new HashSet();
        Iterator it3 = hashSet.iterator();
        while (it3.hasNext()) {
            i iVar4 = (i) it3.next();
            if (iVar4.a()) {
                hashSet2.add(iVar4);
            }
        }
        int i = 0;
        while (!hashSet2.isEmpty()) {
            i iVar5 = (i) hashSet2.iterator().next();
            hashSet2.remove(iVar5);
            i++;
            for (i iVar6 : iVar5.b) {
                iVar6.c.remove(iVar5);
                if (iVar6.a()) {
                    hashSet2.add(iVar6);
                }
            }
        }
        if (i == arrayList.size()) {
            Iterator it4 = arrayList.iterator();
            while (it4.hasNext()) {
                Component<?> component3 = (Component) it4.next();
                this.a.put(component3, new Lazy<>(new Provider(this, component3) { // from class: a2.j.e.c.e
                    public final ComponentRuntime a;
                    public final Component b;

                    {
                        this.a = r1;
                        this.b = r2;
                    }

                    @Override // com.google.firebase.inject.Provider
                    public Object get() {
                        ComponentRuntime componentRuntime = this.a;
                        Component component4 = this.b;
                        int i2 = ComponentRuntime.e;
                        return component4.getFactory().create(new m(component4, componentRuntime));
                    }
                }));
            }
            for (Map.Entry<Component<?>, Lazy<?>> entry : this.a.entrySet()) {
                Component<?> key = entry.getKey();
                if (key.isValue()) {
                    Lazy<?> value = entry.getValue();
                    for (Class<? super Object> cls2 : key.getProvidedInterfaces()) {
                        this.b.put(cls2, value);
                    }
                }
            }
            for (Component<?> component4 : this.a.keySet()) {
                Iterator<Dependency> it5 = component4.getDependencies().iterator();
                while (true) {
                    if (it5.hasNext()) {
                        Dependency next = it5.next();
                        if (next.isRequired() && !this.b.containsKey(next.getInterface())) {
                            throw new MissingDependencyException(String.format("Unsatisfied dependency for component %s: %s", component4, next.getInterface()));
                        }
                    }
                }
            }
            HashMap hashMap2 = new HashMap();
            for (Map.Entry<Component<?>, Lazy<?>> entry2 : this.a.entrySet()) {
                Component<?> key2 = entry2.getKey();
                if (!key2.isValue()) {
                    Lazy<?> value2 = entry2.getValue();
                    for (Class<? super Object> cls3 : key2.getProvidedInterfaces()) {
                        if (!hashMap2.containsKey(cls3)) {
                            hashMap2.put(cls3, new HashSet());
                        }
                        ((Set) hashMap2.get(cls3)).add(value2);
                    }
                }
            }
            for (Map.Entry entry3 : hashMap2.entrySet()) {
                this.c.put((Class) entry3.getKey(), new Lazy<>(new Provider((Set) entry3.getValue()) { // from class: a2.j.e.c.f
                    public final Set a;

                    {
                        this.a = r1;
                    }

                    @Override // com.google.firebase.inject.Provider
                    public Object get() {
                        Set<Lazy> set5 = this.a;
                        int i2 = ComponentRuntime.e;
                        HashSet hashSet3 = new HashSet();
                        for (Lazy lazy : set5) {
                            hashSet3.add(lazy.get());
                        }
                        return Collections.unmodifiableSet(hashSet3);
                    }
                }));
            }
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it6 = hashSet.iterator();
        while (it6.hasNext()) {
            i iVar7 = (i) it6.next();
            if (!iVar7.a() && !iVar7.b.isEmpty()) {
                arrayList2.add(iVar7.a);
            }
        }
        throw new DependencyCycleException(arrayList2);
    }

    @Override // a2.j.e.c.a, com.google.firebase.components.ComponentContainer
    public /* bridge */ /* synthetic */ Object get(Class cls) {
        return super.get(cls);
    }

    @Override // com.google.firebase.components.ComponentContainer
    public <T> Provider<T> getProvider(Class<T> cls) {
        Preconditions.checkNotNull(cls, "Null interface requested.");
        return this.b.get(cls);
    }

    public void initializeEagerComponents(boolean z) {
        Queue<Event<?>> queue;
        for (Map.Entry<Component<?>, Lazy<?>> entry : this.a.entrySet()) {
            Component<?> key = entry.getKey();
            Lazy<?> value = entry.getValue();
            if (key.isAlwaysEager() || (key.isEagerInDefaultApp() && z)) {
                value.get();
            }
        }
        l lVar = this.d;
        synchronized (lVar) {
            queue = lVar.b;
            if (queue != null) {
                lVar.b = null;
            } else {
                queue = null;
            }
        }
        if (queue != null) {
            for (Event<?> event : queue) {
                lVar.publish(event);
            }
        }
    }

    @Override // a2.j.e.c.a, com.google.firebase.components.ComponentContainer
    public /* bridge */ /* synthetic */ Set setOf(Class cls) {
        return super.setOf(cls);
    }

    @Override // com.google.firebase.components.ComponentContainer
    public <T> Provider<Set<T>> setOfProvider(Class<T> cls) {
        Lazy<Set<?>> lazy = this.c.get(cls);
        if (lazy != null) {
            return lazy;
        }
        return g.a;
    }
}
