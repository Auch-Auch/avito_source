package com.avito.android.certificate_pinning;

import a2.g.r.g;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.avito.android.lib.design.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.ButtonsKt;
import com.avito.android.util.Contexts;
import com.avito.android.util.Views;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Observable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.button.ButtonImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010%\u001a\u00020\u001a¢\u0006\u0004\b(\u0010)J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\n\u0010\bJ\u000f\u0010\u000b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\bJ\u000f\u0010\f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\f\u0010\bJ\u000f\u0010\r\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\r\u0010\bR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u0018R\u0016\u0010!\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010\u001cR\u0019\u0010%\u001a\u00020\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010\u001c\u001a\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010\u0014¨\u0006*"}, d2 = {"Lcom/avito/android/certificate_pinning/UnsafeNetworkViewImpl;", "Lcom/avito/android/certificate_pinning/UnsafeNetworkView;", "Lio/reactivex/Observable;", "", "checkAgainButtonClicks", "()Lio/reactivex/Observable;", "authenticateButtonClicks", "showStillUnsafeNetworkError", "()V", "showUnknownSafetyCheckingError", "showNetworkError", "showLoading", "showUnsafeNetwork", "showAuthorizationRequired", "Landroid/widget/ImageView;", "c", "Landroid/widget/ImageView;", "unsafeNetworkImage", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "descriptionText", "Lru/avito/component/button/ButtonImpl;", "f", "Lru/avito/component/button/ButtonImpl;", "checkAgainButton", "Landroid/view/View;", AuthSource.BOOKING_ORDER, "Landroid/view/View;", "progressOverlay", g.a, "authenticateButton", AuthSource.SEND_ABUSE, "content", "h", "getView", "()Landroid/view/View;", "view", "d", "titleText", "<init>", "(Landroid/view/View;)V", "unsafe-network_release"}, k = 1, mv = {1, 4, 2})
public final class UnsafeNetworkViewImpl implements UnsafeNetworkView {
    public final View a;
    public final View b;
    public final ImageView c;
    public final TextView d;
    public final TextView e;
    public final ButtonImpl f;
    public final ButtonImpl g;
    @NotNull
    public final View h;

    public UnsafeNetworkViewImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.h = view;
        View findViewById = view.findViewById(R.id.content);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        this.a = findViewById;
        View findViewById2 = view.findViewById(R.id.loading_overlay);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.View");
        this.b = findViewById2;
        View findViewById3 = view.findViewById(R.id.image_unsafe_network);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.ImageView");
        ImageView imageView = (ImageView) findViewById3;
        this.c = imageView;
        View findViewById4 = view.findViewById(R.id.title);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.widget.TextView");
        this.d = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.description);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.widget.TextView");
        this.e = (TextView) findViewById5;
        View findViewById6 = view.findViewById(R.id.button_check_again);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type android.view.View");
        ButtonImpl buttonImpl = new ButtonImpl(findViewById6);
        this.f = buttonImpl;
        View findViewById7 = view.findViewById(R.id.button_authenticate);
        Objects.requireNonNull(findViewById7, "null cannot be cast to non-null type android.view.View");
        ButtonImpl buttonImpl2 = new ButtonImpl(findViewById7);
        this.g = buttonImpl2;
        buttonImpl.setText(view.getContext().getText(R.string.unsafe_network_check_again));
        buttonImpl2.setText(view.getContext().getText(R.string.public_network_authorise));
        Views.hideIfDoesNotFitIntoParent(imageView, findViewById);
    }

    @Override // com.avito.android.certificate_pinning.UnsafeNetworkView
    @NotNull
    public Observable<Unit> authenticateButtonClicks() {
        return InteropKt.toV2(ButtonsKt.clicks(this.g));
    }

    @Override // com.avito.android.certificate_pinning.UnsafeNetworkView
    @NotNull
    public Observable<Unit> checkAgainButtonClicks() {
        return InteropKt.toV2(ButtonsKt.clicks(this.f));
    }

    @NotNull
    public final View getView() {
        return this.h;
    }

    @Override // com.avito.android.certificate_pinning.UnsafeNetworkView
    public void showAuthorizationRequired() {
        this.d.setText(R.string.public_network_auth_title);
        this.e.setText(R.string.public_network_auth_description);
        ImageView imageView = this.c;
        Context context = this.a.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "content.context");
        imageView.setImageDrawable(Contexts.getDrawableByAttr(context, R.attr.img_publicWifi));
        ButtonsKt.hide(this.f);
        ButtonsKt.show(this.g);
        Views.hide(this.b);
    }

    @Override // com.avito.android.certificate_pinning.UnsafeNetworkView
    public void showLoading() {
        Views.show(this.b);
    }

    @Override // com.avito.android.certificate_pinning.UnsafeNetworkView
    public void showNetworkError() {
        Views.hide(this.b);
        Views.showSnackBar$default(this.h, com.avito.android.remote.R.string.network_unavailable_snack, 0, (Integer) null, 0, (Function0) null, (Function0) null, 0, 124, (Object) null);
    }

    @Override // com.avito.android.certificate_pinning.UnsafeNetworkView
    public void showStillUnsafeNetworkError() {
        showUnsafeNetwork();
        Views.showSnackBar$default(this.h, R.string.still_unsafe_network_error, 0, (Integer) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
    }

    @Override // com.avito.android.certificate_pinning.UnsafeNetworkView
    public void showUnknownSafetyCheckingError() {
        Views.hide(this.b);
        Views.showSnackBar$default(this.h, com.avito.android.remote.R.string.unknown_server_error, 0, (Integer) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
    }

    @Override // com.avito.android.certificate_pinning.UnsafeNetworkView
    public void showUnsafeNetwork() {
        this.d.setText(R.string.unsafe_network_title);
        this.e.setText(R.string.unsafe_network_description);
        ImageView imageView = this.c;
        Context context = this.a.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "content.context");
        imageView.setImageDrawable(Contexts.getDrawableByAttr(context, R.attr.img_badSsl));
        ButtonsKt.show(this.f);
        ButtonsKt.hide(this.g);
        Views.hide(this.b);
    }
}
