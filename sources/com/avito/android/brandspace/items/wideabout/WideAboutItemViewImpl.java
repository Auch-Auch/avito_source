package com.avito.android.brandspace.items.wideabout;

import a2.a.a.w.b.b.a;
import android.view.View;
import android.widget.TextView;
import com.avito.android.brandspace.R;
import com.avito.android.brandspace.presenter.BrandspaceItemBuilderKt;
import com.avito.android.brandspace.remote.model.BrandspaceAboutParagraphElement;
import com.avito.android.image_loader.AvitoPictureKt;
import com.avito.android.remote.model.Image;
import com.avito.android.util.Images;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ1\u0010\u000b\u001a\u00020\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001d"}, d2 = {"Lcom/avito/android/brandspace/items/wideabout/WideAboutItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/brandspace/items/wideabout/WideAboutItemView;", "", "title", "Lcom/avito/android/remote/model/Image;", "image", "", "Lcom/avito/android/brandspace/remote/model/BrandspaceAboutParagraphElement;", "paragraphs", "", "bind", "(Ljava/lang/String;Lcom/avito/android/remote/model/Image;Ljava/util/List;)V", "La2/a/a/w/b/b/a;", "u", "La2/a/a/w/b/b/a;", "paragraphsView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "t", "Lcom/facebook/drawee/view/SimpleDraweeView;", "imageView", "Landroid/widget/TextView;", "s", "Landroid/widget/TextView;", "titleView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class WideAboutItemViewImpl extends BaseViewHolder implements WideAboutItemView {
    public final TextView s;
    public final SimpleDraweeView t;
    public final a u;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WideAboutItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.title)");
        this.s = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.image);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.image)");
        this.t = (SimpleDraweeView) findViewById2;
        View findViewById3 = view.findViewById(R.id.paragraph_container);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.paragraph_container)");
        this.u = new a(findViewById3);
    }

    @Override // com.avito.android.brandspace.items.wideabout.WideAboutItemView
    public void bind(@Nullable String str, @Nullable Image image, @NotNull List<BrandspaceAboutParagraphElement> list) {
        Intrinsics.checkNotNullParameter(list, "paragraphs");
        TextViews.bindText$default(this.s, str, false, 2, null);
        boolean z = true;
        if (image == null || !BrandspaceItemBuilderKt.isValid(image)) {
            z = false;
        }
        Views.setVisible(this.t, z);
        if (z) {
            SimpleDraweeView simpleDraweeView = this.t;
            Intrinsics.checkNotNull(image);
            simpleDraweeView.setAspectRatio(Images.aspectRatio(image, 2.0f));
            SimpleDraweeViewsKt.getRequestBuilder(this.t).picture(AvitoPictureKt.pictureOf$default(image, false, 0.0f, 0.0f, null, 28, null)).cancelOnDetach(false).load();
        }
        a aVar = this.u;
        Objects.requireNonNull(aVar);
        Intrinsics.checkNotNullParameter(list, "data");
        aVar.reuseChildrenView(aVar.a, list);
        View childAt = aVar.a.getChildAt(0);
        if (childAt != null) {
            Views.changeMargin$default(childAt, 0, 0, 0, 0, 13, null);
        }
    }
}
