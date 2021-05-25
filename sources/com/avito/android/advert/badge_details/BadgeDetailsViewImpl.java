package com.avito.android.advert.badge_details;

import a2.g.r.g;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.TextView;
import com.avito.android.advert_core.analytics.contactbar.PhonePageSourceKt;
import com.avito.android.advert_details.R;
import com.avito.android.lib.design.bottom_sheet.BottomSheetDialog;
import com.avito.android.lib.design.bottom_sheet.RightCrossHeaderKt;
import com.avito.android.lib.design.button.Button;
import com.avito.android.lib.design.button.ButtonsKt;
import com.avito.android.lib.design.snackbar.SnackbarExtensionsKt;
import com.avito.android.lib.design.snackbar.SnackbarPosition;
import com.avito.android.lib.design.snackbar.SnackbarType;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.jakewharton.rxrelay3.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010&\u001a\u00020#¢\u0006\u0004\b2\u00103J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u0019\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0006J\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u0006RD\u0010\u0014\u001a0\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u00040\u0004 \u0010*\u0017\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u000f¢\u0006\u0002\b\u00110\u000f¢\u0006\u0002\b\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\"\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040\u001d8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010,\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010%R\"\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00040\u001d8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b-\u0010\u001f\u001a\u0004\b.\u0010!RD\u00101\u001a0\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u00040\u0004 \u0010*\u0017\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u000f¢\u0006\u0002\b\u00110\u000f¢\u0006\u0002\b\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u0010\u0013¨\u00064"}, d2 = {"Lcom/avito/android/advert/badge_details/BadgeDetailsViewImpl;", "Lcom/avito/android/advert/badge_details/BadgeDetailsView;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "description", "setDescription", "text", "setButtonText", "showLoading", "()V", "showContent", "showError", "Lcom/jakewharton/rxrelay3/PublishRelay;", "kotlin.jvm.PlatformType", "Lio/reactivex/rxjava3/annotations/NonNull;", "e", "Lcom/jakewharton/rxrelay3/PublishRelay;", "dismissRelay", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "descriptionView", "Lcom/avito/android/lib/design/button/Button;", "c", "Lcom/avito/android/lib/design/button/Button;", PhonePageSourceKt.PHONE_SOURCE_BUTTON, "Lio/reactivex/rxjava3/core/Observable;", "h", "Lio/reactivex/rxjava3/core/Observable;", "getDialogDismisses", "()Lio/reactivex/rxjava3/core/Observable;", "dialogDismisses", "Landroid/view/View;", "i", "Landroid/view/View;", "view", "Lcom/avito/android/lib/design/bottom_sheet/BottomSheetDialog;", AuthSource.SEND_ABUSE, "Lcom/avito/android/lib/design/bottom_sheet/BottomSheetDialog;", "dialog", AuthSource.BOOKING_ORDER, "progressView", g.a, "getButtonClicks", "buttonClicks", "f", "buttonClicksRelay", "<init>", "(Landroid/view/View;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class BadgeDetailsViewImpl implements BadgeDetailsView {
    public final BottomSheetDialog a;
    public final View b;
    public Button c;
    public TextView d;
    public final PublishRelay<Unit> e;
    public final PublishRelay<Unit> f;
    @NotNull
    public final Observable<Unit> g;
    @NotNull
    public final Observable<Unit> h;
    public final View i;

    public static final class a extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ BadgeDetailsViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(BadgeDetailsViewImpl badgeDetailsViewImpl) {
            super(1);
            this.a = badgeDetailsViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(view2, VKApiConst.VERSION);
            BadgeDetailsViewImpl badgeDetailsViewImpl = this.a;
            View findViewById = view2.findViewById(R.id.description);
            Intrinsics.checkNotNullExpressionValue(findViewById, "v.findViewById(R.id.description)");
            badgeDetailsViewImpl.d = (TextView) findViewById;
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ BadgeDetailsViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(BadgeDetailsViewImpl badgeDetailsViewImpl) {
            super(1);
            this.a = badgeDetailsViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(view2, VKApiConst.VERSION);
            BadgeDetailsViewImpl badgeDetailsViewImpl = this.a;
            View findViewById = view2.findViewById(R.id.button_badge_details);
            Intrinsics.checkNotNullExpressionValue(findViewById, "v.findViewById(R.id.button_badge_details)");
            badgeDetailsViewImpl.c = (Button) findViewById;
            BadgeDetailsViewImpl.access$getButton$p(this.a).setOnClickListener(new a2.a.a.f.u.c(this));
            return Unit.INSTANCE;
        }
    }

    public static final class c implements DialogInterface.OnDismissListener {
        public final /* synthetic */ BadgeDetailsViewImpl a;

        public c(BadgeDetailsViewImpl badgeDetailsViewImpl) {
            this.a = badgeDetailsViewImpl;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            this.a.e.accept(Unit.INSTANCE);
        }
    }

    public BadgeDetailsViewImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.i = view;
        View findViewById = view.findViewById(R.id.progress_view);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById<View>(R.id.progress_view)");
        this.b = findViewById;
        PublishRelay<Unit> create = PublishRelay.create();
        this.e = create;
        PublishRelay<Unit> create2 = PublishRelay.create();
        this.f = create2;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context, 0, 2, null);
        BottomSheetDialog.setHeaderParams$default(bottomSheetDialog, null, null, false, true, 7, null);
        bottomSheetDialog.setContentView(R.layout.badge_details_content, R.layout.badge_details_footer, new a(this), new b(this), true);
        this.a = bottomSheetDialog;
        bottomSheetDialog.setOnDismissListener(new c(this));
        Intrinsics.checkNotNullExpressionValue(create2, "buttonClicksRelay");
        this.g = create2;
        Intrinsics.checkNotNullExpressionValue(create, "dismissRelay");
        this.h = create;
    }

    public static final /* synthetic */ Button access$getButton$p(BadgeDetailsViewImpl badgeDetailsViewImpl) {
        Button button = badgeDetailsViewImpl.c;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException(PhonePageSourceKt.PHONE_SOURCE_BUTTON);
        }
        return button;
    }

    public static final /* synthetic */ TextView access$getDescriptionView$p(BadgeDetailsViewImpl badgeDetailsViewImpl) {
        TextView textView = badgeDetailsViewImpl.d;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("descriptionView");
        }
        return textView;
    }

    @Override // com.avito.android.advert.badge_details.BadgeDetailsView
    @NotNull
    public Observable<Unit> getButtonClicks() {
        return this.g;
    }

    @Override // com.avito.android.advert.badge_details.BadgeDetailsView
    @NotNull
    public Observable<Unit> getDialogDismisses() {
        return this.h;
    }

    @Override // com.avito.android.advert.badge_details.BadgeDetailsView
    public void setButtonText(@Nullable String str) {
        Button button = this.c;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException(PhonePageSourceKt.PHONE_SOURCE_BUTTON);
        }
        ButtonsKt.bindText$default(button, str, false, 2, null);
    }

    @Override // com.avito.android.advert.badge_details.BadgeDetailsView
    public void setDescription(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "description");
        TextView textView = this.d;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("descriptionView");
        }
        TextViews.bindText$default(textView, str, false, 2, null);
    }

    @Override // com.avito.android.advert.badge_details.BadgeDetailsView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        RightCrossHeaderKt.setRightCrossHeader(this.a, str, true, true);
    }

    @Override // com.avito.android.advert.badge_details.BadgeDetailsView
    public void showContent() {
        Views.hide(this.b);
        this.a.show();
    }

    @Override // com.avito.android.advert.badge_details.BadgeDetailsView
    public void showError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        Views.hide(this.b);
        SnackbarExtensionsKt.showSnackbar$default(this.i, str, 0, (String) null, 0, (Function0) null, 0, (SnackbarPosition) null, (SnackbarType) null, 254, (Object) null);
        this.a.dismiss();
    }

    @Override // com.avito.android.advert.badge_details.BadgeDetailsView
    public void showLoading() {
        Views.show(this.b);
    }
}
