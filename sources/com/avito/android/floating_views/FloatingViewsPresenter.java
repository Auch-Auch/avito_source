package com.avito.android.floating_views;

import com.avito.android.floating_views.ScrollHandler;
import com.avito.android.ui.adapter.AppendingListener;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001:\u0001\u0013J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H&¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H&¢\u0006\u0004\b\u0011\u0010\fJ\u000f\u0010\u0012\u001a\u00020\u0004H&¢\u0006\u0004\b\u0012\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/avito/android/floating_views/FloatingViewsPresenter;", "Lcom/avito/android/floating_views/ScrollHandler$Listener;", "", "enabled", "", "setEnabled", "(Z)V", "Lcom/avito/android/floating_views/FloatingViewsPresenter$Subscriber;", "subscriber", "attachSubscriber", "(Lcom/avito/android/floating_views/FloatingViewsPresenter$Subscriber;)V", "detachSubscriber", "()V", "Lcom/avito/android/ui/adapter/AppendingListener;", "appendingListener", "attachAppendingListener", "(Lcom/avito/android/ui/adapter/AppendingListener;)V", "detachAppendingListener", "detachAll", "Subscriber", "floating-views_release"}, k = 1, mv = {1, 4, 2})
public interface FloatingViewsPresenter extends ScrollHandler.Listener {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/floating_views/FloatingViewsPresenter$Subscriber;", "", "", "animate", "", "showFloatingViews", "(Z)V", "hideFloatingViews", "floating-views_release"}, k = 1, mv = {1, 4, 2})
    public interface Subscriber {
        void hideFloatingViews(boolean z);

        void showFloatingViews(boolean z);
    }

    void attachAppendingListener(@NotNull AppendingListener appendingListener);

    void attachSubscriber(@NotNull Subscriber subscriber);

    void detachAll();

    void detachAppendingListener();

    void detachSubscriber();

    void setEnabled(boolean z);
}
