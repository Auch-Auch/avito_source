package com.avito.android.remote.model.category_parameters;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.publish.residential_complex_search.di.ResidentialComplexModuleKt;
import com.avito.android.remote.model.Color;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.ParcelableEntity;
import com.avito.android.remote.model.category_parameters.base.CanHaveTypeCorrection;
import com.avito.android.remote.model.category_parameters.base.EditableParameter;
import com.avito.android.remote.model.category_parameters.base.HasPlaceholder;
import com.avito.android.remote.model.text.AttributedText;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b#\b\b\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00012\u00020\u00042\u00020\u0005:\u0002^_B¥\u0001\u0012\u0006\u0010#\u001a\u00020\u0003\u0012\u0006\u0010$\u001a\u00020\u0003\u0012\u0006\u0010%\u001a\u00020\n\u0012\u0006\u0010&\u001a\u00020\n\u0012\b\u0010'\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010(\u001a\u0004\u0018\u00010\n\u0012\u000e\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\b\u0010*\u001a\u0004\u0018\u00010\u0015\u0012\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00180\u0002\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u000e\u0012\u0010\b\u0002\u00100\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010 ¢\u0006\u0004\b\\\u0010]J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\r\u0010\fJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0014J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0007J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u001bHÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001dJ\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u001f\u0010\u0010J\u0018\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010 HÆ\u0003¢\u0006\u0004\b!\u0010\"JÀ\u0001\u00101\u001a\u00020\u00002\b\b\u0002\u0010#\u001a\u00020\u00032\b\b\u0002\u0010$\u001a\u00020\u00032\b\b\u0002\u0010%\u001a\u00020\n2\b\b\u0002\u0010&\u001a\u00020\n2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\n2\u0010\b\u0002\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00152\u000e\b\u0002\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00180\u00022\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u000e2\u0010\b\u0002\u00100\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010 HÆ\u0001¢\u0006\u0004\b1\u00102J\u0010\u00103\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b3\u00104J\u001a\u00107\u001a\u00020\n2\b\u00106\u001a\u0004\u0018\u000105HÖ\u0003¢\u0006\u0004\b7\u00108J\u0010\u00109\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b9\u00104J \u0010>\u001a\u00020=2\u0006\u0010;\u001a\u00020:2\u0006\u0010<\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b>\u0010?R$\u0010@\u001a\u0004\u0018\u00010\n8\u0016@\u0016X\u0004¢\u0006\u0012\n\u0004\b@\u0010A\u0012\u0004\bC\u0010D\u001a\u0004\bB\u0010\u0012R$\u00100\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010 8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b0\u0010E\u001a\u0004\bF\u0010\"R\u001e\u0010,\u001a\u0004\u0018\u00010\u00038\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b,\u0010G\u001a\u0004\bH\u0010\u0007R\u001e\u0010(\u001a\u0004\u0018\u00010\n8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b(\u0010A\u001a\u0004\bI\u0010\u0012R*\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b)\u0010J\u001a\u0004\bK\u0010\u0014\"\u0004\bL\u0010MR\u001e\u0010/\u001a\u0004\u0018\u00010\u000e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b/\u0010N\u001a\u0004\bO\u0010\u0010R\u001e\u0010'\u001a\u0004\u0018\u00010\u000e8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b'\u0010N\u001a\u0004\bP\u0010\u0010R\u001c\u0010#\u001a\u00020\u00038\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b#\u0010G\u001a\u0004\bQ\u0010\u0007R\"\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00180\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b+\u0010J\u001a\u0004\bR\u0010\u0014R\u001e\u0010-\u001a\u0004\u0018\u00010\u001b8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b-\u0010S\u001a\u0004\bT\u0010\u001dR\u001c\u0010%\u001a\u00020\n8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b%\u0010U\u001a\u0004\bV\u0010\fR\u001e\u0010*\u001a\u0004\u0018\u00010\u00158\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b*\u0010W\u001a\u0004\bX\u0010\u0017R\u001e\u0010.\u001a\u0004\u0018\u00010\u001b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b.\u0010S\u001a\u0004\bY\u0010\u001dR\u001c\u0010$\u001a\u00020\u00038\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b$\u0010G\u001a\u0004\bZ\u0010\u0007R\u001c\u0010&\u001a\u00020\n8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b&\u0010U\u001a\u0004\b[\u0010\f¨\u0006`"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/MultiselectParameter;", "Lcom/avito/android/remote/model/category_parameters/base/EditableParameter;", "", "", "Lcom/avito/android/remote/model/category_parameters/base/HasPlaceholder;", "Lcom/avito/android/remote/model/category_parameters/base/CanHaveTypeCorrection;", "toString", "()Ljava/lang/String;", "component1", "component2", "", "component3", "()Z", "component4", "Lcom/avito/android/remote/model/text/AttributedText;", "component5", "()Lcom/avito/android/remote/model/text/AttributedText;", "component6", "()Ljava/lang/Boolean;", "component7", "()Ljava/util/List;", "Lcom/avito/android/remote/model/category_parameters/MultiselectParameter$Displaying;", "component8", "()Lcom/avito/android/remote/model/category_parameters/MultiselectParameter$Displaying;", "Lcom/avito/android/remote/model/category_parameters/MultiselectParameter$Value;", "component9", "component10", "", "component11", "()Ljava/lang/Integer;", "component12", "component13", "", "component14", "()Ljava/util/Set;", "id", "title", "required", "immutable", "motivation", "updatesForm", "_value", "displaying", ResidentialComplexModuleKt.VALUES, InternalConstsKt.PLACEHOLDER, "attributeId", "maxSelected", MessengerShareContentUtility.SUBTITLE, "availableOptions", "copy", "(Ljava/lang/String;Ljava/lang/String;ZZLcom/avito/android/remote/model/text/AttributedText;Ljava/lang/Boolean;Ljava/util/List;Lcom/avito/android/remote/model/category_parameters/MultiselectParameter$Displaying;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/avito/android/remote/model/text/AttributedText;Ljava/util/Set;)Lcom/avito/android/remote/model/category_parameters/MultiselectParameter;", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "typoCorrectionEnabled", "Ljava/lang/Boolean;", "getTypoCorrectionEnabled", "getTypoCorrectionEnabled$annotations", "()V", "Ljava/util/Set;", "getAvailableOptions", "Ljava/lang/String;", "getPlaceholder", "getUpdatesForm", "Ljava/util/List;", "get_value", "set_value", "(Ljava/util/List;)V", "Lcom/avito/android/remote/model/text/AttributedText;", "getSubtitle", "getMotivation", "getId", "getValues", "Ljava/lang/Integer;", "getAttributeId", "Z", "getRequired", "Lcom/avito/android/remote/model/category_parameters/MultiselectParameter$Displaying;", "getDisplaying", "getMaxSelected", "getTitle", "getImmutable", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZZLcom/avito/android/remote/model/text/AttributedText;Ljava/lang/Boolean;Ljava/util/List;Lcom/avito/android/remote/model/category_parameters/MultiselectParameter$Displaying;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/avito/android/remote/model/text/AttributedText;Ljava/util/Set;)V", "Displaying", "Value", "models_release"}, k = 1, mv = {1, 4, 2})
public final class MultiselectParameter extends EditableParameter<List<? extends String>> implements HasPlaceholder, CanHaveTypeCorrection {
    public static final Parcelable.Creator<MultiselectParameter> CREATOR = new Creator();
    @SerializedName("value")
    @Nullable
    private List<String> _value;
    @SerializedName("attrId")
    @Nullable
    private final Integer attributeId;
    @SerializedName("availableOptions")
    @Nullable
    private final Set<String> availableOptions;
    @SerializedName("displaying")
    @Nullable
    private final Displaying displaying;
    @SerializedName("id")
    @NotNull
    private final String id;
    @SerializedName("immutable")
    private final boolean immutable;
    @SerializedName("maxSelected")
    @Nullable
    private final Integer maxSelected;
    @SerializedName("motivation")
    @Nullable
    private final AttributedText motivation;
    @SerializedName(InternalConstsKt.PLACEHOLDER)
    @Nullable
    private final String placeholder;
    @SerializedName("required")
    private final boolean required;
    @SerializedName(MessengerShareContentUtility.SUBTITLE)
    @Nullable
    private final AttributedText subtitle;
    @SerializedName("title")
    @NotNull
    private final String title;
    @Nullable
    private final Boolean typoCorrectionEnabled;
    @SerializedName("updatesForm")
    @Nullable
    private final Boolean updatesForm;
    @SerializedName(ResidentialComplexModuleKt.VALUES)
    @NotNull
    private final List<Value> values;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<MultiselectParameter> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MultiselectParameter createFromParcel(@NotNull Parcel parcel) {
            Boolean bool;
            LinkedHashSet linkedHashSet;
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            boolean z = true;
            boolean z2 = parcel.readInt() != 0;
            boolean z3 = parcel.readInt() != 0;
            AttributedText attributedText = (AttributedText) parcel.readParcelable(MultiselectParameter.class.getClassLoader());
            if (parcel.readInt() != 0) {
                if (parcel.readInt() == 0) {
                    z = false;
                }
                bool = Boolean.valueOf(z);
            } else {
                bool = null;
            }
            ArrayList<String> createStringArrayList = parcel.createStringArrayList();
            Displaying createFromParcel = parcel.readInt() != 0 ? Displaying.CREATOR.createFromParcel(parcel) : null;
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add(Value.CREATOR.createFromParcel(parcel));
                readInt--;
            }
            String readString3 = parcel.readString();
            Integer valueOf = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            Integer valueOf2 = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            AttributedText attributedText2 = (AttributedText) parcel.readParcelable(MultiselectParameter.class.getClassLoader());
            if (parcel.readInt() != 0) {
                int readInt2 = parcel.readInt();
                LinkedHashSet linkedHashSet2 = new LinkedHashSet(readInt2);
                while (readInt2 != 0) {
                    linkedHashSet2.add(parcel.readString());
                    readInt2--;
                }
                linkedHashSet = linkedHashSet2;
            } else {
                linkedHashSet = null;
            }
            return new MultiselectParameter(readString, readString2, z2, z3, attributedText, bool, createStringArrayList, createFromParcel, arrayList, readString3, valueOf, valueOf2, attributedText2, linkedHashSet);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MultiselectParameter[] newArray(int i) {
            return new MultiselectParameter[i];
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0012\b\b\u0018\u00002\u00020\u0001:\u0001:Bi\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b8\u00109J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0018\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\r\u0010\u0007J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0007J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012Jt\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0010HÆ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0004J\u0010\u0010\u001f\u001a\u00020\u001eHÖ\u0001¢\u0006\u0004\b\u001f\u0010 J\u001a\u0010#\u001a\u00020\u00052\b\u0010\"\u001a\u0004\u0018\u00010!HÖ\u0003¢\u0006\u0004\b#\u0010$J\u0010\u0010%\u001a\u00020\u001eHÖ\u0001¢\u0006\u0004\b%\u0010 J \u0010*\u001a\u00020)2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\u001eHÖ\u0001¢\u0006\u0004\b*\u0010+R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0017\u0010,\u001a\u0004\b-\u0010\u0007R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0018\u0010,\u001a\u0004\b.\u0010\u0007R$\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010/\u001a\u0004\b0\u0010\fR\u001c\u0010\u0013\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u00101\u001a\u0004\b2\u0010\u0004R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010,\u001a\u0004\b3\u0010\u0007R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001a\u00104\u001a\u0004\b5\u0010\u0012R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0019\u00101\u001a\u0004\b6\u0010\u0004R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010,\u001a\u0004\b7\u0010\u0007¨\u0006;"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/MultiselectParameter$Displaying;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/lang/Boolean;", "component3", "", "Lcom/avito/android/remote/model/category_parameters/MultiselectParameter$Displaying$Group;", "component4", "()Ljava/util/List;", "component5", "component6", "component7", "Lcom/avito/android/remote/model/category_parameters/SortDirection;", "component8", "()Lcom/avito/android/remote/model/category_parameters/SortDirection;", "type", "typoCorrectionEnabled", "areGroupsCollapsible", "groups", "keepSelectedChip", "withImages", "titlePattern", "sortDirection", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Lcom/avito/android/remote/model/category_parameters/SortDirection;)Lcom/avito/android/remote/model/category_parameters/MultiselectParameter$Displaying;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/Boolean;", "getKeepSelectedChip", "getWithImages", "Ljava/util/List;", "getGroups", "Ljava/lang/String;", "getType", "getTypoCorrectionEnabled", "Lcom/avito/android/remote/model/category_parameters/SortDirection;", "getSortDirection", "getTitlePattern", "getAreGroupsCollapsible", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Lcom/avito/android/remote/model/category_parameters/SortDirection;)V", "Group", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Displaying implements Parcelable {
        public static final Parcelable.Creator<Displaying> CREATOR = new Creator();
        @SerializedName("areGroupsCollapsible")
        @Nullable
        private final Boolean areGroupsCollapsible;
        @SerializedName("groups")
        @Nullable
        private final List<Group> groups;
        @SerializedName("keepSelected")
        @Nullable
        private final Boolean keepSelectedChip;
        @SerializedName("sortDirection")
        @Nullable
        private final SortDirection sortDirection;
        @SerializedName("titlePattern")
        @Nullable
        private final String titlePattern;
        @SerializedName("type")
        @NotNull
        private final String type;
        @SerializedName("typoCorrectionEnabled")
        @Nullable
        private final Boolean typoCorrectionEnabled;
        @SerializedName("withImages")
        @Nullable
        private final Boolean withImages;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Displaying> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Displaying createFromParcel(@NotNull Parcel parcel) {
                Boolean bool;
                Boolean bool2;
                ArrayList arrayList;
                Boolean bool3;
                Boolean bool4;
                Intrinsics.checkNotNullParameter(parcel, "in");
                String readString = parcel.readString();
                boolean z = true;
                if (parcel.readInt() != 0) {
                    bool = Boolean.valueOf(parcel.readInt() != 0);
                } else {
                    bool = null;
                }
                if (parcel.readInt() != 0) {
                    bool2 = Boolean.valueOf(parcel.readInt() != 0);
                } else {
                    bool2 = null;
                }
                if (parcel.readInt() != 0) {
                    int readInt = parcel.readInt();
                    arrayList = new ArrayList(readInt);
                    while (readInt != 0) {
                        arrayList.add(Group.CREATOR.createFromParcel(parcel));
                        readInt--;
                    }
                } else {
                    arrayList = null;
                }
                if (parcel.readInt() != 0) {
                    bool3 = Boolean.valueOf(parcel.readInt() != 0);
                } else {
                    bool3 = null;
                }
                if (parcel.readInt() != 0) {
                    if (parcel.readInt() == 0) {
                        z = false;
                    }
                    bool4 = Boolean.valueOf(z);
                } else {
                    bool4 = null;
                }
                return new Displaying(readString, bool, bool2, arrayList, bool3, bool4, parcel.readString(), parcel.readInt() != 0 ? (SortDirection) Enum.valueOf(SortDirection.class, parcel.readString()) : null);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Displaying[] newArray(int i) {
                return new Displaying[i];
            }
        }

        @Parcelize
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\"\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/MultiselectParameter$Displaying$Group;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "", "ids", "Ljava/util/List;", "getIds", "()Ljava/util/List;", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Group implements Parcelable {
            public static final Parcelable.Creator<Group> CREATOR = new Creator();
            @SerializedName("groupIds")
            @NotNull
            private final List<String> ids;
            @SerializedName("groupTitle")
            @Nullable
            private final String title;

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<Group> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Group createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    return new Group(parcel.createStringArrayList(), parcel.readString());
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Group[] newArray(int i) {
                    return new Group[i];
                }
            }

