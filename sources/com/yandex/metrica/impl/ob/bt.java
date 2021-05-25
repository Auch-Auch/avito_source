package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import java.lang.Thread;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
public class bt implements Thread.UncaughtExceptionHandler {
    public static final AtomicBoolean a = new AtomicBoolean();
    private final CopyOnWriteArrayList<la> b;
    private final Thread.UncaughtExceptionHandler c;
    private final eg d;
    @NonNull
    private final am e;

    public bt(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, @NonNull Context context) {
        this(uncaughtExceptionHandler, new am(context));
    }

    @VisibleForTesting
    public void a(@NonNull ld ldVar) {
        Iterator<la> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().a(ldVar);
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        try {
            a.set(true);
            a(new ld(th, new ky(new ee().a(thread), this.d.a(thread)), null, this.e.a(), this.e.b()));
        } finally {
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.c;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th);
            }
        }
    }

    @VisibleForTesting
    public bt(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, @NonNull am amVar) {
        this.d = new eg();
        this.b = new CopyOnWriteArrayList<>();
        this.c = uncaughtExceptionHandler;
        this.e = amVar;
    }

    public void a(la laVar) {
        this.b.add(laVar);
    }
}
