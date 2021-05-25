package com.avito.android.analytics.screens.fps;

import a2.b.a.a.a;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.analytics.screens.fps.FpsState;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.Logs;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u001f\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001c"}, d2 = {"Lcom/avito/android/analytics/screens/fps/FpsStateSupplier;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "", "onResume", "()V", "onPause", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", "Lcom/avito/android/analytics/screens/fps/FpsState;", AuthSource.SEND_ABUSE, "Lcom/avito/android/analytics/screens/fps/FpsState;", "state", "", AuthSource.BOOKING_ORDER, "Z", "isDebug", "Lcom/avito/android/analytics/screens/fps/FpsStateListener;", "c", "Lcom/avito/android/analytics/screens/fps/FpsStateListener;", "consumer", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "<init>", "(Lcom/avito/android/analytics/screens/fps/FpsStateListener;Lcom/avito/android/util/BuildInfo;)V", "analytics-screens_release"}, k = 1, mv = {1, 4, 2})
public final class FpsStateSupplier extends RecyclerView.OnScrollListener {
    public FpsState a = FpsState.Create.INSTANCE;
    public final boolean b;
    public final FpsStateListener c;

    @Inject
    public FpsStateSupplier(@NotNull FpsStateListener fpsStateListener, @NotNull BuildInfo buildInfo) {
        Intrinsics.checkNotNullParameter(fpsStateListener, "consumer");
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        this.c = fpsStateListener;
        this.b = buildInfo.isDebug();
    }

    public final void onPause() {
        if (this.b) {
            boolean z = true;
            if (!(!Intrinsics.areEqual(this.a, FpsState.Create.INSTANCE)) && !(!Intrinsics.areEqual(this.a, FpsState.Stop.INSTANCE))) {
                z = false;
            }
            if (!z) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        } else {
            StringBuilder L = a.L("onPause improper state: ");
            L.append(this.a);
            Logs.error(new IllegalStateException(L.toString()));
        }
        FpsState.Stop stop = FpsState.Stop.INSTANCE;
        this.a = stop;
        this.c.onStateChanged(stop);
    }

    public final void onResume() {
        if (this.b) {
            if (!(Intrinsics.areEqual(this.a, FpsState.Create.INSTANCE) || Intrinsics.areEqual(this.a, FpsState.Stop.INSTANCE))) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        } else {
            StringBuilder L = a.L("onResume improper state: ");
            L.append(this.a);
            Logs.error(new IllegalStateException(L.toString()));
        }
        FpsState.Idle idle = FpsState.Idle.INSTANCE;
        this.a = idle;
        this.c.onStateChanged(idle);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int i) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        if (!(!Intrinsics.areEqual(this.a, FpsState.Stop.INSTANCE))) {
            return;
        }
        if (i == 0) {
            FpsState fpsState = this.a;
            FpsState.Idle idle = FpsState.Idle.INSTANCE;
            if (!Intrinsics.areEqual(fpsState, idle)) {
                this.a = idle;
                this.c.onStateChanged(idle);
                return;
            }
            return;
        }
        FpsState fpsState2 = this.a;
        FpsState.Scroll scroll = FpsState.Scroll.INSTANCE;
        if (!Intrinsics.areEqual(fpsState2, scroll)) {
            this.a = scroll;
            this.c.onStateChanged(scroll);
        }
    }
}
