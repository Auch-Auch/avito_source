package com.avito.android.search.map.utils;

import android.view.View;
import com.avito.android.remote.auth.AuthSource;
import com.google.android.material.snackbar.Snackbar;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.PublishSubject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0000¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/search/map/utils/SnackBarCallbackObservable;", "Lcom/google/android/material/snackbar/Snackbar$Callback;", "Landroid/view/View$OnClickListener;", "Lcom/google/android/material/snackbar/Snackbar;", "transientBottomBar", "", "event", "", "onDismissed", "(Lcom/google/android/material/snackbar/Snackbar;I)V", "Landroid/view/View;", VKApiConst.VERSION, "onClick", "(Landroid/view/View;)V", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/search/map/utils/SnackBarCallbackType;", "callbackObservable$map_release", "()Lio/reactivex/rxjava3/core/Observable;", "callbackObservable", "Lio/reactivex/rxjava3/subjects/PublishSubject;", AuthSource.SEND_ABUSE, "Lio/reactivex/rxjava3/subjects/PublishSubject;", "subject", "<init>", "()V", "map_release"}, k = 1, mv = {1, 4, 2})
public final class SnackBarCallbackObservable extends Snackbar.Callback implements View.OnClickListener {
    public final PublishSubject<SnackBarCallbackType> a;

    public SnackBarCallbackObservable() {
        PublishSubject<SnackBarCallbackType> create = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishSubject.create()");
        this.a = create;
    }

    @NotNull
    public final Observable<SnackBarCallbackType> callbackObservable$map_release() {
        return this.a;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View view) {
        this.a.onNext(SnackBarCallbackType.ACTION_CLICK);
    }

    @Override // com.google.android.material.snackbar.Snackbar.Callback
    public void onDismissed(@Nullable Snackbar snackbar, int i) {
        super.onDismissed(snackbar, i);
        this.a.onNext(SnackBarCallbackType.CLOSE);
    }
}
