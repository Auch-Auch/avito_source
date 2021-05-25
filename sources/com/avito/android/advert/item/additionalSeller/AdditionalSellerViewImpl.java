package com.avito.android.advert.item.additionalSeller;

import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import com.avito.android.advert.item.additionalSeller.AdditionalSellerView;
import com.avito.android.advert_core.advert.AdvertDetailsFlatView;
import com.avito.android.advert_core.advert.AdvertDetailsFlatViewImpl;
import com.avito.android.advert_details.R;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.lib.design.button.Button;
import com.avito.android.lib.design.button.ButtonsKt;
import com.avito.android.remote.model.AdditionalSellerAdditionalButton;
import com.avito.android.remote.model.AdditionalSellerButtons;
import com.avito.android.remote.model.AdvertParameters;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.util.text.TextViewsKt;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010-\u001a\u00020\u0017\u0012\u0006\u0010*\u001a\u00020%¢\u0006\u0004\b.\u0010/J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\u000b\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000f\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010\u0019R\u0019\u0010*\u001a\u00020%8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0016\u0010,\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010!¨\u00060"}, d2 = {"Lcom/avito/android/advert/item/additionalSeller/AdditionalSellerViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/advert/item/additionalSeller/AdditionalSellerView;", "Lcom/avito/android/remote/model/text/AttributedText;", "title", "", "setTitle", "(Lcom/avito/android/remote/model/text/AttributedText;)V", "", "Lcom/avito/android/remote/model/AdvertParameters$Parameter;", "params", "bindParams", "(Ljava/util/List;)V", "Lcom/avito/android/remote/model/AdditionalSellerButtons;", "additionalSellerButtons", "bindButtons", "(Lcom/avito/android/remote/model/AdditionalSellerButtons;)V", "hideDivider", "()V", "Landroid/widget/TextView;", "s", "Landroid/widget/TextView;", "titleView", "Landroid/view/View;", "x", "Landroid/view/View;", "dividerTop", "Lcom/avito/android/advert_core/advert/AdvertDetailsFlatView;", "t", "Lcom/avito/android/advert_core/advert/AdvertDetailsFlatView;", "flatsView", "Lcom/avito/android/lib/design/button/Button;", VKApiConst.VERSION, "Lcom/avito/android/lib/design/button/Button;", "mainButton", "u", "buttonsContainer", "Lcom/avito/android/advert/item/additionalSeller/AdditionalSellerView$Listener;", "y", "Lcom/avito/android/advert/item/additionalSeller/AdditionalSellerView$Listener;", "getListener", "()Lcom/avito/android/advert/item/additionalSeller/AdditionalSellerView$Listener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "w", "additionalButton", "view", "<init>", "(Landroid/view/View;Lcom/avito/android/advert/item/additionalSeller/AdditionalSellerView$Listener;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdditionalSellerViewImpl extends BaseViewHolder implements AdditionalSellerView {
    public final TextView s;
    public final AdvertDetailsFlatView t;
    public final View u;
    public final Button v;
    public final Button w;
    public final View x;
    @NotNull
    public final AdditionalSellerView.Listener y;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ DeepLink a;
        public final /* synthetic */ AdditionalSellerViewImpl b;

        public a(DeepLink deepLink, AdditionalSellerViewImpl additionalSellerViewImpl, AdditionalSellerButtons additionalSellerButtons) {
            this.a = deepLink;
            this.b = additionalSellerViewImpl;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.b.getListener().onAdditionalSellerClicks(this.a);
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ AdditionalSellerAdditionalButton a;
        public final /* synthetic */ AdditionalSellerViewImpl b;

        public b(AdditionalSellerAdditionalButton additionalSellerAdditionalButton, AdditionalSellerViewImpl additionalSellerViewImpl) {
            this.a = additionalSellerAdditionalButton;
            this.b = additionalSellerViewImpl;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.b.getListener().onOpenCallBottomSheet(this.a.getDetails());
        }
    }

    public static final class c<T> implements Consumer<DeepLink> {
        public final /* synthetic */ AdditionalSellerViewImpl a;

        public c(AdditionalSellerViewImpl additionalSellerViewImpl) {
            this.a = additionalSellerViewImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(DeepLink deepLink) {
            DeepLink deepLink2 = deepLink;
            AdditionalSellerView.Listener listener = this.a.getListener();
            Intrinsics.checkNotNullExpressionValue(deepLink2, "link");
            listener.onAdditionalSellerClicks(deepLink2);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdditionalSellerViewImpl(@NotNull View view, @NotNull AdditionalSellerView.Listener listener) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.y = listener;
        this.s = (TextView) view.findViewById(R.id.title);
        this.t = new AdvertDetailsFlatViewImpl(view, null, listener, true, true, 2, null);
        View findViewById = view.findViewById(R.id.additional_seller_button_container);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.a…_seller_button_container)");
        this.u = findViewById;
        View findViewById2 = view.findViewById(R.id.additional_seller_main_button);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.a…ional_seller_main_button)");
        this.v = (Button) findViewById2;
        View findViewById3 = view.findViewById(R.id.additional_seller_additional_button);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.a…seller_additional_button)");
        this.w = (Button) findViewById3;
        View findViewById4 = view.findViewById(R.id.additional_seller_divider_top);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.a…ional_seller_divider_top)");
        this.x = findViewById4;
    }

    @Override // com.avito.android.advert.item.additionalSeller.AdditionalSellerView
    public void bindButtons(@Nullable AdditionalSellerButtons additionalSellerButtons) {
        if (additionalSellerButtons != null) {
            DeepLink deeplink = additionalSellerButtons.getMain().getDeeplink();
            if (deeplink != null) {
                this.u.setVisibility(0);
                ButtonsKt.bindText$default(this.v, additionalSellerButtons.getMain().getTitle(), false, 2, null);
                this.v.setOnClickListener(new a(deeplink, this, additionalSellerButtons));
            }
            AdditionalSellerAdditionalButton additional = additionalSellerButtons.getAdditional();
            if (additional != null) {
                this.w.setVisibility(0);
                this.w.setOnClickListener(new b(additional, this));
            }
        }
    }

    @Override // com.avito.android.advert.item.additionalSeller.AdditionalSellerView
    public void bindParams(@NotNull List<AdvertParameters.Parameter> list) {
        Intrinsics.checkNotNullParameter(list, "params");
        this.t.bind(list);
    }

    @NotNull
    public final AdditionalSellerView.Listener getListener() {
        return this.y;
    }

    @Override // com.avito.android.advert.item.additionalSeller.AdditionalSellerView
    public void hideDivider() {
        this.x.setVisibility(8);
    }

    @Override // com.avito.android.advert.item.additionalSeller.AdditionalSellerView
    public void setTitle(@Nullable AttributedText attributedText) {
        if (attributedText != null) {
            TextView textView = this.s;
            if (textView != null) {
                TextViewsKt.setAttributedText$default(textView, attributedText, null, 2, null);
            }
            TextView textView2 = this.s;
            if (textView2 != null) {
                textView2.setMovementMethod(LinkMovementMethod.getInstance());
            }
            attributedText.linkClicks().subscribe(new c(this));
        }
    }
}
