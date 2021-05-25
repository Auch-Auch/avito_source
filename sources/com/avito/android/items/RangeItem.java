package com.avito.android.items;

import androidx.core.app.NotificationCompat;
import com.avito.android.items.ItemWithState;
import com.avito.android.remote.auth.AuthSource;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u001b\u001cJF\u0010\f\u001a\u00020\u000b2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00022!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0005H\u0002¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u000e8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R*\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\t8\u0016@VX\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u0001\u0002\u001d\u001e¨\u0006\u001f"}, d2 = {"Lcom/avito/android/items/RangeItem;", "Lcom/avito/android/items/ItemWithState;", "", "", "textForInternalField", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", NotificationCompat.CATEGORY_MESSAGE, "Lcom/avito/android/items/ItemWithState$State;", "createState", "", AuthSource.SEND_ABUSE, "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)V", "Lcom/avito/android/items/InputItem;", "getFrom", "()Lcom/avito/android/items/InputItem;", "from", "getTo", "to", "value", "Lcom/avito/android/items/ItemWithState$State;", "getState", "()Lcom/avito/android/items/ItemWithState$State;", "setState", "(Lcom/avito/android/items/ItemWithState$State;)V", "state", "CommonRangeItem", "CreRangeItem", "Lcom/avito/android/items/RangeItem$CommonRangeItem;", "Lcom/avito/android/items/RangeItem$CreRangeItem;", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public abstract class RangeItem implements ItemWithState {
    @NotNull
    public ItemWithState.State a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\b\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b'\u0010(J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004JB\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u001c\u0010\u000b\u001a\u00020\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0007R\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001c\u0010\n\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\u0004R\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010!\u001a\u0004\b$\u0010\u0004R\u001c\u0010\f\u001a\u00020\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b%\u0010\u001c\u001a\u0004\b&\u0010\u0007¨\u0006)"}, d2 = {"Lcom/avito/android/items/RangeItem$CommonRangeItem;", "Lcom/avito/android/items/RangeItem;", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/items/InputItem;", "component2", "()Lcom/avito/android/items/InputItem;", "component3", "component5", "stringId", "from", "to", "Lcom/avito/android/items/ItemWithState$State;", "initialState", "title", "copy", "(Ljava/lang/String;Lcom/avito/android/items/InputItem;Lcom/avito/android/items/InputItem;Lcom/avito/android/items/ItemWithState$State;Ljava/lang/String;)Lcom/avito/android/items/RangeItem$CommonRangeItem;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "c", "Lcom/avito/android/items/InputItem;", "getFrom", "e", "Lcom/avito/android/items/ItemWithState$State;", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getStringId", "f", "getTitle", "d", "getTo", "<init>", "(Ljava/lang/String;Lcom/avito/android/items/InputItem;Lcom/avito/android/items/InputItem;Lcom/avito/android/items/ItemWithState$State;Ljava/lang/String;)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
    public static final class CommonRangeItem extends RangeItem {
        @NotNull
        public final String b;
        @NotNull
        public final InputItem c;
        @NotNull
        public final InputItem d;
        public final ItemWithState.State e;
        @NotNull
        public final String f;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ CommonRangeItem(String str, InputItem inputItem, InputItem inputItem2, ItemWithState.State state, String str2, int i, j jVar) {
            this(str, inputItem, inputItem2, (i & 8) != 0 ? new ItemWithState.State.Normal(null, 1, null) : state, str2);
        }

        public static /* synthetic */ CommonRangeItem copy$default(CommonRangeItem commonRangeItem, String str, InputItem inputItem, InputItem inputItem2, ItemWithState.State state, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = commonRangeItem.getStringId();
            }
            if ((i & 2) != 0) {
                inputItem = commonRangeItem.getFrom();
            }
            if ((i & 4) != 0) {
                inputItem2 = commonRangeItem.getTo();
            }
            if ((i & 8) != 0) {
                state = commonRangeItem.e;
            }
            if ((i & 16) != 0) {
                str2 = commonRangeItem.f;
            }
            return commonRangeItem.copy(str, inputItem, inputItem2, state, str2);
        }

        @NotNull
        public final String component1() {
            return getStringId();
        }

        @NotNull
        public final InputItem component2() {
            return getFrom();
        }

        @NotNull
        public final InputItem component3() {
            return getTo();
        }

        @NotNull
        public final String component5() {
            return this.f;
        }

        @NotNull
        public final CommonRangeItem copy(@NotNull String str, @NotNull InputItem inputItem, @NotNull InputItem inputItem2, @NotNull ItemWithState.State state, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, "stringId");
            Intrinsics.checkNotNullParameter(inputItem, "from");
            Intrinsics.checkNotNullParameter(inputItem2, "to");
            Intrinsics.checkNotNullParameter(state, "initialState");
            Intrinsics.checkNotNullParameter(str2, "title");
            return new CommonRangeItem(str, inputItem, inputItem2, state, str2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CommonRangeItem)) {
                return false;
            }
            CommonRangeItem commonRangeItem = (CommonRangeItem) obj;
            return Intrinsics.areEqual(getStringId(), commonRangeItem.getStringId()) && Intrinsics.areEqual(getFrom(), commonRangeItem.getFrom()) && Intrinsics.areEqual(getTo(), commonRangeItem.getTo()) && Intrinsics.areEqual(this.e, commonRangeItem.e) && Intrinsics.areEqual(this.f, commonRangeItem.f);
        }

        @Override // com.avito.android.items.RangeItem
        @NotNull
        public InputItem getFrom() {
            return this.c;
        }

        @Override // com.avito.conveyor_item.Item
        @NotNull
        public String getStringId() {
            return this.b;
        }

        @NotNull
        public final String getTitle() {
            return this.f;
        }

        @Override // com.avito.android.items.RangeItem
        @NotNull
        public InputItem getTo() {
            return this.d;
        }

        public int hashCode() {
            String stringId = getStringId();
            int i = 0;
            int hashCode = (stringId != null ? stringId.hashCode() : 0) * 31;
            InputItem from = getFrom();
            int hashCode2 = (hashCode + (from != null ? from.hashCode() : 0)) * 31;
            InputItem to = getTo();
            int hashCode3 = (hashCode2 + (to != null ? to.hashCode() : 0)) * 31;
            ItemWithState.State state = this.e;
            int hashCode4 = (hashCode3 + (state != null ? state.hashCode() : 0)) * 31;
            String str = this.f;
            if (str != null) {
                i = str.hashCode();
            }
            return hashCode4 + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("CommonRangeItem(stringId=");
            L.append(getStringId());
            L.append(", from=");
            L.append(getFrom());
            L.append(", to=");
            L.append(getTo());
            L.append(", initialState=");
            L.append(this.e);
            L.append(", title=");
            return a2.b.a.a.a.t(L, this.f, ")");
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CommonRangeItem(@NotNull String str, @NotNull InputItem inputItem, @NotNull InputItem inputItem2, @NotNull ItemWithState.State state, @NotNull String str2) {
            super(state, null);
            Intrinsics.checkNotNullParameter(str, "stringId");
            Intrinsics.checkNotNullParameter(inputItem, "from");
            Intrinsics.checkNotNullParameter(inputItem2, "to");
            Intrinsics.checkNotNullParameter(state, "initialState");
            Intrinsics.checkNotNullParameter(str2, "title");
            this.b = str;
            this.c = inputItem;
            this.d = inputItem2;
            this.e = state;
            this.f = str2;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\b\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0012\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\f¢\u0006\u0004\b-\u0010.J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJB\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\t2\b\b\u0002\u0010\u0013\u001a\u00020\fHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u0019\u0010\u0012\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u000bR\u001c\u0010\u0011\u001a\u00020\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\u0007R\u001c\u0010\u0010\u001a\u00020\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b%\u0010#\u001a\u0004\b&\u0010\u0007R\u001c\u0010\u000f\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010\u0004R\u0019\u0010\u0013\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010\u000e¨\u0006/"}, d2 = {"Lcom/avito/android/items/RangeItem$CreRangeItem;", "Lcom/avito/android/items/RangeItem;", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/items/InputItem;", "component2", "()Lcom/avito/android/items/InputItem;", "component3", "Lcom/avito/android/items/ItemWithState$State;", "component4", "()Lcom/avito/android/items/ItemWithState$State;", "Lcom/avito/android/items/CheckBoxItem;", "component5", "()Lcom/avito/android/items/CheckBoxItem;", "stringId", "from", "to", "initialState", "fromEnabler", "copy", "(Ljava/lang/String;Lcom/avito/android/items/InputItem;Lcom/avito/android/items/InputItem;Lcom/avito/android/items/ItemWithState$State;Lcom/avito/android/items/CheckBoxItem;)Lcom/avito/android/items/RangeItem$CreRangeItem;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "e", "Lcom/avito/android/items/ItemWithState$State;", "getInitialState", "d", "Lcom/avito/android/items/InputItem;", "getTo", "c", "getFrom", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getStringId", "f", "Lcom/avito/android/items/CheckBoxItem;", "getFromEnabler", "<init>", "(Ljava/lang/String;Lcom/avito/android/items/InputItem;Lcom/avito/android/items/InputItem;Lcom/avito/android/items/ItemWithState$State;Lcom/avito/android/items/CheckBoxItem;)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
    public static final class CreRangeItem extends RangeItem {
        @NotNull
        public final String b;
        @NotNull
        public final InputItem c;
        @NotNull
        public final InputItem d;
        @NotNull
        public final ItemWithState.State e;
        @NotNull
        public final CheckBoxItem f;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ CreRangeItem(String str, InputItem inputItem, InputItem inputItem2, ItemWithState.State state, CheckBoxItem checkBoxItem, int i, j jVar) {
            this(str, inputItem, inputItem2, (i & 8) != 0 ? new ItemWithState.State.Normal(null, 1, null) : state, checkBoxItem);
        }

        public static /* synthetic */ CreRangeItem copy$default(CreRangeItem creRangeItem, String str, InputItem inputItem, InputItem inputItem2, ItemWithState.State state, CheckBoxItem checkBoxItem, int i, Object obj) {
            if ((i & 1) != 0) {
                str = creRangeItem.getStringId();
            }
            if ((i & 2) != 0) {
                inputItem = creRangeItem.getFrom();
            }
            if ((i & 4) != 0) {
                inputItem2 = creRangeItem.getTo();
            }
            if ((i & 8) != 0) {
                state = creRangeItem.e;
            }
            if ((i & 16) != 0) {
                checkBoxItem = creRangeItem.f;
            }
            return creRangeItem.copy(str, inputItem, inputItem2, state, checkBoxItem);
        }

        @NotNull
        public final String component1() {
            return getStringId();
        }

        @NotNull
        public final InputItem component2() {
            return getFrom();
        }

        @NotNull
        public final InputItem component3() {
            return getTo();
        }

        @NotNull
        public final ItemWithState.State component4() {
            return this.e;
        }

        @NotNull
        public final CheckBoxItem component5() {
            return this.f;
        }

        @NotNull
        public final CreRangeItem copy(@NotNull String str, @NotNull InputItem inputItem, @NotNull InputItem inputItem2, @NotNull ItemWithState.State state, @NotNull CheckBoxItem checkBoxItem) {
            Intrinsics.checkNotNullParameter(str, "stringId");
            Intrinsics.checkNotNullParameter(inputItem, "from");
            Intrinsics.checkNotNullParameter(inputItem2, "to");
            Intrinsics.checkNotNullParameter(state, "initialState");
            Intrinsics.checkNotNullParameter(checkBoxItem, "fromEnabler");
            return new CreRangeItem(str, inputItem, inputItem2, state, checkBoxItem);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CreRangeItem)) {
                return false;
            }
            CreRangeItem creRangeItem = (CreRangeItem) obj;
            return Intrinsics.areEqual(getStringId(), creRangeItem.getStringId()) && Intrinsics.areEqual(getFrom(), creRangeItem.getFrom()) && Intrinsics.areEqual(getTo(), creRangeItem.getTo()) && Intrinsics.areEqual(this.e, creRangeItem.e) && Intrinsics.areEqual(this.f, creRangeItem.f);
        }

        @Override // com.avito.android.items.RangeItem
        @NotNull
        public InputItem getFrom() {
            return this.c;
        }

        @NotNull
        public final CheckBoxItem getFromEnabler() {
            return this.f;
        }

        @NotNull
        public final ItemWithState.State getInitialState() {
            return this.e;
        }

        @Override // com.avito.conveyor_item.Item
        @NotNull
        public String getStringId() {
            return this.b;
        }

        @Override // com.avito.android.items.RangeItem
        @NotNull
        public InputItem getTo() {
            return this.d;
        }

        public int hashCode() {
            String stringId = getStringId();
            int i = 0;
            int hashCode = (stringId != null ? stringId.hashCode() : 0) * 31;
            InputItem from = getFrom();
            int hashCode2 = (hashCode + (from != null ? from.hashCode() : 0)) * 31;
            InputItem to = getTo();
            int hashCode3 = (hashCode2 + (to != null ? to.hashCode() : 0)) * 31;
            ItemWithState.State state = this.e;
            int hashCode4 = (hashCode3 + (state != null ? state.hashCode() : 0)) * 31;
            CheckBoxItem checkBoxItem = this.f;
            if (checkBoxItem != null) {
                i = checkBoxItem.hashCode();
            }
            return hashCode4 + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("CreRangeItem(stringId=");
            L.append(getStringId());
            L.append(", from=");
            L.append(getFrom());
            L.append(", to=");
            L.append(getTo());
            L.append(", initialState=");
            L.append(this.e);
            L.append(", fromEnabler=");
            L.append(this.f);
            L.append(")");
            return L.toString();
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CreRangeItem(@NotNull String str, @NotNull InputItem inputItem, @NotNull InputItem inputItem2, @NotNull ItemWithState.State state, @NotNull CheckBoxItem checkBoxItem) {
            super(state, null);
            Intrinsics.checkNotNullParameter(str, "stringId");
            Intrinsics.checkNotNullParameter(inputItem, "from");
            Intrinsics.checkNotNullParameter(inputItem2, "to");
            Intrinsics.checkNotNullParameter(state, "initialState");
            Intrinsics.checkNotNullParameter(checkBoxItem, "fromEnabler");
            this.b = str;
            this.c = inputItem;
            this.d = inputItem2;
            this.e = state;
            this.f = checkBoxItem;
        }
    }

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function1<String, ItemWithState.State> {
        public static final a b = new a(0);
        public static final a c = new a(1);
        public final /* synthetic */ int a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i) {
            super(1);
            this.a = i;
        }

        @Override // kotlin.jvm.functions.Function1
        public final ItemWithState.State invoke(String str) {
            int i = this.a;
            if (i == 0) {
                String str2 = str;
                Intrinsics.checkNotNullParameter(str2, "it");
                return new ItemWithState.State.Error(str2, null, 2, null);
            } else if (i == 1) {
                String str3 = str;
                Intrinsics.checkNotNullParameter(str3, "it");
                return new ItemWithState.State.Warning(str3, null, 2, null);
            } else {
                throw null;
            }
        }
    }

    public RangeItem(ItemWithState.State state, j jVar) {
        this.a = state;
    }

    public final void a(Map<String, String> map, Function1<? super String, ? extends ItemWithState.State> function1) {
        ItemWithState.State state;
        ItemWithState.State state2;
        InputItem from = getFrom();
        String str = map.get("from");
        if (str == null || (state = (ItemWithState.State) function1.invoke(str)) == null) {
            state = new ItemWithState.State.Normal(null, 1, null);
        }
        from.setState(state);
        InputItem to = getTo();
        String str2 = map.get("to");
        if (str2 == null || (state2 = (ItemWithState.State) function1.invoke(str2)) == null) {
            state2 = new ItemWithState.State.Normal(null, 1, null);
        }
        to.setState(state2);
    }

    @NotNull
    public abstract InputItem getFrom();

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return ItemWithState.DefaultImpls.getId(this);
    }

    @Override // com.avito.android.items.ItemWithState
    @NotNull
    public ItemWithState.State getState() {
        return this.a;
    }

    @NotNull
    public abstract InputItem getTo();

    @Override // com.avito.android.items.ItemWithState
    public void setState(@NotNull ItemWithState.State state) {
        Intrinsics.checkNotNullParameter(state, "value");
        this.a = state;
        if (state instanceof ItemWithState.State.Error) {
            a(((ItemWithState.State.Error) state).getTextForInternalField(), a.b);
        } else if (state instanceof ItemWithState.State.Warning) {
            a(((ItemWithState.State.Warning) state).getTextForInternalField(), a.c);
        } else if (state instanceof ItemWithState.State.Normal) {
            getFrom().setState(new ItemWithState.State.Normal(null, 1, null));
            getTo().setState(new ItemWithState.State.Normal(null, 1, null));
        }
    }
}
