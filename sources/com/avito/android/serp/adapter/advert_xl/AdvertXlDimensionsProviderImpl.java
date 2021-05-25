package com.avito.android.serp.adapter.advert_xl;

import android.content.res.Resources;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eR\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\n\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/avito/android/serp/adapter/advert_xl/AdvertXlDimensionsProviderImpl;", "Lcom/avito/android/serp/adapter/advert_xl/AdvertXlDimensionsProvider;", "", AuthSource.SEND_ABUSE, "I", "getGalleryWidth", "()I", "galleryWidth", AuthSource.BOOKING_ORDER, "getGalleryHeight", "galleryHeight", "Landroid/content/res/Resources;", "resources", "<init>", "(Landroid/content/res/Resources;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertXlDimensionsProviderImpl implements AdvertXlDimensionsProvider {
    public final int a;
    public final int b;

    @Inject
    public AdvertXlDimensionsProviderImpl(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        int integer = resources.getInteger(R.integer.serp_columns);
        if (resources.getBoolean(R.bool.is_tablet)) {
            Resources system = Resources.getSystem();
            Intrinsics.checkNotNullExpressionValue(system, "Resources.getSystem()");
            this.a = (((system.getDisplayMetrics().widthPixels - (resources.getDimensionPixelSize(R.dimen.serp_horizontal_padding) * 2)) / integer) * 2) - (resources.getDimensionPixelSize(R.dimen.list_serp_card_padding) * 2);
            this.b = -1;
            return;
        }
        this.a = -1;
        this.b = -2;
    }

    @Override // com.avito.android.serp.adapter.advert_xl.AdvertXlDimensionsProvider
    public int getGalleryHeight() {
        return this.b;
    }

    @Override // com.avito.android.serp.adapter.advert_xl.AdvertXlDimensionsProvider
    public int getGalleryWidth() {
        return this.a;
    }
}
