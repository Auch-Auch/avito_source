package com.avito.android.user_adverts.root_screen.adverts_host.header;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.user_adverts.root_screen.adverts_host.header.ProfileHeaderView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004¨\u0006\u001c"}, d2 = {"Lcom/avito/android/user_adverts/root_screen/adverts_host/header/OnboardingData;", "", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderView$ClickTarget;", "component2", "()Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderView$ClickTarget;", "text", "closeClickTarget", "copy", "(Ljava/lang/String;Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderView$ClickTarget;)Lcom/avito/android/user_adverts/root_screen/adverts_host/header/OnboardingData;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderView$ClickTarget;", "getCloseClickTarget", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getText", "<init>", "(Ljava/lang/String;Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderView$ClickTarget;)V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class OnboardingData {
    @NotNull
    public final String a;
    @NotNull
    public final ProfileHeaderView.ClickTarget b;

    public OnboardingData(@NotNull String str, @NotNull ProfileHeaderView.ClickTarget clickTarget) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(clickTarget, "closeClickTarget");
        this.a = str;
        this.b = clickTarget;
    }

    public static /* synthetic */ OnboardingData copy$default(OnboardingData onboardingData, String str, ProfileHeaderView.ClickTarget clickTarget, int i, Object obj) {
        if ((i & 1) != 0) {
            str = onboardingData.a;
        }
        if ((i & 2) != 0) {
            clickTarget = onboardingData.b;
        }
        return onboardingData.copy(str, clickTarget);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    @NotNull
    public final ProfileHeaderView.ClickTarget component2() {
        return this.b;
    }

    @NotNull
    public final OnboardingData copy(@NotNull String str, @NotNull ProfileHeaderView.ClickTarget clickTarget) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(clickTarget, "closeClickTarget");
        return new OnboardingData(str, clickTarget);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OnboardingData)) {
            return false;
        }
        OnboardingData onboardingData = (OnboardingData) obj;
        return Intrinsics.areEqual(this.a, onboardingData.a) && Intrinsics.areEqual(this.b, onboardingData.b);
    }

    @NotNull
    public final ProfileHeaderView.ClickTarget getCloseClickTarget() {
        return this.b;
    }

    @NotNull
    public final String getText() {
        return this.a;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        ProfileHeaderView.ClickTarget clickTarget = this.b;
        if (clickTarget != null) {
            i = clickTarget.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("OnboardingData(text=");
        L.append(this.a);
        L.append(", closeClickTarget=");
        L.append(this.b);
        L.append(")");
        return L.toString();
    }
}
