package com.avito.android.recycler.base;

import a2.b.a.a.a;
import a2.g.r.g;
import android.view.ViewGroup;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.NonFatalError;
import com.avito.android.util.BuildInfo;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.adapter.EmptyViewHolder;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.ViewHolderBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u0013\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0017"}, d2 = {"Lcom/avito/android/recycler/base/SafeRecyclerAdapter;", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/analytics/Analytics;", g.a, "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/util/BuildInfo;", "f", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "presenter", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder;", "holderProvider", "<init>", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/blueprint/ViewHolderBuilder;Lcom/avito/android/util/BuildInfo;Lcom/avito/android/analytics/Analytics;)V", "recycler_release"}, k = 1, mv = {1, 4, 2})
public final class SafeRecyclerAdapter extends SimpleRecyclerAdapter {
    public final BuildInfo f;
    public final Analytics g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SafeRecyclerAdapter(@NotNull AdapterPresenter adapterPresenter, @NotNull ViewHolderBuilder<? extends BaseViewHolder> viewHolderBuilder, @NotNull BuildInfo buildInfo, @NotNull Analytics analytics) {
        super(adapterPresenter, viewHolderBuilder);
        Intrinsics.checkNotNullParameter(adapterPresenter, "presenter");
        Intrinsics.checkNotNullParameter(viewHolderBuilder, "holderProvider");
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.f = buildInfo;
        this.g = analytics;
    }

    @Override // com.avito.konveyor.adapter.SimpleRecyclerAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public BaseViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        try {
            return super.onCreateViewHolder(viewGroup, i);
        } catch (Throwable th) {
            if (!this.f.isDebug()) {
                this.g.track(new NonFatalError(a.M2("Failed to inflate view of ", i), th, null, 4, null));
                return new EmptyViewHolder(viewGroup);
            }
            throw th;
        }
    }
}
