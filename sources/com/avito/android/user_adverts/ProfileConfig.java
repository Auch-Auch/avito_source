package com.avito.android.user_adverts;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.user_adverts.root_screen.adverts_host.header.CardData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\b\u0010\u0004R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007¨\u0006\u001c"}, d2 = {"Lcom/avito/android/user_adverts/ProfileConfig;", "", "", "component1", "()Z", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/CardData;", "component2", "()Lcom/avito/android/user_adverts/root_screen/adverts_host/header/CardData;", "isSearchAvailable", "smbStatsData", "copy", "(ZLcom/avito/android/user_adverts/root_screen/adverts_host/header/CardData;)Lcom/avito/android/user_adverts/ProfileConfig;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Z", AuthSource.BOOKING_ORDER, "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/CardData;", "getSmbStatsData", "<init>", "(ZLcom/avito/android/user_adverts/root_screen/adverts_host/header/CardData;)V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class ProfileConfig {
    public final boolean a;
    @Nullable
    public final CardData b;

    public ProfileConfig(boolean z, @Nullable CardData cardData) {
        this.a = z;
        this.b = cardData;
    }

    public static /* synthetic */ ProfileConfig copy$default(ProfileConfig profileConfig, boolean z, CardData cardData, int i, Object obj) {
        if ((i & 1) != 0) {
            z = profileConfig.a;
        }
        if ((i & 2) != 0) {
            cardData = profileConfig.b;
        }
        return profileConfig.copy(z, cardData);
    }

    public final boolean component1() {
        return this.a;
    }

    @Nullable
    public final CardData component2() {
        return this.b;
    }

    @NotNull
    public final ProfileConfig copy(boolean z, @Nullable CardData cardData) {
        return new ProfileConfig(z, cardData);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProfileConfig)) {
            return false;
        }
        ProfileConfig profileConfig = (ProfileConfig) obj;
        return this.a == profileConfig.a && Intrinsics.areEqual(this.b, profileConfig.b);
    }

    @Nullable
    public final CardData getSmbStatsData() {
        return this.b;
    }

    public int hashCode() {
        boolean z = this.a;
        if (z) {
            z = true;
        }
        int i = z ? 1 : 0;
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = i * 31;
        CardData cardData = this.b;
        return i4 + (cardData != null ? cardData.hashCode() : 0);
    }

    public final boolean isSearchAvailable() {
        return this.a;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ProfileConfig(isSearchAvailable=");
        L.append(this.a);
        L.append(", smbStatsData=");
        L.append(this.b);
        L.append(")");
        return L.toString();
    }
}
