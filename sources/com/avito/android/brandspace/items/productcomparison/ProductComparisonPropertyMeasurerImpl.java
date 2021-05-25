package com.avito.android.brandspace.items.productcomparison;

import android.widget.TextView;
import com.avito.android.brandspace.items.textmeasurement.TextMeasurer;
import com.avito.android.remote.auth.AuthSource;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u001b"}, d2 = {"Lcom/avito/android/brandspace/items/productcomparison/ProductComparisonPropertyMeasurerImpl;", "Lcom/avito/android/brandspace/items/productcomparison/ProductComparisonPropertyMeasurer;", "", "text", "Lcom/avito/android/brandspace/items/productcomparison/ProductComparisonPropertyLayout;", "measure", "(Ljava/lang/String;)Lcom/avito/android/brandspace/items/productcomparison/ProductComparisonPropertyLayout;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Lcom/avito/android/brandspace/items/textmeasurement/TextMeasurer;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/brandspace/items/textmeasurement/TextMeasurer;", "textMeasurer", "Lcom/avito/android/brandspace/items/textmeasurement/TextMeasurer$TextParams;", AuthSource.SEND_ABUSE, "Lcom/avito/android/brandspace/items/textmeasurement/TextMeasurer$TextParams;", "titleParams", "Landroid/widget/TextView;", "textView", "<init>", "(Landroid/widget/TextView;Lcom/avito/android/brandspace/items/textmeasurement/TextMeasurer;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class ProductComparisonPropertyMeasurerImpl implements ProductComparisonPropertyMeasurer {
    public final TextMeasurer.TextParams a;
    public final TextMeasurer b;

    public ProductComparisonPropertyMeasurerImpl(@NotNull TextView textView, @NotNull TextMeasurer textMeasurer) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        Intrinsics.checkNotNullParameter(textMeasurer, "textMeasurer");
        this.b = textMeasurer;
        this.a = textMeasurer.createTextParams(textView, (textView.getLayoutParams().width - textView.getPaddingLeft()) - textView.getPaddingRight());
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(ProductComparisonPropertyMeasurerImpl.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.avito.android.brandspace.items.productcomparison.ProductComparisonPropertyMeasurerImpl");
        return !(Intrinsics.areEqual(this.a, ((ProductComparisonPropertyMeasurerImpl) obj).a) ^ true);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // com.avito.android.brandspace.items.productcomparison.ProductComparisonPropertyMeasurer
    @NotNull
    public ProductComparisonPropertyLayout measure(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        return new ProductComparisonPropertyLayout(this.b.measure(str, this.a));
    }
}
