package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.appevents.internal.ViewHierarchyConstants;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001:\u0004\u001f !\"B3\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0016\u0010\u000fR\"\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006#"}, d2 = {"Lcom/avito/android/remote/model/ModelSpecifications;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/ModelSpecifications$Scheme;", "scheme", "Lcom/avito/android/remote/model/ModelSpecifications$Scheme;", "getScheme", "()Lcom/avito/android/remote/model/ModelSpecifications$Scheme;", "modelTitle", "getModelTitle", "", "Lcom/avito/android/remote/model/ModelSpecifications$Block;", "blocks", "Ljava/util/List;", "getBlocks", "()Ljava/util/List;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/ModelSpecifications$Scheme;Ljava/util/List;)V", "Block", "Line", "Parameter", "Scheme", "models_release"}, k = 1, mv = {1, 4, 2})
public final class ModelSpecifications implements Parcelable {
    public static final Parcelable.Creator<ModelSpecifications> CREATOR = new Creator();
    @SerializedName("blocks")
    @NotNull
    private final List<Block> blocks;
    @SerializedName("modelTitle")
    @Nullable
    private final String modelTitle;
    @SerializedName("scheme")
    @Nullable
    private final Scheme scheme;
    @SerializedName("title")
    @Nullable
    private final String title;

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/avito/android/remote/model/ModelSpecifications$Block;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "", "Lcom/avito/android/remote/model/ModelSpecifications$Parameter;", "params", "Ljava/util/List;", "getParams", "()Ljava/util/List;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Block implements Parcelable {
        public static final Parcelable.Creator<Block> CREATOR = new Creator();
        @SerializedName("params")
        @NotNull
        private final List<Parameter> params;
        @SerializedName("title")
        @NotNull
        private final String title;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Block> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Block createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                String readString = parcel.readString();
                int readInt = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add(Parameter.CREATOR.createFromParcel(parcel));
                    readInt--;
                }
                return new Block(readString, arrayList);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Block[] newArray(int i) {
                return new Block[i];
            }
        }

        public Block(@NotNull String str, @NotNull List<Parameter> list) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(list, "params");
            this.title = str;
            this.params = list;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        public final List<Parameter> getParams() {
            return this.params;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.title);
            Iterator n0 = a.n0(this.params, parcel);
            while (n0.hasNext()) {
                ((Parameter) n0.next()).writeToParcel(parcel, 0);
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<ModelSpecifications> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ModelSpecifications createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            Scheme createFromParcel = parcel.readInt() != 0 ? Scheme.CREATOR.createFromParcel(parcel) : null;
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add(Block.CREATOR.createFromParcel(parcel));
                readInt--;
            }
            return new ModelSpecifications(readString, readString2, createFromParcel, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ModelSpecifications[] newArray(int i) {
            return new ModelSpecifications[i];
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0015\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0016\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/avito/android/remote/model/ModelSpecifications$Line;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "to", "F", "getTo", "()F", "", "label", "Ljava/lang/String;", "getLabel", "()Ljava/lang/String;", "from", "getFrom", "<init>", "(Ljava/lang/String;FF)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Line implements Parcelable {
        public static final Parcelable.Creator<Line> CREATOR = new Creator();
        @SerializedName("from")
        private final float from;
        @SerializedName("label")
        @NotNull
        private final String label;
        @SerializedName("to")
        private final float to;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Line> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Line createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Line(parcel.readString(), parcel.readFloat(), parcel.readFloat());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Line[] newArray(int i) {
                return new Line[i];
            }
        }

        public Line(@NotNull String str, float f, float f2) {
            Intrinsics.checkNotNullParameter(str, "label");
            this.label = str;
            this.from = f;
            this.to = f2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public final float getFrom() {
            return this.from;
        }

        @NotNull
        public final String getLabel() {
            return this.label;
        }

        public final float getTo() {
            return this.to;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.label);
            parcel.writeFloat(this.from);
            parcel.writeFloat(this.to);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u00020\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014¨\u0006\u0019"}, d2 = {"Lcom/avito/android/remote/model/ModelSpecifications$Parameter;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "important", "Ljava/lang/Boolean;", "getImportant", "()Ljava/lang/Boolean;", "", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "value", "getValue", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Parameter implements Parcelable {
        public static final Parcelable.Creator<Parameter> CREATOR = new Creator();
        @SerializedName("important")
        @Nullable
        private final Boolean important;
        @SerializedName("name")
        @NotNull
        private final String name;
        @SerializedName("value")
        @NotNull
        private final String value;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Parameter> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Parameter createFromParcel(@NotNull Parcel parcel) {
                Boolean bool;
                Intrinsics.checkNotNullParameter(parcel, "in");
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                if (parcel.readInt() != 0) {
                    bool = Boolean.valueOf(parcel.readInt() != 0);
                } else {
                    bool = null;
                }
                return new Parameter(readString, readString2, bool);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Parameter[] newArray(int i) {
                return new Parameter[i];
            }
        }

        public Parameter(@NotNull String str, @NotNull String str2, @Nullable Boolean bool) {
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(str2, "value");
            this.name = str;
            this.value = str2;
            this.important = bool;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Nullable
        public final Boolean getImportant() {
            return this.important;
        }

        @NotNull
        public final String getName() {
            return this.name;
        }

        @NotNull
        public final String getValue() {
            return this.value;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            boolean z;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.name);
            parcel.writeString(this.value);
            Boolean bool = this.important;
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

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B7\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000fR\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u0015\u0010\u000fR\u001c\u0010\u0017\u001a\u00020\u00168\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/avito/android/remote/model/ModelSpecifications$Scheme;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/ModelSpecifications$Line;", ViewHierarchyConstants.DIMENSION_LEFT_KEY, "Lcom/avito/android/remote/model/ModelSpecifications$Line;", "getLeft", "()Lcom/avito/android/remote/model/ModelSpecifications$Line;", "top", "getTop", "bottom", "getBottom", "right", "getRight", "Lcom/avito/android/remote/model/Image;", "image", "Lcom/avito/android/remote/model/Image;", "getImage", "()Lcom/avito/android/remote/model/Image;", "<init>", "(Lcom/avito/android/remote/model/ModelSpecifications$Line;Lcom/avito/android/remote/model/ModelSpecifications$Line;Lcom/avito/android/remote/model/ModelSpecifications$Line;Lcom/avito/android/remote/model/ModelSpecifications$Line;Lcom/avito/android/remote/model/Image;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Scheme implements Parcelable {
        public static final Parcelable.Creator<Scheme> CREATOR = new Creator();
        @SerializedName("bottom")
        @Nullable
        private final Line bottom;
        @SerializedName("image")
        @NotNull
        private final Image image;
        @SerializedName(ViewHierarchyConstants.DIMENSION_LEFT_KEY)
        @Nullable
        private final Line left;
        @SerializedName("right")
        @Nullable
        private final Line right;
        @SerializedName("top")
        @Nullable
        private final Line top;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Scheme> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Scheme createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Scheme(parcel.readInt() != 0 ? Line.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? Line.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? Line.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? Line.CREATOR.createFromParcel(parcel) : null, (Image) parcel.readParcelable(Scheme.class.getClassLoader()));
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Scheme[] newArray(int i) {
                return new Scheme[i];
            }
        }

        public Scheme(@Nullable Line line, @Nullable Line line2, @Nullable Line line3, @Nullable Line line4, @NotNull Image image2) {
            Intrinsics.checkNotNullParameter(image2, "image");
            this.left = line;
            this.top = line2;
            this.right = line3;
            this.bottom = line4;
            this.image = image2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Nullable
        public final Line getBottom() {
            return this.bottom;
        }

        @NotNull
        public final Image getImage() {
            return this.image;
        }

        @Nullable
        public final Line getLeft() {
            return this.left;
        }

        @Nullable
        public final Line getRight() {
            return this.right;
        }

        @Nullable
        public final Line getTop() {
            return this.top;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            Line line = this.left;
            if (line != null) {
                parcel.writeInt(1);
                line.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            Line line2 = this.top;
            if (line2 != null) {
                parcel.writeInt(1);
                line2.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            Line line3 = this.right;
            if (line3 != null) {
                parcel.writeInt(1);
                line3.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            Line line4 = this.bottom;
            if (line4 != null) {
                parcel.writeInt(1);
                line4.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            parcel.writeParcelable(this.image, i);
        }
    }

    public ModelSpecifications(@Nullable String str, @Nullable String str2, @Nullable Scheme scheme2, @NotNull List<Block> list) {
        Intrinsics.checkNotNullParameter(list, "blocks");
        this.title = str;
        this.modelTitle = str2;
        this.scheme = scheme2;
        this.blocks = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final List<Block> getBlocks() {
        return this.blocks;
    }

    @Nullable
    public final String getModelTitle() {
        return this.modelTitle;
    }

    @Nullable
    public final Scheme getScheme() {
        return this.scheme;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.title);
        parcel.writeString(this.modelTitle);
        Scheme scheme2 = this.scheme;
        if (scheme2 != null) {
            parcel.writeInt(1);
            scheme2.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        Iterator n0 = a.n0(this.blocks, parcel);
        while (n0.hasNext()) {
            ((Block) n0.next()).writeToParcel(parcel, 0);
        }
    }
}
