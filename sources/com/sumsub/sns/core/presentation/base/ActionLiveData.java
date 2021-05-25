package com.sumsub.sns.core.presentation.base;

import androidx.annotation.MainThread;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.avito.android.util.UrlParams;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u0014*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0001\u0014B\u0007¢\u0006\u0004\b\u0013\u0010\u000eJ'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u000b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00018\u0000H\u0017¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/sumsub/sns/core/presentation/base/ActionLiveData;", "T", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/lifecycle/LifecycleOwner;", UrlParams.OWNER, "Landroidx/lifecycle/Observer;", "observer", "", "observe", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Observer;)V", "t", "setValue", "(Ljava/lang/Object;)V", "call", "()V", "Ljava/util/concurrent/atomic/AtomicBoolean;", "l", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mPending", "<init>", "Companion", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public final class ActionLiveData<T> extends MutableLiveData<T> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final String m = "ActionLiveData";
    public final AtomicBoolean l = new AtomicBoolean(false);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002XD¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/sumsub/sns/core/presentation/base/ActionLiveData$Companion;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a<T> implements Observer<T> {
        public final /* synthetic */ ActionLiveData a;
        public final /* synthetic */ Observer b;

        public a(ActionLiveData actionLiveData, Observer observer) {
            this.a = actionLiveData;
            this.b = observer;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t) {
            if (this.a.l.compareAndSet(true, false)) {
                this.b.onChanged(t);
            }
        }
    }

    @MainThread
    public final void call() {
        setValue(null);
    }

    @Override // androidx.lifecycle.LiveData
    public void observe(@NotNull LifecycleOwner lifecycleOwner, @NotNull Observer<? super T> observer) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, UrlParams.OWNER);
        Intrinsics.checkNotNullParameter(observer, "observer");
        hasActiveObservers();
        super.observe(lifecycleOwner, new a(this, observer));
    }

    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    @MainThread
    public void setValue(@Nullable T t) {
        this.l.set(true);
        super.setValue(t);
    }
}
