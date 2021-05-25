package com.avito.android.payment.top_up.form.items.shortcut_section;

import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.avito.konveyor.data_source.ListDataSource;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/payment/top_up/form/items/shortcut_section/ShortcutSectionPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/payment/top_up/form/items/shortcut_section/ShortcutSectionItemView;", "Lcom/avito/android/payment/top_up/form/items/shortcut_section/ShortcutSectionItem;", "view", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/payment/top_up/form/items/shortcut_section/ShortcutSectionItemView;Lcom/avito/android/payment/top_up/form/items/shortcut_section/ShortcutSectionItem;I)V", "Lcom/avito/konveyor/adapter/AdapterPresenter;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "<init>", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
public final class ShortcutSectionPresenter implements ItemPresenter<ShortcutSectionItemView, ShortcutSectionItem> {
    public final AdapterPresenter a;

    public ShortcutSectionPresenter(@NotNull AdapterPresenter adapterPresenter) {
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        this.a = adapterPresenter;
    }

    public void bindView(@NotNull ShortcutSectionItemView shortcutSectionItemView, @NotNull ShortcutSectionItem shortcutSectionItem, int i) {
        Intrinsics.checkNotNullParameter(shortcutSectionItemView, "view");
        Intrinsics.checkNotNullParameter(shortcutSectionItem, "item");
        this.a.onDataSourceChanged(new ListDataSource(shortcutSectionItem.getItems()));
    }
}
