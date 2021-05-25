package com.avito.android.search.filter.adapter;

import android.view.View;
import com.avito.android.blueprints.CheckBoxItemView;
import com.avito.android.component.check_box.CheckBox;
import com.avito.android.component.check_box.CheckBoxImpl;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u000e\u001a\u00020\u00052\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0018"}, d2 = {"Lcom/avito/android/search/filter/adapter/CheckBoxItemViewHolder;", "Lcom/avito/android/blueprints/CheckBoxItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "value", "", "setText", "(Ljava/lang/String;)V", "", "isChecked", "setChecked", "(Z)V", "Lkotlin/Function1;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setCheckListener", "(Lkotlin/jvm/functions/Function1;)V", "Lcom/avito/android/component/check_box/CheckBoxImpl;", "s", "Lcom/avito/android/component/check_box/CheckBoxImpl;", "checkBox", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "filter_release"}, k = 1, mv = {1, 4, 2})
public final class CheckBoxItemViewHolder extends BaseViewHolder implements CheckBoxItemView {
    public final CheckBoxImpl s;

    public static final class a extends Lambda implements Function2<CheckBox, Boolean, Unit> {
        public final /* synthetic */ Function1 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Function1 function1) {
            super(2);
            this.a = function1;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(CheckBox checkBox, Boolean bool) {
            boolean booleanValue = bool.booleanValue();
            Intrinsics.checkNotNullParameter(checkBox, "<anonymous parameter 0>");
            this.a.invoke(Boolean.valueOf(booleanValue));
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CheckBoxItemViewHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.s = new CheckBoxImpl(view, false, 2, null);
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        CheckBoxItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.blueprints.CheckBoxItemView
    public void setCheckListener(@NotNull Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.s.setOnCheckedChangeListener(new a(function1));
    }

    @Override // com.avito.android.blueprints.CheckBoxItemView
    public void setChecked(boolean z) {
        this.s.setChecked(z);
    }

    @Override // com.avito.android.blueprints.CheckBoxItemView
    public void setText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        this.s.setTitle(str);
    }
}
