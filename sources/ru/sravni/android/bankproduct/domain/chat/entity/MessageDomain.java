package ru.sravni.android.bankproduct.domain.chat.entity;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.tariff.tariff_package_info.viewmodel.TariffPackageInfoConverterKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\b\b\u0018\u00002\u00020\u0001:\u0001(BC\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b&\u0010'J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004JL\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u001b\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004R\u001b\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\bR\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\u0004R\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010\u001b\u001a\u0004\b#\u0010\u0004R\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010\u001b\u001a\u0004\b%\u0010\u0004¨\u0006)"}, d2 = {"Lru/sravni/android/bankproduct/domain/chat/entity/MessageDomain;", "", "", "component1", "()Ljava/lang/String;", "component2", "Lru/sravni/android/bankproduct/domain/chat/entity/MessageDomain$HeaderInfoLogo;", "component3", "()Lru/sravni/android/bankproduct/domain/chat/entity/MessageDomain$HeaderInfoLogo;", "component4", "component5", "name", TariffPackageInfoConverterKt.HEADER_STRING_ID, "headerInfoLogo", "title", "message", "copy", "(Ljava/lang/String;Ljava/lang/String;Lru/sravni/android/bankproduct/domain/chat/entity/MessageDomain$HeaderInfoLogo;Ljava/lang/String;Ljava/lang/String;)Lru/sravni/android/bankproduct/domain/chat/entity/MessageDomain;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getHeader", "c", "Lru/sravni/android/bankproduct/domain/chat/entity/MessageDomain$HeaderInfoLogo;", "getHeaderInfoLogo", "d", "getTitle", AuthSource.SEND_ABUSE, "getName", "e", "getMessage", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lru/sravni/android/bankproduct/domain/chat/entity/MessageDomain$HeaderInfoLogo;Ljava/lang/String;Ljava/lang/String;)V", "HeaderInfoLogo", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class MessageDomain {
    @Nullable
    public final String a;
    @Nullable
    public final String b;
    @Nullable
    public final HeaderInfoLogo c;
    @Nullable
    public final String d;
    @Nullable
    public final String e;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u000f\b\b\u0018\u00002\u00020\u0001B/\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b \u0010!J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J<\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0007J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\u000b\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007R\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0017\u001a\u0004\b\u001a\u0010\u0007R\u001b\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u001b\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001c\u001a\u0004\b\u001f\u0010\u0004¨\u0006\""}, d2 = {"Lru/sravni/android/bankproduct/domain/chat/entity/MessageDomain$HeaderInfoLogo;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()I", "component3", "component4", "iconTitle", "fontColor", "backgroundColor", "bankLogoUrlSVG", "copy", "(Ljava/lang/String;IILjava/lang/String;)Lru/sravni/android/bankproduct/domain/chat/entity/MessageDomain$HeaderInfoLogo;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "I", "getFontColor", "c", "getBackgroundColor", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getIconTitle", "d", "getBankLogoUrlSVG", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
    public static final class HeaderInfoLogo {
        @Nullable
        public final String a;
        public final int b;
        public final int c;
        @Nullable
        public final String d;

        public HeaderInfoLogo(@Nullable String str, int i, int i2, @Nullable String str2) {
            this.a = str;
            this.b = i;
            this.c = i2;
            this.d = str2;
        }

        public static /* synthetic */ HeaderInfoLogo copy$default(HeaderInfoLogo headerInfoLogo, String str, int i, int i2, String str2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = headerInfoLogo.a;
            }
            if ((i3 & 2) != 0) {
                i = headerInfoLogo.b;
            }
            if ((i3 & 4) != 0) {
                i2 = headerInfoLogo.c;
            }
            if ((i3 & 8) != 0) {
                str2 = headerInfoLogo.d;
            }
            return headerInfoLogo.copy(str, i, i2, str2);
        }

        @Nullable
        public final String component1() {
            return this.a;
        }

        public final int component2() {
            return this.b;
        }

        public final int component3() {
            return this.c;
        }

        @Nullable
        public final String component4() {
            return this.d;
        }

        @NotNull
        public final HeaderInfoLogo copy(@Nullable String str, int i, int i2, @Nullable String str2) {
            return new HeaderInfoLogo(str, i, i2, str2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof HeaderInfoLogo)) {
                return false;
            }
            HeaderInfoLogo headerInfoLogo = (HeaderInfoLogo) obj;
            return Intrinsics.areEqual(this.a, headerInfoLogo.a) && this.b == headerInfoLogo.b && this.c == headerInfoLogo.c && Intrinsics.areEqual(this.d, headerInfoLogo.d);
        }

        public final int getBackgroundColor() {
            return this.c;
        }

        @Nullable
        public final String getBankLogoUrlSVG() {
            return this.d;
        }

        public final int getFontColor() {
            return this.b;
        }

        @Nullable
        public final String getIconTitle() {
            return this.a;
        }

        public int hashCode() {
            String str = this.a;
            int i = 0;
            int hashCode = (((((str != null ? str.hashCode() : 0) * 31) + this.b) * 31) + this.c) * 31;
            String str2 = this.d;
            if (str2 != null) {
                i = str2.hashCode();
            }
            return hashCode + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("HeaderInfoLogo(iconTitle=");
            L.append(this.a);
            L.append(", fontColor=");
            L.append(this.b);
            L.append(", backgroundColor=");
            L.append(this.c);
            L.append(", bankLogoUrlSVG=");
            return a.t(L, this.d, ")");
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ HeaderInfoLogo(String str, int i, int i2, String str2, int i3, j jVar) {
            this((i3 & 1) != 0 ? null : str, i, i2, (i3 & 8) != 0 ? null : str2);
        }
    }

    public MessageDomain() {
        this(null, null, null, null, null, 31, null);
    }

    public MessageDomain(@Nullable String str, @Nullable String str2, @Nullable HeaderInfoLogo headerInfoLogo, @Nullable String str3, @Nullable String str4) {
        this.a = str;
        this.b = str2;
        this.c = headerInfoLogo;
        this.d = str3;
        this.e = str4;
    }

    public static /* synthetic */ MessageDomain copy$default(MessageDomain messageDomain, String str, String str2, HeaderInfoLogo headerInfoLogo, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = messageDomain.a;
        }
        if ((i & 2) != 0) {
            str2 = messageDomain.b;
        }
        if ((i & 4) != 0) {
            headerInfoLogo = messageDomain.c;
        }
        if ((i & 8) != 0) {
            str3 = messageDomain.d;
        }
        if ((i & 16) != 0) {
            str4 = messageDomain.e;
        }
        return messageDomain.copy(str, str2, headerInfoLogo, str3, str4);
    }

    @Nullable
    public final String component1() {
        return this.a;
    }

    @Nullable
    public final String component2() {
        return this.b;
    }

    @Nullable
    public final HeaderInfoLogo component3() {
        return this.c;
    }

    @Nullable
    public final String component4() {
        return this.d;
    }

    @Nullable
    public final String component5() {
        return this.e;
    }

    @NotNull
    public final MessageDomain copy(@Nullable String str, @Nullable String str2, @Nullable HeaderInfoLogo headerInfoLogo, @Nullable String str3, @Nullable String str4) {
        return new MessageDomain(str, str2, headerInfoLogo, str3, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MessageDomain)) {
            return false;
        }
        MessageDomain messageDomain = (MessageDomain) obj;
        return Intrinsics.areEqual(this.a, messageDomain.a) && Intrinsics.areEqual(this.b, messageDomain.b) && Intrinsics.areEqual(this.c, messageDomain.c) && Intrinsics.areEqual(this.d, messageDomain.d) && Intrinsics.areEqual(this.e, messageDomain.e);
    }

    @Nullable
    public final String getHeader() {
        return this.b;
    }

    @Nullable
    public final HeaderInfoLogo getHeaderInfoLogo() {
        return this.c;
    }

    @Nullable
    public final String getMessage() {
        return this.e;
    }

    @Nullable
    public final String getName() {
        return this.a;
    }

    @Nullable
    public final String getTitle() {
        return this.d;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        HeaderInfoLogo headerInfoLogo = this.c;
        int hashCode3 = (hashCode2 + (headerInfoLogo != null ? headerInfoLogo.hashCode() : 0)) * 31;
        String str3 = this.d;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.e;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode4 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("MessageDomain(name=");
        L.append(this.a);
        L.append(", header=");
        L.append(this.b);
        L.append(", headerInfoLogo=");
        L.append(this.c);
        L.append(", title=");
        L.append(this.d);
        L.append(", message=");
        return a.t(L, this.e, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MessageDomain(String str, String str2, HeaderInfoLogo headerInfoLogo, String str3, String str4, int i, j jVar) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : headerInfoLogo, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4);
    }
}
