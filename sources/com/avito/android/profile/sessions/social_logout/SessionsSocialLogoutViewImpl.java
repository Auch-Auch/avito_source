package com.avito.android.profile.sessions.social_logout;

import android.view.View;
import androidx.appcompat.widget.Toolbar;
import com.avito.android.advert_core.analytics.contactbar.PhonePageSourceKt;
import com.avito.android.lib.design.button.Button;
import com.avito.android.lib.design.snackbar.SnackbarExtensionsKt;
import com.avito.android.lib.design.snackbar.SnackbarPosition;
import com.avito.android.lib.design.snackbar.SnackbarType;
import com.avito.android.profile.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Toolbars;
import com.jakewharton.rxbinding4.view.RxView;
import io.reactivex.rxjava3.core.Observable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\"\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00168\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\"\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00020\u00168\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0018\u001a\u0004\b\u001d\u0010\u001a¨\u0006!"}, d2 = {"Lcom/avito/android/profile/sessions/social_logout/SessionsSocialLogoutViewImpl;", "Lcom/avito/android/profile/sessions/social_logout/SessionsSocialLogoutView;", "", "showButtonProgress", "()V", "hideButtonProgress", "", "message", "showMessage", "(Ljava/lang/String;)V", "Landroid/view/View;", "e", "Landroid/view/View;", "rootView", "Lcom/avito/android/lib/design/button/Button;", AuthSource.SEND_ABUSE, "Lcom/avito/android/lib/design/button/Button;", PhonePageSourceKt.PHONE_SOURCE_BUTTON, "Landroidx/appcompat/widget/Toolbar;", AuthSource.BOOKING_ORDER, "Landroidx/appcompat/widget/Toolbar;", "toolbar", "Lio/reactivex/rxjava3/core/Observable;", "c", "Lio/reactivex/rxjava3/core/Observable;", "getButtonClicks", "()Lio/reactivex/rxjava3/core/Observable;", "buttonClicks", "d", "getNavigationClicks", "navigationClicks", "<init>", "(Landroid/view/View;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class SessionsSocialLogoutViewImpl implements SessionsSocialLogoutView {
    public final Button a;
    public final Toolbar b;
    @NotNull
    public final Observable<Unit> c;
    @NotNull
    public final Observable<Unit> d;
    public final View e;

    public SessionsSocialLogoutViewImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "rootView");
        this.e = view;
        View findViewById = view.findViewById(R.id.button);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.avito.android.lib.design.button.Button");
        Button button = (Button) findViewById;
        this.a = button;
        View findViewById2 = view.findViewById(R.id.toolbar);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
        Toolbar toolbar = (Toolbar) findViewById2;
        this.b = toolbar;
        toolbar.setNavigationIcon(com.avito.android.ui_components.R.drawable.ic_close_24);
        this.c = RxView.clicks(button);
        this.d = Toolbars.upClicks(toolbar);
    }

    @Override // com.avito.android.profile.sessions.social_logout.SessionsSocialLogoutView
    @NotNull
    public Observable<Unit> getButtonClicks() {
        return this.c;
    }

    @Override // com.avito.android.profile.sessions.social_logout.SessionsSocialLogoutView
    @NotNull
    public Observable<Unit> getNavigationClicks() {
        return this.d;
    }

    @Override // com.avito.android.profile.sessions.social_logout.SessionsSocialLogoutView
    public void hideButtonProgress() {
        this.a.setLoading(false);
        this.a.setClickable(true);
    }

    @Override // com.avito.android.profile.sessions.social_logout.SessionsSocialLogoutView
    public void showButtonProgress() {
        this.a.setLoading(true);
        this.a.setClickable(false);
    }

    @Override // com.avito.android.profile.sessions.social_logout.SessionsSocialLogoutView
    public void showMessage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        SnackbarExtensionsKt.showSnackbar$default(this.e, str, 0, (String) null, 0, (Function0) null, 0, (SnackbarPosition) null, (SnackbarType) null, 254, (Object) null);
    }
}
