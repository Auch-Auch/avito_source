package com.avito.android.screen_opener;

import a2.g.r.g;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.DimenRes;
import androidx.appcompat.widget.Toolbar;
import com.avito.android.advert_core.analytics.contactbar.PhonePageSourceKt;
import com.avito.android.extended_profile.R;
import com.avito.android.lib.design.button.Button;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.jakewharton.rxbinding4.appcompat.RxToolbar;
import com.jakewharton.rxbinding4.view.RxView;
import io.reactivex.rxjava3.core.Observable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u00100\u001a\u00020\u0017¢\u0006\u0004\b1\u00102J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0012\u0010\u0011J!\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000e2\b\b\u0001\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010&R\u0016\u0010)\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010\u0019R\u0016\u0010+\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010#R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.¨\u00063"}, d2 = {"Lcom/avito/android/screen_opener/ProfileScreenResolverViewImpl;", "Lcom/avito/android/screen_opener/ProfileScreenResolverView;", "Lio/reactivex/rxjava3/core/Observable;", "", "buttonClicks", "()Lio/reactivex/rxjava3/core/Observable;", "navigationClicks", "showProgress", "()V", "hideProgress", "", "text", "showError", "(Ljava/lang/CharSequence;)V", "", "message", "showUserBanned", "(Ljava/lang/String;)V", "showUserRemoved", "", "maxWidthRes", AuthSource.SEND_ABUSE, "(Ljava/lang/String;I)V", "Landroid/view/View;", g.a, "Landroid/view/View;", "stubContainer", "f", "infoContainer", "Lcom/avito/android/lib/design/button/Button;", "d", "Lcom/avito/android/lib/design/button/Button;", PhonePageSourceKt.PHONE_SOURCE_BUTTON, "Landroid/widget/TextView;", "h", "Landroid/widget/TextView;", "stubText", "Landroid/content/res/Resources;", "Landroid/content/res/Resources;", "resources", AuthSource.BOOKING_ORDER, "progress", "c", "errorMessage", "Landroidx/appcompat/widget/Toolbar;", "e", "Landroidx/appcompat/widget/Toolbar;", "toolbar", "view", "<init>", "(Landroid/view/View;)V", "public-profile_release"}, k = 1, mv = {1, 4, 2})
public final class ProfileScreenResolverViewImpl implements ProfileScreenResolverView {
    public final Resources a;
    public final View b;
    public final TextView c;
    public final Button d;
    public final Toolbar e;
    public final View f;
    public final View g;
    public final TextView h;

    public ProfileScreenResolverViewImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Resources resources = view.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "view.resources");
        this.a = resources;
        View findViewById = view.findViewById(R.id.progress_container);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        this.b = findViewById;
        View findViewById2 = view.findViewById(R.id.message);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.c = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.refresh_button);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type com.avito.android.lib.design.button.Button");
        this.d = (Button) findViewById3;
        View findViewById4 = view.findViewById(R.id.toolbar);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
        this.e = (Toolbar) findViewById4;
        View findViewById5 = view.findViewById(R.id.info_container);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.view.View");
        this.f = findViewById5;
        View findViewById6 = view.findViewById(com.avito.android.public_profile_stuff.R.id.stub_container);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type android.view.View");
        this.g = findViewById6;
        View findViewById7 = view.findViewById(com.avito.android.public_profile_stuff.R.id.stub_text);
        Objects.requireNonNull(findViewById7, "null cannot be cast to non-null type android.widget.TextView");
        this.h = (TextView) findViewById7;
    }

    public final void a(String str, @DimenRes int i) {
        Views.hide(this.b);
        Views.hide(this.f);
        Views.show(this.g);
        this.h.setMaxWidth(this.a.getDimensionPixelSize(i));
        TextViews.bindText$default(this.h, str, false, 2, null);
    }

    @Override // com.avito.android.screen_opener.ProfileScreenResolverView
    @NotNull
    public Observable<Unit> buttonClicks() {
        return RxView.clicks(this.d);
    }

    @Override // com.avito.android.screen_opener.ProfileScreenResolverView
    public void hideProgress() {
        Views.show(this.f);
        Views.hide(this.b);
        Views.hide(this.g);
    }

    @Override // com.avito.android.screen_opener.ProfileScreenResolverView
    @NotNull
    public Observable<Unit> navigationClicks() {
        return RxToolbar.navigationClicks(this.e);
    }

    @Override // com.avito.android.screen_opener.ProfileScreenResolverView
    public void showError(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "text");
        TextViews.bindText$default(this.c, charSequence, false, 2, null);
    }

    @Override // com.avito.android.screen_opener.ProfileScreenResolverView
    public void showProgress() {
        Views.hide(this.f);
        Views.show(this.b);
        Views.hide(this.g);
    }

    @Override // com.avito.android.screen_opener.ProfileScreenResolverView
    public void showUserBanned(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        a(str, com.avito.android.public_profile_stuff.R.dimen.user_banned_message_width);
    }

    @Override // com.avito.android.screen_opener.ProfileScreenResolverView
    public void showUserRemoved(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        a(str, com.avito.android.public_profile_stuff.R.dimen.user_removed_message_width);
    }
}
