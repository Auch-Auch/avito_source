package com.avito.android.deep_linking;

import android.content.Context;
import android.net.Uri;
import com.adjust.sdk.Adjust;
import com.avito.android.Features;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.share.internal.ShareConstants;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\r¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0019\u0010\f\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\u0012\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/deep_linking/AdjustReattributionInteractorImpl;", "Lcom/avito/android/deep_linking/AdjustReattributionInteractor;", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "", "startReattribution", "(Landroid/net/Uri;)V", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lcom/avito/android/Features;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/Features;", "getFeatures", "()Lcom/avito/android/Features;", "features", "<init>", "(Landroid/content/Context;Lcom/avito/android/Features;)V", "deep-linking_release"}, k = 1, mv = {1, 4, 2})
public final class AdjustReattributionInteractorImpl implements AdjustReattributionInteractor {
    @NotNull
    public final Context a;
    @NotNull
    public final Features b;

    @Inject
    public AdjustReattributionInteractorImpl(@NotNull Context context, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(features, "features");
        this.a = context;
        this.b = features;
    }

    @NotNull
    public final Context getContext() {
        return this.a;
    }

    @NotNull
    public final Features getFeatures() {
        return this.b;
    }

    @Override // com.avito.android.deep_linking.AdjustReattributionInteractor
    public void startReattribution(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        if (this.b.getAdjustDeeplinkReattribution().invoke().booleanValue()) {
            Adjust.appWillOpenUrl(uri, this.a);
        }
    }
}
