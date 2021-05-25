package com.avito.android.remote.model.category_parameters;

import a2.b.a.a.a;
import android.os.Parcel;
import com.avito.android.remote.model.category_parameters.Constraint;
import com.avito.android.util.ParcelsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroid/os/Parcel;", "Lcom/avito/android/remote/model/category_parameters/Constraint$Regex;", "invoke", "(Landroid/os/Parcel;)Lcom/avito/android/remote/model/category_parameters/Constraint$Regex;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class Constraint$Regex$Companion$CREATOR$1 extends Lambda implements Function1<Parcel, Constraint.Regex> {
    public static final Constraint$Regex$Companion$CREATOR$1 INSTANCE = new Constraint$Regex$Companion$CREATOR$1();

    public Constraint$Regex$Companion$CREATOR$1() {
        super(1);
    }

    @NotNull
    public final Constraint.Regex invoke(@NotNull Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "$receiver");
        String readString = parcel.readString();
        String readString2 = parcel.readString();
        String readString3 = parcel.readString();
        List createParcelableList = ParcelsKt.createParcelableList(parcel, Condition.class);
        String readString4 = parcel.readString();
        String u2 = a.u2(parcel, "readString()!!");
        Object readValue = parcel.readValue(Boolean.class.getClassLoader());
        if (!(readValue instanceof Boolean)) {
            readValue = null;
        }
        return new Constraint.Regex(u2, (Boolean) readValue, readString, readString2, readString3, createParcelableList, readString4);
    }
}
