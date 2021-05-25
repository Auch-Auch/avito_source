package com.avito.android.async_phone;

import android.view.View;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.Snackbars;
import com.avito.android.util.Views;
import com.google.android.material.snackbar.Snackbar;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.subjects.PublishSubject;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\nR\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/avito/android/async_phone/AsyncPhoneViewImpl;", "Lcom/avito/android/async_phone/AsyncPhoneView;", "Lio/reactivex/rxjava3/core/Observable;", "", "showPhoneLoadError", "()Lio/reactivex/rxjava3/core/Observable;", "dismissPhoneLoadError", "()V", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "errorMessage", "Landroid/view/View;", "d", "Landroid/view/View;", "view", AuthSource.BOOKING_ORDER, "errorAction", "Lcom/google/android/material/snackbar/Snackbar;", "c", "Lcom/google/android/material/snackbar/Snackbar;", "snackbar", "<init>", "(Landroid/view/View;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class AsyncPhoneViewImpl implements AsyncPhoneView {
    public final String a;
    public final String b;
    public Snackbar c;
    public final View d;

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, Object obj) {
            super(0);
            this.a = i;
            this.b = obj;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            int i = this.a;
            if (i == 0) {
                Unit unit = Unit.INSTANCE;
                ((PublishSubject) this.b).onNext(unit);
                return unit;
            } else if (i == 1) {
                ((PublishSubject) this.b).onComplete();
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    public static final class b<T> implements Consumer<Unit> {
        public final /* synthetic */ AsyncPhoneViewImpl a;

        public b(AsyncPhoneViewImpl asyncPhoneViewImpl) {
            this.a = asyncPhoneViewImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Unit unit) {
            this.a.dismissPhoneLoadError();
        }
    }

    public static final class c implements Action {
        public final /* synthetic */ AsyncPhoneViewImpl a;

        public c(AsyncPhoneViewImpl asyncPhoneViewImpl) {
            this.a = asyncPhoneViewImpl;
        }

        @Override // io.reactivex.rxjava3.functions.Action
        public final void run() {
            this.a.dismissPhoneLoadError();
        }
    }

    public AsyncPhoneViewImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.d = view;
        String string = view.getResources().getString(R.string.something_went_wrong);
        Intrinsics.checkNotNullExpressionValue(string, "view.resources.getString…ing.something_went_wrong)");
        this.a = string;
        String string2 = view.getResources().getString(R.string.try_again);
        Intrinsics.checkNotNullExpressionValue(string2, "view.resources.getString(ui_R.string.try_again)");
        this.b = string2;
    }

    @Override // com.avito.android.async_phone.AsyncPhoneView
    public void dismissPhoneLoadError() {
        Snackbar snackbar = this.c;
        if (snackbar != null) {
            snackbar.dismiss();
        }
        this.c = null;
    }

    @Override // com.avito.android.async_phone.AsyncPhoneView
    @NotNull
    public Observable<Unit> showPhoneLoadError() {
        PublishSubject create = PublishSubject.create();
        Snackbar showSnackBar$default = Views.showSnackBar$default(this.d, this.a, 0, this.b, 0, new a(0, create), new a(1, create), 0, 72, (Object) null);
        Snackbars.initButton(showSnackBar$default);
        Snackbars.getTextView(showSnackBar$default).setMaxLines(2);
        this.c = showSnackBar$default;
        Observable<Unit> doOnDispose = create.throttleFirst(500, TimeUnit.MILLISECONDS).doOnNext(new b(this)).doOnDispose(new c(this));
        Intrinsics.checkNotNullExpressionValue(doOnDispose, "retrySubject\n           …dismissPhoneLoadError() }");
        return doOnDispose;
    }
}
