package com.avito.android.scroll_tracker;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.scroll_tracker.SnippetScrollDepthTracker;
import com.avito.android.serp.ad.BannerInfoContainer;
import com.avito.android.serp.adapter.SerpCommercialBanner;
import com.avito.android.serp.adapter.ViewedAdvertItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b!\u0010\u0010J\u001f\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u0015\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0018\u0010\u0017J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Lcom/avito/android/scroll_tracker/SnippetScrollDepthTrackerImpl;", "Lcom/avito/android/scroll_tracker/SnippetScrollDepthTracker;", "Lcom/avito/konveyor/data_source/DataSource;", "Lcom/avito/android/serp/adapter/SpannedItem;", "dataSource", "", "onDataSourceChanged", "(Lcom/avito/konveyor/data_source/DataSource;)V", "", "newVisibleItemPosition", "onUserScrollToNewItem", "(I)V", "", "hasNewDataFromLastEventSent", "()Z", "onAnalyticsEventWasSent", "()V", "resetValues", "", "", "getAdvertItemsIds", "()Ljava/util/List;", "getAdvertsItemCount", "()I", "getTotalItemsCount", "Lcom/avito/android/scroll_tracker/SnippetScrollDepthTracker$State;", "onSaveState", "()Lcom/avito/android/scroll_tracker/SnippetScrollDepthTracker$State;", "state", "restoreState", "(Lcom/avito/android/scroll_tracker/SnippetScrollDepthTracker$State;)V", AuthSource.SEND_ABUSE, "Lcom/avito/android/scroll_tracker/SnippetScrollDepthTracker$State;", "<init>", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class SnippetScrollDepthTrackerImpl implements SnippetScrollDepthTracker {
    public SnippetScrollDepthTracker.State a = new SnippetScrollDepthTracker.State();

    @Override // com.avito.android.scroll_tracker.SnippetScrollDepthTracker
    @NotNull
    public List<String> getAdvertItemsIds() {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (T t : this.a.getViewedAdvertItems()) {
            if ((t instanceof ViewedAdvertItem) && i <= this.a.getLastVisibleByUserItem() && i > this.a.getLastSentByUserItem()) {
                arrayList.add(t.getStringId());
            }
            i++;
        }
        return arrayList;
    }

    @Override // com.avito.android.scroll_tracker.SnippetScrollDepthTracker
    public int getAdvertsItemCount() {
        Iterator<T> it = this.a.getViewedAdvertItems().iterator();
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            if ((it.next() instanceof ViewedAdvertItem) && i2 <= this.a.getLastVisibleByUserItem()) {
                i++;
            }
            i2++;
        }
        return i;
    }

    @Override // com.avito.android.scroll_tracker.SnippetScrollDepthTracker
    public int getTotalItemsCount() {
        int i = 0;
        int i2 = 0;
        for (T t : this.a.getViewedAdvertItems()) {
            if (((t instanceof BannerInfoContainer) || (t instanceof ViewedAdvertItem) || (t instanceof SerpCommercialBanner)) && i2 <= this.a.getLastVisibleByUserItem()) {
                i++;
            }
            i2++;
        }
        return i;
    }

    @Override // com.avito.android.scroll_tracker.SnippetScrollDepthTracker
    public boolean hasNewDataFromLastEventSent() {
        return this.a.getLastSentByUserItem() < this.a.getLastVisibleByUserItem();
    }

    @Override // com.avito.android.scroll_tracker.SnippetScrollDepthTracker
    public void onAnalyticsEventWasSent() {
        SnippetScrollDepthTracker.State state = this.a;
        state.setLastSentByUserItem(state.getLastVisibleByUserItem());
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // com.avito.android.scroll_tracker.SnippetScrollDepthTracker
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDataSourceChanged(@org.jetbrains.annotations.NotNull com.avito.konveyor.data_source.DataSource<? extends com.avito.android.serp.adapter.SpannedItem> r5) {
        /*
            r4 = this;
            java.lang.String r0 = "dataSource"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            boolean r0 = r5.isEmpty()
            if (r0 != 0) goto L_0x0022
            r0 = 0
            int r1 = r5.getCount()
        L_0x0010:
            if (r0 >= r1) goto L_0x0022
            com.avito.android.scroll_tracker.SnippetScrollDepthTracker$State r2 = r4.a
            java.util.Set r2 = r2.getViewedAdvertItems()
            java.lang.Object r3 = r5.getItem(r0)
            r2.add(r3)
            int r0 = r0 + 1
            goto L_0x0010
        L_0x0022:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.scroll_tracker.SnippetScrollDepthTrackerImpl.onDataSourceChanged(com.avito.konveyor.data_source.DataSource):void");
    }

    @Override // com.avito.android.scroll_tracker.SnippetScrollDepthTracker
    @NotNull
    public SnippetScrollDepthTracker.State onSaveState() {
        return this.a;
    }

    @Override // com.avito.android.scroll_tracker.SnippetScrollDepthTracker
    public void onUserScrollToNewItem(int i) {
        if (i > this.a.getLastVisibleByUserItem()) {
            this.a.setLastVisibleByUserItem(i);
        }
    }

    @Override // com.avito.android.scroll_tracker.SnippetScrollDepthTracker
    public void resetValues() {
        this.a.setViewedAdvertItems(new LinkedHashSet());
        this.a.setLastVisibleByUserItem(0);
        this.a.setLastSentByUserItem(-1);
    }

    @Override // com.avito.android.scroll_tracker.SnippetScrollDepthTracker
    public void restoreState(@NotNull SnippetScrollDepthTracker.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        this.a = state;
    }
}
