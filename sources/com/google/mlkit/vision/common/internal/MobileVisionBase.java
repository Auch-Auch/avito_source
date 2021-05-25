package com.google.mlkit.vision.common.internal;

import a2.j.h.b.a.a.a;
import a2.j.h.b.a.a.b;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.MLTask;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.common.internal.MobileVisionBase;
import java.io.Closeable;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
@KeepForSdk
public class MobileVisionBase<DetectionResultT> implements LifecycleObserver, Closeable {
    public static final GmsLogger e = new GmsLogger("MobileVisionBase", "");
    public final AtomicBoolean a = new AtomicBoolean(false);
    public final MLTask<DetectionResultT, InputImage> b;
    public final CancellationTokenSource c;
    public final Executor d;

    @KeepForSdk
    public MobileVisionBase(@NonNull MLTask<DetectionResultT, InputImage> mLTask, @NonNull Executor executor) {
        this.b = mLTask;
        CancellationTokenSource cancellationTokenSource = new CancellationTokenSource();
        this.c = cancellationTokenSource;
        this.d = executor;
        mLTask.pin();
        mLTask.callAfterLoad(executor, b.a, cancellationTokenSource.getToken()).addOnFailureListener(a.a);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public synchronized void close() {
        if (!this.a.getAndSet(true)) {
            this.c.cancel();
            this.b.unpin(this.d);
        }
    }

    @KeepForSdk
    public synchronized Task<DetectionResultT> processBase(@NonNull InputImage inputImage) {
        Preconditions.checkNotNull(inputImage, "InputImage can not be null");
        if (this.a.get()) {
            return Tasks.forException(new MlKitException("This detector is already closed!", 14));
        } else if (inputImage.getWidth() < 32 || inputImage.getHeight() < 32) {
            return Tasks.forException(new MlKitException("InputImage width and height should be at least 32!", 3));
        } else {
            return this.b.callAfterLoad(this.d, new Callable(this, inputImage) { // from class: a2.j.h.b.a.a.c
                public final MobileVisionBase a;
                public final InputImage b;

                {
                    this.a = r1;
                    this.b = r2;
                }

                @Override // java.util.concurrent.Callable
                public final Object call() {
                    MobileVisionBase mobileVisionBase = this.a;
                    return mobileVisionBase.b.run(this.b);
                }
            }, this.c.getToken());
        }
    }
}
