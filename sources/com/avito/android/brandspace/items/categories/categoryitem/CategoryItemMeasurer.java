package com.avito.android.brandspace.items.categories.categoryitem;

import com.avito.android.brandspace.items.categories.categoryitem.CategoryItemView;
import com.avito.android.brandspace.items.textmeasurement.TextItemMeasurer;
import com.avito.android.brandspace.items.textmeasurement.TextMeasurableItem;
import com.avito.android.brandspace.items.textmeasurement.TextMeasuredLayout;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import t6.c;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\b\u0007\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001d\u0010\u0015\u001a\u00020\u00108V@\u0016X\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/avito/android/brandspace/items/categories/categoryitem/CategoryItemMeasurer;", "Lcom/avito/android/brandspace/items/textmeasurement/TextItemMeasurer;", "Lcom/avito/android/brandspace/items/categories/categoryitem/CategoryItem;", "", "prepare", "()V", "Lcom/avito/android/brandspace/items/textmeasurement/TextMeasurableItem;", "item", "Lcom/avito/android/brandspace/items/textmeasurement/TextMeasuredLayout;", "measure", "(Lcom/avito/android/brandspace/items/textmeasurement/TextMeasurableItem;)Lcom/avito/android/brandspace/items/textmeasurement/TextMeasuredLayout;", "Ldagger/Lazy;", "Lcom/avito/android/brandspace/items/categories/categoryitem/CategoryItemView$Measurer;", AuthSource.BOOKING_ORDER, "Ldagger/Lazy;", "lazyMeasurer", "", AuthSource.SEND_ABUSE, "Lkotlin/Lazy;", "getMeasurerHash", "()I", "measurerHash", "<init>", "(Ldagger/Lazy;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class CategoryItemMeasurer implements TextItemMeasurer<CategoryItem> {
    @NotNull
    public final Lazy a = c.lazy(new a(this));
    public final dagger.Lazy<CategoryItemView.Measurer> b;

    public static final class a extends Lambda implements Function0<Integer> {
        public final /* synthetic */ CategoryItemMeasurer a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(CategoryItemMeasurer categoryItemMeasurer) {
            super(0);
            this.a = categoryItemMeasurer;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Integer invoke() {
            return Integer.valueOf(CategoryItemMeasurer.access$getMeasurer$p(this.a).hashCode());
        }
    }

    @Inject
    public CategoryItemMeasurer(@NotNull dagger.Lazy<CategoryItemView.Measurer> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "lazyMeasurer");
        this.b = lazy;
    }

    public static final CategoryItemView.Measurer access$getMeasurer$p(CategoryItemMeasurer categoryItemMeasurer) {
        CategoryItemView.Measurer measurer = categoryItemMeasurer.b.get();
        Intrinsics.checkNotNullExpressionValue(measurer, "lazyMeasurer.get()");
        return measurer;
    }

    @Override // com.avito.android.brandspace.items.textmeasurement.TextItemMeasurer
    public int getMeasurerHash() {
        return ((Number) this.a.getValue()).intValue();
    }

    @Override // com.avito.android.brandspace.items.textmeasurement.TextItemMeasurer
    @NotNull
    public TextMeasuredLayout measure(@NotNull TextMeasurableItem textMeasurableItem) {
        Intrinsics.checkNotNullParameter(textMeasurableItem, "item");
        CategoryItem categoryItem = (CategoryItem) textMeasurableItem;
        CategoryItemView.Measurer measurer = this.b.get();
        Intrinsics.checkNotNullExpressionValue(measurer, "lazyMeasurer.get()");
        return measurer.measure(categoryItem.getTitle(), categoryItem.getSubtitle(), categoryItem.getDescription());
    }

    @Override // com.avito.android.brandspace.items.textmeasurement.TextItemMeasurer
    public void prepare() {
        this.b.get();
    }
}
