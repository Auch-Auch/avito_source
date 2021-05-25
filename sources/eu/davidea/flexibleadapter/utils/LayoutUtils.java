package eu.davidea.flexibleadapter.utils;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.BuildConfig;
import eu.davidea.flexibleadapter.common.FlexibleLayoutManager;
public final class LayoutUtils {
    public static int findFirstCompletelyVisibleItemPosition(RecyclerView recyclerView) {
        return new FlexibleLayoutManager(recyclerView).findFirstCompletelyVisibleItemPosition();
    }

    public static int findFirstVisibleItemPosition(RecyclerView recyclerView) {
        return new FlexibleLayoutManager(recyclerView).findFirstVisibleItemPosition();
    }

    public static int findLastCompletelyVisibleItemPosition(RecyclerView recyclerView) {
        return new FlexibleLayoutManager(recyclerView).findLastCompletelyVisibleItemPosition();
    }

    public static int findLastVisibleItemPosition(RecyclerView recyclerView) {
        return new FlexibleLayoutManager(recyclerView).findLastVisibleItemPosition();
    }

    @NonNull
    public static String getClassName(@Nullable Object obj) {
        return obj == null ? BuildConfig.ADJUST_DEFAULT_TRACKER : obj.getClass().getSimpleName();
    }

    @NonNull
    @SuppressLint({"SwitchIntDef"})
    public static String getModeName(int i) {
        return i != 1 ? i != 2 ? "IDLE" : "MULTI" : "SINGLE";
    }

    public static int getOrientation(RecyclerView recyclerView) {
        return new FlexibleLayoutManager(recyclerView).getOrientation();
    }

    public static int getSpanCount(RecyclerView recyclerView) {
        return new FlexibleLayoutManager(recyclerView).getSpanCount();
    }
}
