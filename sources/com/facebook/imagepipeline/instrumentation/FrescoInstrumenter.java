package com.facebook.imagepipeline.instrumentation;

import androidx.annotation.Nullable;
public final class FrescoInstrumenter {
    @Nullable
    public static volatile Instrumenter a;

    public interface Instrumenter {
        @Nullable
        Runnable decorateRunnable(Runnable runnable, String str);

        boolean isTracing();

        void markFailure(Object obj, Throwable th);

        @Nullable
        Object onBeforeSubmitWork(String str);

        @Nullable
        Object onBeginWork(Object obj, @Nullable String str);

        @Nullable
        void onEndWork(Object obj);
    }

    @Nullable
    public static Runnable decorateRunnable(@Nullable Runnable runnable, @Nullable String str) {
        Instrumenter instrumenter = a;
        return (instrumenter == null || runnable == null || str == null) ? runnable : instrumenter.decorateRunnable(runnable, str);
    }

    public static boolean isTracing() {
        Instrumenter instrumenter = a;
        if (instrumenter == null) {
            return false;
        }
        return instrumenter.isTracing();
    }

    public static void markFailure(@Nullable Object obj, Throwable th) {
        Instrumenter instrumenter = a;
        if (instrumenter != null && obj != null) {
            instrumenter.markFailure(obj, th);
        }
    }

    @Nullable
    public static Object onBeforeSubmitWork(@Nullable String str) {
        Instrumenter instrumenter = a;
        if (instrumenter == null || str == null) {
            return null;
        }
        return instrumenter.onBeforeSubmitWork(str);
    }

    @Nullable
    public static Object onBeginWork(@Nullable Object obj, @Nullable String str) {
        Instrumenter instrumenter = a;
        if (instrumenter == null || obj == null) {
            return null;
        }
        return instrumenter.onBeginWork(obj, str);
    }

    public static void onEndWork(@Nullable Object obj) {
        Instrumenter instrumenter = a;
        if (instrumenter != null && obj != null) {
            instrumenter.onEndWork(obj);
        }
    }

    public static void provide(@Nullable Instrumenter instrumenter) {
        a = instrumenter;
    }
}
