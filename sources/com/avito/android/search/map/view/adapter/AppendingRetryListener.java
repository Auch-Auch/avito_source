package com.avito.android.search.map.view.adapter;

import com.avito.android.ui.adapter.AppendingListener;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\b\u0010\u0005R\u001c\u0010\u000e\u001a\u00020\t8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/avito/android/search/map/view/adapter/AppendingRetryListener;", "Lcom/avito/android/ui/adapter/AppendingListener;", "Lio/reactivex/rxjava3/core/Observable;", "", "appendEvents", "()Lio/reactivex/rxjava3/core/Observable;", "onRetry", "()V", "retryEvents", "Lcom/avito/android/search/map/view/adapter/AppendingState;", "getAppendingState", "()Lcom/avito/android/search/map/view/adapter/AppendingState;", "setAppendingState", "(Lcom/avito/android/search/map/view/adapter/AppendingState;)V", "appendingState", "map_release"}, k = 1, mv = {1, 4, 2})
public interface AppendingRetryListener extends AppendingListener {
    @NotNull
    Observable<Unit> appendEvents();

    @NotNull
    AppendingState getAppendingState();

    void onRetry();

    @NotNull
    Observable<Unit> retryEvents();

    void setAppendingState(@NotNull AppendingState appendingState);
}
