package com.avito.android.theme_settings.item.switcher;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.theme_settings.item.ThemeModeItemPresenter;
import com.jakewharton.rxrelay3.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0012\u0010\u0013J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/avito/android/theme_settings/item/switcher/SwitcherItemPresenterImpl;", "Lcom/avito/android/theme_settings/item/switcher/SwitcherItemPresenter;", "Lcom/avito/android/theme_settings/item/switcher/SwitcherItemView;", "view", "Lcom/avito/android/theme_settings/item/switcher/SwitcherItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/theme_settings/item/switcher/SwitcherItemView;Lcom/avito/android/theme_settings/item/switcher/SwitcherItem;I)V", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/avito/android/theme_settings/item/ThemeModeItemPresenter$Action;", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay3/PublishRelay;", "getActions", "()Lcom/jakewharton/rxrelay3/PublishRelay;", "actions", "<init>", "()V", "settings_release"}, k = 1, mv = {1, 4, 2})
public final class SwitcherItemPresenterImpl implements SwitcherItemPresenter {
    @NotNull
    public final PublishRelay<ThemeModeItemPresenter.Action> a;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ SwitcherItemPresenterImpl a;
        public final /* synthetic */ SwitcherItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(SwitcherItemPresenterImpl switcherItemPresenterImpl, SwitcherItem switcherItem) {
            super(0);
            this.a = switcherItemPresenterImpl;
            this.b = switcherItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.getActions().accept(new ThemeModeItemPresenter.Action.Activate(this.b.getState().getMode(), !this.b.getState().isChecked()));
            return Unit.INSTANCE;
        }
    }

    @Inject
    public SwitcherItemPresenterImpl() {
        PublishRelay<ThemeModeItemPresenter.Action> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.a = create;
    }

    public void bindView(@NotNull SwitcherItemView switcherItemView, @NotNull SwitcherItem switcherItem, int i) {
        Intrinsics.checkNotNullParameter(switcherItemView, "view");
        Intrinsics.checkNotNullParameter(switcherItem, "item");
        switcherItemView.setChecked(switcherItem.getState().isChecked());
        switcherItemView.setTitle(switcherItem.getTitle());
        switcherItemView.setSubtitle(switcherItem.getSubtitle());
        switcherItemView.setOnClickListener(new a(this, switcherItem));
    }

    @Override // com.avito.android.theme_settings.item.ThemeModeItemPresenter
    @NotNull
    public PublishRelay<ThemeModeItemPresenter.Action> getActions() {
        return this.a;
    }
}
