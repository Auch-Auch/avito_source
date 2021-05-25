package com.avito.android.payment;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/payment/ProcessingResultState;", "Landroid/os/Parcelable;", "<init>", "()V", "IntermediateState", "TerminatedState", "Lcom/avito/android/payment/ProcessingResultState$TerminatedState;", "Lcom/avito/android/payment/ProcessingResultState$IntermediateState;", "payment-core_release"}, k = 1, mv = {1, 4, 2})
public abstract class ProcessingResultState implements Parcelable {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0000\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/payment/ProcessingResultState$IntermediateState;", "Lcom/avito/android/payment/ProcessingResultState;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "<init>", "()V", "CREATOR", "payment-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class IntermediateState extends ProcessingResultState {
        @NotNull
        public static final CREATOR CREATOR = new CREATOR(null);

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/payment/ProcessingResultState$IntermediateState$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/payment/ProcessingResultState$IntermediateState;", "Landroid/os/Parcel;", "parcel", "createFromParcel", "(Landroid/os/Parcel;)Lcom/avito/android/payment/ProcessingResultState$IntermediateState;", "", "size", "", "newArray", "(I)[Lcom/avito/android/payment/ProcessingResultState$IntermediateState;", "<init>", "()V", "payment-core_release"}, k = 1, mv = {1, 4, 2})
        public static final class CREATOR implements Parcelable.Creator<IntermediateState> {
            public CREATOR() {
            }

            public CREATOR(j jVar) {
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public IntermediateState createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new IntermediateState();
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public IntermediateState[] newArray(int i) {
                return new IntermediateState[i];
            }
        }

        public IntermediateState() {
            super(null);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0000\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/payment/ProcessingResultState$TerminatedState;", "Lcom/avito/android/payment/ProcessingResultState;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "<init>", "()V", "CREATOR", "payment-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class TerminatedState extends ProcessingResultState {
        @NotNull
        public static final CREATOR CREATOR = new CREATOR(null);

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/payment/ProcessingResultState$TerminatedState$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/payment/ProcessingResultState$TerminatedState;", "Landroid/os/Parcel;", "parcel", "createFromParcel", "(Landroid/os/Parcel;)Lcom/avito/android/payment/ProcessingResultState$TerminatedState;", "", "size", "", "newArray", "(I)[Lcom/avito/android/payment/ProcessingResultState$TerminatedState;", "<init>", "()V", "payment-core_release"}, k = 1, mv = {1, 4, 2})
        public static final class CREATOR implements Parcelable.Creator<TerminatedState> {
            public CREATOR() {
            }

            public CREATOR(j jVar) {
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public TerminatedState createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new TerminatedState();
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public TerminatedState[] newArray(int i) {
                return new TerminatedState[i];
            }
        }

        public TerminatedState() {
            super(null);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
        }
    }

    public ProcessingResultState() {
    }

    public ProcessingResultState(j jVar) {
    }
}
