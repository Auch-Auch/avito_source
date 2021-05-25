package com.avito.android.delivery.summary.konveyor.button;

import android.view.View;
import com.avito.android.advert_core.analytics.contactbar.PhonePageSourceKt;
import com.avito.android.lib.design.button.Button;
import com.avito.konveyor.adapter.BaseViewHolder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0012¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\u000bJ\u001d\u0010\u0010\u001a\u00020\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/avito/android/delivery/summary/konveyor/button/ButtonItemViewHolder;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/delivery/summary/konveyor/button/ButtonItemView;", "", "title", "", "setButtonTitle", "(Ljava/lang/String;)V", "", "loading", "setLoading", "(Z)V", "enabled", "setEnabled", "Lkotlin/Function0;", "action", "setOnButtonClickListener", "(Lkotlin/jvm/functions/Function0;)V", "Lcom/avito/android/lib/design/button/Button;", "s", "Lcom/avito/android/lib/design/button/Button;", PhonePageSourceKt.PHONE_SOURCE_BUTTON, "<init>", "(Lcom/avito/android/lib/design/button/Button;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class ButtonItemViewHolder extends BaseViewHolder implements ButtonItemView {
    public final Button s;

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
    public ButtonItemViewHolder(@NotNull Button button) {
        super(button);
        Intrinsics.checkNotNullParameter(button, PhonePageSourceKt.PHONE_SOURCE_BUTTON);
        this.s = button;
    }

    @Override // com.avito.android.delivery.summary.konveyor.button.ButtonItemView
    public void setButtonTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.s.setText(str);
    }

    @Override // com.avito.android.delivery.summary.konveyor.button.ButtonItemView
    public void setEnabled(boolean z) {
        this.s.setEnabled(z);
    }

    @Override // com.avito.android.delivery.summary.konveyor.button.ButtonItemView
    public void setLoading(boolean z) {
        this.s.setLoading(z);
    }

    @Override // com.avito.android.delivery.summary.konveyor.button.ButtonItemView
    public void setOnButtonClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "action");
        this.s.setOnClickListener(new a(function0));
    }
}
