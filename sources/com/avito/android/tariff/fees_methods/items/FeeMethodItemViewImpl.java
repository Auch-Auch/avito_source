package com.avito.android.tariff.fees_methods.items;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.avito.android.image_loader.Picture;
import com.avito.android.remote.model.HighDemandIcon;
import com.avito.android.remote.model.HighDemandIconName;
import com.avito.android.tariff.R;
import com.avito.android.tariff.fees_methods.items.FeeMethodItemView;
import com.avito.android.util.ImageViewsKt;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.avito.android.util.color.ContextsKt;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u00102\u001a\u00020-¢\u0006\u0004\b8\u00109J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0013\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0013\u0010\u0011J\u001d\u0010\u0016\u001a\u00020\u00052\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001e\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010\u001d\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010,\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010\"R\u0019\u00102\u001a\u00020-8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u001e\u00105\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00107\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u0010\"¨\u0006:"}, d2 = {"Lcom/avito/android/tariff/fees_methods/items/FeeMethodItemViewImpl;", "Lcom/avito/android/tariff/fees_methods/items/FeeMethodItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/image_loader/Picture;", "picture", "", "setPicture", "(Lcom/avito/android/image_loader/Picture;)V", "hidePicture", "()V", "", "title", "setTitle", "(Ljava/lang/String;)V", "", "description", "setDescription", "(Ljava/lang/CharSequence;)V", "price", "setPrice", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnClickListener", "(Lkotlin/jvm/functions/Function0;)V", "", "isNeedTooShow", "showHighDemandIcon", "(Z)V", "Lcom/avito/android/remote/model/HighDemandIcon;", "icon", "setIcon", "(Lcom/avito/android/remote/model/HighDemandIcon;)V", "Landroid/widget/TextView;", "u", "Landroid/widget/TextView;", "priceView", "Landroid/widget/ImageView;", "w", "Landroid/widget/ImageView;", "highDemandView", "Lcom/facebook/drawee/view/SimpleDraweeView;", VKApiConst.VERSION, "Lcom/facebook/drawee/view/SimpleDraweeView;", "s", "titleView", "Landroid/view/View;", "y", "Landroid/view/View;", "getView", "()Landroid/view/View;", "view", "x", "Lkotlin/jvm/functions/Function0;", "clickListener", "t", "descriptionView", "<init>", "(Landroid/view/View;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class FeeMethodItemViewImpl extends BaseViewHolder implements FeeMethodItemView {
    public final TextView s;
    public final TextView t;
    public final TextView u;
    public final SimpleDraweeView v;
    public final ImageView w;
    public Function0<Unit> x;
    @NotNull
    public final View y;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ FeeMethodItemViewImpl a;

        public a(FeeMethodItemViewImpl feeMethodItemViewImpl) {
            this.a = feeMethodItemViewImpl;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function0 function0 = this.a.x;
            if (function0 != null) {
                Unit unit = (Unit) function0.invoke();
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeeMethodItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.y = view;
        View findViewById = view.findViewById(R.id.title);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.s = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.description);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.t = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.price);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        this.u = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.icon);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        this.v = (SimpleDraweeView) findViewById4;
        View findViewById5 = view.findViewById(R.id.highDemandIcon);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.widget.ImageView");
        this.w = (ImageView) findViewById5;
        view.setOnClickListener(new a(this));
    }

    @NotNull
    public final View getView() {
        return this.y;
    }

    @Override // com.avito.android.tariff.fees_methods.items.FeeMethodItemView
    public void hidePicture() {
        Views.hide(this.v);
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        FeeMethodItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.tariff.fees_methods.items.FeeMethodItemView
    public void setDescription(@Nullable CharSequence charSequence) {
        TextViews.bindText$default(this.t, charSequence, false, 2, null);
    }

    @Override // com.avito.android.tariff.fees_methods.items.FeeMethodItemView
    public void setIcon(@Nullable HighDemandIcon highDemandIcon) {
        HighDemandIconName icon = highDemandIcon != null ? highDemandIcon.getIcon() : null;
        if (icon == null) {
            ImageViewsKt.bindImageDrawable(this.w, null);
            return;
        }
        ImageViewsKt.bindImageDrawable(this.w, this.y.getContext().getDrawable(icon.getIconResId()));
        ImageView imageView = this.w;
        Context context = this.y.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        ImageViewsKt.setImageTintListCompat(imageView, ColorStateList.valueOf(ContextsKt.getColorFrom(context, highDemandIcon.getColor())));
    }

    @Override // com.avito.android.tariff.fees_methods.items.FeeMethodItemView
    public void setOnClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.x = function0;
    }

    @Override // com.avito.android.tariff.fees_methods.items.FeeMethodItemView
    public void setPicture(@NotNull Picture picture) {
        Intrinsics.checkNotNullParameter(picture, "picture");
        Views.show(this.v);
        SimpleDraweeViewsKt.loadPicture$default(this.v, picture, null, null, 6, null);
    }

    @Override // com.avito.android.tariff.fees_methods.items.FeeMethodItemView
    public void setPrice(@Nullable CharSequence charSequence) {
        TextViews.bindText$default(this.u, charSequence, false, 2, null);
    }

    @Override // com.avito.android.tariff.fees_methods.items.FeeMethodItemView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.s.setText(str);
    }

    @Override // com.avito.android.tariff.fees_methods.items.FeeMethodItemView
    public void showHighDemandIcon(boolean z) {
        Views.setVisible(this.w, z);
    }
}
