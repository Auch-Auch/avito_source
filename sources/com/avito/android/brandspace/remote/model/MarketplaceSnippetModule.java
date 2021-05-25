package com.avito.android.brandspace.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.remote.model.Action;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0010\b\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\b\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u0017\u001a\u00020\u000f¢\u0006\u0004\b3\u00104J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0007J\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J`\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\u0016\b\u0002\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u0017\u001a\u00020\u000fHÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0007J\u0010\u0010\u001b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0004J\u001a\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÖ\u0003¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b!\u0010\u0004J \u0010&\u001a\u00020%2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b&\u0010'R\u0019\u0010\u0012\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010(\u001a\u0004\b)\u0010\u0004R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010*\u001a\u0004\b+\u0010\u0007R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010,\u001a\u0004\b-\u0010\u000eR\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010*\u001a\u0004\b.\u0010\u0007R\u0019\u0010\u0017\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010/\u001a\u0004\b0\u0010\u0011R'\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u00101\u001a\u0004\b2\u0010\n¨\u00065"}, d2 = {"Lcom/avito/android/brandspace/remote/model/MarketplaceSnippetModule;", "Lcom/avito/android/brandspace/remote/model/BrandspaceElement;", "", "component1", "()I", "", "component2", "()Ljava/lang/String;", "", "component3", "()Ljava/util/Map;", "component4", "Lcom/avito/android/remote/model/Action;", "component5", "()Lcom/avito/android/remote/model/Action;", "Lcom/avito/android/brandspace/remote/model/ItemsShow;", "component6", "()Lcom/avito/android/brandspace/remote/model/ItemsShow;", "version", "title", ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, "link", "action", "type", "copy", "(ILjava/lang/String;Ljava/util/Map;Ljava/lang/String;Lcom/avito/android/remote/model/Action;Lcom/avito/android/brandspace/remote/model/ItemsShow;)Lcom/avito/android/brandspace/remote/model/MarketplaceSnippetModule;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "I", "getVersion", "Ljava/lang/String;", "getLink", "Lcom/avito/android/remote/model/Action;", "getAction", "getTitle", "Lcom/avito/android/brandspace/remote/model/ItemsShow;", "getType", "Ljava/util/Map;", "getParameters", "<init>", "(ILjava/lang/String;Ljava/util/Map;Ljava/lang/String;Lcom/avito/android/remote/model/Action;Lcom/avito/android/brandspace/remote/model/ItemsShow;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class MarketplaceSnippetModule implements BrandspaceElement {
    public static final Parcelable.Creator<MarketplaceSnippetModule> CREATOR = new Creator();
    @Nullable
    private final Action action;
    @Nullable
    private final String link;
    @Nullable
    private final Map<String, String> parameters;
    @Nullable
    private final String title;
    @NotNull
    private final ItemsShow type;
    private final int version;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<MarketplaceSnippetModule> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MarketplaceSnippetModule createFromParcel(@NotNull Parcel parcel) {
            LinkedHashMap linkedHashMap;
            Intrinsics.checkNotNullParameter(parcel, "in");
            int readInt = parcel.readInt();
            String readString = parcel.readString();
            if (parcel.readInt() != 0) {
                int readInt2 = parcel.readInt();
                linkedHashMap = new LinkedHashMap(readInt2);
                while (readInt2 != 0) {
                    readInt2 = a.U(parcel, linkedHashMap, parcel.readString(), readInt2, -1);
                }
            } else {
                linkedHashMap = null;
            }
            return new MarketplaceSnippetModule(readInt, readString, linkedHashMap, parcel.readString(), (Action) parcel.readParcelable(MarketplaceSnippetModule.class.getClassLoader()), (ItemsShow) Enum.valueOf(ItemsShow.class, parcel.readString()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MarketplaceSnippetModule[] newArray(int i) {
            return new MarketplaceSnippetModule[i];
        }
    }

    public MarketplaceSnippetModule(int i, @Nullable String str, @Nullable Map<String, String> map, @Nullable String str2, @Nullable Action action2, @NotNull ItemsShow itemsShow) {
        Intrinsics.checkNotNullParameter(itemsShow, "type");
        this.version = i;
        this.title = str;
        this.parameters = map;
        this.link = str2;
        this.action = action2;
        this.type = itemsShow;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.avito.android.brandspace.remote.model.MarketplaceSnippetModule */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MarketplaceSnippetModule copy$default(MarketplaceSnippetModule marketplaceSnippetModule, int i, String str, Map map, String str2, Action action2, ItemsShow itemsShow, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = marketplaceSnippetModule.version;
        }
        if ((i2 & 2) != 0) {
            str = marketplaceSnippetModule.title;
        }
        if ((i2 & 4) != 0) {
            map = marketplaceSnippetModule.parameters;
        }
        if ((i2 & 8) != 0) {
            str2 = marketplaceSnippetModule.link;
        }
        if ((i2 & 16) != 0) {
            action2 = marketplaceSnippetModule.action;
        }
        if ((i2 & 32) != 0) {
            itemsShow = marketplaceSnippetModule.type;
        }
        return marketplaceSnippetModule.copy(i, str, map, str2, action2, itemsShow);
    }

    public final int component1() {
        return this.version;
    }

    @Nullable
    public final String component2() {
        return this.title;
    }

    @Nullable
    public final Map<String, String> component3() {
        return this.parameters;
    }

    @Nullable
    public final String component4() {
        return this.link;
    }

    @Nullable
    public final Action component5() {
        return this.action;
    }

    @NotNull
    public final ItemsShow component6() {
        return this.type;
    }

    @NotNull
    public final MarketplaceSnippetModule copy(int i, @Nullable String str, @Nullable Map<String, String> map, @Nullable String str2, @Nullable Action action2, @NotNull ItemsShow itemsShow) {
        Intrinsics.checkNotNullParameter(itemsShow, "type");
        return new MarketplaceSnippetModule(i, str, map, str2, action2, itemsShow);
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
        if (!(obj instanceof MarketplaceSnippetModule)) {
            return false;
        }
        MarketplaceSnippetModule marketplaceSnippetModule = (MarketplaceSnippetModule) obj;
        return this.version == marketplaceSnippetModule.version && Intrinsics.areEqual(this.title, marketplaceSnippetModule.title) && Intrinsics.areEqual(this.parameters, marketplaceSnippetModule.parameters) && Intrinsics.areEqual(this.link, marketplaceSnippetModule.link) && Intrinsics.areEqual(this.action, marketplaceSnippetModule.action) && Intrinsics.areEqual(this.type, marketplaceSnippetModule.type);
    }

    @Nullable
    public final Action getAction() {
        return this.action;
    }

    @Nullable
    public final String getLink() {
        return this.link;
    }

    @Nullable
    public final Map<String, String> getParameters() {
        return this.parameters;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final ItemsShow getType() {
        return this.type;
    }

    public final int getVersion() {
        return this.version;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i = this.version * 31;
        String str = this.title;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        Map<String, String> map = this.parameters;
        int hashCode2 = (hashCode + (map != null ? map.hashCode() : 0)) * 31;
        String str2 = this.link;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Action action2 = this.action;
        int hashCode4 = (hashCode3 + (action2 != null ? action2.hashCode() : 0)) * 31;
        ItemsShow itemsShow = this.type;
        if (itemsShow != null) {
            i2 = itemsShow.hashCode();
        }
        return hashCode4 + i2;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("MarketplaceSnippetModule(version=");
        L.append(this.version);
        L.append(", title=");
        L.append(this.title);
        L.append(", parameters=");
        L.append(this.parameters);
        L.append(", link=");
        L.append(this.link);
        L.append(", action=");
        L.append(this.action);
        L.append(", type=");
        L.append(this.type);
        L.append(")");
        return L.toString();
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [java.util.Map$Entry, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // android.os.Parcelable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void writeToParcel(@org.jetbrains.annotations.NotNull android.os.Parcel r4, int r5) {
        /*
            r3 = this;
            java.lang.String r0 = "parcel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            int r0 = r3.version
            r4.writeInt(r0)
            java.lang.String r0 = r3.title
            r4.writeString(r0)
            java.util.Map<java.lang.String, java.lang.String> r0 = r3.parameters
            if (r0 == 0) goto L_0x0035
            r1 = 1
            java.util.Iterator r0 = a2.b.a.a.a.m0(r4, r1, r0)
        L_0x0018:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0039
            java.lang.Object r1 = r0.next()
            java.lang.Object r2 = r1.getKey()
            java.lang.String r2 = (java.lang.String) r2
            r4.writeString(r2)
            java.lang.Object r1 = r1.getValue()
            java.lang.String r1 = (java.lang.String) r1
            r4.writeString(r1)
            goto L_0x0018
        L_0x0035:
            r0 = 0
            r4.writeInt(r0)
        L_0x0039:
            java.lang.String r0 = r3.link
            r4.writeString(r0)
            com.avito.android.remote.model.Action r0 = r3.action
            r4.writeParcelable(r0, r5)
            com.avito.android.brandspace.remote.model.ItemsShow r5 = r3.type
            java.lang.String r5 = r5.name()
            r4.writeString(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.brandspace.remote.model.MarketplaceSnippetModule.writeToParcel(android.os.Parcel, int):void");
    }
}
