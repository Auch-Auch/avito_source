package com.avito.android.advert.item.dfpcreditinfo.calculator;

import a2.a.a.f.x.t.i.e;
import a2.a.a.f.x.t.i.f;
import a2.g.r.g;
import android.text.Editable;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.avito.android.advert.item.dfpcreditinfo.CreditInfoResourcesProvider;
import com.avito.android.advert.item.dfpcreditinfo.DfpCreditButton;
import com.avito.android.advert_core.analytics.contactbar.PhonePageSourceKt;
import com.avito.android.advert_details.R;
import com.avito.android.lib.design.button.Button;
import com.avito.android.lib.design.component_container.ComponentContainer;
import com.avito.android.lib.design.input.Input;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u00104\u001a\u000203\u0012\u0006\u00106\u001a\u000205\u0012\u0006\u00108\u001a\u000207¢\u0006\u0004\b9\u0010:Jg\u0010\u000e\u001a\u00020\r2\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0006\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00042\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010.\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b-\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u0010#R\u0018\u00102\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b1\u0010+¨\u0006;"}, d2 = {"Lcom/avito/android/advert/item/dfpcreditinfo/calculator/TinkoffCalculatorView;", "Lcom/avito/android/advert/item/dfpcreditinfo/calculator/CreditCalculatorView;", "Lkotlin/Pair;", "", "", "initialPayment", FirebaseAnalytics.Param.TERM, "", "terms", "inputHint", "loan", "monthlyPayment", "percent", "", "setData", "(Lkotlin/Pair;ILjava/util/List;Ljava/lang/String;Lkotlin/Pair;Ljava/lang/String;Ljava/lang/String;)V", "text", ShareConstants.WEB_DIALOG_PARAM_PRIVACY, "privacyLink", "showButton", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "clearFocus", "()V", "", "hasFocus", "()Z", "Lcom/avito/android/lib/design/component_container/ComponentContainer;", g.a, "Lcom/avito/android/lib/design/component_container/ComponentContainer;", "loanInputContainer", "l", "I", "termPickerValue", "Lcom/avito/android/lib/design/input/Input;", "i", "Lcom/avito/android/lib/design/input/Input;", "termInputView", "Lcom/avito/android/lib/design/button/Button;", "j", "Lcom/avito/android/lib/design/button/Button;", PhonePageSourceKt.PHONE_SOURCE_BUTTON, "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "initialPaymentView", "f", "monthlyPaymentView", "h", "loanInputView", "k", "privacyTextView", "Landroid/view/View;", "view", "Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditButton$Listener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/avito/android/advert/item/dfpcreditinfo/CreditInfoResourcesProvider;", "resourcesProvider", "<init>", "(Landroid/view/View;Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditButton$Listener;Lcom/avito/android/advert/item/dfpcreditinfo/CreditInfoResourcesProvider;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class TinkoffCalculatorView extends CreditCalculatorView {
    public TextView e;
    public TextView f;
    public ComponentContainer g;
    public Input h;
    public Input i;
    public Button j;
    public TextView k;
    public int l;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ TinkoffCalculatorView a;

        public a(TinkoffCalculatorView tinkoffCalculatorView) {
            this.a = tinkoffCalculatorView;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.clearFocus();
            this.a.getListener().onCreditButtonClick();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TinkoffCalculatorView(@NotNull View view, @NotNull DfpCreditButton.Listener listener, @NotNull CreditInfoResourcesProvider creditInfoResourcesProvider) {
        super(view, listener, creditInfoResourcesProvider, R.layout.advert_details_credit_info_tinkoff, R.layout.advert_details_credit_inputs_tinkoff);
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
        Input input = this.i;
        if (input != null) {
            return input.hasFocus();
        }
        return false;
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.calculator.CreditCalculatorView
    public void setData(@NotNull Pair<Integer, String> pair, int i2, @NotNull List<Integer> list, @Nullable String str, @NotNull Pair<Integer, String> pair2, @NotNull String str2, @NotNull String str3) {
        Input input;
        Intrinsics.checkNotNullParameter(pair, "initialPayment");
        Intrinsics.checkNotNullParameter(list, "terms");
        Intrinsics.checkNotNullParameter(pair2, "loan");
        Intrinsics.checkNotNullParameter(str2, "monthlyPayment");
        Intrinsics.checkNotNullParameter(str3, "percent");
        String second = pair.getSecond();
        if (this.e == null) {
            View findViewById = getView().findViewById(R.id.info_container);
            Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
            if (findViewById instanceof ViewStub) {
                findViewById = ((ViewStub) findViewById).inflate();
            }
            this.e = (TextView) findViewById.findViewById(R.id.initial_payment);
            this.f = (TextView) findViewById.findViewById(R.id.monthly_payment);
        }
        TextView textView = this.e;
        if (textView != null) {
            textView.setText(second);
        }
        TextView textView2 = this.f;
        if (textView2 != null) {
            textView2.setText(str2);
        }
        int intValue = pair2.getFirst().intValue();
        String valueOf = String.valueOf(intValue);
        Input input2 = this.h;
        String deformattedText = input2 != null ? input2.getDeformattedText() : null;
        if (!Intrinsics.areEqual(valueOf, deformattedText) || this.l != i2) {
            if (this.h == null) {
                View findViewById2 = getView().findViewById(R.id.input_container);
                Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.View");
                if (findViewById2 instanceof ViewStub) {
                    findViewById2 = ((ViewStub) findViewById2).inflate();
                }
                Input input3 = (Input) findViewById2.findViewById(R.id.loan_input);
                this.h = input3;
                if (input3 != null) {
                    input3.setMaxLength(9);
                }
                Input input4 = this.h;
                if (input4 != null) {
                    input4.setFocusByClearButton(true);
                }
                this.g = (ComponentContainer) findViewById2.findViewById(R.id.loan_input_container);
                this.i = (Input) findViewById2.findViewById(R.id.term_input);
            }
            Input input5 = this.h;
            if (input5 != null) {
                input5.setFocusChangeListener(null);
            }
            Input input6 = this.h;
            if (input6 != null) {
                input6.setOnEditorActionListener(null);
            }
            Input input7 = this.i;
            if (input7 != null) {
                input7.setOnClickListener(null);
            }
            if ((!Intrinsics.areEqual(valueOf, deformattedText)) && (input = this.h) != null) {
                input.setTextWithoutWatcher(String.valueOf(intValue));
                input.setMaxLength(9);
                Editable text = input.m90getText();
                input.setSelection(Math.max(0, (text != null ? text.length() : 0) - 2));
            }
            ComponentContainer componentContainer = this.g;
            if (componentContainer != null) {
                componentContainer.setMessage(str);
            }
            Input input8 = this.h;
            if (input8 != null) {
                input8.setOnEditorActionListener(new f(this));
            }
            Input input9 = this.h;
            if (input9 != null) {
                input9.setFocusChangeListener(new a2.a.a.f.x.t.i.g(this));
            }
            this.l = i2;
            Input input10 = this.i;
            if (input10 != null) {
                Input.setText$default(input10, formatTerm(i2, true), false, 2, null);
            }
            Input input11 = this.i;
            if (input11 != null) {
                input11.setOnClickListener(new e(this, list));
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
            this.k = (TextView) findViewById.findViewById(R.id.privacy_info);
        }
        Button button = this.j;
        if (button != null) {
            button.setText(str);
        }
        Button button2 = this.j;
        if (button2 != null) {
            button2.setOnClickListener(new a(this));
        }
        TextView textView = this.k;
        if (textView != null) {
            textView.setText(str2);
        }
    }
}
