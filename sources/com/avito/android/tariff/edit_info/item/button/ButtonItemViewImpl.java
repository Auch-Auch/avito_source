package com.avito.android.tariff.edit_info.item.button;

import android.view.View;
import com.avito.android.lib.design.button.Button;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0006\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u001e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/tariff/edit_info/item/button/ButtonItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/tariff/edit_info/item/button/ButtonItemView;", "Lkotlin/Function0;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnClickListener", "(Lkotlin/jvm/functions/Function0;)V", "", "title", "setTitle", "(Ljava/lang/String;)V", "s", "Lkotlin/jvm/functions/Function0;", "clickListener", "Landroid/view/View;", "t", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class ButtonItemViewImpl extends BaseViewHolder implements ButtonItemView {
    public Function0<Unit> s;
    public final View t;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ ButtonItemViewImpl a;

        public a(ButtonItemViewImpl buttonItemViewImpl) {
            this.a = buttonItemViewImpl;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function0 function0 = this.a.s;
            if (function0 != null) {
                Unit unit = (Unit) function0.invoke();
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ButtonItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.t = view;
        view.setOnClickListener(new a(this));
    }

    @Override // com.avito.android.tariff.edit_info.item.button.ButtonItemView
    public void setOnClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.s = function0;
    }

    @Override // com.avito.android.tariff.edit_info.item.button.ButtonItemView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        View view = this.t;
        Objects.requireNonNull(view, "null cannot be cast to non-null type com.avito.android.lib.design.button.Button");
        ((Button) view).setText(str);
    }
}
