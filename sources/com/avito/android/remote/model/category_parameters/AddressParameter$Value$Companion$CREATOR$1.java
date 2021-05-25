package com.avito.android.remote.model.category_parameters;

import android.os.Parcel;
import com.avito.android.remote.model.category_parameters.AddressParameter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroid/os/Parcel;", "Lcom/avito/android/remote/model/category_parameters/AddressParameter$Value;", "invoke", "(Landroid/os/Parcel;)Lcom/avito/android/remote/model/category_parameters/AddressParameter$Value;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class AddressParameter$Value$Companion$CREATOR$1 extends Lambda implements Function1<Parcel, AddressParameter.Value> {
    public static final AddressParameter$Value$Companion$CREATOR$1 INSTANCE = new AddressParameter$Value$Companion$CREATOR$1();

    public AddressParameter$Value$Companion$CREATOR$1() {
        super(1);
    }

    @NotNull
    public final AddressParameter.Value invoke(@NotNull Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "$receiver");
        double readDouble = parcel.readDouble();
        double readDouble2 = parcel.readDouble();
        String readString = parcel.readString();
        Object readValue = parcel.readValue(String.class.getClassLoader());
        if (!(readValue instanceof String)) {
            readValue = null;
        }
        return new AddressParameter.Value(readDouble, readDouble2, readString, (String) readValue);
    }
}
