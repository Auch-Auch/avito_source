package com.avito.android.advert.item.dfpcreditinfo;

import a2.g.r.g;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.avito.android.advert.item.dfpcreditinfo.calculator.CreditCalculatorView;
import com.avito.android.advert.item.dfpcreditinfo.calculator.Type;
import com.avito.android.advert_details.R;
import com.avito.android.lastclick.LastClick;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Contexts;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.android.util.TypefaceType;
import com.avito.android.util.Typefaces;
import com.avito.android.util.Views;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u0001:\u0001eB\u0017\u0012\u0006\u0010a\u001a\u00020=\u0012\u0006\u0010J\u001a\u00020G¢\u0006\u0004\bc\u0010dJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\bJ\u001f\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJg\u0010)\u001a\u00020\u00062\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00020\u001f2\u0006\u0010\"\u001a\u00020 2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020 0#2\b\u0010%\u001a\u0004\u0018\u00010\u00022\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00020\u001f2\u0006\u0010'\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u0002H\u0016¢\u0006\u0004\b)\u0010*J'\u0010-\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\u00022\u0006\u0010,\u001a\u00020\u0002H\u0016¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\u0006H\u0016¢\u0006\u0004\b/\u00100J\u0017\u00102\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u0004H\u0016¢\u0006\u0004\b2\u0010\u0018J\u000f\u00103\u001a\u00020\u0006H\u0016¢\u0006\u0004\b3\u00100J\u000f\u00104\u001a\u00020\u0004H\u0016¢\u0006\u0004\b4\u00105J\u000f\u00106\u001a\u00020\u0006H\u0016¢\u0006\u0004\b6\u00100J\u0017\u00108\u001a\u00020\u00062\u0006\u00107\u001a\u00020\u0004H\u0002¢\u0006\u0004\b8\u0010\u0018R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010@\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010J\u001a\u00020G8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010N\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010P\u001a\u00020=8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bO\u0010?R\u0016\u0010T\u001a\u00020Q8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bR\u0010SR\u0018\u0010X\u001a\u0004\u0018\u00010U8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010Z\u001a\u00020=8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bY\u0010?R\u001c\u0010]\u001a\b\u0012\u0004\u0012\u00020=0#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010_\u001a\u00020Q8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b^\u0010SR\u0016\u0010a\u001a\u00020=8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b`\u0010?R\u0016\u0010b\u001a\u00020=8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u0010?¨\u0006f"}, d2 = {"Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditButton;", "Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditInfoView;", "", "title", "", "isBig", "", "setTitle", "(Ljava/lang/String;Z)V", "text", "isMedium", "setText", "setTitleWithPrice", "(Ljava/lang/String;Ljava/lang/String;)V", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "setIcon", "(Landroid/net/Uri;)V", "Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditButton$Listener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setListener", "(Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditButton$Listener;)V", "force", "dismissDialog", "(Z)V", "showLegalInfoDialog", "(Ljava/lang/String;)V", "Lcom/avito/android/advert/item/dfpcreditinfo/calculator/Type;", "type", "initializeCalculator", "(Lcom/avito/android/advert/item/dfpcreditinfo/calculator/Type;)V", "Lkotlin/Pair;", "", "initialPayment", FirebaseAnalytics.Param.TERM, "", "terms", "inputHint", "loan", "monthlyPayment", "percent", "setCalculatorData", "(Lkotlin/Pair;ILjava/util/List;Ljava/lang/String;Lkotlin/Pair;Ljava/lang/String;Ljava/lang/String;)V", ShareConstants.WEB_DIALOG_PARAM_PRIVACY, "privacyLink", "showButton", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "hideContent", "()V", "isShowTopDivider", "showAdContent", "showStubContent", "isEditing", "()Z", "clearFocus", "isTitleBig", AuthSource.SEND_ABUSE, "Lcom/facebook/drawee/view/SimpleDraweeView;", "f", "Lcom/facebook/drawee/view/SimpleDraweeView;", "icon", "Landroid/view/View;", "h", "Landroid/view/View;", "dividerTop", "l", "Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditButton$Listener;", "Landroid/widget/ImageView;", g.a, "Landroid/widget/ImageView;", "info", "Lcom/avito/android/advert/item/dfpcreditinfo/CreditInfoResourcesProvider;", "n", "Lcom/avito/android/advert/item/dfpcreditinfo/CreditInfoResourcesProvider;", "resourcesProvider", "Lcom/avito/android/advert/item/dfpcreditinfo/calculator/CreditCalculatorView;", "k", "Lcom/avito/android/advert/item/dfpcreditinfo/calculator/CreditCalculatorView;", "calculatorView", "i", "clickArea", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "titleView", "Landroidx/appcompat/app/AlertDialog;", "j", "Landroidx/appcompat/app/AlertDialog;", "legalInfoDialog", "c", "adRoot", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "stubLines", "e", "textView", AuthSource.OPEN_CHANNEL_LIST, "view", "stubRoot", "<init>", "(Landroid/view/View;Lcom/avito/android/advert/item/dfpcreditinfo/CreditInfoResourcesProvider;)V", "Listener", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class DfpCreditButton implements DfpCreditInfoView {
    public final View a;
    public final List<View> b;
    public final View c;
    public final TextView d;
    public final TextView e;
    public final SimpleDraweeView f;
    public final ImageView g;
    public final View h;
    public final View i;
    public AlertDialog j;
    public CreditCalculatorView k;
    public Listener l;
    public final View m;
    public final CreditInfoResourcesProvider n;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\n\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\u0004J\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0010H&¢\u0006\u0004\b\u0015\u0010\u0013J\u000f\u0010\u0016\u001a\u00020\u0002H&¢\u0006\u0004\b\u0016\u0010\u0004J\u0017\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0010H&¢\u0006\u0004\b\u0018\u0010\u0013¨\u0006\u0019"}, d2 = {"Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditButton$Listener;", "", "", "onAdBlockShown", "()V", "onCreditHeaderClick", "onCreditTextClick", "onCreditIconClick", "onCreditInfoButtonClick", "onLegalInfoDialogDismiss", "onCreditButtonClick", "onCreditPrivacyLinkClick", "", "hasFocus", "onInputFieldFocusChanged", "(Z)V", "", "initialPayment", "onInitialPaymentChanged", "(I)V", "loan", "onLoanChanged", "onTermClicked", FirebaseAnalytics.Param.TERM, "onTermSelected", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    public interface Listener {
        void onAdBlockShown();

        void onCreditButtonClick();

        void onCreditHeaderClick();

        void onCreditIconClick();

        void onCreditInfoButtonClick();

        void onCreditPrivacyLinkClick();

        void onCreditTextClick();

        void onInitialPaymentChanged(int i);

        void onInputFieldFocusChanged(boolean z);

        void onLegalInfoDialogDismiss();

        void onLoanChanged(int i);

        void onTermClicked();

        void onTermSelected(int i);
    }

    /* compiled from: java-style lambda group */
    public static final class a implements View.OnClickListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.a;
            if (i == 0) {
                Listener listener = ((DfpCreditButton) this.b).l;
                if (listener != null) {
                    listener.onCreditIconClick();
                }
            } else if (i == 1) {
                Listener listener2 = ((DfpCreditButton) this.b).l;
                if (listener2 != null) {
                    listener2.onCreditHeaderClick();
                }
            } else if (i == 2) {
                Listener listener3 = ((DfpCreditButton) this.b).l;
                if (listener3 != null) {
                    listener3.onCreditTextClick();
                }
            } else if (i == 3) {
                Listener listener4 = ((DfpCreditButton) this.b).l;
                if (listener4 != null) {
                    listener4.onCreditIconClick();
                }
            } else if (i == 4) {
                Listener listener5 = ((DfpCreditButton) this.b).l;
                if (listener5 != null) {
                    listener5.onCreditInfoButtonClick();
                }
            } else {
                throw null;
            }
        }
    }

    public static final class b implements DialogInterface.OnClickListener {
        public static final b a = new b();

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(@NotNull DialogInterface dialogInterface, int i) {
            Intrinsics.checkNotNullParameter(dialogInterface, "dialog");
            dialogInterface.dismiss();
            LastClick.Updater.update();
        }
    }

    public static final class c implements DialogInterface.OnDismissListener {
        public final /* synthetic */ DfpCreditButton a;

        public c(DfpCreditButton dfpCreditButton) {
            this.a = dfpCreditButton;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            Listener listener = this.a.l;
            if (listener != null) {
                listener.onLegalInfoDialogDismiss();
            }
            LastClick.Updater.update();
        }
    }

    public DfpCreditButton(@NotNull View view, @NotNull CreditInfoResourcesProvider creditInfoResourcesProvider) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(creditInfoResourcesProvider, "resourcesProvider");
        this.m = view;
        this.n = creditInfoResourcesProvider;
        View findViewById = view.findViewById(R.id.stub_root);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        this.a = findViewById;
        View findViewById2 = view.findViewById(R.id.constr_title);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.View");
        View findViewById3 = view.findViewById(R.id.constr_subtitle1);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.view.View");
        View findViewById4 = view.findViewById(R.id.constr_subtitle2);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.view.View");
        this.b = CollectionsKt__CollectionsKt.listOf((Object[]) new View[]{findViewById2, findViewById3, findViewById4});
        View findViewById5 = view.findViewById(R.id.ad_root);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.view.View");
        this.c = findViewById5;
        View findViewById6 = view.findViewById(R.id.title);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) findViewById6;
        this.d = textView;
        View findViewById7 = view.findViewById(R.id.subtitle);
        Objects.requireNonNull(findViewById7, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView2 = (TextView) findViewById7;
        this.e = textView2;
        View findViewById8 = view.findViewById(R.id.icon);
        Objects.requireNonNull(findViewById8, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById8;
        this.f = simpleDraweeView;
        View findViewById9 = view.findViewById(R.id.info_icon);
        Objects.requireNonNull(findViewById9, "null cannot be cast to non-null type android.widget.ImageView");
        ImageView imageView = (ImageView) findViewById9;
        this.g = imageView;
        this.h = view.findViewById(R.id.divider_top);
        View findViewById10 = view.findViewById(R.id.click_area);
        Objects.requireNonNull(findViewById10, "null cannot be cast to non-null type android.view.View");
        this.i = findViewById10;
        findViewById10.setOnClickListener(new a(0, this));
        textView.setOnClickListener(new a(1, this));
        textView2.setOnClickListener(new a(2, this));
        simpleDraweeView.setOnClickListener(new a(3, this));
        imageView.setOnClickListener(new a(4, this));
    }

    public final void a(boolean z) {
        int i2;
        if (z) {
            i2 = R.dimen.advert_credit_info_top_margin_with_big_title;
        } else {
            i2 = R.dimen.advert_credit_info_top_margin_with_title;
        }
        ViewGroup.LayoutParams layoutParams = this.g.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        Context context = this.m.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = context.getResources().getDimensionPixelSize(i2);
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.DfpCreditInfoView
    public void clearFocus() {
        CreditCalculatorView creditCalculatorView = this.k;
        if (creditCalculatorView != null) {
            creditCalculatorView.clearFocus();
        }
        Listener listener = this.l;
        if (listener != null) {
            listener.onInputFieldFocusChanged(false);
        }
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.DfpCreditInfoView
    public void dismissDialog(boolean z) {
        AlertDialog alertDialog = this.j;
        if (alertDialog != null) {
            if (z) {
                alertDialog.setOnDismissListener(null);
            }
            alertDialog.dismiss();
        }
        this.j = null;
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.DfpCreditInfoView
    public void hideContent() {
        Views.hide(this.a);
        Views.hide(this.c);
        Views.hide(this.h);
        Views.hide(this.m);
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.DfpCreditInfoView
    public void initializeCalculator(@NotNull Type type) {
        Intrinsics.checkNotNullParameter(type, "type");
        Listener listener = this.l;
        if (this.k == null && listener != null) {
            if (type == Type.TINKOFF) {
                Views.hide(this.g);
            }
            this.k = CreditCalculatorView.Companion.create(type, this.m, this.n, listener);
        }
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.DfpCreditInfoView
    public boolean isEditing() {
        CreditCalculatorView creditCalculatorView = this.k;
        if (creditCalculatorView != null) {
            return creditCalculatorView.hasFocus();
        }
        return false;
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.DfpCreditInfoView
    public void setCalculatorData(@NotNull Pair<Integer, String> pair, int i2, @NotNull List<Integer> list, @Nullable String str, @NotNull Pair<Integer, String> pair2, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(pair, "initialPayment");
        Intrinsics.checkNotNullParameter(list, "terms");
        Intrinsics.checkNotNullParameter(pair2, "loan");
        Intrinsics.checkNotNullParameter(str2, "monthlyPayment");
        Intrinsics.checkNotNullParameter(str3, "percent");
        CreditCalculatorView creditCalculatorView = this.k;
        if (creditCalculatorView != null) {
            creditCalculatorView.setData(pair, i2, list, str, pair2, str2, str3);
        }
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.DfpCreditInfoView
    public void setIcon(@Nullable Uri uri) {
        if (uri != null) {
            SimpleDraweeViewsKt.getRequestBuilder(this.f).uri(uri).load();
        }
        this.f.setVisibility(uri != null ? 0 : 8);
        int dimensionPixelOffset = uri != null ? this.m.getResources().getDimensionPixelOffset(R.dimen.advert_credit_image_margin) : 0;
        for (View view : CollectionsKt___CollectionsKt.plus((Collection) this.b, (Iterable) CollectionsKt__CollectionsKt.listOf((Object[]) new TextView[]{this.d, this.e}))) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = dimensionPixelOffset;
        }
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.DfpCreditInfoView
    public void setListener(@NotNull Listener listener) {
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.l = listener;
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.DfpCreditInfoView
    public void setText(@NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.e.setVisibility(0);
        this.e.setText(str);
        int i2 = z ? com.avito.android.lib.design.avito.R.color.avito_black : com.avito.android.lib.design.avito.R.color.avito_gray_48;
        TextView textView = this.e;
        Context context = this.m.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        textView.setTextColor(Contexts.getColorCompat(context, i2));
        this.e.setTextSize(0, this.m.getResources().getDimension(z ? R.dimen.advert_credit_subtitle_size_medium : R.dimen.advert_credit_subtitle_size));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v3, resolved type: android.text.SpannableStringBuilder */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.avito.android.advert.item.dfpcreditinfo.DfpCreditInfoView
    public void setTitle(@NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "title");
        Context context = this.m.getContext();
        this.d.setSingleLine(!z);
        TextView textView = this.d;
        if (z) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            Intrinsics.checkNotNullExpressionValue(context, "context");
            spannableStringBuilder.setSpan(Typefaces.getSpan(context, TypefaceType.Bold), 0, str.length(), 33);
            str = spannableStringBuilder;
        }
        textView.setText(str);
        this.d.setTextSize(0, this.m.getResources().getDimension(z ? R.dimen.advert_credit_title_size_big : R.dimen.advert_credit_title_size));
        int i2 = z ? R.dimen.advert_credit_big_title_top_margin : R.dimen.advert_credit_title_top_margin;
        int i3 = z ? R.dimen.advert_credit_big_title_bottom_margin : R.dimen.advert_credit_title_bottom_margin;
        ViewGroup.LayoutParams layoutParams = this.d.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        marginLayoutParams.topMargin = context.getResources().getDimensionPixelSize(i2);
        marginLayoutParams.bottomMargin = context.getResources().getDimensionPixelSize(i3);
        a(z);
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.DfpCreditInfoView
    public void setTitleWithPrice(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "text");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(a2.b.a.a.a.L2(str, ' ', str2));
        Context context = this.m.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        spannableStringBuilder.setSpan(Typefaces.getSpan(context, TypefaceType.Bold), 0, str.length(), 33);
        this.d.setText(spannableStringBuilder);
        this.e.setVisibility(8);
        this.e.setText((CharSequence) null);
        this.d.setSingleLine(false);
        a(false);
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.DfpCreditInfoView
    public void showAdContent(boolean z) {
        Views.hide(this.a);
        Views.show(this.c);
        Views.show(this.m);
        if (z) {
            Views.show(this.h);
        } else {
            Views.hide(this.h);
        }
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.DfpCreditInfoView
    public void showButton(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        a2.b.a.a.a.Z0(str, "text", str2, ShareConstants.WEB_DIALOG_PARAM_PRIVACY, str3, "privacyLink");
        CreditCalculatorView creditCalculatorView = this.k;
        if (creditCalculatorView != null) {
            creditCalculatorView.showButton(str, str2, str3);
        }
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.DfpCreditInfoView
    public void showLegalInfoDialog(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        AlertDialog alertDialog = this.j;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        AlertDialog show = new AlertDialog.Builder(this.g.getContext()).setMessage(str).setPositiveButton(com.avito.android.ui_components.R.string.ok, b.a).show();
        this.j = show;
        if (show != null) {
            show.setOnDismissListener(new c(this));
        }
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.DfpCreditInfoView
    public void showStubContent() {
        Views.show(this.a);
        Views.hide(this.c);
        Views.hide(this.h);
        Views.show(this.m);
    }
}
