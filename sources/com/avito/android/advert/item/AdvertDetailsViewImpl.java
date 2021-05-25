package com.avito.android.advert.item;

import a2.a.a.f.x.o;
import a2.a.a.f.x.p;
import a2.a.a.f.x.q;
import a2.a.a.f.x.r;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.app.AlertDialog;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.avito.android.Features;
import com.avito.android.advert.AdvertDetailsToolbarPresenter;
import com.avito.android.advert.item.AdvertDetailsViewScroller;
import com.avito.android.advert.item.autoteka.AdvertDetailsAutotekaPresenter;
import com.avito.android.advert.item.autoteka.teaser.AdvertDetailsAutotekaTeaserPresenter;
import com.avito.android.advert.item.commercials.CommercialItemDecorator;
import com.avito.android.advert.item.contactbar.AdvertDetailsContactBarItem;
import com.avito.android.advert.item.contactbar.AdvertDetailsContactBarView;
import com.avito.android.advert.item.dfpcreditinfo.DfpCreditViewModel;
import com.avito.android.advert.item.marketplace_delivery.MarketplaceDeliveryItem;
import com.avito.android.advert.item.note.AdvertDetailsNotePresenter;
import com.avito.android.advert.item.photogallery.AdvertDetailsGalleryItem;
import com.avito.android.advert.item.price.AdvertDetailsPriceItem;
import com.avito.android.advert.item.sellerprofile.AdvertSellerPresenter;
import com.avito.android.advert.item.sellersubscription.SellerSubscriptionPresenter;
import com.avito.android.advert.item.similars.AdvertComplementaryPresenter;
import com.avito.android.advert.item.similars.AdvertSimilarPresenterResourceProvider;
import com.avito.android.advert.item.title.AdvertDetailsTitleItem;
import com.avito.android.advert.viewed.ViewedAdvertsPresenter;
import com.avito.android.advert_core.R;
import com.avito.android.advert_core.advert.GridAfterHeaderItemDecorator;
import com.avito.android.advert_core.call_methods.AdvertCallMethodsDialogFragment;
import com.avito.android.advert_core.call_methods.CallMethods;
import com.avito.android.advert_core.contactbar.AdvertContactsBindListener;
import com.avito.android.advert_core.contactbar.AdvertContactsPresenter;
import com.avito.android.advert_core.contactbar.AdvertContactsView;
import com.avito.android.advert_core.contactbar.AdvertContactsViewImpl;
import com.avito.android.advert_core.contactbar.anti_fraud.AntiFraudDialog;
import com.avito.android.advert_core.contactbar.feedback.FeedbackDialog;
import com.avito.android.advert_core.marketplace.MarketplacePresenter;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.cart_fab.CartFabView;
import com.avito.android.deep_linking.links.PhoneLink;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.item_visibility_tracker.ItemVisibilityTracker;
import com.avito.android.lib.design.bottom_sheet.BottomSheetDialog;
import com.avito.android.lib.design.button.Button;
import com.avito.android.lib.design.dialog.Dialog;
import com.avito.android.lib.design.snackbar.SnackbarExtensionsKt;
import com.avito.android.lib.design.snackbar.SnackbarPosition;
import com.avito.android.lib.design.snackbar.SnackbarType;
import com.avito.android.lib.design.snackbar.util.SnackbarElementView;
import com.avito.android.recycler.base.DestroyableViewHolderBuilder;
import com.avito.android.recycler.base.SafeRecyclerAdapter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.Coordinates;
import com.avito.android.remote.model.GeoReference;
import com.avito.android.section.action.SectionActionPresenter;
import com.avito.android.section.expand_sections_button.ExpandSectionsButtonItem;
import com.avito.android.section.title.SectionTitleItem;
import com.avito.android.section.title_with_action.SectionTitleWithActionItem;
import com.avito.android.serp.adapter.SerpSpanProvider;
import com.avito.android.serp.adapter.SpannedGridPositionProvider;
import com.avito.android.serp.adapter.SpannedItem;
import com.avito.android.util.DeviceMetrics;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.Formatter;
import com.avito.android.util.ToastsKt;
import com.avito.android.util.Views;
import com.avito.conveyor_item.Item;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.data_source.ListDataSource;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.snackbar.Snackbar;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.model.VKAttachments;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.dialog.Dialogs;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000È\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003Bë\u0002\u0012\b\u0010Á\u0001\u001a\u00030¾\u0001\u0012\b\u0010ô\u0001\u001a\u00030ñ\u0001\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\b\u0010¥\u0001\u001a\u00030¢\u0001\u0012\n\u0010ä\u0001\u001a\u0005\u0018\u00010á\u0001\u0012\b\u0010Ü\u0001\u001a\u00030Ù\u0001\u0012\b\u0010µ\u0001\u001a\u00030²\u0001\u0012\b\u0010½\u0001\u001a\u00030º\u0001\u0012\b\u0010¡\u0001\u001a\u00030\u0001\u0012\b\u0010\u0002\u001a\u00030\u0002\u0012\b\u0010Å\u0001\u001a\u00030Â\u0001\u0012\n\u0010©\u0001\u001a\u0005\u0018\u00010¦\u0001\u0012\b\u0010­\u0001\u001a\u00030ª\u0001\u0012\u000e\u0010¹\u0001\u001a\t\u0012\u0004\u0012\u00020\u00140¶\u0001\u0012\b\u0010¬\u0002\u001a\u00030©\u0002\u0012\b\u0010Ë\u0002\u001a\u00030È\u0002\u0012\b\u0010ü\u0001\u001a\u00030ù\u0001\u0012\b\u0010°\u0002\u001a\u00030­\u0002\u0012\b\u0010Ô\u0001\u001a\u00030Ñ\u0001\u0012\b\u0010\u0002\u001a\u00030\u0002\u0012\b\u0010¢\u0002\u001a\u00030\u0002\u0012\b\u0010\u0002\u001a\u00030ÿ\u0001\u0012\b\u0010Í\u0002\u001a\u00030Ì\u0002\u0012\b\u0010Ã\u0002\u001a\u00030À\u0002\u0012\b\u0010Ï\u0002\u001a\u00030Î\u0002\u0012\b\u0010¨\u0002\u001a\u00030¥\u0002\u0012\b\u0010Ð\u0001\u001a\u00030Í\u0001\u0012\b\u0010Ì\u0001\u001a\u00030É\u0001\u0012\b\u0010\u0002\u001a\u00030\u0002\u0012\b\u0010ì\u0001\u001a\u00030é\u0001\u0012\b\u0010±\u0001\u001a\u00030®\u0001\u0012\b\u0010ø\u0001\u001a\u00030õ\u0001\u0012\b\u0010ð\u0001\u001a\u00030í\u0001\u0012\f\b\u0002\u0010\u0002\u001a\u0005\u0018\u00010\u0002¢\u0006\u0006\bÐ\u0002\u0010Ñ\u0002J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u0006J\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0006J\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013JO\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00142\u0014\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0019j\u0004\u0018\u0001`\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0004H\u0016¢\u0006\u0004\b \u0010\u0006J\u000f\u0010!\u001a\u00020\u0004H\u0016¢\u0006\u0004\b!\u0010\u0006J\u000f\u0010\"\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\"\u0010\u0006J\u000f\u0010#\u001a\u00020\u0004H\u0016¢\u0006\u0004\b#\u0010\u0006J\u0017\u0010&\u001a\u00020\u00042\u0006\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b&\u0010'J\u0017\u0010)\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0014H\u0016¢\u0006\u0004\b)\u0010*J\u0017\u0010+\u001a\u00020\u00042\u0006\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b+\u0010'J9\u0010.\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u00142\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00192\u0006\u0010-\u001a\u00020,H\u0016¢\u0006\u0004\b.\u0010/J\u0017\u00101\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u0014H\u0016¢\u0006\u0004\b1\u0010*J\u000f\u00102\u001a\u00020\u0004H\u0016¢\u0006\u0004\b2\u0010\u0006J\u000f\u00103\u001a\u00020\u0004H\u0016¢\u0006\u0004\b3\u0010\u0006J\u0017\u00106\u001a\u00020\u00042\u0006\u00105\u001a\u000204H\u0016¢\u0006\u0004\b6\u00107J\u000f\u00108\u001a\u00020\u0004H\u0016¢\u0006\u0004\b8\u0010\u0006J\u000f\u00109\u001a\u00020\u0004H\u0016¢\u0006\u0004\b9\u0010\u0006J\u000f\u0010:\u001a\u00020\u0004H\u0016¢\u0006\u0004\b:\u0010\u0006JA\u0010B\u001a\u00020\u00042\b\u00100\u001a\u0004\u0018\u00010\u00142\u0006\u0010;\u001a\u00020\u00142\u0006\u0010=\u001a\u00020<2\u0006\u0010>\u001a\u00020\u00142\u000e\u0010A\u001a\n\u0012\u0004\u0012\u00020@\u0018\u00010?H\u0016¢\u0006\u0004\bB\u0010CJ\u0017\u0010D\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0014H\u0016¢\u0006\u0004\bD\u0010*J\u001f\u0010H\u001a\u00020\u00042\u0006\u0010F\u001a\u00020E2\u0006\u0010G\u001a\u00020\u0014H\u0016¢\u0006\u0004\bH\u0010IJ\u000f\u0010J\u001a\u00020\u0004H\u0016¢\u0006\u0004\bJ\u0010\u0006J\u001f\u0010O\u001a\u00020\u00042\u0006\u0010L\u001a\u00020K2\u0006\u0010N\u001a\u00020MH\u0016¢\u0006\u0004\bO\u0010PJ\u0011\u0010Q\u001a\u0004\u0018\u00010KH\u0016¢\u0006\u0004\bQ\u0010RJ\u0017\u0010T\u001a\u00020\u00042\u0006\u0010S\u001a\u00020\u001cH\u0016¢\u0006\u0004\bT\u0010UJ/\u0010Y\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u000b2\u0006\u0010V\u001a\u00020\u000b2\u0006\u0010W\u001a\u00020\u000b2\u0006\u0010X\u001a\u00020\u001cH\u0016¢\u0006\u0004\bY\u0010ZJ\u000f\u0010[\u001a\u00020\u0004H\u0016¢\u0006\u0004\b[\u0010\u0006J?\u0010`\u001a\u00020\u0004\"\b\b\u0000\u0010]*\u00020\\2\f\u0010_\u001a\b\u0012\u0004\u0012\u00028\u00000^2\u0006\u0010V\u001a\u00020\u000b2\u0006\u0010W\u001a\u00020\u000b2\u0006\u0010X\u001a\u00020\u001cH\u0016¢\u0006\u0004\b`\u0010aJ\u0019\u0010c\u001a\u00020\u00042\b\u0010b\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\bc\u0010*J\u0017\u0010d\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u000bH\u0016¢\u0006\u0004\bd\u0010\u000eJ\u000f\u0010e\u001a\u00020\u0004H\u0016¢\u0006\u0004\be\u0010\u0006J\u0017\u0010g\u001a\u00020\u00042\u0006\u0010f\u001a\u00020\u0014H\u0016¢\u0006\u0004\bg\u0010*J\u000f\u0010h\u001a\u00020\u0004H\u0016¢\u0006\u0004\bh\u0010\u0006J9\u0010n\u001a\u00020\u00042\f\u0010j\u001a\b\u0012\u0004\u0012\u00020i0?2\u0006\u0010k\u001a\u00020\u000b2\b\u0010l\u001a\u0004\u0018\u00010\u000b2\b\u0010m\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\bn\u0010oJ\u000f\u0010p\u001a\u00020\u0004H\u0016¢\u0006\u0004\bp\u0010\u0006J\u000f\u0010q\u001a\u00020\u0004H\u0016¢\u0006\u0004\bq\u0010\u0006J\u000f\u0010r\u001a\u00020\u0004H\u0016¢\u0006\u0004\br\u0010\u0006J\u0015\u0010t\u001a\b\u0012\u0004\u0012\u00020\u000b0sH\u0016¢\u0006\u0004\bt\u0010uJ\u000f\u0010v\u001a\u00020\u0004H\u0016¢\u0006\u0004\bv\u0010\u0006JY\u0010}\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010w\u001a\u00020\u000b2\b\u0010x\u001a\u0004\u0018\u00010\u00142\u0006\u0010y\u001a\u00020\u000b2\u000e\u0010z\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00192\u0006\u0010{\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020,2\u0006\u0010_\u001a\u00020|H\u0016¢\u0006\u0004\b}\u0010~J\u001d\u0010\u0001\u001a\u00020\u00042\t\u0010\u0001\u001a\u0004\u0018\u00010H\u0016¢\u0006\u0006\b\u0001\u0010\u0001J*\u0010\u0001\u001a\u00020\u00042\b\u0010\u0001\u001a\u00030\u00012\f\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00040\u0019H\u0016¢\u0006\u0006\b\u0001\u0010\u0001J\u001a\u0010\u0001\u001a\u00020\u00042\u0007\u0010\u0001\u001a\u00020\u001cH\u0016¢\u0006\u0005\b\u0001\u0010UJ\u0011\u0010\u0001\u001a\u00020\u0004H\u0016¢\u0006\u0005\b\u0001\u0010\u0006R#\u0010\u0001\u001a\r \u0001*\u0005\u0018\u00010\u00010\u00018\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\b\u0010\u0001R\u001c\u0010\u0001\u001a\u0005\u0018\u00010\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001c\u0010\u0001\u001a\u0005\u0018\u00010\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001c\u0010\u0001\u001a\u0005\u0018\u00010\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010¡\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010 \u0001R\u001a\u0010¥\u0001\u001a\u00030¢\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b£\u0001\u0010¤\u0001R\u001c\u0010©\u0001\u001a\u0005\u0018\u00010¦\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b§\u0001\u0010¨\u0001R\u001a\u0010­\u0001\u001a\u00030ª\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b«\u0001\u0010¬\u0001R\u001a\u0010±\u0001\u001a\u00030®\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¯\u0001\u0010°\u0001R\u001a\u0010µ\u0001\u001a\u00030²\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b³\u0001\u0010´\u0001R \u0010¹\u0001\u001a\t\u0012\u0004\u0012\u00020\u00140¶\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b·\u0001\u0010¸\u0001R\u001a\u0010½\u0001\u001a\u00030º\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b»\u0001\u0010¼\u0001R\u001a\u0010Á\u0001\u001a\u00030¾\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¿\u0001\u0010À\u0001R\u001a\u0010Å\u0001\u001a\u00030Â\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÃ\u0001\u0010Ä\u0001R\u0019\u0010È\u0001\u001a\u00020\u001c8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bÆ\u0001\u0010Ç\u0001R\u001a\u0010Ì\u0001\u001a\u00030É\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÊ\u0001\u0010Ë\u0001R\u001a\u0010Ð\u0001\u001a\u00030Í\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÎ\u0001\u0010Ï\u0001R\u001a\u0010Ô\u0001\u001a\u00030Ñ\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÒ\u0001\u0010Ó\u0001R\u001c\u0010Ø\u0001\u001a\u0005\u0018\u00010Õ\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bÖ\u0001\u0010×\u0001R\u001a\u0010Ü\u0001\u001a\u00030Ù\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÚ\u0001\u0010Û\u0001R\u001a\u0010à\u0001\u001a\u00030Ý\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÞ\u0001\u0010ß\u0001R\u001c\u0010ä\u0001\u001a\u0005\u0018\u00010á\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bâ\u0001\u0010ã\u0001R\u001c\u0010è\u0001\u001a\u0005\u0018\u00010å\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bæ\u0001\u0010ç\u0001R\u001a\u0010ì\u0001\u001a\u00030é\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bê\u0001\u0010ë\u0001R\u001a\u0010ð\u0001\u001a\u00030í\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bî\u0001\u0010ï\u0001R\u001a\u0010ô\u0001\u001a\u00030ñ\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bò\u0001\u0010ó\u0001R\u001a\u0010ø\u0001\u001a\u00030õ\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bö\u0001\u0010÷\u0001R\u001a\u0010ü\u0001\u001a\u00030ù\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bú\u0001\u0010û\u0001R\u0019\u0010þ\u0001\u001a\u00020\u001c8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bý\u0001\u0010Ç\u0001R\u001a\u0010\u0002\u001a\u00030ÿ\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0002\u0010\u0002R#\u0010\u0002\u001a\r \u0001*\u0005\u0018\u00010\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0005\u0010\u0002R\u001a\u0010\u0002\u001a\u00030\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0002\u0010\u0002R\u0019\u0010\u0002\u001a\u00030\u00028\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b]\u0010\u0002R\u001c\u0010\u0002\u001a\u0005\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0002\u0010\u0002R\u001a\u0010\u0002\u001a\u00030\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0002\u0010\u0002R\u001a\u0010\u0002\u001a\u00030\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0002\u0010\u0002R\u001c\u0010\u0002\u001a\u0005\u0018\u00010\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0002\u0010\u0002R\u001c\u0010\u0002\u001a\u0005\u0018\u00010\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0002\u0010\u0001R\u001a\u0010¢\u0002\u001a\u00030\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b \u0002\u0010¡\u0002R\u001c\u0010¤\u0002\u001a\u0005\u0018\u00010\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b£\u0002\u0010\u0001R\u001a\u0010¨\u0002\u001a\u00030¥\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¦\u0002\u0010§\u0002R\u001a\u0010¬\u0002\u001a\u00030©\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bª\u0002\u0010«\u0002R\u001a\u0010°\u0002\u001a\u00030­\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b®\u0002\u0010¯\u0002R\u0019\u0010³\u0002\u001a\u00030±\u00028\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b%\u0010²\u0002R \u0010·\u0002\u001a\t\u0012\u0004\u0012\u00020i0´\u00028\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bµ\u0002\u0010¶\u0002R\u001c\u0010»\u0002\u001a\u0005\u0018\u00010¸\u00028\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b¹\u0002\u0010º\u0002R\u001a\u0010¿\u0002\u001a\u00030¼\u00028\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b½\u0002\u0010¾\u0002R\u001a\u0010Ã\u0002\u001a\u00030À\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÁ\u0002\u0010Â\u0002R \u0010Ç\u0002\u001a\t\u0012\u0004\u0012\u00020i0Ä\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÅ\u0002\u0010Æ\u0002R\u001a\u0010Ë\u0002\u001a\u00030È\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÉ\u0002\u0010Ê\u0002¨\u0006Ò\u0002"}, d2 = {"Lcom/avito/android/advert/item/AdvertDetailsViewImpl;", "Lcom/avito/android/advert/item/AdvertDetailsView;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/avito/android/advert_core/contactbar/AdvertContactsBindListener;", "", AuthSource.BOOKING_ORDER, "()V", "Lcom/avito/android/advert_core/call_methods/AdvertCallMethodsDialogFragment;", AuthSource.SEND_ABUSE, "()Lcom/avito/android/advert_core/call_methods/AdvertCallMethodsDialogFragment;", "attach", "", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "onContactBarBind", "(I)V", "detach", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "followUri", "(Landroid/net/Uri;)V", "", "text", "length", "maxLine", "actionTitle", "Lkotlin/Function0;", "Lcom/avito/android/util/ActionHandler;", "action", "", "error", "showSnackBar", "(Ljava/lang/String;IILjava/lang/String;Lkotlin/jvm/functions/Function0;Z)V", "onRefresh", "onLoadFailed", "dismissProgress", "showProgress", "", "e", "onLoadError", "(Ljava/lang/Throwable;)V", "itemId", "showInactiveItem", "(Ljava/lang/String;)V", "showError", "Lcom/avito/android/lib/design/snackbar/SnackbarPosition;", VKApiConst.POSITION, "displayMessage", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lcom/avito/android/lib/design/snackbar/SnackbarPosition;)V", BookingInfoActivity.EXTRA_ITEM_ID, "showContactAccessPackage", "showAddressCopied", "showSellerNotifiedAboutCall", "Lcom/avito/android/advert_core/call_methods/CallMethods;", "callMethods", "showCallMethods", "(Lcom/avito/android/advert_core/call_methods/CallMethods;)V", "onLoadingStart", "onLoadingFinish", "onDataSourceUnavailable", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "Lcom/avito/android/remote/model/Coordinates;", "coordinates", "title", "", "Lcom/avito/android/remote/model/GeoReference;", "geoReferences", "showAddressOnMap", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Coordinates;Ljava/lang/String;Ljava/util/List;)V", "showConsultationForm", "Lcom/avito/android/deep_linking/links/PhoneLink;", "phoneLink", "source", "showPhoneCallConfirmation", "(Lcom/avito/android/deep_linking/links/PhoneLink;Ljava/lang/String;)V", "showAntiFraudCheckList", "Lcom/avito/android/advert_core/contactbar/feedback/FeedbackDialog$State;", "state", "Lcom/avito/android/advert_core/contactbar/feedback/FeedbackDialog$Listener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "showFeedback", "(Lcom/avito/android/advert_core/contactbar/feedback/FeedbackDialog$State;Lcom/avito/android/advert_core/contactbar/feedback/FeedbackDialog$Listener;)V", "getFeedbackState", "()Lcom/avito/android/advert_core/contactbar/feedback/FeedbackDialog$State;", "isFeedbackSent", "clearFeedbackState", "(Z)V", "offset", "verticalSnap", "isFast", "smoothScrollToPosition", "(IIIZ)V", "smoothScrollToStart", "Lcom/avito/conveyor_item/Item;", "T", "Ljava/lang/Class;", "type", "smoothScrollToItem", "(Ljava/lang/Class;IIZ)V", VKAttachments.TYPE_NOTE, "updateAddNoteResult", "notifyItemAtPositionChanged", "destroy", "message", "showSnackbarAboveContactBar", "showEnableNotificationDialog", "Lcom/avito/android/serp/adapter/SpannedItem;", "items", "similarsStartPos", "topCommercialPosition", "bottomCommercialPosition", "bindItemsList", "(Ljava/util/List;ILjava/lang/Integer;Ljava/lang/Integer;)V", "removeToolbarShadow", "showPriceSubscriptionInfo", "showNotificationsEnableWarning", "Lio/reactivex/rxjava3/core/Observable;", "scrollStateChanges", "()Lio/reactivex/rxjava3/core/Observable;", "refreshList", "textResId", "actionText", "actionTextResId", "onActionClick", "duration", "Lcom/avito/android/lib/design/snackbar/SnackbarType;", "showSnackbar", "(Ljava/lang/String;ILjava/lang/String;ILkotlin/jvm/functions/Function0;ILcom/avito/android/lib/design/snackbar/SnackbarPosition;Lcom/avito/android/lib/design/snackbar/SnackbarType;)V", "Lcom/avito/android/advert/item/marketplace_delivery/MarketplaceDeliveryItem;", "marketplaceDeliveryItem", "updateMarketplaceDeliveryInfoItem", "(Lcom/avito/android/advert/item/marketplace_delivery/MarketplaceDeliveryItem;)V", "Lcom/avito/android/remote/error/ErrorResult$ErrorDialog;", "errorDialog", "showErrorDialog", "(Lcom/avito/android/remote/error/ErrorResult$ErrorDialog;Lkotlin/jvm/functions/Function0;)V", "isVisible", "onKeyboardVisibilityChanged", "updateScroll", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "Landroid/content/Context;", "context", "Landroidx/appcompat/app/AlertDialog;", "k", "Landroidx/appcompat/app/AlertDialog;", "phoneCallDialog", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", a2.g.r.g.a, "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "commercialDecorator", "Landroid/app/Dialog;", AuthSource.OPEN_CHANNEL_LIST, "Landroid/app/Dialog;", "dialog", "Lcom/avito/android/advert/item/AdvertDetailsRouter;", VKApiConst.VERSION, "Lcom/avito/android/advert/item/AdvertDetailsRouter;", "advertDetailsRouter", "Lcom/avito/android/section/action/SectionActionPresenter;", "B", "Lcom/avito/android/section/action/SectionActionPresenter;", "sectionActionPresenter", "Lcom/avito/android/util/DialogRouter;", "w", "Lcom/avito/android/util/DialogRouter;", "dialogRouter", "Lcom/avito/android/advert_core/marketplace/MarketplacePresenter;", ExifInterface.LONGITUDE_EAST, "Lcom/avito/android/advert_core/marketplace/MarketplacePresenter;", "marketplacePresenter", "Lcom/avito/android/advert/item/AdvertDetailsPresenter;", "F", "Lcom/avito/android/advert/item/AdvertDetailsPresenter;", "presenter", "Lcom/avito/android/Features;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lcom/avito/android/Features;", "features", "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "z", "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "favoriteAdvertsPresenter", "Lcom/avito/android/util/Formatter;", "G", "Lcom/avito/android/util/Formatter;", "phoneNumberFormatter", "Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "viewedAdvertsPresenter", "Landroid/view/View;", "t", "Landroid/view/View;", "view", "Lcom/avito/android/advert/item/sellersubscription/SellerSubscriptionPresenter;", "D", "Lcom/avito/android/advert/item/sellersubscription/SellerSubscriptionPresenter;", "sellerSubscriptionPresenter", "o", "Z", "isContactBarInited", "Lcom/avito/android/recycler/base/SafeRecyclerAdapter;", ExifInterface.LATITUDE_SOUTH, "Lcom/avito/android/recycler/base/SafeRecyclerAdapter;", "itemsSafeRecyclerAdapter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "R", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "sectionsAdapterPresenter", "Lcom/avito/android/advert/item/autoteka/AdvertDetailsAutotekaPresenter;", "L", "Lcom/avito/android/advert/item/autoteka/AdvertDetailsAutotekaPresenter;", "autotekaPresenter", "Lcom/avito/android/advert_core/contactbar/AdvertContactsView;", "d", "Lcom/avito/android/advert_core/contactbar/AdvertContactsView;", "advertContactsView", "Lcom/avito/android/advert/item/similars/AdvertComplementaryPresenter;", "y", "Lcom/avito/android/advert/item/similars/AdvertComplementaryPresenter;", "advertComplementaryPresenter", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "s", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "viewDisposables", "Lcom/avito/android/advert/item/AdvertDetailsCallbacks;", "x", "Lcom/avito/android/advert/item/AdvertDetailsCallbacks;", "advertCallbacksListener", "Lcom/avito/android/advert_core/contactbar/feedback/FeedbackDialog;", "l", "Lcom/avito/android/advert_core/contactbar/feedback/FeedbackDialog;", "feedbackDialog", "Lcom/avito/android/advert/item/similars/AdvertSimilarPresenterResourceProvider;", "U", "Lcom/avito/android/advert/item/similars/AdvertSimilarPresenterResourceProvider;", "similarAdvertResources", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "X", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "fpsListener", "Lcom/avito/android/advert/item/AdvertDetailsFragmentDelegate;", "u", "Lcom/avito/android/advert/item/AdvertDetailsFragmentDelegate;", "advertDetailsDelegate", "Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker;", ExifInterface.LONGITUDE_WEST, "Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker;", "itemVisibilityTracker", "Lcom/avito/android/advert/AdvertDetailsToolbarPresenter;", "J", "Lcom/avito/android/advert/AdvertDetailsToolbarPresenter;", "advertDetailsToolbarPresenter", "r", "isKeyboardShown", "Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditViewModel;", "O", "Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditViewModel;", "dfpCreditViewModel", "Landroid/content/res/Resources;", "Landroid/content/res/Resources;", "resources", "Landroid/widget/FrameLayout;", "c", "Landroid/widget/FrameLayout;", "containerView", "Lcom/avito/android/util/DeviceMetrics;", "Lcom/avito/android/util/DeviceMetrics;", "deviceMetrics", "Lcom/google/android/material/snackbar/Snackbar;", "p", "Lcom/google/android/material/snackbar/Snackbar;", "retrySnackbar", "Lcom/avito/android/advert/item/AdvertDetailsItemsPresenter;", "C", "Lcom/avito/android/advert/item/AdvertDetailsItemsPresenter;", "advertDetailsItemsPresenter", "Lcom/avito/android/advert/item/autoteka/teaser/AdvertDetailsAutotekaTeaserPresenter;", "M", "Lcom/avito/android/advert/item/autoteka/teaser/AdvertDetailsAutotekaTeaserPresenter;", "autotekaTeaserPresenter", "Lcom/avito/android/cart_fab/CartFabView;", "Y", "Lcom/avito/android/cart_fab/CartFabView;", "cartFabView", "j", "progressDialog", "Lcom/avito/android/advert/item/note/AdvertDetailsNotePresenter;", "N", "Lcom/avito/android/advert/item/note/AdvertDetailsNotePresenter;", "notePresenter", "f", "itemDecorator", "Lcom/avito/android/serp/adapter/SerpSpanProvider;", "Q", "Lcom/avito/android/serp/adapter/SerpSpanProvider;", "spanProvider", "Lcom/avito/android/advert/item/sellerprofile/AdvertSellerPresenter;", "H", "Lcom/avito/android/advert/item/sellerprofile/AdvertSellerPresenter;", "sellerPresenter", "Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;", "K", "Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;", "destroyableComplementaryViewHolderBuilder", "Landroidx/recyclerview/widget/RecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "", "h", "Ljava/util/List;", "recyclerItems", "Lcom/avito/android/lib/design/snackbar/Snackbar;", VKApiConst.Q, "Lcom/avito/android/lib/design/snackbar/Snackbar;", "snackbar", "Landroidx/recyclerview/widget/GridLayoutManager;", "n", "Landroidx/recyclerview/widget/GridLayoutManager;", "layoutManager", "Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "P", "Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "gridPositionProvider", "Lcom/avito/konveyor/data_source/ListDataSource;", "i", "Lcom/avito/konveyor/data_source/ListDataSource;", "itemsDatasource", "Lcom/avito/android/advert_core/contactbar/AdvertContactsPresenter;", "I", "Lcom/avito/android/advert_core/contactbar/AdvertContactsPresenter;", "contactsPresenter", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "spanSizeLookup", "<init>", "(Landroid/view/View;Lcom/avito/android/advert/item/AdvertDetailsFragmentDelegate;Lcom/avito/android/advert/item/AdvertDetailsRouter;Lcom/avito/android/util/DialogRouter;Lcom/avito/android/advert/item/AdvertDetailsCallbacks;Lcom/avito/android/advert/item/similars/AdvertComplementaryPresenter;Lcom/avito/android/favorite/FavoriteAdvertsPresenter;Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;Lcom/avito/android/section/action/SectionActionPresenter;Lcom/avito/android/advert/item/AdvertDetailsItemsPresenter;Lcom/avito/android/advert/item/sellersubscription/SellerSubscriptionPresenter;Lcom/avito/android/advert_core/marketplace/MarketplacePresenter;Lcom/avito/android/advert/item/AdvertDetailsPresenter;Lcom/avito/android/util/Formatter;Lcom/avito/android/advert/item/sellerprofile/AdvertSellerPresenter;Lcom/avito/android/advert_core/contactbar/AdvertContactsPresenter;Lcom/avito/android/advert/AdvertDetailsToolbarPresenter;Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;Lcom/avito/android/advert/item/autoteka/AdvertDetailsAutotekaPresenter;Lcom/avito/android/advert/item/autoteka/teaser/AdvertDetailsAutotekaTeaserPresenter;Lcom/avito/android/advert/item/note/AdvertDetailsNotePresenter;Lcom/avito/android/advert/item/dfpcreditinfo/DfpCreditViewModel;Landroidx/lifecycle/LifecycleOwner;Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;Lcom/avito/android/serp/adapter/SerpSpanProvider;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/recycler/base/SafeRecyclerAdapter;Lcom/avito/android/util/DeviceMetrics;Lcom/avito/android/advert/item/similars/AdvertSimilarPresenterResourceProvider;Lcom/avito/android/Features;Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker;Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;Lcom/avito/android/cart_fab/CartFabView;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsViewImpl implements AdvertDetailsView, LifecycleObserver, AdvertContactsBindListener {
    public final ViewedAdvertsPresenter A;
    public final SectionActionPresenter B;
    public final AdvertDetailsItemsPresenter C;
    public final SellerSubscriptionPresenter D;
    public final MarketplacePresenter E;
    public final AdvertDetailsPresenter F;
    public final Formatter<String> G;
    public final AdvertSellerPresenter H;
    public final AdvertContactsPresenter I;
    public final AdvertDetailsToolbarPresenter J;
    public final DestroyableViewHolderBuilder K;
    public final AdvertDetailsAutotekaPresenter L;
    public final AdvertDetailsAutotekaTeaserPresenter M;
    public final AdvertDetailsNotePresenter N;
    public final DfpCreditViewModel O;
    public final SpannedGridPositionProvider P;
    public final SerpSpanProvider Q;
    public final AdapterPresenter R;
    public final SafeRecyclerAdapter S;
    public final DeviceMetrics T;
    public final AdvertSimilarPresenterResourceProvider U;
    public final Features V;
    public final ItemVisibilityTracker W;
    public final RecyclerView.OnScrollListener X;
    public final CartFabView Y;
    public final Context a;
    public final Resources b;
    public final FrameLayout c;
    public AdvertContactsView d;
    public final RecyclerView e;
    public RecyclerView.ItemDecoration f;
    public RecyclerView.ItemDecoration g;
    public List<SpannedItem> h;
    public final ListDataSource<SpannedItem> i;
    public Dialog j;
    public AlertDialog k;
    public FeedbackDialog l;
    public Dialog m;
    public GridLayoutManager n;
    public boolean o;
    public Snackbar p;
    public com.avito.android.lib.design.snackbar.Snackbar q;
    public boolean r;
    public final CompositeDisposable s;
    public final View t;
    public final AdvertDetailsFragmentDelegate u;
    public final AdvertDetailsRouter v;
    public final DialogRouter w;
    public final AdvertDetailsCallbacks x;
    public final AdvertComplementaryPresenter y;
    public final FavoriteAdvertsPresenter z;

    public static final class a<T> implements Observer<Boolean> {
        public final /* synthetic */ AdvertDetailsViewImpl a;

        public a(AdvertDetailsViewImpl advertDetailsViewImpl) {
            this.a = advertDetailsViewImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(Boolean bool) {
            this.a.b();
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ AdvertDetailsViewImpl a;

        public b(AdvertDetailsViewImpl advertDetailsViewImpl) {
            this.a = advertDetailsViewImpl;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AdvertDetailsViewImpl advertDetailsViewImpl = this.a;
            String string = advertDetailsViewImpl.b.getString(R.string.feedback_send_success);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(adve…ng.feedback_send_success)");
            SnackbarElementView.DefaultImpls.showSnackbar$default(advertDetailsViewImpl, string, 0, null, 0, null, 0, null, null, 254, null);
        }
    }

    public static final class c extends Lambda implements Function0<Unit> {
        public final /* synthetic */ AdvertDetailsViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(AdvertDetailsViewImpl advertDetailsViewImpl) {
            super(0);
            this.a = advertDetailsViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.onRefresh();
            return Unit.INSTANCE;
        }
    }

    public static final class d<T> implements Consumer<Unit> {
        public final /* synthetic */ AdvertDetailsViewImpl a;

        public d(AdvertDetailsViewImpl advertDetailsViewImpl) {
            this.a = advertDetailsViewImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Unit unit) {
            this.a.D.onEnableNotificationDialogSuccess();
        }
    }

    public static final class e extends Lambda implements Function2<Dialog.Config, DialogInterface, Unit> {
        public final /* synthetic */ ErrorResult.ErrorDialog a;
        public final /* synthetic */ Function0 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(ErrorResult.ErrorDialog errorDialog, Function0 function0) {
            super(2);
            this.a = errorDialog;
            this.b = function0;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(Dialog.Config config, DialogInterface dialogInterface) {
            Action action;
            Dialog.Config config2 = config;
            DialogInterface dialogInterface2 = dialogInterface;
            Intrinsics.checkNotNullParameter(config2, "$receiver");
            Intrinsics.checkNotNullParameter(dialogInterface2, "it");
            config2.setTitle(this.a.getUserDialog().getTitle());
            config2.setSubtitle(this.a.getUserDialog().getMessage());
            config2.setCloseButtonVisible(this.a.getUserDialog().getCancelable());
            List<Action> actions = this.a.getUserDialog().getActions();
            if (!(actions == null || (action = actions.get(0)) == null)) {
                config2.addPrimaryButton(action.getTitle(), new o(this, config2, dialogInterface2));
            }
            return Unit.INSTANCE;
        }
    }

    public static final class f implements View.OnClickListener {
        public final /* synthetic */ BottomSheetDialog a;
        public final /* synthetic */ AdvertDetailsViewImpl b;

        public static final class a<T> implements Consumer<Unit> {
            public final /* synthetic */ f a;

            public a(f fVar) {
                this.a = fVar;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.rxjava3.functions.Consumer
            public void accept(Unit unit) {
                this.a.b.D.onEnableNotificationDialogSuccess();
            }
        }

        public f(BottomSheetDialog bottomSheetDialog, AdvertDetailsViewImpl advertDetailsViewImpl) {
            this.a = bottomSheetDialog;
            this.b = advertDetailsViewImpl;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.cancel();
            this.b.F.trackEnableNotificationClick();
            CompositeDisposable compositeDisposable = this.b.s;
            Dialogs dialogs = Dialogs.INSTANCE;
            Context context = this.b.t.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            Disposable subscribe = dialogs.showEnableNotifications(context).subscribe(new a(this));
            Intrinsics.checkNotNullExpressionValue(subscribe, "Dialogs.showEnableNotifi…ccess()\n                }");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
        }
    }

    public static final class g extends Lambda implements Function1<Context, Unit> {
        public final /* synthetic */ AdvertDetailsViewImpl a;
        public final /* synthetic */ PhoneLink b;
        public final /* synthetic */ String c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(AdvertDetailsViewImpl advertDetailsViewImpl, PhoneLink phoneLink, String str) {
            super(1);
            this.a = advertDetailsViewImpl;
            this.b = phoneLink;
            this.c = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Context context) {
            Context context2 = context;
            Intrinsics.checkNotNullParameter(context2, "context");
            this.a.k = new AlertDialog.Builder(context2).setTitle(R.string.phone).setMessage(this.a.G.format(this.b.getPhone())).setPositiveButton(com.avito.android.ui_components.R.string.call, new p(this)).setOnDismissListener(new q(this)).setOnCancelListener(new r(this)).create();
            AlertDialog alertDialog = this.a.k;
            if (alertDialog != null) {
                alertDialog.show();
            }
            this.a.I.onPhoneCallShown(this.c);
            return Unit.INSTANCE;
        }
    }

    public static final class h implements View.OnClickListener {
        public final /* synthetic */ BottomSheetDialog a;

        public h(BottomSheetDialog bottomSheetDialog) {
            this.a = bottomSheetDialog;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.cancel();
        }
    }

    public static final class i implements Runnable {
        public final /* synthetic */ AdvertDetailsViewImpl a;
        public final /* synthetic */ String b;

        public i(AdvertDetailsViewImpl advertDetailsViewImpl, String str) {
            this.a = advertDetailsViewImpl;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            String str = this.b;
            if (str != null) {
                AdvertDetailsViewImpl.access$updateNote(this.a, str);
            }
        }
    }

    public AdvertDetailsViewImpl(@NotNull View view, @NotNull AdvertDetailsFragmentDelegate advertDetailsFragmentDelegate, @NotNull AdvertDetailsRouter advertDetailsRouter, @NotNull DialogRouter dialogRouter, @Nullable AdvertDetailsCallbacks advertDetailsCallbacks, @NotNull AdvertComplementaryPresenter advertComplementaryPresenter, @NotNull FavoriteAdvertsPresenter favoriteAdvertsPresenter, @NotNull ViewedAdvertsPresenter viewedAdvertsPresenter, @NotNull SectionActionPresenter sectionActionPresenter, @NotNull AdvertDetailsItemsPresenter advertDetailsItemsPresenter, @NotNull SellerSubscriptionPresenter sellerSubscriptionPresenter, @Nullable MarketplacePresenter marketplacePresenter, @NotNull AdvertDetailsPresenter advertDetailsPresenter, @NotNull Formatter<String> formatter, @NotNull AdvertSellerPresenter advertSellerPresenter, @NotNull AdvertContactsPresenter advertContactsPresenter, @NotNull AdvertDetailsToolbarPresenter advertDetailsToolbarPresenter, @NotNull DestroyableViewHolderBuilder destroyableViewHolderBuilder, @NotNull AdvertDetailsAutotekaPresenter advertDetailsAutotekaPresenter, @NotNull AdvertDetailsAutotekaTeaserPresenter advertDetailsAutotekaTeaserPresenter, @NotNull AdvertDetailsNotePresenter advertDetailsNotePresenter, @NotNull DfpCreditViewModel dfpCreditViewModel, @NotNull LifecycleOwner lifecycleOwner, @NotNull SpannedGridPositionProvider spannedGridPositionProvider, @NotNull GridLayoutManager.SpanSizeLookup spanSizeLookup, @NotNull SerpSpanProvider serpSpanProvider, @NotNull AdapterPresenter adapterPresenter, @NotNull SafeRecyclerAdapter safeRecyclerAdapter, @NotNull DeviceMetrics deviceMetrics, @NotNull AdvertSimilarPresenterResourceProvider advertSimilarPresenterResourceProvider, @NotNull Features features, @NotNull ItemVisibilityTracker itemVisibilityTracker, @NotNull RecyclerView.OnScrollListener onScrollListener, @Nullable CartFabView cartFabView) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(advertDetailsFragmentDelegate, "advertDetailsDelegate");
        Intrinsics.checkNotNullParameter(advertDetailsRouter, "advertDetailsRouter");
        Intrinsics.checkNotNullParameter(dialogRouter, "dialogRouter");
        Intrinsics.checkNotNullParameter(advertComplementaryPresenter, "advertComplementaryPresenter");
        Intrinsics.checkNotNullParameter(favoriteAdvertsPresenter, "favoriteAdvertsPresenter");
        Intrinsics.checkNotNullParameter(viewedAdvertsPresenter, "viewedAdvertsPresenter");
        Intrinsics.checkNotNullParameter(sectionActionPresenter, "sectionActionPresenter");
        Intrinsics.checkNotNullParameter(advertDetailsItemsPresenter, "advertDetailsItemsPresenter");
        Intrinsics.checkNotNullParameter(sellerSubscriptionPresenter, "sellerSubscriptionPresenter");
        Intrinsics.checkNotNullParameter(advertDetailsPresenter, "presenter");
        Intrinsics.checkNotNullParameter(formatter, "phoneNumberFormatter");
        Intrinsics.checkNotNullParameter(advertSellerPresenter, "sellerPresenter");
        Intrinsics.checkNotNullParameter(advertContactsPresenter, "contactsPresenter");
        Intrinsics.checkNotNullParameter(advertDetailsToolbarPresenter, "advertDetailsToolbarPresenter");
        Intrinsics.checkNotNullParameter(destroyableViewHolderBuilder, "destroyableComplementaryViewHolderBuilder");
        Intrinsics.checkNotNullParameter(advertDetailsAutotekaPresenter, "autotekaPresenter");
        Intrinsics.checkNotNullParameter(advertDetailsAutotekaTeaserPresenter, "autotekaTeaserPresenter");
        Intrinsics.checkNotNullParameter(advertDetailsNotePresenter, "notePresenter");
        Intrinsics.checkNotNullParameter(dfpCreditViewModel, "dfpCreditViewModel");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(spannedGridPositionProvider, "gridPositionProvider");
        Intrinsics.checkNotNullParameter(spanSizeLookup, "spanSizeLookup");
        Intrinsics.checkNotNullParameter(serpSpanProvider, "spanProvider");
        Intrinsics.checkNotNullParameter(adapterPresenter, "sectionsAdapterPresenter");
        Intrinsics.checkNotNullParameter(safeRecyclerAdapter, "itemsSafeRecyclerAdapter");
        Intrinsics.checkNotNullParameter(deviceMetrics, "deviceMetrics");
        Intrinsics.checkNotNullParameter(advertSimilarPresenterResourceProvider, "similarAdvertResources");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(itemVisibilityTracker, "itemVisibilityTracker");
        Intrinsics.checkNotNullParameter(onScrollListener, "fpsListener");
        this.t = view;
        this.u = advertDetailsFragmentDelegate;
        this.v = advertDetailsRouter;
        this.w = dialogRouter;
        this.x = advertDetailsCallbacks;
        this.y = advertComplementaryPresenter;
        this.z = favoriteAdvertsPresenter;
        this.A = viewedAdvertsPresenter;
        this.B = sectionActionPresenter;
        this.C = advertDetailsItemsPresenter;
        this.D = sellerSubscriptionPresenter;
        this.E = marketplacePresenter;
        this.F = advertDetailsPresenter;
        this.G = formatter;
        this.H = advertSellerPresenter;
        this.I = advertContactsPresenter;
        this.J = advertDetailsToolbarPresenter;
        this.K = destroyableViewHolderBuilder;
        this.L = advertDetailsAutotekaPresenter;
        this.M = advertDetailsAutotekaTeaserPresenter;
        this.N = advertDetailsNotePresenter;
        this.O = dfpCreditViewModel;
        this.P = spannedGridPositionProvider;
        this.Q = serpSpanProvider;
        this.R = adapterPresenter;
        this.S = safeRecyclerAdapter;
        this.T = deviceMetrics;
        this.U = advertSimilarPresenterResourceProvider;
        this.V = features;
        this.W = itemVisibilityTracker;
        this.X = onScrollListener;
        this.Y = cartFabView;
        this.a = view.getContext();
        this.b = view.getResources();
        View findViewById = view.findViewById(R.id.advert_details_container);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(advert…advert_details_container)");
        this.c = (FrameLayout) findViewById;
        View findViewById2 = view.findViewById(R.id.advert_details_recycler);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(advert….advert_details_recycler)");
        RecyclerView recyclerView = (RecyclerView) findViewById2;
        this.e = recyclerView;
        ArrayList arrayList = new ArrayList();
        this.h = arrayList;
        this.i = new ListDataSource<>(arrayList);
        this.s = new CompositeDisposable();
        recyclerView.addOnScrollListener(onScrollListener);
        RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
        Objects.requireNonNull(itemAnimator, "null cannot be cast to non-null type androidx.recyclerview.widget.SimpleItemAnimator");
        ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
        this.d = new AdvertContactsViewImpl(view, false, true, this, features, null, null, 96, null);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(view.getContext(), advertSimilarPresenterResourceProvider.getSimilarColumns(), 1, false);
        this.n = gridLayoutManager;
        gridLayoutManager.setSpanSizeLookup(spanSizeLookup);
        recyclerView.setLayoutManager(this.n);
        recyclerView.setNestedScrollingEnabled(true);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener(this) { // from class: com.avito.android.advert.item.AdvertDetailsViewImpl.1
            public final /* synthetic */ AdvertDetailsViewImpl a;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = r1;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NotNull RecyclerView recyclerView2, int i2, int i3) {
                Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
                super.onScrolled(recyclerView2, i2, i3);
                this.a.b();
            }
        });
        dfpCreditViewModel.isEditing().observe(lifecycleOwner, new a(this));
    }

    public static final void access$updateNote(AdvertDetailsViewImpl advertDetailsViewImpl, String str) {
        advertDetailsViewImpl.N.updateNote(str);
        advertDetailsViewImpl.J.updateNoteMenuItemTitle(str);
    }

    public final AdvertCallMethodsDialogFragment a() {
        FragmentManager fragmentManager = this.u.fragmentManager();
        return (AdvertCallMethodsDialogFragment) (fragmentManager != null ? fragmentManager.findFragmentByTag("call_methods_dlg") : null);
    }

    @Override // com.avito.android.advert.item.AdvertDetailsView, com.avito.android.advert_core.advert.AdvertCoreView
    public void attach() {
        MarketplacePresenter marketplacePresenter;
        this.F.attachRouter(this.v);
        this.H.attachRouter(this.v);
        this.B.attachRouter(this.F);
        this.L.attachRouter(this.v);
        this.M.attachRouter(this.v);
        this.N.attachRouter(this.v);
        this.z.attachView(this);
        this.A.attachView(this);
        AdvertContactsView advertContactsView = this.d;
        if (advertContactsView != null) {
            this.H.attachView(advertContactsView);
        }
        this.D.attachView(this);
        this.D.attachRouter(this.v);
        this.C.attachView(this);
        CartFabView cartFabView = this.Y;
        if (!(cartFabView == null || (marketplacePresenter = this.E) == null)) {
            marketplacePresenter.attachView(cartFabView);
        }
        AdvertCallMethodsDialogFragment a3 = a();
        if (a3 != null) {
            a3.setCallback(this.I);
        }
    }

    public final void b() {
        Iterator<SpannedItem> it = this.h.iterator();
        boolean z2 = false;
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                i2 = -1;
                break;
            } else if (it.next() instanceof AdvertDetailsContactBarItem) {
                break;
            } else {
                i2++;
            }
        }
        if (this.o && i2 != -1) {
            int findLastVisibleItemPosition = this.n.findLastVisibleItemPosition();
            RecyclerView.ViewHolder findViewHolderForLayoutPosition = this.e.findViewHolderForLayoutPosition(i2);
            if (!(findViewHolderForLayoutPosition instanceof AdvertDetailsContactBarView)) {
                findViewHolderForLayoutPosition = null;
            }
            AdvertDetailsContactBarView advertDetailsContactBarView = (AdvertDetailsContactBarView) findViewHolderForLayoutPosition;
            int buttonsTop = advertDetailsContactBarView != null ? advertDetailsContactBarView.getButtonsTop() : 0;
            AdvertContactsView advertContactsView = this.d;
            int buttonsTop2 = advertContactsView != null ? advertContactsView.getButtonsTop() : 0;
            if (Intrinsics.areEqual(this.O.isEditing().getValue(), Boolean.TRUE) || this.r) {
                z2 = true;
            }
            if (!z2 && buttonsTop == 0 && findLastVisibleItemPosition <= i2) {
                AdvertContactsView advertContactsView2 = this.d;
                if (advertContactsView2 != null) {
                    advertContactsView2.show();
                }
                if (advertDetailsContactBarView != null) {
                    advertDetailsContactBarView.hide();
                }
            } else if (z2 || buttonsTop < buttonsTop2) {
                AdvertContactsView advertContactsView3 = this.d;
                if (advertContactsView3 != null) {
                    advertContactsView3.hide();
                }
                if (advertDetailsContactBarView != null) {
                    advertDetailsContactBarView.show();
                }
            } else {
                AdvertContactsView advertContactsView4 = this.d;
                if (advertContactsView4 != null) {
                    advertContactsView4.show();
                }
                if (advertDetailsContactBarView != null) {
                    advertDetailsContactBarView.hide();
                }
            }
        }
    }

    @Override // com.avito.android.advert.item.AdvertDetailsView
    public void bindItemsList(@NotNull List<? extends SpannedItem> list, int i2, @Nullable Integer num, @Nullable Integer num2) {
        T t2;
        AdvertContactsView advertContactsView;
        Intrinsics.checkNotNullParameter(list, "items");
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                t2 = null;
                break;
            }
            t2 = it.next();
            if (t2 instanceof AdvertDetailsContactBarItem) {
                break;
            }
        }
        if (t2 == null && (advertContactsView = this.d) != null) {
            advertContactsView.hide();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.h);
        this.h.clear();
        this.h.addAll(list);
        if (this.e.getAdapter() == null) {
            this.Q.setAppendingListener(this.y);
            this.Q.onDataSourceChanged(this.i);
            this.P.onDataSourceChanged(this.i);
            this.z.onDataSourceChanged(this.i);
            this.A.onDataSourceChanged(this.i);
            this.R.onDataSourceChanged(this.i);
            this.e.setAdapter(this.S);
            if (this.V.getViewVisibilityTracking().invoke().booleanValue()) {
                ItemVisibilityTracker.DefaultImpls.subscribe$default(this.W, this.e, null, 2, null);
            }
        } else {
            DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(new DiffUtil.Callback(arrayList, list) { // from class: com.avito.android.advert.item.AdvertDetailsViewImpl$bindItemsList$diff$1
                public final /* synthetic */ List a;
                public final /* synthetic */ List b;

                {
                    this.a = r1;
                    this.b = r2;
                }

                @Override // androidx.recyclerview.widget.DiffUtil.Callback
                public boolean areContentsTheSame(int i3, int i4) {
                    SpannedItem spannedItem = (SpannedItem) this.a.get(i3);
                    SpannedItem spannedItem2 = (SpannedItem) this.b.get(i4);
                    if (!(spannedItem instanceof AdvertDetailsGalleryItem) || !(spannedItem2 instanceof AdvertDetailsGalleryItem)) {
                        if (!(spannedItem instanceof ExpandSectionsButtonItem) || !(spannedItem2 instanceof ExpandSectionsButtonItem)) {
                            if ((spannedItem instanceof AdvertDetailsTitleItem) && (spannedItem2 instanceof AdvertDetailsTitleItem)) {
                                return Intrinsics.areEqual(((AdvertDetailsTitleItem) spannedItem).getTitle(), ((AdvertDetailsTitleItem) spannedItem2).getTitle());
                            }
                            if (!(spannedItem instanceof AdvertDetailsPriceItem) || !(spannedItem2 instanceof AdvertDetailsPriceItem)) {
                                return true;
                            }
                            AdvertDetailsPriceItem advertDetailsPriceItem = (AdvertDetailsPriceItem) spannedItem;
                            AdvertDetailsPriceItem advertDetailsPriceItem2 = (AdvertDetailsPriceItem) spannedItem2;
                            if (Intrinsics.areEqual(advertDetailsPriceItem.getPrice(), advertDetailsPriceItem2.getPrice()) && Intrinsics.areEqual(advertDetailsPriceItem.getOldPrice(), advertDetailsPriceItem2.getOldPrice())) {
                                return true;
                            }
                        } else if (((ExpandSectionsButtonItem) spannedItem).isExpanded() == ((ExpandSectionsButtonItem) spannedItem2).isExpanded()) {
                            return true;
                        }
                    }
                    return false;
                }

                @Override // androidx.recyclerview.widget.DiffUtil.Callback
                public boolean areItemsTheSame(int i3, int i4) {
                    return Intrinsics.areEqual(((SpannedItem) this.a.get(i3)).getClass(), ((SpannedItem) this.b.get(i4)).getClass()) && ((SpannedItem) this.a.get(i3)).getId() == ((SpannedItem) this.b.get(i4)).getId();
                }

                @Override // androidx.recyclerview.widget.DiffUtil.Callback
                public int getNewListSize() {
                    return this.b.size();
                }

                @Override // androidx.recyclerview.widget.DiffUtil.Callback
                public int getOldListSize() {
                    return this.a.size();
                }
            }, true);
            Intrinsics.checkNotNullExpressionValue(calculateDiff, "DiffUtil.calculateDiff(o…size\n            }, true)");
            SafeRecyclerAdapter safeRecyclerAdapter = this.S;
            Objects.requireNonNull(safeRecyclerAdapter, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.Adapter<*>");
            calculateDiff.dispatchUpdatesTo((RecyclerView.Adapter) safeRecyclerAdapter);
        }
        if (this.V.getViewVisibilityTracking().invoke().booleanValue()) {
            this.W.onDataSourceChanged(this.i);
        }
        if (i2 >= 0) {
            RecyclerView.ItemDecoration itemDecoration = this.f;
            if (itemDecoration != null) {
                this.e.removeItemDecoration(itemDecoration);
            }
            RecyclerView.ItemDecoration itemDecoration2 = this.g;
            if (itemDecoration2 != null) {
                this.e.removeItemDecoration(itemDecoration2);
            }
            ArrayList arrayList2 = new ArrayList();
            int i3 = 0;
            for (T t3 : this.h) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                T t4 = t3;
                if ((t4 instanceof SectionTitleItem) || (t4 instanceof SectionTitleWithActionItem)) {
                    arrayList2.add(Integer.valueOf(i3));
                }
                i3 = i4;
            }
            int similarColumns = this.U.getSimilarColumns();
            Resources resources = this.t.getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "view.resources");
            GridAfterHeaderItemDecorator gridAfterHeaderItemDecorator = new GridAfterHeaderItemDecorator(arrayList2, similarColumns, resources, this.T);
            int similarColumns2 = this.U.getSimilarColumns();
            Resources resources2 = this.t.getResources();
            Intrinsics.checkNotNullExpressionValue(resources2, "view.resources");
            CommercialItemDecorator commercialItemDecorator = new CommercialItemDecorator(similarColumns2, num, num2, resources2, this.T);
            this.f = gridAfterHeaderItemDecorator;
            this.g = commercialItemDecorator;
            this.e.addItemDecoration(gridAfterHeaderItemDecorator);
            this.e.addItemDecoration(commercialItemDecorator);
        }
    }

    @Override // com.avito.android.advert_core.advert.AdvertFeedbackView
    public void clearFeedbackState(boolean z2) {
        this.l = null;
        if (z2) {
            this.t.postDelayed(new b(this), 500);
        }
    }

    @Override // com.avito.android.util.architecture_components.auto_clear.LifecycleDestroyable
    public void destroy() {
        detach();
    }

    @Override // com.avito.android.advert.item.AdvertDetailsView, com.avito.android.advert_core.advert.AdvertCoreView
    public void detach() {
        this.e.setAdapter(null);
        this.e.removeOnScrollListener(this.X);
        AdvertCallMethodsDialogFragment a3 = a();
        if (a3 != null) {
            a3.setCallback(null);
        }
        this.F.detachRouter();
        this.H.detachRouter();
        this.H.detachViews();
        this.B.detachRouter();
        this.z.detachViews();
        this.A.detachView();
        this.K.destroy();
        this.L.detachView();
        this.L.detachRouter();
        this.M.detachView();
        this.M.detachRouter();
        this.C.detachView();
        MarketplacePresenter marketplacePresenter = this.E;
        if (marketplacePresenter != null) {
            marketplacePresenter.detachViews();
        }
        this.F.detachDfpCreditViewModel();
        this.N.detachView();
        this.N.detachRouter();
        this.D.detachView();
        this.D.detachRouter();
        this.s.clear();
        Snackbar snackbar = this.p;
        if (snackbar != null) {
            snackbar.dismiss();
        }
        com.avito.android.lib.design.snackbar.Snackbar snackbar2 = this.q;
        if (snackbar2 != null) {
            snackbar2.dismiss();
        }
    }

    @Override // com.avito.android.advert_core.advert.AdvertCoreView
    public void dismissProgress() {
        android.app.Dialog dialog = this.j;
        if (dialog != null) {
            if (dialog != null) {
                dialog.dismiss();
            }
            this.j = null;
        }
    }

    @Override // com.avito.android.advert_core.advert.AdvertCoreView
    public void displayMessage(@NotNull String str, @Nullable String str2, @Nullable Function0<Unit> function0, @NotNull SnackbarPosition snackbarPosition) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(snackbarPosition, VKApiConst.POSITION);
        SnackbarElementView.DefaultImpls.showSnackbar$default(this, str, 0, str2, 0, function0, 0, snackbarPosition, null, 170, null);
    }

    @Override // com.avito.android.advert_core.delivery.AdvertDeliveryBlockView.Listener
    public void followUri(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        this.v.followUri(uri);
    }

    @Override // com.avito.android.advert_core.advert.AdvertFeedbackView
    @Nullable
    public FeedbackDialog.State getFeedbackState() {
        FeedbackDialog feedbackDialog = this.l;
        if (feedbackDialog != null) {
            return feedbackDialog.getState();
        }
        return null;
    }

    @Override // com.avito.android.favorite.FavoriteAdvertsView, com.avito.android.advert.viewed.ViewedAdvertsView
    public void notifyItemAtPositionChanged(int i2) {
        RecyclerView.Adapter adapter = this.e.getAdapter();
        if (adapter != null) {
            adapter.notifyItemChanged(i2);
        }
    }

    @Override // com.avito.android.advert_core.contactbar.AdvertContactsBindListener
    public void onContactBarBind(int i2) {
        this.o = true;
        AdvertContactsView advertContactsView = this.d;
        if (advertContactsView != null) {
            advertContactsView.animateShowHide(true, true);
        }
        b();
    }

    @Override // com.avito.android.advert.item.AdvertDetailsView
    public void onDataSourceUnavailable() {
        dismissProgress();
        this.p = Views.showCustomSnackbar$default(this.t, R.layout.network_retry, null, -2, 0, R.id.advert_network_error_retry, null, new c(this), 42, null);
    }

    @Override // com.avito.android.bottom_navigation.KeyboardListener
    public void onKeyboardVisibilityChanged(boolean z2) {
        this.r = z2;
        b();
    }

    @Override // com.avito.android.advert.item.AdvertDetailsView
    public void onLoadError(@NotNull Throwable th) {
        Intrinsics.checkNotNullParameter(th, "e");
        dismissProgress();
        this.u.handleError(th, true);
    }

    @Override // com.avito.android.advert.item.AdvertDetailsView
    public void onLoadFailed() {
        AdvertDetailsCallbacks advertDetailsCallbacks = this.x;
        if (advertDetailsCallbacks != null) {
            advertDetailsCallbacks.onLoadFailed();
        }
    }

    @Override // com.avito.android.advert.item.AdvertDetailsView
    public void onLoadingFinish() {
        dismissProgress();
    }

    @Override // com.avito.android.advert.item.AdvertDetailsView
    public void onLoadingStart() {
    }

    @Override // com.avito.android.progress_overlay.OnRefreshListener
    public void onRefresh() {
        this.F.refresh();
    }

    @Override // com.avito.android.advert.item.AdvertDetailsView
    public void refreshList() {
        this.S.notifyDataSetChanged();
    }

    @Override // com.avito.android.advert.item.AdvertDetailsView
    public void removeToolbarShadow() {
        this.c.setForeground(null);
    }

    @Override // com.avito.android.advert.item.AdvertDetailsView
    @NotNull
    public Observable<Integer> scrollStateChanges() {
        Observable<Integer> create = Observable.create(new AdvertDetailsViewImpl$scrollStateChanges$1(this));
        Intrinsics.checkNotNullExpressionValue(create, "Observable.create { emit…istener(listener) }\n    }");
        return create;
    }

    @Override // com.avito.android.advert.item.AdvertDetailsView
    public void showAddressCopied() {
        Context context = this.a;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        String string = this.b.getString(R.string.address_is_copied);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(adve…string.address_is_copied)");
        ToastsKt.showToast$default(context, string, 0, 2, (Object) null);
    }

    @Override // com.avito.android.advert.item.AdvertDetailsView
    public void showAddressOnMap(@Nullable String str, @NotNull String str2, @NotNull Coordinates coordinates, @NotNull String str3, @Nullable List<GeoReference> list) {
        Intrinsics.checkNotNullParameter(str2, IntegrityManager.INTEGRITY_TYPE_ADDRESS);
        Intrinsics.checkNotNullParameter(coordinates, "coordinates");
        Intrinsics.checkNotNullParameter(str3, "title");
        this.v.showAddressOnMap(str, str2, coordinates, str3, list);
    }

    @Override // com.avito.android.advert_core.advert.AdvertCoreView
    public void showAntiFraudCheckList() {
        Context context = this.a;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        new AntiFraudDialog(context, this.I).show();
    }

    @Override // com.avito.android.advert_core.advert.AdvertCoreView
    public void showCallMethods(@NotNull CallMethods callMethods) {
        Intrinsics.checkNotNullParameter(callMethods, "callMethods");
        FragmentManager fragmentManager = this.u.fragmentManager();
        if (fragmentManager != null) {
            AdvertCallMethodsDialogFragment newInstance = AdvertCallMethodsDialogFragment.Companion.newInstance(callMethods);
            newInstance.setCallback(this.I);
            newInstance.show(fragmentManager, "call_methods_dlg");
        }
    }

    @Override // com.avito.android.advert.item.AdvertDetailsView
    public void showConsultationForm(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        this.v.showConsultationForm(str);
    }

    @Override // com.avito.android.advert_core.advert.AdvertCoreView
    public void showContactAccessPackage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        this.v.showContactAccessPackage(str);
    }

    @Override // com.avito.android.advert.item.AdvertDetailsView
    public void showEnableNotificationDialog() {
        CompositeDisposable compositeDisposable = this.s;
        Dialogs dialogs = Dialogs.INSTANCE;
        Context context = this.t.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        Disposable subscribe = dialogs.showEnableNotifications(context).subscribe(new d(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "Dialogs.showEnableNotifi…DialogSuccess()\n        }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @Override // com.avito.android.advert_core.advert.AdvertCoreView
    public void showError(@NotNull Throwable th) {
        Intrinsics.checkNotNullParameter(th, "e");
        this.u.handleError(th, true);
    }

    @Override // com.avito.android.advert.item.AdvertDetailsView
    public void showErrorDialog(@NotNull ErrorResult.ErrorDialog errorDialog, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(errorDialog, "errorDialog");
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        android.app.Dialog dialog = this.m;
        if (dialog != null) {
            dialog.dismiss();
        }
        Dialog.Companion companion = com.avito.android.lib.design.dialog.Dialog.Companion;
        Context context = this.t.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        com.avito.android.lib.design.dialog.Dialog create$default = Dialog.Companion.create$default(companion, context, 0, 0, new e(errorDialog, function0), 6, null);
        this.m = create$default;
        if (create$default != null) {
            create$default.show();
        }
    }

    @Override // com.avito.android.advert_core.advert.AdvertFeedbackView
    public void showFeedback(@NotNull FeedbackDialog.State state, @NotNull FeedbackDialog.Listener listener) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        if (this.l == null) {
            Context context = this.a;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            FeedbackDialog feedbackDialog = new FeedbackDialog(context, state, listener);
            this.l = feedbackDialog;
            if (feedbackDialog != null) {
                feedbackDialog.show();
            }
        }
    }

    @Override // com.avito.android.advert.item.AdvertDetailsView
    public void showInactiveItem(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        this.v.showInactiveItem(str);
    }

    @Override // com.avito.android.advert.item.AdvertDetailsView
    public void showNotificationsEnableWarning() {
        Context context = this.a;
        Intrinsics.checkNotNullExpressionValue(context, "this.context");
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context, 0, 2, null);
        bottomSheetDialog.setContentView(com.avito.android.advert_details.R.layout.advert_details_bottom_sheet_warning);
        Button button = (Button) bottomSheetDialog.findViewById(com.avito.android.advert_details.R.id.advert_details_bottom_sheet_button);
        if (button != null) {
            button.setOnClickListener(new f(bottomSheetDialog, this));
        }
        bottomSheetDialog.setCancelable(true);
        bottomSheetDialog.setCanceledOnTouchOutside(true);
        bottomSheetDialog.setTitle((CharSequence) null);
        Resources resources = this.b;
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        if (resources.getConfiguration().orientation == 2) {
            Resources resources2 = this.b;
            Intrinsics.checkNotNullExpressionValue(resources2, "resources");
            bottomSheetDialog.setPeekHeight(resources2.getDisplayMetrics().widthPixels);
        }
        bottomSheetDialog.show();
    }

    @Override // com.avito.android.advert_core.advert.AdvertCoreView
    public void showPhoneCallConfirmation(@NotNull PhoneLink phoneLink, @NotNull String str) {
        Intrinsics.checkNotNullParameter(phoneLink, "phoneLink");
        Intrinsics.checkNotNullParameter(str, "source");
        AlertDialog alertDialog = this.k;
        if (alertDialog == null || !alertDialog.isShowing()) {
            this.u.runBlockWithContext(new g(this, phoneLink, str));
        }
    }

    @Override // com.avito.android.advert.item.AdvertDetailsView
    public void showPriceSubscriptionInfo() {
        Context context = this.a;
        Intrinsics.checkNotNullExpressionValue(context, "this.context");
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context, 0, 2, null);
        bottomSheetDialog.setContentView(com.avito.android.advert_details.R.layout.advert_details_bottom_sheet_info);
        Button button = (Button) bottomSheetDialog.findViewById(com.avito.android.advert_details.R.id.advert_details_bottom_sheet_button);
        if (button != null) {
            button.setOnClickListener(new h(bottomSheetDialog));
        }
        bottomSheetDialog.setCancelable(true);
        bottomSheetDialog.setCanceledOnTouchOutside(true);
        bottomSheetDialog.setTitle((CharSequence) null);
        Resources resources = this.b;
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        if (resources.getConfiguration().orientation == 2) {
            Resources resources2 = this.b;
            Intrinsics.checkNotNullExpressionValue(resources2, "resources");
            bottomSheetDialog.setPeekHeight(resources2.getDisplayMetrics().widthPixels);
        }
        bottomSheetDialog.show();
    }

    @Override // com.avito.android.advert_core.advert.AdvertCoreView
    public void showProgress() {
        if (this.j == null) {
            this.j = this.w.showSimpleWaitingDialog();
        }
    }

    @Override // com.avito.android.advert_core.advert.AdvertCoreView
    public void showSellerNotifiedAboutCall() {
        Context context = this.a;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        String string = this.b.getString(R.string.advert_seller_notified_about_call);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(adve…ller_notified_about_call)");
        ToastsKt.showToast$default(context, string, 0, 2, (Object) null);
    }

    @Override // com.avito.android.advert_core.SnackBarListener
    public void showSnackBar(@NotNull String str, int i2, int i3, @Nullable String str2, @Nullable Function0<Unit> function0, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "text");
        Views.showSnackBar$default(this.t, str, i2, str2, i3, function0, (Function0) null, 0, 96, (Object) null).show();
    }

    @Override // com.avito.android.lib.design.snackbar.util.SnackbarElementView
    public void showSnackbar(@NotNull String str, int i2, @Nullable String str2, int i3, @Nullable Function0<Unit> function0, int i4, @NotNull SnackbarPosition snackbarPosition, @NotNull SnackbarType snackbarType) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(snackbarPosition, VKApiConst.POSITION);
        Intrinsics.checkNotNullParameter(snackbarType, "type");
        com.avito.android.lib.design.snackbar.Snackbar snackbar = this.q;
        if (snackbar != null) {
            snackbar.dismiss();
        }
        this.q = SnackbarExtensionsKt.showSnackbar(this.t, str, i2, str2, i3, function0, i4, snackbarPosition, snackbarType);
    }

    @Override // com.avito.android.advert.item.AdvertDetailsView
    public void showSnackbarAboveContactBar(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        AdvertContactsView advertContactsView = this.d;
        if (advertContactsView != null) {
            advertContactsView.showSnackbarAbove(str);
        }
    }

    @Override // com.avito.android.advert.item.AdvertDetailsViewScroller
    public <T extends Item> void smoothScrollToItem(@NotNull Class<T> cls, int i2, int i3, boolean z2) {
        Intrinsics.checkNotNullParameter(cls, "type");
        Iterator<SpannedItem> it = this.h.iterator();
        int i4 = 0;
        while (true) {
            if (!it.hasNext()) {
                i4 = -1;
                break;
            } else if (cls.isInstance(it.next())) {
                break;
            } else {
                i4++;
            }
        }
        if (i4 >= 0) {
            smoothScrollToPosition(i4, i2, i3, z2);
        }
    }

    @Override // com.avito.android.advert.item.AdvertDetailsViewScroller
    public void smoothScrollToPosition(int i2, int i3, int i4, boolean z2) {
        RecyclerView.LayoutManager layoutManager = this.e.getLayoutManager();
        if (layoutManager != null) {
            AdvertDetailsViewImpl$smoothScrollToPosition$$inlined$let$lambda$1 advertDetailsViewImpl$smoothScrollToPosition$$inlined$let$lambda$1 = new LinearSmoothScroller(this.a, this, i4, i3, z2, i2) { // from class: com.avito.android.advert.item.AdvertDetailsViewImpl$smoothScrollToPosition$$inlined$let$lambda$1
                public final /* synthetic */ int l;
                public final /* synthetic */ int m;
                public final /* synthetic */ boolean n;

                {
                    this.l = r3;
                    this.m = r4;
                    this.n = r5;
                }

                @Override // androidx.recyclerview.widget.LinearSmoothScroller
                public int calculateDyToMakeVisible(@Nullable View view, int i5) {
                    int calculateDyToMakeVisible = super.calculateDyToMakeVisible(view, i5);
                    if (view != null && this.l == -1 && view.getTop() > 0 && view.getTop() < Math.abs(calculateDyToMakeVisible)) {
                        calculateDyToMakeVisible = -view.getTop();
                    }
                    return calculateDyToMakeVisible + this.m;
                }

                @Override // androidx.recyclerview.widget.LinearSmoothScroller
                public float calculateSpeedPerPixel(@Nullable DisplayMetrics displayMetrics) {
                    float f2 = this.n ? 25.0f : 80.0f;
                    Intrinsics.checkNotNull(displayMetrics);
                    return f2 / ((float) displayMetrics.densityDpi);
                }

                @Override // androidx.recyclerview.widget.LinearSmoothScroller
                public int getHorizontalSnapPreference() {
                    return -1;
                }

                @Override // androidx.recyclerview.widget.LinearSmoothScroller
                public int getVerticalSnapPreference() {
                    return this.l;
                }
            };
            advertDetailsViewImpl$smoothScrollToPosition$$inlined$let$lambda$1.setTargetPosition(i2);
            layoutManager.startSmoothScroll(advertDetailsViewImpl$smoothScrollToPosition$$inlined$let$lambda$1);
        }
    }

    @Override // com.avito.android.advert.item.AdvertDetailsViewScroller
    public void smoothScrollToStart() {
        AdvertDetailsViewScroller.DefaultImpls.smoothScrollToPosition$default(this, 0, 0, 0, false, 14, null);
    }

    @Override // com.avito.android.advert.item.AdvertDetailsView
    public void updateAddNoteResult(@Nullable String str) {
        this.t.post(new i(this, str));
    }

    @Override // com.avito.android.advert.item.AdvertDetailsView
    public void updateMarketplaceDeliveryInfoItem(@Nullable MarketplaceDeliveryItem marketplaceDeliveryItem) {
        if (marketplaceDeliveryItem != null) {
            int i2 = 0;
            Iterator<SpannedItem> it = this.h.iterator();
            while (true) {
                if (!it.hasNext()) {
                    i2 = -1;
                    break;
                } else if (it.next() instanceof MarketplaceDeliveryItem) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 >= 0) {
                this.h.remove(i2);
                this.h.add(i2, marketplaceDeliveryItem);
                this.S.notifyItemChanged(i2);
            }
        }
    }

    @Override // com.avito.android.advert.item.AdvertViewScrollUpdater
    public void updateScroll() {
        b();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AdvertDetailsViewImpl(View view, AdvertDetailsFragmentDelegate advertDetailsFragmentDelegate, AdvertDetailsRouter advertDetailsRouter, DialogRouter dialogRouter, AdvertDetailsCallbacks advertDetailsCallbacks, AdvertComplementaryPresenter advertComplementaryPresenter, FavoriteAdvertsPresenter favoriteAdvertsPresenter, ViewedAdvertsPresenter viewedAdvertsPresenter, SectionActionPresenter sectionActionPresenter, AdvertDetailsItemsPresenter advertDetailsItemsPresenter, SellerSubscriptionPresenter sellerSubscriptionPresenter, MarketplacePresenter marketplacePresenter, AdvertDetailsPresenter advertDetailsPresenter, Formatter formatter, AdvertSellerPresenter advertSellerPresenter, AdvertContactsPresenter advertContactsPresenter, AdvertDetailsToolbarPresenter advertDetailsToolbarPresenter, DestroyableViewHolderBuilder destroyableViewHolderBuilder, AdvertDetailsAutotekaPresenter advertDetailsAutotekaPresenter, AdvertDetailsAutotekaTeaserPresenter advertDetailsAutotekaTeaserPresenter, AdvertDetailsNotePresenter advertDetailsNotePresenter, DfpCreditViewModel dfpCreditViewModel, LifecycleOwner lifecycleOwner, SpannedGridPositionProvider spannedGridPositionProvider, GridLayoutManager.SpanSizeLookup spanSizeLookup, SerpSpanProvider serpSpanProvider, AdapterPresenter adapterPresenter, SafeRecyclerAdapter safeRecyclerAdapter, DeviceMetrics deviceMetrics, AdvertSimilarPresenterResourceProvider advertSimilarPresenterResourceProvider, Features features, ItemVisibilityTracker itemVisibilityTracker, RecyclerView.OnScrollListener onScrollListener, CartFabView cartFabView, int i2, int i3, j jVar) {
        this(view, advertDetailsFragmentDelegate, advertDetailsRouter, dialogRouter, advertDetailsCallbacks, advertComplementaryPresenter, favoriteAdvertsPresenter, viewedAdvertsPresenter, sectionActionPresenter, advertDetailsItemsPresenter, sellerSubscriptionPresenter, marketplacePresenter, advertDetailsPresenter, formatter, advertSellerPresenter, advertContactsPresenter, advertDetailsToolbarPresenter, destroyableViewHolderBuilder, advertDetailsAutotekaPresenter, advertDetailsAutotekaTeaserPresenter, advertDetailsNotePresenter, dfpCreditViewModel, lifecycleOwner, spannedGridPositionProvider, spanSizeLookup, serpSpanProvider, adapterPresenter, safeRecyclerAdapter, deviceMetrics, advertSimilarPresenterResourceProvider, features, itemVisibilityTracker, onScrollListener, (i3 & 2) != 0 ? null : cartFabView);
    }
}
