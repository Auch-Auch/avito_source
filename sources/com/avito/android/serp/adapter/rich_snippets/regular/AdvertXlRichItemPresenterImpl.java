package com.avito.android.serp.adapter.rich_snippets.regular;

import com.avito.android.Features;
import com.avito.android.ab_tests.SellerInfoInRichSnippet;
import com.avito.android.ab_tests.configs.SellerInfoInRichSnippetTestGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.ContactSource;
import com.avito.android.analytics.event.GalleryClickEvent;
import com.avito.android.async_phone.AsyncPhonePresenter;
import com.avito.android.date_time_formatter.DateTimeFormatter;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.di.module.DateTimeFormatterModule;
import com.avito.android.di.module.RichGalleryState;
import com.avito.android.image_loader.AvitoPictureKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AdvertAction;
import com.avito.android.remote.model.AdvertActions;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.ImageKt;
import com.avito.android.serp.adapter.advert_xl.AdvertXlItem;
import com.avito.android.serp.adapter.onboarding.SerpOnboardingHandler;
import com.avito.android.serp.adapter.rich_snippets.AdvertGalleryState;
import com.avito.android.serp.adapter.rich_snippets.AdvertRichItemListener;
import com.avito.android.serp.adapter.rich_snippets.AdvertSellerConverter;
import com.avito.android.serp.adapter.rich_snippets.RichSnippetsResourceProvider;
import com.avito.android.util.Kundle;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import dagger.Lazy;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.serp.PhoneLoadingState;
import t6.n.y;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001Bt\b\u0007\u0012\u0011\u0010\u001d\u001a\r\u0012\t\u0012\u00070\u0019¢\u0006\u0002\b\u001a0\u0018\u0012\b\b\u0001\u0010%\u001a\u00020\"\u0012\u0006\u0010)\u001a\u00020&\u0012\u0006\u0010-\u001a\u00020*\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010<\u001a\u000209\u0012\b\u00101\u001a\u0004\u0018\u00010.\u0012\u000e\b\u0001\u00108\u001a\b\u0012\u0004\u0012\u00020302\u0012\n\b\u0001\u0010=\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b>\u0010?J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R!\u0010\u001d\u001a\r\u0012\t\u0012\u00070\u0019¢\u0006\u0002\b\u001a0\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u001f\u00108\u001a\b\u0012\u0004\u0012\u000203028\u0006@\u0006¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010;¨\u0006@"}, d2 = {"Lcom/avito/android/serp/adapter/rich_snippets/regular/AdvertXlRichItemPresenterImpl;", "Lcom/avito/android/serp/adapter/rich_snippets/regular/AdvertXlRichItemPresenter;", "Lcom/avito/android/serp/adapter/rich_snippets/regular/AdvertRichItemView;", "view", "Lcom/avito/android/serp/adapter/advert_xl/AdvertXlItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/serp/adapter/rich_snippets/regular/AdvertRichItemView;Lcom/avito/android/serp/adapter/advert_xl/AdvertXlItem;I)V", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "invalidate", "()V", "Lcom/avito/android/async_phone/AsyncPhonePresenter;", a2.g.r.g.a, "Lcom/avito/android/async_phone/AsyncPhonePresenter;", "asyncPhonePresenter", "Lcom/avito/android/serp/adapter/rich_snippets/AdvertGalleryState;", AuthSource.SEND_ABUSE, "Lcom/avito/android/serp/adapter/rich_snippets/AdvertGalleryState;", "advertGalleryState", "Ldagger/Lazy;", "Lcom/avito/android/serp/adapter/rich_snippets/AdvertRichItemListener;", "Lkotlin/jvm/JvmSuppressWildcards;", AuthSource.BOOKING_ORDER, "Ldagger/Lazy;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/avito/android/serp/adapter/rich_snippets/AdvertSellerConverter;", "f", "Lcom/avito/android/serp/adapter/rich_snippets/AdvertSellerConverter;", "sellerConverter", "Lcom/avito/android/date_time_formatter/DateTimeFormatter;", "c", "Lcom/avito/android/date_time_formatter/DateTimeFormatter;", "formatter", "Lcom/avito/android/serp/adapter/rich_snippets/RichSnippetsResourceProvider;", "d", "Lcom/avito/android/serp/adapter/rich_snippets/RichSnippetsResourceProvider;", "resourceProvider", "Lcom/avito/android/analytics/Analytics;", "e", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/serp/adapter/onboarding/SerpOnboardingHandler;", "i", "Lcom/avito/android/serp/adapter/onboarding/SerpOnboardingHandler;", "onboardingHandler", "Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "Lcom/avito/android/ab_tests/configs/SellerInfoInRichSnippetTestGroup;", "j", "Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "getSellerInfoTestGroup", "()Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "sellerInfoTestGroup", "Lcom/avito/android/Features;", "h", "Lcom/avito/android/Features;", "features", "galleryPresenterState", "<init>", "(Ldagger/Lazy;Lcom/avito/android/date_time_formatter/DateTimeFormatter;Lcom/avito/android/serp/adapter/rich_snippets/RichSnippetsResourceProvider;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/serp/adapter/rich_snippets/AdvertSellerConverter;Lcom/avito/android/async_phone/AsyncPhonePresenter;Lcom/avito/android/Features;Lcom/avito/android/serp/adapter/onboarding/SerpOnboardingHandler;Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;Lcom/avito/android/util/Kundle;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertXlRichItemPresenterImpl implements AdvertXlRichItemPresenter {
    public final AdvertGalleryState a;
    public final Lazy<AdvertRichItemListener> b;
    public final DateTimeFormatter c;
    public final RichSnippetsResourceProvider d;
    public final Analytics e;
    public final AdvertSellerConverter f;
    public final AsyncPhonePresenter g;
    public final Features h;
    public final SerpOnboardingHandler i;
    @NotNull
    public final SingleManuallyExposedAbTestGroup<SellerInfoInRichSnippetTestGroup> j;

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Object c;
        public final /* synthetic */ Object d;
        public final /* synthetic */ Object e;
        public final /* synthetic */ Object f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, int i2, Object obj, Object obj2, Object obj3, Object obj4) {
            super(0);
            this.a = i;
            this.b = i2;
            this.c = obj;
            this.d = obj2;
            this.e = obj3;
            this.f = obj4;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            int i = this.a;
            if (i == 0) {
                ((AdvertRichItemListener) ((AdvertXlRichItemPresenterImpl) this.d).b.get()).onFavoriteButtonClicked((AdvertXlItem) this.e);
                return Unit.INSTANCE;
            } else if (i == 1) {
                AdvertRichItemPresenterKt.clearCallbacks((AdvertRichItemView) this.c);
                ((AdvertRichItemView) this.c).clearPictures();
                ((AdvertRichItemView) this.c).setActions(y.emptySet());
                ((AdvertXlRichItemPresenterImpl) this.d).g.unbindItem((AdvertXlItem) this.e);
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    public static final class b extends Lambda implements Function1<Integer, Unit> {
        public final /* synthetic */ AdvertXlItem a;
        public final /* synthetic */ AdvertRichItemView b;
        public final /* synthetic */ AdvertXlRichItemPresenterImpl c;
        public final /* synthetic */ AdvertXlItem d;
        public final /* synthetic */ AdvertRichItemView e;
        public final /* synthetic */ int f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(AdvertXlItem advertXlItem, AdvertRichItemView advertRichItemView, AdvertXlRichItemPresenterImpl advertXlRichItemPresenterImpl, AdvertXlItem advertXlItem2, AdvertRichItemView advertRichItemView2, int i) {
            super(1);
            this.a = advertXlItem;
            this.b = advertRichItemView;
            this.c = advertXlRichItemPresenterImpl;
            this.d = advertXlItem2;
            this.e = advertRichItemView2;
            this.f = i;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Integer num) {
            Integer num2 = num;
            ((AdvertRichItemListener) this.c.b.get()).onRichAdvertXlClicked(this.a, this.f, AdvertXlRichItemPresenterImpl.access$createImage(this.c, this.e, this.d, num2), num2);
            if (num2 != null) {
                int intValue = num2.intValue();
                Analytics analytics = this.c.e;
                String stringId = this.d.getStringId();
                int i = 1;
                int i2 = intValue + 1;
                List<Image> imageList = this.a.getImageList();
                if (imageList != null) {
                    i = imageList.size();
                }
                analytics.track(new GalleryClickEvent(stringId, i2, i));
            }
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function1<Boolean, Unit> {
        public final /* synthetic */ AdvertXlItem a;
        public final /* synthetic */ AdvertRichItemView b;
        public final /* synthetic */ AdvertXlRichItemPresenterImpl c;
        public final /* synthetic */ AdvertRichItemView d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(AdvertXlItem advertXlItem, AdvertRichItemView advertRichItemView, AdvertXlRichItemPresenterImpl advertXlRichItemPresenterImpl, AdvertXlItem advertXlItem2, AdvertRichItemView advertRichItemView2, int i) {
            super(1);
            this.a = advertXlItem;
            this.b = advertRichItemView;
            this.c = advertXlRichItemPresenterImpl;
            this.d = advertRichItemView2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Boolean bool) {
            List<AdvertAction> actions;
            T t;
            boolean booleanValue = bool.booleanValue();
            AdvertActions contacts = this.a.getContacts();
            DeepLink deepLink = null;
            if (!(contacts == null || (actions = contacts.getActions()) == null)) {
                Iterator<T> it = actions.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        t = null;
                        break;
                    }
                    t = it.next();
                    if (t instanceof AdvertAction.Messenger) {
                        break;
                    }
                }
                T t2 = t;
                if (t2 != null) {
                    deepLink = t2.getDeepLink();
                }
            }
            if (deepLink != null) {
                ((AdvertRichItemListener) this.c.b.get()).onWriteActionClicked(this.a.getStringId(), deepLink, AdvertXlRichItemPresenterImpl.access$contactSource(this.c, booleanValue));
            }
            return Unit.INSTANCE;
        }
    }

    public static final class d extends Lambda implements Function1<Boolean, Unit> {
        public final /* synthetic */ AdvertXlItem a;
        public final /* synthetic */ AdvertRichItemView b;
        public final /* synthetic */ AdvertXlRichItemPresenterImpl c;
        public final /* synthetic */ AdvertXlItem d;
        public final /* synthetic */ AdvertRichItemView e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(AdvertXlItem advertXlItem, AdvertRichItemView advertRichItemView, AdvertXlRichItemPresenterImpl advertXlRichItemPresenterImpl, AdvertXlItem advertXlItem2, AdvertRichItemView advertRichItemView2, int i) {
            super(1);
            this.a = advertXlItem;
            this.b = advertRichItemView;
            this.c = advertXlRichItemPresenterImpl;
            this.d = advertXlItem2;
            this.e = advertRichItemView2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Boolean bool) {
            DeepLink trackSnippetCallEvent;
            boolean booleanValue = bool.booleanValue();
            if (this.d.getPhoneLoadingState() == PhoneLoadingState.IDLE && (trackSnippetCallEvent = AdvertRichItemPresenterKt.trackSnippetCallEvent(this.a, booleanValue, this.c.e)) != null) {
                this.c.g.loadPhoneLink(this.d, this.e, trackSnippetCallEvent, AdvertXlRichItemPresenterImpl.access$contactSource(this.c, booleanValue), new a2.a.a.n2.w.c.b.b(this, booleanValue));
            }
            return Unit.INSTANCE;
        }
    }

    public static final class e extends Lambda implements Function1<DeepLink, Unit> {
        public final /* synthetic */ AdvertRichItemView a;
        public final /* synthetic */ AdvertXlRichItemPresenterImpl b;
        public final /* synthetic */ AdvertRichItemView c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(AdvertRichItemView advertRichItemView, AdvertXlRichItemPresenterImpl advertXlRichItemPresenterImpl, AdvertXlItem advertXlItem, AdvertRichItemView advertRichItemView2, int i) {
            super(1);
            this.a = advertRichItemView;
            this.b = advertXlRichItemPresenterImpl;
            this.c = advertRichItemView2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(DeepLink deepLink) {
            DeepLink deepLink2 = deepLink;
            Intrinsics.checkNotNullParameter(deepLink2, "deepLink");
            ((AdvertRichItemListener) this.b.b.get()).onDeepLinkActionClicked(deepLink2);
            return Unit.INSTANCE;
        }
    }

    public static final class f extends Lambda implements Function1<Integer, Unit> {
        public final /* synthetic */ AdvertRichItemView a;
        public final /* synthetic */ AdvertXlRichItemPresenterImpl b;
        public final /* synthetic */ AdvertXlItem c;
        public final /* synthetic */ AdvertRichItemView d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(AdvertRichItemView advertRichItemView, AdvertXlRichItemPresenterImpl advertXlRichItemPresenterImpl, AdvertXlItem advertXlItem, AdvertRichItemView advertRichItemView2, int i) {
            super(1);
            this.a = advertRichItemView;
            this.b = advertXlRichItemPresenterImpl;
            this.c = advertXlItem;
            this.d = advertRichItemView2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Integer num) {
            num.intValue();
            AdvertRichItemPresenterKt.putAdvertState(this.b.a, this.c.getStringId(), this.a.getGalleryState());
            return Unit.INSTANCE;
        }
    }

    public static final class g extends Lambda implements Function1<Boolean, Unit> {
        public final /* synthetic */ AdvertRichItemView a;
        public final /* synthetic */ AdvertXlRichItemPresenterImpl b;
        public final /* synthetic */ AdvertXlItem c;
        public final /* synthetic */ AdvertRichItemView d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(AdvertRichItemView advertRichItemView, AdvertXlRichItemPresenterImpl advertXlRichItemPresenterImpl, AdvertXlItem advertXlItem, AdvertRichItemView advertRichItemView2, int i) {
            super(1);
            this.a = advertRichItemView;
            this.b = advertXlRichItemPresenterImpl;
            this.c = advertXlItem;
            this.d = advertRichItemView2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Boolean bool) {
            boolean booleanValue = bool.booleanValue();
            if (this.c.getSellerInfo() != null && booleanValue) {
                this.b.getSellerInfoTestGroup().exposeIfNeeded();
            }
            return Unit.INSTANCE;
        }
    }

    @Inject
    public AdvertXlRichItemPresenterImpl(@NotNull Lazy<AdvertRichItemListener> lazy, @DateTimeFormatterModule.UpperCase @NotNull DateTimeFormatter dateTimeFormatter, @NotNull RichSnippetsResourceProvider richSnippetsResourceProvider, @NotNull Analytics analytics, @NotNull AdvertSellerConverter advertSellerConverter, @NotNull AsyncPhonePresenter asyncPhonePresenter, @NotNull Features features, @Nullable SerpOnboardingHandler serpOnboardingHandler, @SellerInfoInRichSnippet @NotNull SingleManuallyExposedAbTestGroup<SellerInfoInRichSnippetTestGroup> singleManuallyExposedAbTestGroup, @RichGalleryState @Nullable Kundle kundle) {
        AdvertGalleryState advertGalleryState;
        Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.checkNotNullParameter(dateTimeFormatter, "formatter");
        Intrinsics.checkNotNullParameter(richSnippetsResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(advertSellerConverter, "sellerConverter");
        Intrinsics.checkNotNullParameter(asyncPhonePresenter, "asyncPhonePresenter");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(singleManuallyExposedAbTestGroup, "sellerInfoTestGroup");
        this.b = lazy;
        this.c = dateTimeFormatter;
        this.d = richSnippetsResourceProvider;
        this.e = analytics;
        this.f = advertSellerConverter;
        this.g = asyncPhonePresenter;
        this.h = features;
        this.i = serpOnboardingHandler;
        this.j = singleManuallyExposedAbTestGroup;
        this.a = (kundle == null || (advertGalleryState = (AdvertGalleryState) kundle.getParcelable("advert_xl_gallery_state")) == null) ? new AdvertGalleryState(null, 1, null) : advertGalleryState;
    }

    public static final ContactSource access$contactSource(AdvertXlRichItemPresenterImpl advertXlRichItemPresenterImpl, boolean z) {
        Objects.requireNonNull(advertXlRichItemPresenterImpl);
        return z ? ContactSource.CONTACT_XL_GALLERY : ContactSource.CONTACT_XL;
    }

    public static final Image access$createImage(AdvertXlRichItemPresenterImpl advertXlRichItemPresenterImpl, AdvertRichItemView advertRichItemView, AdvertXlItem advertXlItem, Integer num) {
        Objects.requireNonNull(advertXlRichItemPresenterImpl);
        boolean z = false;
        int intValue = num != null ? num.intValue() : 0;
        List<Image> imageList = advertXlItem.getImageList();
        if (imageList == null || imageList.isEmpty()) {
            z = true;
        }
        if (z) {
            return null;
        }
        return ImageKt.toSingleImage(advertRichItemView.getPictureUri(AvitoPictureKt.pictureOf$default(advertXlItem.getImageList().get(intValue), true, 0.0f, 0.0f, null, 28, null)));
    }

    @NotNull
    public final SingleManuallyExposedAbTestGroup<SellerInfoInRichSnippetTestGroup> getSellerInfoTestGroup() {
        return this.j;
    }

    @Override // com.avito.android.serp.adapter.rich_snippets.RichSnippetStateProvider
    public void invalidate() {
        this.a.clear();
    }

    @Override // com.avito.android.serp.adapter.rich_snippets.RichSnippetStateProvider
    @NotNull
    public Kundle onSaveState() {
        return new Kundle().putParcelable("advert_xl_gallery_state", this.a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:64:0x01be  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x01c2  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x01f3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void bindView(@org.jetbrains.annotations.NotNull com.avito.android.serp.adapter.rich_snippets.regular.AdvertRichItemView r12, @org.jetbrains.annotations.NotNull com.avito.android.serp.adapter.advert_xl.AdvertXlItem r13, int r14) {
        /*
        // Method dump skipped, instructions count: 617
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.serp.adapter.rich_snippets.regular.AdvertXlRichItemPresenterImpl.bindView(com.avito.android.serp.adapter.rich_snippets.regular.AdvertRichItemView, com.avito.android.serp.adapter.advert_xl.AdvertXlItem, int):void");
    }
}
