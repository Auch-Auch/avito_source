package com.avito.android.notification_center.landing.unified.subtitle;

import android.view.View;
import android.widget.TextView;
import com.avito.android.notification_center.R;
import com.avito.android.util.TextViews;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\b\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\tJ\u001f\u0010\r\u001a\u00020\u00032\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u000f\u001a\u00020\u00032\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u000eR\u001e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0017\u001a\n \u0014*\u0004\u0018\u00010\u00130\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0019\u001a\n \u0014*\u0004\u0018\u00010\u00130\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016¨\u0006\u001e"}, d2 = {"Lcom/avito/android/notification_center/landing/unified/subtitle/UnifiedSubtitleItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/notification_center/landing/unified/subtitle/UnifiedSubtitleItemView;", "", "onUnbind", "()V", "", "text", "setButtonText", "(Ljava/lang/String;)V", "setTitleText", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setButtonClickListener", "(Lkotlin/jvm/functions/Function0;)V", "setUnbindListener", "u", "Lkotlin/jvm/functions/Function0;", "unbindListener", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "t", "Landroid/widget/TextView;", "buttonView", "s", "titleView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "notification-center_release"}, k = 1, mv = {1, 4, 2})
public final class UnifiedSubtitleItemViewImpl extends BaseViewHolder implements UnifiedSubtitleItemView {
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

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UnifiedSubtitleItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.s = (TextView) view.findViewById(R.id.title);
        this.t = (TextView) view.findViewById(R.id.button);
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        Function0<Unit> function0 = this.u;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // com.avito.android.notification_center.landing.unified.subtitle.UnifiedSubtitleItemView
    public void setButtonClickListener(@Nullable Function0<Unit> function0) {
        if (function0 == null) {
            this.t.setOnClickListener(null);
        } else {
            this.t.setOnClickListener(new a(function0));
        }
    }

    @Override // com.avito.android.notification_center.landing.unified.subtitle.UnifiedSubtitleItemView
    public void setButtonText(@Nullable String str) {
        TextView textView = this.t;
        Intrinsics.checkNotNullExpressionValue(textView, "buttonView");
        TextViews.bindText$default(textView, str, false, 2, null);
    }

    @Override // com.avito.android.notification_center.landing.unified.subtitle.UnifiedSubtitleItemView
    public void setTitleText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        TextView textView = this.s;
        Intrinsics.checkNotNullExpressionValue(textView, "titleView");
        textView.setText(str);
    }

    @Override // com.avito.android.notification_center.landing.unified.subtitle.UnifiedSubtitleItemView
    public void setUnbindListener(@Nullable Function0<Unit> function0) {
        this.u = function0;
    }
}
