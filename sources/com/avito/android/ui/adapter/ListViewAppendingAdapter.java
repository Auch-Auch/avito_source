package com.avito.android.ui.adapter;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001+B\u0017\u0012\u0006\u0010)\u001a\u00020&\u0012\u0006\u0010/\u001a\u00020.¢\u0006\u0004\b0\u00101J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0013\u0010\u0012J\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0007\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J-\u0010\u001b\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0007\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0007\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H\u0016¢\u0006\u0004\b \u0010!R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u001a\u0010-\u001a\u00060*R\u00020\u00008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,¨\u00062"}, d2 = {"Lcom/avito/android/ui/adapter/ListViewAppendingAdapter;", "Landroid/widget/BaseAdapter;", "Lcom/avito/android/ui/adapter/AppendingAdapter;", "", "getCount", "()I", "getViewTypeCount", VKApiConst.POSITION, "", "isEnabled", "(I)Z", "isEmpty", "()Z", "loadingRange", "", "setLoadingRange", "(I)V", "setAppendingFromTop", "()V", "setAppendingFromBottom", "", "getItem", "(I)Ljava/lang/Object;", "Landroid/view/View;", "convertView", "Landroid/view/ViewGroup;", "parent", "getView", "(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;", "", "getItemId", "(I)J", "getItemViewType", "(I)I", "Lcom/avito/android/ui/adapter/AppendingAdapterHandler;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/ui/adapter/AppendingAdapterHandler;", "appendingHandler", "Landroid/widget/Adapter;", "c", "Landroid/widget/Adapter;", "delegate", "Lcom/avito/android/ui/adapter/ListViewAppendingAdapter$a;", AuthSource.SEND_ABUSE, "Lcom/avito/android/ui/adapter/ListViewAppendingAdapter$a;", "dataSetObserver", "Lcom/avito/android/ui/adapter/AppendingListener;", "appendingListener", "<init>", "(Landroid/widget/Adapter;Lcom/avito/android/ui/adapter/AppendingListener;)V", "appending-list_release"}, k = 1, mv = {1, 4, 2})
public final class ListViewAppendingAdapter extends BaseAdapter implements AppendingAdapter {
    public final a a;
    public final AppendingAdapterHandler b;
    public final Adapter c;

    public final class a extends DataSetObserver {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public a() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            ListViewAppendingAdapter.this.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ListViewAppendingAdapter.this.notifyDataSetInvalidated();
        }
    }

    public ListViewAppendingAdapter(@NotNull Adapter adapter, @NotNull AppendingListener appendingListener) {
        Intrinsics.checkNotNullParameter(adapter, "delegate");
        Intrinsics.checkNotNullParameter(appendingListener, "appendingListener");
        this.c = adapter;
        a aVar = new a();
        this.a = aVar;
        this.b = new AppendingAdapterHandler(this, appendingListener, false, 0, 12, null);
        adapter.registerDataSetObserver(aVar);
    }

    @Override // android.widget.Adapter, com.avito.android.ui.adapter.AppendingAdapter
    public int getCount() {
        return this.c.getCount();
    }

    @Override // android.widget.Adapter
    @Nullable
    public Object getItem(int i) {
        if (this.b.isAppendingViewPosition(i)) {
            return null;
        }
        return this.c.getItem(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.b.isAppendingViewPosition(i)) {
            return (long) AppendingAdapterKt.getAPPENDING_POSITION_ID();
        }
        return this.c.getItemId(i);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.b.isAppendingViewPosition(i)) {
            return -1;
        }
        return this.c.getItemViewType(i);
    }

    @Override // android.widget.Adapter
    @Nullable
    public View getView(int i, @Nullable View view, @Nullable ViewGroup viewGroup) {
        this.b.appendIfNeeded(i);
        if (this.b.isAppendingViewPosition(i)) {
            AppendingAdapterHandler appendingAdapterHandler = this.b;
            Intrinsics.checkNotNull(viewGroup);
            return appendingAdapterHandler.getAppendingView(viewGroup);
        }
        Adapter adapter = this.c;
        Intrinsics.checkNotNull(viewGroup);
        return adapter.getView(i, view, viewGroup);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return this.c.getViewTypeCount();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        return this.c.isEmpty();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        return !this.b.isAppendingViewPosition(i);
    }

    @Override // com.avito.android.ui.adapter.AppendingAdapter
    public void setAppendingFromBottom() {
        this.b.setAppendingFromBottom();
    }

    @Override // com.avito.android.ui.adapter.AppendingAdapter
    public void setAppendingFromTop() {
        this.b.setAppendingFromTop();
    }

    @Override // com.avito.android.ui.adapter.AppendingAdapter
    public void setLoadingRange(int i) {
        this.b.setLoadingRange(i);
    }
}
