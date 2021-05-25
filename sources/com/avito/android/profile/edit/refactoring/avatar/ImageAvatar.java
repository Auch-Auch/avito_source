package com.avito.android.profile.edit.refactoring.avatar;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.image_loader.AvitoPictureKt;
import com.avito.android.image_loader.Picture;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.android.util.Parcels;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0018"}, d2 = {"Lcom/avito/android/profile/edit/refactoring/avatar/ImageAvatar;", "Lcom/avito/android/profile/edit/refactoring/avatar/ProfileAvatar;", "Lcom/avito/android/image_loader/Picture;", "getPicture", "()Lcom/avito/android/image_loader/Picture;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", AuthSource.SEND_ABUSE, "Lcom/avito/android/image_loader/Picture;", "picture", "Lcom/avito/android/remote/model/Image;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/Image;", "image", "<init>", "(Lcom/avito/android/remote/model/Image;)V", "Companion", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class ImageAvatar implements ProfileAvatar {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<ImageAvatar> CREATOR = Parcels.creator(a.a);
    @NotNull
    public static final Companion Companion = new Companion(null);
    public final Picture a;
    public final Image b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/profile/edit/refactoring/avatar/ImageAvatar$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/profile/edit/refactoring/avatar/ImageAvatar;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<Parcel, ImageAvatar> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public ImageAvatar invoke(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "$receiver");
            return new ImageAvatar((Image) a2.b.a.a.a.z1(Image.class, parcel2));
        }
    }

    public ImageAvatar(@NotNull Image image) {
        Intrinsics.checkNotNullParameter(image, "image");
        this.b = image;
        this.a = AvitoPictureKt.pictureOf$default(image, true, 0.0f, 0.0f, null, 28, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.avito.android.profile.edit.refactoring.avatar.ProfileAvatar
    @NotNull
    public Picture getPicture() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeParcelable(this.b, i);
    }
}
