package ru.avito.component.rate;

import android.view.View;
import android.widget.TextView;
import com.avito.android.design.widget.RateView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.Views;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0015¢\u0006\u0004\b%\u0010&J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J2\u0010\u000b\u001a\u00020\t2!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\tH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000f\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0014\u0010\u0013R\u0019\u0010\u001a\u001a\u00020\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010\u001d¨\u0006'"}, d2 = {"Lru/avito/component/rate/RateImpl;", "Lru/avito/component/rate/Rate;", "", "getRate", "()I", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "rate", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnRateChangeListener", "(Lkotlin/jvm/functions/Function1;)V", "hide", "()V", "show", "", "text", "setNegativeText", "(Ljava/lang/String;)V", "setPositiveText", "Landroid/view/View;", "d", "Landroid/view/View;", "getView", "()Landroid/view/View;", "view", "Landroid/widget/TextView;", AuthSource.BOOKING_ORDER, "Landroid/widget/TextView;", "negativeText", "Lcom/avito/android/design/widget/RateView;", AuthSource.SEND_ABUSE, "Lcom/avito/android/design/widget/RateView;", "rateView", "c", "positiveText", "<init>", "(Landroid/view/View;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class RateImpl implements Rate {
    public final RateView a;
    public final TextView b;
    public final TextView c;
    @NotNull
    public final View d;

    public RateImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.d = view;
        View findViewById = view.findViewById(R.id.rate_view);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.avito.android.design.widget.RateView");
        this.a = (RateView) findViewById;
        View findViewById2 = view.findViewById(R.id.negative_text);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.b = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.positive_text);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        this.c = (TextView) findViewById3;
    }

    @Override // ru.avito.component.rate.Rate
    public int getRate() {
        return this.a.getRate();
    }

    @NotNull
    public final View getView() {
        return this.d;
    }

    @Override // ru.avito.component.rate.Rate
    public void hide() {
        Views.hide(this.d);
    }

    @Override // ru.avito.component.rate.Rate
    public void setNegativeText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.b.setText(str);
    }

    @Override // ru.avito.component.rate.Rate
    public void setOnRateChangeListener(@NotNull Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.a.setOnRateChangeListener(function1);
    }

    @Override // ru.avito.component.rate.Rate
    public void setPositiveText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.c.setText(str);
    }

    @Override // ru.avito.component.rate.Rate
    public void show() {
        Views.show(this.d);
    }
}
