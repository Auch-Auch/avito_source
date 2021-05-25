package com.avito.android.remote.model.category_parameters;

import android.os.Parcel;
import com.avito.android.remote.model.category_parameters.Constraint;
import com.avito.android.util.ParcelsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroid/os/Parcel;", "Lcom/avito/android/remote/model/category_parameters/Constraint$Limit;", "invoke", "(Landroid/os/Parcel;)Lcom/avito/android/remote/model/category_parameters/Constraint$Limit;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class Constraint$Limit$Companion$CREATOR$1 extends Lambda implements Function1<Parcel, Constraint.Limit> {
    public static final Constraint$Limit$Companion$CREATOR$1 INSTANCE = new Constraint$Limit$Companion$CREATOR$1();

    public Constraint$Limit$Companion$CREATOR$1() {
        super(1);
    }

    @NotNull
    public final Constraint.Limit invoke(@NotNull Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "$receiver");
        String readString = parcel.readString();
        String readString2 = parcel.readString();
        String readString3 = parcel.readString();
        List createParcelableList = ParcelsKt.createParcelableList(parcel, Condition.class);
        String readString4 = parcel.readString();
        Object readValue = parcel.readValue(Long.class.getClassLoader());
        Long l = null;
        if (!(readValue instanceof Long)) {
            readValue = null;
        }
        Long l2 = (Long) readValue;
        Object readValue2 = parcel.readValue(Long.class.getClassLoader());
        if (readValue2 instanceof Long) {
            l = readValue2;
        }
        return new Constraint.Limit(l2, l, readString2, readString, readString3, createParcelableList, readString4);
    }
}
