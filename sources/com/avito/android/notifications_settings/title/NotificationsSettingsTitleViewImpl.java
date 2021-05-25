package com.avito.android.notifications_settings.title;

import android.view.View;
import com.avito.android.notifications_settings.R;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.text.TextImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\u0007R\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/avito/android/notifications_settings/title/NotificationsSettingsTitleViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/notifications_settings/title/NotificationsSettingsTitleView;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", MessengerShareContentUtility.SUBTITLE, "setSubtitle", "Lru/avito/component/text/TextImpl;", "s", "Lru/avito/component/text/TextImpl;", "titleView", "t", "subtitleView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "notifications-settings_release"}, k = 1, mv = {1, 4, 2})
public final class NotificationsSettingsTitleViewImpl extends BaseViewHolder implements NotificationsSettingsTitleView {
    public final TextImpl s;
    public final TextImpl t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NotificationsSettingsTitleViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.title);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        this.s = new TextImpl(findViewById);
        View findViewById2 = view.findViewById(R.id.subtitle);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.View");
        this.t = new TextImpl(findViewById2);
    }

    @Override // com.avito.android.notifications_settings.title.NotificationsSettingsTitleView
    public void setSubtitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, MessengerShareContentUtility.SUBTITLE);
        this.t.setText(str);
    }

    @Override // com.avito.android.notifications_settings.title.NotificationsSettingsTitleView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.s.setText(str);
    }
}
