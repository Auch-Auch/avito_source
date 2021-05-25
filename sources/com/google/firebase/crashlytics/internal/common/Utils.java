package com.google.firebase.crashlytics.internal.common;

import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.crashlytics.internal.common.Utils;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
public final class Utils {
    public static final FilenameFilter a = new a();
    public static final ExecutorService b = ExecutorUtils.buildSingleThreadExecutorService("awaitEvenIfOnMainThread task continuation executor");

    public class a implements FilenameFilter {
        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return true;
        }
    }

    public class b implements Continuation<T, Void> {
        public final /* synthetic */ TaskCompletionSource a;

        public b(TaskCompletionSource taskCompletionSource) {
            this.a = taskCompletionSource;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.google.android.gms.tasks.Continuation
        public Void then(@NonNull Task task) throws Exception {
            if (task.isSuccessful()) {
                this.a.trySetResult(task.getResult());
                return null;
            }
            this.a.trySetException(task.getException());
            return null;
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ Callable a;
        public final /* synthetic */ TaskCompletionSource b;

        public class a implements Continuation<T, Void> {
            public a() {
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.google.android.gms.tasks.Continuation
            public Void then(@NonNull Task task) throws Exception {
                if (task.isSuccessful()) {
                    c.this.b.setResult(task.getResult());
                    return null;
                }
                c.this.b.setException(task.getException());
                return null;
            }
        }

        public c(Callable callable, TaskCompletionSource taskCompletionSource) {
            this.a = callable;
            this.b = taskCompletionSource;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ((Task) this.a.call()).continueWith(new a());
            } catch (Exception e) {
                this.b.setException(e);
            }
        }
    }

    public static int a(File file, FilenameFilter filenameFilter, int i, Comparator<File> comparator) {
        File[] listFiles = file.listFiles(filenameFilter);
        if (listFiles == null) {
            return 0;
        }
        return b(Arrays.asList(listFiles), i, comparator);
    }

    public static <T> T awaitEvenIfOnMainThread(Task<T> task) throws InterruptedException, TimeoutException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        task.continueWith(b, new Continuation(countDownLatch) { // from class: a2.j.e.d.d.a.r0
            public final CountDownLatch a;

            {
                this.a = r1;
            }

            @Override // com.google.android.gms.tasks.Continuation
            public Object then(Task task2) {
                CountDownLatch countDownLatch2 = this.a;
                FilenameFilter filenameFilter = Utils.a;
                countDownLatch2.countDown();
                return null;
            }
        });
        if (Looper.getMainLooper() == Looper.myLooper()) {
            countDownLatch.await(4, TimeUnit.SECONDS);
        } else {
            countDownLatch.await();
        }
        if (task.isSuccessful()) {
            return task.getResult();
        }
        if (task.isCanceled()) {
            throw new CancellationException("Task is already canceled");
        } else if (task.isComplete()) {
            throw new IllegalStateException(task.getException());
        } else {
            throw new TimeoutException();
        }
    }

    public static int b(List<File> list, int i, Comparator<File> comparator) {
        int size = list.size();
        Collections.sort(list, comparator);
        for (File file : list) {
            if (size <= i) {
                return size;
            }
            c(file);
            size--;
        }
        return size;
    }

    public static void c(File file) {
        if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                c(file2);
            }
        }
        file.delete();
    }

    public static <T> Task<T> callTask(Executor executor, Callable<Task<T>> callable) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        executor.execute(new c(callable, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    public static <T> Task<T> race(Task<T> task, Task<T> task2) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        b bVar = new b(taskCompletionSource);
        task.continueWith(bVar);
        task2.continueWith(bVar);
        return taskCompletionSource.getTask();
    }
}
