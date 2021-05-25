package bolts;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
public class Task<TResult> {
    public static final ExecutorService BACKGROUND_EXECUTOR;
    public static final Executor UI_THREAD_EXECUTOR = o6.a.b.a;
    public static final Executor i;
    public static volatile UnobservedExceptionHandler j;
    public static Task<?> k = new Task<>((Object) null);
    public static Task<Boolean> l = new Task<>(Boolean.TRUE);
    public static Task<Boolean> m = new Task<>(Boolean.FALSE);
    public static Task<?> n = new Task<>(true);
    public final Object a = new Object();
    public boolean b;
    public boolean c;
    public TResult d;
    public Exception e;
    public boolean f;
    public o6.f g;
    public List<Continuation<TResult, Void>> h = new ArrayList();

    public class TaskCompletionSource extends TaskCompletionSource<TResult> {
        public TaskCompletionSource(Task task) {
        }
    }

    public interface UnobservedExceptionHandler {
        void unobservedException(Task<?> task, UnobservedTaskException unobservedTaskException);
    }

    public class a implements Continuation<TResult, Void> {
        public final /* synthetic */ TaskCompletionSource a;
        public final /* synthetic */ Continuation b;
        public final /* synthetic */ Executor c;
        public final /* synthetic */ CancellationToken d;

        public a(Task task, TaskCompletionSource taskCompletionSource, Continuation continuation, Executor executor, CancellationToken cancellationToken) {
            this.a = taskCompletionSource;
            this.b = continuation;
            this.c = executor;
            this.d = cancellationToken;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // bolts.Continuation
        public Void then(Task task) throws Exception {
            TaskCompletionSource taskCompletionSource = this.a;
            Continuation continuation = this.b;
            Executor executor = this.c;
            CancellationToken cancellationToken = this.d;
            ExecutorService executorService = Task.BACKGROUND_EXECUTOR;
            try {
                executor.execute(new o6.d(cancellationToken, taskCompletionSource, continuation, task));
                return null;
            } catch (Exception e) {
                taskCompletionSource.setError(new ExecutorException(e));
                return null;
            }
        }
    }

    public class b implements Continuation<TResult, Void> {
        public final /* synthetic */ TaskCompletionSource a;
        public final /* synthetic */ Continuation b;
        public final /* synthetic */ Executor c;
        public final /* synthetic */ CancellationToken d;

        public b(Task task, TaskCompletionSource taskCompletionSource, Continuation continuation, Executor executor, CancellationToken cancellationToken) {
            this.a = taskCompletionSource;
            this.b = continuation;
            this.c = executor;
            this.d = cancellationToken;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // bolts.Continuation
        public Void then(Task task) throws Exception {
            TaskCompletionSource taskCompletionSource = this.a;
            Continuation continuation = this.b;
            Executor executor = this.c;
            CancellationToken cancellationToken = this.d;
            ExecutorService executorService = Task.BACKGROUND_EXECUTOR;
            try {
                executor.execute(new o6.e(cancellationToken, taskCompletionSource, continuation, task));
                return null;
            } catch (Exception e) {
                taskCompletionSource.setError(new ExecutorException(e));
                return null;
            }
        }
    }

    public class c implements Continuation<TResult, Task<TContinuationResult>> {
        public final /* synthetic */ CancellationToken a;
        public final /* synthetic */ Continuation b;

        public c(Task task, CancellationToken cancellationToken, Continuation continuation) {
            this.a = cancellationToken;
            this.b = continuation;
        }

        @Override // bolts.Continuation
        public Object then(Task task) throws Exception {
            CancellationToken cancellationToken = this.a;
            if (cancellationToken != null && cancellationToken.isCancellationRequested()) {
                return Task.cancelled();
            }
            if (task.isFaulted()) {
                return Task.forError(task.getError());
            }
            if (task.isCancelled()) {
                return Task.cancelled();
            }
            return task.continueWith(this.b);
        }
    }

    public class d implements Continuation<TResult, Task<TContinuationResult>> {
        public final /* synthetic */ CancellationToken a;
        public final /* synthetic */ Continuation b;

        public d(Task task, CancellationToken cancellationToken, Continuation continuation) {
            this.a = cancellationToken;
            this.b = continuation;
        }

        @Override // bolts.Continuation
        public Object then(Task task) throws Exception {
            CancellationToken cancellationToken = this.a;
            if (cancellationToken != null && cancellationToken.isCancellationRequested()) {
                return Task.cancelled();
            }
            if (task.isFaulted()) {
                return Task.forError(task.getError());
            }
            if (task.isCancelled()) {
                return Task.cancelled();
            }
            return task.continueWithTask(this.b);
        }
    }

