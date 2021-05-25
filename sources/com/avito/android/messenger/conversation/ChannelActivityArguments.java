package com.avito.android.messenger.conversation;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/messenger/conversation/ChannelActivityArguments;", "Landroid/os/Parcelable;", "<init>", "()V", "Create", "Open", "Lcom/avito/android/messenger/conversation/ChannelActivityArguments$Open;", "Lcom/avito/android/messenger/conversation/ChannelActivityArguments$Create;", "messenger_release"}, k = 1, mv = {1, 4, 2})
public abstract class ChannelActivityArguments implements Parcelable {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/messenger/conversation/ChannelActivityArguments$Create;", "Lcom/avito/android/messenger/conversation/ChannelActivityArguments;", "<init>", "()V", "ByItem", "WithAvito", "Lcom/avito/android/messenger/conversation/ChannelActivityArguments$Create$ByItem;", "Lcom/avito/android/messenger/conversation/ChannelActivityArguments$Create$WithAvito;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class Create extends ChannelActivityArguments {

        @Parcelize
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b#\u0010$J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J2\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u000fJ \u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u001b\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u001d\u001a\u0004\b \u0010\u0004R\u001b\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\u001d\u001a\u0004\b\"\u0010\u0004¨\u0006%"}, d2 = {"Lcom/avito/android/messenger/conversation/ChannelActivityArguments$Create$ByItem;", "Lcom/avito/android/messenger/conversation/ChannelActivityArguments$Create;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "itemId", "messageDraft", "source", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/messenger/conversation/ChannelActivityArguments$Create$ByItem;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "c", "Ljava/lang/String;", "getSource", AuthSource.SEND_ABUSE, "getItemId", AuthSource.BOOKING_ORDER, "getMessageDraft", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class ByItem extends Create {
            public static final Parcelable.Creator<ByItem> CREATOR = new Creator();
            @NotNull
            public final String a;
            @Nullable
            public final String b;
            @Nullable
            public final String c;

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<ByItem> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final ByItem createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    return new ByItem(parcel.readString(), parcel.readString(), parcel.readString());
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final ByItem[] newArray(int i) {
                    return new ByItem[i];
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public ByItem(@NotNull String str, @Nullable String str2, @Nullable String str3) {
                super(null);
                Intrinsics.checkNotNullParameter(str, "itemId");
                this.a = str;
                this.b = str2;
                this.c = str3;
            }

            public static /* synthetic */ ByItem copy$default(ByItem byItem, String str, String str2, String str3, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = byItem.a;
                }
                if ((i & 2) != 0) {
                    str2 = byItem.b;
                }
                if ((i & 4) != 0) {
                    str3 = byItem.c;
                }
                return byItem.copy(str, str2, str3);
            }

            @NotNull
            public final String component1() {
                return this.a;
            }

            @Nullable
            public final String component2() {
                return this.b;
            }

            @Nullable
            public final String component3() {
                return this.c;
            }

            @NotNull
            public final ByItem copy(@NotNull String str, @Nullable String str2, @Nullable String str3) {
                Intrinsics.checkNotNullParameter(str, "itemId");
                return new ByItem(str, str2, str3);
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
                if (!(obj instanceof ByItem)) {
                    return false;
                }
                ByItem byItem = (ByItem) obj;
                return Intrinsics.areEqual(this.a, byItem.a) && Intrinsics.areEqual(this.b, byItem.b) && Intrinsics.areEqual(this.c, byItem.c);
            }

            @NotNull
            public final String getItemId() {
                return this.a;
            }

            @Nullable
            public final String getMessageDraft() {
                return this.b;
            }

            @Nullable
            public final String getSource() {
                return this.c;
            }

            @Override // java.lang.Object
            public int hashCode() {
                String str = this.a;
                int i = 0;
                int hashCode = (str != null ? str.hashCode() : 0) * 31;
                String str2 = this.b;
                int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
                String str3 = this.c;
                if (str3 != null) {
                    i = str3.hashCode();
                }
                return hashCode2 + i;
            }

