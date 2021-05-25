package com.avito.android.user_adverts.root_screen.adverts_host.header;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.user_adverts.SoaUpdateInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/user_adverts/root_screen/adverts_host/header/CardState;", "", "<init>", "()V", "Loaded", "Loading", "UpdateAnimation", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/CardState$Loading;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/CardState$UpdateAnimation;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/CardState$Loaded;", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public abstract class CardState {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ2\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u001b\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0007R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u0004R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\n¨\u0006&"}, d2 = {"Lcom/avito/android/user_adverts/root_screen/adverts_host/header/CardState$Loaded;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/CardState;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/CardData;", "component1", "()Lcom/avito/android/user_adverts/root_screen/adverts_host/header/CardData;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/OnboardingData;", "component2", "()Lcom/avito/android/user_adverts/root_screen/adverts_host/header/OnboardingData;", "Lcom/avito/android/user_adverts/SoaUpdateInfo;", "component3", "()Lcom/avito/android/user_adverts/SoaUpdateInfo;", "cardData", "onboarding", "updateInfo", "copy", "(Lcom/avito/android/user_adverts/root_screen/adverts_host/header/CardData;Lcom/avito/android/user_adverts/root_screen/adverts_host/header/OnboardingData;Lcom/avito/android/user_adverts/SoaUpdateInfo;)Lcom/avito/android/user_adverts/root_screen/adverts_host/header/CardState$Loaded;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/OnboardingData;", "getOnboarding", AuthSource.SEND_ABUSE, "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/CardData;", "getCardData", "c", "Lcom/avito/android/user_adverts/SoaUpdateInfo;", "getUpdateInfo", "<init>", "(Lcom/avito/android/user_adverts/root_screen/adverts_host/header/CardData;Lcom/avito/android/user_adverts/root_screen/adverts_host/header/OnboardingData;Lcom/avito/android/user_adverts/SoaUpdateInfo;)V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
    public static final class Loaded extends CardState {
        @NotNull
        public final CardData a;
        @Nullable
        public final OnboardingData b;
        @Nullable
        public final SoaUpdateInfo c;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Loaded(CardData cardData, OnboardingData onboardingData, SoaUpdateInfo soaUpdateInfo, int i, j jVar) {
            this(cardData, (i & 2) != 0 ? null : onboardingData, (i & 4) != 0 ? null : soaUpdateInfo);
        }

        public static /* synthetic */ Loaded copy$default(Loaded loaded, CardData cardData, OnboardingData onboardingData, SoaUpdateInfo soaUpdateInfo, int i, Object obj) {
            if ((i & 1) != 0) {
                cardData = loaded.a;
            }
            if ((i & 2) != 0) {
                onboardingData = loaded.b;
            }
            if ((i & 4) != 0) {
                soaUpdateInfo = loaded.c;
            }
            return loaded.copy(cardData, onboardingData, soaUpdateInfo);
        }

        @NotNull
        public final CardData component1() {
            return this.a;
        }

        @Nullable
        public final OnboardingData component2() {
            return this.b;
        }

        @Nullable
        public final SoaUpdateInfo component3() {
            return this.c;
        }

        @NotNull
        public final Loaded copy(@NotNull CardData cardData, @Nullable OnboardingData onboardingData, @Nullable SoaUpdateInfo soaUpdateInfo) {
            Intrinsics.checkNotNullParameter(cardData, "cardData");
            return new Loaded(cardData, onboardingData, soaUpdateInfo);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Loaded)) {
                return false;
            }
            Loaded loaded = (Loaded) obj;
            return Intrinsics.areEqual(this.a, loaded.a) && Intrinsics.areEqual(this.b, loaded.b) && Intrinsics.areEqual(this.c, loaded.c);
        }

        @NotNull
        public final CardData getCardData() {
            return this.a;
        }

        @Nullable
        public final OnboardingData getOnboarding() {
            return this.b;
        }

        @Nullable
        public final SoaUpdateInfo getUpdateInfo() {
            return this.c;
        }

        public int hashCode() {
            CardData cardData = this.a;
            int i = 0;
            int hashCode = (cardData != null ? cardData.hashCode() : 0) * 31;
            OnboardingData onboardingData = this.b;
            int hashCode2 = (hashCode + (onboardingData != null ? onboardingData.hashCode() : 0)) * 31;
            SoaUpdateInfo soaUpdateInfo = this.c;
            if (soaUpdateInfo != null) {
                i = soaUpdateInfo.hashCode();
            }
            return hashCode2 + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("Loaded(cardData=");
            L.append(this.a);
            L.append(", onboarding=");
            L.append(this.b);
            L.append(", updateInfo=");
            L.append(this.c);
            L.append(")");
            return L.toString();
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Loaded(@NotNull CardData cardData, @Nullable OnboardingData onboardingData, @Nullable SoaUpdateInfo soaUpdateInfo) {
            super(null);
            Intrinsics.checkNotNullParameter(cardData, "cardData");
            this.a = cardData;
            this.b = onboardingData;
            this.c = soaUpdateInfo;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/user_adverts/root_screen/adverts_host/header/CardState$Loading;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/CardState;", "<init>", "()V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
    public static final class Loading extends CardState {
        @NotNull
        public static final Loading INSTANCE = new Loading();

        public Loading() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/avito/android/user_adverts/root_screen/adverts_host/header/CardState$UpdateAnimation;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/CardState;", "Lcom/avito/android/user_adverts/SoaUpdateInfo;", "component1", "()Lcom/avito/android/user_adverts/SoaUpdateInfo;", "updateInfo", "copy", "(Lcom/avito/android/user_adverts/SoaUpdateInfo;)Lcom/avito/android/user_adverts/root_screen/adverts_host/header/CardState$UpdateAnimation;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lcom/avito/android/user_adverts/SoaUpdateInfo;", "getUpdateInfo", "<init>", "(Lcom/avito/android/user_adverts/SoaUpdateInfo;)V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
    public static final class UpdateAnimation extends CardState {
        @NotNull
        public final SoaUpdateInfo a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public UpdateAnimation(@NotNull SoaUpdateInfo soaUpdateInfo) {
            super(null);
            Intrinsics.checkNotNullParameter(soaUpdateInfo, "updateInfo");
            this.a = soaUpdateInfo;
        }

        public static /* synthetic */ UpdateAnimation copy$default(UpdateAnimation updateAnimation, SoaUpdateInfo soaUpdateInfo, int i, Object obj) {
            if ((i & 1) != 0) {
                soaUpdateInfo = updateAnimation.a;
            }
            return updateAnimation.copy(soaUpdateInfo);
        }

        @NotNull
        public final SoaUpdateInfo component1() {
            return this.a;
        }

        @NotNull
        public final UpdateAnimation copy(@NotNull SoaUpdateInfo soaUpdateInfo) {
            Intrinsics.checkNotNullParameter(soaUpdateInfo, "updateInfo");
            return new UpdateAnimation(soaUpdateInfo);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof UpdateAnimation) && Intrinsics.areEqual(this.a, ((UpdateAnimation) obj).a);
            }
            return true;
        }

        @NotNull
        public final SoaUpdateInfo getUpdateInfo() {
            return this.a;
        }

        public int hashCode() {
            SoaUpdateInfo soaUpdateInfo = this.a;
            if (soaUpdateInfo != null) {
                return soaUpdateInfo.hashCode();
            }
            return 0;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("UpdateAnimation(updateInfo=");
            L.append(this.a);
            L.append(")");
            return L.toString();
        }
    }

    public CardState() {
    }

    public CardState(j jVar) {
    }
}
