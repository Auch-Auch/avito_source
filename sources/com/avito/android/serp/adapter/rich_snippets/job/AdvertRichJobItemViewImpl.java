package com.avito.android.serp.adapter.rich_snippets.job;

import android.net.Uri;
import android.os.Parcelable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.image_loader.Picture;
import com.avito.android.remote.model.Color;
import com.avito.android.remote.model.Sort;
import com.avito.android.remote.model.badge_bar.SerpBadge;
import com.avito.android.serp.BaseSerpViewHolder;
import com.facebook.appevents.integrity.IntegrityManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.serp.PhoneLoadingState;
import ru.avito.component.serp.SerpAdvertRichJobCard;
import ru.avito.component.serp.SerpAdvertRichJobCardImpl;
import ru.avito.component.serp.cyclic_gallery.image_carousel.ActionData;
import ru.avito.component.serp.cyclic_gallery.image_carousel.GalleryRatio;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B1\u0012\u0006\u0010`\u001a\u00020_\u0012\n\b\u0002\u0010b\u001a\u0004\u0018\u00010a\u0012\n\b\u0002\u0010d\u001a\u0004\u0018\u00010c\u0012\b\b\u0002\u0010e\u001a\u00020*¢\u0006\u0004\bf\u0010gJ\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J \u0010\n\u001a\u00020\u00042\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001e\u0010\u000e\u001a\u00020\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\fH\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0010\u0010\u0006J\u0010\u0010\u0011\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0011\u0010\u0006J\u0010\u0010\u0012\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0012\u0010\u0006J\u0010\u0010\u0013\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0013\u0010\u0006J \u0010\u0015\u001a\u00020\u00042\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\fH\u0001¢\u0006\u0004\b\u0015\u0010\u000fJ\u0018\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016H\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ&\u0010\u001d\u001a\u00020\u00042\u0014\u0010\r\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0012\u0004\u0012\u00020\u00040\u001bH\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ&\u0010\u001f\u001a\u00020\u00042\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001bH\u0001¢\u0006\u0004\b\u001f\u0010\u001eJ\u001a\u0010\"\u001a\u00020\u00042\b\u0010!\u001a\u0004\u0018\u00010 H\u0001¢\u0006\u0004\b\"\u0010#J\u001e\u0010$\u001a\u00020\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\fH\u0001¢\u0006\u0004\b$\u0010\u000fJ\u001e\u0010(\u001a\u00020\u00042\f\u0010'\u001a\b\u0012\u0004\u0012\u00020&0%H\u0001¢\u0006\u0004\b(\u0010)J\u0018\u0010,\u001a\u00020\u00042\u0006\u0010+\u001a\u00020*H\u0001¢\u0006\u0004\b,\u0010-J\u001a\u00100\u001a\u00020\u00042\b\u0010/\u001a\u0004\u0018\u00010.H\u0001¢\u0006\u0004\b0\u00101J \u00104\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u001c2\u0006\u00103\u001a\u00020*H\u0001¢\u0006\u0004\b4\u00105J\u001a\u00107\u001a\u00020\u00042\b\u00106\u001a\u0004\u0018\u00010.H\u0001¢\u0006\u0004\b7\u00101J\u001a\u00109\u001a\u00020\u00042\b\u00108\u001a\u0004\u0018\u00010.H\u0001¢\u0006\u0004\b9\u00101J \u0010<\u001a\u00020\u00042\u0006\u0010:\u001a\u00020*2\u0006\u0010;\u001a\u00020*H\u0001¢\u0006\u0004\b<\u0010=J4\u0010B\u001a\u00020\u00042\b\u0010>\u001a\u0004\u0018\u00010.2\b\u0010?\u001a\u0004\u0018\u00010.2\u000e\u0010A\u001a\n\u0012\u0004\u0012\u00020@\u0018\u00010\u0007H\u0001¢\u0006\u0004\bB\u0010CJ\u0018\u0010E\u001a\u00020\u00042\u0006\u0010!\u001a\u00020DH\u0001¢\u0006\u0004\bE\u0010FJ\u001e\u0010H\u001a\u00020\u00042\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00160\u0007H\u0001¢\u0006\u0004\bH\u0010\u000bJ\"\u0010K\u001a\u00020\u00042\b\u0010I\u001a\u0004\u0018\u00010.2\u0006\u0010J\u001a\u00020*H\u0001¢\u0006\u0004\bK\u0010LJ,\u0010O\u001a\u00020\u00042\u0006\u0010M\u001a\u00020.2\b\u00106\u001a\u0004\u0018\u00010.2\b\u0010N\u001a\u0004\u0018\u00010\u0016H\u0001¢\u0006\u0004\bO\u0010PJ\u0018\u0010R\u001a\u00020\u00042\u0006\u0010Q\u001a\u00020.H\u0001¢\u0006\u0004\bR\u00101J \u0010T\u001a\u00020\u00042\u0006\u0010S\u001a\u00020*2\u0006\u0010;\u001a\u00020*H\u0001¢\u0006\u0004\bT\u0010=J\u001e\u0010U\u001a\u00020\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\fH\u0001¢\u0006\u0004\bU\u0010\u000fR*\u0010[\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\f8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010\u000fR\u0018\u0010^\u001a\u0004\u0018\u00010 8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\\\u0010]¨\u0006h"}, d2 = {"Lcom/avito/android/serp/adapter/rich_snippets/job/AdvertRichJobItemViewImpl;", "Lcom/avito/android/serp/adapter/rich_snippets/job/AdvertRichJobItemView;", "Lcom/avito/android/serp/BaseSerpViewHolder;", "Lru/avito/component/serp/SerpAdvertRichJobCard;", "", "onUnbind", "()V", "", "Lcom/avito/android/remote/model/badge_bar/SerpBadge;", "badges", "bindBadgeBar", "(Ljava/util/List;)V", "Lkotlin/Function0;", "callback", "callClicks", "(Lkotlin/jvm/functions/Function0;)V", "clearActions", "clearListeners", "clearPictures", "clearSellerInfo", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "favoriteClicks", "Lcom/avito/android/image_loader/Picture;", "picture", "Landroid/net/Uri;", "getPictureUri", "(Lcom/avito/android/image_loader/Picture;)Landroid/net/Uri;", "Lkotlin/Function1;", "", "itemClicks", "(Lkotlin/jvm/functions/Function1;)V", "pictureChanges", "Landroid/os/Parcelable;", "state", "restoreGalleryState", "(Landroid/os/Parcelable;)V", "sellerClicks", "", "Lru/avito/component/serp/cyclic_gallery/image_carousel/ActionData;", "actions", "setActions", "(Ljava/util/Set;)V", "", "active", "setActive", "(Z)V", "", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "setAddress", "(Ljava/lang/String;)V", VKApiConst.POSITION, "smoothScroll", "setCurrentPicture", "(IZ)V", Sort.DATE, "setDate", "description", "setDescription", "favorite", "hasImages", "setFavorite", "(ZZ)V", "location", Sort.DISTANCE, "Lcom/avito/android/remote/model/Color;", "lines", "setLocation", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "Lru/avito/component/serp/PhoneLoadingState;", "setPhoneLoadingState", "(Lru/avito/component/serp/PhoneLoadingState;)V", "pictures", "setPictures", "price", "isHighlighted", "setPrice", "(Ljava/lang/String;Z)V", "name", "icon", "setSellerInfo", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/image_loader/Picture;)V", "title", "setTitle", "viewed", "setViewed", "writeClicks", "s", "Lkotlin/jvm/functions/Function0;", "getUnbindListener", "()Lkotlin/jvm/functions/Function0;", "setUnbindListener", "unbindListener", "getGalleryState", "()Landroid/os/Parcelable;", "galleryState", "Landroid/view/View;", "view", "Lru/avito/component/serp/cyclic_gallery/image_carousel/GalleryRatio;", "galleryRatio", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "recycledViewPool", "coloredContacts", "<init>", "(Landroid/view/View;Lru/avito/component/serp/cyclic_gallery/image_carousel/GalleryRatio;Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;Z)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertRichJobItemViewImpl extends BaseSerpViewHolder implements AdvertRichJobItemView, SerpAdvertRichJobCard {
    @Nullable
    public Function0<Unit> s;
    public final /* synthetic */ SerpAdvertRichJobCardImpl t;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AdvertRichJobItemViewImpl(View view, GalleryRatio galleryRatio, RecyclerView.RecycledViewPool recycledViewPool, boolean z, int i, j jVar) {
        this(view, (i & 2) != 0 ? null : galleryRatio, (i & 4) != 0 ? null : recycledViewPool, (i & 8) != 0 ? false : z);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichJobCard
    public void bindBadgeBar(@Nullable List<SerpBadge> list) {
        this.t.bindBadgeBar(list);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichJobCard
    public void callClicks(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "callback");
        this.t.callClicks(function0);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichJobCard
    public void clearActions() {
        this.t.clearActions();
    }

    @Override // ru.avito.component.serp.SerpAdvertRichJobCard
    public void clearListeners() {
        this.t.clearListeners();
    }

    @Override // ru.avito.component.serp.SerpAdvertRichJobCard
    public void clearPictures() {
        this.t.clearPictures();
    }

    @Override // ru.avito.component.serp.SerpAdvertRichJobCard
    public void clearSellerInfo() {
        this.t.clearSellerInfo();
    }

    @Override // ru.avito.component.serp.SerpAdvertRichJobCard
    public void favoriteClicks(@Nullable Function0<Unit> function0) {
        this.t.favoriteClicks(function0);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichJobCard
    @Nullable
    public Parcelable getGalleryState() {
        return this.t.getGalleryState();
    }

    @Override // ru.avito.component.serp.SerpAdvertRichJobCard
    @NotNull
    public Uri getPictureUri(@NotNull Picture picture) {
        Intrinsics.checkNotNullParameter(picture, "picture");
        return this.t.getPictureUri(picture);
    }

    @Override // com.avito.android.serp.adapter.rich_snippets.job.AdvertRichJobItemView
    @Nullable
    public Function0<Unit> getUnbindListener() {
        return this.s;
    }

    @Override // ru.avito.component.serp.SerpAdvertRichJobCard
    public void itemClicks(@NotNull Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "callback");
        this.t.itemClicks(function1);
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        Function0<Unit> unbindListener = getUnbindListener();
        if (unbindListener != null) {
            unbindListener.invoke();
        }
    }

    @Override // ru.avito.component.serp.SerpAdvertRichJobCard
    public void pictureChanges(@Nullable Function1<? super Integer, Unit> function1) {
        this.t.pictureChanges(function1);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichJobCard
    public void restoreGalleryState(@Nullable Parcelable parcelable) {
        this.t.restoreGalleryState(parcelable);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichJobCard
    public void sellerClicks(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "callback");
        this.t.sellerClicks(function0);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichJobCard
    public void setActions(@NotNull Set<ActionData> set) {
        Intrinsics.checkNotNullParameter(set, "actions");
        this.t.setActions(set);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichJobCard
    public void setActive(boolean z) {
        this.t.setActive(z);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichJobCard
    public void setAddress(@Nullable String str) {
        this.t.setAddress(str);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichJobCard
    public void setCurrentPicture(int i, boolean z) {
        this.t.setCurrentPicture(i, z);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichJobCard
    public void setDate(@Nullable String str) {
        this.t.setDate(str);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichJobCard
    public void setDescription(@Nullable String str) {
        this.t.setDescription(str);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichJobCard
    public void setFavorite(boolean z, boolean z2) {
        this.t.setFavorite(z, z2);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichJobCard
    public void setLocation(@Nullable String str, @Nullable String str2, @Nullable List<Color> list) {
        this.t.setLocation(str, str2, list);
    }

    @Override // ru.avito.component.serp.AsyncPhoneItemView
    public void setPhoneLoadingState(@NotNull PhoneLoadingState phoneLoadingState) {
        Intrinsics.checkNotNullParameter(phoneLoadingState, "state");
        this.t.setPhoneLoadingState(phoneLoadingState);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichJobCard
    public void setPictures(@NotNull List<? extends Picture> list) {
        Intrinsics.checkNotNullParameter(list, "pictures");
        this.t.setPictures(list);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichJobCard
    public void setPrice(@Nullable String str, boolean z) {
        this.t.setPrice(str, z);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichJobCard
    public void setSellerInfo(@NotNull String str, @Nullable String str2, @Nullable Picture picture) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.t.setSellerInfo(str, str2, picture);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichJobCard
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.t.setTitle(str);
    }

    @Override // com.avito.android.serp.adapter.rich_snippets.job.AdvertRichJobItemView
    public void setUnbindListener(@Nullable Function0<Unit> function0) {
        this.s = function0;
    }

    @Override // ru.avito.component.serp.SerpAdvertRichJobCard
    public void setViewed(boolean z, boolean z2) {
        this.t.setViewed(z, z2);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichJobCard
    public void writeClicks(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "callback");
        this.t.writeClicks(function0);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdvertRichJobItemViewImpl(@NotNull View view, @Nullable GalleryRatio galleryRatio, @Nullable RecyclerView.RecycledViewPool recycledViewPool, boolean z) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.t = new SerpAdvertRichJobCardImpl(view, galleryRatio, recycledViewPool, z);
    }
}
