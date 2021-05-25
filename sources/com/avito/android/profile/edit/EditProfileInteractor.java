package com.avito.android.profile.edit;

import a2.b.a.a.a;
import android.net.Uri;
import com.avito.android.krop.util.Transformation;
import com.avito.android.profile.edit.refactoring.adapter.EditProfileItem;
import com.avito.android.profile.edit.refactoring.adapter.item.LocationItem;
import com.avito.android.profile.edit.refactoring.adapter.item.SubLocationItem;
import com.avito.android.profile.edit.refactoring.avatar.ProfileAvatar;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Location;
import com.avito.android.remote.model.NameIdEntity;
import com.avito.android.util.Kundle;
import com.facebook.share.internal.ShareConstants;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\"J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&¢\u0006\u0004\b\t\u0010\nJ'\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00022\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH&¢\u0006\u0004\b\u0010\u0010\u0011J-\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014H&¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H&¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0003H&¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010 \u001a\u00020\u001fH&¢\u0006\u0004\b \u0010!¨\u0006#"}, d2 = {"Lcom/avito/android/profile/edit/EditProfileInteractor;", "", "Lio/reactivex/Observable;", "", "Lcom/avito/android/profile/edit/refactoring/adapter/EditProfileItem;", "loadItems", "()Lio/reactivex/Observable;", "items", "Lcom/avito/android/profile/edit/ProfileSavingResult;", "saveItems", "(Ljava/util/List;)Lio/reactivex/Observable;", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "Lcom/avito/android/krop/util/Transformation;", "transformation", "Lcom/avito/android/profile/edit/refactoring/avatar/ProfileAvatar;", "wrapAvatar", "(Landroid/net/Uri;Lcom/avito/android/krop/util/Transformation;)Lio/reactivex/Observable;", "Lcom/avito/android/remote/model/Location;", "location", "", "subLocationId", "Lcom/avito/android/profile/edit/EditProfileInteractor$LocationItems;", "updateLocation", "(Lcom/avito/android/remote/model/Location;Ljava/lang/String;)Lio/reactivex/Observable;", "", "needToSave", "()Z", "Lcom/avito/android/remote/model/NameIdEntity;", "getSubLocations", "()Ljava/util/List;", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "LocationItems", "profile_release"}, k = 1, mv = {1, 4, 2})
public interface EditProfileInteractor {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Observable updateLocation$default(EditProfileInteractor editProfileInteractor, Location location, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    location = null;
                }
                if ((i & 2) != 0) {
                    str = null;
                }
                return editProfileInteractor.updateLocation(location, str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateLocation");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0007¨\u0006\u001e"}, d2 = {"Lcom/avito/android/profile/edit/EditProfileInteractor$LocationItems;", "", "Lcom/avito/android/profile/edit/refactoring/adapter/item/LocationItem;", "component1", "()Lcom/avito/android/profile/edit/refactoring/adapter/item/LocationItem;", "Lcom/avito/android/profile/edit/refactoring/adapter/item/SubLocationItem;", "component2", "()Lcom/avito/android/profile/edit/refactoring/adapter/item/SubLocationItem;", "location", "subLocation", "copy", "(Lcom/avito/android/profile/edit/refactoring/adapter/item/LocationItem;Lcom/avito/android/profile/edit/refactoring/adapter/item/SubLocationItem;)Lcom/avito/android/profile/edit/EditProfileInteractor$LocationItems;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lcom/avito/android/profile/edit/refactoring/adapter/item/LocationItem;", "getLocation", AuthSource.BOOKING_ORDER, "Lcom/avito/android/profile/edit/refactoring/adapter/item/SubLocationItem;", "getSubLocation", "<init>", "(Lcom/avito/android/profile/edit/refactoring/adapter/item/LocationItem;Lcom/avito/android/profile/edit/refactoring/adapter/item/SubLocationItem;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class LocationItems {
        @NotNull
        public final LocationItem a;
        @Nullable
        public final SubLocationItem b;

        public LocationItems(@NotNull LocationItem locationItem, @Nullable SubLocationItem subLocationItem) {
            Intrinsics.checkNotNullParameter(locationItem, "location");
            this.a = locationItem;
            this.b = subLocationItem;
        }

        public static /* synthetic */ LocationItems copy$default(LocationItems locationItems, LocationItem locationItem, SubLocationItem subLocationItem, int i, Object obj) {
            if ((i & 1) != 0) {
                locationItem = locationItems.a;
            }
            if ((i & 2) != 0) {
                subLocationItem = locationItems.b;
            }
            return locationItems.copy(locationItem, subLocationItem);
        }

        @NotNull
        public final LocationItem component1() {
            return this.a;
        }

        @Nullable
        public final SubLocationItem component2() {
            return this.b;
        }

        @NotNull
        public final LocationItems copy(@NotNull LocationItem locationItem, @Nullable SubLocationItem subLocationItem) {
            Intrinsics.checkNotNullParameter(locationItem, "location");
            return new LocationItems(locationItem, subLocationItem);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LocationItems)) {
                return false;
            }
            LocationItems locationItems = (LocationItems) obj;
            return Intrinsics.areEqual(this.a, locationItems.a) && Intrinsics.areEqual(this.b, locationItems.b);
        }

        @NotNull
        public final LocationItem getLocation() {
            return this.a;
        }

        @Nullable
        public final SubLocationItem getSubLocation() {
            return this.b;
        }

        public int hashCode() {
            LocationItem locationItem = this.a;
            int i = 0;
            int hashCode = (locationItem != null ? locationItem.hashCode() : 0) * 31;
            SubLocationItem subLocationItem = this.b;
            if (subLocationItem != null) {
                i = subLocationItem.hashCode();
            }
            return hashCode + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("LocationItems(location=");
            L.append(this.a);
            L.append(", subLocation=");
            L.append(this.b);
            L.append(")");
            return L.toString();
        }
    }

    @NotNull
    List<NameIdEntity> getSubLocations();

    @NotNull
    Observable<List<EditProfileItem>> loadItems();

    boolean needToSave();

    @NotNull
    Kundle onSaveState();

    @NotNull
    Observable<ProfileSavingResult> saveItems(@NotNull List<? extends EditProfileItem> list);

    @NotNull
    Observable<LocationItems> updateLocation(@Nullable Location location, @Nullable String str);

    @Override // com.avito.android.profile.edit.avatar.AvatarInteractor
    @NotNull
    Observable<ProfileAvatar> wrapAvatar(@NotNull Uri uri, @Nullable Transformation transformation);
}
