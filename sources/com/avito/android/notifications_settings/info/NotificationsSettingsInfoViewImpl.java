package com.avito.android.notifications_settings.info;

import android.view.View;
import com.avito.android.notifications_settings.R;
import com.avito.konveyor.adapter.BaseViewHolder;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.text.TextImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/avito/android/notifications_settings/info/NotificationsSettingsInfoViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/notifications_settings/info/NotificationsSettingsInfoView;", "", "text", "", "setText", "(Ljava/lang/String;)V", "Lru/avito/component/text/TextImpl;", "s", "Lru/avito/component/text/TextImpl;", "textView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "notifications-settings_release"}, k = 1, mv = {1, 4, 2})
public final class NotificationsSettingsInfoViewImpl extends BaseViewHolder implements NotificationsSettingsInfoView {
    public final TextImpl s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NotificationsSettingsInfoViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.notifications_settings_info);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        this.s = new TextImpl(findViewById);
    }

    @Override // com.avito.android.notifications_settings.info.NotificationsSettingsInfoView
    public void setText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.s.setText(str);
    }
}
