package com.avito.android.deep_linking.links;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.util.Parcels;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\b\u0018\u0000 #2\u00020\u0001:\u0001#B\u001f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b!\u0010\"J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\f\u0010\u000bJ(\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0011\u0010\u000bJ\u0010\u0010\u0012\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001c\u001a\u00020\t8\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u000bR\u001b\u0010\r\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001a\u001a\u0004\b\u001e\u0010\u000bR\u001b\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b \u0010\u000b¨\u0006$"}, d2 = {"Lcom/avito/android/deep_linking/links/CreateChannelWithAvitoLink;", "Lcom/avito/android/deep_linking/links/DeepLink;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "component1", "()Ljava/lang/String;", "component2", "context", "source", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/deep_linking/links/CreateChannelWithAvitoLink;", "toString", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "c", "Ljava/lang/String;", "getPath", MessageMetaInfo.COLUMN_PATH, "d", "getContext", "e", "getSource", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
public final class CreateChannelWithAvitoLink extends DeepLink {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<CreateChannelWithAvitoLink> CREATOR = Parcels.creator(a.a);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String PATH = "/item/channel/create";
    @NotNull
    public final String c;
    @Nullable
    public final String d;
    @Nullable
    public final String e;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0007\u001a\u00020\u00068\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/deep_linking/links/CreateChannelWithAvitoLink$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/deep_linking/links/CreateChannelWithAvitoLink;", "CREATOR", "Landroid/os/Parcelable$Creator;", "", "PATH", "Ljava/lang/String;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<Parcel, CreateChannelWithAvitoLink> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public CreateChannelWithAvitoLink invoke(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "$receiver");
            return new CreateChannelWithAvitoLink(parcel2.readString(), parcel2.readString());
        }
    }

    public CreateChannelWithAvitoLink() {
        this(null, null, 3, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CreateChannelWithAvitoLink(String str, String str2, int i, j jVar) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
    }

    public static /* synthetic */ CreateChannelWithAvitoLink copy$default(CreateChannelWithAvitoLink createChannelWithAvitoLink, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = createChannelWithAvitoLink.d;
        }
        if ((i & 2) != 0) {
            str2 = createChannelWithAvitoLink.e;
        }
        return createChannelWithAvitoLink.copy(str, str2);
    }

    @Nullable
    public final String component1() {
        return this.d;
    }

    @Nullable
    public final String component2() {
        return this.e;
    }

    @NotNull
    public final CreateChannelWithAvitoLink copy(@Nullable String str, @Nullable String str2) {
        return new CreateChannelWithAvitoLink(str, str2);
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CreateChannelWithAvitoLink)) {
            return false;
        }
        CreateChannelWithAvitoLink createChannelWithAvitoLink = (CreateChannelWithAvitoLink) obj;
        return Intrinsics.areEqual(this.d, createChannelWithAvitoLink.d) && Intrinsics.areEqual(this.e, createChannelWithAvitoLink.e);
    }

    @Nullable
    public final String getContext() {
        return this.d;
    }

    @Override // com.avito.android.deep_linking.links.DeepLink
    @NotNull
    public String getPath() {
        return this.c;
    }

    @Nullable
    public final String getSource() {
        return this.e;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.d;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.e;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("CreateChannelWithAvitoLink(context=");
        L.append(this.d);
        L.append(", source=");
        return a2.b.a.a.a.t(L, this.e, ")");
    }

    @Override // com.avito.android.deep_linking.links.DeepLink, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(this.d);
        parcel.writeString(this.e);
    }

    public CreateChannelWithAvitoLink(@Nullable String str, @Nullable String str2) {
        this.d = str;
        this.e = str2;
        this.c = "/item/channel/create";
    }
}
