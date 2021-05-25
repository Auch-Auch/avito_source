package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.deep_linking.links.DeepLink;
import com.facebook.internal.AnalyticsEvents;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u0002!\"B;\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u000b\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\"\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u00020\u00118\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u00020\u00118\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0016\u0010\u0015R\"\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0019\u0010\u0010R\u001c\u0010\u001b\u001a\u00020\u001a8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006#"}, d2 = {"Lcom/avito/android/remote/model/DialogInfo;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "Lcom/avito/android/remote/model/DialogInfo$Control;", "controls", "Ljava/util/List;", "getControls", "()Ljava/util/List;", "", "shouldShowCloseControl", "Z", "getShouldShowCloseControl", "()Z", "isCancellable", "Lcom/avito/android/remote/model/DialogInfo$Content;", "content", "getContent", "", "controlsDirection", "Ljava/lang/String;", "getControlsDirection", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ZZLjava/util/List;Ljava/util/List;)V", "Content", "Control", "async-phone-core_release"}, k = 1, mv = {1, 4, 2})
public final class DialogInfo implements Parcelable {
    public static final Parcelable.Creator<DialogInfo> CREATOR = new Creator();
    @SerializedName("content")
    @NotNull
    private final List<Content> content;
    @SerializedName("controls")
    @NotNull
    private final List<Control> controls;
    @SerializedName("controlsDirection")
    @NotNull
    private final String controlsDirection;
    @SerializedName("isCancellable")
    private final boolean isCancellable;
    @SerializedName("shouldShowCloseControl")
    private final boolean shouldShowCloseControl;

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0012\u001a\u00020\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u001c\u0010\u0012\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/avito/android/remote/model/DialogInfo$Content;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "Ljava/lang/String;", "getStyle", "()Ljava/lang/String;", "text", "getText", "type", "getType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "async-phone-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Content implements Parcelable {
        public static final Parcelable.Creator<Content> CREATOR = new Creator();
        @SerializedName(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE)
        @NotNull
        private final String style;
        @SerializedName("text")
        @NotNull
        private final String text;
        @SerializedName("type")
        @NotNull
        private final String type;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Content> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Content createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Content(parcel.readString(), parcel.readString(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Content[] newArray(int i) {
                return new Content[i];
            }
        }

        public Content(@NotNull String str, @NotNull String str2, @NotNull String str3) {
            a.Z0(str, "type", str2, "text", str3, AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE);
            this.type = str;
            this.text = str2;
            this.style = str3;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        public final String getStyle() {
            return this.style;
        }

        @NotNull
        public final String getText() {
            return this.text;
        }

        @NotNull
        public final String getType() {
            return this.type;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.type);
            parcel.writeString(this.text);
            parcel.writeString(this.style);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0012\u001a\u00020\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u001c\u0010\u0012\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000fR\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/avito/android/remote/model/DialogInfo$Control;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "Ljava/lang/String;", "getStyle", "()Ljava/lang/String;", "title", "getTitle", "type", "getType", "Lcom/avito/android/deep_linking/links/DeepLink;", "action", "Lcom/avito/android/deep_linking/links/DeepLink;", "getAction", "()Lcom/avito/android/deep_linking/links/DeepLink;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;)V", "async-phone-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Control implements Parcelable {
        public static final Parcelable.Creator<Control> CREATOR = new Creator();
        @SerializedName("action")
        @Nullable
        private final DeepLink action;
        @SerializedName(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE)
        @NotNull
        private final String style;
        @SerializedName("title")
        @NotNull
        private final String title;
        @SerializedName("type")
        @NotNull
        private final String type;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Control> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Control createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Control(parcel.readString(), parcel.readString(), parcel.readString(), (DeepLink) parcel.readParcelable(Control.class.getClassLoader()));
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Control[] newArray(int i) {
                return new Control[i];
            }
        }

        public Control(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable DeepLink deepLink) {
            a.Z0(str, "type", str2, "title", str3, AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE);
            this.type = str;
            this.title = str2;
            this.style = str3;
            this.action = deepLink;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Nullable
        public final DeepLink getAction() {
            return this.action;
        }

        @NotNull
        public final String getStyle() {
            return this.style;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        @NotNull
        public final String getType() {
            return this.type;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.type);
            parcel.writeString(this.title);
            parcel.writeString(this.style);
            parcel.writeParcelable(this.action, i);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<DialogInfo> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DialogInfo createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            boolean z = false;
            boolean z2 = parcel.readInt() != 0;
            if (parcel.readInt() != 0) {
                z = true;
            }
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add(Content.CREATOR.createFromParcel(parcel));
                readInt--;
            }
            int readInt2 = parcel.readInt();
            ArrayList arrayList2 = new ArrayList(readInt2);
            while (readInt2 != 0) {
                arrayList2.add(Control.CREATOR.createFromParcel(parcel));
                readInt2--;
            }
            return new DialogInfo(readString, z2, z, arrayList, arrayList2);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DialogInfo[] newArray(int i) {
            return new DialogInfo[i];
        }
    }

    public DialogInfo(@NotNull String str, boolean z, boolean z2, @NotNull List<Content> list, @NotNull List<Control> list2) {
        Intrinsics.checkNotNullParameter(str, "controlsDirection");
        Intrinsics.checkNotNullParameter(list, "content");
        Intrinsics.checkNotNullParameter(list2, "controls");
        this.controlsDirection = str;
        this.isCancellable = z;
        this.shouldShowCloseControl = z2;
        this.content = list;
        this.controls = list2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final List<Content> getContent() {
        return this.content;
    }

    @NotNull
    public final List<Control> getControls() {
        return this.controls;
    }

    @NotNull
    public final String getControlsDirection() {
        return this.controlsDirection;
    }

    public final boolean getShouldShowCloseControl() {
        return this.shouldShowCloseControl;
    }

    public final boolean isCancellable() {
        return this.isCancellable;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.controlsDirection);
        parcel.writeInt(this.isCancellable ? 1 : 0);
        parcel.writeInt(this.shouldShowCloseControl ? 1 : 0);
        Iterator n0 = a.n0(this.content, parcel);
        while (n0.hasNext()) {
            ((Content) n0.next()).writeToParcel(parcel, 0);
        }
        Iterator n02 = a.n0(this.controls, parcel);
        while (n02.hasNext()) {
            ((Control) n02.next()).writeToParcel(parcel, 0);
        }
    }
}
