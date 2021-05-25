package com.avito.android.bundles.vas_union.item.performance.vas;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.avito.android.bundles.vas_union.item.performance.vas.PerformanceVasItemView;
import com.avito.android.image_loader.Picture;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.util.TextViews;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.android.vas_performance.R;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u0010\u001d\u001a\u00020\u001a¢\u0006\u0004\b*\u0010+J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\r\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\r\u0010\u000bJ\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0014\u001a\u00020\u00052\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u0018R\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010\u0018¨\u0006,"}, d2 = {"Lcom/avito/android/bundles/vas_union/item/performance/vas/PerformanceVasItemViewImpl;", "Lcom/avito/android/bundles/vas_union/item/performance/vas/PerformanceVasItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "Lcom/avito/android/remote/model/text/AttributedText;", "price", "setPrice", "(Lcom/avito/android/remote/model/text/AttributedText;)V", "oldPrice", "setOldPrice", "Lcom/avito/android/image_loader/Picture;", "picture", "setPicture", "(Lcom/avito/android/image_loader/Picture;)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "Landroid/widget/TextView;", "s", "Landroid/widget/TextView;", "titleView", "Lcom/avito/android/util/text/AttributedTextFormatter;", "x", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "t", "priceView", "Landroid/view/View;", "w", "Landroid/view/View;", "view", "Lcom/facebook/drawee/view/SimpleDraweeView;", VKApiConst.VERSION, "Lcom/facebook/drawee/view/SimpleDraweeView;", "icon", "u", "priceOldView", "<init>", "(Landroid/view/View;Lcom/avito/android/util/text/AttributedTextFormatter;)V", "vas-bundles_release"}, k = 1, mv = {1, 4, 2})
public final class PerformanceVasItemViewImpl extends BaseViewHolder implements PerformanceVasItemView {
    public final TextView s;
    public final TextView t;
    public final TextView u;
    public final SimpleDraweeView v;
    public final View w;
    public final AttributedTextFormatter x;

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
    public PerformanceVasItemViewImpl(@NotNull View view, @NotNull AttributedTextFormatter attributedTextFormatter) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        this.w = view;
        this.x = attributedTextFormatter;
        View findViewById = view.findViewById(R.id.title);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.s = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.price);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.t = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.price_old);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        this.u = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.icon);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        this.v = (SimpleDraweeView) findViewById4;
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        PerformanceVasItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.bundles.vas_union.item.performance.vas.PerformanceVasItemView
    public void setClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.w.setOnClickListener(new a(function0));
    }

    @Override // com.avito.android.bundles.vas_union.item.performance.vas.PerformanceVasItemView
    public void setOldPrice(@Nullable AttributedText attributedText) {
        TextView textView = this.u;
        AttributedTextFormatter attributedTextFormatter = this.x;
        Context context = this.w.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        TextViews.bindText$default(textView, attributedTextFormatter.format(context, attributedText), false, 2, null);
    }

    @Override // com.avito.android.bundles.vas_union.item.performance.vas.PerformanceVasItemView
    public void setPicture(@NotNull Picture picture) {
        Intrinsics.checkNotNullParameter(picture, "picture");
        a2.b.a.a.a.L0(this.v, picture);
    }

    @Override // com.avito.android.bundles.vas_union.item.performance.vas.PerformanceVasItemView
    public void setPrice(@Nullable AttributedText attributedText) {
        TextView textView = this.t;
        AttributedTextFormatter attributedTextFormatter = this.x;
        Context context = this.w.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        TextViews.bindText$default(textView, attributedTextFormatter.format(context, attributedText), false, 2, null);
    }

    @Override // com.avito.android.bundles.vas_union.item.performance.vas.PerformanceVasItemView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.s.setText(str);
    }
}
