package com.avito.android.serp;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\u0007J\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\u0011\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R$\u0010\u0017\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/avito/android/serp/EventsAwareAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "onAttachedToRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "onDetachedFromRecyclerView", "", "toString", "()Ljava/lang/String;", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "d", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "getObserver", "()Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "observer", "c", "Ljava/lang/String;", "getLastEvent", "setLastEvent", "(Ljava/lang/String;)V", "lastEvent", "<init>", "()V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public abstract class EventsAwareAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    @Nullable
    public String c;
    @NotNull
    public final RecyclerView.AdapterDataObserver d = new RecyclerView.AdapterDataObserver(this) { // from class: com.avito.android.serp.EventsAwareAdapter.1
        public final /* synthetic */ EventsAwareAdapter a;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        {
            this.a = r1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            this.a.setLastEvent("onChanged");
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2) {
            EventsAwareAdapter eventsAwareAdapter = this.a;
            eventsAwareAdapter.setLastEvent("onItemRangeChanged start: " + i + " count: " + i2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i, int i2) {
            EventsAwareAdapter eventsAwareAdapter = this.a;
            eventsAwareAdapter.setLastEvent("onItemRangeInserted start: " + i + " count: " + i2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i, int i2, int i3) {
            EventsAwareAdapter eventsAwareAdapter = this.a;
            eventsAwareAdapter.setLastEvent("onItemRangeMoved start: " + i + " count: " + i3);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i, int i2) {
            EventsAwareAdapter eventsAwareAdapter = this.a;
            eventsAwareAdapter.setLastEvent("onItemRangeRemoved start: " + i + " count: " + i2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2, @Nullable Object obj) {
            EventsAwareAdapter eventsAwareAdapter = this.a;
            eventsAwareAdapter.setLastEvent("onItemRangeChanged start: " + i + " count: " + i2);
        }
    };

    @Nullable
    public final String getLastEvent() {
        return this.c;
    }

    @NotNull
    public final RecyclerView.AdapterDataObserver getObserver() {
        return this.d;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        registerAdapterDataObserver(this.d);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onDetachedFromRecyclerView(recyclerView);
        unregisterAdapterDataObserver(this.d);
    }

    public final void setLastEvent(@Nullable String str) {
        this.c = str;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(" {");
        sb.append("item count: ");
        sb.append(getItemCount());
        if (this.c != null) {
            sb.append(", last event: ");
            sb.append(this.c);
        }
        sb.append("}");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "builder.toString()");
        return sb2;
    }
}
