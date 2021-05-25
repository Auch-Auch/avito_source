package com.avito.android.advert.item.flats;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import com.avito.android.advert_core.advert.AdvertDetailsFlatView;
import com.avito.android.advert_core.advert.AdvertDetailsFlatViewImpl;
import com.avito.android.advert_core.advert.AdvertDetailsFlatsListener;
import com.avito.android.advert_details.R;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.model.AdvertParameters;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.util.Contexts;
import com.avito.android.util.Views;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010%\u001a\u00020$\u0012\u0006\u0010\u001e\u001a\u00020\u0017¢\u0006\u0004\b&\u0010'J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\u000b\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\"\u0010\u001e\u001a\u00020\u00178\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010#\u001a\n  *\u0004\u0018\u00010\u001f0\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006("}, d2 = {"Lcom/avito/android/advert/item/flats/AdvertDetailsFlatsViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/advert/item/flats/AdvertDetailsFlatsView;", "Lcom/avito/android/remote/model/text/AttributedText;", "title", "", "bindTitle", "(Lcom/avito/android/remote/model/text/AttributedText;)V", "", "Lcom/avito/android/remote/model/AdvertParameters$Parameter;", ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, "setParameters", "(Ljava/util/List;)V", "applyClosedAdvert", "()V", "", "u", "I", "closedAdvertColor", "Lcom/avito/android/advert_core/advert/AdvertDetailsFlatView;", "t", "Lcom/avito/android/advert_core/advert/AdvertDetailsFlatView;", "flatsView", "Lcom/avito/android/advert_core/advert/AdvertDetailsFlatsListener;", VKApiConst.VERSION, "Lcom/avito/android/advert_core/advert/AdvertDetailsFlatsListener;", "getListener", "()Lcom/avito/android/advert_core/advert/AdvertDetailsFlatsListener;", "setListener", "(Lcom/avito/android/advert_core/advert/AdvertDetailsFlatsListener;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "s", "Landroid/widget/TextView;", "flatsTitleView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;Lcom/avito/android/advert_core/advert/AdvertDetailsFlatsListener;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsFlatsViewImpl extends BaseViewHolder implements AdvertDetailsFlatsView {
    public final TextView s;
    public final AdvertDetailsFlatView t;
    public final int u;
    @NotNull
    public AdvertDetailsFlatsListener v;

    public static final class a<T> implements Consumer<DeepLink> {
        public final /* synthetic */ AdvertDetailsFlatsViewImpl a;

        public a(AdvertDetailsFlatsViewImpl advertDetailsFlatsViewImpl, AttributedText attributedText) {
            this.a = advertDetailsFlatsViewImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(DeepLink deepLink) {
            this.a.getListener().onFlatsClick("", "", deepLink);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdvertDetailsFlatsViewImpl(@NotNull View view, @NotNull AdvertDetailsFlatsListener advertDetailsFlatsListener) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(advertDetailsFlatsListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.v = advertDetailsFlatsListener;
        this.s = (TextView) view.findViewById(R.id.flats_container_title);
        View findViewById = view.findViewById(R.id.flat_container);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.flat_container)");
        this.t = new AdvertDetailsFlatViewImpl(findViewById, null, this.v, true, false, 16, null);
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        this.u = Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.gray48);
    }

    @Override // com.avito.android.advert.item.flats.AdvertDetailsFlatsView
    public void applyClosedAdvert() {
        this.t.forceColors(this.u);
    }

    @Override // com.avito.android.advert.item.flats.AdvertDetailsFlatsView
    public void bindTitle(@Nullable AttributedText attributedText) {
        if (attributedText != null) {
            Views.show(this.s);
            TextView textView = this.s;
            Intrinsics.checkNotNullExpressionValue(textView, "flatsTitleView");
            TextViewsKt.setAttributedText$default(textView, attributedText, null, 2, null);
            TextView textView2 = this.s;
            if (textView2 != null) {
                textView2.setMovementMethod(LinkMovementMethod.getInstance());
            }
            attributedText.linkClicks().subscribe(new a(this, attributedText));
        }
    }

    @NotNull
    public final AdvertDetailsFlatsListener getListener() {
        return this.v;
    }

    public final void setListener(@NotNull AdvertDetailsFlatsListener advertDetailsFlatsListener) {
        Intrinsics.checkNotNullParameter(advertDetailsFlatsListener, "<set-?>");
        this.v = advertDetailsFlatsListener;
    }

    @Override // com.avito.android.advert.item.flats.AdvertDetailsFlatsView
    public void setParameters(@NotNull List<AdvertParameters.Parameter> list) {
        Intrinsics.checkNotNullParameter(list, ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT);
        this.t.bind(list);
    }
}
