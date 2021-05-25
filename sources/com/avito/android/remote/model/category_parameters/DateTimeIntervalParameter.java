package com.avito.android.remote.model.category_parameters;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.remote.model.category_parameters.DateTimeParameter;
import com.avito.android.remote.model.category_parameters.base.CategoryParameter;
import com.avito.android.remote.model.text.AttributedText;
import com.google.gson.annotations.SerializedName;
import com.yandex.mobile.ads.video.tracking.Tracker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010%\u001a\u00020\u001c\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010+\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010'\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b-\u0010.J\u0013\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ \u0010\u000e\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\u00108\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u00020\u00108\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001d\u001a\u00020\u001c8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0019\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00020!8F@\u0006¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u001c\u0010%\u001a\u00020\u001c8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b%\u0010\u001e\u001a\u0004\b&\u0010 R\u001e\u0010'\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001e\u0010+\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b+\u0010(\u001a\u0004\b,\u0010*¨\u0006/"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/DateTimeIntervalParameter;", "Lcom/avito/android/remote/model/category_parameters/base/CategoryParameter;", "Lcom/avito/android/remote/model/category_parameters/DateTimeParameter;", "", "initDateTimeIntervalValue", "(Lcom/avito/android/remote/model/category_parameters/DateTimeParameter;)V", "initialize", "()V", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "required", "Z", "getRequired", "()Z", "immutable", "getImmutable", "Lcom/avito/android/remote/model/text/AttributedText;", "motivation", "Lcom/avito/android/remote/model/text/AttributedText;", "getMotivation", "()Lcom/avito/android/remote/model/text/AttributedText;", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "Lkotlin/sequences/Sequence;", "getParameters", "()Lkotlin/sequences/Sequence;", ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, "title", "getTitle", "end", "Lcom/avito/android/remote/model/category_parameters/DateTimeParameter;", "getEnd", "()Lcom/avito/android/remote/model/category_parameters/DateTimeParameter;", Tracker.Events.CREATIVE_START, "getStart", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZZLcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/model/category_parameters/DateTimeParameter;Lcom/avito/android/remote/model/category_parameters/DateTimeParameter;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class DateTimeIntervalParameter extends CategoryParameter {
    public static final Parcelable.Creator<DateTimeIntervalParameter> CREATOR = new Creator();
    @SerializedName("end")
    @Nullable
    private final DateTimeParameter end;
    @SerializedName("id")
    @NotNull
    private final String id;
    @SerializedName("immutable")
    private final boolean immutable;
    @SerializedName("motivation")
    @Nullable
    private final AttributedText motivation;
    @SerializedName("required")
    private final boolean required;
    @SerializedName(Tracker.Events.CREATIVE_START)
    @Nullable
    private final DateTimeParameter start;
    @SerializedName("title")
    @NotNull
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<DateTimeIntervalParameter> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DateTimeIntervalParameter createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            boolean z = false;
            boolean z2 = parcel.readInt() != 0;
            if (parcel.readInt() != 0) {
                z = true;
            }
            return new DateTimeIntervalParameter(readString, readString2, z2, z, (AttributedText) parcel.readParcelable(DateTimeIntervalParameter.class.getClassLoader()), parcel.readInt() != 0 ? DateTimeParameter.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? DateTimeParameter.CREATOR.createFromParcel(parcel) : null);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DateTimeIntervalParameter[] newArray(int i) {
            return new DateTimeIntervalParameter[i];
        }
    }

    public DateTimeIntervalParameter(@NotNull String str, @NotNull String str2, boolean z, boolean z2, @Nullable AttributedText attributedText, @Nullable DateTimeParameter dateTimeParameter, @Nullable DateTimeParameter dateTimeParameter2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        this.id = str;
        this.title = str2;
        this.required = z;
        this.immutable = z2;
        this.motivation = attributedText;
        this.start = dateTimeParameter;
        this.end = dateTimeParameter2;
    }

    private final void initDateTimeIntervalValue(DateTimeParameter dateTimeParameter) {
        if (!dateTimeParameter.hasValue() && dateTimeParameter.getRequired()) {
            dateTimeParameter.setValue(new DateTimeParameter.Value.Timestamp(System.currentTimeMillis()));
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final DateTimeParameter getEnd() {
        return this.end;
    }

    @Override // com.avito.android.remote.model.category_parameters.base.ParameterSlot
    @NotNull
    public String getId() {
        return this.id;
    }

    @Override // com.avito.android.remote.model.category_parameters.base.BaseParameter
    public boolean getImmutable() {
        return this.immutable;
    }

    @Override // com.avito.android.remote.model.category_parameters.base.BaseParameter
    @Nullable
    public AttributedText getMotivation() {
        return this.motivation;
    }

    @NotNull
    public final Sequence<DateTimeParameter> getParameters() {
        return SequencesKt___SequencesKt.filterNotNull(SequencesKt__SequencesKt.sequenceOf(this.start, this.end));
    }

    @Override // com.avito.android.remote.model.category_parameters.base.BaseParameter
    public boolean getRequired() {
        return this.required;
    }

    @Nullable
    public final DateTimeParameter getStart() {
        return this.start;
    }

    @Override // com.avito.android.remote.model.category_parameters.base.BaseParameter
    @NotNull
    public String getTitle() {
        return this.title;
    }

    public final void initialize() {
        DateTimeParameter dateTimeParameter = this.start;
        if (dateTimeParameter != null) {
            initDateTimeIntervalValue(dateTimeParameter);
        }
        DateTimeParameter dateTimeParameter2 = this.end;
        if (dateTimeParameter2 != null) {
            initDateTimeIntervalValue(dateTimeParameter2);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.id);
        parcel.writeString(this.title);
        parcel.writeInt(this.required ? 1 : 0);
        parcel.writeInt(this.immutable ? 1 : 0);
        parcel.writeParcelable(this.motivation, i);
        DateTimeParameter dateTimeParameter = this.start;
        if (dateTimeParameter != null) {
            parcel.writeInt(1);
            dateTimeParameter.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        DateTimeParameter dateTimeParameter2 = this.end;
        if (dateTimeParameter2 != null) {
            parcel.writeInt(1);
            dateTimeParameter2.writeToParcel(parcel, 0);
            return;
        }
        parcel.writeInt(0);
    }
}
