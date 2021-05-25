package com.avito.android.util;

import a2.a.a.n3.k;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.model.VKApiUserFull;
import io.reactivex.ObservableOperator;
import io.reactivex.Observer;
import io.reactivex.observers.DisposableObserver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\u0002:\u0001\bB\u000f\u0012\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0005\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0019\u0010\f\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/avito/android/util/InitializeOperator;", "T", "Lio/reactivex/ObservableOperator;", "Lio/reactivex/Observer;", VKApiUserFull.RelativeType.CHILD, "apply", "(Lio/reactivex/Observer;)Lio/reactivex/Observer;", "Lcom/avito/android/util/Initializable;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/Initializable;", "getInitializable", "()Lcom/avito/android/util/Initializable;", "initializable", "<init>", "(Lcom/avito/android/util/Initializable;)V", "analytics-core_release"}, k = 1, mv = {1, 4, 2})
public final class InitializeOperator<T> implements ObservableOperator<T, T> {
    @NotNull
    public final Initializable a;

    public static final class a<T> extends DisposableObserver<T> {
        public List<T> b = Collections.synchronizedList(new ArrayList());
        @NotNull
        public final Observer<T> c;
        @NotNull
        public final Initializable d;

        public a(@NotNull Observer<T> observer, @NotNull Initializable initializable) {
            Intrinsics.checkNotNullParameter(observer, VKApiUserFull.RelativeType.CHILD);
            Intrinsics.checkNotNullParameter(initializable, "initializable");
            this.c = observer;
            this.d = initializable;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.c.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(@NotNull Throwable th) {
            Intrinsics.checkNotNullParameter(th, "e");
            this.c.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            if (this.d.isInitialized()) {
                this.c.onNext(t);
                return;
            }
            List<T> list = this.b;
            if (list != null) {
                list.add(t);
            }
            this.d.initialize(new k(this));
        }

        @Override // io.reactivex.observers.DisposableObserver
        public void onStart() {
            this.c.onSubscribe(this);
        }
    }

    public InitializeOperator(@NotNull Initializable initializable) {
        Intrinsics.checkNotNullParameter(initializable, "initializable");
        this.a = initializable;
    }

    @Override // io.reactivex.ObservableOperator
    @NotNull
    public Observer<? super T> apply(@NotNull Observer<? super T> observer) {
        Intrinsics.checkNotNullParameter(observer, VKApiUserFull.RelativeType.CHILD);
        return new a(observer, this.a);
    }

    @NotNull
    public final Initializable getInitializable() {
        return this.a;
    }
}
