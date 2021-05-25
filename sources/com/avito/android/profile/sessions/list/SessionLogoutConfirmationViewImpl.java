package com.avito.android.profile.sessions.list;

import a2.a.a.b2.h1.a.a;
import a2.g.r.g;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.avito.android.lib.design.bottom_sheet.BottomSheetDialog;
import com.avito.android.lib.design.snackbar.SnackbarExtensionsKt;
import com.avito.android.lib.design.snackbar.SnackbarPosition;
import com.avito.android.lib.design.snackbar.SnackbarType;
import com.avito.android.profile.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Contexts;
import com.avito.android.util.TextViews;
import com.jakewharton.rxrelay3.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010#\u001a\u00020 ¢\u0006\u0004\b;\u0010<J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJY\u0010\u0018\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\r2\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\"\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u001a8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"RD\u0010)\u001a0\u0012\f\u0012\n %*\u0004\u0018\u00010\u00040\u0004 %*\u0017\u0012\f\u0012\n %*\u0004\u0018\u00010\u00040\u0004\u0018\u00010$¢\u0006\u0002\b&0$¢\u0006\u0002\b&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b+\u0010,RD\u0010/\u001a0\u0012\f\u0012\n %*\u0004\u0018\u00010\u00040\u0004 %*\u0017\u0012\f\u0012\n %*\u0004\u0018\u00010\u00040\u0004\u0018\u00010$¢\u0006\u0002\b&0$¢\u0006\u0002\b&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010(R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b1\u00102R\"\u00106\u001a\b\u0012\u0004\u0012\u00020\u00040\u001a8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b4\u0010\u001c\u001a\u0004\b5\u0010\u001eR\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b8\u00109¨\u0006="}, d2 = {"Lcom/avito/android/profile/sessions/list/SessionLogoutConfirmationViewImpl;", "Lcom/avito/android/profile/sessions/list/SessionLogoutConfirmationView;", "", "description", "", "showConfirmationMenu", "(Ljava/lang/String;)V", "closeConfirmationMenu", "()V", "", "canShowSnackbar", "()Z", "text", "", "textResId", "actionText", "actionTextResId", "Lkotlin/Function0;", "onActionClick", "duration", "Lcom/avito/android/lib/design/snackbar/SnackbarPosition;", VKApiConst.POSITION, "Lcom/avito/android/lib/design/snackbar/SnackbarType;", "type", "showSnackbar", "(Ljava/lang/String;ILjava/lang/String;ILkotlin/jvm/functions/Function0;ILcom/avito/android/lib/design/snackbar/SnackbarPosition;Lcom/avito/android/lib/design/snackbar/SnackbarType;)V", "Lio/reactivex/rxjava3/core/Observable;", g.a, "Lio/reactivex/rxjava3/core/Observable;", "getDismissEvents", "()Lio/reactivex/rxjava3/core/Observable;", "dismissEvents", "Landroid/content/Context;", "h", "Landroid/content/Context;", "context", "Lcom/jakewharton/rxrelay3/PublishRelay;", "kotlin.jvm.PlatformType", "Lio/reactivex/rxjava3/annotations/NonNull;", "d", "Lcom/jakewharton/rxrelay3/PublishRelay;", "actionRelay", "Landroid/widget/TextView;", "c", "Landroid/widget/TextView;", "descriptionView", "e", "dismissRelay", "Landroid/view/View;", AuthSource.BOOKING_ORDER, "Landroid/view/View;", "containerView", "f", "getChangePasswordClicks", "changePasswordClicks", "Lcom/avito/android/lib/design/bottom_sheet/BottomSheetDialog;", AuthSource.SEND_ABUSE, "Lcom/avito/android/lib/design/bottom_sheet/BottomSheetDialog;", "dialog", "<init>", "(Landroid/content/Context;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class SessionLogoutConfirmationViewImpl implements SessionLogoutConfirmationView {
    public BottomSheetDialog a;
    public View b;
    public TextView c;
    public final PublishRelay<Unit> d;
    public final PublishRelay<Unit> e;
    @NotNull
    public final Observable<Unit> f;
    @NotNull
    public final Observable<Unit> g;
    public final Context h;

    public SessionLogoutConfirmationViewImpl(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.h = context;
        PublishRelay<Unit> create = PublishRelay.create();
        this.d = create;
        PublishRelay<Unit> create2 = PublishRelay.create();
        this.e = create2;
        Intrinsics.checkNotNullExpressionValue(create, "actionRelay");
        this.f = create;
        Intrinsics.checkNotNullExpressionValue(create2, "dismissRelay");
        this.g = create2;
    }

    public static final void access$clearViews(SessionLogoutConfirmationViewImpl sessionLogoutConfirmationViewImpl) {
        sessionLogoutConfirmationViewImpl.b = null;
        sessionLogoutConfirmationViewImpl.c = null;
    }

    @Override // com.avito.android.lib.design.snackbar.util.OptionalSnackbarElementView
    public boolean canShowSnackbar() {
        BottomSheetDialog bottomSheetDialog = this.a;
        if (bottomSheetDialog != null) {
            return bottomSheetDialog.isShowing();
        }
        return false;
    }

    @Override // com.avito.android.profile.sessions.list.SessionLogoutConfirmationView
    public void closeConfirmationMenu() {
        BottomSheetDialog bottomSheetDialog = this.a;
        if (bottomSheetDialog != null) {
            bottomSheetDialog.dismiss();
        }
    }

    @Override // com.avito.android.profile.sessions.list.SessionLogoutConfirmationView
    @NotNull
    public Observable<Unit> getChangePasswordClicks() {
        return this.f;
    }

    @Override // com.avito.android.profile.sessions.list.SessionLogoutConfirmationView
    @NotNull
    public Observable<Unit> getDismissEvents() {
        return this.g;
    }

    @Override // com.avito.android.profile.sessions.list.SessionLogoutConfirmationView
    public void showConfirmationMenu(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "description");
        BottomSheetDialog bottomSheetDialog = this.a;
        if (bottomSheetDialog != null ? bottomSheetDialog.isShowing() : false) {
            TextView textView = this.c;
            if (textView != null) {
                TextViews.bindText$default(textView, this.h.getString(R.string.session_logout_dialog_body, str), false, 2, null);
                return;
            }
            return;
        }
        BottomSheetDialog bottomSheetDialog2 = new BottomSheetDialog(this.h, 0, 2, null);
        bottomSheetDialog2.setContentView(R.layout.session_logout_confirmation);
        View findViewById = bottomSheetDialog2.findViewById(R.id.dialog_root);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(id)");
        this.b = findViewById;
        View findViewById2 = bottomSheetDialog2.findViewById(R.id.dialog_body);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(id)");
        this.c = (TextView) findViewById2;
        View findViewById3 = bottomSheetDialog2.findViewById(R.id.change_password_button);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(id)");
        findViewById3.setOnClickListener(new e0(0, this));
        View findViewById4 = bottomSheetDialog2.findViewById(R.id.close_button);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(id)");
        findViewById4.setOnClickListener(new e0(1, this));
        Context context = bottomSheetDialog2.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        bottomSheetDialog2.setPeekHeight(Contexts.getDisplayHeight(context));
        bottomSheetDialog2.setCancelable(true);
        bottomSheetDialog2.setCanceledOnTouchOutside(true);
        BottomSheetDialog.setHeaderParams$default(bottomSheetDialog2, null, null, false, true, 7, null);
        bottomSheetDialog2.setOnDismissListener(new a(this));
        TextView textView2 = this.c;
        if (textView2 != null) {
            TextViews.bindText$default(textView2, bottomSheetDialog2.getContext().getString(R.string.session_logout_dialog_body, str), false, 2, null);
        }
        bottomSheetDialog2.show();
        this.a = bottomSheetDialog2;
    }

    @Override // com.avito.android.lib.design.snackbar.util.SnackbarElementView
    public void showSnackbar(@NotNull String str, int i, @Nullable String str2, int i2, @Nullable Function0<Unit> function0, int i3, @NotNull SnackbarPosition snackbarPosition, @NotNull SnackbarType snackbarType) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(snackbarPosition, VKApiConst.POSITION);
        Intrinsics.checkNotNullParameter(snackbarType, "type");
        View view = this.b;
        if (view != null) {
            SnackbarExtensionsKt.showSnackbar(view, str, i, str2, i2, function0, i3, snackbarPosition, snackbarType);
        }
    }
}
