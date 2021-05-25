package com.google.android.exoplayer2.upstream;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
public final class Loader implements LoaderErrorThrower {
    public static final LoadErrorAction DONT_RETRY = new LoadErrorAction(2, C.TIME_UNSET, null);
    public static final LoadErrorAction DONT_RETRY_FATAL = new LoadErrorAction(3, C.TIME_UNSET, null);
    public static final LoadErrorAction RETRY = createRetryAction(false, C.TIME_UNSET);
    public static final LoadErrorAction RETRY_RESET_ERROR_COUNT = createRetryAction(true, C.TIME_UNSET);
    public final ExecutorService a;
    @Nullable
    public b<? extends Loadable> b;
    @Nullable
    public IOException c;

    public interface Callback<T extends Loadable> {
        void onLoadCanceled(T t, long j, long j2, boolean z);

        void onLoadCompleted(T t, long j, long j2);

        LoadErrorAction onLoadError(T t, long j, long j2, IOException iOException, int i);
    }

    public static final class LoadErrorAction {
        public final int a;
        public final long b;

        public LoadErrorAction(int i, long j, a aVar) {
            this.a = i;
            this.b = j;
        }

        public boolean isRetry() {
            int i = this.a;
            return i == 0 || i == 1;
        }
    }

    public interface Loadable {
        void cancelLoad();

        void load() throws IOException;
    }

    public interface ReleaseCallback {
        void onLoaderReleased();
    }

