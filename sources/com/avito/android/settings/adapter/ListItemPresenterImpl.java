package com.avito.android.settings.adapter;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.settings.adapter.SettingsItem;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/settings/adapter/ListItemPresenterImpl;", "Lcom/avito/android/settings/adapter/ListItemPresenter;", "Lcom/avito/android/settings/adapter/ListItemView;", "view", "Lcom/avito/android/settings/adapter/SettingsItem$ListItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/settings/adapter/ListItemView;Lcom/avito/android/settings/adapter/SettingsItem$ListItem;I)V", "Lio/reactivex/rxjava3/functions/Consumer;", "", AuthSource.SEND_ABUSE, "Lio/reactivex/rxjava3/functions/Consumer;", "valueConsumer", "<init>", "(Lio/reactivex/rxjava3/functions/Consumer;)V", "settings_release"}, k = 1, mv = {1, 4, 2})
public final class ListItemPresenterImpl implements ListItemPresenter {
    public final Consumer<String> a;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ListItemPresenterImpl a;
        public final /* synthetic */ SettingsItem.ListItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ListItemPresenterImpl listItemPresenterImpl, SettingsItem.ListItem listItem) {
            super(0);
            this.a = listItemPresenterImpl;
            this.b = listItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.a.accept(this.b.getStringId());
            return Unit.INSTANCE;
        }
    }

    @Inject
    public ListItemPresenterImpl(@NotNull Consumer<String> consumer) {
        Intrinsics.checkNotNullParameter(consumer, "valueConsumer");
        this.a = consumer;
    }

    public void bindView(@NotNull ListItemView listItemView, @NotNull SettingsItem.ListItem listItem, int i) {
        Intrinsics.checkNotNullParameter(listItemView, "view");
        Intrinsics.checkNotNullParameter(listItem, "item");
        listItemView.setHint(listItem.getTitle());
        listItemView.setValue(listItem.getValue());
        listItemView.setOnClickListener(new a(this, listItem));
    }
}
