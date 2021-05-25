package ru.avito.component.serp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Parcelable;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.image_loader.Picture;
import com.avito.android.lib.expected.badge_bar.BadgeViewListener;
import com.avito.android.lib.expected.badge_bar.CompactFlexibleLayout;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Sort;
import com.avito.android.remote.model.badge.Badge;
import com.avito.android.remote.model.badge_bar.SerpBadge;
import com.avito.android.ui_components.R;
import com.avito.android.util.Logs;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.avito.android.util.rx3.InteropKt;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.SimpleAdapterPresenter;
import com.facebook.appevents.integrity.IntegrityManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.internal.CheckableImageButton;
import com.google.firebase.analytics.FirebaseAnalytics;
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
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.serp.GalleryBadgeDecoration;
import ru.avito.component.serp.cyclic_gallery.image_carousel.ActionData;
import ru.avito.component.serp.cyclic_gallery.image_carousel.ActionType;
import ru.avito.component.serp.cyclic_gallery.image_carousel.CarouselActions;
import ru.avito.component.serp.cyclic_gallery.image_carousel.GalleryRatio;
import ru.avito.component.serp.cyclic_gallery.image_carousel.ImageCarousel;
import ru.avito.component.serp.cyclic_gallery.image_carousel.seller_info.CarouselSellerItem;
import ru.avito.component.serp.cyclic_gallery.image_carousel.seller_info.SellerInfoParams;
import t6.n.y;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010x\u001a\u00020u\u0012\b\u0010â\u0001\u001a\u00030á\u0001\u0012\b\u0010ä\u0001\u001a\u00030ã\u0001\u0012\u0007\u0010å\u0001\u001a\u00020\u0002\u0012\b\u0010Ô\u0001\u001a\u00030Ñ\u0001\u0012\u0007\u0010\u0001\u001a\u00020\u0002¢\u0006\u0006\bæ\u0001\u0010ç\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u000e\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\b2\u0006\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0011\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u0011\u0010\u000bJ\u0019\u0010\u0013\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u0013\u0010\u000bJ\u0019\u0010\u0015\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u0015\u0010\u000bJ\u0019\u0010\u0017\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u0017\u0010\u000bJ\u0019\u0010\u0019\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u0019\u0010\u000bJ\u0019\u0010\u001b\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u001b\u0010\u000bJ\u001d\u0010\u001f\u001a\u00020\u00052\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0005H\u0016¢\u0006\u0004\b!\u0010\"J\u0019\u0010$\u001a\u00020\u00052\b\u0010#\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b$\u0010\u000bJ#\u0010$\u001a\u00020\u00052\b\u0010#\u001a\u0004\u0018\u00010\b2\b\u0010%\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b$\u0010&J\u0017\u0010(\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u0002H\u0016¢\u0006\u0004\b(\u0010)J\u0017\u0010+\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u0002H\u0017¢\u0006\u0004\b+\u0010)J\u0019\u0010-\u001a\u00020\u00052\b\u0010,\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b-\u0010\u000bJ\u0017\u0010/\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u0002H\u0016¢\u0006\u0004\b/\u0010)J\u001f\u00102\u001a\u00020\u00052\u000e\u00101\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u000100H\u0016¢\u0006\u0004\b2\u00103J\u0019\u00105\u001a\u00020\u00052\b\u00104\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b5\u0010\u000bJ%\u00109\u001a\u00020\u00052\u0014\u00108\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u000107\u0012\u0004\u0012\u00020\u000506H\u0016¢\u0006\u0004\b9\u0010:J#\u0010;\u001a\u00020\u00052\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000506H\u0016¢\u0006\u0004\b;\u0010:J#\u0010<\u001a\u00020\u00052\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000506H\u0016¢\u0006\u0004\b<\u0010:J#\u0010>\u001a\u00020\u00052\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020\u000506H\u0016¢\u0006\u0004\b>\u0010:J\u001f\u0010A\u001a\u00020\u00052\u0006\u0010?\u001a\u0002072\u0006\u0010@\u001a\u00020\u0002H\u0016¢\u0006\u0004\bA\u0010BJ%\u0010C\u001a\u00020\u00052\u0014\u00101\u001a\u0010\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\u0005\u0018\u000106H\u0016¢\u0006\u0004\bC\u0010:J%\u0010D\u001a\u00020\u00052\u0014\u00101\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0018\u000106H\u0016¢\u0006\u0004\bD\u0010:J\u0017\u0010F\u001a\u00020\u00052\u0006\u0010E\u001a\u00020\u0002H\u0016¢\u0006\u0004\bF\u0010)J\u0017\u0010H\u001a\u00020\u00052\u0006\u0010G\u001a\u00020\u0002H\u0016¢\u0006\u0004\bH\u0010)J\u0019\u0010J\u001a\u00020\u00052\b\u0010I\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\bJ\u0010\u000bJ\u0017\u0010M\u001a\u00020L2\u0006\u0010K\u001a\u00020\u001dH\u0016¢\u0006\u0004\bM\u0010NJ\u0019\u0010Q\u001a\u00020\u00052\b\u0010P\u001a\u0004\u0018\u00010OH\u0016¢\u0006\u0004\bQ\u0010RJ\u001d\u0010V\u001a\u00020\u00052\f\u0010U\u001a\b\u0012\u0004\u0012\u00020T0SH\u0016¢\u0006\u0004\bV\u0010WJ\u000f\u0010X\u001a\u00020\u0005H\u0016¢\u0006\u0004\bX\u0010\"J\u0019\u0010[\u001a\u00020\u00052\b\u0010Z\u001a\u0004\u0018\u00010YH\u0016¢\u0006\u0004\b[\u0010\\J\u0017\u0010_\u001a\u00020\u00052\u0006\u0010^\u001a\u00020]H\u0016¢\u0006\u0004\b_\u0010`J\u000f\u0010a\u001a\u00020\u0005H\u0016¢\u0006\u0004\ba\u0010\"J)\u0010f\u001a\u00020\u00052\u000e\u0010c\u001a\n\u0012\u0004\u0012\u00020b\u0018\u00010\u001c2\b\u0010e\u001a\u0004\u0018\u00010dH\u0016¢\u0006\u0004\bf\u0010gJ\u0017\u0010i\u001a\u00020\u00052\u0006\u0010h\u001a\u00020\u0002H\u0016¢\u0006\u0004\bi\u0010)J\u0017\u0010k\u001a\u00020\u00052\u0006\u0010j\u001a\u00020\u0002H\u0016¢\u0006\u0004\bk\u0010)J\u000f\u0010l\u001a\u00020\u0005H\u0016¢\u0006\u0004\bl\u0010\"J\u001f\u0010m\u001a\u00020\u00052\u000e\u00101\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u000100H\u0016¢\u0006\u0004\bm\u00103J\u0017\u0010o\u001a\u00020\u00052\u0006\u0010P\u001a\u00020nH\u0016¢\u0006\u0004\bo\u0010pR\u0016\u0010t\u001a\u00020q8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\br\u0010sR\u0016\u0010x\u001a\u00020u8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bv\u0010wR\u0016\u0010|\u001a\u00020y8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bz\u0010{R\u0016\u0010~\u001a\u00020q8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b}\u0010sR\u0019\u0010\u0001\u001a\u000208\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0018\u0010\u0001\u001a\u00020q8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010sR\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0019\u0010\u0001\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u0004\u0018\u00010q8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010sR\u0018\u0010\u0001\u001a\u00020q8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010sR\u001c\u0010\u0001\u001a\u0005\u0018\u00010\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R!\u0010\u0001\u001a\u000b \u0001*\u0004\u0018\u00010u0u8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010wR\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001c\u0010¢\u0001\u001a\u0005\u0018\u00010\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b \u0001\u0010¡\u0001R\u0018\u0010¤\u0001\u001a\u00020u8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b£\u0001\u0010wR\u0018\u0010¦\u0001\u001a\u00020u8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b¥\u0001\u0010wR\u0018\u0010¨\u0001\u001a\u00020q8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b§\u0001\u0010sR$\u0010¬\u0001\u001a\r \u0001*\u0005\u0018\u00010©\u00010©\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bª\u0001\u0010«\u0001R!\u0010°\u0001\u001a\n\u0012\u0005\u0012\u00030®\u00010­\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010¯\u0001R\u001a\u0010²\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b±\u0001\u0010\u0001R\u0019\u0010´\u0001\u001a\u0002078\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b³\u0001\u0010\u0001R\u001a\u0010¶\u0001\u001a\u0004\u0018\u00010q8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\bµ\u0001\u0010sR\u001a\u0010¸\u0001\u001a\u0004\u0018\u00010q8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b·\u0001\u0010sR\u001a\u0010º\u0001\u001a\u0004\u0018\u00010q8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b¹\u0001\u0010sR\u001a\u0010¼\u0001\u001a\u0004\u0018\u00010q8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b»\u0001\u0010sR\u0018\u0010¾\u0001\u001a\u00020q8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b½\u0001\u0010sR\u0017\u0010¿\u0001\u001a\u00020u8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010wR\u001a\u0010Á\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÀ\u0001\u0010\u0001R\u001a\u0010Ã\u0001\u001a\u0004\u0018\u00010u8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\bÂ\u0001\u0010wR\u001b\u0010Æ\u0001\u001a\u0004\u0018\u00010O8V@\u0016X\u0004¢\u0006\b\u001a\u0006\bÄ\u0001\u0010Å\u0001R\u0018\u0010È\u0001\u001a\u00020q8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\bÇ\u0001\u0010sR\u001a\u0010Ì\u0001\u001a\u00030É\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÊ\u0001\u0010Ë\u0001R\u0018\u0010Î\u0001\u001a\u00020q8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\bÍ\u0001\u0010sR\u0018\u0010Ð\u0001\u001a\u00020u8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\bÏ\u0001\u0010wR\u001a\u0010Ô\u0001\u001a\u00030Ñ\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÒ\u0001\u0010Ó\u0001R\u0018\u0010Ö\u0001\u001a\u00020q8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\bÕ\u0001\u0010sR\u001a\u0010Ú\u0001\u001a\u00030×\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bØ\u0001\u0010Ù\u0001R\u001a\u0010Ü\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÛ\u0001\u0010\u0001R\u001a\u0010à\u0001\u001a\u00030Ý\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÞ\u0001\u0010ß\u0001¨\u0006è\u0001"}, d2 = {"Lru/avito/component/serp/SerpAdvertRichCardImpl;", "Lru/avito/component/serp/SerpAdvertRichCard;", "", "isActive", "isViewed", "", AuthSource.SEND_ABUSE, "(ZZ)V", "", "title", "setTitle", "(Ljava/lang/String;)V", "price", "isHighlighted", "setPrice", "(Ljava/lang/String;Z)V", "value", "setDiscount", "priceWithoutDiscount", "setPriceWithoutDiscount", "location", "setLocation", Sort.DISTANCE, "setDistance", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "setAddress", Sort.DATE, "setDate", "", "Lcom/avito/android/image_loader/Picture;", "pictures", "setPictures", "(Ljava/util/List;)V", "clearPictures", "()V", "seller", "setSeller", "since", "(Ljava/lang/String;Ljava/lang/String;)V", "visible", "setFavoriteVisible", "(Z)V", "favorite", "setFavorite", "description", "setDescription", "isVisible", "setDeliveryVisible", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "favoriteClicks", "(Lkotlin/jvm/functions/Function0;)V", "actionText", "setCallActionText", "Lkotlin/Function1;", "", "callback", "itemClicks", "(Lkotlin/jvm/functions/Function1;)V", "callClicks", "writeClicks", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLinkClicks", VKApiConst.POSITION, "smoothScroll", "setCurrentPicture", "(IZ)V", "pictureChanges", "additionalContentVisibilityChanges", "active", "setActive", "viewed", "setViewed", "text", "setAdditionalActionText", "picture", "Landroid/net/Uri;", "getPictureUri", "(Lcom/avito/android/image_loader/Picture;)Landroid/net/Uri;", "Landroid/os/Parcelable;", "state", "restoreGalleryState", "(Landroid/os/Parcelable;)V", "", "Lru/avito/component/serp/cyclic_gallery/image_carousel/ActionData;", "actions", "setActions", "(Ljava/util/Set;)V", "clearActions", "Lru/avito/component/serp/cyclic_gallery/image_carousel/seller_info/CarouselSellerItem;", "sellerItem", "setSellerInfo", "(Lru/avito/component/serp/cyclic_gallery/image_carousel/seller_info/CarouselSellerItem;)V", "Lcom/avito/android/remote/model/badge/Badge;", "badge", "setBadge", "(Lcom/avito/android/remote/model/badge/Badge;)V", "hideBadge", "Lcom/avito/android/remote/model/badge_bar/SerpBadge;", "badges", "Lcom/avito/android/lib/expected/badge_bar/BadgeViewListener;", "badgeListener", "bindBadges", "(Ljava/util/List;Lcom/avito/android/lib/expected/badge_bar/BadgeViewListener;)V", "enlarged", "setVideoIconEnlarged", "hasVideo", "setHasVideo", "clearListeners", "setOnAdditionalActionClickListener", "Lru/avito/component/serp/PhoneLoadingState;", "setPhoneLoadingState", "(Lru/avito/component/serp/PhoneLoadingState;)V", "Landroid/widget/TextView;", "h", "Landroid/widget/TextView;", "sellerView", "Landroid/view/View;", "K", "Landroid/view/View;", "view", "Lru/avito/component/serp/HighlightDelegate;", "z", "Lru/avito/component/serp/HighlightDelegate;", "priceHighlighter", "p", "dateView", "Lru/avito/component/serp/BadgesView;", AuthSource.BOOKING_ORDER, "Lru/avito/component/serp/BadgesView;", "badgesView", AuthSource.OPEN_CHANNEL_LIST, "priceWithoutDiscountView", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "F", "activeAlpha", "M", "Z", "asyncText", "d", "badgeView", "k", "distanceView", "Landroid/widget/LinearLayout;", a2.g.r.g.a, "Landroid/widget/LinearLayout;", "sellerLayout", "Lru/avito/component/serp/GalleryBadgeDecoration;", "I", "Lru/avito/component/serp/GalleryBadgeDecoration;", "badgesDecoration", "kotlin.jvm.PlatformType", "c", "infoBadge", "Lcom/google/android/material/internal/CheckableImageButton;", "r", "Lcom/google/android/material/internal/CheckableImageButton;", "favoriteButton", "Lcom/avito/android/lib/expected/badge_bar/CompactFlexibleLayout;", "e", "Lcom/avito/android/lib/expected/badge_bar/CompactFlexibleLayout;", "badgeBar", "s", "callButton", "w", "hasDelivery", "j", "locationView", "Landroid/content/res/Resources;", ExifInterface.LONGITUDE_EAST, "Landroid/content/res/Resources;", "resources", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lru/avito/component/serp/cyclic_gallery/image_carousel/CarouselActions;", "Lcom/jakewharton/rxrelay3/PublishRelay;", "consumer", "H", "infoBadgeDecoration", "J", "photoViewType", VKApiConst.Q, "descriptionView", "x", "additionalActionView", VKApiConst.VERSION, "callButtonText", "i", "sellerSinceView", "n", FirebaseAnalytics.Param.DISCOUNT, "advertContent", "B", "inactiveAlpha", "u", "writeButton", "getGalleryState", "()Landroid/os/Parcelable;", "galleryState", "l", "priceView", "Landroid/widget/ImageView;", "y", "Landroid/widget/ImageView;", "hasVideoBadge", "f", "titleView", "t", "phoneLoader", "Lru/avito/component/serp/cyclic_gallery/image_carousel/seller_info/SellerInfoParams;", "L", "Lru/avito/component/serp/cyclic_gallery/image_carousel/seller_info/SellerInfoParams;", "sellerInfoParams", "o", "addressView", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "G", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "disposables", "C", "viewedAlpha", "Lru/avito/component/serp/cyclic_gallery/image_carousel/ImageCarousel;", "D", "Lru/avito/component/serp/cyclic_gallery/image_carousel/ImageCarousel;", "gallery", "Lru/avito/component/serp/cyclic_gallery/image_carousel/GalleryRatio;", "galleryRatio", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "recycledViewPool", "stickyBadgesEnabled", "<init>", "(Landroid/view/View;Lru/avito/component/serp/cyclic_gallery/image_carousel/GalleryRatio;Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;ZLru/avito/component/serp/cyclic_gallery/image_carousel/seller_info/SellerInfoParams;Z)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class SerpAdvertRichCardImpl implements SerpAdvertRichCard {
    public final float A;
    public final float B;
    public final float C;
    public final ImageCarousel D;
    public final Resources E;
    public final PublishRelay<CarouselActions> F;
    public CompositeDisposable G = new CompositeDisposable();
    public final GalleryBadgeDecoration H;
    public final GalleryBadgeDecoration I;
    public final int J;
    public final View K;
    public final SellerInfoParams L;
    public final boolean M;
    public final View a;
    public final BadgesView b;
    public final View c;
    public final TextView d;
    public final CompactFlexibleLayout e;
    public final TextView f;
    public final LinearLayout g;
    public final TextView h;
    public final TextView i;
    public final TextView j;
    public final TextView k;
    public final TextView l;
    public final TextView m;
    public final TextView n;
    public final TextView o;
    public final TextView p;
    public final TextView q;
    public final CheckableImageButton r;
    public final View s;
    public final View t;
    public final View u;
    public final TextView v;
    public final View w;
    public final TextView x;
    public final ImageView y;
    public final HighlightDelegate z;

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

    public static final class a extends Lambda implements Function1<RecyclerView, Unit> {
        public final /* synthetic */ SerpAdvertRichCardImpl a;
        public final /* synthetic */ Ref.ObjectRef b;
        public final /* synthetic */ Function1 c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(SerpAdvertRichCardImpl serpAdvertRichCardImpl, Ref.ObjectRef objectRef, Function1 function1) {
            super(1);
            this.a = serpAdvertRichCardImpl;
            this.b = objectRef;
            this.c = function1;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(RecyclerView recyclerView) {
            RecyclerView recyclerView2 = recyclerView;
            Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
            int lastVisiblePositionViewType = RecyclerViewsKt.getLastVisiblePositionViewType(recyclerView2);
            boolean z = (lastVisiblePositionViewType == -1 || lastVisiblePositionViewType == this.a.J) ? false : true;
            if (!Intrinsics.areEqual(Boolean.valueOf(z), this.b.element)) {
                this.b.element = (T) Boolean.valueOf(z);
                Function1 function1 = this.c;
                if (function1 != null) {
                    Unit unit = (Unit) function1.invoke(Boolean.valueOf(z));
                }
            }
            return Unit.INSTANCE;
        }
    }

    public static final class b<T> implements Predicate<CarouselActions> {
        public static final b a = new b();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Predicate
        public boolean test(CarouselActions carouselActions) {
            return carouselActions instanceof CarouselActions.CallClick;
        }
    }

    public static final class c<T, R> implements Function<CarouselActions, Boolean> {
        public static final c a = new c();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public /* bridge */ /* synthetic */ Boolean apply(CarouselActions carouselActions) {
            return Boolean.TRUE;
        }
    }

    public static final class d<T, R> implements Function<Unit, Boolean> {
        public static final d a = new d();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public /* bridge */ /* synthetic */ Boolean apply(Unit unit) {
            return Boolean.FALSE;
        }
    }

    public static final class e<T> implements Consumer<Boolean> {
        public final /* synthetic */ Function1 a;

        public e(Function1 function1) {
            this.a = function1;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Boolean bool) {
            Boolean bool2 = bool;
            Function1 function1 = this.a;
            Intrinsics.checkNotNullExpressionValue(bool2, "it");
            function1.invoke(bool2);
        }
    }

    public static final class f<T> implements Consumer<Throwable> {
        public static final f a = new f();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("SerpAdvertRichCard", "Click call error", th);
        }
    }

    public static final class g<T> implements Predicate<CarouselActions> {
        public static final g a = new g();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Predicate
        public boolean test(CarouselActions carouselActions) {
            return carouselActions instanceof CarouselActions.DeeplinkClick;
        }
    }

    public static final class h<T, R> implements Function<CarouselActions.DeeplinkClick, DeepLink> {
        public static final h a = new h();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public DeepLink apply(CarouselActions.DeeplinkClick deeplinkClick) {
            return deeplinkClick.getDeepLink();
        }
    }

    public static final class i<T> implements Consumer<DeepLink> {
        public final /* synthetic */ Function1 a;

        public i(Function1 function1) {
            this.a = function1;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(DeepLink deepLink) {
            DeepLink deepLink2 = deepLink;
            Function1 function1 = this.a;
            Intrinsics.checkNotNullExpressionValue(deepLink2, "it");
            function1.invoke(deepLink2);
        }
    }

    public static final class j<T> implements Consumer<Throwable> {
        public static final j a = new j();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("SerpAdvertRichCard", "DeepLink click error", th);
        }
    }

    public static final class k implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public k(SerpAdvertRichCardImpl serpAdvertRichCardImpl, Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    public static final class l<T> implements Predicate<CarouselActions> {
        public static final l a = new l();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Predicate
        public boolean test(CarouselActions carouselActions) {
            return carouselActions instanceof CarouselActions.ImageClick;
        }
    }

    public static final class m<T, R> implements Function<CarouselActions.ImageClick, Integer> {
        public static final m a = new m();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public Integer apply(CarouselActions.ImageClick imageClick) {
            return Integer.valueOf(imageClick.getImagePosition());
        }
    }

    public static final class n<T, R> implements Function<Unit, Integer> {
        public static final n a = new n();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public Integer apply(Unit unit) {
            return -1;
        }
    }

    public static final class o<T> implements Consumer<Integer> {
        public final /* synthetic */ Function1 a;

        public o(Function1 function1) {
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

    public static final class p<T> implements Consumer<Throwable> {
        public static final p a = new p();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("SerpAdvertRichCard", "Click image error", th);
        }
    }

    public static final class q implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public q(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    public static final class r<T> implements Predicate<CarouselActions> {
        public static final r a = new r();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Predicate
        public boolean test(CarouselActions carouselActions) {
            return carouselActions instanceof CarouselActions.WriteClick;
        }
    }

    public static final class s<T, R> implements Function<CarouselActions, Boolean> {
        public static final s a = new s();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public /* bridge */ /* synthetic */ Boolean apply(CarouselActions carouselActions) {
            return Boolean.TRUE;
        }
    }

    public static final class t<T, R> implements Function<Unit, Boolean> {
        public static final t a = new t();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public /* bridge */ /* synthetic */ Boolean apply(Unit unit) {
            return Boolean.FALSE;
        }
    }

    public static final class u<T> implements Consumer<Boolean> {
        public final /* synthetic */ Function1 a;

        public u(Function1 function1) {
            this.a = function1;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Boolean bool) {
            Boolean bool2 = bool;
            Function1 function1 = this.a;
            Intrinsics.checkNotNullExpressionValue(bool2, "it");
            function1.invoke(bool2);
        }
    }

    public static final class v<T> implements Consumer<Throwable> {
        public static final v a = new v();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("SerpAdvertRichCard", "Click write error", th);
        }
    }

    public SerpAdvertRichCardImpl(@NotNull View view, @NotNull GalleryRatio galleryRatio, @NotNull RecyclerView.RecycledViewPool recycledViewPool, boolean z2, @NotNull SellerInfoParams sellerInfoParams, boolean z3) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(galleryRatio, "galleryRatio");
        Intrinsics.checkNotNullParameter(recycledViewPool, "recycledViewPool");
        Intrinsics.checkNotNullParameter(sellerInfoParams, "sellerInfoParams");
        this.K = view;
        this.L = sellerInfoParams;
        this.M = z3;
        View findViewById = view.findViewById(R.id.advert_content);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        this.a = findViewById;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        BadgesView badgesView = new BadgesView(context, null, 0, 6, null);
        this.b = badgesView;
        LayoutInflater from = LayoutInflater.from(view.getContext());
        int i2 = R.layout.rich_snippet_info_viewed_badge;
        Objects.requireNonNull(view, "null cannot be cast to non-null type android.view.ViewGroup");
        this.c = from.inflate(i2, (ViewGroup) view, false);
        this.d = badgesView.getBadge();
        this.e = (CompactFlexibleLayout) view.findViewById(R.id.badge_bar);
        View findViewById2 = view.findViewById(R.id.title);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.f = (TextView) findViewById2;
        this.g = (LinearLayout) view.findViewById(R.id.seller_layout);
        View findViewById3 = view.findViewById(R.id.seller);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        this.h = (TextView) findViewById3;
        this.i = (TextView) view.findViewById(R.id.seller_since);
        View findViewById4 = view.findViewById(R.id.location);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.widget.TextView");
        this.j = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.distance);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.widget.TextView");
        this.k = (TextView) findViewById5;
        View findViewById6 = view.findViewById(R.id.price);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) findViewById6;
        this.l = textView;
        View findViewById7 = view.findViewById(R.id.price_without_discount);
        Objects.requireNonNull(findViewById7, "null cannot be cast to non-null type android.widget.TextView");
        this.m = (TextView) findViewById7;
        View findViewById8 = view.findViewById(R.id.discount);
        Objects.requireNonNull(findViewById8, "null cannot be cast to non-null type android.widget.TextView");
        this.n = (TextView) findViewById8;
        View findViewById9 = view.findViewById(R.id.address);
        Objects.requireNonNull(findViewById9, "null cannot be cast to non-null type android.widget.TextView");
        this.o = (TextView) findViewById9;
        View findViewById10 = view.findViewById(R.id.date);
        Objects.requireNonNull(findViewById10, "null cannot be cast to non-null type android.widget.TextView");
        this.p = (TextView) findViewById10;
        this.q = (TextView) view.findViewById(R.id.description);
        View findViewById11 = view.findViewById(R.id.btn_favorite);
        Objects.requireNonNull(findViewById11, "null cannot be cast to non-null type com.google.android.material.internal.CheckableImageButton");
        this.r = (CheckableImageButton) findViewById11;
        View findViewById12 = view.findViewById(R.id.btn_call);
        Objects.requireNonNull(findViewById12, "null cannot be cast to non-null type android.view.View");
        this.s = findViewById12;
        View findViewById13 = view.findViewById(R.id.phone_loader);
        Objects.requireNonNull(findViewById13, "null cannot be cast to non-null type android.view.View");
        this.t = findViewById13;
        this.u = view.findViewById(R.id.btn_write);
        this.v = (TextView) view.findViewById(R.id.call_button_text);
        this.w = badgesView.getHasDelivery();
        this.x = (TextView) view.findViewById(R.id.additional_action);
        ImageView hasVideoBadge = badgesView.getHasVideoBadge();
        this.y = hasVideoBadge;
        this.z = new PriceHighlightDelegate(textView, true, z3);
        Resources resources = view.getResources();
        this.E = resources;
        PublishRelay<CarouselActions> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.F = create;
        View findViewById14 = this.K.findViewById(R.id.gallery);
        Objects.requireNonNull(findViewById14, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById14;
        ImageGalleryItemBinderFactoryImpl imageGalleryItemBinderFactoryImpl = new ImageGalleryItemBinderFactoryImpl(create, galleryRatio, this.L);
        ItemBinder itemBinder = imageGalleryItemBinderFactoryImpl.getItemBinder();
        ImageCarousel imageCarousel = new ImageCarousel(recyclerView, new SimpleAdapterPresenter(itemBinder, itemBinder), itemBinder, recycledViewPool, false, null, null, 112, null);
        this.D = imageCarousel;
        int photoViewType = imageGalleryItemBinderFactoryImpl.getPhotoViewType();
        this.J = photoViewType;
        GalleryBadgeDecoration galleryBadgeDecoration = new GalleryBadgeDecoration(this.b, GalleryBadgeDecoration.DecorationGravity.BOTTOM, photoViewType, z2);
        this.I = galleryBadgeDecoration;
        imageCarousel.addItemDecoration(galleryBadgeDecoration);
        View view2 = this.c;
        Intrinsics.checkNotNullExpressionValue(view2, "infoBadge");
        this.H = new GalleryBadgeDecoration(view2, GalleryBadgeDecoration.DecorationGravity.TOP, photoViewType, z2);
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        imageCarousel.setHeight((int) (galleryRatio.getGalleryHeightRatio() * ((float) ((resources.getDisplayMetrics().widthPixels - recyclerView.getPaddingLeft()) - recyclerView.getPaddingRight()))));
        hasVideoBadge.setBackground(BadgesKt.getBadgeBackground$default(this.K, null, 1, null));
        TypedValue typedValue = new TypedValue();
        resources.getValue(R.dimen.inactive_alpha_old, typedValue, true);
        this.B = typedValue.getFloat();
        resources.getValue(R.dimen.active_alpha, typedValue, true);
        this.A = typedValue.getFloat();
        resources.getValue(R.dimen.viewed_alpha, typedValue, true);
        this.C = typedValue.getFloat();
    }

    public final void a(boolean z2, boolean z3) {
        this.D.removeItemDecoration(this.H);
        if (z2 && z3) {
            this.D.addItemDecoration(this.H);
        } else if (z2 && (!z3)) {
            this.a.setAlpha(this.A);
        } else if (!z2) {
            this.a.setAlpha(this.B);
        }
    }

    @Override // ru.avito.component.serp.SerpAdvertRichCard
    public void additionalContentVisibilityChanges(@Nullable Function1<? super Boolean, Unit> function1) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = null;
        this.D.setOnScrollChangedListener(new a(this, objectRef, function1));
    }

    @Override // ru.avito.component.serp.SerpAdvertRichCard
    public void bindBadges(@Nullable List<SerpBadge> list, @Nullable BadgeViewListener badgeViewListener) {
        CompactFlexibleLayout compactFlexibleLayout = this.e;
        if (compactFlexibleLayout != null) {
            BadgeBarsKt.bindBadges(compactFlexibleLayout, list, badgeViewListener);
        }
    }

    @Override // ru.avito.component.serp.SerpAdvertRichCard
    public void callClicks(@NotNull Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "callback");
        CompositeDisposable compositeDisposable = this.G;
        Disposable subscribe = this.F.filter(b.a).map(c.a).mergeWith(InteropKt.toV3(RxView.clicks(this.s)).map(d.a)).subscribe(new e(function1), f.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "consumer.filter { it is …Click call error\", it) })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichCard
    public void clearActions() {
        setActions(y.emptySet());
        Views.setVisible(this.s, false);
        TextView textView = this.v;
        if (textView != null) {
            Views.setVisible(textView, false);
        }
    }

    @Override // ru.avito.component.serp.SerpAdvertRichCard
    public void clearListeners() {
        this.G.clear();
    }

    @Override // ru.avito.component.serp.SerpAdvertRichCard
    public void clearPictures() {
        this.D.setPictures(CollectionsKt__CollectionsKt.emptyList());
    }

    @Override // ru.avito.component.serp.SerpAdvertRichCard
    public void deepLinkClicks(@NotNull Function1<? super DeepLink, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "callback");
        CompositeDisposable compositeDisposable = this.G;
        Observable<CarouselActions> filter = this.F.filter(g.a);
        Intrinsics.checkNotNullExpressionValue(filter, "consumer.filter { it is …elActions.DeeplinkClick }");
        Observable<U> cast = filter.cast(CarouselActions.DeeplinkClick.class);
        Intrinsics.checkExpressionValueIsNotNull(cast, "cast(R::class.java)");
        Disposable subscribe = cast.map(h.a).subscribe(new i(function1), j.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "consumer.filter { it is …Link click error\", it) })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichCard
    public void favoriteClicks(@Nullable Function0<Unit> function0) {
        if (function0 != null) {
            this.r.setOnClickListener(new k(this, function0));
        } else {
            this.r.setOnClickListener(null);
        }
    }

    @Override // ru.avito.component.serp.SerpAdvertRichCard
    @Nullable
    public Parcelable getGalleryState() {
        return this.D.getState();
    }

    @Override // ru.avito.component.serp.SerpAdvertRichCard
    @NotNull
    public Uri getPictureUri(@NotNull Picture picture) {
        Intrinsics.checkNotNullParameter(picture, "picture");
        View findViewById = this.K.findViewById(R.id.gallery);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        return picture.getUri(findViewById);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichCard
    public void hideBadge() {
        Views.setVisible(this.d, false);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichCard
    public void itemClicks(@NotNull Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "callback");
        CompositeDisposable compositeDisposable = this.G;
        Observable<CarouselActions> filter = this.F.filter(l.a);
        Intrinsics.checkNotNullExpressionValue(filter, "consumer.filter { it is …ouselActions.ImageClick }");
        Observable<U> cast = filter.cast(CarouselActions.ImageClick.class);
        Intrinsics.checkExpressionValueIsNotNull(cast, "cast(R::class.java)");
        Disposable subscribe = cast.map(m.a).mergeWith(InteropKt.toV3(RxView.clicks(this.K)).map(n.a)).subscribe(new o(function1), p.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "consumer.filter { it is …lick image error\", it) })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichCard
    public void pictureChanges(@Nullable Function1<? super Integer, Unit> function1) {
        this.D.setPictureChangeListener(function1);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichCard
    public void restoreGalleryState(@Nullable Parcelable parcelable) {
        if (parcelable != null) {
            this.D.restoreState(parcelable);
        } else {
            this.D.resetState();
        }
    }

    @Override // ru.avito.component.serp.SerpAdvertRichCard
    public void setActions(@NotNull Set<ActionData> set) {
        T t2;
        boolean z2;
        T t3;
        boolean z3;
        boolean z4;
        Intrinsics.checkNotNullParameter(set, "actions");
        set.size();
        this.D.setActions(set);
        View view = this.s;
        Iterator<T> it = set.iterator();
        while (true) {
            t2 = null;
            z2 = true;
            if (!it.hasNext()) {
                t3 = null;
                break;
            }
            t3 = it.next();
            if (t3.getActionType() == ActionType.CALL) {
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
        Views.setVisible(view, t3 != null);
        View view2 = this.u;
        if (view2 != null) {
            Iterator<T> it2 = set.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                T next = it2.next();
                if (next.getActionType() == ActionType.WRITE) {
                    z3 = true;
                    continue;
                } else {
                    z3 = false;
                    continue;
                }
                if (z3) {
                    t2 = next;
                    break;
                }
            }
            if (t2 == null) {
                z2 = false;
            }
            Views.setVisible(view2, z2);
        }
    }

    @Override // ru.avito.component.serp.SerpAdvertRichCard
    public void setActive(boolean z2) {
        boolean z3 = this.a.getAlpha() == this.C;
        this.K.setClickable(z2);
        a(z2, z3);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichCard
    public void setAdditionalActionText(@Nullable String str) {
        TextView textView = this.x;
        if (textView != null) {
            PrecomputedTextViewKt.bindTextAsync(textView, str, this.M);
        }
        Resources resources = this.K.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "view.resources");
        float f2 = ((float) 4) * resources.getDisplayMetrics().density;
        TextView textView2 = this.x;
        if (textView2 != null) {
            Views.extendTouchableArea(textView2, t6.s.c.roundToInt(f2));
        }
    }

    @Override // ru.avito.component.serp.SerpAdvertRichCard
    public void setAddress(@Nullable String str) {
        PrecomputedTextViewKt.bindTextAsync(this.o, str, this.M);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichCard
    public void setBadge(@NotNull Badge badge) {
        Intrinsics.checkNotNullParameter(badge, "badge");
        TextView textView = this.d;
        if (textView != null) {
            Views.setVisible(textView, true);
            BadgesKt.setBadge(this.d, badge);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0016, code lost:
        if ((r3.length() > 0) != false) goto L_0x001a;
     */
    @Override // ru.avito.component.serp.SerpAdvertRichCard
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setCallActionText(@org.jetbrains.annotations.Nullable java.lang.String r3) {
        /*
            r2 = this;
            android.widget.TextView r0 = r2.v
            if (r0 == 0) goto L_0x0009
            boolean r1 = r2.M
            ru.avito.component.serp.PrecomputedTextViewKt.bindTextAsync(r0, r3, r1)
        L_0x0009:
            r0 = 1
            r1 = 0
            if (r3 == 0) goto L_0x0019
            int r3 = r3.length()
            if (r3 <= 0) goto L_0x0015
            r3 = 1
            goto L_0x0016
        L_0x0015:
            r3 = 0
        L_0x0016:
            if (r3 == 0) goto L_0x0019
            goto L_0x001a
        L_0x0019:
            r0 = 0
        L_0x001a:
            if (r0 == 0) goto L_0x0029
            android.widget.TextView r3 = r2.v
            if (r3 == 0) goto L_0x0023
            com.avito.android.util.Views.show(r3)
        L_0x0023:
            android.view.View r3 = r2.s
            com.avito.android.util.Views.show(r3)
            goto L_0x0035
        L_0x0029:
            android.widget.TextView r3 = r2.v
            if (r3 == 0) goto L_0x0030
            com.avito.android.util.Views.hide(r3)
        L_0x0030:
            android.view.View r3 = r2.s
            com.avito.android.util.Views.hide(r3)
        L_0x0035:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.avito.component.serp.SerpAdvertRichCardImpl.setCallActionText(java.lang.String):void");
    }

    @Override // ru.avito.component.serp.SerpAdvertRichCard
    public void setCurrentPicture(int i2, boolean z2) {
        this.D.setCurrentPicture(i2, z2);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichCard
    public void setDate(@Nullable String str) {
        PrecomputedTextViewKt.bindTextAsync(this.p, str, this.M);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichCard
    public void setDeliveryVisible(boolean z2) {
        Views.setVisible(this.w, z2);
        this.I.onDecorationViewChanged();
    }

    @Override // ru.avito.component.serp.SerpAdvertRichCard
    public void setDescription(@Nullable String str) {
        TextView textView = this.q;
        if (textView != null) {
            PrecomputedTextViewKt.bindTextAsync(textView, str, this.M);
        }
    }

    @Override // ru.avito.component.serp.SerpAdvertRichCard
    public void setDiscount(@Nullable String str) {
        SerpAdvertTileCardKt.applyClassifiedDiscountToViews(this.n, this.l, str, this.M, true);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichCard
    public void setDistance(@Nullable String str) {
        PrecomputedTextViewKt.bindTextAsync(this.k, str, this.M);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichCard
    @SuppressLint({"RestrictedApi"})
    public void setFavorite(boolean z2) {
        this.r.setChecked(z2);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichCard
    public void setFavoriteVisible(boolean z2) {
        Views.setVisible(this.r, z2);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichCard
    public void setHasVideo(boolean z2) {
        Views.setVisible(this.y, z2);
        this.I.onDecorationViewChanged();
    }

    @Override // ru.avito.component.serp.SerpAdvertRichCard
    public void setLocation(@Nullable String str) {
        PrecomputedTextViewKt.bindTextAsync(this.j, str, this.M);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichCard
    public void setOnAdditionalActionClickListener(@Nullable Function0<Unit> function0) {
        if (function0 == null) {
            TextView textView = this.x;
            if (textView != null) {
                textView.setOnClickListener(null);
                return;
            }
            return;
        }
        TextView textView2 = this.x;
        if (textView2 != null) {
            textView2.setOnClickListener(new q(function0));
        }
    }

    @Override // ru.avito.component.serp.AsyncPhoneItemView
    public void setPhoneLoadingState(@NotNull PhoneLoadingState phoneLoadingState) {
        Intrinsics.checkNotNullParameter(phoneLoadingState, "state");
        this.s.setEnabled(phoneLoadingState == PhoneLoadingState.IDLE);
        if (phoneLoadingState.ordinal() != 1) {
            TextView textView = this.v;
            if (textView != null) {
                Views.show(textView);
            }
            Views.hide(this.t);
        } else {
            TextView textView2 = this.v;
            if (textView2 != null) {
                Views.conceal(textView2);
            }
            Views.show(this.t);
        }
        this.D.setLoadingState(ActionType.CALL, phoneLoadingState);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichCard
    public void setPictures(@NotNull List<? extends Picture> list) {
        Intrinsics.checkNotNullParameter(list, "pictures");
        this.D.setPictures(list);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichCard
    public void setPrice(@Nullable String str, boolean z2) {
        this.z.setText(str, z2);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichCard
    public void setPriceWithoutDiscount(@Nullable String str) {
        TextViews.bindText$default(this.m, str, false, 2, null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0011, code lost:
        if ((r5.length() > 0) != false) goto L_0x0015;
     */
    @Override // ru.avito.component.serp.SerpAdvertRichCard
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setSeller(@org.jetbrains.annotations.Nullable java.lang.String r5) {
        /*
            r4 = this;
            android.widget.LinearLayout r0 = r4.g
            if (r0 == 0) goto L_0x0018
            r1 = 1
            r2 = 0
            if (r5 == 0) goto L_0x0014
            int r3 = r5.length()
            if (r3 <= 0) goto L_0x0010
            r3 = 1
            goto L_0x0011
        L_0x0010:
            r3 = 0
        L_0x0011:
            if (r3 == 0) goto L_0x0014
            goto L_0x0015
        L_0x0014:
            r1 = 0
        L_0x0015:
            com.avito.android.util.Views.setVisible(r0, r1)
        L_0x0018:
            android.widget.TextView r0 = r4.h
            boolean r1 = r4.M
            ru.avito.component.serp.PrecomputedTextViewKt.bindTextAsync(r0, r5, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.avito.component.serp.SerpAdvertRichCardImpl.setSeller(java.lang.String):void");
    }

    @Override // ru.avito.component.serp.SerpAdvertRichCard
    public void setSellerInfo(@Nullable CarouselSellerItem carouselSellerItem) {
        this.D.setSellerInfo(carouselSellerItem, this.L.getBlockPosition());
    }

    @Override // ru.avito.component.serp.SerpAdvertRichCard
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        PrecomputedTextViewKt.bindTextAsync(this.f, str, this.M);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichCard
    public void setVideoIconEnlarged(boolean z2) {
        this.y.setImageResource(z2 ? R.drawable.ic_video_17 : R.drawable.video_16);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichCard
    public void setViewed(boolean z2) {
        a(this.a.getAlpha() != this.B, z2);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichCard
    public void writeClicks(@NotNull Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "callback");
        CompositeDisposable compositeDisposable = this.G;
        Observable<R> map = this.F.filter(r.a).map(s.a);
        View view = this.u;
        if (view != null) {
            map = map.mergeWith(InteropKt.toV3(RxView.clicks(view)).map(t.a));
        }
        Disposable subscribe = map.subscribe(new u(function1), v.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "consumer.filter { it is …lick write error\", it) })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0018  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x002b  */
    @Override // ru.avito.component.serp.SerpAdvertRichCard
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setSeller(@org.jetbrains.annotations.Nullable java.lang.String r5, @org.jetbrains.annotations.Nullable java.lang.String r6) {
        /*
            r4 = this;
            android.widget.LinearLayout r0 = r4.g
            if (r0 == 0) goto L_0x002f
            r1 = 1
            r2 = 0
            if (r5 == 0) goto L_0x0015
            int r3 = r5.length()
            if (r3 <= 0) goto L_0x0010
            r3 = 1
            goto L_0x0011
        L_0x0010:
            r3 = 0
        L_0x0011:
            if (r3 == 0) goto L_0x0015
            r3 = 1
            goto L_0x0016
        L_0x0015:
            r3 = 0
        L_0x0016:
            if (r3 != 0) goto L_0x002c
            if (r6 == 0) goto L_0x0027
            int r3 = r6.length()
            if (r3 <= 0) goto L_0x0022
            r3 = 1
            goto L_0x0023
        L_0x0022:
            r3 = 0
        L_0x0023:
            if (r3 == 0) goto L_0x0027
            r3 = 1
            goto L_0x0028
        L_0x0027:
            r3 = 0
        L_0x0028:
            if (r3 == 0) goto L_0x002b
            goto L_0x002c
        L_0x002b:
            r1 = 0
        L_0x002c:
            com.avito.android.util.Views.setVisible(r0, r1)
        L_0x002f:
            android.widget.TextView r0 = r4.h
            boolean r1 = r4.M
            ru.avito.component.serp.PrecomputedTextViewKt.bindTextAsync(r0, r5, r1)
            android.widget.TextView r5 = r4.i
            if (r5 == 0) goto L_0x003f
            boolean r0 = r4.M
            ru.avito.component.serp.PrecomputedTextViewKt.bindTextAsync(r5, r6, r0)
        L_0x003f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.avito.component.serp.SerpAdvertRichCardImpl.setSeller(java.lang.String, java.lang.String):void");
    }
}
