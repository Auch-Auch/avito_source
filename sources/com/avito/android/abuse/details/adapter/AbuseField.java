package com.avito.android.abuse.details.adapter;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Parcels;
import com.avito.konveyor.blueprint.Item;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u00012\u00020\u0002:\u0007\f\r\u000e\u000f\u0010\u0011\u0012J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u001c\u0010\u000b\u001a\u00020\u00068\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\u0001\u0005\u0013\u0014\u0015\u0016\u0017¨\u0006\u0018"}, d2 = {"Lcom/avito/android/abuse/details/adapter/AbuseField;", "Landroid/os/Parcelable;", "Lcom/avito/konveyor/blueprint/Item;", "", "describeContents", "()I", "", AuthSource.SEND_ABUSE, "J", "getId", "()J", "id", "Button", "Comment", "Emotion", "ErrorLabel", "PrimaryButton", "SecondaryButton", "SendingSuccess", "Lcom/avito/android/abuse/details/adapter/AbuseField$Comment;", "Lcom/avito/android/abuse/details/adapter/AbuseField$Emotion;", "Lcom/avito/android/abuse/details/adapter/AbuseField$SendingSuccess;", "Lcom/avito/android/abuse/details/adapter/AbuseField$ErrorLabel;", "Lcom/avito/android/abuse/details/adapter/AbuseField$Button;", "abuse_release"}, k = 1, mv = {1, 4, 2})
public abstract class AbuseField implements Parcelable, Item {
    public final long a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/abuse/details/adapter/AbuseField$Button;", "Lcom/avito/android/abuse/details/adapter/AbuseField;", "", "id", "<init>", "(J)V", "abuse_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class Button extends AbuseField {
        public Button(long j) {
            super(j, null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B#\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u0013\u001a\u00020\t¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0013\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/avito/android/abuse/details/adapter/AbuseField$Comment;", "Lcom/avito/android/abuse/details/adapter/AbuseField;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "message", "c", "getHint", "hint", "", "id", "<init>", "(JLjava/lang/String;Ljava/lang/String;)V", "Companion", "abuse_release"}, k = 1, mv = {1, 4, 2})
    public static final class Comment extends AbuseField {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<Comment> CREATOR = Parcels.creator(a.a);
        @NotNull
        public static final Companion Companion = new Companion(null);
        @Nullable
        public String b;
        @NotNull
        public final String c;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/abuse/details/adapter/AbuseField$Comment$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/abuse/details/adapter/AbuseField$Comment;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "abuse_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            public Companion() {
            }

            public Companion(j jVar) {
            }
        }

        public static final class a extends Lambda implements Function1<Parcel, Comment> {
            public static final a a = new a();

            public a() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Comment invoke(Parcel parcel) {
                Parcel parcel2 = parcel;
                Intrinsics.checkNotNullParameter(parcel2, "$receiver");
                return new Comment(parcel2.readLong(), parcel2.readString(), a2.b.a.a.a.u2(parcel2, "readString()!!"));
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Comment(long j, String str, String str2, int i, j jVar) {
            this(j, (i & 2) != 0 ? null : str, str2);
        }

        @NotNull
        public final String getHint() {
            return this.c;
        }

        @Nullable
        public final String getMessage() {
            return this.b;
        }

        public final void setMessage(@Nullable String str) {
            this.b = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "dest");
            parcel.writeLong(getId());
            parcel.writeString(this.b);
            parcel.writeString(this.c);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Comment(long j, @Nullable String str, @NotNull String str2) {
            super(j, null);
            Intrinsics.checkNotNullParameter(str2, "hint");
            this.b = str;
            this.c = str2;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB#\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0015\u001a\u00020\u0010¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0019\u0010\u0015\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001b"}, d2 = {"Lcom/avito/android/abuse/details/adapter/AbuseField$Emotion;", "Lcom/avito/android/abuse/details/adapter/AbuseField;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.BOOKING_ORDER, "Ljava/lang/Integer;", "getValue", "()Ljava/lang/Integer;", "setValue", "(Ljava/lang/Integer;)V", "value", "", "c", "Ljava/lang/String;", "getHint", "()Ljava/lang/String;", "hint", "", "id", "<init>", "(JLjava/lang/Integer;Ljava/lang/String;)V", "Companion", "abuse_release"}, k = 1, mv = {1, 4, 2})
    public static final class Emotion extends AbuseField {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<Emotion> CREATOR = Parcels.creator(a.a);
        @NotNull
        public static final Companion Companion = new Companion(null);
        @Nullable
        public Integer b;
        @NotNull
        public final String c;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/abuse/details/adapter/AbuseField$Emotion$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/abuse/details/adapter/AbuseField$Emotion;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "abuse_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            public Companion() {
            }

            public Companion(j jVar) {
            }
        }

        public static final class a extends Lambda implements Function1<Parcel, Emotion> {
            public static final a a = new a();

            public a() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Emotion invoke(Parcel parcel) {
                Parcel parcel2 = parcel;
                Intrinsics.checkNotNullParameter(parcel2, "$receiver");
                long readLong = parcel2.readLong();
                Object readValue = parcel2.readValue(Integer.class.getClassLoader());
                if (!(readValue instanceof Integer)) {
                    readValue = null;
                }
                return new Emotion(readLong, (Integer) readValue, a2.b.a.a.a.u2(parcel2, "readString()!!"));
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Emotion(long j, Integer num, String str, int i, j jVar) {
            this(j, (i & 2) != 0 ? null : num, str);
        }

        @NotNull
        public final String getHint() {
            return this.c;
        }

        @Nullable
        public final Integer getValue() {
            return this.b;
        }

        public final void setValue(@Nullable Integer num) {
            this.b = num;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "dest");
            parcel.writeLong(getId());
            parcel.writeValue(this.b);
            parcel.writeString(this.c);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Emotion(long j, @Nullable Integer num, @NotNull String str) {
            super(j, null);
            Intrinsics.checkNotNullParameter(str, "hint");
            this.b = num;
            this.c = str;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0010\u001a\u00020\t¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/avito/android/abuse/details/adapter/AbuseField$ErrorLabel;", "Lcom/avito/android/abuse/details/adapter/AbuseField;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "message", "", "id", "<init>", "(JLjava/lang/String;)V", "Companion", "abuse_release"}, k = 1, mv = {1, 4, 2})
    public static final class ErrorLabel extends AbuseField {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<ErrorLabel> CREATOR = Parcels.creator(a.a);
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        public String b;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/avito/android/abuse/details/adapter/AbuseField$ErrorLabel$Companion;", "", "", "fieldId", "errorId", "(J)J", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/abuse/details/adapter/AbuseField$ErrorLabel;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "abuse_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            public Companion() {
            }

            public final long errorId(long j) {
                return Long.MAX_VALUE - j;
            }

            public Companion(j jVar) {
            }
        }

        public static final class a extends Lambda implements Function1<Parcel, ErrorLabel> {
            public static final a a = new a();

            public a() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public ErrorLabel invoke(Parcel parcel) {
                Parcel parcel2 = parcel;
                Intrinsics.checkNotNullParameter(parcel2, "$receiver");
                return new ErrorLabel(parcel2.readLong(), a2.b.a.a.a.u2(parcel2, "readString()!!"));
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ErrorLabel(long j, @NotNull String str) {
            super(j, null);
            Intrinsics.checkNotNullParameter(str, "message");
            this.b = str;
        }

        @NotNull
        public final String getMessage() {
            return this.b;
        }

        public final void setMessage(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.b = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "dest");
            parcel.writeLong(getId());
            parcel.writeString(this.b);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u001f\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0014\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001a"}, d2 = {"Lcom/avito/android/abuse/details/adapter/AbuseField$PrimaryButton;", "Lcom/avito/android/abuse/details/adapter/AbuseField$Button;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "c", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", "", "id", "<init>", "(JLjava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;)V", "Companion", "abuse_release"}, k = 1, mv = {1, 4, 2})
    public static final class PrimaryButton extends Button {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<PrimaryButton> CREATOR = Parcels.creator(a.a);
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        public final String b;
        @NotNull
        public final DeepLink c;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/abuse/details/adapter/AbuseField$PrimaryButton$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/abuse/details/adapter/AbuseField$PrimaryButton;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "abuse_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            public Companion() {
            }

            public Companion(j jVar) {
            }
        }

        public static final class a extends Lambda implements Function1<Parcel, PrimaryButton> {
            public static final a a = new a();

            public a() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public PrimaryButton invoke(Parcel parcel) {
                Parcel parcel2 = parcel;
                Intrinsics.checkNotNullParameter(parcel2, "$receiver");
                return new PrimaryButton(parcel2.readLong(), a2.b.a.a.a.u2(parcel2, "readString()!!"), (DeepLink) a2.b.a.a.a.z1(DeepLink.class, parcel2));
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PrimaryButton(long j, @NotNull String str, @NotNull DeepLink deepLink) {
            super(j);
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(deepLink, "deepLink");
            this.b = str;
            this.c = deepLink;
        }

        @NotNull
        public final DeepLink getDeepLink() {
            return this.c;
        }

        @NotNull
        public final String getTitle() {
            return this.b;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "dest");
            parcel.writeLong(getId());
            parcel.writeString(this.b);
            parcel.writeParcelable(this.c, i);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u001f\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\u000f¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0014\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001a"}, d2 = {"Lcom/avito/android/abuse/details/adapter/AbuseField$SecondaryButton;", "Lcom/avito/android/abuse/details/adapter/AbuseField$Button;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", "Lcom/avito/android/deep_linking/links/DeepLink;", "c", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "", "id", "<init>", "(JLjava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;)V", "Companion", "abuse_release"}, k = 1, mv = {1, 4, 2})
    public static final class SecondaryButton extends Button {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<PrimaryButton> CREATOR = Parcels.creator(a.a);
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        public final String b;
        @NotNull
        public final DeepLink c;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/abuse/details/adapter/AbuseField$SecondaryButton$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/abuse/details/adapter/AbuseField$PrimaryButton;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "abuse_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            public Companion() {
            }

            public Companion(j jVar) {
            }
        }

        public static final class a extends Lambda implements Function1<Parcel, PrimaryButton> {
            public static final a a = new a();

            public a() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public PrimaryButton invoke(Parcel parcel) {
                Parcel parcel2 = parcel;
                Intrinsics.checkNotNullParameter(parcel2, "$receiver");
                return new PrimaryButton(parcel2.readLong(), a2.b.a.a.a.u2(parcel2, "readString()!!"), (DeepLink) a2.b.a.a.a.z1(DeepLink.class, parcel2));
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SecondaryButton(long j, @NotNull String str, @NotNull DeepLink deepLink) {
            super(j);
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(deepLink, "deepLink");
            this.b = str;
            this.c = deepLink;
        }

        @NotNull
        public final DeepLink getDeepLink() {
            return this.c;
        }

        @NotNull
        public final String getTitle() {
            return this.b;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "dest");
            parcel.writeLong(getId());
            parcel.writeString(this.b);
            parcel.writeParcelable(this.c, i);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0017\u0012\u0006\u0010\u0014\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\t¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0014\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/avito/android/abuse/details/adapter/AbuseField$SendingSuccess;", "Lcom/avito/android/abuse/details/adapter/AbuseField;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "c", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "message", AuthSource.BOOKING_ORDER, "getTitle", "setTitle", "title", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "Companion", "abuse_release"}, k = 1, mv = {1, 4, 2})
    public static final class SendingSuccess extends AbuseField {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<SendingSuccess> CREATOR = Parcels.creator(a.a);
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        public String b;
        @NotNull
        public String c;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/abuse/details/adapter/AbuseField$SendingSuccess$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/abuse/details/adapter/AbuseField$SendingSuccess;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "abuse_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            public Companion() {
            }

            public Companion(j jVar) {
            }
        }

        public static final class a extends Lambda implements Function1<Parcel, SendingSuccess> {
            public static final a a = new a();

            public a() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public SendingSuccess invoke(Parcel parcel) {
                Parcel parcel2 = parcel;
                Intrinsics.checkNotNullParameter(parcel2, "$receiver");
                return new SendingSuccess(a2.b.a.a.a.u2(parcel2, "readString()!!"), a2.b.a.a.a.u2(parcel2, "readString()!!"));
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SendingSuccess(@NotNull String str, @NotNull String str2) {
            super(Long.MAX_VALUE, null);
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(str2, "message");
            this.b = str;
            this.c = str2;
        }

        @NotNull
        public final String getMessage() {
            return this.c;
        }

        @NotNull
        public final String getTitle() {
            return this.b;
        }

        public final void setMessage(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.c = str;
        }

        public final void setTitle(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.b = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "dest");
            parcel.writeString(this.b);
            parcel.writeString(this.c);
        }
    }

    public AbuseField(long j, j jVar) {
        this.a = j;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.avito.konveyor.blueprint.Item
    public long getId() {
        return this.a;
    }
}
