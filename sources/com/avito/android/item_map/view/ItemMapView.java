package com.avito.android.item_map.view;

import a2.b.a.a.a;
import a2.g.r.g;
import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import androidx.annotation.StringRes;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.avito_map.AvitoMapMarker;
import com.avito.android.avito_map.AvitoMapPoint;
import com.avito.android.avito_map.AvitoMapTarget;
import com.avito.android.item_map.remote.model.AmenityButton;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.GeoReference;
import com.facebook.appevents.integrity.IntegrityManager;
import io.reactivex.rxjava3.core.Observable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.bottom_sheet.BottomSheet;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001:\u000389:J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002H&¢\u0006\u0004\b\u0007\u0010\u0005J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002H&¢\u0006\u0004\b\b\u0010\u0005J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002H&¢\u0006\u0004\b\t\u0010\u0005J\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002H&¢\u0006\u0004\b\n\u0010\u0005J\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0002H&¢\u0006\u0004\b\f\u0010\u0005J\u0015\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0002H&¢\u0006\u0004\b\r\u0010\u0005J\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0002H&¢\u0006\u0004\b\u000f\u0010\u0005J\u0019\u0010\u0011\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000eH&¢\u0006\u0004\b\u0011\u0010\u0012J-\u0010\u0017\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\b\u0017\u0010\u0018J-\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00192\u0006\u0010\u001c\u001a\u00020\u001bH&¢\u0006\u0004\b\u001e\u0010\u001fJ\u001d\u0010!\u001a\u00020\u00062\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\u0019H&¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0006H&¢\u0006\u0004\b#\u0010$J\u0019\u0010&\u001a\u00020\u00062\b\u0010%\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0004\b&\u0010'J#\u0010*\u001a\u00020\u00062\b\b\u0001\u0010(\u001a\u00020\u00152\b\b\u0002\u0010)\u001a\u00020\u0015H&¢\u0006\u0004\b*\u0010+J\u0019\u0010,\u001a\u00020\u00062\b\b\u0001\u0010(\u001a\u00020\u0015H&¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\u0006H&¢\u0006\u0004\b.\u0010$J\u000f\u0010/\u001a\u00020\u0006H&¢\u0006\u0004\b/\u0010$J\u000f\u00100\u001a\u00020\u0006H&¢\u0006\u0004\b0\u0010$J\u000f\u00101\u001a\u00020\u0015H&¢\u0006\u0004\b1\u00102J\u000f\u00103\u001a\u00020\u0006H&¢\u0006\u0004\b3\u0010$J\u000f\u00104\u001a\u00020\u0006H&¢\u0006\u0004\b4\u0010$J\u000f\u00106\u001a\u000205H&¢\u0006\u0004\b6\u00107¨\u0006;"}, d2 = {"Lcom/avito/android/item_map/view/ItemMapView;", "", "Lio/reactivex/rxjava3/core/Observable;", "Lru/avito/component/bottom_sheet/BottomSheet$Visibility;", "bottomSheetCallback", "()Lio/reactivex/rxjava3/core/Observable;", "", "backButtonCallback", "findMeButtonCallback", "osmDisclaimerCallback", "osmTooltipCallback", "Lcom/avito/android/avito_map/AvitoMapTarget;", "mapTargetUpdateCallback", "markerClickCallback", "Lcom/avito/android/avito_map/AvitoMapPoint;", "createRouteClicks", "point", "addItemMarker", "(Lcom/avito/android/avito_map/AvitoMapPoint;)V", "", "zoomToBounds", "", "boundsOffset", "addUserMarker", "(Lcom/avito/android/avito_map/AvitoMapPoint;ZI)V", "", "points", "Landroid/graphics/Bitmap;", "bitmap", "Lcom/avito/android/avito_map/AvitoMapMarker;", "addAmenityMarkers", "(Ljava/util/List;Landroid/graphics/Bitmap;)Ljava/util/List;", ScreenPublicConstsKt.CONTENT_TYPE_MARKERS, "removeAmenityMarkers", "(Ljava/util/List;)V", "showFindLocationError", "()V", "target", "moveToTarget", "(Lcom/avito/android/avito_map/AvitoMapTarget;)V", "stringId", "duration", "showError", "(II)V", "showSnackBarWarning", "(I)V", "onStartMap", "onStopMap", "onDestroyMap", "getWhiteColor", "()I", "calculateBottomSheetPeekHeight", "showOsmPopUp", "Landroid/view/View;", "getView", "()Landroid/view/View;", "AmenityButtonsState", "BottomSheetState", "ItemMapState", "item-map_release"}, k = 1, mv = {1, 4, 2})
public interface ItemMapView {

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b#\u0010$J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ.\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0010J \u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cR\u001b\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R!\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\b¨\u0006%"}, d2 = {"Lcom/avito/android/item_map/view/ItemMapView$AmenityButtonsState;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "", "Lcom/avito/android/item_map/remote/model/AmenityButton;", "component2", "()Ljava/util/List;", "itemId", "amenityButtons", "copy", "(Ljava/lang/String;Ljava/util/List;)Lcom/avito/android/item_map/view/ItemMapView$AmenityButtonsState;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getItemId", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "getAmenityButtons", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "item-map_release"}, k = 1, mv = {1, 4, 2})
    public static final class AmenityButtonsState implements Parcelable {
        public static final Parcelable.Creator<AmenityButtonsState> CREATOR = new Creator();
        @Nullable
        public final String a;
        @Nullable
        public final List<AmenityButton> b;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<AmenityButtonsState> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final AmenityButtonsState createFromParcel(@NotNull Parcel parcel) {
                ArrayList arrayList;
                Intrinsics.checkNotNullParameter(parcel, "in");
                String readString = parcel.readString();
                if (parcel.readInt() != 0) {
                    int readInt = parcel.readInt();
                    arrayList = new ArrayList(readInt);
                    while (readInt != 0) {
                        arrayList.add((AmenityButton) parcel.readParcelable(AmenityButtonsState.class.getClassLoader()));
                        readInt--;
                    }
                } else {
                    arrayList = null;
                }
                return new AmenityButtonsState(readString, arrayList);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final AmenityButtonsState[] newArray(int i) {
                return new AmenityButtonsState[i];
            }
        }

