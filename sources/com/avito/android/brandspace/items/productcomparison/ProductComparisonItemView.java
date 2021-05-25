package com.avito.android.brandspace.items.productcomparison;

import a2.b.a.a.a;
import com.avito.android.brandspace.items.textmeasurement.TextMeasuredLayout;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.Size;
import com.avito.konveyor.blueprint.ItemView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0002\u000f\u0010JC\u0010\r\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH&¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/avito/android/brandspace/items/productcomparison/ProductComparisonItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/android/remote/model/Image;", "image", "", "title", "description", "", "headerTextHeight", "", "Lcom/avito/android/brandspace/items/productcomparison/ProductComparisonItemProperty;", "properties", "", "bind", "(Lcom/avito/android/remote/model/Image;Ljava/lang/String;Ljava/lang/String;ILjava/util/List;)V", "Layout", "Measurer", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public interface ProductComparisonItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull ProductComparisonItemView productComparisonItemView) {
            ItemView.DefaultImpls.onUnbind(productComparisonItemView);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u0016\u0010\u0019\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0004R\u0019\u0010\u0006\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0016\u001a\u0004\b\u001b\u0010\u0004¨\u0006\u001e"}, d2 = {"Lcom/avito/android/brandspace/items/productcomparison/ProductComparisonItemView$Layout;", "Lcom/avito/android/brandspace/items/textmeasurement/TextMeasuredLayout;", "Lcom/avito/android/remote/model/Size;", "component1", "()Lcom/avito/android/remote/model/Size;", "component2", "titleSize", "descriptionSize", "copy", "(Lcom/avito/android/remote/model/Size;Lcom/avito/android/remote/model/Size;)Lcom/avito/android/brandspace/items/productcomparison/ProductComparisonItemView$Layout;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/Size;", "getDescriptionSize", "getSize", "size", AuthSource.SEND_ABUSE, "getTitleSize", "<init>", "(Lcom/avito/android/remote/model/Size;Lcom/avito/android/remote/model/Size;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
    public static final class Layout implements TextMeasuredLayout {
        @NotNull
        public final Size a;
        @NotNull
        public final Size b;

        public Layout(@NotNull Size size, @NotNull Size size2) {
            Intrinsics.checkNotNullParameter(size, "titleSize");
            Intrinsics.checkNotNullParameter(size2, "descriptionSize");
            this.a = size;
            this.b = size2;
        }

        public static /* synthetic */ Layout copy$default(Layout layout, Size size, Size size2, int i, Object obj) {
            if ((i & 1) != 0) {
                size = layout.a;
            }
            if ((i & 2) != 0) {
                size2 = layout.b;
            }
            return layout.copy(size, size2);
        }

        @NotNull
        public final Size component1() {
            return this.a;
        }

        @NotNull
        public final Size component2() {
            return this.b;
        }

        @NotNull
        public final Layout copy(@NotNull Size size, @NotNull Size size2) {
            Intrinsics.checkNotNullParameter(size, "titleSize");
            Intrinsics.checkNotNullParameter(size2, "descriptionSize");
            return new Layout(size, size2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Layout)) {
                return false;
            }
            Layout layout = (Layout) obj;
            return Intrinsics.areEqual(this.a, layout.a) && Intrinsics.areEqual(this.b, layout.b);
        }

        @NotNull
        public final Size getDescriptionSize() {
            return this.b;
        }

        @Override // com.avito.android.brandspace.items.textmeasurement.TextMeasuredLayout
        @NotNull
        public Size getSize() {
            return new Size(Math.max(this.a.getWidth(), this.b.getWidth()), this.b.getHeight() + this.a.getHeight());
        }

        @NotNull
        public final Size getTitleSize() {
            return this.a;
        }

        public int hashCode() {
            Size size = this.a;
            int i = 0;
            int hashCode = (size != null ? size.hashCode() : 0) * 31;
            Size size2 = this.b;
            if (size2 != null) {
                i = size2.hashCode();
            }
            return hashCode + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("Layout(titleSize=");
            L.append(this.a);
            L.append(", descriptionSize=");
            L.append(this.b);
            L.append(")");
            return L.toString();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J#\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/brandspace/items/productcomparison/ProductComparisonItemView$Measurer;", "", "", "title", "description", "Lcom/avito/android/brandspace/items/productcomparison/ProductComparisonItemView$Layout;", "measure", "(Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/brandspace/items/productcomparison/ProductComparisonItemView$Layout;", "brandspace_release"}, k = 1, mv = {1, 4, 2})
    public interface Measurer {
        @NotNull
        Layout measure(@Nullable String str, @Nullable String str2);
    }

    void bind(@Nullable Image image, @Nullable String str, @Nullable String str2, int i, @NotNull List<ProductComparisonItemProperty> list);
}
