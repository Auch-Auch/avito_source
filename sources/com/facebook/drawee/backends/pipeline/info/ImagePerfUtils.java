package com.facebook.drawee.backends.pipeline.info;

import com.avito.android.remote.model.payment.status.PaymentStateKt;
public class ImagePerfUtils {
    public static String toString(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "unknown" : "error" : PaymentStateKt.PAYMENT_STATE_CANCELED : "success" : "intermediate_available" : "origin_available" : "requested";
    }
}
