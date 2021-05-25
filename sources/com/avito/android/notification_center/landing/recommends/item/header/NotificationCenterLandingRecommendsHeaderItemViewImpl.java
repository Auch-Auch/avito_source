package com.avito.android.notification_center.landing.recommends.item.header;

import android.net.Uri;
import android.view.View;
import com.avito.android.notification_center.R;
import com.avito.android.remote.model.Image;
import com.avito.android.util.Images;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.text.TextImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\u000bR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/avito/android/notification_center/landing/recommends/item/header/NotificationCenterLandingRecommendsHeaderItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/notification_center/landing/recommends/item/header/NotificationCenterLandingRecommendsHeaderItemView;", "Lcom/avito/android/remote/model/Image;", "image", "", "setImage", "(Lcom/avito/android/remote/model/Image;)V", "", "title", "setTitle", "(Ljava/lang/String;)V", "description", "setDescription", "Lru/avito/component/text/TextImpl;", "u", "Lru/avito/component/text/TextImpl;", "descriptionView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "s", "Lcom/facebook/drawee/view/SimpleDraweeView;", "imageView", "t", "titleView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "notification-center_release"}, k = 1, mv = {1, 4, 2})
public final class NotificationCenterLandingRecommendsHeaderItemViewImpl extends BaseViewHolder implements NotificationCenterLandingRecommendsHeaderItemView {
    public final SimpleDraweeView s;
    public final TextImpl t;
    public final TextImpl u;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NotificationCenterLandingRecommendsHeaderItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.image);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        this.s = (SimpleDraweeView) findViewById;
        View findViewById2 = view.findViewById(R.id.title);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.View");
        this.t = new TextImpl(findViewById2);
        View findViewById3 = view.findViewById(R.id.description);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.view.View");
        this.u = new TextImpl(findViewById3);
    }

    @Override // com.avito.android.notification_center.landing.recommends.item.header.NotificationCenterLandingRecommendsHeaderItemView
    public void setDescription(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "description");
        this.u.setText(str);
    }

    @Override // com.avito.android.notification_center.landing.recommends.item.header.NotificationCenterLandingRecommendsHeaderItemView
    public void setImage(@NotNull Image image) {
        Intrinsics.checkNotNullParameter(image, "image");
        Uri width = Images.fit$default(image, this.s, 0.0f, 0.0f, 2, 6, null).width();
        if (width != null) {
            SimpleDraweeViewsKt.getRequestBuilder(this.s).uri(width).load();
        }
    }

    @Override // com.avito.android.notification_center.landing.recommends.item.header.NotificationCenterLandingRecommendsHeaderItemView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.t.setText(str);
    }
}
