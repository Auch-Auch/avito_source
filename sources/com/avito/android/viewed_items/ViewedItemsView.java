package com.avito.android.viewed_items;

import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\rJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/avito/android/viewed_items/ViewedItemsView;", "", "Lcom/avito/android/viewed_items/ViewedItemsView$ScreenState;", "screenState", "", "setScreenState", "(Lcom/avito/android/viewed_items/ViewedItemsView$ScreenState;)V", "notifyDatasetChanged", "()V", "", VKApiConst.POSITION, "notifyItemAtPositionChanged", "(I)V", "ScreenState", "favorites_release"}, k = 1, mv = {1, 4, 2})
public interface ViewedItemsView {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/viewed_items/ViewedItemsView$ScreenState;", "", "<init>", "(Ljava/lang/String;I)V", "CONTENT", "LOADING", "EMPTY", "ERROR", "favorites_release"}, k = 1, mv = {1, 4, 2})
    public enum ScreenState {
        CONTENT,
        LOADING,
        EMPTY,
        ERROR
    }

    void notifyDatasetChanged();

    void notifyItemAtPositionChanged(int i);

    void setScreenState(@NotNull ScreenState screenState);
}
