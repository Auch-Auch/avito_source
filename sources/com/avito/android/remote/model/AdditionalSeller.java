package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.remote.model.AdvertAction;
import com.avito.android.remote.model.AdvertParameters;
import com.avito.android.remote.model.text.AttributedText;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001BE\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\u000e\b\u0002\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001f\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b%\u0010&J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\"\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$¨\u0006'"}, d2 = {"Lcom/avito/android/remote/model/AdditionalSeller;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/text/AttributedText;", "title", "Lcom/avito/android/remote/model/text/AttributedText;", "getTitle", "()Lcom/avito/android/remote/model/text/AttributedText;", "", "showAfterDescription", "Z", "getShowAfterDescription", "()Z", "Lcom/avito/android/remote/model/AdditionalSellerButtons;", MessengerShareContentUtility.BUTTONS, "Lcom/avito/android/remote/model/AdditionalSellerButtons;", "getButtons", "()Lcom/avito/android/remote/model/AdditionalSellerButtons;", "Lcom/avito/android/remote/model/AdvertAction$Phone;", "phone", "Lcom/avito/android/remote/model/AdvertAction$Phone;", "getPhone", "()Lcom/avito/android/remote/model/AdvertAction$Phone;", "", "Lcom/avito/android/remote/model/AdvertParameters$Parameter;", "params", "Ljava/util/List;", "getParams", "()Ljava/util/List;", "<init>", "(Lcom/avito/android/remote/model/text/AttributedText;Ljava/util/List;Lcom/avito/android/remote/model/AdvertAction$Phone;Lcom/avito/android/remote/model/AdditionalSellerButtons;Z)V", "api_release"}, k = 1, mv = {1, 4, 2})
public final class AdditionalSeller implements Parcelable {
    public static final Parcelable.Creator<AdditionalSeller> CREATOR = new Creator();
    @SerializedName(MessengerShareContentUtility.BUTTONS)
    @Nullable
    private final AdditionalSellerButtons buttons;
    @SerializedName(ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT)
    @NotNull
    private final List<AdvertParameters.Parameter> params;
    @SerializedName("phone")
    @Nullable
    private final AdvertAction.Phone phone;
    @SerializedName("showAfterDescription")
    private final boolean showAfterDescription;
    @SerializedName("title")
    @Nullable
    private final AttributedText title;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<AdditionalSeller> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdditionalSeller createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            AttributedText attributedText = (AttributedText) parcel.readParcelable(AdditionalSeller.class.getClassLoader());
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add((AdvertParameters.Parameter) parcel.readParcelable(AdditionalSeller.class.getClassLoader()));
                readInt--;
            }
            return new AdditionalSeller(attributedText, arrayList, (AdvertAction.Phone) parcel.readParcelable(AdditionalSeller.class.getClassLoader()), parcel.readInt() != 0 ? AdditionalSellerButtons.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdditionalSeller[] newArray(int i) {
            return new AdditionalSeller[i];
        }
    }

    public AdditionalSeller() {
        this(null, null, null, null, false, 31, null);
    }

    public AdditionalSeller(@Nullable AttributedText attributedText, @NotNull List<AdvertParameters.Parameter> list, @Nullable AdvertAction.Phone phone2, @Nullable AdditionalSellerButtons additionalSellerButtons, boolean z) {
        Intrinsics.checkNotNullParameter(list, "params");
        this.title = attributedText;
        this.params = list;
        this.phone = phone2;
        this.buttons = additionalSellerButtons;
        this.showAfterDescription = z;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final AdditionalSellerButtons getButtons() {
        return this.buttons;
    }

    @NotNull
    public final List<AdvertParameters.Parameter> getParams() {
        return this.params;
    }

    @Nullable
    public final AdvertAction.Phone getPhone() {
        return this.phone;
    }

    public final boolean getShowAfterDescription() {
        return this.showAfterDescription;
    }

    @Nullable
    public final AttributedText getTitle() {
        return this.title;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeParcelable(this.title, i);
        Iterator n0 = a.n0(this.params, parcel);
        while (n0.hasNext()) {
            parcel.writeParcelable((AdvertParameters.Parameter) n0.next(), i);
        }
        parcel.writeParcelable(this.phone, i);
        AdditionalSellerButtons additionalSellerButtons = this.buttons;
        if (additionalSellerButtons != null) {
            parcel.writeInt(1);
            additionalSellerButtons.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.showAfterDescription ? 1 : 0);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AdditionalSeller(AttributedText attributedText, List list, AdvertAction.Phone phone2, AdditionalSellerButtons additionalSellerButtons, boolean z, int i, j jVar) {
        this((i & 1) != 0 ? null : attributedText, (i & 2) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i & 4) != 0 ? null : phone2, (i & 8) == 0 ? additionalSellerButtons : null, (i & 16) != 0 ? false : z);
    }
}
