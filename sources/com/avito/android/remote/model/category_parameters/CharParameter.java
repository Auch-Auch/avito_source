package com.avito.android.remote.model.category_parameters;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.advert_core.analytics.contactbar.PhonePageSourceKt;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.remote.model.category_parameters.base.EditableParameter;
import com.avito.android.remote.model.category_parameters.base.HasHtmlValueSupport;
import com.avito.android.remote.model.category_parameters.base.HasTags;
import com.avito.android.remote.model.category_parameters.base.TextParameter;
import com.avito.android.remote.model.text.AttributedText;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b&\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u0001kB§\u0001\u0012\u0006\u0010)\u001a\u00020\u0002\u0012\u0006\u0010*\u001a\u00020\u0002\u0012\u0006\u0010+\u001a\u00020\n\u0012\u0006\u0010,\u001a\u00020\n\u0012\b\u0010-\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010.\u001a\u0004\u0018\u00010\n\u0012\b\u0010/\u001a\u0004\u0018\u00010\u0002\u0012\b\u00100\u001a\u0004\u0018\u00010\u0002\u0012\b\u00101\u001a\u0004\u0018\u00010\u0019\u0012\u000e\u00102\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c\u0012\b\u00103\u001a\u0004\u0018\u00010 \u0012\b\u00104\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u00105\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010\u001c\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010&¢\u0006\u0004\bi\u0010jJ\u0012\u0010\b\u001a\u0004\u0018\u00010\u0007HÂ\u0003¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u0010\u0010\fJ\u0010\u0010\u0011\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u0011\u0010\fJ\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u000eJ\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u000eJ\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cHÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0012\u0010!\u001a\u0004\u0018\u00010 HÆ\u0003¢\u0006\u0004\b!\u0010\"J\u0012\u0010#\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b#\u0010\u000eJ\u0018\u0010%\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010\u001cHÆ\u0003¢\u0006\u0004\b%\u0010\u001fJ\u0012\u0010'\u001a\u0004\u0018\u00010&HÆ\u0003¢\u0006\u0004\b'\u0010(JÈ\u0001\u00108\u001a\u00020\u00002\b\b\u0002\u0010)\u001a\u00020\u00022\b\b\u0002\u0010*\u001a\u00020\u00022\b\b\u0002\u0010+\u001a\u00020\n2\b\b\u0002\u0010,\u001a\u00020\n2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u00192\u0010\b\u0002\u00102\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c2\n\b\u0002\u00103\u001a\u0004\u0018\u00010 2\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u00105\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010\u001c2\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u00107\u001a\u0004\u0018\u00010&HÆ\u0001¢\u0006\u0004\b8\u00109J\u0010\u0010:\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b:\u0010\u000eJ\u0010\u0010<\u001a\u00020;HÖ\u0001¢\u0006\u0004\b<\u0010=J\u001a\u0010@\u001a\u00020\n2\b\u0010?\u001a\u0004\u0018\u00010>HÖ\u0003¢\u0006\u0004\b@\u0010AJ\u0010\u0010B\u001a\u00020;HÖ\u0001¢\u0006\u0004\bB\u0010=J \u0010G\u001a\u00020F2\u0006\u0010D\u001a\u00020C2\u0006\u0010E\u001a\u00020;HÖ\u0001¢\u0006\u0004\bG\u0010HR$\u00105\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010\u001c8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b5\u0010I\u001a\u0004\bJ\u0010\u001fR\u001e\u00104\u001a\u0004\u0018\u00010\u00028\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b4\u0010K\u001a\u0004\bL\u0010\u000eR\u001e\u0010.\u001a\u0004\u0018\u00010\n8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b.\u0010M\u001a\u0004\bN\u0010\u0016R\u001c\u0010)\u001a\u00020\u00028\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b)\u0010K\u001a\u0004\bO\u0010\u000eR$\u00100\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b0\u0010K\u001a\u0004\bP\u0010\u000e\"\u0004\bQ\u0010RR*\u0010S\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u000e¢\u0006\u0018\n\u0004\bS\u0010K\u0012\u0004\bV\u0010W\u001a\u0004\bT\u0010\u000e\"\u0004\bU\u0010RR\u001e\u00107\u001a\u0004\u0018\u00010&8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b7\u0010X\u001a\u0004\bY\u0010(R\u001c\u0010,\u001a\u00020\n8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b,\u0010Z\u001a\u0004\b[\u0010\fR\u001e\u0010/\u001a\u0004\u0018\u00010\u00028\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b/\u0010K\u001a\u0004\b\\\u0010\u000eR\u0018\u00106\u001a\u0004\u0018\u00010\u00078\u0002@\u0003X\u0004¢\u0006\u0006\n\u0004\b6\u0010]R\u0013\u0010_\u001a\u00020\u00078F@\u0006¢\u0006\u0006\u001a\u0004\b^\u0010\tR$\u00102\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b2\u0010I\u001a\u0004\b`\u0010\u001fR\u001c\u0010+\u001a\u00020\n8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b+\u0010Z\u001a\u0004\ba\u0010\fR\u001e\u0010-\u001a\u0004\u0018\u00010\u00128\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b-\u0010b\u001a\u0004\bc\u0010\u0014R\u001c\u0010*\u001a\u00020\u00028\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b*\u0010K\u001a\u0004\bd\u0010\u000eR\u001e\u00103\u001a\u0004\u0018\u00010 8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b3\u0010e\u001a\u0004\bf\u0010\"R\u001e\u00101\u001a\u0004\u0018\u00010\u00198\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b1\u0010g\u001a\u0004\bh\u0010\u001b¨\u0006l"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/CharParameter;", "Lcom/avito/android/remote/model/category_parameters/base/EditableParameter;", "", "Lcom/avito/android/remote/model/category_parameters/base/TextParameter;", "Lcom/avito/android/remote/model/category_parameters/base/HasTags;", "Lcom/avito/android/remote/model/category_parameters/base/HasHtmlValueSupport;", "Lcom/avito/android/remote/model/category_parameters/WithAutogeneratedValue;", "Lcom/avito/android/remote/model/category_parameters/CharParameter$InputType;", "component14", "()Lcom/avito/android/remote/model/category_parameters/CharParameter$InputType;", "", "hasValue", "()Z", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "Lcom/avito/android/remote/model/text/AttributedText;", "component5", "()Lcom/avito/android/remote/model/text/AttributedText;", "component6", "()Ljava/lang/Boolean;", "component7", "component8", "Lcom/avito/android/remote/model/category_parameters/DisplayingOptions;", "component9", "()Lcom/avito/android/remote/model/category_parameters/DisplayingOptions;", "", "Lcom/avito/android/remote/model/category_parameters/Constraint;", "component10", "()Ljava/util/List;", "Lcom/avito/android/remote/model/category_parameters/ParamButton;", "component11", "()Lcom/avito/android/remote/model/category_parameters/ParamButton;", "component12", "Lcom/avito/android/remote/model/category_parameters/TextualTag;", "component13", "Lcom/avito/android/remote/model/category_parameters/AutoGeneratedValue;", "component15", "()Lcom/avito/android/remote/model/category_parameters/AutoGeneratedValue;", "id", "title", "required", "immutable", "motivation", "updatesForm", "hint", "_value", "displayingOptions", "constraints", PhonePageSourceKt.PHONE_SOURCE_BUTTON, InternalConstsKt.PLACEHOLDER, "tags", "_inputType", "autogeneratedValue", "copy", "(Ljava/lang/String;Ljava/lang/String;ZZLcom/avito/android/remote/model/text/AttributedText;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/category_parameters/DisplayingOptions;Ljava/util/List;Lcom/avito/android/remote/model/category_parameters/ParamButton;Ljava/lang/String;Ljava/util/List;Lcom/avito/android/remote/model/category_parameters/CharParameter$InputType;Lcom/avito/android/remote/model/category_parameters/AutoGeneratedValue;)Lcom/avito/android/remote/model/category_parameters/CharParameter;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/util/List;", "getTags", "Ljava/lang/String;", "getPlaceholder", "Ljava/lang/Boolean;", "getUpdatesForm", "getId", "get_value", "set_value", "(Ljava/lang/String;)V", "renderedHtmlValue", "getRenderedHtmlValue", "setRenderedHtmlValue", "getRenderedHtmlValue$annotations", "()V", "Lcom/avito/android/remote/model/category_parameters/AutoGeneratedValue;", "getAutogeneratedValue", "Z", "getImmutable", "getHint", "Lcom/avito/android/remote/model/category_parameters/CharParameter$InputType;", "getInputType", "inputType", "getConstraints", "getRequired", "Lcom/avito/android/remote/model/text/AttributedText;", "getMotivation", "getTitle", "Lcom/avito/android/remote/model/category_parameters/ParamButton;", "getButton", "Lcom/avito/android/remote/model/category_parameters/DisplayingOptions;", "getDisplayingOptions", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZZLcom/avito/android/remote/model/text/AttributedText;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/category_parameters/DisplayingOptions;Ljava/util/List;Lcom/avito/android/remote/model/category_parameters/ParamButton;Ljava/lang/String;Ljava/util/List;Lcom/avito/android/remote/model/category_parameters/CharParameter$InputType;Lcom/avito/android/remote/model/category_parameters/AutoGeneratedValue;)V", "InputType", "models_release"}, k = 1, mv = {1, 4, 2})
public final class CharParameter extends EditableParameter<String> implements TextParameter, HasTags, HasHtmlValueSupport, WithAutogeneratedValue {
    public static final Parcelable.Creator<CharParameter> CREATOR = new Creator();
    @SerializedName("inputType")
    private final InputType _inputType;
    @SerializedName("value")
    @Nullable
    private String _value;
    @SerializedName("autoGeneratedValue")
    @Nullable
    private final AutoGeneratedValue autogeneratedValue;
    @SerializedName(PhonePageSourceKt.PHONE_SOURCE_BUTTON)
    @Nullable
    private final ParamButton button;
    @SerializedName("constraints")
    @Nullable
    private final List<Constraint> constraints;
    @SerializedName("displaying")
    @Nullable
    private final DisplayingOptions displayingOptions;
    @SerializedName("hint")
    @Nullable
    private final String hint;
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
    @Nullable
    private String renderedHtmlValue;
    @SerializedName("required")
    private final boolean required;
    @SerializedName("tags")
    @Nullable
    private final List<TextualTag> tags;
    @SerializedName("title")
    @NotNull
    private final String title;
    @SerializedName("updatesForm")
    @Nullable
    private final Boolean updatesForm;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<CharParameter> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CharParameter createFromParcel(@NotNull Parcel parcel) {
            Boolean bool;
            ArrayList arrayList;
            ArrayList arrayList2;
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            boolean z = true;
            boolean z2 = parcel.readInt() != 0;
            boolean z3 = parcel.readInt() != 0;
            AttributedText attributedText = (AttributedText) parcel.readParcelable(CharParameter.class.getClassLoader());
            if (parcel.readInt() != 0) {
                if (parcel.readInt() == 0) {
                    z = false;
                }
                bool = Boolean.valueOf(z);
            } else {
                bool = null;
            }
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            DisplayingOptions createFromParcel = parcel.readInt() != 0 ? DisplayingOptions.CREATOR.createFromParcel(parcel) : null;
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                ArrayList arrayList3 = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList3.add((Constraint) parcel.readParcelable(CharParameter.class.getClassLoader()));
                    readInt--;
                }
                arrayList = arrayList3;
            } else {
                arrayList = null;
            }
            ParamButton createFromParcel2 = parcel.readInt() != 0 ? ParamButton.CREATOR.createFromParcel(parcel) : null;
            String readString5 = parcel.readString();
            if (parcel.readInt() != 0) {
                int readInt2 = parcel.readInt();
                ArrayList arrayList4 = new ArrayList(readInt2);
                while (readInt2 != 0) {
                    arrayList4.add(TextualTag.CREATOR.createFromParcel(parcel));
                    readInt2--;
                }
                arrayList2 = arrayList4;
            } else {
                arrayList2 = null;
            }
            return new CharParameter(readString, readString2, z2, z3, attributedText, bool, readString3, readString4, createFromParcel, arrayList, createFromParcel2, readString5, arrayList2, parcel.readInt() != 0 ? (InputType) Enum.valueOf(InputType.class, parcel.readString()) : null, parcel.readInt() != 0 ? AutoGeneratedValue.CREATOR.createFromParcel(parcel) : null);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CharParameter[] newArray(int i) {
            return new CharParameter[i];
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/CharParameter$InputType;", "", "<init>", "(Ljava/lang/String;I)V", "TEXT", "EMAIL", "VIN", "models_release"}, k = 1, mv = {1, 4, 2})
    public enum InputType {
        TEXT,
        EMAIL,
        VIN
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CharParameter(String str, String str2, boolean z, boolean z2, AttributedText attributedText, Boolean bool, String str3, String str4, DisplayingOptions displayingOptions2, List list, ParamButton paramButton, String str5, List list2, InputType inputType, AutoGeneratedValue autoGeneratedValue, int i, j jVar) {
        this(str, str2, z, z2, attributedText, bool, str3, str4, displayingOptions2, list, paramButton, str5, (i & 4096) != 0 ? null : list2, (i & 8192) != 0 ? null : inputType, (i & 16384) != 0 ? null : autoGeneratedValue);
    }

    private final InputType component14() {
        return this._inputType;
    }

    public static /* synthetic */ CharParameter copy$default(CharParameter charParameter, String str, String str2, boolean z, boolean z2, AttributedText attributedText, Boolean bool, String str3, String str4, DisplayingOptions displayingOptions2, List list, ParamButton paramButton, String str5, List list2, InputType inputType, AutoGeneratedValue autoGeneratedValue, int i, Object obj) {
        return charParameter.copy((i & 1) != 0 ? charParameter.getId() : str, (i & 2) != 0 ? charParameter.getTitle() : str2, (i & 4) != 0 ? charParameter.getRequired() : z, (i & 8) != 0 ? charParameter.getImmutable() : z2, (i & 16) != 0 ? charParameter.getMotivation() : attributedText, (i & 32) != 0 ? charParameter.getUpdatesForm() : bool, (i & 64) != 0 ? charParameter.getHint() : str3, (i & 128) != 0 ? charParameter.get_value() : str4, (i & 256) != 0 ? charParameter.getDisplayingOptions() : displayingOptions2, (i & 512) != 0 ? charParameter.getConstraints() : list, (i & 1024) != 0 ? charParameter.button : paramButton, (i & 2048) != 0 ? charParameter.getPlaceholder() : str5, (i & 4096) != 0 ? charParameter.getTags() : list2, (i & 8192) != 0 ? charParameter._inputType : inputType, (i & 16384) != 0 ? charParameter.getAutogeneratedValue() : autoGeneratedValue);
    }

    public static /* synthetic */ void getRenderedHtmlValue$annotations() {
    }

    @NotNull
    public final String component1() {
        return getId();
    }

    @Nullable
    public final List<Constraint> component10() {
        return getConstraints();
    }

    @Nullable
    public final ParamButton component11() {
        return this.button;
    }

    @Nullable
    public final String component12() {
        return getPlaceholder();
    }

    @Nullable
    public final List<TextualTag> component13() {
        return getTags();
    }

    @Nullable
    public final AutoGeneratedValue component15() {
        return getAutogeneratedValue();
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
    public final String component7() {
        return getHint();
    }

    @Nullable
    public final String component8() {
        return get_value();
    }

    @Nullable
    public final DisplayingOptions component9() {
        return getDisplayingOptions();
    }

    @NotNull
    public final CharParameter copy(@NotNull String str, @NotNull String str2, boolean z, boolean z2, @Nullable AttributedText attributedText, @Nullable Boolean bool, @Nullable String str3, @Nullable String str4, @Nullable DisplayingOptions displayingOptions2, @Nullable List<? extends Constraint> list, @Nullable ParamButton paramButton, @Nullable String str5, @Nullable List<TextualTag> list2, @Nullable InputType inputType, @Nullable AutoGeneratedValue autoGeneratedValue) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        return new CharParameter(str, str2, z, z2, attributedText, bool, str3, str4, displayingOptions2, list, paramButton, str5, list2, inputType, autoGeneratedValue);
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
        if (!(obj instanceof CharParameter)) {
            return false;
        }
        CharParameter charParameter = (CharParameter) obj;
        return Intrinsics.areEqual(getId(), charParameter.getId()) && Intrinsics.areEqual(getTitle(), charParameter.getTitle()) && getRequired() == charParameter.getRequired() && getImmutable() == charParameter.getImmutable() && Intrinsics.areEqual(getMotivation(), charParameter.getMotivation()) && Intrinsics.areEqual(getUpdatesForm(), charParameter.getUpdatesForm()) && Intrinsics.areEqual(getHint(), charParameter.getHint()) && Intrinsics.areEqual(get_value(), charParameter.get_value()) && Intrinsics.areEqual(getDisplayingOptions(), charParameter.getDisplayingOptions()) && Intrinsics.areEqual(getConstraints(), charParameter.getConstraints()) && Intrinsics.areEqual(this.button, charParameter.button) && Intrinsics.areEqual(getPlaceholder(), charParameter.getPlaceholder()) && Intrinsics.areEqual(getTags(), charParameter.getTags()) && Intrinsics.areEqual(this._inputType, charParameter._inputType) && Intrinsics.areEqual(getAutogeneratedValue(), charParameter.getAutogeneratedValue());
    }

    @Override // com.avito.android.remote.model.category_parameters.WithAutogeneratedValue
    @Nullable
    public AutoGeneratedValue getAutogeneratedValue() {
        return this.autogeneratedValue;
    }

    @Nullable
    public final ParamButton getButton() {
        return this.button;
    }

    @Override // com.avito.android.remote.model.category_parameters.base.HasConstraints
    @Nullable
    public List<Constraint> getConstraints() {
        return this.constraints;
    }

    @Override // com.avito.android.remote.model.category_parameters.base.TextParameter
    @Nullable
    public DisplayingOptions getDisplayingOptions() {
        return this.displayingOptions;
    }

    @Override // com.avito.android.remote.model.category_parameters.base.TextParameter
    @Nullable
    public String getHint() {
        return this.hint;
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

    @NotNull
    public final InputType getInputType() {
        InputType inputType = this._inputType;
        return inputType != null ? inputType : InputType.TEXT;
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

    @Override // com.avito.android.remote.model.category_parameters.base.HasHtmlValueSupport
    @Nullable
    public String getRenderedHtmlValue() {
        return this.renderedHtmlValue;
    }

    @Override // com.avito.android.remote.model.category_parameters.base.BaseParameter
    public boolean getRequired() {
        return this.required;
    }

    @Override // com.avito.android.remote.model.category_parameters.base.HasTags
    @Nullable
    public List<TextualTag> getTags() {
        return this.tags;
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

    @Override // com.avito.android.remote.model.category_parameters.base.EditableParameter
    public boolean hasValue() {
        CharSequence charSequence = (CharSequence) getValue();
        return !(charSequence == null || charSequence.length() == 0);
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
        String hint2 = getHint();
        int hashCode5 = (hashCode4 + (hint2 != null ? hint2.hashCode() : 0)) * 31;
        String str = get_value();
        int hashCode6 = (hashCode5 + (str != null ? str.hashCode() : 0)) * 31;
        DisplayingOptions displayingOptions2 = getDisplayingOptions();
        int hashCode7 = (hashCode6 + (displayingOptions2 != null ? displayingOptions2.hashCode() : 0)) * 31;
        List<Constraint> constraints2 = getConstraints();
        int hashCode8 = (hashCode7 + (constraints2 != null ? constraints2.hashCode() : 0)) * 31;
        ParamButton paramButton = this.button;
        int hashCode9 = (hashCode8 + (paramButton != null ? paramButton.hashCode() : 0)) * 31;
        String placeholder2 = getPlaceholder();
        int hashCode10 = (hashCode9 + (placeholder2 != null ? placeholder2.hashCode() : 0)) * 31;
        List<TextualTag> tags2 = getTags();
        int hashCode11 = (hashCode10 + (tags2 != null ? tags2.hashCode() : 0)) * 31;
        InputType inputType = this._inputType;
        int hashCode12 = (hashCode11 + (inputType != null ? inputType.hashCode() : 0)) * 31;
        AutoGeneratedValue autogeneratedValue2 = getAutogeneratedValue();
        if (autogeneratedValue2 != null) {
            i = autogeneratedValue2.hashCode();
        }
        return hashCode12 + i;
    }

    @Override // com.avito.android.remote.model.category_parameters.base.HasHtmlValueSupport
    public void setRenderedHtmlValue(@Nullable String str) {
        this.renderedHtmlValue = str;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("CharParameter(id=");
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
        L.append(", hint=");
        L.append(getHint());
        L.append(", _value=");
        L.append(get_value());
        L.append(", displayingOptions=");
        L.append(getDisplayingOptions());
        L.append(", constraints=");
        L.append(getConstraints());
        L.append(", button=");
        L.append(this.button);
        L.append(", placeholder=");
        L.append(getPlaceholder());
        L.append(", tags=");
        L.append(getTags());
        L.append(", _inputType=");
        L.append(this._inputType);
        L.append(", autogeneratedValue=");
        L.append(getAutogeneratedValue());
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
        parcel.writeString(this.hint);
        parcel.writeString(this._value);
        DisplayingOptions displayingOptions2 = this.displayingOptions;
        if (displayingOptions2 != null) {
            parcel.writeInt(1);
            displayingOptions2.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        List<Constraint> list = this.constraints;
        if (list != null) {
            Iterator l0 = a.l0(parcel, 1, list);
            while (l0.hasNext()) {
                parcel.writeParcelable((Constraint) l0.next(), i);
            }
        } else {
            parcel.writeInt(0);
        }
        ParamButton paramButton = this.button;
        if (paramButton != null) {
            parcel.writeInt(1);
            paramButton.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.placeholder);
        List<TextualTag> list2 = this.tags;
        if (list2 != null) {
            Iterator l02 = a.l0(parcel, 1, list2);
            while (l02.hasNext()) {
                ((TextualTag) l02.next()).writeToParcel(parcel, 0);
            }
        } else {
            parcel.writeInt(0);
        }
        InputType inputType = this._inputType;
        if (inputType != null) {
            parcel.writeInt(1);
            parcel.writeString(inputType.name());
        } else {
            parcel.writeInt(0);
        }
        AutoGeneratedValue autoGeneratedValue = this.autogeneratedValue;
        if (autoGeneratedValue != null) {
            parcel.writeInt(1);
            autoGeneratedValue.writeToParcel(parcel, 0);
            return;
        }
        parcel.writeInt(0);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r14v0, resolved type: java.util.List<? extends com.avito.android.remote.model.category_parameters.Constraint> */
    /* JADX WARN: Multi-variable type inference failed */
    public CharParameter(@NotNull String str, @NotNull String str2, boolean z, boolean z2, @Nullable AttributedText attributedText, @Nullable Boolean bool, @Nullable String str3, @Nullable String str4, @Nullable DisplayingOptions displayingOptions2, @Nullable List<? extends Constraint> list, @Nullable ParamButton paramButton, @Nullable String str5, @Nullable List<TextualTag> list2, @Nullable InputType inputType, @Nullable AutoGeneratedValue autoGeneratedValue) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        this.id = str;
        this.title = str2;
        this.required = z;
        this.immutable = z2;
        this.motivation = attributedText;
        this.updatesForm = bool;
        this.hint = str3;
        this._value = str4;
        this.displayingOptions = displayingOptions2;
        this.constraints = list;
        this.button = paramButton;
        this.placeholder = str5;
        this.tags = list2;
        this._inputType = inputType;
        this.autogeneratedValue = autoGeneratedValue;
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
