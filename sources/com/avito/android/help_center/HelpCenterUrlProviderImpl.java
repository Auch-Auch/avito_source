package com.avito.android.help_center;

import android.net.Uri;
import com.avito.android.Features;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/avito/android/help_center/HelpCenterUrlProviderImpl;", "Lcom/avito/android/help_center/HelpCenterUrlProvider;", "Landroid/net/Uri;", "getUrl", "()Landroid/net/Uri;", "Lcom/avito/android/Features;", AuthSource.SEND_ABUSE, "Lcom/avito/android/Features;", "features", "<init>", "(Lcom/avito/android/Features;)V", "help-center_release"}, k = 1, mv = {1, 4, 2})
public final class HelpCenterUrlProviderImpl implements HelpCenterUrlProvider {
    public final Features a;

    @Inject
    public HelpCenterUrlProviderImpl(@NotNull Features features) {
        Intrinsics.checkNotNullParameter(features, "features");
        this.a = features;
    }

    @Override // com.avito.android.help_center.HelpCenterUrlProvider
    @Nullable
    public Uri getUrl() {
        return Uri.parse(this.a.getHelpCenterUrl().getValue());
    }
}
