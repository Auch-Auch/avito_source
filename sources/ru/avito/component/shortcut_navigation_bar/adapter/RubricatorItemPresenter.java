package ru.avito.component.shortcut_navigation_bar.adapter;

import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import t6.n.r;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Lru/avito/component/shortcut_navigation_bar/adapter/RubricatorItemPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lru/avito/component/shortcut_navigation_bar/adapter/RubricatorItemView;", "Lru/avito/component/shortcut_navigation_bar/adapter/ShortcutNavigationItem;", "view", "item", "", VKApiConst.POSITION, "", "bindView", "(Lru/avito/component/shortcut_navigation_bar/adapter/RubricatorItemView;Lru/avito/component/shortcut_navigation_bar/adapter/ShortcutNavigationItem;I)V", "Lru/avito/component/shortcut_navigation_bar/adapter/ShortcutClickListener;", AuthSource.SEND_ABUSE, "Lru/avito/component/shortcut_navigation_bar/adapter/ShortcutClickListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "<init>", "(Lru/avito/component/shortcut_navigation_bar/adapter/ShortcutClickListener;)V", "Companion", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class RubricatorItemPresenter implements ItemPresenter<RubricatorItemView, ShortcutNavigationItem> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final Map<String, RubricatorCategory> b = r.mapOf(TuplesKt.to("1", RubricatorCategory.TRANSPORT), TuplesKt.to("4", RubricatorCategory.REALTY), TuplesKt.to("110", RubricatorCategory.JOB), TuplesKt.to("114", RubricatorCategory.SERVICES));
    public final ShortcutClickListener a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR'\u0010\u0005\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lru/avito/component/shortcut_navigation_bar/adapter/RubricatorItemPresenter$Companion;", "", "", "", "Lru/avito/component/shortcut_navigation_bar/adapter/RubricatorCategory;", "RUBRICATOR_CATEGORIES_MAP", "Ljava/util/Map;", "getRUBRICATOR_CATEGORIES_MAP", "()Ljava/util/Map;", "<init>", "()V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final Map<String, RubricatorCategory> getRUBRICATOR_CATEGORIES_MAP() {
            return RubricatorItemPresenter.b;
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ RubricatorItemPresenter a;
        public final /* synthetic */ int b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(RubricatorItemPresenter rubricatorItemPresenter, int i) {
            super(0);
            this.a = rubricatorItemPresenter;
            this.b = i;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.a.onShortcutClick(this.b);
            return Unit.INSTANCE;
        }
    }

    public RubricatorItemPresenter(@NotNull ShortcutClickListener shortcutClickListener) {
        Intrinsics.checkNotNullParameter(shortcutClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.a = shortcutClickListener;
    }

    public void bindView(@NotNull RubricatorItemView rubricatorItemView, @NotNull ShortcutNavigationItem shortcutNavigationItem, int i) {
        Intrinsics.checkNotNullParameter(rubricatorItemView, "view");
        Intrinsics.checkNotNullParameter(shortcutNavigationItem, "item");
        RubricatorCategory rubricatorCategory = b.get(ShortcutNavigationItemKt.extractCategoryId(shortcutNavigationItem));
        if (rubricatorCategory == null) {
            rubricatorCategory = RubricatorCategory.ALL;
        }
        rubricatorItemView.setContent(rubricatorCategory, shortcutNavigationItem.getText());
        rubricatorItemView.setClickListener(new a(this, i));
    }
}
