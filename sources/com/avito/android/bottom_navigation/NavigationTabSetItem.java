package com.avito.android.bottom_navigation;

import android.os.Parcelable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u00020\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0016\u0010\u000f\u001a\u00020\f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/avito/android/bottom_navigation/NavigationTabSetItem;", "Landroid/os/Parcelable;", "", "getName", "()Ljava/lang/String;", "name", "", "getTabContainerId", "()I", "tabContainerId", "getIcon", "icon", "Lcom/avito/android/bottom_navigation/AddButtonState;", "getAddButtonState", "()Lcom/avito/android/bottom_navigation/AddButtonState;", "addButtonState", "", "getNeedAuthorization", "()Z", "needAuthorization", "getTitle", "title", "bottom-navigation_release"}, k = 1, mv = {1, 4, 2})
public interface NavigationTabSetItem extends Parcelable {
    @NotNull
    AddButtonState getAddButtonState();

    int getIcon();

    @NotNull
    String getName();

    boolean getNeedAuthorization();

    int getTabContainerId();

    int getTitle();
}
