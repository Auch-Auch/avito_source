package a2.j.d.e;

import a2.j.d.e.c;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.google.common.reflect.TypeToken;
import com.google.j2objc.annotations.Weak;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public final class d {
    public static final LoadingCache<Class<?>, ImmutableList<Method>> c = CacheBuilder.newBuilder().weakKeys().build(new a());
    public static final LoadingCache<Class<?>, ImmutableSet<Class<?>>> d = CacheBuilder.newBuilder().weakKeys().build(new b());
    public final ConcurrentMap<Class<?>, CopyOnWriteArraySet<c>> a = Maps.newConcurrentMap();
    @Weak
    public final EventBus b;

    public static class a extends CacheLoader<Class<?>, ImmutableList<Method>> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.google.common.cache.CacheLoader
        public ImmutableList<Method> load(Class<?> cls) throws Exception {
            Set<Class> rawTypes = TypeToken.of((Class) cls).getTypes().rawTypes();
            HashMap newHashMap = Maps.newHashMap();
            for (Class cls2 : rawTypes) {
                Method[] declaredMethods = cls2.getDeclaredMethods();
                for (Method method : declaredMethods) {
                    if (method.isAnnotationPresent(Subscribe.class) && !method.isSynthetic()) {
                        Class<?>[] parameterTypes = method.getParameterTypes();
                        boolean z = true;
                        if (parameterTypes.length != 1) {
                            z = false;
                        }
                        Preconditions.checkArgument(z, "Method %s has @Subscribe annotation but has %s parameters.Subscriber methods must have exactly 1 parameter.", (Object) method, parameterTypes.length);
                        c cVar = new c(method);
                        if (!newHashMap.containsKey(cVar)) {
                            newHashMap.put(cVar, method);
                        }
                    }
                }
            }
            return ImmutableList.copyOf(newHashMap.values());
        }
    }

    public static class b extends CacheLoader<Class<?>, ImmutableSet<Class<?>>> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.google.common.cache.CacheLoader
        public ImmutableSet<Class<?>> load(Class<?> cls) throws Exception {
            return ImmutableSet.copyOf((Collection) TypeToken.of((Class) cls).getTypes().rawTypes());
        }
    }

    public static final class c {
        public final String a;
        public final List<Class<?>> b;

        public c(Method method) {
            this.a = method.getName();
            this.b = Arrays.asList(method.getParameterTypes());
        }

        public boolean equals(@NullableDecl Object obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            if (!this.a.equals(cVar.a) || !this.b.equals(cVar.b)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return Objects.hashCode(this.a, this.b);
        }
    }

    public d(EventBus eventBus) {
        this.b = (EventBus) Preconditions.checkNotNull(eventBus);
    }

    public final Multimap<Class<?>, c> a(Object obj) {
        HashMultimap create = HashMultimap.create();
        UnmodifiableIterator<Method> it = c.getUnchecked(obj.getClass()).mo99iterator();
        while (it.hasNext()) {
            Method next = it.next();
            boolean z = false;
            Class<?> cls = next.getParameterTypes()[0];
            EventBus eventBus = this.b;
            if (next.getAnnotation(AllowConcurrentEvents.class) != null) {
                z = true;
            }
            create.put(cls, z ? new c(eventBus, obj, next) : new c.a(eventBus, obj, next, null));
        }
        return create;
    }
}
