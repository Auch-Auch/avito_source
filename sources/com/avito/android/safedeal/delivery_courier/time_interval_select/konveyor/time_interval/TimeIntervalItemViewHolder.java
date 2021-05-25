package com.avito.android.safedeal.delivery_courier.time_interval_select.konveyor.time_interval;

import android.view.View;
import android.widget.TextView;
import com.avito.android.lib.design.toggle.Checkmark;
import com.avito.android.safedeal.R;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0015¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u000e\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0014\u001a\n \u0011*\u0004\u0018\u00010\u00100\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0019\u0010\u001a\u001a\u00020\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001e\u001a\n \u0011*\u0004\u0018\u00010\u001b0\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/time_interval_select/konveyor/time_interval/TimeIntervalItemViewHolder;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/safedeal/delivery_courier/time_interval_select/konveyor/time_interval/TimeIntervalItemView;", "", "text", "", "setText", "(Ljava/lang/String;)V", "", "selected", "setCheckmarkSelected", "(Z)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnClickListener", "(Lkotlin/jvm/functions/Function0;)V", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "s", "Landroid/widget/TextView;", "textView", "Landroid/view/View;", "u", "Landroid/view/View;", "getView", "()Landroid/view/View;", "view", "Lcom/avito/android/lib/design/toggle/Checkmark;", "t", "Lcom/avito/android/lib/design/toggle/Checkmark;", "checkmark", "<init>", "(Landroid/view/View;)V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public final class TimeIntervalItemViewHolder extends BaseViewHolder implements TimeIntervalItemView {
    public final TextView s;
    public final Checkmark t;
    @NotNull
    public final View u;

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

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TimeIntervalItemViewHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.u = view;
        this.s = (TextView) view.findViewById(R.id.text_view);
        this.t = (Checkmark) view.findViewById(R.id.checkmark);
    }

    @NotNull
    public final View getView() {
        return this.u;
    }

    @Override // com.avito.android.safedeal.delivery_courier.time_interval_select.konveyor.time_interval.TimeIntervalItemView
    public void setCheckmarkSelected(boolean z) {
        Checkmark checkmark = this.t;
        Intrinsics.checkNotNullExpressionValue(checkmark, "checkmark");
        checkmark.setChecked(z);
    }

    @Override // com.avito.android.safedeal.delivery_courier.time_interval_select.konveyor.time_interval.TimeIntervalItemView
    public void setOnClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.u.setOnClickListener(new a(function0));
    }

    @Override // com.avito.android.safedeal.delivery_courier.time_interval_select.konveyor.time_interval.TimeIntervalItemView
    public void setText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        TextView textView = this.s;
        Intrinsics.checkNotNullExpressionValue(textView, "textView");
        textView.setText(str);
    }
}
