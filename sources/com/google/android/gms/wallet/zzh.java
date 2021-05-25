package com.google.android.gms.wallet;

import com.avito.android.remote.model.payment.PaymentMethodTypeKt;
import com.google.android.gms.common.Feature;
public final class zzh {
    private static final Feature zzbe;
    private static final Feature zzbf;
    public static final Feature[] zzbg;

    static {
        Feature feature = new Feature(PaymentMethodTypeKt.PAYMENT_METHOD_TYPE_WALLET, 1);
        zzbe = feature;
        Feature feature2 = new Feature("wallet_biometric_auth_keys", 1);
        zzbf = feature2;
        zzbg = new Feature[]{feature, feature2};
    }
}
