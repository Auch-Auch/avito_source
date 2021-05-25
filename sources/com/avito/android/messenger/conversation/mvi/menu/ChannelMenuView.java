package com.avito.android.messenger.conversation.mvi.menu;

import a2.b.a.a.a;
import androidx.annotation.DrawableRes;
import arrow.core.Option;
import com.avito.android.analytics.Event;
import com.avito.android.messenger.channels.mvi.common.v4.rendering.Renderer;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.messenger.ActionConfirmation;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
import t6.r.a.j;
import t6.y.f;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0005\n\u000b\f\r\u000eJ\u000f\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0004\u0010\u0005R\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView;", "Lcom/avito/android/messenger/channels/mvi/common/v4/rendering/Renderer;", "Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$State;", "", "destroyViews", "()V", "Lio/reactivex/Observable;", "getProfileClicks", "()Lio/reactivex/Observable;", "profileClicks", "DialogState", "Menu", "MenuAction", "Profile", "State", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface ChannelMenuView extends Renderer<State> {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void render(@NotNull ChannelMenuView channelMenuView, @NotNull State state) {
            Intrinsics.checkNotNullParameter(state, "state");
            Renderer.DefaultImpls.render(channelMenuView, state);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$DialogState;", "", "<init>", "()V", "Empty", BaseAnalyticKt.ANALYTIC_ACTION_SHOW, "Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$DialogState$Empty;", "Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$DialogState$Show;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class DialogState {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$DialogState$Empty;", "Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$DialogState;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Empty extends DialogState {
            @NotNull
            public static final Empty INSTANCE = new Empty();

            public Empty() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001BE\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0004\b\u001b\u0010\u001cR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0019\u0010\u0016¨\u0006\u001d"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$DialogState$Show;", "Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$DialogState;", "", "e", "Ljava/lang/String;", "getNegativeButtonText", "()Ljava/lang/String;", "negativeButtonText", AuthSource.SEND_ABUSE, "getTitle", "title", "c", "getPositiveButtonText", "positiveButtonText", AuthSource.BOOKING_ORDER, "getMessage", "message", "Lkotlin/Function0;", "", "f", "Lkotlin/jvm/functions/Function0;", "getNegativeButtonListener", "()Lkotlin/jvm/functions/Function0;", "negativeButtonListener", "d", "getPositiveButtonListener", "positiveButtonListener", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Show extends DialogState {
            @Nullable
            public final String a;
            @NotNull
            public final String b;
            @NotNull
            public final String c;
            @NotNull
            public final Function0<Unit> d;
            @NotNull
            public final String e;
            @NotNull
            public final Function0<Unit> f;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Show(@Nullable String str, @NotNull String str2, @NotNull String str3, @NotNull Function0<Unit> function0, @NotNull String str4, @NotNull Function0<Unit> function02) {
                super(null);
                Intrinsics.checkNotNullParameter(str2, "message");
                Intrinsics.checkNotNullParameter(str3, "positiveButtonText");
                Intrinsics.checkNotNullParameter(function0, "positiveButtonListener");
                Intrinsics.checkNotNullParameter(str4, "negativeButtonText");
                Intrinsics.checkNotNullParameter(function02, "negativeButtonListener");
                this.a = str;
                this.b = str2;
                this.c = str3;
                this.d = function0;
                this.e = str4;
                this.f = function02;
            }

            @NotNull
            public final String getMessage() {
                return this.b;
            }

            @NotNull
            public final Function0<Unit> getNegativeButtonListener() {
                return this.f;
            }

            @NotNull
            public final String getNegativeButtonText() {
                return this.e;
            }

            @NotNull
            public final Function0<Unit> getPositiveButtonListener() {
                return this.d;
            }

            @NotNull
            public final String getPositiveButtonText() {
                return this.c;
            }

            @Nullable
            public final String getTitle() {
                return this.a;
            }
        }

        public DialogState() {
        }

        public DialogState(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001:\u0001 BL\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017\u0012#\b\u0002\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\f¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u001f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR4\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006!"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$Menu;", "", "", "toString", "()Ljava/lang/String;", "Larrow/core/Option;", "Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$Profile;", AuthSource.SEND_ABUSE, "Larrow/core/Option;", "getProfile", "()Larrow/core/Option;", "profile", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", VKApiConst.POSITION, "", "c", "Lkotlin/jvm/functions/Function1;", "getListener", "()Lkotlin/jvm/functions/Function1;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$MenuAction;", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "getActions", "()Ljava/util/List;", "actions", "<init>", "(Larrow/core/Option;Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "Empty", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static class Menu {
        @NotNull
        public final Option<Profile> a;
        @NotNull
        public final List<MenuAction> b;
        @NotNull
        public final Function1<Integer, Unit> c;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$Menu$Empty;", "Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$Menu;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Empty extends Menu {
            @NotNull
            public static final Empty INSTANCE = new Empty();

            public Empty() {
                super(null, null, null, 7, null);
            }
        }

        public static final class a extends Lambda implements Function1<Integer, Unit> {
            public static final a a = new a();

            public a() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Integer num) {
                num.intValue();
                return Unit.INSTANCE;
            }
        }

        public Menu() {
            this(null, null, null, 7, null);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: arrow.core.Option<? extends com.avito.android.messenger.conversation.mvi.menu.ChannelMenuView$Profile> */
        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> */
        /* JADX WARN: Multi-variable type inference failed */
        public Menu(@NotNull Option<? extends Profile> option, @NotNull List<MenuAction> list, @NotNull Function1<? super Integer, Unit> function1) {
            Intrinsics.checkNotNullParameter(option, "profile");
            Intrinsics.checkNotNullParameter(list, "actions");
            Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            this.a = option;
            this.b = list;
            this.c = function1;
        }

        @NotNull
        public final List<MenuAction> getActions() {
            return this.b;
        }

        @NotNull
        public final Function1<Integer, Unit> getListener() {
            return this.c;
        }

        @NotNull
        public final Option<Profile> getProfile() {
            return this.a;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("Menu(\n                    |   profile=");
            L.append(this.a);
            L.append(",\n                    |   actions=");
            return f.trimMargin$default(a2.b.a.a.a.w(L, this.b, "\n                    |)"), null, 1, null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Menu(Option option, List list, Function1 function1, int i, j jVar) {
            this((i & 1) != 0 ? Option.Companion.empty() : option, (i & 2) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i & 4) != 0 ? a.a : function1);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0013\b\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b+\u0010,J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0007JJ\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004J\u0010\u0010\u0017\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u0007R\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\u0004R\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\rR\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010\u001e\u001a\u0004\b'\u0010\u0007R\u001b\u0010\u0011\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010\n¨\u0006-"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$MenuAction;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/lang/Integer;", "Lcom/avito/android/remote/model/messenger/ActionConfirmation;", "component3", "()Lcom/avito/android/remote/model/messenger/ActionConfirmation;", "Lcom/avito/android/analytics/Event;", "component4", "()Lcom/avito/android/analytics/Event;", "component5", "title", "drawableId", "confirmation", "analyticEvent", "labelIconId", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/avito/android/remote/model/messenger/ActionConfirmation;Lcom/avito/android/analytics/Event;Ljava/lang/Integer;)Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$MenuAction;", "toString", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/lang/Integer;", "getDrawableId", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getTitle", "d", "Lcom/avito/android/analytics/Event;", "getAnalyticEvent", "e", "getLabelIconId", "c", "Lcom/avito/android/remote/model/messenger/ActionConfirmation;", "getConfirmation", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/avito/android/remote/model/messenger/ActionConfirmation;Lcom/avito/android/analytics/Event;Ljava/lang/Integer;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class MenuAction {
        @NotNull
        public final String a;
        @Nullable
        public final Integer b;
        @Nullable
        public final ActionConfirmation c;
        @Nullable
        public final Event d;
        @Nullable
        public final Integer e;

        public MenuAction(@NotNull String str, @DrawableRes @Nullable Integer num, @Nullable ActionConfirmation actionConfirmation, @Nullable Event event, @DrawableRes @Nullable Integer num2) {
            Intrinsics.checkNotNullParameter(str, "title");
            this.a = str;
            this.b = num;
            this.c = actionConfirmation;
            this.d = event;
            this.e = num2;
        }

        public static /* synthetic */ MenuAction copy$default(MenuAction menuAction, String str, Integer num, ActionConfirmation actionConfirmation, Event event, Integer num2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = menuAction.a;
            }
            if ((i & 2) != 0) {
                num = menuAction.b;
            }
            if ((i & 4) != 0) {
                actionConfirmation = menuAction.c;
            }
            if ((i & 8) != 0) {
                event = menuAction.d;
            }
            if ((i & 16) != 0) {
                num2 = menuAction.e;
            }
            return menuAction.copy(str, num, actionConfirmation, event, num2);
        }

        @NotNull
        public final String component1() {
            return this.a;
        }

        @Nullable
        public final Integer component2() {
            return this.b;
        }

        @Nullable
        public final ActionConfirmation component3() {
            return this.c;
        }

        @Nullable
        public final Event component4() {
            return this.d;
        }

        @Nullable
        public final Integer component5() {
            return this.e;
        }

        @NotNull
        public final MenuAction copy(@NotNull String str, @DrawableRes @Nullable Integer num, @Nullable ActionConfirmation actionConfirmation, @Nullable Event event, @DrawableRes @Nullable Integer num2) {
            Intrinsics.checkNotNullParameter(str, "title");
            return new MenuAction(str, num, actionConfirmation, event, num2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MenuAction)) {
                return false;
            }
            MenuAction menuAction = (MenuAction) obj;
            return Intrinsics.areEqual(this.a, menuAction.a) && Intrinsics.areEqual(this.b, menuAction.b) && Intrinsics.areEqual(this.c, menuAction.c) && Intrinsics.areEqual(this.d, menuAction.d) && Intrinsics.areEqual(this.e, menuAction.e);
        }

        @Nullable
        public final Event getAnalyticEvent() {
            return this.d;
        }

        @Nullable
        public final ActionConfirmation getConfirmation() {
            return this.c;
        }

        @Nullable
        public final Integer getDrawableId() {
            return this.b;
        }

        @Nullable
        public final Integer getLabelIconId() {
            return this.e;
        }

        @NotNull
        public final String getTitle() {
            return this.a;
        }

        public int hashCode() {
            String str = this.a;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            Integer num = this.b;
            int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
            ActionConfirmation actionConfirmation = this.c;
            int hashCode3 = (hashCode2 + (actionConfirmation != null ? actionConfirmation.hashCode() : 0)) * 31;
            Event event = this.d;
            int hashCode4 = (hashCode3 + (event != null ? event.hashCode() : 0)) * 31;
            Integer num2 = this.e;
            if (num2 != null) {
                i = num2.hashCode();
            }
            return hashCode4 + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("MenuAction(title=");
            L.append(this.a);
            L.append(", drawableId=");
            L.append(this.b);
            L.append(", confirmation=");
            L.append(this.c);
            L.append(", analyticEvent=");
            L.append(this.d);
            L.append(", labelIconId=");
            return a.p(L, this.e, ")");
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ MenuAction(String str, Integer num, ActionConfirmation actionConfirmation, Event event, Integer num2, int i, j jVar) {
            this(str, num, actionConfirmation, (i & 8) != 0 ? null : event, (i & 16) != 0 ? null : num2);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0012\u0013B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u00020\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u0001\u0002\u0014\u0015¨\u0006\u0016"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$Profile;", "", "Lcom/avito/android/remote/model/Image;", "getAvatar", "()Lcom/avito/android/remote/model/Image;", "avatar", "", "getUserId", "()Ljava/lang/String;", ChannelContext.Item.USER_ID, "getName", "name", "Lcom/avito/android/remote/model/Action;", "getAction", "()Lcom/avito/android/remote/model/Action;", "action", "<init>", "()V", "System", "User", "Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$Profile$User;", "Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$Profile$System;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class Profile {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0006\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b \u0010\u0014\u001a\u0004\b!\u0010\u0004R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010\u0014\u001a\u0004\b#\u0010\u0004¨\u0006&"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$Profile$System;", "Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$Profile;", "", "component1", "()Ljava/lang/String;", "component2", "name", "description", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$Profile$System;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", ChannelContext.Item.USER_ID, "Ljava/lang/String;", "getUserId", "Lcom/avito/android/remote/model/Image;", "avatar", "Lcom/avito/android/remote/model/Image;", "getAvatar", "()Lcom/avito/android/remote/model/Image;", "Lcom/avito/android/remote/model/Action;", "action", "Lcom/avito/android/remote/model/Action;", "getAction", "()Lcom/avito/android/remote/model/Action;", AuthSource.SEND_ABUSE, "getName", AuthSource.BOOKING_ORDER, "getDescription", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class System extends Profile {
            @NotNull
            public final String a;
            @NotNull
            public final String b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public System(@NotNull String str, @NotNull String str2) {
                super(null);
                Intrinsics.checkNotNullParameter(str, "name");
                Intrinsics.checkNotNullParameter(str2, "description");
                this.a = str;
                this.b = str2;
            }

            public static /* synthetic */ System copy$default(System system, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = system.getName();
                }
                if ((i & 2) != 0) {
                    str2 = system.b;
                }
                return system.copy(str, str2);
            }

            @NotNull
            public final String component1() {
                return getName();
            }

            @NotNull
            public final String component2() {
                return this.b;
            }

            @NotNull
            public final System copy(@NotNull String str, @NotNull String str2) {
                Intrinsics.checkNotNullParameter(str, "name");
                Intrinsics.checkNotNullParameter(str2, "description");
                return new System(str, str2);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof System)) {
                    return false;
                }
                System system = (System) obj;
                return Intrinsics.areEqual(getName(), system.getName()) && Intrinsics.areEqual(this.b, system.b);
            }

            @Override // com.avito.android.messenger.conversation.mvi.menu.ChannelMenuView.Profile
            @Nullable
            public Action getAction() {
                return null;
            }

            @Override // com.avito.android.messenger.conversation.mvi.menu.ChannelMenuView.Profile
            @Nullable
            public Image getAvatar() {
                return null;
            }

            @NotNull
            public final String getDescription() {
                return this.b;
            }

            @Override // com.avito.android.messenger.conversation.mvi.menu.ChannelMenuView.Profile
            @NotNull
            public String getName() {
                return this.a;
            }

            @Override // com.avito.android.messenger.conversation.mvi.menu.ChannelMenuView.Profile
            @Nullable
            public String getUserId() {
                return null;
            }

            public int hashCode() {
                String name = getName();
                int i = 0;
                int hashCode = (name != null ? name.hashCode() : 0) * 31;
                String str = this.b;
                if (str != null) {
                    i = str.hashCode();
                }
                return hashCode + i;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("System(name=");
                L.append(getName());
                L.append(", description=");
                return a.t(L, this.b, ")");
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b&\u0010'J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J>\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u001c\u0010\f\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001c\u001a\u0004\b\u001f\u0010\u0004R\u001e\u0010\r\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\u0007R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\n¨\u0006("}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$Profile$User;", "Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$Profile;", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/Image;", "component2", "()Lcom/avito/android/remote/model/Image;", "Lcom/avito/android/remote/model/Action;", "component3", "()Lcom/avito/android/remote/model/Action;", "component4", "name", "avatar", "action", ChannelContext.Item.USER_ID, "copy", "(Ljava/lang/String;Lcom/avito/android/remote/model/Image;Lcom/avito/android/remote/model/Action;Ljava/lang/String;)Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$Profile$User;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "d", "Ljava/lang/String;", "getUserId", AuthSource.SEND_ABUSE, "getName", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/Image;", "getAvatar", "c", "Lcom/avito/android/remote/model/Action;", "getAction", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/Image;Lcom/avito/android/remote/model/Action;Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class User extends Profile {
            @NotNull
            public final String a;
            @Nullable
            public final Image b;
            @Nullable
            public final Action c;
            @Nullable
            public final String d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public User(@NotNull String str, @Nullable Image image, @Nullable Action action, @Nullable String str2) {
                super(null);
                Intrinsics.checkNotNullParameter(str, "name");
                this.a = str;
                this.b = image;
                this.c = action;
                this.d = str2;
            }

            public static /* synthetic */ User copy$default(User user, String str, Image image, Action action, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = user.getName();
                }
                if ((i & 2) != 0) {
                    image = user.getAvatar();
                }
                if ((i & 4) != 0) {
                    action = user.getAction();
                }
                if ((i & 8) != 0) {
                    str2 = user.getUserId();
                }
                return user.copy(str, image, action, str2);
            }

            @NotNull
            public final String component1() {
                return getName();
            }

            @Nullable
            public final Image component2() {
                return getAvatar();
            }

            @Nullable
            public final Action component3() {
                return getAction();
            }

            @Nullable
            public final String component4() {
                return getUserId();
            }

            @NotNull
            public final User copy(@NotNull String str, @Nullable Image image, @Nullable Action action, @Nullable String str2) {
                Intrinsics.checkNotNullParameter(str, "name");
                return new User(str, image, action, str2);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof User)) {
                    return false;
                }
                User user = (User) obj;
                return Intrinsics.areEqual(getName(), user.getName()) && Intrinsics.areEqual(getAvatar(), user.getAvatar()) && Intrinsics.areEqual(getAction(), user.getAction()) && Intrinsics.areEqual(getUserId(), user.getUserId());
            }

            @Override // com.avito.android.messenger.conversation.mvi.menu.ChannelMenuView.Profile
            @Nullable
            public Action getAction() {
                return this.c;
            }

            @Override // com.avito.android.messenger.conversation.mvi.menu.ChannelMenuView.Profile
            @Nullable
            public Image getAvatar() {
                return this.b;
            }

            @Override // com.avito.android.messenger.conversation.mvi.menu.ChannelMenuView.Profile
            @NotNull
            public String getName() {
                return this.a;
            }

            @Override // com.avito.android.messenger.conversation.mvi.menu.ChannelMenuView.Profile
            @Nullable
            public String getUserId() {
                return this.d;
            }

            public int hashCode() {
                String name = getName();
                int i = 0;
                int hashCode = (name != null ? name.hashCode() : 0) * 31;
                Image avatar = getAvatar();
                int hashCode2 = (hashCode + (avatar != null ? avatar.hashCode() : 0)) * 31;
                Action action = getAction();
                int hashCode3 = (hashCode2 + (action != null ? action.hashCode() : 0)) * 31;
                String userId = getUserId();
                if (userId != null) {
                    i = userId.hashCode();
                }
                return hashCode3 + i;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("User(name=");
                L.append(getName());
                L.append(", avatar=");
                L.append(getAvatar());
                L.append(", action=");
                L.append(getAction());
                L.append(", userId=");
                L.append(getUserId());
                L.append(")");
                return L.toString();
            }
        }

        public Profile() {
        }

        @Nullable
        public abstract Action getAction();

        @Nullable
        public abstract Image getAvatar();

        @NotNull
        public abstract String getName();

        @Nullable
        public abstract String getUserId();

        public Profile(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\f\r\u000eB\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u0001\u0003\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$State;", "", "Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$Menu;", "getMenu", "()Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$Menu;", "menu", "Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$DialogState;", "getDialogState", "()Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$DialogState;", "dialogState", "<init>", "()V", "Empty", "Hidden", "Shown", "Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$State$Empty;", "Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$State$Hidden;", "Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$State$Shown;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class State {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00028V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$State$Empty;", "Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$State;", "Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$DialogState;", "getDialogState", "()Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$DialogState;", "dialogState", "Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$Menu;", "getMenu", "()Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$Menu;", "menu", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Empty extends State {
            @NotNull
            public static final Empty INSTANCE = new Empty();

            public Empty() {
                super(null);
            }

            @Override // com.avito.android.messenger.conversation.mvi.menu.ChannelMenuView.State
            @NotNull
            public DialogState getDialogState() {
                return DialogState.Empty.INSTANCE;
            }

            @Override // com.avito.android.messenger.conversation.mvi.menu.ChannelMenuView.State
            @NotNull
            public Menu getMenu() {
                return Menu.Empty.INSTANCE;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000f\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b#\u0010$J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ.\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u001c\u0010\f\u001a\u00020\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0007R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\nR\u001c\u0010\u000b\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\u0004¨\u0006%"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$State$Hidden;", "Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$State;", "Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$Menu;", "component1", "()Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$Menu;", "Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$DialogState;", "component2", "()Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$DialogState;", "", "component3", "()Z", "menu", "dialogState", "canBlockWithReasons", "copy", "(Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$Menu;Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$DialogState;Z)Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$State$Hidden;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$DialogState;", "getDialogState", "c", "Z", "getCanBlockWithReasons", AuthSource.SEND_ABUSE, "Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$Menu;", "getMenu", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$Menu;Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$DialogState;Z)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Hidden extends State {
            @NotNull
            public final Menu a;
            @NotNull
            public final DialogState b;
            public final boolean c;

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Hidden(Menu menu, DialogState dialogState, boolean z, int i, j jVar) {
                this(menu, (i & 2) != 0 ? DialogState.Empty.INSTANCE : dialogState, z);
            }

            public static /* synthetic */ Hidden copy$default(Hidden hidden, Menu menu, DialogState dialogState, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    menu = hidden.getMenu();
                }
                if ((i & 2) != 0) {
                    dialogState = hidden.getDialogState();
                }
                if ((i & 4) != 0) {
                    z = hidden.c;
                }
                return hidden.copy(menu, dialogState, z);
            }

            @NotNull
            public final Menu component1() {
                return getMenu();
            }

            @NotNull
            public final DialogState component2() {
                return getDialogState();
            }

            public final boolean component3() {
                return this.c;
            }

            @NotNull
            public final Hidden copy(@NotNull Menu menu, @NotNull DialogState dialogState, boolean z) {
                Intrinsics.checkNotNullParameter(menu, "menu");
                Intrinsics.checkNotNullParameter(dialogState, "dialogState");
                return new Hidden(menu, dialogState, z);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Hidden)) {
                    return false;
                }
                Hidden hidden = (Hidden) obj;
                return Intrinsics.areEqual(getMenu(), hidden.getMenu()) && Intrinsics.areEqual(getDialogState(), hidden.getDialogState()) && this.c == hidden.c;
            }

            public final boolean getCanBlockWithReasons() {
                return this.c;
            }

            @Override // com.avito.android.messenger.conversation.mvi.menu.ChannelMenuView.State
            @NotNull
            public DialogState getDialogState() {
                return this.b;
            }

            @Override // com.avito.android.messenger.conversation.mvi.menu.ChannelMenuView.State
            @NotNull
            public Menu getMenu() {
                return this.a;
            }

            public int hashCode() {
                Menu menu = getMenu();
                int i = 0;
                int hashCode = (menu != null ? menu.hashCode() : 0) * 31;
                DialogState dialogState = getDialogState();
                if (dialogState != null) {
                    i = dialogState.hashCode();
                }
                int i2 = (hashCode + i) * 31;
                boolean z = this.c;
                if (z) {
                    z = true;
                }
                int i3 = z ? 1 : 0;
                int i4 = z ? 1 : 0;
                int i5 = z ? 1 : 0;
                return i2 + i3;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("Hidden(menu=");
                L.append(getMenu());
                L.append(", dialogState=");
                L.append(getDialogState());
                L.append(", canBlockWithReasons=");
                return a.B(L, this.c, ")");
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Hidden(@NotNull Menu menu, @NotNull DialogState dialogState, boolean z) {
                super(null);
                Intrinsics.checkNotNullParameter(menu, "menu");
                Intrinsics.checkNotNullParameter(dialogState, "dialogState");
                this.a = menu;
                this.b = dialogState;
                this.c = z;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b(\u0010)J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ4\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\b2\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u0019\u0010\u0010\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\nR\u0016\u0010!\u001a\u00020\u001e8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u001f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\u000eR\u001c\u0010\u000f\u001a\u00020\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\u0007¨\u0006*"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$State$Shown;", "Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$State;", "", "toString", "()Ljava/lang/String;", "Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$Menu;", "component1", "()Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$Menu;", "", "component2", "()Z", "Lkotlin/Function0;", "", "component3", "()Lkotlin/jvm/functions/Function0;", "menu", "canBlockWithReasons", "closeListener", "copy", "(Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$Menu;ZLkotlin/jvm/functions/Function0;)Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$State$Shown;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Z", "getCanBlockWithReasons", "Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$DialogState;", "getDialogState", "()Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$DialogState;", "dialogState", "c", "Lkotlin/jvm/functions/Function0;", "getCloseListener", AuthSource.SEND_ABUSE, "Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$Menu;", "getMenu", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/menu/ChannelMenuView$Menu;ZLkotlin/jvm/functions/Function0;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Shown extends State {
            @NotNull
            public final Menu a;
            public final boolean b;
            @NotNull
            public final Function0<Unit> c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Shown(@NotNull Menu menu, boolean z, @NotNull Function0<Unit> function0) {
                super(null);
                Intrinsics.checkNotNullParameter(menu, "menu");
                Intrinsics.checkNotNullParameter(function0, "closeListener");
                this.a = menu;
                this.b = z;
                this.c = function0;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.messenger.conversation.mvi.menu.ChannelMenuView$State$Shown */
            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Shown copy$default(Shown shown, Menu menu, boolean z, Function0 function0, int i, Object obj) {
                if ((i & 1) != 0) {
                    menu = shown.getMenu();
                }
                if ((i & 2) != 0) {
                    z = shown.b;
                }
                if ((i & 4) != 0) {
                    function0 = shown.c;
                }
                return shown.copy(menu, z, function0);
            }

            @NotNull
            public final Menu component1() {
                return getMenu();
            }

            public final boolean component2() {
                return this.b;
            }

            @NotNull
            public final Function0<Unit> component3() {
                return this.c;
            }

            @NotNull
            public final Shown copy(@NotNull Menu menu, boolean z, @NotNull Function0<Unit> function0) {
                Intrinsics.checkNotNullParameter(menu, "menu");
                Intrinsics.checkNotNullParameter(function0, "closeListener");
                return new Shown(menu, z, function0);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Shown)) {
                    return false;
                }
                Shown shown = (Shown) obj;
                return Intrinsics.areEqual(getMenu(), shown.getMenu()) && this.b == shown.b && Intrinsics.areEqual(this.c, shown.c);
            }

            public final boolean getCanBlockWithReasons() {
                return this.b;
            }

            @NotNull
            public final Function0<Unit> getCloseListener() {
                return this.c;
            }

            @Override // com.avito.android.messenger.conversation.mvi.menu.ChannelMenuView.State
            @NotNull
            public DialogState getDialogState() {
                return DialogState.Empty.INSTANCE;
            }

            @Override // com.avito.android.messenger.conversation.mvi.menu.ChannelMenuView.State
            @NotNull
            public Menu getMenu() {
                return this.a;
            }

            public int hashCode() {
                Menu menu = getMenu();
                int i = 0;
                int hashCode = (menu != null ? menu.hashCode() : 0) * 31;
                boolean z = this.b;
                if (z) {
                    z = true;
                }
                int i2 = z ? 1 : 0;
                int i3 = z ? 1 : 0;
                int i4 = z ? 1 : 0;
                int i5 = (hashCode + i2) * 31;
                Function0<Unit> function0 = this.c;
                if (function0 != null) {
                    i = function0.hashCode();
                }
                return i5 + i;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("State.Shown(menu = ");
                L.append(getMenu());
                L.append(')');
                return L.toString();
            }
        }

        public State() {
        }

        @NotNull
        public abstract DialogState getDialogState();

        @NotNull
        public abstract Menu getMenu();

        public State(j jVar) {
        }
    }

    void destroyViews();

    @NotNull
    Observable<Unit> getProfileClicks();
}
