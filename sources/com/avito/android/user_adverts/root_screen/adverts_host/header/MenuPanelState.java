package com.avito.android.user_adverts.root_screen.adverts_host.header;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/user_adverts/root_screen/adverts_host/header/MenuPanelState;", "", "<init>", "()V", "OneRowFullWidth", "OneRowTwoCards", "TwoRows", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/MenuPanelState$TwoRows;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/MenuPanelState$OneRowTwoCards;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/MenuPanelState$OneRowFullWidth;", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public abstract class MenuPanelState {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/avito/android/user_adverts/root_screen/adverts_host/header/MenuPanelState$OneRowFullWidth;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/MenuPanelState;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/CardState;", "component1", "()Lcom/avito/android/user_adverts/root_screen/adverts_host/header/CardState;", "data", "copy", "(Lcom/avito/android/user_adverts/root_screen/adverts_host/header/CardState;)Lcom/avito/android/user_adverts/root_screen/adverts_host/header/MenuPanelState$OneRowFullWidth;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/CardState;", "getData", "<init>", "(Lcom/avito/android/user_adverts/root_screen/adverts_host/header/CardState;)V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
    public static final class OneRowFullWidth extends MenuPanelState {
        @NotNull
        public final CardState a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public OneRowFullWidth(@NotNull CardState cardState) {
            super(null);
            Intrinsics.checkNotNullParameter(cardState, "data");
            this.a = cardState;
        }

        public static /* synthetic */ OneRowFullWidth copy$default(OneRowFullWidth oneRowFullWidth, CardState cardState, int i, Object obj) {
            if ((i & 1) != 0) {
                cardState = oneRowFullWidth.a;
            }
            return oneRowFullWidth.copy(cardState);
        }

        @NotNull
        public final CardState component1() {
            return this.a;
        }

        @NotNull
        public final OneRowFullWidth copy(@NotNull CardState cardState) {
            Intrinsics.checkNotNullParameter(cardState, "data");
            return new OneRowFullWidth(cardState);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof OneRowFullWidth) && Intrinsics.areEqual(this.a, ((OneRowFullWidth) obj).a);
            }
            return true;
        }

        @NotNull
        public final CardState getData() {
            return this.a;
        }

        public int hashCode() {
            CardState cardState = this.a;
            if (cardState != null) {
                return cardState.hashCode();
            }
            return 0;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("OneRowFullWidth(data=");
            L.append(this.a);
            L.append(")");
            return L.toString();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u0019\u0010\u0006\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0016\u001a\u0004\b\u0019\u0010\u0004¨\u0006\u001c"}, d2 = {"Lcom/avito/android/user_adverts/root_screen/adverts_host/header/MenuPanelState$OneRowTwoCards;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/MenuPanelState;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/CardState;", "component1", "()Lcom/avito/android/user_adverts/root_screen/adverts_host/header/CardState;", "component2", "leftCard", "rightCard", "copy", "(Lcom/avito/android/user_adverts/root_screen/adverts_host/header/CardState;Lcom/avito/android/user_adverts/root_screen/adverts_host/header/CardState;)Lcom/avito/android/user_adverts/root_screen/adverts_host/header/MenuPanelState$OneRowTwoCards;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/CardState;", "getRightCard", AuthSource.SEND_ABUSE, "getLeftCard", "<init>", "(Lcom/avito/android/user_adverts/root_screen/adverts_host/header/CardState;Lcom/avito/android/user_adverts/root_screen/adverts_host/header/CardState;)V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
    public static final class OneRowTwoCards extends MenuPanelState {
        @NotNull
        public final CardState a;
        @NotNull
        public final CardState b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public OneRowTwoCards(@NotNull CardState cardState, @NotNull CardState cardState2) {
            super(null);
            Intrinsics.checkNotNullParameter(cardState, "leftCard");
            Intrinsics.checkNotNullParameter(cardState2, "rightCard");
            this.a = cardState;
            this.b = cardState2;
        }

        public static /* synthetic */ OneRowTwoCards copy$default(OneRowTwoCards oneRowTwoCards, CardState cardState, CardState cardState2, int i, Object obj) {
            if ((i & 1) != 0) {
                cardState = oneRowTwoCards.a;
            }
            if ((i & 2) != 0) {
                cardState2 = oneRowTwoCards.b;
            }
            return oneRowTwoCards.copy(cardState, cardState2);
        }

        @NotNull
        public final CardState component1() {
            return this.a;
        }

        @NotNull
        public final CardState component2() {
            return this.b;
        }

        @NotNull
        public final OneRowTwoCards copy(@NotNull CardState cardState, @NotNull CardState cardState2) {
            Intrinsics.checkNotNullParameter(cardState, "leftCard");
            Intrinsics.checkNotNullParameter(cardState2, "rightCard");
            return new OneRowTwoCards(cardState, cardState2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OneRowTwoCards)) {
                return false;
            }
            OneRowTwoCards oneRowTwoCards = (OneRowTwoCards) obj;
            return Intrinsics.areEqual(this.a, oneRowTwoCards.a) && Intrinsics.areEqual(this.b, oneRowTwoCards.b);
        }

        @NotNull
        public final CardState getLeftCard() {
            return this.a;
        }

        @NotNull
        public final CardState getRightCard() {
            return this.b;
        }

        public int hashCode() {
            CardState cardState = this.a;
            int i = 0;
            int hashCode = (cardState != null ? cardState.hashCode() : 0) * 31;
            CardState cardState2 = this.b;
            if (cardState2 != null) {
                i = cardState2.hashCode();
            }
            return hashCode + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("OneRowTwoCards(leftCard=");
            L.append(this.a);
            L.append(", rightCard=");
            L.append(this.b);
            L.append(")");
            return L.toString();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J.\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0018\u001a\u0004\b\u001b\u0010\u0004R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0018\u001a\u0004\b\u001d\u0010\u0004¨\u0006 "}, d2 = {"Lcom/avito/android/user_adverts/root_screen/adverts_host/header/MenuPanelState$TwoRows;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/MenuPanelState;", "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/CardState;", "component1", "()Lcom/avito/android/user_adverts/root_screen/adverts_host/header/CardState;", "component2", "component3", "topCard", "leftCard", "rightCard", "copy", "(Lcom/avito/android/user_adverts/root_screen/adverts_host/header/CardState;Lcom/avito/android/user_adverts/root_screen/adverts_host/header/CardState;Lcom/avito/android/user_adverts/root_screen/adverts_host/header/CardState;)Lcom/avito/android/user_adverts/root_screen/adverts_host/header/MenuPanelState$TwoRows;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Lcom/avito/android/user_adverts/root_screen/adverts_host/header/CardState;", "getLeftCard", "c", "getRightCard", AuthSource.SEND_ABUSE, "getTopCard", "<init>", "(Lcom/avito/android/user_adverts/root_screen/adverts_host/header/CardState;Lcom/avito/android/user_adverts/root_screen/adverts_host/header/CardState;Lcom/avito/android/user_adverts/root_screen/adverts_host/header/CardState;)V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
    public static final class TwoRows extends MenuPanelState {
        @NotNull
        public final CardState a;
        @NotNull
        public final CardState b;
        @NotNull
        public final CardState c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public TwoRows(@NotNull CardState cardState, @NotNull CardState cardState2, @NotNull CardState cardState3) {
            super(null);
            Intrinsics.checkNotNullParameter(cardState, "topCard");
            Intrinsics.checkNotNullParameter(cardState2, "leftCard");
            Intrinsics.checkNotNullParameter(cardState3, "rightCard");
            this.a = cardState;
            this.b = cardState2;
            this.c = cardState3;
        }

        public static /* synthetic */ TwoRows copy$default(TwoRows twoRows, CardState cardState, CardState cardState2, CardState cardState3, int i, Object obj) {
            if ((i & 1) != 0) {
                cardState = twoRows.a;
            }
            if ((i & 2) != 0) {
                cardState2 = twoRows.b;
            }
            if ((i & 4) != 0) {
                cardState3 = twoRows.c;
            }
            return twoRows.copy(cardState, cardState2, cardState3);
        }

        @NotNull
        public final CardState component1() {
            return this.a;
        }

        @NotNull
        public final CardState component2() {
            return this.b;
        }

        @NotNull
        public final CardState component3() {
            return this.c;
        }

        @NotNull
        public final TwoRows copy(@NotNull CardState cardState, @NotNull CardState cardState2, @NotNull CardState cardState3) {
            Intrinsics.checkNotNullParameter(cardState, "topCard");
            Intrinsics.checkNotNullParameter(cardState2, "leftCard");
            Intrinsics.checkNotNullParameter(cardState3, "rightCard");
            return new TwoRows(cardState, cardState2, cardState3);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TwoRows)) {
                return false;
            }
            TwoRows twoRows = (TwoRows) obj;
            return Intrinsics.areEqual(this.a, twoRows.a) && Intrinsics.areEqual(this.b, twoRows.b) && Intrinsics.areEqual(this.c, twoRows.c);
        }

        @NotNull
        public final CardState getLeftCard() {
            return this.b;
        }

        @NotNull
        public final CardState getRightCard() {
            return this.c;
        }

        @NotNull
        public final CardState getTopCard() {
            return this.a;
        }

        public int hashCode() {
            CardState cardState = this.a;
            int i = 0;
            int hashCode = (cardState != null ? cardState.hashCode() : 0) * 31;
            CardState cardState2 = this.b;
            int hashCode2 = (hashCode + (cardState2 != null ? cardState2.hashCode() : 0)) * 31;
            CardState cardState3 = this.c;
            if (cardState3 != null) {
                i = cardState3.hashCode();
            }
            return hashCode2 + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("TwoRows(topCard=");
            L.append(this.a);
            L.append(", leftCard=");
            L.append(this.b);
            L.append(", rightCard=");
            L.append(this.c);
            L.append(")");
            return L.toString();
        }
    }

    public MenuPanelState() {
    }

    public MenuPanelState(j jVar) {
    }
}
