package com.avito.android.remote.model.messenger.attach_menu;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.internal.ShareConstants;
import com.google.common.net.HttpHeaders;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \b2\u00020\u0001:\u0005\b\t\n\u000b\fB\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0001\u0004\r\u000e\u000f\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/remote/model/messenger/attach_menu/AttachMenuItem;", "Landroid/os/Parcelable;", "", "getTitle", "()Ljava/lang/String;", "title", "<init>", "()V", "Companion", "File", "Image", "Item", HttpHeaders.LOCATION, "Lcom/avito/android/remote/model/messenger/attach_menu/AttachMenuItem$File;", "Lcom/avito/android/remote/model/messenger/attach_menu/AttachMenuItem$Image;", "Lcom/avito/android/remote/model/messenger/attach_menu/AttachMenuItem$Item;", "Lcom/avito/android/remote/model/messenger/attach_menu/AttachMenuItem$Location;", "models_release"}, k = 1, mv = {1, 4, 2})
public abstract class AttachMenuItem implements Parcelable {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String TITLE = "title";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/remote/model/messenger/attach_menu/AttachMenuItem$Companion;", "", "", ShareConstants.TITLE, "Ljava/lang/String;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\b\b\u0018\u0000 '2\u00020\u0001:\u0001'B!\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b%\u0010&J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ0\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0013J \u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eR\u001c\u0010\u000b\u001a\u00020\u00028\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001f\u001a\u0004\b \u0010\u0004R\u001e\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010!\u001a\u0004\b\"\u0010\u0007R\u001c\u0010\r\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010#\u001a\u0004\b$\u0010\n¨\u0006("}, d2 = {"Lcom/avito/android/remote/model/messenger/attach_menu/AttachMenuItem$File;", "Lcom/avito/android/remote/model/messenger/attach_menu/AttachMenuItem;", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/lang/Long;", "", "component3", "()Z", "title", File.MAX_SIZE_BYTES, "enableForUnanswered", "copy", "(Ljava/lang/String;Ljava/lang/Long;Z)Lcom/avito/android/remote/model/messenger/attach_menu/AttachMenuItem$File;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getTitle", "Ljava/lang/Long;", "getMaxSizeBytes", "Z", "getEnableForUnanswered", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Z)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class File extends AttachMenuItem {
        public static final Parcelable.Creator<File> CREATOR = new Creator();
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        public static final String ENABLE_FOR_UNANSWERED = "enableForUnanswered";
        @NotNull
        public static final String KEY = "file";
        @NotNull
        public static final String MAX_SIZE_BYTES = "maxSizeBytes";
        @SerializedName("enableForUnanswered")
        private final boolean enableForUnanswered;
        @SerializedName(MAX_SIZE_BYTES)
        @Nullable
        private final Long maxSizeBytes;
        @SerializedName("title")
        @NotNull
        private final String title;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004¨\u0006\t"}, d2 = {"Lcom/avito/android/remote/model/messenger/attach_menu/AttachMenuItem$File$Companion;", "", "", "ENABLE_FOR_UNANSWERED", "Ljava/lang/String;", "KEY", "MAX_SIZE_BYTES", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(j jVar) {
                this();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<File> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final File createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new File(parcel.readString(), parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null, parcel.readInt() != 0);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final File[] newArray(int i) {
                return new File[i];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public File(@NotNull String str, @Nullable Long l, boolean z) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "title");
            this.title = str;
            this.maxSizeBytes = l;
            this.enableForUnanswered = z;
        }

        public static /* synthetic */ File copy$default(File file, String str, Long l, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = file.getTitle();
            }
            if ((i & 2) != 0) {
                l = file.maxSizeBytes;
            }
            if ((i & 4) != 0) {
                z = file.enableForUnanswered;
            }
            return file.copy(str, l, z);
        }

        @NotNull
        public final String component1() {
            return getTitle();
        }

        @Nullable
        public final Long component2() {
            return this.maxSizeBytes;
        }

        public final boolean component3() {
            return this.enableForUnanswered;
        }

        @NotNull
        public final File copy(@NotNull String str, @Nullable Long l, boolean z) {
            Intrinsics.checkNotNullParameter(str, "title");
            return new File(str, l, z);
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
            if (!(obj instanceof File)) {
                return false;
            }
            File file = (File) obj;
            return Intrinsics.areEqual(getTitle(), file.getTitle()) && Intrinsics.areEqual(this.maxSizeBytes, file.maxSizeBytes) && this.enableForUnanswered == file.enableForUnanswered;
        }

        public final boolean getEnableForUnanswered() {
            return this.enableForUnanswered;
        }

        @Nullable
        public final Long getMaxSizeBytes() {
            return this.maxSizeBytes;
        }

        @Override // com.avito.android.remote.model.messenger.attach_menu.AttachMenuItem
        @NotNull
        public String getTitle() {
            return this.title;
        }

        @Override // java.lang.Object
        public int hashCode() {
            String title2 = getTitle();
            int i = 0;
            int hashCode = (title2 != null ? title2.hashCode() : 0) * 31;
            Long l = this.maxSizeBytes;
            if (l != null) {
                i = l.hashCode();
            }
            int i2 = (hashCode + i) * 31;
            boolean z = this.enableForUnanswered;
            if (z) {
                z = true;
            }
            int i3 = z ? 1 : 0;
            int i4 = z ? 1 : 0;
            int i5 = z ? 1 : 0;
            return i2 + i3;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("File(title=");
            L.append(getTitle());
            L.append(", maxSizeBytes=");
            L.append(this.maxSizeBytes);
            L.append(", enableForUnanswered=");
            return a.B(L, this.enableForUnanswered, ")");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.title);
            Long l = this.maxSizeBytes;
            if (l != null) {
                a.I0(parcel, 1, l);
            } else {
                parcel.writeInt(0);
            }
            parcel.writeInt(this.enableForUnanswered ? 1 : 0);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\b\u0018\u0000 !2\u00020\u0001:\u0001!B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0014\u0010\u000fJ \u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aR\u001c\u0010\t\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u001b\u001a\u0004\b\u001c\u0010\u0007R\u001c\u0010\b\u001a\u00020\u00028\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\b\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004¨\u0006\""}, d2 = {"Lcom/avito/android/remote/model/messenger/attach_menu/AttachMenuItem$Image;", "Lcom/avito/android/remote/model/messenger/attach_menu/AttachMenuItem;", "", "component1", "()Ljava/lang/String;", "", "component2", "()Z", "title", "enableForUnanswered", "copy", "(Ljava/lang/String;Z)Lcom/avito/android/remote/model/messenger/attach_menu/AttachMenuItem$Image;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Z", "getEnableForUnanswered", "Ljava/lang/String;", "getTitle", "<init>", "(Ljava/lang/String;Z)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Image extends AttachMenuItem {
        public static final Parcelable.Creator<Image> CREATOR = new Creator();
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        public static final String ENABLE_FOR_UNANSWERED = "enableForUnanswered";
        @NotNull
        public static final String KEY = "image";
        @SerializedName("enableForUnanswered")
        private final boolean enableForUnanswered;
        @SerializedName("title")
        @NotNull
        private final String title;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/messenger/attach_menu/AttachMenuItem$Image$Companion;", "", "", "ENABLE_FOR_UNANSWERED", "Ljava/lang/String;", "KEY", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(j jVar) {
                this();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Image> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Image createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Image(parcel.readString(), parcel.readInt() != 0);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Image[] newArray(int i) {
                return new Image[i];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Image(@NotNull String str, boolean z) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "title");
            this.title = str;
            this.enableForUnanswered = z;
        }

        public static /* synthetic */ Image copy$default(Image image, String str, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = image.getTitle();
            }
            if ((i & 2) != 0) {
                z = image.enableForUnanswered;
            }
            return image.copy(str, z);
        }

        @NotNull
        public final String component1() {
            return getTitle();
        }

        public final boolean component2() {
            return this.enableForUnanswered;
        }

        @NotNull
        public final Image copy(@NotNull String str, boolean z) {
            Intrinsics.checkNotNullParameter(str, "title");
            return new Image(str, z);
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
            if (!(obj instanceof Image)) {
                return false;
            }
            Image image = (Image) obj;
            return Intrinsics.areEqual(getTitle(), image.getTitle()) && this.enableForUnanswered == image.enableForUnanswered;
        }

        public final boolean getEnableForUnanswered() {
            return this.enableForUnanswered;
        }

        @Override // com.avito.android.remote.model.messenger.attach_menu.AttachMenuItem
        @NotNull
        public String getTitle() {
            return this.title;
        }

        @Override // java.lang.Object
        public int hashCode() {
            String title2 = getTitle();
            int hashCode = (title2 != null ? title2.hashCode() : 0) * 31;
            boolean z = this.enableForUnanswered;
            if (z) {
                z = true;
            }
            int i = z ? 1 : 0;
            int i2 = z ? 1 : 0;
            int i3 = z ? 1 : 0;
            return hashCode + i;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("Image(title=");
            L.append(getTitle());
            L.append(", enableForUnanswered=");
            return a.B(L, this.enableForUnanswered, ")");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.title);
            parcel.writeInt(this.enableForUnanswered ? 1 : 0);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0011\u0010\u000bJ \u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0005\u001a\u00020\u00028\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004¨\u0006\u001d"}, d2 = {"Lcom/avito/android/remote/model/messenger/attach_menu/AttachMenuItem$Item;", "Lcom/avito/android/remote/model/messenger/attach_menu/AttachMenuItem;", "", "component1", "()Ljava/lang/String;", "title", "copy", "(Ljava/lang/String;)Lcom/avito/android/remote/model/messenger/attach_menu/AttachMenuItem$Item;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getTitle", "<init>", "(Ljava/lang/String;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Item extends AttachMenuItem {
        public static final Parcelable.Creator<Item> CREATOR = new Creator();
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        public static final String KEY = "item";
        @SerializedName("title")
        @NotNull
        private final String title;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/remote/model/messenger/attach_menu/AttachMenuItem$Item$Companion;", "", "", "KEY", "Ljava/lang/String;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(j jVar) {
                this();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Item> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Item createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Item(parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Item[] newArray(int i) {
                return new Item[i];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Item(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "title");
            this.title = str;
        }

        public static /* synthetic */ Item copy$default(Item item, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = item.getTitle();
            }
            return item.copy(str);
        }

        @NotNull
        public final String component1() {
            return getTitle();
        }

        @NotNull
        public final Item copy(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "title");
            return new Item(str);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // java.lang.Object
        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof Item) && Intrinsics.areEqual(getTitle(), ((Item) obj).getTitle());
            }
            return true;
        }

        @Override // com.avito.android.remote.model.messenger.attach_menu.AttachMenuItem
        @NotNull
        public String getTitle() {
            return this.title;
        }

        @Override // java.lang.Object
        public int hashCode() {
            String title2 = getTitle();
            if (title2 != null) {
                return title2.hashCode();
            }
            return 0;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("Item(title=");
            L.append(getTitle());
            L.append(")");
            return L.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.title);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0011\u0010\u000bJ \u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0005\u001a\u00020\u00028\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004¨\u0006\u001d"}, d2 = {"Lcom/avito/android/remote/model/messenger/attach_menu/AttachMenuItem$Location;", "Lcom/avito/android/remote/model/messenger/attach_menu/AttachMenuItem;", "", "component1", "()Ljava/lang/String;", "title", "copy", "(Ljava/lang/String;)Lcom/avito/android/remote/model/messenger/attach_menu/AttachMenuItem$Location;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getTitle", "<init>", "(Ljava/lang/String;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Location extends AttachMenuItem {
        public static final Parcelable.Creator<Location> CREATOR = new Creator();
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        public static final String KEY = "location";
        @SerializedName("title")
        @NotNull
        private final String title;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/remote/model/messenger/attach_menu/AttachMenuItem$Location$Companion;", "", "", "KEY", "Ljava/lang/String;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(j jVar) {
                this();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Location> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Location createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Location(parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Location[] newArray(int i) {
                return new Location[i];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Location(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "title");
            this.title = str;
        }

        public static /* synthetic */ Location copy$default(Location location, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = location.getTitle();
            }
            return location.copy(str);
        }

        @NotNull
        public final String component1() {
            return getTitle();
        }

        @NotNull
        public final Location copy(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "title");
            return new Location(str);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // java.lang.Object
        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof Location) && Intrinsics.areEqual(getTitle(), ((Location) obj).getTitle());
            }
            return true;
        }

        @Override // com.avito.android.remote.model.messenger.attach_menu.AttachMenuItem
        @NotNull
        public String getTitle() {
            return this.title;
        }

        @Override // java.lang.Object
        public int hashCode() {
            String title2 = getTitle();
            if (title2 != null) {
                return title2.hashCode();
            }
            return 0;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("Location(title=");
            L.append(getTitle());
            L.append(")");
            return L.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.title);
        }
    }

    private AttachMenuItem() {
    }

    @NotNull
    public abstract String getTitle();

    public /* synthetic */ AttachMenuItem(j jVar) {
        this();
    }
}
