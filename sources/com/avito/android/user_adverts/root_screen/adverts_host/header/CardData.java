package com.avito.android.user_adverts.root_screen.adverts_host.header;

import a2.b.a.a.a;
import androidx.annotation.DrawableRes;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.user_adverts.root_screen.adverts_host.header.ProfileHeaderView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b \b\b\u0018\u00002\u00020\u0001B;\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0012\u001a\u00020\t\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b*\u0010+J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJJ\u0010\u0014\u001a\u00020\u00002\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0012\u001a\u00020\t2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0007J\u0010\u0010\u0017\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001a\u001a\u00020\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0007R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u000eR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\u0004R\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010\u001d\u001a\u0004\b&\u0010\u0007R\u0019\u0010\u0012\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010\u000b¨\u0006,"}, d2 = {"Lcom/avito/android/user_adverts/root_screen/adverts_host/header/CardData;", "", "", "component1", "()Ljava/lang/Integer;", "", "component2", "()Ljava/lang/String;", "component3", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderView$ClickTarget;", "component4", "()Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderView$ClickTarget;", "", "component5", "()Ljava/lang/Boolean;", "icon", "title", "subTitle", "clickTarget", "hasNotification", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderView$ClickTarget;Ljava/lang/Boolean;)Lcom/avito/android/user_adverts/root_screen/adverts_host/header/CardData;", "toString", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "c", "Ljava/lang/String;", "getSubTitle", "e", "Ljava/lang/Boolean;", "getHasNotification", AuthSource.SEND_ABUSE, "Ljava/lang/Integer;", "getIcon", AuthSource.BOOKING_ORDER, "getTitle", "d", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderView$ClickTarget;", "getClickTarget", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/user_adverts/root_screen/adverts_host/header/ProfileHeaderView$ClickTarget;Ljava/lang/Boolean;)V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class CardData {
    @Nullable
    public final Integer a;
    @Nullable
    public final String b;
    @Nullable
    public final String c;
    @NotNull
    public final ProfileHeaderView.ClickTarget d;
    @Nullable
    public final Boolean e;

    public CardData(@DrawableRes @Nullable Integer num, @Nullable String str, @Nullable String str2, @NotNull ProfileHeaderView.ClickTarget clickTarget, @Nullable Boolean bool) {
        Intrinsics.checkNotNullParameter(clickTarget, "clickTarget");
        this.a = num;
        this.b = str;
        this.c = str2;
        this.d = clickTarget;
        this.e = bool;
    }

    public static /* synthetic */ CardData copy$default(CardData cardData, Integer num, String str, String str2, ProfileHeaderView.ClickTarget clickTarget, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            num = cardData.a;
        }
        if ((i & 2) != 0) {
            str = cardData.b;
        }
        if ((i & 4) != 0) {
            str2 = cardData.c;
        }
        if ((i & 8) != 0) {
            clickTarget = cardData.d;
        }
        if ((i & 16) != 0) {
            bool = cardData.e;
        }
        return cardData.copy(num, str, str2, clickTarget, bool);
    }

    @Nullable
    public final Integer component1() {
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
    public final ProfileHeaderView.ClickTarget component4() {
        return this.d;
    }

    @Nullable
    public final Boolean component5() {
        return this.e;
    }

    @NotNull
    public final CardData copy(@DrawableRes @Nullable Integer num, @Nullable String str, @Nullable String str2, @NotNull ProfileHeaderView.ClickTarget clickTarget, @Nullable Boolean bool) {
        Intrinsics.checkNotNullParameter(clickTarget, "clickTarget");
        return new CardData(num, str, str2, clickTarget, bool);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CardData)) {
            return false;
        }
        CardData cardData = (CardData) obj;
        return Intrinsics.areEqual(this.a, cardData.a) && Intrinsics.areEqual(this.b, cardData.b) && Intrinsics.areEqual(this.c, cardData.c) && Intrinsics.areEqual(this.d, cardData.d) && Intrinsics.areEqual(this.e, cardData.e);
    }

    @NotNull
    public final ProfileHeaderView.ClickTarget getClickTarget() {
        return this.d;
    }

    @Nullable
    public final Boolean getHasNotification() {
        return this.e;
    }

    @Nullable
    public final Integer getIcon() {
        return this.a;
    }

    @Nullable
    public final String getSubTitle() {
        return this.c;
    }

    @Nullable
    public final String getTitle() {
        return this.b;
    }

    public int hashCode() {
        Integer num = this.a;
        int i = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        String str = this.b;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.c;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        ProfileHeaderView.ClickTarget clickTarget = this.d;
        int hashCode4 = (hashCode3 + (clickTarget != null ? clickTarget.hashCode() : 0)) * 31;
        Boolean bool = this.e;
        if (bool != null) {
            i = bool.hashCode();
        }
        return hashCode4 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("CardData(icon=");
        L.append(this.a);
        L.append(", title=");
        L.append(this.b);
        L.append(", subTitle=");
        L.append(this.c);
        L.append(", clickTarget=");
        L.append(this.d);
        L.append(", hasNotification=");
        return a.o(L, this.e, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CardData(Integer num, String str, String str2, ProfileHeaderView.ClickTarget clickTarget, Boolean bool, int i, j jVar) {
        this(num, str, str2, clickTarget, (i & 16) != 0 ? null : bool);
    }
}
