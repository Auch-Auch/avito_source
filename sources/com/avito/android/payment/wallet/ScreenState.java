package com.avito.android.payment.wallet;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.payment.wallet.WalletPage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u0004\u0005\u0006\u0007\b\tB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0006\n\u000b\f\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/payment/wallet/ScreenState;", "Landroid/os/Parcelable;", "<init>", "()V", "Content", "InitialError", "InitialLoading", "RefreshingContent", "UpdateError", "UpdateLoading", "Lcom/avito/android/payment/wallet/ScreenState$Content;", "Lcom/avito/android/payment/wallet/ScreenState$RefreshingContent;", "Lcom/avito/android/payment/wallet/ScreenState$InitialLoading;", "Lcom/avito/android/payment/wallet/ScreenState$InitialError;", "Lcom/avito/android/payment/wallet/ScreenState$UpdateLoading;", "Lcom/avito/android/payment/wallet/ScreenState$UpdateError;", "payment_release"}, k = 1, mv = {1, 4, 2})
public abstract class ScreenState implements Parcelable {

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0007J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0007J \u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u0004¨\u0006$"}, d2 = {"Lcom/avito/android/payment/wallet/ScreenState$Content;", "Lcom/avito/android/payment/wallet/ScreenState;", "Lcom/avito/android/remote/model/payment/wallet/WalletPage;", "component1", "()Lcom/avito/android/remote/model/payment/wallet/WalletPage;", "", "component2", "()I", "walletPage", "activeTab", "copy", "(Lcom/avito/android/remote/model/payment/wallet/WalletPage;I)Lcom/avito/android/payment/wallet/ScreenState$Content;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.BOOKING_ORDER, "I", "getActiveTab", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/payment/wallet/WalletPage;", "getWalletPage", "<init>", "(Lcom/avito/android/remote/model/payment/wallet/WalletPage;I)V", "payment_release"}, k = 1, mv = {1, 4, 2})
    public static final class Content extends ScreenState {
        public static final Parcelable.Creator<Content> CREATOR = new Creator();
        @NotNull
        public final WalletPage a;
        public final int b;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Content> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Content createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Content((WalletPage) parcel.readParcelable(Content.class.getClassLoader()), parcel.readInt());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Content[] newArray(int i) {
                return new Content[i];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Content(@NotNull WalletPage walletPage, int i) {
            super(null);
            Intrinsics.checkNotNullParameter(walletPage, "walletPage");
            this.a = walletPage;
            this.b = i;
        }

        public static /* synthetic */ Content copy$default(Content content, WalletPage walletPage, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                walletPage = content.a;
            }
            if ((i2 & 2) != 0) {
                i = content.b;
            }
            return content.copy(walletPage, i);
        }

        @NotNull
        public final WalletPage component1() {
            return this.a;
        }

        public final int component2() {
            return this.b;
        }

