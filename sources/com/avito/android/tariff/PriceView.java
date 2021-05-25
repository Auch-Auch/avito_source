package com.avito.android.tariff;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.StrikethroughSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.transition.Fade;
import androidx.transition.TransitionManager;
import com.avito.android.advert_core.analytics.contactbar.PhonePageSourceKt;
import com.avito.android.lib.design.button.Button;
import com.avito.android.lib.design.spinner.Spinner;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.TransitionDsl;
import com.avito.android.util.Views;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010/\u001a\u00020.\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u000100\u0012\b\b\u0002\u00103\u001a\u000202¢\u0006\u0004\b4\u00105J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u0015\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u0006J\u0015\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\u0006J\u001b\u0010\u000f\u001a\u00020\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0019\u0010\u0014R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\u001a8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\"\u0010\u001cR\u0016\u0010'\u001a\u00020$8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020\u001a8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b(\u0010\u001cR\u0016\u0010-\u001a\u00020*8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b+\u0010,¨\u00066"}, d2 = {"Lcom/avito/android/tariff/PriceView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "price", "", "setPrice", "(Ljava/lang/String;)V", "oldPrice", "setOldPrice", "title", "setTitle", "text", "setButtonText", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setButtonClickListener", "(Lkotlin/jvm/functions/Function0;)V", "", "isLoading", "setButtonLoadingState", "(Z)V", "setPriceLoading", "()V", "setPrices", "(Ljava/lang/String;Ljava/lang/String;)V", AuthSource.BOOKING_ORDER, "Landroid/widget/TextView;", "s", "Landroid/widget/TextView;", "oldPriceTextView", "Landroidx/constraintlayout/widget/Group;", "u", "Landroidx/constraintlayout/widget/Group;", "priceGroup", "r", "priceTextView", "Lcom/avito/android/lib/design/button/Button;", VKApiConst.Q, "Lcom/avito/android/lib/design/button/Button;", PhonePageSourceKt.PHONE_SOURCE_BUTTON, "t", "titleTextView", "Lcom/avito/android/lib/design/spinner/Spinner;", VKApiConst.VERSION, "Lcom/avito/android/lib/design/spinner/Spinner;", "spinner", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class PriceView extends ConstraintLayout {
    public Button q;
    public TextView r;
    public TextView s;
    public TextView t;
    public Group u;
    public Spinner v;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public a(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    @JvmOverloads
    public PriceView(@NotNull Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public PriceView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PriceView(Context context, AttributeSet attributeSet, int i, int i2, j jVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void setOldPrice(String str) {
        if (str == null) {
            TextView textView = this.s;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("oldPriceTextView");
            }
            textView.setVisibility(8);
            TextView textView2 = this.s;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("oldPriceTextView");
            }
            textView2.setText("");
            return;
        }
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new StrikethroughSpan(), 0, spannableString.length(), 33);
        TextView textView3 = this.s;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("oldPriceTextView");
        }
        textView3.setText(spannableString);
        TextView textView4 = this.s;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("oldPriceTextView");
        }
        textView4.setVisibility(0);
    }

    private final void setPrice(String str) {
        TextView textView = this.r;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("priceTextView");
        }
        textView.setText(str);
    }

    public final void b(boolean z) {
        TransitionDsl transitionDsl = new TransitionDsl(new Fade());
        TextView textView = this.t;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleTextView");
        }
        transitionDsl.addTarget(textView);
        TextView textView2 = this.r;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("priceTextView");
        }
        transitionDsl.addTarget(textView2);
        TextView textView3 = this.s;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("oldPriceTextView");
        }
        transitionDsl.addTarget(textView3);
        Spinner spinner = this.v;
        if (spinner == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spinner");
        }
        transitionDsl.addTarget(spinner);
        Unit unit = Unit.INSTANCE;
        TransitionManager.beginDelayedTransition(this, transitionDsl.buildTransition());
        if (z) {
            Group group = this.u;
            if (group == null) {
                Intrinsics.throwUninitializedPropertyAccessException("priceGroup");
            }
            Views.conceal(group);
            Spinner spinner2 = this.v;
            if (spinner2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("spinner");
            }
            Views.show(spinner2);
            return;
        }
        Group group2 = this.u;
        if (group2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("priceGroup");
        }
        Views.show(group2);
        Spinner spinner3 = this.v;
        if (spinner3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("spinner");
        }
        Views.hide(spinner3);
    }

    public final void setButtonClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Button button = this.q;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException(PhonePageSourceKt.PHONE_SOURCE_BUTTON);
        }
        button.setOnClickListener(new a(function0));
    }

    public final void setButtonLoadingState(boolean z) {
        Button button = this.q;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException(PhonePageSourceKt.PHONE_SOURCE_BUTTON);
        }
        button.setLoading(z);
        Button button2 = this.q;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(PhonePageSourceKt.PHONE_SOURCE_BUTTON);
        }
        button2.setClickable(!z);
    }

    public final void setButtonText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        Button button = this.q;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException(PhonePageSourceKt.PHONE_SOURCE_BUTTON);
        }
        button.setText(str);
    }

    public final void setPriceLoading() {
        b(true);
    }

    public final void setPrices(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "price");
        b(false);
        setPrice(str);
        setOldPrice(str2);
    }

    public final void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        TextView textView = this.t;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleTextView");
        }
        textView.setText(str);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PriceView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R.layout.price_view, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.button);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.button)");
        this.q = (Button) findViewById;
        View findViewById2 = findViewById(R.id.price_text);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.price_text)");
        this.r = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.old_price_text);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.old_price_text)");
        this.s = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.title)");
        this.t = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.loading_spinner);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.loading_spinner)");
        this.v = (Spinner) findViewById5;
        View findViewById6 = findViewById(R.id.price_group);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.price_group)");
        this.u = (Group) findViewById6;
        setBackgroundResource(R.drawable.background_price_view);
    }
}
