package com.avito.android.remote.model.rating_details_legacy;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.Action;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB+\u0012\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R$\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00158\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/avito/android/remote/model/rating_details_legacy/RatingDetailsResult;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "Lcom/avito/android/remote/model/Action;", "action", "Lcom/avito/android/remote/model/Action;", "getAction", "()Lcom/avito/android/remote/model/Action;", "Landroid/net/Uri;", "nextPage", "Landroid/net/Uri;", "getNextPage", "()Landroid/net/Uri;", "", "Lcom/avito/android/remote/model/rating_details_legacy/RatingDetailsElement;", MessengerShareContentUtility.ELEMENTS, "Ljava/util/List;", "getElements", "()Ljava/util/List;", "<init>", "(Ljava/util/List;Landroid/net/Uri;Lcom/avito/android/remote/model/Action;)V", "Companion", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class RatingDetailsResult implements Parcelable {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<RatingDetailsResult> CREATOR = Parcels.creator(RatingDetailsResult$Companion$CREATOR$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @SerializedName("action")
    @Nullable
    private final Action action;
    @SerializedName("entries")
    @Nullable
    private final List<RatingDetailsElement> elements;
    @SerializedName("nextPage")
    @Nullable
    private final Uri nextPage;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/rating_details_legacy/RatingDetailsResult$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/rating_details_legacy/RatingDetailsResult;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "rating_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.util.List<? extends com.avito.android.remote.model.rating_details_legacy.RatingDetailsElement> */
    /* JADX WARN: Multi-variable type inference failed */
    public RatingDetailsResult(@Nullable List<? extends RatingDetailsElement> list, @Nullable Uri uri, @Nullable Action action2) {
        this.elements = list;
        this.nextPage = uri;
        this.action = action2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final Action getAction() {
        return this.action;
    }

    @Nullable
    public final List<RatingDetailsElement> getElements() {
        return this.elements;
    }

    @Nullable
    public final Uri getNextPage() {
        return this.nextPage;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        ParcelsKt.writeOptimizedParcelableList$default(parcel, this.elements, 0, 2, null);
        parcel.writeParcelable(this.nextPage, i);
        parcel.writeParcelable(this.action, i);
    }
}
