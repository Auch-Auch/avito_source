package com.avito.android.messenger.conversation;

import a2.b.a.a.a;
import a2.g.r.g;
import com.avito.android.component.message_status.MessageDeliveryStatus;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.ServiceTypeKt;
import com.avito.android.remote.model.Sort;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import com.avito.android.remote.model.messenger.message.MessageBody;
import com.avito.conveyor_item.Item;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongycastle.asn1.cmc.BodyPartID;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0007\u0004\u0005\u0006\u0007\b\t\nB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0006\u000b\f\r\u000e\u000f\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/messenger/conversation/ChannelItem;", "Lcom/avito/conveyor_item/Item;", "<init>", "()V", "GroupFlags", "Message", "PaginationError", "PaginationInProgress", "SpamActions", "TypingIndicator", "UnreadMessagesDivider", "Lcom/avito/android/messenger/conversation/ChannelItem$Message;", "Lcom/avito/android/messenger/conversation/ChannelItem$UnreadMessagesDivider;", "Lcom/avito/android/messenger/conversation/ChannelItem$PaginationError;", "Lcom/avito/android/messenger/conversation/ChannelItem$PaginationInProgress;", "Lcom/avito/android/messenger/conversation/ChannelItem$TypingIndicator;", "Lcom/avito/android/messenger/conversation/ChannelItem$SpamActions;", "messenger_release"}, k = 1, mv = {1, 4, 2})
public abstract class ChannelItem implements Item {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\b\b\u0018\u00002\u00020\u0001BW\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b(\u0010)J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J`\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001d\u001a\u00020\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u0019\u0010\u0012\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u0012\u0010\u0004R\u0019\u0010\u0011\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010 \u001a\u0004\b\u0011\u0010\u0004R\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010 \u001a\u0004\b\u000f\u0010\u0004R\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010 \u001a\u0004\b\u0010\u0010\u0004R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010 \u001a\u0004\b\r\u0010\u0004R\u0019\u0010\u0013\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010 \u001a\u0004\b\u0013\u0010\u0004R\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010 \u001a\u0004\b\u000e\u0010\u0004R\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010 \u001a\u0004\b\f\u0010\u0004¨\u0006*"}, d2 = {"Lcom/avito/android/messenger/conversation/ChannelItem$GroupFlags;", "", "", "component1", "()Z", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "isAtUserGroupStart", "isAtUserGroupEnd", "isAtDateGroupStart", "isAtDateGroupEnd", "isAfterSystemMessage", "isBeforeSystemMessage", "isFirstNewMessage", "isLastOldMessage", "copy", "(ZZZZZZZZ)Lcom/avito/android/messenger/conversation/ChannelItem$GroupFlags;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", g.a, "Z", "f", "d", "e", AuthSource.BOOKING_ORDER, "h", "c", AuthSource.SEND_ABUSE, "<init>", "(ZZZZZZZZ)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class GroupFlags {
        public final boolean a;
        public final boolean b;
        public final boolean c;
        public final boolean d;
        public final boolean e;
        public final boolean f;
        public final boolean g;
        public final boolean h;

        public GroupFlags() {
            this(false, false, false, false, false, false, false, false, 255, null);
        }

        public GroupFlags(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z7, boolean z8, boolean z9) {
            this.a = z;
            this.b = z2;
            this.c = z3;
            this.d = z4;
            this.e = z5;
            this.f = z7;
            this.g = z8;
            this.h = z9;
        }

        public static /* synthetic */ GroupFlags copy$default(GroupFlags groupFlags, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z7, boolean z8, boolean z9, int i, Object obj) {
            return groupFlags.copy((i & 1) != 0 ? groupFlags.a : z, (i & 2) != 0 ? groupFlags.b : z2, (i & 4) != 0 ? groupFlags.c : z3, (i & 8) != 0 ? groupFlags.d : z4, (i & 16) != 0 ? groupFlags.e : z5, (i & 32) != 0 ? groupFlags.f : z7, (i & 64) != 0 ? groupFlags.g : z8, (i & 128) != 0 ? groupFlags.h : z9);
        }

        public final boolean component1() {
            return this.a;
        }

        public final boolean component2() {
            return this.b;
        }

        public final boolean component3() {
            return this.c;
        }

        public final boolean component4() {
            return this.d;
        }

        public final boolean component5() {
            return this.e;
        }

        public final boolean component6() {
            return this.f;
        }

        public final boolean component7() {
            return this.g;
        }

        public final boolean component8() {
            return this.h;
        }

        @NotNull
        public final GroupFlags copy(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z7, boolean z8, boolean z9) {
            return new GroupFlags(z, z2, z3, z4, z5, z7, z8, z9);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof GroupFlags)) {
                return false;
            }
            GroupFlags groupFlags = (GroupFlags) obj;
            return this.a == groupFlags.a && this.b == groupFlags.b && this.c == groupFlags.c && this.d == groupFlags.d && this.e == groupFlags.e && this.f == groupFlags.f && this.g == groupFlags.g && this.h == groupFlags.h;
        }

        public int hashCode() {
            boolean z = this.a;
            int i = 1;
            if (z) {
                z = true;
            }
            int i2 = z ? 1 : 0;
            int i3 = z ? 1 : 0;
            int i4 = z ? 1 : 0;
            int i5 = i2 * 31;
            boolean z2 = this.b;
            if (z2) {
                z2 = true;
            }
            int i6 = z2 ? 1 : 0;
            int i7 = z2 ? 1 : 0;
            int i8 = z2 ? 1 : 0;
            int i9 = (i5 + i6) * 31;
            boolean z3 = this.c;
            if (z3) {
                z3 = true;
            }
            int i10 = z3 ? 1 : 0;
            int i11 = z3 ? 1 : 0;
            int i12 = z3 ? 1 : 0;
            int i13 = (i9 + i10) * 31;
            boolean z4 = this.d;
            if (z4) {
                z4 = true;
            }
            int i14 = z4 ? 1 : 0;
            int i15 = z4 ? 1 : 0;
            int i16 = z4 ? 1 : 0;
            int i17 = (i13 + i14) * 31;
            boolean z5 = this.e;
            if (z5) {
                z5 = true;
            }
            int i18 = z5 ? 1 : 0;
            int i19 = z5 ? 1 : 0;
            int i20 = z5 ? 1 : 0;
            int i21 = (i17 + i18) * 31;
            boolean z7 = this.f;
            if (z7) {
                z7 = true;
            }
            int i22 = z7 ? 1 : 0;
            int i23 = z7 ? 1 : 0;
            int i24 = z7 ? 1 : 0;
            int i25 = (i21 + i22) * 31;
            boolean z8 = this.g;
            if (z8) {
                z8 = true;
            }
            int i26 = z8 ? 1 : 0;
            int i27 = z8 ? 1 : 0;
            int i28 = z8 ? 1 : 0;
            int i29 = (i25 + i26) * 31;
            boolean z9 = this.h;
            if (!z9) {
                i = z9 ? 1 : 0;
            }
            return i29 + i;
        }

        public final boolean isAfterSystemMessage() {
            return this.e;
        }

        public final boolean isAtDateGroupEnd() {
            return this.d;
        }

        public final boolean isAtDateGroupStart() {
            return this.c;
        }

        public final boolean isAtUserGroupEnd() {
            return this.b;
        }

        public final boolean isAtUserGroupStart() {
            return this.a;
        }

        public final boolean isBeforeSystemMessage() {
            return this.f;
        }

        public final boolean isFirstNewMessage() {
            return this.g;
        }

        public final boolean isLastOldMessage() {
            return this.h;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("GroupFlags(isAtUserGroupStart=");
            L.append(this.a);
            L.append(", isAtUserGroupEnd=");
            L.append(this.b);
            L.append(", isAtDateGroupStart=");
            L.append(this.c);
            L.append(", isAtDateGroupEnd=");
            L.append(this.d);
            L.append(", isAfterSystemMessage=");
            L.append(this.e);
            L.append(", isBeforeSystemMessage=");
            L.append(this.f);
            L.append(", isFirstNewMessage=");
            L.append(this.g);
            L.append(", isLastOldMessage=");
            return a.B(L, this.h, ")");
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ GroupFlags(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z7, boolean z8, boolean z9, int i, j jVar) {
            this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? false : z3, (i & 8) != 0 ? false : z4, (i & 16) != 0 ? false : z5, (i & 32) != 0 ? false : z7, (i & 64) != 0 ? false : z8, (i & 128) == 0 ? z9 : false);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0002\b\u001d\n\u0002\u0010\t\n\u0002\b\u001b\b\b\u0018\u00002\u00020\u0001:\u0001oB\u0001\u0012\u0006\u0010$\u001a\u00020\u0002\u0012\u0006\u0010%\u001a\u00020\u0006\u0012\u0006\u0010&\u001a\u00020\u0002\u0012\u0006\u0010'\u001a\u00020\u0002\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010)\u001a\u00020\f\u0012\u0006\u0010*\u001a\u00020\u000f\u0012\b\b\u0002\u0010+\u001a\u00020\f\u0012\b\b\u0002\u0010,\u001a\u00020\f\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u001b\u0012\u0006\u00101\u001a\u00020\u001e\u0012\b\u00102\u001a\u0004\u0018\u00010!¢\u0006\u0004\bm\u0010nJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\u0012\u0010\u000eJ\u0010\u0010\u0013\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\u0013\u0010\u000eJ\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0016J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001f\u001a\u00020\u001eHÆ\u0003¢\u0006\u0004\b\u001f\u0010 J\u0012\u0010\"\u001a\u0004\u0018\u00010!HÆ\u0003¢\u0006\u0004\b\"\u0010#J²\u0001\u00103\u001a\u00020\u00002\b\b\u0002\u0010$\u001a\u00020\u00022\b\b\u0002\u0010%\u001a\u00020\u00062\b\b\u0002\u0010&\u001a\u00020\u00022\b\b\u0002\u0010'\u001a\u00020\u00022\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010)\u001a\u00020\f2\b\b\u0002\u0010*\u001a\u00020\u000f2\b\b\u0002\u0010+\u001a\u00020\f2\b\b\u0002\u0010,\u001a\u00020\f2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u00101\u001a\u00020\u001e2\n\b\u0002\u00102\u001a\u0004\u0018\u00010!HÆ\u0001¢\u0006\u0004\b3\u00104J\u0010\u00105\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b5\u00106J\u001a\u00109\u001a\u00020\f2\b\u00108\u001a\u0004\u0018\u000107HÖ\u0003¢\u0006\u0004\b9\u0010:R$\u00100\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010\u001d\"\u0004\b>\u0010?R\u0019\u00101\u001a\u00020\u001e8\u0006@\u0006¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010 R\u0019\u0010+\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010\u000eR\"\u0010J\u001a\u00020\f8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bF\u0010D\u001a\u0004\bG\u0010\u000e\"\u0004\bH\u0010IR\u0019\u0010'\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\bK\u0010L\u001a\u0004\bM\u0010\u0004R\u0019\u0010)\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\bN\u0010D\u001a\u0004\b)\u0010\u000eR\u001b\u00102\u001a\u0004\u0018\u00010!8\u0006@\u0006¢\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010#R\u001b\u0010-\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\bR\u0010S\u001a\u0004\bT\u0010\u0016R\u0016\u0010X\u001a\u00020U8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\bV\u0010WR\u0019\u0010&\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\bY\u0010L\u001a\u0004\bZ\u0010\u0004R\u0019\u0010,\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b[\u0010D\u001a\u0004\b,\u0010\u000eR$\u0010/\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010\u001a\"\u0004\b_\u0010`R\u0019\u0010%\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\ba\u0010b\u001a\u0004\bc\u0010\bR\u001b\u0010.\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\bd\u0010S\u001a\u0004\be\u0010\u0016R\u001b\u0010(\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\bf\u0010L\u001a\u0004\bg\u0010\u0004R\u001c\u0010$\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bh\u0010L\u001a\u0004\bi\u0010\u0004R\u0019\u0010*\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\bj\u0010k\u001a\u0004\bl\u0010\u0011¨\u0006p"}, d2 = {"Lcom/avito/android/messenger/conversation/ChannelItem$Message;", "Lcom/avito/android/messenger/conversation/ChannelItem;", "", "toString", "()Ljava/lang/String;", "component1", "Lcom/avito/android/messenger/conversation/ChannelItem$Message$BodyOrBubble;", "component2", "()Lcom/avito/android/messenger/conversation/ChannelItem$Message$BodyOrBubble;", "component3", "component4", "component5", "", "component6", "()Z", "Lcom/avito/android/component/message_status/MessageDeliveryStatus;", "component7", "()Lcom/avito/android/component/message_status/MessageDeliveryStatus;", "component8", "component9", "", "component10", "()Ljava/lang/Integer;", "component11", "Lcom/avito/android/remote/model/Image;", "component12", "()Lcom/avito/android/remote/model/Image;", "Lcom/avito/android/messenger/conversation/ChannelItem$GroupFlags;", "component13", "()Lcom/avito/android/messenger/conversation/ChannelItem$GroupFlags;", "Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "component14", "()Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "Lru/avito/android/persistence/messenger/MessageMetaInfo;", "component15", "()Lru/avito/android/persistence/messenger/MessageMetaInfo;", "stringId", "bodyOrBubble", "userName", Sort.DATE, "time", "isMy", "status", "showStatus", "isRead", "overrideTopMarginDp", "overrideBottomMarginDp", "avatar", "groupFlags", "localMessage", "metaInfo", "copy", "(Ljava/lang/String;Lcom/avito/android/messenger/conversation/ChannelItem$Message$BodyOrBubble;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/avito/android/component/message_status/MessageDeliveryStatus;ZZLjava/lang/Integer;Ljava/lang/Integer;Lcom/avito/android/remote/model/Image;Lcom/avito/android/messenger/conversation/ChannelItem$GroupFlags;Lcom/avito/android/remote/model/messenger/message/LocalMessage;Lru/avito/android/persistence/messenger/MessageMetaInfo;)Lcom/avito/android/messenger/conversation/ChannelItem$Message;", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "n", "Lcom/avito/android/messenger/conversation/ChannelItem$GroupFlags;", "getGroupFlags", "setGroupFlags", "(Lcom/avito/android/messenger/conversation/ChannelItem$GroupFlags;)V", "o", "Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "getLocalMessage", "i", "Z", "getShowStatus", AuthSource.SEND_ABUSE, "getHighlight", "setHighlight", "(Z)V", ServiceTypeKt.SERVICE_HIGHLIGHT, "e", "Ljava/lang/String;", "getDate", g.a, "p", "Lru/avito/android/persistence/messenger/MessageMetaInfo;", "getMetaInfo", "k", "Ljava/lang/Integer;", "getOverrideTopMarginDp", "", "getId", "()J", "id", "d", "getUserName", "j", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/remote/model/Image;", "getAvatar", "setAvatar", "(Lcom/avito/android/remote/model/Image;)V", "c", "Lcom/avito/android/messenger/conversation/ChannelItem$Message$BodyOrBubble;", "getBodyOrBubble", "l", "getOverrideBottomMarginDp", "f", "getTime", AuthSource.BOOKING_ORDER, "getStringId", "h", "Lcom/avito/android/component/message_status/MessageDeliveryStatus;", "getStatus", "<init>", "(Ljava/lang/String;Lcom/avito/android/messenger/conversation/ChannelItem$Message$BodyOrBubble;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/avito/android/component/message_status/MessageDeliveryStatus;ZZLjava/lang/Integer;Ljava/lang/Integer;Lcom/avito/android/remote/model/Image;Lcom/avito/android/messenger/conversation/ChannelItem$GroupFlags;Lcom/avito/android/remote/model/messenger/message/LocalMessage;Lru/avito/android/persistence/messenger/MessageMetaInfo;)V", "BodyOrBubble", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Message extends ChannelItem {
        public boolean a;
        @NotNull
        public final String b;
        @NotNull
        public final BodyOrBubble c;
        @NotNull
        public final String d;
        @NotNull
        public final String e;
        @Nullable
        public final String f;
        public final boolean g;
        @NotNull
        public final MessageDeliveryStatus h;
        public final boolean i;
        public final boolean j;
        @Nullable
        public final Integer k;
        @Nullable
        public final Integer l;
        @Nullable
        public Image m;
        @Nullable
        public GroupFlags n;
        @NotNull
        public final LocalMessage o;
        @Nullable
        public final MessageMetaInfo p;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\f\rB\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u0001\u0002\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/messenger/conversation/ChannelItem$Message$BodyOrBubble;", "", "Lcom/avito/android/remote/model/messenger/message/MessageBody;", "getBody", "()Lcom/avito/android/remote/model/messenger/message/MessageBody;", SDKConstants.PARAM_A2U_BODY, "Lcom/avito/android/remote/model/messenger/message/MessageBody$SystemMessageBody$Platform$Bubble;", "getBubble", "()Lcom/avito/android/remote/model/messenger/message/MessageBody$SystemMessageBody$Platform$Bubble;", "bubble", "<init>", "()V", "Body", "Bubble", "Lcom/avito/android/messenger/conversation/ChannelItem$Message$BodyOrBubble$Body;", "Lcom/avito/android/messenger/conversation/ChannelItem$Message$BodyOrBubble$Bubble;", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static abstract class BodyOrBubble {

            @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\b\u001a\u00020\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0007R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/avito/android/messenger/conversation/ChannelItem$Message$BodyOrBubble$Body;", "Lcom/avito/android/messenger/conversation/ChannelItem$Message$BodyOrBubble;", "", "toString", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/messenger/message/MessageBody;", "component1", "()Lcom/avito/android/remote/model/messenger/message/MessageBody;", SDKConstants.PARAM_A2U_BODY, "copy", "(Lcom/avito/android/remote/model/messenger/message/MessageBody;)Lcom/avito/android/messenger/conversation/ChannelItem$Message$BodyOrBubble$Body;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/messenger/message/MessageBody;", "getBody", "Lcom/avito/android/remote/model/messenger/message/MessageBody$SystemMessageBody$Platform$Bubble;", "bubble", "Lcom/avito/android/remote/model/messenger/message/MessageBody$SystemMessageBody$Platform$Bubble;", "getBubble", "()Lcom/avito/android/remote/model/messenger/message/MessageBody$SystemMessageBody$Platform$Bubble;", "<init>", "(Lcom/avito/android/remote/model/messenger/message/MessageBody;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class Body extends BodyOrBubble {
                @NotNull
                public final MessageBody a;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Body(@NotNull MessageBody messageBody) {
                    super(null);
                    Intrinsics.checkNotNullParameter(messageBody, SDKConstants.PARAM_A2U_BODY);
                    this.a = messageBody;
                }

                public static /* synthetic */ Body copy$default(Body body, MessageBody messageBody, int i, Object obj) {
                    if ((i & 1) != 0) {
                        messageBody = body.getBody();
                    }
                    return body.copy(messageBody);
                }

                @NotNull
                public final MessageBody component1() {
                    return getBody();
                }

                @NotNull
                public final Body copy(@NotNull MessageBody messageBody) {
                    Intrinsics.checkNotNullParameter(messageBody, SDKConstants.PARAM_A2U_BODY);
                    return new Body(messageBody);
                }

                public boolean equals(@Nullable Object obj) {
                    if (this != obj) {
                        return (obj instanceof Body) && Intrinsics.areEqual(getBody(), ((Body) obj).getBody());
                    }
                    return true;
                }

                @Override // com.avito.android.messenger.conversation.ChannelItem.Message.BodyOrBubble
                @NotNull
                public MessageBody getBody() {
                    return this.a;
                }

                @Override // com.avito.android.messenger.conversation.ChannelItem.Message.BodyOrBubble
                @Nullable
                public MessageBody.SystemMessageBody.Platform.Bubble getBubble() {
                    return null;
                }

                public int hashCode() {
                    MessageBody body = getBody();
                    if (body != null) {
                        return body.hashCode();
                    }
                    return 0;
                }

                @NotNull
                public String toString() {
                    StringBuilder L = a.L("Body(body = ");
                    L.append(getBody());
                    L.append(')');
                    return L.toString();
                }
            }

