package com.avito.android.serp.adapter;

import androidx.annotation.ColorInt;
import com.avito.android.image_loader.AvitoPictureKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Color;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import dagger.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\b\b\u0001\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\r\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/serp/adapter/ShortcutBannerItemPresenterImpl;", "Lcom/avito/android/serp/adapter/ShortcutBannerItemPresenter;", "Lcom/avito/android/serp/adapter/ShortcutBannerItemView;", "view", "Lcom/avito/android/serp/adapter/ShortcutBannerItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/serp/adapter/ShortcutBannerItemView;Lcom/avito/android/serp/adapter/ShortcutBannerItem;I)V", "c", "I", "fallbackColor", "Lcom/avito/android/serp/adapter/ShortcutBannerWidthProvider;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/serp/adapter/ShortcutBannerWidthProvider;", "shortcutBannerWidthProvider", "Ldagger/Lazy;", "Lcom/avito/android/serp/adapter/ShortcutBannerItemListener;", AuthSource.SEND_ABUSE, "Ldagger/Lazy;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "<init>", "(Ldagger/Lazy;Lcom/avito/android/serp/adapter/ShortcutBannerWidthProvider;I)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class ShortcutBannerItemPresenterImpl implements ShortcutBannerItemPresenter {
    public final Lazy<ShortcutBannerItemListener> a;
    public final ShortcutBannerWidthProvider b;
    public final int c;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ShortcutBannerItemPresenterImpl a;
        public final /* synthetic */ ShortcutBannerItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ShortcutBannerItemPresenterImpl shortcutBannerItemPresenterImpl, ShortcutBannerItem shortcutBannerItem) {
            super(0);
            this.a = shortcutBannerItemPresenterImpl;
            this.b = shortcutBannerItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            ((ShortcutBannerItemListener) this.a.a.get()).onShortcutBannerItemClicked(this.b);
            return Unit.INSTANCE;
        }
    }

    public ShortcutBannerItemPresenterImpl(@NotNull Lazy<ShortcutBannerItemListener> lazy, @NotNull ShortcutBannerWidthProvider shortcutBannerWidthProvider, @ColorInt int i) {
        Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.checkNotNullParameter(shortcutBannerWidthProvider, "shortcutBannerWidthProvider");
        this.a = lazy;
        this.b = shortcutBannerWidthProvider;
        this.c = i;
    }

    public void bindView(@NotNull ShortcutBannerItemView shortcutBannerItemView, @NotNull ShortcutBannerItem shortcutBannerItem, int i) {
        Intrinsics.checkNotNullParameter(shortcutBannerItemView, "view");
        Intrinsics.checkNotNullParameter(shortcutBannerItem, "item");
        this.a.get().onShortcutBannerItemShowed(shortcutBannerItem);
        shortcutBannerItemView.setClickListener(new a(this, shortcutBannerItem));
        shortcutBannerItemView.setTitle(shortcutBannerItem.getTitle());
        Color color = shortcutBannerItem.getColor();
        int value = color != null ? color.getValue() : this.c;
        shortcutBannerItemView.setLeftImage(AvitoPictureKt.pictureOf$default(shortcutBannerItem.getLeftImage(), false, 0.0f, 0.0f, null, 28, null));
        shortcutBannerItemView.setRightImage(AvitoPictureKt.pictureOf$default(shortcutBannerItem.getRightImage(), false, 0.0f, 0.0f, null, 28, null));
        shortcutBannerItemView.setBackground(value);
        shortcutBannerItemView.setImage(AvitoPictureKt.pictureOf$default(shortcutBannerItem.getImage(), false, 0.0f, 0.0f, null, 28, null));
        shortcutBannerItemView.setShortcutWidth(this.b.getWidthPx());
    }
}
