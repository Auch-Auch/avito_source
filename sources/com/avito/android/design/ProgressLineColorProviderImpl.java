package com.avito.android.design;

import com.avito.android.ui_components.R;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/design/ProgressLineColorProviderImpl;", "Lcom/avito/android/design/ProgressLineColorProvider;", "", "percentage", "getDrawableIdByPercentage", "(I)I", "<init>", "()V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class ProgressLineColorProviderImpl implements ProgressLineColorProvider {
    @Override // com.avito.android.design.ProgressLineColorProvider
    public int getDrawableIdByPercentage(int i) {
        if (i >= 0 && 20 >= i) {
            return R.drawable.fees_progress_red;
        }
        if (21 <= i && 50 >= i) {
            return R.drawable.fees_progress_orange;
        }
        return R.drawable.fees_progress_green;
    }
}
