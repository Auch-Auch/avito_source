package com.avito.android.vas_performance.ui.items.banner;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.avito.android.image_loader.AvitoPictureKt;
import com.avito.android.lib.util.DarkThemeManagerKt;
import com.avito.android.remote.model.UniversalColor;
import com.avito.android.remote.model.UniversalImage;
import com.avito.android.remote.model.UniversalImageKt;
import com.avito.android.util.SimpleDraweeView;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.avito.android.util.color.ContextsKt;
import com.avito.android.vas_performance.R;
import com.avito.android.vas_performance.ui.items.banner.VasBundleBannerItemView;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.vk.sdk.api.VKApiConst;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b \u0010!J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000e\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/avito/android/vas_performance/ui/items/banner/VasBundleBannerItemViewImpl;", "Lcom/avito/android/vas_performance/ui/items/banner/VasBundleBannerItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "title", "", "setText", "(Ljava/lang/String;)V", "Lcom/avito/android/remote/model/UniversalColor;", "color", "setBackgroundColor", "(Lcom/avito/android/remote/model/UniversalColor;)V", "Lcom/avito/android/remote/model/UniversalImage;", "image", "setImage", "(Lcom/avito/android/remote/model/UniversalImage;)V", "Lcom/avito/android/util/SimpleDraweeView;", "u", "Lcom/avito/android/util/SimpleDraweeView;", "pictureView", "Landroid/view/View;", VKApiConst.VERSION, "Landroid/view/View;", "view", "Landroid/widget/TextView;", "s", "Landroid/widget/TextView;", "titleView", "Landroid/view/ViewGroup;", "t", "Landroid/view/ViewGroup;", "bannerContainer", "<init>", "(Landroid/view/View;)V", "vas-performance_release"}, k = 1, mv = {1, 4, 2})
public final class VasBundleBannerItemViewImpl extends BaseViewHolder implements VasBundleBannerItemView {
    public final TextView s;
    public final ViewGroup t;
    public final SimpleDraweeView u;
    public final View v;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VasBundleBannerItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.v = view;
        View findViewById = view.findViewById(R.id.title);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.s = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.vas_bundle_banner_container);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.ViewGroup");
        this.t = (ViewGroup) findViewById2;
        View findViewById3 = view.findViewById(R.id.picture);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type com.avito.android.util.SimpleDraweeView");
        this.u = (SimpleDraweeView) findViewById3;
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        VasBundleBannerItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.vas_performance.ui.items.banner.VasBundleBannerItemView
    public void setBackgroundColor(@NotNull UniversalColor universalColor) {
        Intrinsics.checkNotNullParameter(universalColor, "color");
        Context context = this.v.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        this.t.setBackgroundTintList(ColorStateList.valueOf(ContextsKt.getColorFrom(context, universalColor)));
    }

    @Override // com.avito.android.vas_performance.ui.items.banner.VasBundleBannerItemView
    public void setImage(@Nullable UniversalImage universalImage) {
        if (universalImage != null) {
            Context context = this.v.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            SimpleDraweeViewsKt.loadPicture$default(this.u, AvitoPictureKt.pictureOf$default(UniversalImageKt.getImageDependsOnTheme(universalImage, DarkThemeManagerKt.isLightTheme(context)), true, 0.0f, 0.0f, null, 28, null), null, null, 6, null);
            Views.show(this.u);
            return;
        }
        Views.hide(this.u);
    }

    @Override // com.avito.android.vas_performance.ui.items.banner.VasBundleBannerItemView
    public void setText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        TextViews.bindText$default(this.s, str, false, 2, null);
    }
}
