package com.avito.android.home;

import androidx.recyclerview.widget.AdapterListUpdateCallback;
import androidx.recyclerview.widget.ListUpdateCallback;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u0019\u0012\u0006\u0010\u0018\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ)\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\rJ\u001f\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\rR\u0019\u0010\u0015\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001d"}, d2 = {"Lcom/avito/android/home/OffsetListUpdateCallback;", "Landroidx/recyclerview/widget/ListUpdateCallback;", "", VKApiConst.POSITION, "count", "", "payload", "", "onChanged", "(IILjava/lang/Object;)V", "fromPosition", "toPosition", "onMoved", "(II)V", "onInserted", "onRemoved", "Landroidx/recyclerview/widget/AdapterListUpdateCallback;", AuthSource.SEND_ABUSE, "Landroidx/recyclerview/widget/AdapterListUpdateCallback;", "getCallback", "()Landroidx/recyclerview/widget/AdapterListUpdateCallback;", "callback", AuthSource.BOOKING_ORDER, "I", "offset", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "adapter", "<init>", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;I)V", "serp_release"}, k = 1, mv = {1, 4, 2})
public final class OffsetListUpdateCallback implements ListUpdateCallback {
    @NotNull
    public final AdapterListUpdateCallback a;
    public final int b;

    public OffsetListUpdateCallback(@NotNull RecyclerView.Adapter<?> adapter, int i) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        this.b = i;
        this.a = new AdapterListUpdateCallback(adapter);
    }

    @NotNull
    public final AdapterListUpdateCallback getCallback() {
        return this.a;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onChanged(int i, int i2, @Nullable Object obj) {
        this.a.onChanged(i + this.b, i2, obj);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onInserted(int i, int i2) {
        this.a.onInserted(i + this.b, i2);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onMoved(int i, int i2) {
        AdapterListUpdateCallback adapterListUpdateCallback = this.a;
        int i3 = this.b;
        adapterListUpdateCallback.onMoved(i + i3, i2 + i3);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onRemoved(int i, int i2) {
        this.a.onRemoved(i + this.b, i2);
    }
}
