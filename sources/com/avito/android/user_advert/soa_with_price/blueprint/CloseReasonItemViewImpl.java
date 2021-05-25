package com.avito.android.user_advert.soa_with_price.blueprint;

import android.view.View;
import com.avito.android.lib.design.list_item.CheckmarkListItem;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u0006\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u001a"}, d2 = {"Lcom/avito/android/user_advert/soa_with_price/blueprint/CloseReasonItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/user_advert/soa_with_price/blueprint/CloseReasonItemView;", "Lkotlin/Function0;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "", "text", "setText", "(Ljava/lang/CharSequence;)V", "onUnbind", "()V", "", "isChecked", "setChecked", "(Z)V", "Lcom/avito/android/lib/design/list_item/CheckmarkListItem;", "s", "Lcom/avito/android/lib/design/list_item/CheckmarkListItem;", "listItem", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
public final class CloseReasonItemViewImpl extends BaseViewHolder implements CloseReasonItemView {
    public final CheckmarkListItem s;

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
    public CloseReasonItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.s = (CheckmarkListItem) view;
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        this.s.setOnClickListener(null);
    }

    @Override // com.avito.android.user_advert.soa_with_price.blueprint.CloseReasonItemView
    public void setChecked(boolean z) {
        this.s.setChecked(z);
    }

    @Override // com.avito.android.user_advert.soa_with_price.blueprint.CloseReasonItemView
    public void setClickListener(@Nullable Function0<Unit> function0) {
        if (function0 != null) {
            this.s.setOnClickListener(new a(function0));
        } else {
            this.s.setOnClickListener(null);
        }
    }

    @Override // com.avito.android.user_advert.soa_with_price.blueprint.CloseReasonItemView
    public void setText(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "text");
        this.s.setTitle(charSequence);
    }
}
