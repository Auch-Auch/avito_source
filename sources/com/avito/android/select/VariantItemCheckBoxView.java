package com.avito.android.select;

import android.view.View;
import com.avito.android.component.check_box.CheckBox;
import com.avito.android.component.check_box.CheckBoxImpl;
import com.avito.android.remote.model.Image;
import com.avito.android.select.VariantItemView;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u000e\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0018"}, d2 = {"Lcom/avito/android/select/VariantItemCheckBoxView;", "Lcom/avito/android/select/VariantItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "", "selected", "setSelected", "(Z)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnClickListener", "(Lkotlin/jvm/functions/Function0;)V", "Lcom/avito/android/component/check_box/CheckBoxImpl;", "s", "Lcom/avito/android/component/check_box/CheckBoxImpl;", "checkBox", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "select_release"}, k = 1, mv = {1, 4, 2})
public final class VariantItemCheckBoxView extends BaseViewHolder implements VariantItemView {
    public final CheckBoxImpl s;

    public static final class a extends Lambda implements Function1<CheckBox, Unit> {
        public final /* synthetic */ Function0 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Function0 function0) {
            super(1);
            this.a = function0;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(CheckBox checkBox) {
            Intrinsics.checkNotNullParameter(checkBox, "it");
            this.a.invoke();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VariantItemCheckBoxView(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.s = new CheckBoxImpl(view, false, 2, null);
    }

    @Override // com.avito.android.select.VariantItemView
    public void enableMultiselect(boolean z) {
        VariantItemView.DefaultImpls.enableMultiselect(this, z);
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        VariantItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.select.VariantItemView
    public void setImage(@Nullable Image image) {
        VariantItemView.DefaultImpls.setImage(this, image);
    }

    @Override // com.avito.android.select.VariantItemView
    public void setOnClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.s.setOnClickListener(new a(function0));
    }

    @Override // com.avito.android.select.VariantItemView
    public void setSelected(boolean z) {
        this.s.setChecked(z);
    }

    @Override // com.avito.android.select.VariantItemView
    public void setSubtitle(@Nullable String str) {
        VariantItemView.DefaultImpls.setSubtitle(this, str);
    }

    @Override // com.avito.android.select.VariantItemView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.s.setTitle(str);
    }
}
