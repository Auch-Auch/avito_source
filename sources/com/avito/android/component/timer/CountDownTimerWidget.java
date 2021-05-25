package com.avito.android.component.timer;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.Views;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010+\u001a\u00020*\u0012\b\u0010-\u001a\u0004\u0018\u00010,\u0012\b\b\u0002\u0010/\u001a\u00020.¢\u0006\u0004\b0\u00101J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\u0007J\u000f\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u000e\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u000f\u0010\rJ\r\u0010\u0010\u001a\u00020\u0005¢\u0006\u0004\b\u0010\u0010\rJ\u0015\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0017\u001a\u00020\u00052\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u0015¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\u001bR\u001e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010\u001bR\u0016\u0010)\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010\u001b¨\u00062"}, d2 = {"Lcom/avito/android/component/timer/CountDownTimerWidget;", "Landroid/widget/LinearLayout;", "Lcom/avito/android/component/timer/TimeWidget;", "", "hours", "", "setHours", "(Ljava/lang/String;)V", "minutes", "setMinutes", "seconds", "setSeconds", "onFinish", "()V", "onAttachedToWindow", "onDetachedFromWindow", "hideHours", "", "endDateTimestamp", "setFinishDate", "(J)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnFinishListener", "(Lkotlin/jvm/functions/Function0;)V", "Landroid/widget/TextView;", AuthSource.SEND_ABUSE, "Landroid/widget/TextView;", "hoursView", "Lcom/avito/android/component/timer/Counter;", "f", "Lcom/avito/android/component/timer/Counter;", "counter", "c", "secondsView", "e", "Lkotlin/jvm/functions/Function0;", "finishListener", "d", "hoursSeparator", AuthSource.BOOKING_ORDER, "minutesView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class CountDownTimerWidget extends LinearLayout implements TimeWidget {
    public final TextView a;
    public final TextView b;
    public final TextView c;
    public final TextView d;
    public Function0<Unit> e;
    public Counter f;

    @JvmOverloads
    public CountDownTimerWidget(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CountDownTimerWidget(Context context, AttributeSet attributeSet, int i, int i2, j jVar) {
        this(context, attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final void hideHours() {
        Views.hide(this.a);
        Views.hide(this.d);
    }

    @Override // android.view.View, android.view.ViewGroup
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Counter counter = this.f;
        if (counter != null) {
            counter.start(this);
        }
    }

    @Override // android.view.View, android.view.ViewGroup
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Counter counter = this.f;
        if (counter != null) {
            counter.stop();
        }
    }

    @Override // com.avito.android.component.timer.TimeWidget
    public void onFinish() {
        Function0<Unit> function0 = this.e;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final void setFinishDate(long j) {
        Counter counter = this.f;
        if (counter != null) {
            counter.stop();
        }
        Counter counter2 = new Counter(j);
        counter2.start(this);
        Unit unit = Unit.INSTANCE;
        this.f = counter2;
    }

    @Override // com.avito.android.component.timer.TimeWidget
    public void setHours(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "hours");
        this.a.setText(str);
    }

    @Override // com.avito.android.component.timer.TimeWidget
    public void setMinutes(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "minutes");
        this.b.setText(str);
    }

    public final void setOnFinishListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.e = function0;
    }

    @Override // com.avito.android.component.timer.TimeWidget
    public void setSeconds(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "seconds");
        this.c.setText(str);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CountDownTimerWidget(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(context, R.layout.countdown_timer_view, this);
        View findViewById = findViewById(R.id.hours);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.hours)");
        TextView textView = (TextView) findViewById;
        this.a = textView;
        View findViewById2 = findViewById(R.id.minutes);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.minutes)");
        TextView textView2 = (TextView) findViewById2;
        this.b = textView2;
        View findViewById3 = findViewById(R.id.seconds);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.seconds)");
        TextView textView3 = (TextView) findViewById3;
        this.c = textView3;
        View findViewById4 = findViewById(R.id.hours_separator);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.hours_separator)");
        this.d = (TextView) findViewById4;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CountDownTimerWidget);
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.CountDownTimerWidget_cell_background);
        if (drawable != null) {
            Views.setBackgroundCompat(textView, drawable);
            Views.setBackgroundCompat(textView2, drawable);
            Views.setBackgroundCompat(textView3, drawable);
        }
        obtainStyledAttributes.recycle();
    }
}
