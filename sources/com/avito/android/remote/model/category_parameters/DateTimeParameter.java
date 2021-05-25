package com.avito.android.remote.model.category_parameters;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.category_parameters.base.EditableParameter;
import com.avito.android.remote.model.category_parameters.base.HasConstraints;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.util.Parcels;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u001d\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002XYBs\u0012\u0006\u0010$\u001a\u00020\n\u0012\u0006\u0010%\u001a\u00020\n\u0012\u0006\u0010&\u001a\u00020\u0004\u0012\u0006\u0010'\u001a\u00020\u0004\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010)\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010*\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010+\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010,\u001a\u0004\u0018\u00010\u001a\u0012\b\u0010-\u001a\u0004\u0018\u00010\u001d\u0012\u000e\u0010.\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 ¢\u0006\u0004\bV\u0010WJ\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\r\u0010\fJ\u0010\u0010\u000e\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0006J\u0010\u0010\u000f\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0006J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u001dHÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010\"\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 HÆ\u0003¢\u0006\u0004\b\"\u0010#J\u0001\u0010/\u001a\u00020\u00002\b\b\u0002\u0010$\u001a\u00020\n2\b\b\u0002\u0010%\u001a\u00020\n2\b\b\u0002\u0010&\u001a\u00020\u00042\b\b\u0002\u0010'\u001a\u00020\u00042\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u001d2\u0010\b\u0002\u0010.\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 HÆ\u0001¢\u0006\u0004\b/\u00100J\u0010\u00101\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b1\u0010\fJ\u0010\u00103\u001a\u000202HÖ\u0001¢\u0006\u0004\b3\u00104J\u001a\u00107\u001a\u00020\u00042\b\u00106\u001a\u0004\u0018\u000105HÖ\u0003¢\u0006\u0004\b7\u00108J\u0010\u00109\u001a\u000202HÖ\u0001¢\u0006\u0004\b9\u00104J \u0010>\u001a\u00020=2\u0006\u0010;\u001a\u00020:2\u0006\u0010<\u001a\u000202HÖ\u0001¢\u0006\u0004\b>\u0010?R\u001c\u0010'\u001a\u00020\u00048\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b'\u0010@\u001a\u0004\bA\u0010\u0006R\u001e\u0010,\u001a\u0004\u0018\u00010\u001a8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b,\u0010B\u001a\u0004\bC\u0010\u001cR\u001e\u0010)\u001a\u0004\u0018\u00010\u00048\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b)\u0010D\u001a\u0004\bE\u0010\u0014R$\u0010*\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b*\u0010F\u001a\u0004\bG\u0010\u0016\"\u0004\bH\u0010IR\u001e\u0010(\u001a\u0004\u0018\u00010\u00108\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b(\u0010J\u001a\u0004\bK\u0010\u0012R\u001c\u0010$\u001a\u00020\n8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b$\u0010L\u001a\u0004\bM\u0010\fR$\u0010.\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b.\u0010N\u001a\u0004\bO\u0010#R\u001e\u0010+\u001a\u0004\u0018\u00010\u00178\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b+\u0010P\u001a\u0004\bQ\u0010\u0019R\u001c\u0010&\u001a\u00020\u00048\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b&\u0010@\u001a\u0004\bR\u0010\u0006R\u001e\u0010-\u001a\u0004\u0018\u00010\u001d8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b-\u0010S\u001a\u0004\bT\u0010\u001fR\u001c\u0010%\u001a\u00020\n8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b%\u0010L\u001a\u0004\bU\u0010\f¨\u0006Z"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/DateTimeParameter;", "Lcom/avito/android/remote/model/category_parameters/base/EditableParameter;", "Lcom/avito/android/remote/model/category_parameters/DateTimeParameter$Value;", "Lcom/avito/android/remote/model/category_parameters/base/HasConstraints;", "", "isPresentTime", "()Z", "", "getTimestamp", "()Ljava/lang/Long;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "Lcom/avito/android/remote/model/text/AttributedText;", "component5", "()Lcom/avito/android/remote/model/text/AttributedText;", "component6", "()Ljava/lang/Boolean;", "component7", "()Lcom/avito/android/remote/model/category_parameters/DateTimeParameter$Value;", "Lcom/avito/android/remote/model/category_parameters/DateTimeParameter$PresentTimeOptions;", "component8", "()Lcom/avito/android/remote/model/category_parameters/DateTimeParameter$PresentTimeOptions;", "Lcom/avito/android/remote/model/category_parameters/SelectionType;", "component9", "()Lcom/avito/android/remote/model/category_parameters/SelectionType;", "Lcom/avito/android/remote/model/category_parameters/Restrictions;", "component10", "()Lcom/avito/android/remote/model/category_parameters/Restrictions;", "", "Lcom/avito/android/remote/model/category_parameters/Constraint;", "component11", "()Ljava/util/List;", "id", "title", "required", "immutable", "motivation", "updatesForm", "_value", "presentTime", "selectionType", "restrictions", "constraints", "copy", "(Ljava/lang/String;Ljava/lang/String;ZZLcom/avito/android/remote/model/text/AttributedText;Ljava/lang/Boolean;Lcom/avito/android/remote/model/category_parameters/DateTimeParameter$Value;Lcom/avito/android/remote/model/category_parameters/DateTimeParameter$PresentTimeOptions;Lcom/avito/android/remote/model/category_parameters/SelectionType;Lcom/avito/android/remote/model/category_parameters/Restrictions;Ljava/util/List;)Lcom/avito/android/remote/model/category_parameters/DateTimeParameter;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Z", "getImmutable", "Lcom/avito/android/remote/model/category_parameters/SelectionType;", "getSelectionType", "Ljava/lang/Boolean;", "getUpdatesForm", "Lcom/avito/android/remote/model/category_parameters/DateTimeParameter$Value;", "get_value", "set_value", "(Lcom/avito/android/remote/model/category_parameters/DateTimeParameter$Value;)V", "Lcom/avito/android/remote/model/text/AttributedText;", "getMotivation", "Ljava/lang/String;", "getId", "Ljava/util/List;", "getConstraints", "Lcom/avito/android/remote/model/category_parameters/DateTimeParameter$PresentTimeOptions;", "getPresentTime", "getRequired", "Lcom/avito/android/remote/model/category_parameters/Restrictions;", "getRestrictions", "getTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZZLcom/avito/android/remote/model/text/AttributedText;Ljava/lang/Boolean;Lcom/avito/android/remote/model/category_parameters/DateTimeParameter$Value;Lcom/avito/android/remote/model/category_parameters/DateTimeParameter$PresentTimeOptions;Lcom/avito/android/remote/model/category_parameters/SelectionType;Lcom/avito/android/remote/model/category_parameters/Restrictions;Ljava/util/List;)V", "PresentTimeOptions", "Value", "models_release"}, k = 1, mv = {1, 4, 2})
public final class DateTimeParameter extends EditableParameter<Value> implements HasConstraints {
    public static final Parcelable.Creator<DateTimeParameter> CREATOR = new Creator();
    @SerializedName("value")
    @Nullable
    private Value _value;
    @SerializedName("constraints")
    @Nullable
    private final List<Constraint> constraints;
    @SerializedName("id")
    @NotNull
    private final String id;
    @SerializedName("immutable")
    private final boolean immutable;
    @SerializedName("motivation")
    @Nullable
    private final AttributedText motivation;
    @SerializedName("presentTimeOptions")
    @Nullable
    private final PresentTimeOptions presentTime;
    @SerializedName("required")
    private final boolean required;
    @SerializedName("restrictions")
    @Nullable
    private final Restrictions restrictions;
    @SerializedName("selectionType")
    @Nullable
    private final SelectionType selectionType;
    @SerializedName("title")
    @NotNull
    private final String title;
    @SerializedName("updatesForm")
    @Nullable
    private final Boolean updatesForm;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<DateTimeParameter> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DateTimeParameter createFromParcel(@NotNull Parcel parcel) {
            Boolean bool;
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            boolean z = true;
            boolean z2 = parcel.readInt() != 0;
            boolean z3 = parcel.readInt() != 0;
            AttributedText attributedText = (AttributedText) parcel.readParcelable(DateTimeParameter.class.getClassLoader());
            if (parcel.readInt() != 0) {
                if (parcel.readInt() == 0) {
                    z = false;
                }
                bool = Boolean.valueOf(z);
            } else {
                bool = null;
            }
            Value value = (Value) parcel.readParcelable(DateTimeParameter.class.getClassLoader());
            PresentTimeOptions presentTimeOptions = (PresentTimeOptions) parcel.readParcelable(DateTimeParameter.class.getClassLoader());
            SelectionType selectionType = (SelectionType) parcel.readParcelable(DateTimeParameter.class.getClassLoader());
            Restrictions restrictions = (Restrictions) parcel.readParcelable(DateTimeParameter.class.getClassLoader());
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList2.add((Constraint) parcel.readParcelable(DateTimeParameter.class.getClassLoader()));
                    readInt--;
                }
                arrayList = arrayList2;
            } else {
                arrayList = null;
            }
            return new DateTimeParameter(readString, readString2, z2, z3, attributedText, bool, value, presentTimeOptions, selectionType, restrictions, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DateTimeParameter[] newArray(int i) {
            return new DateTimeParameter[i];
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/DateTimeParameter$PresentTimeOptions;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class PresentTimeOptions implements Parcelable {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<PresentTimeOptions> CREATOR = Parcels.creator(DateTimeParameter$PresentTimeOptions$Companion$CREATOR$1.INSTANCE);
        @NotNull
        public static final Companion Companion = new Companion(null);
        @SerializedName("title")
        @NotNull
        private final String title;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/DateTimeParameter$PresentTimeOptions$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/category_parameters/DateTimeParameter$PresentTimeOptions;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(j jVar) {
                this();
            }
        }

        public PresentTimeOptions(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "title");
            this.title = str;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "dest");
            parcel.writeString(this.title);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\r\u000eB\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\n\u0001\u0002\u000f\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/DateTimeParameter$Value;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "<init>", "()V", "PresentTime", "Timestamp", "Lcom/avito/android/remote/model/category_parameters/DateTimeParameter$Value$Timestamp;", "Lcom/avito/android/remote/model/category_parameters/DateTimeParameter$Value$PresentTime;", "models_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class Value implements Parcelable {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/DateTimeParameter$Value$PresentTime;", "Lcom/avito/android/remote/model/category_parameters/DateTimeParameter$Value;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class PresentTime extends Value {
            @JvmField
            @NotNull
            public static final Parcelable.Creator<PresentTime> CREATOR = Parcels.creator(DateTimeParameter$Value$PresentTime$CREATOR$1.INSTANCE);
            @NotNull
            public static final PresentTime INSTANCE = new PresentTime();

            private PresentTime() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u000f\u0012\u0006\u0010\r\u001a\u00020\t¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\f\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\r\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001a\u001a\u0004\b\u001b\u0010\u000b¨\u0006\u001f"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/DateTimeParameter$Value$Timestamp;", "Lcom/avito/android/remote/model/category_parameters/DateTimeParameter$Value;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "toSeconds", "()J", "component1", "timestamp", "copy", "(J)Lcom/avito/android/remote/model/category_parameters/DateTimeParameter$Value$Timestamp;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getTimestamp", "<init>", "(J)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Timestamp extends Value {
            @JvmField
            @NotNull
            public static final Parcelable.Creator<Timestamp> CREATOR = Parcels.creator(DateTimeParameter$Value$Timestamp$Companion$CREATOR$1.INSTANCE);
            @NotNull
            public static final Companion Companion = new Companion(null);
            private final long timestamp;

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/DateTimeParameter$Value$Timestamp$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/category_parameters/DateTimeParameter$Value$Timestamp;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
            public static final class Companion {
                private Companion() {
                }

                public /* synthetic */ Companion(j jVar) {
                    this();
                }
            }

            public Timestamp(long j) {
                super(null);
                this.timestamp = j;
            }

            public static /* synthetic */ Timestamp copy$default(Timestamp timestamp2, long j, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = timestamp2.timestamp;
                }
                return timestamp2.copy(j);
            }

            public final long component1() {
                return this.timestamp;
            }

            @NotNull
            public final Timestamp copy(long j) {
                return new Timestamp(j);
            }

            @Override // java.lang.Object
            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof Timestamp) && this.timestamp == ((Timestamp) obj).timestamp;
                }
                return true;
            }

            public final long getTimestamp() {
                return this.timestamp;
            }

            @Override // java.lang.Object
            public int hashCode() {
                return c.a(this.timestamp);
            }

            public final long toSeconds() {
                return TimeUnit.MILLISECONDS.toSeconds(this.timestamp);
            }

            @Override // java.lang.Object
            @NotNull
            public String toString() {
                return a.l(a.L("Timestamp(timestamp="), this.timestamp, ")");
            }

            @Override // com.avito.android.remote.model.category_parameters.DateTimeParameter.Value, android.os.Parcelable
            public void writeToParcel(@NotNull Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.writeLong(this.timestamp);
            }
        }

        private Value() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
        }

        public /* synthetic */ Value(j jVar) {
            this();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r12v0, resolved type: java.util.List<? extends com.avito.android.remote.model.category_parameters.Constraint> */
    /* JADX WARN: Multi-variable type inference failed */
    public DateTimeParameter(@NotNull String str, @NotNull String str2, boolean z, boolean z2, @Nullable AttributedText attributedText, @Nullable Boolean bool, @Nullable Value value, @Nullable PresentTimeOptions presentTimeOptions, @Nullable SelectionType selectionType2, @Nullable Restrictions restrictions2, @Nullable List<? extends Constraint> list) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        this.id = str;
        this.title = str2;
        this.required = z;
        this.immutable = z2;
        this.motivation = attributedText;
        this.updatesForm = bool;
        this._value = value;
        this.presentTime = presentTimeOptions;
        this.selectionType = selectionType2;
        this.restrictions = restrictions2;
        this.constraints = list;
    }

    public static /* synthetic */ DateTimeParameter copy$default(DateTimeParameter dateTimeParameter, String str, String str2, boolean z, boolean z2, AttributedText attributedText, Boolean bool, Value value, PresentTimeOptions presentTimeOptions, SelectionType selectionType2, Restrictions restrictions2, List list, int i, Object obj) {
        return dateTimeParameter.copy((i & 1) != 0 ? dateTimeParameter.getId() : str, (i & 2) != 0 ? dateTimeParameter.getTitle() : str2, (i & 4) != 0 ? dateTimeParameter.getRequired() : z, (i & 8) != 0 ? dateTimeParameter.getImmutable() : z2, (i & 16) != 0 ? dateTimeParameter.getMotivation() : attributedText, (i & 32) != 0 ? dateTimeParameter.getUpdatesForm() : bool, (i & 64) != 0 ? dateTimeParameter.get_value() : value, (i & 128) != 0 ? dateTimeParameter.presentTime : presentTimeOptions, (i & 256) != 0 ? dateTimeParameter.selectionType : selectionType2, (i & 512) != 0 ? dateTimeParameter.restrictions : restrictions2, (i & 1024) != 0 ? dateTimeParameter.getConstraints() : list);
    }

    @NotNull
    public final String component1() {
        return getId();
    }

    @Nullable
    public final Restrictions component10() {
        return this.restrictions;
    }

    @Nullable
    public final List<Constraint> component11() {
        return getConstraints();
    }

    @NotNull
    public final String component2() {
        return getTitle();
    }

    public final boolean component3() {
        return getRequired();
    }

    public final boolean component4() {
        return getImmutable();
    }

    @Nullable
    public final AttributedText component5() {
        return getMotivation();
    }

    @Nullable
    public final Boolean component6() {
        return getUpdatesForm();
    }

    @Nullable
    public final Value component7() {
        return get_value();
    }

    @Nullable
    public final PresentTimeOptions component8() {
        return this.presentTime;
    }

    @Nullable
    public final SelectionType component9() {
        return this.selectionType;
    }

    @NotNull
    public final DateTimeParameter copy(@NotNull String str, @NotNull String str2, boolean z, boolean z2, @Nullable AttributedText attributedText, @Nullable Boolean bool, @Nullable Value value, @Nullable PresentTimeOptions presentTimeOptions, @Nullable SelectionType selectionType2, @Nullable Restrictions restrictions2, @Nullable List<? extends Constraint> list) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        return new DateTimeParameter(str, str2, z, z2, attributedText, bool, value, presentTimeOptions, selectionType2, restrictions2, list);
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
        if (!(obj instanceof DateTimeParameter)) {
            return false;
        }
        DateTimeParameter dateTimeParameter = (DateTimeParameter) obj;
        return Intrinsics.areEqual(getId(), dateTimeParameter.getId()) && Intrinsics.areEqual(getTitle(), dateTimeParameter.getTitle()) && getRequired() == dateTimeParameter.getRequired() && getImmutable() == dateTimeParameter.getImmutable() && Intrinsics.areEqual(getMotivation(), dateTimeParameter.getMotivation()) && Intrinsics.areEqual(getUpdatesForm(), dateTimeParameter.getUpdatesForm()) && Intrinsics.areEqual(get_value(), dateTimeParameter.get_value()) && Intrinsics.areEqual(this.presentTime, dateTimeParameter.presentTime) && Intrinsics.areEqual(this.selectionType, dateTimeParameter.selectionType) && Intrinsics.areEqual(this.restrictions, dateTimeParameter.restrictions) && Intrinsics.areEqual(getConstraints(), dateTimeParameter.getConstraints());
    }

    @Override // com.avito.android.remote.model.category_parameters.base.HasConstraints
    @Nullable
    public List<Constraint> getConstraints() {
        return this.constraints;
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

    @Nullable
    public final PresentTimeOptions getPresentTime() {
        return this.presentTime;
    }

    @Override // com.avito.android.remote.model.category_parameters.base.BaseParameter
    public boolean getRequired() {
        return this.required;
    }

    @Nullable
    public final Restrictions getRestrictions() {
        return this.restrictions;
    }

    @Nullable
    public final SelectionType getSelectionType() {
        return this.selectionType;
    }

    @Nullable
    public final Long getTimestamp() {
        Value value = (Value) getValue();
        if (value == null || !(value instanceof Value.Timestamp)) {
            return null;
        }
        return Long.valueOf(((Value.Timestamp) value).getTimestamp());
    }

    @Override // com.avito.android.remote.model.category_parameters.base.BaseParameter
    @NotNull
    public String getTitle() {
        return this.title;
    }

    @Override // com.avito.android.remote.model.category_parameters.base.BaseEditableParameter
    @Nullable
    public Boolean getUpdatesForm() {
        return this.updatesForm;
    }

    @Override // com.avito.android.remote.model.category_parameters.base.CategoryParameter, java.lang.Object
    public int hashCode() {
        String id2 = getId();
        int i = 0;
        int hashCode = (id2 != null ? id2.hashCode() : 0) * 31;
        String title2 = getTitle();
        int hashCode2 = (hashCode + (title2 != null ? title2.hashCode() : 0)) * 31;
        boolean required2 = getRequired();
        int i2 = 1;
        if (required2) {
            required2 = true;
        }
        int i3 = required2 ? 1 : 0;
        int i4 = required2 ? 1 : 0;
        int i5 = required2 ? 1 : 0;
        int i6 = (hashCode2 + i3) * 31;
        boolean immutable2 = getImmutable();
        if (!immutable2) {
            i2 = immutable2;
        }
        int i7 = (i6 + i2) * 31;
        AttributedText motivation2 = getMotivation();
        int hashCode3 = (i7 + (motivation2 != null ? motivation2.hashCode() : 0)) * 31;
        Boolean updatesForm2 = getUpdatesForm();
        int hashCode4 = (hashCode3 + (updatesForm2 != null ? updatesForm2.hashCode() : 0)) * 31;
        Value value = get_value();
        int hashCode5 = (hashCode4 + (value != null ? value.hashCode() : 0)) * 31;
        PresentTimeOptions presentTimeOptions = this.presentTime;
        int hashCode6 = (hashCode5 + (presentTimeOptions != null ? presentTimeOptions.hashCode() : 0)) * 31;
        SelectionType selectionType2 = this.selectionType;
        int hashCode7 = (hashCode6 + (selectionType2 != null ? selectionType2.hashCode() : 0)) * 31;
        Restrictions restrictions2 = this.restrictions;
        int hashCode8 = (hashCode7 + (restrictions2 != null ? restrictions2.hashCode() : 0)) * 31;
        List<Constraint> constraints2 = getConstraints();
        if (constraints2 != null) {
            i = constraints2.hashCode();
        }
        return hashCode8 + i;
    }

    public final boolean isPresentTime() {
        return getValue() instanceof Value.PresentTime;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("DateTimeParameter(id=");
        L.append(getId());
        L.append(", title=");
        L.append(getTitle());
        L.append(", required=");
        L.append(getRequired());
        L.append(", immutable=");
        L.append(getImmutable());
        L.append(", motivation=");
        L.append(getMotivation());
        L.append(", updatesForm=");
        L.append(getUpdatesForm());
        L.append(", _value=");
        L.append(get_value());
        L.append(", presentTime=");
        L.append(this.presentTime);
        L.append(", selectionType=");
        L.append(this.selectionType);
        L.append(", restrictions=");
        L.append(this.restrictions);
        L.append(", constraints=");
        L.append(getConstraints());
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.id);
        parcel.writeString(this.title);
        parcel.writeInt(this.required ? 1 : 0);
        parcel.writeInt(this.immutable ? 1 : 0);
        parcel.writeParcelable(this.motivation, i);
        Boolean bool = this.updatesForm;
        if (bool != null) {
            a.G0(parcel, 1, bool);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeParcelable(this._value, i);
        parcel.writeParcelable(this.presentTime, i);
        parcel.writeParcelable(this.selectionType, i);
        parcel.writeParcelable(this.restrictions, i);
        List<Constraint> list = this.constraints;
        if (list != null) {
            Iterator l0 = a.l0(parcel, 1, list);
            while (l0.hasNext()) {
                parcel.writeParcelable((Constraint) l0.next(), i);
            }
            return;
        }
        parcel.writeInt(0);
    }

    @Override // com.avito.android.remote.model.category_parameters.base.EditableParameter
    @Nullable
    public Value get_value() {
        return this._value;
    }

    public void set_value(@Nullable Value value) {
        this._value = value;
    }
}
