package com.avito.android.safedeal.delivery_type.items.button;

import android.view.View;
import android.widget.TextView;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.safedeal.R;
import com.avito.android.safedeal.delivery_type.ButtonClickListener;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0012¢\u0006\u0004\b\u001a\u0010\u001bJ'\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/avito/android/safedeal/delivery_type/items/button/ButtonViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/safedeal/delivery_type/items/button/ButtonView;", "Lcom/avito/android/safedeal/remote/model/OrderType;", "data", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Lcom/avito/android/safedeal/delivery_type/ButtonClickListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "setButton", "(Lcom/avito/android/safedeal/remote/model/OrderType;Lcom/avito/android/util/text/AttributedTextFormatter;Lcom/avito/android/safedeal/delivery_type/ButtonClickListener;)V", "Landroid/widget/TextView;", "s", "Landroid/widget/TextView;", "title", "t", MessengerShareContentUtility.SUBTITLE, "Landroid/view/View;", VKApiConst.VERSION, "Landroid/view/View;", "icon", "w", "view", "u", "promoView", "<init>", "(Landroid/view/View;)V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public final class ButtonViewImpl extends BaseViewHolder implements ButtonView {
    public final TextView s;
    public final TextView t;
    public final TextView u;
    public final View v;
    public final View w;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ DeepLink a;
        public final /* synthetic */ ButtonClickListener b;

        public a(DeepLink deepLink, ButtonViewImpl buttonViewImpl, ButtonClickListener buttonClickListener) {
            this.a = deepLink;
            this.b = buttonClickListener;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.b.onButtonClick(this.a);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ButtonViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.w = view;
        View findViewById = view.findViewById(R.id.delivery_type_button_text);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(safeDe…elivery_type_button_text)");
        this.s = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.delivery_type_subtitle);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(safeDe…d.delivery_type_subtitle)");
        this.t = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.delivery_type_button_promo);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(safeDe…livery_type_button_promo)");
        this.u = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.delivery_type_button_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(safeDe…elivery_type_button_icon)");
        this.v = findViewById4;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    @Override // com.avito.android.safedeal.delivery_type.items.button.ButtonView
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setButton(@org.jetbrains.annotations.NotNull com.avito.android.safedeal.remote.model.OrderType r9, @org.jetbrains.annotations.NotNull com.avito.android.util.text.AttributedTextFormatter r10, @org.jetbrains.annotations.NotNull com.avito.android.safedeal.delivery_type.ButtonClickListener r11) {
        /*
        // Method dump skipped, instructions count: 269
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.safedeal.delivery_type.items.button.ButtonViewImpl.setButton(com.avito.android.safedeal.remote.model.OrderType, com.avito.android.util.text.AttributedTextFormatter, com.avito.android.safedeal.delivery_type.ButtonClickListener):void");
    }
}
