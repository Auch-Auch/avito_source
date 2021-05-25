package ru.avito.component.serp;

import android.net.Uri;
import android.os.Parcelable;
import com.avito.android.image_loader.Picture;
import com.avito.android.remote.model.Color;
import com.avito.android.remote.model.Sort;
import com.avito.android.remote.model.badge_bar.SerpBadge;
import com.facebook.appevents.integrity.IntegrityManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.serp.cyclic_gallery.image_carousel.ActionData;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\n\u0010\u000bJ3\u0010\u0011\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH&¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0014\u0010\u0006J\u0019\u0010\u0016\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0016\u0010\u0006J\u001d\u0010\u0019\u001a\u00020\u00042\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u000eH&¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u001e\u001a\u00020\u00042\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH&¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0004H&¢\u0006\u0004\b \u0010!J\u001f\u0010$\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\bH&¢\u0006\u0004\b$\u0010%J\u0019\u0010'\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b'\u0010\u0006J+\u0010*\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u00022\b\u0010)\u001a\u0004\u0018\u00010\u0017H&¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\u0004H&¢\u0006\u0004\b,\u0010!J\u001f\u00100\u001a\u00020\u00042\u0006\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020\bH&¢\u0006\u0004\b0\u00101J\u001f\u00104\u001a\u00020\u00042\u000e\u00103\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u000102H&¢\u0006\u0004\b4\u00105J\u001d\u00107\u001a\u00020\u00042\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u000402H&¢\u0006\u0004\b7\u00105J\u001d\u00108\u001a\u00020\u00042\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u000402H&¢\u0006\u0004\b8\u00105J%\u0010:\u001a\u00020\u00042\u0014\u00106\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010-\u0012\u0004\u0012\u00020\u000409H&¢\u0006\u0004\b:\u0010;J\u001d\u0010<\u001a\u00020\u00042\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u000402H&¢\u0006\u0004\b<\u00105J%\u0010=\u001a\u00020\u00042\u0014\u00103\u001a\u0010\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u0004\u0018\u000109H&¢\u0006\u0004\b=\u0010;J\u0017\u0010?\u001a\u00020\u00042\u0006\u0010>\u001a\u00020\bH&¢\u0006\u0004\b?\u0010@J\u001f\u0010B\u001a\u00020\u00042\u0006\u0010A\u001a\u00020\b2\u0006\u0010#\u001a\u00020\bH&¢\u0006\u0004\bB\u0010%J\u0017\u0010E\u001a\u00020D2\u0006\u0010C\u001a\u00020\u0017H&¢\u0006\u0004\bE\u0010FJ\u000f\u0010G\u001a\u00020\u0004H&¢\u0006\u0004\bG\u0010!J\u0019\u0010J\u001a\u00020\u00042\b\u0010I\u001a\u0004\u0018\u00010HH&¢\u0006\u0004\bJ\u0010KJ\u000f\u0010L\u001a\u00020\u0004H&¢\u0006\u0004\bL\u0010!J\u001f\u0010O\u001a\u00020\u00042\u000e\u0010N\u001a\n\u0012\u0004\u0012\u00020M\u0018\u00010\u000eH&¢\u0006\u0004\bO\u0010\u001aR\u0018\u0010R\u001a\u0004\u0018\u00010H8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\bP\u0010Q¨\u0006S"}, d2 = {"Lru/avito/component/serp/SerpAdvertRichJobCard;", "Lru/avito/component/serp/AsyncPhoneItemView;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "price", "", "isHighlighted", "setPrice", "(Ljava/lang/String;Z)V", "location", Sort.DISTANCE, "", "Lcom/avito/android/remote/model/Color;", "lines", "setLocation", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "setAddress", Sort.DATE, "setDate", "Lcom/avito/android/image_loader/Picture;", "pictures", "setPictures", "(Ljava/util/List;)V", "", "Lru/avito/component/serp/cyclic_gallery/image_carousel/ActionData;", "actions", "setActions", "(Ljava/util/Set;)V", "clearPictures", "()V", "favorite", "hasImages", "setFavorite", "(ZZ)V", "description", "setDescription", "name", "icon", "setSellerInfo", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/image_loader/Picture;)V", "clearSellerInfo", "", VKApiConst.POSITION, "smoothScroll", "setCurrentPicture", "(IZ)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "favoriteClicks", "(Lkotlin/jvm/functions/Function0;)V", "callback", "writeClicks", "callClicks", "Lkotlin/Function1;", "itemClicks", "(Lkotlin/jvm/functions/Function1;)V", "sellerClicks", "pictureChanges", "active", "setActive", "(Z)V", "viewed", "setViewed", "picture", "Landroid/net/Uri;", "getPictureUri", "(Lcom/avito/android/image_loader/Picture;)Landroid/net/Uri;", "clearActions", "Landroid/os/Parcelable;", "state", "restoreGalleryState", "(Landroid/os/Parcelable;)V", "clearListeners", "Lcom/avito/android/remote/model/badge_bar/SerpBadge;", "badges", "bindBadgeBar", "getGalleryState", "()Landroid/os/Parcelable;", "galleryState", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface SerpAdvertRichJobCard extends AsyncPhoneItemView {
    void bindBadgeBar(@Nullable List<SerpBadge> list);

    void callClicks(@NotNull Function0<Unit> function0);

    void clearActions();

    void clearListeners();

    void clearPictures();

    void clearSellerInfo();

    void favoriteClicks(@Nullable Function0<Unit> function0);

    @Nullable
    Parcelable getGalleryState();

    @NotNull
    Uri getPictureUri(@NotNull Picture picture);

    void itemClicks(@NotNull Function1<? super Integer, Unit> function1);

    void pictureChanges(@Nullable Function1<? super Integer, Unit> function1);

    void restoreGalleryState(@Nullable Parcelable parcelable);

    void sellerClicks(@NotNull Function0<Unit> function0);

    void setActions(@NotNull Set<ActionData> set);

    void setActive(boolean z);

    void setAddress(@Nullable String str);

    void setCurrentPicture(int i, boolean z);

    void setDate(@Nullable String str);

    void setDescription(@Nullable String str);

    void setFavorite(boolean z, boolean z2);

    void setLocation(@Nullable String str, @Nullable String str2, @Nullable List<Color> list);

    void setPictures(@NotNull List<? extends Picture> list);

    void setPrice(@Nullable String str, boolean z);

    void setSellerInfo(@NotNull String str, @Nullable String str2, @Nullable Picture picture);

    void setTitle(@NotNull String str);

    void setViewed(boolean z, boolean z2);

    void writeClicks(@NotNull Function0<Unit> function0);
}