        @NotNull
        public final Content copy(@NotNull WalletPage walletPage, int i) {
            Intrinsics.checkNotNullParameter(walletPage, "walletPage");
            return new Content(walletPage, i);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // java.lang.Object
        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Content)) {
                return false;
            }
            Content content = (Content) obj;
            return Intrinsics.areEqual(this.a, content.a) && this.b == content.b;
        }

        public final int getActiveTab() {
            return this.b;
        }

        @NotNull
        public final WalletPage getWalletPage() {
            return this.a;
        }

        @Override // java.lang.Object
        public int hashCode() {
            WalletPage walletPage = this.a;
            return ((walletPage != null ? walletPage.hashCode() : 0) * 31) + this.b;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("Content(walletPage=");
            L.append(this.a);
            L.append(", activeTab=");
            return a.j(L, this.b, ")");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeParcelable(this.a, i);
            parcel.writeInt(this.b);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/payment/wallet/ScreenState$InitialError;", "Lcom/avito/android/payment/wallet/ScreenState;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getErrorMessage", "()Ljava/lang/String;", "errorMessage", "<init>", "(Ljava/lang/String;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
    public static final class InitialError extends ScreenState {
        public static final Parcelable.Creator<InitialError> CREATOR = new Creator();
        @NotNull
        public final String a;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<InitialError> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final InitialError createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new InitialError(parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final InitialError[] newArray(int i) {
                return new InitialError[i];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public InitialError(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "errorMessage");
            this.a = str;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        public final String getErrorMessage() {
            return this.a;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.a);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/payment/wallet/ScreenState$InitialLoading;", "Lcom/avito/android/payment/wallet/ScreenState;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "<init>", "()V", "payment_release"}, k = 1, mv = {1, 4, 2})
    public static final class InitialLoading extends ScreenState {
        public static final Parcelable.Creator<InitialLoading> CREATOR = new Creator();

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<InitialLoading> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final InitialLoading createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                if (parcel.readInt() != 0) {
                    return new InitialLoading();
                }
                return null;
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final InitialLoading[] newArray(int i) {
                return new InitialLoading[i];
            }
        }

        public InitialLoading() {
            super(null);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeInt(1);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0007J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0007J \u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u0007¨\u0006$"}, d2 = {"Lcom/avito/android/payment/wallet/ScreenState$RefreshingContent;", "Lcom/avito/android/payment/wallet/ScreenState;", "Lcom/avito/android/remote/model/payment/wallet/WalletPage;", "component1", "()Lcom/avito/android/remote/model/payment/wallet/WalletPage;", "", "component2", "()I", "walletPage", "activeTab", "copy", "(Lcom/avito/android/remote/model/payment/wallet/WalletPage;I)Lcom/avito/android/payment/wallet/ScreenState$RefreshingContent;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/payment/wallet/WalletPage;", "getWalletPage", AuthSource.BOOKING_ORDER, "I", "getActiveTab", "<init>", "(Lcom/avito/android/remote/model/payment/wallet/WalletPage;I)V", "payment_release"}, k = 1, mv = {1, 4, 2})
    public static final class RefreshingContent extends ScreenState {
        public static final Parcelable.Creator<RefreshingContent> CREATOR = new Creator();
        @NotNull
        public final WalletPage a;
        public final int b;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<RefreshingContent> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final RefreshingContent createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new RefreshingContent((WalletPage) parcel.readParcelable(RefreshingContent.class.getClassLoader()), parcel.readInt());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final RefreshingContent[] newArray(int i) {
                return new RefreshingContent[i];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public RefreshingContent(@NotNull WalletPage walletPage, int i) {
            super(null);
            Intrinsics.checkNotNullParameter(walletPage, "walletPage");
            this.a = walletPage;
            this.b = i;
        }

        public static /* synthetic */ RefreshingContent copy$default(RefreshingContent refreshingContent, WalletPage walletPage, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                walletPage = refreshingContent.a;
            }
            if ((i2 & 2) != 0) {
                i = refreshingContent.b;
            }
            return refreshingContent.copy(walletPage, i);
        }

        @NotNull
        public final WalletPage component1() {
            return this.a;
        }

        public final int component2() {
            return this.b;
        }

        @NotNull
        public final RefreshingContent copy(@NotNull WalletPage walletPage, int i) {
            Intrinsics.checkNotNullParameter(walletPage, "walletPage");
            return new RefreshingContent(walletPage, i);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // java.lang.Object
        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RefreshingContent)) {
                return false;
            }
            RefreshingContent refreshingContent = (RefreshingContent) obj;
            return Intrinsics.areEqual(this.a, refreshingContent.a) && this.b == refreshingContent.b;
        }

        public final int getActiveTab() {
            return this.b;
        }

        @NotNull
        public final WalletPage getWalletPage() {
            return this.a;
        }

        @Override // java.lang.Object
        public int hashCode() {
            WalletPage walletPage = this.a;
            return ((walletPage != null ? walletPage.hashCode() : 0) * 31) + this.b;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("RefreshingContent(walletPage=");
            L.append(this.a);
            L.append(", activeTab=");
            return a.j(L, this.b, ")");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeParcelable(this.a, i);
            parcel.writeInt(this.b);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/payment/wallet/ScreenState$UpdateError;", "Lcom/avito/android/payment/wallet/ScreenState;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getErrorMessage", "()Ljava/lang/String;", "errorMessage", "<init>", "(Ljava/lang/String;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
    public static final class UpdateError extends ScreenState {
        public static final Parcelable.Creator<UpdateError> CREATOR = new Creator();
        @NotNull
        public final String a;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<UpdateError> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final UpdateError createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new UpdateError(parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final UpdateError[] newArray(int i) {
                return new UpdateError[i];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public UpdateError(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "errorMessage");
            this.a = str;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        public final String getErrorMessage() {
            return this.a;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.a);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/payment/wallet/ScreenState$UpdateLoading;", "Lcom/avito/android/payment/wallet/ScreenState;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "<init>", "()V", "payment_release"}, k = 1, mv = {1, 4, 2})
    public static final class UpdateLoading extends ScreenState {
        public static final Parcelable.Creator<UpdateLoading> CREATOR = new Creator();

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<UpdateLoading> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final UpdateLoading createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                if (parcel.readInt() != 0) {
                    return new UpdateLoading();
                }
                return null;
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final UpdateLoading[] newArray(int i) {
                return new UpdateLoading[i];
            }
        }

        public UpdateLoading() {
            super(null);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeInt(1);
        }
    }

    public ScreenState() {
    }

    public ScreenState(j jVar) {
    }
}
