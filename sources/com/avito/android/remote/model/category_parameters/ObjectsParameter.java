package com.avito.android.remote.model.category_parameters;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.category_parameters.base.EditableParameter;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import com.avito.android.remote.model.text.AttributedText;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongycastle.i18n.ErrorBundle;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u001f\b\b\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00020\u0001:\u0001RBy\u0012\u0006\u0010\u001c\u001a\u00020\u0007\u0012\u0006\u0010\u001d\u001a\u00020\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u0004\u0012\u0006\u0010\u001f\u001a\u00020\u0004\u0012\b\u0010 \u001a\u0004\u0018\u00010\r\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0013\u0012\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0016\b\u0002\u0010$\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\u0002\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\bP\u0010QJ\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\n\u0010\tJ\u0010\u0010\u000b\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0006J\u0010\u0010\f\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\f\u0010\u0006J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u001e\u0010\u0018\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0017J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0001\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u001c\u001a\u00020\u00072\b\b\u0002\u0010\u001d\u001a\u00020\u00072\b\b\u0002\u0010\u001e\u001a\u00020\u00042\b\b\u0002\u0010\u001f\u001a\u00020\u00042\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00132\u0010\b\u0002\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0016\b\u0002\u0010$\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\u00022\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0019HÆ\u0001¢\u0006\u0004\b&\u0010'J\u0010\u0010(\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b(\u0010\tJ\u0010\u0010*\u001a\u00020)HÖ\u0001¢\u0006\u0004\b*\u0010+J\u001a\u0010.\u001a\u00020\u00042\b\u0010-\u001a\u0004\u0018\u00010,HÖ\u0003¢\u0006\u0004\b.\u0010/J\u0010\u00100\u001a\u00020)HÖ\u0001¢\u0006\u0004\b0\u0010+J \u00105\u001a\u0002042\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u00020)HÖ\u0001¢\u0006\u0004\b5\u00106R\u001c\u0010\u001e\u001a\u00020\u00048\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u001e\u00107\u001a\u0004\b8\u0010\u0006R\u001e\u0010\"\u001a\u0004\u0018\u00010\u00138\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\"\u00109\u001a\u0004\b:\u0010\u0015R0\u0010$\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\u00028\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b$\u0010;\u001a\u0004\b<\u0010\u0017\"\u0004\b=\u0010>R$\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b#\u0010;\u001a\u0004\b?\u0010\u0017R\u001e\u0010 \u001a\u0004\u0018\u00010\r8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b \u0010@\u001a\u0004\bA\u0010\u000fR\u001e\u0010!\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b!\u0010B\u001a\u0004\bC\u0010\u0012R\u001c\u0010\u001f\u001a\u00020\u00048\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u001f\u00107\u001a\u0004\bD\u0010\u0006R$\u0010E\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u0004¢\u0006\u0012\n\u0004\bE\u0010F\u0012\u0004\bI\u0010J\u001a\u0004\bG\u0010HR\u001e\u0010%\u001a\u0004\u0018\u00010\u00198\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b%\u0010K\u001a\u0004\bL\u0010\u001bR\u001c\u0010\u001d\u001a\u00020\u00078\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u001d\u0010M\u001a\u0004\bN\u0010\tR\u001c\u0010\u001c\u001a\u00020\u00078\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u001c\u0010M\u001a\u0004\bO\u0010\t¨\u0006S"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/ObjectsParameter;", "Lcom/avito/android/remote/model/category_parameters/base/EditableParameter;", "", "Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;", "", "hasValue", "()Z", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "Lcom/avito/android/remote/model/text/AttributedText;", "component5", "()Lcom/avito/android/remote/model/text/AttributedText;", "Lcom/avito/android/remote/model/category_parameters/Restrictions;", "component6", "()Lcom/avito/android/remote/model/category_parameters/Restrictions;", "Lcom/avito/android/remote/model/category_parameters/ObjectsParameter$Summary;", "component7", "()Lcom/avito/android/remote/model/category_parameters/ObjectsParameter$Summary;", "component8", "()Ljava/util/List;", "component9", "Lcom/avito/android/remote/model/category_parameters/DisplayingOptions;", "component10", "()Lcom/avito/android/remote/model/category_parameters/DisplayingOptions;", "id", "title", "required", "immutable", "motivation", "restrictions", ErrorBundle.SUMMARY_ENTRY, "params", "_value", "displayingOptions", "copy", "(Ljava/lang/String;Ljava/lang/String;ZZLcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/model/category_parameters/Restrictions;Lcom/avito/android/remote/model/category_parameters/ObjectsParameter$Summary;Ljava/util/List;Ljava/util/List;Lcom/avito/android/remote/model/category_parameters/DisplayingOptions;)Lcom/avito/android/remote/model/category_parameters/ObjectsParameter;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Z", "getRequired", "Lcom/avito/android/remote/model/category_parameters/ObjectsParameter$Summary;", "getSummary", "Ljava/util/List;", "get_value", "set_value", "(Ljava/util/List;)V", "getParams", "Lcom/avito/android/remote/model/text/AttributedText;", "getMotivation", "Lcom/avito/android/remote/model/category_parameters/Restrictions;", "getRestrictions", "getImmutable", "updatesForm", "Ljava/lang/Boolean;", "getUpdatesForm", "()Ljava/lang/Boolean;", "getUpdatesForm$annotations", "()V", "Lcom/avito/android/remote/model/category_parameters/DisplayingOptions;", "getDisplayingOptions", "Ljava/lang/String;", "getTitle", "getId", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZZLcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/model/category_parameters/Restrictions;Lcom/avito/android/remote/model/category_parameters/ObjectsParameter$Summary;Ljava/util/List;Ljava/util/List;Lcom/avito/android/remote/model/category_parameters/DisplayingOptions;)V", "Summary", "models_release"}, k = 1, mv = {1, 4, 2})
public final class ObjectsParameter extends EditableParameter<List<? extends List<? extends ParameterSlot>>> {
    public static final Parcelable.Creator<ObjectsParameter> CREATOR = new Creator();
    @SerializedName("value")
    @Nullable
    private List<? extends List<? extends ParameterSlot>> _value;
    @SerializedName("displaying")
    @Nullable
    private final DisplayingOptions displayingOptions;
    @SerializedName("id")
    @NotNull
    private final String id;
    @SerializedName("immutable")
    private final boolean immutable;
    @SerializedName("motivation")
    @Nullable
    private final AttributedText motivation;
    @SerializedName("params")
    @Nullable
    private final List<ParameterSlot> params;
    @SerializedName("required")
    private final boolean required;
    @SerializedName("restrictions")
    @Nullable
    private final Restrictions restrictions;
    @SerializedName(ErrorBundle.SUMMARY_ENTRY)
    @Nullable
    private final Summary summary;
    @SerializedName("title")
    @NotNull
    private final String title;
    @Nullable
    private final Boolean updatesForm;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<ObjectsParameter> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ObjectsParameter createFromParcel(@NotNull Parcel parcel) {
            ArrayList arrayList;
            ArrayList arrayList2;
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            boolean z = false;
            boolean z2 = parcel.readInt() != 0;
            if (parcel.readInt() != 0) {
                z = true;
            }
            AttributedText attributedText = (AttributedText) parcel.readParcelable(ObjectsParameter.class.getClassLoader());
            Restrictions restrictions = (Restrictions) parcel.readParcelable(ObjectsParameter.class.getClassLoader());
            Summary createFromParcel = parcel.readInt() != 0 ? Summary.CREATOR.createFromParcel(parcel) : null;
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add((ParameterSlot) parcel.readParcelable(ObjectsParameter.class.getClassLoader()));
                    readInt--;
                }
            } else {
                arrayList = null;
            }
            if (parcel.readInt() != 0) {
                int readInt2 = parcel.readInt();
                arrayList2 = new ArrayList(readInt2);
                while (readInt2 != 0) {
                    int readInt3 = parcel.readInt();
                    ArrayList arrayList3 = new ArrayList(readInt3);
                    while (readInt3 != 0) {
                        arrayList3.add((ParameterSlot) parcel.readParcelable(ObjectsParameter.class.getClassLoader()));
                        readInt3--;
                    }
                    arrayList2.add(arrayList3);
                    readInt2--;
                }
            } else {
                arrayList2 = null;
            }
            return new ObjectsParameter(readString, readString2, z2, z, attributedText, restrictions, createFromParcel, arrayList, arrayList2, parcel.readInt() != 0 ? DisplayingOptions.CREATOR.createFromParcel(parcel) : null);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ObjectsParameter[] newArray(int i) {
            return new ObjectsParameter[i];
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u001f\u0010 J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0005J0\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u000fJ \u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\"\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0005R\"\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001c\u001a\u0004\b\u001e\u0010\u0005¨\u0006!"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/ObjectsParameter$Summary;", "Landroid/os/Parcelable;", "", "", "component1", "()Ljava/util/List;", "component2", "titles", "subtitles", "copy", "(Ljava/util/List;Ljava/util/List;)Lcom/avito/android/remote/model/category_parameters/ObjectsParameter$Summary;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/util/List;", "getSubtitles", "getTitles", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Summary implements Parcelable {
        public static final Parcelable.Creator<Summary> CREATOR = new Creator();
        @SerializedName("subtitles")
        @NotNull
        private final List<String> subtitles;
        @SerializedName("titles")
        @NotNull
        private final List<String> titles;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Summary> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Summary createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Summary(parcel.createStringArrayList(), parcel.createStringArrayList());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Summary[] newArray(int i) {
                return new Summary[i];
            }
        }

        public Summary(@NotNull List<String> list, @NotNull List<String> list2) {
            Intrinsics.checkNotNullParameter(list, "titles");
            Intrinsics.checkNotNullParameter(list2, "subtitles");
            this.titles = list;
            this.subtitles = list2;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.remote.model.category_parameters.ObjectsParameter$Summary */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Summary copy$default(Summary summary, List list, List list2, int i, Object obj) {
            if ((i & 1) != 0) {
                list = summary.titles;
            }
            if ((i & 2) != 0) {
                list2 = summary.subtitles;
            }
            return summary.copy(list, list2);
        }

        @NotNull
        public final List<String> component1() {
            return this.titles;
        }

        @NotNull
        public final List<String> component2() {
            return this.subtitles;
        }

        @NotNull
        public final Summary copy(@NotNull List<String> list, @NotNull List<String> list2) {
            Intrinsics.checkNotNullParameter(list, "titles");
            Intrinsics.checkNotNullParameter(list2, "subtitles");
            return new Summary(list, list2);
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
            if (!(obj instanceof Summary)) {
                return false;
            }
            Summary summary = (Summary) obj;
            return Intrinsics.areEqual(this.titles, summary.titles) && Intrinsics.areEqual(this.subtitles, summary.subtitles);
        }

        @NotNull
        public final List<String> getSubtitles() {
            return this.subtitles;
        }

        @NotNull
        public final List<String> getTitles() {
            return this.titles;
        }

        @Override // java.lang.Object
        public int hashCode() {
            List<String> list = this.titles;
            int i = 0;
            int hashCode = (list != null ? list.hashCode() : 0) * 31;
            List<String> list2 = this.subtitles;
            if (list2 != null) {
                i = list2.hashCode();
            }
            return hashCode + i;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("Summary(titles=");
            L.append(this.titles);
            L.append(", subtitles=");
            return a.w(L, this.subtitles, ")");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeStringList(this.titles);
            parcel.writeStringList(this.subtitles);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ObjectsParameter(String str, String str2, boolean z, boolean z2, AttributedText attributedText, Restrictions restrictions2, Summary summary2, List list, List list2, DisplayingOptions displayingOptions2, int i, j jVar) {
        this(str, str2, z, z2, attributedText, restrictions2, summary2, list, (i & 256) != 0 ? null : list2, (i & 512) != 0 ? null : displayingOptions2);
    }

    public static /* synthetic */ ObjectsParameter copy$default(ObjectsParameter objectsParameter, String str, String str2, boolean z, boolean z2, AttributedText attributedText, Restrictions restrictions2, Summary summary2, List list, List list2, DisplayingOptions displayingOptions2, int i, Object obj) {
        return objectsParameter.copy((i & 1) != 0 ? objectsParameter.getId() : str, (i & 2) != 0 ? objectsParameter.getTitle() : str2, (i & 4) != 0 ? objectsParameter.getRequired() : z, (i & 8) != 0 ? objectsParameter.getImmutable() : z2, (i & 16) != 0 ? objectsParameter.getMotivation() : attributedText, (i & 32) != 0 ? objectsParameter.restrictions : restrictions2, (i & 64) != 0 ? objectsParameter.summary : summary2, (i & 128) != 0 ? objectsParameter.params : list, (i & 256) != 0 ? objectsParameter.get_value() : list2, (i & 512) != 0 ? objectsParameter.displayingOptions : displayingOptions2);
    }

    public static /* synthetic */ void getUpdatesForm$annotations() {
    }

    @NotNull
    public final String component1() {
        return getId();
    }

    @Nullable
    public final DisplayingOptions component10() {
        return this.displayingOptions;
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
    public final Restrictions component6() {
        return this.restrictions;
    }

    @Nullable
    public final Summary component7() {
        return this.summary;
    }

    @Nullable
    public final List<ParameterSlot> component8() {
        return this.params;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.util.List<? extends java.util.List<? extends com.avito.android.remote.model.category_parameters.base.ParameterSlot>>, java.util.List<java.util.List<com.avito.android.remote.model.category_parameters.base.ParameterSlot>> */
    @Nullable
    public final List<List<ParameterSlot>> component9() {
        return get_value();
    }

    @NotNull
    public final ObjectsParameter copy(@NotNull String str, @NotNull String str2, boolean z, boolean z2, @Nullable AttributedText attributedText, @Nullable Restrictions restrictions2, @Nullable Summary summary2, @Nullable List<? extends ParameterSlot> list, @Nullable List<? extends List<? extends ParameterSlot>> list2, @Nullable DisplayingOptions displayingOptions2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        return new ObjectsParameter(str, str2, z, z2, attributedText, restrictions2, summary2, list, list2, displayingOptions2);
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
        if (!(obj instanceof ObjectsParameter)) {
            return false;
        }
        ObjectsParameter objectsParameter = (ObjectsParameter) obj;
        return Intrinsics.areEqual(getId(), objectsParameter.getId()) && Intrinsics.areEqual(getTitle(), objectsParameter.getTitle()) && getRequired() == objectsParameter.getRequired() && getImmutable() == objectsParameter.getImmutable() && Intrinsics.areEqual(getMotivation(), objectsParameter.getMotivation()) && Intrinsics.areEqual(this.restrictions, objectsParameter.restrictions) && Intrinsics.areEqual(this.summary, objectsParameter.summary) && Intrinsics.areEqual(this.params, objectsParameter.params) && Intrinsics.areEqual(get_value(), objectsParameter.get_value()) && Intrinsics.areEqual(this.displayingOptions, objectsParameter.displayingOptions);
    }

    @Nullable
    public final DisplayingOptions getDisplayingOptions() {
        return this.displayingOptions;
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
    public final List<ParameterSlot> getParams() {
        return this.params;
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
    public final Summary getSummary() {
        return this.summary;
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
        Collection collection = (Collection) getValue();
        return !(collection == null || collection.isEmpty());
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
        Restrictions restrictions2 = this.restrictions;
        int hashCode4 = (hashCode3 + (restrictions2 != null ? restrictions2.hashCode() : 0)) * 31;
        Summary summary2 = this.summary;
        int hashCode5 = (hashCode4 + (summary2 != null ? summary2.hashCode() : 0)) * 31;
        List<ParameterSlot> list = this.params;
        int hashCode6 = (hashCode5 + (list != null ? list.hashCode() : 0)) * 31;
        List<? extends List<? extends ParameterSlot>> list2 = get_value();
        int hashCode7 = (hashCode6 + (list2 != null ? list2.hashCode() : 0)) * 31;
        DisplayingOptions displayingOptions2 = this.displayingOptions;
        if (displayingOptions2 != null) {
            i = displayingOptions2.hashCode();
        }
        return hashCode7 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("ObjectsParameter(id=");
        L.append(getId());
        L.append(", title=");
        L.append(getTitle());
        L.append(", required=");
        L.append(getRequired());
        L.append(", immutable=");
        L.append(getImmutable());
        L.append(", motivation=");
        L.append(getMotivation());
        L.append(", restrictions=");
        L.append(this.restrictions);
        L.append(", summary=");
        L.append(this.summary);
        L.append(", params=");
        L.append(this.params);
        L.append(", _value=");
        L.append(get_value());
        L.append(", displayingOptions=");
        L.append(this.displayingOptions);
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
        parcel.writeParcelable(this.restrictions, i);
        Summary summary2 = this.summary;
        if (summary2 != null) {
            parcel.writeInt(1);
            summary2.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        List<ParameterSlot> list = this.params;
        if (list != null) {
            Iterator l0 = a.l0(parcel, 1, list);
            while (l0.hasNext()) {
                parcel.writeParcelable((ParameterSlot) l0.next(), i);
            }
        } else {
            parcel.writeInt(0);
        }
        List<? extends List<? extends ParameterSlot>> list2 = this._value;
        if (list2 != null) {
            Iterator l02 = a.l0(parcel, 1, list2);
            while (l02.hasNext()) {
                Iterator n0 = a.n0((List) l02.next(), parcel);
                while (n0.hasNext()) {
                    parcel.writeParcelable((ParameterSlot) n0.next(), i);
                }
            }
        } else {
            parcel.writeInt(0);
        }
        DisplayingOptions displayingOptions2 = this.displayingOptions;
        if (displayingOptions2 != null) {
            parcel.writeInt(1);
            displayingOptions2.writeToParcel(parcel, 0);
            return;
        }
        parcel.writeInt(0);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: java.util.List<? extends com.avito.android.remote.model.category_parameters.base.ParameterSlot> */
    /* JADX WARN: Multi-variable type inference failed */
    public ObjectsParameter(@NotNull String str, @NotNull String str2, boolean z, boolean z2, @Nullable AttributedText attributedText, @Nullable Restrictions restrictions2, @Nullable Summary summary2, @Nullable List<? extends ParameterSlot> list, @Nullable List<? extends List<? extends ParameterSlot>> list2, @Nullable DisplayingOptions displayingOptions2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        this.id = str;
        this.title = str2;
        this.required = z;
        this.immutable = z2;
        this.motivation = attributedText;
        this.restrictions = restrictions2;
        this.summary = summary2;
        this.params = list;
        this._value = list2;
        this.displayingOptions = displayingOptions2;
    }

    /* Return type fixed from 'java.util.List<java.util.List<com.avito.android.remote.model.category_parameters.base.ParameterSlot>>' to match base method */
    @Override // com.avito.android.remote.model.category_parameters.base.EditableParameter
    @Nullable
    public List<? extends List<? extends ParameterSlot>> get_value() {
        return this._value;
    }

    public void set_value(@Nullable List<? extends List<? extends ParameterSlot>> list) {
        this._value = list;
    }
}
