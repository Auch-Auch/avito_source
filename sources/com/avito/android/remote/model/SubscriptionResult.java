package com.avito.android.remote.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.SaveSearchLink;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\f\u0010\rR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012¨\u0006\u0017"}, d2 = {"Lcom/avito/android/remote/model/SubscriptionResult;", "Landroid/os/Parcelable;", "Lcom/avito/android/deep_linking/links/SaveSearchLink;", ShareConstants.MEDIA_URI, "()Lcom/avito/android/deep_linking/links/SaveSearchLink;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "editAction", "Lcom/avito/android/deep_linking/links/DeepLink;", "getEditAction", "()Lcom/avito/android/deep_linking/links/DeepLink;", "searchSubscriptionAction", "getSearchSubscriptionAction", "<init>", "(Lcom/avito/android/deep_linking/links/DeepLink;Lcom/avito/android/deep_linking/links/DeepLink;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class SubscriptionResult implements Parcelable {
    public static final Parcelable.Creator<SubscriptionResult> CREATOR = new Creator();
    @SerializedName("editAction")
    @Nullable
    private final DeepLink editAction;
    @SerializedName("searchSubscriptionAction")
    @Nullable
    private final DeepLink searchSubscriptionAction;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<SubscriptionResult> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SubscriptionResult createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new SubscriptionResult((DeepLink) parcel.readParcelable(SubscriptionResult.class.getClassLoader()), (DeepLink) parcel.readParcelable(SubscriptionResult.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SubscriptionResult[] newArray(int i) {
            return new SubscriptionResult[i];
        }
    }

    public SubscriptionResult(@Nullable DeepLink deepLink, @Nullable DeepLink deepLink2) {
        this.searchSubscriptionAction = deepLink;
        this.editAction = deepLink2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final DeepLink getEditAction() {
        return this.editAction;
    }

    @Nullable
    public final DeepLink getSearchSubscriptionAction() {
        return this.searchSubscriptionAction;
    }

    @Nullable
    public final SaveSearchLink uri() {
        DeepLink deepLink = this.searchSubscriptionAction;
        SaveSearchLink saveSearchLink = null;
        if (!(deepLink instanceof SaveSearchLink)) {
            deepLink = null;
        }
        SaveSearchLink saveSearchLink2 = (SaveSearchLink) deepLink;
        if (saveSearchLink2 != null) {
            return saveSearchLink2;
        }
        DeepLink deepLink2 = this.editAction;
        if (deepLink2 instanceof SaveSearchLink) {
            saveSearchLink = deepLink2;
        }
        return saveSearchLink;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeParcelable(this.searchSubscriptionAction, i);
        parcel.writeParcelable(this.editAction, i);
    }
}
