package com.avito.android.payment.wallet.history.details.item;

import android.view.View;
import com.avito.android.lib.design.button.Button;
import com.avito.android.payment.R;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00152\u00020\u00012\u00020\u0002:\u0001\u0015B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\n\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u001e\u0010\u0010\u001a\n \r*\u0004\u0018\u00010\f0\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/avito/android/payment/wallet/history/details/item/ButtonItemViewHolder;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/payment/wallet/history/details/item/ButtonItemView;", "", ShareConstants.FEED_CAPTION_PARAM, "", "setCaption", "(Ljava/lang/String;)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnClickListener", "(Lkotlin/jvm/functions/Function0;)V", "Lcom/avito/android/lib/design/button/Button;", "kotlin.jvm.PlatformType", "s", "Lcom/avito/android/lib/design/button/Button;", "showReceiptButton", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "Companion", "payment_release"}, k = 1, mv = {1, 4, 2})
public final class ButtonItemViewHolder extends BaseViewHolder implements ButtonItemView {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int t = R.layout.payment_history_details_button_item;
    public final Button s;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/payment/wallet/history/details/item/ButtonItemViewHolder$Companion;", "", "", "LAYOUT_ID", "I", "getLAYOUT_ID", "()I", "<init>", "()V", "payment_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public final int getLAYOUT_ID() {
            return ButtonItemViewHolder.t;
        }

        public Companion(j jVar) {
        }
    }

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
    public ButtonItemViewHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.s = (Button) view.findViewById(R.id.show_receipt_button);
    }

    @Override // com.avito.android.payment.wallet.history.details.item.ButtonItemView
    public void setCaption(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, ShareConstants.FEED_CAPTION_PARAM);
        this.s.setText(str);
    }

    @Override // com.avito.android.payment.wallet.history.details.item.ButtonItemView
    public void setOnClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.s.setOnClickListener(new a(function0));
    }
}
