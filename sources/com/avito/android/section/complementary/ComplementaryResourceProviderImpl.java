package com.avito.android.section.complementary;

import android.content.res.Resources;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.section.SectionResourceProvider;
import com.avito.android.ui_components.R;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0003\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\n\u001a\u00020\u00058V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u00058V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0007R\u0016\u0010\u0012\u001a\u00020\u00058V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0007R\u0016\u0010\u0014\u001a\u00020\u00058V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0007R\u0016\u0010\u0016\u001a\u00020\u00058V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/avito/android/section/complementary/ComplementaryResourceProviderImpl;", "Lcom/avito/android/section/SectionResourceProvider;", "", "isVerticalShortcutsAsCard", "()Z", "", "getCropPx", "()I", "cropPx", "getColumnsCount", "columnsCount", "Landroid/content/res/Resources;", AuthSource.SEND_ABUSE, "Landroid/content/res/Resources;", "resources", "getContentPaddingPx", "contentPaddingPx", "getDefaultItemWidthPx", "defaultItemWidthPx", "getColumnsOffsetPx", "columnsOffsetPx", "getPaddingPx", "paddingPx", "<init>", "(Landroid/content/res/Resources;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class ComplementaryResourceProviderImpl implements SectionResourceProvider {
    public final Resources a;

    @Inject
    public ComplementaryResourceProviderImpl(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.a = resources;
    }

    @Override // com.avito.android.home.ColumnsCountProvider
    public int getColumnsCount() {
        return this.a.getInteger(R.integer.similar_adverts_columns);
    }

    @Override // com.avito.android.section.SectionResourceProvider
    public int getColumnsOffsetPx() {
        return 0;
    }

    @Override // com.avito.android.section.SectionResourceProvider
    public int getContentPaddingPx() {
        return this.a.getDimensionPixelSize(R.dimen.content_horizontal_padding);
    }

    @Override // com.avito.android.section.SectionResourceProvider
    public int getCropPx() {
        return this.a.getDimensionPixelSize(R.dimen.content_horizontal_padding);
    }

    @Override // com.avito.android.section.SectionResourceProvider
    public int getDefaultItemWidthPx() {
        return this.a.getDimensionPixelSize(com.avito.android.serp_core.R.dimen.section_advert_width_default);
    }

    @Override // com.avito.android.section.SectionResourceProvider
    public int getPaddingPx() {
        return this.a.getDimensionPixelSize(R.dimen.content_horizontal_padding);
    }

    @Override // com.avito.android.section.SectionResourceProvider
    public boolean isVerticalShortcutsAsCard() {
        return this.a.getDimensionPixelOffset(R.dimen.complementary_shortcut_content_horizontal_padding) > 0;
    }
}