            @Override // java.lang.Object
            @NotNull
            public String toString() {
                StringBuilder L = a.L("ByItem(itemId=");
                L.append(this.a);
                L.append(", messageDraft=");
                L.append(this.b);
                L.append(", source=");
                return a.t(L, this.c, ")");
            }

            @Override // android.os.Parcelable
            public void writeToParcel(@NotNull Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.writeString(this.a);
                parcel.writeString(this.b);
                parcel.writeString(this.c);
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ ByItem(String str, String str2, String str3, int i, j jVar) {
                this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
            }
        }

        @Parcelize
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0011\u0010\u000bJ \u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004¨\u0006\u001d"}, d2 = {"Lcom/avito/android/messenger/conversation/ChannelActivityArguments$Create$WithAvito;", "Lcom/avito/android/messenger/conversation/ChannelActivityArguments$Create;", "", "component1", "()Ljava/lang/String;", "source", "copy", "(Ljava/lang/String;)Lcom/avito/android/messenger/conversation/ChannelActivityArguments$Create$WithAvito;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getSource", "<init>", "(Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class WithAvito extends Create {
            public static final Parcelable.Creator<WithAvito> CREATOR = new Creator();
            @Nullable
            public final String a;

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<WithAvito> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final WithAvito createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    return new WithAvito(parcel.readString());
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final WithAvito[] newArray(int i) {
                    return new WithAvito[i];
                }
            }

            public WithAvito() {
                this(null, 1, null);
            }

            public WithAvito(@Nullable String str) {
                super(null);
                this.a = str;
            }

            public static /* synthetic */ WithAvito copy$default(WithAvito withAvito, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = withAvito.a;
                }
                return withAvito.copy(str);
            }

            @Nullable
            public final String component1() {
                return this.a;
            }

