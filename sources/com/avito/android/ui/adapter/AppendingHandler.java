package com.avito.android.ui.adapter;

import androidx.recyclerview.widget.RecyclerView;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u00020\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0007H&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/ui/adapter/AppendingHandler;", "", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "adapter", "", "setAdapterDelegate", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V", "", VKApiConst.POSITION, "appendIfNeeded", "(I)V", "", "isAppendingViewPosition", "(I)Z", "getCount", "()I", "appending-list_release"}, k = 1, mv = {1, 4, 2})
public interface AppendingHandler {
    void appendIfNeeded(int i);

    int getCount();

    boolean isAppendingViewPosition(int i);

    void setAdapterDelegate(@NotNull RecyclerView.Adapter<?> adapter);
}
