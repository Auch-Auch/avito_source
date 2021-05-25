package com.jakewharton.rxbinding4.widget;

import android.view.View;
import android.widget.Toolbar;
import androidx.annotation.RequiresApi;
import com.avito.android.remote.auth.AuthSource;
import com.jakewharton.rxbinding4.internal.Preconditions;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.android.MainThreadDisposable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\bB\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0005\u001a\u00020\u00022\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\u0003H\u0014¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/jakewharton/rxbinding4/widget/ToolbarNavigationClickObservable;", "Lio/reactivex/rxjava3/core/Observable;", "", "Lio/reactivex/rxjava3/core/Observer;", "observer", "subscribeActual", "(Lio/reactivex/rxjava3/core/Observer;)V", "Landroid/widget/Toolbar;", AuthSource.SEND_ABUSE, "Landroid/widget/Toolbar;", "view", "<init>", "(Landroid/widget/Toolbar;)V", "rxbinding_release"}, k = 1, mv = {1, 4, 0})
@RequiresApi(21)
public final class ToolbarNavigationClickObservable extends Observable<Unit> {
    public final Toolbar a;

    public static final class a extends MainThreadDisposable implements View.OnClickListener {
        public final Toolbar b;
        public final Observer<? super Unit> c;

        public a(@NotNull Toolbar toolbar, @NotNull Observer<? super Unit> observer) {
            Intrinsics.checkParameterIsNotNull(toolbar, "view");
            Intrinsics.checkParameterIsNotNull(observer, "observer");
            this.b = toolbar;
            this.c = observer;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(@NotNull View view) {
            Intrinsics.checkParameterIsNotNull(view, VKApiConst.VERSION);
            if (!isDisposed()) {
                this.c.onNext(Unit.INSTANCE);
            }
        }

        @Override // io.reactivex.rxjava3.android.MainThreadDisposable
        public void onDispose() {
            this.b.setNavigationOnClickListener(null);
        }
    }

    public ToolbarNavigationClickObservable(@NotNull Toolbar toolbar) {
        Intrinsics.checkParameterIsNotNull(toolbar, "view");
        this.a = toolbar;
    }

    @Override // io.reactivex.rxjava3.core.Observable
    public void subscribeActual(@NotNull Observer<? super Unit> observer) {
        Intrinsics.checkParameterIsNotNull(observer, "observer");
        if (Preconditions.checkMainThread(observer)) {
            a aVar = new a(this.a, observer);
            observer.onSubscribe(aVar);
            this.a.setNavigationOnClickListener(aVar);
        }
    }
}
