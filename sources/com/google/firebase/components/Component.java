package com.google.firebase.components;

import com.google.firebase.components.ComponentContainer;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
public final class Component<T> {
    public final Set<Class<? super T>> a;
    public final Set<Dependency> b;
    public final int c;
    public final int d;
    public final ComponentFactory<T> e;
    public final Set<Class<?>> f;

    public static class Builder<T> {
        public final Set<Class<? super T>> a;
        public final Set<Dependency> b = new HashSet();
        public int c;
        public int d;
        public ComponentFactory<T> e;
        public Set<Class<?>> f;

        public Builder(Class cls, Class[] clsArr, a aVar) {
            HashSet hashSet = new HashSet();
            this.a = hashSet;
            this.c = 0;
            this.d = 0;
            this.f = new HashSet();
            Preconditions.checkNotNull(cls, "Null interface");
            hashSet.add(cls);
            for (Class cls2 : clsArr) {
                Preconditions.checkNotNull(cls2, "Null interface");
            }
            Collections.addAll(this.a, clsArr);
        }

        public Builder<T> add(Dependency dependency) {
            Preconditions.checkNotNull(dependency, "Null dependency");
            Preconditions.checkArgument(!this.a.contains(dependency.getInterface()), "Components are not allowed to depend on interfaces they themselves provide.");
            this.b.add(dependency);
            return this;
        }

        public Builder<T> alwaysEager() {
            Preconditions.checkState(this.c == 0, "Instantiation type has already been set.");
            this.c = 1;
            return this;
        }

        public Component<T> build() {
            Preconditions.checkState(this.e != null, "Missing required property: factory.");
            return new Component<>(new HashSet(this.a), new HashSet(this.b), this.c, this.d, this.e, this.f, null);
        }

        public Builder<T> eagerInDefaultApp() {
            Preconditions.checkState(this.c == 0, "Instantiation type has already been set.");
            this.c = 2;
            return this;
        }

        public Builder<T> factory(ComponentFactory<T> componentFactory) {
            this.e = (ComponentFactory) Preconditions.checkNotNull(componentFactory, "Null factory");
            return this;
        }

        public Builder<T> publishes(Class<?> cls) {
            this.f.add(cls);
            return this;
        }
    }

    public Component(Set set, Set set2, int i, int i2, ComponentFactory componentFactory, Set set3, a aVar) {
        this.a = Collections.unmodifiableSet(set);
        this.b = Collections.unmodifiableSet(set2);
        this.c = i;
        this.d = i2;
        this.e = componentFactory;
        this.f = Collections.unmodifiableSet(set3);
    }

    public static <T> Builder<T> builder(Class<T> cls) {
        return new Builder<>(cls, new Class[0], null);
    }

    public static <T> Component<T> intoSet(T t, Class<T> cls) {
        return intoSetBuilder(cls).factory(new ComponentFactory(t) { // from class: a2.j.e.c.d
            public final Object a;

            {
                this.a = r1;
            }

            @Override // com.google.firebase.components.ComponentFactory
            public Object create(ComponentContainer componentContainer) {
                return this.a;
            }
        }).build();
    }

    public static <T> Builder<T> intoSetBuilder(Class<T> cls) {
        Builder<T> builder = builder(cls);
        builder.d = 1;
        return builder;
    }

    @Deprecated
    public static <T> Component<T> of(Class<T> cls, T t) {
        return builder(cls).factory(new ComponentFactory(t) { // from class: a2.j.e.c.b
            public final Object a;

            {
                this.a = r1;
            }

            @Override // com.google.firebase.components.ComponentFactory
            public Object create(ComponentContainer componentContainer) {
                return this.a;
            }
        }).build();
    }

    public Set<Dependency> getDependencies() {
        return this.b;
    }

    public ComponentFactory<T> getFactory() {
        return this.e;
    }

    public Set<Class<? super T>> getProvidedInterfaces() {
        return this.a;
    }

    public Set<Class<?>> getPublishedEvents() {
        return this.f;
    }

    public boolean isAlwaysEager() {
        return this.c == 1;
    }

    public boolean isEagerInDefaultApp() {
        return this.c == 2;
    }

    public boolean isLazy() {
        return this.c == 0;
    }

    public boolean isValue() {
        return this.d == 0;
    }

    public String toString() {
        return "Component<" + Arrays.toString(this.a.toArray()) + ">{" + this.c + ", type=" + this.d + ", deps=" + Arrays.toString(this.b.toArray()) + "}";
    }

    @SafeVarargs
    public static <T> Builder<T> builder(Class<T> cls, Class<? super T>... clsArr) {
        return new Builder<>(cls, clsArr, null);
    }

    @SafeVarargs
    public static <T> Component<T> of(T t, Class<T> cls, Class<? super T>... clsArr) {
        return builder(cls, clsArr).factory(new ComponentFactory(t) { // from class: a2.j.e.c.c
            public final Object a;

            {
                this.a = r1;
            }

            @Override // com.google.firebase.components.ComponentFactory
            public Object create(ComponentContainer componentContainer) {
                return this.a;
            }
        }).build();
    }
}
