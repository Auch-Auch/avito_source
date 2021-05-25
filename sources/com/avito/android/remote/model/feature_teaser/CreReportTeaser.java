package com.avito.android.remote.model.feature_teaser;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.deep_linking.links.ConsultationFormLink;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.DetailsSheetButton;
import com.avito.android.deep_linking.links.DetailsSheetLink;
import com.avito.android.deep_linking.links.DetailsSheetLinkBody;
import com.avito.android.remote.model.ConsultationFormData;
import com.avito.android.remote.model.Coordinates;
import com.avito.android.remote.model.FormCategory;
import com.avito.android.remote.model.FormInput;
import com.avito.android.remote.model.GeoReference;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.SerpElement;
import com.avito.android.remote.model.SuccessAction;
import com.avito.android.remote.model.UniversalColor;
import com.avito.android.remote.model.feature_teaser.CreReportTeaser;
import com.avito.android.remote.model.text.AttributedText;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002:\u0006;<=>?@B\u0001\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\"\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u00103\u001a\u000202\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010+\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010+\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b9\u0010:J\u0019\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ \u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014R(\u0010\u0018\u001a\u00020\u00178\u0016@\u0016X\u000e¢\u0006\u0018\n\u0004\b\u0018\u0010\u0019\u0012\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010 \u001a\u0004\u0018\u00010\u00038\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b \u0010\u0012\u001a\u0004\b!\u0010\u0014R$\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\"8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001e\u0010'\u001a\u0004\u0018\u00010\u00038\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b'\u0010\u0012\u001a\u0004\b(\u0010\u0014R\u001e\u0010)\u001a\u0004\u0018\u00010\u00038\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b)\u0010\u0012\u001a\u0004\b*\u0010\u0014R\u001e\u0010,\u001a\u0004\u0018\u00010+8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u001e\u00100\u001a\u0004\u0018\u00010\u00038\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b0\u0010\u0012\u001a\u0004\b1\u0010\u0014R\u001c\u00103\u001a\u0002028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u001e\u00107\u001a\u0004\u0018\u00010+8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b7\u0010-\u001a\u0004\b8\u0010/¨\u0006A"}, d2 = {"Lcom/avito/android/remote/model/feature_teaser/CreReportTeaser;", "Landroid/os/Parcelable;", "Lcom/avito/android/remote/model/SerpElement;", "", BookingInfoActivity.EXTRA_ITEM_ID, "Lcom/avito/android/deep_linking/links/DeepLink;", "toConsultationFormDeepLink", "(Ljava/lang/String;)Lcom/avito/android/deep_linking/links/DeepLink;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", MessengerShareContentUtility.SUBTITLE, "Ljava/lang/String;", "getSubtitle", "()Ljava/lang/String;", "serpShowDescriptionTitle", "getSerpShowDescriptionTitle", "", "uniqueId", "J", "getUniqueId", "()J", "setUniqueId", "(J)V", "getUniqueId$annotations", "()V", "title", "getTitle", "", "insights", "Ljava/util/List;", "getInsights", "()Ljava/util/List;", "showDescriptionTitle", "getShowDescriptionTitle", "serpTitle", "getSerpTitle", "Lcom/avito/android/remote/model/UniversalColor;", "backgroundColor", "Lcom/avito/android/remote/model/UniversalColor;", "getBackgroundColor", "()Lcom/avito/android/remote/model/UniversalColor;", "image", "getImage", "Lcom/avito/android/remote/model/feature_teaser/CreReportTeaser$Description;", "description", "Lcom/avito/android/remote/model/feature_teaser/CreReportTeaser$Description;", "getDescription", "()Lcom/avito/android/remote/model/feature_teaser/CreReportTeaser$Description;", "highlightedBackgroundColor", "getHighlightedBackgroundColor", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/avito/android/remote/model/feature_teaser/CreReportTeaser$Description;Lcom/avito/android/remote/model/UniversalColor;Lcom/avito/android/remote/model/UniversalColor;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Description", "DescriptionForm", "DescriptionInsight", "FormId", "ItemPreview", "ReportPlug", "api_release"}, k = 1, mv = {1, 4, 2})
public class CreReportTeaser implements Parcelable, SerpElement {
    public static final Parcelable.Creator<CreReportTeaser> CREATOR = new Creator();
    @SerializedName("backgroundColor")
    @Nullable
    private final UniversalColor backgroundColor;
    @SerializedName("description")
    @NotNull
    private final Description description;
    @SerializedName("highlightedBackgroundColor")
    @Nullable
    private final UniversalColor highlightedBackgroundColor;
    @SerializedName("imageName")
    @Nullable
    private final String image;
    @SerializedName("insights")
    @Nullable
    private final List<String> insights;
    @SerializedName("serpShowDescriptionTitle")
    @Nullable
    private final String serpShowDescriptionTitle;
    @SerializedName("serpTitle")
    @Nullable
    private final String serpTitle;
    @SerializedName("showDescriptionTitle")
    @Nullable
    private final String showDescriptionTitle;
    @SerializedName(MessengerShareContentUtility.SUBTITLE)
    @Nullable
    private final String subtitle;
    @SerializedName("title")
    @Nullable
    private final String title;
    private long uniqueId;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<CreReportTeaser> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CreReportTeaser createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new CreReportTeaser(parcel.readString(), parcel.readString(), parcel.createStringArrayList(), parcel.readString(), Description.CREATOR.createFromParcel(parcel), (UniversalColor) parcel.readParcelable(CreReportTeaser.class.getClassLoader()), (UniversalColor) parcel.readParcelable(CreReportTeaser.class.getClassLoader()), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CreReportTeaser[] newArray(int i) {
            return new CreReportTeaser[i];
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0001\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0011\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u000101\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 \u0012\u0010\b\u0002\u0010(\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u000b\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b6\u00107J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR$\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR$\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u000e\u001a\u0004\b\u001f\u0010\u0010R\u001e\u0010!\u001a\u0004\u0018\u00010 8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001e\u0010%\u001a\u0004\u0018\u00010\u00118\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b%\u0010\u0013\u001a\u0004\b&\u0010\u0015R$\u0010(\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b(\u0010\u000e\u001a\u0004\b)\u0010\u0010R\u001e\u0010+\u001a\u0004\u0018\u00010*8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u001e\u0010/\u001a\u0004\u0018\u00010\u00118\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b/\u0010\u0013\u001a\u0004\b0\u0010\u0015R\u001e\u00102\u001a\u0004\u0018\u0001018\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105¨\u00068"}, d2 = {"Lcom/avito/android/remote/model/feature_teaser/CreReportTeaser$Description;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "Lcom/avito/android/remote/model/feature_teaser/CreReportTeaser$DescriptionInsight;", "insights", "Ljava/util/List;", "getInsights", "()Ljava/util/List;", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "getAddress", "Lcom/avito/android/remote/model/text/AttributedText;", "addition", "Lcom/avito/android/remote/model/text/AttributedText;", "getAddition", "()Lcom/avito/android/remote/model/text/AttributedText;", "Lcom/avito/android/remote/model/feature_teaser/CreReportTeaser$DescriptionForm;", "inputs", "getInputs", "Lcom/avito/android/remote/model/feature_teaser/CreReportTeaser$ItemPreview;", "itemPreview", "Lcom/avito/android/remote/model/feature_teaser/CreReportTeaser$ItemPreview;", "getItemPreview", "()Lcom/avito/android/remote/model/feature_teaser/CreReportTeaser$ItemPreview;", MessengerShareContentUtility.SUBTITLE, "getSubtitle", "Lcom/avito/android/remote/model/GeoReference;", "geoReferences", "getGeoReferences", "Lcom/avito/android/remote/model/Coordinates;", "coordinates", "Lcom/avito/android/remote/model/Coordinates;", "getCoordinates", "()Lcom/avito/android/remote/model/Coordinates;", "reportButtonTitle", "getReportButtonTitle", "Lcom/avito/android/remote/model/feature_teaser/CreReportTeaser$ReportPlug;", "reportPlugDialog", "Lcom/avito/android/remote/model/feature_teaser/CreReportTeaser$ReportPlug;", "getReportPlugDialog", "()Lcom/avito/android/remote/model/feature_teaser/CreReportTeaser$ReportPlug;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lcom/avito/android/remote/model/text/AttributedText;Ljava/lang/String;Lcom/avito/android/remote/model/feature_teaser/CreReportTeaser$ReportPlug;Lcom/avito/android/remote/model/feature_teaser/CreReportTeaser$ItemPreview;Ljava/util/List;Lcom/avito/android/remote/model/Coordinates;Ljava/lang/String;)V", "api_release"}, k = 1, mv = {1, 4, 2})
    public static final class Description implements Parcelable {
        public static final Parcelable.Creator<Description> CREATOR = new Creator();
        @SerializedName("addition")
        @Nullable
        private final AttributedText addition;
        @SerializedName(IntegrityManager.INTEGRITY_TYPE_ADDRESS)
        @Nullable
        private final String address;
        @SerializedName("coordinates")
        @Nullable
        private final Coordinates coordinates;
        @SerializedName("geoReferences")
        @Nullable
        private final List<GeoReference> geoReferences;
        @SerializedName("form")
        @Nullable
        private final List<DescriptionForm> inputs;
        @SerializedName("insights")
        @Nullable
        private final List<DescriptionInsight> insights;
        @SerializedName("itemPreview")
        @Nullable
        private final ItemPreview itemPreview;
        @SerializedName("reportButtonTitle")
        @Nullable
        private final String reportButtonTitle;
        @SerializedName("plug")
        @Nullable
        private final ReportPlug reportPlugDialog;
        @SerializedName(MessengerShareContentUtility.SUBTITLE)
        @Nullable
        private final String subtitle;
        @SerializedName("title")
        @Nullable
        private final String title;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Description> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Description createFromParcel(@NotNull Parcel parcel) {
                ArrayList arrayList;
                ArrayList arrayList2;
                Intrinsics.checkNotNullParameter(parcel, "in");
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                ArrayList arrayList3 = null;
                if (parcel.readInt() != 0) {
                    int readInt = parcel.readInt();
                    arrayList = new ArrayList(readInt);
                    while (readInt != 0) {
                        arrayList.add(DescriptionInsight.CREATOR.createFromParcel(parcel));
                        readInt--;
                    }
                } else {
                    arrayList = null;
                }
                if (parcel.readInt() != 0) {
                    int readInt2 = parcel.readInt();
                    arrayList2 = new ArrayList(readInt2);
                    while (readInt2 != 0) {
                        arrayList2.add(DescriptionForm.CREATOR.createFromParcel(parcel));
                        readInt2--;
                    }
                } else {
                    arrayList2 = null;
                }
                AttributedText attributedText = (AttributedText) parcel.readParcelable(Description.class.getClassLoader());
                String readString3 = parcel.readString();
                ReportPlug createFromParcel = parcel.readInt() != 0 ? ReportPlug.CREATOR.createFromParcel(parcel) : null;
                ItemPreview createFromParcel2 = parcel.readInt() != 0 ? ItemPreview.CREATOR.createFromParcel(parcel) : null;
                if (parcel.readInt() != 0) {
                    int readInt3 = parcel.readInt();
                    arrayList3 = new ArrayList(readInt3);
                    while (readInt3 != 0) {
                        arrayList3.add((GeoReference) parcel.readParcelable(Description.class.getClassLoader()));
                        readInt3--;
                    }
                }
                return new Description(readString, readString2, arrayList, arrayList2, attributedText, readString3, createFromParcel, createFromParcel2, arrayList3, (Coordinates) parcel.readParcelable(Description.class.getClassLoader()), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Description[] newArray(int i) {
                return new Description[i];
            }
        }

        public Description() {
            this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
        }

        public Description(@Nullable String str, @Nullable String str2, @Nullable List<DescriptionInsight> list, @Nullable List<DescriptionForm> list2, @Nullable AttributedText attributedText, @Nullable String str3, @Nullable ReportPlug reportPlug, @Nullable ItemPreview itemPreview2, @Nullable List<GeoReference> list3, @Nullable Coordinates coordinates2, @Nullable String str4) {
            this.title = str;
            this.address = str2;
            this.insights = list;
            this.inputs = list2;
            this.addition = attributedText;
            this.reportButtonTitle = str3;
            this.reportPlugDialog = reportPlug;
            this.itemPreview = itemPreview2;
            this.geoReferences = list3;
            this.coordinates = coordinates2;
            this.subtitle = str4;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Nullable
        public final AttributedText getAddition() {
            return this.addition;
        }

        @Nullable
        public final String getAddress() {
            return this.address;
        }

        @Nullable
        public final Coordinates getCoordinates() {
            return this.coordinates;
        }

        @Nullable
        public final List<GeoReference> getGeoReferences() {
            return this.geoReferences;
        }

        @Nullable
        public final List<DescriptionForm> getInputs() {
            return this.inputs;
        }

        @Nullable
        public final List<DescriptionInsight> getInsights() {
            return this.insights;
        }

        @Nullable
        public final ItemPreview getItemPreview() {
            return this.itemPreview;
        }

        @Nullable
        public final String getReportButtonTitle() {
            return this.reportButtonTitle;
        }

        @Nullable
        public final ReportPlug getReportPlugDialog() {
            return this.reportPlugDialog;
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
            parcel.writeString(this.title);
            parcel.writeString(this.address);
            List<DescriptionInsight> list = this.insights;
            if (list != null) {
                Iterator l0 = a.l0(parcel, 1, list);
                while (l0.hasNext()) {
                    ((DescriptionInsight) l0.next()).writeToParcel(parcel, 0);
                }
            } else {
                parcel.writeInt(0);
            }
            List<DescriptionForm> list2 = this.inputs;
            if (list2 != null) {
                Iterator l02 = a.l0(parcel, 1, list2);
                while (l02.hasNext()) {
                    ((DescriptionForm) l02.next()).writeToParcel(parcel, 0);
                }
            } else {
                parcel.writeInt(0);
            }
            parcel.writeParcelable(this.addition, i);
            parcel.writeString(this.reportButtonTitle);
            ReportPlug reportPlug = this.reportPlugDialog;
            if (reportPlug != null) {
                parcel.writeInt(1);
                reportPlug.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            ItemPreview itemPreview2 = this.itemPreview;
            if (itemPreview2 != null) {
                parcel.writeInt(1);
                itemPreview2.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            List<GeoReference> list3 = this.geoReferences;
            if (list3 != null) {
                Iterator l03 = a.l0(parcel, 1, list3);
                while (l03.hasNext()) {
                    parcel.writeParcelable((GeoReference) l03.next(), i);
                }
            } else {
                parcel.writeInt(0);
            }
            parcel.writeParcelable(this.coordinates, i);
            parcel.writeString(this.subtitle);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Description(String str, String str2, List list, List list2, AttributedText attributedText, String str3, ReportPlug reportPlug, ItemPreview itemPreview2, List list3, Coordinates coordinates2, String str4, int i, j jVar) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : list, (i & 8) != 0 ? null : list2, (i & 16) != 0 ? null : attributedText, (i & 32) != 0 ? null : str3, (i & 64) != 0 ? null : reportPlug, (i & 128) != 0 ? null : itemPreview2, (i & 256) != 0 ? null : list3, (i & 512) != 0 ? null : coordinates2, (i & 1024) == 0 ? str4 : null);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001BG\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000fR\u001c\u0010\u0015\u001a\u00020\u00148\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\r\u001a\u0004\b\u001a\u0010\u000fR\u001c\u0010\u001c\u001a\u00020\u001b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lcom/avito/android/remote/model/feature_teaser/CreReportTeaser$DescriptionForm;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "value", "getValue", InternalConstsKt.PLACEHOLDER, "getPlaceholder", "", "required", "Z", "getRequired", "()Z", "error", "getError", "Lcom/avito/android/remote/model/feature_teaser/CreReportTeaser$FormId;", "identifier", "Lcom/avito/android/remote/model/feature_teaser/CreReportTeaser$FormId;", "getIdentifier", "()Lcom/avito/android/remote/model/feature_teaser/CreReportTeaser$FormId;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lcom/avito/android/remote/model/feature_teaser/CreReportTeaser$FormId;)V", "api_release"}, k = 1, mv = {1, 4, 2})
    public static final class DescriptionForm implements Parcelable {
        public static final Parcelable.Creator<DescriptionForm> CREATOR = new Creator();
        @SerializedName("error")
        @Nullable
        private final String error;
        @SerializedName("identifier")
        @NotNull
        private final FormId identifier;
        @SerializedName(InternalConstsKt.PLACEHOLDER)
        @Nullable
        private final String placeholder;
        @SerializedName("required")
        private final boolean required;
        @SerializedName("title")
        @Nullable
        private final String title;
        @SerializedName("value")
        @Nullable
        private final String value;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<DescriptionForm> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final DescriptionForm createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new DescriptionForm(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readString(), (FormId) Enum.valueOf(FormId.class, parcel.readString()));
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final DescriptionForm[] newArray(int i) {
                return new DescriptionForm[i];
            }
        }

        public DescriptionForm(@Nullable String str, @Nullable String str2, @Nullable String str3, boolean z, @Nullable String str4, @NotNull FormId formId) {
            Intrinsics.checkNotNullParameter(formId, "identifier");
            this.title = str;
            this.placeholder = str2;
            this.value = str3;
            this.required = z;
            this.error = str4;
            this.identifier = formId;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Nullable
        public final String getError() {
            return this.error;
        }

        @NotNull
        public final FormId getIdentifier() {
            return this.identifier;
        }

        @Nullable
        public final String getPlaceholder() {
            return this.placeholder;
        }

        public final boolean getRequired() {
            return this.required;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        public final String getValue() {
            return this.value;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.title);
            parcel.writeString(this.placeholder);
            parcel.writeString(this.value);
            parcel.writeInt(this.required ? 1 : 0);
            parcel.writeString(this.error);
            parcel.writeString(this.identifier.name());
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ DescriptionForm(String str, String str2, String str3, boolean z, String str4, FormId formId, int i, j jVar) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, z, (i & 16) != 0 ? null : str4, formId);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/avito/android/remote/model/feature_teaser/CreReportTeaser$DescriptionInsight;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "description", "getDescription", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "api_release"}, k = 1, mv = {1, 4, 2})
    public static final class DescriptionInsight implements Parcelable {
        public static final Parcelable.Creator<DescriptionInsight> CREATOR = new Creator();
        @SerializedName("description")
        @Nullable
        private final String description;
        @SerializedName("title")
        @Nullable
        private final String title;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<DescriptionInsight> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final DescriptionInsight createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new DescriptionInsight(parcel.readString(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final DescriptionInsight[] newArray(int i) {
                return new DescriptionInsight[i];
            }
        }

        public DescriptionInsight() {
            this(null, null, 3, null);
        }

        public DescriptionInsight(@Nullable String str, @Nullable String str2) {
            this.title = str;
            this.description = str2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Nullable
        public final String getDescription() {
            return this.description;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.title);
            parcel.writeString(this.description);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ DescriptionInsight(String str, String str2, int i, j jVar) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/remote/model/feature_teaser/CreReportTeaser$FormId;", "", "<init>", "(Ljava/lang/String;I)V", "Name", "Phone", "api_release"}, k = 1, mv = {1, 4, 2})
    public enum FormId {
        Name,
        Phone
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/avito/android/remote/model/feature_teaser/CreReportTeaser$ItemPreview;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/Image;", "image", "Lcom/avito/android/remote/model/Image;", "getImage", "()Lcom/avito/android/remote/model/Image;", "", "info", "Ljava/lang/String;", "getInfo", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/Image;)V", "api_release"}, k = 1, mv = {1, 4, 2})
    public static final class ItemPreview implements Parcelable {
        public static final Parcelable.Creator<ItemPreview> CREATOR = new Creator();
        @SerializedName("image")
        @Nullable
        private final Image image;
        @SerializedName("info")
        @Nullable
        private final String info;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<ItemPreview> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final ItemPreview createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new ItemPreview(parcel.readString(), (Image) parcel.readParcelable(ItemPreview.class.getClassLoader()));
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final ItemPreview[] newArray(int i) {
                return new ItemPreview[i];
            }
        }

        public ItemPreview() {
            this(null, null, 3, null);
        }

        public ItemPreview(@Nullable String str, @Nullable Image image2) {
            this.info = str;
            this.image = image2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Nullable
        public final Image getImage() {
            return this.image;
        }

        @Nullable
        public final String getInfo() {
            return this.info;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.info);
            parcel.writeParcelable(this.image, i);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ItemPreview(String str, Image image2, int i, j jVar) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : image2);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\f\u0010\rR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012¨\u0006\u0019"}, d2 = {"Lcom/avito/android/remote/model/feature_teaser/CreReportTeaser$ReportPlug;", "Landroid/os/Parcelable;", "Lcom/avito/android/deep_linking/links/DeepLink;", "link", "()Lcom/avito/android/deep_linking/links/DeepLink;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "buttonTitle", "getButtonTitle", "description", "getDescription", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "api_release"}, k = 1, mv = {1, 4, 2})
    public static final class ReportPlug implements Parcelable {
        public static final Parcelable.Creator<ReportPlug> CREATOR = new Creator();
        @SerializedName("buttonTitle")
        @Nullable
        private final String buttonTitle;
        @SerializedName("description")
        @Nullable
        private final String description;
        @SerializedName("title")
        @Nullable
        private final String title;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<ReportPlug> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final ReportPlug createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new ReportPlug(parcel.readString(), parcel.readString(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final ReportPlug[] newArray(int i) {
                return new ReportPlug[i];
            }
        }

        public ReportPlug() {
            this(null, null, null, 7, null);
        }

        public ReportPlug(@Nullable String str, @Nullable String str2, @Nullable String str3) {
            this.title = str;
            this.description = str2;
            this.buttonTitle = str3;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Nullable
        public final String getButtonTitle() {
            return this.buttonTitle;
        }

        @Nullable
        public final String getDescription() {
            return this.description;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        @NotNull
        public final DeepLink link() {
            String str = this.title;
            String str2 = this.description;
            AttributedText attributedText = str2 != null ? new AttributedText(str2, CollectionsKt__CollectionsKt.emptyList()) : null;
            String str3 = this.buttonTitle;
            return new DetailsSheetLink(new DetailsSheetLinkBody(str, attributedText, null, str3 != null ? new DetailsSheetButton(str3, "secondary", null, null, 12, null) : null, null, null, Boolean.TRUE, null, 144, null));
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.title);
            parcel.writeString(this.description);
            parcel.writeString(this.buttonTitle);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ReportPlug(String str, String str2, String str3, int i, j jVar) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
        }
    }

    public CreReportTeaser(@Nullable String str, @Nullable String str2, @Nullable List<String> list, @Nullable String str3, @NotNull Description description2, @Nullable UniversalColor universalColor, @Nullable UniversalColor universalColor2, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
        Intrinsics.checkNotNullParameter(description2, "description");
        this.title = str;
        this.subtitle = str2;
        this.insights = list;
        this.showDescriptionTitle = str3;
        this.description = description2;
        this.backgroundColor = universalColor;
        this.highlightedBackgroundColor = universalColor2;
        this.image = str4;
        this.serpTitle = str5;
        this.serpShowDescriptionTitle = str6;
    }

    public static /* synthetic */ void getUniqueId$annotations() {
    }

    public static /* synthetic */ DeepLink toConsultationFormDeepLink$default(CreReportTeaser creReportTeaser, String str, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = null;
            }
            return creReportTeaser.toConsultationFormDeepLink(str);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toConsultationFormDeepLink");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final UniversalColor getBackgroundColor() {
        return this.backgroundColor;
    }

    @NotNull
    public final Description getDescription() {
        return this.description;
    }

    @Nullable
    public final UniversalColor getHighlightedBackgroundColor() {
        return this.highlightedBackgroundColor;
    }

    @Nullable
    public final String getImage() {
        return this.image;
    }

    @Nullable
    public final List<String> getInsights() {
        return this.insights;
    }

    @Nullable
    public final String getSerpShowDescriptionTitle() {
        return this.serpShowDescriptionTitle;
    }

    @Nullable
    public final String getSerpTitle() {
        return this.serpTitle;
    }

    @Nullable
    public final String getShowDescriptionTitle() {
        return this.showDescriptionTitle;
    }

    @Nullable
    public final String getSubtitle() {
        return this.subtitle;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Override // com.avito.android.remote.model.SerpElement
    public long getUniqueId() {
        return this.uniqueId;
    }

    @Override // com.avito.android.remote.model.SerpElement
    public void setUniqueId(long j) {
        this.uniqueId = j;
    }

    @NotNull
    public final DeepLink toConsultationFormDeepLink(@Nullable String str) {
        DeepLink link;
        CreReportTeaser$toConsultationFormDeepLink$1 creReportTeaser$toConsultationFormDeepLink$1 = new Function1<FormId, FormInput>(this) { // from class: com.avito.android.remote.model.feature_teaser.CreReportTeaser$toConsultationFormDeepLink$1
            public final /* synthetic */ CreReportTeaser this$0;

            {
                this.this$0 = r1;
            }

            @Nullable
            public final FormInput invoke(@NotNull CreReportTeaser.FormId formId) {
                boolean z;
                String placeholder;
                Intrinsics.checkNotNullParameter(formId, "formId");
                List<CreReportTeaser.DescriptionForm> inputs = this.this$0.getDescription().getInputs();
                FormInput formInput = null;
                if (inputs != null) {
                    for (T t : inputs) {
                        if (t.getIdentifier() == formId) {
                            z = true;
                            continue;
                        } else {
                            z = false;
                            continue;
                        }
                        if (z) {
                            if (t != null) {
                                String title2 = t.getTitle();
                                if (title2 == null || (placeholder = t.getPlaceholder()) == null) {
                                    return null;
                                }
                                formInput = new FormInput(title2, placeholder, t.getValue(), t.getError(), Boolean.valueOf(t.getRequired()), formId == CreReportTeaser.FormId.Phone);
                            }
                        }
                    }
                    throw new NoSuchElementException("Collection contains no element matching the predicate.");
                }
                return formInput;
            }
        };
        String title2 = this.description.getTitle();
        String subtitle2 = this.description.getSubtitle();
        FormInput invoke = creReportTeaser$toConsultationFormDeepLink$1.invoke(FormId.Name);
        FormInput invoke2 = creReportTeaser$toConsultationFormDeepLink$1.invoke(FormId.Phone);
        FormCategory formCategory = FormCategory.FindOfficeOffer;
        ReportPlug reportPlugDialog = this.description.getReportPlugDialog();
        return new ConsultationFormLink(new ConsultationFormData(title2, subtitle2, null, invoke, invoke2, null, null, (reportPlugDialog == null || (link = reportPlugDialog.link()) == null) ? null : new SuccessAction.OpenDeepLink(link), formCategory, 100, null), str);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.title);
        parcel.writeString(this.subtitle);
        parcel.writeStringList(this.insights);
        parcel.writeString(this.showDescriptionTitle);
        this.description.writeToParcel(parcel, 0);
        parcel.writeParcelable(this.backgroundColor, i);
        parcel.writeParcelable(this.highlightedBackgroundColor, i);
        parcel.writeString(this.image);
        parcel.writeString(this.serpTitle);
        parcel.writeString(this.serpShowDescriptionTitle);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CreReportTeaser(String str, String str2, List list, String str3, Description description2, UniversalColor universalColor, UniversalColor universalColor2, String str4, String str5, String str6, int i, j jVar) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : list, (i & 8) != 0 ? null : str3, description2, (i & 32) != 0 ? null : universalColor, (i & 64) != 0 ? null : universalColor2, (i & 128) != 0 ? null : str4, (i & 256) != 0 ? null : str5, (i & 512) != 0 ? null : str6);
    }
}