            @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\b\u001a\u00020\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0007¨\u0006\u001d"}, d2 = {"Lcom/avito/android/messenger/conversation/ChannelItem$Message$BodyOrBubble$Bubble;", "Lcom/avito/android/messenger/conversation/ChannelItem$Message$BodyOrBubble;", "", "toString", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/messenger/message/MessageBody$SystemMessageBody$Platform$Bubble;", "component1", "()Lcom/avito/android/remote/model/messenger/message/MessageBody$SystemMessageBody$Platform$Bubble;", "bubble", "copy", "(Lcom/avito/android/remote/model/messenger/message/MessageBody$SystemMessageBody$Platform$Bubble;)Lcom/avito/android/messenger/conversation/ChannelItem$Message$BodyOrBubble$Bubble;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/avito/android/remote/model/messenger/message/MessageBody;", SDKConstants.PARAM_A2U_BODY, "Lcom/avito/android/remote/model/messenger/message/MessageBody;", "getBody", "()Lcom/avito/android/remote/model/messenger/message/MessageBody;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/messenger/message/MessageBody$SystemMessageBody$Platform$Bubble;", "getBubble", "<init>", "(Lcom/avito/android/remote/model/messenger/message/MessageBody$SystemMessageBody$Platform$Bubble;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class Bubble extends BodyOrBubble {
                @NotNull
                public final MessageBody.SystemMessageBody.Platform.Bubble a;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Bubble(@NotNull MessageBody.SystemMessageBody.Platform.Bubble bubble) {
                    super(null);
                    Intrinsics.checkNotNullParameter(bubble, "bubble");
                    this.a = bubble;
                }

