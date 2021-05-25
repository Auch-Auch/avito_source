package com.google.android.gms.internal.ads;

import com.avito.android.remote.model.category_parameters.FormattedDateDisplayingType;
import com.avito.android.remote.model.payment.PaymentMethodTypeKt;
import org.json.JSONException;
import org.json.JSONObject;
public final class zzaqc {
    private final boolean zzdna;
    private final boolean zzdnb;
    private final boolean zzdnc;
    private final boolean zzdnd;
    private final boolean zzdne;

    private zzaqc(zzaqe zzaqe) {
        this.zzdna = zzaqe.zzdna;
        this.zzdnb = zzaqe.zzdnb;
        this.zzdnc = zzaqe.zzdnc;
        this.zzdnd = zzaqe.zzdnd;
        this.zzdne = zzaqe.zzdne;
    }

    public final JSONObject zzul() {
        try {
            return new JSONObject().put(PaymentMethodTypeKt.PAYMENT_METHOD_TYPE_SMS, this.zzdna).put("tel", this.zzdnb).put(FormattedDateDisplayingType.TYPE_CALENDAR, this.zzdnc).put("storePicture", this.zzdnd).put("inlineVideo", this.zzdne);
        } catch (JSONException e) {
            zzbbd.zzc("Error occured while obtaining the MRAID capabilities.", e);
            return null;
        }
    }
}
