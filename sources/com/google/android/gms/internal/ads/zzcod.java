package com.google.android.gms.internal.ads;

import android.content.Context;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.ads.internal.zzp;
import java.io.StringReader;
import java.util.concurrent.Executor;
import org.json.JSONObject;
import ru.avito.messenger.internal.jsonrpc.CommonKt;
public final class zzcod {
    private final Executor executor;
    private final zzdln zzfqn;
    private final zzbbg zzghx;
    private final Context zzvr;

    public zzcod(Context context, zzbbg zzbbg, zzdln zzdln, Executor executor2) {
        this.zzvr = context;
        this.zzghx = zzbbg;
        this.zzfqn = zzdln;
        this.executor = executor2;
    }

    public final zzdvt<zzdlj> zzapk() {
        zzalu zzb = zzp.zzlc().zzb(this.zzvr, this.zzghx);
        zzalq<JSONObject> zzalq = zzalp.zzdhs;
        zzalm zza = zzb.zza("google.afma.response.normalize", zzalq, zzalq);
        return zzdvl.zzb(zzdvl.zzb(zzdvl.zzb(zzdvl.zzaf(""), new zzduv(this, this.zzfqn.zzhbu.zzchi) { // from class: com.google.android.gms.internal.ads.zzcog
            private final zzcod zzghz;
            private final zzuu zzgia;

            {
                this.zzghz = r1;
                this.zzgia = r2;
            }

            @Override // com.google.android.gms.internal.ads.zzduv
            public final zzdvt zzf(Object obj) {
                zzuu zzuu = this.zzgia;
                String str = (String) obj;
                String str2 = zzuu.zzcgo;
                String str3 = zzuu.zzcgp;
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("headers", new JSONObject());
                jSONObject3.put(SDKConstants.PARAM_A2U_BODY, str2);
                jSONObject2.put("base_url", "");
                jSONObject2.put("signals", new JSONObject(str3));
                jSONObject.put("request", jSONObject2);
                jSONObject.put(CommonKt.EXTRA_RESPONSE, jSONObject3);
                jSONObject.put("flags", new JSONObject());
                return zzdvl.zzaf(jSONObject);
            }
        }, this.executor), new zzduv(zza) { // from class: com.google.android.gms.internal.ads.zzcof
            private final zzalm zzghy;

            {
                this.zzghy = r1;
            }

            @Override // com.google.android.gms.internal.ads.zzduv
            public final zzdvt zzf(Object obj) {
                return this.zzghy.zzi((JSONObject) obj);
            }
        }, this.executor), new zzduv(this) { // from class: com.google.android.gms.internal.ads.zzcoi
            private final zzcod zzghz;

            {
                this.zzghz = r1;
            }

            @Override // com.google.android.gms.internal.ads.zzduv
            public final zzdvt zzf(Object obj) {
                return this.zzghz.zzo((JSONObject) obj);
            }
        }, this.executor);
    }

    public final /* synthetic */ zzdvt zzo(JSONObject jSONObject) throws Exception {
        return zzdvl.zzaf(new zzdlj(new zzdle(this.zzfqn), zzdlh.zza(new StringReader(jSONObject.toString()))));
    }
}
