package com.avito.android.advert.item.dfpcreditinfo.calculator;

import a2.a.a.f.x.t.i.b;
import a2.a.a.f.x.t.i.c;
import a2.a.a.f.x.t.i.d;
import a2.g.r.g;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.avito.android.advert.item.dfpcreditinfo.CreditInfoResourcesProvider;
import com.avito.android.advert.item.dfpcreditinfo.DfpCreditButton;
import com.avito.android.advert_details.R;
import com.avito.android.lib.design.button.Button;
import com.avito.android.lib.design.input.Input;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.UrlSpan;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u00106\u001a\u000205\u0012\u0006\u00108\u001a\u000207\u0012\u0006\u0010:\u001a\u000209¢\u0006\u0004\b;\u0010<Jg\u0010\u000e\u001a\u00020\r2\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0006\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00042\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010&\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b%\u0010#R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010,\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b+\u0010#R\u0018\u0010.\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b-\u0010#R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u00104\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b3\u0010)¨\u0006="}, d2 = {"Lcom/avito/android/advert/item/dfpcreditinfo/calculator/SravniCalculatorView;", "Lcom/avito/android/advert/item/dfpcreditinfo/calculator/CreditCalculatorView;", "Lkotlin/Pair;", "", "", "initialPayment", FirebaseAnalytics.Param.TERM, "", "terms", "inputHint", "loan", "monthlyPayment", "percent", "", "setData", "(Lkotlin/Pair;ILjava/util/List;Ljava/lang/String;Lkotlin/Pair;Ljava/lang/String;Ljava/lang/String;)V", "text", ShareConstants.WEB_DIALOG_PARAM_PRIVACY, "privacyLink", "showButton", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "", "hasFocus", "()Z", "clearFocus", "()V", "Lcom/avito/android/lib/design/button/Button;", "j", "Lcom/avito/android/lib/design/button/Button;", "sravniButton", AuthSource.OPEN_CHANNEL_LIST, "I", "termPickerValue", "Landroid/widget/TextView;", "k", "Landroid/widget/TextView;", "sravniPrivacyTextView", "e", "loanView", "Lcom/avito/android/lib/design/input/Input;", "h", "Lcom/avito/android/lib/design/input/Input;", "initialPaymentInputView", "f", "monthlyPaymentView", g.a, "percentView", "Landroid/text/TextWatcher;", "l", "Landroid/text/TextWatcher;", "initialPaymentTextWatcher", "i", "termInputView", "Landroid/view/View;", "view", "Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditButton$Listener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/avito/android/advert/item/dfpcreditinfo/CreditInfoResourcesProvider;", "resourcesProvider", "<init>", "(Landroid/view/View;Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditButton$Listener;Lcom/avito/android/advert/item/dfpcreditinfo/CreditInfoResourcesProvider;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class SravniCalculatorView extends CreditCalculatorView {
    public TextView e;
    public TextView f;
    public TextView g;
    public Input h;
    public Input i;
    public Button j;
    public TextView k;
    public TextWatcher l;
    public int m;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ SravniCalculatorView a;

        public a(SravniCalculatorView sravniCalculatorView) {
            this.a = sravniCalculatorView;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.getListener().onCreditButtonClick();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SravniCalculatorView(@NotNull View view, @NotNull DfpCreditButton.Listener listener, @NotNull CreditInfoResourcesProvider creditInfoResourcesProvider) {
        super(view, listener, creditInfoResourcesProvider, R.layout.advert_details_credit_info, R.layout.advert_details_credit_inputs);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.checkNotNullParameter(creditInfoResourcesProvider, "resourcesProvider");
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.calculator.CreditCalculatorView
    public void clearFocus() {
        Input input = this.h;
        if (input != null) {
            input.clearInputFocus();
        }
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.calculator.CreditCalculatorView
    public boolean hasFocus() {
        Input input = this.h;
        if (input != null) {
            return input.hasFocus();
        }
        return false;
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.calculator.CreditCalculatorView
    public void setData(@NotNull Pair<Integer, String> pair, int i2, @NotNull List<Integer> list, @Nullable String str, @NotNull Pair<Integer, String> pair2, @NotNull String str2, @NotNull String str3) {
        Input input;
        Input input2;
        Intrinsics.checkNotNullParameter(pair, "initialPayment");
        Intrinsics.checkNotNullParameter(list, "terms");
        Intrinsics.checkNotNullParameter(pair2, "loan");
        Intrinsics.checkNotNullParameter(str2, "monthlyPayment");
        Intrinsics.checkNotNullParameter(str3, "percent");
        String second = pair2.getSecond();
        if (this.e == null) {
            View findViewById = getView().findViewById(R.id.info_container);
            Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
            if (findViewById instanceof ViewStub) {
                findViewById = ((ViewStub) findViewById).inflate();
            }
            this.e = (TextView) findViewById.findViewById(R.id.loan);
            this.f = (TextView) findViewById.findViewById(R.id.monthly_payment);
            this.g = (TextView) findViewById.findViewById(R.id.percent);
        }
        TextView textView = this.e;
        if (textView != null) {
            textView.setText(second);
        }
        TextView textView2 = this.f;
        if (textView2 != null) {
            textView2.setText(str2);
        }
        TextView textView3 = this.g;
        if (textView3 != null) {
            textView3.setText(str3);
        }
        int intValue = pair.getFirst().intValue();
        String valueOf = String.valueOf(intValue);
        Input input3 = this.h;
        String deformattedText = input3 != null ? input3.getDeformattedText() : null;
        if (!Intrinsics.areEqual(valueOf, deformattedText) || this.m != i2) {
            if (this.h == null) {
                View findViewById2 = getView().findViewById(R.id.input_container);
                Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.View");
                if (findViewById2 instanceof ViewStub) {
                    findViewById2 = ((ViewStub) findViewById2).inflate();
                }
                this.h = (Input) findViewById2.findViewById(R.id.initial_payment_input);
                this.i = (Input) findViewById2.findViewById(R.id.term_input);
            }
            TextWatcher textWatcher = this.l;
            if (!(textWatcher == null || (input2 = this.h) == null)) {
                input2.removeTextChangedListener(textWatcher);
            }
            Input input4 = this.h;
            if (input4 != null) {
                input4.setFocusChangeListener(null);
            }
            Input input5 = this.h;
            if (input5 != null) {
                input5.setOnEditorActionListener(null);
            }
            Input input6 = this.i;
            if (input6 != null) {
                input6.setOnClickListener(null);
            }
            if ((!Intrinsics.areEqual(valueOf, deformattedText)) && (input = this.h) != null) {
                input.setTextWithoutWatcher(String.valueOf(intValue));
                Editable text = input.m90getText();
                input.setSelection(Math.max(0, (text != null ? text.length() : 0) - 2));
            }
            Input input7 = this.h;
            if (input7 != null) {
                input7.setOnEditorActionListener(new c(this));
            }
            SravniCalculatorView$createInitialPaymentTextWatcher$1 sravniCalculatorView$createInitialPaymentTextWatcher$1 = new SravniCalculatorView$createInitialPaymentTextWatcher$1(this);
            Input input8 = this.h;
            if (input8 != null) {
                input8.addTextChangedListener(sravniCalculatorView$createInitialPaymentTextWatcher$1);
            }
            this.l = sravniCalculatorView$createInitialPaymentTextWatcher$1;
            Input input9 = this.h;
            if (input9 != null) {
                input9.setFocusChangeListener(new d(this));
            }
            this.m = i2;
            Input input10 = this.i;
            if (input10 != null) {
                Input.setText$default(input10, formatTerm(i2, true), false, 2, null);
            }
            Input input11 = this.i;
            if (input11 != null) {
                input11.setOnClickListener(new b(this, list));
            }
        }
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.calculator.CreditCalculatorView
    public void showButton(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        a2.b.a.a.a.Z0(str, "text", str2, ShareConstants.WEB_DIALOG_PARAM_PRIVACY, str3, "privacyLink");
        if (this.j == null) {
            View findViewById = getView().findViewById(R.id.show_form_button_container);
            Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
            if (findViewById instanceof ViewStub) {
                findViewById = ((ViewStub) findViewById).inflate();
            }
            this.j = (Button) findViewById.findViewById(R.id.show_form_button);
            TextView textView = (TextView) findViewById.findViewById(R.id.privacy_info);
            this.k = textView;
            if (textView != null) {
                textView.setMovementMethod(new LinkMovementMethod());
            }
        }
        Button button = this.j;
        if (button != null) {
            button.setText(str);
        }
        Button button2 = this.j;
        if (button2 != null) {
            button2.setOnClickListener(new a(this));
        }
        TextView textView2 = this.k;
        if (textView2 != null) {
            SpannableString spannableString = new SpannableString(str2);
            int indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str2, str3, 0, false, 6, (Object) null);
            if (indexOf$default != -1) {
                spannableString.setSpan(new UrlSpan("", new a2.a.a.f.x.t.i.a(this, str2, str3), false, 4, null), indexOf$default, str3.length() + indexOf$default, 33);
            }
            textView2.setText(spannableString);
        }
    }
}
