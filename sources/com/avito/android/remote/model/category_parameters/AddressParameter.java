package com.avito.android.remote.model.category_parameters;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.lib.design.input.FormatterType;
import com.avito.android.remote.annotations.Field;
import com.avito.android.remote.model.category_parameters.base.EditableParameter;
import com.avito.android.remote.model.category_parameters.base.HasPlaceholder;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import com.google.gson.annotations.SerializedName;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.HashMap;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u001f\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0003WXYB\u0012\u0006\u0010!\u001a\u00020\u0007\u0012\u0006\u0010\"\u001a\u00020\u0007\u0012\u0006\u0010#\u001a\u00020\u0004\u0012\u0006\u0010$\u001a\u00020\u0004\u0012\b\u0010%\u001a\u0004\u0018\u00010\r\u0012\b\u0010&\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010'\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\bU\u0010VJ\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\n\u0010\tJ\u0010\u0010\u000b\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0006J\u0010\u0010\f\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\f\u0010\u0006J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\u0017\u0010\tJ\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u001eHÆ\u0003¢\u0006\u0004\b\u001f\u0010 J\u0001\u0010-\u001a\u00020\u00002\b\b\u0002\u0010!\u001a\u00020\u00072\b\b\u0002\u0010\"\u001a\u00020\u00072\b\b\u0002\u0010#\u001a\u00020\u00042\b\b\u0002\u0010$\u001a\u00020\u00042\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u001eHÆ\u0001¢\u0006\u0004\b-\u0010.J\u0010\u0010/\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b/\u0010\tJ\u0010\u00101\u001a\u000200HÖ\u0001¢\u0006\u0004\b1\u00102J\u001a\u00105\u001a\u00020\u00042\b\u00104\u001a\u0004\u0018\u000103HÖ\u0003¢\u0006\u0004\b5\u00106J\u0010\u00107\u001a\u000200HÖ\u0001¢\u0006\u0004\b7\u00102J \u0010<\u001a\u00020;2\u0006\u00109\u001a\u0002082\u0006\u0010:\u001a\u000200HÖ\u0001¢\u0006\u0004\b<\u0010=R$\u0010(\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b(\u0010>\u001a\u0004\b?\u0010\u0016\"\u0004\b@\u0010AR\u001e\u0010%\u001a\u0004\u0018\u00010\r8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b%\u0010B\u001a\u0004\bC\u0010\u000fR\u001e\u0010&\u001a\u0004\u0018\u00010\u00048\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b&\u0010D\u001a\u0004\bE\u0010\u0011R\u001e\u0010*\u001a\u0004\u0018\u00010\u00188\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b*\u0010F\u001a\u0004\bG\u0010\u001aR\u001c\u0010$\u001a\u00020\u00048\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b$\u0010H\u001a\u0004\bI\u0010\u0006R\u001c\u0010#\u001a\u00020\u00048\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b#\u0010H\u001a\u0004\bJ\u0010\u0006R\u001e\u0010+\u001a\u0004\u0018\u00010\u001b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b+\u0010K\u001a\u0004\bL\u0010\u001dR\u001c\u0010\"\u001a\u00020\u00078\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\"\u0010M\u001a\u0004\bN\u0010\tR\u001e\u0010'\u001a\u0004\u0018\u00010\u00128\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b'\u0010O\u001a\u0004\bP\u0010\u0014R\u001e\u0010,\u001a\u0004\u0018\u00010\u001e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b,\u0010Q\u001a\u0004\bR\u0010 R\u001e\u0010)\u001a\u0004\u0018\u00010\u00078\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b)\u0010M\u001a\u0004\bS\u0010\tR\u001c\u0010!\u001a\u00020\u00078\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b!\u0010M\u001a\u0004\bT\u0010\t¨\u0006Z"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/AddressParameter;", "Lcom/avito/android/remote/model/category_parameters/base/EditableParameter;", "Lcom/avito/android/remote/model/category_parameters/AddressParameter$Value;", "Lcom/avito/android/remote/model/category_parameters/base/HasPlaceholder;", "", "hasValue", "()Z", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "Lcom/avito/android/remote/model/text/AttributedText;", "component5", "()Lcom/avito/android/remote/model/text/AttributedText;", "component6", "()Ljava/lang/Boolean;", "Lcom/avito/android/remote/model/category_parameters/SuggestData;", "component7", "()Lcom/avito/android/remote/model/category_parameters/SuggestData;", "component8", "()Lcom/avito/android/remote/model/category_parameters/AddressParameter$Value;", "component9", "Lcom/avito/android/remote/model/category_parameters/DisplayingOptions;", "component10", "()Lcom/avito/android/remote/model/category_parameters/DisplayingOptions;", "Lcom/avito/android/remote/model/category_parameters/AddressParameter$GeoFlowType;", "component11", "()Lcom/avito/android/remote/model/category_parameters/AddressParameter$GeoFlowType;", "Lcom/avito/android/remote/model/category_parameters/AddressParameter$ValidationRules;", "component12", "()Lcom/avito/android/remote/model/category_parameters/AddressParameter$ValidationRules;", "id", "title", "required", "immutable", "motivation", "updatesForm", "suggestData", "_value", InternalConstsKt.PLACEHOLDER, "displaying", "flowType", "validationRules", "copy", "(Ljava/lang/String;Ljava/lang/String;ZZLcom/avito/android/remote/model/text/AttributedText;Ljava/lang/Boolean;Lcom/avito/android/remote/model/category_parameters/SuggestData;Lcom/avito/android/remote/model/category_parameters/AddressParameter$Value;Ljava/lang/String;Lcom/avito/android/remote/model/category_parameters/DisplayingOptions;Lcom/avito/android/remote/model/category_parameters/AddressParameter$GeoFlowType;Lcom/avito/android/remote/model/category_parameters/AddressParameter$ValidationRules;)Lcom/avito/android/remote/model/category_parameters/AddressParameter;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/category_parameters/AddressParameter$Value;", "get_value", "set_value", "(Lcom/avito/android/remote/model/category_parameters/AddressParameter$Value;)V", "Lcom/avito/android/remote/model/text/AttributedText;", "getMotivation", "Ljava/lang/Boolean;", "getUpdatesForm", "Lcom/avito/android/remote/model/category_parameters/DisplayingOptions;", "getDisplaying", "Z", "getImmutable", "getRequired", "Lcom/avito/android/remote/model/category_parameters/AddressParameter$GeoFlowType;", "getFlowType", "Ljava/lang/String;", "getTitle", "Lcom/avito/android/remote/model/category_parameters/SuggestData;", "getSuggestData", "Lcom/avito/android/remote/model/category_parameters/AddressParameter$ValidationRules;", "getValidationRules", "getPlaceholder", "getId", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZZLcom/avito/android/remote/model/text/AttributedText;Ljava/lang/Boolean;Lcom/avito/android/remote/model/category_parameters/SuggestData;Lcom/avito/android/remote/model/category_parameters/AddressParameter$Value;Ljava/lang/String;Lcom/avito/android/remote/model/category_parameters/DisplayingOptions;Lcom/avito/android/remote/model/category_parameters/AddressParameter$GeoFlowType;Lcom/avito/android/remote/model/category_parameters/AddressParameter$ValidationRules;)V", "GeoFlowType", "ValidationRules", "Value", "models_release"}, k = 1, mv = {1, 4, 2})
public final class AddressParameter extends EditableParameter<Value> implements HasPlaceholder {
    public static final Parcelable.Creator<AddressParameter> CREATOR = new Creator();
    @SerializedName("value")
    @Nullable
    private Value _value;
    @SerializedName("displaying")
    @Nullable
    private final DisplayingOptions displaying;
    @SerializedName("flowType")
    @Nullable
    private final GeoFlowType flowType;
    @SerializedName("id")
    @NotNull
    private final String id;
    @SerializedName("immutable")
    private final boolean immutable;
    @SerializedName("motivation")
    @Nullable
    private final AttributedText motivation;
    @SerializedName(InternalConstsKt.PLACEHOLDER)
    @Nullable
    private final String placeholder;
    @SerializedName("required")
    private final boolean required;
    @SerializedName("suggestData")
    @Nullable
    private final SuggestData suggestData;
    @SerializedName("title")
    @NotNull
    private final String title;
    @SerializedName("updatesForm")
    @Nullable
    private final Boolean updatesForm;
    @SerializedName("validationRules")
    @Nullable
    private final ValidationRules validationRules;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<AddressParameter> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AddressParameter createFromParcel(@NotNull Parcel parcel) {
            Boolean bool;
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            boolean z = true;
            boolean z2 = parcel.readInt() != 0;
            boolean z3 = parcel.readInt() != 0;
            AttributedText attributedText = (AttributedText) parcel.readParcelable(AddressParameter.class.getClassLoader());
            if (parcel.readInt() != 0) {
                if (parcel.readInt() == 0) {
                    z = false;
                }
                bool = Boolean.valueOf(z);
            } else {
                bool = null;
            }
            return new AddressParameter(readString, readString2, z2, z3, attributedText, bool, (SuggestData) parcel.readParcelable(AddressParameter.class.getClassLoader()), (Value) parcel.readParcelable(AddressParameter.class.getClassLoader()), parcel.readString(), parcel.readInt() != 0 ? DisplayingOptions.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (GeoFlowType) Enum.valueOf(GeoFlowType.class, parcel.readString()) : null, parcel.readInt() != 0 ? ValidationRules.CREATOR.createFromParcel(parcel) : null);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AddressParameter[] newArray(int i) {
            return new AddressParameter[i];
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/AddressParameter$GeoFlowType;", "", "<init>", "(Ljava/lang/String;I)V", "MAP", "SUGGEST", "HISTORICAL_SUGGEST", "models_release"}, k = 1, mv = {1, 4, 2})
    public enum GeoFlowType {
        MAP,
        SUGGEST,
        HISTORICAL_SUGGEST
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ)\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u001c\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\bJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u000fJ \u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u001e\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u001c\u001a\u0004\b\u001d\u0010\b¨\u0006 "}, d2 = {"Lcom/avito/android/remote/model/category_parameters/AddressParameter$ValidationRules;", "Landroid/os/Parcelable;", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "convertToFieldMap", "()Ljava/util/HashMap;", "component1", "()Ljava/lang/String;", "minimalPrecision", "copy", "(Ljava/lang/String;)Lcom/avito/android/remote/model/category_parameters/AddressParameter$ValidationRules;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getMinimalPrecision", "<init>", "(Ljava/lang/String;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class ValidationRules implements Parcelable {
        public static final Parcelable.Creator<ValidationRules> CREATOR = new Creator();
        @SerializedName("minimalPrecision")
        @Nullable
        private final String minimalPrecision;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<ValidationRules> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final ValidationRules createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new ValidationRules(parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final ValidationRules[] newArray(int i) {
                return new ValidationRules[i];
            }
        }

        public ValidationRules() {
            this(null, 1, null);
        }

        public ValidationRules(@Nullable String str) {
            this.minimalPrecision = str;
        }

        public static /* synthetic */ ValidationRules copy$default(ValidationRules validationRules, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = validationRules.minimalPrecision;
            }
            return validationRules.copy(str);
        }

        @Nullable
        public final String component1() {
            return this.minimalPrecision;
        }

        /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0011: APUT  
          (r0v1 kotlin.Pair[])
          (0 ??[int, short, byte, char])
          (wrap: kotlin.Pair : 0x000c: INVOKE  (r1v2 kotlin.Pair) = ("validationRules[minimalPrecision]"), (r1v1 java.lang.String) type: STATIC call: kotlin.TuplesKt.to(java.lang.Object, java.lang.Object):kotlin.Pair)
         */
        @NotNull
        public final HashMap<String, String> convertToFieldMap() {
            Pair[] pairArr = new Pair[1];
            String str = this.minimalPrecision;
            if (str == null) {
                str = "";
            }
            pairArr[0] = TuplesKt.to("validationRules[minimalPrecision]", str);
            return r.hashMapOf(pairArr);
        }

        @NotNull
        public final ValidationRules copy(@Nullable String str) {
            return new ValidationRules(str);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // java.lang.Object
        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof ValidationRules) && Intrinsics.areEqual(this.minimalPrecision, ((ValidationRules) obj).minimalPrecision);
            }
            return true;
        }

        @Nullable
        public final String getMinimalPrecision() {
            return this.minimalPrecision;
        }

        @Override // java.lang.Object
        public int hashCode() {
            String str = this.minimalPrecision;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            return a.t(a.L("ValidationRules(minimalPrecision="), this.minimalPrecision, ")");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.minimalPrecision);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ValidationRules(String str, int i, j jVar) {
            this((i & 1) != 0 ? null : str);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\b\b\u0018\u0000 ,2\u00020\u0001:\u0001,B-\u0012\u0006\u0010\u0013\u001a\u00020\u000b\u0012\u0006\u0010\u0014\u001a\u00020\u000b\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b*\u0010+J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\rJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0011J<\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u000b2\b\b\u0002\u0010\u0014\u001a\u00020\u000b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000fHÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0011J\u0010\u0010\u001a\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0004J\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0014\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010 \u001a\u0004\b!\u0010\rR\u001c\u0010\u0013\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010 \u001a\u0004\b\"\u0010\rR\u0013\u0010$\u001a\u00020\u000f8G@\u0006¢\u0006\u0006\u001a\u0004\b#\u0010\u0011R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u000f8\u0007@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010%\u001a\u0004\b&\u0010\u0011R\u0013\u0010(\u001a\u00020\u000f8G@\u0006¢\u0006\u0006\u001a\u0004\b'\u0010\u0011R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u000f8\u0007@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010%\u001a\u0004\b)\u0010\u0011¨\u0006-"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/AddressParameter$Value;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "component1", "()D", "component2", "", "component3", "()Ljava/lang/String;", "component4", "lat", "lng", "text", "jsonWebToken", "copy", "(DDLjava/lang/String;Ljava/lang/String;)Lcom/avito/android/remote/model/category_parameters/AddressParameter$Value;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "D", "getLng", "getLat", "getFormattedLng", "formattedLng", "Ljava/lang/String;", "getJsonWebToken", "getFormattedLat", "formattedLat", "getText", "<init>", "(DDLjava/lang/String;Ljava/lang/String;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Value implements Parcelable {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<Value> CREATOR = Parcels.creator(AddressParameter$Value$Companion$CREATOR$1.INSTANCE);
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        public static final String JSON_WEB_TOKEN = "jwt";
        @NotNull
        public static final String LAT = "lat";
        @NotNull
        public static final String LNG = "lng";
        @NotNull
        public static final String TEXT = "text";
        private static final DecimalFormat coordinateFormat;
        private static final DecimalFormatSymbols formatSymbols;
        @SerializedName(JSON_WEB_TOKEN)
        @Nullable
        private final String jsonWebToken;
        @SerializedName("lat")
        private final double lat;
        @SerializedName("lng")
        private final double lng;
        @SerializedName("text")
        @Nullable
        private final String text;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0007\u001a\u00020\u00068\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u00020\u00068\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\t\u0010\bR\u0016\u0010\n\u001a\u00020\u00068\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\n\u0010\bR\u0016\u0010\u000b\u001a\u00020\u00068\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u000b\u0010\bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/AddressParameter$Value$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/category_parameters/AddressParameter$Value;", "CREATOR", "Landroid/os/Parcelable$Creator;", "", "JSON_WEB_TOKEN", "Ljava/lang/String;", "LAT", "LNG", "TEXT", "Ljava/text/DecimalFormat;", "coordinateFormat", "Ljava/text/DecimalFormat;", "Ljava/text/DecimalFormatSymbols;", "formatSymbols", "Ljava/text/DecimalFormatSymbols;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(j jVar) {
                this();
            }
        }

        static {
            DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols(Locale.ENGLISH);
            decimalFormatSymbols.setDecimalSeparator(FormatterType.defaultDecimalSeparator);
            formatSymbols = decimalFormatSymbols;
            coordinateFormat = new DecimalFormat("0.000000", decimalFormatSymbols);
        }

        public Value(double d, double d2, @Nullable String str, @Nullable String str2) {
            this.lat = d;
            this.lng = d2;
            this.text = str;
            this.jsonWebToken = str2;
        }

        public static /* synthetic */ Value copy$default(Value value, double d, double d2, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                d = value.lat;
            }
            if ((i & 2) != 0) {
                d2 = value.lng;
            }
            if ((i & 4) != 0) {
                str = value.text;
            }
            if ((i & 8) != 0) {
                str2 = value.jsonWebToken;
            }
            return value.copy(d, d2, str, str2);
        }

        public final double component1() {
            return this.lat;
        }

        public final double component2() {
            return this.lng;
        }

        @Nullable
        public final String component3() {
            return this.text;
        }

        @Nullable
        public final String component4() {
            return this.jsonWebToken;
        }

        @NotNull
        public final Value copy(double d, double d2, @Nullable String str, @Nullable String str2) {
            return new Value(d, d2, str, str2);
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
            if (!(obj instanceof Value)) {
                return false;
            }
            Value value = (Value) obj;
            return Double.compare(this.lat, value.lat) == 0 && Double.compare(this.lng, value.lng) == 0 && Intrinsics.areEqual(this.text, value.text) && Intrinsics.areEqual(this.jsonWebToken, value.jsonWebToken);
        }

        @Field(name = "lat")
        @NotNull
        public final String getFormattedLat() {
            String format = coordinateFormat.format(this.lat);
            Intrinsics.checkNotNullExpressionValue(format, "coordinateFormat.format(lat)");
            return format;
        }

        @Field(name = "lng")
        @NotNull
        public final String getFormattedLng() {
            String format = coordinateFormat.format(this.lng);
            Intrinsics.checkNotNullExpressionValue(format, "coordinateFormat.format(lng)");
            return format;
        }

        @Field(name = JSON_WEB_TOKEN)
        @Nullable
        public final String getJsonWebToken() {
            return this.jsonWebToken;
        }

        public final double getLat() {
            return this.lat;
        }

        public final double getLng() {
            return this.lng;
        }

        @Field(name = "text")
        @Nullable
        public final String getText() {
            return this.text;
        }

        @Override // java.lang.Object
        public int hashCode() {
            int a = ((b.a(this.lat) * 31) + b.a(this.lng)) * 31;
            String str = this.text;
            int i = 0;
            int hashCode = (a + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.jsonWebToken;
            if (str2 != null) {
                i = str2.hashCode();
            }
            return hashCode + i;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("Value(lat=");
            L.append(this.lat);
            L.append(", lng=");
            L.append(this.lng);
            L.append(", text=");
            L.append(this.text);
            L.append(", jsonWebToken=");
            return a.t(L, this.jsonWebToken, ")");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "dest");
            parcel.writeDouble(this.lat);
            parcel.writeDouble(this.lng);
            parcel.writeString(this.text);
            ParcelsKt.writeNullableValue(parcel, this.jsonWebToken);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Value(double d, double d2, String str, String str2, int i, j jVar) {
            this(d, d2, str, (i & 8) != 0 ? null : str2);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AddressParameter(String str, String str2, boolean z, boolean z2, AttributedText attributedText, Boolean bool, SuggestData suggestData2, Value value, String str3, DisplayingOptions displayingOptions, GeoFlowType geoFlowType, ValidationRules validationRules2, int i, j jVar) {
        this(str, str2, z, z2, attributedText, bool, suggestData2, value, (i & 256) != 0 ? null : str3, (i & 512) != 0 ? null : displayingOptions, (i & 1024) != 0 ? null : geoFlowType, (i & 2048) != 0 ? null : validationRules2);
    }

    public static /* synthetic */ AddressParameter copy$default(AddressParameter addressParameter, String str, String str2, boolean z, boolean z2, AttributedText attributedText, Boolean bool, SuggestData suggestData2, Value value, String str3, DisplayingOptions displayingOptions, GeoFlowType geoFlowType, ValidationRules validationRules2, int i, Object obj) {
        return addressParameter.copy((i & 1) != 0 ? addressParameter.getId() : str, (i & 2) != 0 ? addressParameter.getTitle() : str2, (i & 4) != 0 ? addressParameter.getRequired() : z, (i & 8) != 0 ? addressParameter.getImmutable() : z2, (i & 16) != 0 ? addressParameter.getMotivation() : attributedText, (i & 32) != 0 ? addressParameter.getUpdatesForm() : bool, (i & 64) != 0 ? addressParameter.suggestData : suggestData2, (i & 128) != 0 ? addressParameter.get_value() : value, (i & 256) != 0 ? addressParameter.getPlaceholder() : str3, (i & 512) != 0 ? addressParameter.displaying : displayingOptions, (i & 1024) != 0 ? addressParameter.flowType : geoFlowType, (i & 2048) != 0 ? addressParameter.validationRules : validationRules2);
    }

    @NotNull
    public final String component1() {
        return getId();
    }

    @Nullable
    public final DisplayingOptions component10() {
        return this.displaying;
    }

    @Nullable
    public final GeoFlowType component11() {
        return this.flowType;
    }

    @Nullable
    public final ValidationRules component12() {
        return this.validationRules;
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
    public final SuggestData component7() {
        return this.suggestData;
    }

    @Nullable
    public final Value component8() {
        return get_value();
    }

    @Nullable
    public final String component9() {
        return getPlaceholder();
    }

    @NotNull
    public final AddressParameter copy(@NotNull String str, @NotNull String str2, boolean z, boolean z2, @Nullable AttributedText attributedText, @Nullable Boolean bool, @Nullable SuggestData suggestData2, @Nullable Value value, @Nullable String str3, @Nullable DisplayingOptions displayingOptions, @Nullable GeoFlowType geoFlowType, @Nullable ValidationRules validationRules2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        return new AddressParameter(str, str2, z, z2, attributedText, bool, suggestData2, value, str3, displayingOptions, geoFlowType, validationRules2);
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
        if (!(obj instanceof AddressParameter)) {
            return false;
        }
        AddressParameter addressParameter = (AddressParameter) obj;
        return Intrinsics.areEqual(getId(), addressParameter.getId()) && Intrinsics.areEqual(getTitle(), addressParameter.getTitle()) && getRequired() == addressParameter.getRequired() && getImmutable() == addressParameter.getImmutable() && Intrinsics.areEqual(getMotivation(), addressParameter.getMotivation()) && Intrinsics.areEqual(getUpdatesForm(), addressParameter.getUpdatesForm()) && Intrinsics.areEqual(this.suggestData, addressParameter.suggestData) && Intrinsics.areEqual(get_value(), addressParameter.get_value()) && Intrinsics.areEqual(getPlaceholder(), addressParameter.getPlaceholder()) && Intrinsics.areEqual(this.displaying, addressParameter.displaying) && Intrinsics.areEqual(this.flowType, addressParameter.flowType) && Intrinsics.areEqual(this.validationRules, addressParameter.validationRules);
    }

    @Nullable
    public final DisplayingOptions getDisplaying() {
        return this.displaying;
    }

    @Nullable
    public final GeoFlowType getFlowType() {
        return this.flowType;
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

    @Override // com.avito.android.remote.model.category_parameters.base.HasPlaceholder
    @Nullable
    public String getPlaceholder() {
        return this.placeholder;
    }

    @Override // com.avito.android.remote.model.category_parameters.base.BaseParameter
    public boolean getRequired() {
        return this.required;
    }

    @Nullable
    public final SuggestData getSuggestData() {
        return this.suggestData;
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

    @Nullable
    public final ValidationRules getValidationRules() {
        return this.validationRules;
    }

    @Override // com.avito.android.remote.model.category_parameters.base.EditableParameter
    public boolean hasValue() {
        Value value = (Value) getValue();
        boolean z = false;
        if (value == null) {
            return false;
        }
        String text = value.getText();
        if ((text == null || text.length() == 0) || value.getLat() == 0.0d || value.getLng() == 0.0d) {
            z = true;
        }
        return !z;
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
        SuggestData suggestData2 = this.suggestData;
        int hashCode5 = (hashCode4 + (suggestData2 != null ? suggestData2.hashCode() : 0)) * 31;
        Value value = get_value();
        int hashCode6 = (hashCode5 + (value != null ? value.hashCode() : 0)) * 31;
        String placeholder2 = getPlaceholder();
        int hashCode7 = (hashCode6 + (placeholder2 != null ? placeholder2.hashCode() : 0)) * 31;
        DisplayingOptions displayingOptions = this.displaying;
        int hashCode8 = (hashCode7 + (displayingOptions != null ? displayingOptions.hashCode() : 0)) * 31;
        GeoFlowType geoFlowType = this.flowType;
        int hashCode9 = (hashCode8 + (geoFlowType != null ? geoFlowType.hashCode() : 0)) * 31;
        ValidationRules validationRules2 = this.validationRules;
        if (validationRules2 != null) {
            i = validationRules2.hashCode();
        }
        return hashCode9 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("AddressParameter(id=");
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
        L.append(", suggestData=");
        L.append(this.suggestData);
        L.append(", _value=");
        L.append(get_value());
        L.append(", placeholder=");
        L.append(getPlaceholder());
        L.append(", displaying=");
        L.append(this.displaying);
        L.append(", flowType=");
        L.append(this.flowType);
        L.append(", validationRules=");
        L.append(this.validationRules);
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
        parcel.writeParcelable(this.suggestData, i);
        parcel.writeParcelable(this._value, i);
        parcel.writeString(this.placeholder);
        DisplayingOptions displayingOptions = this.displaying;
        if (displayingOptions != null) {
            parcel.writeInt(1);
            displayingOptions.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        GeoFlowType geoFlowType = this.flowType;
        if (geoFlowType != null) {
            parcel.writeInt(1);
            parcel.writeString(geoFlowType.name());
        } else {
            parcel.writeInt(0);
        }
        ValidationRules validationRules2 = this.validationRules;
        if (validationRules2 != null) {
            parcel.writeInt(1);
            validationRules2.writeToParcel(parcel, 0);
            return;
        }
        parcel.writeInt(0);
    }

    public AddressParameter(@NotNull String str, @NotNull String str2, boolean z, boolean z2, @Nullable AttributedText attributedText, @Nullable Boolean bool, @Nullable SuggestData suggestData2, @Nullable Value value, @Nullable String str3, @Nullable DisplayingOptions displayingOptions, @Nullable GeoFlowType geoFlowType, @Nullable ValidationRules validationRules2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        this.id = str;
        this.title = str2;
        this.required = z;
        this.immutable = z2;
        this.motivation = attributedText;
        this.updatesForm = bool;
        this.suggestData = suggestData2;
        this._value = value;
        this.placeholder = str3;
        this.displaying = displayingOptions;
        this.flowType = geoFlowType;
        this.validationRules = validationRules2;
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
