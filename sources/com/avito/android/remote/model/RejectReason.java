package com.avito.android.remote.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.user_advert.reject.RejectReasonItemKt;
import com.google.gson.annotations.SerializedName;
import com.sumsub.sns.core.common.SNSConstants;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001:\u0001\"B?\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b \u0010!J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\u00020\u000e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u000e8\u0002@\u0003X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0010R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u000e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u0010\u001a\u0004\b\u001f\u0010\u0012¨\u0006#"}, d2 = {"Lcom/avito/android/remote/model/RejectReason;", "Landroid/os/Parcelable;", "", "isCritical", "()Z", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/Action;", "action", "Lcom/avito/android/remote/model/Action;", "getAction", "()Lcom/avito/android/remote/model/Action;", "severity", "Lcom/avito/android/remote/model/text/AttributedText;", SNSConstants.LinkType.SUPPORT, "Lcom/avito/android/remote/model/text/AttributedText;", "getSupport", "()Lcom/avito/android/remote/model/text/AttributedText;", "description", "getDescription", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Action;Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;)V", "Severity", "models_release"}, k = 1, mv = {1, 4, 2})
public final class RejectReason implements Parcelable {
    public static final Parcelable.Creator<RejectReason> CREATOR = new Creator();
    @SerializedName("action")
    @Nullable
    private final Action action;
    @SerializedName("description")
    @Nullable
    private final String description;
    @SerializedName("name")
    @NotNull
    private final String name;
    @SerializedName("severity")
    private final String severity;
    @SerializedName(SNSConstants.LinkType.SUPPORT)
    @Nullable
    private final AttributedText support;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<RejectReason> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final RejectReason createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new RejectReason(parcel.readString(), parcel.readString(), (Action) parcel.readParcelable(RejectReason.class.getClassLoader()), parcel.readString(), (AttributedText) parcel.readParcelable(RejectReason.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final RejectReason[] newArray(int i) {
            return new RejectReason[i];
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/remote/model/RejectReason$Severity;", "", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface Severity {
    }

    public RejectReason(@NotNull String str, @Nullable String str2, @Nullable Action action2, @Nullable String str3, @Nullable AttributedText attributedText) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.name = str;
        this.description = str2;
        this.action = action2;
        this.severity = str3;
        this.support = attributedText;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final Action getAction() {
        return this.action;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final AttributedText getSupport() {
        return this.support;
    }

    public final boolean isCritical() {
        return Intrinsics.areEqual(RejectReasonItemKt.SEVERITY_CRITICAL, this.severity);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.name);
        parcel.writeString(this.description);
        parcel.writeParcelable(this.action, i);
        parcel.writeString(this.severity);
        parcel.writeParcelable(this.support, i);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RejectReason(String str, String str2, Action action2, String str3, AttributedText attributedText, int i, j jVar) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : action2, (i & 8) != 0 ? RejectReasonItemKt.SEVERITY_CRITICAL : str3, (i & 16) != 0 ? null : attributedText);
    }
}
