package com.avito.android.advert.item.icebreakers;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.avito.android.advert_details.R;
import com.avito.android.lib.design.button.Button;
import com.avito.android.remote.model.IceBreaker;
import com.avito.android.util.TextViews;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.flexbox.FlexboxLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\u001e\u0010\u000e\u001a\n \u000b*\u0004\u0018\u00010\n0\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/avito/android/advert/item/icebreakers/AdvertDetailsIceBreakersViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/advert/item/icebreakers/AdvertDetailsIceBreakersView;", "Lcom/avito/android/advert/item/icebreakers/AdvertDetailsIceBreakersItem;", "item", "Lcom/avito/android/advert/item/icebreakers/IcebreakersListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "setIcebreakers", "(Lcom/avito/android/advert/item/icebreakers/AdvertDetailsIceBreakersItem;Lcom/avito/android/advert/item/icebreakers/IcebreakersListener;)V", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "u", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/View;", VKApiConst.VERSION, "Landroid/view/View;", "view", "Lcom/google/android/flexbox/FlexboxLayout;", "t", "Lcom/google/android/flexbox/FlexboxLayout;", "container", "Landroid/widget/TextView;", "s", "Landroid/widget/TextView;", "title", "<init>", "(Landroid/view/View;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsIceBreakersViewImpl extends BaseViewHolder implements AdvertDetailsIceBreakersView {
    public final TextView s;
    public final FlexboxLayout t;
    public final LayoutInflater u;
    public final View v;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ IceBreaker a;
        public final /* synthetic */ int b;
        public final /* synthetic */ IcebreakersListener c;

        public a(IceBreaker iceBreaker, int i, AdvertDetailsIceBreakersViewImpl advertDetailsIceBreakersViewImpl, IcebreakersListener icebreakersListener) {
            this.a = iceBreaker;
            this.b = i;
            this.c = icebreakersListener;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.c.onIcebreakerClick(this.a, this.b);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdvertDetailsIceBreakersViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.v = view;
        View findViewById = view.findViewById(R.id.ice_breakers_title);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.s = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.ice_breakers_container);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type com.google.android.flexbox.FlexboxLayout");
        this.t = (FlexboxLayout) findViewById2;
        this.u = LayoutInflater.from(view.getContext());
    }

    @Override // com.avito.android.advert.item.icebreakers.AdvertDetailsIceBreakersView
    public void setIcebreakers(@NotNull AdvertDetailsIceBreakersItem advertDetailsIceBreakersItem, @NotNull IcebreakersListener icebreakersListener) {
        Intrinsics.checkNotNullParameter(advertDetailsIceBreakersItem, "item");
        Intrinsics.checkNotNullParameter(icebreakersListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        if (this.t.getChildCount() == 0) {
            TextViews.bindText$default(this.s, advertDetailsIceBreakersItem.getIcebreakers().getContact(), false, 2, null);
            int i = 0;
            for (T t2 : advertDetailsIceBreakersItem.getIcebreakers().getTexts()) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                T t3 = t2;
                View inflate = this.u.inflate(R.layout.advert_details_icebreaker, (ViewGroup) this.t, false);
                Objects.requireNonNull(inflate, "null cannot be cast to non-null type com.avito.android.lib.design.button.Button");
                Button button = (Button) inflate;
                button.setText(t3.getPreviewText());
                button.setOnClickListener(new a(t3, i, this, icebreakersListener));
                this.t.addView(button);
                i = i2;
            }
            icebreakersListener.onShowIcebreakers();
        }
    }
}
