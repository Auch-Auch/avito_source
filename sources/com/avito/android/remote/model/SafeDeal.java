package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.advert_core.analytics.contactbar.PhonePageSourceKt;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.model.MyAdvertSafeDeal;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.tariff.tariff_package_info.viewmodel.TariffPackageInfoConverterKt;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.annotations.SerializedName;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.model.VKApiUserFull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0019\b\b\u0018\u00002\u00020\u0001:\u0005>?@ABBO\u0012\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0002\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b<\u0010=J\u0018\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0005J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013Jd\u0010\u001a\u001a\u00020\u00002\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00022\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0011HÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001f\u001a\u00020\u001eHÖ\u0001¢\u0006\u0004\b\u001f\u0010 J\u001a\u0010$\u001a\u00020#2\b\u0010\"\u001a\u0004\u0018\u00010!HÖ\u0003¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020\u001eHÖ\u0001¢\u0006\u0004\b&\u0010 J \u0010+\u001a\u00020*2\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020\u001eHÖ\u0001¢\u0006\u0004\b+\u0010,R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u000e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0018\u0010-\u001a\u0004\b.\u0010\u0010R$\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010/\u001a\u0004\b0\u0010\u0005R\u001b\u00104\u001a\u0004\u0018\u00010\u00038F@\u0006¢\u0006\f\u0012\u0004\b2\u00103\u001a\u0004\b1\u0010\u001dR\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u00118\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0019\u00105\u001a\u0004\b6\u0010\u0013R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u00107\u001a\u0004\b8\u0010\nR$\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010/\u001a\u0004\b9\u0010\u0005R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0017\u0010:\u001a\u0004\b;\u0010\r¨\u0006C"}, d2 = {"Lcom/avito/android/remote/model/SafeDeal;", "Landroid/os/Parcelable;", "", "", "component1", "()Ljava/util/List;", "Lcom/avito/android/remote/model/MyAdvertSafeDeal$Service;", "component2", "Lcom/avito/android/remote/model/SafeDeal$Actions;", "component3", "()Lcom/avito/android/remote/model/SafeDeal$Actions;", "Lcom/avito/android/remote/model/SafeDeal$Info;", "component4", "()Lcom/avito/android/remote/model/SafeDeal$Info;", "Lcom/avito/android/remote/model/SafeDeal$Button;", "component5", "()Lcom/avito/android/remote/model/SafeDeal$Button;", "Lcom/avito/android/remote/model/SafeDeal$About;", "component6", "()Lcom/avito/android/remote/model/SafeDeal$About;", "orderTypes", VKApiConst.SERVICES, "actions", "info", PhonePageSourceKt.PHONE_SOURCE_BUTTON, VKApiUserFull.ABOUT, "copy", "(Ljava/util/List;Ljava/util/List;Lcom/avito/android/remote/model/SafeDeal$Actions;Lcom/avito/android/remote/model/SafeDeal$Info;Lcom/avito/android/remote/model/SafeDeal$Button;Lcom/avito/android/remote/model/SafeDeal$About;)Lcom/avito/android/remote/model/SafeDeal;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/SafeDeal$Button;", "getButton", "Ljava/util/List;", "getOrderTypes", "getFormattedOrderTypes", "getFormattedOrderTypes$annotations", "()V", "formattedOrderTypes", "Lcom/avito/android/remote/model/SafeDeal$About;", "getAbout", "Lcom/avito/android/remote/model/SafeDeal$Actions;", "getActions", "getServices", "Lcom/avito/android/remote/model/SafeDeal$Info;", "getInfo", "<init>", "(Ljava/util/List;Ljava/util/List;Lcom/avito/android/remote/model/SafeDeal$Actions;Lcom/avito/android/remote/model/SafeDeal$Info;Lcom/avito/android/remote/model/SafeDeal$Button;Lcom/avito/android/remote/model/SafeDeal$About;)V", "About", "Actions", "Button", "DiscountLabel", "Info", "models_release"}, k = 1, mv = {1, 4, 2})
public final class SafeDeal implements Parcelable {
    public static final Parcelable.Creator<SafeDeal> CREATOR = new Creator();
    @SerializedName(VKApiUserFull.ABOUT)
    @Nullable
    private final About about;
    @SerializedName("actions")
    @Nullable
    private final Actions actions;
    @SerializedName(PhonePageSourceKt.PHONE_SOURCE_BUTTON)
    @Nullable
    private final Button button;
    @SerializedName("info")
    @Nullable
    private final Info info;
    @SerializedName("orderTypes")
    @Nullable
    private final List<String> orderTypes;
    @SerializedName(VKApiConst.SERVICES)
    @Nullable
    private final List<MyAdvertSafeDeal.Service> services;

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\b\b\u0018\u00002\u00020\u0001:\u0003%&'B!\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b#\u0010$J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ.\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0012J \u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eR$\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u001f\u001a\u0004\b \u0010\bR\u001e\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010!\u001a\u0004\b\"\u0010\u0004¨\u0006("}, d2 = {"Lcom/avito/android/remote/model/SafeDeal$About;", "Landroid/os/Parcelable;", "Lcom/avito/android/remote/model/SafeDeal$About$Header;", "component1", "()Lcom/avito/android/remote/model/SafeDeal$About$Header;", "", "Lcom/avito/android/remote/model/SafeDeal$About$ListComponent;", "component2", "()Ljava/util/List;", TariffPackageInfoConverterKt.HEADER_STRING_ID, "listComponents", "copy", "(Lcom/avito/android/remote/model/SafeDeal$About$Header;Ljava/util/List;)Lcom/avito/android/remote/model/SafeDeal$About;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/util/List;", "getListComponents", "Lcom/avito/android/remote/model/SafeDeal$About$Header;", "getHeader", "<init>", "(Lcom/avito/android/remote/model/SafeDeal$About$Header;Ljava/util/List;)V", "Header", "Icon", "ListComponent", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class About implements Parcelable {
        public static final Parcelable.Creator<About> CREATOR = new Creator();
        @SerializedName(TariffPackageInfoConverterKt.HEADER_STRING_ID)
        @Nullable
        private final Header header;
        @SerializedName("listComponents")
        @Nullable
        private final List<ListComponent> listComponents;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<About> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final About createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                ArrayList arrayList = null;
                Header createFromParcel = parcel.readInt() != 0 ? Header.CREATOR.createFromParcel(parcel) : null;
                if (parcel.readInt() != 0) {
                    int readInt = parcel.readInt();
                    ArrayList arrayList2 = new ArrayList(readInt);
                    while (readInt != 0) {
                        arrayList2.add((ListComponent) parcel.readParcelable(About.class.getClassLoader()));
                        readInt--;
                    }
                    arrayList = arrayList2;
                }
                return new About(createFromParcel, arrayList);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final About[] newArray(int i) {
                return new About[i];
            }
        }

        @Parcelize
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\b\b\u0018\u00002\u00020\u0001:\u0001*B%\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b(\u0010)J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ4\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0015J \u0010 \u001a\u00020\u001f2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b \u0010!R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\"\u001a\u0004\b#\u0010\u0004R\u001e\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010$\u001a\u0004\b%\u0010\u0007R\u001e\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010&\u001a\u0004\b'\u0010\n¨\u0006+"}, d2 = {"Lcom/avito/android/remote/model/SafeDeal$About$Header;", "Landroid/os/Parcelable;", "Lcom/avito/android/remote/model/text/AttributedText;", "component1", "()Lcom/avito/android/remote/model/text/AttributedText;", "Lcom/avito/android/remote/model/SafeDeal$About$Header$Info;", "component2", "()Lcom/avito/android/remote/model/SafeDeal$About$Header$Info;", "Lcom/avito/android/deep_linking/links/DeepLink;", "component3", "()Lcom/avito/android/deep_linking/links/DeepLink;", "title", "info", "titleDeeplink", "copy", "(Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/model/SafeDeal$About$Header$Info;Lcom/avito/android/deep_linking/links/DeepLink;)Lcom/avito/android/remote/model/SafeDeal$About$Header;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/text/AttributedText;", "getTitle", "Lcom/avito/android/remote/model/SafeDeal$About$Header$Info;", "getInfo", "Lcom/avito/android/deep_linking/links/DeepLink;", "getTitleDeeplink", "<init>", "(Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/model/SafeDeal$About$Header$Info;Lcom/avito/android/deep_linking/links/DeepLink;)V", "Info", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Header implements Parcelable {
            public static final Parcelable.Creator<Header> CREATOR = new Creator();
            @SerializedName("info")
            @Nullable
            private final Info info;
            @SerializedName("title")
            @Nullable
            private final AttributedText title;
            @SerializedName("titleDeepLink")
            @Nullable
            private final DeepLink titleDeeplink;

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<Header> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Header createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    return new Header((AttributedText) parcel.readParcelable(Header.class.getClassLoader()), parcel.readInt() != 0 ? Info.CREATOR.createFromParcel(parcel) : null, (DeepLink) parcel.readParcelable(Header.class.getClassLoader()));
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Header[] newArray(int i) {
                    return new Header[i];
                }
            }

            @Parcelize
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0013\u0010\rJ \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004¨\u0006\u001e"}, d2 = {"Lcom/avito/android/remote/model/SafeDeal$About$Header$Info;", "Landroid/os/Parcelable;", "Lcom/avito/android/deep_linking/links/DeepLink;", "component1", "()Lcom/avito/android/deep_linking/links/DeepLink;", "deeplink", "copy", "(Lcom/avito/android/deep_linking/links/DeepLink;)Lcom/avito/android/remote/model/SafeDeal$About$Header$Info;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeeplink", "<init>", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "models_release"}, k = 1, mv = {1, 4, 2})
            public static final class Info implements Parcelable {
                public static final Parcelable.Creator<Info> CREATOR = new Creator();
                @SerializedName("deepLink")
                @Nullable
                private final DeepLink deeplink;

                @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
                public static class Creator implements Parcelable.Creator<Info> {
                    @Override // android.os.Parcelable.Creator
                    @NotNull
                    public final Info createFromParcel(@NotNull Parcel parcel) {
                        Intrinsics.checkNotNullParameter(parcel, "in");
                        return new Info((DeepLink) parcel.readParcelable(Info.class.getClassLoader()));
                    }

                    @Override // android.os.Parcelable.Creator
                    @NotNull
                    public final Info[] newArray(int i) {
                        return new Info[i];
                    }
                }

                public Info(@Nullable DeepLink deepLink) {
                    this.deeplink = deepLink;
                }

                public static /* synthetic */ Info copy$default(Info info, DeepLink deepLink, int i, Object obj) {
                    if ((i & 1) != 0) {
                        deepLink = info.deeplink;
                    }
                    return info.copy(deepLink);
                }

                @Nullable
                public final DeepLink component1() {
                    return this.deeplink;
                }

                @NotNull
                public final Info copy(@Nullable DeepLink deepLink) {
                    return new Info(deepLink);
                }

                @Override // android.os.Parcelable
                public int describeContents() {
                    return 0;
                }

                @Override // java.lang.Object
                public boolean equals(@Nullable Object obj) {
                    if (this != obj) {
                        return (obj instanceof Info) && Intrinsics.areEqual(this.deeplink, ((Info) obj).deeplink);
                    }
                    return true;
                }

                @Nullable
                public final DeepLink getDeeplink() {
                    return this.deeplink;
                }

                @Override // java.lang.Object
                public int hashCode() {
                    DeepLink deepLink = this.deeplink;
                    if (deepLink != null) {
                        return deepLink.hashCode();
                    }
                    return 0;
                }

                @Override // java.lang.Object
                @NotNull
                public String toString() {
                    return a.m(a.L("Info(deeplink="), this.deeplink, ")");
                }

                @Override // android.os.Parcelable
                public void writeToParcel(@NotNull Parcel parcel, int i) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    parcel.writeParcelable(this.deeplink, i);
                }
            }

            public Header(@Nullable AttributedText attributedText, @Nullable Info info2, @Nullable DeepLink deepLink) {
                this.title = attributedText;
                this.info = info2;
                this.titleDeeplink = deepLink;
            }

            public static /* synthetic */ Header copy$default(Header header, AttributedText attributedText, Info info2, DeepLink deepLink, int i, Object obj) {
                if ((i & 1) != 0) {
                    attributedText = header.title;
                }
                if ((i & 2) != 0) {
                    info2 = header.info;
                }
                if ((i & 4) != 0) {
                    deepLink = header.titleDeeplink;
                }
                return header.copy(attributedText, info2, deepLink);
            }

            @Nullable
            public final AttributedText component1() {
                return this.title;
            }

            @Nullable
            public final Info component2() {
                return this.info;
            }

            @Nullable
            public final DeepLink component3() {
                return this.titleDeeplink;
            }

            @NotNull
            public final Header copy(@Nullable AttributedText attributedText, @Nullable Info info2, @Nullable DeepLink deepLink) {
                return new Header(attributedText, info2, deepLink);
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
                if (!(obj instanceof Header)) {
                    return false;
                }
                Header header = (Header) obj;
                return Intrinsics.areEqual(this.title, header.title) && Intrinsics.areEqual(this.info, header.info) && Intrinsics.areEqual(this.titleDeeplink, header.titleDeeplink);
            }

            @Nullable
            public final Info getInfo() {
                return this.info;
            }

            @Nullable
            public final AttributedText getTitle() {
                return this.title;
            }

            @Nullable
            public final DeepLink getTitleDeeplink() {
                return this.titleDeeplink;
            }

            @Override // java.lang.Object
            public int hashCode() {
                AttributedText attributedText = this.title;
                int i = 0;
                int hashCode = (attributedText != null ? attributedText.hashCode() : 0) * 31;
                Info info2 = this.info;
                int hashCode2 = (hashCode + (info2 != null ? info2.hashCode() : 0)) * 31;
                DeepLink deepLink = this.titleDeeplink;
                if (deepLink != null) {
                    i = deepLink.hashCode();
                }
                return hashCode2 + i;
            }

            @Override // java.lang.Object
            @NotNull
            public String toString() {
                StringBuilder L = a.L("Header(title=");
                L.append(this.title);
                L.append(", info=");
                L.append(this.info);
                L.append(", titleDeeplink=");
                return a.m(L, this.titleDeeplink, ")");
            }

            @Override // android.os.Parcelable
            public void writeToParcel(@NotNull Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.writeParcelable(this.title, i);
                Info info2 = this.info;
                if (info2 != null) {
                    parcel.writeInt(1);
                    info2.writeToParcel(parcel, 0);
                } else {
                    parcel.writeInt(0);
                }
                parcel.writeParcelable(this.titleDeeplink, i);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/remote/model/SafeDeal$About$Icon;", "", "<init>", "(Ljava/lang/String;I)V", "DELIVERY", "COURIER", "RETURN", "models_release"}, k = 1, mv = {1, 4, 2})
        public enum Icon {
            DELIVERY,
            COURIER,
            RETURN
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/remote/model/SafeDeal$About$ListComponent;", "Landroid/os/Parcelable;", "<init>", "()V", "ListItem", "Spacing", AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN, "Lcom/avito/android/remote/model/SafeDeal$About$ListComponent$ListItem;", "Lcom/avito/android/remote/model/SafeDeal$About$ListComponent$Spacing;", "Lcom/avito/android/remote/model/SafeDeal$About$ListComponent$Unknown;", "models_release"}, k = 1, mv = {1, 4, 2})
        public static abstract class ListComponent implements Parcelable {

            @Parcelize
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\b\b\u0018\u00002\u00020\u0001:\u0001*B%\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b(\u0010)J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ4\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0015J \u0010 \u001a\u00020\u001f2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b \u0010!R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\"\u001a\u0004\b#\u0010\u0004R\u001e\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010$\u001a\u0004\b%\u0010\u0007R\u001e\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010&\u001a\u0004\b'\u0010\n¨\u0006+"}, d2 = {"Lcom/avito/android/remote/model/SafeDeal$About$ListComponent$ListItem;", "Lcom/avito/android/remote/model/SafeDeal$About$ListComponent;", "Lcom/avito/android/remote/model/SafeDeal$About$Icon;", "component1", "()Lcom/avito/android/remote/model/SafeDeal$About$Icon;", "Lcom/avito/android/remote/model/text/AttributedText;", "component2", "()Lcom/avito/android/remote/model/text/AttributedText;", "Lcom/avito/android/remote/model/SafeDeal$About$ListComponent$ListItem$Alignment;", "component3", "()Lcom/avito/android/remote/model/SafeDeal$About$ListComponent$ListItem$Alignment;", "icon", "title", "titleAlignment", "copy", "(Lcom/avito/android/remote/model/SafeDeal$About$Icon;Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/model/SafeDeal$About$ListComponent$ListItem$Alignment;)Lcom/avito/android/remote/model/SafeDeal$About$ListComponent$ListItem;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/SafeDeal$About$Icon;", "getIcon", "Lcom/avito/android/remote/model/text/AttributedText;", "getTitle", "Lcom/avito/android/remote/model/SafeDeal$About$ListComponent$ListItem$Alignment;", "getTitleAlignment", "<init>", "(Lcom/avito/android/remote/model/SafeDeal$About$Icon;Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/model/SafeDeal$About$ListComponent$ListItem$Alignment;)V", "Alignment", "models_release"}, k = 1, mv = {1, 4, 2})
            public static final class ListItem extends ListComponent {
                public static final Parcelable.Creator<ListItem> CREATOR = new Creator();
                @SerializedName("icon")
                @Nullable
                private final Icon icon;
                @SerializedName("title")
                @Nullable
                private final AttributedText title;
                @SerializedName("titleAlignment")
                @Nullable
                private final Alignment titleAlignment;

                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/remote/model/SafeDeal$About$ListComponent$ListItem$Alignment;", "", "<init>", "(Ljava/lang/String;I)V", "LEFT", "CENTER", "RIGHT", "models_release"}, k = 1, mv = {1, 4, 2})
                public enum Alignment {
                    LEFT,
                    CENTER,
                    RIGHT
                }

                @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
                public static class Creator implements Parcelable.Creator<ListItem> {
                    @Override // android.os.Parcelable.Creator
                    @NotNull
                    public final ListItem createFromParcel(@NotNull Parcel parcel) {
                        Intrinsics.checkNotNullParameter(parcel, "in");
                        Alignment alignment = null;
                        Icon icon = parcel.readInt() != 0 ? (Icon) Enum.valueOf(Icon.class, parcel.readString()) : null;
                        AttributedText attributedText = (AttributedText) parcel.readParcelable(ListItem.class.getClassLoader());
                        if (parcel.readInt() != 0) {
                            alignment = (Alignment) Enum.valueOf(Alignment.class, parcel.readString());
                        }
                        return new ListItem(icon, attributedText, alignment);
                    }

                    @Override // android.os.Parcelable.Creator
                    @NotNull
                    public final ListItem[] newArray(int i) {
                        return new ListItem[i];
                    }
                }

                public ListItem(@Nullable Icon icon2, @Nullable AttributedText attributedText, @Nullable Alignment alignment) {
                    super(null);
                    this.icon = icon2;
                    this.title = attributedText;
                    this.titleAlignment = alignment;
                }

                public static /* synthetic */ ListItem copy$default(ListItem listItem, Icon icon2, AttributedText attributedText, Alignment alignment, int i, Object obj) {
                    if ((i & 1) != 0) {
                        icon2 = listItem.icon;
                    }
                    if ((i & 2) != 0) {
                        attributedText = listItem.title;
                    }
                    if ((i & 4) != 0) {
                        alignment = listItem.titleAlignment;
                    }
                    return listItem.copy(icon2, attributedText, alignment);
                }

                @Nullable
                public final Icon component1() {
                    return this.icon;
                }

                @Nullable
                public final AttributedText component2() {
                    return this.title;
                }

                @Nullable
                public final Alignment component3() {
                    return this.titleAlignment;
                }

                @NotNull
                public final ListItem copy(@Nullable Icon icon2, @Nullable AttributedText attributedText, @Nullable Alignment alignment) {
                    return new ListItem(icon2, attributedText, alignment);
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
                    if (!(obj instanceof ListItem)) {
                        return false;
                    }
                    ListItem listItem = (ListItem) obj;
                    return Intrinsics.areEqual(this.icon, listItem.icon) && Intrinsics.areEqual(this.title, listItem.title) && Intrinsics.areEqual(this.titleAlignment, listItem.titleAlignment);
                }

                @Nullable
                public final Icon getIcon() {
                    return this.icon;
                }

                @Nullable
                public final AttributedText getTitle() {
                    return this.title;
                }

                @Nullable
                public final Alignment getTitleAlignment() {
                    return this.titleAlignment;
                }

                @Override // java.lang.Object
                public int hashCode() {
                    Icon icon2 = this.icon;
                    int i = 0;
                    int hashCode = (icon2 != null ? icon2.hashCode() : 0) * 31;
                    AttributedText attributedText = this.title;
                    int hashCode2 = (hashCode + (attributedText != null ? attributedText.hashCode() : 0)) * 31;
                    Alignment alignment = this.titleAlignment;
                    if (alignment != null) {
                        i = alignment.hashCode();
                    }
                    return hashCode2 + i;
                }

                @Override // java.lang.Object
                @NotNull
                public String toString() {
                    StringBuilder L = a.L("ListItem(icon=");
                    L.append(this.icon);
                    L.append(", title=");
                    L.append(this.title);
                    L.append(", titleAlignment=");
                    L.append(this.titleAlignment);
                    L.append(")");
                    return L.toString();
                }

                @Override // android.os.Parcelable
                public void writeToParcel(@NotNull Parcel parcel, int i) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    Icon icon2 = this.icon;
                    if (icon2 != null) {
                        parcel.writeInt(1);
                        parcel.writeString(icon2.name());
                    } else {
                        parcel.writeInt(0);
                    }
                    parcel.writeParcelable(this.title, i);
                    Alignment alignment = this.titleAlignment;
                    if (alignment != null) {
                        parcel.writeInt(1);
                        parcel.writeString(alignment.name());
                        return;
                    }
                    parcel.writeInt(0);
                }
            }

            @Parcelize
            @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\fJ \u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004¨\u0006\u001d"}, d2 = {"Lcom/avito/android/remote/model/SafeDeal$About$ListComponent$Spacing;", "Lcom/avito/android/remote/model/SafeDeal$About$ListComponent;", "", "component1", "()Ljava/lang/Integer;", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "copy", "(Ljava/lang/Integer;)Lcom/avito/android/remote/model/SafeDeal$About$ListComponent$Spacing;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/Integer;", "getHeight", "<init>", "(Ljava/lang/Integer;)V", "models_release"}, k = 1, mv = {1, 4, 2})
            public static final class Spacing extends ListComponent {
                public static final Parcelable.Creator<Spacing> CREATOR = new Creator();
                @SerializedName(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY)
                @Nullable
                private final Integer height;

                @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
                public static class Creator implements Parcelable.Creator<Spacing> {
                    @Override // android.os.Parcelable.Creator
                    @NotNull
                    public final Spacing createFromParcel(@NotNull Parcel parcel) {
                        Intrinsics.checkNotNullParameter(parcel, "in");
                        return new Spacing(parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null);
                    }

                    @Override // android.os.Parcelable.Creator
                    @NotNull
                    public final Spacing[] newArray(int i) {
                        return new Spacing[i];
                    }
                }

                public Spacing(@Nullable Integer num) {
                    super(null);
                    this.height = num;
                }

                public static /* synthetic */ Spacing copy$default(Spacing spacing, Integer num, int i, Object obj) {
                    if ((i & 1) != 0) {
                        num = spacing.height;
                    }
                    return spacing.copy(num);
                }

                @Nullable
                public final Integer component1() {
                    return this.height;
                }

                @NotNull
                public final Spacing copy(@Nullable Integer num) {
                    return new Spacing(num);
                }

                @Override // android.os.Parcelable
                public int describeContents() {
                    return 0;
                }

                @Override // java.lang.Object
                public boolean equals(@Nullable Object obj) {
                    if (this != obj) {
                        return (obj instanceof Spacing) && Intrinsics.areEqual(this.height, ((Spacing) obj).height);
                    }
                    return true;
                }

                @Nullable
                public final Integer getHeight() {
                    return this.height;
                }

                @Override // java.lang.Object
                public int hashCode() {
                    Integer num = this.height;
                    if (num != null) {
                        return num.hashCode();
                    }
                    return 0;
                }

                @Override // java.lang.Object
                @NotNull
                public String toString() {
                    return a.p(a.L("Spacing(height="), this.height, ")");
                }

                @Override // android.os.Parcelable
                public void writeToParcel(@NotNull Parcel parcel, int i) {
                    int i2;
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    Integer num = this.height;
                    if (num != null) {
                        parcel.writeInt(1);
                        i2 = num.intValue();
                    } else {
                        i2 = 0;
                    }
                    parcel.writeInt(i2);
                }
            }

            @Parcelize
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/remote/model/SafeDeal$About$ListComponent$Unknown;", "Lcom/avito/android/remote/model/SafeDeal$About$ListComponent;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
            public static final class Unknown extends ListComponent {
                public static final Parcelable.Creator<Unknown> CREATOR = new Creator();
                @NotNull
                public static final Unknown INSTANCE = new Unknown();

                @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
                public static class Creator implements Parcelable.Creator<Unknown> {
                    @Override // android.os.Parcelable.Creator
                    @NotNull
                    public final Unknown createFromParcel(@NotNull Parcel parcel) {
                        Intrinsics.checkNotNullParameter(parcel, "in");
                        if (parcel.readInt() != 0) {
                            return Unknown.INSTANCE;
                        }
                        return null;
                    }

                    @Override // android.os.Parcelable.Creator
                    @NotNull
                    public final Unknown[] newArray(int i) {
                        return new Unknown[i];
                    }
                }

                private Unknown() {
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

            private ListComponent() {
            }

            public /* synthetic */ ListComponent(j jVar) {
                this();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends com.avito.android.remote.model.SafeDeal$About$ListComponent> */
        /* JADX WARN: Multi-variable type inference failed */
        public About(@Nullable Header header2, @Nullable List<? extends ListComponent> list) {
            this.header = header2;
            this.listComponents = list;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.remote.model.SafeDeal$About */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ About copy$default(About about, Header header2, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                header2 = about.header;
            }
            if ((i & 2) != 0) {
                list = about.listComponents;
            }
            return about.copy(header2, list);
        }

        @Nullable
        public final Header component1() {
            return this.header;
        }

        @Nullable
        public final List<ListComponent> component2() {
            return this.listComponents;
        }

        @NotNull
        public final About copy(@Nullable Header header2, @Nullable List<? extends ListComponent> list) {
            return new About(header2, list);
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
            if (!(obj instanceof About)) {
                return false;
            }
            About about = (About) obj;
            return Intrinsics.areEqual(this.header, about.header) && Intrinsics.areEqual(this.listComponents, about.listComponents);
        }

        @Nullable
        public final Header getHeader() {
            return this.header;
        }

        @Nullable
        public final List<ListComponent> getListComponents() {
            return this.listComponents;
        }

        @Override // java.lang.Object
        public int hashCode() {
            Header header2 = this.header;
            int i = 0;
            int hashCode = (header2 != null ? header2.hashCode() : 0) * 31;
            List<ListComponent> list = this.listComponents;
            if (list != null) {
                i = list.hashCode();
            }
            return hashCode + i;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("About(header=");
            L.append(this.header);
            L.append(", listComponents=");
            return a.w(L, this.listComponents, ")");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            Header header2 = this.header;
            if (header2 != null) {
                parcel.writeInt(1);
                header2.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            List<ListComponent> list = this.listComponents;
            if (list != null) {
                Iterator l0 = a.l0(parcel, 1, list);
                while (l0.hasNext()) {
                    parcel.writeParcelable((ListComponent) l0.next(), i);
                }
                return;
            }
            parcel.writeInt(0);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\b\b\u0018\u00002\u00020\u0001B5\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b2\u00103J\u0018\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJF\u0010\u0013\u001a\u00020\u00002\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u001f\u0010\u0019J \u0010$\u001a\u00020#2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b$\u0010%R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010&\u001a\u0004\b'\u0010\bR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010(\u001a\u0004\b)\u0010\u000bR$\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010*\u001a\u0004\b+\u0010\u0005R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010,\u001a\u0004\b-\u0010\u000eR\u001b\u00101\u001a\u0004\u0018\u00010\u00038F@\u0006¢\u0006\f\u0012\u0004\b/\u00100\u001a\u0004\b.\u0010\u0016¨\u00064"}, d2 = {"Lcom/avito/android/remote/model/SafeDeal$Actions;", "Landroid/os/Parcelable;", "", "", "component1", "()Ljava/util/List;", "Lcom/avito/android/remote/model/SafeDealAction;", "component2", "()Lcom/avito/android/remote/model/SafeDealAction;", "Lcom/avito/android/remote/model/text/AttributedText;", "component3", "()Lcom/avito/android/remote/model/text/AttributedText;", "Lcom/avito/android/remote/model/SafeDeal$DiscountLabel;", "component4", "()Lcom/avito/android/remote/model/SafeDeal$DiscountLabel;", "orderTypes", "buyButton", "aboutLabel", "discountLabel", "copy", "(Ljava/util/List;Lcom/avito/android/remote/model/SafeDealAction;Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/model/SafeDeal$DiscountLabel;)Lcom/avito/android/remote/model/SafeDeal$Actions;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/SafeDealAction;", "getBuyButton", "Lcom/avito/android/remote/model/text/AttributedText;", "getAboutLabel", "Ljava/util/List;", "getOrderTypes", "Lcom/avito/android/remote/model/SafeDeal$DiscountLabel;", "getDiscountLabel", "getFormattedOrderTypes", "getFormattedOrderTypes$annotations", "()V", "formattedOrderTypes", "<init>", "(Ljava/util/List;Lcom/avito/android/remote/model/SafeDealAction;Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/model/SafeDeal$DiscountLabel;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Actions implements Parcelable {
        public static final Parcelable.Creator<Actions> CREATOR = new Creator();
        @SerializedName("aboutLabel")
        @Nullable
        private final AttributedText aboutLabel;
        @SerializedName("buyButton")
        @Nullable
        private final SafeDealAction buyButton;
        @SerializedName("discountLabel")
        @Nullable
        private final DiscountLabel discountLabel;
        @SerializedName("orderTypes")
        @Nullable
        private final List<String> orderTypes;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Actions> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Actions createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                ArrayList<String> createStringArrayList = parcel.createStringArrayList();
                DiscountLabel discountLabel = null;
                SafeDealAction createFromParcel = parcel.readInt() != 0 ? SafeDealAction.CREATOR.createFromParcel(parcel) : null;
                AttributedText attributedText = (AttributedText) parcel.readParcelable(Actions.class.getClassLoader());
                if (parcel.readInt() != 0) {
                    discountLabel = DiscountLabel.CREATOR.createFromParcel(parcel);
                }
                return new Actions(createStringArrayList, createFromParcel, attributedText, discountLabel);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Actions[] newArray(int i) {
                return new Actions[i];
            }
        }

        public Actions(@Nullable List<String> list, @Nullable SafeDealAction safeDealAction, @Nullable AttributedText attributedText, @Nullable DiscountLabel discountLabel2) {
            this.orderTypes = list;
            this.buyButton = safeDealAction;
            this.aboutLabel = attributedText;
            this.discountLabel = discountLabel2;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.remote.model.SafeDeal$Actions */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Actions copy$default(Actions actions, List list, SafeDealAction safeDealAction, AttributedText attributedText, DiscountLabel discountLabel2, int i, Object obj) {
            if ((i & 1) != 0) {
                list = actions.orderTypes;
            }
            if ((i & 2) != 0) {
                safeDealAction = actions.buyButton;
            }
            if ((i & 4) != 0) {
                attributedText = actions.aboutLabel;
            }
            if ((i & 8) != 0) {
                discountLabel2 = actions.discountLabel;
            }
            return actions.copy(list, safeDealAction, attributedText, discountLabel2);
        }

        public static /* synthetic */ void getFormattedOrderTypes$annotations() {
        }

        @Nullable
        public final List<String> component1() {
            return this.orderTypes;
        }

        @Nullable
        public final SafeDealAction component2() {
            return this.buyButton;
        }

        @Nullable
        public final AttributedText component3() {
            return this.aboutLabel;
        }

        @Nullable
        public final DiscountLabel component4() {
            return this.discountLabel;
        }

        @NotNull
        public final Actions copy(@Nullable List<String> list, @Nullable SafeDealAction safeDealAction, @Nullable AttributedText attributedText, @Nullable DiscountLabel discountLabel2) {
            return new Actions(list, safeDealAction, attributedText, discountLabel2);
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
            if (!(obj instanceof Actions)) {
                return false;
            }
            Actions actions = (Actions) obj;
            return Intrinsics.areEqual(this.orderTypes, actions.orderTypes) && Intrinsics.areEqual(this.buyButton, actions.buyButton) && Intrinsics.areEqual(this.aboutLabel, actions.aboutLabel) && Intrinsics.areEqual(this.discountLabel, actions.discountLabel);
        }

        @Nullable
        public final AttributedText getAboutLabel() {
            return this.aboutLabel;
        }

        @Nullable
        public final SafeDealAction getBuyButton() {
            return this.buyButton;
        }

        @Nullable
        public final DiscountLabel getDiscountLabel() {
            return this.discountLabel;
        }

        @Nullable
        public final String getFormattedOrderTypes() {
            List<String> list = this.orderTypes;
            if (list != null) {
                return CollectionsKt___CollectionsKt.joinToString$default(list, null, "[", "]", 0, null, SafeDeal$Actions$formattedOrderTypes$1.INSTANCE, 25, null);
            }
            return null;
        }

        @Nullable
        public final List<String> getOrderTypes() {
            return this.orderTypes;
        }

        @Override // java.lang.Object
        public int hashCode() {
            List<String> list = this.orderTypes;
            int i = 0;
            int hashCode = (list != null ? list.hashCode() : 0) * 31;
            SafeDealAction safeDealAction = this.buyButton;
            int hashCode2 = (hashCode + (safeDealAction != null ? safeDealAction.hashCode() : 0)) * 31;
            AttributedText attributedText = this.aboutLabel;
            int hashCode3 = (hashCode2 + (attributedText != null ? attributedText.hashCode() : 0)) * 31;
            DiscountLabel discountLabel2 = this.discountLabel;
            if (discountLabel2 != null) {
                i = discountLabel2.hashCode();
            }
            return hashCode3 + i;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("Actions(orderTypes=");
            L.append(this.orderTypes);
            L.append(", buyButton=");
            L.append(this.buyButton);
            L.append(", aboutLabel=");
            L.append(this.aboutLabel);
            L.append(", discountLabel=");
            L.append(this.discountLabel);
            L.append(")");
            return L.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeStringList(this.orderTypes);
            SafeDealAction safeDealAction = this.buyButton;
            if (safeDealAction != null) {
                parcel.writeInt(1);
                safeDealAction.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            parcel.writeParcelable(this.aboutLabel, i);
            DiscountLabel discountLabel2 = this.discountLabel;
            if (discountLabel2 != null) {
                parcel.writeInt(1);
                discountLabel2.writeToParcel(parcel, 0);
                return;
            }
            parcel.writeInt(0);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\b\b\u0018\u00002\u00020\u0001:\u0002./B-\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b,\u0010-J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ>\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0017J \u0010\"\u001a\u00020!2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\"\u0010#R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010$\u001a\u0004\b%\u0010\u0007R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010&\u001a\u0004\b'\u0010\nR\u001c\u0010\u000e\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010(\u001a\u0004\b)\u0010\u0004R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010*\u001a\u0004\b+\u0010\r¨\u00060"}, d2 = {"Lcom/avito/android/remote/model/SafeDeal$Button;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/SafeDeal$Button$Icon;", "component2", "()Lcom/avito/android/remote/model/SafeDeal$Button$Icon;", "Lcom/avito/android/remote/model/SafeDeal$Button$Style;", "component3", "()Lcom/avito/android/remote/model/SafeDeal$Button$Style;", "Lcom/avito/android/deep_linking/links/DeepLink;", "component4", "()Lcom/avito/android/deep_linking/links/DeepLink;", "title", "icon", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "deeplink", "copy", "(Ljava/lang/String;Lcom/avito/android/remote/model/SafeDeal$Button$Icon;Lcom/avito/android/remote/model/SafeDeal$Button$Style;Lcom/avito/android/deep_linking/links/DeepLink;)Lcom/avito/android/remote/model/SafeDeal$Button;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/SafeDeal$Button$Icon;", "getIcon", "Lcom/avito/android/remote/model/SafeDeal$Button$Style;", "getStyle", "Ljava/lang/String;", "getTitle", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeeplink", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/SafeDeal$Button$Icon;Lcom/avito/android/remote/model/SafeDeal$Button$Style;Lcom/avito/android/deep_linking/links/DeepLink;)V", "Icon", "Style", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Button implements Parcelable {
        public static final Parcelable.Creator<Button> CREATOR = new Creator();
        @SerializedName("deepLink")
        @Nullable
        private final DeepLink deeplink;
        @SerializedName("icon")
        @Nullable
        private final Icon icon;
        @SerializedName(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE)
        @Nullable
        private final Style style;
        @SerializedName("title")
        @NotNull
        private final String title;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Button> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Button createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                String readString = parcel.readString();
                Style style = null;
                Icon icon = parcel.readInt() != 0 ? (Icon) Enum.valueOf(Icon.class, parcel.readString()) : null;
                if (parcel.readInt() != 0) {
                    style = (Style) Enum.valueOf(Style.class, parcel.readString());
                }
                return new Button(readString, icon, style, (DeepLink) parcel.readParcelable(Button.class.getClassLoader()));
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Button[] newArray(int i) {
                return new Button[i];
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/remote/model/SafeDeal$Button$Icon;", "", "<init>", "(Ljava/lang/String;I)V", "DELIVERY", "COURIER", "SAFE_DEAL", "models_release"}, k = 1, mv = {1, 4, 2})
        public enum Icon {
            DELIVERY,
            COURIER,
            SAFE_DEAL
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/remote/model/SafeDeal$Button$Style;", "", "<init>", "(Ljava/lang/String;I)V", "PRIMARY", "SECONDARY", MessengerShareContentUtility.PREVIEW_DEFAULT, "models_release"}, k = 1, mv = {1, 4, 2})
        public enum Style {
            PRIMARY,
            SECONDARY,
            DEFAULT
        }

        public Button(@NotNull String str, @Nullable Icon icon2, @Nullable Style style2, @Nullable DeepLink deepLink) {
            Intrinsics.checkNotNullParameter(str, "title");
            this.title = str;
            this.icon = icon2;
            this.style = style2;
            this.deeplink = deepLink;
        }

        public static /* synthetic */ Button copy$default(Button button, String str, Icon icon2, Style style2, DeepLink deepLink, int i, Object obj) {
            if ((i & 1) != 0) {
                str = button.title;
            }
            if ((i & 2) != 0) {
                icon2 = button.icon;
            }
            if ((i & 4) != 0) {
                style2 = button.style;
            }
            if ((i & 8) != 0) {
                deepLink = button.deeplink;
            }
            return button.copy(str, icon2, style2, deepLink);
        }

        @NotNull
        public final String component1() {
            return this.title;
        }

        @Nullable
        public final Icon component2() {
            return this.icon;
        }

        @Nullable
        public final Style component3() {
            return this.style;
        }

        @Nullable
        public final DeepLink component4() {
            return this.deeplink;
        }

        @NotNull
        public final Button copy(@NotNull String str, @Nullable Icon icon2, @Nullable Style style2, @Nullable DeepLink deepLink) {
            Intrinsics.checkNotNullParameter(str, "title");
            return new Button(str, icon2, style2, deepLink);
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
            if (!(obj instanceof Button)) {
                return false;
            }
            Button button = (Button) obj;
            return Intrinsics.areEqual(this.title, button.title) && Intrinsics.areEqual(this.icon, button.icon) && Intrinsics.areEqual(this.style, button.style) && Intrinsics.areEqual(this.deeplink, button.deeplink);
        }

        @Nullable
        public final DeepLink getDeeplink() {
            return this.deeplink;
        }

        @Nullable
        public final Icon getIcon() {
            return this.icon;
        }

        @Nullable
        public final Style getStyle() {
            return this.style;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        @Override // java.lang.Object
        public int hashCode() {
            String str = this.title;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            Icon icon2 = this.icon;
            int hashCode2 = (hashCode + (icon2 != null ? icon2.hashCode() : 0)) * 31;
            Style style2 = this.style;
            int hashCode3 = (hashCode2 + (style2 != null ? style2.hashCode() : 0)) * 31;
            DeepLink deepLink = this.deeplink;
            if (deepLink != null) {
                i = deepLink.hashCode();
            }
            return hashCode3 + i;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("Button(title=");
            L.append(this.title);
            L.append(", icon=");
            L.append(this.icon);
            L.append(", style=");
            L.append(this.style);
            L.append(", deeplink=");
            return a.m(L, this.deeplink, ")");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.title);
            Icon icon2 = this.icon;
            if (icon2 != null) {
                parcel.writeInt(1);
                parcel.writeString(icon2.name());
            } else {
                parcel.writeInt(0);
            }
            Style style2 = this.style;
            if (style2 != null) {
                parcel.writeInt(1);
                parcel.writeString(style2.name());
            } else {
                parcel.writeInt(0);
            }
            parcel.writeParcelable(this.deeplink, i);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<SafeDeal> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SafeDeal createFromParcel(@NotNull Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "in");
            ArrayList<String> createStringArrayList = parcel.createStringArrayList();
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add(MyAdvertSafeDeal.Service.CREATOR.createFromParcel(parcel));
                    readInt--;
                }
            } else {
                arrayList = null;
            }
            return new SafeDeal(createStringArrayList, arrayList, parcel.readInt() != 0 ? Actions.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? Info.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? Button.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? About.CREATOR.createFromParcel(parcel) : null);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SafeDeal[] newArray(int i) {
            return new SafeDeal[i];
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0011\u0010\u000bJ \u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0005\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004¨\u0006\u001c"}, d2 = {"Lcom/avito/android/remote/model/SafeDeal$DiscountLabel;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "text", "copy", "(Ljava/lang/String;)Lcom/avito/android/remote/model/SafeDeal$DiscountLabel;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getText", "<init>", "(Ljava/lang/String;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class DiscountLabel implements Parcelable {
        public static final Parcelable.Creator<DiscountLabel> CREATOR = new Creator();
        @SerializedName("text")
        @NotNull
        private final String text;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<DiscountLabel> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final DiscountLabel createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new DiscountLabel(parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final DiscountLabel[] newArray(int i) {
                return new DiscountLabel[i];
            }
        }

        public DiscountLabel(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "text");
            this.text = str;
        }

        public static /* synthetic */ DiscountLabel copy$default(DiscountLabel discountLabel, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = discountLabel.text;
            }
            return discountLabel.copy(str);
        }

        @NotNull
        public final String component1() {
            return this.text;
        }

        @NotNull
        public final DiscountLabel copy(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "text");
            return new DiscountLabel(str);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // java.lang.Object
        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof DiscountLabel) && Intrinsics.areEqual(this.text, ((DiscountLabel) obj).text);
            }
            return true;
        }

        @NotNull
        public final String getText() {
            return this.text;
        }

        @Override // java.lang.Object
        public int hashCode() {
            String str = this.text;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            return a.t(a.L("DiscountLabel(text="), this.text, ")");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.text);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\b\b\u0018\u00002\u00020\u0001:\u0001(B%\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b&\u0010'J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ4\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0013J \u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fR\u001e\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010 \u001a\u0004\b!\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\"\u001a\u0004\b#\u0010\u0007R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010$\u001a\u0004\b%\u0010\u0004¨\u0006)"}, d2 = {"Lcom/avito/android/remote/model/SafeDeal$Info;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/SafeDeal$Info$OrderType;", "component2", "()Lcom/avito/android/remote/model/SafeDeal$Info$OrderType;", "Lcom/avito/android/deep_linking/links/DeepLink;", "component3", "()Lcom/avito/android/deep_linking/links/DeepLink;", "title", "orderType", "deeplink", "copy", "(Ljava/lang/String;Lcom/avito/android/remote/model/SafeDeal$Info$OrderType;Lcom/avito/android/deep_linking/links/DeepLink;)Lcom/avito/android/remote/model/SafeDeal$Info;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeeplink", "Lcom/avito/android/remote/model/SafeDeal$Info$OrderType;", "getOrderType", "Ljava/lang/String;", "getTitle", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/SafeDeal$Info$OrderType;Lcom/avito/android/deep_linking/links/DeepLink;)V", "OrderType", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Info implements Parcelable {
        public static final Parcelable.Creator<Info> CREATOR = new Creator();
        @SerializedName(ShareConstants.MEDIA_URI)
        @Nullable
        private final DeepLink deeplink;
        @SerializedName("orderType")
        @Nullable
        private final OrderType orderType;
        @SerializedName("title")
        @Nullable
        private final String title;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Info> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Info createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Info(parcel.readString(), parcel.readInt() != 0 ? (OrderType) Enum.valueOf(OrderType.class, parcel.readString()) : null, (DeepLink) parcel.readParcelable(Info.class.getClassLoader()));
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Info[] newArray(int i) {
                return new Info[i];
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/remote/model/SafeDeal$Info$OrderType;", "", "<init>", "(Ljava/lang/String;I)V", "DELIVERY", "COURIER", "SAFE_DEAL", "models_release"}, k = 1, mv = {1, 4, 2})
        public enum OrderType {
            DELIVERY,
            COURIER,
            SAFE_DEAL
        }

        public Info(@Nullable String str, @Nullable OrderType orderType2, @Nullable DeepLink deepLink) {
            this.title = str;
            this.orderType = orderType2;
            this.deeplink = deepLink;
        }

        public static /* synthetic */ Info copy$default(Info info, String str, OrderType orderType2, DeepLink deepLink, int i, Object obj) {
            if ((i & 1) != 0) {
                str = info.title;
            }
            if ((i & 2) != 0) {
                orderType2 = info.orderType;
            }
            if ((i & 4) != 0) {
                deepLink = info.deeplink;
            }
            return info.copy(str, orderType2, deepLink);
        }

        @Nullable
        public final String component1() {
            return this.title;
        }

        @Nullable
        public final OrderType component2() {
            return this.orderType;
        }

        @Nullable
        public final DeepLink component3() {
            return this.deeplink;
        }

        @NotNull
        public final Info copy(@Nullable String str, @Nullable OrderType orderType2, @Nullable DeepLink deepLink) {
            return new Info(str, orderType2, deepLink);
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
            if (!(obj instanceof Info)) {
                return false;
            }
            Info info = (Info) obj;
            return Intrinsics.areEqual(this.title, info.title) && Intrinsics.areEqual(this.orderType, info.orderType) && Intrinsics.areEqual(this.deeplink, info.deeplink);
        }

        @Nullable
        public final DeepLink getDeeplink() {
            return this.deeplink;
        }

        @Nullable
        public final OrderType getOrderType() {
            return this.orderType;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        @Override // java.lang.Object
        public int hashCode() {
            String str = this.title;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            OrderType orderType2 = this.orderType;
            int hashCode2 = (hashCode + (orderType2 != null ? orderType2.hashCode() : 0)) * 31;
            DeepLink deepLink = this.deeplink;
            if (deepLink != null) {
                i = deepLink.hashCode();
            }
            return hashCode2 + i;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("Info(title=");
            L.append(this.title);
            L.append(", orderType=");
            L.append(this.orderType);
            L.append(", deeplink=");
            return a.m(L, this.deeplink, ")");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.title);
            OrderType orderType2 = this.orderType;
            if (orderType2 != null) {
                parcel.writeInt(1);
                parcel.writeString(orderType2.name());
            } else {
                parcel.writeInt(0);
            }
            parcel.writeParcelable(this.deeplink, i);
        }
    }

    public SafeDeal(@Nullable List<String> list, @Nullable List<MyAdvertSafeDeal.Service> list2, @Nullable Actions actions2, @Nullable Info info2, @Nullable Button button2, @Nullable About about2) {
        this.orderTypes = list;
        this.services = list2;
        this.actions = actions2;
        this.info = info2;
        this.button = button2;
        this.about = about2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.avito.android.remote.model.SafeDeal */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SafeDeal copy$default(SafeDeal safeDeal, List list, List list2, Actions actions2, Info info2, Button button2, About about2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = safeDeal.orderTypes;
        }
        if ((i & 2) != 0) {
            list2 = safeDeal.services;
        }
        if ((i & 4) != 0) {
            actions2 = safeDeal.actions;
        }
        if ((i & 8) != 0) {
            info2 = safeDeal.info;
        }
        if ((i & 16) != 0) {
            button2 = safeDeal.button;
        }
        if ((i & 32) != 0) {
            about2 = safeDeal.about;
        }
        return safeDeal.copy(list, list2, actions2, info2, button2, about2);
    }

    public static /* synthetic */ void getFormattedOrderTypes$annotations() {
    }

    @Nullable
    public final List<String> component1() {
        return this.orderTypes;
    }

    @Nullable
    public final List<MyAdvertSafeDeal.Service> component2() {
        return this.services;
    }

    @Nullable
    public final Actions component3() {
        return this.actions;
    }

    @Nullable
    public final Info component4() {
        return this.info;
    }

    @Nullable
    public final Button component5() {
        return this.button;
    }

    @Nullable
    public final About component6() {
        return this.about;
    }

    @NotNull
    public final SafeDeal copy(@Nullable List<String> list, @Nullable List<MyAdvertSafeDeal.Service> list2, @Nullable Actions actions2, @Nullable Info info2, @Nullable Button button2, @Nullable About about2) {
        return new SafeDeal(list, list2, actions2, info2, button2, about2);
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
        if (!(obj instanceof SafeDeal)) {
            return false;
        }
        SafeDeal safeDeal = (SafeDeal) obj;
        return Intrinsics.areEqual(this.orderTypes, safeDeal.orderTypes) && Intrinsics.areEqual(this.services, safeDeal.services) && Intrinsics.areEqual(this.actions, safeDeal.actions) && Intrinsics.areEqual(this.info, safeDeal.info) && Intrinsics.areEqual(this.button, safeDeal.button) && Intrinsics.areEqual(this.about, safeDeal.about);
    }

    @Nullable
    public final About getAbout() {
        return this.about;
    }

    @Nullable
    public final Actions getActions() {
        return this.actions;
    }

    @Nullable
    public final Button getButton() {
        return this.button;
    }

    @Nullable
    public final String getFormattedOrderTypes() {
        List<String> list = this.orderTypes;
        if (list != null) {
            return CollectionsKt___CollectionsKt.joinToString$default(list, null, "[", "]", 0, null, SafeDeal$formattedOrderTypes$1.INSTANCE, 25, null);
        }
        return null;
    }

    @Nullable
    public final Info getInfo() {
        return this.info;
    }

    @Nullable
    public final List<String> getOrderTypes() {
        return this.orderTypes;
    }

    @Nullable
    public final List<MyAdvertSafeDeal.Service> getServices() {
        return this.services;
    }

    @Override // java.lang.Object
    public int hashCode() {
        List<String> list = this.orderTypes;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        List<MyAdvertSafeDeal.Service> list2 = this.services;
        int hashCode2 = (hashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
        Actions actions2 = this.actions;
        int hashCode3 = (hashCode2 + (actions2 != null ? actions2.hashCode() : 0)) * 31;
        Info info2 = this.info;
        int hashCode4 = (hashCode3 + (info2 != null ? info2.hashCode() : 0)) * 31;
        Button button2 = this.button;
        int hashCode5 = (hashCode4 + (button2 != null ? button2.hashCode() : 0)) * 31;
        About about2 = this.about;
        if (about2 != null) {
            i = about2.hashCode();
        }
        return hashCode5 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("SafeDeal(orderTypes=");
        L.append(this.orderTypes);
        L.append(", services=");
        L.append(this.services);
        L.append(", actions=");
        L.append(this.actions);
        L.append(", info=");
        L.append(this.info);
        L.append(", button=");
        L.append(this.button);
        L.append(", about=");
        L.append(this.about);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeStringList(this.orderTypes);
        List<MyAdvertSafeDeal.Service> list = this.services;
        if (list != null) {
            Iterator l0 = a.l0(parcel, 1, list);
            while (l0.hasNext()) {
                ((MyAdvertSafeDeal.Service) l0.next()).writeToParcel(parcel, 0);
            }
        } else {
            parcel.writeInt(0);
        }
        Actions actions2 = this.actions;
        if (actions2 != null) {
            parcel.writeInt(1);
            actions2.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        Info info2 = this.info;
        if (info2 != null) {
            parcel.writeInt(1);
            info2.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        Button button2 = this.button;
        if (button2 != null) {
            parcel.writeInt(1);
            button2.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        About about2 = this.about;
        if (about2 != null) {
            parcel.writeInt(1);
            about2.writeToParcel(parcel, 0);
            return;
        }
        parcel.writeInt(0);
    }
}
