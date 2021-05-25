package com.avito.android.player.presenter;

import android.content.res.Resources;
import com.avito.android.remote.CallAdapterFactoryResourceProvider;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/player/presenter/PlayerResourcesProviderImpl;", "Lcom/avito/android/player/presenter/PlayerResourcesProvider;", "", "connectionError", "()Ljava/lang/String;", "unknownError", "Lcom/avito/android/remote/CallAdapterFactoryResourceProvider;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/CallAdapterFactoryResourceProvider;", "callAdapterFactoryResourceProvider", "Landroid/content/res/Resources;", "resources", "<init>", "(Landroid/content/res/Resources;Lcom/avito/android/remote/CallAdapterFactoryResourceProvider;)V", "player_release"}, k = 1, mv = {1, 4, 2})
public final class PlayerResourcesProviderImpl implements PlayerResourcesProvider {
    public final CallAdapterFactoryResourceProvider a;

    @Inject
    public PlayerResourcesProviderImpl(@NotNull Resources resources, @NotNull CallAdapterFactoryResourceProvider callAdapterFactoryResourceProvider) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(callAdapterFactoryResourceProvider, "callAdapterFactoryResourceProvider");
        this.a = callAdapterFactoryResourceProvider;
    }

    @Override // com.avito.android.player.presenter.PlayerResourcesProvider
    @NotNull
    public String connectionError() {
        return this.a.getNetworkUnavailableError();
    }

    @Override // com.avito.android.player.presenter.PlayerResourcesProvider
    @NotNull
    public String unknownError() {
        return this.a.getUnknownError();
    }
}
