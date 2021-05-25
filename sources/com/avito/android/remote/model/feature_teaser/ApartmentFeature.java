package com.avito.android.remote.model.feature_teaser;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001:\u0002 !B9\u0012\u0006\u0010\u001c\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0012\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\"\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00128\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\r\u001a\u0004\b\u001d\u0010\u000f¨\u0006\""}, d2 = {"Lcom/avito/android/remote/model/feature_teaser/ApartmentFeature;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "slug", "Ljava/lang/String;", "getSlug", "()Ljava/lang/String;", "actionText", "getActionText", "", "previewOptions", "Ljava/util/List;", "getPreviewOptions", "()Ljava/util/List;", "Lcom/avito/android/remote/model/feature_teaser/ApartmentFeature$ActionInfo;", "actionInfo", "Lcom/avito/android/remote/model/feature_teaser/ApartmentFeature$ActionInfo;", "getActionInfo", "()Lcom/avito/android/remote/model/feature_teaser/ApartmentFeature$ActionInfo;", "title", "getTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/avito/android/remote/model/feature_teaser/ApartmentFeature$ActionInfo;)V", "ActionInfo", "FeatureBloc", "api_release"}, k = 1, mv = {1, 4, 2})
public final class ApartmentFeature implements Parcelable {
    public static final Parcelable.Creator<ApartmentFeature> CREATOR = new Creator();
    @SerializedName("actionInfo")
    @Nullable
    private final ActionInfo actionInfo;
    @SerializedName("actionText")
    @Nullable
    private final String actionText;
    @SerializedName("preview")
    @NotNull
    private final List<String> previewOptions;
    @SerializedName("slug")
    @NotNull
    private final String slug;
    @SerializedName("title")
    @NotNull
    private final String title;

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\"\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u00020\u00118\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/avito/android/remote/model/feature_teaser/ApartmentFeature$ActionInfo;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "Lcom/avito/android/remote/model/feature_teaser/ApartmentFeature$FeatureBloc;", "blocs", "Ljava/util/List;", "getBlocs", "()Ljava/util/List;", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "api_release"}, k = 1, mv = {1, 4, 2})
    public static final class ActionInfo implements Parcelable {
        public static final Parcelable.Creator<ActionInfo> CREATOR = new Creator();
        @SerializedName("list")
        @NotNull
        private final List<FeatureBloc> blocs;
        @SerializedName("title")
        @NotNull
        private final String title;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<ActionInfo> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final ActionInfo createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                String readString = parcel.readString();
                int readInt = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add(FeatureBloc.CREATOR.createFromParcel(parcel));
                    readInt--;
                }
                return new ActionInfo(readString, arrayList);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final ActionInfo[] newArray(int i) {
                return new ActionInfo[i];
            }
        }

        public ActionInfo(@NotNull String str, @NotNull List<FeatureBloc> list) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(list, "blocs");
            this.title = str;
            this.blocs = list;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        public final List<FeatureBloc> getBlocs() {
            return this.blocs;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.title);
            Iterator n0 = a.n0(this.blocs, parcel);
            while (n0.hasNext()) {
                ((FeatureBloc) n0.next()).writeToParcel(parcel, 0);
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<ApartmentFeature> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ApartmentFeature createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new ApartmentFeature(parcel.readString(), parcel.readString(), parcel.createStringArrayList(), parcel.readString(), parcel.readInt() != 0 ? ActionInfo.CREATOR.createFromParcel(parcel) : null);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ApartmentFeature[] newArray(int i) {
            return new ApartmentFeature[i];
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0010¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/avito/android/remote/model/feature_teaser/ApartmentFeature$FeatureBloc;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "", "items", "Ljava/util/List;", "getItems", "()Ljava/util/List;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "api_release"}, k = 1, mv = {1, 4, 2})
    public static final class FeatureBloc implements Parcelable {
        public static final Parcelable.Creator<FeatureBloc> CREATOR = new Creator();
        @SerializedName("list")
        @NotNull
        private final List<String> items;
        @SerializedName("title")
        @NotNull
        private final String title;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<FeatureBloc> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final FeatureBloc createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new FeatureBloc(parcel.readString(), parcel.createStringArrayList());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final FeatureBloc[] newArray(int i) {
                return new FeatureBloc[i];
            }
        }

        public FeatureBloc(@NotNull String str, @NotNull List<String> list) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(list, "items");
            this.title = str;
            this.items = list;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        public final List<String> getItems() {
            return this.items;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.title);
            parcel.writeStringList(this.items);
        }
    }

    public ApartmentFeature(@NotNull String str, @NotNull String str2, @NotNull List<String> list, @Nullable String str3, @Nullable ActionInfo actionInfo2) {
        a.c1(str, "title", str2, "slug", list, "previewOptions");
        this.title = str;
        this.slug = str2;
        this.previewOptions = list;
        this.actionText = str3;
        this.actionInfo = actionInfo2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final ActionInfo getActionInfo() {
        return this.actionInfo;
    }

    @Nullable
    public final String getActionText() {
        return this.actionText;
    }

    @NotNull
    public final List<String> getPreviewOptions() {
        return this.previewOptions;
    }

    @NotNull
    public final String getSlug() {
        return this.slug;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.title);
        parcel.writeString(this.slug);
        parcel.writeStringList(this.previewOptions);
        parcel.writeString(this.actionText);
        ActionInfo actionInfo2 = this.actionInfo;
        if (actionInfo2 != null) {
            parcel.writeInt(1);
            actionInfo2.writeToParcel(parcel, 0);
            return;
        }
        parcel.writeInt(0);
    }
}
