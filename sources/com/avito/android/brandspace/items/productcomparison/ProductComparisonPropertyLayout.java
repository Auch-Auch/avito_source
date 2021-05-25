package com.avito.android.brandspace.items.productcomparison;

import a2.b.a.a.a;
import com.avito.android.brandspace.items.textmeasurement.TextMeasuredLayout;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Size;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0004R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004¨\u0006\u001a"}, d2 = {"Lcom/avito/android/brandspace/items/productcomparison/ProductComparisonPropertyLayout;", "Lcom/avito/android/brandspace/items/textmeasurement/TextMeasuredLayout;", "Lcom/avito/android/remote/model/Size;", "component1", "()Lcom/avito/android/remote/model/Size;", "text", "copy", "(Lcom/avito/android/remote/model/Size;)Lcom/avito/android/brandspace/items/productcomparison/ProductComparisonPropertyLayout;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "getSize", "size", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/Size;", "getText", "<init>", "(Lcom/avito/android/remote/model/Size;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class ProductComparisonPropertyLayout implements TextMeasuredLayout {
    @NotNull
    public final Size a;

    public ProductComparisonPropertyLayout(@NotNull Size size) {
        Intrinsics.checkNotNullParameter(size, "text");
        this.a = size;
    }

    public static /* synthetic */ ProductComparisonPropertyLayout copy$default(ProductComparisonPropertyLayout productComparisonPropertyLayout, Size size, int i, Object obj) {
        if ((i & 1) != 0) {
            size = productComparisonPropertyLayout.a;
        }
        return productComparisonPropertyLayout.copy(size);
    }

    @NotNull
    public final Size component1() {
        return this.a;
    }

    @NotNull
    public final ProductComparisonPropertyLayout copy(@NotNull Size size) {
        Intrinsics.checkNotNullParameter(size, "text");
        return new ProductComparisonPropertyLayout(size);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof ProductComparisonPropertyLayout) && Intrinsics.areEqual(this.a, ((ProductComparisonPropertyLayout) obj).a);
        }
        return true;
    }

    @Override // com.avito.android.brandspace.items.textmeasurement.TextMeasuredLayout
    @NotNull
    public Size getSize() {
        return new Size(this.a.getWidth(), this.a.getHeight());
    }

    @NotNull
    public final Size getText() {
        return this.a;
    }

    public int hashCode() {
        Size size = this.a;
        if (size != null) {
            return size.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ProductComparisonPropertyLayout(text=");
        L.append(this.a);
        L.append(")");
        return L.toString();
    }
}
