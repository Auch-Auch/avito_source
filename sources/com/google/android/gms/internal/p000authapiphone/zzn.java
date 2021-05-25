package com.google.android.gms.internal.p000authapiphone;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.auth.api.phone.SmsCodeAutofillClient;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
/* renamed from: com.google.android.gms.internal.auth-api-phone.zzn  reason: invalid package */
public final class zzn extends GoogleApi<Api.ApiOptions.NoOptions> implements SmsCodeAutofillClient {
    private static final Api.ClientKey<zzv> zza;
    private static final Api.AbstractClientBuilder<zzv, Api.ApiOptions.NoOptions> zzb;
    private static final Api<Api.ApiOptions.NoOptions> zzc;

    static {
        Api.ClientKey<zzv> clientKey = new Api.ClientKey<>();
        zza = clientKey;
        zzr zzr = new zzr();
        zzb = zzr;
        zzc = new Api<>("SmsCodeAutofill.API", zzr, clientKey);
    }

    public zzn(@NonNull Context context) {
        super(context, zzc, (Api.ApiOptions) null, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    @Override // com.google.android.gms.auth.api.phone.SmsCodeAutofillClient
    public final Task<Integer> checkPermissionState() {
        return doRead(TaskApiCall.builder().setFeatures(zzaa.zza).run(new RemoteCall(this) { // from class: com.google.android.gms.internal.auth-api-phone.zzp
            private final zzn zza;

            {
                this.zza = r1;
            }

            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                ((zzj) ((zzv) obj).getService()).zza(new zzt(this.zza, (TaskCompletionSource) obj2));
            }
        }).build());
    }

    @Override // com.google.android.gms.auth.api.phone.SmsCodeAutofillClient
    public final Task<Boolean> hasOngoingSmsRequest(@NonNull String str) {
        Preconditions.checkNotNull(str);
        Preconditions.checkArgument(!str.isEmpty(), "The package name cannot be empty.");
        return doRead(TaskApiCall.builder().setFeatures(zzaa.zza).run(new RemoteCall(this, str) { // from class: com.google.android.gms.internal.auth-api-phone.zzo
            private final zzn zza;
            private final String zzb;

            {
                this.zza = r1;
                this.zzb = r2;
            }

            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                zzn zzn = this.zza;
                ((zzj) ((zzv) obj).getService()).zza(this.zzb, new zzs(zzn, (TaskCompletionSource) obj2));
            }
        }).build());
    }

    @Override // com.google.android.gms.auth.api.phone.SmsCodeAutofillClient
    public final Task<Void> startSmsCodeRetriever() {
        return doWrite(TaskApiCall.builder().setFeatures(zzaa.zza).run(new RemoteCall(this) { // from class: com.google.android.gms.internal.auth-api-phone.zzm
            private final zzn zza;

            {
                this.zza = r1;
            }

            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                ((zzj) ((zzv) obj).getService()).zza(new zzq(this.zza, (TaskCompletionSource) obj2));
            }
        }).build());
    }

    public zzn(@NonNull Activity activity) {
        super(activity, (Api<Api.ApiOptions>) zzc, (Api.ApiOptions) null, GoogleApi.Settings.DEFAULT_SETTINGS);
    }
}
