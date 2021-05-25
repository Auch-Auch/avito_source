package com.avito.android.remote.model.category_parameters;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.advert_core.analytics.contactbar.PhonePageSourceKt;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.remote.model.category_parameters.base.EditableParameter;
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
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u001a\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B}\u0012\u0006\u0010\u001e\u001a\u00020\u0002\u0012\u0006\u0010\u001f\u001a\u00020\u0002\u0012\u0006\u0010 \u001a\u00020\u0004\u0012\u0006\u0010!\u001a\u00020\u0004\u0012\b\u0010\"\u001a\u0004\u0018\u00010\f\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010&\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010)\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\bP\u0010QJ\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ\u0010\u0010\n\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\n\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0006J\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\bJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\bJ\u0018\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\bJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0001\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u001e\u001a\u00020\u00022\b\b\u0002\u0010\u001f\u001a\u00020\u00022\b\b\u0002\u0010 \u001a\u00020\u00042\b\b\u0002\u0010!\u001a\u00020\u00042\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00162\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u001bHÆ\u0001¢\u0006\u0004\b*\u0010+J\u0010\u0010,\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b,\u0010\bJ\u0010\u0010.\u001a\u00020-HÖ\u0001¢\u0006\u0004\b.\u0010/J\u001a\u00102\u001a\u00020\u00042\b\u00101\u001a\u0004\u0018\u000100HÖ\u0003¢\u0006\u0004\b2\u00103J\u0010\u00104\u001a\u00020-HÖ\u0001¢\u0006\u0004\b4\u0010/J \u00109\u001a\u0002082\u0006\u00106\u001a\u0002052\u0006\u00107\u001a\u00020-HÖ\u0001¢\u0006\u0004\b9\u0010:R$\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00168\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b'\u0010;\u001a\u0004\b<\u0010\u0019R\u001c\u0010 \u001a\u00020\u00048\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b \u0010=\u001a\u0004\b>\u0010\u0006R\u001c\u0010\u001e\u001a\u00020\u00028\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u001e\u0010?\u001a\u0004\b@\u0010\bR\u001e\u0010&\u001a\u0004\u0018\u00010\u00028\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b&\u0010?\u001a\u0004\bA\u0010\bR$\u0010(\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b(\u0010?\u001a\u0004\bB\u0010\b\"\u0004\bC\u0010DR\u001e\u0010%\u001a\u0004\u0018\u00010\u00048\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b%\u0010E\u001a\u0004\bF\u0010\u0014R\u001c\u0010\u001f\u001a\u00020\u00028\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u001f\u0010?\u001a\u0004\bG\u0010\bR\u001e\u0010\"\u001a\u0004\u0018\u00010\f8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\"\u0010H\u001a\u0004\bI\u0010\u000eR\u001e\u0010#\u001a\u0004\u0018\u00010\u00028\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b#\u0010?\u001a\u0004\bJ\u0010\bR\u001e\u0010$\u001a\u0004\u0018\u00010\u00108\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b$\u0010K\u001a\u0004\bL\u0010\u0012R\u001c\u0010!\u001a\u00020\u00048\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b!\u0010=\u001a\u0004\bM\u0010\u0006R\u001e\u0010)\u001a\u0004\u0018\u00010\u001b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b)\u0010N\u001a\u0004\bO\u0010\u001d¨\u0006R"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/VideoParameter;", "Lcom/avito/android/remote/model/category_parameters/base/EditableParameter;", "", "Lcom/avito/android/remote/model/category_parameters/base/TextParameter;", "", "hasValue", "()Z", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "Lcom/avito/android/remote/model/text/AttributedText;", "component5", "()Lcom/avito/android/remote/model/text/AttributedText;", "component6", "Lcom/avito/android/remote/model/category_parameters/DisplayingOptions;", "component7", "()Lcom/avito/android/remote/model/category_parameters/DisplayingOptions;", "component8", "()Ljava/lang/Boolean;", "component9", "", "Lcom/avito/android/remote/model/category_parameters/Constraint;", "component10", "()Ljava/util/List;", "component11", "Lcom/avito/android/remote/model/category_parameters/ParamButton;", "component12", "()Lcom/avito/android/remote/model/category_parameters/ParamButton;", "id", "title", "required", "immutable", "motivation", "hint", "displayingOptions", "updatesForm", InternalConstsKt.PLACEHOLDER, "constraints", "_value", PhonePageSourceKt.PHONE_SOURCE_BUTTON, "copy", "(Ljava/lang/String;Ljava/lang/String;ZZLcom/avito/android/remote/model/text/AttributedText;Ljava/lang/String;Lcom/avito/android/remote/model/category_parameters/DisplayingOptions;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/avito/android/remote/model/category_parameters/ParamButton;)Lcom/avito/android/remote/model/category_parameters/VideoParameter;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/util/List;", "getConstraints", "Z", "getRequired", "Ljava/lang/String;", "getId", "getPlaceholder", "get_value", "set_value", "(Ljava/lang/String;)V", "Ljava/lang/Boolean;", "getUpdatesForm", "getTitle", "Lcom/avito/android/remote/model/text/AttributedText;", "getMotivation", "getHint", "Lcom/avito/android/remote/model/category_parameters/DisplayingOptions;", "getDisplayingOptions", "getImmutable", "Lcom/avito/android/remote/model/category_parameters/ParamButton;", "getButton", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZZLcom/avito/android/remote/model/text/AttributedText;Ljava/lang/String;Lcom/avito/android/remote/model/category_parameters/DisplayingOptions;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/avito/android/remote/model/category_parameters/ParamButton;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class VideoParameter extends EditableParameter<String> implements TextParameter {
    public static final Parcelable.Creator<VideoParameter> CREATOR = new Creator();
    @SerializedName("value")
    @Nullable
    private String _value;
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
    @SerializedName("required")
    private final boolean required;
    @SerializedName("title")
    @NotNull
    private final String title;
    @SerializedName("updatesForm")
    @Nullable
    private final Boolean updatesForm;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<VideoParameter> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final VideoParameter createFromParcel(@NotNull Parcel parcel) {
            Boolean bool;
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            boolean z = true;
            boolean z2 = parcel.readInt() != 0;
            boolean z3 = parcel.readInt() != 0;
            AttributedText attributedText = (AttributedText) parcel.readParcelable(VideoParameter.class.getClassLoader());
            String readString3 = parcel.readString();
            DisplayingOptions createFromParcel = parcel.readInt() != 0 ? DisplayingOptions.CREATOR.createFromParcel(parcel) : null;
            if (parcel.readInt() != 0) {
                if (parcel.readInt() == 0) {
                    z = false;
                }
                bool = Boolean.valueOf(z);
            } else {
                bool = null;
            }
            String readString4 = parcel.readString();
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList2.add((Constraint) parcel.readParcelable(VideoParameter.class.getClassLoader()));
                    readInt--;
                }
                arrayList = arrayList2;
            } else {
                arrayList = null;
            }
            return new VideoParameter(readString, readString2, z2, z3, attributedText, readString3, createFromParcel, bool, readString4, arrayList, parcel.readString(), parcel.readInt() != 0 ? ParamButton.CREATOR.createFromParcel(parcel) : null);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final VideoParameter[] newArray(int i) {
            return new VideoParameter[i];
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r11v0, resolved type: java.util.List<? extends com.avito.android.remote.model.category_parameters.Constraint> */
    /* JADX WARN: Multi-variable type inference failed */
    public VideoParameter(@NotNull String str, @NotNull String str2, boolean z, boolean z2, @Nullable AttributedText attributedText, @Nullable String str3, @Nullable DisplayingOptions displayingOptions2, @Nullable Boolean bool, @Nullable String str4, @Nullable List<? extends Constraint> list, @Nullable String str5, @Nullable ParamButton paramButton) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        this.id = str;
        this.title = str2;
        this.required = z;
        this.immutable = z2;
        this.motivation = attributedText;
        this.hint = str3;
        this.displayingOptions = displayingOptions2;
        this.updatesForm = bool;
        this.placeholder = str4;
        this.constraints = list;
        this._value = str5;
        this.button = paramButton;
    }

    public static /* synthetic */ VideoParameter copy$default(VideoParameter videoParameter, String str, String str2, boolean z, boolean z2, AttributedText attributedText, String str3, DisplayingOptions displayingOptions2, Boolean bool, String str4, List list, String str5, ParamButton paramButton, int i, Object obj) {
        return videoParameter.copy((i & 1) != 0 ? videoParameter.getId() : str, (i & 2) != 0 ? videoParameter.getTitle() : str2, (i & 4) != 0 ? videoParameter.getRequired() : z, (i & 8) != 0 ? videoParameter.getImmutable() : z2, (i & 16) != 0 ? videoParameter.getMotivation() : attributedText, (i & 32) != 0 ? videoParameter.getHint() : str3, (i & 64) != 0 ? videoParameter.getDisplayingOptions() : displayingOptions2, (i & 128) != 0 ? videoParameter.getUpdatesForm() : bool, (i & 256) != 0 ? videoParameter.getPlaceholder() : str4, (i & 512) != 0 ? videoParameter.getConstraints() : list, (i & 1024) != 0 ? videoParameter.get_value() : str5, (i & 2048) != 0 ? videoParameter.button : paramButton);
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
    public final String component11() {
        return get_value();
    }

    @Nullable
    public final ParamButton component12() {
        return this.button;
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
    public final String component6() {
        return getHint();
    }

    @Nullable
    public final DisplayingOptions component7() {
        return getDisplayingOptions();
    }

    @Nullable
    public final Boolean component8() {
        return getUpdatesForm();
    }

    @Nullable
    public final String component9() {
        return getPlaceholder();
    }

    @NotNull
    public final VideoParameter copy(@NotNull String str, @NotNull String str2, boolean z, boolean z2, @Nullable AttributedText attributedText, @Nullable String str3, @Nullable DisplayingOptions displayingOptions2, @Nullable Boolean bool, @Nullable String str4, @Nullable List<? extends Constraint> list, @Nullable String str5, @Nullable ParamButton paramButton) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        return new VideoParameter(str, str2, z, z2, attributedText, str3, displayingOptions2, bool, str4, list, str5, paramButton);
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
        if (!(obj instanceof VideoParameter)) {
            return false;
        }
        VideoParameter videoParameter = (VideoParameter) obj;
        return Intrinsics.areEqual(getId(), videoParameter.getId()) && Intrinsics.areEqual(getTitle(), videoParameter.getTitle()) && getRequired() == videoParameter.getRequired() && getImmutable() == videoParameter.getImmutable() && Intrinsics.areEqual(getMotivation(), videoParameter.getMotivation()) && Intrinsics.areEqual(getHint(), videoParameter.getHint()) && Intrinsics.areEqual(getDisplayingOptions(), videoParameter.getDisplayingOptions()) && Intrinsics.areEqual(getUpdatesForm(), videoParameter.getUpdatesForm()) && Intrinsics.areEqual(getPlaceholder(), videoParameter.getPlaceholder()) && Intrinsics.areEqual(getConstraints(), videoParameter.getConstraints()) && Intrinsics.areEqual(get_value(), videoParameter.get_value()) && Intrinsics.areEqual(this.button, videoParameter.button);
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
        String hint2 = getHint();
        int hashCode4 = (hashCode3 + (hint2 != null ? hint2.hashCode() : 0)) * 31;
        DisplayingOptions displayingOptions2 = getDisplayingOptions();
        int hashCode5 = (hashCode4 + (displayingOptions2 != null ? displayingOptions2.hashCode() : 0)) * 31;
        Boolean updatesForm2 = getUpdatesForm();
        int hashCode6 = (hashCode5 + (updatesForm2 != null ? updatesForm2.hashCode() : 0)) * 31;
        String placeholder2 = getPlaceholder();
        int hashCode7 = (hashCode6 + (placeholder2 != null ? placeholder2.hashCode() : 0)) * 31;
        List<Constraint> constraints2 = getConstraints();
        int hashCode8 = (hashCode7 + (constraints2 != null ? constraints2.hashCode() : 0)) * 31;
        String str = get_value();
        int hashCode9 = (hashCode8 + (str != null ? str.hashCode() : 0)) * 31;
        ParamButton paramButton = this.button;
        if (paramButton != null) {
            i = paramButton.hashCode();
        }
        return hashCode9 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("VideoParameter(id=");
        L.append(getId());
        L.append(", title=");
        L.append(getTitle());
        L.append(", required=");
        L.append(getRequired());
        L.append(", immutable=");
        L.append(getImmutable());
        L.append(", motivation=");
        L.append(getMotivation());
        L.append(", hint=");
        L.append(getHint());
        L.append(", displayingOptions=");
        L.append(getDisplayingOptions());
        L.append(", updatesForm=");
        L.append(getUpdatesForm());
        L.append(", placeholder=");
        L.append(getPlaceholder());
        L.append(", constraints=");
        L.append(getConstraints());
        L.append(", _value=");
        L.append(get_value());
        L.append(", button=");
        L.append(this.button);
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
        parcel.writeString(this.hint);
        DisplayingOptions displayingOptions2 = this.displayingOptions;
        if (displayingOptions2 != null) {
            parcel.writeInt(1);
            displayingOptions2.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        Boolean bool = this.updatesForm;
        if (bool != null) {
            a.G0(parcel, 1, bool);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.placeholder);
        List<Constraint> list = this.constraints;
        if (list != null) {
            Iterator l0 = a.l0(parcel, 1, list);
            while (l0.hasNext()) {
                parcel.writeParcelable((Constraint) l0.next(), i);
            }
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this._value);
        ParamButton paramButton = this.button;
        if (paramButton != null) {
            parcel.writeInt(1);
            paramButton.writeToParcel(parcel, 0);
            return;
        }
        parcel.writeInt(0);
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
