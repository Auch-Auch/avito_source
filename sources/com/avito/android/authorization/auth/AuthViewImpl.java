package com.avito.android.authorization.auth;

import a2.a.a.b.b.i;
import a2.g.r.g;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.avito.android.authorization.R;
import com.avito.android.component.bottom_sheet.BottomSheetViewImpl;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.InfoPageLink;
import com.avito.android.lib.design.dialog.Dialog;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.remote.model.text.DeepLinkAttribute;
import com.avito.android.snackbar.proxy.SnackbarProxyKt;
import com.avito.android.social.button.SocialInfo;
import com.avito.android.util.AvitoSnackbar;
import com.avito.android.util.ButtonsKt;
import com.avito.android.util.DrawablesKt;
import com.avito.android.util.Views;
import com.avito.android.util.rx3.InteropKt;
import com.avito.android.util.text.TextViewsKt;
import com.jakewharton.rxbinding4.view.RxView;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.button.Button;
import ru.avito.component.button.ButtonImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010B\u001a\u000206¢\u0006\u0004\bI\u0010JJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0005J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0005J\u000f\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\f\u0010\u000bJ%\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0013\u0010\u000bJ\u000f\u0010\u0014\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0014\u0010\u000bJ\u0017\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0018\u0010\u000bJ\u000f\u0010\u0019\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0019\u0010\u000bJ\u000f\u0010\u001a\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001a\u0010\u000bJ\u0017\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0003H\u0016¢\u0006\u0004\b!\u0010\u000bJ\u000f\u0010\"\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\"\u0010\u000bJ#\u0010%\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010\r2\b\u0010$\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u001e\u00103\u001a\n 0*\u0004\u0018\u00010/0/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00105\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u0010)R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010@\u001a\u00020\u001b8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010B\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bA\u00108R\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010H\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bG\u00108¨\u0006K"}, d2 = {"Lcom/avito/android/authorization/auth/AuthViewImpl;", "Lcom/avito/android/authorization/auth/AuthView;", "Lio/reactivex/rxjava3/core/Observable;", "", "closeClicks", "()Lio/reactivex/rxjava3/core/Observable;", "loginClicks", "registrationClicks", "Lcom/avito/android/deep_linking/links/DeepLink;", "linkClicks", "enableSocialButtons", "()V", "disableSocialButtons", "", "type", "Lcom/avito/android/social/button/SocialInfo;", "info", "addSocialButton", "(Ljava/lang/String;Lcom/avito/android/social/button/SocialInfo;)Lio/reactivex/rxjava3/core/Observable;", "hideSocialButtons", "showContent", "error", "showError", "(Ljava/lang/String;)V", "showProgress", "showScreenProgress", "hideScreenProgress", "Lcom/avito/android/remote/model/text/AttributedText;", "text", "setServiceAgreementText", "(Lcom/avito/android/remote/model/text/AttributedText;)V", "generateServiceAgreementAttributedText", "()Lcom/avito/android/remote/model/text/AttributedText;", "close", "show", "title", "message", "showErrorDialog", "(Ljava/lang/String;Ljava/lang/String;)V", "Lru/avito/component/button/Button;", g.a, "Lru/avito/component/button/Button;", "registrationButton", "Lcom/avito/android/component/bottom_sheet/BottomSheetViewImpl;", AuthSource.SEND_ABUSE, "Lcom/avito/android/component/bottom_sheet/BottomSheetViewImpl;", "bottomSheetView", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", AuthSource.BOOKING_ORDER, "Landroid/view/LayoutInflater;", "layoutInflater", "f", "loginButton", "Landroid/view/View;", "d", "Landroid/view/View;", "loader", "Landroid/widget/TextView;", "h", "Landroid/widget/TextView;", "agreementTextView", "i", "Lcom/avito/android/remote/model/text/AttributedText;", "agreementText", "j", "view", "Landroid/view/ViewGroup;", "c", "Landroid/view/ViewGroup;", "socialButtonsContainer", "e", "screenLoader", "<init>", "(Landroid/view/View;)V", "authorization_release"}, k = 1, mv = {1, 4, 2})
public final class AuthViewImpl implements AuthView {
    public final BottomSheetViewImpl a;
    public final LayoutInflater b;
    public final ViewGroup c;
    public final View d;
    public final View e;
    public final Button f;
    public final Button g;
    public final TextView h;
    public AttributedText i;
    public final View j;

    public static final class a<T, R> implements Function<Unit, String> {
        public final /* synthetic */ String a;

        public a(String str) {
            this.a = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public String apply(Unit unit) {
            return this.a;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ AuthViewImpl a;

        public b(AuthViewImpl authViewImpl) {
            this.a = authViewImpl;
        }

        @Override // java.lang.Runnable
        public final void run() {
            TextViewsKt.setAttributedText$default(this.a.h, AuthViewImpl.access$getAgreementText$p(this.a), null, 2, null);
        }
    }

    public static final class c extends Lambda implements Function2<Dialog.Config, DialogInterface, Unit> {
        public final /* synthetic */ AuthViewImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(AuthViewImpl authViewImpl, String str, String str2) {
            super(2);
            this.a = authViewImpl;
            this.b = str;
            this.c = str2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(Dialog.Config config, DialogInterface dialogInterface) {
            Dialog.Config config2 = config;
            DialogInterface dialogInterface2 = dialogInterface;
            Intrinsics.checkNotNullParameter(config2, "$receiver");
            Intrinsics.checkNotNullParameter(dialogInterface2, "it");
            config2.setTitle(this.b);
            config2.setSubtitle(this.c);
            String string = this.a.j.getResources().getString(R.string.social_auth_error_dialog_btn);
            Intrinsics.checkNotNullExpressionValue(string, "view.resources.getString…al_auth_error_dialog_btn)");
            config2.addDefaultButton(string, new i(dialogInterface2));
            config2.setCancelable(true);
            return Unit.INSTANCE;
        }
    }

    public AuthViewImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.j = view;
        this.a = new BottomSheetViewImpl(view, null, null, null, null, false, 30, null);
        this.b = LayoutInflater.from(view.getContext());
        View findViewById = view.findViewById(R.id.social_container);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.ViewGroup");
        this.c = (ViewGroup) findViewById;
        View findViewById2 = view.findViewById(R.id.progress);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.View");
        this.d = findViewById2;
        View findViewById3 = view.findViewById(R.id.screen_progress);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.view.View");
        this.e = findViewById3;
        View findViewById4 = view.findViewById(R.id.login);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.view.View");
        ButtonImpl buttonImpl = new ButtonImpl(findViewById4);
        buttonImpl.setText(R.string.auth_button_login);
        Unit unit = Unit.INSTANCE;
        this.f = buttonImpl;
        View findViewById5 = view.findViewById(R.id.registration);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.view.View");
        ButtonImpl buttonImpl2 = new ButtonImpl(findViewById5);
        buttonImpl2.setText(R.string.auth_button_registration);
        this.g = buttonImpl2;
        View findViewById6 = view.findViewById(R.id.auth_user_agreement);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) findViewById6;
        this.h = textView;
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public static final /* synthetic */ AttributedText access$getAgreementText$p(AuthViewImpl authViewImpl) {
        AttributedText attributedText = authViewImpl.i;
        if (attributedText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("agreementText");
        }
        return attributedText;
    }

    @Override // com.avito.android.authorization.auth.AuthView
    @NotNull
    public Observable<String> addSocialButton(@NotNull String str, @NotNull SocialInfo socialInfo) {
        Drawable drawable;
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(socialInfo, "info");
        View inflate = this.b.inflate(com.avito.android.social.R.layout.auth_social_button, this.c, false);
        Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.widget.ImageButton");
        ImageButton imageButton = (ImageButton) inflate;
        imageButton.setBackgroundResource(socialInfo.getBackground());
        Integer tintColor = socialInfo.getTintColor();
        if (tintColor == null) {
            drawable = this.j.getContext().getDrawable(socialInfo.getIcon());
        } else {
            Drawable drawable2 = this.j.getContext().getDrawable(socialInfo.getIcon());
            drawable = drawable2 != null ? DrawablesKt.wrapForTinting(drawable2, ContextCompat.getColor(this.j.getContext(), tintColor.intValue())) : null;
        }
        imageButton.setImageDrawable(drawable);
        imageButton.setTag(str);
        this.c.addView(imageButton);
        Observable<R> map = RxView.clicks(imageButton).map(new a(str));
        Intrinsics.checkNotNullExpressionValue(map, "button.clicks().map { type }");
        return map;
    }

    @Override // com.avito.android.authorization.auth.AuthView
    public void close() {
        this.a.close();
    }

    @Override // com.avito.android.authorization.auth.AuthView
    @NotNull
    public Observable<Unit> closeClicks() {
        return this.a.closeEvents();
    }

    @Override // com.avito.android.authorization.auth.AuthView
    public void disableSocialButtons() {
        Views.disable(this.c);
    }

    @Override // com.avito.android.authorization.auth.AuthView
    public void enableSocialButtons() {
        Views.enable(this.c);
    }

    @Override // com.avito.android.authorization.auth.AuthView
    @NotNull
    public AttributedText generateServiceAgreementAttributedText() {
        String string = this.j.getResources().getString(R.string.user_agreement_link_title);
        Intrinsics.checkNotNullExpressionValue(string, "view.resources.getString…ser_agreement_link_title)");
        String string2 = this.j.getResources().getString(com.avito.android.ui_components.R.string.read_licence);
        Intrinsics.checkNotNullExpressionValue(string2, "view.resources.getString(ui_R.string.read_licence)");
        String string3 = this.j.getResources().getString(R.string.data_policy_link_title);
        Intrinsics.checkNotNullExpressionValue(string3, "view.resources.getString…g.data_policy_link_title)");
        String string4 = this.j.getResources().getString(com.avito.android.ui_components.R.string.read_data_policy);
        Intrinsics.checkNotNullExpressionValue(string4, "view.resources.getString….string.read_data_policy)");
        List listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new DeepLinkAttribute[]{new DeepLinkAttribute("user_agreement", string, new InfoPageLink("user_agreement", string2), null, null, 24, null), new DeepLinkAttribute("data_policy", string3, new InfoPageLink("data_policy", string4), null, null, 24, null)});
        String string5 = this.j.getResources().getString(R.string.service_agreement_text);
        Intrinsics.checkNotNullExpressionValue(string5, "view.resources.getString…g.service_agreement_text)");
        return new AttributedText(string5, listOf);
    }

    @Override // com.avito.android.authorization.auth.AuthView
    public void hideScreenProgress() {
        Views.hide(this.e);
    }

    @Override // com.avito.android.authorization.auth.AuthView
    public void hideSocialButtons() {
        this.c.removeAllViewsInLayout();
    }

    @Override // com.avito.android.authorization.auth.AuthView
    @NotNull
    public Observable<DeepLink> linkClicks() {
        AttributedText attributedText = this.i;
        if (attributedText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("agreementText");
        }
        return InteropKt.toV3(attributedText.linkClicks());
    }

    @Override // com.avito.android.authorization.auth.AuthView
    @NotNull
    public Observable<Unit> loginClicks() {
        return ButtonsKt.clicks(this.f);
    }

    @Override // com.avito.android.authorization.auth.AuthView
    @NotNull
    public Observable<Unit> registrationClicks() {
        return ButtonsKt.clicks(this.g);
    }

    @Override // com.avito.android.authorization.auth.AuthView
    public void setServiceAgreementText(@NotNull AttributedText attributedText) {
        Intrinsics.checkNotNullParameter(attributedText, "text");
        this.i = attributedText;
        this.h.post(new b(this));
    }

    @Override // com.avito.android.authorization.auth.AuthView
    public void show() {
        this.j.setBackgroundResource(com.avito.android.lib.design.avito.R.color.expected_overlay);
        this.a.show();
    }

    @Override // com.avito.android.authorization.auth.AuthView
    public void showContent() {
        Views.hide(this.d);
    }

    @Override // com.avito.android.authorization.auth.AuthView
    public void showError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "error");
        Views.hide(this.d);
        SnackbarProxyKt.showSnackbar(AvitoSnackbar.make$default(AvitoSnackbar.INSTANCE, this.j, str, 0, null, 0, null, null, 0, 0, 0, 1016, null));
    }

    @Override // com.avito.android.authorization.auth.AuthView
    public void showErrorDialog(@Nullable String str, @Nullable String str2) {
        Views.hide(this.d);
        Dialog.Companion companion = Dialog.Companion;
        Context context = this.j.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        Dialog.Companion.create$default(companion, context, 0, 0, new c(this, str, str2), 6, null).show();
    }

    @Override // com.avito.android.authorization.auth.AuthView
    public void showProgress() {
        Views.show(this.d);
    }

    @Override // com.avito.android.authorization.auth.AuthView
    public void showScreenProgress() {
        Views.show(this.e);
    }
}
