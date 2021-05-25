package com.avito.android.search.subscriptions;

import android.os.Bundle;
import com.avito.android.common.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0019\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"", "listBottomPaddingPx", "Lcom/avito/android/search/subscriptions/SearchSubscriptionFragment;", "createSearchSubscriptionFragment", "(Ljava/lang/Integer;)Lcom/avito/android/search/subscriptions/SearchSubscriptionFragment;", "subscriptions_release"}, k = 2, mv = {1, 4, 2})
public final class SearchSubscriptionFragmentKt {
    @NotNull
    public static final SearchSubscriptionFragment createSearchSubscriptionFragment(@Nullable Integer num) {
        SearchSubscriptionFragment searchSubscriptionFragment = new SearchSubscriptionFragment();
        Bundle bundle = new Bundle();
        if (num != null) {
            bundle.putInt(ConstantsKt.KEY_LIST_BOTTOM_PADDING, num.intValue());
        }
        Unit unit = Unit.INSTANCE;
        searchSubscriptionFragment.setArguments(bundle);
        return searchSubscriptionFragment;
    }

    public static /* synthetic */ SearchSubscriptionFragment createSearchSubscriptionFragment$default(Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        return createSearchSubscriptionFragment(num);
    }
}
