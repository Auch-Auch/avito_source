package com.avito.android.serp.adapter.snippet;

import a2.b.a.a.a;
import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.Image;
import com.avito.android.serp.adapter.PersistableSerpItem;
import com.avito.android.serp.adapter.SerpViewType;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u001a\u001a\u00020\u0015\u0012\u0006\u0010<\u001a\u00020\u001f\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u00101\u001a\u00020,\u0012\u0006\u00107\u001a\u000202\u0012\u0006\u0010?\u001a\u00020\u001f\u0012\u0006\u0010\u001d\u001a\u00020\u000b\u0012\u0014\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001e¢\u0006\u0004\b@\u0010AJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\"\u0010\f\u001a\u00020\u000b8\u0016@\u0016XD¢\u0006\u0012\n\u0004\b\f\u0010\r\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\f\u0010\u000eR\u001c\u0010\u0014\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004R\u001c\u0010\u001a\u001a\u00020\u00158\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\u001d\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\r\u001a\u0004\b\u001c\u0010\u000eR'\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001e8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\"\u0010+\u001a\u00020%8\u0016@\u0016X\u0004¢\u0006\u0012\n\u0004\b&\u0010'\u0012\u0004\b*\u0010\u0010\u001a\u0004\b(\u0010)R\u0019\u00101\u001a\u00020,8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u0019\u00107\u001a\u0002028\u0006@\u0006¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u001c\u0010<\u001a\u00020\u001f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u0019\u0010?\u001a\u00020\u001f8\u0006@\u0006¢\u0006\f\n\u0004\b=\u00109\u001a\u0004\b>\u0010;¨\u0006B"}, d2 = {"Lcom/avito/android/serp/adapter/snippet/SnippetItem;", "Lcom/avito/android/serp/adapter/PersistableSerpItem;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "isExternalAd", "Z", "()Z", "isExternalAd$annotations", "()V", "d", "I", "getSpanCount", "spanCount", "", AuthSource.BOOKING_ORDER, "J", "getId", "()J", "id", "h", "getClosable", "closable", "", "", "i", "Ljava/util/Map;", "getAnalytics", "()Ljava/util/Map;", "analytics", "Lcom/avito/android/serp/adapter/SerpViewType;", AuthSource.SEND_ABUSE, "Lcom/avito/android/serp/adapter/SerpViewType;", "getViewType", "()Lcom/avito/android/serp/adapter/SerpViewType;", "getViewType$annotations", "viewType", "Lcom/avito/android/remote/model/Action;", "e", "Lcom/avito/android/remote/model/Action;", "getAction", "()Lcom/avito/android/remote/model/Action;", "action", "Lcom/avito/android/remote/model/Image;", "f", "Lcom/avito/android/remote/model/Image;", "getImage", "()Lcom/avito/android/remote/model/Image;", "image", "c", "Ljava/lang/String;", "getStringId", "()Ljava/lang/String;", "stringId", g.a, "getText", "text", "<init>", "(JLjava/lang/String;ILcom/avito/android/remote/model/Action;Lcom/avito/android/remote/model/Image;Ljava/lang/String;ZLjava/util/Map;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class SnippetItem implements PersistableSerpItem {
    public static final Parcelable.Creator<SnippetItem> CREATOR = new Creator();
    @NotNull
    public final SerpViewType a = SerpViewType.SINGLE;
    public final long b;
    @NotNull
    public final String c;
    public final int d;
    @NotNull
    public final Action e;
    @NotNull
    public final Image f;
    @NotNull
    public final String g;
    public final boolean h;
    @Nullable
    public final Map<String, String> i;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<SnippetItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SnippetItem createFromParcel(@NotNull Parcel parcel) {
            LinkedHashMap linkedHashMap;
            Intrinsics.checkNotNullParameter(parcel, "in");
            long readLong = parcel.readLong();
            String readString = parcel.readString();
            int readInt = parcel.readInt();
            Action action = (Action) parcel.readParcelable(SnippetItem.class.getClassLoader());
            Image image = (Image) parcel.readParcelable(SnippetItem.class.getClassLoader());
            String readString2 = parcel.readString();
            boolean z = parcel.readInt() != 0;
            if (parcel.readInt() != 0) {
                int readInt2 = parcel.readInt();
                linkedHashMap = new LinkedHashMap(readInt2);
                while (readInt2 != 0) {
                    readInt2 = a.U(parcel, linkedHashMap, parcel.readString(), readInt2, -1);
                }
            } else {
                linkedHashMap = null;
            }
            return new SnippetItem(readLong, readString, readInt, action, image, readString2, z, linkedHashMap);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SnippetItem[] newArray(int i) {
            return new SnippetItem[i];
        }
    }

    public SnippetItem(long j, @NotNull String str, int i2, @NotNull Action action, @NotNull Image image, @NotNull String str2, boolean z, @Nullable Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(str2, "text");
        this.b = j;
        this.c = str;
        this.d = i2;
        this.e = action;
        this.f = image;
        this.g = str2;
        this.h = z;
        this.i = map;
    }

    public static /* synthetic */ void getViewType$annotations() {
    }

    public static /* synthetic */ void isExternalAd$annotations() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final Action getAction() {
        return this.e;
    }

    @Nullable
    public final Map<String, String> getAnalytics() {
        return this.i;
    }

    public final boolean getClosable() {
        return this.h;
    }

    @Override // com.avito.android.serp.adapter.PersistableSerpItem
    public boolean getHasStablePosition() {
        return PersistableSerpItem.DefaultImpls.getHasStablePosition(this);
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return this.b;
    }

    @NotNull
    public final Image getImage() {
        return this.f;
    }

    @Override // com.avito.android.serp.adapter.SpannedItem
    public int getSpanCount() {
        return this.d;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.c;
    }

    @NotNull
    public final String getText() {
        return this.g;
    }

    @Override // com.avito.android.serp.adapter.ViewTypeSerpItem
    @NotNull
    public SerpViewType getViewType() {
        return this.a;
    }

    @Override // com.avito.android.serp.adapter.PersistableSerpItem
    public boolean isExternalAd() {
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [java.util.Map$Entry, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // android.os.Parcelable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void writeToParcel(@org.jetbrains.annotations.NotNull android.os.Parcel r3, int r4) {
        /*
            r2 = this;
            java.lang.String r0 = "parcel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            long r0 = r2.b
            r3.writeLong(r0)
            java.lang.String r0 = r2.c
            r3.writeString(r0)
            int r0 = r2.d
            r3.writeInt(r0)
            com.avito.android.remote.model.Action r0 = r2.e
            r3.writeParcelable(r0, r4)
            com.avito.android.remote.model.Image r0 = r2.f
            r3.writeParcelable(r0, r4)
            java.lang.String r4 = r2.g
            r3.writeString(r4)
            boolean r4 = r2.h
            r3.writeInt(r4)
            java.util.Map<java.lang.String, java.lang.String> r4 = r2.i
            if (r4 == 0) goto L_0x004e
            r0 = 1
            java.util.Iterator r4 = a2.b.a.a.a.m0(r3, r0, r4)
        L_0x0031:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x0052
            java.lang.Object r0 = r4.next()
            java.lang.Object r1 = r0.getKey()
            java.lang.String r1 = (java.lang.String) r1
            r3.writeString(r1)
            java.lang.Object r0 = r0.getValue()
            java.lang.String r0 = (java.lang.String) r0
            r3.writeString(r0)
            goto L_0x0031
        L_0x004e:
            r4 = 0
            r3.writeInt(r4)
        L_0x0052:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.serp.adapter.snippet.SnippetItem.writeToParcel(android.os.Parcel, int):void");
    }
}
