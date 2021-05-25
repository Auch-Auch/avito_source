package com.avito.android.remote.model.search;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.Navigation;
import com.avito.android.remote.model.category_parameters.SortDirection;
import com.facebook.share.internal.MessengerShareContentUtility;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0018\b\b\u0018\u00002\u00020\u0001:\u0005ABCDEBg\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0010\u0012\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b?\u0010@J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0007J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\f\u0010\u0007J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0007J\u0001\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00102\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00132\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b#\u0010\u0007J\u0010\u0010$\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b$\u0010%J\u001a\u0010(\u001a\u00020\r2\b\u0010'\u001a\u0004\u0018\u00010&HÖ\u0003¢\u0006\u0004\b(\u0010)J\u0010\u0010*\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b*\u0010%J \u0010/\u001a\u00020.2\u0006\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b/\u00100R\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001c\u00101\u001a\u0004\b2\u0010\u0007R\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001e\u00103\u001a\u0004\b4\u0010\u0012R\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001b\u00101\u001a\u0004\b5\u0010\u0007R$\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001f\u00106\u001a\u0004\b7\u0010\u0016R\u001e\u0010 \u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b \u00101\u001a\u0004\b8\u0010\u0007R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0018\u00109\u001a\u0004\b:\u0010\u0004R\u001e\u0010\u001d\u001a\u0004\u0018\u00010\r8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001d\u0010;\u001a\u0004\b\u001d\u0010\u000fR\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0019\u00101\u001a\u0004\b<\u0010\u0007R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001a\u0010=\u001a\u0004\b>\u0010\n¨\u0006F"}, d2 = {"Lcom/avito/android/remote/model/search/Filter;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/Integer;", "", "component2", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/search/Filter$Widget;", "component3", "()Lcom/avito/android/remote/model/search/Filter$Widget;", "component4", "component5", "", "component6", "()Ljava/lang/Boolean;", "Lcom/avito/android/remote/model/search/InlineFilterValue;", "component7", "()Lcom/avito/android/remote/model/search/InlineFilterValue;", "", "Lcom/avito/android/remote/model/search/Filter$InnerOptions;", "component8", "()Ljava/util/List;", "component9", "attrId", "id", "widget", "title", "displayTitle", "isHighlighted", "value", "options", "changedParamType", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/avito/android/remote/model/search/Filter$Widget;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/avito/android/remote/model/search/InlineFilterValue;Ljava/util/List;Ljava/lang/String;)Lcom/avito/android/remote/model/search/Filter;", "toString", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getDisplayTitle", "Lcom/avito/android/remote/model/search/InlineFilterValue;", "getValue", "getTitle", "Ljava/util/List;", "getOptions", "getChangedParamType", "Ljava/lang/Integer;", "getAttrId", "Ljava/lang/Boolean;", "getId", "Lcom/avito/android/remote/model/search/Filter$Widget;", "getWidget", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/avito/android/remote/model/search/Filter$Widget;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/avito/android/remote/model/search/InlineFilterValue;Ljava/util/List;Ljava/lang/String;)V", "Config", "InnerOptions", "NextAction", "OptionsGroup", "Widget", "models_release"}, k = 1, mv = {1, 4, 2})
public final class Filter implements Parcelable {
    public static final Parcelable.Creator<Filter> CREATOR = new Creator();
    @SerializedName("attrId")
    @Nullable
    private final Integer attrId;
    @SerializedName("changedParamType")
    @Nullable
    private final String changedParamType;
    @SerializedName("displayTitle")
    @Nullable
    private final String displayTitle;
    @SerializedName("id")
    @Nullable
    private final String id;
    @SerializedName("isHighlighted")
    @Nullable
    private final Boolean isHighlighted;
    @SerializedName("options")
    @Nullable
    private final List<InnerOptions> options;
    @SerializedName("title")
    @Nullable
    private final String title;
    @SerializedName("value")
    @Nullable
    private final InlineFilterValue value;
    @SerializedName("widget")
    @Nullable
    private final Widget widget;

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B©\u0001\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0010\u0012\u0010\b\u0002\u0010.\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b8\u00109J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001f\u0010\r\u001a\u0004\b \u0010\u000fR\u001e\u0010!\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b!\u0010\u0012\u001a\u0004\b\"\u0010\u0014R\u001e\u0010$\u001a\u0004\u0018\u00010#8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001e\u0010(\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b(\u0010\u0012\u001a\u0004\b)\u0010\u0014R\u001e\u0010*\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b*\u0010\u0012\u001a\u0004\b+\u0010\u0014R$\u0010.\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u001e\u00102\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b2\u0010\r\u001a\u0004\b3\u0010\u000fR\u001e\u00104\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b4\u0010\r\u001a\u0004\b5\u0010\u000fR\u001e\u00106\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b6\u0010\u0012\u001a\u0004\b7\u0010\u0014¨\u0006:"}, d2 = {"Lcom/avito/android/remote/model/search/Filter$Config;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "areGroupsCollapsible", "Ljava/lang/Boolean;", "getAreGroupsCollapsible", "()Ljava/lang/Boolean;", "", "toValueFormat", "Ljava/lang/String;", "getToValueFormat", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/search/Filter$NextAction;", "nextAction", "Lcom/avito/android/remote/model/search/Filter$NextAction;", "getNextAction", "()Lcom/avito/android/remote/model/search/Filter$NextAction;", "Lcom/avito/android/remote/model/category_parameters/SortDirection;", "sortDirection", "Lcom/avito/android/remote/model/category_parameters/SortDirection;", "getSortDirection", "()Lcom/avito/android/remote/model/category_parameters/SortDirection;", "withBackButton", "getWithBackButton", "thousandsSeparator", "getThousandsSeparator", "Lcom/avito/android/remote/model/search/WidgetSize;", "size", "Lcom/avito/android/remote/model/search/WidgetSize;", "getSize", "()Lcom/avito/android/remote/model/search/WidgetSize;", "fromValueFormat", "getFromValueFormat", "fromPlaceholder", "getFromPlaceholder", "", "Lcom/avito/android/remote/model/search/Filter$OptionsGroup;", "groups", "Ljava/util/List;", "getGroups", "()Ljava/util/List;", "withImages", "getWithImages", "resetDisabled", "getResetDisabled", "toPlaceholder", "getToPlaceholder", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/avito/android/remote/model/search/WidgetSize;Lcom/avito/android/remote/model/search/Filter$NextAction;Ljava/lang/Boolean;Lcom/avito/android/remote/model/category_parameters/SortDirection;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Config implements Parcelable {
        public static final Parcelable.Creator<Config> CREATOR = new Creator();
        @SerializedName("areGroupsCollapsible")
        @Nullable
        private final Boolean areGroupsCollapsible;
        @SerializedName("fromPlaceholder")
        @Nullable
        private final String fromPlaceholder;
        @SerializedName("fromValueFormat")
        @Nullable
        private final String fromValueFormat;
        @SerializedName("groups")
        @Nullable
        private final List<OptionsGroup> groups;
        @SerializedName("nextAction")
        @Nullable
        private final NextAction nextAction;
        @SerializedName("resetDisabled")
        @Nullable
        private final Boolean resetDisabled;
        @SerializedName("size")
        @Nullable
        private final WidgetSize size;
        @SerializedName("sortDirection")
        @Nullable
        private final SortDirection sortDirection;
        @SerializedName("thousandsSeparator")
        @Nullable
        private final String thousandsSeparator;
        @SerializedName("toPlaceholder")
        @Nullable
        private final String toPlaceholder;
        @SerializedName("toValueFormat")
        @Nullable
        private final String toValueFormat;
        @SerializedName("withBackButton")
        @Nullable
        private final Boolean withBackButton;
        @SerializedName("withImages")
        @Nullable
        private final Boolean withImages;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Config> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Config createFromParcel(@NotNull Parcel parcel) {
                ArrayList arrayList;
                Boolean bool;
                Boolean bool2;
                Boolean bool3;
                Boolean bool4;
                Intrinsics.checkNotNullParameter(parcel, "in");
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                String readString3 = parcel.readString();
                String readString4 = parcel.readString();
                String readString5 = parcel.readString();
                if (parcel.readInt() != 0) {
                    int readInt = parcel.readInt();
                    arrayList = new ArrayList(readInt);
                    while (readInt != 0) {
                        arrayList.add(OptionsGroup.CREATOR.createFromParcel(parcel));
                        readInt--;
                    }
                } else {
                    arrayList = null;
                }
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
                    bool3 = Boolean.valueOf(parcel.readInt() != 0);
                } else {
                    bool3 = null;
                }
                WidgetSize widgetSize = parcel.readInt() != 0 ? (WidgetSize) Enum.valueOf(WidgetSize.class, parcel.readString()) : null;
                NextAction createFromParcel = parcel.readInt() != 0 ? NextAction.CREATOR.createFromParcel(parcel) : null;
                if (parcel.readInt() != 0) {
                    if (parcel.readInt() == 0) {
                        z = false;
                    }
                    bool4 = Boolean.valueOf(z);
                } else {
                    bool4 = null;
                }
                return new Config(readString, readString2, readString3, readString4, readString5, arrayList, bool, bool2, bool3, widgetSize, createFromParcel, bool4, parcel.readInt() != 0 ? (SortDirection) Enum.valueOf(SortDirection.class, parcel.readString()) : null);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Config[] newArray(int i) {
                return new Config[i];
            }
        }

        public Config() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, null, 8191, null);
        }

        public Config(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable List<OptionsGroup> list, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable WidgetSize widgetSize, @Nullable NextAction nextAction2, @Nullable Boolean bool4, @Nullable SortDirection sortDirection2) {
            this.toPlaceholder = str;
            this.fromPlaceholder = str2;
            this.toValueFormat = str3;
            this.fromValueFormat = str4;
            this.thousandsSeparator = str5;
            this.groups = list;
            this.areGroupsCollapsible = bool;
            this.resetDisabled = bool2;
            this.withBackButton = bool3;
            this.size = widgetSize;
            this.nextAction = nextAction2;
            this.withImages = bool4;
            this.sortDirection = sortDirection2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Nullable
        public final Boolean getAreGroupsCollapsible() {
            return this.areGroupsCollapsible;
        }

        @Nullable
        public final String getFromPlaceholder() {
            return this.fromPlaceholder;
        }

        @Nullable
        public final String getFromValueFormat() {
            return this.fromValueFormat;
        }

        @Nullable
        public final List<OptionsGroup> getGroups() {
            return this.groups;
        }

        @Nullable
        public final NextAction getNextAction() {
            return this.nextAction;
        }

        @Nullable
        public final Boolean getResetDisabled() {
            return this.resetDisabled;
        }

        @Nullable
        public final WidgetSize getSize() {
            return this.size;
        }

        @Nullable
        public final SortDirection getSortDirection() {
            return this.sortDirection;
        }

        @Nullable
        public final String getThousandsSeparator() {
            return this.thousandsSeparator;
        }

        @Nullable
        public final String getToPlaceholder() {
            return this.toPlaceholder;
        }

        @Nullable
        public final String getToValueFormat() {
            return this.toValueFormat;
        }

        @Nullable
        public final Boolean getWithBackButton() {
            return this.withBackButton;
        }

        @Nullable
        public final Boolean getWithImages() {
            return this.withImages;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.toPlaceholder);
            parcel.writeString(this.fromPlaceholder);
            parcel.writeString(this.toValueFormat);
            parcel.writeString(this.fromValueFormat);
            parcel.writeString(this.thousandsSeparator);
            List<OptionsGroup> list = this.groups;
            if (list != null) {
                Iterator l0 = a.l0(parcel, 1, list);
                while (l0.hasNext()) {
                    ((OptionsGroup) l0.next()).writeToParcel(parcel, 0);
                }
            } else {
                parcel.writeInt(0);
            }
            Boolean bool = this.areGroupsCollapsible;
            if (bool != null) {
                a.G0(parcel, 1, bool);
            } else {
                parcel.writeInt(0);
            }
            Boolean bool2 = this.resetDisabled;
            if (bool2 != null) {
                a.G0(parcel, 1, bool2);
            } else {
                parcel.writeInt(0);
            }
            Boolean bool3 = this.withBackButton;
            if (bool3 != null) {
                a.G0(parcel, 1, bool3);
            } else {
                parcel.writeInt(0);
            }
            WidgetSize widgetSize = this.size;
            if (widgetSize != null) {
                parcel.writeInt(1);
                parcel.writeString(widgetSize.name());
            } else {
                parcel.writeInt(0);
            }
            NextAction nextAction2 = this.nextAction;
            if (nextAction2 != null) {
                parcel.writeInt(1);
                nextAction2.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            Boolean bool4 = this.withImages;
            if (bool4 != null) {
                a.G0(parcel, 1, bool4);
            } else {
                parcel.writeInt(0);
            }
            SortDirection sortDirection2 = this.sortDirection;
            if (sortDirection2 != null) {
                parcel.writeInt(1);
                parcel.writeString(sortDirection2.name());
                return;
            }
            parcel.writeInt(0);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Config(String str, String str2, String str3, String str4, String str5, List list, Boolean bool, Boolean bool2, Boolean bool3, WidgetSize widgetSize, NextAction nextAction2, Boolean bool4, SortDirection sortDirection2, int i, j jVar) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : list, (i & 64) != 0 ? null : bool, (i & 128) != 0 ? null : bool2, (i & 256) != 0 ? null : bool3, (i & 512) != 0 ? null : widgetSize, (i & 1024) != 0 ? null : nextAction2, (i & 2048) != 0 ? Boolean.FALSE : bool4, (i & 4096) == 0 ? sortDirection2 : null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<Filter> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Filter createFromParcel(@NotNull Parcel parcel) {
            Boolean bool;
            Intrinsics.checkNotNullParameter(parcel, "in");
            ArrayList arrayList = null;
            Integer valueOf = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            String readString = parcel.readString();
            Widget createFromParcel = parcel.readInt() != 0 ? Widget.CREATOR.createFromParcel(parcel) : null;
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            if (parcel.readInt() != 0) {
                bool = Boolean.valueOf(parcel.readInt() != 0);
            } else {
                bool = null;
            }
            InlineFilterValue inlineFilterValue = (InlineFilterValue) parcel.readParcelable(Filter.class.getClassLoader());
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add(InnerOptions.CREATOR.createFromParcel(parcel));
                    readInt--;
                }
            }
            return new Filter(valueOf, readString, createFromParcel, readString2, readString3, bool, inlineFilterValue, arrayList, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Filter[] newArray(int i) {
            return new Filter[i];
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u0002\u001d\u001eB+\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR$\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001f"}, d2 = {"Lcom/avito/android/remote/model/search/Filter$InnerOptions;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "Lcom/avito/android/remote/model/search/Filter$InnerOptions$Options;", "options", "Ljava/util/List;", "getOptions", "()Ljava/util/List;", "", "default", "Ljava/lang/Boolean;", "getDefault", "()Ljava/lang/Boolean;", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;)V", "Options", "State", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class InnerOptions implements Parcelable {
        public static final Parcelable.Creator<InnerOptions> CREATOR = new Creator();
        @SerializedName("default")
        @Nullable

        /* renamed from: default  reason: not valid java name */
        private final Boolean f8default;
        @SerializedName("options")
        @Nullable
        private final List<Options> options;
        @SerializedName("title")
        @Nullable
        private final String title;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<InnerOptions> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final InnerOptions createFromParcel(@NotNull Parcel parcel) {
                ArrayList arrayList;
                Intrinsics.checkNotNullParameter(parcel, "in");
                String readString = parcel.readString();
                Boolean bool = null;
                if (parcel.readInt() != 0) {
                    int readInt = parcel.readInt();
                    arrayList = new ArrayList(readInt);
                    while (readInt != 0) {
                        arrayList.add(Options.CREATOR.createFromParcel(parcel));
                        readInt--;
                    }
                } else {
                    arrayList = null;
                }
                if (parcel.readInt() != 0) {
                    bool = Boolean.valueOf(parcel.readInt() != 0);
                }
                return new InnerOptions(readString, arrayList, bool);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final InnerOptions[] newArray(int i) {
                return new InnerOptions[i];
            }
        }

        @Parcelize
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001BG\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u0014R\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0012\u001a\u0004\b\u001d\u0010\u0014R\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u0012\u001a\u0004\b\u001f\u0010\u0014¨\u0006\""}, d2 = {"Lcom/avito/android/remote/model/search/Filter$InnerOptions$Options;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/Image;", "image", "Lcom/avito/android/remote/model/Image;", "getImage", "()Lcom/avito/android/remote/model/Image;", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/search/Filter$InnerOptions$State;", "newState", "Lcom/avito/android/remote/model/search/Filter$InnerOptions$State;", "getNewState", "()Lcom/avito/android/remote/model/search/Filter$InnerOptions$State;", MessengerShareContentUtility.SUBTITLE, "getSubtitle", "sortParam", "getSortParam", "title", "getTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/search/Filter$InnerOptions$State;Lcom/avito/android/remote/model/Image;Ljava/lang/String;)V", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Options implements Parcelable {
            public static final Parcelable.Creator<Options> CREATOR = new Creator();
            @SerializedName("id")
            @Nullable
            private final String id;
            @SerializedName("images")
            @Nullable
            private final Image image;
            @SerializedName("newState")
            @Nullable
            private final State newState;
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
            public static class Creator implements Parcelable.Creator<Options> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Options createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    return new Options(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? State.CREATOR.createFromParcel(parcel) : null, (Image) parcel.readParcelable(Options.class.getClassLoader()), parcel.readString());
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Options[] newArray(int i) {
                    return new Options[i];
                }
            }

            public Options(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable State state, @Nullable Image image2, @Nullable String str4) {
                this.id = str;
                this.title = str2;
                this.subtitle = str3;
                this.newState = state;
                this.image = image2;
                this.sortParam = str4;
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Nullable
            public final String getId() {
                return this.id;
            }

            @Nullable
            public final Image getImage() {
                return this.image;
            }

            @Nullable
            public final State getNewState() {
                return this.newState;
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
                parcel.writeString(this.id);
                parcel.writeString(this.title);
                parcel.writeString(this.subtitle);
                State state = this.newState;
                if (state != null) {
                    parcel.writeInt(1);
                    state.writeToParcel(parcel, 0);
                } else {
                    parcel.writeInt(0);
                }
                parcel.writeParcelable(this.image, i);
                parcel.writeString(this.sortParam);
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Options(String str, String str2, String str3, State state, Image image2, String str4, int i, j jVar) {
                this(str, str2, str3, state, (i & 16) != 0 ? null : image2, (i & 32) != 0 ? null : str4);
            }
        }

        @Parcelize
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000eR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/avito/android/remote/model/search/Filter$InnerOptions$State;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "isHighlighted", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "", "displayTitle", "Ljava/lang/String;", "getDisplayTitle", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class State implements Parcelable {
            public static final Parcelable.Creator<State> CREATOR = new Creator();
            @SerializedName("displayTitle")
            @Nullable
            private final String displayTitle;
            @SerializedName("isHighlighted")
            @Nullable
            private final Boolean isHighlighted;

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<State> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final State createFromParcel(@NotNull Parcel parcel) {
                    Boolean bool;
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    String readString = parcel.readString();
                    if (parcel.readInt() != 0) {
                        bool = Boolean.valueOf(parcel.readInt() != 0);
                    } else {
                        bool = null;
                    }
                    return new State(readString, bool);
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final State[] newArray(int i) {
                    return new State[i];
                }
            }

            public State(@Nullable String str, @Nullable Boolean bool) {
                this.displayTitle = str;
                this.isHighlighted = bool;
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Nullable
            public final String getDisplayTitle() {
                return this.displayTitle;
            }

            @Nullable
            public final Boolean isHighlighted() {
                return this.isHighlighted;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(@NotNull Parcel parcel, int i) {
                boolean z;
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.writeString(this.displayTitle);
                Boolean bool = this.isHighlighted;
                if (bool != null) {
                    parcel.writeInt(1);
                    z = bool.booleanValue();
                } else {
                    z = false;
                }
                int i2 = z ? 1 : 0;
                int i3 = z ? 1 : 0;
                int i4 = z ? 1 : 0;
                parcel.writeInt(i2);
            }
        }

        public InnerOptions(@Nullable String str, @Nullable List<Options> list, @Nullable Boolean bool) {
            this.title = str;
            this.options = list;
            this.f8default = bool;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Nullable
        public final Boolean getDefault() {
            return this.f8default;
        }

        @Nullable
        public final List<Options> getOptions() {
            return this.options;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.title);
            List<Options> list = this.options;
            if (list != null) {
                Iterator l0 = a.l0(parcel, 1, list);
                while (l0.hasNext()) {
                    ((Options) l0.next()).writeToParcel(parcel, 0);
                }
            } else {
                parcel.writeInt(0);
            }
            Boolean bool = this.f8default;
            if (bool != null) {
                a.G0(parcel, 1, bool);
            } else {
                parcel.writeInt(0);
            }
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/avito/android/remote/model/search/Filter$NextAction;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/search/NextActionType;", "type", "Lcom/avito/android/remote/model/search/NextActionType;", "getType", "()Lcom/avito/android/remote/model/search/NextActionType;", "", "focusField", "Ljava/lang/String;", "getFocusField", "()Ljava/lang/String;", "<init>", "(Lcom/avito/android/remote/model/search/NextActionType;Ljava/lang/String;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class NextAction implements Parcelable {
        public static final Parcelable.Creator<NextAction> CREATOR = new Creator();
        @SerializedName("focusField")
        @Nullable
        private final String focusField;
        @SerializedName("type")
        @Nullable
        private final NextActionType type;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<NextAction> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final NextAction createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new NextAction(parcel.readInt() != 0 ? (NextActionType) Enum.valueOf(NextActionType.class, parcel.readString()) : null, parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final NextAction[] newArray(int i) {
                return new NextAction[i];
            }
        }

        public NextAction() {
            this(null, null, 3, null);
        }

        public NextAction(@Nullable NextActionType nextActionType, @Nullable String str) {
            this.type = nextActionType;
            this.focusField = str;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Nullable
        public final String getFocusField() {
            return this.focusField;
        }

        @Nullable
        public final NextActionType getType() {
            return this.type;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            NextActionType nextActionType = this.type;
            if (nextActionType != null) {
                parcel.writeInt(1);
                parcel.writeString(nextActionType.name());
            } else {
                parcel.writeInt(0);
            }
            parcel.writeString(this.focusField);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ NextAction(NextActionType nextActionType, String str, int i, j jVar) {
            this((i & 1) != 0 ? null : nextActionType, (i & 2) != 0 ? null : str);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B!\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\"\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/avito/android/remote/model/search/Filter$OptionsGroup;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "", "groupIds", "Ljava/util/List;", "getGroupIds", "()Ljava/util/List;", "groupTitle", "Ljava/lang/String;", "getGroupTitle", "()Ljava/lang/String;", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class OptionsGroup implements Parcelable {
        public static final Parcelable.Creator<OptionsGroup> CREATOR = new Creator();
        @SerializedName("groupIds")
        @NotNull
        private final List<String> groupIds;
        @SerializedName("groupTitle")
        @Nullable
        private final String groupTitle;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<OptionsGroup> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final OptionsGroup createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new OptionsGroup(parcel.createStringArrayList(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final OptionsGroup[] newArray(int i) {
                return new OptionsGroup[i];
            }
        }

        public OptionsGroup(@NotNull List<String> list, @Nullable String str) {
            Intrinsics.checkNotNullParameter(list, "groupIds");
            this.groupIds = list;
            this.groupTitle = str;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        public final List<String> getGroupIds() {
            return this.groupIds;
        }

        @Nullable
        public final String getGroupTitle() {
            return this.groupTitle;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeStringList(this.groupIds);
            parcel.writeString(this.groupTitle);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ OptionsGroup(List list, String str, int i, j jVar) {
            this(list, (i & 2) != 0 ? null : str);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\b\b\u0018\u00002\u00020\u0001BA\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b1\u00102J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010JL\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0007J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001e\u001a\u00020\u000e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b \u0010\u001bJ \u0010%\u001a\u00020$2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b%\u0010&R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010'\u001a\u0004\b(\u0010\u0004R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010)\u001a\u0004\b*\u0010\u0007R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010+\u001a\u0004\b,\u0010\rR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010-\u001a\u0004\b.\u0010\nR\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010/\u001a\u0004\b0\u0010\u0010¨\u00063"}, d2 = {"Lcom/avito/android/remote/model/search/Filter$Widget;", "Landroid/os/Parcelable;", "Lcom/avito/android/remote/model/search/WidgetType;", "component1", "()Lcom/avito/android/remote/model/search/WidgetType;", "", "component2", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/search/Filter$Config;", "component3", "()Lcom/avito/android/remote/model/search/Filter$Config;", "Lcom/avito/android/remote/model/search/TooltipInfo;", "component4", "()Lcom/avito/android/remote/model/search/TooltipInfo;", "", "component5", "()Ljava/lang/Boolean;", "type", "format", Navigation.CONFIG, "tooltip", "resetDisabled", "copy", "(Lcom/avito/android/remote/model/search/WidgetType;Ljava/lang/String;Lcom/avito/android/remote/model/search/Filter$Config;Lcom/avito/android/remote/model/search/TooltipInfo;Ljava/lang/Boolean;)Lcom/avito/android/remote/model/search/Filter$Widget;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/search/WidgetType;", "getType", "Ljava/lang/String;", "getFormat", "Lcom/avito/android/remote/model/search/TooltipInfo;", "getTooltip", "Lcom/avito/android/remote/model/search/Filter$Config;", "getConfig", "Ljava/lang/Boolean;", "getResetDisabled", "<init>", "(Lcom/avito/android/remote/model/search/WidgetType;Ljava/lang/String;Lcom/avito/android/remote/model/search/Filter$Config;Lcom/avito/android/remote/model/search/TooltipInfo;Ljava/lang/Boolean;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Widget implements Parcelable {
        public static final Parcelable.Creator<Widget> CREATOR = new Creator();
        @SerializedName(Navigation.CONFIG)
        @Nullable
        private final Config config;
        @SerializedName("format")
        @Nullable
        private final String format;
        @SerializedName("resetDisabled")
        @Nullable
        private final Boolean resetDisabled;
        @SerializedName("tooltip")
        @Nullable
        private final TooltipInfo tooltip;
        @SerializedName("type")
        @Nullable
        private final WidgetType type;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Widget> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Widget createFromParcel(@NotNull Parcel parcel) {
                Boolean bool;
                Intrinsics.checkNotNullParameter(parcel, "in");
                WidgetType widgetType = parcel.readInt() != 0 ? (WidgetType) Enum.valueOf(WidgetType.class, parcel.readString()) : null;
                String readString = parcel.readString();
                Config createFromParcel = parcel.readInt() != 0 ? Config.CREATOR.createFromParcel(parcel) : null;
                TooltipInfo createFromParcel2 = parcel.readInt() != 0 ? TooltipInfo.CREATOR.createFromParcel(parcel) : null;
                if (parcel.readInt() != 0) {
                    bool = Boolean.valueOf(parcel.readInt() != 0);
                } else {
                    bool = null;
                }
                return new Widget(widgetType, readString, createFromParcel, createFromParcel2, bool);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Widget[] newArray(int i) {
                return new Widget[i];
            }
        }

        public Widget(@Nullable WidgetType widgetType, @Nullable String str, @Nullable Config config2, @Nullable TooltipInfo tooltipInfo, @Nullable Boolean bool) {
            this.type = widgetType;
            this.format = str;
            this.config = config2;
            this.tooltip = tooltipInfo;
            this.resetDisabled = bool;
        }

        public static /* synthetic */ Widget copy$default(Widget widget, WidgetType widgetType, String str, Config config2, TooltipInfo tooltipInfo, Boolean bool, int i, Object obj) {
            if ((i & 1) != 0) {
                widgetType = widget.type;
            }
            if ((i & 2) != 0) {
                str = widget.format;
            }
            if ((i & 4) != 0) {
                config2 = widget.config;
            }
            if ((i & 8) != 0) {
                tooltipInfo = widget.tooltip;
            }
            if ((i & 16) != 0) {
                bool = widget.resetDisabled;
            }
            return widget.copy(widgetType, str, config2, tooltipInfo, bool);
        }

        @Nullable
        public final WidgetType component1() {
            return this.type;
        }

        @Nullable
        public final String component2() {
            return this.format;
        }

        @Nullable
        public final Config component3() {
            return this.config;
        }

        @Nullable
        public final TooltipInfo component4() {
            return this.tooltip;
        }

        @Nullable
        public final Boolean component5() {
            return this.resetDisabled;
        }

        @NotNull
        public final Widget copy(@Nullable WidgetType widgetType, @Nullable String str, @Nullable Config config2, @Nullable TooltipInfo tooltipInfo, @Nullable Boolean bool) {
            return new Widget(widgetType, str, config2, tooltipInfo, bool);
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
            if (!(obj instanceof Widget)) {
                return false;
            }
            Widget widget = (Widget) obj;
            return Intrinsics.areEqual(this.type, widget.type) && Intrinsics.areEqual(this.format, widget.format) && Intrinsics.areEqual(this.config, widget.config) && Intrinsics.areEqual(this.tooltip, widget.tooltip) && Intrinsics.areEqual(this.resetDisabled, widget.resetDisabled);
        }

        @Nullable
        public final Config getConfig() {
            return this.config;
        }

        @Nullable
        public final String getFormat() {
            return this.format;
        }

        @Nullable
        public final Boolean getResetDisabled() {
            return this.resetDisabled;
        }

        @Nullable
        public final TooltipInfo getTooltip() {
            return this.tooltip;
        }

        @Nullable
        public final WidgetType getType() {
            return this.type;
        }

        @Override // java.lang.Object
        public int hashCode() {
            WidgetType widgetType = this.type;
            int i = 0;
            int hashCode = (widgetType != null ? widgetType.hashCode() : 0) * 31;
            String str = this.format;
            int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
            Config config2 = this.config;
            int hashCode3 = (hashCode2 + (config2 != null ? config2.hashCode() : 0)) * 31;
            TooltipInfo tooltipInfo = this.tooltip;
            int hashCode4 = (hashCode3 + (tooltipInfo != null ? tooltipInfo.hashCode() : 0)) * 31;
            Boolean bool = this.resetDisabled;
            if (bool != null) {
                i = bool.hashCode();
            }
            return hashCode4 + i;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("Widget(type=");
            L.append(this.type);
            L.append(", format=");
            L.append(this.format);
            L.append(", config=");
            L.append(this.config);
            L.append(", tooltip=");
            L.append(this.tooltip);
            L.append(", resetDisabled=");
            return a.o(L, this.resetDisabled, ")");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            WidgetType widgetType = this.type;
            if (widgetType != null) {
                parcel.writeInt(1);
                parcel.writeString(widgetType.name());
            } else {
                parcel.writeInt(0);
            }
            parcel.writeString(this.format);
            Config config2 = this.config;
            if (config2 != null) {
                parcel.writeInt(1);
                config2.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            TooltipInfo tooltipInfo = this.tooltip;
            if (tooltipInfo != null) {
                parcel.writeInt(1);
                tooltipInfo.writeToParcel(parcel, 0);
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

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Widget(WidgetType widgetType, String str, Config config2, TooltipInfo tooltipInfo, Boolean bool, int i, j jVar) {
            this(widgetType, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : config2, (i & 8) != 0 ? null : tooltipInfo, (i & 16) != 0 ? null : bool);
        }
    }

    public Filter(@Nullable Integer num, @Nullable String str, @Nullable Widget widget2, @Nullable String str2, @Nullable String str3, @Nullable Boolean bool, @Nullable InlineFilterValue inlineFilterValue, @Nullable List<InnerOptions> list, @Nullable String str4) {
        this.attrId = num;
        this.id = str;
        this.widget = widget2;
        this.title = str2;
        this.displayTitle = str3;
        this.isHighlighted = bool;
        this.value = inlineFilterValue;
        this.options = list;
        this.changedParamType = str4;
    }

    public static /* synthetic */ Filter copy$default(Filter filter, Integer num, String str, Widget widget2, String str2, String str3, Boolean bool, InlineFilterValue inlineFilterValue, List list, String str4, int i, Object obj) {
        return filter.copy((i & 1) != 0 ? filter.attrId : num, (i & 2) != 0 ? filter.id : str, (i & 4) != 0 ? filter.widget : widget2, (i & 8) != 0 ? filter.title : str2, (i & 16) != 0 ? filter.displayTitle : str3, (i & 32) != 0 ? filter.isHighlighted : bool, (i & 64) != 0 ? filter.value : inlineFilterValue, (i & 128) != 0 ? filter.options : list, (i & 256) != 0 ? filter.changedParamType : str4);
    }

    @Nullable
    public final Integer component1() {
        return this.attrId;
    }

    @Nullable
    public final String component2() {
        return this.id;
    }

    @Nullable
    public final Widget component3() {
        return this.widget;
    }

    @Nullable
    public final String component4() {
        return this.title;
    }

    @Nullable
    public final String component5() {
        return this.displayTitle;
    }

    @Nullable
    public final Boolean component6() {
        return this.isHighlighted;
    }

    @Nullable
    public final InlineFilterValue component7() {
        return this.value;
    }

    @Nullable
    public final List<InnerOptions> component8() {
        return this.options;
    }

    @Nullable
    public final String component9() {
        return this.changedParamType;
    }

    @NotNull
    public final Filter copy(@Nullable Integer num, @Nullable String str, @Nullable Widget widget2, @Nullable String str2, @Nullable String str3, @Nullable Boolean bool, @Nullable InlineFilterValue inlineFilterValue, @Nullable List<InnerOptions> list, @Nullable String str4) {
        return new Filter(num, str, widget2, str2, str3, bool, inlineFilterValue, list, str4);
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
        if (!(obj instanceof Filter)) {
            return false;
        }
        Filter filter = (Filter) obj;
        return Intrinsics.areEqual(this.attrId, filter.attrId) && Intrinsics.areEqual(this.id, filter.id) && Intrinsics.areEqual(this.widget, filter.widget) && Intrinsics.areEqual(this.title, filter.title) && Intrinsics.areEqual(this.displayTitle, filter.displayTitle) && Intrinsics.areEqual(this.isHighlighted, filter.isHighlighted) && Intrinsics.areEqual(this.value, filter.value) && Intrinsics.areEqual(this.options, filter.options) && Intrinsics.areEqual(this.changedParamType, filter.changedParamType);
    }

    @Nullable
    public final Integer getAttrId() {
        return this.attrId;
    }

    @Nullable
    public final String getChangedParamType() {
        return this.changedParamType;
    }

    @Nullable
    public final String getDisplayTitle() {
        return this.displayTitle;
    }

    @Nullable
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final List<InnerOptions> getOptions() {
        return this.options;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final InlineFilterValue getValue() {
        return this.value;
    }

    @Nullable
    public final Widget getWidget() {
        return this.widget;
    }

    @Override // java.lang.Object
    public int hashCode() {
        Integer num = this.attrId;
        int i = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        String str = this.id;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        Widget widget2 = this.widget;
        int hashCode3 = (hashCode2 + (widget2 != null ? widget2.hashCode() : 0)) * 31;
        String str2 = this.title;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.displayTitle;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Boolean bool = this.isHighlighted;
        int hashCode6 = (hashCode5 + (bool != null ? bool.hashCode() : 0)) * 31;
        InlineFilterValue inlineFilterValue = this.value;
        int hashCode7 = (hashCode6 + (inlineFilterValue != null ? inlineFilterValue.hashCode() : 0)) * 31;
        List<InnerOptions> list = this.options;
        int hashCode8 = (hashCode7 + (list != null ? list.hashCode() : 0)) * 31;
        String str4 = this.changedParamType;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode8 + i;
    }

    @Nullable
    public final Boolean isHighlighted() {
        return this.isHighlighted;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("Filter(attrId=");
        L.append(this.attrId);
        L.append(", id=");
        L.append(this.id);
        L.append(", widget=");
        L.append(this.widget);
        L.append(", title=");
        L.append(this.title);
        L.append(", displayTitle=");
        L.append(this.displayTitle);
        L.append(", isHighlighted=");
        L.append(this.isHighlighted);
        L.append(", value=");
        L.append(this.value);
        L.append(", options=");
        L.append(this.options);
        L.append(", changedParamType=");
        return a.t(L, this.changedParamType, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        Integer num = this.attrId;
        if (num != null) {
            a.H0(parcel, 1, num);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.id);
        Widget widget2 = this.widget;
        if (widget2 != null) {
            parcel.writeInt(1);
            widget2.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.title);
        parcel.writeString(this.displayTitle);
        Boolean bool = this.isHighlighted;
        if (bool != null) {
            a.G0(parcel, 1, bool);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeParcelable(this.value, i);
        List<InnerOptions> list = this.options;
        if (list != null) {
            Iterator l0 = a.l0(parcel, 1, list);
            while (l0.hasNext()) {
                ((InnerOptions) l0.next()).writeToParcel(parcel, 0);
            }
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.changedParamType);
    }
}