                public static /* synthetic */ Bubble copy$default(Bubble bubble, MessageBody.SystemMessageBody.Platform.Bubble bubble2, int i, Object obj) {
                    if ((i & 1) != 0) {
                        bubble2 = bubble.getBubble();
                    }
                    return bubble.copy(bubble2);
                }

                @NotNull
                public final MessageBody.SystemMessageBody.Platform.Bubble component1() {
                    return getBubble();
                }

                @NotNull
                public final Bubble copy(@NotNull MessageBody.SystemMessageBody.Platform.Bubble bubble) {
                    Intrinsics.checkNotNullParameter(bubble, "bubble");
                    return new Bubble(bubble);
                }

                public boolean equals(@Nullable Object obj) {
                    if (this != obj) {
                        return (obj instanceof Bubble) && Intrinsics.areEqual(getBubble(), ((Bubble) obj).getBubble());
                    }
                    return true;
                }

                @Override // com.avito.android.messenger.conversation.ChannelItem.Message.BodyOrBubble
                @Nullable
                public MessageBody getBody() {
                    return null;
                }

                @Override // com.avito.android.messenger.conversation.ChannelItem.Message.BodyOrBubble
                @NotNull
                public MessageBody.SystemMessageBody.Platform.Bubble getBubble() {
                    return this.a;
                }

