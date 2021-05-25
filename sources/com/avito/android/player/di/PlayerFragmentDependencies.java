package com.avito.android.player.di;

import com.avito.android.IdProvider;
import com.avito.android.analytics.provider.TreeStateIdGenerator;
import com.avito.android.connection_quality.connectivity.ConnectivityProvider;
import com.avito.android.di.CoreComponentDependencies;
import com.avito.android.server_time.TimeSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/player/di/PlayerFragmentDependencies;", "Lcom/avito/android/di/CoreComponentDependencies;", "Lcom/avito/android/analytics/provider/TreeStateIdGenerator;", "treeStateIdGenerator", "()Lcom/avito/android/analytics/provider/TreeStateIdGenerator;", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "()Lcom/avito/android/server_time/TimeSource;", "Lcom/avito/android/IdProvider;", "idGenerator", "()Lcom/avito/android/IdProvider;", "Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;", "connectivityProvider", "()Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;", "player_release"}, k = 1, mv = {1, 4, 2})
public interface PlayerFragmentDependencies extends CoreComponentDependencies {
    @Override // com.avito.android.similar_adverts.di.SimilarAdvertsDependencies
    @NotNull
    ConnectivityProvider connectivityProvider();

    @NotNull
    IdProvider idGenerator();

    @Override // com.avito.android.similar_adverts.di.SimilarAdvertsDependencies
    @NotNull
    TimeSource timeSource();

    @NotNull
    TreeStateIdGenerator treeStateIdGenerator();
}
