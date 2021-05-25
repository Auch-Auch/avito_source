package com.avito.android.rating.details.adapter.rating;

import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.rating.details.adapter.RatingDetailsItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0016\u0018\u0000 .2\u00020\u0001:\u0001.BO\u0012\u0006\u0010!\u001a\u00020\t\u0012\u0006\u0010&\u001a\u00020\u000f\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\t\u0012\b\u0010+\u001a\u0004\u0018\u00010\u0004\u0012\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018¢\u0006\u0004\b,\u0010-J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001b\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0016\u0010\rR!\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00188\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010!\u001a\u00020\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b \u0010\rR\u0019\u0010&\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001b\u0010+\u001a\u0004\u0018\u00010\u00048\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*¨\u0006/"}, d2 = {"Lcom/avito/android/rating/details/adapter/rating/RatingItem;", "Lcom/avito/android/rating/details/adapter/RatingDetailsItem;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "d", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", "", "c", "Ljava/lang/Float;", "getScoreFloat", "()Ljava/lang/Float;", "scoreFloat", "e", "getSubtitle", MessengerShareContentUtility.SUBTITLE, "", "Lcom/avito/android/rating/details/adapter/rating/RatingStatEntry;", g.a, "Ljava/util/List;", "getRatingStat", "()Ljava/util/List;", "ratingStat", AuthSource.SEND_ABUSE, "getStringId", "stringId", AuthSource.BOOKING_ORDER, "F", "getScore", "()F", "score", "f", "Ljava/lang/Integer;", "getReviewCount", "()Ljava/lang/Integer;", "reviewCount", "<init>", "(Ljava/lang/String;FLjava/lang/Float;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;)V", "Companion", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class RatingItem extends RatingDetailsItem {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<RatingItem> CREATOR = Parcels.creator(a.a);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public final String a;
    public final float b;
    @Nullable
    public final Float c;
    @Nullable
    public final String d;
    @Nullable
    public final String e;
    @Nullable
    public final Integer f;
    @Nullable
    public final List<RatingStatEntry> g;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/rating/details/adapter/rating/RatingItem$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/rating/details/adapter/rating/RatingItem;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "rating_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<Parcel, RatingItem> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public RatingItem invoke(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "$receiver");
            String u2 = a2.b.a.a.a.u2(parcel2, "readString()!!");
            float readFloat = parcel2.readFloat();
            Object readValue = parcel2.readValue(Float.class.getClassLoader());
            Integer num = null;
            if (!(readValue instanceof Float)) {
                readValue = null;
            }
            Float f = (Float) readValue;
            String readString = parcel2.readString();
            String readString2 = parcel2.readString();
            Object readValue2 = parcel2.readValue(Integer.class.getClassLoader());
            if (readValue2 instanceof Integer) {
                num = readValue2;
            }
            return new RatingItem(u2, readFloat, f, readString, readString2, num, ParcelsKt.createParcelableList(parcel2, RatingStatEntry.class));
        }
    }

    public RatingItem(@NotNull String str, float f2, @Nullable Float f3, @Nullable String str2, @Nullable String str3, @Nullable Integer num, @Nullable List<RatingStatEntry> list) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        this.a = str;
        this.b = f2;
        this.c = f3;
        this.d = str2;
        this.e = str3;
        this.f = num;
        this.g = list;
    }

    @Nullable
    public final List<RatingStatEntry> getRatingStat() {
        return this.g;
    }

    @Nullable
    public final Integer getReviewCount() {
        return this.f;
    }

    public final float getScore() {
        return this.b;
    }

    @Nullable
    public final Float getScoreFloat() {
        return this.c;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }

    @Nullable
    public final String getSubtitle() {
        return this.e;
    }

    @Nullable
    public final String getTitle() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(getStringId());
        parcel.writeFloat(this.b);
        ParcelsKt.writeNullableValue(parcel, this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        ParcelsKt.writeNullableValue(parcel, this.f);
        ParcelsKt.writeOptimizedParcelableList(parcel, this.g, i);
    }
}
