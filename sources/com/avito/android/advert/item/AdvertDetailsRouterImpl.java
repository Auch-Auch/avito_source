package com.avito.android.advert.item;

import a2.g.r.g;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.os.SystemClock;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.AdvertDetailsIntentFactory;
import com.avito.android.AuthIntentFactory;
import com.avito.android.ItemMapIntentFactory;
import com.avito.android.MessengerIntentFactory;
import com.avito.android.NotificationCenterIntentFactory;
import com.avito.android.SerpIntentFactory;
import com.avito.android.SuggestLocationsIntentFactory;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.advert.AdvertDetailsActivity;
import com.avito.android.advert.item.dfpcreditinfo.credit_partner_screen.CreditPartner;
import com.avito.android.advert_core.analytics.contactbar.ShowPhoneDialerEvent;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.provider.clickstream.ParametrizedClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.authorization.AuthParamsKt;
import com.avito.android.autoteka_details.core.analytics.event.FromBlock;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.contact_access.ContactAccessPackageFragment;
import com.avito.android.contact_access.ContactAccessPackageFragmentKt;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.BadgeBarShowLink;
import com.avito.android.deep_linking.links.ChannelDetailsLink;
import com.avito.android.deep_linking.links.CreateChannelLink;
import com.avito.android.deep_linking.links.CvPackagesLink;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.DetailsSheetLinkBody;
import com.avito.android.deep_linking.links.ExpressCvLink;
import com.avito.android.deep_linking.links.ItemsSearchLink;
import com.avito.android.deep_linking.links.NoMatchLink;
import com.avito.android.deep_linking.links.PhoneLink;
import com.avito.android.deep_linking.links.RatingPublishLink;
import com.avito.android.in_app_calls.data.CallActivityRequest;
import com.avito.android.lib.design.snackbar.SnackbarExtensionsKt;
import com.avito.android.lib.design.snackbar.SnackbarPosition;
import com.avito.android.lib.design.snackbar.SnackbarType;
import com.avito.android.rec.ScreenSource;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AdvertActions;
import com.avito.android.remote.model.AdvertDetails;
import com.avito.android.remote.model.AutotekaDetailsResponse;
import com.avito.android.remote.model.Coordinates;
import com.avito.android.remote.model.CpoDescription;
import com.avito.android.remote.model.ForegroundImage;
import com.avito.android.remote.model.GeoReference;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.Navigation;
import com.avito.android.remote.model.Video;
import com.avito.android.remote.model.advert_details.ContactBarData;
import com.avito.android.remote.model.autoteka.AutotekaTeaserGalleryModel;
import com.avito.android.remote.models.SparePartsResponse;
import com.avito.android.serp.adapter.promo_card.PromoCardItem;
import com.avito.android.suggest_locations.OpenEventFromBlock;
import com.avito.android.ui.fragments.TabBaseFragment;
import com.avito.android.ui_components.R;
import com.avito.android.util.Constants;
import com.avito.android.util.FragmentsKt;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.Intents;
import com.avito.android.util.IntentsKt;
import com.avito.android.util.ToastsKt;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.share.internal.ShareConstants;
import com.vk.sdk.api.model.VKApiUserFull;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongycastle.i18n.ErrorBundle;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Â\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\b\u0010¡\u0001\u001a\u00030\u0001\u0012\b\u0010º\u0001\u001a\u00030·\u0001\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\b\u0010¶\u0001\u001a\u00030³\u0001\u0012\b\u0010­\u0001\u001a\u00030ª\u0001\u0012\b\u0010©\u0001\u001a\u00030¦\u0001\u0012\u000e\u0010¥\u0001\u001a\t\u0012\u0004\u0012\u00020\u00050¢\u0001¢\u0006\u0006\b»\u0001\u0010¼\u0001J#\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0010J/\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00132\u0016\u0010\u0018\u001a\u0012\u0012\b\u0012\u00060\u0016j\u0002`\u0017\u0012\u0004\u0012\u00020\u00050\u0015H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J\u0019\u0010#\u001a\u00020\u00052\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0004\b#\u0010$J\u0017\u0010'\u001a\u00020\u00052\u0006\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b'\u0010(J\u001f\u0010'\u001a\u00020\u00052\u0006\u0010&\u001a\u00020%2\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b'\u0010+J\u0017\u0010.\u001a\u00020\u00052\u0006\u0010-\u001a\u00020,H\u0016¢\u0006\u0004\b.\u0010/J\u0017\u00101\u001a\u0002002\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b1\u00102J\u0017\u00104\u001a\u00020\u00052\u0006\u00103\u001a\u00020%H\u0016¢\u0006\u0004\b4\u0010(J\u0017\u00105\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b5\u0010 J\u0017\u00106\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b6\u0010 J\u001f\u00109\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u00108\u001a\u000207H\u0016¢\u0006\u0004\b9\u0010:J\u0017\u00109\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b9\u0010 J!\u0010=\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010<\u001a\u0004\u0018\u00010;H\u0016¢\u0006\u0004\b=\u0010>J\u0017\u0010?\u001a\u00020\u00052\u0006\u00103\u001a\u00020%H\u0016¢\u0006\u0004\b?\u0010(J\u000f\u0010@\u001a\u00020\u0005H\u0016¢\u0006\u0004\b@\u0010\u001cJ\u0017\u0010B\u001a\u00020\u00052\u0006\u0010A\u001a\u00020\u001dH\u0016¢\u0006\u0004\bB\u0010 J\u001f\u0010D\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00022\u0006\u0010C\u001a\u00020\u0002H\u0016¢\u0006\u0004\bD\u0010\u0007J\u0017\u0010G\u001a\u00020\u00052\u0006\u0010F\u001a\u00020EH\u0016¢\u0006\u0004\bG\u0010HJ\u0017\u0010I\u001a\u00020\u00052\u0006\u0010F\u001a\u00020EH\u0016¢\u0006\u0004\bI\u0010HJ#\u0010M\u001a\u00020\u00052\b\u0010J\u001a\u0004\u0018\u00010\u00022\b\u0010L\u001a\u0004\u0018\u00010KH\u0016¢\u0006\u0004\bM\u0010NJ\u0019\u0010M\u001a\u00020\u00052\b\u0010J\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\bM\u0010\u0010J\u0017\u0010P\u001a\u00020\u00052\u0006\u0010A\u001a\u00020OH\u0016¢\u0006\u0004\bP\u0010QJ!\u0010S\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00022\b\u0010R\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\bS\u0010\u0007J\u0017\u0010V\u001a\u00020\u00052\u0006\u0010U\u001a\u00020TH\u0016¢\u0006\u0004\bV\u0010WJ'\u0010[\u001a\u0002002\u0006\u0010Y\u001a\u00020X2\u0006\u0010J\u001a\u00020\u00022\u0006\u0010Z\u001a\u000200H\u0016¢\u0006\u0004\b[\u0010\\J\u0017\u0010]\u001a\u00020\u00052\u0006\u00103\u001a\u00020%H\u0016¢\u0006\u0004\b]\u0010(J\u0017\u0010_\u001a\u00020\u00052\u0006\u0010^\u001a\u00020\u0002H\u0016¢\u0006\u0004\b_\u0010\u0010JA\u0010f\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010`\u001a\u00020\u00022\u0006\u0010b\u001a\u00020a2\u0006\u0010C\u001a\u00020\u00022\u000e\u0010e\u001a\n\u0012\u0004\u0012\u00020d\u0018\u00010cH\u0016¢\u0006\u0004\bf\u0010gJ\u0017\u0010h\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\bh\u0010\u0010J\u0017\u0010i\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\bi\u0010\u0010J\u0010y\u001a\u00020\u00052\u0006\u0010j\u001a\u0002072\b\u0010l\u001a\u0004\u0018\u00010k2\u000e\u0010n\u001a\n\u0012\u0004\u0012\u00020m\u0018\u00010c2\u0006\u0010<\u001a\u00020;2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010p\u001a\u0004\u0018\u00010o2\b\u0010-\u001a\u0004\u0018\u00010q2\b\u0010s\u001a\u0004\u0018\u00010r2\b\u0010t\u001a\u0004\u0018\u00010\u00022\b\u0010v\u001a\u0004\u0018\u00010u2\b\u0010x\u001a\u0004\u0018\u00010wH\u0016¢\u0006\u0004\by\u0010zJZ\u0010\u0001\u001a\u00020\u00052\u0006\u0010^\u001a\u00020\u00022\b\u0010{\u001a\u0004\u0018\u00010\u00022\u0006\u0010C\u001a\u00020\u00022\b\u0010|\u001a\u0004\u0018\u00010\u00022\b\u0010}\u001a\u0004\u0018\u00010\u00022\b\u0010~\u001a\u0004\u0018\u00010m2\u0006\u0010\u001a\u0002002\u0006\u0010<\u001a\u00020;H\u0016¢\u0006\u0006\b\u0001\u0010\u0001J\u0011\u0010\u0001\u001a\u00020\u0005H\u0016¢\u0006\u0005\b\u0001\u0010\u001cJ\u001b\u0010\u0001\u001a\u00020\u00052\u0007\u0010A\u001a\u00030\u0001H\u0016¢\u0006\u0006\b\u0001\u0010\u0001J\u0019\u0010\u0001\u001a\u00020\u00052\u0006\u0010&\u001a\u00020%H\u0016¢\u0006\u0005\b\u0001\u0010(J\u001c\u0010\u0001\u001a\u00020\u00052\b\u0010\u0001\u001a\u00030\u0001H\u0016¢\u0006\u0006\b\u0001\u0010\u0001J\u001c\u0010\u0001\u001a\u00020\u00052\b\u0010\u0001\u001a\u00030\u0001H\u0016¢\u0006\u0006\b\u0001\u0010\u0001J&\u0010\u0001\u001a\u00020\u00052\t\u0010\u0001\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0005\b\u0001\u0010\u0007J\u0019\u0010\u0001\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u0002H\u0016¢\u0006\u0005\b\u0001\u0010\u0010J-\u0010\u0001\u001a\u00020\u00052\b\u0010\u0001\u001a\u00030\u00012\u0006\u00103\u001a\u00020%2\u0007\u0010\u0001\u001a\u00020\u0002H\u0016¢\u0006\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010¡\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010 \u0001R \u0010¥\u0001\u001a\t\u0012\u0004\u0012\u00020\u00050¢\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b£\u0001\u0010¤\u0001R\u001a\u0010©\u0001\u001a\u00030¦\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b§\u0001\u0010¨\u0001R\u001a\u0010­\u0001\u001a\u00030ª\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b«\u0001\u0010¬\u0001R\u0018\u0010\u000e\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b®\u0001\u0010\u0001R\u001c\u0010²\u0001\u001a\u0005\u0018\u00010¯\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b°\u0001\u0010±\u0001R\u001a\u0010¶\u0001\u001a\u00030³\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b´\u0001\u0010µ\u0001R\u001a\u0010º\u0001\u001a\u00030·\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¸\u0001\u0010¹\u0001¨\u0006½\u0001"}, d2 = {"Lcom/avito/android/advert/item/AdvertDetailsRouterImpl;", "Lcom/avito/android/advert/item/AdvertDetailsRouter;", "", "categoryId", "microCategoryId", "", "setAnalyticsParams", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/avito/android/deep_linking/links/DetailsSheetLinkBody;", ErrorBundle.DETAIL_ENTRY, "Lcom/avito/android/analytics/provider/clickstream/ParametrizedClickStreamEvent;", "clickEvent", "openBottomSheet", "(Lcom/avito/android/deep_linking/links/DetailsSheetLinkBody;Lcom/avito/android/analytics/provider/clickstream/ParametrizedClickStreamEvent;)V", BookingInfoActivity.EXTRA_ITEM_ID, "showContactAccessPackage", "(Ljava/lang/String;)V", "actionUri", "openAutoDeal", "Landroid/content/Intent;", "intent", "Lkotlin/Function1;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "errorHandler", "openActivitySafely", "(Landroid/content/Intent;Lkotlin/jvm/functions/Function1;)V", "closeScreen", "()V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "followShortTermRentLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "Lcom/avito/android/remote/model/AutotekaDetailsResponse;", "autotekaDetails", "showAutoteka", "(Lcom/avito/android/remote/model/AutotekaDetailsResponse;)V", "Landroid/net/Uri;", "url", "openAutotekaTeaser", "(Landroid/net/Uri;)V", "Lcom/avito/android/autoteka_details/core/analytics/event/FromBlock;", BookingInfoActivity.EXTRA_FROM_BLOCK, "(Landroid/net/Uri;Lcom/avito/android/autoteka_details/core/analytics/event/FromBlock;)V", "Lcom/avito/android/remote/model/CpoDescription;", "data", "openAutotekaCpoProgramScreen", "(Lcom/avito/android/remote/model/CpoDescription;)V", "", "followDeliveryDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)Z", ShareConstants.MEDIA_URI, "followDeliveryExternalLink", "followSafeDealDeepLink", "followDeepLinkFromRecommendations", "", "req", "followDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;I)V", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "treeParent", "followDeeplinkWithTreeParent", "(Lcom/avito/android/deep_linking/links/DeepLink;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;)V", "openDomotekaReport", "loginForDomotekaFlatNumberRequest", "link", "followDomotekaOpenChatDeeplink", "title", "openShareDialog", "Lcom/avito/android/remote/model/AdvertDetails;", "advert", "editNoteClick", "(Lcom/avito/android/remote/model/AdvertDetails;)V", "openEditNote", "source", "Landroid/os/Parcelable;", AuthParamsKt.KEY_SUCCESS_AUTH_RESULT_DATA, "onAuthRequired", "(Ljava/lang/String;Landroid/os/Parcelable;)V", "Lcom/avito/android/deep_linking/links/CvPackagesLink;", "buyAdvertContacts", "(Lcom/avito/android/deep_linking/links/CvPackagesLink;)V", "message", "openMessengerWithMessage", "Lcom/avito/android/in_app_calls/data/CallActivityRequest$Dial;", "dialRequest", "makeInAppCall", "(Lcom/avito/android/in_app_calls/data/CallActivityRequest$Dial;)V", "Lcom/avito/android/deep_linking/links/PhoneLink;", "phoneLink", "showError", "dialPhone", "(Lcom/avito/android/deep_linking/links/PhoneLink;Ljava/lang/String;Z)Z", "followUri", "itemId", "showInactiveItem", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "Lcom/avito/android/remote/model/Coordinates;", "coordinates", "", "Lcom/avito/android/remote/model/GeoReference;", "geoReferences", "showAddressOnMap", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Coordinates;Ljava/lang/String;Ljava/util/List;)V", "showConsultationForm", "showAbuseCategoryScreen", "currentPosition", "Lcom/avito/android/remote/model/Video;", "advertVideo", "Lcom/avito/android/remote/model/Image;", "advertImages", "Lcom/avito/android/remote/model/AdvertActions;", "actions", "Lcom/avito/android/remote/model/advert_details/ContactBarData;", "", "stateId", "searchContext", "Lcom/avito/android/remote/model/ForegroundImage;", "foregroundImage", "Lcom/avito/android/remote/model/autoteka/AutotekaTeaserGalleryModel;", "autotekaTeaser", "showGalleryFullscreen", "(ILcom/avito/android/remote/model/Video;Ljava/util/List;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;Ljava/lang/String;Lcom/avito/android/remote/model/AdvertActions;Lcom/avito/android/remote/model/advert_details/ContactBarData;Ljava/lang/Long;Ljava/lang/String;Lcom/avito/android/remote/model/ForegroundImage;Lcom/avito/android/remote/model/autoteka/AutotekaTeaserGalleryModel;)V", "context", "price", "oldPrice", "image", "isMarketplace", "openAdvertDetails", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;ZLcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;)V", "openNotificationsSettings", "Lcom/avito/android/deep_linking/links/RatingPublishLink;", "openRatingPublishScreen", "(Lcom/avito/android/deep_linking/links/RatingPublishLink;)V", "openGuideLink", "Lcom/avito/android/serp/adapter/promo_card/PromoCardItem;", "item", "onBannerClicked", "(Lcom/avito/android/serp/adapter/promo_card/PromoCardItem;)V", "Lcom/avito/android/remote/models/SparePartsResponse$SparePartsGroup;", Navigation.GROUP, "openSparePartsBottomSheet", "(Lcom/avito/android/remote/models/SparePartsResponse$SparePartsGroup;)V", "selectedLocationId", "openSuggestLocation", "openHelpCenterScreen", "Lcom/avito/android/advert/item/dfpcreditinfo/credit_partner_screen/CreditPartner;", VKApiUserFull.RelativeType.PARTNER, "brokerSession", "showCreditPartnerScreen", "(Lcom/avito/android/advert/item/dfpcreditinfo/credit_partner_screen/CreditPartner;Landroid/net/Uri;Ljava/lang/String;)V", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", g.a, "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "c", "Lcom/avito/android/ui/fragments/TabBaseFragment;", "e", "Lcom/avito/android/ui/fragments/TabBaseFragment;", "fragment", "Lkotlin/Function0;", "k", "Lkotlin/jvm/functions/Function0;", "refreshPresenter", "Lcom/avito/android/analytics/Analytics;", "j", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/account/AccountStateProvider;", "i", "Lcom/avito/android/account/AccountStateProvider;", "accountStatus", "d", "Landroidx/fragment/app/FragmentActivity;", AuthSource.SEND_ABUSE, "Landroidx/fragment/app/FragmentActivity;", "activity", "Lcom/avito/android/util/ImplicitIntentFactory;", "h", "Lcom/avito/android/util/ImplicitIntentFactory;", "implicitIntentFactory", "Lcom/avito/android/ActivityIntentFactory;", "f", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "<init>", "(Ljava/lang/String;Lcom/avito/android/ui/fragments/TabBaseFragment;Lcom/avito/android/ActivityIntentFactory;Lcom/avito/android/deep_linking/DeepLinkIntentFactory;Lcom/avito/android/util/ImplicitIntentFactory;Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/analytics/Analytics;Lkotlin/jvm/functions/Function0;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsRouterImpl implements AdvertDetailsRouter {
    public final FragmentActivity a;
    public String b;
    public String c;
    public final String d;
    public final TabBaseFragment e;
    public final ActivityIntentFactory f;
    public final DeepLinkIntentFactory g;
    public final ImplicitIntentFactory h;
    public final AccountStateProvider i;
    public final Analytics j;
    public final Function0<Unit> k;

    public static final class a extends Lambda implements Function1<Exception, Unit> {
        public final /* synthetic */ AdvertDetailsRouterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(AdvertDetailsRouterImpl advertDetailsRouterImpl) {
            super(1);
            this.a = advertDetailsRouterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Exception exc) {
            Intrinsics.checkNotNullParameter(exc, "it");
            Context context = this.a.e.getContext();
            if (context != null) {
                ToastsKt.showToast$default(context, R.string.no_application_installed_to_perform_this_action, 0, 2, (Object) null);
            }
            return Unit.INSTANCE;
        }
    }

    public AdvertDetailsRouterImpl(@NotNull String str, @NotNull TabBaseFragment tabBaseFragment, @NotNull ActivityIntentFactory activityIntentFactory, @NotNull DeepLinkIntentFactory deepLinkIntentFactory, @NotNull ImplicitIntentFactory implicitIntentFactory, @NotNull AccountStateProvider accountStateProvider, @NotNull Analytics analytics, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(tabBaseFragment, "fragment");
        Intrinsics.checkNotNullParameter(activityIntentFactory, "activityIntentFactory");
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory, "deepLinkIntentFactory");
        Intrinsics.checkNotNullParameter(implicitIntentFactory, "implicitIntentFactory");
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStatus");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(function0, "refreshPresenter");
        this.d = str;
        this.e = tabBaseFragment;
        this.f = activityIntentFactory;
        this.g = deepLinkIntentFactory;
        this.h = implicitIntentFactory;
        this.i = accountStateProvider;
        this.j = analytics;
        this.k = function0;
        this.a = tabBaseFragment.getActivity();
        Fragment findFragmentByTag = tabBaseFragment.getChildFragmentManager().findFragmentByTag("tag_choose_package_fragment");
        ContactAccessPackageFragment contactAccessPackageFragment = (ContactAccessPackageFragment) (!(findFragmentByTag instanceof ContactAccessPackageFragment) ? null : findFragmentByTag);
        if (contactAccessPackageFragment != null) {
            contactAccessPackageFragment.setRouter(new AdvertDetailsRouterImpl$setRouter$contactAccessPackageRouter$1(this, contactAccessPackageFragment));
        }
    }

    @Override // com.avito.android.advert_core.advert.AdvertCoreRouter
    public void buyAdvertContacts(@NotNull CvPackagesLink cvPackagesLink) {
        Intrinsics.checkNotNullParameter(cvPackagesLink, "link");
        Intent intent = this.g.getIntent(cvPackagesLink);
        if (intent != null) {
            this.e.startActivityForResult(intent, 2);
        }
    }

    @Override // com.avito.android.advert.AdvertDetailsToolbarRouter
    public void closeScreen() {
        FragmentActivity fragmentActivity = this.a;
        if (fragmentActivity == null) {
            return;
        }
        if (!(fragmentActivity instanceof AdvertDetailsActivity)) {
            this.e.finish();
        } else if (!((AdvertDetailsActivity) fragmentActivity).handleUp()) {
            fragmentActivity.finish();
        }
    }

    @Override // com.avito.android.advert_core.advert.AdvertCoreRouter
    public boolean dialPhone(@NotNull PhoneLink phoneLink, @NotNull String str, boolean z) {
        Context context;
        Intrinsics.checkNotNullParameter(phoneLink, "phoneLink");
        Intrinsics.checkNotNullParameter(str, "source");
        Intent intent = this.g.getIntent(phoneLink);
        boolean z2 = false;
        if (intent != null) {
            try {
                this.e.startActivity(intent);
                z2 = true;
            } catch (ActivityNotFoundException unused) {
                if (z && (context = this.e.getContext()) != null) {
                    ToastsKt.showToast$default(context, R.string.cant_do_call, 0, 2, (Object) null);
                }
            }
            this.j.track(new ShowPhoneDialerEvent(this.d, str, z2, this.b, this.c));
        }
        return z2;
    }

    @Override // com.avito.android.advert.item.note.AdvertDetailsNotePresenter.Router, com.avito.android.advert.AdvertDetailsToolbarRouter
    public void editNoteClick(@NotNull AdvertDetails advertDetails) {
        Intrinsics.checkNotNullParameter(advertDetails, "advert");
        if (this.i.isAuthorized()) {
            openEditNote(advertDetails);
        } else {
            this.e.startActivityForResult(AuthIntentFactory.DefaultImpls.authIntent$default(this.f, null, "n", null, 4, null), 7);
        }
    }

    @Override // com.avito.android.advert.item.sellersubscription.SellerSubscriptionPresenter.Router
    public void followDeepLink(@NotNull DeepLink deepLink, int i2) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        Intent intent = this.g.getIntent(deepLink);
        if (intent != null) {
            this.e.startActivityForResult(intent, i2);
        }
    }

    @Override // com.avito.android.favorite_sellers.adapter.recommendation.RecommendationItemPresenter.Router
    public void followDeepLinkFromRecommendations(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        Intent intent = this.g.getIntent(deepLink);
        if (intent != null) {
            this.e.startActivityForResult(intent, 16);
        }
    }

    @Override // com.avito.android.advert.item.AdvertDeeplinkRouter
    public void followDeeplinkWithTreeParent(@NotNull DeepLink deepLink, @Nullable TreeClickStreamParent treeClickStreamParent) {
        Intent intent;
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        if (deepLink instanceof ItemsSearchLink) {
            ItemsSearchLink itemsSearchLink = (ItemsSearchLink) deepLink;
            intent = SerpIntentFactory.DefaultImpls.itemsListIntent$default(this.f, itemsSearchLink.getSearchParams(), itemsSearchLink.getContext(), null, itemsSearchLink.getFromPage(), true, false, 36, null);
        } else {
            intent = this.g.getIntent(deepLink);
        }
        if (intent != null) {
            if (treeClickStreamParent != null) {
                Intents.putTreeAnalyticsParent(intent, treeClickStreamParent);
            }
            this.e.startActivity(intent);
        }
    }

    @Override // com.avito.android.advert.item.delivery.AdvertDeliveryPresenter.Router
    public boolean followDeliveryDeepLink(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        Intent intent = this.g.getIntent(deepLink);
        if (intent == null) {
            return false;
        }
        this.e.startActivityForResult(intent, 5);
        return true;
    }

    @Override // com.avito.android.advert.item.delivery.AdvertDeliveryPresenter.Router
    public void followDeliveryExternalLink(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        FragmentsKt.startActivitySafely(this.e, this.h.uriIntent(uri), new a(this));
    }

    @Override // com.avito.android.advert.item.domoteka.conveyor.AdvertDetailsDomotekaTeaserPresenter.Router
    public void followDomotekaOpenChatDeeplink(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "link");
        Intent intent = this.g.getIntent(deepLink);
        if (intent != null) {
            if (deepLink instanceof ChannelDetailsLink) {
                intent.removeExtra(Constants.UP_INTENT);
            }
            this.e.startActivity(intent);
        }
    }

    @Override // com.avito.android.advert.item.safedeal.AdvertSafeDealPresenter.Router
    public void followSafeDealDeepLink(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        if (deepLink instanceof NoMatchLink) {
            SnackbarExtensionsKt.showSnackbar$default(this.e, (String) null, R.string.no_match_deep_link_try_to_update_the_app, (String) null, 0, (Function0) null, 0, (SnackbarPosition) null, (SnackbarType) null, 253, (Object) null);
            return;
        }
        Intent intent = this.g.getIntent(deepLink);
        if (intent != null) {
            this.e.startActivityForResult(intent, 5);
        }
    }

    @Override // com.avito.android.advert.item.shorttermrent.AdvertDetailsShortTermRentPresenter.Router
    public void followShortTermRentLink(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        Intent intent = this.g.getIntent(deepLink);
        if (intent != null) {
            this.e.startActivity(intent);
        }
    }

    @Override // com.avito.android.advert_core.advert.AdvertCoreRouter
    public void followUri(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        this.e.startActivity(this.h.uriIntent(uri));
    }

    @Override // com.avito.android.advert.item.domoteka.conveyor.AdvertDetailsDomotekaTeaserPresenter.Router
    public void loginForDomotekaFlatNumberRequest() {
        this.e.startActivityForResult(AuthIntentFactory.DefaultImpls.authIntent$default(this.f, null, AuthSource.DOMOTEKA_TEASER_VIEW, null, 5, null), 13);
    }

    @Override // com.avito.android.advert_core.advert.AdvertCoreRouter
    public void makeInAppCall(@NotNull CallActivityRequest.Dial dial) {
        Intrinsics.checkNotNullParameter(dial, "dialRequest");
        this.e.startActivity(this.f.inAppCallIntent(dial));
    }

    @Override // com.avito.android.advert_core.advert.AdvertCoreRouter
    public void onAuthRequired(@Nullable String str, @Nullable Parcelable parcelable) {
        this.e.startActivityForResult(IntentsKt.withClearTopFlags(this.f.authIntent(null, str, parcelable)), 1);
    }

    @Override // com.avito.android.serp.adapter.promo_card.PromoCardItemPresenter.Router
    public void onBannerClicked(@NotNull PromoCardItem promoCardItem) {
        Intrinsics.checkNotNullParameter(promoCardItem, "item");
        followDeepLink(promoCardItem.getAction());
    }

    @Override // com.avito.android.advert.item.AdvertDetailsRouter
    public void openActivitySafely(@NotNull Intent intent, @NotNull Function1<? super Exception, Unit> function1) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(function1, "errorHandler");
        FragmentsKt.startActivitySafely(this.e, intent, function1);
    }

    @Override // com.avito.android.advert.item.AdvertDetailsRouter
    public void openAdvertDetails(@NotNull String str, @Nullable String str2, @NotNull String str3, @Nullable String str4, @Nullable String str5, @Nullable Image image, boolean z, @NotNull TreeClickStreamParent treeClickStreamParent) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        Intrinsics.checkNotNullParameter(str3, "title");
        Intrinsics.checkNotNullParameter(treeClickStreamParent, "treeParent");
        this.e.startActivity(AdvertDetailsIntentFactory.DefaultImpls.advertDetailsIntent$default(this.f, str, str2, str3, str4, str5, image, z, treeClickStreamParent, SystemClock.elapsedRealtime(), null, this.e.currentTab(), ScreenSource.ADVERT.INSTANCE, 512, null));
    }

    @Override // com.avito.android.advert.item.AdvertDetailsRouter
    public void openAutoDeal(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "actionUri");
        this.e.startActivity(this.f.autoDealDetails(str));
    }

    @Override // com.avito.android.advert.item.autoteka.teaser.AdvertDetailsAutotekaTeaserPresenter.Router
    public void openAutotekaCpoProgramScreen(@NotNull CpoDescription cpoDescription) {
        Intrinsics.checkNotNullParameter(cpoDescription, "data");
        this.e.startActivity(this.f.cpoProgram(cpoDescription));
    }

    @Override // com.avito.android.advert.item.autoteka.teaser.AdvertDetailsAutotekaTeaserPresenter.Router
    public void openAutotekaTeaser(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "url");
        FragmentsKt.startActivitySafely(this.e, ImplicitIntentFactory.DefaultImpls.uriIntentCustomChromeTabs$default(this.h, uri, false, 2, null));
    }

    @Override // com.avito.android.advert.item.AdvertDetailsRouter
    public void openBottomSheet(@NotNull DetailsSheetLinkBody detailsSheetLinkBody, @NotNull ParametrizedClickStreamEvent parametrizedClickStreamEvent) {
        Intrinsics.checkNotNullParameter(detailsSheetLinkBody, ErrorBundle.DETAIL_ENTRY);
        Intrinsics.checkNotNullParameter(parametrizedClickStreamEvent, "clickEvent");
        this.e.startActivity(this.f.detailsSheetIntent(detailsSheetLinkBody, parametrizedClickStreamEvent));
    }

    @Override // com.avito.android.advert.item.domoteka.conveyor.AdvertDetailsDomotekaTeaserPresenter.Router
    public void openDomotekaReport(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        Intent promoIntent$default = NotificationCenterIntentFactory.DefaultImpls.promoIntent$default(this.f, uri, false, true, 2, null);
        if (this.i.isAuthorized()) {
            this.e.startActivity(promoIntent$default);
        } else {
            this.e.startActivity(AuthIntentFactory.DefaultImpls.authIntent$default(this.f, promoIntent$default, AuthSource.DOMOTEKA_TEASER_VIEW, null, 4, null));
        }
    }

    @Override // com.avito.android.advert.item.AdvertDetailsRouter
    public void openEditNote(@NotNull AdvertDetails advertDetails) {
        Intrinsics.checkNotNullParameter(advertDetails, "advert");
        this.e.startActivityForResult(this.f.advertDetailsNoteIntent(advertDetails.getId(), advertDetails.getTitle(), advertDetails.getNote(), advertDetails.isFavorite()), 8);
    }

    @Override // com.avito.android.advert.item.guide.AdvertDetailsGuidePresenter.Router
    public void openGuideLink(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "url");
        FragmentsKt.startActivitySafely(this.e, ImplicitIntentFactory.DefaultImpls.uriIntentCustomChromeTabs$default(this.h, uri, false, 2, null));
    }

    @Override // com.avito.android.advert.item.AdvertDetailsRouter
    public void openHelpCenterScreen(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        String path = new URL(str).getPath();
        Intrinsics.checkNotNullExpressionValue(path, "URL(url).path");
        Objects.requireNonNull(path, "null cannot be cast to non-null type java.lang.String");
        String substring = path.substring(1);
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
        this.e.startActivity(this.f.helpCenterIntent(substring));
    }

    @Override // com.avito.android.advert.item.AdvertDetailsRouter
    public void openMessengerWithMessage(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        this.e.startActivity(MessengerIntentFactory.DefaultImpls.createChannelByItemIdIntent$default(this.f, str, str2, null, 4, null));
    }

    @Override // com.avito.android.advert.item.sellersubscription.SellerSubscriptionPresenter.Router, com.avito.android.favorite_sellers.adapter.recommendation.RecommendationItemPresenter.Router
    public void openNotificationsSettings() {
        this.e.startActivity(this.h.notificationsSettingsIntent());
    }

    @Override // com.avito.android.advert.item.rating_publish.AdvertDetailsRatingPublishPresenter.Router
    public void openRatingPublishScreen(@NotNull RatingPublishLink ratingPublishLink) {
        Intrinsics.checkNotNullParameter(ratingPublishLink, "link");
        Intent intent = this.g.getIntent(ratingPublishLink);
        if (intent != null) {
            this.e.startActivityForResult(intent, 12);
        }
    }

    @Override // com.avito.android.advert.AdvertDetailsToolbarRouter
    public void openShareDialog(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(str2, "title");
        this.e.startActivityForResult(Intent.createChooser(this.h.shareItemIntent(str, str2), this.e.getResources().getString(com.avito.android.advert_details.R.string.menu_share)), 10);
    }

    @Override // com.avito.android.advert.item.spare_parts.SparePartsPresenter.Router
    public void openSparePartsBottomSheet(@NotNull SparePartsResponse.SparePartsGroup sparePartsGroup) {
        Intrinsics.checkNotNullParameter(sparePartsGroup, Navigation.GROUP);
        this.e.startActivity(this.f.openSparePartsBottomSheet(sparePartsGroup));
    }

    @Override // com.avito.android.advert.item.AdvertDetailsRouter
    public void openSuggestLocation(@Nullable String str, @Nullable String str2) {
        Intent suggestLocationsIntent$default = SuggestLocationsIntentFactory.DefaultImpls.suggestLocationsIntent$default(this.f, str, str2, Integer.valueOf(OpenEventFromBlock.MARKETPLACE.getValue()), null, null, this.e.currentTab(), false, UUID.randomUUID().toString(), null, true, true, 320, null);
        TabBaseFragment tabBaseFragment = this.e;
        if ((tabBaseFragment instanceof AdvertDetailsFragment) && tabBaseFragment.currentTab() != null) {
            ((AdvertDetailsFragment) this.e).startForResultProxy(suggestLocationsIntent$default, 3);
        }
    }

    @Override // com.avito.android.advert.item.AdvertDetailsRouter
    public void setAnalyticsParams(@Nullable String str, @Nullable String str2) {
        this.b = str;
        this.c = str2;
    }

    @Override // com.avito.android.advert.item.AdvertDetailsRouter
    public void showAbuseCategoryScreen(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        this.e.startActivity(this.f.abuseCategoryIntent(str, "item", null));
    }

    @Override // com.avito.android.advert.item.AdvertDetailsRouter
    public void showAddressOnMap(@Nullable String str, @NotNull String str2, @NotNull Coordinates coordinates, @NotNull String str3, @Nullable List<GeoReference> list) {
        Intrinsics.checkNotNullParameter(str2, IntegrityManager.INTEGRITY_TYPE_ADDRESS);
        Intrinsics.checkNotNullParameter(coordinates, "coordinates");
        Intrinsics.checkNotNullParameter(str3, "title");
        this.e.startActivity(ItemMapIntentFactory.DefaultImpls.itemMapIntent$default(this.f, coordinates, true, null, true, str2, str3, list, str, null, false, false, this.e.currentTab(), true, null, 9984, null));
    }

    @Override // com.avito.android.advert.item.autoteka.AdvertDetailsAutotekaPresenter.Router
    public void showAutoteka(@Nullable AutotekaDetailsResponse autotekaDetailsResponse) {
        this.e.startActivity(this.f.autotekaDetailsIntent(this.d, autotekaDetailsResponse, null));
    }

    @Override // com.avito.android.advert.item.AdvertDetailsRouter
    public void showConsultationForm(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        this.e.startActivity(AdvertDetailsIntentFactory.DefaultImpls.consultationForm$default(this.f, str, null, null, 6, null));
    }

    @Override // com.avito.android.advert_core.advert.AdvertCoreRouter
    public void showContactAccessPackage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        FragmentManager childFragmentManager = this.e.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "fragment.childFragmentManager");
        Fragment findFragmentByTag = childFragmentManager.findFragmentByTag("tag_choose_package_fragment");
        if (!(findFragmentByTag instanceof ContactAccessPackageFragment)) {
            findFragmentByTag = null;
        }
        ContactAccessPackageFragment contactAccessPackageFragment = (ContactAccessPackageFragment) findFragmentByTag;
        if (contactAccessPackageFragment == null) {
            contactAccessPackageFragment = ContactAccessPackageFragmentKt.createContactAccessPackageFragment(str);
        }
        if (contactAccessPackageFragment != null) {
            contactAccessPackageFragment.setRouter(new AdvertDetailsRouterImpl$setRouter$contactAccessPackageRouter$1(this, contactAccessPackageFragment));
        }
        contactAccessPackageFragment.show(childFragmentManager, "tag_choose_package_fragment");
    }

    @Override // com.avito.android.advert.item.dfpcreditinfo.credit_partner_screen.CreditPartnerRouter
    public void showCreditPartnerScreen(@NotNull CreditPartner creditPartner, @NotNull Uri uri, @NotNull String str) {
        Intrinsics.checkNotNullParameter(creditPartner, VKApiUserFull.RelativeType.PARTNER);
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        Intrinsics.checkNotNullParameter(str, "brokerSession");
        this.e.startActivity(this.f.creditPartnerIntent(creditPartner.name(), uri, this.e.currentTab(), this.d, str));
    }

    @Override // com.avito.android.advert.item.AdvertDetailsRouter
    public void showGalleryFullscreen(int i2, @Nullable Video video, @Nullable List<Image> list, @NotNull TreeClickStreamParent treeClickStreamParent, @Nullable String str, @Nullable AdvertActions advertActions, @Nullable ContactBarData contactBarData, @Nullable Long l, @Nullable String str2, @Nullable ForegroundImage foregroundImage, @Nullable AutotekaTeaserGalleryModel autotekaTeaserGalleryModel) {
        List<Image> list2;
        Intrinsics.checkNotNullParameter(treeClickStreamParent, "treeParent");
        ActivityIntentFactory activityIntentFactory = this.f;
        if (list != null) {
            list2 = list;
        } else {
            list2 = CollectionsKt__CollectionsKt.emptyList();
        }
        Intent flags = activityIntentFactory.legacyPhotoGalleryIntent(video, list2, i2, this.d, str, treeClickStreamParent, advertActions, contactBarData, l, str2, foregroundImage, autotekaTeaserGalleryModel).setFlags(603979776);
        Intrinsics.checkNotNullExpressionValue(flags, "activityIntentFactory.le…FLAG_ACTIVITY_SINGLE_TOP)");
        this.e.startActivityForResult(flags, 4);
    }

    @Override // com.avito.android.advert.item.AdvertDetailsRouter
    public void showInactiveItem(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        this.e.startActivity(this.f.inactiveItemIntent(str));
    }

    @Override // com.avito.android.advert_core.advert.AdvertCoreRouter
    public void openAutotekaTeaser(@NotNull Uri uri, @NotNull FromBlock fromBlock) {
        Intrinsics.checkNotNullParameter(uri, "url");
        Intrinsics.checkNotNullParameter(fromBlock, BookingInfoActivity.EXTRA_FROM_BLOCK);
        FragmentsKt.startActivitySafely(this.e, ImplicitIntentFactory.DefaultImpls.uriIntentCustomChromeTabs$default(this.h, uri, false, 2, null));
    }

    @Override // com.avito.android.advert_core.advert.AdvertCoreRouter, com.avito.android.advert.item.booking.AdvertBookingPresenter.Router, com.avito.android.advert_core.advert_badge_bar.AdvertBadgeBarPresenter.Router, com.avito.android.advert.item.cre_geo_report.AdvertDetailsGeoReportTeaserPresenter.Router, com.avito.android.advert_core.car_market_price.price_chart.CarMarketPriceChartPresenter.Router
    public void followDeepLink(@NotNull DeepLink deepLink) {
        Intent intent;
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        if (deepLink instanceof ItemsSearchLink) {
            ItemsSearchLink itemsSearchLink = (ItemsSearchLink) deepLink;
            intent = SerpIntentFactory.DefaultImpls.itemsListIntent$default(this.f, itemsSearchLink.getSearchParams(), itemsSearchLink.getContext(), null, itemsSearchLink.getFromPage(), true, itemsSearchLink.getShowSimpleMap(), 4, null);
        } else {
            intent = this.g.getIntent(deepLink);
        }
        if (intent == null) {
            return;
        }
        if (deepLink instanceof ExpressCvLink) {
            this.e.startActivityForResult(intent, 9);
        } else if (deepLink instanceof CreateChannelLink) {
            this.e.startActivityForResult(intent, 11);
        } else if (deepLink instanceof BadgeBarShowLink) {
            this.e.startActivityForResult(intent, 14);
        } else {
            this.e.startActivity(intent);
        }
    }

    @Override // com.avito.android.advert.item.sellersubscription.SellerSubscriptionPresenter.Router
    public void onAuthRequired(@Nullable String str) {
        onAuthRequired(str, null);
    }
}
