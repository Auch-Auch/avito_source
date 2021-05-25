package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import com.avito.android.remote.model.GlobalProperties;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroid/os/Parcel;", "Lcom/avito/android/remote/model/GlobalProperties$PriceRule$Value;", "invoke", "(Landroid/os/Parcel;)Lcom/avito/android/remote/model/GlobalProperties$PriceRule$Value;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class GlobalProperties$PriceRule$Value$Companion$CREATOR$1 extends Lambda implements Function1<Parcel, GlobalProperties.PriceRule.Value> {
    public static final GlobalProperties$PriceRule$Value$Companion$CREATOR$1 INSTANCE = new GlobalProperties$PriceRule$Value$Companion$CREATOR$1();

    public GlobalProperties$PriceRule$Value$Companion$CREATOR$1() {
        super(1);
    }

    @NotNull
    public final GlobalProperties.PriceRule.Value invoke(@NotNull Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "$receiver");
        return new GlobalProperties.PriceRule.Value(a.u2(parcel, "readString()!!"), parcel.readString(), parcel.readString());
    }
}
