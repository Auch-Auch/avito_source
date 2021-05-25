package com.avito.android.remote.model.payment;

import a2.b.a.a.a;
import android.os.Parcel;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.model.payment.PaymentMethod;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroid/os/Parcel;", "Lcom/avito/android/remote/model/payment/PaymentMethod$SelectableMethod;", "invoke", "(Landroid/os/Parcel;)Lcom/avito/android/remote/model/payment/PaymentMethod$SelectableMethod;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class PaymentMethod$SelectableMethod$Companion$CREATOR$1 extends Lambda implements Function1<Parcel, PaymentMethod.SelectableMethod> {
    public static final PaymentMethod$SelectableMethod$Companion$CREATOR$1 INSTANCE = new PaymentMethod$SelectableMethod$Companion$CREATOR$1();

    public PaymentMethod$SelectableMethod$Companion$CREATOR$1() {
        super(1);
    }

    @NotNull
    public final PaymentMethod.SelectableMethod invoke(@NotNull Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "$receiver");
        String u2 = a.u2(parcel, "readString()!!");
        String u22 = a.u2(parcel, "readString()!!");
        DeepLink deepLink = (DeepLink) a.z1(DeepLink.class, parcel);
        Object readValue = parcel.readValue(String.class.getClassLoader());
        String str = null;
        if (!(readValue instanceof String)) {
            readValue = null;
        }
        String str2 = (String) readValue;
        Object readValue2 = parcel.readValue(String.class.getClassLoader());
        if (!(readValue2 instanceof String)) {
            readValue2 = null;
        }
        String str3 = (String) readValue2;
        Object readValue3 = parcel.readValue(String.class.getClassLoader());
        if (readValue3 instanceof String) {
            str = readValue3;
        }
        return new PaymentMethod.SelectableMethod(str2, str3, str, u2, u22, deepLink);
    }
}
