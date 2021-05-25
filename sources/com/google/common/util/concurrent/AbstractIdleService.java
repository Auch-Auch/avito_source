package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Service;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
@Beta
@GwtIncompatible
public abstract class AbstractIdleService implements Service {
    public final Supplier<String> a = new c(null);
    public final Service b = new b(null);

    public class a implements Executor {
        public a() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            MoreExecutors.c(AbstractIdleService.this.a.get(), runnable).start();
        }
    }

    public final class b extends AbstractService {

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    AbstractIdleService.this.startUp();
                    b.this.notifyStarted();
                } catch (Throwable th) {
                    b.this.notifyFailed(th);
                }
            }
        }

        /* renamed from: com.google.common.util.concurrent.AbstractIdleService$b$b  reason: collision with other inner class name */
        public class RunnableC0298b implements Runnable {
            public RunnableC0298b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    AbstractIdleService.this.shutDown();
                    b.this.notifyStopped();
                } catch (Throwable th) {
                    b.this.notifyFailed(th);
                }
            }
        }

        public b(a aVar) {
        }

        @Override // com.google.common.util.concurrent.AbstractService
        public final void doStart() {
            MoreExecutors.e(AbstractIdleService.this.executor(), AbstractIdleService.this.a).execute(new a());
        }

        @Override // com.google.common.util.concurrent.AbstractService
        public final void doStop() {
            MoreExecutors.e(AbstractIdleService.this.executor(), AbstractIdleService.this.a).execute(new RunnableC0298b());
        }

        @Override // com.google.common.util.concurrent.AbstractService
        public String toString() {
            return AbstractIdleService.this.toString();
        }
    }

    public final class c implements Supplier<String> {
        public c(a aVar) {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.google.common.base.Supplier
        public String get() {
            return AbstractIdleService.this.serviceName() + " " + AbstractIdleService.this.state();
        }
    }

    @Override // com.google.common.util.concurrent.Service
    public final void addListener(Service.Listener listener, Executor executor) {
        this.b.addListener(listener, executor);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning() {
        this.b.awaitRunning();
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated() {
        this.b.awaitTerminated();
    }

    public Executor executor() {
        return new a();
    }

    @Override // com.google.common.util.concurrent.Service
    public final Throwable failureCause() {
        return this.b.failureCause();
    }

    @Override // com.google.common.util.concurrent.Service
    public final boolean isRunning() {
        return this.b.isRunning();
    }

    public String serviceName() {
        return getClass().getSimpleName();
    }

    public abstract void shutDown() throws Exception;

    @Override // com.google.common.util.concurrent.Service
    @CanIgnoreReturnValue
    public final Service startAsync() {
        this.b.startAsync();
        return this;
    }

    public abstract void startUp() throws Exception;

    @Override // com.google.common.util.concurrent.Service
    public final Service.State state() {
        return this.b.state();
    }

    @Override // com.google.common.util.concurrent.Service
    @CanIgnoreReturnValue
    public final Service stopAsync() {
        this.b.stopAsync();
        return this;
    }

    public String toString() {
        return serviceName() + " [" + state() + "]";
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning(long j, TimeUnit timeUnit) throws TimeoutException {
        this.b.awaitRunning(j, timeUnit);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated(long j, TimeUnit timeUnit) throws TimeoutException {
        this.b.awaitTerminated(j, timeUnit);
    }
}