                public int hashCode() {
                    MessageBody.SystemMessageBody.Platform.Bubble bubble = getBubble();
                    if (bubble != null) {
                        return bubble.hashCode();
                    }
                    return 0;
                }

                @NotNull
                public String toString() {
                    StringBuilder L = a.L("Bubble(bubble = ");
                    L.append(getBubble());
                    L.append(')');
                    return L.toString();
                }
            }

            public BodyOrBubble() {
            }

            @Nullable
            public abstract MessageBody getBody();

            @Nullable
            public abstract MessageBody.SystemMessageBody.Platform.Bubble getBubble();

            public BodyOrBubble(j jVar) {
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Message(String str, BodyOrBubble bodyOrBubble, String str2, String str3, String str4, boolean z, MessageDeliveryStatus messageDeliveryStatus, boolean z2, boolean z3, Integer num, Integer num2, Image image, GroupFlags groupFlags, LocalMessage localMessage, MessageMetaInfo messageMetaInfo, int i2, j jVar) {
            this(str, bodyOrBubble, str2, str3, str4, z, messageDeliveryStatus, (i2 & 128) != 0 ? true : z2, (i2 & 256) != 0 ? true : z3, (i2 & 512) != 0 ? null : num, (i2 & 1024) != 0 ? null : num2, (i2 & 2048) != 0 ? null : image, (i2 & 4096) != 0 ? null : groupFlags, localMessage, messageMetaInfo);
        }

        public static /* synthetic */ Message copy$default(Message message, String str, BodyOrBubble bodyOrBubble, String str2, String str3, String str4, boolean z, MessageDeliveryStatus messageDeliveryStatus, boolean z2, boolean z3, Integer num, Integer num2, Image image, GroupFlags groupFlags, LocalMessage localMessage, MessageMetaInfo messageMetaInfo, int i2, Object obj) {
            return message.copy((i2 & 1) != 0 ? message.getStringId() : str, (i2 & 2) != 0 ? message.c : bodyOrBubble, (i2 & 4) != 0 ? message.d : str2, (i2 & 8) != 0 ? message.e : str3, (i2 & 16) != 0 ? message.f : str4, (i2 & 32) != 0 ? message.g : z, (i2 & 64) != 0 ? message.h : messageDeliveryStatus, (i2 & 128) != 0 ? message.i : z2, (i2 & 256) != 0 ? message.j : z3, (i2 & 512) != 0 ? message.k : num, (i2 & 1024) != 0 ? message.l : num2, (i2 & 2048) != 0 ? message.m : image, (i2 & 4096) != 0 ? message.n : groupFlags, (i2 & 8192) != 0 ? message.o : localMessage, (i2 & 16384) != 0 ? message.p : messageMetaInfo);
        }

        @NotNull
        public final String component1() {
            return getStringId();
        }

        @Nullable
        public final Integer component10() {
            return this.k;
        }

        @Nullable
        public final Integer component11() {
            return this.l;
        }

        @Nullable
        public final Image component12() {
            return this.m;
        }

        @Nullable
        public final GroupFlags component13() {
            return this.n;
        }

        @NotNull
        public final LocalMessage component14() {
            return this.o;
        }

        @Nullable
        public final MessageMetaInfo component15() {
            return this.p;
        }

        @NotNull
        public final BodyOrBubble component2() {
            return this.c;
        }

        @NotNull
        public final String component3() {
            return this.d;
        }

        @NotNull
        public final String component4() {
            return this.e;
        }

        @Nullable
        public final String component5() {
            return this.f;
        }

        public final boolean component6() {
            return this.g;
        }

        @NotNull
        public final MessageDeliveryStatus component7() {
            return this.h;
        }

        public final boolean component8() {
            return this.i;
        }

        public final boolean component9() {
            return this.j;
        }

        @NotNull
        public final Message copy(@NotNull String str, @NotNull BodyOrBubble bodyOrBubble, @NotNull String str2, @NotNull String str3, @Nullable String str4, boolean z, @NotNull MessageDeliveryStatus messageDeliveryStatus, boolean z2, boolean z3, @Nullable Integer num, @Nullable Integer num2, @Nullable Image image, @Nullable GroupFlags groupFlags, @NotNull LocalMessage localMessage, @Nullable MessageMetaInfo messageMetaInfo) {
            Intrinsics.checkNotNullParameter(str, "stringId");
            Intrinsics.checkNotNullParameter(bodyOrBubble, "bodyOrBubble");
            Intrinsics.checkNotNullParameter(str2, "userName");
            Intrinsics.checkNotNullParameter(str3, Sort.DATE);
            Intrinsics.checkNotNullParameter(messageDeliveryStatus, "status");
            Intrinsics.checkNotNullParameter(localMessage, "localMessage");
            return new Message(str, bodyOrBubble, str2, str3, str4, z, messageDeliveryStatus, z2, z3, num, num2, image, groupFlags, localMessage, messageMetaInfo);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Message)) {
                return false;
            }
            Message message = (Message) obj;
            return Intrinsics.areEqual(getStringId(), message.getStringId()) && Intrinsics.areEqual(this.c, message.c) && Intrinsics.areEqual(this.d, message.d) && Intrinsics.areEqual(this.e, message.e) && Intrinsics.areEqual(this.f, message.f) && this.g == message.g && Intrinsics.areEqual(this.h, message.h) && this.i == message.i && this.j == message.j && Intrinsics.areEqual(this.k, message.k) && Intrinsics.areEqual(this.l, message.l) && Intrinsics.areEqual(this.m, message.m) && Intrinsics.areEqual(this.n, message.n) && Intrinsics.areEqual(this.o, message.o) && Intrinsics.areEqual(this.p, message.p);
        }

        @Nullable
        public final Image getAvatar() {
            return this.m;
        }

        @NotNull
        public final BodyOrBubble getBodyOrBubble() {
            return this.c;
        }

        @NotNull
        public final String getDate() {
            return this.e;
        }

        @Nullable
        public final GroupFlags getGroupFlags() {
            return this.n;
        }

        public final boolean getHighlight() {
            return this.a;
        }

        @Override // com.avito.android.messenger.conversation.ChannelItem, com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
        public long getId() {
            return ((BodyPartID.bodyIdMax & ((long) getStringId().hashCode())) << 32) + (this.o.created & BodyPartID.bodyIdMax);
        }

        @NotNull
        public final LocalMessage getLocalMessage() {
            return this.o;
        }

        @Nullable
        public final MessageMetaInfo getMetaInfo() {
            return this.p;
        }

        @Nullable
        public final Integer getOverrideBottomMarginDp() {
            return this.l;
        }

        @Nullable
        public final Integer getOverrideTopMarginDp() {
            return this.k;
        }

        public final boolean getShowStatus() {
            return this.i;
        }

        @NotNull
        public final MessageDeliveryStatus getStatus() {
            return this.h;
        }

        @Override // com.avito.conveyor_item.Item
        @NotNull
        public String getStringId() {
            return this.b;
        }

        @Nullable
        public final String getTime() {
            return this.f;
        }

        @NotNull
        public final String getUserName() {
            return this.d;
        }

        public int hashCode() {
            String stringId = getStringId();
            int i2 = 0;
            int hashCode = (stringId != null ? stringId.hashCode() : 0) * 31;
            BodyOrBubble bodyOrBubble = this.c;
            int hashCode2 = (hashCode + (bodyOrBubble != null ? bodyOrBubble.hashCode() : 0)) * 31;
            String str = this.d;
            int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.e;
            int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.f;
            int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
            boolean z = this.g;
            int i3 = 1;
            if (z) {
                z = true;
            }
            int i4 = z ? 1 : 0;
            int i5 = z ? 1 : 0;
            int i6 = z ? 1 : 0;
            int i7 = (hashCode5 + i4) * 31;
            MessageDeliveryStatus messageDeliveryStatus = this.h;
            int hashCode6 = (i7 + (messageDeliveryStatus != null ? messageDeliveryStatus.hashCode() : 0)) * 31;
            boolean z2 = this.i;
            if (z2) {
                z2 = true;
            }
            int i8 = z2 ? 1 : 0;
            int i9 = z2 ? 1 : 0;
            int i10 = z2 ? 1 : 0;
            int i11 = (hashCode6 + i8) * 31;
            boolean z3 = this.j;
            if (!z3) {
                i3 = z3 ? 1 : 0;
            }
            int i12 = (i11 + i3) * 31;
            Integer num = this.k;
            int hashCode7 = (i12 + (num != null ? num.hashCode() : 0)) * 31;
            Integer num2 = this.l;
            int hashCode8 = (hashCode7 + (num2 != null ? num2.hashCode() : 0)) * 31;
            Image image = this.m;
            int hashCode9 = (hashCode8 + (image != null ? image.hashCode() : 0)) * 31;
            GroupFlags groupFlags = this.n;
            int hashCode10 = (hashCode9 + (groupFlags != null ? groupFlags.hashCode() : 0)) * 31;
            LocalMessage localMessage = this.o;
            int hashCode11 = (hashCode10 + (localMessage != null ? localMessage.hashCode() : 0)) * 31;
            MessageMetaInfo messageMetaInfo = this.p;
            if (messageMetaInfo != null) {
                i2 = messageMetaInfo.hashCode();
            }
            return hashCode11 + i2;
        }

        public final boolean isMy() {
            return this.g;
        }

        public final boolean isRead() {
            return this.j;
        }

        public final void setAvatar(@Nullable Image image) {
            this.m = image;
        }

        public final void setGroupFlags(@Nullable GroupFlags groupFlags) {
            this.n = groupFlags;
        }

        public final void setHighlight(boolean z) {
            this.a = z;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("Message[id=");
            L.append(getStringId());
            L.append(", bodyOrBubble=");
            L.append(this.c);
            L.append(", metaInfo=");
            L.append(this.p);
            L.append(']');
            return L.toString();
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Message(@NotNull String str, @NotNull BodyOrBubble bodyOrBubble, @NotNull String str2, @NotNull String str3, @Nullable String str4, boolean z, @NotNull MessageDeliveryStatus messageDeliveryStatus, boolean z2, boolean z3, @Nullable Integer num, @Nullable Integer num2, @Nullable Image image, @Nullable GroupFlags groupFlags, @NotNull LocalMessage localMessage, @Nullable MessageMetaInfo messageMetaInfo) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "stringId");
            Intrinsics.checkNotNullParameter(bodyOrBubble, "bodyOrBubble");
            Intrinsics.checkNotNullParameter(str2, "userName");
            Intrinsics.checkNotNullParameter(str3, Sort.DATE);
            Intrinsics.checkNotNullParameter(messageDeliveryStatus, "status");
            Intrinsics.checkNotNullParameter(localMessage, "localMessage");
            this.b = str;
            this.c = bodyOrBubble;
            this.d = str2;
            this.e = str3;
            this.f = str4;
            this.g = z;
            this.h = messageDeliveryStatus;
            this.i = z2;
            this.j = z3;
            this.k = num;
            this.l = num2;
            this.m = image;
            this.n = groupFlags;
            this.o = localMessage;
            this.p = messageMetaInfo;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\r\u001a\u00020\b8\u0016@\u0016XD¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/messenger/conversation/ChannelItem$PaginationError;", "Lcom/avito/android/messenger/conversation/ChannelItem;", "", AuthSource.BOOKING_ORDER, "J", "getId", "()J", "id", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getStringId", "()Ljava/lang/String;", "stringId", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class PaginationError extends ChannelItem {
        @NotNull
        public static final PaginationError INSTANCE = new PaginationError();
        @NotNull
        public static final String a = "PaginationError";
        public static final long b = -2;

        public PaginationError() {
            super(null);
        }

        @Override // com.avito.android.messenger.conversation.ChannelItem, com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
        public long getId() {
            return b;
        }

        @Override // com.avito.conveyor_item.Item
        @NotNull
        public String getStringId() {
            return a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\r\u001a\u00020\b8\u0016@\u0016XD¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/messenger/conversation/ChannelItem$PaginationInProgress;", "Lcom/avito/android/messenger/conversation/ChannelItem;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getStringId", "()Ljava/lang/String;", "stringId", "", AuthSource.BOOKING_ORDER, "J", "getId", "()J", "id", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class PaginationInProgress extends ChannelItem {
        @NotNull
        public static final PaginationInProgress INSTANCE = new PaginationInProgress();
        @NotNull
        public static final String a = "PaginationInProgress";
        public static final long b = -3;

        public PaginationInProgress() {
            super(null);
        }

        @Override // com.avito.android.messenger.conversation.ChannelItem, com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
        public long getId() {
            return b;
        }

        @Override // com.avito.conveyor_item.Item
        @NotNull
        public String getStringId() {
            return a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0015\b\b\u0018\u00002\u00020\u0001:\u00011B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b/\u00100J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u001c\u0010\u001c\u001a\u00020\u00028\u0016@\u0016XD¢\u0006\f\n\u0004\b\u001a\u0010\u0018\u001a\u0004\b\u001b\u0010\u0004R\u001c\u0010\"\u001a\u00020\u001d8\u0016@\u0016XD¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010\u0018\u001a\u0004\b$\u0010\u0004R\u0019\u0010\u000b\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\bR\"\u0010.\u001a\u00020\u00148\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-¨\u00062"}, d2 = {"Lcom/avito/android/messenger/conversation/ChannelItem$SpamActions;", "Lcom/avito/android/messenger/conversation/ChannelItem;", "", "component1", "()Ljava/lang/String;", "component2", "Lcom/avito/android/messenger/conversation/ChannelItem$SpamActions$State;", "component3", "()Lcom/avito/android/messenger/conversation/ChannelItem$SpamActions$State;", "channelId", "messageRemoteId", "state", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/messenger/conversation/ChannelItem$SpamActions$State;)Lcom/avito/android/messenger/conversation/ChannelItem$SpamActions;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "d", "Ljava/lang/String;", "getChannelId", AuthSource.SEND_ABUSE, "getStringId", "stringId", "", AuthSource.BOOKING_ORDER, "J", "getId", "()J", "id", "e", "getMessageRemoteId", "f", "Lcom/avito/android/messenger/conversation/ChannelItem$SpamActions$State;", "getState", "c", "Z", "getSplitsUserGroup", "()Z", "setSplitsUserGroup", "(Z)V", "splitsUserGroup", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/messenger/conversation/ChannelItem$SpamActions$State;)V", "State", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class SpamActions extends ChannelItem {
        @NotNull
        public final String a = "SpamActions:d2322996-ade8-11e9-a2a3-2a2ae2dbcce4";
        public final long b = -6;
        public boolean c;
        @NotNull
        public final String d;
        @NotNull
        public final String e;
        @NotNull
        public final State f;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/messenger/conversation/ChannelItem$SpamActions$State;", "", "<init>", "()V", "InProgress", "Static", "Lcom/avito/android/messenger/conversation/ChannelItem$SpamActions$State$Static;", "Lcom/avito/android/messenger/conversation/ChannelItem$SpamActions$State$InProgress;", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static abstract class State {

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/messenger/conversation/ChannelItem$SpamActions$State$InProgress;", "Lcom/avito/android/messenger/conversation/ChannelItem$SpamActions$State;", "", AuthSource.SEND_ABUSE, "Z", "isSpam", "()Z", "<init>", "(Z)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class InProgress extends State {
                public final boolean a;

                public InProgress(boolean z) {
                    super(null);
                    this.a = z;
                }

                public final boolean isSpam() {
                    return this.a;
                }
            }

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/messenger/conversation/ChannelItem$SpamActions$State$Static;", "Lcom/avito/android/messenger/conversation/ChannelItem$SpamActions$State;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class Static extends State {
                @NotNull
                public static final Static INSTANCE = new Static();

                public Static() {
                    super(null);
                }
            }

            public State() {
            }

            public State(j jVar) {
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SpamActions(@NotNull String str, @NotNull String str2, @NotNull State state) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "channelId");
            Intrinsics.checkNotNullParameter(str2, "messageRemoteId");
            Intrinsics.checkNotNullParameter(state, "state");
            this.d = str;
            this.e = str2;
            this.f = state;
        }

        public static /* synthetic */ SpamActions copy$default(SpamActions spamActions, String str, String str2, State state, int i, Object obj) {
            if ((i & 1) != 0) {
                str = spamActions.d;
            }
            if ((i & 2) != 0) {
                str2 = spamActions.e;
            }
            if ((i & 4) != 0) {
                state = spamActions.f;
            }
            return spamActions.copy(str, str2, state);
        }

        @NotNull
        public final String component1() {
            return this.d;
        }

        @NotNull
        public final String component2() {
            return this.e;
        }

        @NotNull
        public final State component3() {
            return this.f;
        }

        @NotNull
        public final SpamActions copy(@NotNull String str, @NotNull String str2, @NotNull State state) {
            Intrinsics.checkNotNullParameter(str, "channelId");
            Intrinsics.checkNotNullParameter(str2, "messageRemoteId");
            Intrinsics.checkNotNullParameter(state, "state");
            return new SpamActions(str, str2, state);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SpamActions)) {
                return false;
            }
            SpamActions spamActions = (SpamActions) obj;
            return Intrinsics.areEqual(this.d, spamActions.d) && Intrinsics.areEqual(this.e, spamActions.e) && Intrinsics.areEqual(this.f, spamActions.f);
        }

        @NotNull
        public final String getChannelId() {
            return this.d;
        }

        @Override // com.avito.android.messenger.conversation.ChannelItem, com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
        public long getId() {
            return this.b;
        }

        @NotNull
        public final String getMessageRemoteId() {
            return this.e;
        }

        public final boolean getSplitsUserGroup() {
            return this.c;
        }

        @NotNull
        public final State getState() {
            return this.f;
        }

        @Override // com.avito.conveyor_item.Item
        @NotNull
        public String getStringId() {
            return this.a;
        }

        public int hashCode() {
            String str = this.d;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.e;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            State state = this.f;
            if (state != null) {
                i = state.hashCode();
            }
            return hashCode2 + i;
        }

        public final void setSplitsUserGroup(boolean z) {
            this.c = z;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("SpamActions(channelId=");
            L.append(this.d);
            L.append(", messageRemoteId=");
            L.append(this.e);
            L.append(", state=");
            L.append(this.f);
            L.append(")");
            return L.toString();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\r\u001a\u00020\b8\u0016@\u0016XD¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/messenger/conversation/ChannelItem$UnreadMessagesDivider;", "Lcom/avito/android/messenger/conversation/ChannelItem;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getStringId", "()Ljava/lang/String;", "stringId", "", AuthSource.BOOKING_ORDER, "J", "getId", "()J", "id", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class UnreadMessagesDivider extends ChannelItem {
        @NotNull
        public static final UnreadMessagesDivider INSTANCE = new UnreadMessagesDivider();
        @NotNull
        public static final String a = "UnreadMessagesDivider";
        public static final long b = -1;

        public UnreadMessagesDivider() {
            super(null);
        }

        @Override // com.avito.android.messenger.conversation.ChannelItem, com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
        public long getId() {
            return b;
        }

        @Override // com.avito.conveyor_item.Item
        @NotNull
        public String getStringId() {
            return a;
        }
    }

    public ChannelItem() {
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return Item.DefaultImpls.getId(this);
    }

    public ChannelItem(j jVar) {
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0011\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\u001a\u001a\u00020\u00158\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u0007R\u001c\u0010#\u001a\u00020\u00028\u0016@\u0016XD¢\u0006\f\n\u0004\b!\u0010\u001c\u001a\u0004\b\"\u0010\u0004¨\u0006&"}, d2 = {"Lcom/avito/android/messenger/conversation/ChannelItem$TypingIndicator;", "Lcom/avito/android/messenger/conversation/ChannelItem;", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/Image;", "component2", "()Lcom/avito/android/remote/model/Image;", "typingUserId", "avatar", "copy", "(Ljava/lang/String;Lcom/avito/android/remote/model/Image;)Lcom/avito/android/messenger/conversation/ChannelItem$TypingIndicator;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", AuthSource.BOOKING_ORDER, "J", "getId", "()J", "id", "c", "Ljava/lang/String;", "getTypingUserId", "d", "Lcom/avito/android/remote/model/Image;", "getAvatar", AuthSource.SEND_ABUSE, "getStringId", "stringId", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/Image;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class TypingIndicator extends ChannelItem {
        @NotNull
        public final String a;
        public final long b;
        @NotNull
        public final String c;
        @Nullable
        public final Image d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public TypingIndicator(@NotNull String str, @Nullable Image image) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "typingUserId");
            this.c = str;
            this.d = image;
            this.a = "TypingIndicator:d2322996-ade8-11e9-a2a3-2a2ae2dbcce4";
            this.b = -5;
        }

        public static /* synthetic */ TypingIndicator copy$default(TypingIndicator typingIndicator, String str, Image image, int i, Object obj) {
            if ((i & 1) != 0) {
                str = typingIndicator.c;
            }
            if ((i & 2) != 0) {
                image = typingIndicator.d;
            }
            return typingIndicator.copy(str, image);
        }

        @NotNull
        public final String component1() {
            return this.c;
        }

        @Nullable
        public final Image component2() {
            return this.d;
        }

        @NotNull
        public final TypingIndicator copy(@NotNull String str, @Nullable Image image) {
            Intrinsics.checkNotNullParameter(str, "typingUserId");
            return new TypingIndicator(str, image);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TypingIndicator)) {
                return false;
            }
            TypingIndicator typingIndicator = (TypingIndicator) obj;
            return Intrinsics.areEqual(this.c, typingIndicator.c) && Intrinsics.areEqual(this.d, typingIndicator.d);
        }

        @Nullable
        public final Image getAvatar() {
            return this.d;
        }

        @Override // com.avito.android.messenger.conversation.ChannelItem, com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
        public long getId() {
            return this.b;
        }

        @Override // com.avito.conveyor_item.Item
        @NotNull
        public String getStringId() {
            return this.a;
        }

        @NotNull
        public final String getTypingUserId() {
            return this.c;
        }

        public int hashCode() {
            String str = this.c;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            Image image = this.d;
            if (image != null) {
                i = image.hashCode();
            }
            return hashCode + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("TypingIndicator(typingUserId=");
            L.append(this.c);
            L.append(", avatar=");
            L.append(this.d);
            L.append(")");
            return L.toString();
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ TypingIndicator(String str, Image image, int i, j jVar) {
            this(str, (i & 2) != 0 ? null : image);
        }
    }
}
