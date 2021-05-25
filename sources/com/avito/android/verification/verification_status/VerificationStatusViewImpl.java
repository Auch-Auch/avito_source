package com.avito.android.verification.verification_status;

import a2.a.a.r3.a.h;
import a2.a.a.r3.a.i;
import a2.a.a.r3.a.j;
import a2.g.r.g;
import android.app.Dialog;
import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.OnDeepLinkClickListener;
import com.avito.android.deep_linking.links.OnUrlClickListener;
import com.avito.android.image_loader.AvitoPictureKt;
import com.avito.android.lib.design.alert_banner.AlertBanner;
import com.avito.android.lib.design.alert_banner.AlertBannerContent;
import com.avito.android.lib.design.bottom_sheet.BottomSheetMenuDialog;
import com.avito.android.lib.design.button.Button;
import com.avito.android.lib.design.snackbar.SnackbarExtensionsKt;
import com.avito.android.lib.design.snackbar.SnackbarPosition;
import com.avito.android.lib.design.snackbar.SnackbarType;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.util.Contexts;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.android.util.ViewSizeKt;
import com.avito.android.util.Views;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.android.verification.R;
import com.avito.android.verification.verification_status.VerificationStatusScreenData;
import com.facebook.drawee.view.SimpleDraweeView;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.toolbar.AppBarLayoutWithIconAction;
import ru.avito.component.toolbar.AppbarClickListener;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0001\u0012\u0006\u00100\u001a\u00020-\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010Z\u001a\u00020Y\u0012\f\u0010[\u001a\b\u0012\u0004\u0012\u00020\u00040\u0010\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0010\u0012\f\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u00040\u0010\u0012!\u0010U\u001a\u001d\u0012\u0013\u0012\u00110R¢\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(S\u0012\u0004\u0012\u00020\u000405\u0012!\u0010;\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(8\u0012\u0004\u0012\u00020\u000405¢\u0006\u0004\b]\u0010^J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000f\u0010\rJ'\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\n2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u001e\u0010,\u001a\n )*\u0004\u0018\u00010(0(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103R1\u0010;\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(8\u0012\u0004\u0012\u00020\u0004058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010A\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b@\u0010\u001aR\u0016\u0010C\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bB\u0010&R\u0016\u0010E\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bD\u0010\u001aR\u0016\u0010I\u001a\u00020F8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010M\u001a\u00020J8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010Q\u001a\u00020N8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bO\u0010PR1\u0010U\u001a\u001d\u0012\u0013\u0012\u00110R¢\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(S\u0012\u0004\u0012\u00020\u0004058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bT\u0010:R\u001e\u0010X\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bV\u0010W¨\u0006_"}, d2 = {"Lcom/avito/android/verification/verification_status/VerificationStatusViewImpl;", "Lcom/avito/android/verification/verification_status/VerificationStatusView;", "Lcom/avito/android/verification/verification_status/VerificationStatusScreenData;", "screenData", "", "setContent", "(Lcom/avito/android/verification/verification_status/VerificationStatusScreenData;)V", "showLoading", "()V", "showContent", "", "error", "showError", "(Ljava/lang/String;)V", "text", "showAlert", "Lkotlin/Function0;", "refreshesListener", "showErrorAlert", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "Lru/avito/component/toolbar/AppBarLayoutWithIconAction;", AuthSource.BOOKING_ORDER, "Lru/avito/component/toolbar/AppBarLayoutWithIconAction;", "appBar", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "titleView", "Lcom/avito/android/util/text/AttributedTextFormatter;", "p", "Lcom/avito/android/util/text/AttributedTextFormatter;", "textFormatter", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "k", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Landroid/view/ViewGroup;", "j", "Landroid/view/ViewGroup;", "contentContainer", "Landroid/content/Context;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "Landroid/view/View;", "o", "Landroid/view/View;", "view", "Lcom/avito/android/deep_linking/links/OnUrlClickListener;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/deep_linking/links/OnUrlClickListener;", "urlLinkClickListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "url", "r", "Lkotlin/jvm/functions/Function1;", "urlListener", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "c", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "swipeRefreshLayout", "e", "descriptionView", "i", "buttonsContainer", "f", "footerTextView", "Lcom/facebook/drawee/view/SimpleDraweeView;", g.a, "Lcom/facebook/drawee/view/SimpleDraweeView;", "imageView", "Lcom/avito/android/lib/design/alert_banner/AlertBanner;", "h", "Lcom/avito/android/lib/design/alert_banner/AlertBanner;", "bannerView", "Lcom/avito/android/deep_linking/links/OnDeepLinkClickListener;", "l", "Lcom/avito/android/deep_linking/links/OnDeepLinkClickListener;", "attributedTextDeepLinkClickListener", "Lcom/avito/android/deep_linking/links/DeepLink;", "deeplink", VKApiConst.Q, "deepLinkListener", "n", "Lkotlin/jvm/functions/Function0;", "actionClickListener", "Lcom/avito/android/analytics/Analytics;", "analytics", "backClicksListener", "reloadsListener", "<init>", "(Landroid/view/View;Lcom/avito/android/util/text/AttributedTextFormatter;Lcom/avito/android/analytics/Analytics;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "verification_release"}, k = 1, mv = {1, 4, 2})
public final class VerificationStatusViewImpl implements VerificationStatusView {
    public final Context a;
    public final AppBarLayoutWithIconAction b;
    public final SwipeRefreshLayout c;
    public final TextView d;
    public final TextView e;
    public final TextView f;
    public final SimpleDraweeView g;
    public final AlertBanner h;
    public final ViewGroup i;
    public final ViewGroup j;
    public final ProgressOverlay k;
    public final OnDeepLinkClickListener l = new a(this);
    public final OnUrlClickListener m = new b(this);
    public Function0<Unit> n;
    public final View o;
    public final AttributedTextFormatter p;
    public final Function1<DeepLink, Unit> q;
    public final Function1<String, Unit> r;

    public static final class a implements OnDeepLinkClickListener {
        public final /* synthetic */ VerificationStatusViewImpl a;

        public a(VerificationStatusViewImpl verificationStatusViewImpl) {
            this.a = verificationStatusViewImpl;
        }

        @Override // com.avito.android.deep_linking.links.OnDeepLinkClickListener
        public final void onDeepLinkClick(@NotNull DeepLink deepLink) {
            Intrinsics.checkNotNullParameter(deepLink, "deepLink");
            this.a.q.invoke(deepLink);
        }
    }

    public static final class b implements OnUrlClickListener {
        public final /* synthetic */ VerificationStatusViewImpl a;

        public b(VerificationStatusViewImpl verificationStatusViewImpl) {
            this.a = verificationStatusViewImpl;
        }

        @Override // com.avito.android.deep_linking.links.OnUrlClickListener
        public final boolean onUrlClick(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "url");
            this.a.r.invoke(str);
            return true;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r25v0, resolved type: kotlin.jvm.functions.Function1<? super com.avito.android.deep_linking.links.DeepLink, kotlin.Unit> */
    /* JADX DEBUG: Multi-variable search result rejected for r26v0, resolved type: kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> */
    /* JADX WARN: Multi-variable type inference failed */
    public VerificationStatusViewImpl(@NotNull View view, @NotNull AttributedTextFormatter attributedTextFormatter, @NotNull Analytics analytics, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02, @NotNull Function0<Unit> function03, @NotNull Function1<? super DeepLink, Unit> function1, @NotNull Function1<? super String, Unit> function12) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "textFormatter");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(function0, "backClicksListener");
        Intrinsics.checkNotNullParameter(function02, "refreshesListener");
        Intrinsics.checkNotNullParameter(function03, "reloadsListener");
        Intrinsics.checkNotNullParameter(function1, "deepLinkListener");
        Intrinsics.checkNotNullParameter(function12, "urlListener");
        this.o = view;
        this.p = attributedTextFormatter;
        this.q = function1;
        this.r = function12;
        this.a = view.getContext();
        View findViewById = view.findViewById(R.id.app_bar);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.app_bar)");
        AppBarLayoutWithIconAction appBarLayoutWithIconAction = (AppBarLayoutWithIconAction) findViewById;
        this.b = appBarLayoutWithIconAction;
        View findViewById2 = view.findViewById(R.id.swipe_refresh);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.swipe_refresh)");
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) findViewById2;
        this.c = swipeRefreshLayout;
        View findViewById3 = view.findViewById(R.id.verification_title);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.verification_title)");
        this.d = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.verification_description);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.verification_description)");
        TextView textView = (TextView) findViewById4;
        this.e = textView;
        View findViewById5 = view.findViewById(R.id.footer_text);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.footer_text)");
        TextView textView2 = (TextView) findViewById5;
        this.f = textView2;
        View findViewById6 = view.findViewById(R.id.verification_image);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.verification_image)");
        this.g = (SimpleDraweeView) findViewById6;
        View findViewById7 = view.findViewById(R.id.verification_banner);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "view.findViewById(R.id.verification_banner)");
        this.h = (AlertBanner) findViewById7;
        View findViewById8 = view.findViewById(R.id.buttons_container);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "view.findViewById(R.id.buttons_container)");
        this.i = (ViewGroup) findViewById8;
        int i2 = R.id.content_container;
        View findViewById9 = view.findViewById(i2);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "view.findViewById(R.id.content_container)");
        this.j = (ViewGroup) findViewById9;
        View findViewById10 = view.findViewById(R.id.progress_root);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "view.findViewById(R.id.progress_root)");
        ProgressOverlay progressOverlay = new ProgressOverlay((ViewGroup) findViewById10, i2, analytics, false, 0, 24, null);
        this.k = progressOverlay;
        appBarLayoutWithIconAction.setClickListener(new AppbarClickListener(function0) { // from class: com.avito.android.verification.verification_status.VerificationStatusViewImpl$setupAppBar$1
            public final /* synthetic */ Function0 b;

            {
                this.b = r2;
            }

            @Override // ru.avito.component.toolbar.AppbarClickListener
            public void onActionClicked() {
                Function0 function04 = VerificationStatusViewImpl.this.n;
                if (function04 != null) {
                    Unit unit = (Unit) function04.invoke();
                }
            }

            @Override // ru.avito.component.toolbar.AppbarClickListener
            public void onHomeClicked() {
                this.b.invoke();
            }
        });
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
        progressOverlay.setOnRefreshListener(function03);
        swipeRefreshLayout.setOnRefreshListener((SwipeRefreshLayout.OnRefreshListener) (function02 != null ? new j(function02) : function02));
    }

    public static final Dialog access$createActionsMenuDialog(VerificationStatusViewImpl verificationStatusViewImpl, List list) {
        Objects.requireNonNull(verificationStatusViewImpl);
        Context context = verificationStatusViewImpl.a;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return new BottomSheetMenuDialog(context, new a2.a.a.r3.a.g(verificationStatusViewImpl, list));
    }

    @Override // com.avito.android.verification.verification_status.VerificationStatusView
    public void setContent(@NotNull VerificationStatusScreenData verificationStatusScreenData) {
        Intrinsics.checkNotNullParameter(verificationStatusScreenData, "screenData");
        this.d.setText(verificationStatusScreenData.getTitle());
        AttributedText description = verificationStatusScreenData.getDescription();
        if (description != null) {
            description.setOnDeepLinkClickListener(this.l);
        }
        if (description != null) {
            description.setOnUrlClickListener(this.m);
        }
        TextView textView = this.e;
        AttributedTextFormatter attributedTextFormatter = this.p;
        Context context = this.a;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        textView.setText(attributedTextFormatter.format(context, description));
        Image image = verificationStatusScreenData.getImage();
        boolean z = true;
        Views.setVisible(this.g, image != null);
        if (image != null) {
            SimpleDraweeViewsKt.getRequestBuilder(this.g).picture(AvitoPictureKt.pictureOf$default(image, false, 0.0f, 0.0f, null, 28, null)).load();
        }
        VerificationStatusScreenData.Banner banner = verificationStatusScreenData.getBanner();
        Views.setVisible(this.h, banner != null);
        Integer num = null;
        if (banner != null) {
            AlertBanner.setContentByAttr$default(this.h, 0, banner.getStyleAttrId(), 1, null);
            this.h.getContent().setTitle(banner.getTitle());
            this.h.getContent().setBody(banner.getDescription());
            if (banner.getDetailsLink() != null) {
                banner.getDetailsLink().setOnDeepLinkClickListener(this.l);
                banner.getDetailsLink().setOnUrlClickListener(this.m);
                AlertBannerContent content = this.h.getContent();
                AttributedTextFormatter attributedTextFormatter2 = this.p;
                Context context2 = this.a;
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                AlertBannerContent.setLink$default(content, attributedTextFormatter2.format(context2, banner.getDetailsLink()), null, 2, null);
            } else {
                AlertBannerContent.setLink$default(this.h.getContent(), null, null, 2, null);
            }
            AlertBannerContent content2 = this.h.getContent();
            Context context3 = this.a;
            Intrinsics.checkNotNullExpressionValue(context3, "context");
            content2.setImageDrawable(Contexts.getDrawableByAttr(context3, banner.getIconAttrId()));
        }
        AttributedText footerInfo = verificationStatusScreenData.getFooterInfo();
        if (footerInfo != null) {
            footerInfo.setOnDeepLinkClickListener(this.l);
        }
        if (footerInfo != null) {
            footerInfo.setOnUrlClickListener(this.m);
        }
        TextView textView2 = this.f;
        AttributedTextFormatter attributedTextFormatter3 = this.p;
        Context context4 = this.a;
        Intrinsics.checkNotNullExpressionValue(context4, "context");
        textView2.setText(attributedTextFormatter3.format(context4, footerInfo));
        TextView textView3 = this.f;
        if (footerInfo == null) {
            z = false;
        }
        Views.setVisible(textView3, z);
        List<VerificationStatusScreenData.Button> buttons = verificationStatusScreenData.getButtons();
        this.i.removeAllViews();
        if (buttons != null) {
            for (T t : buttons) {
                Context context5 = this.a;
                Intrinsics.checkNotNullExpressionValue(context5, "context");
                Button button = new Button(context5);
                button.setAppearanceFromAttr(t.getStyleAttrId());
                button.setText(t.getTitle());
                button.setEnabled(t.isEnabled());
                button.setOnClickListener(new h(t, this));
                this.i.addView(button);
                ViewGroup.LayoutParams layoutParams = button.getLayoutParams();
                Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.setMargins(0, ViewSizeKt.getDp(10), 0, 0);
                button.setLayoutParams(marginLayoutParams);
            }
        }
        Integer actionIconAttrId = verificationStatusScreenData.getActionIconAttrId();
        List<VerificationStatusScreenData.Action> actions = verificationStatusScreenData.getActions();
        AppBarLayoutWithIconAction appBarLayoutWithIconAction = this.b;
        if (actionIconAttrId != null) {
            int intValue = actionIconAttrId.intValue();
            Context context6 = this.a;
            Intrinsics.checkNotNullExpressionValue(context6, "context");
            num = Integer.valueOf(Contexts.getResourceIdByAttr(context6, intValue));
        }
        Context context7 = this.a;
        Intrinsics.checkNotNullExpressionValue(context7, "context");
        appBarLayoutWithIconAction.setActionIcon(num, Integer.valueOf(Contexts.getColorByAttr(context7, com.avito.android.lib.design.R.attr.black)));
        if (actions != null) {
            this.n = new i(this, actions);
        }
    }

    @Override // com.avito.android.verification.verification_status.VerificationStatusView
    public void showAlert(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        SnackbarExtensionsKt.showSnackbar$default(this.i, str, 0, (String) null, 0, (Function0) null, 0, SnackbarPosition.ABOVE_VIEW, (SnackbarType) null, 190, (Object) null);
    }

    @Override // com.avito.android.verification.verification_status.VerificationStatusView
    public void showContent() {
        if (this.c.isRefreshing()) {
            this.c.setRefreshing(false);
        }
        if (!this.k.isContentVisible()) {
            this.k.showContent();
        }
    }

    @Override // com.avito.android.verification.verification_status.VerificationStatusView
    public void showError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "error");
        if (this.c.isRefreshing()) {
            this.c.setRefreshing(false);
        }
        AppBarLayoutWithIconAction.setActionIcon$default(this.b, null, null, 2, null);
        this.k.showLoadingProblem(str);
    }

    @Override // com.avito.android.verification.verification_status.VerificationStatusView
    public void showErrorAlert(@NotNull String str, @Nullable Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str, "text");
        ViewGroup viewGroup = this.j;
        SnackbarType snackbarType = SnackbarType.ERROR;
        SnackbarExtensionsKt.showSnackbar$default(viewGroup, str, 0, (String) null, function0 != null ? R.string.verification_retry_action : 0, function0, 0, SnackbarPosition.OVERLAY_VIEW_TOP, snackbarType, 38, (Object) null);
    }

    @Override // com.avito.android.verification.verification_status.VerificationStatusView
    public void showLoading() {
        this.k.showLoading();
    }
}
