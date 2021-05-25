package ru.sravni.android.bankproduct.domain.dashboard.entity;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\b\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b-\u0010.J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\f\u0010\nJ\u0012\u0010\r\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\r\u0010\nJV\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0016\u0010\nJ\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u001b\u0010\u0012\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\nR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\u0007R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010\u001f\u001a\u0004\b%\u0010\nR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010\u001f\u001a\u0004\b'\u0010\nR\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010\u0004R\u001b\u0010\u0011\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010\u001f\u001a\u0004\b,\u0010\n¨\u0006/"}, d2 = {"Lru/sravni/android/bankproduct/domain/dashboard/entity/RestoreStorageIntentInfoDomain;", "", "Lru/sravni/android/bankproduct/domain/dashboard/entity/ChannelStorageIntentEnum;", "component1", "()Lru/sravni/android/bankproduct/domain/dashboard/entity/ChannelStorageIntentEnum;", "Lru/sravni/android/bankproduct/domain/dashboard/entity/ActionStorageIntentEnum;", "component2", "()Lru/sravni/android/bankproduct/domain/dashboard/entity/ActionStorageIntentEnum;", "", "component3", "()Ljava/lang/String;", "component4", "component5", "component6", "channel", "action", "savedSearchID", "conversationID", "chatName", "chatTitle", "copy", "(Lru/sravni/android/bankproduct/domain/dashboard/entity/ChannelStorageIntentEnum;Lru/sravni/android/bankproduct/domain/dashboard/entity/ActionStorageIntentEnum;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lru/sravni/android/bankproduct/domain/dashboard/entity/RestoreStorageIntentInfoDomain;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "e", "Ljava/lang/String;", "getChatName", AuthSource.BOOKING_ORDER, "Lru/sravni/android/bankproduct/domain/dashboard/entity/ActionStorageIntentEnum;", "getAction", "f", "getChatTitle", "c", "getSavedSearchID", AuthSource.SEND_ABUSE, "Lru/sravni/android/bankproduct/domain/dashboard/entity/ChannelStorageIntentEnum;", "getChannel", "d", "getConversationID", "<init>", "(Lru/sravni/android/bankproduct/domain/dashboard/entity/ChannelStorageIntentEnum;Lru/sravni/android/bankproduct/domain/dashboard/entity/ActionStorageIntentEnum;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class RestoreStorageIntentInfoDomain {
    @NotNull
    public final ChannelStorageIntentEnum a;
    @Nullable
    public final ActionStorageIntentEnum b;
    @Nullable
    public final String c;
    @Nullable
    public final String d;
    @Nullable
    public final String e;
    @Nullable
    public final String f;

    public RestoreStorageIntentInfoDomain(@NotNull ChannelStorageIntentEnum channelStorageIntentEnum, @Nullable ActionStorageIntentEnum actionStorageIntentEnum, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        Intrinsics.checkParameterIsNotNull(channelStorageIntentEnum, "channel");
        this.a = channelStorageIntentEnum;
        this.b = actionStorageIntentEnum;
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = str4;
    }

    public static /* synthetic */ RestoreStorageIntentInfoDomain copy$default(RestoreStorageIntentInfoDomain restoreStorageIntentInfoDomain, ChannelStorageIntentEnum channelStorageIntentEnum, ActionStorageIntentEnum actionStorageIntentEnum, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            channelStorageIntentEnum = restoreStorageIntentInfoDomain.a;
        }
        if ((i & 2) != 0) {
            actionStorageIntentEnum = restoreStorageIntentInfoDomain.b;
        }
        if ((i & 4) != 0) {
            str = restoreStorageIntentInfoDomain.c;
        }
        if ((i & 8) != 0) {
            str2 = restoreStorageIntentInfoDomain.d;
        }
        if ((i & 16) != 0) {
            str3 = restoreStorageIntentInfoDomain.e;
        }
        if ((i & 32) != 0) {
            str4 = restoreStorageIntentInfoDomain.f;
        }
        return restoreStorageIntentInfoDomain.copy(channelStorageIntentEnum, actionStorageIntentEnum, str, str2, str3, str4);
    }

    @NotNull
    public final ChannelStorageIntentEnum component1() {
        return this.a;
    }

    @Nullable
    public final ActionStorageIntentEnum component2() {
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

    @Nullable
    public final String component5() {
        return this.e;
    }

    @Nullable
    public final String component6() {
        return this.f;
    }

    @NotNull
    public final RestoreStorageIntentInfoDomain copy(@NotNull ChannelStorageIntentEnum channelStorageIntentEnum, @Nullable ActionStorageIntentEnum actionStorageIntentEnum, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        Intrinsics.checkParameterIsNotNull(channelStorageIntentEnum, "channel");
        return new RestoreStorageIntentInfoDomain(channelStorageIntentEnum, actionStorageIntentEnum, str, str2, str3, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RestoreStorageIntentInfoDomain)) {
            return false;
        }
        RestoreStorageIntentInfoDomain restoreStorageIntentInfoDomain = (RestoreStorageIntentInfoDomain) obj;
        return Intrinsics.areEqual(this.a, restoreStorageIntentInfoDomain.a) && Intrinsics.areEqual(this.b, restoreStorageIntentInfoDomain.b) && Intrinsics.areEqual(this.c, restoreStorageIntentInfoDomain.c) && Intrinsics.areEqual(this.d, restoreStorageIntentInfoDomain.d) && Intrinsics.areEqual(this.e, restoreStorageIntentInfoDomain.e) && Intrinsics.areEqual(this.f, restoreStorageIntentInfoDomain.f);
    }

    @Nullable
    public final ActionStorageIntentEnum getAction() {
        return this.b;
    }

    @NotNull
    public final ChannelStorageIntentEnum getChannel() {
        return this.a;
    }

    @Nullable
    public final String getChatName() {
        return this.e;
    }

    @Nullable
    public final String getChatTitle() {
        return this.f;
    }

    @Nullable
    public final String getConversationID() {
        return this.d;
    }

    @Nullable
    public final String getSavedSearchID() {
        return this.c;
    }

    public int hashCode() {
        ChannelStorageIntentEnum channelStorageIntentEnum = this.a;
        int i = 0;
        int hashCode = (channelStorageIntentEnum != null ? channelStorageIntentEnum.hashCode() : 0) * 31;
        ActionStorageIntentEnum actionStorageIntentEnum = this.b;
        int hashCode2 = (hashCode + (actionStorageIntentEnum != null ? actionStorageIntentEnum.hashCode() : 0)) * 31;
        String str = this.c;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.d;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.e;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode5 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("RestoreStorageIntentInfoDomain(channel=");
        L.append(this.a);
        L.append(", action=");
        L.append(this.b);
        L.append(", savedSearchID=");
        L.append(this.c);
        L.append(", conversationID=");
        L.append(this.d);
        L.append(", chatName=");
        L.append(this.e);
        L.append(", chatTitle=");
        return a.t(L, this.f, ")");
    }
}
