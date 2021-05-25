package com.avito.android.feedback_adverts;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.feedback.FeedbackAdvertItem;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000  2\u00020\u0001:\u0001 B1\u0012\u0006\u0010\u001b\u001a\u00020\u0016\u0012\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\u0006\u0010\u0015\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR!\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0015\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\nR\u0019\u0010\u001b\u001a\u00020\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010\u001d\u001a\u00020\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0018\u001a\u0004\b\u001d\u0010\u001a¨\u0006!"}, d2 = {"Lcom/avito/android/feedback_adverts/FeedbackAdvertsPresenterState;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "Lcom/avito/android/remote/feedback/FeedbackAdvertItem;", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "getItemList", "()Ljava/util/List;", "itemList", "c", "I", "getNextPage", "nextPage", "", AuthSource.SEND_ABUSE, "Z", "getHasMorePages", "()Z", "hasMorePages", "d", "isNetworkProblem", "<init>", "(ZLjava/util/List;IZ)V", "Companion", "feedback-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class FeedbackAdvertsPresenterState implements Parcelable {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<FeedbackAdvertsPresenterState> CREATOR = Parcels.creator(a.a);
    @NotNull
    public static final Companion Companion = new Companion(null);
    public final boolean a;
    @Nullable
    public final List<FeedbackAdvertItem> b;
    public final int c;
    public final boolean d;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/feedback_adverts/FeedbackAdvertsPresenterState$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/feedback_adverts/FeedbackAdvertsPresenterState;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "feedback-adverts_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<Parcel, FeedbackAdvertsPresenterState> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public FeedbackAdvertsPresenterState invoke(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "$receiver");
            return new FeedbackAdvertsPresenterState(ParcelsKt.readBool(parcel2), ParcelsKt.createParcelableList(parcel2, FeedbackAdvertItem.class), parcel2.readInt(), ParcelsKt.readBool(parcel2));
        }
    }

    public FeedbackAdvertsPresenterState(boolean z, @Nullable List<FeedbackAdvertItem> list, int i, boolean z2) {
        this.a = z;
        this.b = list;
        this.c = i;
        this.d = z2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final boolean getHasMorePages() {
        return this.a;
    }

    @Nullable
    public final List<FeedbackAdvertItem> getItemList() {
        return this.b;
    }

    public final int getNextPage() {
        return this.c;
    }

    public final boolean isNetworkProblem() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        ParcelsKt.writeBool(parcel, this.a);
        ParcelsKt.writeOptimizedParcelableList$default(parcel, this.b, 0, 2, null);
        parcel.writeInt(this.c);
        ParcelsKt.writeBool(parcel, this.d);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FeedbackAdvertsPresenterState(boolean z, List list, int i, boolean z2, int i2, j jVar) {
        this(z, list, i, (i2 & 8) != 0 ? false : z2);
    }
}
