package com.avito.android.basket_legacy.item;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.avito.android.basket.R;
import com.avito.android.basket_legacy.item.BasketItemView;
import com.avito.android.image_loader.Picture;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.avito.android.util.text.AttributedTextFormatterImpl;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u00103\u001a\u000202¢\u0006\u0004\b4\u00105J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\u000bJ\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0018\u001a\u00020\u00052\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001b\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u001b\u0010\u000bR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010%\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010\u001eR\u0016\u0010'\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010\u001eR\u0016\u0010)\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010\u001eR\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100¨\u00066"}, d2 = {"Lcom/avito/android/basket_legacy/item/BasketItemViewImpl;", "Lcom/avito/android/basket_legacy/item/BasketItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "Lcom/avito/android/remote/model/text/AttributedText;", MessengerShareContentUtility.SUBTITLE, "setSubtitle", "(Lcom/avito/android/remote/model/text/AttributedText;)V", "price", "setPrice", "", "cancelable", "setCancelable", "(Z)V", "Lcom/avito/android/image_loader/Picture;", "picture", "setPicture", "(Lcom/avito/android/image_loader/Picture;)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setCrossClickListener", "(Lkotlin/jvm/functions/Function0;)V", "oldPrice", "setOldPrice", "Landroid/widget/TextView;", VKApiConst.VERSION, "Landroid/widget/TextView;", "oldPriceView", "Landroid/widget/ImageView;", "x", "Landroid/widget/ImageView;", "iconCross", "u", "priceView", "t", "subtitleView", "s", "titleView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "w", "Lcom/facebook/drawee/view/SimpleDraweeView;", "icon", "Lcom/avito/android/util/text/AttributedTextFormatterImpl;", "y", "Lcom/avito/android/util/text/AttributedTextFormatterImpl;", "attributedTextFormatter", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "basket_release"}, k = 1, mv = {1, 4, 2})
public final class BasketItemViewImpl extends BaseViewHolder implements BasketItemView {
    public final TextView s;
    public final TextView t;
    public final TextView u;
    public final TextView v;
    public final SimpleDraweeView w;
    public final ImageView x;
    public final AttributedTextFormatterImpl y = new AttributedTextFormatterImpl();

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
    public BasketItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.title);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.s = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.subtitle);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.t = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.price);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        this.u = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.old_price);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.widget.TextView");
        this.v = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.icon);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        this.w = (SimpleDraweeView) findViewById5;
        View findViewById6 = view.findViewById(R.id.icon_cross);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.icon_cross)");
        this.x = (ImageView) findViewById6;
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        BasketItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.basket_legacy.item.BasketItemView
    public void setCancelable(boolean z) {
        Views.setVisible(this.x, z);
    }

    @Override // com.avito.android.basket_legacy.item.BasketItemView
    public void setCrossClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.x.setOnClickListener(new a(function0));
    }

    @Override // com.avito.android.basket_legacy.item.BasketItemView
    public void setOldPrice(@Nullable AttributedText attributedText) {
        TextView textView = this.v;
        AttributedTextFormatterImpl attributedTextFormatterImpl = this.y;
        Context context = textView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "oldPriceView.context");
        TextViews.bindText$default(textView, attributedTextFormatterImpl.format(context, attributedText), false, 2, null);
    }

    @Override // com.avito.android.basket_legacy.item.BasketItemView
    public void setPicture(@NotNull Picture picture) {
        Intrinsics.checkNotNullParameter(picture, "picture");
        a2.b.a.a.a.L0(this.w, picture);
    }

    @Override // com.avito.android.basket_legacy.item.BasketItemView
    public void setPrice(@NotNull AttributedText attributedText) {
        Intrinsics.checkNotNullParameter(attributedText, "price");
        TextView textView = this.u;
        AttributedTextFormatterImpl attributedTextFormatterImpl = this.y;
        Context context = textView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "priceView.context");
        TextViews.bindText$default(textView, attributedTextFormatterImpl.format(context, attributedText), false, 2, null);
    }

    @Override // com.avito.android.basket_legacy.item.BasketItemView
    public void setSubtitle(@Nullable AttributedText attributedText) {
        TextView textView = this.t;
        AttributedTextFormatterImpl attributedTextFormatterImpl = this.y;
        Context context = textView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "subtitleView.context");
        TextViews.bindText$default(textView, attributedTextFormatterImpl.format(context, attributedText), false, 2, null);
    }

    @Override // com.avito.android.basket_legacy.item.BasketItemView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.s.setText(str);
    }
}
