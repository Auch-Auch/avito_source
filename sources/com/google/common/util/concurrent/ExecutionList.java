package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtIncompatible
public final class ExecutionList {
    public static final Logger c = Logger.getLogger(ExecutionList.class.getName());
    @NullableDecl
    @GuardedBy("this")
    public a a;
    @GuardedBy("this")
    public boolean b;

    public static final class a {
        public final Runnable a;
        public final Executor b;
        @NullableDecl
        public a c;

        public a(Runnable runnable, Executor executor, a aVar) {
            this.a = runnable;
            this.b = executor;
            this.c = aVar;
        }
    }

    public static void a(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e) {
            Logger logger = c;
            Level level = Level.SEVERE;
            logger.log(level, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e);
        }
    }

    public void add(Runnable runnable, Executor executor) {
        Preconditions.checkNotNull(runnable, "Runnable was null.");
        Preconditions.checkNotNull(executor, "Executor was null.");
        synchronized (this) {
            if (!this.b) {
                this.a = new a(runnable, executor, this.a);
            } else {
                a(runnable, executor);
            }
        }
    }

    public void execute() {
        a aVar;
        a aVar2;
        synchronized (this) {
            if (!this.b) {
                this.b = true;
                aVar = this.a;
                aVar2 = null;
                this.a = null;
            } else {
                return;
            }
        }
        while (aVar != null) {
            a aVar3 = aVar.c;
            aVar.c = aVar2;
            aVar2 = aVar;
            aVar = aVar3;
        }
        while (aVar2 != null) {
            a(aVar2.a, aVar2.b);
            aVar2 = aVar2.c;
        }
    }
}
