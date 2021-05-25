package com.avito.android.advert.item.dfpcreditinfo.broker_link;

import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.avito.android.advert_details.R;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.vk.sdk.api.VKApiConst;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0015¢\u0006\u0004\b!\u0010\"J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u000e\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0014\u001a\n \u0011*\u0004\u0018\u00010\u00100\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lcom/avito/android/advert/item/dfpcreditinfo/broker_link/CreditBrokerLinkViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/advert/item/dfpcreditinfo/broker_link/CreditBrokerLinkView;", "", "payment", "", "setPayment", "(Ljava/lang/String;)V", "", "isTinkoff", "setTinkoffIcon", "(Z)V", "Lkotlin/Function0;", "callback", "setOnClickListener", "(Lkotlin/jvm/functions/Function0;)V", "Landroid/content/res/Resources;", "kotlin.jvm.PlatformType", "u", "Landroid/content/res/Resources;", "resources", "Landroid/view/View;", VKApiConst.VERSION, "Landroid/view/View;", "view", "Landroid/widget/ImageView;", "t", "Landroid/widget/ImageView;", "icon", "Landroid/widget/TextView;", "s", "Landroid/widget/TextView;", "title", "<init>", "(Landroid/view/View;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class CreditBrokerLinkViewImpl extends BaseViewHolder implements CreditBrokerLinkView {
    public final TextView s;
    public final ImageView t;
    public final Resources u;
    public final View v;

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
    public CreditBrokerLinkViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.v = view;
        View findViewById = view.findViewById(R.id.title);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.s = (TextView) findViewById;
        this.t = (ImageView) view.findViewById(R.id.icon);
        this.u = a2.b.a.a.a.u1(view, "view.context");
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.broker_link.CreditBrokerLinkView
    public void setOnClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "callback");
        this.v.setOnClickListener(new a(function0));
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.broker_link.CreditBrokerLinkView
    public void setPayment(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "payment");
        this.s.setText(this.u.getString(R.string.advert_details_credit_link_payment_from, str));
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.broker_link.CreditBrokerLinkView
    public void setTinkoffIcon(boolean z) {
        ImageView imageView = this.t;
        if (imageView != null) {
            imageView.setImageResource(z ? R.drawable.tinkoff_logo : R.drawable.banks_icons);
        }
    }
}
