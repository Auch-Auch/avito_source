package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@Beta
@GwtIncompatible
public final class Closer implements Closeable {
    public static final c d = (b.b != null ? b.a : a.a);
    @VisibleForTesting
    public final c a;
    public final Deque<Closeable> b = new ArrayDeque(4);
    @MonotonicNonNullDecl
    public Throwable c;

    @VisibleForTesting
    public static final class a implements c {
        public static final a a = new a();

        @Override // com.google.common.io.Closer.c
        public void a(Closeable closeable, Throwable th, Throwable th2) {
            Logger logger = Closeables.a;
            Level level = Level.WARNING;
            logger.log(level, "Suppressing exception thrown when closing " + closeable, th2);
        }
    }

    @VisibleForTesting
    public static final class b implements c {
        public static final b a = new b();
        public static final Method b;

        static {
            Method method;
            try {
                method = Throwable.class.getMethod("addSuppressed", Throwable.class);
            } catch (Throwable unused) {
                method = null;
            }
            b = method;
        }

        @Override // com.google.common.io.Closer.c
        public void a(Closeable closeable, Throwable th, Throwable th2) {
            if (th != th2) {
                try {
                    b.invoke(th, th2);
                } catch (Throwable unused) {
                    Logger logger = Closeables.a;
                    Level level = Level.WARNING;
                    logger.log(level, "Suppressing exception thrown when closing " + closeable, th2);
                }
            }
        }
    }

    @VisibleForTesting
    public interface c {
        void a(Closeable closeable, Throwable th, Throwable th2);
    }

    @VisibleForTesting
    public Closer(c cVar) {
        this.a = (c) Preconditions.checkNotNull(cVar);
    }

    public static Closer create() {
        return new Closer(d);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Throwable th = this.c;
        while (!this.b.isEmpty()) {
            Closeable removeFirst = this.b.removeFirst();
            try {
                removeFirst.close();
            } catch (Throwable th2) {
                if (th == null) {
                    th = th2;
                } else {
                    this.a.a(removeFirst, th, th2);
                }
            }
        }
        if (this.c == null && th != null) {
            Throwables.propagateIfPossible(th, IOException.class);
            throw new AssertionError(th);
        }
    }

    @CanIgnoreReturnValue
    public <C extends Closeable> C register(@NullableDecl C c2) {
        if (c2 != null) {
            this.b.addFirst(c2);
        }
        return c2;
    }

    public RuntimeException rethrow(Throwable th) throws IOException {
        Preconditions.checkNotNull(th);
        this.c = th;
        Throwables.propagateIfPossible(th, IOException.class);
        throw new RuntimeException(th);
    }

    public <X extends Exception> RuntimeException rethrow(Throwable th, Class<X> cls) throws IOException, Exception {
        Preconditions.checkNotNull(th);
        this.c = th;
        Throwables.propagateIfPossible(th, IOException.class);
        Throwables.propagateIfPossible(th, cls);
        throw new RuntimeException(th);
    }

    public <X1 extends Exception, X2 extends Exception> RuntimeException rethrow(Throwable th, Class<X1> cls, Class<X2> cls2) throws IOException, Exception, Exception {
        Preconditions.checkNotNull(th);
        this.c = th;
        Throwables.propagateIfPossible(th, IOException.class);
        Throwables.propagateIfPossible(th, cls, cls2);
        throw new RuntimeException(th);
    }
}