    public static class e implements Runnable {
        public final /* synthetic */ TaskCompletionSource a;

        public e(TaskCompletionSource taskCompletionSource) {
            this.a = taskCompletionSource;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.trySetResult(null);
        }
    }

    public static class f implements Runnable {
        public final /* synthetic */ ScheduledFuture a;
        public final /* synthetic */ TaskCompletionSource b;

        public f(ScheduledFuture scheduledFuture, TaskCompletionSource taskCompletionSource) {
            this.a = scheduledFuture;
            this.b = taskCompletionSource;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.cancel(true);
            this.b.trySetCancelled();
        }
    }

    public class g implements Continuation<TResult, Task<Void>> {
        public g(Task task) {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // bolts.Continuation
        public Task<Void> then(Task task) throws Exception {
            if (task.isCancelled()) {
                return Task.cancelled();
            }
            if (task.isFaulted()) {
                return Task.forError(task.getError());
            }
            return Task.forResult(null);
        }
    }

    public static class h implements Runnable {
        public final /* synthetic */ CancellationToken a;
        public final /* synthetic */ TaskCompletionSource b;
        public final /* synthetic */ Callable c;

        public h(CancellationToken cancellationToken, TaskCompletionSource taskCompletionSource, Callable callable) {
            this.a = cancellationToken;
            this.b = taskCompletionSource;
            this.c = callable;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: bolts.TaskCompletionSource */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            CancellationToken cancellationToken = this.a;
            if (cancellationToken == null || !cancellationToken.isCancellationRequested()) {
                try {
                    this.b.setResult(this.c.call());
                } catch (CancellationException unused) {
                    this.b.setCancelled();
                } catch (Exception e) {
                    this.b.setError(e);
                }
            } else {
                this.b.setCancelled();
            }
        }
    }

    public static class i implements Continuation<TResult, Void> {
        public final /* synthetic */ AtomicBoolean a;
        public final /* synthetic */ TaskCompletionSource b;

        public i(AtomicBoolean atomicBoolean, TaskCompletionSource taskCompletionSource) {
            this.a = atomicBoolean;
            this.b = taskCompletionSource;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // bolts.Continuation
        public Void then(Task task) throws Exception {
            if (this.a.compareAndSet(false, true)) {
                this.b.setResult(task);
                return null;
            }
            task.getError();
            return null;
        }
    }

    public static class j implements Continuation<Object, Void> {
        public final /* synthetic */ AtomicBoolean a;
        public final /* synthetic */ TaskCompletionSource b;

        public j(AtomicBoolean atomicBoolean, TaskCompletionSource taskCompletionSource) {
            this.a = atomicBoolean;
            this.b = taskCompletionSource;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [bolts.Task] */
        @Override // bolts.Continuation
        public Void then(Task<Object> task) throws Exception {
            if (this.a.compareAndSet(false, true)) {
                this.b.setResult(task);
                return null;
            }
            task.getError();
            return null;
        }
    }

    public static class k implements Continuation<Void, List<TResult>> {
        public final /* synthetic */ Collection a;

