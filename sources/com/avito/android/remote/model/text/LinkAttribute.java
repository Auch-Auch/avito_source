package com.avito.android.remote.model.text;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J.\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J \u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aR\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004R\u001c\u0010\b\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\b\u0010\u001b\u001a\u0004\b\u001d\u0010\u0004R\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001b\u001a\u0004\b\u001e\u0010\u0004¨\u0006!"}, d2 = {"Lcom/avito/android/remote/model/text/LinkAttribute;", "Lcom/avito/android/remote/model/text/Attribute;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "name", "title", "url", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/remote/model/text/LinkAttribute;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getUrl", "getTitle", "getName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class LinkAttribute extends Attribute {
    public static final Parcelable.Creator<LinkAttribute> CREATOR = new Creator();
    @NotNull
    private final String name;
    @NotNull
    private final String title;
    @NotNull
    private final String url;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<LinkAttribute> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final LinkAttribute createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new LinkAttribute(parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final LinkAttribute[] newArray(int i) {
            return new LinkAttribute[i];
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LinkAttribute(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        super(null);
        a.Z0(str, "name", str2, "title", str3, "url");
        this.name = str;
        this.title = str2;
        this.url = str3;
    }

    public static /* synthetic */ LinkAttribute copy$default(LinkAttribute linkAttribute, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = linkAttribute.getName();
        }
        if ((i & 2) != 0) {
            str2 = linkAttribute.getTitle();
        }
        if ((i & 4) != 0) {
            str3 = linkAttribute.url;
        }
        return linkAttribute.copy(str, str2, str3);
    }

    @NotNull
    public final String component1() {
        return getName();
    }

    @NotNull
    public final String component2() {
        return getTitle();
    }

    @NotNull
    public final String component3() {
        return this.url;
    }

    @NotNull
    public final LinkAttribute copy(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(str3, "url");
        return new LinkAttribute(str, str2, str3);
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LinkAttribute)) {
            return false;
        }
        LinkAttribute linkAttribute = (LinkAttribute) obj;
        return Intrinsics.areEqual(getName(), linkAttribute.getName()) && Intrinsics.areEqual(getTitle(), linkAttribute.getTitle()) && Intrinsics.areEqual(this.url, linkAttribute.url);
    }

    @Override // com.avito.android.remote.model.text.Attribute
    @NotNull
    public String getName() {
        return this.name;
    }

    @Override // com.avito.android.remote.model.text.Attribute
    @NotNull
    public String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String name2 = getName();
        int i = 0;
        int hashCode = (name2 != null ? name2.hashCode() : 0) * 31;
        String title2 = getTitle();
        int hashCode2 = (hashCode + (title2 != null ? title2.hashCode() : 0)) * 31;
        String str = this.url;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode2 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("LinkAttribute(name=");
        L.append(getName());
        L.append(", title=");
        L.append(getTitle());
        L.append(", url=");
        return a.t(L, this.url, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.name);
        parcel.writeString(this.title);
        parcel.writeString(this.url);
    }
}
