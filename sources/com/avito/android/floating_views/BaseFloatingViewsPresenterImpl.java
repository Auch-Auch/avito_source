package com.avito.android.floating_views;

import com.avito.android.floating_views.FloatingViewsPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui.adapter.AppendingListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b%\u0010\u0013J/\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0018\u0010\u0013J\u000f\u0010\u0019\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0019\u0010\u0013J\u000f\u0010\u001a\u001a\u00020\u0007H$¢\u0006\u0004\b\u001a\u0010\u0013J\u000f\u0010\u001b\u001a\u00020\u0007H$¢\u0006\u0004\b\u001b\u0010\u0013R\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010\u0011R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006&"}, d2 = {"Lcom/avito/android/floating_views/BaseFloatingViewsPresenterImpl;", "Lcom/avito/android/floating_views/FloatingViewsPresenter;", "", "firstVisibleItem", "lastFirstVisibleItem", "visibleItemCount", "totalItemCount", "", "onVisibleItemChanged", "(IIII)V", "", "enabled", "setEnabled", "(Z)V", "Lcom/avito/android/floating_views/FloatingViewsPresenter$Subscriber;", "subscriber", "attachSubscriber", "(Lcom/avito/android/floating_views/FloatingViewsPresenter$Subscriber;)V", "detachSubscriber", "()V", "Lcom/avito/android/ui/adapter/AppendingListener;", "appendingListener", "attachAppendingListener", "(Lcom/avito/android/ui/adapter/AppendingListener;)V", "detachAppendingListener", "detachAll", "show", "hide", "c", "Z", AuthSource.BOOKING_ORDER, "Lcom/avito/android/floating_views/FloatingViewsPresenter$Subscriber;", "getSubscriber", "()Lcom/avito/android/floating_views/FloatingViewsPresenter$Subscriber;", "setSubscriber", AuthSource.SEND_ABUSE, "Lcom/avito/android/ui/adapter/AppendingListener;", "<init>", "floating-views_release"}, k = 1, mv = {1, 4, 2})
public abstract class BaseFloatingViewsPresenterImpl implements FloatingViewsPresenter {
    public AppendingListener a;
    @Nullable
    public FloatingViewsPresenter.Subscriber b;
    public boolean c = true;

    @Override // com.avito.android.floating_views.FloatingViewsPresenter
    public void attachAppendingListener(@NotNull AppendingListener appendingListener) {
        Intrinsics.checkNotNullParameter(appendingListener, "appendingListener");
        this.a = appendingListener;
    }

    @Override // com.avito.android.floating_views.FloatingViewsPresenter
    public void attachSubscriber(@NotNull FloatingViewsPresenter.Subscriber subscriber) {
        Intrinsics.checkNotNullParameter(subscriber, "subscriber");
        this.b = subscriber;
    }

    @Override // com.avito.android.floating_views.FloatingViewsPresenter
    public void detachAll() {
        detachSubscriber();
        detachAppendingListener();
    }

    @Override // com.avito.android.floating_views.FloatingViewsPresenter
    public void detachAppendingListener() {
        this.a = null;
    }

    @Override // com.avito.android.floating_views.FloatingViewsPresenter
    public void detachSubscriber() {
        this.b = null;
    }

    @Nullable
    public final FloatingViewsPresenter.Subscriber getSubscriber() {
        return this.b;
    }

    public abstract void hide();

    @Override // com.avito.android.floating_views.ScrollHandler.Listener
    public void onVisibleItemChanged(int i, int i2, int i3, int i4) {
        if (this.c) {
            AppendingListener appendingListener = this.a;
            if ((appendingListener == null || !appendingListener.canAppend()) && i3 + i >= i4) {
                show();
            } else if (i2 < i) {
                hide();
            } else if (i2 > i) {
                show();
            }
        }
    }

    @Override // com.avito.android.floating_views.FloatingViewsPresenter
    public void setEnabled(boolean z) {
        this.c = z;
    }

    public final void setSubscriber(@Nullable FloatingViewsPresenter.Subscriber subscriber) {
        this.b = subscriber;
    }

    public abstract void show();
}
