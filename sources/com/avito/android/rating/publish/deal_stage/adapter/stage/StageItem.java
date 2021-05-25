package com.avito.android.rating.publish.deal_stage.adapter.stage;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.rating.publish.deal_stage.adapter.DealStageItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.publish.DealStage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\u0006\u0010\u001a\u001a\u00020\u0017¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0010\u001a\u00020\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0016\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u001a\u001a\u00020\u00178\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lcom/avito/android/rating/publish/deal_stage/adapter/stage/StageItem;", "Lcom/avito/android/rating/publish/deal_stage/adapter/DealStageItem;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", AuthSource.BOOKING_ORDER, "J", "getId", "()J", "id", "Lcom/avito/android/remote/model/publish/DealStage;", "c", "Lcom/avito/android/remote/model/publish/DealStage;", "getStage", "()Lcom/avito/android/remote/model/publish/DealStage;", "stage", "", "d", "Z", "isChecked", "()Z", "setChecked", "(Z)V", "<init>", "(JLcom/avito/android/remote/model/publish/DealStage;Z)V", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class StageItem extends DealStageItem {
    public static final Parcelable.Creator<StageItem> CREATOR = new Creator();
    public final long b;
    @NotNull
    public final DealStage c;
    public boolean d;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<StageItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final StageItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new StageItem(parcel.readLong(), (DealStage) parcel.readParcelable(StageItem.class.getClassLoader()), parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final StageItem[] newArray(int i) {
            return new StageItem[i];
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StageItem(long j, @NotNull DealStage dealStage, boolean z) {
        super(j);
        Intrinsics.checkNotNullParameter(dealStage, "stage");
        this.b = j;
        this.c = dealStage;
        this.d = z;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.avito.android.rating.publish.deal_stage.adapter.DealStageItem, com.avito.konveyor.blueprint.Item
    public long getId() {
        return this.b;
    }

    @NotNull
    public final DealStage getStage() {
        return this.c;
    }

    public final boolean isChecked() {
        return this.d;
    }

    public final void setChecked(boolean z) {
        this.d = z;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.b);
        parcel.writeParcelable(this.c, i);
        parcel.writeInt(this.d ? 1 : 0);
    }
}
