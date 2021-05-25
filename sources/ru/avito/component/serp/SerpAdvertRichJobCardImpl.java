package ru.avito.component.serp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Parcelable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.design.widget.circular_progress.CircularProgressBar;
import com.avito.android.design.widget.circular_progress.CircularProgressDrawable;
import com.avito.android.image_loader.Picture;
import com.avito.android.lib.expected.badge_bar.CompactFlexibleLayout;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Color;
import com.avito.android.remote.model.Sort;
import com.avito.android.remote.model.badge_bar.SerpBadge;
import com.avito.android.ui_components.R;
import com.avito.android.util.Contexts;
import com.avito.android.util.Logs;
import com.avito.android.util.SimpleDraweeView;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.avito.android.util.rx3.InteropKt;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.SimpleAdapterPresenter;
import com.facebook.appevents.integrity.IntegrityManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.internal.CheckableImageButton;
import com.jakewharton.rxbinding3.view.RxView;
import com.jakewharton.rxrelay3.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.serp.cyclic_gallery.image_carousel.ActionData;
import ru.avito.component.serp.cyclic_gallery.image_carousel.ActionType;
import ru.avito.component.serp.cyclic_gallery.image_carousel.CarouselActions;
import ru.avito.component.serp.cyclic_gallery.image_carousel.GalleryRatio;
import ru.avito.component.serp.cyclic_gallery.image_carousel.ImageCarousel;
import ru.avito.component.serp.cyclic_gallery.image_carousel.ImageCarouselItemBlueprint;
import ru.avito.component.serp.cyclic_gallery.image_carousel.ImageCarouselItemPresenter;
import t6.n.y;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ü\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B3\u0012\u0007\u0010¡\u0001\u001a\u00020V\u0012\n\u0010½\u0001\u001a\u0005\u0018\u00010¼\u0001\u0012\n\u0010¿\u0001\u001a\u0005\u0018\u00010¾\u0001\u0012\u0007\u0010À\u0001\u001a\u00020\b¢\u0006\u0006\bÁ\u0001\u0010Â\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ3\u0010\u0011\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0006J\u0019\u0010\u0016\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0016\u0010\u0006J\u001d\u0010\u0019\u001a\u00020\u00042\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u000eH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\bH\u0017¢\u0006\u0004\b\u001f\u0010 J\u0019\u0010\"\u001a\u00020\u00042\b\u0010!\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\"\u0010\u0006J+\u0010%\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u00022\b\u0010$\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u0004H\u0016¢\u0006\u0004\b'\u0010\u001cJ\u001f\u0010*\u001a\u00020\u00042\u000e\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010(H\u0016¢\u0006\u0004\b*\u0010+J%\u0010/\u001a\u00020\u00042\u0014\u0010.\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010-\u0012\u0004\u0012\u00020\u00040,H\u0016¢\u0006\u0004\b/\u00100J\u001d\u00101\u001a\u00020\u00042\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00040(H\u0016¢\u0006\u0004\b1\u0010+J\u001d\u00102\u001a\u00020\u00042\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00040(H\u0016¢\u0006\u0004\b2\u0010+J\u001d\u00103\u001a\u00020\u00042\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00040(H\u0016¢\u0006\u0004\b3\u0010+J\u001f\u00106\u001a\u00020\u00042\u0006\u00104\u001a\u00020-2\u0006\u00105\u001a\u00020\bH\u0016¢\u0006\u0004\b6\u00107J%\u00108\u001a\u00020\u00042\u0014\u0010)\u001a\u0010\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u0004\u0018\u00010,H\u0016¢\u0006\u0004\b8\u00100J\u0017\u0010:\u001a\u00020\u00042\u0006\u00109\u001a\u00020\bH\u0016¢\u0006\u0004\b:\u0010;J\u001f\u0010=\u001a\u00020\u00042\u0006\u0010<\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\bH\u0016¢\u0006\u0004\b=\u0010 J\u0017\u0010@\u001a\u00020?2\u0006\u0010>\u001a\u00020\u0017H\u0016¢\u0006\u0004\b@\u0010AJ\u0019\u0010D\u001a\u00020\u00042\b\u0010C\u001a\u0004\u0018\u00010BH\u0016¢\u0006\u0004\bD\u0010EJ\u001d\u0010I\u001a\u00020\u00042\f\u0010H\u001a\b\u0012\u0004\u0012\u00020G0FH\u0016¢\u0006\u0004\bI\u0010JJ\u0017\u0010L\u001a\u00020\u00042\u0006\u0010C\u001a\u00020KH\u0016¢\u0006\u0004\bL\u0010MJ\u001f\u0010P\u001a\u00020\u00042\u000e\u0010O\u001a\n\u0012\u0004\u0012\u00020N\u0018\u00010\u000eH\u0016¢\u0006\u0004\bP\u0010\u001aJ\u000f\u0010Q\u001a\u00020\u0004H\u0016¢\u0006\u0004\bQ\u0010\u001cJ\u000f\u0010R\u001a\u00020\u0004H\u0016¢\u0006\u0004\bR\u0010\u001cJ\u001f\u0010U\u001a\u00020\u00042\u0006\u0010S\u001a\u00020\b2\u0006\u0010T\u001a\u00020\bH\u0002¢\u0006\u0004\bU\u0010 R\u0016\u0010Y\u001a\u00020V8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010]\u001a\u00020Z8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b[\u0010\\R\u001e\u0010b\u001a\n _*\u0004\u0018\u00010^0^8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010f\u001a\u00020c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bd\u0010eR\u0016\u0010h\u001a\u00020c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bg\u0010eR\u0016\u0010l\u001a\u00020i8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bj\u0010kR\u0016\u0010o\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bm\u0010nR\u0016\u0010s\u001a\u00020p8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bq\u0010rR\u0016\u0010u\u001a\u00020Z8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bt\u0010\\R\u0016\u0010w\u001a\u00020c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bv\u0010eR\u0016\u0010y\u001a\u00020c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bx\u0010eR\u0016\u0010}\u001a\u00020z8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b{\u0010|R\u0018\u0010\u0001\u001a\u00020~8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0018\u0010\u0001\u001a\u00020V8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010XR\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0018\u0010\u0001\u001a\u00020V8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010XR\u0018\u0010\u0001\u001a\u00020Z8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010\\R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0018\u0010\u0001\u001a\u00020c8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010eR\u0018\u0010\u0001\u001a\u00020V8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010XR \u0010\u0001\u001a\n\u0012\u0005\u0012\u00030\u00010\u00018\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\\\u0010\u0001R\u0018\u0010¡\u0001\u001a\u00020V8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b \u0001\u0010XR\u0018\u0010£\u0001\u001a\u00020V8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b¢\u0001\u0010XR\u001b\u0010¦\u0001\u001a\u0004\u0018\u00010B8V@\u0016X\u0004¢\u0006\b\u001a\u0006\b¤\u0001\u0010¥\u0001R\u0019\u0010©\u0001\u001a\u00030§\u00018\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\bU\u0010¨\u0001R\u0018\u0010«\u0001\u001a\u00020c8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\bª\u0001\u0010eR\u001c\u0010¯\u0001\u001a\u0005\u0018\u00010¬\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b­\u0001\u0010®\u0001R\u0018\u0010±\u0001\u001a\u00020c8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b°\u0001\u0010eR\u0018\u0010³\u0001\u001a\u00020V8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b²\u0001\u0010XR\u0018\u0010µ\u0001\u001a\u00020c8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b´\u0001\u0010eR\u0018\u0010·\u0001\u001a\u00020c8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b¶\u0001\u0010eR\u0018\u0010¹\u0001\u001a\u00020c8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b¸\u0001\u0010eR\u0018\u0010»\u0001\u001a\u00020c8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\bº\u0001\u0010e¨\u0006Ã\u0001"}, d2 = {"Lru/avito/component/serp/SerpAdvertRichJobCardImpl;", "Lru/avito/component/serp/SerpAdvertRichJobCard;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "price", "", "isHighlighted", "setPrice", "(Ljava/lang/String;Z)V", "location", Sort.DISTANCE, "", "Lcom/avito/android/remote/model/Color;", "lines", "setLocation", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "setAddress", Sort.DATE, "setDate", "Lcom/avito/android/image_loader/Picture;", "pictures", "setPictures", "(Ljava/util/List;)V", "clearPictures", "()V", "favorite", "hasImages", "setFavorite", "(ZZ)V", "description", "setDescription", "name", "icon", "setSellerInfo", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/image_loader/Picture;)V", "clearSellerInfo", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "favoriteClicks", "(Lkotlin/jvm/functions/Function0;)V", "Lkotlin/Function1;", "", "callback", "itemClicks", "(Lkotlin/jvm/functions/Function1;)V", "callClicks", "writeClicks", "sellerClicks", VKApiConst.POSITION, "smoothScroll", "setCurrentPicture", "(IZ)V", "pictureChanges", "active", "setActive", "(Z)V", "viewed", "setViewed", "picture", "Landroid/net/Uri;", "getPictureUri", "(Lcom/avito/android/image_loader/Picture;)Landroid/net/Uri;", "Landroid/os/Parcelable;", "state", "restoreGalleryState", "(Landroid/os/Parcelable;)V", "", "Lru/avito/component/serp/cyclic_gallery/image_carousel/ActionData;", "actions", "setActions", "(Ljava/util/Set;)V", "Lru/avito/component/serp/PhoneLoadingState;", "setPhoneLoadingState", "(Lru/avito/component/serp/PhoneLoadingState;)V", "Lcom/avito/android/remote/model/badge_bar/SerpBadge;", "badges", "bindBadgeBar", "clearActions", "clearListeners", "isActive", "isViewed", AuthSource.SEND_ABUSE, "Landroid/view/View;", "p", "Landroid/view/View;", "writeButton", "", "C", "F", "viewedAlpha", "Landroid/content/res/Resources;", "kotlin.jvm.PlatformType", ExifInterface.LONGITUDE_EAST, "Landroid/content/res/Resources;", "resources", "Landroid/widget/TextView;", a2.g.r.g.a, "Landroid/widget/TextView;", "distanceView", VKApiConst.Q, "callButtonText", "Lcom/avito/android/util/SimpleDraweeView;", VKApiConst.VERSION, "Lcom/avito/android/util/SimpleDraweeView;", "sellerLogo", "z", "I", "viewedBadgeMargin", "Lcom/google/android/material/internal/CheckableImageButton;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/google/android/material/internal/CheckableImageButton;", "favoriteButton", "B", "inactiveAlpha", "h", "priceView", "t", "sellerName", "Lcom/avito/android/lib/expected/badge_bar/CompactFlexibleLayout;", "w", "Lcom/avito/android/lib/expected/badge_bar/CompactFlexibleLayout;", "badgeBar", "Landroid/graphics/drawable/Drawable;", "y", "Landroid/graphics/drawable/Drawable;", "favoriteOnContentRedesignDrawable", "Lcom/avito/android/design/widget/circular_progress/CircularProgressBar;", "o", "Lcom/avito/android/design/widget/circular_progress/CircularProgressBar;", "phoneLoader", "c", "badgeContainer", "Landroidx/recyclerview/widget/RecyclerView;", "d", "Landroidx/recyclerview/widget/RecyclerView;", "galleryRecycler", "Lru/avito/component/serp/HighlightDelegate;", "x", "Lru/avito/component/serp/HighlightDelegate;", "priceHighlighter", "n", "callButton", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "activeAlpha", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "G", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "disposables", "j", "addressView", "l", "infoBadge", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lru/avito/component/serp/cyclic_gallery/image_carousel/CarouselActions;", "Lcom/jakewharton/rxrelay3/PublishRelay;", "consumer", "H", "view", "s", "sellerInfoDivider", "getGalleryState", "()Landroid/os/Parcelable;", "galleryState", "Landroid/widget/RelativeLayout;", "Landroid/widget/RelativeLayout;", "advertContent", "u", "sellerDate", "Lru/avito/component/serp/cyclic_gallery/image_carousel/ImageCarousel;", "D", "Lru/avito/component/serp/cyclic_gallery/image_carousel/ImageCarousel;", "gallery", "r", "writeButtonText", AuthSource.BOOKING_ORDER, "fieldsContainer", "e", "titleView", "f", "locationView", "k", "dateView", "i", "descriptionView", "Lru/avito/component/serp/cyclic_gallery/image_carousel/GalleryRatio;", "galleryRatio", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "recycledViewPool", "coloredContacts", "<init>", "(Landroid/view/View;Lru/avito/component/serp/cyclic_gallery/image_carousel/GalleryRatio;Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;Z)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class SerpAdvertRichJobCardImpl implements SerpAdvertRichJobCard {
    public final float A;
    public final float B;
    public final float C;
    public final ImageCarousel D;
    public final Resources E;
    public final PublishRelay<CarouselActions> F;
    public CompositeDisposable G;
    public final View H;
    public final RelativeLayout a;
    public final View b;
    public final View c;
    public final RecyclerView d;
    public final TextView e;
    public final TextView f;
    public final TextView g;
    public final TextView h;
    public final TextView i;
    public final TextView j;
    public final TextView k;
    public final View l;
    public final CheckableImageButton m;
    public final View n;
    public final CircularProgressBar o;
    public final View p;
    public final TextView q;
    public final TextView r;
    public final View s;
    public final TextView t;
    public final TextView u;
    public final SimpleDraweeView v;
    public final CompactFlexibleLayout w;
    public final HighlightDelegate x;
    public final Drawable y;
    public final int z = Views.dpToPx(this.H, 8);

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            PhoneLoadingState.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[1] = 1;
        }
    }

    public static final class a extends Lambda implements Function1<CircularProgressDrawable.Builder, Unit> {
        public final /* synthetic */ int a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i) {
            super(1);
            this.a = i;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(CircularProgressDrawable.Builder builder) {
            CircularProgressDrawable.Builder builder2 = builder;
            Intrinsics.checkNotNullParameter(builder2, "$receiver");
            builder2.color(this.a);
            return Unit.INSTANCE;
        }
    }

    public static final class b<T> implements Consumer<Unit> {
        public final /* synthetic */ Function0 a;

        public b(Function0 function0) {
            this.a = function0;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Unit unit) {
            this.a.invoke();
        }
    }

    public static final class c<T> implements Consumer<Throwable> {
        public static final c a = new c();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("SerpAdvertRichJobCard", "Click call error", th);
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public d(SerpAdvertRichJobCardImpl serpAdvertRichJobCardImpl, Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    public static final class e<T> implements Predicate<CarouselActions> {
        public static final e a = new e();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Predicate
        public boolean test(CarouselActions carouselActions) {
            return carouselActions instanceof CarouselActions.ImageClick;
        }
    }

    public static final class f<T, R> implements Function<CarouselActions.ImageClick, Integer> {
        public static final f a = new f();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public Integer apply(CarouselActions.ImageClick imageClick) {
            return Integer.valueOf(imageClick.getImagePosition());
        }
    }

    public static final class g<T, R> implements Function<Unit, Integer> {
        public static final g a = new g();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public Integer apply(Unit unit) {
            return -1;
        }
    }

    public static final class h<T> implements Consumer<Integer> {
        public final /* synthetic */ Function1 a;

        public h(Function1 function1) {
            this.a = function1;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Integer num) {
            Integer num2 = num;
            Function1 function1 = this.a;
            if (!(num2.intValue() >= 0)) {
                num2 = null;
            }
            function1.invoke(num2);
        }
    }

    public static final class i<T> implements Consumer<Throwable> {
        public static final i a = new i();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("SerpAdvertRichJobCard", "Click item error", th);
        }
    }

    public static final class j<T> implements Consumer<Unit> {
        public final /* synthetic */ Function0 a;

        public j(Function0 function0) {
            this.a = function0;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Unit unit) {
            this.a.invoke();
        }
    }

    public static final class k<T> implements Consumer<Throwable> {
        public static final k a = new k();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("SerpAdvertRichJobCard", "Click seller error", th);
        }
    }

    public static final class l<T> implements Consumer<Unit> {
        public final /* synthetic */ Function0 a;

        public l(Function0 function0) {
            this.a = function0;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Unit unit) {
            this.a.invoke();
        }
    }

    public static final class m<T> implements Consumer<Throwable> {
        public static final m a = new m();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("SerpAdvertRichJobCard", "Click write error", th);
        }
    }

    public SerpAdvertRichJobCardImpl(@NotNull View view, @Nullable GalleryRatio galleryRatio, @Nullable RecyclerView.RecycledViewPool recycledViewPool, boolean z2) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.H = view;
        View findViewById = view.findViewById(R.id.advert_content);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.RelativeLayout");
        this.a = (RelativeLayout) findViewById;
        View findViewById2 = view.findViewById(R.id.fields_container);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.View");
        this.b = findViewById2;
        View findViewById3 = view.findViewById(R.id.top_badge_container);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.view.View");
        this.c = findViewById3;
        View findViewById4 = view.findViewById(R.id.gallery);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        this.d = (RecyclerView) findViewById4;
        View findViewById5 = view.findViewById(R.id.title);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.widget.TextView");
        this.e = (TextView) findViewById5;
        View findViewById6 = view.findViewById(R.id.location);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type android.widget.TextView");
        this.f = (TextView) findViewById6;
        View findViewById7 = view.findViewById(R.id.distance);
        Objects.requireNonNull(findViewById7, "null cannot be cast to non-null type android.widget.TextView");
        this.g = (TextView) findViewById7;
        View findViewById8 = view.findViewById(R.id.price);
        Objects.requireNonNull(findViewById8, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) findViewById8;
        this.h = textView;
        View findViewById9 = view.findViewById(R.id.description);
        Objects.requireNonNull(findViewById9, "null cannot be cast to non-null type android.widget.TextView");
        this.i = (TextView) findViewById9;
        View findViewById10 = view.findViewById(R.id.address);
        Objects.requireNonNull(findViewById10, "null cannot be cast to non-null type android.widget.TextView");
        this.j = (TextView) findViewById10;
        View findViewById11 = view.findViewById(R.id.date);
        Objects.requireNonNull(findViewById11, "null cannot be cast to non-null type android.widget.TextView");
        this.k = (TextView) findViewById11;
        View findViewById12 = view.findViewById(R.id.card_info_badge);
        Objects.requireNonNull(findViewById12, "null cannot be cast to non-null type android.view.View");
        this.l = findViewById12;
        View findViewById13 = view.findViewById(R.id.btn_favorite);
        Objects.requireNonNull(findViewById13, "null cannot be cast to non-null type com.google.android.material.internal.CheckableImageButton");
        this.m = (CheckableImageButton) findViewById13;
        View findViewById14 = view.findViewById(R.id.btn_call);
        Objects.requireNonNull(findViewById14, "null cannot be cast to non-null type android.view.View");
        this.n = findViewById14;
        View findViewById15 = view.findViewById(R.id.phone_loader);
        Objects.requireNonNull(findViewById15, "null cannot be cast to non-null type com.avito.android.design.widget.circular_progress.CircularProgressBar");
        CircularProgressBar circularProgressBar = (CircularProgressBar) findViewById15;
        this.o = circularProgressBar;
        View findViewById16 = view.findViewById(R.id.btn_write);
        Objects.requireNonNull(findViewById16, "null cannot be cast to non-null type android.view.View");
        this.p = findViewById16;
        View findViewById17 = view.findViewById(R.id.call_button_text);
        Objects.requireNonNull(findViewById17, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView2 = (TextView) findViewById17;
        this.q = textView2;
        View findViewById18 = view.findViewById(R.id.write_button_text);
        Objects.requireNonNull(findViewById18, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView3 = (TextView) findViewById18;
        this.r = textView3;
        View findViewById19 = view.findViewById(R.id.seller_info_divider);
        Objects.requireNonNull(findViewById19, "null cannot be cast to non-null type android.view.View");
        this.s = findViewById19;
        View findViewById20 = view.findViewById(R.id.seller_name);
        Objects.requireNonNull(findViewById20, "null cannot be cast to non-null type android.widget.TextView");
        this.t = (TextView) findViewById20;
        View findViewById21 = view.findViewById(R.id.seller_date);
        Objects.requireNonNull(findViewById21, "null cannot be cast to non-null type android.widget.TextView");
        this.u = (TextView) findViewById21;
        View findViewById22 = view.findViewById(R.id.seller_logo);
        Objects.requireNonNull(findViewById22, "null cannot be cast to non-null type com.avito.android.util.SimpleDraweeView");
        this.v = (SimpleDraweeView) findViewById22;
        View findViewById23 = view.findViewById(R.id.badge_bar);
        Objects.requireNonNull(findViewById23, "null cannot be cast to non-null type com.avito.android.lib.expected.badge_bar.CompactFlexibleLayout");
        this.w = (CompactFlexibleLayout) findViewById23;
        this.x = new PriceHighlightDelegate(textView, false, false);
        Views.getDrawable(view, R.drawable.advert_item_grid_favorite);
        Views.getDrawable(view, R.drawable.advert_item_rich_job_favorite);
        this.y = Views.getDrawable(view, R.drawable.advert_item_list_favorite_red);
        Resources resources = this.H.getResources();
        this.E = resources;
        PublishRelay<CarouselActions> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.F = create;
        this.G = new CompositeDisposable();
        if (galleryRatio != null) {
            Views.show(this.d);
            ItemBinder build = new ItemBinder.Builder().registerItem(new ImageCarouselItemBlueprint(new ImageCarouselItemPresenter(create, galleryRatio.getImageWidthRatio()))).build();
            ImageCarousel imageCarousel = new ImageCarousel(this.d, new SimpleAdapterPresenter(build, build), build, recycledViewPool, false, null, null, 112, null);
            this.D = imageCarousel;
            Intrinsics.checkNotNullExpressionValue(resources, "resources");
            imageCarousel.setHeight((int) (galleryRatio.getGalleryHeightRatio() * ((float) ((resources.getDisplayMetrics().widthPixels - this.d.getPaddingLeft()) - this.d.getPaddingRight()))));
        } else {
            Views.hide(this.d);
            Views.changeMargin$default(this.b, 0, 0, 0, 0, 13, null);
            this.D = null;
        }
        if (!z2) {
            Context context = this.H.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            int colorByAttr = Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.black);
            int i2 = com.avito.android.lib.design.R.drawable.design_background_button_default;
            findViewById14.setBackgroundResource(i2);
            findViewById16.setBackgroundResource(i2);
            textView2.setTextColor(colorByAttr);
            textView3.setTextColor(colorByAttr);
            circularProgressBar.updateDrawable(new a(colorByAttr));
            TextViews.setCompoundDrawables$default(textView2, Views.getDrawable(this.H, R.drawable.ic_rds_call_green_20), (Drawable) null, (Drawable) null, (Drawable) null, 14, (Object) null);
            TextViews.setCompoundDrawables$default(textView3, Views.getDrawable(this.H, R.drawable.ic_rds_message_blue_20), (Drawable) null, (Drawable) null, (Drawable) null, 14, (Object) null);
        }
        TypedValue typedValue = new TypedValue();
        resources.getValue(R.dimen.inactive_alpha_old, typedValue, true);
        this.B = typedValue.getFloat();
        resources.getValue(R.dimen.active_alpha, typedValue, true);
        this.A = typedValue.getFloat();
        resources.getValue(R.dimen.viewed_alpha, typedValue, true);
        this.C = typedValue.getFloat();
    }

    public final void a(boolean z2, boolean z3) {
        if (z2 && z3) {
            Views.show(this.l);
        } else if (z2 && (!z3)) {
            this.a.setAlpha(this.A);
            Views.hide(this.l);
        } else if (!z2) {
            this.a.setAlpha(this.B);
            Views.setVisible(this.l, z3);
        }
    }

    @Override // ru.avito.component.serp.SerpAdvertRichJobCard
    public void bindBadgeBar(@Nullable List<SerpBadge> list) {
        BadgeBarsKt.bindBadges$default(this.w, list, null, 2, null);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichJobCard
    public void callClicks(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "callback");
        CompositeDisposable compositeDisposable = this.G;
        Disposable subscribe = InteropKt.toV3(RxView.clicks(this.n)).subscribe(new b(function0), c.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "callButton.clicks().toV3…Click call error\", it) })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichJobCard
    public void clearActions() {
        setActions(y.emptySet());
    }

    @Override // ru.avito.component.serp.SerpAdvertRichJobCard
    public void clearListeners() {
        this.G.clear();
    }

    @Override // ru.avito.component.serp.SerpAdvertRichJobCard
    public void clearPictures() {
        ImageCarousel imageCarousel = this.D;
        if (imageCarousel != null) {
            imageCarousel.setPictures(CollectionsKt__CollectionsKt.emptyList());
        }
        Views.changeMargin$default(this.b, 0, 0, 0, 0, 13, null);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichJobCard
    public void clearSellerInfo() {
        Views.hide(this.s);
        this.t.setText((CharSequence) null);
        Views.hide(this.t);
        this.u.setText((CharSequence) null);
        Views.hide(this.u);
        SimpleDraweeViewsKt.getRequestBuilder(this.v).clear();
        Views.hide(this.v);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichJobCard
    public void favoriteClicks(@Nullable Function0<Unit> function0) {
        if (function0 != null) {
            this.m.setOnClickListener(new d(this, function0));
        } else {
            this.m.setOnClickListener(null);
        }
    }

    @Override // ru.avito.component.serp.SerpAdvertRichJobCard
    @Nullable
    public Parcelable getGalleryState() {
        ImageCarousel imageCarousel = this.D;
        if (imageCarousel != null) {
            return imageCarousel.getState();
        }
        return null;
    }

    @Override // ru.avito.component.serp.SerpAdvertRichJobCard
    @NotNull
    public Uri getPictureUri(@NotNull Picture picture) {
        Intrinsics.checkNotNullParameter(picture, "picture");
        View findViewById = this.H.findViewById(R.id.gallery);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        return picture.getUri(findViewById);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichJobCard
    public void itemClicks(@NotNull Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "callback");
        CompositeDisposable compositeDisposable = this.G;
        Observable<CarouselActions> filter = this.F.filter(e.a);
        Intrinsics.checkNotNullExpressionValue(filter, "consumer.filter { it is …ouselActions.ImageClick }");
        Observable<U> cast = filter.cast(CarouselActions.ImageClick.class);
        Intrinsics.checkExpressionValueIsNotNull(cast, "cast(R::class.java)");
        Disposable subscribe = cast.map(f.a).mergeWith(InteropKt.toV3(RxView.clicks(this.H)).map(g.a)).subscribe(new h(function1), i.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "consumer.filter { it is …Click item error\", it) })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichJobCard
    public void pictureChanges(@Nullable Function1<? super Integer, Unit> function1) {
        ImageCarousel imageCarousel = this.D;
        if (imageCarousel != null) {
            imageCarousel.setPictureChangeListener(function1);
        }
    }

    @Override // ru.avito.component.serp.SerpAdvertRichJobCard
    public void restoreGalleryState(@Nullable Parcelable parcelable) {
        if (parcelable != null) {
            ImageCarousel imageCarousel = this.D;
            if (imageCarousel != null) {
                imageCarousel.restoreState(parcelable);
                return;
            }
            return;
        }
        ImageCarousel imageCarousel2 = this.D;
        if (imageCarousel2 != null) {
            imageCarousel2.resetState();
        }
    }

    @Override // ru.avito.component.serp.SerpAdvertRichJobCard
    public void sellerClicks(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "callback");
        CompositeDisposable compositeDisposable = this.G;
        Disposable subscribe = Observable.merge(InteropKt.toV3(RxView.clicks(this.v)), InteropKt.toV3(RxView.clicks(this.t)), InteropKt.toV3(RxView.clicks(this.u))).subscribe(new j(function0), k.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "Observable.merge(sellerL…ick seller error\", it) })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichJobCard
    public void setActions(@NotNull Set<ActionData> set) {
        boolean z2;
        String str;
        T t2;
        T t3;
        boolean z3;
        boolean z4;
        Intrinsics.checkNotNullParameter(set, "actions");
        Iterator<T> it = set.iterator();
        while (true) {
            z2 = true;
            str = null;
            if (!it.hasNext()) {
                t2 = null;
                break;
            }
            t2 = it.next();
            if (t2.getActionType() == ActionType.CALL) {
                z4 = true;
                continue;
            } else {
                z4 = false;
                continue;
            }
            if (z4) {
                break;
            }
        }
        T t4 = t2;
        Iterator<T> it2 = set.iterator();
        while (true) {
            if (!it2.hasNext()) {
                t3 = null;
                break;
            }
            t3 = it2.next();
            if (t3.getActionType() == ActionType.WRITE) {
                z3 = true;
                continue;
            } else {
                z3 = false;
                continue;
            }
            if (z3) {
                break;
            }
        }
        T t5 = t3;
        Views.setVisible(this.n, t4 != null);
        View view = this.p;
        if (t5 == null) {
            z2 = false;
        }
        Views.setVisible(view, z2);
        this.q.setText(t4 != null ? t4.getTitle() : null);
        TextView textView = this.r;
        if (t5 != null) {
            str = t5.getTitle();
        }
        textView.setText(str);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichJobCard
    public void setActive(boolean z2) {
        boolean z3 = this.a.getAlpha() == this.C;
        this.H.setClickable(z2);
        a(z2, z3);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichJobCard
    public void setAddress(@Nullable String str) {
        TextViews.bindText$default(this.j, str, false, 2, null);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichJobCard
    public void setCurrentPicture(int i2, boolean z2) {
        ImageCarousel imageCarousel = this.D;
        if (imageCarousel != null) {
            imageCarousel.setCurrentPicture(i2, z2);
        }
    }

    @Override // ru.avito.component.serp.SerpAdvertRichJobCard
    public void setDate(@Nullable String str) {
        TextViews.bindText$default(this.k, str, false, 2, null);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichJobCard
    public void setDescription(@Nullable String str) {
        TextViews.bindText$default(this.i, str, false, 2, null);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichJobCard
    @SuppressLint({"RestrictedApi"})
    public void setFavorite(boolean z2, boolean z3) {
        this.m.setChecked(z2);
        ViewGroup.LayoutParams layoutParams = this.m.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        if (z3) {
            Views.show(this.d);
            this.m.setImageDrawable(this.y);
            Views.changeMargin$default(this.m, 0, Views.dpToPx(this.H, 9), Views.dpToPx(this.H, 12), 0, 9, null);
            layoutParams2.removeRule(10);
            layoutParams2.addRule(3, this.c.getId());
        } else {
            Views.hide(this.d);
            this.m.setImageDrawable(this.y);
            Views.changeMargin$default(this.m, 0, Views.dpToPx(this.H, -1), Views.dpToPx(this.H, 12), 0, 9, null);
            layoutParams2.removeRule(10);
            layoutParams2.addRule(3, this.c.getId());
        }
        this.m.requestLayout();
    }

    @Override // ru.avito.component.serp.SerpAdvertRichJobCard
    public void setLocation(@Nullable String str, @Nullable String str2, @Nullable List<Color> list) {
        MetroLinesDrawable metroLinesDrawable = null;
        TextViews.bindText$default(this.f, str, false, 2, null);
        TextViews.bindText$default(this.g, str2, false, 2, null);
        if (list != null) {
            Context context = this.H.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            metroLinesDrawable = new MetroLinesDrawable(context, list);
        }
        TextViews.setCompoundDrawables$default(this.f, metroLinesDrawable, (Drawable) null, (Drawable) null, (Drawable) null, 14, (Object) null);
    }

    @Override // ru.avito.component.serp.AsyncPhoneItemView
    public void setPhoneLoadingState(@NotNull PhoneLoadingState phoneLoadingState) {
        Intrinsics.checkNotNullParameter(phoneLoadingState, "state");
        this.n.setEnabled(phoneLoadingState == PhoneLoadingState.IDLE);
        if (phoneLoadingState.ordinal() != 1) {
            Views.show(this.q);
            Views.hide(this.o);
            return;
        }
        Views.conceal(this.q);
        Views.show(this.o);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichJobCard
    public void setPictures(@NotNull List<? extends Picture> list) {
        Intrinsics.checkNotNullParameter(list, "pictures");
        ImageCarousel imageCarousel = this.D;
        if (imageCarousel != null) {
            imageCarousel.setPictures(list);
        }
        Views.changeMargin$default(this.b, 0, Views.dpToPx(this.H, 10), 0, 0, 13, null);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichJobCard
    public void setPrice(@Nullable String str, boolean z2) {
        this.x.setText(str, z2);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichJobCard
    public void setSellerInfo(@NotNull String str, @Nullable String str2, @Nullable Picture picture) {
        Intrinsics.checkNotNullParameter(str, "name");
        Views.show(this.s);
        this.t.setText(str);
        Views.show(this.t);
        TextViews.bindText$default(this.u, str2, false, 2, null);
        SimpleDraweeViewsKt.loadPicture$default(this.v, picture, null, null, 6, null);
        Views.show(this.v);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichJobCard
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.e.setText(str);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichJobCard
    public void setViewed(boolean z2, boolean z3) {
        a(this.a.getAlpha() != this.B, z2);
        if (z3) {
            View view = this.l;
            int i2 = this.z;
            Views.changeMargin$default(view, i2, i2, 0, 0, 12, null);
            return;
        }
        Views.changeMargin$default(this.l, 0, 0, 0, 0, 12, null);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichJobCard
    public void writeClicks(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "callback");
        CompositeDisposable compositeDisposable = this.G;
        Disposable subscribe = InteropKt.toV3(RxView.clicks(this.p)).subscribe(new l(function0), m.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "writeButton.clicks().toV…lick write error\", it) })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }
}
