package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.teaser.TeaserInsight;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0010¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0018\u0010\u0015¨\u0006\u001b"}, d2 = {"Lcom/avito/android/remote/model/CREGeoReportTeaser;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "", "Lcom/avito/android/remote/model/teaser/TeaserInsight;", "insights", "Ljava/util/List;", "getInsights", "()Ljava/util/List;", "Lcom/avito/android/remote/model/Action;", "actions", "getActions", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class CREGeoReportTeaser implements Parcelable {
    public static final Parcelable.Creator<CREGeoReportTeaser> CREATOR = new Creator();
    @SerializedName("actions")
    @NotNull
    private final List<Action> actions;
    @SerializedName("insights")
    @NotNull
    private final List<TeaserInsight> insights;
    @SerializedName("title")
    @NotNull
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<CREGeoReportTeaser> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CREGeoReportTeaser createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add(TeaserInsight.CREATOR.createFromParcel(parcel));
                readInt--;
            }
            int readInt2 = parcel.readInt();
            ArrayList arrayList2 = new ArrayList(readInt2);
            while (readInt2 != 0) {
                arrayList2.add((Action) parcel.readParcelable(CREGeoReportTeaser.class.getClassLoader()));
                readInt2--;
            }
            return new CREGeoReportTeaser(readString, arrayList, arrayList2);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CREGeoReportTeaser[] newArray(int i) {
            return new CREGeoReportTeaser[i];
        }
    }

    public CREGeoReportTeaser(@NotNull String str, @NotNull List<TeaserInsight> list, @NotNull List<Action> list2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(list, "insights");
        Intrinsics.checkNotNullParameter(list2, "actions");
        this.title = str;
        this.insights = list;
        this.actions = list2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final List<Action> getActions() {
        return this.actions;
    }

    @NotNull
    public final List<TeaserInsight> getInsights() {
        return this.insights;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.title);
        Iterator n0 = a.n0(this.insights, parcel);
        while (n0.hasNext()) {
            ((TeaserInsight) n0.next()).writeToParcel(parcel, 0);
        }
        Iterator n02 = a.n0(this.actions, parcel);
        while (n02.hasNext()) {
            parcel.writeParcelable((Action) n02.next(), i);
        }
    }
}
