package bolts;

import o6.f;
public class TaskCompletionSource<TResult> {
    public final Task<TResult> a = new Task<>();

    public Task<TResult> getTask() {
        return this.a;
    }

    public void setCancelled() {
        if (!trySetCancelled()) {
            throw new IllegalStateException("Cannot cancel a completed task.");
        }
    }

    public void setError(Exception exc) {
        if (!trySetError(exc)) {
            throw new IllegalStateException("Cannot set the error on a completed task.");
        }
    }

    public void setResult(TResult tresult) {
        if (!trySetResult(tresult)) {
            throw new IllegalStateException("Cannot set the result of a completed task.");
        }
    }

    public boolean trySetCancelled() {
        return this.a.c();
    }

    public boolean trySetError(Exception exc) {
        Task<TResult> task = this.a;
        synchronized (task.a) {
            if (task.b) {
                return false;
            }
            task.b = true;
            task.e = exc;
            task.f = false;
            task.a.notifyAll();
            task.b();
            if (!task.f && Task.getUnobservedExceptionHandler() != null) {
                task.g = new f(task);
            }
            return true;
        }
    }

    public boolean trySetResult(TResult tresult) {
        return this.a.d(tresult);
    }
}
