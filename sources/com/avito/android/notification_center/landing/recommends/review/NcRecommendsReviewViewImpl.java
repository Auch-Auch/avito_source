package com.avito.android.notification_center.landing.recommends.review;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import com.avito.android.advert_core.analytics.contactbar.PhonePageSourceKt;
import com.avito.android.notification_center.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.Keyboards;
import com.avito.android.util.ToastsKt;
import com.avito.android.util.rx3.InteropKt;
import com.jakewharton.rxbinding3.appcompat.RxToolbar;
import com.jakewharton.rxbinding3.view.RxMenuItem;
import com.jakewharton.rxrelay2.PublishRelay;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.text_input.EditTextAreaImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u00102\u001a\u000201\u0012\u0006\u00100\u001a\u00020-¢\u0006\u0004\b3\u00104J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\tJ\u000f\u0010\u0010\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0004J\u000f\u0010\u0011\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0004J\u0015\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0014J\u0015\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012H\u0016¢\u0006\u0004\b\u0016\u0010\u0014J\u0015\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012H\u0016¢\u0006\u0004\b\u0017\u0010\u0014R:\u0010\u001c\u001a&\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u00020\u0002 \u0019*\u0012\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00180\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/¨\u00065"}, d2 = {"Lcom/avito/android/notification_center/landing/recommends/review/NcRecommendsReviewViewImpl;", "Lcom/avito/android/notification_center/landing/recommends/review/NcRecommendsReviewView;", "", "enableButton", "()V", "disableButton", "", "hint", "showHint", "(Ljava/lang/String;)V", "", "text", "showText", "(Ljava/lang/CharSequence;)V", "message", "showMessage", "showProgressDialog", "hideProgressDialog", "Lio/reactivex/Observable;", "getTextChangeCallback", "()Lio/reactivex/Observable;", "getSaveButtonClicks", "getCancelDialogCallback", "getBackButtonClicks", "Lcom/jakewharton/rxrelay2/PublishRelay;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay2/PublishRelay;", "dialogRelay", "Landroidx/appcompat/widget/Toolbar;", "d", "Landroidx/appcompat/widget/Toolbar;", "toolbar", "Landroid/view/MenuItem;", AuthSource.BOOKING_ORDER, "Landroid/view/MenuItem;", PhonePageSourceKt.PHONE_SOURCE_BUTTON, "Lru/avito/component/text_input/EditTextAreaImpl;", "c", "Lru/avito/component/text_input/EditTextAreaImpl;", "editText", "Landroid/app/Dialog;", "e", "Landroid/app/Dialog;", "dialog", "Lcom/avito/android/util/DialogRouter;", "f", "Lcom/avito/android/util/DialogRouter;", "dialogRouter", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;Lcom/avito/android/util/DialogRouter;)V", "notification-center_release"}, k = 1, mv = {1, 4, 2})
public final class NcRecommendsReviewViewImpl implements NcRecommendsReviewView {
    public final PublishRelay<Unit> a = PublishRelay.create();
    public final MenuItem b;
    public final EditTextAreaImpl c;
    public final Toolbar d;
    public Dialog e;
    public final DialogRouter f;

    public static final class a<T> implements Consumer<Unit> {
        public final /* synthetic */ NcRecommendsReviewViewImpl a;

        public a(NcRecommendsReviewViewImpl ncRecommendsReviewViewImpl) {
            this.a = ncRecommendsReviewViewImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Unit unit) {
            Keyboards.hideKeyboard$default(this.a.d, false, 1, null);
        }
    }

    public static final class b<T> implements Consumer<Unit> {
        public final /* synthetic */ NcRecommendsReviewViewImpl a;

        public b(NcRecommendsReviewViewImpl ncRecommendsReviewViewImpl) {
            this.a = ncRecommendsReviewViewImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Unit unit) {
            Keyboards.hideKeyboard$default(this.a.d, false, 1, null);
        }
    }

    public static final class c implements DialogInterface.OnCancelListener {
        public final /* synthetic */ NcRecommendsReviewViewImpl a;
        public final /* synthetic */ Dialog b;

        public c(NcRecommendsReviewViewImpl ncRecommendsReviewViewImpl, Dialog dialog) {
            this.a = ncRecommendsReviewViewImpl;
            this.b = dialog;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface dialogInterface) {
            this.b.setOnCancelListener(null);
            this.a.a.accept(Unit.INSTANCE);
            this.a.e = null;
        }
    }

