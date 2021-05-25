package com.avito.android.profile.edit.refactoring.adapter;

import android.os.Parcelable;
import com.avito.konveyor.blueprint.Item;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"Lcom/avito/android/profile/edit/refactoring/adapter/EditProfileItem;", "Landroid/os/Parcelable;", "Lcom/avito/konveyor/blueprint/Item;", "", "describeContents", "()I", "", "hasTopDivider", "()Z", "hasBottomDivider", "profile_release"}, k = 1, mv = {1, 4, 2})
public interface EditProfileItem extends Parcelable, Item {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static int describeContents(@NotNull EditProfileItem editProfileItem) {
            return 0;
        }

        public static boolean hasBottomDivider(@NotNull EditProfileItem editProfileItem) {
            return true;
        }

        public static boolean hasTopDivider(@NotNull EditProfileItem editProfileItem) {
            return true;
        }
    }

    @Override // android.os.Parcelable
    int describeContents();

    boolean hasBottomDivider();

    boolean hasTopDivider();
}
