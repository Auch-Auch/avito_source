package com.avito.android.remote.model.serp;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.SerpElement;
import com.google.gson.annotations.SerializedName;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u001f\u001a\u00020\f\u0012\u0006\u0010\u0016\u001a\u00020\f\u0012\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\b\b\u0002\u0010\"\u001a\u00020!¢\u0006\u0004\b(\u0010)J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR*\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u00020\u00118\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u00020\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001b\u001a\u00020\u001a8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u00020\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u0017\u001a\u0004\b \u0010\u0019R\"\u0010\"\u001a\u00020!8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006*"}, d2 = {"Lcom/avito/android/remote/model/serp/Snippet;", "Lcom/avito/android/remote/model/SerpElement;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "", "analytics", "Ljava/util/Map;", "getAnalytics", "()Ljava/util/Map;", "Lcom/avito/android/remote/model/Action;", "action", "Lcom/avito/android/remote/model/Action;", "getAction", "()Lcom/avito/android/remote/model/Action;", "text", "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/Image;", "image", "Lcom/avito/android/remote/model/Image;", "getImage", "()Lcom/avito/android/remote/model/Image;", "id", "getId", "", "uniqueId", "J", "getUniqueId", "()J", "setUniqueId", "(J)V", "<init>", "(Lcom/avito/android/remote/model/Action;Lcom/avito/android/remote/model/Image;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;J)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class Snippet implements SerpElement {
    public static final Parcelable.Creator<Snippet> CREATOR = new Creator();
    @SerializedName("action")
    @NotNull
    private final Action action;
    @SerializedName("analytics")
    @Nullable
    private final Map<String, String> analytics;
    @SerializedName("id")
    @NotNull
    private final String id;
    @SerializedName("image")
    @NotNull
    private final Image image;
    @SerializedName("text")
    @NotNull
    private final String text;
    private long uniqueId;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<Snippet> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Snippet createFromParcel(@NotNull Parcel parcel) {
            LinkedHashMap linkedHashMap;
            Intrinsics.checkNotNullParameter(parcel, "in");
            Action action = (Action) parcel.readParcelable(Snippet.class.getClassLoader());
            Image image = (Image) parcel.readParcelable(Snippet.class.getClassLoader());
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                linkedHashMap = new LinkedHashMap(readInt);
                while (readInt != 0) {
                    readInt = a.U(parcel, linkedHashMap, parcel.readString(), readInt, -1);
                }
            } else {
                linkedHashMap = null;
            }
            return new Snippet(action, image, readString, readString2, linkedHashMap, parcel.readLong());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Snippet[] newArray(int i) {
            return new Snippet[i];
        }
    }

    public Snippet(@NotNull Action action2, @NotNull Image image2, @NotNull String str, @NotNull String str2, @Nullable Map<String, String> map, long j) {
        Intrinsics.checkNotNullParameter(action2, "action");
        Intrinsics.checkNotNullParameter(image2, "image");
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "text");
        this.action = action2;
        this.image = image2;
        this.id = str;
        this.text = str2;
        this.analytics = map;
        this.uniqueId = j;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final Action getAction() {
        return this.action;
    }

    @Nullable
    public final Map<String, String> getAnalytics() {
        return this.analytics;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final Image getImage() {
        return this.image;
    }

    @NotNull
    public final String getText() {
        return this.text;
    }

    @Override // com.avito.android.remote.model.SerpElement
    public long getUniqueId() {
        return this.uniqueId;
    }

    @Override // com.avito.android.remote.model.SerpElement
    public void setUniqueId(long j) {
        this.uniqueId = j;
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [java.util.Map$Entry, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // android.os.Parcelable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void writeToParcel(@org.jetbrains.annotations.NotNull android.os.Parcel r3, int r4) {
        /*
            r2 = this;
            java.lang.String r0 = "parcel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            com.avito.android.remote.model.Action r0 = r2.action
            r3.writeParcelable(r0, r4)
            com.avito.android.remote.model.Image r0 = r2.image
            r3.writeParcelable(r0, r4)
            java.lang.String r4 = r2.id
            r3.writeString(r4)
            java.lang.String r4 = r2.text
            r3.writeString(r4)
            java.util.Map<java.lang.String, java.lang.String> r4 = r2.analytics
            if (r4 == 0) goto L_0x003f
            r0 = 1
            java.util.Iterator r4 = a2.b.a.a.a.m0(r3, r0, r4)
        L_0x0022:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x0043
            java.lang.Object r0 = r4.next()
            java.lang.Object r1 = r0.getKey()
            java.lang.String r1 = (java.lang.String) r1
            r3.writeString(r1)
            java.lang.Object r0 = r0.getValue()
            java.lang.String r0 = (java.lang.String) r0
            r3.writeString(r0)
            goto L_0x0022
        L_0x003f:
            r4 = 0
            r3.writeInt(r4)
        L_0x0043:
            long r0 = r2.uniqueId
            r3.writeLong(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.remote.model.serp.Snippet.writeToParcel(android.os.Parcel, int):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Snippet(Action action2, Image image2, String str, String str2, Map map, long j, int i, j jVar) {
        this(action2, image2, str, str2, map, (i & 32) != 0 ? 0 : j);
    }
}
