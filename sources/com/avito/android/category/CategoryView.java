package com.avito.android.category;

import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H&¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\f\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H&¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\r\u001a\u00020\u0002H&¢\u0006\u0004\b\r\u0010\u0004J\u000f\u0010\u000e\u001a\u00020\u0002H&¢\u0006\u0004\b\u000e\u0010\u0004J\u000f\u0010\u000f\u001a\u00020\u0002H&¢\u0006\u0004\b\u000f\u0010\u0004J\u0017\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0019\u001a\u00020\u00052\b\b\u0001\u0010\u0018\u001a\u00020\u0005H'¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/avito/android/category/CategoryView;", "", "", "dataChanged", "()V", "", VKApiConst.POSITION, "itemChanged", "(I)V", "count", "itemRangeInserted", "(II)V", "itemRangeRemoved", "showProgress", "showRetry", "showContent", "", "error", "showError", "(Ljava/lang/String;)V", "Lkotlin/ranges/IntRange;", "range", "showBackgroundForRange", "(Lkotlin/ranges/IntRange;)V", "colorAttr", "getColor", "(I)I", "category_release"}, k = 1, mv = {1, 4, 2})
public interface CategoryView {
    void dataChanged();

    @ColorInt
    int getColor(@AttrRes int i);

    void itemChanged(int i);

    void itemRangeInserted(int i, int i2);

    void itemRangeRemoved(int i, int i2);

    void showBackgroundForRange(@NotNull IntRange intRange);

    void showContent();

    void showError(@NotNull String str);

    void showProgress();

    void showRetry();
}
