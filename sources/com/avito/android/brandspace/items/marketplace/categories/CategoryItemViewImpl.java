package com.avito.android.brandspace.items.marketplace.categories;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010%\u001a\u00020 ¢\u0006\u0004\b&\u0010'J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0019\u0010%\u001a\u00020 8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$¨\u0006("}, d2 = {"Lcom/avito/android/brandspace/items/marketplace/categories/CategoryItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/brandspace/items/marketplace/categories/CategoryItemView;", "Lcom/avito/android/remote/model/Image;", "image", "", "setPreviewImage", "(Lcom/avito/android/remote/model/Image;)V", "", "text", "setTitle", "(Ljava/lang/String;)V", "Lcom/avito/android/remote/model/UniversalColor;", "color", "setBackgroundColor", "(Lcom/avito/android/remote/model/UniversalColor;)V", "Landroid/view/View$OnClickListener;", "clickListener", "setOnClickListener", "(Landroid/view/View$OnClickListener;)V", "Landroidx/cardview/widget/CardView;", "u", "Landroidx/cardview/widget/CardView;", "cvCategory", "Lcom/facebook/drawee/view/SimpleDraweeView;", "s", "Lcom/facebook/drawee/view/SimpleDraweeView;", "ivPreview", "Landroid/widget/TextView;", "t", "Landroid/widget/TextView;", "tvTitle", "Landroid/view/View;", VKApiConst.VERSION, "Landroid/view/View;", "getView", "()Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class CategoryItemViewImpl extends BaseViewHolder implements CategoryItemView {
    public final SimpleDraweeView s;
    public final TextView t;
    public final CardView u;
    @NotNull
    public final View v;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CategoryItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.v = view;
        View findViewById = view.findViewById(R.id.iv_category_preview);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.iv_category_preview)");
        this.s = (SimpleDraweeView) findViewById;
        View findViewById2 = view.findViewById(R.id.tv_category_title);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.tv_category_title)");
        this.t = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.cv_root_category_preview);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.cv_root_category_preview)");
        this.u = (CardView) findViewById3;
    }

    @NotNull
    public final View getView() {
        return this.v;
    }

    @Override // com.avito.android.brandspace.items.marketplace.categories.CategoryItemView
    public void setBackgroundColor(@NotNull UniversalColor universalColor) {
        Intrinsics.checkNotNullParameter(universalColor, "color");
        Context context = this.u.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "cvCategory.context");
        this.u.setCardBackgroundColor(ContextsKt.getColorFrom(context, universalColor));
    }

    @Override // com.avito.android.brandspace.items.marketplace.categories.CategoryItemView
    public void setOnClickListener(@NotNull View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(onClickListener, "clickListener");
        this.v.setOnClickListener(onClickListener);
    }

    @Override // com.avito.android.brandspace.items.marketplace.categories.CategoryItemView
    public void setPreviewImage(@NotNull Image image) {
        Intrinsics.checkNotNullParameter(image, "image");
        SimpleDraweeViewsKt.getRequestBuilder(this.s).picture(AvitoPictureKt.pictureOf$default(image, false, 0.0f, 0.0f, null, 28, null)).retainImage(true).noFadeAnimation(true).load();
    }

    @Override // com.avito.android.brandspace.items.marketplace.categories.CategoryItemView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        TextViews.bindText$default(this.t, str, false, 2, null);
    }
}
