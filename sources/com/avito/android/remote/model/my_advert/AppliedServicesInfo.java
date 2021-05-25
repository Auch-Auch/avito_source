package com.avito.android.remote.model.my_advert;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.model.Service;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.annotations.SerializedName;
import com.vk.sdk.api.VKApiConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/avito/android/remote/model/my_advert/AppliedServicesInfo;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "Lcom/avito/android/deep_linking/links/DeepLink;", ShareConstants.MEDIA_URI, "Lcom/avito/android/deep_linking/links/DeepLink;", "getUri", "()Lcom/avito/android/deep_linking/links/DeepLink;", "", "Lcom/avito/android/remote/model/Service;", "servicesIcons", "Ljava/util/List;", "getServicesIcons", "()Ljava/util/List;", "<init>", "(Ljava/lang/String;Ljava/util/List;Lcom/avito/android/deep_linking/links/DeepLink;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class AppliedServicesInfo implements Parcelable {
    public static final Parcelable.Creator<AppliedServicesInfo> CREATOR = new Creator();
    @SerializedName(VKApiConst.SERVICES)
    @NotNull
    private final List<Service> servicesIcons;
    @SerializedName("title")
    @NotNull
    private final String title;
    @SerializedName(ShareConstants.MEDIA_URI)
    @NotNull
    private final DeepLink uri;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<AppliedServicesInfo> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AppliedServicesInfo createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add(Service.CREATOR.createFromParcel(parcel));
                readInt--;
            }
            return new AppliedServicesInfo(readString, arrayList, (DeepLink) parcel.readParcelable(AppliedServicesInfo.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AppliedServicesInfo[] newArray(int i) {
            return new AppliedServicesInfo[i];
        }
    }

    public AppliedServicesInfo(@NotNull String str, @NotNull List<Service> list, @NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(list, "servicesIcons");
        Intrinsics.checkNotNullParameter(deepLink, ShareConstants.MEDIA_URI);
        this.title = str;
        this.servicesIcons = list;
        this.uri = deepLink;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final List<Service> getServicesIcons() {
        return this.servicesIcons;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final DeepLink getUri() {
        return this.uri;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.title);
        Iterator n0 = a.n0(this.servicesIcons, parcel);
        while (n0.hasNext()) {
            ((Service) n0.next()).writeToParcel(parcel, 0);
        }
        parcel.writeParcelable(this.uri, i);
    }
}
