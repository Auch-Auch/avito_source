package ru.sravni.android.bankproduct.utils.adapter;

import androidx.core.content.ContextCompat;
import androidx.databinding.BindingAdapter;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.utils.components.wraprefreshlayout.WrapContentableSwipeRefreshLayout;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\b¨\u0006\t"}, d2 = {"Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "view", "", "isLoading", "", "bindColorSchemeToSwipeRefresh", "(Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;Z)V", "Lru/sravni/android/bankproduct/utils/components/wraprefreshlayout/WrapContentableSwipeRefreshLayout;", "(Lru/sravni/android/bankproduct/utils/components/wraprefreshlayout/WrapContentableSwipeRefreshLayout;Z)V", "sravnichat_release"}, k = 2, mv = {1, 4, 0})
public final class BindingSwipeRefreshKt {
    @BindingAdapter({"isLoading"})
    public static final void bindColorSchemeToSwipeRefresh(@NotNull SwipeRefreshLayout swipeRefreshLayout, boolean z) {
        Intrinsics.checkParameterIsNotNull(swipeRefreshLayout, "view");
        swipeRefreshLayout.setRefreshing(z);
        swipeRefreshLayout.setColorSchemeResources(R.color.primary, R.color.secondary, R.color.error);
        swipeRefreshLayout.setProgressBackgroundColorSchemeColor(ContextCompat.getColor(swipeRefreshLayout.getContext(), R.color.background));
    }

    @BindingAdapter({"isLoading"})
    public static final void bindColorSchemeToSwipeRefresh(@NotNull WrapContentableSwipeRefreshLayout wrapContentableSwipeRefreshLayout, boolean z) {
        Intrinsics.checkParameterIsNotNull(wrapContentableSwipeRefreshLayout, "view");
        wrapContentableSwipeRefreshLayout.setRefreshing(z);
        wrapContentableSwipeRefreshLayout.setColorSchemeResources(R.color.primary, R.color.secondary, R.color.error);
        wrapContentableSwipeRefreshLayout.setProgressBackgroundColorSchemeColor(ContextCompat.getColor(wrapContentableSwipeRefreshLayout.getContext(), R.color.background));
    }
}