        public AmenityButtonsState(@Nullable String str, @Nullable List<AmenityButton> list) {
            this.a = str;
            this.b = list;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.item_map.view.ItemMapView$AmenityButtonsState */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ AmenityButtonsState copy$default(AmenityButtonsState amenityButtonsState, String str, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = amenityButtonsState.a;
            }
            if ((i & 2) != 0) {
                list = amenityButtonsState.b;
            }
            return amenityButtonsState.copy(str, list);
        }

        @Nullable
        public final String component1() {
            return this.a;
        }

        @Nullable
        public final List<AmenityButton> component2() {
            return this.b;
        }

        @NotNull
        public final AmenityButtonsState copy(@Nullable String str, @Nullable List<AmenityButton> list) {
            return new AmenityButtonsState(str, list);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // java.lang.Object
        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AmenityButtonsState)) {
                return false;
            }
            AmenityButtonsState amenityButtonsState = (AmenityButtonsState) obj;
            return Intrinsics.areEqual(this.a, amenityButtonsState.a) && Intrinsics.areEqual(this.b, amenityButtonsState.b);
        }

        @Nullable
        public final List<AmenityButton> getAmenityButtons() {
            return this.b;
        }

        @Nullable
        public final String getItemId() {
            return this.a;
        }

        @Override // java.lang.Object
        public int hashCode() {
            String str = this.a;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            List<AmenityButton> list = this.b;
            if (list != null) {
                i = list.hashCode();
            }
            return hashCode + i;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("AmenityButtonsState(itemId=");
            L.append(this.a);
            L.append(", amenityButtons=");
            return a.w(L, this.b, ")");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.a);
            List<AmenityButton> list = this.b;
            if (list != null) {
                Iterator l0 = a.l0(parcel, 1, list);
                while (l0.hasNext()) {
                    parcel.writeParcelable((AmenityButton) l0.next(), i);
                }
                return;
            }
            parcel.writeInt(0);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AmenityButtonsState(String str, List list, int i, j jVar) {
            this(str, (i & 2) != 0 ? null : list);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B+\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b(\u0010)J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ4\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u000e\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0012\u0010\u000bJ\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u000bJ \u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eR\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u000bR\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\u0004R\u001f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\b¨\u0006*"}, d2 = {"Lcom/avito/android/item_map/view/ItemMapView$BottomSheetState;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "", "Lcom/avito/android/remote/model/GeoReference;", "component2", "()Ljava/util/List;", "", "component3", "()I", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "geoReferences", "bottomSheetVisibility", "copy", "(Ljava/lang/String;Ljava/util/List;I)Lcom/avito/android/item_map/view/ItemMapView$BottomSheetState;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "c", "I", "getBottomSheetVisibility", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getAddress", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "getGeoReferences", "<init>", "(Ljava/lang/String;Ljava/util/List;I)V", "item-map_release"}, k = 1, mv = {1, 4, 2})
    public static final class BottomSheetState implements Parcelable {
        public static final Parcelable.Creator<BottomSheetState> CREATOR = new Creator();
        @NotNull
        public final String a;
        @NotNull
        public final List<GeoReference> b;
        public final int c;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<BottomSheetState> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final BottomSheetState createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                String readString = parcel.readString();
                int readInt = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add((GeoReference) parcel.readParcelable(BottomSheetState.class.getClassLoader()));
                    readInt--;
                }
                return new BottomSheetState(readString, arrayList, parcel.readInt());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final BottomSheetState[] newArray(int i) {
                return new BottomSheetState[i];
            }
        }

        public BottomSheetState() {
            this(null, null, 0, 7, null);
        }

        public BottomSheetState(@NotNull String str, @NotNull List<GeoReference> list, int i) {
            Intrinsics.checkNotNullParameter(str, IntegrityManager.INTEGRITY_TYPE_ADDRESS);
            Intrinsics.checkNotNullParameter(list, "geoReferences");
            this.a = str;
            this.b = list;
            this.c = i;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.item_map.view.ItemMapView$BottomSheetState */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ BottomSheetState copy$default(BottomSheetState bottomSheetState, String str, List list, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = bottomSheetState.a;
            }
            if ((i2 & 2) != 0) {
                list = bottomSheetState.b;
            }
            if ((i2 & 4) != 0) {
                i = bottomSheetState.c;
            }
            return bottomSheetState.copy(str, list, i);
        }

        @NotNull
        public final String component1() {
            return this.a;
        }

        @NotNull
        public final List<GeoReference> component2() {
            return this.b;
        }

        public final int component3() {
            return this.c;
        }

        @NotNull
        public final BottomSheetState copy(@NotNull String str, @NotNull List<GeoReference> list, int i) {
            Intrinsics.checkNotNullParameter(str, IntegrityManager.INTEGRITY_TYPE_ADDRESS);
            Intrinsics.checkNotNullParameter(list, "geoReferences");
            return new BottomSheetState(str, list, i);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // java.lang.Object
        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof BottomSheetState)) {
                return false;
            }
            BottomSheetState bottomSheetState = (BottomSheetState) obj;
            return Intrinsics.areEqual(this.a, bottomSheetState.a) && Intrinsics.areEqual(this.b, bottomSheetState.b) && this.c == bottomSheetState.c;
        }

        @NotNull
        public final String getAddress() {
            return this.a;
        }

        public final int getBottomSheetVisibility() {
            return this.c;
        }

        @NotNull
        public final List<GeoReference> getGeoReferences() {
            return this.b;
        }

        @Override // java.lang.Object
        public int hashCode() {
            String str = this.a;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            List<GeoReference> list = this.b;
            if (list != null) {
                i = list.hashCode();
            }
            return ((hashCode + i) * 31) + this.c;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("BottomSheetState(address=");
            L.append(this.a);
            L.append(", geoReferences=");
            L.append(this.b);
            L.append(", bottomSheetVisibility=");
            return a.j(L, this.c, ")");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.a);
            Iterator n0 = a.n0(this.b, parcel);
            while (n0.hasNext()) {
                parcel.writeParcelable((GeoReference) n0.next(), i);
            }
            parcel.writeInt(this.c);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ BottomSheetState(String str, List list, int i, int i2, j jVar) {
            this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i2 & 4) != 0 ? 3 : i);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void addUserMarker$default(ItemMapView itemMapView, AvitoMapPoint avitoMapPoint, boolean z, int i, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 2) != 0) {
                    z = false;
                }
                if ((i2 & 4) != 0) {
                    i = 0;
                }
                itemMapView.addUserMarker(avitoMapPoint, z, i);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addUserMarker");
        }

        public static /* synthetic */ void showError$default(ItemMapView itemMapView, int i, int i2, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    i2 = 0;
                }
                itemMapView.showError(i, i2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showError");
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b#\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u000f\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\"\u001a\u00020\u0005\u0012\b\b\u0002\u0010#\u001a\u00020\u0005\u0012\b\b\u0002\u0010$\u001a\u00020\u0005\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\t¢\u0006\u0004\bU\u0010VJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0004J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0007J\u0010\u0010\u0017\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0007J\u0010\u0010\u0018\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0007J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\u0019\u0010\u000bJ\u0001\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u001b\u001a\u00020\u00052\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u001f\u001a\u00020\u000f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\"\u001a\u00020\u00052\b\b\u0002\u0010#\u001a\u00020\u00052\b\b\u0002\u0010$\u001a\u00020\u00052\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b&\u0010'J\u0010\u0010(\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b(\u0010\u000bJ\u0010\u0010*\u001a\u00020)HÖ\u0001¢\u0006\u0004\b*\u0010+J\u001a\u0010.\u001a\u00020\u00052\b\u0010-\u001a\u0004\u0018\u00010,HÖ\u0003¢\u0006\u0004\b.\u0010/J\u0010\u00100\u001a\u00020)HÖ\u0001¢\u0006\u0004\b0\u0010+J \u00105\u001a\u0002042\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u00020)HÖ\u0001¢\u0006\u0004\b5\u00106R\u0019\u0010#\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010\u0007R\u001b\u0010%\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010\u000bR\u001b\u0010\u001d\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b=\u0010;\u001a\u0004\b>\u0010\u000bR\u001b\u0010 \u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010\u0004R\u001b\u0010\u001e\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010\u000eR\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\bE\u0010@\u001a\u0004\bF\u0010\u0004R\u0019\u0010\u001b\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\bG\u00108\u001a\u0004\bH\u0010\u0007R\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\bI\u0010@\u001a\u0004\bJ\u0010\u0004R\u0019\u0010\u001f\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\bK\u0010L\u001a\u0004\bM\u0010\u0011R\u001b\u0010!\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\bN\u0010O\u001a\u0004\bP\u0010\u0015R\u0019\u0010\"\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\bQ\u00108\u001a\u0004\bR\u0010\u0007R\u0019\u0010$\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\bS\u00108\u001a\u0004\bT\u0010\u0007¨\u0006W"}, d2 = {"Lcom/avito/android/item_map/view/ItemMapView$ItemMapState;", "Landroid/os/Parcelable;", "Lcom/avito/android/avito_map/AvitoMapPoint;", "component1", "()Lcom/avito/android/avito_map/AvitoMapPoint;", "", "component2", "()Z", "component3", "", "component4", "()Ljava/lang/String;", "Lcom/avito/android/item_map/view/ItemMapView$BottomSheetState;", "component5", "()Lcom/avito/android/item_map/view/ItemMapView$BottomSheetState;", "", "component6", "()F", "component7", "Lcom/avito/android/item_map/view/ItemMapView$AmenityButtonsState;", "component8", "()Lcom/avito/android/item_map/view/ItemMapView$AmenityButtonsState;", "component9", "component10", "component11", "component12", "itemCoordinates", "hasFindMeButton", "myCoordinates", "title", "bottomSheetState", "mapZoomLevel", "mapTargetPoint", "amenityButtonsState", "showMeOnMap", "hasCreateRouteButton", "shouldTrackMapMovement", "fromPage", "copy", "(Lcom/avito/android/avito_map/AvitoMapPoint;ZLcom/avito/android/avito_map/AvitoMapPoint;Ljava/lang/String;Lcom/avito/android/item_map/view/ItemMapView$BottomSheetState;FLcom/avito/android/avito_map/AvitoMapPoint;Lcom/avito/android/item_map/view/ItemMapView$AmenityButtonsState;ZZZLjava/lang/String;)Lcom/avito/android/item_map/view/ItemMapView$ItemMapState;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "j", "Z", "getHasCreateRouteButton", "l", "Ljava/lang/String;", "getFromPage", "d", "getTitle", g.a, "Lcom/avito/android/avito_map/AvitoMapPoint;", "getMapTargetPoint", "e", "Lcom/avito/android/item_map/view/ItemMapView$BottomSheetState;", "getBottomSheetState", AuthSource.SEND_ABUSE, "getItemCoordinates", AuthSource.BOOKING_ORDER, "getHasFindMeButton", "c", "getMyCoordinates", "f", "F", "getMapZoomLevel", "h", "Lcom/avito/android/item_map/view/ItemMapView$AmenityButtonsState;", "getAmenityButtonsState", "i", "getShowMeOnMap", "k", "getShouldTrackMapMovement", "<init>", "(Lcom/avito/android/avito_map/AvitoMapPoint;ZLcom/avito/android/avito_map/AvitoMapPoint;Ljava/lang/String;Lcom/avito/android/item_map/view/ItemMapView$BottomSheetState;FLcom/avito/android/avito_map/AvitoMapPoint;Lcom/avito/android/item_map/view/ItemMapView$AmenityButtonsState;ZZZLjava/lang/String;)V", "item-map_release"}, k = 1, mv = {1, 4, 2})
    public static final class ItemMapState implements Parcelable {
        public static final Parcelable.Creator<ItemMapState> CREATOR = new Creator();
        @Nullable
        public final AvitoMapPoint a;
        public final boolean b;
        @Nullable
        public final AvitoMapPoint c;
        @Nullable
        public final String d;
        @Nullable
        public final BottomSheetState e;
        public final float f;
        @Nullable
        public final AvitoMapPoint g;
        @Nullable
        public final AmenityButtonsState h;
        public final boolean i;
        public final boolean j;
        public final boolean k;
        @Nullable
        public final String l;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<ItemMapState> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final ItemMapState createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new ItemMapState((AvitoMapPoint) parcel.readParcelable(ItemMapState.class.getClassLoader()), parcel.readInt() != 0, (AvitoMapPoint) parcel.readParcelable(ItemMapState.class.getClassLoader()), parcel.readString(), parcel.readInt() != 0 ? BottomSheetState.CREATOR.createFromParcel(parcel) : null, parcel.readFloat(), (AvitoMapPoint) parcel.readParcelable(ItemMapState.class.getClassLoader()), parcel.readInt() != 0 ? AmenityButtonsState.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0, parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final ItemMapState[] newArray(int i) {
                return new ItemMapState[i];
            }
        }

        public ItemMapState() {
            this(null, false, null, null, null, 0.0f, null, null, false, false, false, null, 4095, null);
        }

        public ItemMapState(@Nullable AvitoMapPoint avitoMapPoint, boolean z, @Nullable AvitoMapPoint avitoMapPoint2, @Nullable String str, @Nullable BottomSheetState bottomSheetState, float f2, @Nullable AvitoMapPoint avitoMapPoint3, @Nullable AmenityButtonsState amenityButtonsState, boolean z2, boolean z3, boolean z4, @Nullable String str2) {
            this.a = avitoMapPoint;
            this.b = z;
            this.c = avitoMapPoint2;
            this.d = str;
            this.e = bottomSheetState;
            this.f = f2;
            this.g = avitoMapPoint3;
            this.h = amenityButtonsState;
            this.i = z2;
            this.j = z3;
            this.k = z4;
            this.l = str2;
        }

        public static /* synthetic */ ItemMapState copy$default(ItemMapState itemMapState, AvitoMapPoint avitoMapPoint, boolean z, AvitoMapPoint avitoMapPoint2, String str, BottomSheetState bottomSheetState, float f2, AvitoMapPoint avitoMapPoint3, AmenityButtonsState amenityButtonsState, boolean z2, boolean z3, boolean z4, String str2, int i2, Object obj) {
            return itemMapState.copy((i2 & 1) != 0 ? itemMapState.a : avitoMapPoint, (i2 & 2) != 0 ? itemMapState.b : z, (i2 & 4) != 0 ? itemMapState.c : avitoMapPoint2, (i2 & 8) != 0 ? itemMapState.d : str, (i2 & 16) != 0 ? itemMapState.e : bottomSheetState, (i2 & 32) != 0 ? itemMapState.f : f2, (i2 & 64) != 0 ? itemMapState.g : avitoMapPoint3, (i2 & 128) != 0 ? itemMapState.h : amenityButtonsState, (i2 & 256) != 0 ? itemMapState.i : z2, (i2 & 512) != 0 ? itemMapState.j : z3, (i2 & 1024) != 0 ? itemMapState.k : z4, (i2 & 2048) != 0 ? itemMapState.l : str2);
        }

        @Nullable
        public final AvitoMapPoint component1() {
            return this.a;
        }

        public final boolean component10() {
            return this.j;
        }

        public final boolean component11() {
            return this.k;
        }

        @Nullable
        public final String component12() {
            return this.l;
        }

        public final boolean component2() {
            return this.b;
        }

        @Nullable
        public final AvitoMapPoint component3() {
            return this.c;
        }

        @Nullable
        public final String component4() {
            return this.d;
        }

        @Nullable
        public final BottomSheetState component5() {
            return this.e;
        }

        public final float component6() {
            return this.f;
        }

        @Nullable
        public final AvitoMapPoint component7() {
            return this.g;
        }

        @Nullable
        public final AmenityButtonsState component8() {
            return this.h;
        }

        public final boolean component9() {
            return this.i;
        }

        @NotNull
        public final ItemMapState copy(@Nullable AvitoMapPoint avitoMapPoint, boolean z, @Nullable AvitoMapPoint avitoMapPoint2, @Nullable String str, @Nullable BottomSheetState bottomSheetState, float f2, @Nullable AvitoMapPoint avitoMapPoint3, @Nullable AmenityButtonsState amenityButtonsState, boolean z2, boolean z3, boolean z4, @Nullable String str2) {
            return new ItemMapState(avitoMapPoint, z, avitoMapPoint2, str, bottomSheetState, f2, avitoMapPoint3, amenityButtonsState, z2, z3, z4, str2);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // java.lang.Object
        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ItemMapState)) {
                return false;
            }
            ItemMapState itemMapState = (ItemMapState) obj;
            return Intrinsics.areEqual(this.a, itemMapState.a) && this.b == itemMapState.b && Intrinsics.areEqual(this.c, itemMapState.c) && Intrinsics.areEqual(this.d, itemMapState.d) && Intrinsics.areEqual(this.e, itemMapState.e) && Float.compare(this.f, itemMapState.f) == 0 && Intrinsics.areEqual(this.g, itemMapState.g) && Intrinsics.areEqual(this.h, itemMapState.h) && this.i == itemMapState.i && this.j == itemMapState.j && this.k == itemMapState.k && Intrinsics.areEqual(this.l, itemMapState.l);
        }

        @Nullable
        public final AmenityButtonsState getAmenityButtonsState() {
            return this.h;
        }

        @Nullable
        public final BottomSheetState getBottomSheetState() {
            return this.e;
        }

        @Nullable
        public final String getFromPage() {
            return this.l;
        }

        public final boolean getHasCreateRouteButton() {
            return this.j;
        }

        public final boolean getHasFindMeButton() {
            return this.b;
        }

        @Nullable
        public final AvitoMapPoint getItemCoordinates() {
            return this.a;
        }

        @Nullable
        public final AvitoMapPoint getMapTargetPoint() {
            return this.g;
        }

        public final float getMapZoomLevel() {
            return this.f;
        }

        @Nullable
        public final AvitoMapPoint getMyCoordinates() {
            return this.c;
        }

        public final boolean getShouldTrackMapMovement() {
            return this.k;
        }

        public final boolean getShowMeOnMap() {
            return this.i;
        }

        @Nullable
        public final String getTitle() {
            return this.d;
        }

        @Override // java.lang.Object
        public int hashCode() {
            AvitoMapPoint avitoMapPoint = this.a;
            int i2 = 0;
            int hashCode = (avitoMapPoint != null ? avitoMapPoint.hashCode() : 0) * 31;
            boolean z = this.b;
            int i3 = 1;
            if (z) {
                z = true;
            }
            int i4 = z ? 1 : 0;
            int i5 = z ? 1 : 0;
            int i6 = z ? 1 : 0;
            int i7 = (hashCode + i4) * 31;
            AvitoMapPoint avitoMapPoint2 = this.c;
            int hashCode2 = (i7 + (avitoMapPoint2 != null ? avitoMapPoint2.hashCode() : 0)) * 31;
            String str = this.d;
            int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
            BottomSheetState bottomSheetState = this.e;
            int i1 = a.i1(this.f, (hashCode3 + (bottomSheetState != null ? bottomSheetState.hashCode() : 0)) * 31, 31);
            AvitoMapPoint avitoMapPoint3 = this.g;
            int hashCode4 = (i1 + (avitoMapPoint3 != null ? avitoMapPoint3.hashCode() : 0)) * 31;
            AmenityButtonsState amenityButtonsState = this.h;
            int hashCode5 = (hashCode4 + (amenityButtonsState != null ? amenityButtonsState.hashCode() : 0)) * 31;
            boolean z2 = this.i;
            if (z2) {
                z2 = true;
            }
            int i8 = z2 ? 1 : 0;
            int i9 = z2 ? 1 : 0;
            int i10 = z2 ? 1 : 0;
            int i11 = (hashCode5 + i8) * 31;
            boolean z3 = this.j;
            if (z3) {
                z3 = true;
            }
            int i12 = z3 ? 1 : 0;
            int i13 = z3 ? 1 : 0;
            int i14 = z3 ? 1 : 0;
            int i15 = (i11 + i12) * 31;
            boolean z4 = this.k;
            if (!z4) {
                i3 = z4 ? 1 : 0;
            }
            int i16 = (i15 + i3) * 31;
            String str2 = this.l;
            if (str2 != null) {
                i2 = str2.hashCode();
            }
            return i16 + i2;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("ItemMapState(itemCoordinates=");
            L.append(this.a);
            L.append(", hasFindMeButton=");
            L.append(this.b);
            L.append(", myCoordinates=");
            L.append(this.c);
            L.append(", title=");
            L.append(this.d);
            L.append(", bottomSheetState=");
            L.append(this.e);
            L.append(", mapZoomLevel=");
            L.append(this.f);
            L.append(", mapTargetPoint=");
            L.append(this.g);
            L.append(", amenityButtonsState=");
            L.append(this.h);
            L.append(", showMeOnMap=");
            L.append(this.i);
            L.append(", hasCreateRouteButton=");
            L.append(this.j);
            L.append(", shouldTrackMapMovement=");
            L.append(this.k);
            L.append(", fromPage=");
            return a.t(L, this.l, ")");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i2) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeParcelable(this.a, i2);
            parcel.writeInt(this.b ? 1 : 0);
            parcel.writeParcelable(this.c, i2);
            parcel.writeString(this.d);
            BottomSheetState bottomSheetState = this.e;
            if (bottomSheetState != null) {
                parcel.writeInt(1);
                bottomSheetState.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            parcel.writeFloat(this.f);
            parcel.writeParcelable(this.g, i2);
            AmenityButtonsState amenityButtonsState = this.h;
            if (amenityButtonsState != null) {
                parcel.writeInt(1);
                amenityButtonsState.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            parcel.writeInt(this.i ? 1 : 0);
            parcel.writeInt(this.j ? 1 : 0);
            parcel.writeInt(this.k ? 1 : 0);
            parcel.writeString(this.l);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ItemMapState(AvitoMapPoint avitoMapPoint, boolean z, AvitoMapPoint avitoMapPoint2, String str, BottomSheetState bottomSheetState, float f2, AvitoMapPoint avitoMapPoint3, AmenityButtonsState amenityButtonsState, boolean z2, boolean z3, boolean z4, String str2, int i2, j jVar) {
            this((i2 & 1) != 0 ? null : avitoMapPoint, (i2 & 2) != 0 ? true : z, (i2 & 4) != 0 ? null : avitoMapPoint2, (i2 & 8) != 0 ? null : str, (i2 & 16) != 0 ? null : bottomSheetState, (i2 & 32) != 0 ? 15.0f : f2, (i2 & 64) != 0 ? null : avitoMapPoint3, (i2 & 128) != 0 ? null : amenityButtonsState, (i2 & 256) == 0 ? z2 : true, (i2 & 512) != 0 ? false : z3, (i2 & 1024) == 0 ? z4 : false, (i2 & 2048) == 0 ? str2 : null);
        }
    }

    @Nullable
    List<AvitoMapMarker> addAmenityMarkers(@NotNull List<AvitoMapPoint> list, @NotNull Bitmap bitmap);

    void addItemMarker(@Nullable AvitoMapPoint avitoMapPoint);

    void addUserMarker(@Nullable AvitoMapPoint avitoMapPoint, boolean z, int i);

    @NotNull
    Observable<Unit> backButtonCallback();

    @NotNull
    Observable<BottomSheet.Visibility> bottomSheetCallback();

    void calculateBottomSheetPeekHeight();

    @NotNull
    Observable<AvitoMapPoint> createRouteClicks();

    @NotNull
    Observable<Unit> findMeButtonCallback();

    @NotNull
    View getView();

    int getWhiteColor();

    @NotNull
    Observable<AvitoMapTarget> mapTargetUpdateCallback();

    @NotNull
    Observable<AvitoMapTarget> markerClickCallback();

    void moveToTarget(@Nullable AvitoMapTarget avitoMapTarget);

    void onDestroyMap();

    void onStartMap();

    void onStopMap();

    @NotNull
    Observable<Unit> osmDisclaimerCallback();

    @NotNull
    Observable<Unit> osmTooltipCallback();

    void removeAmenityMarkers(@NotNull List<? extends AvitoMapMarker> list);

    void showError(@StringRes int i, int i2);

    void showFindLocationError();

    void showOsmPopUp();

    void showSnackBarWarning(@StringRes int i);
}
