package a2.j.d.e;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.eventbus.EventBus;
import com.google.j2objc.annotations.Weak;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public class c {
    @Weak
    public EventBus a;
    @VisibleForTesting
    public final Object b;
    public final Method c;
    public final Executor d;

    @VisibleForTesting
    public static final class a extends c {
        public a(EventBus eventBus, Object obj, Method method, b bVar) {
            super(eventBus, obj, method);
        }

        @Override // a2.j.d.e.c
        public void a(Object obj) throws InvocationTargetException {
            synchronized (this) {
                c.super.a(obj);
            }
        }
    }

    public c(EventBus eventBus, Object obj, Method method) {
        this.a = eventBus;
        this.b = Preconditions.checkNotNull(obj);
        this.c = method;
        method.setAccessible(true);
        this.d = eventBus.b;
    }

    @VisibleForTesting
    public void a(Object obj) throws InvocationTargetException {
        try {
            this.c.invoke(this.b, Preconditions.checkNotNull(obj));
        } catch (IllegalArgumentException e) {
            throw new Error(a2.b.a.a.a.b3("Method rejected target/argument: ", obj), e);
        } catch (IllegalAccessException e2) {
            throw new Error(a2.b.a.a.a.b3("Method became inaccessible: ", obj), e2);
        } catch (InvocationTargetException e3) {
            if (e3.getCause() instanceof Error) {
                throw ((Error) e3.getCause());
            }
            throw e3;
        }
    }

    public final boolean equals(@NullableDecl Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (this.b != cVar.b || !this.c.equals(cVar.c)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return System.identityHashCode(this.b) + ((this.c.hashCode() + 31) * 31);
    }
}
