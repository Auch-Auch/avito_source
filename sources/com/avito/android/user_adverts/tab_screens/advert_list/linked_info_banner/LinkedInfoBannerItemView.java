package com.avito.android.user_adverts.tab_screens.advert_list.linked_info_banner;

import com.avito.android.deep_linking.links.OnDeepLinkClickListener;
import com.avito.android.remote.model.LinkedInfoBannerIcon;
import com.avito.android.remote.model.UniversalColor;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.konveyor.blueprint.ItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000b\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\u000b\u0010\nJ!\u0010\u000f\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0003H&¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0003H&¢\u0006\u0004\b\u001b\u0010\u0016J\u0017\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001cH&¢\u0006\u0004\b\u001e\u0010\u001fJ\u001d\u0010 \u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b \u0010\u0006J'\u0010\"\u001a\u00020\u00032\b\u0010!\u001a\u0004\u0018\u00010\u00072\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lcom/avito/android/user_adverts/tab_screens/advert_list/linked_info_banner/LinkedInfoBannerItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lkotlin/Function0;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "", "text", "setTitle", "(Ljava/lang/String;)V", "setMessage", "Lcom/avito/android/remote/model/text/AttributedText;", "Lcom/avito/android/deep_linking/links/OnDeepLinkClickListener;", "clickListener", "setDetailsLink", "(Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/deep_linking/links/OnDeepLinkClickListener;)V", "Lcom/avito/android/remote/model/UniversalColor;", "color", "setBackground", "(Lcom/avito/android/remote/model/UniversalColor;)V", "setDefaultBackground", "()V", "Lcom/avito/android/remote/model/LinkedInfoBannerIcon;", "linkedInfoBannerIcon", "setIcon", "(Lcom/avito/android/remote/model/LinkedInfoBannerIcon;)V", "hideIcon", "", "visible", "showCloseButton", "(Z)V", "setCloseButtonListener", "title", "setButton", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public interface LinkedInfoBannerItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull LinkedInfoBannerItemView linkedInfoBannerItemView) {
            ItemView.DefaultImpls.onUnbind(linkedInfoBannerItemView);
        }
    }

    void hideIcon();

    void setBackground(@NotNull UniversalColor universalColor);

    void setButton(@Nullable String str, @NotNull Function0<Unit> function0);

    void setClickListener(@NotNull Function0<Unit> function0);

    void setCloseButtonListener(@NotNull Function0<Unit> function0);

    void setDefaultBackground();

    void setDetailsLink(@Nullable AttributedText attributedText, @NotNull OnDeepLinkClickListener onDeepLinkClickListener);

    void setIcon(@NotNull LinkedInfoBannerIcon linkedInfoBannerIcon);

    void setMessage(@Nullable String str);

    void setTitle(@Nullable String str);

    void showCloseButton(boolean z);
}
