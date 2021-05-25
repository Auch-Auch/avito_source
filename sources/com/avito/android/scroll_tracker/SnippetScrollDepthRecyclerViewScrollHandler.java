package com.avito.android.scroll_tracker;

import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u0005J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/avito/android/scroll_tracker/SnippetScrollDepthRecyclerViewScrollHandler;", "", "", "onInitialDataSourceSet", "()V", "Listener", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface SnippetScrollDepthRecyclerViewScrollHandler {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/scroll_tracker/SnippetScrollDepthRecyclerViewScrollHandler$Listener;", "", "", "mostDepthVisibleItemPosition", "", "onVisibleItemChanged", "(I)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
    public interface Listener {
        void onVisibleItemChanged(int i);
    }

    void onInitialDataSourceSet();
}
