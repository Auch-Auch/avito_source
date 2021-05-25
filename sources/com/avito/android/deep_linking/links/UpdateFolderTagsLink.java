package com.avito.android.deep_linking.links;

import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.util.Parcels;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\b\b\u0018\u0000 .2\u00020\u0001:\u0001.B3\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\t\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\r\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\r¢\u0006\u0004\b,\u0010-J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\f\u0010\u000bJ\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\rHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000fJD\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\t2\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\r2\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\rHÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u000bJ\u0010\u0010\u0018\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u001c\u0010\"\u001a\u00020\t8\u0016@\u0016XD¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u000bR\u001f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\r8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\u000fR\u0019\u0010\u0011\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010 \u001a\u0004\b'\u0010\u000bR\u001f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\r8\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010$\u001a\u0004\b)\u0010\u000fR\u0019\u0010\u0012\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010 \u001a\u0004\b+\u0010\u000b¨\u0006/"}, d2 = {"Lcom/avito/android/deep_linking/links/UpdateFolderTagsLink;", "Lcom/avito/android/deep_linking/links/DeepLink;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Ljava/util/List;", "component4", "channelId", UpdateFolderTagsLink.FOLDER_ID, "addTags", "removeTags", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)Lcom/avito/android/deep_linking/links/UpdateFolderTagsLink;", "toString", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "c", "Ljava/lang/String;", "getPath", MessageMetaInfo.COLUMN_PATH, g.a, "Ljava/util/List;", "getRemoveTags", "d", "getChannelId", "f", "getAddTags", "e", "getFolderId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
public final class UpdateFolderTagsLink extends DeepLink {
    @NotNull
    public static final String ADD_TAGS = "addTags";
    @NotNull
    public static final String CHANNEL_ID = "channelId";
    @JvmField
    @NotNull
    public static final Parcelable.Creator<UpdateFolderTagsLink> CREATOR = Parcels.creator(a.a);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String FOLDER_ID = "folderId";
    @NotNull
    public static final String PATH = "/channel/updateFolderTags";
    @NotNull
    public static final String REMOVE_TAGS = "removeTags";
    @NotNull
    public final String c = PATH;
    @NotNull
    public final String d;
    @NotNull
    public final String e;
    @NotNull
    public final List<String> f;
    @NotNull
    public final List<String> g;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0016\u0010\f\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\f\u0010\u0004¨\u0006\u000f"}, d2 = {"Lcom/avito/android/deep_linking/links/UpdateFolderTagsLink$Companion;", "", "", "ADD_TAGS", "Ljava/lang/String;", "CHANNEL_ID", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/deep_linking/links/UpdateFolderTagsLink;", "CREATOR", "Landroid/os/Parcelable$Creator;", "FOLDER_ID", "PATH", "REMOVE_TAGS", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<Parcel, UpdateFolderTagsLink> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public UpdateFolderTagsLink invoke(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "$receiver");
            String u2 = a2.b.a.a.a.u2(parcel2, "readString()!!");
            String u22 = a2.b.a.a.a.u2(parcel2, "readString()!!");
            List createStringArrayList = parcel2.createStringArrayList();
            if (createStringArrayList == null) {
                createStringArrayList = CollectionsKt__CollectionsKt.emptyList();
            }
            List createStringArrayList2 = parcel2.createStringArrayList();
            if (createStringArrayList2 == null) {
                createStringArrayList2 = CollectionsKt__CollectionsKt.emptyList();
            }
            return new UpdateFolderTagsLink(u2, u22, createStringArrayList, createStringArrayList2);
        }
    }

    public UpdateFolderTagsLink(@NotNull String str, @NotNull String str2, @NotNull List<String> list, @NotNull List<String> list2) {
        Intrinsics.checkNotNullParameter(str, "channelId");
        Intrinsics.checkNotNullParameter(str2, FOLDER_ID);
        Intrinsics.checkNotNullParameter(list, "addTags");
        Intrinsics.checkNotNullParameter(list2, "removeTags");
        this.d = str;
        this.e = str2;
        this.f = list;
        this.g = list2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.deep_linking.links.UpdateFolderTagsLink */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UpdateFolderTagsLink copy$default(UpdateFolderTagsLink updateFolderTagsLink, String str, String str2, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = updateFolderTagsLink.d;
        }
        if ((i & 2) != 0) {
            str2 = updateFolderTagsLink.e;
        }
        if ((i & 4) != 0) {
            list = updateFolderTagsLink.f;
        }
        if ((i & 8) != 0) {
            list2 = updateFolderTagsLink.g;
        }
        return updateFolderTagsLink.copy(str, str2, list, list2);
    }

    @NotNull
    public final String component1() {
        return this.d;
    }

    @NotNull
    public final String component2() {
        return this.e;
    }

    @NotNull
    public final List<String> component3() {
        return this.f;
    }

    @NotNull
    public final List<String> component4() {
        return this.g;
    }

    @NotNull
    public final UpdateFolderTagsLink copy(@NotNull String str, @NotNull String str2, @NotNull List<String> list, @NotNull List<String> list2) {
        Intrinsics.checkNotNullParameter(str, "channelId");
        Intrinsics.checkNotNullParameter(str2, FOLDER_ID);
        Intrinsics.checkNotNullParameter(list, "addTags");
        Intrinsics.checkNotNullParameter(list2, "removeTags");
        return new UpdateFolderTagsLink(str, str2, list, list2);
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UpdateFolderTagsLink)) {
            return false;
        }
        UpdateFolderTagsLink updateFolderTagsLink = (UpdateFolderTagsLink) obj;
        return Intrinsics.areEqual(this.d, updateFolderTagsLink.d) && Intrinsics.areEqual(this.e, updateFolderTagsLink.e) && Intrinsics.areEqual(this.f, updateFolderTagsLink.f) && Intrinsics.areEqual(this.g, updateFolderTagsLink.g);
    }

    @NotNull
    public final List<String> getAddTags() {
        return this.f;
    }

    @NotNull
    public final String getChannelId() {
        return this.d;
    }

    @NotNull
    public final String getFolderId() {
        return this.e;
    }

    @Override // com.avito.android.deep_linking.links.DeepLink
    @NotNull
    public String getPath() {
        return this.c;
    }

    @NotNull
    public final List<String> getRemoveTags() {
        return this.g;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.d;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.e;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        List<String> list = this.f;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        List<String> list2 = this.g;
        if (list2 != null) {
            i = list2.hashCode();
        }
        return hashCode3 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("UpdateFolderTagsLink(channelId=");
        L.append(this.d);
        L.append(", folderId=");
        L.append(this.e);
        L.append(", addTags=");
        L.append(this.f);
        L.append(", removeTags=");
        return a2.b.a.a.a.w(L, this.g, ")");
    }

    @Override // com.avito.android.deep_linking.links.DeepLink, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeStringList(this.f);
        parcel.writeStringList(this.g);
    }
}
