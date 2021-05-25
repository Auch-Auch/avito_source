package com.avito.android.app.external;

import android.content.Context;
import com.avito.android.remote.auth.AuthSource;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/app/external/ApplicationInfoProviderImpl;", "Lcom/avito/android/app/external/ApplicationInfoProvider;", "", Constants.FirelogAnalytics.PARAM_PACKAGE_NAME, "", "isAppInstalled", "(Ljava/lang/String;)Z", "", "getVersionCode", "(Ljava/lang/String;)I", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "core_release"}, k = 1, mv = {1, 4, 2})
public class ApplicationInfoProviderImpl implements ApplicationInfoProvider {
    public final Context a;

    public ApplicationInfoProviderImpl(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = context;
    }

    @Override // com.avito.android.app.external.ApplicationInfoProvider
    public int getVersionCode(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, Constants.FirelogAnalytics.PARAM_PACKAGE_NAME);
        try {
            Context applicationContext = this.a.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
            return applicationContext.getPackageManager().getPackageInfo(str, 0).versionCode;
        } catch (Throwable unused) {
            return 0;
        }
    }

    @Override // com.avito.android.app.external.ApplicationInfoProvider
    public boolean isAppInstalled(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, Constants.FirelogAnalytics.PARAM_PACKAGE_NAME);
        try {
            Context applicationContext = this.a.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
            applicationContext.getPackageManager().getApplicationInfo(str, 0);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
