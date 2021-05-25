package com.avito.android.settings.adapter;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.settings.adapter.SettingsItem;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/settings/adapter/InfoSettingsWithProgressItemPresenterImpl;", "Lcom/avito/android/settings/adapter/InfoSettingsWithProgressItemPresenter;", "Lcom/avito/android/settings/adapter/InfoSettingsWithProgressItemView;", "view", "Lcom/avito/android/settings/adapter/SettingsItem$InfoWithProgress;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/settings/adapter/InfoSettingsWithProgressItemView;Lcom/avito/android/settings/adapter/SettingsItem$InfoWithProgress;I)V", "Lio/reactivex/rxjava3/functions/Consumer;", "", AuthSource.SEND_ABUSE, "Lio/reactivex/rxjava3/functions/Consumer;", "valueConsumer", "<init>", "(Lio/reactivex/rxjava3/functions/Consumer;)V", "settings_release"}, k = 1, mv = {1, 4, 2})
public final class InfoSettingsWithProgressItemPresenterImpl implements InfoSettingsWithProgressItemPresenter {
    public final Consumer<String> a;

    public static final class a<T> implements Consumer<Unit> {
        public final /* synthetic */ InfoSettingsWithProgressItemPresenterImpl a;
        public final /* synthetic */ SettingsItem.InfoWithProgress b;

        public a(InfoSettingsWithProgressItemPresenterImpl infoSettingsWithProgressItemPresenterImpl, SettingsItem.InfoWithProgress infoWithProgress) {
            this.a = infoSettingsWithProgressItemPresenterImpl;
            this.b = infoWithProgress;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: io.reactivex.rxjava3.functions.Consumer */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Unit unit) {
            this.a.a.accept(this.b.getStringId());
        }
    }

    @Inject
    public InfoSettingsWithProgressItemPresenterImpl(@NotNull Consumer<String> consumer) {
        Intrinsics.checkNotNullParameter(consumer, "valueConsumer");
        this.a = consumer;
    }

    public void bindView(@NotNull InfoSettingsWithProgressItemView infoSettingsWithProgressItemView, @NotNull SettingsItem.InfoWithProgress infoWithProgress, int i) {
        Intrinsics.checkNotNullParameter(infoSettingsWithProgressItemView, "view");
        Intrinsics.checkNotNullParameter(infoWithProgress, "item");
        infoSettingsWithProgressItemView.setTitle(infoWithProgress.getTitle());
        infoSettingsWithProgressItemView.visibleProgress(infoWithProgress.getShowProgress());
        infoSettingsWithProgressItemView.clicks().subscribe(new a(this, infoWithProgress));
    }
}
