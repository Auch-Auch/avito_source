package com.avito.android.remote.model.category_parameters;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.remote.model.ImageUpload;
import com.avito.android.remote.model.ImageUploadResult;
import com.avito.android.remote.model.category_parameters.base.EditableParameter;
import com.avito.android.remote.model.category_parameters.base.HasConstraints;
import com.avito.android.remote.model.category_parameters.base.TextParameter;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.util.Parcels;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableList;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b*\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0001dB{\u0012\u0006\u0010$\u001a\u00020\f\u0012\u0006\u0010%\u001a\u00020\f\u0012\b\u0010&\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010'\u001a\u00020\u0013\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0013\u0012\u0010\b\u0002\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010+\u001a\u00020\u0005\u0012\b\b\u0002\u0010,\u001a\u00020\u0005\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010.\u001a\u0004\u0018\u00010!¢\u0006\u0004\bb\u0010cJ\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\n\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u000eJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u0007J\u0010\u0010\u001f\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u0007J\u0012\u0010 \u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0004\b \u0010\u0017J\u0012\u0010\"\u001a\u0004\u0018\u00010!HÆ\u0003¢\u0006\u0004\b\"\u0010#J\u0001\u0010/\u001a\u00020\u00002\b\b\u0002\u0010$\u001a\u00020\f2\b\b\u0002\u0010%\u001a\u00020\f2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010'\u001a\u00020\u00132\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00132\u0010\b\u0002\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00182\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010+\u001a\u00020\u00052\b\b\u0002\u0010,\u001a\u00020\u00052\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010.\u001a\u0004\u0018\u00010!HÆ\u0001¢\u0006\u0004\b/\u00100J\u0010\u00101\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b1\u0010\u000eJ\u0010\u00102\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b2\u0010\u0015J\u001a\u00105\u001a\u00020\u00052\b\u00104\u001a\u0004\u0018\u000103HÖ\u0003¢\u0006\u0004\b5\u00106J\u0010\u00107\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b7\u0010\u0015J \u0010<\u001a\u00020;2\u0006\u00109\u001a\u0002082\u0006\u0010:\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b<\u0010=R$\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00188\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b)\u0010>\u001a\u0004\b?\u0010\u001bR$\u0010@\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0004¢\u0006\u0012\n\u0004\b@\u0010A\u0012\u0004\bD\u0010E\u001a\u0004\bB\u0010CR\u001c\u0010+\u001a\u00020\u00058\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b+\u0010F\u001a\u0004\bG\u0010\u0007R\u001e\u0010&\u001a\u0004\u0018\u00010\u00108\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b&\u0010H\u001a\u0004\bI\u0010\u0012R$\u0010J\u001a\u0004\u0018\u00010\f8\u0016@\u0016X\u0004¢\u0006\u0012\n\u0004\bJ\u0010K\u0012\u0004\bM\u0010E\u001a\u0004\bL\u0010\u000eR\u001c\u0010,\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b,\u0010F\u001a\u0004\bN\u0010\u0007R\u001b\u0010(\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010O\u001a\u0004\bP\u0010\u0017R\u001c\u0010$\u001a\u00020\f8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b$\u0010K\u001a\u0004\bQ\u0010\u000eR\u001e\u0010.\u001a\u0004\u0018\u00010!8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b.\u0010R\u001a\u0004\bS\u0010#R$\u0010*\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b*\u0010T\u001a\u0004\bU\u0010\u001d\"\u0004\bV\u0010WR\u001c\u0010'\u001a\u00020\u00138\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b'\u0010X\u001a\u0004\bY\u0010\u0015R\"\u0010Z\u001a\u00020\u00058\u0016@\u0016XD¢\u0006\u0012\n\u0004\bZ\u0010F\u0012\u0004\b\\\u0010E\u001a\u0004\b[\u0010\u0007R\u001c\u0010%\u001a\u00020\f8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b%\u0010K\u001a\u0004\b]\u0010\u000eR\u001e\u0010-\u001a\u0004\u0018\u00010\u00138\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b-\u0010O\u001a\u0004\b^\u0010\u0017R$\u0010_\u001a\u0004\u0018\u00010\f8\u0016@\u0016X\u0004¢\u0006\u0012\n\u0004\b_\u0010K\u0012\u0004\ba\u0010E\u001a\u0004\b`\u0010\u000e¨\u0006e"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/PhotoParameter;", "Lcom/avito/android/remote/model/category_parameters/base/EditableParameter;", "Lcom/avito/android/remote/model/category_parameters/PhotoParameter$ImageUploadListWrapper;", "Lcom/avito/android/remote/model/category_parameters/base/HasConstraints;", "Lcom/avito/android/remote/model/category_parameters/base/TextParameter;", "", "hasValue", "()Z", "oldValue", "newValue", "areValuesTheSame", "(Lcom/avito/android/remote/model/category_parameters/PhotoParameter$ImageUploadListWrapper;Lcom/avito/android/remote/model/category_parameters/PhotoParameter$ImageUploadListWrapper;)Z", "", "component1", "()Ljava/lang/String;", "component2", "Lcom/avito/android/remote/model/text/AttributedText;", "component3", "()Lcom/avito/android/remote/model/text/AttributedText;", "", "component4", "()I", "component5", "()Ljava/lang/Integer;", "", "Lcom/avito/android/remote/model/category_parameters/Constraint;", "component6", "()Ljava/util/List;", "component7", "()Lcom/avito/android/remote/model/category_parameters/PhotoParameter$ImageUploadListWrapper;", "component8", "component9", "component10", "Lcom/avito/android/remote/model/category_parameters/DisplayingOptions;", "component11", "()Lcom/avito/android/remote/model/category_parameters/DisplayingOptions;", "id", "title", "motivation", "maxCount", "recommendedAmount", "constraints", "_value", "required", "shouldUploadPhotoForCV", "suggestByPhotoMaxImages", "displayingOptions", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;ILjava/lang/Integer;Ljava/util/List;Lcom/avito/android/remote/model/category_parameters/PhotoParameter$ImageUploadListWrapper;ZZLjava/lang/Integer;Lcom/avito/android/remote/model/category_parameters/DisplayingOptions;)Lcom/avito/android/remote/model/category_parameters/PhotoParameter;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/util/List;", "getConstraints", "updatesForm", "Ljava/lang/Boolean;", "getUpdatesForm", "()Ljava/lang/Boolean;", "getUpdatesForm$annotations", "()V", "Z", "getRequired", "Lcom/avito/android/remote/model/text/AttributedText;", "getMotivation", InternalConstsKt.PLACEHOLDER, "Ljava/lang/String;", "getPlaceholder", "getPlaceholder$annotations", "getShouldUploadPhotoForCV", "Ljava/lang/Integer;", "getRecommendedAmount", "getId", "Lcom/avito/android/remote/model/category_parameters/DisplayingOptions;", "getDisplayingOptions", "Lcom/avito/android/remote/model/category_parameters/PhotoParameter$ImageUploadListWrapper;", "get_value", "set_value", "(Lcom/avito/android/remote/model/category_parameters/PhotoParameter$ImageUploadListWrapper;)V", "I", "getMaxCount", "immutable", "getImmutable", "getImmutable$annotations", "getTitle", "getSuggestByPhotoMaxImages", "hint", "getHint", "getHint$annotations", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;ILjava/lang/Integer;Ljava/util/List;Lcom/avito/android/remote/model/category_parameters/PhotoParameter$ImageUploadListWrapper;ZZLjava/lang/Integer;Lcom/avito/android/remote/model/category_parameters/DisplayingOptions;)V", "ImageUploadListWrapper", "models_release"}, k = 1, mv = {1, 4, 2})
public final class PhotoParameter extends EditableParameter<ImageUploadListWrapper> implements HasConstraints, TextParameter {
    public static final Parcelable.Creator<PhotoParameter> CREATOR = new Creator();
    @SerializedName("value")
    @Nullable
    private ImageUploadListWrapper _value;
    @SerializedName("constraints")
    @Nullable
    private final List<Constraint> constraints;
    @SerializedName("displaying")
    @Nullable
    private final DisplayingOptions displayingOptions;
    @Nullable
    private final String hint;
    @SerializedName("id")
    @NotNull
    private final String id;
    private final boolean immutable;
    @SerializedName("maxCount")
    private final int maxCount;
    @SerializedName("motivation")
    @Nullable
    private final AttributedText motivation;
    @Nullable
    private final String placeholder;
    @Nullable
    private final Integer recommendedAmount;
    @SerializedName("required")
    private final boolean required;
    @SerializedName("shouldUploadPhotoForCV")
    private final boolean shouldUploadPhotoForCV;
    @SerializedName("suggestByPhotoMaxImages")
    @Nullable
    private final Integer suggestByPhotoMaxImages;
    @SerializedName("title")
    @NotNull
    private final String title;
    @Nullable
    private final Boolean updatesForm;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<PhotoParameter> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PhotoParameter createFromParcel(@NotNull Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            AttributedText attributedText = (AttributedText) parcel.readParcelable(PhotoParameter.class.getClassLoader());
            int readInt = parcel.readInt();
            Integer valueOf = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            if (parcel.readInt() != 0) {
                int readInt2 = parcel.readInt();
                arrayList = new ArrayList(readInt2);
                while (readInt2 != 0) {
                    arrayList.add((Constraint) parcel.readParcelable(PhotoParameter.class.getClassLoader()));
                    readInt2--;
                }
            } else {
                arrayList = null;
            }
            ImageUploadListWrapper imageUploadListWrapper = (ImageUploadListWrapper) parcel.readParcelable(PhotoParameter.class.getClassLoader());
            boolean z = true;
            boolean z2 = parcel.readInt() != 0;
            if (parcel.readInt() == 0) {
                z = false;
            }
            return new PhotoParameter(readString, readString2, attributedText, readInt, valueOf, arrayList, imageUploadListWrapper, z2, z, parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null, parcel.readInt() != 0 ? DisplayingOptions.CREATOR.createFromParcel(parcel) : null);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PhotoParameter[] newArray(int i) {
            return new PhotoParameter[i];
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u000e\n\u0002\u0010)\n\u0002\b\u0003\n\u0002\u0010+\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u000b\b\b\u0018\u0000 J2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001JB\u0017\u0012\u000e\b\u0002\u00109\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0004\bH\u0010IJ\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0013\u0010\u0014J \u0010\u0013\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0013\u0010\u0016J&\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00042\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u0017H\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001e\u0010\u0019\u001a\u00020\u00122\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u0017H\u0001¢\u0006\u0004\b\u0019\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\nH\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0002H\u0003¢\u0006\u0004\b\u001e\u0010\u0014J\u001e\u0010\u001f\u001a\u00020\u00122\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u0017H\u0001¢\u0006\u0004\b\u001f\u0010\u001bJ\u0018\u0010 \u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0004H\u0003¢\u0006\u0004\b \u0010!J\u0018\u0010\"\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\"\u0010#J\u0010\u0010$\u001a\u00020\u0012H\u0001¢\u0006\u0004\b$\u0010%J\u0016\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00020&H\u0003¢\u0006\u0004\b'\u0010(J\u0018\u0010)\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0002H\u0001¢\u0006\u0004\b)\u0010#J\u0016\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00020*H\u0001¢\u0006\u0004\b+\u0010,J\u001e\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00020*2\u0006\u0010\u0015\u001a\u00020\u0004H\u0001¢\u0006\u0004\b+\u0010-J\u0018\u0010.\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0002H\u0001¢\u0006\u0004\b.\u0010\u0014J\u001e\u0010/\u001a\u00020\u00122\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u0017H\u0001¢\u0006\u0004\b/\u0010\u001bJ\u0018\u00100\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0004H\u0001¢\u0006\u0004\b0\u0010!J\u001e\u00101\u001a\u00020\u00122\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u0017H\u0001¢\u0006\u0004\b1\u0010\u001bJ \u00102\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0002H\u0003¢\u0006\u0004\b2\u00103J&\u00106\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u00104\u001a\u00020\u00042\u0006\u00105\u001a\u00020\u0004H\u0001¢\u0006\u0004\b6\u00107J\u0016\u00108\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001HÆ\u0003¢\u0006\u0004\b8\u0010\u0010J \u0010:\u001a\u00020\u00002\u000e\b\u0002\u00109\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001HÆ\u0001¢\u0006\u0004\b:\u0010;J\u0010\u0010=\u001a\u00020<HÖ\u0001¢\u0006\u0004\b=\u0010>J\u0010\u0010?\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b?\u0010\u0006J\u001a\u0010B\u001a\u00020\u00122\b\u0010A\u001a\u0004\u0018\u00010@HÖ\u0003¢\u0006\u0004\bB\u0010CR\u001f\u00109\u001a\b\u0012\u0004\u0012\u00020\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b9\u0010D\u001a\u0004\bE\u0010\u0010R\u0016\u0010G\u001a\u00020\u00048\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\bF\u0010\u0006¨\u0006K"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/PhotoParameter$ImageUploadListWrapper;", "", "Lcom/avito/android/remote/model/ImageUpload;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "Lcom/avito/android/remote/model/ImageUploadResult;", "getOnlyUploaded", "()Ljava/util/List;", "element", "", ProductAction.ACTION_ADD, "(Lcom/avito/android/remote/model/ImageUpload;)Z", FirebaseAnalytics.Param.INDEX, "(ILcom/avito/android/remote/model/ImageUpload;)V", "", MessengerShareContentUtility.ELEMENTS, "addAll", "(ILjava/util/Collection;)Z", "(Ljava/util/Collection;)Z", "clear", "()V", "contains", "containsAll", "get", "(I)Lcom/avito/android/remote/model/ImageUpload;", "indexOf", "(Lcom/avito/android/remote/model/ImageUpload;)I", "isEmpty", "()Z", "", "iterator", "()Ljava/util/Iterator;", "lastIndexOf", "", "listIterator", "()Ljava/util/ListIterator;", "(I)Ljava/util/ListIterator;", ProductAction.ACTION_REMOVE, "removeAll", "removeAt", "retainAll", "set", "(ILcom/avito/android/remote/model/ImageUpload;)Lcom/avito/android/remote/model/ImageUpload;", "fromIndex", "toIndex", "subList", "(II)Ljava/util/List;", "component1", "list", "copy", "(Ljava/util/List;)Lcom/avito/android/remote/model/category_parameters/PhotoParameter$ImageUploadListWrapper;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getList", "getSize", "size", "<init>", "(Ljava/util/List;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class ImageUploadListWrapper implements List<ImageUpload>, Parcelable, KMutableList {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<ImageUploadListWrapper> CREATOR = Parcels.creator(PhotoParameter$ImageUploadListWrapper$Companion$CREATOR$1.INSTANCE);
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        private final List<ImageUpload> list;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/PhotoParameter$ImageUploadListWrapper$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/category_parameters/PhotoParameter$ImageUploadListWrapper;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(j jVar) {
                this();
            }
        }

        public ImageUploadListWrapper() {
            this(null, 1, null);
        }

        public ImageUploadListWrapper(@NotNull List<ImageUpload> list2) {
            Intrinsics.checkNotNullParameter(list2, "list");
            this.list = list2;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.remote.model.category_parameters.PhotoParameter$ImageUploadListWrapper */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ImageUploadListWrapper copy$default(ImageUploadListWrapper imageUploadListWrapper, List list2, int i, Object obj) {
            if ((i & 1) != 0) {
                list2 = imageUploadListWrapper.list;
            }
            return imageUploadListWrapper.copy(list2);
        }

        public void add(int i, @NotNull ImageUpload imageUpload) {
            Intrinsics.checkNotNullParameter(imageUpload, "element");
            this.list.add(i, imageUpload);
        }

        public boolean add(@NotNull ImageUpload imageUpload) {
            Intrinsics.checkNotNullParameter(imageUpload, "element");
            return this.list.add(imageUpload);
        }

        @Override // java.util.List
        public boolean addAll(int i, @NotNull Collection<? extends ImageUpload> collection) {
            Intrinsics.checkNotNullParameter(collection, MessengerShareContentUtility.ELEMENTS);
            return this.list.addAll(i, collection);
        }

        @Override // java.util.List, java.util.Collection
        public boolean addAll(@NotNull Collection<? extends ImageUpload> collection) {
            Intrinsics.checkNotNullParameter(collection, MessengerShareContentUtility.ELEMENTS);
            return this.list.addAll(collection);
        }

        @Override // java.util.List, java.util.Collection
        public void clear() {
            this.list.clear();
        }

        @NotNull
        public final List<ImageUpload> component1() {
            return this.list;
        }

        public boolean contains(@NotNull ImageUpload imageUpload) {
            Intrinsics.checkNotNullParameter(imageUpload, "element");
            return this.list.contains(imageUpload);
        }

        @Override // java.util.List, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof ImageUpload) {
                return contains((ImageUpload) obj);
            }
            return false;
        }

        @Override // java.util.List, java.util.Collection
        public boolean containsAll(@NotNull Collection<? extends Object> collection) {
            Intrinsics.checkNotNullParameter(collection, MessengerShareContentUtility.ELEMENTS);
            return this.list.containsAll(collection);
        }

        @NotNull
        public final ImageUploadListWrapper copy(@NotNull List<ImageUpload> list2) {
            Intrinsics.checkNotNullParameter(list2, "list");
            return new ImageUploadListWrapper(list2);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // java.util.List, java.util.Collection, java.lang.Object
        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof ImageUploadListWrapper) && Intrinsics.areEqual(this.list, ((ImageUploadListWrapper) obj).list);
            }
            return true;
        }

        @Override // java.util.List
        @NotNull
        public ImageUpload get(int i) {
            ImageUpload imageUpload = this.list.get(i);
            Intrinsics.checkNotNullExpressionValue(imageUpload, "get(...)");
            return imageUpload;
        }

        @NotNull
        public final List<ImageUpload> getList() {
            return this.list;
        }

        @NotNull
        public final List<ImageUploadResult> getOnlyUploaded() {
            return t6.n.j.filterIsInstance(this, ImageUploadResult.class);
        }

        public int getSize() {
            return this.list.size();
        }

        @Override // java.util.List, java.util.Collection, java.lang.Object
        public int hashCode() {
            List<ImageUpload> list2 = this.list;
            if (list2 != null) {
                return list2.hashCode();
            }
            return 0;
        }

        public int indexOf(@NotNull ImageUpload imageUpload) {
            Intrinsics.checkNotNullParameter(imageUpload, "element");
            return this.list.indexOf(imageUpload);
        }

        @Override // java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof ImageUpload) {
                return indexOf((ImageUpload) obj);
            }
            return -1;
        }

        @Override // java.util.List, java.util.Collection
        public boolean isEmpty() {
            return this.list.isEmpty();
        }

        @Override // java.util.List, java.util.Collection, java.lang.Iterable
        @NotNull
        public Iterator<ImageUpload> iterator() {
            return this.list.iterator();
        }

        public int lastIndexOf(@NotNull ImageUpload imageUpload) {
            Intrinsics.checkNotNullParameter(imageUpload, "element");
            return this.list.lastIndexOf(imageUpload);
        }

        @Override // java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof ImageUpload) {
                return lastIndexOf((ImageUpload) obj);
            }
            return -1;
        }

        @Override // java.util.List
        @NotNull
        public ListIterator<ImageUpload> listIterator() {
            return this.list.listIterator();
        }

        @Override // java.util.List
        @NotNull
        public ListIterator<ImageUpload> listIterator(int i) {
            return this.list.listIterator(i);
        }

        @Override // java.util.List
        public final /* bridge */ ImageUpload remove(int i) {
            return remove(i);
        }

        public boolean remove(@NotNull ImageUpload imageUpload) {
            Intrinsics.checkNotNullParameter(imageUpload, "element");
            return this.list.remove(imageUpload);
        }

        @Override // java.util.List, java.util.Collection
        public boolean removeAll(@NotNull Collection<? extends Object> collection) {
            Intrinsics.checkNotNullParameter(collection, MessengerShareContentUtility.ELEMENTS);
            return this.list.removeAll(collection);
        }

        @NotNull
        /* renamed from: removeAt */
        public ImageUpload remove(int i) {
            ImageUpload remove = this.list.remove(i);
            Intrinsics.checkNotNullExpressionValue(remove, "removeAt(...)");
            return remove;
        }

        @Override // java.util.List, java.util.Collection
        public boolean retainAll(@NotNull Collection<? extends Object> collection) {
            Intrinsics.checkNotNullParameter(collection, MessengerShareContentUtility.ELEMENTS);
            return this.list.retainAll(collection);
        }

        @NotNull
        public ImageUpload set(int i, @NotNull ImageUpload imageUpload) {
            Intrinsics.checkNotNullParameter(imageUpload, "element");
            ImageUpload imageUpload2 = this.list.set(i, imageUpload);
            Intrinsics.checkNotNullExpressionValue(imageUpload2, "set(...)");
            return imageUpload2;
        }

        @Override // java.util.List, java.util.Collection
        public final /* bridge */ int size() {
            return getSize();
        }

        @Override // java.util.List
        @NotNull
        public List<ImageUpload> subList(int i, int i2) {
            return this.list.subList(i, i2);
        }

        @Override // java.util.List, java.util.Collection
        public Object[] toArray() {
            return CollectionToArray.toArray(this);
        }

        @Override // java.util.List, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) CollectionToArray.toArray(this, tArr);
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            return a.w(a.L("ImageUploadListWrapper(list="), this.list, ")");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "dest");
            parcel.writeList(this.list);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ImageUploadListWrapper(List list2, int i, j jVar) {
            this((i & 1) != 0 ? new ArrayList() : list2);
        }

        @Override // java.util.List, java.util.Collection
        public final /* bridge */ boolean remove(Object obj) {
            if (obj instanceof ImageUpload) {
                return remove((ImageUpload) obj);
            }
            return false;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PhotoParameter(String str, String str2, AttributedText attributedText, int i, Integer num, List list, ImageUploadListWrapper imageUploadListWrapper, boolean z, boolean z2, Integer num2, DisplayingOptions displayingOptions2, int i2, j jVar) {
        this(str, str2, attributedText, i, num, (i2 & 32) != 0 ? new ArrayList() : list, (i2 & 64) != 0 ? new ImageUploadListWrapper(null, 1, null) : imageUploadListWrapper, (i2 & 128) != 0 ? false : z, (i2 & 256) != 0 ? false : z2, (i2 & 512) != 0 ? null : num2, displayingOptions2);
    }

    public static /* synthetic */ PhotoParameter copy$default(PhotoParameter photoParameter, String str, String str2, AttributedText attributedText, int i, Integer num, List list, ImageUploadListWrapper imageUploadListWrapper, boolean z, boolean z2, Integer num2, DisplayingOptions displayingOptions2, int i2, Object obj) {
        return photoParameter.copy((i2 & 1) != 0 ? photoParameter.getId() : str, (i2 & 2) != 0 ? photoParameter.getTitle() : str2, (i2 & 4) != 0 ? photoParameter.getMotivation() : attributedText, (i2 & 8) != 0 ? photoParameter.maxCount : i, (i2 & 16) != 0 ? photoParameter.recommendedAmount : num, (i2 & 32) != 0 ? photoParameter.getConstraints() : list, (i2 & 64) != 0 ? photoParameter.get_value() : imageUploadListWrapper, (i2 & 128) != 0 ? photoParameter.getRequired() : z, (i2 & 256) != 0 ? photoParameter.shouldUploadPhotoForCV : z2, (i2 & 512) != 0 ? photoParameter.suggestByPhotoMaxImages : num2, (i2 & 1024) != 0 ? photoParameter.getDisplayingOptions() : displayingOptions2);
    }

    public static /* synthetic */ void getHint$annotations() {
    }

    public static /* synthetic */ void getImmutable$annotations() {
    }

    public static /* synthetic */ void getPlaceholder$annotations() {
    }

    public static /* synthetic */ void getUpdatesForm$annotations() {
    }

    @NotNull
    public final String component1() {
        return getId();
    }

    @Nullable
    public final Integer component10() {
        return this.suggestByPhotoMaxImages;
    }

    @Nullable
    public final DisplayingOptions component11() {
        return getDisplayingOptions();
    }

    @NotNull
    public final String component2() {
        return getTitle();
    }

    @Nullable
    public final AttributedText component3() {
        return getMotivation();
    }

    public final int component4() {
        return this.maxCount;
    }

    @Nullable
    public final Integer component5() {
        return this.recommendedAmount;
    }

    @Nullable
    public final List<Constraint> component6() {
        return getConstraints();
    }

    @Nullable
    public final ImageUploadListWrapper component7() {
        return get_value();
    }

    public final boolean component8() {
        return getRequired();
    }

    public final boolean component9() {
        return this.shouldUploadPhotoForCV;
    }

    @NotNull
    public final PhotoParameter copy(@NotNull String str, @NotNull String str2, @Nullable AttributedText attributedText, int i, @Nullable Integer num, @Nullable List<? extends Constraint> list, @Nullable ImageUploadListWrapper imageUploadListWrapper, boolean z, boolean z2, @Nullable Integer num2, @Nullable DisplayingOptions displayingOptions2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        return new PhotoParameter(str, str2, attributedText, i, num, list, imageUploadListWrapper, z, z2, num2, displayingOptions2);
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
        if (!(obj instanceof PhotoParameter)) {
            return false;
        }
        PhotoParameter photoParameter = (PhotoParameter) obj;
        return Intrinsics.areEqual(getId(), photoParameter.getId()) && Intrinsics.areEqual(getTitle(), photoParameter.getTitle()) && Intrinsics.areEqual(getMotivation(), photoParameter.getMotivation()) && this.maxCount == photoParameter.maxCount && Intrinsics.areEqual(this.recommendedAmount, photoParameter.recommendedAmount) && Intrinsics.areEqual(getConstraints(), photoParameter.getConstraints()) && Intrinsics.areEqual(get_value(), photoParameter.get_value()) && getRequired() == photoParameter.getRequired() && this.shouldUploadPhotoForCV == photoParameter.shouldUploadPhotoForCV && Intrinsics.areEqual(this.suggestByPhotoMaxImages, photoParameter.suggestByPhotoMaxImages) && Intrinsics.areEqual(getDisplayingOptions(), photoParameter.getDisplayingOptions());
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

    public final int getMaxCount() {
        return this.maxCount;
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

    @Nullable
    public final Integer getRecommendedAmount() {
        return this.recommendedAmount;
    }

    @Override // com.avito.android.remote.model.category_parameters.base.BaseParameter
    public boolean getRequired() {
        return this.required;
    }

    public final boolean getShouldUploadPhotoForCV() {
        return this.shouldUploadPhotoForCV;
    }

    @Nullable
    public final Integer getSuggestByPhotoMaxImages() {
        return this.suggestByPhotoMaxImages;
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
        AttributedText motivation2 = getMotivation();
        int hashCode3 = (((hashCode2 + (motivation2 != null ? motivation2.hashCode() : 0)) * 31) + this.maxCount) * 31;
        Integer num = this.recommendedAmount;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 31;
        List<Constraint> constraints2 = getConstraints();
        int hashCode5 = (hashCode4 + (constraints2 != null ? constraints2.hashCode() : 0)) * 31;
        ImageUploadListWrapper imageUploadListWrapper = get_value();
        int hashCode6 = (hashCode5 + (imageUploadListWrapper != null ? imageUploadListWrapper.hashCode() : 0)) * 31;
        boolean required2 = getRequired();
        int i2 = 1;
        if (required2) {
            required2 = true;
        }
        int i3 = required2 ? 1 : 0;
        int i4 = required2 ? 1 : 0;
        int i5 = required2 ? 1 : 0;
        int i6 = (hashCode6 + i3) * 31;
        boolean z = this.shouldUploadPhotoForCV;
        if (!z) {
            i2 = z ? 1 : 0;
        }
        int i7 = (i6 + i2) * 31;
        Integer num2 = this.suggestByPhotoMaxImages;
        int hashCode7 = (i7 + (num2 != null ? num2.hashCode() : 0)) * 31;
        DisplayingOptions displayingOptions2 = getDisplayingOptions();
        if (displayingOptions2 != null) {
            i = displayingOptions2.hashCode();
        }
        return hashCode7 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("PhotoParameter(id=");
        L.append(getId());
        L.append(", title=");
        L.append(getTitle());
        L.append(", motivation=");
        L.append(getMotivation());
        L.append(", maxCount=");
        L.append(this.maxCount);
        L.append(", recommendedAmount=");
        L.append(this.recommendedAmount);
        L.append(", constraints=");
        L.append(getConstraints());
        L.append(", _value=");
        L.append(get_value());
        L.append(", required=");
        L.append(getRequired());
        L.append(", shouldUploadPhotoForCV=");
        L.append(this.shouldUploadPhotoForCV);
        L.append(", suggestByPhotoMaxImages=");
        L.append(this.suggestByPhotoMaxImages);
        L.append(", displayingOptions=");
        L.append(getDisplayingOptions());
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.id);
        parcel.writeString(this.title);
        parcel.writeParcelable(this.motivation, i);
        parcel.writeInt(this.maxCount);
        Integer num = this.recommendedAmount;
        if (num != null) {
            a.H0(parcel, 1, num);
        } else {
            parcel.writeInt(0);
        }
        List<Constraint> list = this.constraints;
        if (list != null) {
            Iterator l0 = a.l0(parcel, 1, list);
            while (l0.hasNext()) {
                parcel.writeParcelable((Constraint) l0.next(), i);
            }
        } else {
            parcel.writeInt(0);
        }
        parcel.writeParcelable(this._value, i);
        parcel.writeInt(this.required ? 1 : 0);
        parcel.writeInt(this.shouldUploadPhotoForCV ? 1 : 0);
        Integer num2 = this.suggestByPhotoMaxImages;
        if (num2 != null) {
            a.H0(parcel, 1, num2);
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

    public boolean areValuesTheSame(@Nullable ImageUploadListWrapper imageUploadListWrapper, @Nullable ImageUploadListWrapper imageUploadListWrapper2) {
        Collection collection;
        Collection collection2;
        if (imageUploadListWrapper != null) {
            collection = new ArrayList();
            for (Object obj : imageUploadListWrapper) {
                if (obj instanceof ImageUploadResult) {
                    collection.add(obj);
                }
            }
        } else {
            collection = CollectionsKt__CollectionsKt.emptyList();
        }
        if (imageUploadListWrapper2 != null) {
            collection2 = new ArrayList();
            for (Object obj2 : imageUploadListWrapper2) {
                if (obj2 instanceof ImageUploadResult) {
                    collection2.add(obj2);
                }
            }
        } else {
            collection2 = CollectionsKt__CollectionsKt.emptyList();
        }
        return Intrinsics.areEqual(collection, collection2);
    }

    @Override // com.avito.android.remote.model.category_parameters.base.EditableParameter
    @Nullable
    public ImageUploadListWrapper get_value() {
        return this._value;
    }

    public void set_value(@Nullable ImageUploadListWrapper imageUploadListWrapper) {
        this._value = imageUploadListWrapper;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: java.util.List<? extends com.avito.android.remote.model.category_parameters.Constraint> */
    /* JADX WARN: Multi-variable type inference failed */
    public PhotoParameter(@NotNull String str, @NotNull String str2, @Nullable AttributedText attributedText, int i, @Nullable Integer num, @Nullable List<? extends Constraint> list, @Nullable ImageUploadListWrapper imageUploadListWrapper, boolean z, boolean z2, @Nullable Integer num2, @Nullable DisplayingOptions displayingOptions2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        this.id = str;
        this.title = str2;
        this.motivation = attributedText;
        this.maxCount = i;
        this.recommendedAmount = num;
        this.constraints = list;
        this._value = imageUploadListWrapper;
        this.required = z;
        this.shouldUploadPhotoForCV = z2;
        this.suggestByPhotoMaxImages = num2;
        this.displayingOptions = displayingOptions2;
    }
}