            @NotNull
            public final WithAvito copy(@Nullable String str) {
                return new WithAvito(str);
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Override // java.lang.Object
            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof WithAvito) && Intrinsics.areEqual(this.a, ((WithAvito) obj).a);
                }
                return true;
            }

            @Nullable
            public final String getSource() {
                return this.a;
            }

            @Override // java.lang.Object
            public int hashCode() {
                String str = this.a;
                if (str != null) {
                    return str.hashCode();
                }
                return 0;
            }

            @Override // java.lang.Object
            @NotNull
            public String toString() {
                return a.t(a.L("WithAvito(source="), this.a, ")");
            }

            @Override // android.os.Parcelable
            public void writeToParcel(@NotNull Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.writeString(this.a);
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ WithAvito(String str, int i, j jVar) {
                this((i & 1) != 0 ? null : str);
            }
        }

        public Create() {
            super(null);
        }

        public Create(j jVar) {
            super(null);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0012\b\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\n¢\u0006\u0004\b/\u00100J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJH\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0011\u001a\u00020\nHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004J\u0010\u0010\u0015\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0016J \u0010 \u001a\u00020\u001f2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b \u0010!R\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\u0007R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\u0004R\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010&\u001a\u0004\b)\u0010\u0004R\u0019\u0010\u0011\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010\fR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010&\u001a\u0004\b.\u0010\u0004¨\u00061"}, d2 = {"Lcom/avito/android/messenger/conversation/ChannelActivityArguments$Open;", "Lcom/avito/android/messenger/conversation/ChannelActivityArguments;", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/lang/Integer;", "component3", "component4", "", "component5", "()Z", "channelId", "numberInList", "messageId", "searchQuery", "backWorksAsUp", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Z)Lcom/avito/android/messenger/conversation/ChannelActivityArguments$Open;", "toString", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.BOOKING_ORDER, "Ljava/lang/Integer;", "getNumberInList", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getChannelId", "d", "getSearchQuery", "e", "Z", "getBackWorksAsUp", "c", "getMessageId", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Z)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Open extends ChannelActivityArguments {
        public static final Parcelable.Creator<Open> CREATOR = new Creator();
        @NotNull
        public final String a;
        @Nullable
        public final Integer b;
        @Nullable
        public final String c;
        @Nullable
        public final String d;
        public final boolean e;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Open> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Open createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Open(parcel.readString(), parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null, parcel.readString(), parcel.readString(), parcel.readInt() != 0);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Open[] newArray(int i) {
                return new Open[i];
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Open(String str, Integer num, String str2, String str3, boolean z, int i, j jVar) {
            this(str, num, str2, str3, (i & 16) != 0 ? false : z);
        }

        public static /* synthetic */ Open copy$default(Open open, String str, Integer num, String str2, String str3, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = open.a;
            }
            if ((i & 2) != 0) {
                num = open.b;
            }
            if ((i & 4) != 0) {
                str2 = open.c;
            }
            if ((i & 8) != 0) {
                str3 = open.d;
            }
            if ((i & 16) != 0) {
                z = open.e;
            }
            return open.copy(str, num, str2, str3, z);
        }

        @NotNull
        public final String component1() {
            return this.a;
        }

        @Nullable
        public final Integer component2() {
            return this.b;
        }

        @Nullable
        public final String component3() {
            return this.c;
        }

        @Nullable
        public final String component4() {
            return this.d;
        }

        public final boolean component5() {
            return this.e;
        }

        @NotNull
        public final Open copy(@NotNull String str, @Nullable Integer num, @Nullable String str2, @Nullable String str3, boolean z) {
            Intrinsics.checkNotNullParameter(str, "channelId");
            return new Open(str, num, str2, str3, z);
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
            if (!(obj instanceof Open)) {
                return false;
            }
            Open open = (Open) obj;
            return Intrinsics.areEqual(this.a, open.a) && Intrinsics.areEqual(this.b, open.b) && Intrinsics.areEqual(this.c, open.c) && Intrinsics.areEqual(this.d, open.d) && this.e == open.e;
        }

        public final boolean getBackWorksAsUp() {
            return this.e;
        }

        @NotNull
        public final String getChannelId() {
            return this.a;
        }

        @Nullable
        public final String getMessageId() {
            return this.c;
        }

        @Nullable
        public final Integer getNumberInList() {
            return this.b;
        }

        @Nullable
        public final String getSearchQuery() {
            return this.d;
        }

        @Override // java.lang.Object
        public int hashCode() {
            String str = this.a;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            Integer num = this.b;
            int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
            String str2 = this.c;
            int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.d;
            if (str3 != null) {
                i = str3.hashCode();
            }
            int i2 = (hashCode3 + i) * 31;
            boolean z = this.e;
            if (z) {
                z = true;
            }
            int i3 = z ? 1 : 0;
            int i4 = z ? 1 : 0;
            int i5 = z ? 1 : 0;
            return i2 + i3;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("Open(channelId=");
            L.append(this.a);
            L.append(", numberInList=");
            L.append(this.b);
            L.append(", messageId=");
            L.append(this.c);
            L.append(", searchQuery=");
            L.append(this.d);
            L.append(", backWorksAsUp=");
            return a.B(L, this.e, ")");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            int i2;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.a);
            Integer num = this.b;
            if (num != null) {
                parcel.writeInt(1);
                i2 = num.intValue();
            } else {
                i2 = 0;
            }
            parcel.writeInt(i2);
            parcel.writeString(this.c);
            parcel.writeString(this.d);
            parcel.writeInt(this.e ? 1 : 0);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Open(@NotNull String str, @Nullable Integer num, @Nullable String str2, @Nullable String str3, boolean z) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "channelId");
            this.a = str;
            this.b = num;
            this.c = str2;
            this.d = str3;
            this.e = z;
        }
    }

    public ChannelActivityArguments() {
    }

    public ChannelActivityArguments(j jVar) {
    }
}