            public Group(@NotNull List<String> list, @Nullable String str) {
                Intrinsics.checkNotNullParameter(list, "ids");
                this.ids = list;
                this.title = str;
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @NotNull
            public final List<String> getIds() {
                return this.ids;
            }

            @Nullable
            public final String getTitle() {
                return this.title;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(@NotNull Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.writeStringList(this.ids);
                parcel.writeString(this.title);
            }
        }

        public Displaying(@NotNull String str, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable List<Group> list, @Nullable Boolean bool3, @Nullable Boolean bool4, @Nullable String str2, @Nullable SortDirection sortDirection2) {
            Intrinsics.checkNotNullParameter(str, "type");
            this.type = str;
            this.typoCorrectionEnabled = bool;
            this.areGroupsCollapsible = bool2;
            this.groups = list;
            this.keepSelectedChip = bool3;
            this.withImages = bool4;
            this.titlePattern = str2;
            this.sortDirection = sortDirection2;
        }

        public static /* synthetic */ Displaying copy$default(Displaying displaying, String str, Boolean bool, Boolean bool2, List list, Boolean bool3, Boolean bool4, String str2, SortDirection sortDirection2, int i, Object obj) {
            return displaying.copy((i & 1) != 0 ? displaying.type : str, (i & 2) != 0 ? displaying.typoCorrectionEnabled : bool, (i & 4) != 0 ? displaying.areGroupsCollapsible : bool2, (i & 8) != 0 ? displaying.groups : list, (i & 16) != 0 ? displaying.keepSelectedChip : bool3, (i & 32) != 0 ? displaying.withImages : bool4, (i & 64) != 0 ? displaying.titlePattern : str2, (i & 128) != 0 ? displaying.sortDirection : sortDirection2);
        }

        @NotNull
        public final String component1() {
            return this.type;
        }

        @Nullable
        public final Boolean component2() {
            return this.typoCorrectionEnabled;
        }

        @Nullable
        public final Boolean component3() {
            return this.areGroupsCollapsible;
        }

        @Nullable
        public final List<Group> component4() {
            return this.groups;
        }

        @Nullable
        public final Boolean component5() {
            return this.keepSelectedChip;
        }

        @Nullable
        public final Boolean component6() {
            return this.withImages;
        }

        @Nullable
        public final String component7() {
            return this.titlePattern;
        }

        @Nullable
        public final SortDirection component8() {
            return this.sortDirection;
        }

        @NotNull
        public final Displaying copy(@NotNull String str, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable List<Group> list, @Nullable Boolean bool3, @Nullable Boolean bool4, @Nullable String str2, @Nullable SortDirection sortDirection2) {
            Intrinsics.checkNotNullParameter(str, "type");
            return new Displaying(str, bool, bool2, list, bool3, bool4, str2, sortDirection2);
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
            return Intrinsics.areEqual(this.type, displaying.type) && Intrinsics.areEqual(this.typoCorrectionEnabled, displaying.typoCorrectionEnabled) && Intrinsics.areEqual(this.areGroupsCollapsible, displaying.areGroupsCollapsible) && Intrinsics.areEqual(this.groups, displaying.groups) && Intrinsics.areEqual(this.keepSelectedChip, displaying.keepSelectedChip) && Intrinsics.areEqual(this.withImages, displaying.withImages) && Intrinsics.areEqual(this.titlePattern, displaying.titlePattern) && Intrinsics.areEqual(this.sortDirection, displaying.sortDirection);
        }

        @Nullable
        public final Boolean getAreGroupsCollapsible() {
            return this.areGroupsCollapsible;
        }

        @Nullable
        public final List<Group> getGroups() {
            return this.groups;
        }

        @Nullable
        public final Boolean getKeepSelectedChip() {
            return this.keepSelectedChip;
        }

        @Nullable
        public final SortDirection getSortDirection() {
            return this.sortDirection;
        }

        @Nullable
        public final String getTitlePattern() {
            return this.titlePattern;
        }

        @NotNull
        public final String getType() {
            return this.type;
        }

        @Nullable
        public final Boolean getTypoCorrectionEnabled() {
            return this.typoCorrectionEnabled;
        }

        @Nullable
        public final Boolean getWithImages() {
            return this.withImages;
        }

        @Override // java.lang.Object
        public int hashCode() {
            String str = this.type;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            Boolean bool = this.typoCorrectionEnabled;
            int hashCode2 = (hashCode + (bool != null ? bool.hashCode() : 0)) * 31;
            Boolean bool2 = this.areGroupsCollapsible;
            int hashCode3 = (hashCode2 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
            List<Group> list = this.groups;
            int hashCode4 = (hashCode3 + (list != null ? list.hashCode() : 0)) * 31;
            Boolean bool3 = this.keepSelectedChip;
            int hashCode5 = (hashCode4 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
            Boolean bool4 = this.withImages;
            int hashCode6 = (hashCode5 + (bool4 != null ? bool4.hashCode() : 0)) * 31;
            String str2 = this.titlePattern;
            int hashCode7 = (hashCode6 + (str2 != null ? str2.hashCode() : 0)) * 31;
            SortDirection sortDirection2 = this.sortDirection;
            if (sortDirection2 != null) {
                i = sortDirection2.hashCode();
            }
            return hashCode7 + i;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("Displaying(type=");
            L.append(this.type);
            L.append(", typoCorrectionEnabled=");
            L.append(this.typoCorrectionEnabled);
            L.append(", areGroupsCollapsible=");
            L.append(this.areGroupsCollapsible);
            L.append(", groups=");
            L.append(this.groups);
            L.append(", keepSelectedChip=");
            L.append(this.keepSelectedChip);
            L.append(", withImages=");
            L.append(this.withImages);
            L.append(", titlePattern=");
            L.append(this.titlePattern);
            L.append(", sortDirection=");
            L.append(this.sortDirection);
            L.append(")");
            return L.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.type);
            Boolean bool = this.typoCorrectionEnabled;
            if (bool != null) {
                a.G0(parcel, 1, bool);
            } else {
                parcel.writeInt(0);
            }
            Boolean bool2 = this.areGroupsCollapsible;
            if (bool2 != null) {
                a.G0(parcel, 1, bool2);
            } else {
                parcel.writeInt(0);
            }
            List<Group> list = this.groups;
            if (list != null) {
                Iterator l0 = a.l0(parcel, 1, list);
                while (l0.hasNext()) {
                    ((Group) l0.next()).writeToParcel(parcel, 0);
                }
            } else {
                parcel.writeInt(0);
            }
            Boolean bool3 = this.keepSelectedChip;
            if (bool3 != null) {
                a.G0(parcel, 1, bool3);
            } else {
                parcel.writeInt(0);
            }
            Boolean bool4 = this.withImages;
            if (bool4 != null) {
                a.G0(parcel, 1, bool4);
            } else {
                parcel.writeInt(0);
            }
            parcel.writeString(this.titlePattern);
            SortDirection sortDirection2 = this.sortDirection;
            if (sortDirection2 != null) {
                parcel.writeInt(1);
                parcel.writeString(sortDirection2.name());
                return;
            }
            parcel.writeInt(0);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Displaying(String str, Boolean bool, Boolean bool2, List list, Boolean bool3, Boolean bool4, String str2, SortDirection sortDirection2, int i, j jVar) {
            this(str, (i & 2) != 0 ? Boolean.FALSE : bool, (i & 4) != 0 ? Boolean.FALSE : bool2, (i & 8) != 0 ? null : list, (i & 16) != 0 ? null : bool3, (i & 32) != 0 ? Boolean.FALSE : bool4, (i & 64) != 0 ? null : str2, (i & 128) == 0 ? sortDirection2 : null);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001%B!\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b#\u0010$J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ0\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0011J \u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u001c\u0010\n\u001a\u00020\u00028\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\n\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R\u001c\u0010\t\u001a\u00020\u00028\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\t\u0010\u001e\u001a\u0004\b \u0010\u0004R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010!\u001a\u0004\b\"\u0010\b¨\u0006&"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/MultiselectParameter$Value;", "Lcom/avito/android/remote/model/ParcelableEntity;", "", "component1", "()Ljava/lang/String;", "component2", "Lcom/avito/android/remote/model/category_parameters/MultiselectParameter$Value$Display;", "component3", "()Lcom/avito/android/remote/model/category_parameters/MultiselectParameter$Value$Display;", "id", "name", "display", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/category_parameters/MultiselectParameter$Value$Display;)Lcom/avito/android/remote/model/category_parameters/MultiselectParameter$Value;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getName", "getId", "Lcom/avito/android/remote/model/category_parameters/MultiselectParameter$Value$Display;", "getDisplay", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/category_parameters/MultiselectParameter$Value$Display;)V", "Display", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Value implements ParcelableEntity<String> {
        public static final Parcelable.Creator<Value> CREATOR = new Creator();
        @SerializedName("display")
        @Nullable
        private final Display display;
        @SerializedName("id")
        @NotNull
        private final String id;
        @SerializedName("title")
        @NotNull
        private final String name;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Value> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Value createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Value(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? Display.CREATOR.createFromParcel(parcel) : null);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Value[] newArray(int i) {
                return new Value[i];
            }
        }

        @Parcelize
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001BA\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lcom/avito/android/remote/model/category_parameters/MultiselectParameter$Value$Display;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/Color;", "color", "Lcom/avito/android/remote/model/Color;", "getColor", "()Lcom/avito/android/remote/model/Color;", "", "sortParam", "Ljava/lang/String;", "getSortParam", "()Ljava/lang/String;", "title", "getTitle", MessengerShareContentUtility.SUBTITLE, "getSubtitle", "Lcom/avito/android/remote/model/Image;", "image", "Lcom/avito/android/remote/model/Image;", "getImage", "()Lcom/avito/android/remote/model/Image;", "<init>", "(Lcom/avito/android/remote/model/Color;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;Ljava/lang/String;)V", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Display implements Parcelable {
            public static final Parcelable.Creator<Display> CREATOR = new Creator();
            @SerializedName("color")
            @Nullable
            private final Color color;
            @SerializedName("images")
            @Nullable
            private final Image image;
            @SerializedName("sortParam")
            @Nullable
            private final String sortParam;
            @SerializedName(MessengerShareContentUtility.SUBTITLE)
            @Nullable
            private final String subtitle;
            @SerializedName("title")
            @Nullable
            private final String title;

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<Display> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Display createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    return new Display(parcel.readInt() != 0 ? Color.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readString(), (Image) parcel.readParcelable(Display.class.getClassLoader()), parcel.readString());
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Display[] newArray(int i) {
                    return new Display[i];
                }
            }

            public Display(@Nullable Color color2, @Nullable String str, @Nullable String str2, @Nullable Image image2, @Nullable String str3) {
                this.color = color2;
                this.title = str;
                this.subtitle = str2;
                this.image = image2;
                this.sortParam = str3;
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Nullable
            public final Color getColor() {
                return this.color;
            }

            @Nullable
            public final Image getImage() {
                return this.image;
            }

            @Nullable
            public final String getSortParam() {
                return this.sortParam;
            }

            @Nullable
            public final String getSubtitle() {
                return this.subtitle;
            }

            @Nullable
            public final String getTitle() {
                return this.title;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(@NotNull Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                Color color2 = this.color;
                if (color2 != null) {
                    parcel.writeInt(1);
                    color2.writeToParcel(parcel, 0);
                } else {
                    parcel.writeInt(0);
                }
                parcel.writeString(this.title);
                parcel.writeString(this.subtitle);
                parcel.writeParcelable(this.image, i);
                parcel.writeString(this.sortParam);
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Display(Color color2, String str, String str2, Image image2, String str3, int i, j jVar) {
                this(color2, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : image2, (i & 16) != 0 ? null : str3);
            }
        }

        public Value(@NotNull String str, @NotNull String str2, @Nullable Display display2) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "name");
            this.id = str;
            this.name = str2;
            this.display = display2;
        }

        public static /* synthetic */ Value copy$default(Value value, String str, String str2, Display display2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = value.getId();
            }
            if ((i & 2) != 0) {
                str2 = value.getName();
            }
            if ((i & 4) != 0) {
                display2 = value.display;
            }
            return value.copy(str, str2, display2);
        }

        @NotNull
        public final String component1() {
            return getId();
        }

        @NotNull
        public final String component2() {
            return getName();
        }

        @Nullable
        public final Display component3() {
            return this.display;
        }

        @NotNull
        public final Value copy(@NotNull String str, @NotNull String str2, @Nullable Display display2) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "name");
            return new Value(str, str2, display2);
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
            return Intrinsics.areEqual(getId(), value.getId()) && Intrinsics.areEqual(getName(), value.getName()) && Intrinsics.areEqual(this.display, value.display);
        }

        @Nullable
        public final Display getDisplay() {
            return this.display;
        }

        @Override // com.avito.android.remote.model.Entity
        @NotNull
        public String getName() {
            return this.name;
        }

        @Override // java.lang.Object
        public int hashCode() {
            String id2 = getId();
            int i = 0;
            int hashCode = (id2 != null ? id2.hashCode() : 0) * 31;
            String name2 = getName();
            int hashCode2 = (hashCode + (name2 != null ? name2.hashCode() : 0)) * 31;
            Display display2 = this.display;
            if (display2 != null) {
                i = display2.hashCode();
            }
            return hashCode2 + i;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("Value(id=");
            L.append(getId());
            L.append(", name=");
            L.append(getName());
            L.append(", display=");
            L.append(this.display);
            L.append(")");
            return L.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.id);
            parcel.writeString(this.name);
            Display display2 = this.display;
            if (display2 != null) {
                parcel.writeInt(1);
                display2.writeToParcel(parcel, 0);
                return;
            }
            parcel.writeInt(0);
        }

        @Override // com.avito.android.remote.model.Entity
        @NotNull
        public String getId() {
            return this.id;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MultiselectParameter(String str, String str2, boolean z, boolean z2, AttributedText attributedText, Boolean bool, List list, Displaying displaying2, List list2, String str3, Integer num, Integer num2, AttributedText attributedText2, Set set, int i, j jVar) {
        this(str, str2, z, z2, attributedText, bool, list, displaying2, list2, (i & 512) != 0 ? null : str3, (i & 1024) != 0 ? null : num, (i & 2048) != 0 ? null : num2, (i & 4096) != 0 ? null : attributedText2, (i & 8192) != 0 ? null : set);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r15v0, resolved type: com.avito.android.remote.model.category_parameters.MultiselectParameter */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MultiselectParameter copy$default(MultiselectParameter multiselectParameter, String str, String str2, boolean z, boolean z2, AttributedText attributedText, Boolean bool, List list, Displaying displaying2, List list2, String str3, Integer num, Integer num2, AttributedText attributedText2, Set set, int i, Object obj) {
        return multiselectParameter.copy((i & 1) != 0 ? multiselectParameter.getId() : str, (i & 2) != 0 ? multiselectParameter.getTitle() : str2, (i & 4) != 0 ? multiselectParameter.getRequired() : z, (i & 8) != 0 ? multiselectParameter.getImmutable() : z2, (i & 16) != 0 ? multiselectParameter.getMotivation() : attributedText, (i & 32) != 0 ? multiselectParameter.getUpdatesForm() : bool, (i & 64) != 0 ? multiselectParameter.get_value() : list, (i & 128) != 0 ? multiselectParameter.displaying : displaying2, (i & 256) != 0 ? multiselectParameter.values : list2, (i & 512) != 0 ? multiselectParameter.getPlaceholder() : str3, (i & 1024) != 0 ? multiselectParameter.getAttributeId() : num, (i & 2048) != 0 ? multiselectParameter.maxSelected : num2, (i & 4096) != 0 ? multiselectParameter.subtitle : attributedText2, (i & 8192) != 0 ? multiselectParameter.availableOptions : set);
    }

    public static /* synthetic */ void getTypoCorrectionEnabled$annotations() {
    }

    @NotNull
    public final String component1() {
        return getId();
    }

    @Nullable
    public final String component10() {
        return getPlaceholder();
    }

    @Nullable
    public final Integer component11() {
        return getAttributeId();
    }

    @Nullable
    public final Integer component12() {
        return this.maxSelected;
    }

    @Nullable
    public final AttributedText component13() {
        return this.subtitle;
    }

    @Nullable
    public final Set<String> component14() {
        return this.availableOptions;
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

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.util.List<? extends java.lang.String>, java.util.List<java.lang.String> */
    @Nullable
    public final List<String> component7() {
        return get_value();
    }

    @Nullable
    public final Displaying component8() {
        return this.displaying;
    }

    @NotNull
    public final List<Value> component9() {
        return this.values;
    }

    @NotNull
    public final MultiselectParameter copy(@NotNull String str, @NotNull String str2, boolean z, boolean z2, @Nullable AttributedText attributedText, @Nullable Boolean bool, @Nullable List<String> list, @Nullable Displaying displaying2, @NotNull List<Value> list2, @Nullable String str3, @Nullable Integer num, @Nullable Integer num2, @Nullable AttributedText attributedText2, @Nullable Set<String> set) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(list2, ResidentialComplexModuleKt.VALUES);
        return new MultiselectParameter(str, str2, z, z2, attributedText, bool, list, displaying2, list2, str3, num, num2, attributedText2, set);
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
        if (!(obj instanceof MultiselectParameter)) {
            return false;
        }
        MultiselectParameter multiselectParameter = (MultiselectParameter) obj;
        return Intrinsics.areEqual(getId(), multiselectParameter.getId()) && Intrinsics.areEqual(getTitle(), multiselectParameter.getTitle()) && getRequired() == multiselectParameter.getRequired() && getImmutable() == multiselectParameter.getImmutable() && Intrinsics.areEqual(getMotivation(), multiselectParameter.getMotivation()) && Intrinsics.areEqual(getUpdatesForm(), multiselectParameter.getUpdatesForm()) && Intrinsics.areEqual(get_value(), multiselectParameter.get_value()) && Intrinsics.areEqual(this.displaying, multiselectParameter.displaying) && Intrinsics.areEqual(this.values, multiselectParameter.values) && Intrinsics.areEqual(getPlaceholder(), multiselectParameter.getPlaceholder()) && Intrinsics.areEqual(getAttributeId(), multiselectParameter.getAttributeId()) && Intrinsics.areEqual(this.maxSelected, multiselectParameter.maxSelected) && Intrinsics.areEqual(this.subtitle, multiselectParameter.subtitle) && Intrinsics.areEqual(this.availableOptions, multiselectParameter.availableOptions);
    }

    @Override // com.avito.android.remote.model.category_parameters.base.CanHaveTypeCorrection
    @Nullable
    public Integer getAttributeId() {
        return this.attributeId;
    }

    @Nullable
    public final Set<String> getAvailableOptions() {
        return this.availableOptions;
    }

    @Nullable
    public final Displaying getDisplaying() {
        return this.displaying;
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

    @Nullable
    public final Integer getMaxSelected() {
        return this.maxSelected;
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
    public final AttributedText getSubtitle() {
        return this.subtitle;
    }

    @Override // com.avito.android.remote.model.category_parameters.base.BaseParameter
    @NotNull
    public String getTitle() {
        return this.title;
    }

    @Override // com.avito.android.remote.model.category_parameters.base.CanHaveTypeCorrection
    @Nullable
    public Boolean getTypoCorrectionEnabled() {
        return this.typoCorrectionEnabled;
    }

    @Override // com.avito.android.remote.model.category_parameters.base.BaseEditableParameter
    @Nullable
    public Boolean getUpdatesForm() {
        return this.updatesForm;
    }

    @NotNull
    public final List<Value> getValues() {
        return this.values;
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
        List<? extends String> list = get_value();
        int hashCode5 = (hashCode4 + (list != null ? list.hashCode() : 0)) * 31;
        Displaying displaying2 = this.displaying;
        int hashCode6 = (hashCode5 + (displaying2 != null ? displaying2.hashCode() : 0)) * 31;
        List<Value> list2 = this.values;
        int hashCode7 = (hashCode6 + (list2 != null ? list2.hashCode() : 0)) * 31;
        String placeholder2 = getPlaceholder();
        int hashCode8 = (hashCode7 + (placeholder2 != null ? placeholder2.hashCode() : 0)) * 31;
        Integer attributeId2 = getAttributeId();
        int hashCode9 = (hashCode8 + (attributeId2 != null ? attributeId2.hashCode() : 0)) * 31;
        Integer num = this.maxSelected;
        int hashCode10 = (hashCode9 + (num != null ? num.hashCode() : 0)) * 31;
        AttributedText attributedText = this.subtitle;
        int hashCode11 = (hashCode10 + (attributedText != null ? attributedText.hashCode() : 0)) * 31;
        Set<String> set = this.availableOptions;
        if (set != null) {
            i = set.hashCode();
        }
        return hashCode11 + i;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.avito.android.remote.model.category_parameters.base.EditableParameter
    public /* bridge */ /* synthetic */ void set_value(List<? extends String> list) {
        set_value((List<String>) list);
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("MultiselectParameter(id:");
        L.append(getId());
        L.append(')');
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
        parcel.writeStringList(this._value);
        Displaying displaying2 = this.displaying;
        if (displaying2 != null) {
            parcel.writeInt(1);
            displaying2.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        Iterator n0 = a.n0(this.values, parcel);
        while (n0.hasNext()) {
            ((Value) n0.next()).writeToParcel(parcel, 0);
        }
        parcel.writeString(this.placeholder);
        Integer num = this.attributeId;
        if (num != null) {
            a.H0(parcel, 1, num);
        } else {
            parcel.writeInt(0);
        }
        Integer num2 = this.maxSelected;
        if (num2 != null) {
            a.H0(parcel, 1, num2);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeParcelable(this.subtitle, i);
        Set<String> set = this.availableOptions;
        if (set != null) {
            parcel.writeInt(1);
            parcel.writeInt(set.size());
            for (String str : set) {
                parcel.writeString(str);
            }
            return;
        }
        parcel.writeInt(0);
    }

    public MultiselectParameter(@NotNull String str, @NotNull String str2, boolean z, boolean z2, @Nullable AttributedText attributedText, @Nullable Boolean bool, @Nullable List<String> list, @Nullable Displaying displaying2, @NotNull List<Value> list2, @Nullable String str3, @Nullable Integer num, @Nullable Integer num2, @Nullable AttributedText attributedText2, @Nullable Set<String> set) {
        a.c1(str, "id", str2, "title", list2, ResidentialComplexModuleKt.VALUES);
        this.id = str;
        this.title = str2;
        this.required = z;
        this.immutable = z2;
        this.motivation = attributedText;
        this.updatesForm = bool;
        this._value = list;
        this.displaying = displaying2;
        this.values = list2;
        this.placeholder = str3;
        this.attributeId = num;
        this.maxSelected = num2;
        this.subtitle = attributedText2;
        this.availableOptions = set;
        this.typoCorrectionEnabled = displaying2 != null ? displaying2.getTypoCorrectionEnabled() : null;
    }

    /* Return type fixed from 'java.util.List<java.lang.String>' to match base method */
    @Override // com.avito.android.remote.model.category_parameters.base.EditableParameter
    @Nullable
    public List<? extends String> get_value() {
        return this._value;
    }

    public void set_value(@Nullable List<String> list) {
        this._value = list;
    }
}
