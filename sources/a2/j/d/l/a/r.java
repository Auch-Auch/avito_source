package a2.j.d.l.a;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Ordering;
import com.google.common.util.concurrent.ExecutionError;
import com.google.common.util.concurrent.UncheckedExecutionException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
@GwtIncompatible
public final class r {
    public static final Ordering<Constructor<?>> a = Ordering.natural().onResultOf(new a()).reverse();

    public static class a implements Function<Constructor<?>, Boolean> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.google.common.base.Function
        public Boolean apply(Constructor<?> constructor) {
            return Boolean.valueOf(Arrays.asList(constructor.getParameterTypes()).contains(String.class));
        }
    }

    @VisibleForTesting
    public interface b {
        void a(Class<? extends Exception> cls);
    }

    @VisibleForTesting
    public static class c {
        public static final String a;
        public static final b b;

        public enum a implements b {
            INSTANCE;
            
            public static final Set<WeakReference<Class<? extends Exception>>> b = new CopyOnWriteArraySet();

            @Override // a2.j.d.l.a.r.b
            public void a(Class<? extends Exception> cls) {
                for (WeakReference<Class<? extends Exception>> weakReference : b) {
                    if (cls.equals(weakReference.get())) {
                        return;
                    }
                }
                Ordering<Constructor<?>> ordering = r.a;
                boolean z = true;
                Preconditions.checkArgument(!RuntimeException.class.isAssignableFrom(cls), "Futures.getChecked exception type (%s) must not be a RuntimeException", cls);
                try {
                    r.a(cls, new Exception());
                } catch (Exception unused) {
                    z = false;
                }
                Preconditions.checkArgument(z, "Futures.getChecked exception type (%s) must be an accessible class with an accessible constructor whose parameters (if any) must be of type String and/or Throwable", cls);
                Set<WeakReference<Class<? extends Exception>>> set = b;
                if (set.size() > 1000) {
                    set.clear();
                }
                set.add(new WeakReference<>(cls));
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v7, resolved type: java.lang.Object[] */
        /* JADX WARN: Multi-variable type inference failed */
        static {
            b bVar;
            String D2 = a2.b.a.a.a.D2(c.class, new StringBuilder(), "$ClassValueValidator");
            a = D2;
            try {
                bVar = (b) Class.forName(D2).getEnumConstants()[0];
            } catch (Throwable unused) {
                Ordering<Constructor<?>> ordering = r.a;
                bVar = a.INSTANCE;
            }
            b = bVar;
        }
    }

    public static <X extends Exception> X a(Class<X> cls, Throwable th) {
        Object obj;
        for (E e : a.sortedCopy(Arrays.asList(cls.getConstructors()))) {
            Class<?>[] parameterTypes = e.getParameterTypes();
            Object[] objArr = new Object[parameterTypes.length];
            int i = 0;
            while (true) {
                obj = null;
                if (i < parameterTypes.length) {
                    Class<?> cls2 = parameterTypes[i];
                    if (!cls2.equals(String.class)) {
                        if (!cls2.equals(Throwable.class)) {
                            break;
                        }
                        objArr[i] = th;
                    } else {
                        objArr[i] = th.toString();
                    }
                    i++;
                } else {
                    try {
                        obj = e.newInstance(objArr);
                        break;
                    } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | InvocationTargetException unused) {
                    }
                }
            }
            X x = (X) ((Exception) obj);
            if (x != null) {
                if (x.getCause() == null) {
                    x.initCause(th);
                }
                return x;
            }
        }
        throw new IllegalArgumentException("No appropriate constructor for exception of type " + cls + " in response to chained exception", th);
    }

    public static <X extends Exception> void b(Throwable th, Class<X> cls) throws Exception {
        if (th instanceof Error) {
            throw new ExecutionError((Error) th);
        } else if (th instanceof RuntimeException) {
            throw new UncheckedExecutionException(th);
        } else {
            throw a(cls, th);
        }
    }
}