    public NcRecommendsReviewViewImpl(@NotNull View view, @NotNull DialogRouter dialogRouter) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(dialogRouter, "dialogRouter");
        this.f = dialogRouter;
        View findViewById = view.findViewById(R.id.edit_text);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        this.c = new EditTextAreaImpl(findViewById);
        View findViewById2 = view.findViewById(com.avito.android.deprecated_design.R.id.toolbar);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
        Toolbar toolbar = (Toolbar) findViewById2;
        this.d = toolbar;
        toolbar.setNavigationIcon(com.avito.android.ui_components.R.drawable.ic_back_24_blue);
        toolbar.setTitle(com.avito.android.ui_components.R.string.nc_recommends_review_title);
        toolbar.inflateMenu(com.avito.android.ui_components.R.menu.send);
        MenuItem findItem = toolbar.getMenu().findItem(com.avito.android.ui_components.R.id.send);
        Intrinsics.checkNotNullExpressionValue(findItem, "toolbar.menu.findItem(ui_R.id.send)");
        this.b = findItem;
    }

    @Override // com.avito.android.notification_center.landing.recommends.review.NcRecommendsReviewView
    public void disableButton() {
        this.b.setEnabled(false);
    }

    @Override // com.avito.android.notification_center.landing.recommends.review.NcRecommendsReviewView
    public void enableButton() {
        this.b.setEnabled(true);
    }

    @Override // com.avito.android.notification_center.landing.recommends.review.NcRecommendsReviewView
    @NotNull
    public Observable<Unit> getBackButtonClicks() {
        Observable<Unit> doOnNext = RxToolbar.navigationClicks(this.d).doOnNext(new a(this));
        Intrinsics.checkNotNullExpressionValue(doOnNext, "toolbar.navigationClicks… toolbar.hideKeyboard() }");
        return doOnNext;
    }

    @Override // com.avito.android.notification_center.landing.recommends.review.NcRecommendsReviewView
    @NotNull
    public Observable<Unit> getCancelDialogCallback() {
        PublishRelay<Unit> publishRelay = this.a;
        Intrinsics.checkNotNullExpressionValue(publishRelay, "dialogRelay");
        return publishRelay;
    }

    @Override // com.avito.android.notification_center.landing.recommends.review.NcRecommendsReviewView
    @NotNull
    public Observable<Unit> getSaveButtonClicks() {
        Observable<Unit> doOnNext = RxMenuItem.clicks$default(this.b, null, 1, null).doOnNext(new b(this));
        Intrinsics.checkNotNullExpressionValue(doOnNext, "button.clicks()\n        … toolbar.hideKeyboard() }");
        return doOnNext;
    }

    @Override // com.avito.android.notification_center.landing.recommends.review.NcRecommendsReviewView
    @NotNull
    public Observable<String> getTextChangeCallback() {
        return InteropKt.toV2(this.c.textChangeCallbacks());
    }

    @Override // com.avito.android.notification_center.landing.recommends.review.NcRecommendsReviewView
    public void hideProgressDialog() {
        Dialog dialog = this.e;
        if (dialog != null) {
            dialog.setOnCancelListener(null);
            dialog.dismiss();
            this.e = null;
        }
    }

    @Override // com.avito.android.notification_center.landing.recommends.review.NcRecommendsReviewView
    public void showHint(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "hint");
        this.c.setHint((CharSequence) str);
    }

    @Override // com.avito.android.notification_center.landing.recommends.review.NcRecommendsReviewView
    public void showMessage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        Context context = this.d.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "toolbar.context");
        ToastsKt.showToast$default(context, str, 0, 2, (Object) null);
    }

    @Override // com.avito.android.notification_center.landing.recommends.review.NcRecommendsReviewView
    public void showProgressDialog() {
        if (this.e == null) {
            Dialog showSimpleWaitingDialog = this.f.showSimpleWaitingDialog();
            showSimpleWaitingDialog.setOnCancelListener(new c(this, showSimpleWaitingDialog));
            this.e = showSimpleWaitingDialog;
        }
    }

    @Override // com.avito.android.notification_center.landing.recommends.review.NcRecommendsReviewView
    public void showText(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "text");
        this.c.setText(charSequence);
    }
}
