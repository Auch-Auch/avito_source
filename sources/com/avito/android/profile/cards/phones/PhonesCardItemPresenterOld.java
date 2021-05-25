package com.avito.android.profile.cards.phones;

import a2.b.a.a.a;
import com.avito.android.profile.cards.CardItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.user_profile.Phone;
import com.avito.konveyor.blueprint.ItemPresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/profile/cards/phones/PhonesCardItemPresenterOld;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/profile/cards/phones/PhonesCardItemViewOld;", "Lcom/avito/android/profile/cards/CardItem$PhonesCardItem;", "Action", "profile_release"}, k = 1, mv = {1, 4, 2})
public interface PhonesCardItemPresenterOld extends ItemPresenter<PhonesCardItemViewOld, CardItem.PhonesCardItem> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0004J\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007¨\u0006\u001c"}, d2 = {"Lcom/avito/android/profile/cards/phones/PhonesCardItemPresenterOld$Action;", "", "", "component1", "()I", "Lcom/avito/android/remote/model/user_profile/Phone;", "component2", "()Lcom/avito/android/remote/model/user_profile/Phone;", "action", "phone", "copy", "(ILcom/avito/android/remote/model/user_profile/Phone;)Lcom/avito/android/profile/cards/phones/PhonesCardItemPresenterOld$Action;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "I", "getAction", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/user_profile/Phone;", "getPhone", "<init>", "(ILcom/avito/android/remote/model/user_profile/Phone;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class Action {
        public final int a;
        @NotNull
        public final Phone b;

        public Action(int i, @NotNull Phone phone) {
            Intrinsics.checkNotNullParameter(phone, "phone");
            this.a = i;
            this.b = phone;
        }

        public static /* synthetic */ Action copy$default(Action action, int i, Phone phone, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = action.a;
            }
            if ((i2 & 2) != 0) {
                phone = action.b;
            }
            return action.copy(i, phone);
        }

        public final int component1() {
            return this.a;
        }

        @NotNull
        public final Phone component2() {
            return this.b;
        }

        @NotNull
        public final Action copy(int i, @NotNull Phone phone) {
            Intrinsics.checkNotNullParameter(phone, "phone");
            return new Action(i, phone);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Action)) {
                return false;
            }
            Action action = (Action) obj;
            return this.a == action.a && Intrinsics.areEqual(this.b, action.b);
        }

        public final int getAction() {
            return this.a;
        }

        @NotNull
        public final Phone getPhone() {
            return this.b;
        }

        public int hashCode() {
            int i = this.a * 31;
            Phone phone = this.b;
            return i + (phone != null ? phone.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("Action(action=");
            L.append(this.a);
            L.append(", phone=");
            L.append(this.b);
            L.append(")");
            return L.toString();
        }
    }
}
