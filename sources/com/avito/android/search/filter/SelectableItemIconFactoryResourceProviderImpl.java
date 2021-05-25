package com.avito.android.search.filter;

import android.content.res.Resources;
import com.avito.android.lib.design.avito.R;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u001c\u0010\u000e\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u0011\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006¨\u0006\u0014"}, d2 = {"Lcom/avito/android/search/filter/SelectableItemIconFactoryResourceProviderImpl;", "Lcom/avito/android/search/filter/SelectableItemIconFactoryResourceProvider;", "", "c", "I", "getStrokeWidth", "()I", "strokeWidth", "Landroid/content/res/Resources;", "d", "Landroid/content/res/Resources;", "resources", AuthSource.BOOKING_ORDER, "getOutlineColor", "outlineColor", AuthSource.SEND_ABUSE, "getIconSize", "iconSize", "<init>", "(Landroid/content/res/Resources;)V", "filter_release"}, k = 1, mv = {1, 4, 2})
public final class SelectableItemIconFactoryResourceProviderImpl implements SelectableItemIconFactoryResourceProvider {
    public final int a;
    public final int b;
    public final int c;
    public final Resources d;

    @Inject
    public SelectableItemIconFactoryResourceProviderImpl(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.d = resources;
        this.a = resources.getDimensionPixelSize(R.dimen.color_indicator_size);
        this.b = resources.getColor(R.color.avito_gray_12);
        this.c = (int) (((float) 1) * resources.getDisplayMetrics().density);
    }

    @Override // com.avito.android.search.filter.SelectableItemIconFactoryResourceProvider
    public int getIconSize() {
        return this.a;
    }

    @Override // com.avito.android.search.filter.SelectableItemIconFactoryResourceProvider
    public int getOutlineColor() {
        return this.b;
    }

    @Override // com.avito.android.search.filter.SelectableItemIconFactoryResourceProvider
    public int getStrokeWidth() {
        return this.c;
    }
}
