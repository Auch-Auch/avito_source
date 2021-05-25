package com.avito.android.deep_linking.links;

import a2.b.a.a.a;
import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SearchParams;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010+\u001a\u00020&\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0016\u0012\b\u00101\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010.\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b2\u00103J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR!\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001b\u0010%\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010\u0018\u001a\u0004\b$\u0010\u001aR\u0019\u0010+\u001a\u00020&8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001b\u0010.\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010\u0018\u001a\u0004\b-\u0010\u001aR\u001b\u00101\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010\u0018\u001a\u0004\b0\u0010\u001a¨\u00064"}, d2 = {"Lcom/avito/android/deep_linking/links/SearchPushSubscription;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/SearchParams;", g.a, "Lcom/avito/android/remote/model/SearchParams;", "getSearchParams", "()Lcom/avito/android/remote/model/SearchParams;", "searchParams", "e", "Ljava/lang/Integer;", "getPushFrequencyId", "()Ljava/lang/Integer;", "pushFrequencyId", "", "d", "Ljava/lang/String;", "getDescription", "()Ljava/lang/String;", "description", "", "Lcom/avito/android/deep_linking/links/PushFrequencyOption;", "f", "Ljava/util/List;", "getPushFrequencyOptions", "()Ljava/util/List;", "pushFrequencyOptions", AuthSource.BOOKING_ORDER, "getFilterId", "filterId", "Lcom/avito/android/deep_linking/links/SaveSearchLinkType;", AuthSource.SEND_ABUSE, "Lcom/avito/android/deep_linking/links/SaveSearchLinkType;", "getType", "()Lcom/avito/android/deep_linking/links/SaveSearchLinkType;", "type", "h", "getXHash", "xHash", "c", "getTitle", "title", "<init>", "(Lcom/avito/android/deep_linking/links/SaveSearchLinkType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Lcom/avito/android/remote/model/SearchParams;Ljava/lang/String;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class SearchPushSubscription implements Parcelable {
    public static final Parcelable.Creator<SearchPushSubscription> CREATOR = new Creator();
    @NotNull
    public final SaveSearchLinkType a;
    @Nullable
    public final String b;
    @Nullable
    public final String c;
    @Nullable
    public final String d;
    @Nullable
    public final Integer e;
    @Nullable
    public final List<PushFrequencyOption> f;
    @Nullable
    public final SearchParams g;
    @Nullable
    public final String h;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<SearchPushSubscription> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SearchPushSubscription createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            SaveSearchLinkType saveSearchLinkType = (SaveSearchLinkType) Enum.valueOf(SaveSearchLinkType.class, parcel.readString());
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            ArrayList arrayList = null;
            Integer valueOf = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add(PushFrequencyOption.CREATOR.createFromParcel(parcel));
                    readInt--;
                }
            }
            return new SearchPushSubscription(saveSearchLinkType, readString, readString2, readString3, valueOf, arrayList, (SearchParams) parcel.readParcelable(SearchPushSubscription.class.getClassLoader()), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SearchPushSubscription[] newArray(int i) {
            return new SearchPushSubscription[i];
        }
    }

    public SearchPushSubscription(@NotNull SaveSearchLinkType saveSearchLinkType, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Integer num, @Nullable List<PushFrequencyOption> list, @Nullable SearchParams searchParams, @Nullable String str4) {
        Intrinsics.checkNotNullParameter(saveSearchLinkType, "type");
        this.a = saveSearchLinkType;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = num;
        this.f = list;
        this.g = searchParams;
        this.h = str4;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final String getDescription() {
        return this.d;
    }

    @Nullable
    public final String getFilterId() {
        return this.b;
    }

    @Nullable
    public final Integer getPushFrequencyId() {
        return this.e;
    }

    @Nullable
    public final List<PushFrequencyOption> getPushFrequencyOptions() {
        return this.f;
    }

    @Nullable
    public final SearchParams getSearchParams() {
        return this.g;
    }

    @Nullable
    public final String getTitle() {
        return this.c;
    }

    @NotNull
    public final SaveSearchLinkType getType() {
        return this.a;
    }

    @Nullable
    public final String getXHash() {
        return this.h;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a.name());
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        Integer num = this.e;
        if (num != null) {
            a.H0(parcel, 1, num);
        } else {
            parcel.writeInt(0);
        }
        List<PushFrequencyOption> list = this.f;
        if (list != null) {
            Iterator l0 = a.l0(parcel, 1, list);
            while (l0.hasNext()) {
                ((PushFrequencyOption) l0.next()).writeToParcel(parcel, 0);
            }
        } else {
            parcel.writeInt(0);
        }
        parcel.writeParcelable(this.g, i);
        parcel.writeString(this.h);
    }
}
