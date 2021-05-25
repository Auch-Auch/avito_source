package com.avito.android.enabler;

import com.avito.android.enabler.model.RemoteToggles;
import com.avito.android.remote.FeaturesApi;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.util.Logs;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/avito/android/enabler/RemoteTogglesFetcherImpl;", "Lcom/avito/android/enabler/RemoteTogglesFetcher;", "Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/enabler/model/RemoteToggles;", "load", "()Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/enabler/RemoteFeaturesLoadingMonitor;", "loadingMonitor", "Lcom/avito/android/enabler/RemoteFeaturesLoadingMonitor;", "Lcom/avito/android/enabler/TogglesStorage;", "storage", "Lcom/avito/android/enabler/TogglesStorage;", "Lcom/avito/android/remote/FeaturesApi;", "api", "Lcom/avito/android/remote/FeaturesApi;", "<init>", "(Lcom/avito/android/remote/FeaturesApi;Lcom/avito/android/enabler/TogglesStorage;Lcom/avito/android/enabler/RemoteFeaturesLoadingMonitor;)V", "application_release"}, k = 1, mv = {1, 4, 2})
public final class RemoteTogglesFetcherImpl implements RemoteTogglesFetcher {
    private final FeaturesApi api;
    private final RemoteFeaturesLoadingMonitor loadingMonitor;
    private final TogglesStorage storage;

    public RemoteTogglesFetcherImpl(@NotNull FeaturesApi featuresApi, @NotNull TogglesStorage togglesStorage, @NotNull RemoteFeaturesLoadingMonitor remoteFeaturesLoadingMonitor) {
        Intrinsics.checkNotNullParameter(featuresApi, "api");
        Intrinsics.checkNotNullParameter(togglesStorage, "storage");
        Intrinsics.checkNotNullParameter(remoteFeaturesLoadingMonitor, "loadingMonitor");
        this.api = featuresApi;
        this.storage = togglesStorage;
        this.loadingMonitor = remoteFeaturesLoadingMonitor;
    }

    @Override // com.avito.android.enabler.RemoteTogglesFetcher
    @NotNull
    public Single<TypedResult<RemoteToggles>> load() {
        Single<TypedResult<RemoteToggles>> doOnSuccess = this.api.fetchRemoteToggles().firstOrError().doOnSuccess(new Consumer<TypedResult<RemoteToggles>>(this) { // from class: com.avito.android.enabler.RemoteTogglesFetcherImpl$load$1
            public final /* synthetic */ RemoteTogglesFetcherImpl this$0;

            {
                this.this$0 = r1;
            }

            public final void accept(TypedResult<RemoteToggles> typedResult) {
                if (typedResult instanceof TypedResult.OfResult) {
                    this.this$0.loadingMonitor.reportLoadingSuccess();
                    this.this$0.storage.store((RemoteToggles) ((TypedResult.OfResult) typedResult).getResult());
                } else if (typedResult instanceof TypedResult.OfError) {
                    this.this$0.loadingMonitor.reportLoadingFailed();
                    Logs.error$default("RemoteFeatures", "Failed to load remote toggles: " + ((TypedResult.OfError) typedResult).getError(), null, 4, null);
                }
            }
        });
        Intrinsics.checkNotNullExpressionValue(doOnSuccess, "api.fetchRemoteToggles()…          }\n            }");
        return doOnSuccess;
    }
}
