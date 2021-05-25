package com.avito.android.advert_core.phone_request;

import a2.g.r.g;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import com.avito.android.advert_core.R;
import com.avito.android.async_phone.AsyncPhoneView;
import com.avito.android.deep_linking.links.PhoneLink;
import com.avito.android.lastclick.LastClick;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.Formatter;
import com.avito.android.util.ToastsKt;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.serp.PhoneLoadingState;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B5\u0012\u0006\u0010 \u001a\u00020\u001d\u0012\u0006\u00101\u001a\u00020.\u0012\f\u0010&\u001a\b\u0012\u0004\u0012\u00020#0\"\u0012\u0006\u00105\u001a\u000202\u0012\u0006\u0010-\u001a\u00020\u0002¢\u0006\u0004\b6\u00107J\u0015\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010!\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u001bR\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020#0\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010-\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104¨\u00068"}, d2 = {"Lcom/avito/android/advert_core/phone_request/PhoneRequestViewImpl;", "Lcom/avito/android/advert_core/phone_request/PhoneRequestView;", "Lcom/avito/android/async_phone/AsyncPhoneView;", "Lio/reactivex/rxjava3/core/Observable;", "", "showPhoneLoadError", "()Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/deep_linking/links/PhoneLink$Call;", "link", "call", "(Lcom/avito/android/deep_linking/links/PhoneLink$Call;)V", "", "resourceId", "showToast", "(I)V", "Lru/avito/component/serp/PhoneLoadingState;", "state", "setPhoneLoadingState", "(Lru/avito/component/serp/PhoneLoadingState;)V", "dismissPhoneLoadError", "()V", "", "show", AuthSource.SEND_ABUSE, "(Z)V", "Landroid/app/Dialog;", AuthSource.BOOKING_ORDER, "Landroid/app/Dialog;", "phoneDialog", "Landroid/view/View;", "d", "Landroid/view/View;", "view", "loadingDialog", "Lcom/avito/android/util/Formatter;", "", "f", "Lcom/avito/android/util/Formatter;", "phoneNumberFormatter", "Landroid/content/Context;", "c", "Landroid/content/Context;", "context", "h", "Lcom/avito/android/async_phone/AsyncPhoneView;", "asyncPhoneView", "Lcom/avito/android/util/DialogRouter;", "e", "Lcom/avito/android/util/DialogRouter;", "dialogRouter", "Lcom/avito/android/advert_core/phone_request/PhoneRequestPresenter;", g.a, "Lcom/avito/android/advert_core/phone_request/PhoneRequestPresenter;", "contactsPresenter", "<init>", "(Landroid/view/View;Lcom/avito/android/util/DialogRouter;Lcom/avito/android/util/Formatter;Lcom/avito/android/advert_core/phone_request/PhoneRequestPresenter;Lcom/avito/android/async_phone/AsyncPhoneView;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class PhoneRequestViewImpl implements PhoneRequestView, AsyncPhoneView {
    public Dialog a;
    public Dialog b;
    public final Context c;
    public final View d;
    public final DialogRouter e;
    public final Formatter<String> f;
    public final PhoneRequestPresenter g;
    public final AsyncPhoneView h;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            PhoneLoadingState.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
            iArr[2] = 3;
        }
    }

    public static final class a implements DialogInterface.OnClickListener {
        public final /* synthetic */ PhoneRequestViewImpl a;
        public final /* synthetic */ PhoneLink.Call b;

        public a(PhoneRequestViewImpl phoneRequestViewImpl, PhoneLink.Call call) {
            this.a = phoneRequestViewImpl;
            this.b = call;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i) {
            LastClick.Updater.update();
            this.a.g.onPhoneCallConfirmed();
            this.a.g.makeCallSafely(this.b);
        }
    }

    public static final class b implements DialogInterface.OnDismissListener {
        public final /* synthetic */ PhoneRequestViewImpl a;

        public b(PhoneRequestViewImpl phoneRequestViewImpl) {
            this.a = phoneRequestViewImpl;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            LastClick.Updater.update();
            this.a.g.onDialogDismiss();
        }
    }

    public static final class c implements DialogInterface.OnCancelListener {
        public final /* synthetic */ PhoneRequestViewImpl a;

        public c(PhoneRequestViewImpl phoneRequestViewImpl) {
            this.a = phoneRequestViewImpl;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface dialogInterface) {
            this.a.g.onDialogCanceled();
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ PhoneRequestViewImpl a;

        public d(PhoneRequestViewImpl phoneRequestViewImpl) {
            this.a = phoneRequestViewImpl;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.g.onDialogDismiss();
        }
    }

    public static final class e<T> implements Consumer<Unit> {
        public final /* synthetic */ PhoneRequestViewImpl a;

        public e(PhoneRequestViewImpl phoneRequestViewImpl) {
            this.a = phoneRequestViewImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Unit unit) {
            this.a.d.setOnClickListener(null);
        }
    }

    public static final class f implements Action {
        public final /* synthetic */ PhoneRequestViewImpl a;

        public f(PhoneRequestViewImpl phoneRequestViewImpl) {
            this.a = phoneRequestViewImpl;
        }

        @Override // io.reactivex.rxjava3.functions.Action
        public final void run() {
            this.a.g.onDialogDismiss();
        }
    }

    public PhoneRequestViewImpl(@NotNull View view, @NotNull DialogRouter dialogRouter, @NotNull Formatter<String> formatter, @NotNull PhoneRequestPresenter phoneRequestPresenter, @NotNull AsyncPhoneView asyncPhoneView) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(dialogRouter, "dialogRouter");
        Intrinsics.checkNotNullParameter(formatter, "phoneNumberFormatter");
        Intrinsics.checkNotNullParameter(phoneRequestPresenter, "contactsPresenter");
        Intrinsics.checkNotNullParameter(asyncPhoneView, "asyncPhoneView");
        this.d = view;
        this.e = dialogRouter;
        this.f = formatter;
        this.g = phoneRequestPresenter;
        this.h = asyncPhoneView;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        this.c = context;
    }

    public final void a(boolean z) {
        if (!z) {
            Dialog dialog = this.a;
            if (dialog != null) {
                dialog.dismiss();
            }
            this.a = null;
        } else if (this.a == null) {
            this.a = this.e.showSimpleWaitingDialog();
        }
    }

    @Override // com.avito.android.advert_core.phone_request.PhoneRequestView
    public void call(@NotNull PhoneLink.Call call) {
        Intrinsics.checkNotNullParameter(call, "link");
        Dialog dialog = this.b;
        if (dialog == null || !dialog.isShowing()) {
            AlertDialog create = new AlertDialog.Builder(this.c).setTitle(R.string.phone).setMessage(this.f.format(call.getPhone())).setPositiveButton(com.avito.android.ui_components.R.string.call, new a(this, call)).setOnDismissListener(new b(this)).setOnCancelListener(new c(this)).create();
            this.b = create;
            if (create != null) {
                create.show();
            }
        }
    }

    @Override // com.avito.android.async_phone.AsyncPhoneView
    public void dismissPhoneLoadError() {
        this.h.dismissPhoneLoadError();
    }

    @Override // ru.avito.component.serp.AsyncPhoneItemView
    public void setPhoneLoadingState(@NotNull PhoneLoadingState phoneLoadingState) {
        Intrinsics.checkNotNullParameter(phoneLoadingState, "state");
        int ordinal = phoneLoadingState.ordinal();
        if (ordinal == 0) {
            a(false);
        } else if (ordinal == 1) {
            a(true);
        }
    }

    @Override // com.avito.android.async_phone.AsyncPhoneView
    @NotNull
    public Observable<Unit> showPhoneLoadError() {
        this.d.setOnClickListener(new d(this));
        Observable<Unit> doOnComplete = this.h.showPhoneLoadError().doOnNext(new e(this)).doOnComplete(new f(this));
        Intrinsics.checkNotNullExpressionValue(doOnComplete, "asyncPhoneView\n         …enter.onDialogDismiss() }");
        return doOnComplete;
    }

    @Override // com.avito.android.advert_core.phone_request.PhoneRequestView
    public void showToast(int i) {
        Context context = this.c;
        String string = context.getResources().getString(i);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getString(resourceId)");
        ToastsKt.showToast$default(context, string, 0, 2, (Object) null);
    }
}
