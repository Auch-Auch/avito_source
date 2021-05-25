package com.google.firebase.dynamiclinks.internal;

import a2.j.e.f.a.f;
import a2.j.e.f.a.g;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.dynamiclinks.DynamicLink;
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks;
import com.google.firebase.dynamiclinks.PendingDynamicLinkData;
import com.google.firebase.dynamiclinks.ShortDynamicLink;
public final class zze extends FirebaseDynamicLinks {
    public final GoogleApi<Api.ApiOptions.NoOptions> a;
    @Nullable
    public final AnalyticsConnector b;

    public zze(FirebaseApp firebaseApp, @Nullable AnalyticsConnector analyticsConnector) {
        this.a = new zzc(firebaseApp.getApplicationContext());
        this.b = analyticsConnector;
    }

    public static void zzb(Bundle bundle) {
        Uri uri = (Uri) bundle.getParcelable("dynamicLink");
        if (TextUtils.isEmpty(bundle.getString("domainUriPrefix")) && uri == null) {
            throw new IllegalArgumentException("FDL domain is missing. Set with setDomainUriPrefix() or setDynamicLinkDomain().");
        }
    }

    @Override // com.google.firebase.dynamiclinks.FirebaseDynamicLinks
    public final DynamicLink.Builder createDynamicLink() {
        return new DynamicLink.Builder(this);
    }

    @Override // com.google.firebase.dynamiclinks.FirebaseDynamicLinks
    public final Task<PendingDynamicLinkData> getDynamicLink(@NonNull Intent intent) {
        Task<TResult> doWrite = this.a.doWrite(new g(this.b, intent.getDataString()));
        DynamicLinkData dynamicLinkData = (DynamicLinkData) SafeParcelableSerializer.deserializeFromIntentExtra(intent, "com.google.firebase.dynamiclinks.DYNAMIC_LINK_DATA", DynamicLinkData.CREATOR);
        PendingDynamicLinkData pendingDynamicLinkData = dynamicLinkData != null ? new PendingDynamicLinkData(dynamicLinkData) : null;
        return pendingDynamicLinkData != null ? Tasks.forResult(pendingDynamicLinkData) : doWrite;
    }

    public final Task<ShortDynamicLink> zza(Bundle bundle) {
        zzb(bundle);
        return this.a.doWrite(new f(bundle));
    }

    @Override // com.google.firebase.dynamiclinks.FirebaseDynamicLinks
    public final Task<PendingDynamicLinkData> getDynamicLink(@NonNull Uri uri) {
        return this.a.doWrite(new g(this.b, uri.toString()));
    }
}
