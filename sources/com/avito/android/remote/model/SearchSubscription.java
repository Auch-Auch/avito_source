package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.db.SearchSubscriptionsContract;
import com.avito.android.deep_linking.links.DeepLink;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001Bg\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010-\u001a\u00020\u0016\u0012\u0006\u0010$\u001a\u00020\u0016\u0012\u0006\u00100\u001a\u00020/\u0012\u0006\u0010&\u001a\u00020\u0007\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010+\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b4\u00105J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\n\u0010\tJ \u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0017\u001a\u00020\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0019\u0010$\u001a\u00020\u00168\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010\u0018\u001a\u0004\b%\u0010\u001aR\u0019\u0010&\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010\tR\u001b\u0010)\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010!\u001a\u0004\b*\u0010#R\u001b\u0010+\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010\u0018\u001a\u0004\b,\u0010\u001aR\u0019\u0010-\u001a\u00020\u00168\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010\u0018\u001a\u0004\b.\u0010\u001aR\u0019\u00100\u001a\u00020/8\u0006@\u0006¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103¨\u00066"}, d2 = {"Lcom/avito/android/remote/model/SearchSubscription;", "Landroid/os/Parcelable;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/SearchParams;", "searchParams", "Lcom/avito/android/remote/model/SearchParams;", "getSearchParams", "()Lcom/avito/android/remote/model/SearchParams;", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "pushFrequency", "Ljava/lang/Integer;", "getPushFrequency", "()Ljava/lang/Integer;", "Lcom/avito/android/deep_linking/links/DeepLink;", "editAction", "Lcom/avito/android/deep_linking/links/DeepLink;", "getEditAction", "()Lcom/avito/android/deep_linking/links/DeepLink;", "description", "getDescription", "count", "I", "getCount", "deeplink", "getDeeplink", SearchSubscriptionsContract.Columns.SSID, "getSsid", "title", "getTitle", "", "lastUpdateTime", "J", "getLastUpdateTime", "()J", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JILcom/avito/android/remote/model/SearchParams;Ljava/lang/String;Ljava/lang/Integer;Lcom/avito/android/deep_linking/links/DeepLink;Lcom/avito/android/deep_linking/links/DeepLink;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class SearchSubscription implements Parcelable {
    public static final Parcelable.Creator<SearchSubscription> CREATOR = new Creator();
    private final int count;
    @Nullable
    private final DeepLink deeplink;
    @NotNull
    private final String description;
    @Nullable
    private final DeepLink editAction;
    @NotNull
    private final String id;
    private final long lastUpdateTime;
    @Nullable
    private final Integer pushFrequency;
    @Nullable
    private final SearchParams searchParams;
    @Nullable
    private final String ssid;
    @NotNull
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<SearchSubscription> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SearchSubscription createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new SearchSubscription(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readLong(), parcel.readInt(), (SearchParams) parcel.readParcelable(SearchSubscription.class.getClassLoader()), parcel.readString(), parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null, (DeepLink) parcel.readParcelable(SearchSubscription.class.getClassLoader()), (DeepLink) parcel.readParcelable(SearchSubscription.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SearchSubscription[] newArray(int i) {
            return new SearchSubscription[i];
        }
    }

    public SearchSubscription(@NotNull String str, @NotNull String str2, @NotNull String str3, long j, int i, @Nullable SearchParams searchParams2, @Nullable String str4, @Nullable Integer num, @Nullable DeepLink deepLink, @Nullable DeepLink deepLink2) {
        a.Z0(str, "id", str2, "title", str3, "description");
        this.id = str;
        this.title = str2;
        this.description = str3;
        this.lastUpdateTime = j;
        this.count = i;
        this.searchParams = searchParams2;
        this.ssid = str4;
        this.pushFrequency = num;
        this.editAction = deepLink;
        this.deeplink = deepLink2;
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
        if (obj == null || (true ^ Intrinsics.areEqual(SearchSubscription.class, obj.getClass()))) {
            return false;
        }
        return Intrinsics.areEqual(this.id, ((SearchSubscription) obj).id);
    }

    public final int getCount() {
        return this.count;
    }

    @Nullable
    public final DeepLink getDeeplink() {
        return this.deeplink;
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final DeepLink getEditAction() {
        return this.editAction;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    public final long getLastUpdateTime() {
        return this.lastUpdateTime;
    }

    @Nullable
    public final Integer getPushFrequency() {
        return this.pushFrequency;
    }

    @Nullable
    public final SearchParams getSearchParams() {
        return this.searchParams;
    }

    @Nullable
    public final String getSsid() {
        return this.ssid;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.id);
        parcel.writeString(this.title);
        parcel.writeString(this.description);
        parcel.writeLong(this.lastUpdateTime);
        parcel.writeInt(this.count);
        parcel.writeParcelable(this.searchParams, i);
        parcel.writeString(this.ssid);
        Integer num = this.pushFrequency;
        if (num != null) {
            parcel.writeInt(1);
            i2 = num.intValue();
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeParcelable(this.editAction, i);
        parcel.writeParcelable(this.deeplink, i);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SearchSubscription(String str, String str2, String str3, long j, int i, SearchParams searchParams2, String str4, Integer num, DeepLink deepLink, DeepLink deepLink2, int i2, j jVar) {
        this(str, str2, str3, j, i, searchParams2, str4, (i2 & 128) != 0 ? null : num, (i2 & 256) != 0 ? null : deepLink, (i2 & 512) != 0 ? null : deepLink2);
    }
}
