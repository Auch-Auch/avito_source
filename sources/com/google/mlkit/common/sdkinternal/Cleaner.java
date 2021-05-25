package com.google.mlkit.common.sdkinternal;

import a2.j.h.a.c.c;
import a2.j.h.a.c.d;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.mlkit.common.sdkinternal.Cleaner;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
public class Cleaner {
    public final ReferenceQueue<Object> a = new ReferenceQueue<>();
    public final Set<a> b = Collections.synchronizedSet(new HashSet());

    public interface Cleanable {
        @KeepForSdk
        void clean();
    }

    public static class a extends PhantomReference<Object> implements Cleanable {
        public final Set<a> a;
        public final Runnable b;

        public a(Object obj, ReferenceQueue referenceQueue, Set set, Runnable runnable, d dVar) {
            super(obj, referenceQueue);
            this.a = set;
            this.b = runnable;
        }

        @Override // com.google.mlkit.common.sdkinternal.Cleaner.Cleanable
        public final void clean() {
            if (this.a.remove(this)) {
                clear();
                this.b.run();
            }
        }
    }

    @KeepForSdk
    public static Cleaner create() {
        Cleaner cleaner = new Cleaner();
        cleaner.register(cleaner, c.a);
        Thread thread = new Thread(new Runnable(cleaner.a, cleaner.b) { // from class: a2.j.h.a.c.b
            public final ReferenceQueue a;
            public final Set b;

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                ReferenceQueue referenceQueue = this.a;
                Set set = this.b;
                while (!set.isEmpty()) {
                    try {
                        Cleaner.a aVar = (Cleaner.a) referenceQueue.remove();
                        if (aVar.a.remove(aVar)) {
                            aVar.clear();
                            aVar.b.run();
                        }
                    } catch (InterruptedException unused) {
                    }
                }
            }
        }, "MlKitCleaner");
        thread.setDaemon(true);
        thread.start();
        return cleaner;
    }

    @KeepForSdk
    public Cleanable register(Object obj, Runnable runnable) {
        a aVar = new a(obj, this.a, this.b, runnable, null);
        this.b.add(aVar);
        return aVar;
    }
}
