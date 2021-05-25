package com.avito.android.remote.model.messenger.attach_menu;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.messenger.attach_menu.AttachMenuItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b.\u0010/J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ@\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u001f\u0010\u0019J \u0010$\u001a\u00020#2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b$\u0010%R\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010&\u001a\u0004\b'\u0010\u0004R\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010(\u001a\u0004\b)\u0010\rR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010*\u001a\u0004\b+\u0010\u0007R\u001b\u0010\u0010\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010,\u001a\u0004\b-\u0010\n¨\u00060"}, d2 = {"Lcom/avito/android/remote/model/messenger/attach_menu/AttachMenu;", "Landroid/os/Parcelable;", "Lcom/avito/android/remote/model/messenger/attach_menu/AttachMenuItem$File;", "component1", "()Lcom/avito/android/remote/model/messenger/attach_menu/AttachMenuItem$File;", "Lcom/avito/android/remote/model/messenger/attach_menu/AttachMenuItem$Image;", "component2", "()Lcom/avito/android/remote/model/messenger/attach_menu/AttachMenuItem$Image;", "Lcom/avito/android/remote/model/messenger/attach_menu/AttachMenuItem$Item;", "component3", "()Lcom/avito/android/remote/model/messenger/attach_menu/AttachMenuItem$Item;", "Lcom/avito/android/remote/model/messenger/attach_menu/AttachMenuItem$Location;", "component4", "()Lcom/avito/android/remote/model/messenger/attach_menu/AttachMenuItem$Location;", "file", "image", "item", "location", "copy", "(Lcom/avito/android/remote/model/messenger/attach_menu/AttachMenuItem$File;Lcom/avito/android/remote/model/messenger/attach_menu/AttachMenuItem$Image;Lcom/avito/android/remote/model/messenger/attach_menu/AttachMenuItem$Item;Lcom/avito/android/remote/model/messenger/attach_menu/AttachMenuItem$Location;)Lcom/avito/android/remote/model/messenger/attach_menu/AttachMenu;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/messenger/attach_menu/AttachMenuItem$File;", "getFile", "Lcom/avito/android/remote/model/messenger/attach_menu/AttachMenuItem$Location;", "getLocation", "Lcom/avito/android/remote/model/messenger/attach_menu/AttachMenuItem$Image;", "getImage", "Lcom/avito/android/remote/model/messenger/attach_menu/AttachMenuItem$Item;", "getItem", "<init>", "(Lcom/avito/android/remote/model/messenger/attach_menu/AttachMenuItem$File;Lcom/avito/android/remote/model/messenger/attach_menu/AttachMenuItem$Image;Lcom/avito/android/remote/model/messenger/attach_menu/AttachMenuItem$Item;Lcom/avito/android/remote/model/messenger/attach_menu/AttachMenuItem$Location;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class AttachMenu implements Parcelable {
    public static final Parcelable.Creator<AttachMenu> CREATOR = new Creator();
    @Nullable
    private final AttachMenuItem.File file;
    @Nullable
    private final AttachMenuItem.Image image;
    @Nullable
    private final AttachMenuItem.Item item;
    @Nullable
    private final AttachMenuItem.Location location;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<AttachMenu> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AttachMenu createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            AttachMenuItem.Location location = null;
            AttachMenuItem.File createFromParcel = parcel.readInt() != 0 ? AttachMenuItem.File.CREATOR.createFromParcel(parcel) : null;
            AttachMenuItem.Image createFromParcel2 = parcel.readInt() != 0 ? AttachMenuItem.Image.CREATOR.createFromParcel(parcel) : null;
            AttachMenuItem.Item createFromParcel3 = parcel.readInt() != 0 ? AttachMenuItem.Item.CREATOR.createFromParcel(parcel) : null;
            if (parcel.readInt() != 0) {
                location = AttachMenuItem.Location.CREATOR.createFromParcel(parcel);
            }
            return new AttachMenu(createFromParcel, createFromParcel2, createFromParcel3, location);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AttachMenu[] newArray(int i) {
            return new AttachMenu[i];
        }
    }

    public AttachMenu(@Nullable AttachMenuItem.File file2, @Nullable AttachMenuItem.Image image2, @Nullable AttachMenuItem.Item item2, @Nullable AttachMenuItem.Location location2) {
        this.file = file2;
        this.image = image2;
        this.item = item2;
        this.location = location2;
    }

    public static /* synthetic */ AttachMenu copy$default(AttachMenu attachMenu, AttachMenuItem.File file2, AttachMenuItem.Image image2, AttachMenuItem.Item item2, AttachMenuItem.Location location2, int i, Object obj) {
        if ((i & 1) != 0) {
            file2 = attachMenu.file;
        }
        if ((i & 2) != 0) {
            image2 = attachMenu.image;
        }
        if ((i & 4) != 0) {
            item2 = attachMenu.item;
        }
        if ((i & 8) != 0) {
            location2 = attachMenu.location;
        }
        return attachMenu.copy(file2, image2, item2, location2);
    }

    @Nullable
    public final AttachMenuItem.File component1() {
        return this.file;
    }

    @Nullable
    public final AttachMenuItem.Image component2() {
        return this.image;
    }

    @Nullable
    public final AttachMenuItem.Item component3() {
        return this.item;
    }

    @Nullable
    public final AttachMenuItem.Location component4() {
        return this.location;
    }

    @NotNull
    public final AttachMenu copy(@Nullable AttachMenuItem.File file2, @Nullable AttachMenuItem.Image image2, @Nullable AttachMenuItem.Item item2, @Nullable AttachMenuItem.Location location2) {
        return new AttachMenu(file2, image2, item2, location2);
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
        if (!(obj instanceof AttachMenu)) {
            return false;
        }
        AttachMenu attachMenu = (AttachMenu) obj;
        return Intrinsics.areEqual(this.file, attachMenu.file) && Intrinsics.areEqual(this.image, attachMenu.image) && Intrinsics.areEqual(this.item, attachMenu.item) && Intrinsics.areEqual(this.location, attachMenu.location);
    }

    @Nullable
    public final AttachMenuItem.File getFile() {
        return this.file;
    }

    @Nullable
    public final AttachMenuItem.Image getImage() {
        return this.image;
    }

    @Nullable
    public final AttachMenuItem.Item getItem() {
        return this.item;
    }

    @Nullable
    public final AttachMenuItem.Location getLocation() {
        return this.location;
    }

    @Override // java.lang.Object
    public int hashCode() {
        AttachMenuItem.File file2 = this.file;
        int i = 0;
        int hashCode = (file2 != null ? file2.hashCode() : 0) * 31;
        AttachMenuItem.Image image2 = this.image;
        int hashCode2 = (hashCode + (image2 != null ? image2.hashCode() : 0)) * 31;
        AttachMenuItem.Item item2 = this.item;
        int hashCode3 = (hashCode2 + (item2 != null ? item2.hashCode() : 0)) * 31;
        AttachMenuItem.Location location2 = this.location;
        if (location2 != null) {
            i = location2.hashCode();
        }
        return hashCode3 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("AttachMenu(file=");
        L.append(this.file);
        L.append(", image=");
        L.append(this.image);
        L.append(", item=");
        L.append(this.item);
        L.append(", location=");
        L.append(this.location);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        AttachMenuItem.File file2 = this.file;
        if (file2 != null) {
            parcel.writeInt(1);
            file2.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        AttachMenuItem.Image image2 = this.image;
        if (image2 != null) {
            parcel.writeInt(1);
            image2.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        AttachMenuItem.Item item2 = this.item;
        if (item2 != null) {
            parcel.writeInt(1);
            item2.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        AttachMenuItem.Location location2 = this.location;
        if (location2 != null) {
            parcel.writeInt(1);
            location2.writeToParcel(parcel, 0);
            return;
        }
        parcel.writeInt(0);
    }
}
