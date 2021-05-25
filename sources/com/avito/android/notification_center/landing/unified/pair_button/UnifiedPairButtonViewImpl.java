package com.avito.android.notification_center.landing.unified.pair_button;

import android.view.View;
import android.widget.TextView;
import com.avito.android.notification_center.R;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\tJ\u001f\u0010\r\u001a\u00020\u00032\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u000f\u001a\u00020\u00032\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u000eJ\u001f\u0010\u0010\u001a\u00020\u00032\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\u000eR\u001e\u0010\u0015\u001a\n \u0012*\u0004\u0018\u00010\u00110\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001e\u0010\u001a\u001a\n \u0012*\u0004\u0018\u00010\u00110\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/avito/android/notification_center/landing/unified/pair_button/UnifiedPairButtonViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/notification_center/landing/unified/pair_button/UnifiedPairButtonView;", "", "onUnbind", "()V", "", "text", "setFirstText", "(Ljava/lang/String;)V", "setSecondText", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setFirstClickListener", "(Lkotlin/jvm/functions/Function0;)V", "setSecondClickListener", "setUnbindListener", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "t", "Landroid/widget/TextView;", "secondButton", "u", "Lkotlin/jvm/functions/Function0;", "unbindListener", "s", "firstButton", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "notification-center_release"}, k = 1, mv = {1, 4, 2})
public final class UnifiedPairButtonViewImpl extends BaseViewHolder implements UnifiedPairButtonView {
    public final TextView s;
    public final TextView t;
    public Function0<Unit> u;

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

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public b(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UnifiedPairButtonViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.s = (TextView) view.findViewById(R.id.first_button);
        this.t = (TextView) view.findViewById(R.id.second_button);
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        Function0<Unit> function0 = this.u;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // com.avito.android.notification_center.landing.unified.pair_button.UnifiedPairButtonView
    public void setFirstClickListener(@Nullable Function0<Unit> function0) {
        if (function0 == null) {
            this.s.setOnClickListener(null);
        } else {
            this.s.setOnClickListener(new a(function0));
        }
    }

    @Override // com.avito.android.notification_center.landing.unified.pair_button.UnifiedPairButtonView
    public void setFirstText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        TextView textView = this.s;
        Intrinsics.checkNotNullExpressionValue(textView, "firstButton");
        textView.setText(str);
    }

    @Override // com.avito.android.notification_center.landing.unified.pair_button.UnifiedPairButtonView
    public void setSecondClickListener(@Nullable Function0<Unit> function0) {
        if (function0 == null) {
            this.t.setOnClickListener(null);
        } else {
            this.t.setOnClickListener(new b(function0));
        }
    }

    @Override // com.avito.android.notification_center.landing.unified.pair_button.UnifiedPairButtonView
    public void setSecondText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        TextView textView = this.t;
        Intrinsics.checkNotNullExpressionValue(textView, "secondButton");
        textView.setText(str);
    }

    @Override // com.avito.android.notification_center.landing.unified.pair_button.UnifiedPairButtonView
    public void setUnbindListener(@Nullable Function0<Unit> function0) {
        this.u = function0;
    }
}
