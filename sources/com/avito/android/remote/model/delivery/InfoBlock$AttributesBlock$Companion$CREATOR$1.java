package com.avito.android.remote.model.delivery;

import android.os.Parcel;
import com.avito.android.remote.model.delivery.InfoBlock;
import com.avito.android.util.ParcelsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroid/os/Parcel;", "Lcom/avito/android/remote/model/delivery/InfoBlock$AttributesBlock;", "invoke", "(Landroid/os/Parcel;)Lcom/avito/android/remote/model/delivery/InfoBlock$AttributesBlock;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class InfoBlock$AttributesBlock$Companion$CREATOR$1 extends Lambda implements Function1<Parcel, InfoBlock.AttributesBlock> {
    public static final InfoBlock$AttributesBlock$Companion$CREATOR$1 INSTANCE = new InfoBlock$AttributesBlock$Companion$CREATOR$1();

    public InfoBlock$AttributesBlock$Companion$CREATOR$1() {
        super(1);
    }

    @NotNull
    public final InfoBlock.AttributesBlock invoke(@NotNull Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "$receiver");
        String readString = parcel.readString();
        List createParcelableList = ParcelsKt.createParcelableList(parcel, Attribute.class);
        if (createParcelableList == null) {
            createParcelableList = CollectionsKt__CollectionsKt.emptyList();
        }
        return new InfoBlock.AttributesBlock(readString, createParcelableList);
    }
}
