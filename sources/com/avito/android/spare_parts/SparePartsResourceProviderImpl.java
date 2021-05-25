package com.avito.android.spare_parts;

import android.content.res.Resources;
import androidx.core.content.res.ResourcesCompat;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/spare_parts/SparePartsResourceProviderImpl;", "Lcom/avito/android/spare_parts/SparePartsResourceProvider;", "", "getBottomSheetBackButtonResId", "()I", "getBottomSheetCloseButtonResId", "getSpecificationsDelimiterColor", "getTextItemIconRightResId", "Landroid/content/res/Resources;", AuthSource.SEND_ABUSE, "Landroid/content/res/Resources;", "resources", "<init>", "(Landroid/content/res/Resources;)V", "spare-parts_release"}, k = 1, mv = {1, 4, 2})
public final class SparePartsResourceProviderImpl implements SparePartsResourceProvider {
    public final Resources a;

    @Inject
    public SparePartsResourceProviderImpl(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.a = resources;
    }

    @Override // com.avito.android.spare_parts.SparePartsResourceProvider
    public int getBottomSheetBackButtonResId() {
        return R.drawable.ic_back_bottom_sheet_ripple;
    }

    @Override // com.avito.android.spare_parts.SparePartsResourceProvider
    public int getBottomSheetCloseButtonResId() {
        return com.avito.android.lib.design.R.drawable.design_icon_close_ripple;
    }

    @Override // com.avito.android.spare_parts.SparePartsResourceProvider
    public int getSpecificationsDelimiterColor() {
        return ResourcesCompat.getColor(this.a, com.avito.android.lib.design.avito.R.color.avito_gray_48, null);
    }

    @Override // com.avito.android.spare_parts.SparePartsResourceProvider
    public int getTextItemIconRightResId() {
        return R.drawable.ic_spare_parts_arrow_right;
    }
}
