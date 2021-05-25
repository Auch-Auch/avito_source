package com.avito.android.section;

import android.content.res.Resources;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp.adapter.LayoutTypeProvider;
import com.avito.android.ui_components.R;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u001b\u0010\u001cR\u0016\u0010\u0005\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00068V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0004R\u0016\u0010\f\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0004R\u0016\u0010\u000e\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0004R\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0004R\u0016\u0010\u0016\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0004R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/avito/android/section/RdsSectionResourceProviderImpl;", "Lcom/avito/android/section/SectionResourceProvider;", "", "getCropPx", "()I", "cropPx", "", "isVerticalShortcutsAsCard", "()Z", "getColumnsOffsetPx", "columnsOffsetPx", "getContentPaddingPx", "contentPaddingPx", "getColumnsCount", "columnsCount", "Lcom/avito/android/serp/adapter/LayoutTypeProvider;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/serp/adapter/LayoutTypeProvider;", "layoutTypeProvider", "getDefaultItemWidthPx", "defaultItemWidthPx", "getPaddingPx", "paddingPx", "Landroid/content/res/Resources;", AuthSource.SEND_ABUSE, "Landroid/content/res/Resources;", "resources", "<init>", "(Landroid/content/res/Resources;Lcom/avito/android/serp/adapter/LayoutTypeProvider;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class RdsSectionResourceProviderImpl implements SectionResourceProvider {
    public final Resources a;
    public final LayoutTypeProvider b;

    @Inject
    public RdsSectionResourceProviderImpl(@NotNull Resources resources, @NotNull LayoutTypeProvider layoutTypeProvider) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(layoutTypeProvider, "layoutTypeProvider");
        this.a = resources;
        this.b = layoutTypeProvider;
    }

    @Override // com.avito.android.home.ColumnsCountProvider
    public int getColumnsCount() {
        return this.b.getLayoutType().getColumnCount();
    }

    @Override // com.avito.android.section.SectionResourceProvider
    public int getColumnsOffsetPx() {
        return this.a.getDimensionPixelOffset(R.dimen.rds_column_offset);
    }

    @Override // com.avito.android.section.SectionResourceProvider
    public int getContentPaddingPx() {
        return this.a.getDimensionPixelSize(R.dimen.content_horizontal_padding);
    }

    @Override // com.avito.android.section.SectionResourceProvider
    public int getCropPx() {
        return 0;
    }

    @Override // com.avito.android.section.SectionResourceProvider
    public int getDefaultItemWidthPx() {
        return this.a.getDimensionPixelSize(com.avito.android.serp_core.R.dimen.section_advert_width_default);
    }

    @Override // com.avito.android.section.SectionResourceProvider
    public int getPaddingPx() {
        return this.a.getDimensionPixelOffset(R.dimen.rds_horizontal_edge_offset);
    }

    @Override // com.avito.android.section.SectionResourceProvider
    public boolean isVerticalShortcutsAsCard() {
        return this.a.getDimensionPixelOffset(R.dimen.complementary_shortcut_content_horizontal_padding) > 0;
    }
}
