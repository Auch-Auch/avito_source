package com.avito.android.stories;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b&\u0010'J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J4\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0011J \u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u0007R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\u0004R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010\"\u001a\u0004\b%\u0010\u0004¨\u0006("}, d2 = {"Lcom/avito/android/stories/StoriesArguments;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/util/List;", "component3", "url", "stories", "currentStoryId", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)Lcom/avito/android/stories/StoriesArguments;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "getStories", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getUrl", "c", "getCurrentStoryId", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class StoriesArguments implements Parcelable {
    public static final Parcelable.Creator<StoriesArguments> CREATOR = new Creator();
    @NotNull
    public final String a;
    @NotNull
    public final List<String> b;
    @NotNull
    public final String c;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<StoriesArguments> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final StoriesArguments createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new StoriesArguments(parcel.readString(), parcel.createStringArrayList(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final StoriesArguments[] newArray(int i) {
            return new StoriesArguments[i];
        }
    }

    public StoriesArguments(@NotNull String str, @NotNull List<String> list, @NotNull String str2) {
        a.d1(str, "url", list, "stories", str2, "currentStoryId");
        this.a = str;
        this.b = list;
        this.c = str2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.stories.StoriesArguments */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StoriesArguments copy$default(StoriesArguments storiesArguments, String str, List list, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = storiesArguments.a;
        }
        if ((i & 2) != 0) {
            list = storiesArguments.b;
        }
        if ((i & 4) != 0) {
            str2 = storiesArguments.c;
        }
        return storiesArguments.copy(str, list, str2);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    @NotNull
    public final List<String> component2() {
        return this.b;
    }

    @NotNull
    public final String component3() {
        return this.c;
    }

    @NotNull
    public final StoriesArguments copy(@NotNull String str, @NotNull List<String> list, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(list, "stories");
        Intrinsics.checkNotNullParameter(str2, "currentStoryId");
        return new StoriesArguments(str, list, str2);
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
        if (!(obj instanceof StoriesArguments)) {
            return false;
        }
        StoriesArguments storiesArguments = (StoriesArguments) obj;
        return Intrinsics.areEqual(this.a, storiesArguments.a) && Intrinsics.areEqual(this.b, storiesArguments.b) && Intrinsics.areEqual(this.c, storiesArguments.c);
    }

    @NotNull
    public final String getCurrentStoryId() {
        return this.c;
    }

    @NotNull
    public final List<String> getStories() {
        return this.b;
    }

    @NotNull
    public final String getUrl() {
        return this.a;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<String> list = this.b;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        String str2 = this.c;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("StoriesArguments(url=");
        L.append(this.a);
        L.append(", stories=");
        L.append(this.b);
        L.append(", currentStoryId=");
        return a.t(L, this.c, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a);
        parcel.writeStringList(this.b);
        parcel.writeString(this.c);
    }
}
