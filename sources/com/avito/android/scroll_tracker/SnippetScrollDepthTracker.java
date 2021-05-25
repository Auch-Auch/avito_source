package com.avito.android.scroll_tracker;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp.adapter.SpannedItem;
import com.avito.konveyor.data_source.DataSource;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001:\u0001\u001fJ\u001f\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0005H&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0005H&¢\u0006\u0004\b\u0011\u0010\u0010J\u0015\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H&¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\bH&¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\bH&¢\u0006\u0004\b\u0018\u0010\u0017J\u000f\u0010\u001a\u001a\u00020\u0019H&¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0019H&¢\u0006\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Lcom/avito/android/scroll_tracker/SnippetScrollDepthTracker;", "", "Lcom/avito/konveyor/data_source/DataSource;", "Lcom/avito/android/serp/adapter/SpannedItem;", "dataSource", "", "onDataSourceChanged", "(Lcom/avito/konveyor/data_source/DataSource;)V", "", "newVisibleItemPosition", "onUserScrollToNewItem", "(I)V", "", "hasNewDataFromLastEventSent", "()Z", "onAnalyticsEventWasSent", "()V", "resetValues", "", "", "getAdvertItemsIds", "()Ljava/util/List;", "getAdvertsItemCount", "()I", "getTotalItemsCount", "Lcom/avito/android/scroll_tracker/SnippetScrollDepthTracker$State;", "onSaveState", "()Lcom/avito/android/scroll_tracker/SnippetScrollDepthTracker$State;", "state", "restoreState", "(Lcom/avito/android/scroll_tracker/SnippetScrollDepthTracker$State;)V", "State", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface SnippetScrollDepthTracker {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R(\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0016\u001a\u00020\u000b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011¨\u0006\u0019"}, d2 = {"Lcom/avito/android/scroll_tracker/SnippetScrollDepthTracker$State;", "", "", "Lcom/avito/android/serp/adapter/SpannedItem;", AuthSource.SEND_ABUSE, "Ljava/util/Set;", "getViewedAdvertItems", "()Ljava/util/Set;", "setViewedAdvertItems", "(Ljava/util/Set;)V", "viewedAdvertItems", "", AuthSource.BOOKING_ORDER, "I", "getLastVisibleByUserItem", "()I", "setLastVisibleByUserItem", "(I)V", "lastVisibleByUserItem", "c", "getLastSentByUserItem", "setLastSentByUserItem", "lastSentByUserItem", "<init>", "()V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class State {
        @NotNull
        public Set<SpannedItem> a = new LinkedHashSet();
        public int b;
        public int c = -1;

        public final int getLastSentByUserItem() {
            return this.c;
        }

        public final int getLastVisibleByUserItem() {
            return this.b;
        }

        @NotNull
        public final Set<SpannedItem> getViewedAdvertItems() {
            return this.a;
        }

        public final void setLastSentByUserItem(int i) {
            this.c = i;
        }

        public final void setLastVisibleByUserItem(int i) {
            this.b = i;
        }

        public final void setViewedAdvertItems(@NotNull Set<SpannedItem> set) {
            Intrinsics.checkNotNullParameter(set, "<set-?>");
            this.a = set;
        }
    }

    @NotNull
    List<String> getAdvertItemsIds();

    int getAdvertsItemCount();

    int getTotalItemsCount();

    boolean hasNewDataFromLastEventSent();

    void onAnalyticsEventWasSent();

    void onDataSourceChanged(@NotNull DataSource<? extends SpannedItem> dataSource);

    @NotNull
    State onSaveState();

    void onUserScrollToNewItem(int i);

    void resetValues();

    void restoreState(@NotNull State state);
}
