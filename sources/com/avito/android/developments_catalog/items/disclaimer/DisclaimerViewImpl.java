package com.avito.android.developments_catalog.items.disclaimer;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.avito.android.developments_catalog.R;
import com.avito.android.developments_catalog.items.disclaimer.DisclaimerView;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\n\u001a\u00020\u00052\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\bH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0018"}, d2 = {"Lcom/avito/android/developments_catalog/items/disclaimer/DisclaimerViewImpl;", "Lcom/avito/android/developments_catalog/items/disclaimer/DisclaimerView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "text", "", "setText", "(Ljava/lang/String;)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setInfoClickListener", "(Lkotlin/jvm/functions/Function0;)V", "Landroid/widget/TextView;", "s", "Landroid/widget/TextView;", "textView", "Landroid/widget/ImageButton;", "t", "Landroid/widget/ImageButton;", "infoButton", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "developments-catalog_release"}, k = 1, mv = {1, 4, 2})
public final class DisclaimerViewImpl extends BaseViewHolder implements DisclaimerView {
    public final TextView s;
    public final ImageButton t;

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
    public DisclaimerViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.text);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.text)");
        this.s = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.info_button);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.info_button)");
        this.t = (ImageButton) findViewById2;
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        DisclaimerView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.developments_catalog.items.disclaimer.DisclaimerView
    public void setInfoClickListener(@Nullable Function0<Unit> function0) {
        if (function0 != null) {
            this.t.setOnClickListener(new a(function0));
        } else {
            this.t.setOnClickListener(null);
        }
    }

    @Override // com.avito.android.developments_catalog.items.disclaimer.DisclaimerView
    public void setText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.s.setText(str);
    }
}
