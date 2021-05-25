package com.google.android.gms.internal.ads;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.ads.internal.zzp;
import org.json.JSONException;
import org.json.JSONObject;
import ru.avito.messenger.internal.jsonrpc.CommonKt;
public final class zzcqa implements zzaln<zzcpx> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzaln
    public final /* synthetic */ JSONObject zzj(zzcpx zzcpx) throws JSONException {
        zzcpx zzcpx2 = zzcpx;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        jSONObject2.put("base_url", zzcpx2.zzgji.zzvf());
        jSONObject2.put("signals", zzcpx2.zzgjh);
        jSONObject3.put(SDKConstants.PARAM_A2U_BODY, zzcpx2.zzgjg.zzdrq);
        jSONObject3.put("headers", zzp.zzkp().zzj(zzcpx2.zzgjg.zzam));
        jSONObject3.put("response_code", zzcpx2.zzgjg.zzgjq);
        jSONObject3.put("latency", zzcpx2.zzgjg.zzgjr);
        jSONObject.put("request", jSONObject2);
        jSONObject.put(CommonKt.EXTRA_RESPONSE, jSONObject3);
        jSONObject.put("flags", zzcpx2.zzgji.zzvi());
        return jSONObject;
    }
}
