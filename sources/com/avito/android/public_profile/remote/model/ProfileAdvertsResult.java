package com.avito.android.public_profile.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.SerpElement;
import com.avito.android.remote.model.UserDialog;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B+\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR$\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/avito/android/public_profile/remote/model/ProfileAdvertsResult;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/UserDialog;", "dialog", "Lcom/avito/android/remote/model/UserDialog;", "getDialog", "()Lcom/avito/android/remote/model/UserDialog;", "", "Lcom/avito/android/remote/model/SerpElement;", "list", "Ljava/util/List;", "getList", "()Ljava/util/List;", "", "disclaimer", "Ljava/lang/String;", "getDisclaimer", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;Ljava/util/List;Lcom/avito/android/remote/model/UserDialog;)V", "public-profile_release"}, k = 1, mv = {1, 4, 2})
public final class ProfileAdvertsResult implements Parcelable {
    public static final Parcelable.Creator<ProfileAdvertsResult> CREATOR = new Creator();
    @SerializedName("dialog")
    @Nullable
    private final UserDialog dialog;
    @SerializedName("disclaimer")
    @Nullable
    private final String disclaimer;
    @SerializedName("list")
    @Nullable
    private final List<SerpElement> list;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<ProfileAdvertsResult> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ProfileAdvertsResult createFromParcel(@NotNull Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add((SerpElement) parcel.readParcelable(ProfileAdvertsResult.class.getClassLoader()));
                    readInt--;
                }
            } else {
                arrayList = null;
            }
            return new ProfileAdvertsResult(readString, arrayList, (UserDialog) parcel.readParcelable(ProfileAdvertsResult.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ProfileAdvertsResult[] newArray(int i) {
            return new ProfileAdvertsResult[i];
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends com.avito.android.remote.model.SerpElement> */
    /* JADX WARN: Multi-variable type inference failed */
    public ProfileAdvertsResult(@Nullable String str, @Nullable List<? extends SerpElement> list2, @Nullable UserDialog userDialog) {
        this.disclaimer = str;
        this.list = list2;
        this.dialog = userDialog;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final UserDialog getDialog() {
        return this.dialog;
    }

    @Nullable
    public final String getDisclaimer() {
        return this.disclaimer;
    }

    @Nullable
    public final List<SerpElement> getList() {
        return this.list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.disclaimer);
        List<SerpElement> list2 = this.list;
        if (list2 != null) {
            Iterator l0 = a.l0(parcel, 1, list2);
            while (l0.hasNext()) {
                parcel.writeParcelable((SerpElement) l0.next(), i);
            }
        } else {
            parcel.writeInt(0);
        }
        parcel.writeParcelable(this.dialog, i);
    }
}
