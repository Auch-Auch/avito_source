package com.facebook.imagepipeline.core;

import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.common.references.SharedReference;
import com.facebook.imagepipeline.debug.CloseableReferenceLeakTracker;
import java.io.Closeable;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.annotation.Nullable;
public class CloseableReferenceFactory {
    public final CloseableReference.LeakHandler a;

    public class a implements CloseableReference.LeakHandler {
        public final /* synthetic */ CloseableReferenceLeakTracker a;

        public a(CloseableReferenceFactory closeableReferenceFactory, CloseableReferenceLeakTracker closeableReferenceLeakTracker) {
            this.a = closeableReferenceLeakTracker;
        }

        /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0044: APUT  (r0v2 java.lang.Object[]), (3 ??[int, float, short, byte, char]), (r4v4 java.lang.String) */
        @Override // com.facebook.common.references.CloseableReference.LeakHandler
        public void reportLeak(SharedReference<Object> sharedReference, @Nullable Throwable th) {
            String str;
            this.a.trackCloseableReferenceLeak(sharedReference, th);
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(System.identityHashCode(this));
            objArr[1] = Integer.valueOf(System.identityHashCode(sharedReference));
            objArr[2] = sharedReference.get().getClass().getName();
            if (th == null) {
                str = "";
            } else {
                StringWriter stringWriter = new StringWriter();
                th.printStackTrace(new PrintWriter(stringWriter));
                str = stringWriter.toString();
            }
            objArr[3] = str;
            FLog.w("Fresco", "Finalized without closing: %x %x (type = %s).\nStack:\n%s", objArr);
        }

        @Override // com.facebook.common.references.CloseableReference.LeakHandler
        public boolean requiresStacktrace() {
            return this.a.isSet();
        }
    }

    public CloseableReferenceFactory(CloseableReferenceLeakTracker closeableReferenceLeakTracker) {
        this.a = new a(this, closeableReferenceLeakTracker);
    }

    public <U extends Closeable> CloseableReference<U> create(U u) {
        return CloseableReference.of(u, this.a);
    }

    public <T> CloseableReference<T> create(T t, ResourceReleaser<T> resourceReleaser) {
        return CloseableReference.of(t, resourceReleaser, this.a);
    }
}
