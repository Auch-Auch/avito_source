package com.avito.android.brandspace.items.marketplace.banner;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.avito.android.brandspace.R;
import com.avito.android.image_loader.AvitoPictureKt;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.UniversalColor;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.android.util.TextViews;
import com.avito.android.util.color.ContextsKt;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010'\u001a\u00020\"¢\u0006\u0004\b(\u0010)J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\u000bJ\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u0014R\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0019\u0010'\u001a\u00020\"8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&¨\u0006*"}, d2 = {"Lcom/avito/android/brandspace/items/marketplace/banner/BannerItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/brandspace/items/marketplace/banner/BannerItemView;", "Lcom/avito/android/remote/model/Image;", "image", "", "setImage", "(Lcom/avito/android/remote/model/Image;)V", "", "text", "setTitle", "(Ljava/lang/String;)V", "setDescription", "setUptitle", "Lcom/avito/android/remote/model/UniversalColor;", "color", "setBackground", "(Lcom/avito/android/remote/model/UniversalColor;)V", "Landroid/widget/TextView;", "t", "Landroid/widget/TextView;", "tvTitle", VKApiConst.VERSION, "tvUptitle", "Lcom/facebook/drawee/view/SimpleDraweeView;", "s", "Lcom/facebook/drawee/view/SimpleDraweeView;", "ivBannerPicture", "u", "tvDescription", "Landroid/view/ViewGroup;", "w", "Landroid/view/ViewGroup;", "rootViewGroup", "Landroid/view/View;", "x", "Landroid/view/View;", "getView", "()Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class BannerItemViewImpl extends BaseViewHolder implements BannerItemView {
    public final SimpleDraweeView s;
    public final TextView t;
    public final TextView u;
    public final TextView v;
    public final ViewGroup w;
    @NotNull
    public final View x;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BannerItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.x = view;
        View findViewById = view.findViewById(R.id.iv_banner_picture);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.iv_banner_picture)");
        this.s = (SimpleDraweeView) findViewById;
        View findViewById2 = view.findViewById(R.id.tv_banner_title);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.tv_banner_title)");
        this.t = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.tv_banner_description);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.tv_banner_description)");
        this.u = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.tv_banner_uptitle);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.tv_banner_uptitle)");
        this.v = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.root_marketplace_banner);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.root_marketplace_banner)");
        this.w = (ViewGroup) findViewById5;
    }

    @NotNull
    public final View getView() {
        return this.x;
    }

    @Override // com.avito.android.brandspace.items.marketplace.banner.BannerItemView
    public void setBackground(@NotNull UniversalColor universalColor) {
        Intrinsics.checkNotNullParameter(universalColor, "color");
        Context context = this.w.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "rootViewGroup.context");
        this.w.setBackgroundColor(ContextsKt.getColorFrom(context, universalColor));
    }

    @Override // com.avito.android.brandspace.items.marketplace.banner.BannerItemView
    public void setDescription(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        TextViews.bindText$default(this.u, str, false, 2, null);
    }

    @Override // com.avito.android.brandspace.items.marketplace.banner.BannerItemView
    public void setImage(@NotNull Image image) {
        Intrinsics.checkNotNullParameter(image, "image");
        SimpleDraweeViewsKt.getRequestBuilder(this.s).picture(AvitoPictureKt.pictureOf$default(image, true, 0.0f, 0.0f, null, 28, null)).retainImage(true).noFadeAnimation(true).load();
    }

    @Override // com.avito.android.brandspace.items.marketplace.banner.BannerItemView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        TextViews.bindText$default(this.t, str, false, 2, null);
    }

    @Override // com.avito.android.brandspace.items.marketplace.banner.BannerItemView
    public void setUptitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        TextViews.bindText$default(this.v, str, false, 2, null);
    }
}
