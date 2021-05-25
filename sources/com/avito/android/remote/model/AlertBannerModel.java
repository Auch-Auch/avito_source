package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.text.AttributedText;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.AnalyticsEvents;
import com.google.common.net.HttpHeaders;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001:\u0001'B#\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b%\u0010&J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J2\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0013J \u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010 \u001a\u0004\b!\u0010\u0007R\u001c\u0010\t\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\"\u001a\u0004\b#\u0010\u0004R\u001e\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010 \u001a\u0004\b$\u0010\u0007¨\u0006("}, d2 = {"Lcom/avito/android/remote/model/AlertBannerModel;", "Landroid/os/Parcelable;", "Lcom/avito/android/remote/model/AlertBannerModel$Style;", "component1", "()Lcom/avito/android/remote/model/AlertBannerModel$Style;", "Lcom/avito/android/remote/model/text/AttributedText;", "component2", "()Lcom/avito/android/remote/model/text/AttributedText;", "component3", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "title", SDKConstants.PARAM_A2U_BODY, "copy", "(Lcom/avito/android/remote/model/AlertBannerModel$Style;Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/model/text/AttributedText;)Lcom/avito/android/remote/model/AlertBannerModel;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/text/AttributedText;", "getBody", "Lcom/avito/android/remote/model/AlertBannerModel$Style;", "getStyle", "getTitle", "<init>", "(Lcom/avito/android/remote/model/AlertBannerModel$Style;Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/model/text/AttributedText;)V", "Style", "api_release"}, k = 1, mv = {1, 4, 2})
public final class AlertBannerModel implements Parcelable {
    public static final Parcelable.Creator<AlertBannerModel> CREATOR = new Creator();
    @SerializedName(SDKConstants.PARAM_A2U_BODY)
    @Nullable
    private final AttributedText body;
    @SerializedName(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE)
    @NotNull
    private final Style style;
    @SerializedName("title")
    @Nullable
    private final AttributedText title;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<AlertBannerModel> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AlertBannerModel createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new AlertBannerModel((Style) Enum.valueOf(Style.class, parcel.readString()), (AttributedText) parcel.readParcelable(AlertBannerModel.class.getClassLoader()), (AttributedText) parcel.readParcelable(AlertBannerModel.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AlertBannerModel[] newArray(int i) {
            return new AlertBannerModel[i];
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/avito/android/remote/model/AlertBannerModel$Style;", "", "<init>", "(Ljava/lang/String;I)V", "Default", "Danger", "Success", HttpHeaders.WARNING, "Info", "api_release"}, k = 1, mv = {1, 4, 2})
    public enum Style {
        Default,
        Danger,
        Success,
        Warning,
        Info
    }

    public AlertBannerModel(@NotNull Style style2, @Nullable AttributedText attributedText, @Nullable AttributedText attributedText2) {
        Intrinsics.checkNotNullParameter(style2, AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE);
        this.style = style2;
        this.title = attributedText;
        this.body = attributedText2;
    }

    public static /* synthetic */ AlertBannerModel copy$default(AlertBannerModel alertBannerModel, Style style2, AttributedText attributedText, AttributedText attributedText2, int i, Object obj) {
        if ((i & 1) != 0) {
            style2 = alertBannerModel.style;
        }
        if ((i & 2) != 0) {
            attributedText = alertBannerModel.title;
        }
        if ((i & 4) != 0) {
            attributedText2 = alertBannerModel.body;
        }
        return alertBannerModel.copy(style2, attributedText, attributedText2);
    }

    @NotNull
    public final Style component1() {
        return this.style;
    }

    @Nullable
    public final AttributedText component2() {
        return this.title;
    }

    @Nullable
    public final AttributedText component3() {
        return this.body;
    }

    @NotNull
    public final AlertBannerModel copy(@NotNull Style style2, @Nullable AttributedText attributedText, @Nullable AttributedText attributedText2) {
        Intrinsics.checkNotNullParameter(style2, AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE);
        return new AlertBannerModel(style2, attributedText, attributedText2);
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
        if (!(obj instanceof AlertBannerModel)) {
            return false;
        }
        AlertBannerModel alertBannerModel = (AlertBannerModel) obj;
        return Intrinsics.areEqual(this.style, alertBannerModel.style) && Intrinsics.areEqual(this.title, alertBannerModel.title) && Intrinsics.areEqual(this.body, alertBannerModel.body);
    }

    @Nullable
    public final AttributedText getBody() {
        return this.body;
    }

    @NotNull
    public final Style getStyle() {
        return this.style;
    }

    @Nullable
    public final AttributedText getTitle() {
        return this.title;
    }

    @Override // java.lang.Object
    public int hashCode() {
        Style style2 = this.style;
        int i = 0;
        int hashCode = (style2 != null ? style2.hashCode() : 0) * 31;
        AttributedText attributedText = this.title;
        int hashCode2 = (hashCode + (attributedText != null ? attributedText.hashCode() : 0)) * 31;
        AttributedText attributedText2 = this.body;
        if (attributedText2 != null) {
            i = attributedText2.hashCode();
        }
        return hashCode2 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("AlertBannerModel(style=");
        L.append(this.style);
        L.append(", title=");
        L.append(this.title);
        L.append(", body=");
        L.append(this.body);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.style.name());
        parcel.writeParcelable(this.title, i);
        parcel.writeParcelable(this.body, i);
    }
}
