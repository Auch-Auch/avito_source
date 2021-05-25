package com.avito.android.messenger.connection_indicator;

import android.view.View;
import com.avito.android.messenger.channels.mvi.common.v1.Renderer;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u00032\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0003\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/messenger/connection_indicator/ConnectionErrorIndicatorView;", "Lcom/avito/android/messenger/channels/mvi/common/v1/Renderer;", "Lcom/avito/android/messenger/connection_indicator/ConnectionErrorIndicatorView$State;", "Companion", "State", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface ConnectionErrorIndicatorView extends Renderer<State> {
    @NotNull
    public static final Companion Companion = Companion.a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/messenger/connection_indicator/ConnectionErrorIndicatorView$Companion;", "", "Landroid/view/View;", "rootView", "Lcom/avito/android/messenger/connection_indicator/ConnectionErrorIndicatorView;", "create", "(Landroid/view/View;)Lcom/avito/android/messenger/connection_indicator/ConnectionErrorIndicatorView;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public static final /* synthetic */ Companion a = new Companion();

        @NotNull
        public final ConnectionErrorIndicatorView create(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "rootView");
            return new ConnectionErrorIndicatorViewImpl(view);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/messenger/connection_indicator/ConnectionErrorIndicatorView$State;", "", "<init>", "()V", "Hidden", "Shown", "Lcom/avito/android/messenger/connection_indicator/ConnectionErrorIndicatorView$State$Hidden;", "Lcom/avito/android/messenger/connection_indicator/ConnectionErrorIndicatorView$State$Shown;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class State {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/messenger/connection_indicator/ConnectionErrorIndicatorView$State$Hidden;", "Lcom/avito/android/messenger/connection_indicator/ConnectionErrorIndicatorView$State;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Hidden extends State {
            @NotNull
            public static final Hidden INSTANCE = new Hidden();

            public Hidden() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\b\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u0001\u0002\n\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/messenger/connection_indicator/ConnectionErrorIndicatorView$State$Shown;", "Lcom/avito/android/messenger/connection_indicator/ConnectionErrorIndicatorView$State;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "message", "Error", "InProgress", "Lcom/avito/android/messenger/connection_indicator/ConnectionErrorIndicatorView$State$Shown$Error;", "Lcom/avito/android/messenger/connection_indicator/ConnectionErrorIndicatorView$State$Shown$InProgress;", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static abstract class Shown extends State {
            @NotNull
            public final String a;

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/avito/android/messenger/connection_indicator/ConnectionErrorIndicatorView$State$Shown$Error;", "Lcom/avito/android/messenger/connection_indicator/ConnectionErrorIndicatorView$State$Shown;", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getActionName", "()Ljava/lang/String;", "actionName", "Landroid/view/View$OnClickListener;", "c", "Landroid/view/View$OnClickListener;", "getActionClickListener", "()Landroid/view/View$OnClickListener;", "actionClickListener", "message", "<init>", "(Ljava/lang/String;Ljava/lang/String;Landroid/view/View$OnClickListener;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class Error extends Shown {
                @NotNull
                public final String b;
                @NotNull
                public final View.OnClickListener c;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public Error(@NotNull String str, @NotNull String str2, @NotNull View.OnClickListener onClickListener) {
                    super(str, null);
                    Intrinsics.checkNotNullParameter(str, "message");
                    Intrinsics.checkNotNullParameter(str2, "actionName");
                    Intrinsics.checkNotNullParameter(onClickListener, "actionClickListener");
                    this.b = str2;
                    this.c = onClickListener;
                }

                @NotNull
                public final View.OnClickListener getActionClickListener() {
                    return this.c;
                }

                @NotNull
                public final String getActionName() {
                    return this.b;
                }
            }

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/messenger/connection_indicator/ConnectionErrorIndicatorView$State$Shown$InProgress;", "Lcom/avito/android/messenger/connection_indicator/ConnectionErrorIndicatorView$State$Shown;", "", "message", "<init>", "(Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
            public static final class InProgress extends Shown {
                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public InProgress(@NotNull String str) {
                    super(str, null);
                    Intrinsics.checkNotNullParameter(str, "message");
                }
            }

            public Shown(String str, j jVar) {
                super(null);
                this.a = str;
            }

            @NotNull
            public final String getMessage() {
                return this.a;
            }
        }

        public State() {
        }

        public State(j jVar) {
        }
    }
}
