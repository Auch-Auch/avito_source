package com.avito.android.enabler;

import com.avito.android.app.task.ApplicationForegroundStartupTask;
import com.avito.android.enabler.model.RemoteToggles;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.rx3.Singles;
import io.reactivex.rxjava3.core.Single;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/avito/android/enabler/FetchRemoteTogglesStartUpTask;", "Lcom/avito/android/app/task/ApplicationForegroundStartupTask;", "", "execute", "()V", "Lcom/avito/android/enabler/RemoteTogglesFetcher;", "fetcher", "Lcom/avito/android/enabler/RemoteTogglesFetcher;", "Lcom/avito/android/enabler/RemoteFeaturesTouchMonitor;", "touchMonitor", "Lcom/avito/android/enabler/RemoteFeaturesTouchMonitor;", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/util/SchedulersFactory3;", "<init>", "(Lcom/avito/android/enabler/RemoteTogglesFetcher;Lcom/avito/android/enabler/RemoteFeaturesTouchMonitor;Lcom/avito/android/util/SchedulersFactory3;)V", "application_release"}, k = 1, mv = {1, 4, 2})
public final class FetchRemoteTogglesStartUpTask implements ApplicationForegroundStartupTask {
    private final RemoteTogglesFetcher fetcher;
    private final SchedulersFactory3 schedulers;
    private final RemoteFeaturesTouchMonitor touchMonitor;

    public FetchRemoteTogglesStartUpTask(@NotNull RemoteTogglesFetcher remoteTogglesFetcher, @NotNull RemoteFeaturesTouchMonitor remoteFeaturesTouchMonitor, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(remoteTogglesFetcher, "fetcher");
        Intrinsics.checkNotNullParameter(remoteFeaturesTouchMonitor, "touchMonitor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        this.fetcher = remoteTogglesFetcher;
        this.touchMonitor = remoteFeaturesTouchMonitor;
        this.schedulers = schedulersFactory3;
    }

    @Override // com.avito.android.app.task.ApplicationForegroundStartupTask
    public void execute() {
        this.touchMonitor.start();
        Single<TypedResult<RemoteToggles>> observeOn = this.fetcher.load().subscribeOn(this.schedulers.io()).observeOn(this.schedulers.io());
        Intrinsics.checkNotNullExpressionValue(observeOn, "fetcher.load()\n         …bserveOn(schedulers.io())");
        Singles.subscribeIgnoreResult(observeOn);
    }
}
