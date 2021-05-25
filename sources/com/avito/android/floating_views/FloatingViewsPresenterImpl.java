package com.avito.android.floating_views;

import android.os.Bundle;
import com.avito.android.floating_views.FloatingViewsPresenter;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\b\u0017\u0012\n\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0018\u0010\u0010J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\n\u0010\tJ\u0011\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000f\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0011\u0010\tJ\u000f\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\tR\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/floating_views/FloatingViewsPresenterImpl;", "Lcom/avito/android/floating_views/BaseFloatingViewsPresenterImpl;", "Lcom/avito/android/floating_views/PersistableFloatingViewsPresenter;", "Lcom/avito/android/floating_views/FloatingViewsPresenter$Subscriber;", "subscriber", "", "attachSubscriber", "(Lcom/avito/android/floating_views/FloatingViewsPresenter$Subscriber;)V", "show", "()V", "hide", "Landroid/os/Bundle;", "onSaveState", "()Landroid/os/Bundle;", "savedInstanceState", "onRestoreState", "(Landroid/os/Bundle;)V", "reset", "updateVisibility", "", "d", "Z", "viewsVisible", "savedState", "<init>", "floating-views_release"}, k = 1, mv = {1, 4, 2})
public final class FloatingViewsPresenterImpl extends BaseFloatingViewsPresenterImpl implements PersistableFloatingViewsPresenter {
    public boolean d;

    @Inject
    public FloatingViewsPresenterImpl(@FloatingViewsPresenterState @Nullable Bundle bundle) {
        this.d = true;
        onRestoreState(bundle);
    }

    @Override // com.avito.android.floating_views.BaseFloatingViewsPresenterImpl, com.avito.android.floating_views.FloatingViewsPresenter
    public void attachSubscriber(@NotNull FloatingViewsPresenter.Subscriber subscriber) {
        Intrinsics.checkNotNullParameter(subscriber, "subscriber");
        super.attachSubscriber(subscriber);
        updateVisibility();
    }

    @Override // com.avito.android.floating_views.BaseFloatingViewsPresenterImpl
    public void hide() {
        if (this.d) {
            this.d = false;
            FloatingViewsPresenter.Subscriber subscriber = getSubscriber();
            if (subscriber != null) {
                subscriber.hideFloatingViews(true);
            }
        }
    }

    @Override // com.avito.android.floating_views.PersistableFloatingViewsPresenter
    public void onRestoreState(@Nullable Bundle bundle) {
        Boolean valueOf = bundle != null ? Boolean.valueOf(bundle.getBoolean("views_visible")) : null;
        if (valueOf != null) {
            this.d = valueOf.booleanValue();
        }
    }

    @Override // com.avito.android.floating_views.PersistableFloatingViewsPresenter
    @Nullable
    public Bundle onSaveState() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("views_visible", this.d);
        return bundle;
    }

    @Override // com.avito.android.floating_views.PersistableFloatingViewsPresenter
    public void reset() {
        this.d = true;
        updateVisibility();
    }

    @Override // com.avito.android.floating_views.BaseFloatingViewsPresenterImpl
    public void show() {
        if (!this.d) {
            this.d = true;
            FloatingViewsPresenter.Subscriber subscriber = getSubscriber();
            if (subscriber != null) {
                subscriber.showFloatingViews(true);
            }
        }
    }

    @Override // com.avito.android.floating_views.PersistableFloatingViewsPresenter
    public void updateVisibility() {
        if (this.d) {
            FloatingViewsPresenter.Subscriber subscriber = getSubscriber();
            if (subscriber != null) {
                subscriber.showFloatingViews(false);
                return;
            }
            return;
        }
        FloatingViewsPresenter.Subscriber subscriber2 = getSubscriber();
        if (subscriber2 != null) {
            subscriber2.hideFloatingViews(false);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FloatingViewsPresenterImpl(Bundle bundle, int i, j jVar) {
        this((i & 1) != 0 ? null : bundle);
    }
}
