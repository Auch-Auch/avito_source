package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ObjectArrays;
import com.google.common.collect.Sets;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
@Beta
@GwtIncompatible
public final class SimpleTimeLimiter implements TimeLimiter {
    public final ExecutorService a;

    public class a implements InvocationHandler {
        public final /* synthetic */ Object a;
        public final /* synthetic */ long b;
        public final /* synthetic */ TimeUnit c;
        public final /* synthetic */ Set d;

        /* renamed from: com.google.common.util.concurrent.SimpleTimeLimiter$a$a  reason: collision with other inner class name */
        public class CallableC0301a implements Callable<Object> {
            public final /* synthetic */ Method a;
            public final /* synthetic */ Object[] b;

            public CallableC0301a(Method method, Object[] objArr) {
                this.a = method;
                this.b = objArr;
            }

            @Override // java.util.concurrent.Callable
            public Object call() throws Exception {
                try {
                    return this.a.invoke(a.this.a, this.b);
                } catch (InvocationTargetException e) {
                    SimpleTimeLimiter.b(e, false);
                    throw null;
                }
            }
        }

        public a(Object obj, long j, TimeUnit timeUnit, Set set) {
            this.a = obj;
            this.b = j;
            this.c = timeUnit;
            this.d = set;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            CallableC0301a aVar = new CallableC0301a(method, objArr);
            SimpleTimeLimiter simpleTimeLimiter = SimpleTimeLimiter.this;
            long j = this.b;
            TimeUnit timeUnit = this.c;
            boolean contains = this.d.contains(method);
            Objects.requireNonNull(simpleTimeLimiter);
            Preconditions.checkNotNull(aVar);
            Preconditions.checkNotNull(timeUnit);
            SimpleTimeLimiter.a(j);
            Future submit = simpleTimeLimiter.a.submit(aVar);
            if (!contains) {
                return Uninterruptibles.getUninterruptibly(submit, j, timeUnit);
            }
            try {
                return submit.get(j, timeUnit);
            } catch (InterruptedException e2) {
                submit.cancel(true);
                throw e2;
            } catch (ExecutionException e3) {
                SimpleTimeLimiter.b(e3, true);
                throw null;
            } catch (TimeoutException e4) {
                submit.cancel(true);
                throw new UncheckedTimeoutException(e4);
            }
        }
    }

    public SimpleTimeLimiter(ExecutorService executorService) {
        this.a = (ExecutorService) Preconditions.checkNotNull(executorService);
    }

    public static void a(long j) {
        Preconditions.checkArgument(j > 0, "timeout must be positive: %s", j);
    }

    public static Exception b(Exception exc, boolean z) throws Exception {
        Throwable cause = exc.getCause();
        if (cause != null) {
            if (z) {
                cause.setStackTrace((StackTraceElement[]) ObjectArrays.concat(cause.getStackTrace(), exc.getStackTrace(), StackTraceElement.class));
            }
            if (cause instanceof Exception) {
                throw ((Exception) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw exc;
            }
        } else {
            throw exc;
        }
    }

    public static SimpleTimeLimiter create(ExecutorService executorService) {
        return new SimpleTimeLimiter(executorService);
    }

    public final void c(Throwable th) throws ExecutionException {
        if (th instanceof Error) {
            throw new ExecutionError((Error) th);
        } else if (th instanceof RuntimeException) {
            throw new UncheckedExecutionException(th);
        } else {
            throw new ExecutionException(th);
        }
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    @CanIgnoreReturnValue
    public <T> T callUninterruptiblyWithTimeout(Callable<T> callable, long j, TimeUnit timeUnit) throws TimeoutException, ExecutionException {
        Preconditions.checkNotNull(callable);
        Preconditions.checkNotNull(timeUnit);
        a(j);
        Future<T> submit = this.a.submit(callable);
        try {
            return (T) Uninterruptibles.getUninterruptibly(submit, j, timeUnit);
        } catch (TimeoutException e) {
            submit.cancel(true);
            throw e;
        } catch (ExecutionException e2) {
            c(e2.getCause());
            throw null;
        }
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    @CanIgnoreReturnValue
    public <T> T callWithTimeout(Callable<T> callable, long j, TimeUnit timeUnit) throws TimeoutException, InterruptedException, ExecutionException {
        Preconditions.checkNotNull(callable);
        Preconditions.checkNotNull(timeUnit);
        a(j);
        Future<T> submit = this.a.submit(callable);
        try {
            return submit.get(j, timeUnit);
        } catch (InterruptedException | TimeoutException e) {
            submit.cancel(true);
            throw e;
        } catch (ExecutionException e2) {
            c(e2.getCause());
            throw null;
        }
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    public <T> T newProxy(T t, Class<T> cls, long j, TimeUnit timeUnit) {
        Preconditions.checkNotNull(t);
        Preconditions.checkNotNull(cls);
        Preconditions.checkNotNull(timeUnit);
        a(j);
        Preconditions.checkArgument(cls.isInterface(), "interfaceType must be an interface type");
        HashSet newHashSet = Sets.newHashSet();
        Method[] methods = cls.getMethods();
        int length = methods.length;
        int i = 0;
        while (true) {
            boolean z = true;
            if (i < length) {
                Method method = methods[i];
                Class<?>[] exceptionTypes = method.getExceptionTypes();
                int length2 = exceptionTypes.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length2) {
                        z = false;
                        break;
                    } else if (exceptionTypes[i2] == InterruptedException.class) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (z) {
                    newHashSet.add(method);
                }
                i++;
            } else {
                return cls.cast(Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new a(t, j, timeUnit, newHashSet)));
            }
        }
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    public void runUninterruptiblyWithTimeout(Runnable runnable, long j, TimeUnit timeUnit) throws TimeoutException {
        Preconditions.checkNotNull(runnable);
        Preconditions.checkNotNull(timeUnit);
        a(j);
        Future<?> submit = this.a.submit(runnable);
        try {
            Uninterruptibles.getUninterruptibly(submit, j, timeUnit);
        } catch (TimeoutException e) {
            submit.cancel(true);
            throw e;
        } catch (ExecutionException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof Error) {
                throw new ExecutionError((Error) cause);
            }
            throw new UncheckedExecutionException(cause);
        }
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    public void runWithTimeout(Runnable runnable, long j, TimeUnit timeUnit) throws TimeoutException, InterruptedException {
        Preconditions.checkNotNull(runnable);
        Preconditions.checkNotNull(timeUnit);
        a(j);
        Future<?> submit = this.a.submit(runnable);
        try {
            submit.get(j, timeUnit);
        } catch (InterruptedException | TimeoutException e) {
            submit.cancel(true);
            throw e;
        } catch (ExecutionException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof Error) {
                throw new ExecutionError((Error) cause);
            }
            throw new UncheckedExecutionException(cause);
        }
    }
}
