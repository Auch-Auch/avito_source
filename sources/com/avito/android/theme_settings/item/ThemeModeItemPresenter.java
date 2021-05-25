package com.avito.android.theme_settings.item;

import com.avito.android.lib.util.DarkThemeManager;
import com.avito.android.remote.auth.AuthSource;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u0007R\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/theme_settings/item/ThemeModeItemPresenter;", "", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/theme_settings/item/ThemeModeItemPresenter$Action;", "getActions", "()Lio/reactivex/rxjava3/core/Observable;", "actions", "Action", "settings_release"}, k = 1, mv = {1, 4, 2})
public interface ThemeModeItemPresenter {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/theme_settings/item/ThemeModeItemPresenter$Action;", "", "<init>", "()V", "Activate", "Lcom/avito/android/theme_settings/item/ThemeModeItemPresenter$Action$Activate;", "settings_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class Action {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/theme_settings/item/ThemeModeItemPresenter$Action$Activate;", "Lcom/avito/android/theme_settings/item/ThemeModeItemPresenter$Action;", "", AuthSource.BOOKING_ORDER, "Z", "getTargetState", "()Z", "targetState", "Lcom/avito/android/lib/util/DarkThemeManager$Mode;", AuthSource.SEND_ABUSE, "Lcom/avito/android/lib/util/DarkThemeManager$Mode;", "getMode", "()Lcom/avito/android/lib/util/DarkThemeManager$Mode;", "mode", "<init>", "(Lcom/avito/android/lib/util/DarkThemeManager$Mode;Z)V", "settings_release"}, k = 1, mv = {1, 4, 2})
        public static final class Activate extends Action {
            @NotNull
            public final DarkThemeManager.Mode a;
            public final boolean b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Activate(@NotNull DarkThemeManager.Mode mode, boolean z) {
                super(null);
                Intrinsics.checkNotNullParameter(mode, "mode");
                this.a = mode;
                this.b = z;
            }

            @NotNull
            public final DarkThemeManager.Mode getMode() {
                return this.a;
            }

            public final boolean getTargetState() {
                return this.b;
            }
        }

        public Action() {
        }

        public Action(j jVar) {
        }
    }

    @NotNull
    Observable<Action> getActions();
}
