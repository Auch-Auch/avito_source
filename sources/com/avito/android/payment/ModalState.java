package com.avito.android.payment;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SimpleUserDialog;
import com.avito.android.util.ParcelsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0005\t\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/payment/ModalState;", "", "<init>", "()V", "Empty", "ModalError", "NotifyingDialog", "SBOLAppLaunchError", "SBOLResultDialog", "Lcom/avito/android/payment/ModalState$NotifyingDialog;", "Lcom/avito/android/payment/ModalState$ModalError;", "Lcom/avito/android/payment/ModalState$Empty;", "Lcom/avito/android/payment/ModalState$SBOLResultDialog;", "Lcom/avito/android/payment/ModalState$SBOLAppLaunchError;", "payment-core_release"}, k = 1, mv = {1, 4, 2})
public abstract class ModalState {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/payment/ModalState$Empty;", "Lcom/avito/android/payment/ModalState;", "<init>", "()V", "payment-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Empty extends ModalState {
        public Empty() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/payment/ModalState$ModalError;", "Lcom/avito/android/payment/ModalState;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "message", "<init>", "(Ljava/lang/String;)V", "payment-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class ModalError extends ModalState {
        @NotNull
        public final String a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ModalError(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "message");
            this.a = str;
        }

        @NotNull
        public final String getMessage() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 \u001b2\u00020\u00012\u00020\u0002:\u0001\u001bB\u0019\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0012¢\u0006\u0004\b\u0018\u0010\u0019B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0018\u0010\u001aJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\u0011\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0017\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001c"}, d2 = {"Lcom/avito/android/payment/ModalState$NotifyingDialog;", "Lcom/avito/android/payment/ModalState;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "Lcom/avito/android/remote/model/SimpleUserDialog;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/SimpleUserDialog;", "getUserDialog", "()Lcom/avito/android/remote/model/SimpleUserDialog;", "userDialog", "", AuthSource.BOOKING_ORDER, "Z", "getShouldCloseActivityOnDismiss", "()Z", "shouldCloseActivityOnDismiss", "<init>", "(Lcom/avito/android/remote/model/SimpleUserDialog;Z)V", "(Landroid/os/Parcel;)V", "CREATOR", "payment-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class NotifyingDialog extends ModalState implements Parcelable {
        @NotNull
        public static final CREATOR CREATOR = new CREATOR(null);
        @NotNull
        public final SimpleUserDialog a;
        public final boolean b;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/payment/ModalState$NotifyingDialog$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/payment/ModalState$NotifyingDialog;", "Landroid/os/Parcel;", "parcel", "createFromParcel", "(Landroid/os/Parcel;)Lcom/avito/android/payment/ModalState$NotifyingDialog;", "", "size", "", "newArray", "(I)[Lcom/avito/android/payment/ModalState$NotifyingDialog;", "<init>", "()V", "payment-core_release"}, k = 1, mv = {1, 4, 2})
        public static final class CREATOR implements Parcelable.Creator<NotifyingDialog> {
            public CREATOR() {
            }

            public CREATOR(j jVar) {
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public NotifyingDialog createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new NotifyingDialog(parcel);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public NotifyingDialog[] newArray(int i) {
                return new NotifyingDialog[i];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public NotifyingDialog(@NotNull SimpleUserDialog simpleUserDialog, boolean z) {
            super(null);
            Intrinsics.checkNotNullParameter(simpleUserDialog, "userDialog");
            this.a = simpleUserDialog;
            this.b = z;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public final boolean getShouldCloseActivityOnDismiss() {
            return this.b;
        }

        @NotNull
        public final SimpleUserDialog getUserDialog() {
            return this.a;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeParcelable(this.a, i);
            ParcelsKt.writeBool(parcel, true);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ NotifyingDialog(SimpleUserDialog simpleUserDialog, boolean z, int i, j jVar) {
            this(simpleUserDialog, (i & 2) != 0 ? false : z);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public NotifyingDialog(@org.jetbrains.annotations.NotNull android.os.Parcel r2) {
            /*
                r1 = this;
                java.lang.String r0 = "parcel"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                java.lang.Class<com.avito.android.remote.model.SimpleUserDialog> r0 = com.avito.android.remote.model.SimpleUserDialog.class
                java.lang.ClassLoader r0 = r0.getClassLoader()
                android.os.Parcelable r0 = r2.readParcelable(r0)
                kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
                com.avito.android.remote.model.SimpleUserDialog r0 = (com.avito.android.remote.model.SimpleUserDialog) r0
                boolean r2 = com.avito.android.util.ParcelsKt.readBool(r2)
                r1.<init>(r0, r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.avito.android.payment.ModalState.NotifyingDialog.<init>(android.os.Parcel):void");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 \u000f2\u00020\u00012\u00020\u0002:\u0001\u000fB\u0007¢\u0006\u0004\b\f\u0010\rB\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\u000eJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/avito/android/payment/ModalState$SBOLAppLaunchError;", "Lcom/avito/android/payment/ModalState;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "<init>", "()V", "(Landroid/os/Parcel;)V", "CREATOR", "payment-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class SBOLAppLaunchError extends ModalState implements Parcelable {
        @NotNull
        public static final CREATOR CREATOR = new CREATOR(null);

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/payment/ModalState$SBOLAppLaunchError$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/payment/ModalState$SBOLAppLaunchError;", "Landroid/os/Parcel;", "parcel", "createFromParcel", "(Landroid/os/Parcel;)Lcom/avito/android/payment/ModalState$SBOLAppLaunchError;", "", "size", "", "newArray", "(I)[Lcom/avito/android/payment/ModalState$SBOLAppLaunchError;", "<init>", "()V", "payment-core_release"}, k = 1, mv = {1, 4, 2})
        public static final class CREATOR implements Parcelable.Creator<SBOLAppLaunchError> {
            public CREATOR() {
            }

            public CREATOR(j jVar) {
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public SBOLAppLaunchError createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new SBOLAppLaunchError(parcel);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public SBOLAppLaunchError[] newArray(int i) {
                return new SBOLAppLaunchError[i];
            }
        }

        public SBOLAppLaunchError() {
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

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public SBOLAppLaunchError(@NotNull Parcel parcel) {
            this();
            Intrinsics.checkNotNullParameter(parcel, "parcel");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 \u00152\u00020\u00012\u00020\u0002:\u0001\u0015B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\f¢\u0006\u0004\b\u0012\u0010\u0013B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0012\u0010\u0014J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\u0011\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/avito/android/payment/ModalState$SBOLResultDialog;", "Lcom/avito/android/payment/ModalState;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", AuthSource.SEND_ABUSE, "Z", "getSuccess", "()Z", "success", "<init>", "(Z)V", "(Landroid/os/Parcel;)V", "CREATOR", "payment-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class SBOLResultDialog extends ModalState implements Parcelable {
        @NotNull
        public static final CREATOR CREATOR = new CREATOR(null);
        public final boolean a;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/payment/ModalState$SBOLResultDialog$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/payment/ModalState$SBOLResultDialog;", "Landroid/os/Parcel;", "parcel", "createFromParcel", "(Landroid/os/Parcel;)Lcom/avito/android/payment/ModalState$SBOLResultDialog;", "", "size", "", "newArray", "(I)[Lcom/avito/android/payment/ModalState$SBOLResultDialog;", "<init>", "()V", "payment-core_release"}, k = 1, mv = {1, 4, 2})
        public static final class CREATOR implements Parcelable.Creator<SBOLResultDialog> {
            public CREATOR() {
            }

            public CREATOR(j jVar) {
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public SBOLResultDialog createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new SBOLResultDialog(parcel);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public SBOLResultDialog[] newArray(int i) {
                return new SBOLResultDialog[i];
            }
        }

        public SBOLResultDialog(boolean z) {
            super(null);
            this.a = z;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public final boolean getSuccess() {
            return this.a;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeByte(this.a ? (byte) 1 : 0);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public SBOLResultDialog(@NotNull Parcel parcel) {
            this(parcel.readByte() != ((byte) 0));
            Intrinsics.checkNotNullParameter(parcel, "parcel");
        }
    }

    public ModalState() {
    }

    public ModalState(j jVar) {
    }
}
