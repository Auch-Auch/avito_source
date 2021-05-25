package com.avito.android.advert.item.delivery;

import android.view.View;
import android.widget.TextView;
import com.avito.android.advert.item.delivery.AdvertDetailsDeliveryActionsView;
import com.avito.android.advert_details.R;
import com.avito.android.remote.model.AdvertDeliveryC2C;
import com.avito.android.remote.model.SimpleAction;
import com.avito.android.remote.model.delivery.DeliveryLabel;
import com.avito.android.util.TextViews;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\f¢\u0006\u0004\b\u001d\u0010\u001eJ'\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u000eR\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0012R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u000eR\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/avito/android/advert/item/delivery/AdvertDetailsDeliveryActionsViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/advert/item/delivery/AdvertDetailsDeliveryActionsView;", "Lcom/avito/android/remote/model/AdvertDeliveryC2C;", "delivery", "", "secondaryLabelStyle", "Lcom/avito/android/advert/item/delivery/AdvertDetailsDeliveryActionsView$Router;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "showDelivery", "(Lcom/avito/android/remote/model/AdvertDeliveryC2C;ILcom/avito/android/advert/item/delivery/AdvertDetailsDeliveryActionsView$Router;)V", "Landroid/view/View;", "s", "Landroid/view/View;", "deliveryActionsView", "Landroid/widget/TextView;", "x", "Landroid/widget/TextView;", "secondaryLabel", "u", "primaryButtonClickContainer", "t", "primaryButton", VKApiConst.VERSION, "secondaryButton", "w", "secondaryLink", "view", "<init>", "(Landroid/view/View;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsDeliveryActionsViewImpl extends BaseViewHolder implements AdvertDetailsDeliveryActionsView {
    public View s;
    public TextView t;
    public View u;
    public View v;
    public TextView w;
    public TextView x;

    /* compiled from: java-style lambda group */
    public static final class a implements View.OnClickListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ Object c;
        public final /* synthetic */ Object d;

        public a(int i, Object obj, Object obj2, Object obj3) {
            this.a = i;
            this.b = obj;
            this.c = obj2;
            this.d = obj3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.a;
            if (i == 0) {
                ((AdvertDetailsDeliveryActionsView.Router) this.d).followUri(((SimpleAction) this.b).getUri(), true);
            } else if (i == 1) {
                ((AdvertDetailsDeliveryActionsView.Router) this.d).followUri(((SimpleAction) this.b).getUri(), false);
            } else {
                throw null;
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdvertDetailsDeliveryActionsViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.layout_delivery_buttons);
        this.s = findViewById;
        TextView textView = null;
        this.t = findViewById != null ? (TextView) findViewById.findViewById(R.id.primary_button) : null;
        View view2 = this.s;
        this.u = view2 != null ? view2.findViewById(R.id.primary_button_container) : null;
        View view3 = this.s;
        this.v = view3 != null ? view3.findViewById(R.id.secondary_button) : null;
        View view4 = this.s;
        this.w = view4 != null ? (TextView) view4.findViewById(R.id.secondary_link) : null;
        View view5 = this.s;
        this.x = view5 != null ? (TextView) view5.findViewById(R.id.secondary_label) : textView;
    }

    @Override // com.avito.android.advert.item.delivery.AdvertDetailsDeliveryActionsView
    public void showDelivery(@NotNull AdvertDeliveryC2C advertDeliveryC2C, int i, @NotNull AdvertDetailsDeliveryActionsView.Router router) {
        DeliveryLabel secondaryLabel;
        TextView textView;
        SimpleAction secondary;
        SimpleAction primary;
        Intrinsics.checkNotNullParameter(advertDeliveryC2C, "delivery");
        Intrinsics.checkNotNullParameter(router, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        AdvertDeliveryC2C.Actions actions = advertDeliveryC2C.getActions();
        if (!(actions == null || (primary = actions.getPrimary()) == null)) {
            TextView textView2 = this.t;
            if (textView2 != null) {
                TextViews.bindText$default(textView2, primary.getTitle(), false, 2, null);
            }
            View view = this.u;
            if (view != null) {
                view.setOnClickListener(new a(0, primary, this, router));
            }
        }
        AdvertDeliveryC2C.Actions actions2 = advertDeliveryC2C.getActions();
        if (!(actions2 == null || (secondary = actions2.getSecondary()) == null)) {
            TextView textView3 = this.w;
            if (textView3 != null) {
                TextViews.bindText$default(textView3, secondary.getTitle(), false, 2, null);
            }
            View view2 = this.v;
            if (view2 != null) {
                view2.setOnClickListener(new a(1, secondary, this, router));
            }
        }
        AdvertDeliveryC2C.Actions actions3 = advertDeliveryC2C.getActions();
        if (!(actions3 == null || (secondaryLabel = actions3.getSecondaryLabel()) == null || (textView = this.x) == null)) {
            TextViews.bindText$default(textView, secondaryLabel.getText(), false, 2, null);
        }
        TextView textView4 = this.x;
        if (textView4 != null) {
            textView4.setBackgroundResource(com.avito.android.ui_components.R.drawable.delivery_green_label_background);
            TextViews.setTextAppearanceCompat(textView4, i);
        }
    }
}
