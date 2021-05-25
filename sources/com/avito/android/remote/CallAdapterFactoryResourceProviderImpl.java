package com.avito.android.remote;

import android.content.res.Resources;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0005\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0004R\u0016\u0010\r\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0004¨\u0006\u0010"}, d2 = {"Lcom/avito/android/remote/CallAdapterFactoryResourceProviderImpl;", "Lcom/avito/android/remote/CallAdapterFactoryResourceProvider;", "", "getUnsafeNetworkError", "()Ljava/lang/String;", "unsafeNetworkError", "Landroid/content/res/Resources;", AuthSource.SEND_ABUSE, "Landroid/content/res/Resources;", "resources", "getUnknownError", "unknownError", "getNetworkUnavailableError", "networkUnavailableError", "<init>", "(Landroid/content/res/Resources;)V", "api_release"}, k = 1, mv = {1, 4, 2})
public class CallAdapterFactoryResourceProviderImpl implements CallAdapterFactoryResourceProvider {
    public final Resources a;

    public CallAdapterFactoryResourceProviderImpl(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.a = resources;
    }

    @Override // com.avito.android.remote.CallAdapterFactoryResourceProvider
    @NotNull
    public String getNetworkUnavailableError() {
        String string = this.a.getString(R.string.network_unavailable_snack);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…etwork_unavailable_snack)");
        return string;
    }

    @Override // com.avito.android.remote.CallAdapterFactoryResourceProvider
    @NotNull
    public String getUnknownError() {
        String string = this.a.getString(R.string.unknown_server_error);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.unknown_server_error)");
        return string;
    }

    @Override // com.avito.android.remote.CallAdapterFactoryResourceProvider
    @NotNull
    public String getUnsafeNetworkError() {
        String string = this.a.getString(R.string.unsafe_network_message);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…g.unsafe_network_message)");
        return string;
    }
}
