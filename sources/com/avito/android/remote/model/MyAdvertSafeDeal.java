package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.internal.ShareConstants;
import com.google.common.net.HttpHeaders;
import com.google.gson.annotations.SerializedName;
import com.vk.sdk.api.VKApiConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001:\u0001\u001fB\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0014\u0010\u000eJ \u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001b\u001a\u0004\b\u001c\u0010\u0005¨\u0006 "}, d2 = {"Lcom/avito/android/remote/model/MyAdvertSafeDeal;", "Landroid/os/Parcelable;", "", "Lcom/avito/android/remote/model/MyAdvertSafeDeal$Service;", "component1", "()Ljava/util/List;", VKApiConst.SERVICES, "copy", "(Ljava/util/List;)Lcom/avito/android/remote/model/MyAdvertSafeDeal;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/util/List;", "getServices", "<init>", "(Ljava/util/List;)V", "Service", "models_release"}, k = 1, mv = {1, 4, 2})
public final class MyAdvertSafeDeal implements Parcelable {
    public static final Parcelable.Creator<MyAdvertSafeDeal> CREATOR = new Creator();
    @SerializedName(VKApiConst.SERVICES)
    @NotNull
    private final List<Service> services;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<MyAdvertSafeDeal> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MyAdvertSafeDeal createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add(Service.CREATOR.createFromParcel(parcel));
                readInt--;
            }
            return new MyAdvertSafeDeal(arrayList);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MyAdvertSafeDeal[] newArray(int i) {
            return new MyAdvertSafeDeal[i];
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001:\u0002$%B\u0019\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\"\u0010#J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0011J \u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u001e\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R\u001c\u0010\t\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010 \u001a\u0004\b!\u0010\u0007¨\u0006&"}, d2 = {"Lcom/avito/android/remote/model/MyAdvertSafeDeal$Service;", "Landroid/os/Parcelable;", "Lcom/avito/android/remote/model/MyAdvertSafeDeal$Service$Type;", "component1", "()Lcom/avito/android/remote/model/MyAdvertSafeDeal$Service$Type;", "Lcom/avito/android/remote/model/MyAdvertSafeDeal$Service$Content;", "component2", "()Lcom/avito/android/remote/model/MyAdvertSafeDeal$Service$Content;", "type", "content", "copy", "(Lcom/avito/android/remote/model/MyAdvertSafeDeal$Service$Type;Lcom/avito/android/remote/model/MyAdvertSafeDeal$Service$Content;)Lcom/avito/android/remote/model/MyAdvertSafeDeal$Service;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/MyAdvertSafeDeal$Service$Type;", "getType", "Lcom/avito/android/remote/model/MyAdvertSafeDeal$Service$Content;", "getContent", "<init>", "(Lcom/avito/android/remote/model/MyAdvertSafeDeal$Service$Type;Lcom/avito/android/remote/model/MyAdvertSafeDeal$Service$Content;)V", "Content", "Type", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Service implements Parcelable {
        public static final Parcelable.Creator<Service> CREATOR = new Creator();
        @SerializedName("content")
        @NotNull
        private final Content content;
        @SerializedName("type")
        @Nullable
        private final Type type;

        @Parcelize
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\b\b\u0018\u00002\u00020\u0001:\u0002/0B5\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b-\u0010.J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJH\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00062\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0019J \u0010#\u001a\u00020\"2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b#\u0010$R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010%\u001a\u0004\b&\u0010\u0004R\u001c\u0010\u0010\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010%\u001a\u0004\b'\u0010\u0004R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010(\u001a\u0004\b)\u0010\u000bR\u001c\u0010\u0011\u001a\u00020\u00068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010*\u001a\u0004\b+\u0010\bR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010,\u001a\u0004\b\u0013\u0010\u000e¨\u00061"}, d2 = {"Lcom/avito/android/remote/model/MyAdvertSafeDeal$Service$Content;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component2", "Lcom/avito/android/remote/model/MyAdvertSafeDeal$Service$Content$Link;", "component3", "()Lcom/avito/android/remote/model/MyAdvertSafeDeal$Service$Content$Link;", "Lcom/avito/android/remote/model/MyAdvertSafeDeal$Service$Content$Icon;", "component4", "()Lcom/avito/android/remote/model/MyAdvertSafeDeal$Service$Content$Icon;", "", "component5", "()Ljava/lang/Boolean;", "id", "title", "link", "icon", "isSwitchOn", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/MyAdvertSafeDeal$Service$Content$Link;Lcom/avito/android/remote/model/MyAdvertSafeDeal$Service$Content$Icon;Ljava/lang/Boolean;)Lcom/avito/android/remote/model/MyAdvertSafeDeal$Service$Content;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getId", "getTitle", "Lcom/avito/android/remote/model/MyAdvertSafeDeal$Service$Content$Icon;", "getIcon", "Lcom/avito/android/remote/model/MyAdvertSafeDeal$Service$Content$Link;", "getLink", "Ljava/lang/Boolean;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/MyAdvertSafeDeal$Service$Content$Link;Lcom/avito/android/remote/model/MyAdvertSafeDeal$Service$Content$Icon;Ljava/lang/Boolean;)V", "Icon", HttpHeaders.LINK, "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Content implements Parcelable {
            public static final Parcelable.Creator<Content> CREATOR = new Creator();
            @SerializedName("icon")
            @Nullable
            private final Icon icon;
            @SerializedName("id")
            @Nullable
            private final String id;
            @SerializedName("isSwitchOn")
            @Nullable
            private final Boolean isSwitchOn;
            @SerializedName("link")
            @NotNull
            private final Link link;
            @SerializedName("title")
            @NotNull
            private final String title;

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<Content> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Content createFromParcel(@NotNull Parcel parcel) {
                    Boolean bool;
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    String readString = parcel.readString();
                    String readString2 = parcel.readString();
                    Link createFromParcel = Link.CREATOR.createFromParcel(parcel);
                    Icon icon = parcel.readInt() != 0 ? (Icon) Enum.valueOf(Icon.class, parcel.readString()) : null;
                    if (parcel.readInt() != 0) {
                        bool = Boolean.valueOf(parcel.readInt() != 0);
                    } else {
                        bool = null;
                    }
                    return new Content(readString, readString2, createFromParcel, icon, bool);
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Content[] newArray(int i) {
                    return new Content[i];
                }
            }

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/MyAdvertSafeDeal$Service$Content$Icon;", "", "<init>", "(Ljava/lang/String;I)V", "DELIVERY", "DELIVERY_COURIER", "SAFE_PAYMENT", "DELIVERY_UNAVAILABLE", "models_release"}, k = 1, mv = {1, 4, 2})
            public enum Icon {
                DELIVERY,
                DELIVERY_COURIER,
                SAFE_PAYMENT,
                DELIVERY_UNAVAILABLE
            }

            @Parcelize
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u000fJ \u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u001c\u0010\t\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u001c\u001a\u0004\b\u001d\u0010\u0007R\u001c\u0010\b\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004¨\u0006\""}, d2 = {"Lcom/avito/android/remote/model/MyAdvertSafeDeal$Service$Content$Link;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "Landroid/net/Uri;", "component2", "()Landroid/net/Uri;", "text", ShareConstants.MEDIA_URI, "copy", "(Ljava/lang/String;Landroid/net/Uri;)Lcom/avito/android/remote/model/MyAdvertSafeDeal$Service$Content$Link;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Landroid/net/Uri;", "getUri", "Ljava/lang/String;", "getText", "<init>", "(Ljava/lang/String;Landroid/net/Uri;)V", "models_release"}, k = 1, mv = {1, 4, 2})
            public static final class Link implements Parcelable {
                public static final Parcelable.Creator<Link> CREATOR = new Creator();
                @SerializedName("text")
                @NotNull
                private final String text;
                @SerializedName("url")
                @NotNull
                private final Uri uri;

                @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
                public static class Creator implements Parcelable.Creator<Link> {
                    @Override // android.os.Parcelable.Creator
                    @NotNull
                    public final Link createFromParcel(@NotNull Parcel parcel) {
                        Intrinsics.checkNotNullParameter(parcel, "in");
                        return new Link(parcel.readString(), (Uri) parcel.readParcelable(Link.class.getClassLoader()));
                    }

                    @Override // android.os.Parcelable.Creator
                    @NotNull
                    public final Link[] newArray(int i) {
                        return new Link[i];
                    }
                }

                public Link(@NotNull String str, @NotNull Uri uri2) {
                    Intrinsics.checkNotNullParameter(str, "text");
                    Intrinsics.checkNotNullParameter(uri2, ShareConstants.MEDIA_URI);
                    this.text = str;
                    this.uri = uri2;
                }

                public static /* synthetic */ Link copy$default(Link link, String str, Uri uri2, int i, Object obj) {
                    if ((i & 1) != 0) {
                        str = link.text;
                    }
                    if ((i & 2) != 0) {
                        uri2 = link.uri;
                    }
                    return link.copy(str, uri2);
                }

                @NotNull
                public final String component1() {
                    return this.text;
                }

                @NotNull
                public final Uri component2() {
                    return this.uri;
                }

                @NotNull
                public final Link copy(@NotNull String str, @NotNull Uri uri2) {
                    Intrinsics.checkNotNullParameter(str, "text");
                    Intrinsics.checkNotNullParameter(uri2, ShareConstants.MEDIA_URI);
                    return new Link(str, uri2);
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
                    if (!(obj instanceof Link)) {
                        return false;
                    }
                    Link link = (Link) obj;
                    return Intrinsics.areEqual(this.text, link.text) && Intrinsics.areEqual(this.uri, link.uri);
                }

                @NotNull
                public final String getText() {
                    return this.text;
                }

                @NotNull
                public final Uri getUri() {
                    return this.uri;
                }

                @Override // java.lang.Object
                public int hashCode() {
                    String str = this.text;
                    int i = 0;
                    int hashCode = (str != null ? str.hashCode() : 0) * 31;
                    Uri uri2 = this.uri;
                    if (uri2 != null) {
                        i = uri2.hashCode();
                    }
                    return hashCode + i;
                }

                @Override // java.lang.Object
                @NotNull
                public String toString() {
                    StringBuilder L = a.L("Link(text=");
                    L.append(this.text);
                    L.append(", uri=");
                    L.append(this.uri);
                    L.append(")");
                    return L.toString();
                }

                @Override // android.os.Parcelable
                public void writeToParcel(@NotNull Parcel parcel, int i) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    parcel.writeString(this.text);
                    parcel.writeParcelable(this.uri, i);
                }
            }

            public Content(@Nullable String str, @NotNull String str2, @NotNull Link link2, @Nullable Icon icon2, @Nullable Boolean bool) {
                Intrinsics.checkNotNullParameter(str2, "title");
                Intrinsics.checkNotNullParameter(link2, "link");
                this.id = str;
                this.title = str2;
                this.link = link2;
                this.icon = icon2;
                this.isSwitchOn = bool;
            }

            public static /* synthetic */ Content copy$default(Content content, String str, String str2, Link link2, Icon icon2, Boolean bool, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = content.id;
                }
                if ((i & 2) != 0) {
                    str2 = content.title;
                }
                if ((i & 4) != 0) {
                    link2 = content.link;
                }
                if ((i & 8) != 0) {
                    icon2 = content.icon;
                }
                if ((i & 16) != 0) {
                    bool = content.isSwitchOn;
                }
                return content.copy(str, str2, link2, icon2, bool);
            }

            @Nullable
            public final String component1() {
                return this.id;
            }

            @NotNull
            public final String component2() {
                return this.title;
            }

            @NotNull
            public final Link component3() {
                return this.link;
            }

            @Nullable
            public final Icon component4() {
                return this.icon;
            }

            @Nullable
            public final Boolean component5() {
                return this.isSwitchOn;
            }

            @NotNull
            public final Content copy(@Nullable String str, @NotNull String str2, @NotNull Link link2, @Nullable Icon icon2, @Nullable Boolean bool) {
                Intrinsics.checkNotNullParameter(str2, "title");
                Intrinsics.checkNotNullParameter(link2, "link");
                return new Content(str, str2, link2, icon2, bool);
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
                if (!(obj instanceof Content)) {
                    return false;
                }
                Content content = (Content) obj;
                return Intrinsics.areEqual(this.id, content.id) && Intrinsics.areEqual(this.title, content.title) && Intrinsics.areEqual(this.link, content.link) && Intrinsics.areEqual(this.icon, content.icon) && Intrinsics.areEqual(this.isSwitchOn, content.isSwitchOn);
            }

            @Nullable
            public final Icon getIcon() {
                return this.icon;
            }

            @Nullable
            public final String getId() {
                return this.id;
            }

            @NotNull
            public final Link getLink() {
                return this.link;
            }

            @NotNull
            public final String getTitle() {
                return this.title;
            }

            @Override // java.lang.Object
            public int hashCode() {
                String str = this.id;
                int i = 0;
                int hashCode = (str != null ? str.hashCode() : 0) * 31;
                String str2 = this.title;
                int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
                Link link2 = this.link;
                int hashCode3 = (hashCode2 + (link2 != null ? link2.hashCode() : 0)) * 31;
                Icon icon2 = this.icon;
                int hashCode4 = (hashCode3 + (icon2 != null ? icon2.hashCode() : 0)) * 31;
                Boolean bool = this.isSwitchOn;
                if (bool != null) {
                    i = bool.hashCode();
                }
                return hashCode4 + i;
            }

            @Nullable
            public final Boolean isSwitchOn() {
                return this.isSwitchOn;
            }

            @Override // java.lang.Object
            @NotNull
            public String toString() {
                StringBuilder L = a.L("Content(id=");
                L.append(this.id);
                L.append(", title=");
                L.append(this.title);
                L.append(", link=");
                L.append(this.link);
                L.append(", icon=");
                L.append(this.icon);
                L.append(", isSwitchOn=");
                return a.o(L, this.isSwitchOn, ")");
            }

            @Override // android.os.Parcelable
            public void writeToParcel(@NotNull Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.writeString(this.id);
                parcel.writeString(this.title);
                this.link.writeToParcel(parcel, 0);
                Icon icon2 = this.icon;
                if (icon2 != null) {
                    parcel.writeInt(1);
                    parcel.writeString(icon2.name());
                } else {
                    parcel.writeInt(0);
                }
                Boolean bool = this.isSwitchOn;
                if (bool != null) {
                    a.G0(parcel, 1, bool);
                } else {
                    parcel.writeInt(0);
                }
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Service> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Service createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Service(parcel.readInt() != 0 ? (Type) Enum.valueOf(Type.class, parcel.readString()) : null, Content.CREATOR.createFromParcel(parcel));
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Service[] newArray(int i) {
                return new Service[i];
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/remote/model/MyAdvertSafeDeal$Service$Type;", "", "<init>", "(Ljava/lang/String;I)V", "LIST_ITEM", "SWITCHER", "models_release"}, k = 1, mv = {1, 4, 2})
        public enum Type {
            LIST_ITEM,
            SWITCHER
        }

        public Service(@Nullable Type type2, @NotNull Content content2) {
            Intrinsics.checkNotNullParameter(content2, "content");
            this.type = type2;
            this.content = content2;
        }

        public static /* synthetic */ Service copy$default(Service service, Type type2, Content content2, int i, Object obj) {
            if ((i & 1) != 0) {
                type2 = service.type;
            }
            if ((i & 2) != 0) {
                content2 = service.content;
            }
            return service.copy(type2, content2);
        }

        @Nullable
        public final Type component1() {
            return this.type;
        }

        @NotNull
        public final Content component2() {
            return this.content;
        }

        @NotNull
        public final Service copy(@Nullable Type type2, @NotNull Content content2) {
            Intrinsics.checkNotNullParameter(content2, "content");
            return new Service(type2, content2);
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
            if (!(obj instanceof Service)) {
                return false;
            }
            Service service = (Service) obj;
            return Intrinsics.areEqual(this.type, service.type) && Intrinsics.areEqual(this.content, service.content);
        }

        @NotNull
        public final Content getContent() {
            return this.content;
        }

        @Nullable
        public final Type getType() {
            return this.type;
        }

        @Override // java.lang.Object
        public int hashCode() {
            Type type2 = this.type;
            int i = 0;
            int hashCode = (type2 != null ? type2.hashCode() : 0) * 31;
            Content content2 = this.content;
            if (content2 != null) {
                i = content2.hashCode();
            }
            return hashCode + i;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("Service(type=");
            L.append(this.type);
            L.append(", content=");
            L.append(this.content);
            L.append(")");
            return L.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            Type type2 = this.type;
            if (type2 != null) {
                parcel.writeInt(1);
                parcel.writeString(type2.name());
            } else {
                parcel.writeInt(0);
            }
            this.content.writeToParcel(parcel, 0);
        }
    }

    public MyAdvertSafeDeal(@NotNull List<Service> list) {
        Intrinsics.checkNotNullParameter(list, VKApiConst.SERVICES);
        this.services = list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.remote.model.MyAdvertSafeDeal */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MyAdvertSafeDeal copy$default(MyAdvertSafeDeal myAdvertSafeDeal, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = myAdvertSafeDeal.services;
        }
        return myAdvertSafeDeal.copy(list);
    }

    @NotNull
    public final List<Service> component1() {
        return this.services;
    }

    @NotNull
    public final MyAdvertSafeDeal copy(@NotNull List<Service> list) {
        Intrinsics.checkNotNullParameter(list, VKApiConst.SERVICES);
        return new MyAdvertSafeDeal(list);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof MyAdvertSafeDeal) && Intrinsics.areEqual(this.services, ((MyAdvertSafeDeal) obj).services);
        }
        return true;
    }

    @NotNull
    public final List<Service> getServices() {
        return this.services;
    }

    @Override // java.lang.Object
    public int hashCode() {
        List<Service> list = this.services;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        return a.w(a.L("MyAdvertSafeDeal(services="), this.services, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        Iterator n0 = a.n0(this.services, parcel);
        while (n0.hasNext()) {
            ((Service) n0.next()).writeToParcel(parcel, 0);
        }
    }
}
