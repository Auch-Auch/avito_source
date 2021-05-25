package org.junit.internal.runners.statements;

import java.lang.Thread;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.junit.internal.management.ManagementFactory;
import org.junit.internal.management.ThreadMXBean;
import org.junit.runners.model.MultipleFailureException;
import org.junit.runners.model.Statement;
import org.junit.runners.model.TestTimedOutException;
public class FailOnTimeout extends Statement {
    public final Statement a;
    public final TimeUnit b;
    public final long c;
    public final boolean d;

    public class b implements Callable<Throwable> {
        public final CountDownLatch a = new CountDownLatch(1);

        public b(a aVar) {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public Throwable call() throws Exception {
            try {
                this.a.countDown();
                FailOnTimeout.this.a.evaluate();
                return null;
            } catch (Exception e) {
                throw e;
            } catch (Throwable th) {
                return th;
            }
        }
    }

    @Deprecated
    public FailOnTimeout(Statement statement, long j) {
        Builder withTimeout = builder().withTimeout(j, TimeUnit.MILLISECONDS);
        this.a = statement;
        this.c = withTimeout.b;
        this.b = withTimeout.c;
        this.d = withTimeout.a;
    }

    public static Builder builder() {
        return new Builder(null);
    }

    public final Throwable a(FutureTask<Throwable> futureTask, Thread thread) {
        StackTraceElement[] stackTraceElementArr;
        List<Thread> emptyList;
        long j;
        try {
            long j2 = this.c;
            if (j2 > 0) {
                return futureTask.get(j2, this.b);
            }
            return futureTask.get();
        } catch (InterruptedException e) {
            return e;
        } catch (ExecutionException e2) {
            return e2.getCause();
        } catch (TimeoutException unused) {
            StackTraceElement[] stackTrace = thread.getStackTrace();
            Thread thread2 = null;
            if (this.d) {
                ThreadGroup threadGroup = thread.getThreadGroup();
                int max = Math.max(threadGroup.activeCount() * 2, 100);
                int i = 0;
                while (true) {
                    if (i >= 5) {
                        emptyList = Collections.emptyList();
                        break;
                    }
                    Thread[] threadArr = new Thread[max];
                    int enumerate = threadGroup.enumerate(threadArr);
                    if (enumerate < max) {
                        emptyList = Arrays.asList(threadArr).subList(0, enumerate);
                        break;
                    }
                    max += 100;
                    i++;
                }
                if (!emptyList.isEmpty()) {
                    long j3 = 0;
                    Thread thread3 = null;
                    for (Thread thread4 : emptyList) {
                        if (thread4.getState() == Thread.State.RUNNABLE) {
                            ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
                            if (threadMXBean.isThreadCpuTimeSupported()) {
                                try {
                                    j = threadMXBean.getThreadCpuTime(thread4.getId());
                                } catch (UnsupportedOperationException unused2) {
                                }
                                if (thread3 != null || j > j3) {
                                    thread3 = thread4;
                                    j3 = j;
                                }
                            }
                            j = 0;
                            if (thread3 != null) {
                            }
                            thread3 = thread4;
                            j3 = j;
                        }
                    }
                    if (thread3 != thread) {
                        thread2 = thread3;
                    }
                }
            }
            TestTimedOutException testTimedOutException = new TestTimedOutException(this.c, this.b);
            if (stackTrace != null) {
                testTimedOutException.setStackTrace(stackTrace);
                thread.interrupt();
            }
            if (thread2 == null) {
                return testTimedOutException;
            }
            StringBuilder L = a2.b.a.a.a.L("Appears to be stuck in thread ");
            L.append(thread2.getName());
            Exception exc = new Exception(L.toString());
            try {
                stackTraceElementArr = thread2.getStackTrace();
            } catch (SecurityException unused3) {
                stackTraceElementArr = new StackTraceElement[0];
            }
            exc.setStackTrace(stackTraceElementArr);
            return new MultipleFailureException(Arrays.asList(testTimedOutException, exc));
        }
    }

    @Override // org.junit.runners.model.Statement
    public void evaluate() throws Throwable {
        b bVar = new b(null);
        FutureTask<Throwable> futureTask = new FutureTask<>(bVar);
        ThreadGroup threadGroup = new ThreadGroup("FailOnTimeoutGroup");
        Thread thread = new Thread(threadGroup, futureTask, "Time-limited test");
        long j = 1;
        try {
            thread.setDaemon(true);
            thread.start();
            bVar.a.await();
            Throwable a3 = a(futureTask, thread);
            if (a3 == null) {
            } else {
                throw a3;
            }
        } finally {
            try {
                thread.join(j);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
            try {
                threadGroup.destroy();
            } catch (IllegalThreadStateException unused2) {
            }
        }
    }

    public static class Builder {
        public boolean a = false;
        public long b = 0;
        public TimeUnit c = TimeUnit.SECONDS;

        public Builder() {
        }

        public FailOnTimeout build(Statement statement) {
            Objects.requireNonNull(statement, "statement cannot be null");
            return new FailOnTimeout(this, statement, null);
        }

        public Builder withLookingForStuckThread(boolean z) {
            this.a = z;
            return this;
        }

        public Builder withTimeout(long j, TimeUnit timeUnit) {
            if (j >= 0) {
                Objects.requireNonNull(timeUnit, "TimeUnit cannot be null");
                this.b = j;
                this.c = timeUnit;
                return this;
            }
            throw new IllegalArgumentException("timeout must be non-negative");
        }

        public Builder(a aVar) {
        }
    }

    public FailOnTimeout(Builder builder, Statement statement, a aVar) {
        this.a = statement;
        this.c = builder.b;
        this.b = builder.c;
        this.d = builder.a;
    }
}
