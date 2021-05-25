package com.avito.android.brandspace.items.mainbanner;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;
import com.avito.android.advert_core.analytics.contactbar.PhonePageSourceKt;
import com.avito.android.brandspace.R;
import com.avito.android.image_loader.AvitoPictureKt;
import com.avito.android.lib.design.button.Button;
import com.avito.android.lib.design.button.ButtonsKt;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.Size;
import com.avito.android.util.Images;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.vk.sdk.api.VKApiConst;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u001a¢\u0006\u0004\b\u001f\u0010 J?\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0007\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0006\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0014R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006!"}, d2 = {"Lcom/avito/android/brandspace/items/mainbanner/MainBannerItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/brandspace/items/mainbanner/MainBannerItemView;", "Lcom/avito/android/remote/model/Image;", "image", "", "title", "description", "actionText", "Landroid/view/View$OnClickListener;", "clickListener", "", "bind", "(Lcom/avito/android/remote/model/Image;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/view/View$OnClickListener;)V", "Lcom/facebook/drawee/view/SimpleDraweeView;", "s", "Lcom/facebook/drawee/view/SimpleDraweeView;", "imageView", "Landroid/widget/TextView;", "u", "Landroid/widget/TextView;", "Lcom/avito/android/lib/design/button/Button;", VKApiConst.VERSION, "Lcom/avito/android/lib/design/button/Button;", PhonePageSourceKt.PHONE_SOURCE_BUTTON, "t", "Landroid/view/View;", "w", "Landroid/view/View;", "overlay", "view", "<init>", "(Landroid/view/View;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class MainBannerItemViewImpl extends BaseViewHolder implements MainBannerItemView {
    public final SimpleDraweeView s;
    public final TextView t;
    public final TextView u;
    public final Button v;
    public final View w;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MainBannerItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.image);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.image)");
        this.s = (SimpleDraweeView) findViewById;
        View findViewById2 = view.findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.title)");
        this.t = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.description);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.description)");
        this.u = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.button);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.button)");
        this.v = (Button) findViewById4;
        View findViewById5 = view.findViewById(R.id.overlay);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.overlay)");
        this.w = findViewById5;
    }

    @Override // com.avito.android.brandspace.items.mainbanner.MainBannerItemView
    public void bind(@NotNull Image image, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable View.OnClickListener onClickListener) {
        Float f;
        Intrinsics.checkNotNullParameter(image, "image");
        boolean z = false;
        TextViews.bindText$default(this.t, str, false, 2, null);
        TextViews.bindText$default(this.u, str2, false, 2, null);
        ButtonsKt.bindText$default(this.v, str3, false, 2, null);
        this.v.setOnClickListener(onClickListener);
        View view = this.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "itemView");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "itemView.context.resources");
        boolean z2 = resources.getConfiguration().orientation == 2;
        Set<Size> keySet = image.getVariants().keySet();
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(keySet, 10));
        for (T t2 : keySet) {
            arrayList.add(Float.valueOf(((float) t2.getWidth()) / ((float) t2.getHeight())));
        }
        if (z2) {
            f = CollectionsKt___CollectionsKt.m358maxOrNull((Iterable<Float>) arrayList);
        } else {
            f = CollectionsKt___CollectionsKt.m362minOrNull((Iterable<Float>) arrayList);
        }
        float floatValue = f != null ? f.floatValue() : 1.33f;
        Map<Size, Uri> variants = image.getVariants();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<Size, Uri> entry : variants.entrySet()) {
            if (Math.abs((((float) entry.getKey().getWidth()) / ((float) entry.getKey().getHeight())) - floatValue) < 0.2f) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        Image copy = image.copy(linkedHashMap);
        this.s.setAspectRatio(Images.aspectRatio(copy, 1.33f));
        SimpleDraweeViewsKt.getRequestBuilder(this.s).picture(AvitoPictureKt.pictureOf$default(copy, false, 0.0f, 0.0f, null, 28, null)).cancelOnDetach(false).load();
        if (Views.isVisible(this.t) || Views.isVisible(this.u) || Views.isVisible(this.v)) {
            z = true;
        }
        Views.setVisible(this.w, z);
    }
}
