package com.avito.android.component.banner_card;

import a2.b.a.a.a;
import android.view.View;
import androidx.annotation.DrawableRes;
import com.avito.android.image_loader.Picture;
import com.avito.android.remote.auth.AuthSource;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001e\u001dJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\t\u001a\u00020\u00042\b\b\u0001\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\t\u0010\rJ\u001d\u0010\u0011\u001a\u00020\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH&¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0004H&¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001b\u001a\u00020\u00042\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0019H&¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/avito/android/component/banner_card/BannerCard;", "", "", "message", "", "setMessage", "(Ljava/lang/CharSequence;)V", "Lcom/avito/android/image_loader/Picture;", "picture", "setImage", "(Lcom/avito/android/image_loader/Picture;)V", "", "drawableRes", "(I)V", "", "Lcom/avito/android/component/banner_card/BannerCard$Action;", "actions", "setActions", "(Ljava/util/List;)V", "clearActionListeners", "()V", "", "visible", "setCloseButtonVisible", "(Z)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setCloseClickListener", "(Lkotlin/jvm/functions/Function0;)V", "Companion", "Action", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface BannerCard {
    @NotNull
    public static final Companion Companion = Companion.a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B!\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ.\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R!\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\bR\u001b\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004¨\u0006\u001f"}, d2 = {"Lcom/avito/android/component/banner_card/BannerCard$Action;", "", "", "component1", "()Ljava/lang/CharSequence;", "Lkotlin/Function0;", "", "component2", "()Lkotlin/jvm/functions/Function0;", "title", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "copy", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function0;)Lcom/avito/android/component/banner_card/BannerCard$Action;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Lkotlin/jvm/functions/Function0;", "getListener", AuthSource.SEND_ABUSE, "Ljava/lang/CharSequence;", "getTitle", "<init>", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function0;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
    public static final class Action {
        @Nullable
        public final CharSequence a;
        @Nullable
        public final Function0<Unit> b;

        public Action(@Nullable CharSequence charSequence, @Nullable Function0<Unit> function0) {
            this.a = charSequence;
            this.b = function0;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.component.banner_card.BannerCard$Action */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Action copy$default(Action action, CharSequence charSequence, Function0 function0, int i, Object obj) {
            if ((i & 1) != 0) {
                charSequence = action.a;
            }
            if ((i & 2) != 0) {
                function0 = action.b;
            }
            return action.copy(charSequence, function0);
        }

        @Nullable
        public final CharSequence component1() {
            return this.a;
        }

        @Nullable
        public final Function0<Unit> component2() {
            return this.b;
        }

        @NotNull
        public final Action copy(@Nullable CharSequence charSequence, @Nullable Function0<Unit> function0) {
            return new Action(charSequence, function0);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Action)) {
                return false;
            }
            Action action = (Action) obj;
            return Intrinsics.areEqual(this.a, action.a) && Intrinsics.areEqual(this.b, action.b);
        }

        @Nullable
        public final Function0<Unit> getListener() {
            return this.b;
        }

        @Nullable
        public final CharSequence getTitle() {
            return this.a;
        }

        public int hashCode() {
            CharSequence charSequence = this.a;
            int i = 0;
            int hashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
            Function0<Unit> function0 = this.b;
            if (function0 != null) {
                i = function0.hashCode();
            }
            return hashCode + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("Action(title=");
            L.append(this.a);
            L.append(", listener=");
            L.append(this.b);
            L.append(")");
            return L.toString();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/component/banner_card/BannerCard$Companion;", "", "Landroid/view/View;", "view", "Lcom/avito/android/component/banner_card/BannerCard;", "create", "(Landroid/view/View;)Lcom/avito/android/component/banner_card/BannerCard;", "<init>", "()V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public static final /* synthetic */ Companion a = new Companion();

        @NotNull
        public final BannerCard create(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            return new BannerCardImpl(view);
        }
    }

    void clearActionListeners();

    void setActions(@NotNull List<Action> list);

    void setCloseButtonVisible(boolean z);

    void setCloseClickListener(@Nullable Function0<Unit> function0);

    void setImage(@DrawableRes int i);

    void setImage(@Nullable Picture picture);

    void setMessage(@NotNull CharSequence charSequence);
}
