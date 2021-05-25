package com.avito.android.util.architecture_components.auto_clear;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/avito/android/util/architecture_components/auto_clear/AutoClearedRecyclerView;", "Lcom/avito/android/util/architecture_components/auto_clear/AutoClearedValue;", "Landroidx/recyclerview/widget/RecyclerView;", "", "onDestroy", "()V", "<init>", "android_release"}, k = 1, mv = {1, 4, 2})
public final class AutoClearedRecyclerView extends AutoClearedValue<RecyclerView> {
    @Override // com.avito.android.util.architecture_components.auto_clear.AutoClearedValue
    public void onDestroy() {
        RecyclerView recyclerView = (RecyclerView) getValue();
        if (recyclerView != null) {
            recyclerView.setAdapter(null);
        }
        super.onDestroy();
    }
}
