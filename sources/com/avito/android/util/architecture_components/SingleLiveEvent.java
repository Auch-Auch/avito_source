package com.avito.android.util.architecture_components;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.avito.android.util.UrlParams;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\t\b\u0007¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "T", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/lifecycle/LifecycleOwner;", UrlParams.OWNER, "Landroidx/lifecycle/Observer;", "observer", "", "observe", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Observer;)V", "t", "setValue", "(Ljava/lang/Object;)V", "Ljava/util/concurrent/atomic/AtomicBoolean;", "l", "Ljava/util/concurrent/atomic/AtomicBoolean;", "pending", "<init>", "()V", "android_release"}, k = 1, mv = {1, 4, 2})
public final class SingleLiveEvent<T> extends MutableLiveData<T> {
    public AtomicBoolean l = new AtomicBoolean(false);

    public static final class a<T> implements Observer<T> {
        public final /* synthetic */ SingleLiveEvent a;
        public final /* synthetic */ Observer b;

        public a(SingleLiveEvent singleLiveEvent, Observer observer) {
            this.a = singleLiveEvent;
            this.b = observer;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t) {
            if (this.a.l.compareAndSet(true, false)) {
                this.b.onChanged(t);
            }
        }
    }

    @Override // androidx.lifecycle.LiveData
    public void observe(@NotNull LifecycleOwner lifecycleOwner, @NotNull Observer<? super T> observer) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, UrlParams.OWNER);
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (!hasActiveObservers()) {
            super.observe(lifecycleOwner, new a(this, observer));
            return;
        }
        throw new IllegalStateException("Multiple observers registered but only one will be notified of changes.");
    }

    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public void setValue(T t) {
        this.l.set(true);
        super.setValue(t);
    }
}
