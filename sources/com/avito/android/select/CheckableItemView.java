package com.avito.android.select;

import android.view.View;
import android.widget.TextView;
import com.avito.android.remote.model.Image;
import com.avito.android.select.VariantItemView;
import com.avito.android.ui.view.CheckableFrameLayout;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u000e\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001c"}, d2 = {"Lcom/avito/android/select/CheckableItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/select/VariantItemView;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "", "selected", "setSelected", "(Z)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnClickListener", "(Lkotlin/jvm/functions/Function0;)V", "Lcom/avito/android/ui/view/CheckableFrameLayout;", "t", "Lcom/avito/android/ui/view/CheckableFrameLayout;", "frameView", "Landroid/widget/TextView;", "s", "Landroid/widget/TextView;", "titleView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "select_release"}, k = 1, mv = {1, 4, 2})
public final class CheckableItemView extends BaseViewHolder implements VariantItemView {
    public final TextView s;
    public final CheckableFrameLayout t;

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
    public CheckableItemView(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.title)");
        this.s = (TextView) findViewById;
        this.t = (CheckableFrameLayout) view;
    }

    @Override // com.avito.android.select.VariantItemView
    public void enableMultiselect(boolean z) {
        VariantItemView.DefaultImpls.enableMultiselect(this, z);
    }

    @Override // com.avito.android.select.VariantItemView
    public void setImage(@Nullable Image image) {
        VariantItemView.DefaultImpls.setImage(this, image);
    }

    @Override // com.avito.android.select.VariantItemView
    public void setOnClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.t.setOnClickListener(new a(function0));
    }

    @Override // com.avito.android.select.VariantItemView
    public void setSelected(boolean z) {
        this.t.setChecked(z);
    }

    @Override // com.avito.android.select.VariantItemView
    public void setSubtitle(@Nullable String str) {
        VariantItemView.DefaultImpls.setSubtitle(this, str);
    }

    @Override // com.avito.android.select.VariantItemView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.s.setText(str);
    }
}
