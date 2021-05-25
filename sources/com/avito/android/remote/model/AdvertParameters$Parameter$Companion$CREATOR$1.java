package com.avito.android.remote.model;

import android.os.Parcel;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.model.AdvertParameters;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroid/os/Parcel;", "Lcom/avito/android/remote/model/AdvertParameters$Parameter;", "invoke", "(Landroid/os/Parcel;)Lcom/avito/android/remote/model/AdvertParameters$Parameter;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class AdvertParameters$Parameter$Companion$CREATOR$1 extends Lambda implements Function1<Parcel, AdvertParameters.Parameter> {
    public static final AdvertParameters$Parameter$Companion$CREATOR$1 INSTANCE = new AdvertParameters$Parameter$Companion$CREATOR$1();

    public AdvertParameters$Parameter$Companion$CREATOR$1() {
        super(1);
    }

    @NotNull
    public final AdvertParameters.Parameter invoke(@NotNull Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "$receiver");
        String readString = parcel.readString();
        if (readString == null) {
            readString = "";
        }
        List createStringArrayList = parcel.createStringArrayList();
        if (createStringArrayList == null) {
            createStringArrayList = CollectionsKt__CollectionsKt.emptyList();
        }
        return new AdvertParameters.Parameter(readString, createStringArrayList, parcel.readString(), (DeepLink) parcel.readParcelable(DeepLink.class.getClassLoader()));
    }
}
