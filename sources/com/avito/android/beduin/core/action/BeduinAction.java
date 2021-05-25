package com.avito.android.beduin.core.action;

import android.os.Parcelable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/avito/android/beduin/core/action/BeduinAction;", "Landroid/os/Parcelable;", "Lcom/avito/android/beduin/core/action/BeduinActionType;", "getActionType", "()Lcom/avito/android/beduin/core/action/BeduinActionType;", "actionType", "beduin_release"}, k = 1, mv = {1, 4, 2})
public interface BeduinAction extends Parcelable {
    @NotNull
    BeduinActionType getActionType();
}
