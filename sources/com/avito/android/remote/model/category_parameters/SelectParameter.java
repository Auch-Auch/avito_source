package com.avito.android.remote.model.category_parameters;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.publish.residential_complex_search.di.ResidentialComplexModuleKt;
import com.avito.android.remote.model.Color;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.ParcelableEntity;
import com.avito.android.remote.model.category_parameters.base.CanHaveTypeCorrection;
import com.avito.android.remote.model.category_parameters.base.EditableParameter;
import com.avito.android.remote.model.category_parameters.base.HasPlaceholder;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import com.avito.android.remote.model.text.AttributedText;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0005 !\"#$B\t\b\u0002¢\u0006\u0004\b\u001f\u0010\u000bJ\u0011\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\b\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\b\u0010\u0007J\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00108&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00170\u00168&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d\u0001\u0002%&¨\u0006'"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/SelectParameter;", "Lcom/avito/android/remote/model/category_parameters/base/EditableParameter;", "", "Lcom/avito/android/remote/model/category_parameters/base/HasPlaceholder;", "Lcom/avito/android/remote/model/category_parameters/base/CanHaveTypeCorrection;", "Lcom/avito/android/remote/model/category_parameters/SelectParameter$Value;", "getSelectedValue", "()Lcom/avito/android/remote/model/category_parameters/SelectParameter$Value;", "getChosenOrCurrentSelectedValue", "", "applyChosenValue", "()V", "", "getTypoCorrectionEnabled", "()Ljava/lang/Boolean;", "typoCorrectionEnabled", "Lcom/avito/android/remote/model/category_parameters/SelectParameter$UserChosenValue;", "getChosenValue", "()Lcom/avito/android/remote/model/category_parameters/SelectParameter$UserChosenValue;", "setChosenValue", "(Lcom/avito/android/remote/model/category_parameters/SelectParameter$UserChosenValue;)V", "chosenValue", "", "Lcom/avito/android/remote/model/ParcelableEntity;", "getListToShow", "()Ljava/util/List;", "listToShow", "Lcom/avito/android/remote/model/category_parameters/SelectParameter$Displaying;", "getDisplaying", "()Lcom/avito/android/remote/model/category_parameters/SelectParameter$Displaying;", "displaying", "<init>", "Displaying", "Flat", "Sectioned", "UserChosenValue", "Value", "Lcom/avito/android/remote/model/category_parameters/SelectParameter$Flat;", "Lcom/avito/android/remote/model/category_parameters/SelectParameter$Sectioned;", "models_release"}, k = 1, mv = {1, 4, 2})
public abstract class SelectParameter extends EditableParameter<String> implements HasPlaceholder, CanHaveTypeCorrection {

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\b\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b0\u00101J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\n\u0010\u0007J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJT\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0004J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001d\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u001f\u0010\u001aJ \u0010$\u001a\u00020#2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b$\u0010%R\u001c\u0010\u0011\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010&\u001a\u0004\b'\u0010\tR\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010(\u001a\u0004\b)\u0010\u0007R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010*\u001a\u0004\b+\u0010\u000eR\u001c\u0010\u000f\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010,\u001a\u0004\b-\u0010\u0004R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010,\u001a\u0004\b.\u0010\u0004R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010(\u001a\u0004\b/\u0010\u0007¨\u00062"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/SelectParameter$Displaying;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/lang/Boolean;", "component3", "()Z", "component4", "component5", "Lcom/avito/android/remote/model/category_parameters/SortDirection;", "component6", "()Lcom/avito/android/remote/model/category_parameters/SortDirection;", "type", "typoCorrectionEnabled", "hideTitle", "withImages", "titlePattern", "sortDirection", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;ZLjava/lang/Boolean;Ljava/lang/String;Lcom/avito/android/remote/model/category_parameters/SortDirection;)Lcom/avito/android/remote/model/category_parameters/SelectParameter$Displaying;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Z", "getHideTitle", "Ljava/lang/Boolean;", "getWithImages", "Lcom/avito/android/remote/model/category_parameters/SortDirection;", "getSortDirection", "Ljava/lang/String;", "getType", "getTitlePattern", "getTypoCorrectionEnabled", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;ZLjava/lang/Boolean;Ljava/lang/String;Lcom/avito/android/remote/model/category_parameters/SortDirection;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Displaying implements Parcelable {
        public static final Parcelable.Creator<Displaying> CREATOR = new Creator();
        @SerializedName("hideTitle")
        private final boolean hideTitle;
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
                Intrinsics.checkNotNullParameter(parcel, "in");
                String readString = parcel.readString();
                boolean z = true;
                if (parcel.readInt() != 0) {
                    bool = Boolean.valueOf(parcel.readInt() != 0);
                } else {
                    bool = null;
                }
                boolean z2 = parcel.readInt() != 0;
                if (parcel.readInt() != 0) {
                    if (parcel.readInt() == 0) {
                        z = false;
                    }
                    bool2 = Boolean.valueOf(z);
                } else {
                    bool2 = null;
                }
                return new Displaying(readString, bool, z2, bool2, parcel.readString(), parcel.readInt() != 0 ? (SortDirection) Enum.valueOf(SortDirection.class, parcel.readString()) : null);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Displaying[] newArray(int i) {
                return new Displaying[i];
            }
        }

        public Displaying(@NotNull String str, @Nullable Boolean bool, boolean z, @Nullable Boolean bool2, @Nullable String str2, @Nullable SortDirection sortDirection2) {
            Intrinsics.checkNotNullParameter(str, "type");
            this.type = str;
            this.typoCorrectionEnabled = bool;
            this.hideTitle = z;
            this.withImages = bool2;
            this.titlePattern = str2;
            this.sortDirection = sortDirection2;
        }

        public static /* synthetic */ Displaying copy$default(Displaying displaying, String str, Boolean bool, boolean z, Boolean bool2, String str2, SortDirection sortDirection2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = displaying.type;
            }
            if ((i & 2) != 0) {
                bool = displaying.typoCorrectionEnabled;
            }
            if ((i & 4) != 0) {
                z = displaying.hideTitle;
            }
            if ((i & 8) != 0) {
                bool2 = displaying.withImages;
            }
            if ((i & 16) != 0) {
                str2 = displaying.titlePattern;
            }
            if ((i & 32) != 0) {
                sortDirection2 = displaying.sortDirection;
            }
            return displaying.copy(str, bool, z, bool2, str2, sortDirection2);
        }

        @NotNull
        public final String component1() {
            return this.type;
        }

        @Nullable
        public final Boolean component2() {
            return this.typoCorrectionEnabled;
        }

        public final boolean component3() {
            return this.hideTitle;
        }

        @Nullable
        public final Boolean component4() {
            return this.withImages;
        }

        @Nullable
        public final String component5() {
            return this.titlePattern;
        }

        @Nullable
        public final SortDirection component6() {
            return this.sortDirection;
        }

        @NotNull
        public final Displaying copy(@NotNull String str, @Nullable Boolean bool, boolean z, @Nullable Boolean bool2, @Nullable String str2, @Nullable SortDirection sortDirection2) {
            Intrinsics.checkNotNullParameter(str, "type");
            return new Displaying(str, bool, z, bool2, str2, sortDirection2);
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
            return Intrinsics.areEqual(this.type, displaying.type) && Intrinsics.areEqual(this.typoCorrectionEnabled, displaying.typoCorrectionEnabled) && this.hideTitle == displaying.hideTitle && Intrinsics.areEqual(this.withImages, displaying.withImages) && Intrinsics.areEqual(this.titlePattern, displaying.titlePattern) && Intrinsics.areEqual(this.sortDirection, displaying.sortDirection);
        }

        public final boolean getHideTitle() {
            return this.hideTitle;
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
            boolean z = this.hideTitle;
            if (z) {
                z = true;
            }
            int i2 = z ? 1 : 0;
            int i3 = z ? 1 : 0;
            int i4 = z ? 1 : 0;
            int i5 = (hashCode2 + i2) * 31;
            Boolean bool2 = this.withImages;
            int hashCode3 = (i5 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
            String str2 = this.titlePattern;
            int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
            SortDirection sortDirection2 = this.sortDirection;
            if (sortDirection2 != null) {
                i = sortDirection2.hashCode();
            }
            return hashCode4 + i;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("Displaying(type=");
            L.append(this.type);
            L.append(", typoCorrectionEnabled=");
            L.append(this.typoCorrectionEnabled);
            L.append(", hideTitle=");
            L.append(this.hideTitle);
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
            parcel.writeInt(this.hideTitle ? 1 : 0);
            Boolean bool2 = this.withImages;
            if (bool2 != null) {
                a.G0(parcel, 1, bool2);
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
        public /* synthetic */ Displaying(String str, Boolean bool, boolean z, Boolean bool2, String str2, SortDirection sortDirection2, int i, j jVar) {
            this(str, (i & 2) != 0 ? Boolean.FALSE : bool, (i & 4) != 0 ? false : z, (i & 8) != 0 ? Boolean.FALSE : bool2, (i & 16) != 0 ? null : str2, (i & 32) != 0 ? null : sortDirection2);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b!\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\u0006\u0010\"\u001a\u00020\u0006\u0012\u0006\u0010#\u001a\u00020\u0006\u0012\u0006\u0010$\u001a\u00020\u000b\u0012\u0006\u0010%\u001a\u00020\u000b\u0012\b\u0010&\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010'\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0015\u0012\u000e\b\u0002\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00020\u0018\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\bY\u0010ZJ\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ\u0010\u0010\n\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\n\u0010\bJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\rJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0014\u0010\bJ\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u0018HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u001e\u0010\bJ\u0012\u0010 \u001a\u0004\u0018\u00010\u001fHÆ\u0003¢\u0006\u0004\b \u0010!J\u0001\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\"\u001a\u00020\u00062\b\b\u0002\u0010#\u001a\u00020\u00062\b\b\u0002\u0010$\u001a\u00020\u000b2\b\b\u0002\u0010%\u001a\u00020\u000b2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00152\u000e\b\u0002\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00020\u00182\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u001fHÆ\u0001¢\u0006\u0004\b.\u0010/J\u0010\u00100\u001a\u00020\u001fHÖ\u0001¢\u0006\u0004\b0\u00101J\u001a\u00104\u001a\u00020\u000b2\b\u00103\u001a\u0004\u0018\u000102HÖ\u0003¢\u0006\u0004\b4\u00105J\u0010\u00106\u001a\u00020\u001fHÖ\u0001¢\u0006\u0004\b6\u00101J \u0010;\u001a\u00020:2\u0006\u00108\u001a\u0002072\u0006\u00109\u001a\u00020\u001fHÖ\u0001¢\u0006\u0004\b;\u0010<R\u001c\u0010%\u001a\u00020\u000b8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b%\u0010=\u001a\u0004\b>\u0010\rR\u001c\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00020\u00188V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b?\u0010\u001aR\u001e\u0010'\u001a\u0004\u0018\u00010\u000b8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b'\u0010A\u001a\u0004\bB\u0010\u0013R(\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00020\u00188\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b*\u0010C\u001a\u0004\bD\u0010\u001a\"\u0004\bE\u0010FR\u001e\u0010+\u001a\u0004\u0018\u00010\u001b8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b+\u0010G\u001a\u0004\bH\u0010\u001dR\u001e\u0010&\u001a\u0004\u0018\u00010\u000f8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b&\u0010I\u001a\u0004\bJ\u0010\u0011R\u001c\u0010#\u001a\u00020\u00068\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b#\u0010K\u001a\u0004\bL\u0010\bR\u001e\u0010-\u001a\u0004\u0018\u00010\u001f8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b-\u0010M\u001a\u0004\bN\u0010!R\u001c\u0010\"\u001a\u00020\u00068\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\"\u0010K\u001a\u0004\bO\u0010\bR\u001e\u0010,\u001a\u0004\u0018\u00010\u00068\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b,\u0010K\u001a\u0004\bP\u0010\bR$\u0010)\u001a\u0004\u0018\u00010\u00158\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b)\u0010Q\u001a\u0004\bR\u0010\u0017\"\u0004\bS\u0010TR$\u0010(\u001a\u0004\u0018\u00010\u00068\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b(\u0010K\u001a\u0004\bU\u0010\b\"\u0004\bV\u0010WR\u001c\u0010$\u001a\u00020\u000b8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b$\u0010=\u001a\u0004\bX\u0010\r¨\u0006["}, d2 = {"Lcom/avito/android/remote/model/category_parameters/SelectParameter$Flat;", "Lcom/avito/android/remote/model/category_parameters/SelectParameter;", "Lcom/avito/android/remote/model/category_parameters/SelectParameter$Value;", "getSelectedValue", "()Lcom/avito/android/remote/model/category_parameters/SelectParameter$Value;", "getChosenOrCurrentSelectedValue", "", "toString", "()Ljava/lang/String;", "component1", "component2", "", "component3", "()Z", "component4", "Lcom/avito/android/remote/model/text/AttributedText;", "component5", "()Lcom/avito/android/remote/model/text/AttributedText;", "component6", "()Ljava/lang/Boolean;", "component7", "Lcom/avito/android/remote/model/category_parameters/SelectParameter$UserChosenValue;", "component8", "()Lcom/avito/android/remote/model/category_parameters/SelectParameter$UserChosenValue;", "", "component9", "()Ljava/util/List;", "Lcom/avito/android/remote/model/category_parameters/SelectParameter$Displaying;", "component10", "()Lcom/avito/android/remote/model/category_parameters/SelectParameter$Displaying;", "component11", "", "component12", "()Ljava/lang/Integer;", "id", "title", "required", "immutable", "motivation", "updatesForm", "_value", "chosenValue", ResidentialComplexModuleKt.VALUES, "displaying", InternalConstsKt.PLACEHOLDER, "attributeId", "copy", "(Ljava/lang/String;Ljava/lang/String;ZZLcom/avito/android/remote/model/text/AttributedText;Ljava/lang/Boolean;Ljava/lang/String;Lcom/avito/android/remote/model/category_parameters/SelectParameter$UserChosenValue;Ljava/util/List;Lcom/avito/android/remote/model/category_parameters/SelectParameter$Displaying;Ljava/lang/String;Ljava/lang/Integer;)Lcom/avito/android/remote/model/category_parameters/SelectParameter$Flat;", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Z", "getImmutable", "getListToShow", "listToShow", "Ljava/lang/Boolean;", "getUpdatesForm", "Ljava/util/List;", "getValues", "setValues", "(Ljava/util/List;)V", "Lcom/avito/android/remote/model/category_parameters/SelectParameter$Displaying;", "getDisplaying", "Lcom/avito/android/remote/model/text/AttributedText;", "getMotivation", "Ljava/lang/String;", "getTitle", "Ljava/lang/Integer;", "getAttributeId", "getId", "getPlaceholder", "Lcom/avito/android/remote/model/category_parameters/SelectParameter$UserChosenValue;", "getChosenValue", "setChosenValue", "(Lcom/avito/android/remote/model/category_parameters/SelectParameter$UserChosenValue;)V", "get_value", "set_value", "(Ljava/lang/String;)V", "getRequired", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZZLcom/avito/android/remote/model/text/AttributedText;Ljava/lang/Boolean;Ljava/lang/String;Lcom/avito/android/remote/model/category_parameters/SelectParameter$UserChosenValue;Ljava/util/List;Lcom/avito/android/remote/model/category_parameters/SelectParameter$Displaying;Ljava/lang/String;Ljava/lang/Integer;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Flat extends SelectParameter {
        public static final Parcelable.Creator<Flat> CREATOR = new Creator();
        @SerializedName("value")
        @Nullable
        private String _value;
        @SerializedName("attrId")
        @Nullable
        private final Integer attributeId;
        @Nullable
        private UserChosenValue chosenValue;
        @SerializedName("displaying")
        @Nullable
        private final Displaying displaying;
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
        @SerializedName(ResidentialComplexModuleKt.VALUES)
        @NotNull
        private List<Value> values;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Flat> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Flat createFromParcel(@NotNull Parcel parcel) {
                Boolean bool;
                Intrinsics.checkNotNullParameter(parcel, "in");
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                boolean z = true;
                boolean z2 = parcel.readInt() != 0;
                boolean z3 = parcel.readInt() != 0;
                AttributedText attributedText = (AttributedText) parcel.readParcelable(Flat.class.getClassLoader());
                if (parcel.readInt() != 0) {
                    if (parcel.readInt() == 0) {
                        z = false;
                    }
                    bool = Boolean.valueOf(z);
                } else {
                    bool = null;
                }
                String readString3 = parcel.readString();
                UserChosenValue userChosenValue = (UserChosenValue) parcel.readParcelable(Flat.class.getClassLoader());
                int readInt = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add(Value.CREATOR.createFromParcel(parcel));
                    readInt--;
                }
                return new Flat(readString, readString2, z2, z3, attributedText, bool, readString3, userChosenValue, arrayList, parcel.readInt() != 0 ? Displaying.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Flat[] newArray(int i) {
                return new Flat[i];
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Flat(String str, String str2, boolean z, boolean z2, AttributedText attributedText, Boolean bool, String str3, UserChosenValue userChosenValue, List list, Displaying displaying2, String str4, Integer num, int i, j jVar) {
            this(str, str2, z, z2, attributedText, bool, (i & 64) != 0 ? null : str3, (i & 128) != 0 ? null : userChosenValue, (i & 256) != 0 ? new ArrayList() : list, (i & 512) != 0 ? null : displaying2, (i & 1024) != 0 ? null : str4, (i & 2048) != 0 ? -1 : num);
        }

        public static /* synthetic */ Flat copy$default(Flat flat, String str, String str2, boolean z, boolean z2, AttributedText attributedText, Boolean bool, String str3, UserChosenValue userChosenValue, List list, Displaying displaying2, String str4, Integer num, int i, Object obj) {
            return flat.copy((i & 1) != 0 ? flat.getId() : str, (i & 2) != 0 ? flat.getTitle() : str2, (i & 4) != 0 ? flat.getRequired() : z, (i & 8) != 0 ? flat.getImmutable() : z2, (i & 16) != 0 ? flat.getMotivation() : attributedText, (i & 32) != 0 ? flat.getUpdatesForm() : bool, (i & 64) != 0 ? flat.get_value() : str3, (i & 128) != 0 ? flat.getChosenValue() : userChosenValue, (i & 256) != 0 ? flat.values : list, (i & 512) != 0 ? flat.getDisplaying() : displaying2, (i & 1024) != 0 ? flat.getPlaceholder() : str4, (i & 2048) != 0 ? flat.getAttributeId() : num);
        }

        @NotNull
        public final String component1() {
            return getId();
        }

        @Nullable
        public final Displaying component10() {
            return getDisplaying();
        }

        @Nullable
        public final String component11() {
            return getPlaceholder();
        }

        @Nullable
        public final Integer component12() {
            return getAttributeId();
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
            return get_value();
        }

        @Nullable
        public final UserChosenValue component8() {
            return getChosenValue();
        }

        @NotNull
        public final List<Value> component9() {
            return this.values;
        }

        @NotNull
        public final Flat copy(@NotNull String str, @NotNull String str2, boolean z, boolean z2, @Nullable AttributedText attributedText, @Nullable Boolean bool, @Nullable String str3, @Nullable UserChosenValue userChosenValue, @NotNull List<Value> list, @Nullable Displaying displaying2, @Nullable String str4, @Nullable Integer num) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "title");
            Intrinsics.checkNotNullParameter(list, ResidentialComplexModuleKt.VALUES);
            return new Flat(str, str2, z, z2, attributedText, bool, str3, userChosenValue, list, displaying2, str4, num);
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
            if (!(obj instanceof Flat)) {
                return false;
            }
            Flat flat = (Flat) obj;
            return Intrinsics.areEqual(getId(), flat.getId()) && Intrinsics.areEqual(getTitle(), flat.getTitle()) && getRequired() == flat.getRequired() && getImmutable() == flat.getImmutable() && Intrinsics.areEqual(getMotivation(), flat.getMotivation()) && Intrinsics.areEqual(getUpdatesForm(), flat.getUpdatesForm()) && Intrinsics.areEqual(get_value(), flat.get_value()) && Intrinsics.areEqual(getChosenValue(), flat.getChosenValue()) && Intrinsics.areEqual(this.values, flat.values) && Intrinsics.areEqual(getDisplaying(), flat.getDisplaying()) && Intrinsics.areEqual(getPlaceholder(), flat.getPlaceholder()) && Intrinsics.areEqual(getAttributeId(), flat.getAttributeId());
        }

        @Override // com.avito.android.remote.model.category_parameters.base.CanHaveTypeCorrection
        @Nullable
        public Integer getAttributeId() {
            return this.attributeId;
        }

        @Override // com.avito.android.remote.model.category_parameters.SelectParameter
        @Nullable
        public Value getChosenOrCurrentSelectedValue() {
            String str;
            UserChosenValue chosenValue2 = getChosenValue();
            T t = null;
            if (chosenValue2 instanceof UserChosenValue.ValueId) {
                str = ((UserChosenValue.ValueId) chosenValue2).getId();
            } else if (chosenValue2 instanceof UserChosenValue.ClearValue) {
                str = null;
            } else {
                str = (String) getValue();
            }
            if (str == null) {
                return null;
            }
            Iterator<T> it = this.values.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                T next = it.next();
                if (Intrinsics.areEqual(next.getId(), str)) {
                    t = next;
                    break;
                }
            }
            return t;
        }

        @Override // com.avito.android.remote.model.category_parameters.SelectParameter
        @Nullable
        public UserChosenValue getChosenValue() {
            return this.chosenValue;
        }

        @Override // com.avito.android.remote.model.category_parameters.SelectParameter
        @Nullable
        public Displaying getDisplaying() {
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

        @Override // com.avito.android.remote.model.category_parameters.SelectParameter
        @NotNull
        public List<Value> getListToShow() {
            return this.values;
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

        @Override // com.avito.android.remote.model.category_parameters.SelectParameter
        @Nullable
        public Value getSelectedValue() {
            T t = null;
            if (getValue() == null) {
                return null;
            }
            Iterator<T> it = this.values.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                T next = it.next();
                if (Intrinsics.areEqual(next.getId(), (String) getValue())) {
                    t = next;
                    break;
                }
            }
            return t;
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
            String str = get_value();
            int hashCode5 = (hashCode4 + (str != null ? str.hashCode() : 0)) * 31;
            UserChosenValue chosenValue2 = getChosenValue();
            int hashCode6 = (hashCode5 + (chosenValue2 != null ? chosenValue2.hashCode() : 0)) * 31;
            List<Value> list = this.values;
            int hashCode7 = (hashCode6 + (list != null ? list.hashCode() : 0)) * 31;
            Displaying displaying2 = getDisplaying();
            int hashCode8 = (hashCode7 + (displaying2 != null ? displaying2.hashCode() : 0)) * 31;
            String placeholder2 = getPlaceholder();
            int hashCode9 = (hashCode8 + (placeholder2 != null ? placeholder2.hashCode() : 0)) * 31;
            Integer attributeId2 = getAttributeId();
            if (attributeId2 != null) {
                i = attributeId2.hashCode();
            }
            return hashCode9 + i;
        }

        @Override // com.avito.android.remote.model.category_parameters.SelectParameter
        public void setChosenValue(@Nullable UserChosenValue userChosenValue) {
            this.chosenValue = userChosenValue;
        }

        public final void setValues(@NotNull List<Value> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.values = list;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("SelectParameter.Flat(id:");
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
            parcel.writeString(this._value);
            parcel.writeParcelable(this.chosenValue, i);
            Iterator n0 = a.n0(this.values, parcel);
            while (n0.hasNext()) {
                ((Value) n0.next()).writeToParcel(parcel, 0);
            }
            Displaying displaying2 = this.displaying;
            if (displaying2 != null) {
                parcel.writeInt(1);
                displaying2.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            parcel.writeString(this.placeholder);
            Integer num = this.attributeId;
            if (num != null) {
                a.H0(parcel, 1, num);
            } else {
                parcel.writeInt(0);
            }
        }

        @Override // com.avito.android.remote.model.category_parameters.base.EditableParameter
        @Nullable
        public String get_value() {
            return this._value;
        }

        public void set_value(@Nullable String str) {
            this._value = str;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Flat(@NotNull String str, @NotNull String str2, boolean z, boolean z2, @Nullable AttributedText attributedText, @Nullable Boolean bool, @Nullable String str3, @Nullable UserChosenValue userChosenValue, @NotNull List<Value> list, @Nullable Displaying displaying2, @Nullable String str4, @Nullable Integer num) {
            super(null);
            a.c1(str, "id", str2, "title", list, ResidentialComplexModuleKt.VALUES);
            this.id = str;
            this.title = str2;
            this.required = z;
            this.immutable = z2;
            this.motivation = attributedText;
            this.updatesForm = bool;
            this._value = str3;
            this.chosenValue = userChosenValue;
            this.values = list;
            this.displaying = displaying2;
            this.placeholder = str4;
            this.attributeId = num;
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\b\u0018\u00002\u00020\u0001:\u0001_B\u0001\u0012\u0006\u0010&\u001a\u00020\u0002\u0012\u0006\u0010'\u001a\u00020\u0002\u0012\u0006\u0010(\u001a\u00020\u0011\u0012\u0006\u0010)\u001a\u00020\u0011\u0012\b\u0010*\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010+\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u001b\u0012\u000e\b\u0002\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010#¢\u0006\u0004\b]\u0010^J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0007HÂ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000eJ\u0010\u0010\u0012\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0013J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u000eJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eHÆ\u0003¢\u0006\u0004\b \u0010!J\u0012\u0010\"\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\"\u0010\u000eJ\u0012\u0010$\u001a\u0004\u0018\u00010#HÆ\u0003¢\u0006\u0004\b$\u0010%J\u0001\u00102\u001a\u00020\u00002\b\b\u0002\u0010&\u001a\u00020\u00022\b\b\u0002\u0010'\u001a\u00020\u00022\b\b\u0002\u0010(\u001a\u00020\u00112\b\b\u0002\u0010)\u001a\u00020\u00112\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u001b2\u000e\b\u0002\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00101\u001a\u0004\u0018\u00010#HÆ\u0001¢\u0006\u0004\b2\u00103J\u0010\u00104\u001a\u00020#HÖ\u0001¢\u0006\u0004\b4\u00105J\u001a\u00108\u001a\u00020\u00112\b\u00107\u001a\u0004\u0018\u000106HÖ\u0003¢\u0006\u0004\b8\u00109J\u0010\u0010:\u001a\u00020#HÖ\u0001¢\u0006\u0004\b:\u00105J \u0010?\u001a\u00020>2\u0006\u0010<\u001a\u00020;2\u0006\u0010=\u001a\u00020#HÖ\u0001¢\u0006\u0004\b?\u0010@R\u001c\u0010&\u001a\u00020\u00028\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b&\u0010A\u001a\u0004\bB\u0010\u000eR\u001c\u0010'\u001a\u00020\u00028\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b'\u0010A\u001a\u0004\bC\u0010\u000eR\u001c\u0010(\u001a\u00020\u00118\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b(\u0010D\u001a\u0004\bE\u0010\u0013R$\u0010,\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b,\u0010A\u001a\u0004\bF\u0010\u000e\"\u0004\bG\u0010HR$\u0010-\u001a\u0004\u0018\u00010\u001b8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b-\u0010I\u001a\u0004\bJ\u0010\u001d\"\u0004\bK\u0010LR\"\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b.\u0010M\u001a\u0004\bN\u0010!R\u001e\u0010*\u001a\u0004\u0018\u00010\u00158\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b*\u0010O\u001a\u0004\bP\u0010\u0017R\u001c\u0010)\u001a\u00020\u00118\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b)\u0010D\u001a\u0004\bQ\u0010\u0013R\u0018\u0010/\u001a\u0004\u0018\u00010\u00078\u0002@\u0003X\u0004¢\u0006\u0006\n\u0004\b/\u0010RR\u001e\u00100\u001a\u0004\u0018\u00010\u00028\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b0\u0010A\u001a\u0004\bS\u0010\u000eR\u0018\u0010U\u001a\u0004\u0018\u00010\u00078V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\bT\u0010\tR\u001e\u0010+\u001a\u0004\u0018\u00010\u00118\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b+\u0010V\u001a\u0004\bW\u0010\u0019R\u001e\u00101\u001a\u0004\u0018\u00010#8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b1\u0010X\u001a\u0004\bY\u0010%R\"\u0010\\\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020Z0\u001e8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b[\u0010!¨\u0006`"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/SelectParameter$Sectioned;", "Lcom/avito/android/remote/model/category_parameters/SelectParameter;", "", "valueId", "Lcom/avito/android/remote/model/category_parameters/SelectParameter$Value;", "findValueWithId", "(Ljava/lang/String;)Lcom/avito/android/remote/model/category_parameters/SelectParameter$Value;", "Lcom/avito/android/remote/model/category_parameters/SelectParameter$Displaying;", "component10", "()Lcom/avito/android/remote/model/category_parameters/SelectParameter$Displaying;", "getSelectedValue", "()Lcom/avito/android/remote/model/category_parameters/SelectParameter$Value;", "getChosenOrCurrentSelectedValue", "toString", "()Ljava/lang/String;", "component1", "component2", "", "component3", "()Z", "component4", "Lcom/avito/android/remote/model/text/AttributedText;", "component5", "()Lcom/avito/android/remote/model/text/AttributedText;", "component6", "()Ljava/lang/Boolean;", "component7", "Lcom/avito/android/remote/model/category_parameters/SelectParameter$UserChosenValue;", "component8", "()Lcom/avito/android/remote/model/category_parameters/SelectParameter$UserChosenValue;", "", "Lcom/avito/android/remote/model/category_parameters/SelectParameter$Sectioned$Section;", "component9", "()Ljava/util/List;", "component11", "", "component12", "()Ljava/lang/Integer;", "id", "title", "required", "immutable", "motivation", "updatesForm", "_value", "chosenValue", "sections", "_displaying", InternalConstsKt.PLACEHOLDER, "attributeId", "copy", "(Ljava/lang/String;Ljava/lang/String;ZZLcom/avito/android/remote/model/text/AttributedText;Ljava/lang/Boolean;Ljava/lang/String;Lcom/avito/android/remote/model/category_parameters/SelectParameter$UserChosenValue;Ljava/util/List;Lcom/avito/android/remote/model/category_parameters/SelectParameter$Displaying;Ljava/lang/String;Ljava/lang/Integer;)Lcom/avito/android/remote/model/category_parameters/SelectParameter$Sectioned;", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getId", "getTitle", "Z", "getRequired", "get_value", "set_value", "(Ljava/lang/String;)V", "Lcom/avito/android/remote/model/category_parameters/SelectParameter$UserChosenValue;", "getChosenValue", "setChosenValue", "(Lcom/avito/android/remote/model/category_parameters/SelectParameter$UserChosenValue;)V", "Ljava/util/List;", "getSections", "Lcom/avito/android/remote/model/text/AttributedText;", "getMotivation", "getImmutable", "Lcom/avito/android/remote/model/category_parameters/SelectParameter$Displaying;", "getPlaceholder", "getDisplaying", "displaying", "Ljava/lang/Boolean;", "getUpdatesForm", "Ljava/lang/Integer;", "getAttributeId", "Lcom/avito/android/remote/model/ParcelableEntity;", "getListToShow", "listToShow", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZZLcom/avito/android/remote/model/text/AttributedText;Ljava/lang/Boolean;Ljava/lang/String;Lcom/avito/android/remote/model/category_parameters/SelectParameter$UserChosenValue;Ljava/util/List;Lcom/avito/android/remote/model/category_parameters/SelectParameter$Displaying;Ljava/lang/String;Ljava/lang/Integer;)V", "Section", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Sectioned extends SelectParameter {
        public static final Parcelable.Creator<Sectioned> CREATOR = new Creator();
        @SerializedName("displaying")
        private final Displaying _displaying;
        @SerializedName("value")
        @Nullable
        private String _value;
        @SerializedName("attrId")
        @Nullable
        private final Integer attributeId;
        @Nullable
        private UserChosenValue chosenValue;
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
        @SerializedName(ResidentialComplexModuleKt.VALUES)
        @NotNull
        private final List<Section> sections;
        @SerializedName("title")
        @NotNull
        private final String title;
        @SerializedName("updatesForm")
        @Nullable
        private final Boolean updatesForm;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Sectioned> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Sectioned createFromParcel(@NotNull Parcel parcel) {
                Boolean bool;
                Intrinsics.checkNotNullParameter(parcel, "in");
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                boolean z = true;
                boolean z2 = parcel.readInt() != 0;
                boolean z3 = parcel.readInt() != 0;
                AttributedText attributedText = (AttributedText) parcel.readParcelable(Sectioned.class.getClassLoader());
                if (parcel.readInt() != 0) {
                    if (parcel.readInt() == 0) {
                        z = false;
                    }
                    bool = Boolean.valueOf(z);
                } else {
                    bool = null;
                }
                String readString3 = parcel.readString();
                UserChosenValue userChosenValue = (UserChosenValue) parcel.readParcelable(Sectioned.class.getClassLoader());
                int readInt = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add(Section.CREATOR.createFromParcel(parcel));
                    readInt--;
                }
                return new Sectioned(readString, readString2, z2, z3, attributedText, bool, readString3, userChosenValue, arrayList, parcel.readInt() != 0 ? Displaying.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Sectioned[] newArray(int i) {
                return new Sectioned[i];
            }
        }

        @Parcelize
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001B#\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b!\u0010\"J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ,\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0010J \u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cR\u001e\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004R\"\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u001f\u001a\u0004\b \u0010\b¨\u0006#"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/SelectParameter$Sectioned$Section;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "", "Lcom/avito/android/remote/model/category_parameters/SelectParameter$Value;", "component2", "()Ljava/util/List;", "sectionTitle", ResidentialComplexModuleKt.VALUES, "copy", "(Ljava/lang/String;Ljava/util/List;)Lcom/avito/android/remote/model/category_parameters/SelectParameter$Sectioned$Section;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getSectionTitle", "Ljava/util/List;", "getValues", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Section implements Parcelable {
            public static final Parcelable.Creator<Section> CREATOR = new Creator();
            @SerializedName("title")
            @Nullable
            private final String sectionTitle;
            @SerializedName("options")
            @NotNull
            private final List<Value> values;

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<Section> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Section createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    String readString = parcel.readString();
                    int readInt = parcel.readInt();
                    ArrayList arrayList = new ArrayList(readInt);
                    while (readInt != 0) {
                        arrayList.add(Value.CREATOR.createFromParcel(parcel));
                        readInt--;
                    }
                    return new Section(readString, arrayList);
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Section[] newArray(int i) {
                    return new Section[i];
                }
            }

            public Section() {
                this(null, null, 3, null);
            }

            public Section(@Nullable String str, @NotNull List<Value> list) {
                Intrinsics.checkNotNullParameter(list, ResidentialComplexModuleKt.VALUES);
                this.sectionTitle = str;
                this.values = list;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.remote.model.category_parameters.SelectParameter$Sectioned$Section */
            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Section copy$default(Section section, String str, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = section.sectionTitle;
                }
                if ((i & 2) != 0) {
                    list = section.values;
                }
                return section.copy(str, list);
            }

            @Nullable
            public final String component1() {
                return this.sectionTitle;
            }

            @NotNull
            public final List<Value> component2() {
                return this.values;
            }

            @NotNull
            public final Section copy(@Nullable String str, @NotNull List<Value> list) {
                Intrinsics.checkNotNullParameter(list, ResidentialComplexModuleKt.VALUES);
                return new Section(str, list);
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
                if (!(obj instanceof Section)) {
                    return false;
                }
                Section section = (Section) obj;
                return Intrinsics.areEqual(this.sectionTitle, section.sectionTitle) && Intrinsics.areEqual(this.values, section.values);
            }

            @Nullable
            public final String getSectionTitle() {
                return this.sectionTitle;
            }

            @NotNull
            public final List<Value> getValues() {
                return this.values;
            }

            @Override // java.lang.Object
            public int hashCode() {
                String str = this.sectionTitle;
                int i = 0;
                int hashCode = (str != null ? str.hashCode() : 0) * 31;
                List<Value> list = this.values;
                if (list != null) {
                    i = list.hashCode();
                }
                return hashCode + i;
            }

            @Override // java.lang.Object
            @NotNull
            public String toString() {
                StringBuilder L = a.L("Section(sectionTitle=");
                L.append(this.sectionTitle);
                L.append(", values=");
                return a.w(L, this.values, ")");
            }

            @Override // android.os.Parcelable
            public void writeToParcel(@NotNull Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.writeString(this.sectionTitle);
                Iterator n0 = a.n0(this.values, parcel);
                while (n0.hasNext()) {
                    ((Value) n0.next()).writeToParcel(parcel, 0);
                }
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Section(String str, List list, int i, j jVar) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list);
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Sectioned(String str, String str2, boolean z, boolean z2, AttributedText attributedText, Boolean bool, String str3, UserChosenValue userChosenValue, List list, Displaying displaying, String str4, Integer num, int i, j jVar) {
            this(str, str2, z, z2, attributedText, bool, (i & 64) != 0 ? null : str3, (i & 128) != 0 ? null : userChosenValue, (i & 256) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i & 512) != 0 ? null : displaying, (i & 1024) != 0 ? null : str4, (i & 2048) != 0 ? -1 : num);
        }

        private final Displaying component10() {
            return this._displaying;
        }

        public static /* synthetic */ Sectioned copy$default(Sectioned sectioned, String str, String str2, boolean z, boolean z2, AttributedText attributedText, Boolean bool, String str3, UserChosenValue userChosenValue, List list, Displaying displaying, String str4, Integer num, int i, Object obj) {
            return sectioned.copy((i & 1) != 0 ? sectioned.getId() : str, (i & 2) != 0 ? sectioned.getTitle() : str2, (i & 4) != 0 ? sectioned.getRequired() : z, (i & 8) != 0 ? sectioned.getImmutable() : z2, (i & 16) != 0 ? sectioned.getMotivation() : attributedText, (i & 32) != 0 ? sectioned.getUpdatesForm() : bool, (i & 64) != 0 ? sectioned.get_value() : str3, (i & 128) != 0 ? sectioned.getChosenValue() : userChosenValue, (i & 256) != 0 ? sectioned.sections : list, (i & 512) != 0 ? sectioned._displaying : displaying, (i & 1024) != 0 ? sectioned.getPlaceholder() : str4, (i & 2048) != 0 ? sectioned.getAttributeId() : num);
        }

        private final Value findValueWithId(String str) {
            Object obj;
            Iterator it = SequencesKt__SequencesKt.flattenSequenceOfIterable(SequencesKt___SequencesKt.map(CollectionsKt___CollectionsKt.asSequence(this.sections), SelectParameter$Sectioned$findValueWithId$1.INSTANCE)).iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual(((Value) obj).getId(), str)) {
                    break;
                }
            }
            return (Value) obj;
        }

        @NotNull
        public final String component1() {
            return getId();
        }

        @Nullable
        public final String component11() {
            return getPlaceholder();
        }

        @Nullable
        public final Integer component12() {
            return getAttributeId();
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
            return get_value();
        }

        @Nullable
        public final UserChosenValue component8() {
            return getChosenValue();
        }

        @NotNull
        public final List<Section> component9() {
            return this.sections;
        }

        @NotNull
        public final Sectioned copy(@NotNull String str, @NotNull String str2, boolean z, boolean z2, @Nullable AttributedText attributedText, @Nullable Boolean bool, @Nullable String str3, @Nullable UserChosenValue userChosenValue, @NotNull List<Section> list, @Nullable Displaying displaying, @Nullable String str4, @Nullable Integer num) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "title");
            Intrinsics.checkNotNullParameter(list, "sections");
            return new Sectioned(str, str2, z, z2, attributedText, bool, str3, userChosenValue, list, displaying, str4, num);
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
            if (!(obj instanceof Sectioned)) {
                return false;
            }
            Sectioned sectioned = (Sectioned) obj;
            return Intrinsics.areEqual(getId(), sectioned.getId()) && Intrinsics.areEqual(getTitle(), sectioned.getTitle()) && getRequired() == sectioned.getRequired() && getImmutable() == sectioned.getImmutable() && Intrinsics.areEqual(getMotivation(), sectioned.getMotivation()) && Intrinsics.areEqual(getUpdatesForm(), sectioned.getUpdatesForm()) && Intrinsics.areEqual(get_value(), sectioned.get_value()) && Intrinsics.areEqual(getChosenValue(), sectioned.getChosenValue()) && Intrinsics.areEqual(this.sections, sectioned.sections) && Intrinsics.areEqual(this._displaying, sectioned._displaying) && Intrinsics.areEqual(getPlaceholder(), sectioned.getPlaceholder()) && Intrinsics.areEqual(getAttributeId(), sectioned.getAttributeId());
        }

        @Override // com.avito.android.remote.model.category_parameters.base.CanHaveTypeCorrection
        @Nullable
        public Integer getAttributeId() {
            return this.attributeId;
        }

        @Override // com.avito.android.remote.model.category_parameters.SelectParameter
        @Nullable
        public Value getChosenOrCurrentSelectedValue() {
            String str;
            UserChosenValue chosenValue2 = getChosenValue();
            if (chosenValue2 instanceof UserChosenValue.ValueId) {
                str = ((UserChosenValue.ValueId) chosenValue2).getId();
            } else if (chosenValue2 instanceof UserChosenValue.ClearValue) {
                str = null;
            } else {
                str = (String) getValue();
            }
            if (str != null) {
                return findValueWithId(str);
            }
            return null;
        }

        @Override // com.avito.android.remote.model.category_parameters.SelectParameter
        @Nullable
        public UserChosenValue getChosenValue() {
            return this.chosenValue;
        }

        @Override // com.avito.android.remote.model.category_parameters.SelectParameter
        @Nullable
        public Displaying getDisplaying() {
            Displaying displaying = this._displaying;
            if (displaying != null) {
                return Displaying.copy$default(displaying, "default", null, false, null, null, null, 62, null);
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

        @Override // com.avito.android.remote.model.category_parameters.SelectParameter
        @NotNull
        public List<ParcelableEntity<String>> getListToShow() {
            return SequencesKt___SequencesKt.toList(SequencesKt__SequencesKt.flattenSequenceOfIterable(SequencesKt___SequencesKt.mapNotNull(CollectionsKt___CollectionsKt.asSequence(this.sections), SelectParameter$Sectioned$listToShow$1.INSTANCE)));
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

        @NotNull
        public final List<Section> getSections() {
            return this.sections;
        }

        @Override // com.avito.android.remote.model.category_parameters.SelectParameter
        @Nullable
        public Value getSelectedValue() {
            String str = (String) getValue();
            if (str != null) {
                return findValueWithId(str);
            }
            return null;
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
            String str = get_value();
            int hashCode5 = (hashCode4 + (str != null ? str.hashCode() : 0)) * 31;
            UserChosenValue chosenValue2 = getChosenValue();
            int hashCode6 = (hashCode5 + (chosenValue2 != null ? chosenValue2.hashCode() : 0)) * 31;
            List<Section> list = this.sections;
            int hashCode7 = (hashCode6 + (list != null ? list.hashCode() : 0)) * 31;
            Displaying displaying = this._displaying;
            int hashCode8 = (hashCode7 + (displaying != null ? displaying.hashCode() : 0)) * 31;
            String placeholder2 = getPlaceholder();
            int hashCode9 = (hashCode8 + (placeholder2 != null ? placeholder2.hashCode() : 0)) * 31;
            Integer attributeId2 = getAttributeId();
            if (attributeId2 != null) {
                i = attributeId2.hashCode();
            }
            return hashCode9 + i;
        }

        @Override // com.avito.android.remote.model.category_parameters.SelectParameter
        public void setChosenValue(@Nullable UserChosenValue userChosenValue) {
            this.chosenValue = userChosenValue;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("SelectParameter.Sectioned(id:");
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
            parcel.writeString(this._value);
            parcel.writeParcelable(this.chosenValue, i);
            Iterator n0 = a.n0(this.sections, parcel);
            while (n0.hasNext()) {
                ((Section) n0.next()).writeToParcel(parcel, 0);
            }
            Displaying displaying = this._displaying;
            if (displaying != null) {
                parcel.writeInt(1);
                displaying.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            parcel.writeString(this.placeholder);
            Integer num = this.attributeId;
            if (num != null) {
                a.H0(parcel, 1, num);
            } else {
                parcel.writeInt(0);
            }
        }

        @Override // com.avito.android.remote.model.category_parameters.base.EditableParameter
        @Nullable
        public String get_value() {
            return this._value;
        }

        public void set_value(@Nullable String str) {
            this._value = str;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Sectioned(@NotNull String str, @NotNull String str2, boolean z, boolean z2, @Nullable AttributedText attributedText, @Nullable Boolean bool, @Nullable String str3, @Nullable UserChosenValue userChosenValue, @NotNull List<Section> list, @Nullable Displaying displaying, @Nullable String str4, @Nullable Integer num) {
            super(null);
            a.c1(str, "id", str2, "title", list, "sections");
            this.id = str;
            this.title = str2;
            this.required = z;
            this.immutable = z2;
            this.motivation = attributedText;
            this.updatesForm = bool;
            this._value = str3;
            this.chosenValue = userChosenValue;
            this.sections = list;
            this._displaying = displaying;
            this.placeholder = str4;
            this.attributeId = num;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/SelectParameter$UserChosenValue;", "Landroid/os/Parcelable;", "<init>", "()V", "ClearValue", "ValueId", "Lcom/avito/android/remote/model/category_parameters/SelectParameter$UserChosenValue$ClearValue;", "Lcom/avito/android/remote/model/category_parameters/SelectParameter$UserChosenValue$ValueId;", "models_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class UserChosenValue implements Parcelable {

        @Parcelize
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/SelectParameter$UserChosenValue$ClearValue;", "Lcom/avito/android/remote/model/category_parameters/SelectParameter$UserChosenValue;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class ClearValue extends UserChosenValue {
            public static final Parcelable.Creator<ClearValue> CREATOR = new Creator();
            @NotNull
            public static final ClearValue INSTANCE = new ClearValue();

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<ClearValue> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final ClearValue createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    if (parcel.readInt() != 0) {
                        return ClearValue.INSTANCE;
                    }
                    return null;
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final ClearValue[] newArray(int i) {
                    return new ClearValue[i];
                }
            }

            private ClearValue() {
                super(null);
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(@NotNull Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.writeInt(1);
            }
        }

        @Parcelize
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\f\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/SelectParameter$UserChosenValue$ValueId;", "Lcom/avito/android/remote/model/category_parameters/SelectParameter$UserChosenValue;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class ValueId extends UserChosenValue {
            public static final Parcelable.Creator<ValueId> CREATOR = new Creator();
            @NotNull
            private final String id;

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<ValueId> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final ValueId createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    return new ValueId(parcel.readString());
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final ValueId[] newArray(int i) {
                    return new ValueId[i];
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public ValueId(@NotNull String str) {
                super(null);
                Intrinsics.checkNotNullParameter(str, "id");
                this.id = str;
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @NotNull
            public final String getId() {
                return this.id;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(@NotNull Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.writeString(this.id);
            }
        }

        private UserChosenValue() {
        }

        public /* synthetic */ UserChosenValue(j jVar) {
            this();
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001*B3\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019\u0012\b\u0010$\u001a\u0004\u0018\u00010#¢\u0006\u0004\b(\u0010)J\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\r\u0010\nJ \u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u00020\u00028\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\fR\u001c\u0010\u0017\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0015\u001a\u0004\b\u0018\u0010\fR*\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00198\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0016\u0010\"\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\fR\u001e\u0010$\u001a\u0004\u0018\u00010#8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'¨\u0006+"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/SelectParameter$Value;", "Lcom/avito/android/remote/model/ParcelableEntity;", "", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "()Ljava/lang/String;", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "id", "Ljava/lang/String;", "getId", "title", "getTitle", "", "Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;", ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, "Ljava/util/List;", "getParameters", "()Ljava/util/List;", "setParameters", "(Ljava/util/List;)V", "getName", "name", "Lcom/avito/android/remote/model/category_parameters/SelectParameter$Value$Display;", "display", "Lcom/avito/android/remote/model/category_parameters/SelectParameter$Value$Display;", "getDisplay", "()Lcom/avito/android/remote/model/category_parameters/SelectParameter$Value$Display;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/avito/android/remote/model/category_parameters/SelectParameter$Value$Display;)V", "Display", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Value implements ParcelableEntity<String> {
        public static final Parcelable.Creator<Value> CREATOR = new Creator();
        @SerializedName("display")
        @Nullable
        private final Display display;
        @SerializedName("id")
        @NotNull
        private final String id;
        @SerializedName("params")
        @Nullable
        private List<? extends ParameterSlot> parameters;
        @SerializedName("title")
        @NotNull
        private final String title;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Value> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Value createFromParcel(@NotNull Parcel parcel) {
                ArrayList arrayList;
                Intrinsics.checkNotNullParameter(parcel, "in");
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                Display display = null;
                if (parcel.readInt() != 0) {
                    int readInt = parcel.readInt();
                    arrayList = new ArrayList(readInt);
                    while (readInt != 0) {
                        arrayList.add((ParameterSlot) parcel.readParcelable(Value.class.getClassLoader()));
                        readInt--;
                    }
                } else {
                    arrayList = null;
                }
                if (parcel.readInt() != 0) {
                    display = Display.CREATOR.createFromParcel(parcel);
                }
                return new Value(readString, readString2, arrayList, display);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Value[] newArray(int i) {
                return new Value[i];
            }
        }

        @Parcelize
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001BA\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000fR\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lcom/avito/android/remote/model/category_parameters/SelectParameter$Value$Display;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "sortParam", "Ljava/lang/String;", "getSortParam", "()Ljava/lang/String;", "title", "getTitle", MessengerShareContentUtility.SUBTITLE, "getSubtitle", "Lcom/avito/android/remote/model/Image;", "image", "Lcom/avito/android/remote/model/Image;", "getImage", "()Lcom/avito/android/remote/model/Image;", "Lcom/avito/android/remote/model/Color;", "color", "Lcom/avito/android/remote/model/Color;", "getColor", "()Lcom/avito/android/remote/model/Color;", "<init>", "(Lcom/avito/android/remote/model/Color;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;Ljava/lang/String;)V", "models_release"}, k = 1, mv = {1, 4, 2})
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

        public Value(@NotNull String str, @NotNull String str2, @Nullable List<? extends ParameterSlot> list, @Nullable Display display2) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "title");
            this.id = str;
            this.title = str2;
            this.parameters = list;
            this.display = display2;
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
            if (!Intrinsics.areEqual(obj != null ? obj.getClass() : null, Value.class)) {
                return false;
            }
            Objects.requireNonNull(obj, "null cannot be cast to non-null type com.avito.android.remote.model.category_parameters.SelectParameter.Value");
            return !(Intrinsics.areEqual(getId(), ((Value) obj).getId()) ^ true);
        }

        @Nullable
        public final Display getDisplay() {
            return this.display;
        }

        @Override // com.avito.android.remote.model.Entity
        @NotNull
        public String getName() {
            return this.title;
        }

        /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.util.List<? extends com.avito.android.remote.model.category_parameters.base.ParameterSlot>, java.util.List<com.avito.android.remote.model.category_parameters.base.ParameterSlot> */
        @Nullable
        public final List<ParameterSlot> getParameters() {
            return this.parameters;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return getId().hashCode();
        }

        public final void setParameters(@Nullable List<? extends ParameterSlot> list) {
            this.parameters = list;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("Value(id='");
            L.append(getId());
            L.append("', title='");
            return a.t(L, this.title, "')");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.id);
            parcel.writeString(this.title);
            List<? extends ParameterSlot> list = this.parameters;
            if (list != null) {
                Iterator l0 = a.l0(parcel, 1, list);
                while (l0.hasNext()) {
                    parcel.writeParcelable((ParameterSlot) l0.next(), i);
                }
            } else {
                parcel.writeInt(0);
            }
            Display display2 = this.display;
            if (display2 != null) {
                parcel.writeInt(1);
                display2.writeToParcel(parcel, 0);
                return;
            }
            parcel.writeInt(0);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Value(String str, String str2, List list, Display display2, int i, j jVar) {
            this(str, str2, (i & 4) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, display2);
        }

        @Override // com.avito.android.remote.model.Entity
        @NotNull
        public String getId() {
            return this.id;
        }
    }

    private SelectParameter() {
    }

    public final void applyChosenValue() {
        String str;
        UserChosenValue chosenValue = getChosenValue();
        if (chosenValue != null) {
            if (chosenValue instanceof UserChosenValue.ValueId) {
                str = ((UserChosenValue.ValueId) chosenValue).getId();
            } else if (chosenValue instanceof UserChosenValue.ClearValue) {
                str = null;
            } else {
                throw new NoWhenBranchMatchedException();
            }
            setValue(str);
            setChosenValue(null);
        }
    }

    @Nullable
    public abstract Value getChosenOrCurrentSelectedValue();

    @Nullable
    public abstract UserChosenValue getChosenValue();

    @Nullable
    public abstract Displaying getDisplaying();

    @NotNull
    public abstract List<ParcelableEntity<String>> getListToShow();

    @Nullable
    public abstract Value getSelectedValue();

    @Override // com.avito.android.remote.model.category_parameters.base.CanHaveTypeCorrection
    @Nullable
    public Boolean getTypoCorrectionEnabled() {
        Displaying displaying = getDisplaying();
        if (displaying != null) {
            return displaying.getTypoCorrectionEnabled();
        }
        return null;
    }

    public abstract void setChosenValue(@Nullable UserChosenValue userChosenValue);

    public /* synthetic */ SelectParameter(j jVar) {
        this();
    }
}
