package a2.j.e.c;

import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.Dependency;
import com.google.firebase.events.Event;
import com.google.firebase.events.Publisher;
import com.google.firebase.inject.Provider;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
public final class m extends a {
    public final Set<Class<?>> a;
    public final Set<Class<?>> b;
    public final Set<Class<?>> c;
    public final Set<Class<?>> d;
    public final Set<Class<?>> e;
    public final ComponentContainer f;

    public static class a implements Publisher {
        public final Set<Class<?>> a;
        public final Publisher b;

        public a(Set<Class<?>> set, Publisher publisher) {
            this.a = set;
            this.b = publisher;
        }

        @Override // com.google.firebase.events.Publisher
        public void publish(Event<?> event) {
            if (this.a.contains(event.getType())) {
                this.b.publish(event);
                return;
            }
            throw new IllegalArgumentException(String.format("Attempting to publish an undeclared event %s.", event));
        }
    }

    public m(Component<?> component, ComponentContainer componentContainer) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        for (Dependency dependency : component.getDependencies()) {
            if (dependency.isDirectInjection()) {
                if (dependency.isSet()) {
                    hashSet3.add(dependency.getInterface());
                } else {
                    hashSet.add(dependency.getInterface());
                }
            } else if (dependency.isSet()) {
                hashSet4.add(dependency.getInterface());
            } else {
                hashSet2.add(dependency.getInterface());
            }
        }
        if (!component.getPublishedEvents().isEmpty()) {
            hashSet.add(Publisher.class);
        }
        this.a = Collections.unmodifiableSet(hashSet);
        this.b = Collections.unmodifiableSet(hashSet2);
        this.c = Collections.unmodifiableSet(hashSet3);
        this.d = Collections.unmodifiableSet(hashSet4);
        this.e = component.getPublishedEvents();
        this.f = componentContainer;
    }

    @Override // a2.j.e.c.a, com.google.firebase.components.ComponentContainer
    public <T> T get(Class<T> cls) {
        if (this.a.contains(cls)) {
            T t = (T) this.f.get(cls);
            return !cls.equals(Publisher.class) ? t : (T) new a(this.e, t);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency %s.", cls));
    }

    @Override // com.google.firebase.components.ComponentContainer
    public <T> Provider<T> getProvider(Class<T> cls) {
        if (this.b.contains(cls)) {
            return this.f.getProvider(cls);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Provider<%s>.", cls));
    }

    @Override // a2.j.e.c.a, com.google.firebase.components.ComponentContainer
    public <T> Set<T> setOf(Class<T> cls) {
        if (this.c.contains(cls)) {
            return this.f.setOf(cls);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Set<%s>.", cls));
    }

    @Override // com.google.firebase.components.ComponentContainer
    public <T> Provider<Set<T>> setOfProvider(Class<T> cls) {
        if (this.d.contains(cls)) {
            return this.f.setOfProvider(cls);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Provider<Set<%s>>.", cls));
    }
}
