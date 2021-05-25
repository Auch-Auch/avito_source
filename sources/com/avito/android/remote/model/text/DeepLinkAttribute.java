package com.avito.android.remote.model.text;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.deep_linking.links.DeepLink;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\b\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0013\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\n\u0012\u0006\u0010\u0015\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b(\u0010)J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\r\u0010\fJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u0011\u0010\fJ\u0012\u0010\u0012\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u0012\u0010\fJF\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\n2\b\b\u0002\u0010\u0014\u001a\u00020\n2\b\b\u0002\u0010\u0015\u001a\u00020\u000e2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u001a\u0010\fJ \u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u001f\u0010 R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010!\u001a\u0004\b\"\u0010\fR\u001c\u0010\u0014\u001a\u00020\n8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0014\u0010!\u001a\u0004\b#\u0010\fR\u0019\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010$\u001a\u0004\b%\u0010\u0010R\u001c\u0010\u0013\u001a\u00020\n8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0013\u0010!\u001a\u0004\b&\u0010\fR\u001b\u0010\u0016\u001a\u0004\u0018\u00010\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010!\u001a\u0004\b'\u0010\f¨\u0006*"}, d2 = {"Lcom/avito/android/remote/model/text/DeepLinkAttribute;", "Lcom/avito/android/remote/model/text/Attribute;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "component1", "()Ljava/lang/String;", "component2", "Lcom/avito/android/deep_linking/links/DeepLink;", "component3", "()Lcom/avito/android/deep_linking/links/DeepLink;", "component4", "component5", "name", "title", "deepLink", "fallbackUrl", "deepLinkString", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/remote/model/text/DeepLinkAttribute;", "toString", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getDeepLinkString", "getTitle", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "getName", "getFallbackUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;Ljava/lang/String;Ljava/lang/String;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class DeepLinkAttribute extends Attribute {
    public static final Parcelable.Creator<DeepLinkAttribute> CREATOR = new Creator();
    @NotNull
    private final DeepLink deepLink;
    @Nullable
    private final String deepLinkString;
    @Nullable
    private final String fallbackUrl;
    @NotNull
    private final String name;
    @NotNull
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<DeepLinkAttribute> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DeepLinkAttribute createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new DeepLinkAttribute(parcel.readString(), parcel.readString(), (DeepLink) parcel.readParcelable(DeepLinkAttribute.class.getClassLoader()), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DeepLinkAttribute[] newArray(int i) {
            return new DeepLinkAttribute[i];
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DeepLinkAttribute(String str, String str2, DeepLink deepLink2, String str3, String str4, int i, j jVar) {
        this(str, str2, deepLink2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4);
    }

    public static /* synthetic */ DeepLinkAttribute copy$default(DeepLinkAttribute deepLinkAttribute, String str, String str2, DeepLink deepLink2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = deepLinkAttribute.getName();
        }
        if ((i & 2) != 0) {
            str2 = deepLinkAttribute.getTitle();
        }
        if ((i & 4) != 0) {
            deepLink2 = deepLinkAttribute.deepLink;
        }
        if ((i & 8) != 0) {
            str3 = deepLinkAttribute.fallbackUrl;
        }
        if ((i & 16) != 0) {
            str4 = deepLinkAttribute.deepLinkString;
        }
        return deepLinkAttribute.copy(str, str2, deepLink2, str3, str4);
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
    public final DeepLink component3() {
        return this.deepLink;
    }

    @Nullable
    public final String component4() {
        return this.fallbackUrl;
    }

    @Nullable
    public final String component5() {
        return this.deepLinkString;
    }

    @NotNull
    public final DeepLinkAttribute copy(@NotNull String str, @NotNull String str2, @NotNull DeepLink deepLink2, @Nullable String str3, @Nullable String str4) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(deepLink2, "deepLink");
        return new DeepLinkAttribute(str, str2, deepLink2, str3, str4);
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(DeepLinkAttribute.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.avito.android.remote.model.text.DeepLinkAttribute");
        DeepLinkAttribute deepLinkAttribute = (DeepLinkAttribute) obj;
        return !(Intrinsics.areEqual(getName(), deepLinkAttribute.getName()) ^ true) && !(Intrinsics.areEqual(getTitle(), deepLinkAttribute.getTitle()) ^ true) && !(Intrinsics.areEqual(this.deepLink.getUri(), deepLinkAttribute.deepLink.getUri()) ^ true) && !(Intrinsics.areEqual(this.fallbackUrl, deepLinkAttribute.fallbackUrl) ^ true);
    }

    @NotNull
    public final DeepLink getDeepLink() {
        return this.deepLink;
    }

    @Nullable
    public final String getDeepLinkString() {
        return this.deepLinkString;
    }

    @Nullable
    public final String getFallbackUrl() {
        return this.fallbackUrl;
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

    @Override // java.lang.Object
    public int hashCode() {
        int hashCode = this.deepLink.getUri().hashCode() * 31;
        String str = this.fallbackUrl;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("DeepLinkAttribute(name=");
        L.append(getName());
        L.append(", title=");
        L.append(getTitle());
        L.append(", deepLink=");
        L.append(this.deepLink);
        L.append(", fallbackUrl=");
        L.append(this.fallbackUrl);
        L.append(", deepLinkString=");
        return a.t(L, this.deepLinkString, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.name);
        parcel.writeString(this.title);
        parcel.writeParcelable(this.deepLink, i);
        parcel.writeString(this.fallbackUrl);
        parcel.writeString(this.deepLinkString);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeepLinkAttribute(@NotNull String str, @NotNull String str2, @NotNull DeepLink deepLink2, @Nullable String str3, @Nullable String str4) {
        super(null);
        a.W0(str, "name", str2, "title", deepLink2, "deepLink");
        this.name = str;
        this.title = str2;
        this.deepLink = deepLink2;
        this.fallbackUrl = str3;
        this.deepLinkString = str4;
    }
}
