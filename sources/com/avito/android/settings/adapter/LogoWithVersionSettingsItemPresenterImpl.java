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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/settings/adapter/LogoWithVersionSettingsItemPresenterImpl;", "Lcom/avito/android/settings/adapter/LogoWithVersionSettingsItemPresenter;", "Lcom/avito/android/settings/adapter/LogoWithVersionSettingsItemView;", "view", "Lcom/avito/android/settings/adapter/SettingsItem$LogoWithVersion;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/settings/adapter/LogoWithVersionSettingsItemView;Lcom/avito/android/settings/adapter/SettingsItem$LogoWithVersion;I)V", "Lio/reactivex/rxjava3/functions/Consumer;", "", AuthSource.SEND_ABUSE, "Lio/reactivex/rxjava3/functions/Consumer;", "valueConsumer", "<init>", "(Lio/reactivex/rxjava3/functions/Consumer;)V", "settings_release"}, k = 1, mv = {1, 4, 2})
public final class LogoWithVersionSettingsItemPresenterImpl implements LogoWithVersionSettingsItemPresenter {
    public final Consumer<String> a;

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ Object c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, Object obj, Object obj2) {
            super(0);
            this.a = i;
            this.b = obj;
            this.c = obj2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            int i = this.a;
            if (i == 0) {
                ((LogoWithVersionSettingsItemPresenterImpl) this.b).a.accept(((SettingsItem.LogoWithVersion) this.c).getStringId());
                return Unit.INSTANCE;
            } else if (i == 1) {
                ((LogoWithVersionSettingsItemPresenterImpl) this.b).a.accept(((SettingsItem.LogoWithVersion) this.c).getVersionId());
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    @Inject
    public LogoWithVersionSettingsItemPresenterImpl(@NotNull Consumer<String> consumer) {
        Intrinsics.checkNotNullParameter(consumer, "valueConsumer");
        this.a = consumer;
    }

    public void bindView(@NotNull LogoWithVersionSettingsItemView logoWithVersionSettingsItemView, @NotNull SettingsItem.LogoWithVersion logoWithVersion, int i) {
        Intrinsics.checkNotNullParameter(logoWithVersionSettingsItemView, "view");
        Intrinsics.checkNotNullParameter(logoWithVersion, "item");
        logoWithVersionSettingsItemView.setLogoActionListener(new a(0, this, logoWithVersion));
        logoWithVersionSettingsItemView.setVersionActionListener(new a(1, this, logoWithVersion));
        logoWithVersionSettingsItemView.setVersion(logoWithVersion.getVersion());
    }
}
