package com.avito.android.remote.model.category_parameters;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.category_parameters.Constraint;
import com.avito.android.remote.model.category_parameters.base.EditableParameter;
import com.avito.android.remote.model.category_parameters.base.HasConstraints;
import com.avito.android.remote.model.text.AttributedText;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b \b\b\u0018\u0000 X2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0005XYZ[\\BM\u0012\u0006\u0010\u0018\u001a\u00020\u0004\u0012\u0006\u0010\u0019\u001a\u00020\u0007\u0012\u0006\u0010\u001a\u001a\u00020\f\u0012\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\bV\u0010WJ\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\n\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u000b\u0010\tJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0006J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017Jb\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0018\u001a\u00020\u00042\b\b\u0002\u0010\u0019\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\f2\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u001d\u001a\u00020\u00042\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\"\u001a\u00020!HÖ\u0001¢\u0006\u0004\b\"\u0010#J\u001a\u0010&\u001a\u00020\u00072\b\u0010%\u001a\u0004\u0018\u00010$HÖ\u0003¢\u0006\u0004\b&\u0010'J\u0010\u0010(\u001a\u00020!HÖ\u0001¢\u0006\u0004\b(\u0010#J \u0010-\u001a\u00020,2\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020!HÖ\u0001¢\u0006\u0004\b-\u0010.R$\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001b\u0010/\u001a\u0004\b0\u0010\u0012R*\u00101\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b1\u00102\u0012\u0004\b6\u00107\u001a\u0004\b3\u0010\u0006\"\u0004\b4\u00105R$\u00108\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f8\u0002@\u0002X\u000e¢\u0006\f\n\u0004\b8\u0010/\u0012\u0004\b9\u00107R\u001c\u0010\u001a\u001a\u00020\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001a\u0010:\u001a\u0004\b;\u0010\u000eR\u001c\u0010\u0018\u001a\u00020\u00048\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0018\u00102\u001a\u0004\b<\u0010\u0006R$\u0010>\u001a\u0004\u0018\u00010=8\u0016@\u0016X\u0004¢\u0006\u0012\n\u0004\b>\u0010?\u0012\u0004\bB\u00107\u001a\u0004\b@\u0010AR*\u0010C\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\bC\u00102\u0012\u0004\bF\u00107\u001a\u0004\bD\u0010\u0006\"\u0004\bE\u00105R\"\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8V@\u0016X\u0004¢\u0006\f\u0012\u0004\bH\u00107\u001a\u0004\bG\u0010\u0012R\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u00078\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u001e\u0010J\u001a\u0004\bK\u0010\u0017R\"\u0010L\u001a\u00020\u00078\u0016@\u0016XD¢\u0006\u0012\n\u0004\bL\u0010M\u0012\u0004\bO\u00107\u001a\u0004\bN\u0010\tR$\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010P\u001a\u0004\bQ\u0010\u0014\"\u0004\bR\u0010SR\u001c\u0010\u0019\u001a\u00020\u00078\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0019\u0010M\u001a\u0004\bT\u0010\tR\u001c\u0010\u001d\u001a\u00020\u00048\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u001d\u00102\u001a\u0004\bU\u0010\u0006¨\u0006]"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/RangeParameter;", "Lcom/avito/android/remote/model/category_parameters/base/EditableParameter;", "Lcom/avito/android/remote/model/category_parameters/RangeParameter$RangeValue;", "Lcom/avito/android/remote/model/category_parameters/base/HasConstraints;", "", "toString", "()Ljava/lang/String;", "", "hasValue", "()Z", "component1", "component2", "Lcom/avito/android/remote/model/category_parameters/RangeParameter$Displaying;", "component3", "()Lcom/avito/android/remote/model/category_parameters/RangeParameter$Displaying;", "", "Lcom/avito/android/remote/model/category_parameters/Constraint;", "component4", "()Ljava/util/List;", "component5", "()Lcom/avito/android/remote/model/category_parameters/RangeParameter$RangeValue;", "component6", "component7", "()Ljava/lang/Boolean;", "id", "required", "displaying", "remoteConstraints", "_value", "title", "updatesForm", "copy", "(Ljava/lang/String;ZLcom/avito/android/remote/model/category_parameters/RangeParameter$Displaying;Ljava/util/List;Lcom/avito/android/remote/model/category_parameters/RangeParameter$RangeValue;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/avito/android/remote/model/category_parameters/RangeParameter;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/util/List;", "getRemoteConstraints", "fromError", "Ljava/lang/String;", "getFromError", "setFromError", "(Ljava/lang/String;)V", "getFromError$annotations", "()V", "internalConstraints", "getInternalConstraints$annotations", "Lcom/avito/android/remote/model/category_parameters/RangeParameter$Displaying;", "getDisplaying", "getId", "Lcom/avito/android/remote/model/text/AttributedText;", "motivation", "Lcom/avito/android/remote/model/text/AttributedText;", "getMotivation", "()Lcom/avito/android/remote/model/text/AttributedText;", "getMotivation$annotations", "toError", "getToError", "setToError", "getToError$annotations", "getConstraints", "getConstraints$annotations", "constraints", "Ljava/lang/Boolean;", "getUpdatesForm", "immutable", "Z", "getImmutable", "getImmutable$annotations", "Lcom/avito/android/remote/model/category_parameters/RangeParameter$RangeValue;", "get_value", "set_value", "(Lcom/avito/android/remote/model/category_parameters/RangeParameter$RangeValue;)V", "getRequired", "getTitle", "<init>", "(Ljava/lang/String;ZLcom/avito/android/remote/model/category_parameters/RangeParameter$Displaying;Ljava/util/List;Lcom/avito/android/remote/model/category_parameters/RangeParameter$RangeValue;Ljava/lang/String;Ljava/lang/Boolean;)V", "Companion", "DataType", "Displaying", "FromFieldEnabler", "RangeValue", "models_release"}, k = 1, mv = {1, 4, 2})
public final class RangeParameter extends EditableParameter<RangeValue> implements HasConstraints {
    public static final Parcelable.Creator<RangeParameter> CREATOR = new Creator();
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String fromKey = "from";
    @NotNull
    public static final String toKey = "to";
    @SerializedName("value")
    @Nullable
    private RangeValue _value;
    @SerializedName("displaying")
    @NotNull
    private final Displaying displaying;
    @Nullable
    private String fromError;
    @SerializedName("id")
    @NotNull
    private final String id;
    private final boolean immutable;
    private List<? extends Constraint> internalConstraints;
    @Nullable
    private final AttributedText motivation;
    @SerializedName("constraints")
    @Nullable
    private final List<Constraint> remoteConstraints;
    @SerializedName("required")
    private final boolean required;
    @SerializedName("title")
    @NotNull
    private final String title;
    @Nullable
    private String toError;
    @SerializedName("updatesForm")
    @Nullable
    private final Boolean updatesForm;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/RangeParameter$Companion;", "", "", "fromKey", "Ljava/lang/String;", "toKey", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<RangeParameter> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final RangeParameter createFromParcel(@NotNull Parcel parcel) {
            ArrayList arrayList;
            Boolean bool;
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            boolean z = true;
            boolean z2 = parcel.readInt() != 0;
            Displaying createFromParcel = Displaying.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add((Constraint) parcel.readParcelable(RangeParameter.class.getClassLoader()));
                    readInt--;
                }
            } else {
                arrayList = null;
            }
            RangeValue createFromParcel2 = parcel.readInt() != 0 ? RangeValue.CREATOR.createFromParcel(parcel) : null;
            String readString2 = parcel.readString();
            if (parcel.readInt() != 0) {
                if (parcel.readInt() == 0) {
                    z = false;
                }
                bool = Boolean.valueOf(z);
            } else {
                bool = null;
            }
            return new RangeParameter(readString, z2, createFromParcel, arrayList, createFromParcel2, readString2, bool);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final RangeParameter[] newArray(int i) {
            return new RangeParameter[i];
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/RangeParameter$DataType;", "", "<init>", "(Ljava/lang/String;I)V", "FLOAT", "INTEGER", "models_release"}, k = 1, mv = {1, 4, 2})
    public enum DataType {
        FLOAT,
        INTEGER
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001B5\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b,\u0010-J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0007J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\f\u0010\u0007JH\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0007J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0017J \u0010\"\u001a\u00020!2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\"\u0010#R\u001e\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010$\u001a\u0004\b%\u0010\u0004R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010&\u001a\u0004\b'\u0010\u0007R\u001c\u0010\u000e\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010&\u001a\u0004\b(\u0010\u0007R\u001c\u0010\u000f\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010)\u001a\u0004\b*\u0010\nR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010&\u001a\u0004\b+\u0010\u0007¨\u0006."}, d2 = {"Lcom/avito/android/remote/model/category_parameters/RangeParameter$Displaying;", "Landroid/os/Parcelable;", "Lcom/avito/android/remote/model/category_parameters/RangeParameter$FromFieldEnabler;", "component1", "()Lcom/avito/android/remote/model/category_parameters/RangeParameter$FromFieldEnabler;", "", "component2", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/category_parameters/RangeParameter$DataType;", "component3", "()Lcom/avito/android/remote/model/category_parameters/RangeParameter$DataType;", "component4", "component5", "fromFieldEnabler", "incorrectRangeError", "dataType", "toTitle", "fromTitle", "copy", "(Lcom/avito/android/remote/model/category_parameters/RangeParameter$FromFieldEnabler;Ljava/lang/String;Lcom/avito/android/remote/model/category_parameters/RangeParameter$DataType;Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/remote/model/category_parameters/RangeParameter$Displaying;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/category_parameters/RangeParameter$FromFieldEnabler;", "getFromFieldEnabler", "Ljava/lang/String;", "getFromTitle", "getIncorrectRangeError", "Lcom/avito/android/remote/model/category_parameters/RangeParameter$DataType;", "getDataType", "getToTitle", "<init>", "(Lcom/avito/android/remote/model/category_parameters/RangeParameter$FromFieldEnabler;Ljava/lang/String;Lcom/avito/android/remote/model/category_parameters/RangeParameter$DataType;Ljava/lang/String;Ljava/lang/String;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Displaying implements Parcelable {
        public static final Parcelable.Creator<Displaying> CREATOR = new Creator();
        @SerializedName("dataType")
        @NotNull
        private final DataType dataType;
        @SerializedName("fromFieldEnabler")
        @Nullable
        private final FromFieldEnabler fromFieldEnabler;
        @SerializedName("fromTitle")
        @Nullable
        private final String fromTitle;
        @SerializedName("incorrectRangeError")
        @NotNull
        private final String incorrectRangeError;
        @SerializedName("toTitle")
        @Nullable
        private final String toTitle;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Displaying> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Displaying createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Displaying(parcel.readInt() != 0 ? FromFieldEnabler.CREATOR.createFromParcel(parcel) : null, parcel.readString(), (DataType) Enum.valueOf(DataType.class, parcel.readString()), parcel.readString(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Displaying[] newArray(int i) {
                return new Displaying[i];
            }
        }

        public Displaying(@Nullable FromFieldEnabler fromFieldEnabler2, @NotNull String str, @NotNull DataType dataType2, @Nullable String str2, @Nullable String str3) {
            Intrinsics.checkNotNullParameter(str, "incorrectRangeError");
            Intrinsics.checkNotNullParameter(dataType2, "dataType");
            this.fromFieldEnabler = fromFieldEnabler2;
            this.incorrectRangeError = str;
            this.dataType = dataType2;
            this.toTitle = str2;
            this.fromTitle = str3;
        }

        public static /* synthetic */ Displaying copy$default(Displaying displaying, FromFieldEnabler fromFieldEnabler2, String str, DataType dataType2, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                fromFieldEnabler2 = displaying.fromFieldEnabler;
            }
            if ((i & 2) != 0) {
                str = displaying.incorrectRangeError;
            }
            if ((i & 4) != 0) {
                dataType2 = displaying.dataType;
            }
            if ((i & 8) != 0) {
                str2 = displaying.toTitle;
            }
            if ((i & 16) != 0) {
                str3 = displaying.fromTitle;
            }
            return displaying.copy(fromFieldEnabler2, str, dataType2, str2, str3);
        }

        @Nullable
        public final FromFieldEnabler component1() {
            return this.fromFieldEnabler;
        }

        @NotNull
        public final String component2() {
            return this.incorrectRangeError;
        }

        @NotNull
        public final DataType component3() {
            return this.dataType;
        }

        @Nullable
        public final String component4() {
            return this.toTitle;
        }

        @Nullable
        public final String component5() {
            return this.fromTitle;
        }

        @NotNull
        public final Displaying copy(@Nullable FromFieldEnabler fromFieldEnabler2, @NotNull String str, @NotNull DataType dataType2, @Nullable String str2, @Nullable String str3) {
            Intrinsics.checkNotNullParameter(str, "incorrectRangeError");
            Intrinsics.checkNotNullParameter(dataType2, "dataType");
            return new Displaying(fromFieldEnabler2, str, dataType2, str2, str3);
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
            if (!(obj instanceof Displaying)) {
                return false;
            }
            Displaying displaying = (Displaying) obj;
            return Intrinsics.areEqual(this.fromFieldEnabler, displaying.fromFieldEnabler) && Intrinsics.areEqual(this.incorrectRangeError, displaying.incorrectRangeError) && Intrinsics.areEqual(this.dataType, displaying.dataType) && Intrinsics.areEqual(this.toTitle, displaying.toTitle) && Intrinsics.areEqual(this.fromTitle, displaying.fromTitle);
        }

        @NotNull
        public final DataType getDataType() {
            return this.dataType;
        }

        @Nullable
        public final FromFieldEnabler getFromFieldEnabler() {
            return this.fromFieldEnabler;
        }

        @Nullable
        public final String getFromTitle() {
            return this.fromTitle;
        }

        @NotNull
        public final String getIncorrectRangeError() {
            return this.incorrectRangeError;
        }

        @Nullable
        public final String getToTitle() {
            return this.toTitle;
        }

        @Override // java.lang.Object
        public int hashCode() {
            FromFieldEnabler fromFieldEnabler2 = this.fromFieldEnabler;
            int i = 0;
            int hashCode = (fromFieldEnabler2 != null ? fromFieldEnabler2.hashCode() : 0) * 31;
            String str = this.incorrectRangeError;
            int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
            DataType dataType2 = this.dataType;
            int hashCode3 = (hashCode2 + (dataType2 != null ? dataType2.hashCode() : 0)) * 31;
            String str2 = this.toTitle;
            int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.fromTitle;
            if (str3 != null) {
                i = str3.hashCode();
            }
            return hashCode4 + i;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("Displaying(fromFieldEnabler=");
            L.append(this.fromFieldEnabler);
            L.append(", incorrectRangeError=");
            L.append(this.incorrectRangeError);
            L.append(", dataType=");
            L.append(this.dataType);
            L.append(", toTitle=");
            L.append(this.toTitle);
            L.append(", fromTitle=");
            return a.t(L, this.fromTitle, ")");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            FromFieldEnabler fromFieldEnabler2 = this.fromFieldEnabler;
            if (fromFieldEnabler2 != null) {
                parcel.writeInt(1);
                fromFieldEnabler2.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            parcel.writeString(this.incorrectRangeError);
            parcel.writeString(this.dataType.name());
            parcel.writeString(this.toTitle);
            parcel.writeString(this.fromTitle);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0014\u0010\u000fJ \u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aR\u001c\u0010\b\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004R\u001c\u0010\t\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u001d\u001a\u0004\b\u001e\u0010\u0007¨\u0006!"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/RangeParameter$FromFieldEnabler;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "", "component2", "()Z", "title", "value", "copy", "(Ljava/lang/String;Z)Lcom/avito/android/remote/model/category_parameters/RangeParameter$FromFieldEnabler;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getTitle", "Z", "getValue", "<init>", "(Ljava/lang/String;Z)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class FromFieldEnabler implements Parcelable {
        public static final Parcelable.Creator<FromFieldEnabler> CREATOR = new Creator();
        @SerializedName("title")
        @NotNull
        private final String title;
        @SerializedName("value")
        private final boolean value;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<FromFieldEnabler> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final FromFieldEnabler createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new FromFieldEnabler(parcel.readString(), parcel.readInt() != 0);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final FromFieldEnabler[] newArray(int i) {
                return new FromFieldEnabler[i];
            }
        }

        public FromFieldEnabler(@NotNull String str, boolean z) {
            Intrinsics.checkNotNullParameter(str, "title");
            this.title = str;
            this.value = z;
        }

        public static /* synthetic */ FromFieldEnabler copy$default(FromFieldEnabler fromFieldEnabler, String str, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = fromFieldEnabler.title;
            }
            if ((i & 2) != 0) {
                z = fromFieldEnabler.value;
            }
            return fromFieldEnabler.copy(str, z);
        }

        @NotNull
        public final String component1() {
            return this.title;
        }

        public final boolean component2() {
            return this.value;
        }

        @NotNull
        public final FromFieldEnabler copy(@NotNull String str, boolean z) {
            Intrinsics.checkNotNullParameter(str, "title");
            return new FromFieldEnabler(str, z);
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
            if (!(obj instanceof FromFieldEnabler)) {
                return false;
            }
            FromFieldEnabler fromFieldEnabler = (FromFieldEnabler) obj;
            return Intrinsics.areEqual(this.title, fromFieldEnabler.title) && this.value == fromFieldEnabler.value;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        public final boolean getValue() {
            return this.value;
        }

        @Override // java.lang.Object
        public int hashCode() {
            String str = this.title;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            boolean z = this.value;
            if (z) {
                z = true;
            }
            int i = z ? 1 : 0;
            int i2 = z ? 1 : 0;
            int i3 = z ? 1 : 0;
            return hashCode + i;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("FromFieldEnabler(title=");
            L.append(this.title);
            L.append(", value=");
            return a.B(L, this.value, ")");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.title);
            parcel.writeInt(this.value ? 1 : 0);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ FromFieldEnabler(String str, boolean z, int i, j jVar) {
            this(str, (i & 2) != 0 ? false : z);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001f\u0010 J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J(\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u000fJ \u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001c\u001a\u0004\b\u001e\u0010\u0004¨\u0006!"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/RangeParameter$RangeValue;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/Double;", "component2", "from", "to", "copy", "(Ljava/lang/Double;Ljava/lang/Double;)Lcom/avito/android/remote/model/category_parameters/RangeParameter$RangeValue;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/Double;", "getFrom", "getTo", "<init>", "(Ljava/lang/Double;Ljava/lang/Double;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class RangeValue implements Parcelable {
        public static final Parcelable.Creator<RangeValue> CREATOR = new Creator();
        @SerializedName("from")
        @Nullable
        private final Double from;
        @SerializedName("to")
        @Nullable
        private final Double to;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<RangeValue> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final RangeValue createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                Double d = null;
                Double valueOf = parcel.readInt() != 0 ? Double.valueOf(parcel.readDouble()) : null;
                if (parcel.readInt() != 0) {
                    d = Double.valueOf(parcel.readDouble());
                }
                return new RangeValue(valueOf, d);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final RangeValue[] newArray(int i) {
                return new RangeValue[i];
            }
        }

        public RangeValue() {
            this(null, null, 3, null);
        }

        public RangeValue(@Nullable Double d, @Nullable Double d2) {
            this.from = d;
            this.to = d2;
        }

        public static /* synthetic */ RangeValue copy$default(RangeValue rangeValue, Double d, Double d2, int i, Object obj) {
            if ((i & 1) != 0) {
                d = rangeValue.from;
            }
            if ((i & 2) != 0) {
                d2 = rangeValue.to;
            }
            return rangeValue.copy(d, d2);
        }

        @Nullable
        public final Double component1() {
            return this.from;
        }

        @Nullable
        public final Double component2() {
            return this.to;
        }

        @NotNull
        public final RangeValue copy(@Nullable Double d, @Nullable Double d2) {
            return new RangeValue(d, d2);
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
            if (!(obj instanceof RangeValue)) {
                return false;
            }
            RangeValue rangeValue = (RangeValue) obj;
            return Intrinsics.areEqual(this.from, rangeValue.from) && Intrinsics.areEqual(this.to, rangeValue.to);
        }

        @Nullable
        public final Double getFrom() {
            return this.from;
        }

        @Nullable
        public final Double getTo() {
            return this.to;
        }

        @Override // java.lang.Object
        public int hashCode() {
            Double d = this.from;
            int i = 0;
            int hashCode = (d != null ? d.hashCode() : 0) * 31;
            Double d2 = this.to;
            if (d2 != null) {
                i = d2.hashCode();
            }
            return hashCode + i;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("RangeValue(from=");
            L.append(this.from);
            L.append(", to=");
            L.append(this.to);
            L.append(")");
            return L.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            Double d = this.from;
            if (d != null) {
                parcel.writeInt(1);
                parcel.writeDouble(d.doubleValue());
            } else {
                parcel.writeInt(0);
            }
            Double d2 = this.to;
            if (d2 != null) {
                parcel.writeInt(1);
                parcel.writeDouble(d2.doubleValue());
                return;
            }
            parcel.writeInt(0);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ RangeValue(Double d, Double d2, int i, j jVar) {
            this((i & 1) != 0 ? null : d, (i & 2) != 0 ? null : d2);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RangeParameter(String str, boolean z, Displaying displaying2, List list, RangeValue rangeValue, String str2, Boolean bool, int i, j jVar) {
        this(str, z, displaying2, list, rangeValue, str2, (i & 64) != 0 ? null : bool);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.avito.android.remote.model.category_parameters.RangeParameter */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RangeParameter copy$default(RangeParameter rangeParameter, String str, boolean z, Displaying displaying2, List list, RangeValue rangeValue, String str2, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = rangeParameter.getId();
        }
        if ((i & 2) != 0) {
            z = rangeParameter.getRequired();
        }
        if ((i & 4) != 0) {
            displaying2 = rangeParameter.displaying;
        }
        if ((i & 8) != 0) {
            list = rangeParameter.remoteConstraints;
        }
        if ((i & 16) != 0) {
            rangeValue = rangeParameter.get_value();
        }
        if ((i & 32) != 0) {
            str2 = rangeParameter.getTitle();
        }
        if ((i & 64) != 0) {
            bool = rangeParameter.getUpdatesForm();
        }
        return rangeParameter.copy(str, z, displaying2, list, rangeValue, str2, bool);
    }

    public static /* synthetic */ void getConstraints$annotations() {
    }

    public static /* synthetic */ void getFromError$annotations() {
    }

    public static /* synthetic */ void getImmutable$annotations() {
    }

    private static /* synthetic */ void getInternalConstraints$annotations() {
    }

    public static /* synthetic */ void getMotivation$annotations() {
    }

    public static /* synthetic */ void getToError$annotations() {
    }

    @NotNull
    public final String component1() {
        return getId();
    }

    public final boolean component2() {
        return getRequired();
    }

    @NotNull
    public final Displaying component3() {
        return this.displaying;
    }

    @Nullable
    public final List<Constraint> component4() {
        return this.remoteConstraints;
    }

    @Nullable
    public final RangeValue component5() {
        return get_value();
    }

    @NotNull
    public final String component6() {
        return getTitle();
    }

    @Nullable
    public final Boolean component7() {
        return getUpdatesForm();
    }

    @NotNull
    public final RangeParameter copy(@NotNull String str, boolean z, @NotNull Displaying displaying2, @Nullable List<? extends Constraint> list, @Nullable RangeValue rangeValue, @NotNull String str2, @Nullable Boolean bool) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(displaying2, "displaying");
        Intrinsics.checkNotNullParameter(str2, "title");
        return new RangeParameter(str, z, displaying2, list, rangeValue, str2, bool);
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
        if (!(obj instanceof RangeParameter)) {
            return false;
        }
        RangeParameter rangeParameter = (RangeParameter) obj;
        return Intrinsics.areEqual(getId(), rangeParameter.getId()) && getRequired() == rangeParameter.getRequired() && Intrinsics.areEqual(this.displaying, rangeParameter.displaying) && Intrinsics.areEqual(this.remoteConstraints, rangeParameter.remoteConstraints) && Intrinsics.areEqual(get_value(), rangeParameter.get_value()) && Intrinsics.areEqual(getTitle(), rangeParameter.getTitle()) && Intrinsics.areEqual(getUpdatesForm(), rangeParameter.getUpdatesForm());
    }

    /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: java.util.List<? extends com.avito.android.remote.model.category_parameters.Constraint>, java.lang.Object, java.util.List<com.avito.android.remote.model.category_parameters.Constraint> */
    @Override // com.avito.android.remote.model.category_parameters.base.HasConstraints
    @NotNull
    public List<Constraint> getConstraints() {
        if (this.internalConstraints == null) {
            List mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new Constraint.RangeConstraint(this.displaying.getIncorrectRangeError(), null, null, null, null, 30, null));
            List<Constraint> list = this.remoteConstraints;
            if (list != null) {
                mutableListOf.addAll(list);
            }
            this.internalConstraints = CollectionsKt___CollectionsKt.toList(mutableListOf);
        }
        List list2 = this.internalConstraints;
        Intrinsics.checkNotNull(list2);
        return list2;
    }

    @NotNull
    public final Displaying getDisplaying() {
        return this.displaying;
    }

    @Nullable
    public final String getFromError() {
        return this.fromError;
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
    public final List<Constraint> getRemoteConstraints() {
        return this.remoteConstraints;
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

    @Nullable
    public final String getToError() {
        return this.toError;
    }

    @Override // com.avito.android.remote.model.category_parameters.base.BaseEditableParameter
    @Nullable
    public Boolean getUpdatesForm() {
        return this.updatesForm;
    }

    @Override // com.avito.android.remote.model.category_parameters.base.EditableParameter
    public boolean hasValue() {
        RangeValue rangeValue = (RangeValue) getValue();
        Double d = null;
        if ((rangeValue != null ? rangeValue.getFrom() : null) == null) {
            RangeValue rangeValue2 = (RangeValue) getValue();
            if (rangeValue2 != null) {
                d = rangeValue2.getTo();
            }
            if (d == null) {
                return false;
            }
        }
        return true;
    }

    @Override // com.avito.android.remote.model.category_parameters.base.CategoryParameter, java.lang.Object
    public int hashCode() {
        String id2 = getId();
        int i = 0;
        int hashCode = (id2 != null ? id2.hashCode() : 0) * 31;
        boolean required2 = getRequired();
        if (required2) {
            required2 = true;
        }
        int i2 = required2 ? 1 : 0;
        int i3 = required2 ? 1 : 0;
        int i4 = required2 ? 1 : 0;
        int i5 = (hashCode + i2) * 31;
        Displaying displaying2 = this.displaying;
        int hashCode2 = (i5 + (displaying2 != null ? displaying2.hashCode() : 0)) * 31;
        List<Constraint> list = this.remoteConstraints;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        RangeValue rangeValue = get_value();
        int hashCode4 = (hashCode3 + (rangeValue != null ? rangeValue.hashCode() : 0)) * 31;
        String title2 = getTitle();
        int hashCode5 = (hashCode4 + (title2 != null ? title2.hashCode() : 0)) * 31;
        Boolean updatesForm2 = getUpdatesForm();
        if (updatesForm2 != null) {
            i = updatesForm2.hashCode();
        }
        return hashCode5 + i;
    }

    public final void setFromError(@Nullable String str) {
        this.fromError = str;
    }

    public final void setToError(@Nullable String str) {
        this.toError = str;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("RangeParameter(id='");
        L.append(getId());
        L.append("',");
        L.append(" required=");
        L.append(getRequired());
        L.append(", ");
        L.append("displaying=");
        L.append(this.displaying);
        L.append(", ");
        L.append("constraints=");
        L.append(this.remoteConstraints);
        L.append(", ");
        L.append("value=");
        L.append((RangeValue) getValue());
        L.append(", ");
        L.append("title='");
        L.append(getTitle());
        L.append("', ");
        L.append("immutable=");
        L.append(getImmutable());
        L.append(", ");
        L.append("motivation=");
        L.append(getMotivation());
        L.append(", ");
        L.append("fromError=");
        a.m1(L, this.fromError, ", ", "toError=");
        return a.s(L, this.toError, ')');
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.id);
        parcel.writeInt(this.required ? 1 : 0);
        this.displaying.writeToParcel(parcel, 0);
        List<Constraint> list = this.remoteConstraints;
        if (list != null) {
            Iterator l0 = a.l0(parcel, 1, list);
            while (l0.hasNext()) {
                parcel.writeParcelable((Constraint) l0.next(), i);
            }
        } else {
            parcel.writeInt(0);
        }
        RangeValue rangeValue = this._value;
        if (rangeValue != null) {
            parcel.writeInt(1);
            rangeValue.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.title);
        Boolean bool = this.updatesForm;
        if (bool != null) {
            a.G0(parcel, 1, bool);
        } else {
            parcel.writeInt(0);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.util.List<? extends com.avito.android.remote.model.category_parameters.Constraint> */
    /* JADX WARN: Multi-variable type inference failed */
    public RangeParameter(@NotNull String str, boolean z, @NotNull Displaying displaying2, @Nullable List<? extends Constraint> list, @Nullable RangeValue rangeValue, @NotNull String str2, @Nullable Boolean bool) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(displaying2, "displaying");
        Intrinsics.checkNotNullParameter(str2, "title");
        this.id = str;
        this.required = z;
        this.displaying = displaying2;
        this.remoteConstraints = list;
        this._value = rangeValue;
        this.title = str2;
        this.updatesForm = bool;
    }

    @Override // com.avito.android.remote.model.category_parameters.base.EditableParameter
    @Nullable
    public RangeValue get_value() {
        return this._value;
    }

    public void set_value(@Nullable RangeValue rangeValue) {
        this._value = rangeValue;
    }
}
