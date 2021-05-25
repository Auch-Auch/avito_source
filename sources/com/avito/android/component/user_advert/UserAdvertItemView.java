package com.avito.android.component.user_advert;

import androidx.annotation.AttrRes;
import com.avito.android.db.FavoritesContract;
import com.avito.android.image_loader.Picture;
import com.avito.android.remote.model.badge.Badge;
import com.avito.konveyor.blueprint.ItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.messaging.Constants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010$\n\u0002\b\u0017\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\f\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\f\u0010\nJ\u0017\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0003H&¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001bH&¢\u0006\u0004\b\u001d\u0010\u001eJ#\u0010!\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010\u00072\b\u0010 \u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0003H&¢\u0006\u0004\b#\u0010\u0012J\u0019\u0010%\u001a\u00020\u00032\b\u0010$\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b%\u0010\nJ\u000f\u0010&\u001a\u00020\u0003H&¢\u0006\u0004\b&\u0010\u0012J\u0019\u0010(\u001a\u00020\u00032\b\u0010'\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b(\u0010\nJ!\u0010+\u001a\u00020\u00032\b\u0010)\u001a\u0004\u0018\u00010\u00072\u0006\u0010*\u001a\u00020\u0017H&¢\u0006\u0004\b+\u0010,J#\u0010/\u001a\u00020\u00032\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00130-H&¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\u0003H&¢\u0006\u0004\b1\u0010\u0012J\u0017\u00103\u001a\u00020\u00032\u0006\u00102\u001a\u00020\u0017H&¢\u0006\u0004\b3\u0010\u001aJ!\u00106\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u00072\b\b\u0001\u00105\u001a\u00020\u001bH&¢\u0006\u0004\b6\u00107J\u000f\u00108\u001a\u00020\u0003H&¢\u0006\u0004\b8\u0010\u0012J!\u00109\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u00072\b\b\u0001\u00105\u001a\u00020\u001bH&¢\u0006\u0004\b9\u00107J\u000f\u0010:\u001a\u00020\u0003H&¢\u0006\u0004\b:\u0010\u0012J\u0017\u0010<\u001a\u00020\u00032\u0006\u0010;\u001a\u00020\u0017H&¢\u0006\u0004\b<\u0010\u001aJ\u0017\u0010>\u001a\u00020\u00032\u0006\u0010=\u001a\u00020\u0017H&¢\u0006\u0004\b>\u0010\u001aJ\u000f\u0010?\u001a\u00020\u0003H&¢\u0006\u0004\b?\u0010\u0012J\u000f\u0010@\u001a\u00020\u0003H&¢\u0006\u0004\b@\u0010\u0012J#\u0010C\u001a\u00020\u00032\b\u0010A\u001a\u0004\u0018\u00010\u00072\b\u0010B\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\bC\u0010\"¨\u0006D"}, d2 = {"Lcom/avito/android/component/user_advert/UserAdvertItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lkotlin/Function0;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "", "title", "setTitle", "(Ljava/lang/String;)V", "price", "setPrice", "Lcom/avito/android/remote/model/badge/Badge;", "priceBadge", "setPriceBadge", "(Lcom/avito/android/remote/model/badge/Badge;)V", "hidePriceBadge", "()V", "Lcom/avito/android/image_loader/Picture;", "picture", "setImage", "(Lcom/avito/android/image_loader/Picture;)V", "", "active", "setActive", "(Z)V", "", "widthPx", "setWidth", "(I)V", "watchesTotal", "watchesToday", "showViewsStats", "(Ljava/lang/String;Ljava/lang/String;)V", "showViewsStatsNoViews", FavoritesContract.TABLE_NAME, "showFavoritesStats", "hideStats", Constants.FirelogAnalytics.PARAM_TTL, "setTimeToLive", "declineReason", "isCritical", "setDeclineReason", "(Ljava/lang/String;Z)V", "", "pictures", "setServiceIcons", "(Ljava/util/Map;)V", "hideServices", "isShowDelivery", "setDeliveryVisible", "text", "colorAttr", "showStatus", "(Ljava/lang/String;I)V", "hideStatus", "showOrderStatus", "hideOrderStatus", "visible", "setAutoPublishVisibility", "isModerated", "setModerationStatus", "hideContactStats", "showContactStatsNoViews", "contactsTotal", "contactsToday", "showContactStats", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface UserAdvertItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull UserAdvertItemView userAdvertItemView) {
            ItemView.DefaultImpls.onUnbind(userAdvertItemView);
        }
    }

    void hideContactStats();

    void hideOrderStatus();

    void hidePriceBadge();

    void hideServices();

    void hideStats();

    void hideStatus();

    void setActive(boolean z);

    void setAutoPublishVisibility(boolean z);

    void setClickListener(@NotNull Function0<Unit> function0);

    void setDeclineReason(@Nullable String str, boolean z);

    void setDeliveryVisible(boolean z);

    void setImage(@NotNull Picture picture);

    void setModerationStatus(boolean z);

    void setPrice(@Nullable String str);

    void setPriceBadge(@NotNull Badge badge);

    void setServiceIcons(@NotNull Map<String, ? extends Picture> map);

    void setTimeToLive(@Nullable String str);

    void setTitle(@NotNull String str);

    void setWidth(int i);

    void showContactStats(@Nullable String str, @Nullable String str2);

    void showContactStatsNoViews();

    void showFavoritesStats(@Nullable String str);

    void showOrderStatus(@NotNull String str, @AttrRes int i);

    void showStatus(@NotNull String str, @AttrRes int i);

    void showViewsStats(@Nullable String str, @Nullable String str2);

    void showViewsStatsNoViews();
}