        public k(Collection collection) {
            this.a = collection;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [bolts.Task] */
        @Override // bolts.Continuation
        public Object then(Task<Void> task) throws Exception {
            if (this.a.size() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            for (Task task2 : this.a) {
                arrayList.add(task2.getResult());
            }
            return arrayList;
        }
    }

    public static class l implements Continuation<Object, Void> {
        public final /* synthetic */ Object a;
        public final /* synthetic */ ArrayList b;
        public final /* synthetic */ AtomicBoolean c;
        public final /* synthetic */ AtomicInteger d;
        public final /* synthetic */ TaskCompletionSource e;

        public l(Object obj, ArrayList arrayList, AtomicBoolean atomicBoolean, AtomicInteger atomicInteger, TaskCompletionSource taskCompletionSource) {
            this.a = obj;
            this.b = arrayList;
            this.c = atomicBoolean;
            this.d = atomicInteger;
            this.e = taskCompletionSource;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [bolts.Task] */
        @Override // bolts.Continuation
        public Void then(Task<Object> task) throws Exception {
            if (task.isFaulted()) {
                synchronized (this.a) {
                    this.b.add(task.getError());
                }
            }
            if (task.isCancelled()) {
                this.c.set(true);
            }
            if (this.d.decrementAndGet() == 0) {
                if (this.b.size() != 0) {
                    if (this.b.size() == 1) {
                        this.e.setError((Exception) this.b.get(0));
                    } else {
                        this.e.setError(new AggregateException(String.format("There were %d exceptions.", Integer.valueOf(this.b.size())), this.b));
                    }
                } else if (this.c.get()) {
                    this.e.setCancelled();
                } else {
                    this.e.setResult(null);
                }
            }
            return null;
        }
    }

    public class m implements Continuation<Void, Task<Void>> {
        public final /* synthetic */ CancellationToken a;
        public final /* synthetic */ Callable b;
        public final /* synthetic */ Continuation c;
        public final /* synthetic */ Executor d;
        public final /* synthetic */ Capture e;

        public m(Task task, CancellationToken cancellationToken, Callable callable, Continuation continuation, Executor executor, Capture capture) {
            this.a = cancellationToken;
            this.b = callable;
            this.c = continuation;
            this.d = executor;
            this.e = capture;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [bolts.Task] */
        @Override // bolts.Continuation
        public Task<Void> then(Task<Void> task) throws Exception {
            CancellationToken cancellationToken = this.a;
            if (cancellationToken != null && cancellationToken.isCancellationRequested()) {
                return Task.cancelled();
            }
            if (((Boolean) this.b.call()).booleanValue()) {
                return Task.forResult(null).onSuccessTask(this.c, this.d).onSuccessTask((Continuation) this.e.get(), this.d);
            }
            return Task.forResult(null);
        }
    }

    static {
        o6.b bVar = o6.b.d;
        BACKGROUND_EXECUTOR = bVar.a;
        i = bVar.c;
    }

    public Task() {
    }

    public static Task<Void> a(long j2, ScheduledExecutorService scheduledExecutorService, CancellationToken cancellationToken) {
        if (cancellationToken != null && cancellationToken.isCancellationRequested()) {
            return cancelled();
        }
        if (j2 <= 0) {
            return forResult(null);
        }
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        ScheduledFuture<?> schedule = scheduledExecutorService.schedule(new e(taskCompletionSource), j2, TimeUnit.MILLISECONDS);
        if (cancellationToken != null) {
            cancellationToken.register(new f(schedule, taskCompletionSource));
        }
        return taskCompletionSource.getTask();
    }

    public static <TResult> Task<TResult> call(Callable<TResult> callable, Executor executor) {
        return call(callable, executor, null);
    }

    public static <TResult> Task<TResult> callInBackground(Callable<TResult> callable) {
        return call(callable, BACKGROUND_EXECUTOR, null);
    }

    public static <TResult> Task<TResult> cancelled() {
        return (Task<TResult>) n;
    }

    public static <TResult> Task<TResult>.TaskCompletionSource create() {
        return new TaskCompletionSource(new Task());
    }

    public static Task<Void> delay(long j2) {
        return a(j2, o6.b.d.b, null);
    }

    public static <TResult> Task<TResult> forError(Exception exc) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        taskCompletionSource.setError(exc);
        return taskCompletionSource.getTask();
    }

    public static <TResult> Task<TResult> forResult(TResult tresult) {
        if (tresult == null) {
            return (Task<TResult>) k;
        }
        if (tresult instanceof Boolean) {
            return tresult.booleanValue() ? (Task<TResult>) l : (Task<TResult>) m;
        }
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        taskCompletionSource.setResult(tresult);
        return taskCompletionSource.getTask();
    }

    public static UnobservedExceptionHandler getUnobservedExceptionHandler() {
        return j;
    }

    public static void setUnobservedExceptionHandler(UnobservedExceptionHandler unobservedExceptionHandler) {
        j = unobservedExceptionHandler;
    }

    public static Task<Void> whenAll(Collection<? extends Task<?>> collection) {
        if (collection.size() == 0) {
            return forResult(null);
        }
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        ArrayList arrayList = new ArrayList();
        Object obj = new Object();
        AtomicInteger atomicInteger = new AtomicInteger(collection.size());
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        Iterator<? extends Task<?>> it = collection.iterator();
        while (it.hasNext()) {
            ((Task) it.next()).continueWith(new l(obj, arrayList, atomicBoolean, atomicInteger, taskCompletionSource));
        }
        return taskCompletionSource.getTask();
    }

    public static <TResult> Task<List<TResult>> whenAllResult(Collection<? extends Task<TResult>> collection) {
        return whenAll(collection).onSuccess(new k(collection));
    }

    public static Task<Task<?>> whenAny(Collection<? extends Task<?>> collection) {
        if (collection.size() == 0) {
            return forResult(null);
        }
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        Iterator<? extends Task<?>> it = collection.iterator();
        while (it.hasNext()) {
            ((Task) it.next()).continueWith(new j(atomicBoolean, taskCompletionSource));
        }
        return taskCompletionSource.getTask();
    }

    public static <TResult> Task<Task<TResult>> whenAnyResult(Collection<? extends Task<TResult>> collection) {
        if (collection.size() == 0) {
            return forResult(null);
        }
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        Iterator<? extends Task<TResult>> it = collection.iterator();
        while (it.hasNext()) {
            ((Task) it.next()).continueWith(new i(atomicBoolean, taskCompletionSource));
        }
        return taskCompletionSource.getTask();
    }

    public final void b() {
        synchronized (this.a) {
            for (Continuation<TResult, Void> continuation : this.h) {
                try {
                    continuation.then(this);
                } catch (RuntimeException e2) {
                    throw e2;
                } catch (Exception e3) {
                    throw new RuntimeException(e3);
                }
            }
            this.h = null;
        }
    }

    public boolean c() {
        synchronized (this.a) {
            if (this.b) {
                return false;
            }
            this.b = true;
            this.c = true;
            this.a.notifyAll();
            b();
            return true;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: bolts.Task<TResult> */
    /* JADX WARN: Multi-variable type inference failed */
    public <TOut> Task<TOut> cast() {
        return this;
    }

    public Task<Void> continueWhile(Callable<Boolean> callable, Continuation<Void, Task<Void>> continuation) {
        return continueWhile(callable, continuation, i, null);
    }

    public <TContinuationResult> Task<TContinuationResult> continueWith(Continuation<TResult, TContinuationResult> continuation, Executor executor) {
        return continueWith(continuation, executor, null);
    }

    public <TContinuationResult> Task<TContinuationResult> continueWithTask(Continuation<TResult, Task<TContinuationResult>> continuation, Executor executor) {
        return continueWithTask(continuation, executor, null);
    }

    public boolean d(TResult tresult) {
        synchronized (this.a) {
            if (this.b) {
                return false;
            }
            this.b = true;
            this.d = tresult;
            this.a.notifyAll();
            b();
            return true;
        }
    }

    public Exception getError() {
        Exception exc;
        synchronized (this.a) {
            exc = this.e;
            if (exc != null) {
                this.f = true;
                o6.f fVar = this.g;
                if (fVar != null) {
                    fVar.a = null;
                    this.g = null;
                }
            }
        }
        return exc;
    }

    public TResult getResult() {
        TResult tresult;
        synchronized (this.a) {
            tresult = this.d;
        }
        return tresult;
    }

    public boolean isCancelled() {
        boolean z;
        synchronized (this.a) {
            z = this.c;
        }
        return z;
    }

    public boolean isCompleted() {
        boolean z;
        synchronized (this.a) {
            z = this.b;
        }
        return z;
    }

    public boolean isFaulted() {
        boolean z;
        synchronized (this.a) {
            z = getError() != null;
        }
        return z;
    }

    public Task<Void> makeVoid() {
        return continueWithTask(new g(this));
    }

    public <TContinuationResult> Task<TContinuationResult> onSuccess(Continuation<TResult, TContinuationResult> continuation, Executor executor) {
        return onSuccess(continuation, executor, null);
    }

    public <TContinuationResult> Task<TContinuationResult> onSuccessTask(Continuation<TResult, Task<TContinuationResult>> continuation, Executor executor) {
        return onSuccessTask(continuation, executor, null);
    }

    public void waitForCompletion() throws InterruptedException {
        synchronized (this.a) {
            if (!isCompleted()) {
                this.a.wait();
            }
        }
    }

    public static <TResult> Task<TResult> call(Callable<TResult> callable, Executor executor, CancellationToken cancellationToken) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        try {
            executor.execute(new h(cancellationToken, taskCompletionSource, callable));
        } catch (Exception e2) {
            taskCompletionSource.setError(new ExecutorException(e2));
        }
        return taskCompletionSource.getTask();
    }

    public static <TResult> Task<TResult> callInBackground(Callable<TResult> callable, CancellationToken cancellationToken) {
        return call(callable, BACKGROUND_EXECUTOR, cancellationToken);
    }

    public Task<Void> continueWhile(Callable<Boolean> callable, Continuation<Void, Task<Void>> continuation, CancellationToken cancellationToken) {
        return continueWhile(callable, continuation, i, cancellationToken);
    }

    public <TContinuationResult> Task<TContinuationResult> continueWith(Continuation<TResult, TContinuationResult> continuation, Executor executor, CancellationToken cancellationToken) {
        boolean isCompleted;
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        synchronized (this.a) {
            isCompleted = isCompleted();
            if (!isCompleted) {
                this.h.add(new a(this, taskCompletionSource, continuation, executor, cancellationToken));
            }
        }
        if (isCompleted) {
            try {
                executor.execute(new o6.d(cancellationToken, taskCompletionSource, continuation, this));
            } catch (Exception e2) {
                taskCompletionSource.setError(new ExecutorException(e2));
            }
        }
        return taskCompletionSource.getTask();
    }

    public <TContinuationResult> Task<TContinuationResult> continueWithTask(Continuation<TResult, Task<TContinuationResult>> continuation, Executor executor, CancellationToken cancellationToken) {
        boolean isCompleted;
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        synchronized (this.a) {
            isCompleted = isCompleted();
            if (!isCompleted) {
                this.h.add(new b(this, taskCompletionSource, continuation, executor, cancellationToken));
            }
        }
        if (isCompleted) {
            try {
                executor.execute(new o6.e(cancellationToken, taskCompletionSource, continuation, this));
            } catch (Exception e2) {
                taskCompletionSource.setError(new ExecutorException(e2));
            }
        }
        return taskCompletionSource.getTask();
    }

    public <TContinuationResult> Task<TContinuationResult> onSuccess(Continuation<TResult, TContinuationResult> continuation, Executor executor, CancellationToken cancellationToken) {
        return continueWithTask(new c(this, cancellationToken, continuation), executor);
    }

    public <TContinuationResult> Task<TContinuationResult> onSuccessTask(Continuation<TResult, Task<TContinuationResult>> continuation, Executor executor, CancellationToken cancellationToken) {
        return continueWithTask(new d(this, cancellationToken, continuation), executor);
    }

    public static Task<Void> delay(long j2, CancellationToken cancellationToken) {
        return a(j2, o6.b.d.b, cancellationToken);
    }

    public Task<Void> continueWhile(Callable<Boolean> callable, Continuation<Void, Task<Void>> continuation, Executor executor) {
        return continueWhile(callable, continuation, executor, null);
    }

    public <TContinuationResult> Task<TContinuationResult> onSuccess(Continuation<TResult, TContinuationResult> continuation) {
        return onSuccess(continuation, i, null);
    }

    public <TContinuationResult> Task<TContinuationResult> onSuccessTask(Continuation<TResult, Task<TContinuationResult>> continuation) {
        return onSuccessTask(continuation, i);
    }

    public Task(TResult tresult) {
        d(tresult);
    }

    public Task<Void> continueWhile(Callable<Boolean> callable, Continuation<Void, Task<Void>> continuation, Executor executor, CancellationToken cancellationToken) {
        Capture capture = new Capture();
        capture.set(new m(this, cancellationToken, callable, continuation, executor, capture));
        return makeVoid().continueWithTask((Continuation) capture.get(), executor);
    }

    public <TContinuationResult> Task<TContinuationResult> onSuccess(Continuation<TResult, TContinuationResult> continuation, CancellationToken cancellationToken) {
        return onSuccess(continuation, i, cancellationToken);
    }

    public <TContinuationResult> Task<TContinuationResult> onSuccessTask(Continuation<TResult, Task<TContinuationResult>> continuation, CancellationToken cancellationToken) {
        return onSuccessTask(continuation, i, cancellationToken);
    }

    public boolean waitForCompletion(long j2, TimeUnit timeUnit) throws InterruptedException {
        boolean isCompleted;
        synchronized (this.a) {
            if (!isCompleted()) {
                this.a.wait(timeUnit.toMillis(j2));
            }
            isCompleted = isCompleted();
        }
        return isCompleted;
    }

    public static <TResult> Task<TResult> call(Callable<TResult> callable) {
        return call(callable, i, null);
    }

    public static <TResult> Task<TResult> call(Callable<TResult> callable, CancellationToken cancellationToken) {
        return call(callable, i, cancellationToken);
    }

    public Task(boolean z) {
        if (z) {
            c();
        } else {
            d(null);
        }
    }

    public <TContinuationResult> Task<TContinuationResult> continueWith(Continuation<TResult, TContinuationResult> continuation) {
        return continueWith(continuation, i, null);
    }

    public <TContinuationResult> Task<TContinuationResult> continueWithTask(Continuation<TResult, Task<TContinuationResult>> continuation) {
        return continueWithTask(continuation, i, null);
    }

    public <TContinuationResult> Task<TContinuationResult> continueWith(Continuation<TResult, TContinuationResult> continuation, CancellationToken cancellationToken) {
        return continueWith(continuation, i, cancellationToken);
    }

    public <TContinuationResult> Task<TContinuationResult> continueWithTask(Continuation<TResult, Task<TContinuationResult>> continuation, CancellationToken cancellationToken) {
        return continueWithTask(continuation, i, cancellationToken);
    }
}
