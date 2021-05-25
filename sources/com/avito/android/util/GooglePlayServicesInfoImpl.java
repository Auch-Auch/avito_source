package com.avito.android.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.avito.android.remote.auth.AuthSource;
import com.google.android.gms.common.GoogleApiAvailability;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.c;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010\u0016\u001a\u00020\u0013¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001f\u0010\u000e\u001a\u0004\u0018\u00010\t8B@\u0002X\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00058V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/avito/android/util/GooglePlayServicesInfoImpl;", "Lcom/avito/android/util/GooglePlayServicesInfo;", "", "isGooglePlayServicesAvailable", "()Z", "", "getVersionCode", "()Ljava/lang/Integer;", "versionCode", "Landroid/content/pm/PackageInfo;", AuthSource.SEND_ABUSE, "Lkotlin/Lazy;", "getPlayServicesPackageInfo", "()Landroid/content/pm/PackageInfo;", "playServicesPackageInfo", "", "getVersionName", "()Ljava/lang/String;", "versionName", "Lcom/google/android/gms/common/GoogleApiAvailability;", "c", "Lcom/google/android/gms/common/GoogleApiAvailability;", "googleApiAvailability", "getLibraryVersionCode", "()I", "libraryVersionCode", "Landroid/content/Context;", AuthSource.BOOKING_ORDER, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/google/android/gms/common/GoogleApiAvailability;)V", "application_release"}, k = 1, mv = {1, 4, 2})
public final class GooglePlayServicesInfoImpl implements GooglePlayServicesInfo {
    public final Lazy a = c.lazy(new a(this));
    public final Context b;
    public final GoogleApiAvailability c;

    public static final class a extends Lambda implements Function0<PackageInfo> {
        public final /* synthetic */ GooglePlayServicesInfoImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(GooglePlayServicesInfoImpl googlePlayServicesInfoImpl) {
            super(0);
            this.a = googlePlayServicesInfoImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public PackageInfo invoke() {
            try {
                return this.a.b.getPackageManager().getPackageInfo("com.google.android.gms", 0);
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }
    }

    public GooglePlayServicesInfoImpl(@NotNull Context context, @NotNull GoogleApiAvailability googleApiAvailability) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(googleApiAvailability, "googleApiAvailability");
        this.b = context;
        this.c = googleApiAvailability;
    }

    @Override // com.avito.android.util.GooglePlayServicesInfo
    public int getLibraryVersionCode() {
        return GoogleApiAvailability.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    @Override // com.avito.android.util.GooglePlayServicesInfo
    @Nullable
    public Integer getVersionCode() {
        PackageInfo packageInfo = (PackageInfo) this.a.getValue();
        if (packageInfo != null) {
            return Integer.valueOf(packageInfo.versionCode);
        }
        return null;
    }

    @Override // com.avito.android.util.GooglePlayServicesInfo
    @Nullable
    public String getVersionName() {
        PackageInfo packageInfo = (PackageInfo) this.a.getValue();
        if (packageInfo != null) {
            return packageInfo.versionName;
        }
        return null;
    }

    @Override // com.avito.android.util.GooglePlayServicesInfo
    public boolean isGooglePlayServicesAvailable() {
        int i;
        try {
            i = this.c.isGooglePlayServicesAvailable(this.b);
        } catch (Throwable unused) {
            i = 9;
        }
        return i == 0;
    }
}
