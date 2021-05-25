package o6;

import bolts.Task;
import bolts.UnobservedTaskException;
public class f {
    public Task<?> a;

    public f(Task<?> task) {
        this.a = task;
    }

    public void finalize() throws Throwable {
        Task.UnobservedExceptionHandler unobservedExceptionHandler;
        try {
            Task<?> task = this.a;
            if (!(task == null || (unobservedExceptionHandler = Task.getUnobservedExceptionHandler()) == null)) {
                unobservedExceptionHandler.unobservedException(task, new UnobservedTaskException(task.getError()));
            }
        } finally {
            super.finalize();
        }
    }
}
