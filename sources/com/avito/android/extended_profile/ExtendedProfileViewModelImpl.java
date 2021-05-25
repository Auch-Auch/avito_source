package com.avito.android.extended_profile;

import a2.a.a.q0.a0;
import a2.a.a.q0.b0;
import a2.a.a.q0.c0;
import a2.a.a.q0.d0;
import a2.a.a.q0.e0;
import a2.a.a.q0.f0;
import a2.a.a.q0.g0;
import a2.a.a.q0.h0;
import a2.a.a.q0.p;
import a2.a.a.q0.q;
import a2.a.a.q0.r;
import a2.a.a.q0.s;
import a2.a.a.q0.t;
import a2.a.a.q0.u;
import a2.a.a.q0.v;
import a2.a.a.q0.w;
import a2.a.a.q0.x;
import a2.a.a.q0.y;
import a2.a.a.q0.z;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.FavoriteSeller;
import com.avito.android.FavoriteSellersRepository;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.advert.viewed.ViewedAdvertsEventInteractor;
import com.avito.android.advert_core.contactbar.AdvertActionIconFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.CallToSellerClickStreamEvent;
import com.avito.android.analytics.screens.tracker.ScreenTransfer;
import com.avito.android.component.contact_bar.ContactBar;
import com.avito.android.deep_linking.links.AdvertDetailsLink;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.PhoneLink;
import com.avito.android.deep_linking.links.ProfilePhoneRequestLink;
import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.extended_profile.ExtendedProfileInteractorImpl;
import com.avito.android.extended_profile.ExtendedProfileViewEvent;
import com.avito.android.extended_profile.ExtendedProfileViewModel;
import com.avito.android.extended_profile.ExtendedProfileViewSingleLiveEvent;
import com.avito.android.extended_profile.adapter.ExtendedProfileListItem;
import com.avito.android.extended_profile.adapter.action.ExtendedProfileItemAction;
import com.avito.android.extended_profile.adapter.category.category_advert.CategoryAdvertItem;
import com.avito.android.extended_profile.adapter.category.category_advert.CategoryAdvertItemAction;
import com.avito.android.extended_profile.adapter.category.category_button.CategoryButtonAction;
import com.avito.android.extended_profile.adapter.category.category_button.CategoryButtonItem;
import com.avito.android.extended_profile.adapter.category.category_header.CategoryHeaderAction;
import com.avito.android.extended_profile.adapter.category.category_header.CategoryHeaderItem;
import com.avito.android.extended_profile.adapter.contact_bar.ContactBarItem;
import com.avito.android.extended_profile.adapter.contact_bar.ContactBarItemAction;
import com.avito.android.extended_profile.adapter.contact_bar.ContactBarItemKt;
import com.avito.android.extended_profile.adapter.divider.DividerItem;
import com.avito.android.extended_profile.adapter.error.RetryAction;
import com.avito.android.extended_profile.adapter.header.HeaderItem;
import com.avito.android.extended_profile.adapter.header.HeaderItemAction;
import com.avito.android.extended_profile.adapter.header.HeaderItemKt;
import com.avito.android.extended_profile.data.CategoryData;
import com.avito.android.extended_profile.data.CategoryDataContainer;
import com.avito.android.extended_profile.data.ExtendedProfileDataItem;
import com.avito.android.extended_profile.event.ExtendedProfilePictureViewEvent;
import com.avito.android.extended_profile.tracker.ExtendedProfileTracker;
import com.avito.android.favorite.FavoriteActionSource;
import com.avito.android.favorite.FavoriteAdvertsInteractor;
import com.avito.android.public_profile.analytics.event.AvatarPreviewEvent;
import com.avito.android.public_profile.analytics.event.ProfileShareEvent;
import com.avito.android.public_profile.remote.model.ExtendedPublicUserProfile;
import com.avito.android.public_profile.remote.model.SubscribeInfo;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AdvertAction;
import com.avito.android.remote.model.AdvertActions;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.Sharing;
import com.avito.android.tns_gallery.TnsGalleryItemClickAction;
import com.avito.android.util.LoadingState;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.TypedResultException;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¬\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0001\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0018\u0012\u0006\u0010|\u001a\u00020y\u0012\u0006\u0010^\u001a\u00020[\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\b\u0010©\u0001\u001a\u00030¦\u0001\u0012\b\u0010³\u0001\u001a\u00030°\u0001\u0012\u0006\u0010n\u001a\u00020k\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\u0006\u0010Z\u001a\u00020W\u0012\u0006\u0010b\u001a\u00020_\u0012\b\u0010¡\u0001\u001a\u00030\u0001\u0012\u0007\u0010\u0001\u001a\u00020\u0003\u0012\b\u0010\u0001\u001a\u00030\u0001¢\u0006\u0006\b´\u0001\u0010µ\u0001J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0011\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ+\u0010$\u001a\u00020\u00062\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\u001fH\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u0006H\u0016¢\u0006\u0004\b&\u0010'J\u0017\u0010*\u001a\u00020\u00062\u0006\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\u0006H\u0016¢\u0006\u0004\b,\u0010'J\u000f\u0010-\u001a\u00020\u0011H\u0016¢\u0006\u0004\b-\u0010.J\u0017\u00101\u001a\u00020\u00062\u0006\u00100\u001a\u00020/H\u0016¢\u0006\u0004\b1\u00102J\u000f\u00103\u001a\u00020\u0006H\u0016¢\u0006\u0004\b3\u0010'J\u0017\u00105\u001a\u00020\u00062\u0006\u00104\u001a\u00020\u0011H\u0016¢\u0006\u0004\b5\u0010\u0014J\u0019\u00108\u001a\u00020\u00062\b\u00107\u001a\u0004\u0018\u000106H\u0016¢\u0006\u0004\b8\u00109J\u000f\u0010:\u001a\u00020\u0006H\u0014¢\u0006\u0004\b:\u0010'J\u0018\u0010=\u001a\u00020\u00062\u0006\u0010<\u001a\u00020;H\u0001¢\u0006\u0004\b=\u0010>J\u0010\u0010?\u001a\u00020\u0006H\u0001¢\u0006\u0004\b?\u0010'J\u0010\u0010@\u001a\u00020\u0006H\u0001¢\u0006\u0004\b@\u0010'J\u0010\u0010A\u001a\u00020\u0006H\u0001¢\u0006\u0004\bA\u0010'J\u0010\u0010B\u001a\u00020\u0006H\u0001¢\u0006\u0004\bB\u0010'J\u0010\u0010C\u001a\u00020\u0006H\u0001¢\u0006\u0004\bC\u0010'J\u0010\u0010D\u001a\u00020\u0006H\u0001¢\u0006\u0004\bD\u0010'J\u0010\u0010E\u001a\u00020\u0006H\u0001¢\u0006\u0004\bE\u0010'J\u0010\u0010F\u001a\u00020\u0006H\u0001¢\u0006\u0004\bF\u0010'J\u0018\u0010I\u001a\u00020\u00062\u0006\u0010H\u001a\u00020GH\u0001¢\u0006\u0004\bI\u0010JJ\u0010\u0010K\u001a\u00020\u0006H\u0001¢\u0006\u0004\bK\u0010'J\u0010\u0010L\u001a\u00020\u0006H\u0001¢\u0006\u0004\bL\u0010'J\u0010\u0010M\u001a\u00020\u0006H\u0001¢\u0006\u0004\bM\u0010'J\u0010\u0010N\u001a\u00020\u0006H\u0001¢\u0006\u0004\bN\u0010'J\u0010\u0010O\u001a\u00020\u0006H\u0001¢\u0006\u0004\bO\u0010'J\u0010\u0010P\u001a\u00020\u0006H\u0001¢\u0006\u0004\bP\u0010'J\u0010\u0010Q\u001a\u00020\u0006H\u0001¢\u0006\u0004\bQ\u0010'J\u0010\u0010R\u001a\u00020\u0006H\u0001¢\u0006\u0004\bR\u0010'J\u0010\u0010S\u001a\u00020\u0006H\u0001¢\u0006\u0004\bS\u0010'J\u0010\u0010T\u001a\u00020\u0006H\u0001¢\u0006\u0004\bT\u0010'J\u0010\u0010U\u001a\u00020\u0006H\u0001¢\u0006\u0004\bU\u0010'J\u0010\u0010V\u001a\u00020\u0006H\u0001¢\u0006\u0004\bV\u0010'R\u0016\u0010Z\u001a\u00020W8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010^\u001a\u00020[8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010b\u001a\u00020_8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b`\u0010aR\u001e\u0010g\u001a\n\u0012\u0004\u0012\u00020d\u0018\u00010c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\be\u0010fR\u001e\u0010j\u001a\n\u0012\u0004\u0012\u00020h\u0018\u00010c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bi\u0010fR\u0016\u0010n\u001a\u00020k8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bl\u0010mR\u0018\u00100\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bo\u0010pR\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bq\u0010rR\"\u0010x\u001a\b\u0012\u0004\u0012\u00020t0s8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001b\u0010u\u001a\u0004\bv\u0010wR\u0016\u0010|\u001a\u00020y8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bz\u0010{R+\u0010\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020~0c0}8\u0016@\u0016X\u0004¢\u0006\u000e\n\u0004\b\u0016\u0010\u001a\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0019\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0013\u0010\u0001R\u0019\u0010\u0001\u001a\u00020\u00038\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R&\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010}8\u0016@\u0016X\u0004¢\u0006\u000e\n\u0004\b\u001d\u0010\u001a\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R \u0010\u0001\u001a\n\u0012\u0004\u0012\u00020d\u0018\u00010c8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0001\u0010fR\u0019\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u000b\u0010\u0001R&\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010}8\u0016@\u0016X\u0004¢\u0006\u000e\n\u0004\b\u0007\u0010\u001a\u0006\b\u0001\u0010\u0001R\u001a\u0010¡\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010 \u0001R\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b¢\u0001\u0010rR&\u0010¥\u0001\u001a\t\u0012\u0005\u0012\u00030£\u00010}8\u0016@\u0016X\u0004¢\u0006\u000e\n\u0004\b\u000f\u0010\u001a\u0006\b¤\u0001\u0010\u0001R\u001a\u0010©\u0001\u001a\u00030¦\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b§\u0001\u0010¨\u0001R\u001c\u0010­\u0001\u001a\u0005\u0018\u00010ª\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b«\u0001\u0010¬\u0001R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b®\u0001\u0010¯\u0001R\u001a\u0010³\u0001\u001a\u00030°\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b±\u0001\u0010²\u0001¨\u0006¶\u0001"}, d2 = {"Lcom/avito/android/extended_profile/ExtendedProfileViewModelImpl;", "Lcom/avito/android/extended_profile/ExtendedProfileViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/extended_profile/tracker/ExtendedProfileTracker;", "Lcom/avito/android/public_profile/remote/model/ExtendedPublicUserProfile;", "profile", "", "c", "(Lcom/avito/android/public_profile/remote/model/ExtendedPublicUserProfile;)V", "Lcom/avito/android/extended_profile/tracker/ExtendedProfileTracker$TrackFlow;", "trackFlow", "h", "(Lcom/avito/android/extended_profile/tracker/ExtendedProfileTracker$TrackFlow;)V", "Lcom/avito/android/extended_profile/data/CategoryData;", "category", "f", "(Lcom/avito/android/extended_profile/data/CategoryData;)V", "", "isVisible", "i", "(Z)V", "Lcom/avito/android/extended_profile/adapter/header/HeaderItem;", "e", "()Lcom/avito/android/extended_profile/adapter/header/HeaderItem;", "", "userKey", "contextId", a2.g.r.g.a, "(Ljava/lang/String;Ljava/lang/String;)V", "d", "()Ljava/lang/String;", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/extended_profile/adapter/action/ExtendedProfileItemAction;", "itemsClicks", "Lcom/avito/android/tns_gallery/TnsGalleryItemClickAction;", "galleryClicks", "observeClicks", "(Lio/reactivex/rxjava3/core/Observable;Lio/reactivex/rxjava3/core/Observable;)V", "refreshState", "()V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "handleDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "onBackClicked", "onShareMenuClick", "()Z", "Lcom/avito/android/deep_linking/links/PhoneLink$Call;", "phoneLink", "onPhoneCallConfirmed", "(Lcom/avito/android/deep_linking/links/PhoneLink$Call;)V", "onPhoneCallCanceled", "isRefreshing", "loadData", "Lcom/avito/android/public_profile/remote/model/SubscribeInfo;", "subscribeInfo", "onSubscribeInfoChanged", "(Lcom/avito/android/public_profile/remote/model/SubscribeInfo;)V", "onCleared", "Lcom/avito/android/analytics/screens/tracker/ScreenTransfer;", "transfer", "recover", "(Lcom/avito/android/analytics/screens/tracker/ScreenTransfer;)V", "startExtendedProfileDraw", "startExtendedProfileLoading", "startExtendedProfilePreparing", "startInit", "startProfileDraw", "startProfileLoading", "startProfilePreparing", "stopTracking", "", "durationMs", "trackDiInject", "(J)V", "trackExtendedProfileDraw", "trackExtendedProfileErrorDraw", "trackExtendedProfileErrorPreparing", "trackExtendedProfileLoadError", "trackExtendedProfileLoaded", "trackExtendedProfilePreparing", "trackInit", "trackProfileDraw", "trackProfileErrorDraw", "trackProfileLoadError", "trackProfileLoaded", "trackProfilePreparing", "Lcom/avito/android/util/SchedulersFactory3;", "y", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/extended_profile/ExtendedProfileContactsInteractor;", "s", "Lcom/avito/android/extended_profile/ExtendedProfileContactsInteractor;", "contactsInteractor", "Lcom/avito/android/error_helper/ErrorHelper;", "z", "Lcom/avito/android/error_helper/ErrorHelper;", "errorHelper", "", "Lcom/avito/android/extended_profile/adapter/ExtendedProfileListItem;", "k", "Ljava/util/List;", "hatItems", "Lcom/avito/android/extended_profile/data/ExtendedProfileDataItem;", "l", "extendedProfileData", "Lcom/avito/android/account/AccountStateProvider;", "w", "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "n", "Lcom/avito/android/deep_linking/links/PhoneLink$Call;", "o", "Ljava/lang/String;", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "Lcom/avito/android/extended_profile/ExtendedProfileViewSingleLiveEvent;", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "getSingleLiveEvents", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "singleLiveEvents", "Lcom/avito/android/extended_profile/ExtendedProfileInteractor;", "r", "Lcom/avito/android/extended_profile/ExtendedProfileInteractor;", "interactor", "Landroidx/lifecycle/MutableLiveData;", "Lcom/avito/android/component/contact_bar/ContactBar$Action;", "Landroidx/lifecycle/MutableLiveData;", "getContactActions", "()Landroidx/lifecycle/MutableLiveData;", "contactActions", "Lcom/avito/android/extended_profile/ExtendedProfileResourceProvider;", "x", "Lcom/avito/android/extended_profile/ExtendedProfileResourceProvider;", "resourceProvider", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "loadingSubscriptions", "B", "Lcom/avito/android/extended_profile/tracker/ExtendedProfileTracker;", "performanceTracker", "", "getChangedItemsIndexes", "changedItemsIndexes", "Lcom/avito/android/favorite/FavoriteAdvertsInteractor;", "t", "Lcom/avito/android/favorite/FavoriteAdvertsInteractor;", "favoritesInteractor", "Lcom/avito/android/analytics/Analytics;", "C", "Lcom/avito/android/analytics/Analytics;", "analytics", AuthSource.OPEN_CHANNEL_LIST, "dataSourceToDisplay", "viewModelSubscriptions", "Lcom/avito/android/extended_profile/DataChangeEvent;", "getDataToDisplayChanges", "dataToDisplayChanges", "Lcom/avito/android/advert_core/contactbar/AdvertActionIconFactory;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/avito/android/advert_core/contactbar/AdvertActionIconFactory;", "advertActionIconFactory", VKApiConst.Q, "Lcom/avito/android/extended_profile/ExtendedProfileViewEvent;", "getViewEvents", "viewEvents", "Lcom/avito/android/FavoriteSellersRepository;", "u", "Lcom/avito/android/FavoriteSellersRepository;", "favoriteSellersRepository", "Lio/reactivex/rxjava3/disposables/Disposable;", "j", "Lio/reactivex/rxjava3/disposables/Disposable;", "phoneLoadingDisposable", "p", "Lcom/avito/android/public_profile/remote/model/ExtendedPublicUserProfile;", "Lcom/avito/android/advert/viewed/ViewedAdvertsEventInteractor;", VKApiConst.VERSION, "Lcom/avito/android/advert/viewed/ViewedAdvertsEventInteractor;", "viewedAdvertsEventInteractor", "<init>", "(Ljava/lang/String;Lcom/avito/android/public_profile/remote/model/ExtendedPublicUserProfile;Ljava/lang/String;Lcom/avito/android/extended_profile/ExtendedProfileInteractor;Lcom/avito/android/extended_profile/ExtendedProfileContactsInteractor;Lcom/avito/android/favorite/FavoriteAdvertsInteractor;Lcom/avito/android/FavoriteSellersRepository;Lcom/avito/android/advert/viewed/ViewedAdvertsEventInteractor;Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/extended_profile/ExtendedProfileResourceProvider;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/error_helper/ErrorHelper;Lcom/avito/android/advert_core/contactbar/AdvertActionIconFactory;Lcom/avito/android/extended_profile/tracker/ExtendedProfileTracker;Lcom/avito/android/analytics/Analytics;)V", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
public final class ExtendedProfileViewModelImpl extends ViewModel implements ExtendedProfileViewModel, ExtendedProfileTracker {
    public final AdvertActionIconFactory A;
    public final ExtendedProfileTracker B;
    public final Analytics C;
    @NotNull
    public final MutableLiveData<DataChangeEvent> c = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<Integer> d = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<List<ContactBar.Action>> e = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<ExtendedProfileViewEvent> f = new MutableLiveData<>();
    @NotNull
    public final SingleLiveEvent<ExtendedProfileViewSingleLiveEvent> g = new SingleLiveEvent<>();
    public final CompositeDisposable h;
    public final CompositeDisposable i;
    public Disposable j;
    public List<? extends ExtendedProfileListItem> k;
    public List<? extends ExtendedProfileDataItem> l;
    public List<? extends ExtendedProfileListItem> m;
    public PhoneLink.Call n;
    public final String o;
    public ExtendedPublicUserProfile p;
    public final String q;
    public final ExtendedProfileInteractor r;
    public final ExtendedProfileContactsInteractor s;
    public final FavoriteAdvertsInteractor t;
    public final FavoriteSellersRepository u;
    public final ViewedAdvertsEventInteractor v;
    public final AccountStateProvider w;
    public final ExtendedProfileResourceProvider x;
    public final SchedulersFactory3 y;
    public final ErrorHelper z;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            ExtendedProfileTracker.TrackFlow.values();
            int[] iArr = new int[5];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[2] = 2;
            iArr[3] = 3;
        }
    }

    public static final class a<T> implements Supplier<CompletableSource> {
        public final /* synthetic */ ExtendedProfileViewModelImpl a;

        public a(ExtendedProfileViewModelImpl extendedProfileViewModelImpl) {
            this.a = extendedProfileViewModelImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // io.reactivex.rxjava3.functions.Supplier
        public CompletableSource get() {
            Completable access$getLocalExtendedProfile = ExtendedProfileViewModelImpl.access$getLocalExtendedProfile(this.a);
            return access$getLocalExtendedProfile != null ? access$getLocalExtendedProfile : ExtendedProfileViewModelImpl.access$loadExtendedProfileFromApi(this.a);
        }
    }

    public static final class b implements Action {
        public static final b a = new b();

        @Override // io.reactivex.rxjava3.functions.Action
        public final void run() {
        }
    }

    public static final class c<T> implements Consumer<Throwable> {
        public static final c a = new c();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("ExtendedProfileViewModel", th);
        }
    }

    public static final class d<T> implements Consumer<LoadingState<? super CategoryData>> {
        public final /* synthetic */ ExtendedProfileViewModelImpl a;
        public final /* synthetic */ CategoryData b;

        public d(ExtendedProfileViewModelImpl extendedProfileViewModelImpl, CategoryData categoryData) {
            this.a = extendedProfileViewModelImpl;
            this.b = categoryData;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(LoadingState<? super CategoryData> loadingState) {
            LoadingState<? super CategoryData> loadingState2 = loadingState;
            if (loadingState2 instanceof LoadingState.Loaded) {
                CategoryData categoryData = this.b;
                if (categoryData.getAdvertItems().isEmpty()) {
                    CategoryHeaderItem headerItem = categoryData.getHeaderItem();
                    categoryData.setHeaderItem(headerItem != null ? CategoryHeaderItem.copy$default(headerItem, null, null, null, false, false, false, null, false, 215, null) : null);
                }
                LoadingState.Loaded loaded = (LoadingState.Loaded) loadingState2;
                categoryData.setLoadMoreUri(((CategoryData) loaded.getData()).getLoadMoreUri());
                categoryData.getAdvertItems().addAll(((CategoryData) loaded.getData()).getAdvertItems());
                categoryData.setButtonItem(((CategoryData) loaded.getData()).getButtonItem());
                this.a.h(ExtendedProfileTracker.TrackFlow.SKIP_TRACKING);
            } else if (loadingState2 instanceof LoadingState.Loading) {
                ExtendedProfileViewModelImpl.access$showCategoryLoading(this.a, this.b, true);
            } else if (loadingState2 instanceof LoadingState.Error) {
                ExtendedProfileViewModelImpl.access$showCategoryLoading(this.a, this.b, false);
                ExtendedProfileViewModelImpl extendedProfileViewModelImpl = this.a;
                ExtendedProfileViewModelImpl.access$showSnackbar(extendedProfileViewModelImpl, extendedProfileViewModelImpl.z.recycle(((LoadingState.Error) loadingState2).getError()));
            }
        }
    }

    public static final class e<T> implements Consumer<Throwable> {
        public final /* synthetic */ ExtendedProfileViewModelImpl a;
        public final /* synthetic */ CategoryData b;

        public e(ExtendedProfileViewModelImpl extendedProfileViewModelImpl, CategoryData categoryData) {
            this.a = extendedProfileViewModelImpl;
            this.b = categoryData;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            ExtendedProfileViewModelImpl.access$showCategoryLoading(this.a, this.b, false);
            ExtendedProfileViewModelImpl extendedProfileViewModelImpl = this.a;
            ErrorHelper errorHelper = extendedProfileViewModelImpl.z;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            ExtendedProfileViewModelImpl.access$showSnackbar(extendedProfileViewModelImpl, errorHelper.recycle(th2));
        }
    }

    public static final class f<T> implements Consumer<ExtendedProfileItemAction> {
        public final /* synthetic */ ExtendedProfileViewModelImpl a;

        public f(ExtendedProfileViewModelImpl extendedProfileViewModelImpl) {
            this.a = extendedProfileViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(ExtendedProfileItemAction extendedProfileItemAction) {
            ExtendedProfileItemAction extendedProfileItemAction2 = extendedProfileItemAction;
            ExtendedProfileViewModelImpl extendedProfileViewModelImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(extendedProfileItemAction2, "action");
            ExtendedProfileViewModelImpl.access$handleItemAction(extendedProfileViewModelImpl, extendedProfileItemAction2);
        }
    }

    public static final class g<T> implements Consumer<TnsGalleryItemClickAction> {
        public final /* synthetic */ ExtendedProfileViewModelImpl a;

        public g(ExtendedProfileViewModelImpl extendedProfileViewModelImpl) {
            this.a = extendedProfileViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(TnsGalleryItemClickAction tnsGalleryItemClickAction) {
            TnsGalleryItemClickAction tnsGalleryItemClickAction2 = tnsGalleryItemClickAction;
            this.a.C.track(ExtendedProfilePictureViewEvent.INSTANCE);
            ExtendedProfileViewModelImpl.access$openGallery(this.a, tnsGalleryItemClickAction2.getImages(), tnsGalleryItemClickAction2.getIndex());
        }
    }

    public static final class h<T> implements Consumer<Unit> {
        public static final h a = new h();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Unit unit) {
        }
    }

    public static final class i<T> implements Consumer<Throwable> {
        public static final i a = new i();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("ExtendedProfileViewModel", th);
        }
    }

    public ExtendedProfileViewModelImpl(@NotNull String str, @Nullable ExtendedPublicUserProfile extendedPublicUserProfile, @Nullable String str2, @NotNull ExtendedProfileInteractor extendedProfileInteractor, @NotNull ExtendedProfileContactsInteractor extendedProfileContactsInteractor, @NotNull FavoriteAdvertsInteractor favoriteAdvertsInteractor, @NotNull FavoriteSellersRepository favoriteSellersRepository, @NotNull ViewedAdvertsEventInteractor viewedAdvertsEventInteractor, @NotNull AccountStateProvider accountStateProvider, @NotNull ExtendedProfileResourceProvider extendedProfileResourceProvider, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull ErrorHelper errorHelper, @NotNull AdvertActionIconFactory advertActionIconFactory, @NotNull ExtendedProfileTracker extendedProfileTracker, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(str, "userKey");
        Intrinsics.checkNotNullParameter(extendedProfileInteractor, "interactor");
        Intrinsics.checkNotNullParameter(extendedProfileContactsInteractor, "contactsInteractor");
        Intrinsics.checkNotNullParameter(favoriteAdvertsInteractor, "favoritesInteractor");
        Intrinsics.checkNotNullParameter(favoriteSellersRepository, "favoriteSellersRepository");
        Intrinsics.checkNotNullParameter(viewedAdvertsEventInteractor, "viewedAdvertsEventInteractor");
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        Intrinsics.checkNotNullParameter(extendedProfileResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(errorHelper, "errorHelper");
        Intrinsics.checkNotNullParameter(advertActionIconFactory, "advertActionIconFactory");
        Intrinsics.checkNotNullParameter(extendedProfileTracker, "performanceTracker");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.o = str;
        this.p = extendedPublicUserProfile;
        this.q = str2;
        this.r = extendedProfileInteractor;
        this.s = extendedProfileContactsInteractor;
        this.t = favoriteAdvertsInteractor;
        this.u = favoriteSellersRepository;
        this.v = viewedAdvertsEventInteractor;
        this.w = accountStateProvider;
        this.x = extendedProfileResourceProvider;
        this.y = schedulersFactory3;
        this.z = errorHelper;
        this.A = advertActionIconFactory;
        this.B = extendedProfileTracker;
        this.C = analytics;
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.h = compositeDisposable;
        this.i = new CompositeDisposable();
        Disposable subscribe = favoriteAdvertsInteractor.favoritesEvents().observeOn(schedulersFactory3.mainThread()).subscribe(new g0(this), h0.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "favoritesInteractor.favo…s.error(LOG_TAG, error) }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        Disposable subscribe2 = viewedAdvertsEventInteractor.getAdvertViewedEvents().observeOn(schedulersFactory3.mainThread()).subscribe(new e0(this), f0.a);
        Intrinsics.checkNotNullExpressionValue(subscribe2, "viewedAdvertsEventIntera…s.error(LOG_TAG, error) }");
        DisposableKt.plusAssign(compositeDisposable, subscribe2);
        ExtendedPublicUserProfile extendedPublicUserProfile2 = this.p;
        if (extendedPublicUserProfile2 != null) {
            c(extendedPublicUserProfile2);
        }
        ExtendedProfileViewModel.DefaultImpls.loadData$default(this, false, 1, null);
    }

    public static final Completable access$getLocalExtendedProfile(ExtendedProfileViewModelImpl extendedProfileViewModelImpl) {
        Objects.requireNonNull(extendedProfileViewModelImpl);
        Completable complete = Completable.complete();
        if (!(extendedProfileViewModelImpl.l != null)) {
            complete = null;
        }
        if (complete != null) {
            return complete.doOnComplete(new p(extendedProfileViewModelImpl));
        }
        return null;
    }

    public static final void access$handleItemAction(ExtendedProfileViewModelImpl extendedProfileViewModelImpl, ExtendedProfileItemAction extendedProfileItemAction) {
        Image avatar;
        if (extendedProfileViewModelImpl.l != null) {
            boolean z2 = false;
            if (extendedProfileItemAction instanceof HeaderItemAction.AvatarClickAction) {
                HeaderItem e2 = extendedProfileViewModelImpl.e();
                if (e2 != null && (avatar = e2.getAvatar()) != null) {
                    extendedProfileViewModelImpl.getSingleLiveEvents().postValue(new ExtendedProfileViewSingleLiveEvent.GalleryOpenEvent(t6.n.d.listOf(avatar), 0));
                    extendedProfileViewModelImpl.C.track(new AvatarPreviewEvent(extendedProfileViewModelImpl.o));
                }
            } else if (extendedProfileItemAction instanceof HeaderItemAction.RatingClickAction) {
                extendedProfileViewModelImpl.handleDeepLink(((HeaderItemAction.RatingClickAction) extendedProfileItemAction).getRatingAction().getDeepLink());
            } else if (extendedProfileItemAction instanceof CategoryButtonAction) {
                extendedProfileViewModelImpl.f(((CategoryButtonAction) extendedProfileItemAction).getCategory());
            } else {
                CategoryHeaderItem categoryHeaderItem = null;
                if (extendedProfileItemAction instanceof CategoryHeaderAction) {
                    CategoryData category = ((CategoryHeaderAction) extendedProfileItemAction).getCategory();
                    if (category.getLoadMoreUri() == null || !category.getAdvertItems().isEmpty()) {
                        CategoryHeaderItem headerItem = category.getHeaderItem();
                        if (headerItem != null) {
                            CategoryHeaderItem headerItem2 = category.getHeaderItem();
                            if (headerItem2 != null) {
                                z2 = headerItem2.isCollapsed();
                            }
                            categoryHeaderItem = CategoryHeaderItem.copy$default(headerItem, null, null, null, !z2, false, false, null, true, 119, null);
                        }
                        category.setHeaderItem(categoryHeaderItem);
                        extendedProfileViewModelImpl.h(ExtendedProfileTracker.TrackFlow.SKIP_TRACKING);
                        return;
                    }
                    extendedProfileViewModelImpl.f(category);
                } else if (extendedProfileItemAction instanceof CategoryAdvertItemAction.FavoriteClickAction) {
                    CategoryAdvertItem item = ((CategoryAdvertItemAction.FavoriteClickAction) extendedProfileItemAction).getItem();
                    CompositeDisposable compositeDisposable = extendedProfileViewModelImpl.h;
                    Disposable subscribe = extendedProfileViewModelImpl.t.toggleFavoriteStatus(item.getAdvert().getStringId(), new FavoriteActionSource.Snippet(item.getAdvert().getAnalyticsContext()), item.getAdvert().isFavorite()).subscribe(r.a, s.a);
                    Intrinsics.checkNotNullExpressionValue(subscribe, "favoritesInteractor.togg…s.error(LOG_TAG, error) }");
                    DisposableKt.plusAssign(compositeDisposable, subscribe);
                } else if (extendedProfileItemAction instanceof CategoryAdvertItemAction.AdvertItemClickAction) {
                    CategoryAdvertItemAction.AdvertItemClickAction advertItemClickAction = (CategoryAdvertItemAction.AdvertItemClickAction) extendedProfileItemAction;
                    DeepLink deepLink = advertItemClickAction.getAdvert().getDeepLink();
                    if (deepLink instanceof AdvertDetailsLink) {
                        AdvertDetailsLink advertDetailsLink = (AdvertDetailsLink) deepLink;
                        extendedProfileViewModelImpl.getSingleLiveEvents().postValue(new ExtendedProfileViewSingleLiveEvent.AdvertDetailsOpenEvent(advertDetailsLink.getItemId(), advertDetailsLink.getContext(), advertItemClickAction.getAdvert().getTitle(), advertItemClickAction.getAdvert().getPrice(), advertItemClickAction.getAdvert().getPreviousPrice(), advertItemClickAction.getImage(), advertItemClickAction.getGalleryPosition()));
                        return;
                    }
                    extendedProfileViewModelImpl.handleDeepLink(advertItemClickAction.getAdvert().getDeepLink());
                } else if (extendedProfileItemAction instanceof RetryAction) {
                    extendedProfileViewModelImpl.l = null;
                    ExtendedProfileViewModel.DefaultImpls.loadData$default(extendedProfileViewModelImpl, false, 1, null);
                } else if (extendedProfileItemAction instanceof ContactBarItemAction) {
                    ContactBarItemAction contactBarItemAction = (ContactBarItemAction) extendedProfileItemAction;
                    DeepLink deepLink2 = contactBarItemAction.getDeepLink();
                    if (deepLink2 instanceof ProfilePhoneRequestLink) {
                        ProfilePhoneRequestLink profilePhoneRequestLink = (ProfilePhoneRequestLink) deepLink2;
                        extendedProfileViewModelImpl.g(profilePhoneRequestLink.getUserKey(), profilePhoneRequestLink.getContext());
                    } else if (deepLink2 instanceof PhoneLink.Call) {
                        extendedProfileViewModelImpl.g(extendedProfileViewModelImpl.o, ((PhoneLink.Call) deepLink2).getContext());
                    }
                    extendedProfileViewModelImpl.handleDeepLink(contactBarItemAction.getDeepLink());
                }
            }
        }
    }

    public static final void access$handleLoadProfileError(ExtendedProfileViewModelImpl extendedProfileViewModelImpl, Throwable th) {
        extendedProfileViewModelImpl.B.trackProfileLoadError();
        extendedProfileViewModelImpl.h(ExtendedProfileTracker.TrackFlow.SKIP_TRACKING);
        extendedProfileViewModelImpl.i(false);
        extendedProfileViewModelImpl.B.startProfileDraw();
        boolean z2 = th instanceof TypedResultException;
        if (z2) {
            TypedResultException typedResultException = (TypedResultException) th;
            if (typedResultException.getErrorResult() instanceof ExtendedProfileInteractorImpl.UserBannedError) {
                extendedProfileViewModelImpl.getViewEvents().setValue(new ExtendedProfileViewEvent.ShowUserBannedEvent(extendedProfileViewModelImpl.z.recycle(typedResultException.getErrorResult())));
                extendedProfileViewModelImpl.B.trackProfileErrorDraw();
            }
        }
        if (z2) {
            TypedResultException typedResultException2 = (TypedResultException) th;
            if (typedResultException2.getErrorResult() instanceof ExtendedProfileInteractorImpl.UserRemovedError) {
                extendedProfileViewModelImpl.getViewEvents().setValue(new ExtendedProfileViewEvent.ShowUserRemovedEvent(extendedProfileViewModelImpl.z.recycle(typedResultException2.getErrorResult())));
                extendedProfileViewModelImpl.B.trackProfileErrorDraw();
            }
        }
        extendedProfileViewModelImpl.getViewEvents().setValue(new ExtendedProfileViewEvent.LoadingErrorEvent(extendedProfileViewModelImpl.z.recycle(th)));
        extendedProfileViewModelImpl.B.trackProfileErrorDraw();
    }

    public static final void access$hideProgressAsDialog(ExtendedProfileViewModelImpl extendedProfileViewModelImpl) {
        extendedProfileViewModelImpl.getViewEvents().setValue(ExtendedProfileViewEvent.HideProgressAsDialogEvent.INSTANCE);
    }

    public static final Completable access$loadExtendedProfileFromApi(ExtendedProfileViewModelImpl extendedProfileViewModelImpl) {
        Completable doOnError = extendedProfileViewModelImpl.r.loadExtendedProfile(extendedProfileViewModelImpl.o, extendedProfileViewModelImpl.d()).doOnSubscribe(new t(extendedProfileViewModelImpl)).observeOn(extendedProfileViewModelImpl.y.mainThread()).doOnNext(new u(extendedProfileViewModelImpl)).ignoreElements().doOnError(new v(extendedProfileViewModelImpl));
        Intrinsics.checkNotNullExpressionValue(doOnError, "interactor.loadExtendedP…LE_FAILURE)\n            }");
        return doOnError;
    }

    public static final void access$openGallery(ExtendedProfileViewModelImpl extendedProfileViewModelImpl, List list, int i2) {
        extendedProfileViewModelImpl.getSingleLiveEvents().postValue(new ExtendedProfileViewSingleLiveEvent.GalleryOpenEvent(list, i2));
    }

    public static final void access$showCategoryLoading(ExtendedProfileViewModelImpl extendedProfileViewModelImpl, CategoryData categoryData, boolean z2) {
        Objects.requireNonNull(extendedProfileViewModelImpl);
        if (categoryData.getAdvertItems().isEmpty()) {
            CategoryHeaderItem headerItem = categoryData.getHeaderItem();
            if (headerItem != null) {
                categoryData.setHeaderItem(CategoryHeaderItem.copy$default(headerItem, null, null, null, false, false, z2, null, false, 223, null));
            }
        } else {
            CategoryButtonItem buttonItem = categoryData.getButtonItem();
            if (buttonItem != null) {
                categoryData.setButtonItem(CategoryButtonItem.copy$default(buttonItem, null, null, null, z2, null, 23, null));
            }
        }
        extendedProfileViewModelImpl.h(ExtendedProfileTracker.TrackFlow.SKIP_TRACKING);
    }

    public static final void access$showProgress(ExtendedProfileViewModelImpl extendedProfileViewModelImpl) {
        extendedProfileViewModelImpl.getViewEvents().setValue(ExtendedProfileViewEvent.ShowProgressEvent.INSTANCE);
    }

    public static final void access$showProgressAsDialog(ExtendedProfileViewModelImpl extendedProfileViewModelImpl) {
        extendedProfileViewModelImpl.getViewEvents().setValue(ExtendedProfileViewEvent.ShowProgressAsDialogEvent.INSTANCE);
    }

    public static final void access$showSnackbar(ExtendedProfileViewModelImpl extendedProfileViewModelImpl, String str) {
        extendedProfileViewModelImpl.getSingleLiveEvents().postValue(new ExtendedProfileViewSingleLiveEvent.ShowSnackbarEvent(str));
    }

    public static final void access$trackProfileFlow(ExtendedProfileViewModelImpl extendedProfileViewModelImpl, LoadingState loadingState) {
        Objects.requireNonNull(extendedProfileViewModelImpl);
        if (loadingState instanceof LoadingState.Loaded) {
            extendedProfileViewModelImpl.B.trackProfileLoaded();
            extendedProfileViewModelImpl.B.startProfilePreparing();
        } else if (loadingState instanceof LoadingState.Loading) {
            extendedProfileViewModelImpl.B.startProfileLoading();
        }
    }

    public static final void access$updateFavoriteStatuses(ExtendedProfileViewModelImpl extendedProfileViewModelImpl, List list, boolean z2) {
        List<? extends ExtendedProfileListItem> list2 = extendedProfileViewModelImpl.m;
        if (list2 != null) {
            int i2 = 0;
            for (T t2 : list2) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                T t3 = t2;
                if (t3 instanceof CategoryAdvertItem) {
                    T t4 = t3;
                    if (list.contains(t4.getAdvert().getStringId())) {
                        t4.getAdvert().setFavorite(z2);
                        extendedProfileViewModelImpl.getChangedItemsIndexes().setValue(Integer.valueOf(i2));
                    }
                }
                i2 = i3;
            }
        }
    }

    public static final void access$updateShareMenuVisibility(ExtendedProfileViewModelImpl extendedProfileViewModelImpl, boolean z2) {
        extendedProfileViewModelImpl.getSingleLiveEvents().postValue(new ExtendedProfileViewSingleLiveEvent.ShareMenuVisibleEvent(z2));
    }

    public static final void access$updateViewedStatus(ExtendedProfileViewModelImpl extendedProfileViewModelImpl, String str) {
        List<? extends ExtendedProfileListItem> list = extendedProfileViewModelImpl.m;
        if (list != null) {
            int i2 = 0;
            for (T t2 : list) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                T t3 = t2;
                if (t3 instanceof CategoryAdvertItem) {
                    T t4 = t3;
                    if (Intrinsics.areEqual(t4.getAdvert().getStringId(), str)) {
                        t4.getAdvert().setViewed(true);
                        extendedProfileViewModelImpl.getChangedItemsIndexes().setValue(Integer.valueOf(i2));
                    }
                }
                i2 = i3;
            }
        }
    }

    public final void c(ExtendedPublicUserProfile extendedPublicUserProfile) {
        List<AdvertAction> actions;
        ArrayList arrayList = new ArrayList();
        arrayList.add(HeaderItemKt.toHeaderItem(extendedPublicUserProfile.getUser(), this.o, d()));
        AdvertActions contacts = extendedPublicUserProfile.getUser().getContacts();
        if (!(contacts == null || (actions = contacts.getActions()) == null || !(!actions.isEmpty()))) {
            ContactBarItem contactBarItem = ContactBarItemKt.toContactBarItem(extendedPublicUserProfile.getUser(), this.A);
            arrayList.add(contactBarItem);
            arrayList.add(new DividerItem(null, null, 3, null));
            getContactActions().setValue(contactBarItem.getContactActions());
        }
        this.k = arrayList;
    }

    public final String d() {
        Map<String, String> analytics;
        String str;
        ExtendedPublicUserProfile extendedPublicUserProfile = this.p;
        return (extendedPublicUserProfile == null || (analytics = extendedPublicUserProfile.getAnalytics()) == null || (str = analytics.get("context")) == null) ? "" : str;
    }

    public final HeaderItem e() {
        T t2;
        T t3;
        List<? extends ExtendedProfileListItem> list = this.k;
        T t4 = null;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    t3 = null;
                    break;
                }
                t3 = it.next();
                if (t3 instanceof HeaderItem) {
                    break;
                }
            }
            t2 = t3;
        } else {
            t2 = null;
        }
        if (t2 instanceof HeaderItem) {
            t4 = t2;
        }
        return t4;
    }

    public final void f(CategoryData categoryData) {
        String loadMoreUri = categoryData.getLoadMoreUri();
        if (loadMoreUri != null) {
            CompositeDisposable compositeDisposable = this.i;
            Disposable subscribe = this.r.loadNextPage(loadMoreUri, categoryData).observeOn(this.y.mainThread()).subscribe(new d(this, categoryData), new e(this, categoryData));
            Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.loadNextPage(…ecycle(it))\n            }");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
        }
    }

    public final void g(String str, String str2) {
        this.C.track(CallToSellerClickStreamEvent.Companion.createForExtendedProfile(str));
        CompositeDisposable compositeDisposable = this.h;
        Disposable subscribe = this.s.sendCallEvent(str, str2).subscribe(h.a, i.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "contactsInteractor.sendC…Logs.error(LOG_TAG, it) }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void h(ExtendedProfileTracker.TrackFlow trackFlow) {
        ArrayList arrayList = new ArrayList();
        List<? extends ExtendedProfileListItem> list = this.k;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
        }
        List<? extends ExtendedProfileDataItem> list2 = this.l;
        if (list2 != null) {
            for (T t2 : list2) {
                if (t2 instanceof CategoryDataContainer) {
                    for (T t3 : t2.getCategories()) {
                        CategoryHeaderItem headerItem = t3.getHeaderItem();
                        if (headerItem != null) {
                            arrayList.add(headerItem);
                        }
                        CategoryHeaderItem headerItem2 = t3.getHeaderItem();
                        if (headerItem2 == null || !headerItem2.isCollapsed()) {
                            arrayList.addAll(t3.getAdvertItems());
                            CategoryButtonItem buttonItem = t3.getButtonItem();
                            if (buttonItem != null) {
                                arrayList.add(buttonItem);
                            }
                        }
                    }
                } else if (t2 instanceof ExtendedProfileListItem) {
                    arrayList.add(t2);
                }
            }
        }
        getDataToDisplayChanges().setValue(new DataChangeEvent(arrayList, trackFlow));
        this.m = arrayList;
        int ordinal = trackFlow.ordinal();
        if (ordinal == 0) {
            this.B.trackProfilePreparing();
        } else if (ordinal == 2) {
            this.B.trackExtendedProfilePreparing();
        } else if (ordinal == 3) {
            this.B.trackExtendedProfileErrorPreparing();
        }
        getViewEvents().setValue(ExtendedProfileViewEvent.ShowDataEvent.INSTANCE);
    }

    @Override // com.avito.android.extended_profile.ExtendedProfileViewModel
    public void handleDeepLink(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        boolean z2 = deepLink instanceof ProfilePhoneRequestLink;
        if ((z2 && ((ProfilePhoneRequestLink) deepLink).getNeedAuth()) && !this.w.isAuthorized()) {
            getSingleLiveEvents().postValue(new ExtendedProfileViewSingleLiveEvent.AuthEvent(AuthSource.PHONE_REQUEST, deepLink));
        } else if (deepLink instanceof PhoneLink.Call) {
            PhoneLink.Call call = (PhoneLink.Call) deepLink;
            this.n = call;
            getViewEvents().setValue(new ExtendedProfileViewEvent.ConfirmCallEvent(call));
        } else if (z2) {
            ProfilePhoneRequestLink profilePhoneRequestLink = (ProfilePhoneRequestLink) deepLink;
            PhoneLink.Call call2 = this.n;
            if (call2 != null) {
                getViewEvents().setValue(new ExtendedProfileViewEvent.ConfirmCallEvent(call2));
                return;
            }
            Disposable disposable = this.j;
            if (disposable != null) {
                disposable.dispose();
            }
            this.j = this.s.getPhoneAction(profilePhoneRequestLink.getUserKey(), profilePhoneRequestLink.getContext()).observeOn(this.y.mainThread()).doOnSubscribe(new w(this)).doOnEach(x.a).subscribe(new y(this), new z(this));
        } else {
            getSingleLiveEvents().postValue(new ExtendedProfileViewSingleLiveEvent.DeepLinkEvent(deepLink));
        }
    }

    public final void i(boolean z2) {
        getSingleLiveEvents().postValue(new ExtendedProfileViewSingleLiveEvent.ShareMenuVisibleEvent(z2));
    }

    @Override // com.avito.android.extended_profile.ExtendedProfileViewModel
    public void loadData(boolean z2) {
        Completable completable = null;
        if (z2) {
            this.k = null;
            this.l = null;
        }
        this.i.clear();
        CompositeDisposable compositeDisposable = this.i;
        Completable complete = Completable.complete();
        if (!(this.k != null)) {
            complete = null;
        }
        if (complete != null) {
            completable = complete.doOnComplete(new q(this));
        }
        if (completable == null) {
            completable = this.r.loadPublicUserProfile(this.o, this.q).observeOn(this.y.mainThread()).doOnSubscribe(new a0(this)).doOnNext(new b0(this)).map(new c0(this, z2)).ignoreElements().doOnError(new d0(this));
            Intrinsics.checkNotNullExpressionValue(completable, "interactor.loadPublicUse…dleLoadProfileError(it) }");
        }
        Disposable subscribe = completable.andThen(Completable.defer(new a(this))).subscribe(b.a, c.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "(getLocalProfile() ?: lo…s.error(LOG_TAG, error) }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @Override // com.avito.android.extended_profile.ExtendedProfileViewModel
    public void observeClicks(@NotNull Observable<ExtendedProfileItemAction> observable, @NotNull Observable<TnsGalleryItemClickAction> observable2) {
        Intrinsics.checkNotNullParameter(observable, "itemsClicks");
        Intrinsics.checkNotNullParameter(observable2, "galleryClicks");
        CompositeDisposable compositeDisposable = this.h;
        Disposable subscribe = observable.subscribe(new f(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "itemsClicks.subscribe { …andleItemAction(action) }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.h;
        Disposable subscribe2 = observable2.subscribe(new g(this));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "galleryClicks.subscribe …, action.index)\n        }");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
    }

    @Override // com.avito.android.extended_profile.ExtendedProfileViewModel
    public void onBackClicked() {
        getSingleLiveEvents().postValue(ExtendedProfileViewSingleLiveEvent.BackClickedEvent.INSTANCE);
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.h.clear();
        this.i.clear();
        Disposable disposable = this.j;
        if (disposable != null) {
            disposable.dispose();
        }
        this.j = null;
    }

    @Override // com.avito.android.extended_profile.ExtendedProfileViewModel
    public void onPhoneCallCanceled() {
        Disposable disposable = this.j;
        if (disposable != null) {
            disposable.dispose();
        }
        this.j = null;
        getViewEvents().setValue(ExtendedProfileViewEvent.DoNothing.INSTANCE);
    }

    @Override // com.avito.android.extended_profile.ExtendedProfileViewModel
    public void onPhoneCallConfirmed(@NotNull PhoneLink.Call call) {
        Intrinsics.checkNotNullParameter(call, "phoneLink");
        getSingleLiveEvents().postValue(new ExtendedProfileViewSingleLiveEvent.CallEvent(call));
    }

    @Override // com.avito.android.extended_profile.ExtendedProfileViewModel
    public boolean onShareMenuClick() {
        Sharing sharing;
        Map<String, String> analytics;
        String str;
        ExtendedPublicUserProfile extendedPublicUserProfile = this.p;
        if (extendedPublicUserProfile == null || (sharing = extendedPublicUserProfile.getSharing()) == null) {
            return true;
        }
        getSingleLiveEvents().postValue(new ExtendedProfileViewSingleLiveEvent.ShareClickEvent(sharing.getTitle(), sharing.getText()));
        ExtendedPublicUserProfile extendedPublicUserProfile2 = this.p;
        if (extendedPublicUserProfile2 == null || (analytics = extendedPublicUserProfile2.getAnalytics()) == null || (str = analytics.get("sharing")) == null) {
            return true;
        }
        this.C.track(new ProfileShareEvent(str));
        return true;
    }

    @Override // com.avito.android.public_profile.ui.SubscriptionStateListener
    public void onSubscribeInfoChanged(@Nullable SubscribeInfo subscribeInfo) {
        HeaderItem e2 = e();
        if (e2 != null) {
            e2.setSubscribeInfo(subscribeInfo);
        }
    }

    @Override // com.avito.android.extended_profile.tracker.ExtendedProfileTracker
    public void recover(@NotNull ScreenTransfer screenTransfer) {
        Intrinsics.checkNotNullParameter(screenTransfer, "transfer");
        this.B.recover(screenTransfer);
    }

    @Override // com.avito.android.extended_profile.ExtendedProfileViewModel
    public void refreshState() {
        SubscribeInfo subscribeInfo;
        SubscribeInfo subscribeInfo2;
        FavoriteSeller favoriteSeller = this.u.getSellersAsMap().get(this.o);
        boolean z2 = false;
        Sharing sharing = null;
        if (favoriteSeller != null) {
            HeaderItem e2 = e();
            Boolean isSubscribed = (e2 == null || (subscribeInfo2 = e2.getSubscribeInfo()) == null) ? null : subscribeInfo2.isSubscribed();
            HeaderItem e3 = e();
            Boolean isNotificationsActivated = (e3 == null || (subscribeInfo = e3.getSubscribeInfo()) == null) ? null : subscribeInfo.isNotificationsActivated();
            if ((!Intrinsics.areEqual(Boolean.valueOf(favoriteSeller.isSubscribed()), isSubscribed)) || ((!Intrinsics.areEqual(favoriteSeller.isNotificationsActivated(), isNotificationsActivated)) && isSubscribed.booleanValue())) {
                this.k = null;
                ExtendedProfileViewModel.DefaultImpls.loadData$default(this, false, 1, null);
            }
        }
        ExtendedPublicUserProfile extendedPublicUserProfile = this.p;
        if (extendedPublicUserProfile != null) {
            sharing = extendedPublicUserProfile.getSharing();
        }
        if (sharing != null) {
            z2 = true;
        }
        i(z2);
    }

    @Override // com.avito.android.extended_profile.tracker.ExtendedProfileTracker
    public void startExtendedProfileDraw() {
        this.B.startExtendedProfileDraw();
    }

    @Override // com.avito.android.extended_profile.tracker.ExtendedProfileTracker
    public void startExtendedProfileLoading() {
        this.B.startExtendedProfileLoading();
    }

    @Override // com.avito.android.extended_profile.tracker.ExtendedProfileTracker
    public void startExtendedProfilePreparing() {
        this.B.startExtendedProfilePreparing();
    }

    @Override // com.avito.android.extended_profile.tracker.ExtendedProfileTracker
    public void startInit() {
        this.B.startInit();
    }

    @Override // com.avito.android.extended_profile.tracker.ExtendedProfileTracker
    public void startProfileDraw() {
        this.B.startProfileDraw();
    }

    @Override // com.avito.android.extended_profile.tracker.ExtendedProfileTracker
    public void startProfileLoading() {
        this.B.startProfileLoading();
    }

    @Override // com.avito.android.extended_profile.tracker.ExtendedProfileTracker
    public void startProfilePreparing() {
        this.B.startProfilePreparing();
    }

    @Override // com.avito.android.extended_profile.tracker.ExtendedProfileTracker
    public void stopTracking() {
        this.B.stopTracking();
    }

    @Override // com.avito.android.extended_profile.tracker.ExtendedProfileTracker
    public void trackDiInject(long j2) {
        this.B.trackDiInject(j2);
    }

    @Override // com.avito.android.extended_profile.tracker.ExtendedProfileTracker
    public void trackExtendedProfileDraw() {
        this.B.trackExtendedProfileDraw();
    }

    @Override // com.avito.android.extended_profile.tracker.ExtendedProfileTracker
    public void trackExtendedProfileErrorDraw() {
        this.B.trackExtendedProfileErrorDraw();
    }

    @Override // com.avito.android.extended_profile.tracker.ExtendedProfileTracker
    public void trackExtendedProfileErrorPreparing() {
        this.B.trackExtendedProfileErrorPreparing();
    }

    @Override // com.avito.android.extended_profile.tracker.ExtendedProfileTracker
    public void trackExtendedProfileLoadError() {
        this.B.trackExtendedProfileLoadError();
    }

    @Override // com.avito.android.extended_profile.tracker.ExtendedProfileTracker
    public void trackExtendedProfileLoaded() {
        this.B.trackExtendedProfileLoaded();
    }

    @Override // com.avito.android.extended_profile.tracker.ExtendedProfileTracker
    public void trackExtendedProfilePreparing() {
        this.B.trackExtendedProfilePreparing();
    }

    @Override // com.avito.android.extended_profile.tracker.ExtendedProfileTracker
    public void trackInit() {
        this.B.trackInit();
    }

    @Override // com.avito.android.extended_profile.tracker.ExtendedProfileTracker
    public void trackProfileDraw() {
        this.B.trackProfileDraw();
    }

    @Override // com.avito.android.extended_profile.tracker.ExtendedProfileTracker
    public void trackProfileErrorDraw() {
        this.B.trackProfileErrorDraw();
    }

    @Override // com.avito.android.extended_profile.tracker.ExtendedProfileTracker
    public void trackProfileLoadError() {
        this.B.trackProfileLoadError();
    }

    @Override // com.avito.android.extended_profile.tracker.ExtendedProfileTracker
    public void trackProfileLoaded() {
        this.B.trackProfileLoaded();
    }

    @Override // com.avito.android.extended_profile.tracker.ExtendedProfileTracker
    public void trackProfilePreparing() {
        this.B.trackProfilePreparing();
    }

    @Override // com.avito.android.extended_profile.ExtendedProfileViewModel
    @NotNull
    public MutableLiveData<Integer> getChangedItemsIndexes() {
        return this.d;
    }

    @Override // com.avito.android.extended_profile.ExtendedProfileViewModel
    @NotNull
    public MutableLiveData<List<ContactBar.Action>> getContactActions() {
        return this.e;
    }

    @Override // com.avito.android.extended_profile.ExtendedProfileViewModel
    @NotNull
    public MutableLiveData<DataChangeEvent> getDataToDisplayChanges() {
        return this.c;
    }

    @Override // com.avito.android.extended_profile.ExtendedProfileViewModel
    @NotNull
    public SingleLiveEvent<ExtendedProfileViewSingleLiveEvent> getSingleLiveEvents() {
        return this.g;
    }

    @Override // com.avito.android.extended_profile.ExtendedProfileViewModel
    @NotNull
    public MutableLiveData<ExtendedProfileViewEvent> getViewEvents() {
        return this.f;
    }
}
