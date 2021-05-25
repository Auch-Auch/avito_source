package com.avito.android.remote.model.user_profile.items;

import android.os.Parcel;
import com.avito.android.remote.model.user_profile.items.ExtensionsItem;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroid/os/Parcel;", "Lcom/avito/android/remote/model/user_profile/items/ExtensionsItem$ExtensionInfo;", "invoke", "(Landroid/os/Parcel;)Lcom/avito/android/remote/model/user_profile/items/ExtensionsItem$ExtensionInfo;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class ExtensionsItem$ExtensionInfo$Companion$CREATOR$1 extends Lambda implements Function1<Parcel, ExtensionsItem.ExtensionInfo> {
    public static final ExtensionsItem$ExtensionInfo$Companion$CREATOR$1 INSTANCE = new ExtensionsItem$ExtensionInfo$Companion$CREATOR$1();

    public ExtensionsItem$ExtensionInfo$Companion$CREATOR$1() {
        super(1);
    }

    @NotNull
    public final ExtensionsItem.ExtensionInfo invoke(@NotNull Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "$receiver");
        String readString = parcel.readString();
        String str = "";
        if (readString == null) {
            readString = str;
        }
        String readString2 = parcel.readString();
        if (readString2 != null) {
            str = readString2;
        }
        return new ExtensionsItem.ExtensionInfo(readString, str);
    }
}
