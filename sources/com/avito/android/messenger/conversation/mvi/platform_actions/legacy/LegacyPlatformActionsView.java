package com.avito.android.messenger.conversation.mvi.platform_actions.legacy;

import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import com.avito.android.messenger.channels.mvi.common.v2.Renderer;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.LegacyPlatformActionsPresenter;
import com.avito.android.ui.fragments.OnBackPressedListener;
import com.avito.android.util.UrlParams;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002\u001f JC\u0010\f\u001a\u00020\u000b\"\b\b\u0000\u0010\u0005*\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u001a\u0010\n\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\t0\bH&¢\u0006\u0004\b\f\u0010\rJG\u0010\u0012\u001a\u00020\u000b\"\b\b\u0000\u0010\u0005*\u00020\u0004\"\u000e\b\u0001\u0010\u000e*\b\u0012\u0004\u0012\u00028\u00000\t2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00028\u0001H&¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u000bH&¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0016H&¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u000bH&¢\u0006\u0004\b\u001a\u0010\u0015R\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsView;", "Lcom/avito/android/messenger/channels/mvi/common/v2/Renderer;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter$State;", "Lcom/avito/android/ui/fragments/OnBackPressedListener;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter$ContentData;", "T", "Ljava/lang/Class;", "clazz", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsView$ContentView;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsView$ContentPresenter;", "view", "", "addContentView", "(Ljava/lang/Class;Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsView$ContentView;)V", "P", "Landroidx/lifecycle/LifecycleOwner;", UrlParams.OWNER, "presenter", "bindContentPresenter", "(Ljava/lang/Class;Landroidx/lifecycle/LifecycleOwner;Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsView$ContentPresenter;)V", "unbindContentPresenters", "()V", "", "visible", "onKeyboardVisibilityChanged", "(Z)V", "destroyViews", "Lio/reactivex/Observable;", "getBottomSheetOpenedStream", "()Lio/reactivex/Observable;", "bottomSheetOpenedStream", "ContentPresenter", "ContentView", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface LegacyPlatformActionsView extends Renderer<LegacyPlatformActionsPresenter.State>, OnBackPressedListener {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsView$ContentPresenter;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter$ContentData;", "T", "", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public interface ContentPresenter<T extends LegacyPlatformActionsPresenter.ContentData> {
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\u000e\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u00032\u00020\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00028\u0001H&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH&¢\u0006\u0004\b\f\u0010\rJ)\u0010\u0014\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H&¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0016\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H&¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00020\u0019H&¢\u0006\u0004\b\u001c\u0010\u001dR\u0018\u0010 \u001a\u0004\u0018\u00010\u00128&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006!"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsView$ContentView;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter$ContentData;", "T", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsView$ContentPresenter;", "P", "", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "presenter", "", "bindPresenter", "(Landroidx/lifecycle/LifecycleOwner;Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsView$ContentPresenter;)V", "unbindPresenter", "()V", "Landroid/view/ViewGroup;", "container", "Landroid/view/ViewGroup$LayoutParams;", "params", "Landroid/view/View;", "closeButton", "addToParent", "(Landroid/view/ViewGroup;Landroid/view/ViewGroup$LayoutParams;Landroid/view/View;)V", "removeFromParent", "(Landroid/view/ViewGroup;Landroid/view/View;)V", "content", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter$UiData;", "uiData", "", "render", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter$ContentData;Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/LegacyPlatformActionsPresenter$UiData;)Z", "getTitleView", "()Landroid/view/View;", "titleView", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public interface ContentView<T extends LegacyPlatformActionsPresenter.ContentData, P extends ContentPresenter<T>> {
        void addToParent(@NotNull ViewGroup viewGroup, @NotNull ViewGroup.LayoutParams layoutParams, @Nullable View view);

        void bindPresenter(@NotNull LifecycleOwner lifecycleOwner, @NotNull P p);

        @Nullable
        View getTitleView();

        void removeFromParent(@Nullable ViewGroup viewGroup, @Nullable View view);

        boolean render(@NotNull T t, @NotNull LegacyPlatformActionsPresenter.UiData uiData);

        void unbindPresenter();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void render(@NotNull LegacyPlatformActionsView legacyPlatformActionsView, @NotNull LegacyPlatformActionsPresenter.State state) {
            Intrinsics.checkNotNullParameter(state, "state");
            Renderer.DefaultImpls.render(legacyPlatformActionsView, state);
        }
    }

    <T extends LegacyPlatformActionsPresenter.ContentData> void addContentView(@NotNull Class<T> cls, @NotNull ContentView<T, ? extends ContentPresenter<T>> contentView);

    <T extends LegacyPlatformActionsPresenter.ContentData, P extends ContentPresenter<T>> void bindContentPresenter(@NotNull Class<T> cls, @NotNull LifecycleOwner lifecycleOwner, @NotNull P p);

    void destroyViews();

    @NotNull
    Observable<Unit> getBottomSheetOpenedStream();

    void onKeyboardVisibilityChanged(boolean z);

    void unbindContentPresenters();
}
