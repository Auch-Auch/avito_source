package com.avito.android;

import android.content.Intent;
import com.avito.android.bottom_navigation.NavigationTab;
import com.avito.android.item_map.remote.model.AmenityButton;
import com.avito.android.remote.model.Coordinates;
import com.avito.android.remote.model.GeoReference;
import com.facebook.appevents.integrity.IntegrityManager;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J¹\u0001\u0010\u0018\u001a\u00020\u00172\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000b2\b\b\u0002\u0010\u0011\u001a\u00020\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u00042\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00042\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/avito/android/ItemMapIntentFactory;", "", "Lcom/avito/android/remote/model/Coordinates;", "itemCoordinates", "", "hasFindMeButton", "myCoordinates", "hasBottomSheet", "", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "title", "", "Lcom/avito/android/remote/model/GeoReference;", "geoReference", "itemId", "Lcom/avito/android/item_map/remote/model/AmenityButton;", "amenityButtons", "showMeOnMap", "hasCreateRouteButton", "Lcom/avito/android/bottom_navigation/NavigationTab;", "tab", "shouldTrackMapMovements", "fromPage", "Landroid/content/Intent;", "itemMapIntent", "(Lcom/avito/android/remote/model/Coordinates;ZLcom/avito/android/remote/model/Coordinates;ZLjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/List;ZZLcom/avito/android/bottom_navigation/NavigationTab;ZLjava/lang/String;)Landroid/content/Intent;", "core_release"}, k = 1, mv = {1, 4, 2})
public interface ItemMapIntentFactory {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Intent itemMapIntent$default(ItemMapIntentFactory itemMapIntentFactory, Coordinates coordinates, boolean z, Coordinates coordinates2, boolean z2, String str, String str2, List list, String str3, List list2, boolean z3, boolean z4, NavigationTab navigationTab, boolean z5, String str4, int i, Object obj) {
            if (obj == null) {
                String str5 = null;
                Coordinates coordinates3 = (i & 1) != 0 ? null : coordinates;
                boolean z7 = true;
                boolean z8 = (i & 2) != 0 ? true : z;
                Coordinates coordinates4 = (i & 4) != 0 ? null : coordinates2;
                boolean z9 = (i & 8) != 0 ? true : z2;
                String str6 = (i & 16) != 0 ? null : str;
                String str7 = (i & 32) != 0 ? null : str2;
                List list3 = (i & 64) != 0 ? null : list;
                String str8 = (i & 128) != 0 ? null : str3;
                List list4 = (i & 256) != 0 ? null : list2;
                if ((i & 512) == 0) {
                    z7 = z3;
                }
                boolean z10 = false;
                boolean z11 = (i & 1024) != 0 ? false : z4;
                NavigationTab navigationTab2 = (i & 2048) != 0 ? null : navigationTab;
                if ((i & 4096) == 0) {
                    z10 = z5;
                }
                if ((i & 8192) == 0) {
                    str5 = str4;
                }
                return itemMapIntentFactory.itemMapIntent(coordinates3, z8, coordinates4, z9, str6, str7, list3, str8, list4, z7, z11, navigationTab2, z10, str5);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: itemMapIntent");
        }
    }

    @NotNull
    Intent itemMapIntent(@Nullable Coordinates coordinates, boolean z, @Nullable Coordinates coordinates2, boolean z2, @Nullable String str, @Nullable String str2, @Nullable List<GeoReference> list, @Nullable String str3, @Nullable List<AmenityButton> list2, boolean z3, boolean z4, @Nullable NavigationTab navigationTab, boolean z5, @Nullable String str4);
}
