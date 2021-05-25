package com.google.android.play.core.tasks;

import a2.j.b.e.a.j.k;
import a2.j.b.e.a.j.l;
import com.google.android.play.core.splitcompat.d;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
public final class Tasks {
    public static <ResultT> Task<ResultT> a(Exception exc) {
        k kVar = new k();
        kVar.a(exc);
        return kVar;
    }

    public static <ResultT> Task<ResultT> a(ResultT resultt) {
        k kVar = new k();
        kVar.b(resultt);
        return kVar;
    }

    public static <ResultT> ResultT await(Task<ResultT> task) throws ExecutionException, InterruptedException {
        d.a(task, "Task must not be null");
        if (task.isComplete()) {
            return (ResultT) b(task);
        }
        l lVar = new l(null);
        Executor executor = TaskExecutors.a;
        task.addOnSuccessListener(executor, lVar);
        task.addOnFailureListener(executor, lVar);
        lVar.a.await();
        return (ResultT) b(task);
    }

    public static <ResultT> ResultT b(Task<ResultT> task) throws ExecutionException {
        if (task.isSuccessful()) {
            return task.getResult();
        }
        throw new ExecutionException(task.getException());
    }

    public static <ResultT> ResultT await(Task<ResultT> task, long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        d.a(task, "Task must not be null");
        d.a(timeUnit, "TimeUnit must not be null");
        if (task.isComplete()) {
            return (ResultT) b(task);
        }
        l lVar = new l(null);
        Executor executor = TaskExecutors.a;
        task.addOnSuccessListener(executor, lVar);
        task.addOnFailureListener(executor, lVar);
        if (lVar.a.await(j, timeUnit)) {
            return (ResultT) b(task);
        }
        throw new TimeoutException("Timed out waiting for Task");
    }
}
