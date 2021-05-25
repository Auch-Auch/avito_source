package com.sumsub.sns.core.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import java.io.Serializable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00042\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0007\b¨\u0006\t"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSLivenessResult;", "Landroid/os/Parcelable;", "<init>", "()V", "Companion", "FaceAuth", "FaceDetection", "Lcom/sumsub/sns/core/data/model/SNSLivenessResult$FaceDetection;", "Lcom/sumsub/sns/core/data/model/SNSLivenessResult$FaceAuth;", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public abstract class SNSLivenessResult implements Parcelable {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String EXTRA_RESULT = "EXTRA_RESULT";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSLivenessResult$Companion;", "", "", "EXTRA_RESULT", "Ljava/lang/String;", "<init>", "()V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 !2\u00020\u00012\u00020\u0002:\u0001!B'\b\u0016\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0018\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u001e\u0010\u001fB\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u001e\u0010 J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\u0011\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u00188\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\""}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSLivenessResult$FaceAuth;", "Lcom/sumsub/sns/core/data/model/SNSLivenessResult;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "Lcom/sumsub/sns/core/data/model/SNSLivenessReason;", AuthSource.BOOKING_ORDER, "Lcom/sumsub/sns/core/data/model/SNSLivenessReason;", "getReason", "()Lcom/sumsub/sns/core/data/model/SNSLivenessReason;", "reason", "Lcom/sumsub/sns/core/data/model/AnswerType;", "c", "Lcom/sumsub/sns/core/data/model/AnswerType;", "getAnswer", "()Lcom/sumsub/sns/core/data/model/AnswerType;", "answer", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "id", "<init>", "(Ljava/lang/String;Lcom/sumsub/sns/core/data/model/SNSLivenessReason;Lcom/sumsub/sns/core/data/model/AnswerType;)V", "(Landroid/os/Parcel;)V", "CREATOR", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class FaceAuth extends SNSLivenessResult implements Parcelable {
        @NotNull
        public static final CREATOR CREATOR = new CREATOR(null);
        @Nullable
        public final String a;
        @NotNull
        public final SNSLivenessReason b;
        @Nullable
        public final AnswerType c;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSLivenessResult$FaceAuth$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/sumsub/sns/core/data/model/SNSLivenessResult$FaceAuth;", "Landroid/os/Parcel;", "parcel", "createFromParcel", "(Landroid/os/Parcel;)Lcom/sumsub/sns/core/data/model/SNSLivenessResult$FaceAuth;", "", "size", "", "newArray", "(I)[Lcom/sumsub/sns/core/data/model/SNSLivenessResult$FaceAuth;", "<init>", "()V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
        public static final class CREATOR implements Parcelable.Creator<FaceAuth> {
            public CREATOR() {
            }

            public CREATOR(j jVar) {
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public FaceAuth createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new FaceAuth(parcel);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public FaceAuth[] newArray(int i) {
                return new FaceAuth[i];
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ FaceAuth(String str, SNSLivenessReason sNSLivenessReason, AnswerType answerType, int i, j jVar) {
            this(str, sNSLivenessReason, (i & 4) != 0 ? null : answerType);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Nullable
        public final AnswerType getAnswer() {
            return this.c;
        }

        @Nullable
        public final String getId() {
            return this.a;
        }

        @NotNull
        public final SNSLivenessReason getReason() {
            return this.b;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.a);
            parcel.writeSerializable(this.b);
            AnswerType answerType = this.c;
            parcel.writeString(answerType != null ? answerType.name() : null);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FaceAuth(@Nullable String str, @NotNull SNSLivenessReason sNSLivenessReason, @Nullable AnswerType answerType) {
            super(null);
            Intrinsics.checkNotNullParameter(sNSLivenessReason, "reason");
            this.a = str;
            this.b = sNSLivenessReason;
            this.c = answerType;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FaceAuth(@NotNull Parcel parcel) {
            super(null);
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            AnswerType answerType = null;
            this.a = parcel.readString();
            Serializable readSerializable = parcel.readSerializable();
            Objects.requireNonNull(readSerializable, "null cannot be cast to non-null type com.sumsub.sns.core.data.model.SNSLivenessReason");
            this.b = (SNSLivenessReason) readSerializable;
            String readString = parcel.readString();
            this.c = readString != null ? AnswerType.valueOf(readString) : answerType;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00152\u00020\u00012\u00020\u0002:\u0001\u0015B\u0011\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\f¢\u0006\u0004\b\u0012\u0010\u0013B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0012\u0010\u0014J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\u0011\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSLivenessResult$FaceDetection;", "Lcom/sumsub/sns/core/data/model/SNSLivenessResult;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "Lcom/sumsub/sns/core/data/model/SNSLivenessReason;", AuthSource.SEND_ABUSE, "Lcom/sumsub/sns/core/data/model/SNSLivenessReason;", "getReason", "()Lcom/sumsub/sns/core/data/model/SNSLivenessReason;", "reason", "<init>", "(Lcom/sumsub/sns/core/data/model/SNSLivenessReason;)V", "(Landroid/os/Parcel;)V", "CREATOR", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class FaceDetection extends SNSLivenessResult implements Parcelable {
        @NotNull
        public static final CREATOR CREATOR = new CREATOR(null);
        @NotNull
        public final SNSLivenessReason a;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSLivenessResult$FaceDetection$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/sumsub/sns/core/data/model/SNSLivenessResult$FaceDetection;", "Landroid/os/Parcel;", "parcel", "createFromParcel", "(Landroid/os/Parcel;)Lcom/sumsub/sns/core/data/model/SNSLivenessResult$FaceDetection;", "", "size", "", "newArray", "(I)[Lcom/sumsub/sns/core/data/model/SNSLivenessResult$FaceDetection;", "<init>", "()V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
        public static final class CREATOR implements Parcelable.Creator<FaceDetection> {
            public CREATOR() {
            }

            public CREATOR(j jVar) {
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public FaceDetection createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new FaceDetection(parcel);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public FaceDetection[] newArray(int i) {
                return new FaceDetection[i];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FaceDetection(@NotNull SNSLivenessReason sNSLivenessReason) {
            super(null);
            Intrinsics.checkNotNullParameter(sNSLivenessReason, "reason");
            this.a = sNSLivenessReason;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        public final SNSLivenessReason getReason() {
            return this.a;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeSerializable(this.a);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FaceDetection(@NotNull Parcel parcel) {
            super(null);
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            Serializable readSerializable = parcel.readSerializable();
            Objects.requireNonNull(readSerializable, "null cannot be cast to non-null type com.sumsub.sns.core.data.model.SNSLivenessReason");
            this.a = (SNSLivenessReason) readSerializable;
        }
    }

    public SNSLivenessResult() {
    }

    public SNSLivenessResult(j jVar) {
    }
}