    public static final class UnexpectedLoaderException extends IOException {
        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public UnexpectedLoaderException(java.lang.Throwable r3) {
            /*
                r2 = this;
                java.lang.String r0 = "Unexpected "
                java.lang.StringBuilder r0 = a2.b.a.a.a.L(r0)
                java.lang.Class r1 = r3.getClass()
                java.lang.String r1 = r1.getSimpleName()
                r0.append(r1)
                java.lang.String r1 = ": "
                r0.append(r1)
                java.lang.String r1 = r3.getMessage()
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                r2.<init>(r0, r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.upstream.Loader.UnexpectedLoaderException.<init>(java.lang.Throwable):void");
        }
    }

    @SuppressLint({"HandlerLeak"})
    public final class b<T extends Loadable> extends Handler implements Runnable {
        public final int a;
        public final T b;
        public final long c;
        @Nullable
        public Callback<T> d;
        @Nullable
        public IOException e;
        public int f;
        @Nullable
        public Thread g;
        public boolean h;
        public volatile boolean i;

        public b(Looper looper, T t, Callback<T> callback, int i2, long j2) {
            super(looper);
            this.b = t;
            this.d = callback;
            this.a = i2;
            this.c = j2;
        }

        public void a(boolean z) {
            this.i = z;
            this.e = null;
            if (hasMessages(0)) {
                this.h = true;
                removeMessages(0);
                if (!z) {
                    sendEmptyMessage(1);
                }
            } else {
                synchronized (this) {
                    this.h = true;
                    this.b.cancelLoad();
                    Thread thread = this.g;
                    if (thread != null) {
                        thread.interrupt();
                    }
                }
            }
            if (z) {
                Loader.this.b = null;
                long elapsedRealtime = SystemClock.elapsedRealtime();
                ((Callback) Assertions.checkNotNull(this.d)).onLoadCanceled(this.b, elapsedRealtime, elapsedRealtime - this.c, true);
                this.d = null;
            }
        }

        public void b(long j2) {
            Assertions.checkState(Loader.this.b == null);
            Loader loader = Loader.this;
            loader.b = this;
            if (j2 > 0) {
                sendEmptyMessageDelayed(0, j2);
                return;
            }
            this.e = null;
            loader.a.execute((Runnable) Assertions.checkNotNull(this));
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (!this.i) {
                int i2 = message.what;
                if (i2 == 0) {
                    this.e = null;
                    Loader loader = Loader.this;
                    loader.a.execute((Runnable) Assertions.checkNotNull(loader.b));
                } else if (i2 != 3) {
                    Loader.this.b = null;
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    long j2 = elapsedRealtime - this.c;
                    Callback callback = (Callback) Assertions.checkNotNull(this.d);
                    if (this.h) {
                        callback.onLoadCanceled(this.b, elapsedRealtime, j2, false);
                        return;
                    }
                    int i3 = message.what;
                    if (i3 == 1) {
                        try {
                            callback.onLoadCompleted(this.b, elapsedRealtime, j2);
                        } catch (RuntimeException e2) {
                            Log.e("LoadTask", "Unexpected exception handling load completed", e2);
                            Loader.this.c = new UnexpectedLoaderException(e2);
                        }
                    } else if (i3 == 2) {
                        IOException iOException = (IOException) message.obj;
                        this.e = iOException;
                        int i4 = this.f + 1;
                        this.f = i4;
                        LoadErrorAction onLoadError = callback.onLoadError(this.b, elapsedRealtime, j2, iOException, i4);
                        int i5 = onLoadError.a;
                        if (i5 == 3) {
                            Loader.this.c = this.e;
                        } else if (i5 != 2) {
                            if (i5 == 1) {
                                this.f = 1;
                            }
                            long j3 = onLoadError.b;
                            if (j3 == C.TIME_UNSET) {
                                j3 = (long) Math.min((this.f - 1) * 1000, 5000);
                            }
                            b(j3);
                        }
                    }
                } else {
                    throw ((Error) message.obj);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            try {
                synchronized (this) {
                    z = !this.h;
                    this.g = Thread.currentThread();
                }
                if (z) {
                    TraceUtil.beginSection("load:" + this.b.getClass().getSimpleName());
                    try {
                        this.b.load();
                    } finally {
                        TraceUtil.endSection();
                    }
                }
                synchronized (this) {
                    this.g = null;
                    Thread.interrupted();
                }
                if (!this.i) {
                    sendEmptyMessage(1);
                }
            } catch (IOException e2) {
                if (!this.i) {
                    obtainMessage(2, e2).sendToTarget();
                }
            } catch (Exception e3) {
                Log.e("LoadTask", "Unexpected exception loading stream", e3);
                if (!this.i) {
                    obtainMessage(2, new UnexpectedLoaderException(e3)).sendToTarget();
                }
            } catch (OutOfMemoryError e4) {
                Log.e("LoadTask", "OutOfMemory error loading stream", e4);
                if (!this.i) {
                    obtainMessage(2, new UnexpectedLoaderException(e4)).sendToTarget();
                }
            } catch (Error e5) {
                Log.e("LoadTask", "Unexpected error loading stream", e5);
                if (!this.i) {
                    obtainMessage(3, e5).sendToTarget();
                }
                throw e5;
            }
        }
    }

    public static final class c implements Runnable {
        public final ReleaseCallback a;

        public c(ReleaseCallback releaseCallback) {
            this.a = releaseCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.onLoaderReleased();
        }
    }

    public Loader(String str) {
        this.a = Util.newSingleThreadExecutor(str);
    }

    public static LoadErrorAction createRetryAction(boolean z, long j) {
        return new LoadErrorAction(z ? 1 : 0, j, null);
    }

    public void cancelLoading() {
        ((b) Assertions.checkStateNotNull(this.b)).a(false);
    }

    public void clearFatalError() {
        this.c = null;
    }

    public boolean hasFatalError() {
        return this.c != null;
    }

    public boolean isLoading() {
        return this.b != null;
    }

    @Override // com.google.android.exoplayer2.upstream.LoaderErrorThrower
    public void maybeThrowError() throws IOException {
        maybeThrowError(Integer.MIN_VALUE);
    }

    public void release() {
        release(null);
    }

    public <T extends Loadable> long startLoading(T t, Callback<T> callback, int i) {
        this.c = null;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        new b((Looper) Assertions.checkStateNotNull(Looper.myLooper()), t, callback, i, elapsedRealtime).b(0);
        return elapsedRealtime;
    }

    @Override // com.google.android.exoplayer2.upstream.LoaderErrorThrower
    public void maybeThrowError(int i) throws IOException {
        IOException iOException = this.c;
        if (iOException == null) {
            b<? extends Loadable> bVar = this.b;
            if (bVar != null) {
                if (i == Integer.MIN_VALUE) {
                    i = bVar.a;
                }
                IOException iOException2 = bVar.e;
                if (iOException2 != null && bVar.f > i) {
                    throw iOException2;
                }
                return;
            }
            return;
        }
        throw iOException;
    }

    public void release(@Nullable ReleaseCallback releaseCallback) {
        b<? extends Loadable> bVar = this.b;
        if (bVar != null) {
            bVar.a(true);
        }
        if (releaseCallback != null) {
            this.a.execute(new c(releaseCallback));
        }
        this.a.shutdown();
    }
}
