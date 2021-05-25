package com.avito.android.developments_catalog.items.consultation;

import android.view.View;
import android.widget.TextView;
import com.avito.android.developments_catalog.R;
import com.avito.android.developments_catalog.items.consultation.ConsultationView;
import com.avito.android.lib.design.button.Button;
import com.avito.android.lib.design.button.ButtonsKt;
import com.avito.android.util.TextViews;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\u0007J\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0018\u001a\n \u0015*\u0004\u0018\u00010\u00140\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001e\u0010\u001a\u001a\n \u0015*\u0004\u0018\u00010\u00140\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017¨\u0006\u001f"}, d2 = {"Lcom/avito/android/developments_catalog/items/consultation/ConsultationViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/developments_catalog/items/consultation/ConsultationView;", "", "title", "", "bindTitle", "(Ljava/lang/String;)V", "description", "bindSubtitle", "buttonTitle", "bindButton", "Lcom/avito/android/developments_catalog/items/consultation/ConsultationView$Listener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "addListener", "(Lcom/avito/android/developments_catalog/items/consultation/ConsultationView$Listener;)V", "Lcom/avito/android/lib/design/button/Button;", "u", "Lcom/avito/android/lib/design/button/Button;", "submitButton", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "s", "Landroid/widget/TextView;", "titleView", "t", "subtitleView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "developments-catalog_release"}, k = 1, mv = {1, 4, 2})
public final class ConsultationViewImpl extends BaseViewHolder implements ConsultationView {
    public final TextView s;
    public final TextView t;
    public final Button u;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ ConsultationView.Listener a;

        public a(ConsultationView.Listener listener) {
            this.a = listener;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.onSubmitConsultationRequestClick();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConsultationViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.s = (TextView) view.findViewById(R.id.title);
        this.t = (TextView) view.findViewById(R.id.subtitle);
        this.u = (Button) view.findViewById(R.id.consultation_button);
    }

    @Override // com.avito.android.developments_catalog.items.consultation.ConsultationView
    public void addListener(@NotNull ConsultationView.Listener listener) {
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Button button = this.u;
        if (button != null) {
            button.setOnClickListener(new a(listener));
        }
    }

    @Override // com.avito.android.developments_catalog.items.consultation.ConsultationView
    public void bindButton(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "buttonTitle");
        Button button = this.u;
        if (button != null) {
            ButtonsKt.bindText$default(button, str, false, 2, null);
        }
    }

    @Override // com.avito.android.developments_catalog.items.consultation.ConsultationView
    public void bindSubtitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "description");
        TextView textView = this.t;
        Intrinsics.checkNotNullExpressionValue(textView, "subtitleView");
        TextViews.bindText$default(textView, str, false, 2, null);
    }

    @Override // com.avito.android.developments_catalog.items.consultation.ConsultationView
    public void bindTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        TextView textView = this.s;
        Intrinsics.checkNotNullExpressionValue(textView, "titleView");
        TextViews.bindText$default(textView, str, false, 2, null);
    }
}
