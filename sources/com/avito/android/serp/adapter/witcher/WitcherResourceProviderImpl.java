package com.avito.android.serp.adapter.witcher;

import a2.g.r.g;
import android.content.res.Resources;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0011¢\u0006\u0004\b(\u0010)R\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\n\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001c\u0010\r\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\u0010\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u0019\u0010\u0016\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0019\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006R\u001c\u0010\u001c\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006R\u001c\u0010\u001f\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006R\u001c\u0010\"\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\u0006R\u001c\u0010&\u001a\u00020#8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'¨\u0006*"}, d2 = {"Lcom/avito/android/serp/adapter/witcher/WitcherResourceProviderImpl;", "Lcom/avito/android/serp/adapter/witcher/WitcherResourceProvider;", "", "e", "I", "getPaddingForTitleEnd", "()I", "paddingForTitleEnd", "i", "getBottomPaddingForEmptyButton", "bottomPaddingForEmptyButton", AuthSource.BOOKING_ORDER, "getPaddingTopForSelectedWitcher", "paddingTopForSelectedWitcher", "f", "getPaddingForButton", "paddingForButton", "Landroid/content/res/Resources;", "j", "Landroid/content/res/Resources;", "getResources", "()Landroid/content/res/Resources;", "resources", "d", "getPaddingForTitleStart", "paddingForTitleStart", g.a, "getBottomMarginForButton", "bottomMarginForButton", "c", "getPadding", "padding", AuthSource.SEND_ABUSE, "getElementsCountForWitcher", "elementsCountForWitcher", "", "h", "Z", "isTablet", "()Z", "<init>", "(Landroid/content/res/Resources;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class WitcherResourceProviderImpl implements WitcherResourceProvider {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final boolean h;
    public final int i;
    @NotNull
    public final Resources j;

    @Inject
    public WitcherResourceProviderImpl(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.j = resources;
        this.a = resources.getInteger(R.integer.serp_columns);
        this.b = resources.getDimensionPixelSize(R.dimen.witcher_extra_padding_top);
        this.c = resources.getDimensionPixelSize(R.dimen.serp_horizontal_padding);
        this.d = resources.getDimensionPixelSize(R.dimen.witcher_title_padding_start);
        this.e = resources.getDimensionPixelSize(R.dimen.witcher_title_padding_end);
        this.f = resources.getDimensionPixelSize(R.dimen.witcher_button_padding);
        this.g = resources.getDimensionPixelSize(R.dimen.witcher_button_increased_margin);
        this.h = resources.getBoolean(R.bool.is_tablet);
        this.i = resources.getDimensionPixelSize(R.dimen.witcher_bottom_padding_for_empty_button);
    }

    @Override // com.avito.android.serp.adapter.witcher.WitcherResourceProvider
    public int getBottomMarginForButton() {
        return this.g;
    }

    @Override // com.avito.android.serp.adapter.witcher.WitcherResourceProvider
    public int getBottomPaddingForEmptyButton() {
        return this.i;
    }

    @Override // com.avito.android.serp.adapter.witcher.WitcherResourceProvider
    public int getElementsCountForWitcher() {
        return this.a;
    }

    @Override // com.avito.android.serp.adapter.witcher.WitcherResourceProvider
    public int getPadding() {
        return this.c;
    }

    @Override // com.avito.android.serp.adapter.witcher.WitcherResourceProvider
    public int getPaddingForButton() {
        return this.f;
    }

    @Override // com.avito.android.serp.adapter.witcher.WitcherResourceProvider
    public int getPaddingForTitleEnd() {
        return this.e;
    }

    @Override // com.avito.android.serp.adapter.witcher.WitcherResourceProvider
    public int getPaddingForTitleStart() {
        return this.d;
    }

    @Override // com.avito.android.serp.adapter.witcher.WitcherResourceProvider
    public int getPaddingTopForSelectedWitcher() {
        return this.b;
    }

    @NotNull
    public final Resources getResources() {
        return this.j;
    }

    @Override // com.avito.android.serp.adapter.witcher.WitcherResourceProvider
    public boolean isTablet() {
        return this.h;
    }
}
