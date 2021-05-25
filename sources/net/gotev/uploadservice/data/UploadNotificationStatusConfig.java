package net.gotev.uploadservice.data;

import a2.b.a.a.a;
import a2.g.r.g;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import com.avito.android.remote.auth.AuthSource;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u001e\b\b\u0018\u00002\u00020\u0001Bu\b\u0007\u0012\u0006\u0010\u001d\u001a\u00020\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u0007\u0012\b\b\u0003\u0010\u001f\u001a\u00020\u000b\u0012\b\b\u0003\u0010 \u001a\u00020\u000b\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0004\u0012\u000e\b\u0002\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\b\b\u0002\u0010$\u001a\u00020\u0018\u0012\b\b\u0002\u0010%\u001a\u00020\u0018\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\bO\u0010PJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\n\u0010\tJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\rJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0018HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001aJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u0013J\u0001\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u001d\u001a\u00020\u00072\b\b\u0002\u0010\u001e\u001a\u00020\u00072\b\b\u0003\u0010\u001f\u001a\u00020\u000b2\b\b\u0003\u0010 \u001a\u00020\u000b2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00042\u000e\b\u0002\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\b\b\u0002\u0010$\u001a\u00020\u00182\b\b\u0002\u0010%\u001a\u00020\u00182\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b'\u0010(J\u0010\u0010)\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b)\u0010\tJ\u0010\u0010*\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b*\u0010\rJ\u001a\u0010-\u001a\u00020\u00182\b\u0010,\u001a\u0004\u0018\u00010+HÖ\u0003¢\u0006\u0004\b-\u0010.J\u0010\u0010/\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b/\u0010\rJ \u00104\u001a\u0002032\u0006\u00101\u001a\u0002002\u0006\u00102\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b4\u00105R\u0019\u0010\u001e\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u0010\tR\u0019\u0010 \u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010\rR\u001b\u0010!\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010\u0011R\u0019\u0010%\u001a\u00020\u00188\u0006@\u0006¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010\u001aR\u0019\u0010$\u001a\u00020\u00188\u0006@\u0006¢\u0006\f\n\u0004\bB\u0010@\u001a\u0004\bC\u0010\u001aR\u0019\u0010\u001f\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\bD\u0010:\u001a\u0004\bE\u0010\rR\u0019\u0010\u001d\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\bF\u00107\u001a\u0004\bG\u0010\tR\u001b\u0010\"\u001a\u0004\u0018\u00010\u00048\u0006@\u0006¢\u0006\f\n\u0004\bH\u0010I\u001a\u0004\b\u0005\u0010\u0013R\u001f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0006@\u0006¢\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010\u0017R\u001b\u0010&\u001a\u0004\u0018\u00010\u00048\u0006@\u0006¢\u0006\f\n\u0004\bM\u0010I\u001a\u0004\bN\u0010\u0013¨\u0006Q"}, d2 = {"Lnet/gotev/uploadservice/data/UploadNotificationStatusConfig;", "Landroid/os/Parcelable;", "Landroid/content/Context;", "context", "Landroid/app/PendingIntent;", "getClickIntent", "(Landroid/content/Context;)Landroid/app/PendingIntent;", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()I", "component4", "Landroid/graphics/Bitmap;", "component5", "()Landroid/graphics/Bitmap;", "component6", "()Landroid/app/PendingIntent;", "Ljava/util/ArrayList;", "Lnet/gotev/uploadservice/data/UploadNotificationAction;", "component7", "()Ljava/util/ArrayList;", "", "component8", "()Z", "component9", "component10", "title", "message", "iconResourceID", "iconColorResourceID", "largeIcon", "clickIntent", "actions", "clearOnAction", "autoClear", "onDismissed", "copy", "(Ljava/lang/String;Ljava/lang/String;IILandroid/graphics/Bitmap;Landroid/app/PendingIntent;Ljava/util/ArrayList;ZZLandroid/app/PendingIntent;)Lnet/gotev/uploadservice/data/UploadNotificationStatusConfig;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getMessage", "d", "I", "getIconColorResourceID", "e", "Landroid/graphics/Bitmap;", "getLargeIcon", "i", "Z", "getAutoClear", "h", "getClearOnAction", "c", "getIconResourceID", AuthSource.SEND_ABUSE, "getTitle", "f", "Landroid/app/PendingIntent;", g.a, "Ljava/util/ArrayList;", "getActions", "j", "getOnDismissed", "<init>", "(Ljava/lang/String;Ljava/lang/String;IILandroid/graphics/Bitmap;Landroid/app/PendingIntent;Ljava/util/ArrayList;ZZLandroid/app/PendingIntent;)V", "uploadservice_release"}, k = 1, mv = {1, 4, 0})
public final class UploadNotificationStatusConfig implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    public final int c;
    public final int d;
    @Nullable
    public final Bitmap e;
    @Nullable
    public final PendingIntent f;
    @NotNull
    public final ArrayList<UploadNotificationAction> g;
    public final boolean h;
    public final boolean i;
    @Nullable
    public final PendingIntent j;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public static class Creator implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Object createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            int readInt = parcel.readInt();
            int readInt2 = parcel.readInt();
            Bitmap bitmap = parcel.readInt() != 0 ? (Bitmap) Bitmap.CREATOR.createFromParcel(parcel) : null;
            PendingIntent pendingIntent = parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null;
            int readInt3 = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt3);
            while (readInt3 != 0) {
                arrayList.add((UploadNotificationAction) UploadNotificationAction.CREATOR.createFromParcel(parcel));
                readInt3--;
            }
            boolean z = true;
            boolean z2 = parcel.readInt() != 0;
            if (parcel.readInt() == 0) {
                z = false;
            }
            return new UploadNotificationStatusConfig(readString, readString2, readInt, readInt2, bitmap, pendingIntent, arrayList, z2, z, parcel.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel) : null);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Object[] newArray(int i) {
            return new UploadNotificationStatusConfig[i];
        }
    }

    @JvmOverloads
    public UploadNotificationStatusConfig(@NotNull String str, @NotNull String str2) {
        this(str, str2, 0, 0, null, null, null, false, false, null, 1020, null);
    }

    @JvmOverloads
    public UploadNotificationStatusConfig(@NotNull String str, @NotNull String str2, @DrawableRes int i2) {
        this(str, str2, i2, 0, null, null, null, false, false, null, 1016, null);
    }

    @JvmOverloads
    public UploadNotificationStatusConfig(@NotNull String str, @NotNull String str2, @DrawableRes int i2, @ColorInt int i3) {
        this(str, str2, i2, i3, null, null, null, false, false, null, 1008, null);
    }

    @JvmOverloads
    public UploadNotificationStatusConfig(@NotNull String str, @NotNull String str2, @DrawableRes int i2, @ColorInt int i3, @Nullable Bitmap bitmap) {
        this(str, str2, i2, i3, bitmap, null, null, false, false, null, 992, null);
    }

    @JvmOverloads
    public UploadNotificationStatusConfig(@NotNull String str, @NotNull String str2, @DrawableRes int i2, @ColorInt int i3, @Nullable Bitmap bitmap, @Nullable PendingIntent pendingIntent) {
        this(str, str2, i2, i3, bitmap, pendingIntent, null, false, false, null, 960, null);
    }

    @JvmOverloads
    public UploadNotificationStatusConfig(@NotNull String str, @NotNull String str2, @DrawableRes int i2, @ColorInt int i3, @Nullable Bitmap bitmap, @Nullable PendingIntent pendingIntent, @NotNull ArrayList<UploadNotificationAction> arrayList) {
        this(str, str2, i2, i3, bitmap, pendingIntent, arrayList, false, false, null, 896, null);
    }

    @JvmOverloads
    public UploadNotificationStatusConfig(@NotNull String str, @NotNull String str2, @DrawableRes int i2, @ColorInt int i3, @Nullable Bitmap bitmap, @Nullable PendingIntent pendingIntent, @NotNull ArrayList<UploadNotificationAction> arrayList, boolean z) {
        this(str, str2, i2, i3, bitmap, pendingIntent, arrayList, z, false, null, 768, null);
    }

    @JvmOverloads
    public UploadNotificationStatusConfig(@NotNull String str, @NotNull String str2, @DrawableRes int i2, @ColorInt int i3, @Nullable Bitmap bitmap, @Nullable PendingIntent pendingIntent, @NotNull ArrayList<UploadNotificationAction> arrayList, boolean z, boolean z2) {
        this(str, str2, i2, i3, bitmap, pendingIntent, arrayList, z, z2, null, 512, null);
    }

    @JvmOverloads
    public UploadNotificationStatusConfig(@NotNull String str, @NotNull String str2, @DrawableRes int i2, @ColorInt int i3, @Nullable Bitmap bitmap, @Nullable PendingIntent pendingIntent, @NotNull ArrayList<UploadNotificationAction> arrayList, boolean z, boolean z2, @Nullable PendingIntent pendingIntent2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "message");
        Intrinsics.checkNotNullParameter(arrayList, "actions");
        this.a = str;
        this.b = str2;
        this.c = i2;
        this.d = i3;
        this.e = bitmap;
        this.f = pendingIntent;
        this.g = arrayList;
        this.h = z;
        this.i = z2;
        this.j = pendingIntent2;
    }

    public static /* synthetic */ UploadNotificationStatusConfig copy$default(UploadNotificationStatusConfig uploadNotificationStatusConfig, String str, String str2, int i2, int i3, Bitmap bitmap, PendingIntent pendingIntent, ArrayList arrayList, boolean z, boolean z2, PendingIntent pendingIntent2, int i4, Object obj) {
        return uploadNotificationStatusConfig.copy((i4 & 1) != 0 ? uploadNotificationStatusConfig.a : str, (i4 & 2) != 0 ? uploadNotificationStatusConfig.b : str2, (i4 & 4) != 0 ? uploadNotificationStatusConfig.c : i2, (i4 & 8) != 0 ? uploadNotificationStatusConfig.d : i3, (i4 & 16) != 0 ? uploadNotificationStatusConfig.e : bitmap, (i4 & 32) != 0 ? uploadNotificationStatusConfig.f : pendingIntent, (i4 & 64) != 0 ? uploadNotificationStatusConfig.g : arrayList, (i4 & 128) != 0 ? uploadNotificationStatusConfig.h : z, (i4 & 256) != 0 ? uploadNotificationStatusConfig.i : z2, (i4 & 512) != 0 ? uploadNotificationStatusConfig.j : pendingIntent2);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    @Nullable
    public final PendingIntent component10() {
        return this.j;
    }

    @NotNull
    public final String component2() {
        return this.b;
    }

    public final int component3() {
        return this.c;
    }

    public final int component4() {
        return this.d;
    }

    @Nullable
    public final Bitmap component5() {
        return this.e;
    }

    @Nullable
    public final PendingIntent component6() {
        return this.f;
    }

    @NotNull
    public final ArrayList<UploadNotificationAction> component7() {
        return this.g;
    }

    public final boolean component8() {
        return this.h;
    }

    public final boolean component9() {
        return this.i;
    }

    @NotNull
    public final UploadNotificationStatusConfig copy(@NotNull String str, @NotNull String str2, @DrawableRes int i2, @ColorInt int i3, @Nullable Bitmap bitmap, @Nullable PendingIntent pendingIntent, @NotNull ArrayList<UploadNotificationAction> arrayList, boolean z, boolean z2, @Nullable PendingIntent pendingIntent2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "message");
        Intrinsics.checkNotNullParameter(arrayList, "actions");
        return new UploadNotificationStatusConfig(str, str2, i2, i3, bitmap, pendingIntent, arrayList, z, z2, pendingIntent2);
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
        if (!(obj instanceof UploadNotificationStatusConfig)) {
            return false;
        }
        UploadNotificationStatusConfig uploadNotificationStatusConfig = (UploadNotificationStatusConfig) obj;
        return Intrinsics.areEqual(this.a, uploadNotificationStatusConfig.a) && Intrinsics.areEqual(this.b, uploadNotificationStatusConfig.b) && this.c == uploadNotificationStatusConfig.c && this.d == uploadNotificationStatusConfig.d && Intrinsics.areEqual(this.e, uploadNotificationStatusConfig.e) && Intrinsics.areEqual(this.f, uploadNotificationStatusConfig.f) && Intrinsics.areEqual(this.g, uploadNotificationStatusConfig.g) && this.h == uploadNotificationStatusConfig.h && this.i == uploadNotificationStatusConfig.i && Intrinsics.areEqual(this.j, uploadNotificationStatusConfig.j);
    }

    @NotNull
    public final ArrayList<UploadNotificationAction> getActions() {
        return this.g;
    }

    public final boolean getAutoClear() {
        return this.i;
    }

    public final boolean getClearOnAction() {
        return this.h;
    }

    @Nullable
    public final PendingIntent getClickIntent() {
        return this.f;
    }

    public final int getIconColorResourceID() {
        return this.d;
    }

    public final int getIconResourceID() {
        return this.c;
    }

    @Nullable
    public final Bitmap getLargeIcon() {
        return this.e;
    }

    @NotNull
    public final String getMessage() {
        return this.b;
    }

    @Nullable
    public final PendingIntent getOnDismissed() {
        return this.j;
    }

    @NotNull
    public final String getTitle() {
        return this.a;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.a;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        int hashCode2 = (((((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.c) * 31) + this.d) * 31;
        Bitmap bitmap = this.e;
        int hashCode3 = (hashCode2 + (bitmap != null ? bitmap.hashCode() : 0)) * 31;
        PendingIntent pendingIntent = this.f;
        int hashCode4 = (hashCode3 + (pendingIntent != null ? pendingIntent.hashCode() : 0)) * 31;
        ArrayList<UploadNotificationAction> arrayList = this.g;
        int hashCode5 = (hashCode4 + (arrayList != null ? arrayList.hashCode() : 0)) * 31;
        boolean z = this.h;
        int i3 = 1;
        if (z) {
            z = true;
        }
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = z ? 1 : 0;
        int i7 = (hashCode5 + i4) * 31;
        boolean z2 = this.i;
        if (!z2) {
            i3 = z2 ? 1 : 0;
        }
        int i8 = (i7 + i3) * 31;
        PendingIntent pendingIntent2 = this.j;
        if (pendingIntent2 != null) {
            i2 = pendingIntent2.hashCode();
        }
        return i8 + i2;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("UploadNotificationStatusConfig(title=");
        L.append(this.a);
        L.append(", message=");
        L.append(this.b);
        L.append(", iconResourceID=");
        L.append(this.c);
        L.append(", iconColorResourceID=");
        L.append(this.d);
        L.append(", largeIcon=");
        L.append(this.e);
        L.append(", clickIntent=");
        L.append(this.f);
        L.append(", actions=");
        L.append(this.g);
        L.append(", clearOnAction=");
        L.append(this.h);
        L.append(", autoClear=");
        L.append(this.i);
        L.append(", onDismissed=");
        L.append(this.j);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
        Bitmap bitmap = this.e;
        if (bitmap != null) {
            parcel.writeInt(1);
            bitmap.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        PendingIntent pendingIntent = this.f;
        if (pendingIntent != null) {
            parcel.writeInt(1);
            pendingIntent.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        ArrayList<UploadNotificationAction> arrayList = this.g;
        parcel.writeInt(arrayList.size());
        for (UploadNotificationAction uploadNotificationAction : arrayList) {
            uploadNotificationAction.writeToParcel(parcel, 0);
        }
        parcel.writeInt(this.h ? 1 : 0);
        parcel.writeInt(this.i ? 1 : 0);
        PendingIntent pendingIntent2 = this.j;
        if (pendingIntent2 != null) {
            parcel.writeInt(1);
            pendingIntent2.writeToParcel(parcel, 0);
            return;
        }
        parcel.writeInt(0);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UploadNotificationStatusConfig(String str, String str2, int i2, int i3, Bitmap bitmap, PendingIntent pendingIntent, ArrayList arrayList, boolean z, boolean z2, PendingIntent pendingIntent2, int i4, j jVar) {
        this(str, str2, (i4 & 4) != 0 ? 17301589 : i2, (i4 & 8) != 0 ? 0 : i3, (i4 & 16) != 0 ? null : bitmap, (i4 & 32) != 0 ? null : pendingIntent, (i4 & 64) != 0 ? new ArrayList(3) : arrayList, (i4 & 128) != 0 ? false : z, (i4 & 256) != 0 ? false : z2, (i4 & 512) != 0 ? null : pendingIntent2);
    }

    @NotNull
    public final PendingIntent getClickIntent(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        PendingIntent pendingIntent = this.f;
        if (pendingIntent != null) {
            return pendingIntent;
        }
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, new Intent(), 134217728);
        Intrinsics.checkNotNullExpressionValue(broadcast, "PendingIntent.getBroadca…_UPDATE_CURRENT\n        )");
        return broadcast;
    }
}
