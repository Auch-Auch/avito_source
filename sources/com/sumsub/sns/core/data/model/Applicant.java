package com.sumsub.sns.core.data.model;

import a2.b.a.a.a;
import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AvatarStatus;
import com.google.firebase.messaging.Constants;
import com.sumsub.sns.core.data.model.ApplicantDataField;
import com.sumsub.sns.core.data.model.VideoRequiredType;
import com.vk.sdk.api.VKApiConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u001c\b\b\u0018\u00002\u00020\u0001:\u0004opqrB\u0001\u0012\u0006\u0010\"\u001a\u00020\u000b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010#\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010$\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010%\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010&\u001a\u00020\u0012\u0012\b\u0010'\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010(\u001a\u00020\u0016\u0012\b\u0010)\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010*\u001a\u0004\u0018\u00010\u001a\u0012\b\u0010+\u001a\u0004\u0018\u00010\u000b\u0012\u000e\u0010,\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u0007\u0012\b\u0010-\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\bm\u0010nJ\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u0002ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\rJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u000f\u0010\rJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u0010\u0010\rJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u0011\u0010\rJ\u0010\u0010\u0013\u001a\u00020\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u0015\u0010\rJ\u0010\u0010\u0017\u001a\u00020\u0016HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u0019\u0010\rJ\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u001d\u0010\rJ\u0018\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\u001f\u0010 J\u0012\u0010!\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b!\u0010\rJ¬\u0001\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\"\u001a\u00020\u000b2\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010&\u001a\u00020\u00122\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010(\u001a\u00020\u00162\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u000b2\u0010\b\u0002\u0010,\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u00072\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0004\b.\u0010/J\u0010\u00100\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b0\u0010\rJ\u0010\u00102\u001a\u000201HÖ\u0001¢\u0006\u0004\b2\u00103J\u001a\u00107\u001a\u0002062\b\u00105\u001a\u0004\u0018\u000104HÖ\u0003¢\u0006\u0004\b7\u00108J\u0010\u00109\u001a\u000201HÖ\u0001¢\u0006\u0004\b9\u00103J \u0010>\u001a\u00020=2\u0006\u0010;\u001a\u00020:2\u0006\u0010<\u001a\u000201HÖ\u0001¢\u0006\u0004\b>\u0010?R\u001b\u0010'\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010\rR\"\u0010(\u001a\u00020\u00168\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010\u0018\"\u0004\bF\u0010GR\u001b\u0010-\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\bH\u0010A\u001a\u0004\bI\u0010\rR\u001b\u0010+\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\bJ\u0010A\u001a\u0004\bK\u0010\rR\u001b\u0010\u0003\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\bL\u0010A\u001a\u0004\bM\u0010\rR\u0015\u0010O\u001a\u0004\u0018\u00010\u000b8F@\u0006¢\u0006\u0006\u001a\u0004\bN\u0010\rR\u001b\u0010$\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\bP\u0010A\u001a\u0004\bQ\u0010\rR!\u0010,\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u00078\u0006@\u0006¢\u0006\f\n\u0004\bR\u0010S\u001a\u0004\bT\u0010 R\u0013\u0010U\u001a\u0002068F@\u0006¢\u0006\u0006\u001a\u0004\bU\u0010VR\u0013\u0010Z\u001a\u00020W8F@\u0006¢\u0006\u0006\u001a\u0004\bX\u0010YR\u0013\u0010[\u001a\u0002068F@\u0006¢\u0006\u0006\u001a\u0004\b[\u0010VR\u0013\u0010\\\u001a\u0002068F@\u0006¢\u0006\u0006\u001a\u0004\b\\\u0010VR\u001b\u0010%\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b]\u0010A\u001a\u0004\b^\u0010\rR\u0019\u0010&\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b_\u0010`\u001a\u0004\ba\u0010\u0014R\u0019\u0010\"\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\bb\u0010A\u001a\u0004\bc\u0010\rR\u001b\u0010)\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\bd\u0010A\u001a\u0004\be\u0010\rR\u001b\u0010*\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006¢\u0006\f\n\u0004\bf\u0010g\u001a\u0004\bh\u0010\u001cR\u001b\u0010#\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\bi\u0010A\u001a\u0004\bj\u0010\rR\u0019\u0010l\u001a\b\u0012\u0004\u0012\u00020\u00020\u00078F@\u0006¢\u0006\u0006\u001a\u0004\bk\u0010 \u0002\u0004\n\u0002\b\u0019¨\u0006s"}, d2 = {"Lcom/sumsub/sns/core/data/model/Applicant;", "Landroid/os/Parcelable;", "Lcom/sumsub/sns/core/data/model/DocumentType;", "type", "Lcom/sumsub/sns/core/data/model/Applicant$RequiredIdDocs$DocSetsItem;", "getDocSetByType", "(Lcom/sumsub/sns/core/data/model/DocumentType;)Lcom/sumsub/sns/core/data/model/Applicant$RequiredIdDocs$DocSetsItem;", "", "Lcom/sumsub/sns/core/data/model/IdentityType;", "getIdentityList", "(Lcom/sumsub/sns/core/data/model/DocumentType;)Ljava/util/List;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "Lcom/sumsub/sns/core/data/model/Applicant$RequiredIdDocs;", "component6", "()Lcom/sumsub/sns/core/data/model/Applicant$RequiredIdDocs;", "component7", "Lcom/sumsub/sns/core/data/model/Applicant$Review;", "component8", "()Lcom/sumsub/sns/core/data/model/Applicant$Review;", "component9", "Lcom/sumsub/sns/core/data/model/Applicant$Info;", "component10", "()Lcom/sumsub/sns/core/data/model/Applicant$Info;", "component11", "Lcom/sumsub/sns/core/data/model/Applicant$MetaValue;", "component12", "()Ljava/util/List;", "component13", "id", "clientId", "createdAt", "inspectionId", "requiredIdDocs", "externalUserId", AvatarStatus.REVIEW, "env", "info", VKApiConst.LANG, "metadata", "email", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/sumsub/sns/core/data/model/Applicant$RequiredIdDocs;Ljava/lang/String;Lcom/sumsub/sns/core/data/model/Applicant$Review;Ljava/lang/String;Lcom/sumsub/sns/core/data/model/Applicant$Info;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)Lcom/sumsub/sns/core/data/model/Applicant;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", g.a, "Ljava/lang/String;", "getExternalUserId", "h", "Lcom/sumsub/sns/core/data/model/Applicant$Review;", "getReview", "setReview", "(Lcom/sumsub/sns/core/data/model/Applicant$Review;)V", AuthSource.OPEN_CHANNEL_LIST, "getEmail", "k", "getLang", AuthSource.BOOKING_ORDER, "getType", "getCountry", "country", "d", "getCreatedAt", "l", "Ljava/util/List;", "getMetadata", "isFinallyRejected", "()Z", "Lcom/sumsub/sns/core/data/model/ReviewStatusType;", "getStatus", "()Lcom/sumsub/sns/core/data/model/ReviewStatusType;", "status", "isTemporarilyDeclined", "isApproved", "e", "getInspectionId", "f", "Lcom/sumsub/sns/core/data/model/Applicant$RequiredIdDocs;", "getRequiredIdDocs", AuthSource.SEND_ABUSE, "getId", "i", "getEnv", "j", "Lcom/sumsub/sns/core/data/model/Applicant$Info;", "getInfo", "c", "getClientId", "getDocuments", "documents", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/sumsub/sns/core/data/model/Applicant$RequiredIdDocs;Ljava/lang/String;Lcom/sumsub/sns/core/data/model/Applicant$Review;Ljava/lang/String;Lcom/sumsub/sns/core/data/model/Applicant$Info;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "Info", "MetaValue", "RequiredIdDocs", "Review", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public final class Applicant implements Parcelable {
    public static final Parcelable.Creator<Applicant> CREATOR = new Creator();
    @NotNull
    public final String a;
    @Nullable
    public final String b;
    @Nullable
    public final String c;
    @Nullable
    public final String d;
    @Nullable
    public final String e;
    @NotNull
    public final RequiredIdDocs f;
    @Nullable
    public final String g;
    @NotNull
    public Review h;
    @Nullable
    public final String i;
    @Nullable
    public final Info j;
    @Nullable
    public final String k;
    @Nullable
    public final List<MetaValue> l;
    @Nullable
    public final String m;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<Applicant> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Applicant createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            RequiredIdDocs createFromParcel = RequiredIdDocs.CREATOR.createFromParcel(parcel);
            String readString6 = parcel.readString();
            Review createFromParcel2 = Review.CREATOR.createFromParcel(parcel);
            String readString7 = parcel.readString();
            ArrayList arrayList = null;
            Info createFromParcel3 = parcel.readInt() != 0 ? Info.CREATOR.createFromParcel(parcel) : null;
            String readString8 = parcel.readString();
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add(MetaValue.CREATOR.createFromParcel(parcel));
                    readInt--;
                }
            }
            return new Applicant(readString, readString2, readString3, readString4, readString5, createFromParcel, readString6, createFromParcel2, readString7, createFromParcel3, readString8, arrayList, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Applicant[] newArray(int i) {
            return new Applicant[i];
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010 \n\u0002\u0010$\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b!\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0002\u0012\u001a\u0010 \u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0011\u0018\u00010\u0010¢\u0006\u0004\bO\u0010PJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J$\u0010\u0012\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0011\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J¾\u0001\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00022\u001c\b\u0002\u0010 \u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0011\u0018\u00010\u0010HÆ\u0001¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b#\u0010\u0004J\u0010\u0010%\u001a\u00020$HÖ\u0001¢\u0006\u0004\b%\u0010&J\u001a\u0010*\u001a\u00020)2\b\u0010(\u001a\u0004\u0018\u00010'HÖ\u0003¢\u0006\u0004\b*\u0010+J\u0010\u0010,\u001a\u00020$HÖ\u0001¢\u0006\u0004\b,\u0010&J \u00101\u001a\u0002002\u0006\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020$HÖ\u0001¢\u0006\u0004\b1\u00102R\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u0010\u0004R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b6\u00104\u001a\u0004\b7\u0010\u0004R-\u0010 \u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0011\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010\u0013R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b;\u00104\u001a\u0004\b<\u0010\u0004R\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b=\u00104\u001a\u0004\b>\u0010\u0004R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b?\u00104\u001a\u0004\b@\u0010\u0004R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\bA\u00104\u001a\u0004\bB\u0010\u0004R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\bC\u00104\u001a\u0004\bD\u0010\u0004R\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\bE\u00104\u001a\u0004\bF\u0010\u0004R\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\bG\u00104\u001a\u0004\bH\u0010\u0004R\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\bI\u00104\u001a\u0004\bJ\u0010\u0004R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\bK\u00104\u001a\u0004\bL\u0010\u0004R\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\bM\u00104\u001a\u0004\bN\u0010\u0004¨\u0006Q"}, d2 = {"Lcom/sumsub/sns/core/data/model/Applicant$Info;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "", "", "component13", "()Ljava/util/List;", "country", "firstName", "lastName", "middleName", "legalName", "gender", "dob", "placeOfBirth", "countryOfBirth", "stateOfBirth", "nationality", "phone", "addresses", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lcom/sumsub/sns/core/data/model/Applicant$Info;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getCountry", AuthSource.BOOKING_ORDER, "getFirstName", AuthSource.OPEN_CHANNEL_LIST, "Ljava/util/List;", "getAddresses", g.a, "getDob", "i", "getCountryOfBirth", "e", "getLegalName", "c", "getLastName", "f", "getGender", "h", "getPlaceOfBirth", "l", "getPhone", "j", "getStateOfBirth", "d", "getMiddleName", "k", "getNationality", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Info implements Parcelable {
        public static final Parcelable.Creator<Info> CREATOR = new Creator();
        @Nullable
        public final String a;
        @Nullable
        public final String b;
        @Nullable
        public final String c;
        @Nullable
        public final String d;
        @Nullable
        public final String e;
        @Nullable
        public final String f;
        @Nullable
        public final String g;
        @Nullable
        public final String h;
        @Nullable
        public final String i;
        @Nullable
        public final String j;
        @Nullable
        public final String k;
        @Nullable
        public final String l;
        @Nullable
        public final List<Map<String, String>> m;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Info> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Info createFromParcel(@NotNull Parcel parcel) {
                String str;
                String str2;
                String str3;
                String str4;
                ArrayList arrayList;
                Intrinsics.checkNotNullParameter(parcel, "in");
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                String readString3 = parcel.readString();
                String readString4 = parcel.readString();
                String readString5 = parcel.readString();
                String readString6 = parcel.readString();
                String readString7 = parcel.readString();
                String readString8 = parcel.readString();
                String readString9 = parcel.readString();
                String readString10 = parcel.readString();
                String readString11 = parcel.readString();
                String readString12 = parcel.readString();
                if (parcel.readInt() != 0) {
                    int readInt = parcel.readInt();
                    arrayList = new ArrayList(readInt);
                    while (readInt != 0) {
                        int readInt2 = parcel.readInt();
                        LinkedHashMap linkedHashMap = new LinkedHashMap(readInt2);
                        while (readInt2 != 0) {
                            readInt2 = a.U(parcel, linkedHashMap, parcel.readString(), readInt2, -1);
                            readString10 = readString10;
                            readString9 = readString9;
                        }
                        arrayList.add(linkedHashMap);
                        readInt--;
                        readString12 = readString12;
                        readString11 = readString11;
                    }
                    str = readString9;
                    str2 = readString10;
                    str3 = readString11;
                    str4 = readString12;
                } else {
                    str = readString9;
                    str2 = readString10;
                    str3 = readString11;
                    str4 = readString12;
                    arrayList = null;
                }
                return new Info(readString, readString2, readString3, readString4, readString5, readString6, readString7, readString8, str, str2, str3, str4, arrayList);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Info[] newArray(int i) {
                return new Info[i];
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r13v0, resolved type: java.util.List<? extends java.util.Map<java.lang.String, java.lang.String>> */
        /* JADX WARN: Multi-variable type inference failed */
        public Info(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10, @Nullable String str11, @Nullable String str12, @Nullable List<? extends Map<String, String>> list) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
            this.e = str5;
            this.f = str6;
            this.g = str7;
            this.h = str8;
            this.i = str9;
            this.j = str10;
            this.k = str11;
            this.l = str12;
            this.m = list;
        }

        public static /* synthetic */ Info copy$default(Info info, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, List list, int i2, Object obj) {
            return info.copy((i2 & 1) != 0 ? info.a : str, (i2 & 2) != 0 ? info.b : str2, (i2 & 4) != 0 ? info.c : str3, (i2 & 8) != 0 ? info.d : str4, (i2 & 16) != 0 ? info.e : str5, (i2 & 32) != 0 ? info.f : str6, (i2 & 64) != 0 ? info.g : str7, (i2 & 128) != 0 ? info.h : str8, (i2 & 256) != 0 ? info.i : str9, (i2 & 512) != 0 ? info.j : str10, (i2 & 1024) != 0 ? info.k : str11, (i2 & 2048) != 0 ? info.l : str12, (i2 & 4096) != 0 ? info.m : list);
        }

        @Nullable
        public final String component1() {
            return this.a;
        }

        @Nullable
        public final String component10() {
            return this.j;
        }

        @Nullable
        public final String component11() {
            return this.k;
        }

        @Nullable
        public final String component12() {
            return this.l;
        }

        @Nullable
        public final List<Map<String, String>> component13() {
            return this.m;
        }

        @Nullable
        public final String component2() {
            return this.b;
        }

        @Nullable
        public final String component3() {
            return this.c;
        }

        @Nullable
        public final String component4() {
            return this.d;
        }

        @Nullable
        public final String component5() {
            return this.e;
        }

        @Nullable
        public final String component6() {
            return this.f;
        }

        @Nullable
        public final String component7() {
            return this.g;
        }

        @Nullable
        public final String component8() {
            return this.h;
        }

        @Nullable
        public final String component9() {
            return this.i;
        }

        @NotNull
        public final Info copy(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10, @Nullable String str11, @Nullable String str12, @Nullable List<? extends Map<String, String>> list) {
            return new Info(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, list);
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
            return Intrinsics.areEqual(this.a, info.a) && Intrinsics.areEqual(this.b, info.b) && Intrinsics.areEqual(this.c, info.c) && Intrinsics.areEqual(this.d, info.d) && Intrinsics.areEqual(this.e, info.e) && Intrinsics.areEqual(this.f, info.f) && Intrinsics.areEqual(this.g, info.g) && Intrinsics.areEqual(this.h, info.h) && Intrinsics.areEqual(this.i, info.i) && Intrinsics.areEqual(this.j, info.j) && Intrinsics.areEqual(this.k, info.k) && Intrinsics.areEqual(this.l, info.l) && Intrinsics.areEqual(this.m, info.m);
        }

        @Nullable
        public final List<Map<String, String>> getAddresses() {
            return this.m;
        }

        @Nullable
        public final String getCountry() {
            return this.a;
        }

        @Nullable
        public final String getCountryOfBirth() {
            return this.i;
        }

        @Nullable
        public final String getDob() {
            return this.g;
        }

        @Nullable
        public final String getFirstName() {
            return this.b;
        }

        @Nullable
        public final String getGender() {
            return this.f;
        }

        @Nullable
        public final String getLastName() {
            return this.c;
        }

        @Nullable
        public final String getLegalName() {
            return this.e;
        }

        @Nullable
        public final String getMiddleName() {
            return this.d;
        }

        @Nullable
        public final String getNationality() {
            return this.k;
        }

        @Nullable
        public final String getPhone() {
            return this.l;
        }

        @Nullable
        public final String getPlaceOfBirth() {
            return this.h;
        }

        @Nullable
        public final String getStateOfBirth() {
            return this.j;
        }

        @Override // java.lang.Object
        public int hashCode() {
            String str = this.a;
            int i2 = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.b;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.c;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.d;
            int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
            String str5 = this.e;
            int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
            String str6 = this.f;
            int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
            String str7 = this.g;
            int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
            String str8 = this.h;
            int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
            String str9 = this.i;
            int hashCode9 = (hashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31;
            String str10 = this.j;
            int hashCode10 = (hashCode9 + (str10 != null ? str10.hashCode() : 0)) * 31;
            String str11 = this.k;
            int hashCode11 = (hashCode10 + (str11 != null ? str11.hashCode() : 0)) * 31;
            String str12 = this.l;
            int hashCode12 = (hashCode11 + (str12 != null ? str12.hashCode() : 0)) * 31;
            List<Map<String, String>> list = this.m;
            if (list != null) {
                i2 = list.hashCode();
            }
            return hashCode12 + i2;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("Info(country=");
            L.append(this.a);
            L.append(", firstName=");
            L.append(this.b);
            L.append(", lastName=");
            L.append(this.c);
            L.append(", middleName=");
            L.append(this.d);
            L.append(", legalName=");
            L.append(this.e);
            L.append(", gender=");
            L.append(this.f);
            L.append(", dob=");
            L.append(this.g);
            L.append(", placeOfBirth=");
            L.append(this.h);
            L.append(", countryOfBirth=");
            L.append(this.i);
            L.append(", stateOfBirth=");
            L.append(this.j);
            L.append(", nationality=");
            L.append(this.k);
            L.append(", phone=");
            L.append(this.l);
            L.append(", addresses=");
            return a.w(L, this.m, ")");
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Map$Entry, java.lang.Object] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // android.os.Parcelable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void writeToParcel(@org.jetbrains.annotations.NotNull android.os.Parcel r4, int r5) {
            /*
                r3 = this;
                java.lang.String r5 = "parcel"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r5)
                java.lang.String r5 = r3.a
                r4.writeString(r5)
                java.lang.String r5 = r3.b
                r4.writeString(r5)
                java.lang.String r5 = r3.c
                r4.writeString(r5)
                java.lang.String r5 = r3.d
                r4.writeString(r5)
                java.lang.String r5 = r3.e
                r4.writeString(r5)
                java.lang.String r5 = r3.f
                r4.writeString(r5)
                java.lang.String r5 = r3.g
                r4.writeString(r5)
                java.lang.String r5 = r3.h
                r4.writeString(r5)
                java.lang.String r5 = r3.i
                r4.writeString(r5)
                java.lang.String r5 = r3.j
                r4.writeString(r5)
                java.lang.String r5 = r3.k
                r4.writeString(r5)
                java.lang.String r5 = r3.l
                r4.writeString(r5)
                java.util.List<java.util.Map<java.lang.String, java.lang.String>> r5 = r3.m
                if (r5 == 0) goto L_0x0077
                r0 = 1
                java.util.Iterator r5 = a2.b.a.a.a.l0(r4, r0, r5)
            L_0x004a:
                boolean r0 = r5.hasNext()
                if (r0 == 0) goto L_0x007b
                java.lang.Object r0 = r5.next()
                java.util.Map r0 = (java.util.Map) r0
                java.util.Iterator r0 = a2.b.a.a.a.o0(r0, r4)
            L_0x005a:
                boolean r1 = r0.hasNext()
                if (r1 == 0) goto L_0x004a
                java.lang.Object r1 = r0.next()
                java.lang.Object r2 = r1.getKey()
                java.lang.String r2 = (java.lang.String) r2
                r4.writeString(r2)
                java.lang.Object r1 = r1.getValue()
                java.lang.String r1 = (java.lang.String) r1
                r4.writeString(r1)
                goto L_0x005a
            L_0x0077:
                r5 = 0
                r4.writeInt(r5)
            L_0x007b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.data.model.Applicant.Info.writeToParcel(android.os.Parcel, int):void");
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0013\u0010\rJ \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\u0006\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001b\u001a\u0004\b\u001e\u0010\u0004¨\u0006!"}, d2 = {"Lcom/sumsub/sns/core/data/model/Applicant$MetaValue;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component2", "key", "value", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lcom/sumsub/sns/core/data/model/Applicant$MetaValue;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getKey", AuthSource.BOOKING_ORDER, "getValue", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class MetaValue implements Parcelable {
        public static final Parcelable.Creator<MetaValue> CREATOR = new Creator();
        @NotNull
        public final String a;
        @NotNull
        public final String b;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<MetaValue> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final MetaValue createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new MetaValue(parcel.readString(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final MetaValue[] newArray(int i) {
                return new MetaValue[i];
            }
        }

        public MetaValue(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, "key");
            Intrinsics.checkNotNullParameter(str2, "value");
            this.a = str;
            this.b = str2;
        }

        public static /* synthetic */ MetaValue copy$default(MetaValue metaValue, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = metaValue.a;
            }
            if ((i & 2) != 0) {
                str2 = metaValue.b;
            }
            return metaValue.copy(str, str2);
        }

        @NotNull
        public final String component1() {
            return this.a;
        }

        @NotNull
        public final String component2() {
            return this.b;
        }

        @NotNull
        public final MetaValue copy(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, "key");
            Intrinsics.checkNotNullParameter(str2, "value");
            return new MetaValue(str, str2);
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
            if (!(obj instanceof MetaValue)) {
                return false;
            }
            MetaValue metaValue = (MetaValue) obj;
            return Intrinsics.areEqual(this.a, metaValue.a) && Intrinsics.areEqual(this.b, metaValue.b);
        }

        @NotNull
        public final String getKey() {
            return this.a;
        }

        @NotNull
        public final String getValue() {
            return this.b;
        }

        @Override // java.lang.Object
        public int hashCode() {
            String str = this.a;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.b;
            if (str2 != null) {
                i = str2.hashCode();
            }
            return hashCode + i;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("MetaValue(key=");
            L.append(this.a);
            L.append(", value=");
            return a.t(L, this.b, ")");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.a);
            parcel.writeString(this.b);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001:\u0001+B5\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0004\b)\u0010*J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\n\u0010\tJD\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0014J \u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u001f\u0010 R!\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\tR!\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010\"\u001a\u0004\b%\u0010\tR\u001f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010\u0005¨\u0006,"}, d2 = {"Lcom/sumsub/sns/core/data/model/Applicant$RequiredIdDocs;", "Landroid/os/Parcelable;", "", "Lcom/sumsub/sns/core/data/model/Applicant$RequiredIdDocs$DocSetsItem;", "component1", "()Ljava/util/List;", "", "", "component2", "()Ljava/util/Set;", "component3", "docSets", "includedCountries", "excludedCountries", "copy", "(Ljava/util/List;Ljava/util/Set;Ljava/util/Set;)Lcom/sumsub/sns/core/data/model/Applicant$RequiredIdDocs;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.BOOKING_ORDER, "Ljava/util/Set;", "getIncludedCountries", "c", "getExcludedCountries", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getDocSets", "<init>", "(Ljava/util/List;Ljava/util/Set;Ljava/util/Set;)V", "DocSetsItem", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class RequiredIdDocs implements Parcelable {
        public static final Parcelable.Creator<RequiredIdDocs> CREATOR = new Creator();
        @NotNull
        public final List<DocSetsItem> a;
        @Nullable
        public final Set<String> b;
        @Nullable
        public final Set<String> c;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<RequiredIdDocs> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final RequiredIdDocs createFromParcel(@NotNull Parcel parcel) {
                LinkedHashSet linkedHashSet;
                Intrinsics.checkNotNullParameter(parcel, "in");
                int readInt = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add(DocSetsItem.CREATOR.createFromParcel(parcel));
                    readInt--;
                }
                LinkedHashSet linkedHashSet2 = null;
                if (parcel.readInt() != 0) {
                    int readInt2 = parcel.readInt();
                    linkedHashSet = new LinkedHashSet(readInt2);
                    while (readInt2 != 0) {
                        linkedHashSet.add(parcel.readString());
                        readInt2--;
                    }
                } else {
                    linkedHashSet = null;
                }
                if (parcel.readInt() != 0) {
                    int readInt3 = parcel.readInt();
                    linkedHashSet2 = new LinkedHashSet(readInt3);
                    while (readInt3 != 0) {
                        linkedHashSet2.add(parcel.readString());
                        readInt3--;
                    }
                }
                return new RequiredIdDocs(arrayList, linkedHashSet, linkedHashSet2);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final RequiredIdDocs[] newArray(int i) {
                return new RequiredIdDocs[i];
            }
        }

        @Parcelize
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0016\b\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u0005\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0006\u0012\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0005\u0012\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0005¢\u0006\u0004\b:\u0010;J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0005HÆ\u0003¢\u0006\u0004\b\n\u0010\bJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u000e\u0010\bJ\u0018\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0010\u0010\bJj\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00022\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00052\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0019\u0010\fJ\u0010\u0010\u001b\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010 \u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dHÖ\u0003¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\"\u0010\u001cJ \u0010'\u001a\u00020&2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b'\u0010(R\u0019\u0010\u0011\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010\u0004R!\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010\bR\u0013\u0010/\u001a\u00020\u001f8F@\u0006¢\u0006\u0006\u001a\u0004\b/\u00100R\u001f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u00058\u0006@\u0006¢\u0006\f\n\u0004\b1\u0010-\u001a\u0004\b2\u0010\bR!\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b3\u0010-\u001a\u0004\b4\u0010\bR\u001f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b5\u0010-\u001a\u0004\b6\u0010\bR\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010\f¨\u0006<"}, d2 = {"Lcom/sumsub/sns/core/data/model/Applicant$RequiredIdDocs$DocSetsItem;", "Landroid/os/Parcelable;", "Lcom/sumsub/sns/core/data/model/DocumentType;", "component1", "()Lcom/sumsub/sns/core/data/model/DocumentType;", "", "", "component2", "()Ljava/util/List;", "Lcom/sumsub/sns/core/data/model/IdentitySide;", "component3", "component4", "()Ljava/lang/String;", "Lcom/sumsub/sns/core/data/model/ApplicantDataField$Field;", "component5", "Lcom/sumsub/sns/core/data/model/ApplicantDataField$CustomField;", "component6", "idDocSetType", "types", "sides", "videoRequired", "fields", "customField", "copy", "(Lcom/sumsub/sns/core/data/model/DocumentType;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)Lcom/sumsub/sns/core/data/model/Applicant$RequiredIdDocs$DocSetsItem;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.SEND_ABUSE, "Lcom/sumsub/sns/core/data/model/DocumentType;", "getIdDocSetType", "e", "Ljava/util/List;", "getFields", "isSelfieWithDocument", "()Z", "c", "getSides", "f", "getCustomField", AuthSource.BOOKING_ORDER, "getTypes", "d", "Ljava/lang/String;", "getVideoRequired", "<init>", "(Lcom/sumsub/sns/core/data/model/DocumentType;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
        public static final class DocSetsItem implements Parcelable {
            public static final Parcelable.Creator<DocSetsItem> CREATOR = new Creator();
            @NotNull
            public final DocumentType a;
            @NotNull
            public final List<String> b;
            @NotNull
            public final List<IdentitySide> c;
            @Nullable
            public final String d;
            @Nullable
            public final List<ApplicantDataField.Field> e;
            @Nullable
            public final List<ApplicantDataField.CustomField> f;

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<DocSetsItem> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final DocSetsItem createFromParcel(@NotNull Parcel parcel) {
                    String readString;
                    ArrayList arrayList;
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    DocumentType createFromParcel = DocumentType.CREATOR.createFromParcel(parcel);
                    ArrayList<String> createStringArrayList = parcel.createStringArrayList();
                    int readInt = parcel.readInt();
                    ArrayList arrayList2 = new ArrayList(readInt);
                    while (true) {
                        readString = parcel.readString();
                        if (readInt == 0) {
                            break;
                        }
                        arrayList2.add((IdentitySide) Enum.valueOf(IdentitySide.class, readString));
                        readInt--;
                    }
                    ArrayList arrayList3 = null;
                    if (parcel.readInt() != 0) {
                        int readInt2 = parcel.readInt();
                        arrayList = new ArrayList(readInt2);
                        while (readInt2 != 0) {
                            arrayList.add(ApplicantDataField.Field.CREATOR.createFromParcel(parcel));
                            readInt2--;
                        }
                    } else {
                        arrayList = null;
                    }
                    if (parcel.readInt() != 0) {
                        int readInt3 = parcel.readInt();
                        arrayList3 = new ArrayList(readInt3);
                        while (readInt3 != 0) {
                            arrayList3.add(ApplicantDataField.CustomField.CREATOR.createFromParcel(parcel));
                            readInt3--;
                        }
                    }
                    return new DocSetsItem(createFromParcel, createStringArrayList, arrayList2, readString, arrayList, arrayList3);
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final DocSetsItem[] newArray(int i) {
                    return new DocSetsItem[i];
                }
            }

            /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<? extends com.sumsub.sns.core.data.model.IdentitySide> */
            /* JADX WARN: Multi-variable type inference failed */
            public DocSetsItem(@NotNull DocumentType documentType, @NotNull List<String> list, @NotNull List<? extends IdentitySide> list2, @Nullable String str, @Nullable List<ApplicantDataField.Field> list3, @Nullable List<ApplicantDataField.CustomField> list4) {
                Intrinsics.checkNotNullParameter(documentType, "idDocSetType");
                Intrinsics.checkNotNullParameter(list, "types");
                Intrinsics.checkNotNullParameter(list2, "sides");
                this.a = documentType;
                this.b = list;
                this.c = list2;
                this.d = str;
                this.e = list3;
                this.f = list4;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.sumsub.sns.core.data.model.Applicant$RequiredIdDocs$DocSetsItem */
            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ DocSetsItem copy$default(DocSetsItem docSetsItem, DocumentType documentType, List list, List list2, String str, List list3, List list4, int i, Object obj) {
                if ((i & 1) != 0) {
                    documentType = docSetsItem.a;
                }
                if ((i & 2) != 0) {
                    list = docSetsItem.b;
                }
                if ((i & 4) != 0) {
                    list2 = docSetsItem.c;
                }
                if ((i & 8) != 0) {
                    str = docSetsItem.d;
                }
                if ((i & 16) != 0) {
                    list3 = docSetsItem.e;
                }
                if ((i & 32) != 0) {
                    list4 = docSetsItem.f;
                }
                return docSetsItem.copy(documentType, list, list2, str, list3, list4);
            }

            @NotNull
            public final DocumentType component1() {
                return this.a;
            }

            @NotNull
            public final List<String> component2() {
                return this.b;
            }

            @NotNull
            public final List<IdentitySide> component3() {
                return this.c;
            }

            @Nullable
            public final String component4() {
                return this.d;
            }

            @Nullable
            public final List<ApplicantDataField.Field> component5() {
                return this.e;
            }

            @Nullable
            public final List<ApplicantDataField.CustomField> component6() {
                return this.f;
            }

            @NotNull
            public final DocSetsItem copy(@NotNull DocumentType documentType, @NotNull List<String> list, @NotNull List<? extends IdentitySide> list2, @Nullable String str, @Nullable List<ApplicantDataField.Field> list3, @Nullable List<ApplicantDataField.CustomField> list4) {
                Intrinsics.checkNotNullParameter(documentType, "idDocSetType");
                Intrinsics.checkNotNullParameter(list, "types");
                Intrinsics.checkNotNullParameter(list2, "sides");
                return new DocSetsItem(documentType, list, list2, str, list3, list4);
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
                if (!(obj instanceof DocSetsItem)) {
                    return false;
                }
                DocSetsItem docSetsItem = (DocSetsItem) obj;
                return Intrinsics.areEqual(this.a, docSetsItem.a) && Intrinsics.areEqual(this.b, docSetsItem.b) && Intrinsics.areEqual(this.c, docSetsItem.c) && Intrinsics.areEqual(this.d, docSetsItem.d) && Intrinsics.areEqual(this.e, docSetsItem.e) && Intrinsics.areEqual(this.f, docSetsItem.f);
            }

            @Nullable
            public final List<ApplicantDataField.CustomField> getCustomField() {
                return this.f;
            }

            @Nullable
            public final List<ApplicantDataField.Field> getFields() {
                return this.e;
            }

            @NotNull
            public final DocumentType getIdDocSetType() {
                return this.a;
            }

            @NotNull
            public final List<IdentitySide> getSides() {
                return this.c;
            }

            @NotNull
            public final List<String> getTypes() {
                return this.b;
            }

            @Nullable
            public final String getVideoRequired() {
                return this.d;
            }

            @Override // java.lang.Object
            public int hashCode() {
                DocumentType documentType = this.a;
                int i = 0;
                int hashCode = (documentType != null ? documentType.hashCode() : 0) * 31;
                List<String> list = this.b;
                int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
                List<IdentitySide> list2 = this.c;
                int hashCode3 = (hashCode2 + (list2 != null ? list2.hashCode() : 0)) * 31;
                String str = this.d;
                int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 31;
                List<ApplicantDataField.Field> list3 = this.e;
                int hashCode5 = (hashCode4 + (list3 != null ? list3.hashCode() : 0)) * 31;
                List<ApplicantDataField.CustomField> list4 = this.f;
                if (list4 != null) {
                    i = list4.hashCode();
                }
                return hashCode5 + i;
            }

            public final boolean isSelfieWithDocument() {
                if (this.a.isSelfie()) {
                    String str = this.d;
                    VideoRequiredType.Companion companion = VideoRequiredType.Companion;
                    if (Intrinsics.areEqual(str, companion.m233getPhotoRequiredu2aduso()) || Intrinsics.areEqual(this.d, companion.m229getDisabledu2aduso())) {
                        return true;
                    }
                }
                return false;
            }

            @Override // java.lang.Object
            @NotNull
            public String toString() {
                StringBuilder L = a.L("DocSetsItem(idDocSetType=");
                L.append(this.a);
                L.append(", types=");
                L.append(this.b);
                L.append(", sides=");
                L.append(this.c);
                L.append(", videoRequired=");
                L.append(this.d);
                L.append(", fields=");
                L.append(this.e);
                L.append(", customField=");
                return a.w(L, this.f, ")");
            }

            @Override // android.os.Parcelable
            public void writeToParcel(@NotNull Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                this.a.writeToParcel(parcel, 0);
                parcel.writeStringList(this.b);
                Iterator n0 = a.n0(this.c, parcel);
                while (n0.hasNext()) {
                    parcel.writeString(((IdentitySide) n0.next()).name());
                }
                parcel.writeString(this.d);
                List<ApplicantDataField.Field> list = this.e;
                if (list != null) {
                    Iterator l0 = a.l0(parcel, 1, list);
                    while (l0.hasNext()) {
                        ((ApplicantDataField.Field) l0.next()).writeToParcel(parcel, 0);
                    }
                } else {
                    parcel.writeInt(0);
                }
                List<ApplicantDataField.CustomField> list2 = this.f;
                if (list2 != null) {
                    Iterator l02 = a.l0(parcel, 1, list2);
                    while (l02.hasNext()) {
                        ((ApplicantDataField.CustomField) l02.next()).writeToParcel(parcel, 0);
                    }
                    return;
                }
                parcel.writeInt(0);
            }
        }

        public RequiredIdDocs(@NotNull List<DocSetsItem> list, @Nullable Set<String> set, @Nullable Set<String> set2) {
            Intrinsics.checkNotNullParameter(list, "docSets");
            this.a = list;
            this.b = set;
            this.c = set2;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.sumsub.sns.core.data.model.Applicant$RequiredIdDocs */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ RequiredIdDocs copy$default(RequiredIdDocs requiredIdDocs, List list, Set set, Set set2, int i, Object obj) {
            if ((i & 1) != 0) {
                list = requiredIdDocs.a;
            }
            if ((i & 2) != 0) {
                set = requiredIdDocs.b;
            }
            if ((i & 4) != 0) {
                set2 = requiredIdDocs.c;
            }
            return requiredIdDocs.copy(list, set, set2);
        }

        @NotNull
        public final List<DocSetsItem> component1() {
            return this.a;
        }

        @Nullable
        public final Set<String> component2() {
            return this.b;
        }

        @Nullable
        public final Set<String> component3() {
            return this.c;
        }

        @NotNull
        public final RequiredIdDocs copy(@NotNull List<DocSetsItem> list, @Nullable Set<String> set, @Nullable Set<String> set2) {
            Intrinsics.checkNotNullParameter(list, "docSets");
            return new RequiredIdDocs(list, set, set2);
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
            if (!(obj instanceof RequiredIdDocs)) {
                return false;
            }
            RequiredIdDocs requiredIdDocs = (RequiredIdDocs) obj;
            return Intrinsics.areEqual(this.a, requiredIdDocs.a) && Intrinsics.areEqual(this.b, requiredIdDocs.b) && Intrinsics.areEqual(this.c, requiredIdDocs.c);
        }

        @NotNull
        public final List<DocSetsItem> getDocSets() {
            return this.a;
        }

        @Nullable
        public final Set<String> getExcludedCountries() {
            return this.c;
        }

        @Nullable
        public final Set<String> getIncludedCountries() {
            return this.b;
        }

        @Override // java.lang.Object
        public int hashCode() {
            List<DocSetsItem> list = this.a;
            int i = 0;
            int hashCode = (list != null ? list.hashCode() : 0) * 31;
            Set<String> set = this.b;
            int hashCode2 = (hashCode + (set != null ? set.hashCode() : 0)) * 31;
            Set<String> set2 = this.c;
            if (set2 != null) {
                i = set2.hashCode();
            }
            return hashCode2 + i;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("RequiredIdDocs(docSets=");
            L.append(this.a);
            L.append(", includedCountries=");
            L.append(this.b);
            L.append(", excludedCountries=");
            L.append(this.c);
            L.append(")");
            return L.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            Iterator n0 = a.n0(this.a, parcel);
            while (n0.hasNext()) {
                ((DocSetsItem) n0.next()).writeToParcel(parcel, 0);
            }
            Set<String> set = this.b;
            if (set != null) {
                parcel.writeInt(1);
                parcel.writeInt(set.size());
                for (String str : set) {
                    parcel.writeString(str);
                }
            } else {
                parcel.writeInt(0);
            }
            Set<String> set2 = this.c;
            if (set2 != null) {
                parcel.writeInt(1);
                parcel.writeInt(set2.size());
                for (String str2 : set2) {
                    parcel.writeString(str2);
                }
                return;
            }
            parcel.writeInt(0);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0014\b\b\u0018\u00002\u00020\u0001:\u00015B7\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b3\u00104J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJJ\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u000bJ\u0010\u0010\u0017\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0018J \u0010#\u001a\u00020\"2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b#\u0010$R\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\u0004R\u0019\u0010\u0010\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010\u0007R\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010&\u001a\u0004\b,\u0010\u0004R\u001b\u0010\u0012\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u0010\u000bR\u001b\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u0010\u000e¨\u00066"}, d2 = {"Lcom/sumsub/sns/core/data/model/Applicant$Review;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/Integer;", "Lcom/sumsub/sns/core/data/model/ReviewStatusType;", "component2", "()Lcom/sumsub/sns/core/data/model/ReviewStatusType;", "component3", "", "component4", "()Ljava/lang/String;", "Lcom/sumsub/sns/core/data/model/Applicant$Review$Result;", "component5", "()Lcom/sumsub/sns/core/data/model/Applicant$Review$Result;", "notificationFailureCnt", "status", Constants.FirelogAnalytics.PARAM_PRIORITY, "createDate", "result", "copy", "(Ljava/lang/Integer;Lcom/sumsub/sns/core/data/model/ReviewStatusType;Ljava/lang/Integer;Ljava/lang/String;Lcom/sumsub/sns/core/data/model/Applicant$Review$Result;)Lcom/sumsub/sns/core/data/model/Applicant$Review;", "toString", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.SEND_ABUSE, "Ljava/lang/Integer;", "getNotificationFailureCnt", AuthSource.BOOKING_ORDER, "Lcom/sumsub/sns/core/data/model/ReviewStatusType;", "getStatus", "c", "getPriority", "d", "Ljava/lang/String;", "getCreateDate", "e", "Lcom/sumsub/sns/core/data/model/Applicant$Review$Result;", "getResult", "<init>", "(Ljava/lang/Integer;Lcom/sumsub/sns/core/data/model/ReviewStatusType;Ljava/lang/Integer;Ljava/lang/String;Lcom/sumsub/sns/core/data/model/Applicant$Review$Result;)V", "Result", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Review implements Parcelable {
        public static final Parcelable.Creator<Review> CREATOR = new Creator();
        @Nullable
        public final Integer a;
        @NotNull
        public final ReviewStatusType b;
        @Nullable
        public final Integer c;
        @Nullable
        public final String d;
        @Nullable
        public final Result e;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Review> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Review createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Review(parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null, (ReviewStatusType) Enum.valueOf(ReviewStatusType.class, parcel.readString()), parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null, parcel.readString(), parcel.readInt() != 0 ? Result.CREATOR.createFromParcel(parcel) : null);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Review[] newArray(int i) {
                return new Review[i];
            }
        }

        @Parcelize
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0013\b\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\f¢\u0006\u0004\b4\u00105J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJL\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00062\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\b\b\u0002\u0010\u0013\u001a\u00020\fHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u001f\u0010\u0019J \u0010$\u001a\u00020#2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b$\u0010%R\u001f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010\u000bR\u0019\u0010\u0011\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010\bR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010\u0004R\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010-\u001a\u0004\b0\u0010\u0004R\u0019\u0010\u0013\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u0010\u000e¨\u00066"}, d2 = {"Lcom/sumsub/sns/core/data/model/Applicant$Review$Result;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component2", "Lcom/sumsub/sns/core/data/model/ReviewAnswerType;", "component3", "()Lcom/sumsub/sns/core/data/model/ReviewAnswerType;", "", "component4", "()Ljava/util/List;", "Lcom/sumsub/sns/core/data/model/ReviewRejectType;", "component5", "()Lcom/sumsub/sns/core/data/model/ReviewRejectType;", "moderationComment", "clientComment", "reviewAnswer", "rejectLabels", "reviewRejectType", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/sumsub/sns/core/data/model/ReviewAnswerType;Ljava/util/List;Lcom/sumsub/sns/core/data/model/ReviewRejectType;)Lcom/sumsub/sns/core/data/model/Applicant$Review$Result;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "d", "Ljava/util/List;", "getRejectLabels", "c", "Lcom/sumsub/sns/core/data/model/ReviewAnswerType;", "getReviewAnswer", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getModerationComment", AuthSource.BOOKING_ORDER, "getClientComment", "e", "Lcom/sumsub/sns/core/data/model/ReviewRejectType;", "getReviewRejectType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/sumsub/sns/core/data/model/ReviewAnswerType;Ljava/util/List;Lcom/sumsub/sns/core/data/model/ReviewRejectType;)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
        public static final class Result implements Parcelable {
            public static final Parcelable.Creator<Result> CREATOR = new Creator();
            @Nullable
            public final String a;
            @Nullable
            public final String b;
            @NotNull
            public final ReviewAnswerType c;
            @NotNull
            public final List<String> d;
            @NotNull
            public final ReviewRejectType e;

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<Result> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Result createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    return new Result(parcel.readString(), parcel.readString(), (ReviewAnswerType) Enum.valueOf(ReviewAnswerType.class, parcel.readString()), parcel.createStringArrayList(), (ReviewRejectType) Enum.valueOf(ReviewRejectType.class, parcel.readString()));
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Result[] newArray(int i) {
                    return new Result[i];
                }
            }

            public Result(@Nullable String str, @Nullable String str2, @NotNull ReviewAnswerType reviewAnswerType, @NotNull List<String> list, @NotNull ReviewRejectType reviewRejectType) {
                Intrinsics.checkNotNullParameter(reviewAnswerType, "reviewAnswer");
                Intrinsics.checkNotNullParameter(list, "rejectLabels");
                Intrinsics.checkNotNullParameter(reviewRejectType, "reviewRejectType");
                this.a = str;
                this.b = str2;
                this.c = reviewAnswerType;
                this.d = list;
                this.e = reviewRejectType;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.sumsub.sns.core.data.model.Applicant$Review$Result */
            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Result copy$default(Result result, String str, String str2, ReviewAnswerType reviewAnswerType, List list, ReviewRejectType reviewRejectType, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = result.a;
                }
                if ((i & 2) != 0) {
                    str2 = result.b;
                }
                if ((i & 4) != 0) {
                    reviewAnswerType = result.c;
                }
                if ((i & 8) != 0) {
                    list = result.d;
                }
                if ((i & 16) != 0) {
                    reviewRejectType = result.e;
                }
                return result.copy(str, str2, reviewAnswerType, list, reviewRejectType);
            }

            @Nullable
            public final String component1() {
                return this.a;
            }

            @Nullable
            public final String component2() {
                return this.b;
            }

            @NotNull
            public final ReviewAnswerType component3() {
                return this.c;
            }

            @NotNull
            public final List<String> component4() {
                return this.d;
            }

            @NotNull
            public final ReviewRejectType component5() {
                return this.e;
            }

            @NotNull
            public final Result copy(@Nullable String str, @Nullable String str2, @NotNull ReviewAnswerType reviewAnswerType, @NotNull List<String> list, @NotNull ReviewRejectType reviewRejectType) {
                Intrinsics.checkNotNullParameter(reviewAnswerType, "reviewAnswer");
                Intrinsics.checkNotNullParameter(list, "rejectLabels");
                Intrinsics.checkNotNullParameter(reviewRejectType, "reviewRejectType");
                return new Result(str, str2, reviewAnswerType, list, reviewRejectType);
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
                if (!(obj instanceof Result)) {
                    return false;
                }
                Result result = (Result) obj;
                return Intrinsics.areEqual(this.a, result.a) && Intrinsics.areEqual(this.b, result.b) && Intrinsics.areEqual(this.c, result.c) && Intrinsics.areEqual(this.d, result.d) && Intrinsics.areEqual(this.e, result.e);
            }

            @Nullable
            public final String getClientComment() {
                return this.b;
            }

            @Nullable
            public final String getModerationComment() {
                return this.a;
            }

            @NotNull
            public final List<String> getRejectLabels() {
                return this.d;
            }

            @NotNull
            public final ReviewAnswerType getReviewAnswer() {
                return this.c;
            }

            @NotNull
            public final ReviewRejectType getReviewRejectType() {
                return this.e;
            }

            @Override // java.lang.Object
            public int hashCode() {
                String str = this.a;
                int i = 0;
                int hashCode = (str != null ? str.hashCode() : 0) * 31;
                String str2 = this.b;
                int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
                ReviewAnswerType reviewAnswerType = this.c;
                int hashCode3 = (hashCode2 + (reviewAnswerType != null ? reviewAnswerType.hashCode() : 0)) * 31;
                List<String> list = this.d;
                int hashCode4 = (hashCode3 + (list != null ? list.hashCode() : 0)) * 31;
                ReviewRejectType reviewRejectType = this.e;
                if (reviewRejectType != null) {
                    i = reviewRejectType.hashCode();
                }
                return hashCode4 + i;
            }

            @Override // java.lang.Object
            @NotNull
            public String toString() {
                StringBuilder L = a.L("Result(moderationComment=");
                L.append(this.a);
                L.append(", clientComment=");
                L.append(this.b);
                L.append(", reviewAnswer=");
                L.append(this.c);
                L.append(", rejectLabels=");
                L.append(this.d);
                L.append(", reviewRejectType=");
                L.append(this.e);
                L.append(")");
                return L.toString();
            }

            @Override // android.os.Parcelable
            public void writeToParcel(@NotNull Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.writeString(this.a);
                parcel.writeString(this.b);
                parcel.writeString(this.c.name());
                parcel.writeStringList(this.d);
                parcel.writeString(this.e.name());
            }
        }

        public Review(@Nullable Integer num, @NotNull ReviewStatusType reviewStatusType, @Nullable Integer num2, @Nullable String str, @Nullable Result result) {
            Intrinsics.checkNotNullParameter(reviewStatusType, "status");
            this.a = num;
            this.b = reviewStatusType;
            this.c = num2;
            this.d = str;
            this.e = result;
        }

        public static /* synthetic */ Review copy$default(Review review, Integer num, ReviewStatusType reviewStatusType, Integer num2, String str, Result result, int i, Object obj) {
            if ((i & 1) != 0) {
                num = review.a;
            }
            if ((i & 2) != 0) {
                reviewStatusType = review.b;
            }
            if ((i & 4) != 0) {
                num2 = review.c;
            }
            if ((i & 8) != 0) {
                str = review.d;
            }
            if ((i & 16) != 0) {
                result = review.e;
            }
            return review.copy(num, reviewStatusType, num2, str, result);
        }

        @Nullable
        public final Integer component1() {
            return this.a;
        }

        @NotNull
        public final ReviewStatusType component2() {
            return this.b;
        }

        @Nullable
        public final Integer component3() {
            return this.c;
        }

        @Nullable
        public final String component4() {
            return this.d;
        }

        @Nullable
        public final Result component5() {
            return this.e;
        }

        @NotNull
        public final Review copy(@Nullable Integer num, @NotNull ReviewStatusType reviewStatusType, @Nullable Integer num2, @Nullable String str, @Nullable Result result) {
            Intrinsics.checkNotNullParameter(reviewStatusType, "status");
            return new Review(num, reviewStatusType, num2, str, result);
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
            if (!(obj instanceof Review)) {
                return false;
            }
            Review review = (Review) obj;
            return Intrinsics.areEqual(this.a, review.a) && Intrinsics.areEqual(this.b, review.b) && Intrinsics.areEqual(this.c, review.c) && Intrinsics.areEqual(this.d, review.d) && Intrinsics.areEqual(this.e, review.e);
        }

        @Nullable
        public final String getCreateDate() {
            return this.d;
        }

        @Nullable
        public final Integer getNotificationFailureCnt() {
            return this.a;
        }

        @Nullable
        public final Integer getPriority() {
            return this.c;
        }

        @Nullable
        public final Result getResult() {
            return this.e;
        }

        @NotNull
        public final ReviewStatusType getStatus() {
            return this.b;
        }

        @Override // java.lang.Object
        public int hashCode() {
            Integer num = this.a;
            int i = 0;
            int hashCode = (num != null ? num.hashCode() : 0) * 31;
            ReviewStatusType reviewStatusType = this.b;
            int hashCode2 = (hashCode + (reviewStatusType != null ? reviewStatusType.hashCode() : 0)) * 31;
            Integer num2 = this.c;
            int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 31;
            String str = this.d;
            int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 31;
            Result result = this.e;
            if (result != null) {
                i = result.hashCode();
            }
            return hashCode4 + i;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("Review(notificationFailureCnt=");
            L.append(this.a);
            L.append(", status=");
            L.append(this.b);
            L.append(", priority=");
            L.append(this.c);
            L.append(", createDate=");
            L.append(this.d);
            L.append(", result=");
            L.append(this.e);
            L.append(")");
            return L.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            Integer num = this.a;
            if (num != null) {
                a.H0(parcel, 1, num);
            } else {
                parcel.writeInt(0);
            }
            parcel.writeString(this.b.name());
            Integer num2 = this.c;
            if (num2 != null) {
                a.H0(parcel, 1, num2);
            } else {
                parcel.writeInt(0);
            }
            parcel.writeString(this.d);
            Result result = this.e;
            if (result != null) {
                parcel.writeInt(1);
                result.writeToParcel(parcel, 0);
                return;
            }
            parcel.writeInt(0);
        }
    }

    public Applicant(@NotNull String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @NotNull RequiredIdDocs requiredIdDocs, @Nullable String str6, @NotNull Review review, @Nullable String str7, @Nullable Info info, @Nullable String str8, @Nullable List<MetaValue> list, @Nullable String str9) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(requiredIdDocs, "requiredIdDocs");
        Intrinsics.checkNotNullParameter(review, AvatarStatus.REVIEW);
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = requiredIdDocs;
        this.g = str6;
        this.h = review;
        this.i = str7;
        this.j = info;
        this.k = str8;
        this.l = list;
        this.m = str9;
    }

    public static /* synthetic */ Applicant copy$default(Applicant applicant, String str, String str2, String str3, String str4, String str5, RequiredIdDocs requiredIdDocs, String str6, Review review, String str7, Info info, String str8, List list, String str9, int i2, Object obj) {
        return applicant.copy((i2 & 1) != 0 ? applicant.a : str, (i2 & 2) != 0 ? applicant.b : str2, (i2 & 4) != 0 ? applicant.c : str3, (i2 & 8) != 0 ? applicant.d : str4, (i2 & 16) != 0 ? applicant.e : str5, (i2 & 32) != 0 ? applicant.f : requiredIdDocs, (i2 & 64) != 0 ? applicant.g : str6, (i2 & 128) != 0 ? applicant.h : review, (i2 & 256) != 0 ? applicant.i : str7, (i2 & 512) != 0 ? applicant.j : info, (i2 & 1024) != 0 ? applicant.k : str8, (i2 & 2048) != 0 ? applicant.l : list, (i2 & 4096) != 0 ? applicant.m : str9);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    @Nullable
    public final Info component10() {
        return this.j;
    }

    @Nullable
    public final String component11() {
        return this.k;
    }

    @Nullable
    public final List<MetaValue> component12() {
        return this.l;
    }

    @Nullable
    public final String component13() {
        return this.m;
    }

    @Nullable
    public final String component2() {
        return this.b;
    }

    @Nullable
    public final String component3() {
        return this.c;
    }

    @Nullable
    public final String component4() {
        return this.d;
    }

    @Nullable
    public final String component5() {
        return this.e;
    }

    @NotNull
    public final RequiredIdDocs component6() {
        return this.f;
    }

    @Nullable
    public final String component7() {
        return this.g;
    }

    @NotNull
    public final Review component8() {
        return this.h;
    }

    @Nullable
    public final String component9() {
        return this.i;
    }

    @NotNull
    public final Applicant copy(@NotNull String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @NotNull RequiredIdDocs requiredIdDocs, @Nullable String str6, @NotNull Review review, @Nullable String str7, @Nullable Info info, @Nullable String str8, @Nullable List<MetaValue> list, @Nullable String str9) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(requiredIdDocs, "requiredIdDocs");
        Intrinsics.checkNotNullParameter(review, AvatarStatus.REVIEW);
        return new Applicant(str, str2, str3, str4, str5, requiredIdDocs, str6, review, str7, info, str8, list, str9);
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
        if (!(obj instanceof Applicant)) {
            return false;
        }
        Applicant applicant = (Applicant) obj;
        return Intrinsics.areEqual(this.a, applicant.a) && Intrinsics.areEqual(this.b, applicant.b) && Intrinsics.areEqual(this.c, applicant.c) && Intrinsics.areEqual(this.d, applicant.d) && Intrinsics.areEqual(this.e, applicant.e) && Intrinsics.areEqual(this.f, applicant.f) && Intrinsics.areEqual(this.g, applicant.g) && Intrinsics.areEqual(this.h, applicant.h) && Intrinsics.areEqual(this.i, applicant.i) && Intrinsics.areEqual(this.j, applicant.j) && Intrinsics.areEqual(this.k, applicant.k) && Intrinsics.areEqual(this.l, applicant.l) && Intrinsics.areEqual(this.m, applicant.m);
    }

    @Nullable
    public final String getClientId() {
        return this.c;
    }

    @Nullable
    public final String getCountry() {
        Info info = this.j;
        if (info != null) {
            return info.getCountry();
        }
        return null;
    }

    @Nullable
    public final String getCreatedAt() {
        return this.d;
    }

    @Nullable
    public final RequiredIdDocs.DocSetsItem getDocSetByType(@NotNull DocumentType documentType) {
        T t;
        Intrinsics.checkNotNullParameter(documentType, "type");
        Iterator<T> it = this.f.getDocSets().iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (Intrinsics.areEqual(t.getIdDocSetType(), documentType)) {
                break;
            }
        }
        return t;
    }

    @NotNull
    public final List<DocumentType> getDocuments() {
        List<RequiredIdDocs.DocSetsItem> docSets = this.f.getDocSets();
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(docSets, 10));
        Iterator<T> it = docSets.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getIdDocSetType());
        }
        return arrayList;
    }

    @Nullable
    public final String getEmail() {
        return this.m;
    }

    @Nullable
    public final String getEnv() {
        return this.i;
    }

    @Nullable
    public final String getExternalUserId() {
        return this.g;
    }

    @NotNull
    public final String getId() {
        return this.a;
    }

    @NotNull
    public final List<IdentityType> getIdentityList(@NotNull DocumentType documentType) {
        List<String> types;
        Intrinsics.checkNotNullParameter(documentType, "type");
        RequiredIdDocs.DocSetsItem docSetByType = getDocSetByType(documentType);
        if (docSetByType == null || (types = docSetByType.getTypes()) == null) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(types, 10));
        Iterator<T> it = types.iterator();
        while (it.hasNext()) {
            arrayList.add(IdentityType.m201boximpl(IdentityType.m202constructorimpl(it.next())));
        }
        return arrayList;
    }

    @Nullable
    public final Info getInfo() {
        return this.j;
    }

    @Nullable
    public final String getInspectionId() {
        return this.e;
    }

    @Nullable
    public final String getLang() {
        return this.k;
    }

    @Nullable
    public final List<MetaValue> getMetadata() {
        return this.l;
    }

    @NotNull
    public final RequiredIdDocs getRequiredIdDocs() {
        return this.f;
    }

    @NotNull
    public final Review getReview() {
        return this.h;
    }

    @NotNull
    public final ReviewStatusType getStatus() {
        return this.h.getStatus();
    }

    @Nullable
    public final String getType() {
        return this.b;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.a;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.c;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.d;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.e;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        RequiredIdDocs requiredIdDocs = this.f;
        int hashCode6 = (hashCode5 + (requiredIdDocs != null ? requiredIdDocs.hashCode() : 0)) * 31;
        String str6 = this.g;
        int hashCode7 = (hashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31;
        Review review = this.h;
        int hashCode8 = (hashCode7 + (review != null ? review.hashCode() : 0)) * 31;
        String str7 = this.i;
        int hashCode9 = (hashCode8 + (str7 != null ? str7.hashCode() : 0)) * 31;
        Info info = this.j;
        int hashCode10 = (hashCode9 + (info != null ? info.hashCode() : 0)) * 31;
        String str8 = this.k;
        int hashCode11 = (hashCode10 + (str8 != null ? str8.hashCode() : 0)) * 31;
        List<MetaValue> list = this.l;
        int hashCode12 = (hashCode11 + (list != null ? list.hashCode() : 0)) * 31;
        String str9 = this.m;
        if (str9 != null) {
            i2 = str9.hashCode();
        }
        return hashCode12 + i2;
    }

    public final boolean isApproved() {
        Review.Result result = this.h.getResult();
        return (result != null ? result.getReviewAnswer() : null) == ReviewAnswerType.Green;
    }

    public final boolean isFinallyRejected() {
        Review.Result result = this.h.getResult();
        ReviewRejectType reviewRejectType = null;
        if ((result != null ? result.getReviewAnswer() : null) == ReviewAnswerType.Red && this.h.getStatus() == ReviewStatusType.Completed) {
            Review.Result result2 = this.h.getResult();
            if ((result2 != null ? result2.getReviewRejectType() : null) != ReviewRejectType.Final) {
                Review.Result result3 = this.h.getResult();
                if (result3 != null) {
                    reviewRejectType = result3.getReviewRejectType();
                }
                if (reviewRejectType == ReviewRejectType.External) {
                }
            }
            return true;
        }
        return false;
    }

    public final boolean isTemporarilyDeclined() {
        Review.Result result = this.h.getResult();
        ReviewRejectType reviewRejectType = null;
        if ((result != null ? result.getReviewAnswer() : null) == ReviewAnswerType.Red && this.h.getStatus() == ReviewStatusType.Completed) {
            Review.Result result2 = this.h.getResult();
            if (result2 != null) {
                reviewRejectType = result2.getReviewRejectType();
            }
            if (reviewRejectType == ReviewRejectType.Retry) {
                return true;
            }
        }
        return false;
    }

    public final void setReview(@NotNull Review review) {
        Intrinsics.checkNotNullParameter(review, "<set-?>");
        this.h = review;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("Applicant(id=");
        L.append(this.a);
        L.append(", type=");
        L.append(this.b);
        L.append(", clientId=");
        L.append(this.c);
        L.append(", createdAt=");
        L.append(this.d);
        L.append(", inspectionId=");
        L.append(this.e);
        L.append(", requiredIdDocs=");
        L.append(this.f);
        L.append(", externalUserId=");
        L.append(this.g);
        L.append(", review=");
        L.append(this.h);
        L.append(", env=");
        L.append(this.i);
        L.append(", info=");
        L.append(this.j);
        L.append(", lang=");
        L.append(this.k);
        L.append(", metadata=");
        L.append(this.l);
        L.append(", email=");
        return a.t(L, this.m, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        this.f.writeToParcel(parcel, 0);
        parcel.writeString(this.g);
        this.h.writeToParcel(parcel, 0);
        parcel.writeString(this.i);
        Info info = this.j;
        if (info != null) {
            parcel.writeInt(1);
            info.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.k);
        List<MetaValue> list = this.l;
        if (list != null) {
            Iterator l0 = a.l0(parcel, 1, list);
            while (l0.hasNext()) {
                ((MetaValue) l0.next()).writeToParcel(parcel, 0);
            }
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.m);
    }
}
