package com.avito.android.util.rx;

import io.reactivex.disposables.Disposable;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"com/avito/android/util/rx/SchedulersKt$singleThreadSchedulerWithAutoShutdown$disposable$1", "Lio/reactivex/disposables/Disposable;", "", "isDisposed", "()Z", "", "dispose", "()V", "rx"}, k = 1, mv = {1, 4, 2})
public final class SchedulersKt$singleThreadSchedulerWithAutoShutdown$disposable$1 implements Disposable {
    public final /* synthetic */ ThreadPoolExecutor a;

    public SchedulersKt$singleThreadSchedulerWithAutoShutdown$disposable$1(ThreadPoolExecutor threadPoolExecutor) {
        this.a = threadPoolExecutor;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.a.shutdown();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.a.isShutdown();
    }
}
