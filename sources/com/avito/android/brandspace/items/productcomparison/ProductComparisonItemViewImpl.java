package com.avito.android.brandspace.items.productcomparison;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.avito.android.brandspace.R;
import com.avito.android.brandspace.items.productcomparison.ProductComparisonItemView;
import com.avito.android.brandspace.items.textmeasurement.TextMeasurer;
import com.avito.android.image_loader.AvitoPictureKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.android.util.Images;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.android.util.TextViews;
import com.avito.android.util.ViewGroupsKt;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.vk.sdk.api.VKApiConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001%B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0013¢\u0006\u0004\b#\u0010$JC\u0010\u000e\u001a\u00020\r2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\nH\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u0006\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u001fR\u0016\u0010!\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010\u0019R\u0016\u0010\u0007\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010\u001f¨\u0006&"}, d2 = {"Lcom/avito/android/brandspace/items/productcomparison/ProductComparisonItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/brandspace/items/productcomparison/ProductComparisonItemView;", "Lcom/avito/android/remote/model/Image;", "image", "", "title", "description", "", "headerTextHeight", "", "Lcom/avito/android/brandspace/items/productcomparison/ProductComparisonItemProperty;", "properties", "", "bind", "(Lcom/avito/android/remote/model/Image;Ljava/lang/String;Ljava/lang/String;ILjava/util/List;)V", "Landroid/widget/TextView;", "t", "()Ljava/util/List;", "Landroid/view/View;", "x", "Landroid/view/View;", "view", "Landroid/view/ViewGroup;", "w", "Landroid/view/ViewGroup;", "propertyContainer", "Lcom/facebook/drawee/view/SimpleDraweeView;", "s", "Lcom/facebook/drawee/view/SimpleDraweeView;", "imageView", "Landroid/widget/TextView;", VKApiConst.VERSION, "headerTextContainer", "u", "<init>", "(Landroid/view/View;)V", "MeasurerImpl", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class ProductComparisonItemViewImpl extends BaseViewHolder implements ProductComparisonItemView {
    public final SimpleDraweeView s;
    public final TextView t;
    public final TextView u;
    public final ViewGroup v;
    public final ViewGroup w;
    public final View x;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u0019\u001a\u00020\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ#\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001e"}, d2 = {"Lcom/avito/android/brandspace/items/productcomparison/ProductComparisonItemViewImpl$MeasurerImpl;", "Lcom/avito/android/brandspace/items/productcomparison/ProductComparisonItemView$Measurer;", "", "title", "description", "Lcom/avito/android/brandspace/items/productcomparison/ProductComparisonItemView$Layout;", "measure", "(Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/brandspace/items/productcomparison/ProductComparisonItemView$Layout;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Lcom/avito/android/brandspace/items/textmeasurement/TextMeasurer$TextParams;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/brandspace/items/textmeasurement/TextMeasurer$TextParams;", "descriptionParams", AuthSource.SEND_ABUSE, "titleParams", "Lcom/avito/android/brandspace/items/textmeasurement/TextMeasurer;", "c", "Lcom/avito/android/brandspace/items/textmeasurement/TextMeasurer;", "textMeasurer", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;Lcom/avito/android/brandspace/items/textmeasurement/TextMeasurer;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
    public static final class MeasurerImpl implements ProductComparisonItemView.Measurer {
        public final TextMeasurer.TextParams a;
        public final TextMeasurer.TextParams b;
        public final TextMeasurer c;

        public MeasurerImpl(@NotNull View view, @NotNull TextMeasurer textMeasurer) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(textMeasurer, "textMeasurer");
            this.c = textMeasurer;
            ProductComparisonItemViewImpl productComparisonItemViewImpl = new ProductComparisonItemViewImpl(view);
            int paddingLeft = (view.getLayoutParams().width - view.getPaddingLeft()) - view.getPaddingRight();
            this.a = textMeasurer.createTextParams(productComparisonItemViewImpl.t, paddingLeft);
            this.b = textMeasurer.createTextParams(productComparisonItemViewImpl.u, paddingLeft);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!Intrinsics.areEqual(MeasurerImpl.class, obj != null ? obj.getClass() : null)) {
                return false;
            }
            Objects.requireNonNull(obj, "null cannot be cast to non-null type com.avito.android.brandspace.items.productcomparison.ProductComparisonItemViewImpl.MeasurerImpl");
            MeasurerImpl measurerImpl = (MeasurerImpl) obj;
            return !(Intrinsics.areEqual(this.a, measurerImpl.a) ^ true) && !(Intrinsics.areEqual(this.b, measurerImpl.b) ^ true);
        }

        public int hashCode() {
            return this.b.hashCode() + (this.a.hashCode() * 31);
        }

        @Override // com.avito.android.brandspace.items.productcomparison.ProductComparisonItemView.Measurer
        @NotNull
        public ProductComparisonItemView.Layout measure(@Nullable String str, @Nullable String str2) {
            return new ProductComparisonItemView.Layout(this.c.measure(str, this.a), this.c.measure(str2, this.b));
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProductComparisonItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.x = view;
        View findViewById = view.findViewById(R.id.image);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.image)");
        this.s = (SimpleDraweeView) findViewById;
        View findViewById2 = view.findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.title)");
        this.t = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.description);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.description)");
        this.u = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.header_text_container);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.header_text_container)");
        this.v = (ViewGroup) findViewById4;
        View findViewById5 = view.findViewById(R.id.property_container);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.property_container)");
        this.w = (ViewGroup) findViewById5;
    }

    @Override // com.avito.android.brandspace.items.productcomparison.ProductComparisonItemView
    public void bind(@Nullable Image image, @Nullable String str, @Nullable String str2, int i, @NotNull List<ProductComparisonItemProperty> list) {
        List<TextView> list2;
        Intrinsics.checkNotNullParameter(list, "properties");
        int i2 = 0;
        TextViews.bindText$default(this.t, str, false, 2, null);
        TextViews.bindText$default(this.u, str2, false, 2, null);
        this.v.getLayoutParams().height = i;
        this.s.setAspectRatio(Images.aspectRatio(image, 1.38f));
        if (image != null) {
            SimpleDraweeViewsKt.getRequestBuilder(this.s).picture(AvitoPictureKt.pictureOf$default(image, false, 0.0f, 0.0f, null, 28, null)).cancelOnDetach(false).load();
        } else {
            this.s.setController(null);
        }
        if (this.w.getChildCount() != list.size()) {
            this.w.removeAllViews();
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                ViewGroup viewGroup = this.w;
                View inflate = LayoutInflater.from(this.x.getContext()).inflate(R.layout.brandspace_item_productcomparison_property, (ViewGroup) null);
                Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.widget.TextView");
                TextView textView = (TextView) inflate;
                textView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                viewGroup.addView(textView);
            }
            list2 = t();
        } else {
            list2 = t();
        }
        for (T t2 : list2) {
            int i4 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            T t3 = t2;
            ProductComparisonItemProperty productComparisonItemProperty = list.get(i2);
            Views.changePadding$default(t3, 0, productComparisonItemProperty.getTopPadding(), 0, 0, 13, null);
            t3.setHeight(productComparisonItemProperty.getPrecalculatedTextHeight() + productComparisonItemProperty.getTopPadding());
            t3.setText(productComparisonItemProperty.getValue());
            i2 = i4;
        }
    }

    public final List<TextView> t() {
        ArrayList arrayList = new ArrayList();
        Iterator<View> children = ViewGroupsKt.getChildren(this.w);
        while (children.hasNext()) {
            View next = children.next();
            if (next instanceof TextView) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }
}
