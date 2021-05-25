package com.google.common.base;

import com.avito.android.lib.design.input.FormatterType;
import com.google.common.annotations.GwtIncompatible;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtIncompatible
public class FinalizableReferenceQueue implements Closeable {
    public static final Logger d = Logger.getLogger(FinalizableReferenceQueue.class.getName());
    public static final Method e;
    public final ReferenceQueue<Object> a;
    public final PhantomReference<Object> b;
    public final boolean c;

    public static class a implements c {
        @Override // com.google.common.base.FinalizableReferenceQueue.c
        @NullableDecl
        public Class<?> a() {
            try {
                return new URLClassLoader(new URL[]{b()}, null).loadClass("com.google.common.base.internal.Finalizer");
            } catch (Exception e) {
                FinalizableReferenceQueue.d.log(Level.WARNING, "Could not load Finalizer in its own class loader. Loading Finalizer in the current class loader instead. As a result, you will not be able to garbage collect this class loader. To support reclaiming this class loader, either resolve the underlying issue, or move Guava to your system class path.", (Throwable) e);
                return null;
            }
        }

        public URL b() throws IOException {
            String str = "com.google.common.base.internal.Finalizer".replace((char) FormatterType.defaultDecimalSeparator, '/') + ".class";
            URL resource = a.class.getClassLoader().getResource(str);
            if (resource != null) {
                String url = resource.toString();
                if (url.endsWith(str)) {
                    return new URL(resource, url.substring(0, url.length() - str.length()));
                }
                throw new IOException(a2.b.a.a.a.c3("Unsupported path style: ", url));
            }
            throw new FileNotFoundException(str);
        }
    }

    public static class b implements c {
        @Override // com.google.common.base.FinalizableReferenceQueue.c
        public Class<?> a() {
            try {
                return Class.forName("com.google.common.base.internal.Finalizer");
            } catch (ClassNotFoundException e) {
                throw new AssertionError(e);
            }
        }
    }

    public interface c {
        @NullableDecl
        Class<?> a();
    }

    public static class d implements c {
        @Override // com.google.common.base.FinalizableReferenceQueue.c
        @NullableDecl
        public Class<?> a() {
            try {
                ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
                if (systemClassLoader == null) {
                    return null;
                }
                try {
                    return systemClassLoader.loadClass("com.google.common.base.internal.Finalizer");
                } catch (ClassNotFoundException unused) {
                    return null;
                }
            } catch (SecurityException unused2) {
                FinalizableReferenceQueue.d.info("Not allowed to access system class loader.");
                return null;
            }
        }
    }

    static {
        c[] cVarArr = {new d(), new a(), new b()};
        for (int i = 0; i < 3; i++) {
            Class<?> a3 = cVarArr[i].a();
            if (a3 != null) {
                try {
                    e = a3.getMethod("startFinalizer", Class.class, ReferenceQueue.class, PhantomReference.class);
                    return;
                } catch (NoSuchMethodException e2) {
                    throw new AssertionError(e2);
                }
            }
        }
        throw new AssertionError();
    }

    public FinalizableReferenceQueue() {
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        this.a = referenceQueue;
        PhantomReference<Object> phantomReference = new PhantomReference<>(this, referenceQueue);
        this.b = phantomReference;
        boolean z = true;
        try {
            e.invoke(null, FinalizableReference.class, referenceQueue, phantomReference);
        } catch (IllegalAccessException e2) {
            throw new AssertionError(e2);
        } catch (Throwable th) {
            d.log(Level.INFO, "Failed to start reference finalizer thread. Reference cleanup will only occur when new references are created.", th);
            z = false;
        }
        this.c = z;
    }

    public void a() {
        if (!this.c) {
            while (true) {
                Reference<? extends Object> poll = this.a.poll();
                if (poll != null) {
                    poll.clear();
                    try {
                        ((FinalizableReference) poll).finalizeReferent();
                    } catch (Throwable th) {
                        d.log(Level.SEVERE, "Error cleaning up after reference.", th);
                    }
                } else {
                    return;
                }
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.b.enqueue();
        a();
    }
}
