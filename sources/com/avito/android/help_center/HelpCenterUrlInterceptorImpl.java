package com.avito.android.help_center;

import android.net.Uri;
import com.avito.android.help_center.HelpCenterUrlInterceptor;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.share.internal.ShareConstants;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/avito/android/help_center/HelpCenterUrlInterceptorImpl;", "Lcom/avito/android/help_center/HelpCenterUrlInterceptor;", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "", "intercept", "(Landroid/net/Uri;)Z", "Lcom/avito/android/help_center/HelpCenterUrlInterceptor$CallBack;", "callBack", "", "setCallBack", "(Lcom/avito/android/help_center/HelpCenterUrlInterceptor$CallBack;)V", "Lcom/avito/android/help_center/HelpCenterUrlProvider;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/help_center/HelpCenterUrlProvider;", "helpCenterUrlProvider", AuthSource.SEND_ABUSE, "Lcom/avito/android/help_center/HelpCenterUrlInterceptor$CallBack;", "<init>", "(Lcom/avito/android/help_center/HelpCenterUrlProvider;)V", "help-center_release"}, k = 1, mv = {1, 4, 2})
public final class HelpCenterUrlInterceptorImpl implements HelpCenterUrlInterceptor {
    public HelpCenterUrlInterceptor.CallBack a;
    public final HelpCenterUrlProvider b;

    @Inject
    public HelpCenterUrlInterceptorImpl(@NotNull HelpCenterUrlProvider helpCenterUrlProvider) {
        Intrinsics.checkNotNullParameter(helpCenterUrlProvider, "helpCenterUrlProvider");
        this.b = helpCenterUrlProvider;
    }

    @Override // com.yatatsu.powerwebview.PowerWebViewInterceptor
    public boolean intercept(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        String host = uri.getHost();
        Uri url = this.b.getUrl();
        if (Intrinsics.areEqual(host, url != null ? url.getHost() : null)) {
            return false;
        }
        HelpCenterUrlInterceptor.CallBack callBack = this.a;
        if (callBack == null) {
            return true;
        }
        callBack.doesNotSupportUrl(uri);
        return true;
    }

    @Override // com.avito.android.help_center.HelpCenterUrlInterceptor
    public void setCallBack(@NotNull HelpCenterUrlInterceptor.CallBack callBack) {
        Intrinsics.checkNotNullParameter(callBack, "callBack");
        this.a = callBack;
    }
}
