package com.avito.android.publish;

import android.view.View;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.search.map.view.PanelStateKt;
import com.avito.android.ui_components.R;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.toolbar.AppBarLayoutWithTextAction;
import ru.avito.component.toolbar.AppbarClickListener;
import ru.avito.component.toolbar.OnboardingData;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010+\u001a\u00020*\u0012\b\b\u0002\u0010)\u001a\u00020\u001d¢\u0006\u0004\b,\u0010-J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\n\u0010\u0006J\u0015\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000f\u0010\u0006J\u0015\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J)\u0010\u001b\u001a\u00020\u00042\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u00182\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u0018¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\u001d\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010\"R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(¨\u0006."}, d2 = {"Lcom/avito/android/publish/PublishAppbarView;", "", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "shortTitle", "setShortTitle", MessengerShareContentUtility.SUBTITLE, "setSubtitle", "Lru/avito/component/toolbar/OnboardingData;", "onboardingData", "showActionOnboarding", "(Lru/avito/component/toolbar/OnboardingData;)V", "setActionTitle", "Lcom/avito/android/publish/ActionMode;", "mode", "setActionMode", "(Lcom/avito/android/publish/ActionMode;)V", "", "id", "setHomeIcon", "(I)V", "Lkotlin/Function0;", "onAction", "onBack", "setActionsListener", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "", PanelStateKt.PANEL_EXPANDED, "setExpanded", "(Z)V", "animate", "(ZZ)V", "Lru/avito/component/toolbar/AppBarLayoutWithTextAction;", AuthSource.SEND_ABUSE, "Lru/avito/component/toolbar/AppBarLayoutWithTextAction;", "appBar", AuthSource.BOOKING_ORDER, "Z", "saveActionEnabled", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;Z)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class PublishAppbarView {
    public final AppBarLayoutWithTextAction a;
    public final boolean b;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            ActionMode.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
        }
    }

    public PublishAppbarView(@NotNull View view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.b = z;
        View findViewById = view.findViewById(R.id.app_bar);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type ru.avito.component.toolbar.AppBarLayoutWithTextAction");
        this.a = (AppBarLayoutWithTextAction) findViewById;
        setActionMode(ActionMode.CLOSE);
    }

    public final void setActionMode(@NotNull ActionMode actionMode) {
        Intrinsics.checkNotNullParameter(actionMode, "mode");
        int ordinal = actionMode.ordinal();
        if (ordinal != 0) {
            if (ordinal == 1) {
                setActionTitle(null);
            }
        } else if (this.b) {
            setActionTitle(this.a.getContext().getString(R.string.save_and_close));
        } else {
            setActionTitle(this.a.getContext().getString(R.string.close));
        }
    }

    public final void setActionTitle(@Nullable String str) {
        this.a.setAction(str);
    }

    public final void setActionsListener(@NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(function0, "onAction");
        Intrinsics.checkNotNullParameter(function02, "onBack");
        this.a.setClickListener(new AppbarClickListener(function0, function02) { // from class: com.avito.android.publish.PublishAppbarView$setActionsListener$1
            public final /* synthetic */ Function0 a;
            public final /* synthetic */ Function0 b;

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // ru.avito.component.toolbar.AppbarClickListener
            public void onActionClicked() {
                this.a.invoke();
            }

            @Override // ru.avito.component.toolbar.AppbarClickListener
            public void onHomeClicked() {
                this.b.invoke();
            }
        });
    }

    public final void setExpanded(boolean z) {
        this.a.setExpanded(z);
    }

    public final void setHomeIcon(int i) {
        this.a.setHomeIcon(i);
    }

    public final void setShortTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "shortTitle");
        this.a.setShortTitle(str);
    }

    public final void setSubtitle(@Nullable String str) {
        this.a.setSubTitle(str);
    }

    public final void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.a.setTitle(str);
    }

    public final void showActionOnboarding(@NotNull OnboardingData onboardingData) {
        Intrinsics.checkNotNullParameter(onboardingData, "onboardingData");
        this.a.showActionOnboarding(onboardingData);
    }

    public final void setExpanded(boolean z, boolean z2) {
        this.a.setExpanded(z, z2);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PublishAppbarView(View view, boolean z, int i, j jVar) {
        this(view, (i & 2) != 0 ? false : z);
    }
}
