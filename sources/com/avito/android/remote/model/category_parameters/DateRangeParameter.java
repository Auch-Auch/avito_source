package com.avito.android.remote.model.category_parameters;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.remote.model.Sort;
import com.avito.android.remote.model.category_parameters.base.EditableParameter;
import com.avito.android.remote.model.text.AttributedText;
import com.google.gson.annotations.SerializedName;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001d\b\b\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0001CB3\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\n¢\u0006\u0004\bA\u0010BJ\u0010\u0010\u0005\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0006J\u0018\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJB\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u00042\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0006J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0016J \u0010 \u001a\u00020\u001f2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b \u0010!R\u001c\u0010\u000e\u001a\u00020\u00048\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\"\u001a\u0004\b#\u0010\u0006R\u0015\u0010&\u001a\u0004\u0018\u00010\u00038F@\u0006¢\u0006\u0006\u001a\u0004\b$\u0010%R$\u0010(\u001a\u0004\u0018\u00010'8\u0016@\u0016X\u0004¢\u0006\u0012\n\u0004\b(\u0010)\u0012\u0004\b,\u0010-\u001a\u0004\b*\u0010+R\"\u0010.\u001a\u00020\n8\u0016@\u0016XD¢\u0006\u0012\n\u0004\b.\u0010/\u0012\u0004\b2\u0010-\u001a\u0004\b0\u00101R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u00103\u001a\u0004\b4\u0010\fR\u001c\u0010\r\u001a\u00020\u00048\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\r\u0010\"\u001a\u0004\b5\u0010\u0006R*\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u000f\u00106\u001a\u0004\b7\u0010\t\"\u0004\b8\u00109R\u0015\u0010;\u001a\u0004\u0018\u00010\u00038F@\u0006¢\u0006\u0006\u001a\u0004\b:\u0010%R\"\u0010<\u001a\u00020\n8\u0016@\u0016XD¢\u0006\u0012\n\u0004\b<\u0010/\u0012\u0004\b>\u0010-\u001a\u0004\b=\u00101R\u0018\u0010@\u001a\u0004\u0018\u00010\n8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b?\u0010\f¨\u0006D"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/DateRangeParameter;", "Lcom/avito/android/remote/model/category_parameters/base/EditableParameter;", "", "Lcom/avito/android/remote/model/category_parameters/DateRangeParameter$FormattedDateParameter;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "()Ljava/util/List;", "", "component4", "()Ljava/lang/Boolean;", "id", "title", "_value", "resetDisabled", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;)Lcom/avito/android/remote/model/category_parameters/DateRangeParameter;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getTitle", "getCheckIn", "()Lcom/avito/android/remote/model/category_parameters/DateRangeParameter$FormattedDateParameter;", "checkIn", "Lcom/avito/android/remote/model/text/AttributedText;", "motivation", "Lcom/avito/android/remote/model/text/AttributedText;", "getMotivation", "()Lcom/avito/android/remote/model/text/AttributedText;", "getMotivation$annotations", "()V", "immutable", "Z", "getImmutable", "()Z", "getImmutable$annotations", "Ljava/lang/Boolean;", "getResetDisabled", "getId", "Ljava/util/List;", "get_value", "set_value", "(Ljava/util/List;)V", "getCheckOut", "checkOut", "required", "getRequired", "getRequired$annotations", "getUpdatesForm", "updatesForm", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;)V", "FormattedDateParameter", "models_release"}, k = 1, mv = {1, 4, 2})
public final class DateRangeParameter extends EditableParameter<List<? extends FormattedDateParameter>> {
    public static final Parcelable.Creator<DateRangeParameter> CREATOR = new Creator();
    @SerializedName(ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT)
    @Nullable
    private List<FormattedDateParameter> _value;
    @SerializedName("id")
    @NotNull
    private final String id;
    private final boolean immutable;
    @Nullable
    private final AttributedText motivation;
    private final boolean required;
    @SerializedName("resetDisabled")
    @Nullable
    private final Boolean resetDisabled;
    @SerializedName("title")
    @NotNull
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<DateRangeParameter> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DateRangeParameter createFromParcel(@NotNull Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            Boolean bool = null;
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add(FormattedDateParameter.CREATOR.createFromParcel(parcel));
                    readInt--;
                }
            } else {
                arrayList = null;
            }
            if (parcel.readInt() != 0) {
                bool = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new DateRangeParameter(readString, readString2, arrayList, bool);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DateRangeParameter[] newArray(int i) {
            return new DateRangeParameter[i];
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001IB1\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u000e¢\u0006\u0004\bG\u0010HJ\u0015\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\nJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\nJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010JD\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u000eHÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0018\u0010\nJ\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÖ\u0003¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b!\u0010\u001bJ \u0010&\u001a\u00020%2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b&\u0010'R\"\u0010(\u001a\u00020\u001e8\u0016@\u0016XD¢\u0006\u0012\n\u0004\b(\u0010)\u0012\u0004\b,\u0010-\u001a\u0004\b*\u0010+R$\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010.\u001a\u0004\b/\u0010\n\"\u0004\b0\u00101R$\u00103\u001a\u0004\u0018\u0001028\u0016@\u0016X\u0004¢\u0006\u0012\n\u0004\b3\u00104\u0012\u0004\b7\u0010-\u001a\u0004\b5\u00106R\"\u00108\u001a\u00020\u001e8\u0016@\u0016XD¢\u0006\u0012\n\u0004\b8\u0010)\u0012\u0004\b:\u0010-\u001a\u0004\b9\u0010+R\u001c\u0010\u0013\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010.\u001a\u0004\b;\u0010\nR\u001c\u0010\u0015\u001a\u00020\u000e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010<\u001a\u0004\b=\u0010\u0010R\u0016\u0010A\u001a\u00020>8B@\u0002X\u0004¢\u0006\u0006\u001a\u0004\b?\u0010@R\u0018\u0010D\u001a\u0004\u0018\u00010\u001e8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\bB\u0010CR\u001c\u0010\u0012\u001a\u00020\u00028\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0012\u0010.\u001a\u0004\bE\u0010\nR\u001c\u0010\u0011\u001a\u00020\u00028\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0011\u0010.\u001a\u0004\bF\u0010\n¨\u0006J"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/DateRangeParameter$FormattedDateParameter;", "Lcom/avito/android/remote/model/category_parameters/base/EditableParameter;", "", "Ljava/util/Date;", Sort.DATE, "dateToString", "(Ljava/util/Date;)Ljava/lang/String;", "toDate", "()Ljava/util/Date;", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "Lcom/avito/android/remote/model/category_parameters/DateRangeParameter$FormattedDateParameter$Displaying;", "component5", "()Lcom/avito/android/remote/model/category_parameters/DateRangeParameter$FormattedDateParameter$Displaying;", "id", "title", "format", "_value", "displaying", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/category_parameters/DateRangeParameter$FormattedDateParameter$Displaying;)Lcom/avito/android/remote/model/category_parameters/DateRangeParameter$FormattedDateParameter;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "required", "Z", "getRequired", "()Z", "getRequired$annotations", "()V", "Ljava/lang/String;", "get_value", "set_value", "(Ljava/lang/String;)V", "Lcom/avito/android/remote/model/text/AttributedText;", "motivation", "Lcom/avito/android/remote/model/text/AttributedText;", "getMotivation", "()Lcom/avito/android/remote/model/text/AttributedText;", "getMotivation$annotations", "immutable", "getImmutable", "getImmutable$annotations", "getFormat", "Lcom/avito/android/remote/model/category_parameters/DateRangeParameter$FormattedDateParameter$Displaying;", "getDisplaying", "Ljava/text/SimpleDateFormat;", "getDateFormat", "()Ljava/text/SimpleDateFormat;", "dateFormat", "getUpdatesForm", "()Ljava/lang/Boolean;", "updatesForm", "getTitle", "getId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/category_parameters/DateRangeParameter$FormattedDateParameter$Displaying;)V", "Displaying", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class FormattedDateParameter extends EditableParameter<String> {
        public static final Parcelable.Creator<FormattedDateParameter> CREATOR = new Creator();
        @SerializedName("value")
        @Nullable
        private String _value;
        @SerializedName("displaying")
        @NotNull
        private final Displaying displaying;
        @SerializedName("format")
        @NotNull
        private final String format;
        @SerializedName("id")
        @NotNull
        private final String id;
        private final boolean immutable;
        @Nullable
        private final AttributedText motivation;
        private final boolean required;
        @SerializedName("title")
        @NotNull
        private final String title;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<FormattedDateParameter> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final FormattedDateParameter createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new FormattedDateParameter(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), Displaying.CREATOR.createFromParcel(parcel));
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final FormattedDateParameter[] newArray(int i) {
                return new FormattedDateParameter[i];
            }
        }

        @Parcelize
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0011\u0010\u000bJ \u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0005\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004¨\u0006\u001c"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/DateRangeParameter$FormattedDateParameter$Displaying;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "type", "copy", "(Ljava/lang/String;)Lcom/avito/android/remote/model/category_parameters/DateRangeParameter$FormattedDateParameter$Displaying;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getType", "<init>", "(Ljava/lang/String;)V", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Displaying implements Parcelable {
            public static final Parcelable.Creator<Displaying> CREATOR = new Creator();
            @SerializedName("type")
            @NotNull
            private final String type;

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<Displaying> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Displaying createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    return new Displaying(parcel.readString());
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Displaying[] newArray(int i) {
                    return new Displaying[i];
                }
            }

            public Displaying(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, "type");
                this.type = str;
            }

            public static /* synthetic */ Displaying copy$default(Displaying displaying, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = displaying.type;
                }
                return displaying.copy(str);
            }

            @NotNull
            public final String component1() {
                return this.type;
            }

            @NotNull
            public final Displaying copy(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, "type");
                return new Displaying(str);
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Override // java.lang.Object
            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof Displaying) && Intrinsics.areEqual(this.type, ((Displaying) obj).type);
                }
                return true;
            }

            @NotNull
            public final String getType() {
                return this.type;
            }

            @Override // java.lang.Object
            public int hashCode() {
                String str = this.type;
                if (str != null) {
                    return str.hashCode();
                }
                return 0;
            }

            @Override // java.lang.Object
            @NotNull
            public String toString() {
                return a.t(a.L("Displaying(type="), this.type, ")");
            }

            @Override // android.os.Parcelable
            public void writeToParcel(@NotNull Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.writeString(this.type);
            }
        }

        public FormattedDateParameter(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4, @NotNull Displaying displaying2) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "title");
            Intrinsics.checkNotNullParameter(str3, "format");
            Intrinsics.checkNotNullParameter(displaying2, "displaying");
            this.id = str;
            this.title = str2;
            this.format = str3;
            this._value = str4;
            this.displaying = displaying2;
        }

        public static /* synthetic */ FormattedDateParameter copy$default(FormattedDateParameter formattedDateParameter, String str, String str2, String str3, String str4, Displaying displaying2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = formattedDateParameter.getId();
            }
            if ((i & 2) != 0) {
                str2 = formattedDateParameter.getTitle();
            }
            if ((i & 4) != 0) {
                str3 = formattedDateParameter.format;
            }
            if ((i & 8) != 0) {
                str4 = formattedDateParameter.get_value();
            }
            if ((i & 16) != 0) {
                displaying2 = formattedDateParameter.displaying;
            }
            return formattedDateParameter.copy(str, str2, str3, str4, displaying2);
        }

        private final SimpleDateFormat getDateFormat() {
            return new SimpleDateFormat(this.format, Locale.getDefault());
        }

        public static /* synthetic */ void getImmutable$annotations() {
        }

        public static /* synthetic */ void getMotivation$annotations() {
        }

        public static /* synthetic */ void getRequired$annotations() {
        }

        @NotNull
        public final String component1() {
            return getId();
        }

        @NotNull
        public final String component2() {
            return getTitle();
        }

        @NotNull
        public final String component3() {
            return this.format;
        }

        @Nullable
        public final String component4() {
            return get_value();
        }

        @NotNull
        public final Displaying component5() {
            return this.displaying;
        }

        @NotNull
        public final FormattedDateParameter copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4, @NotNull Displaying displaying2) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "title");
            Intrinsics.checkNotNullParameter(str3, "format");
            Intrinsics.checkNotNullParameter(displaying2, "displaying");
            return new FormattedDateParameter(str, str2, str3, str4, displaying2);
        }

        @NotNull
        public final String dateToString(@NotNull Date date) {
            Intrinsics.checkNotNullParameter(date, Sort.DATE);
            String format2 = getDateFormat().format(date);
            Intrinsics.checkNotNullExpressionValue(format2, "dateFormat.format(date)");
            return format2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.avito.android.remote.model.category_parameters.base.CategoryParameter, java.lang.Object
        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof FormattedDateParameter)) {
                return false;
            }
            FormattedDateParameter formattedDateParameter = (FormattedDateParameter) obj;
            return Intrinsics.areEqual(getId(), formattedDateParameter.getId()) && Intrinsics.areEqual(getTitle(), formattedDateParameter.getTitle()) && Intrinsics.areEqual(this.format, formattedDateParameter.format) && Intrinsics.areEqual(get_value(), formattedDateParameter.get_value()) && Intrinsics.areEqual(this.displaying, formattedDateParameter.displaying);
        }

        @NotNull
        public final Displaying getDisplaying() {
            return this.displaying;
        }

        @NotNull
        public final String getFormat() {
            return this.format;
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

        @Override // com.avito.android.remote.model.category_parameters.base.BaseParameter
        public boolean getRequired() {
            return this.required;
        }

        @Override // com.avito.android.remote.model.category_parameters.base.BaseParameter
        @NotNull
        public String getTitle() {
            return this.title;
        }

        @Override // com.avito.android.remote.model.category_parameters.base.BaseEditableParameter
        @Nullable
        public Boolean getUpdatesForm() {
            return Boolean.TRUE;
        }

        @Override // com.avito.android.remote.model.category_parameters.base.CategoryParameter, java.lang.Object
        public int hashCode() {
            String id2 = getId();
            int i = 0;
            int hashCode = (id2 != null ? id2.hashCode() : 0) * 31;
            String title2 = getTitle();
            int hashCode2 = (hashCode + (title2 != null ? title2.hashCode() : 0)) * 31;
            String str = this.format;
            int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = get_value();
            int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
            Displaying displaying2 = this.displaying;
            if (displaying2 != null) {
                i = displaying2.hashCode();
            }
            return hashCode4 + i;
        }

        @Nullable
        public final Date toDate() {
            if (getValue() != null) {
                return getDateFormat().parse((String) getValue());
            }
            return null;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("FormattedDateParameter(id=");
            L.append(getId());
            L.append(", title=");
            L.append(getTitle());
            L.append(", format=");
            L.append(this.format);
            L.append(", _value=");
            L.append(get_value());
            L.append(", displaying=");
            L.append(this.displaying);
            L.append(")");
            return L.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.id);
            parcel.writeString(this.title);
            parcel.writeString(this.format);
            parcel.writeString(this._value);
            this.displaying.writeToParcel(parcel, 0);
        }

        @Override // com.avito.android.remote.model.category_parameters.base.EditableParameter
        @Nullable
        public String get_value() {
            return this._value;
        }

        public void set_value(@Nullable String str) {
            this._value = str;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DateRangeParameter(String str, String str2, List list, Boolean bool, int i, j jVar) {
        this(str, str2, list, (i & 8) != 0 ? Boolean.FALSE : bool);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.remote.model.category_parameters.DateRangeParameter */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DateRangeParameter copy$default(DateRangeParameter dateRangeParameter, String str, String str2, List list, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = dateRangeParameter.getId();
        }
        if ((i & 2) != 0) {
            str2 = dateRangeParameter.getTitle();
        }
        if ((i & 4) != 0) {
            list = dateRangeParameter.get_value();
        }
        if ((i & 8) != 0) {
            bool = dateRangeParameter.resetDisabled;
        }
        return dateRangeParameter.copy(str, str2, list, bool);
    }

    public static /* synthetic */ void getImmutable$annotations() {
    }

    public static /* synthetic */ void getMotivation$annotations() {
    }

    public static /* synthetic */ void getRequired$annotations() {
    }

    @NotNull
    public final String component1() {
        return getId();
    }

    @NotNull
    public final String component2() {
        return getTitle();
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.util.List<? extends com.avito.android.remote.model.category_parameters.DateRangeParameter$FormattedDateParameter>, java.util.List<com.avito.android.remote.model.category_parameters.DateRangeParameter$FormattedDateParameter> */
    @Nullable
    public final List<FormattedDateParameter> component3() {
        return get_value();
    }

    @Nullable
    public final Boolean component4() {
        return this.resetDisabled;
    }

    @NotNull
    public final DateRangeParameter copy(@NotNull String str, @NotNull String str2, @Nullable List<FormattedDateParameter> list, @Nullable Boolean bool) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        return new DateRangeParameter(str, str2, list, bool);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.avito.android.remote.model.category_parameters.base.CategoryParameter, java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DateRangeParameter)) {
            return false;
        }
        DateRangeParameter dateRangeParameter = (DateRangeParameter) obj;
        return Intrinsics.areEqual(getId(), dateRangeParameter.getId()) && Intrinsics.areEqual(getTitle(), dateRangeParameter.getTitle()) && Intrinsics.areEqual(get_value(), dateRangeParameter.get_value()) && Intrinsics.areEqual(this.resetDisabled, dateRangeParameter.resetDisabled);
    }

    @Nullable
    public final FormattedDateParameter getCheckIn() {
        List list = (List) getValue();
        if (list != null) {
            return (FormattedDateParameter) CollectionsKt___CollectionsKt.getOrNull(list, 0);
        }
        return null;
    }

    @Nullable
    public final FormattedDateParameter getCheckOut() {
        List list = (List) getValue();
        if (list != null) {
            return (FormattedDateParameter) CollectionsKt___CollectionsKt.getOrNull(list, 1);
        }
        return null;
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

    @Override // com.avito.android.remote.model.category_parameters.base.BaseParameter
    public boolean getRequired() {
        return this.required;
    }

    @Nullable
    public final Boolean getResetDisabled() {
        return this.resetDisabled;
    }

    @Override // com.avito.android.remote.model.category_parameters.base.BaseParameter
    @NotNull
    public String getTitle() {
        return this.title;
    }

    @Override // com.avito.android.remote.model.category_parameters.base.BaseEditableParameter
    @Nullable
    public Boolean getUpdatesForm() {
        return Boolean.TRUE;
    }

    @Override // com.avito.android.remote.model.category_parameters.base.CategoryParameter, java.lang.Object
    public int hashCode() {
        String id2 = getId();
        int i = 0;
        int hashCode = (id2 != null ? id2.hashCode() : 0) * 31;
        String title2 = getTitle();
        int hashCode2 = (hashCode + (title2 != null ? title2.hashCode() : 0)) * 31;
        List<? extends FormattedDateParameter> list = get_value();
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        Boolean bool = this.resetDisabled;
        if (bool != null) {
            i = bool.hashCode();
        }
        return hashCode3 + i;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.avito.android.remote.model.category_parameters.base.EditableParameter
    public /* bridge */ /* synthetic */ void set_value(List<? extends FormattedDateParameter> list) {
        set_value((List<FormattedDateParameter>) list);
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("DateRangeParameter(id=");
        L.append(getId());
        L.append(", title=");
        L.append(getTitle());
        L.append(", _value=");
        L.append(get_value());
        L.append(", resetDisabled=");
        return a.o(L, this.resetDisabled, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.id);
        parcel.writeString(this.title);
        List<FormattedDateParameter> list = this._value;
        if (list != null) {
            Iterator l0 = a.l0(parcel, 1, list);
            while (l0.hasNext()) {
                ((FormattedDateParameter) l0.next()).writeToParcel(parcel, 0);
            }
        } else {
            parcel.writeInt(0);
        }
        Boolean bool = this.resetDisabled;
        if (bool != null) {
            a.G0(parcel, 1, bool);
        } else {
            parcel.writeInt(0);
        }
    }

    public DateRangeParameter(@NotNull String str, @NotNull String str2, @Nullable List<FormattedDateParameter> list, @Nullable Boolean bool) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        this.id = str;
        this.title = str2;
        this._value = list;
        this.resetDisabled = bool;
    }

    /* Return type fixed from 'java.util.List<com.avito.android.remote.model.category_parameters.DateRangeParameter$FormattedDateParameter>' to match base method */
    @Override // com.avito.android.remote.model.category_parameters.base.EditableParameter
    @Nullable
    public List<? extends FormattedDateParameter> get_value() {
        return this._value;
    }

    public void set_value(@Nullable List<FormattedDateParameter> list) {
        this._value = list;
    }
}
