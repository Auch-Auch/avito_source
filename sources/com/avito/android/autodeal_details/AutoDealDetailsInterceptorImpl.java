package com.avito.android.autodeal_details;

import android.net.Uri;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.share.internal.ShareConstants;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J4\u0010\r\u001a\u00020\u000b2#\u0010\f\u001a\u001f\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\r\u0010\u000eR\u001e\u0010\u0013\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R3\u0010\f\u001a\u001f\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/avito/android/autodeal_details/AutoDealDetailsInterceptorImpl;", "Lcom/avito/android/autodeal_details/AutoDealDetailsInterceptor;", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "", "intercept", "(Landroid/net/Uri;)Z", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "url", "", "callback", "setOpenThirdPartyUriCallBack", "(Lkotlin/jvm/functions/Function1;)V", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", AuthSource.BOOKING_ORDER, "Ljava/util/regex/Pattern;", "pattern", AuthSource.SEND_ABUSE, "Lkotlin/jvm/functions/Function1;", "<init>", "()V", "autodeal-details_release"}, k = 1, mv = {1, 4, 2})
public final class AutoDealDetailsInterceptorImpl implements AutoDealDetailsInterceptor {
    public Function1<? super Uri, Unit> a;
    public final Pattern b = Pattern.compile("^(.*)avito\\.ru/(point|autodeal).*?$");

    @Override // com.yatatsu.powerwebview.PowerWebViewInterceptor
    public boolean intercept(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        if (this.b.matcher(uri.toString()).matches()) {
            return false;
        }
        Function1<? super Uri, Unit> function1 = this.a;
        if (function1 != null) {
            function1.invoke(uri);
        }
        return true;
    }

    @Override // com.avito.android.autodeal_details.AutoDealDetailsInterceptor
    public void setOpenThirdPartyUriCallBack(@Nullable Function1<? super Uri, Unit> function1) {
        this.a = function1;
    }
}
