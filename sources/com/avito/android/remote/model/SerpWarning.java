package com.avito.android.remote.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 *2\u00020\u0001:\u0001*B;\u0012\u0006\u0010&\u001a\u00020!\u0012\u0006\u0010\"\u001a\u00020!\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b¢\u0006\u0004\b(\u0010)J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0018\u0010\u001aR$\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001c\u0010\"\u001a\u00020!8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001c\u0010&\u001a\u00020!8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b&\u0010#\u001a\u0004\b'\u0010%¨\u0006+"}, d2 = {"Lcom/avito/android/remote/model/SerpWarning;", "Lcom/avito/android/remote/model/SerpElement;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "Lcom/avito/android/remote/model/Image;", "image", "Lcom/avito/android/remote/model/Image;", "getImage", "()Lcom/avito/android/remote/model/Image;", "", "uniqueId", "J", "getUniqueId", "()J", "setUniqueId", "(J)V", "", "isCloseable", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "", "Lcom/avito/android/remote/model/Action;", "actions", "Ljava/util/List;", "getActions", "()Ljava/util/List;", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "id", "getId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/avito/android/remote/model/Image;Ljava/util/List;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
public final class SerpWarning implements SerpElement {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<SerpWarning> CREATOR = Parcels.creator(SerpWarning$Companion$CREATOR$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @SerializedName("actions")
    @Nullable
    private final List<Action> actions;
    @SerializedName("id")
    @NotNull
    private final String id;
    @SerializedName("image")
    @Nullable
    private final Image image;
    @SerializedName("isClosable")
    @Nullable
    private final Boolean isCloseable;
    @SerializedName("title")
    @NotNull
    private final String title;
    private long uniqueId;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/SerpWarning$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/SerpWarning;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    public SerpWarning(@NotNull String str, @NotNull String str2, @Nullable Boolean bool, @Nullable Image image2, @Nullable List<Action> list) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        this.id = str;
        this.title = str2;
        this.isCloseable = bool;
        this.image = image2;
        this.actions = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final List<Action> getActions() {
        return this.actions;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final Image getImage() {
        return this.image;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @Override // com.avito.android.remote.model.SerpElement
    public long getUniqueId() {
        return this.uniqueId;
    }

    @Nullable
    public final Boolean isCloseable() {
        return this.isCloseable;
    }

    @Override // com.avito.android.remote.model.SerpElement
    public void setUniqueId(long j) {
        this.uniqueId = j;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(this.id);
        parcel.writeString(this.title);
        ParcelsKt.writeNullableValue(parcel, this.isCloseable);
        parcel.writeParcelable(this.image, i);
        ParcelsKt.writeOptimizedParcelableList(parcel, this.actions, i);
        parcel.writeLong(getUniqueId());
    }
}
