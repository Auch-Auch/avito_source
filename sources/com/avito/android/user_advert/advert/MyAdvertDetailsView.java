package com.avito.android.user_advert.advert;

import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import com.avito.android.advert_core.feature_teasers.common.FeatureTeaserView;
import com.avito.android.analytics.provider.clickstream.ParametrizedClickStreamEvent;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.db.FavoritesContract;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.DetailsSheetLinkBody;
import com.avito.android.deep_linking.links.OnDeepLinkClickListener;
import com.avito.android.image_loader.Picture;
import com.avito.android.remote.model.AdvertParameters;
import com.avito.android.remote.model.AdvertStatsContact;
import com.avito.android.remote.model.AnonymousNumber;
import com.avito.android.remote.model.ContractInfo;
import com.avito.android.remote.model.ForegroundImage;
import com.avito.android.remote.model.GeoReference;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.LimitsInfo;
import com.avito.android.remote.model.RejectReason;
import com.avito.android.remote.model.Video;
import com.avito.android.remote.model.adverts.MyAdvertDetails;
import com.avito.android.remote.model.badge.Badge;
import com.avito.android.remote.model.feature_teaser.SafeShow;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.remote.model.user_adverts.UserOrderStatus;
import com.avito.android.user_advert.advert.verification.VerificationBlockItem;
import com.avito.android.util.ActionMenu;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H&¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u0004H&¢\u0006\u0004\b\u0010\u0010\u000eJ\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0004H&¢\u0006\u0004\b\u0015\u0010\u000eJ\u0019\u0010\u0017\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0017\u0010\u0006J\u001d\u0010\u001a\u001a\u00020\u00042\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u0018H&¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0004H&¢\u0006\u0004\b\u001c\u0010\u000eJ#\u0010!\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001d2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001fH&¢\u0006\u0004\b!\u0010\"J\u0017\u0010#\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b#\u0010\u0006J\u0019\u0010%\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b%\u0010\u0006J\u0019\u0010(\u001a\u00020\u00042\b\b\u0001\u0010'\u001a\u00020&H&¢\u0006\u0004\b(\u0010)J\u0017\u0010+\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u0002H&¢\u0006\u0004\b+\u0010\u0006J\u0017\u0010.\u001a\u00020\u00042\u0006\u0010-\u001a\u00020,H&¢\u0006\u0004\b.\u0010/J\u0019\u00101\u001a\u00020\u00042\b\b\u0001\u00100\u001a\u00020&H&¢\u0006\u0004\b1\u0010)J\u0019\u00104\u001a\u00020\u00042\b\u00103\u001a\u0004\u0018\u000102H&¢\u0006\u0004\b4\u00105J\u001d\u00109\u001a\u00020\u00042\f\u00108\u001a\b\u0012\u0004\u0012\u00020706H&¢\u0006\u0004\b9\u0010:J\u0015\u0010<\u001a\b\u0012\u0004\u0012\u00020&0;H&¢\u0006\u0004\b<\u0010=J\u0015\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00040;H&¢\u0006\u0004\b>\u0010=J\u000f\u0010?\u001a\u00020\u0004H&¢\u0006\u0004\b?\u0010\u000eJ\u001f\u0010B\u001a\u00020\u00042\u000e\u0010A\u001a\n\u0012\u0004\u0012\u00020@\u0018\u000106H&¢\u0006\u0004\bB\u0010:J\u001f\u0010E\u001a\u00020\u00042\u000e\u0010D\u001a\n\u0012\u0004\u0012\u00020C\u0018\u000106H&¢\u0006\u0004\bE\u0010:J\u000f\u0010F\u001a\u00020\u0004H&¢\u0006\u0004\bF\u0010\u000eJ\u000f\u0010G\u001a\u00020\u0004H&¢\u0006\u0004\bG\u0010\u000eJ\u0017\u0010I\u001a\u00020\u00042\u0006\u0010H\u001a\u00020\u0002H&¢\u0006\u0004\bI\u0010\u0006J\u000f\u0010J\u001a\u00020\u0004H&¢\u0006\u0004\bJ\u0010\u000eJ\u0015\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00040;H'¢\u0006\u0004\bK\u0010=J%\u0010M\u001a\u00020\u00042\u0006\u0010H\u001a\u00020\u00022\f\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00040\u0018H&¢\u0006\u0004\bM\u0010NJ\u0017\u0010O\u001a\u00020\u00042\u0006\u0010H\u001a\u00020\u0002H&¢\u0006\u0004\bO\u0010\u0006J\u0017\u0010P\u001a\u00020\u00042\u0006\u0010H\u001a\u00020\u0002H&¢\u0006\u0004\bP\u0010\u0006J\u0015\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00040;H&¢\u0006\u0004\bQ\u0010=J\u0017\u0010S\u001a\u00020\u00042\u0006\u0010$\u001a\u00020RH&¢\u0006\u0004\bS\u0010TJ\u0017\u0010U\u001a\u00020\u00042\u0006\u0010H\u001a\u00020\u0002H&¢\u0006\u0004\bU\u0010\u0006J\u000f\u0010V\u001a\u00020\u0004H&¢\u0006\u0004\bV\u0010\u000eJ+\u0010[\u001a\u00020\u00042\u0006\u0010X\u001a\u00020W2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020Z\u0012\u0004\u0012\u00020\u00040YH&¢\u0006\u0004\b[\u0010\\J\u000f\u0010]\u001a\u00020\u0004H&¢\u0006\u0004\b]\u0010\u000eJ\u001f\u0010`\u001a\u00020\u00042\u0006\u0010^\u001a\u00020\u00022\u0006\u0010_\u001a\u00020\u0002H&¢\u0006\u0004\b`\u0010aJ\u000f\u0010b\u001a\u00020\u0004H&¢\u0006\u0004\bb\u0010\u000eJ\u0017\u0010d\u001a\u00020\u00042\u0006\u0010c\u001a\u00020\u0002H&¢\u0006\u0004\bd\u0010\u0006J\u001f\u0010g\u001a\u00020\u00042\u000e\u0010f\u001a\n\u0012\u0004\u0012\u00020e\u0018\u000106H&¢\u0006\u0004\bg\u0010:J\u0015\u0010h\u001a\b\u0012\u0004\u0012\u00020\u00040;H&¢\u0006\u0004\bh\u0010=J\u0015\u0010i\u001a\b\u0012\u0004\u0012\u00020\u00040;H&¢\u0006\u0004\bi\u0010=J\u0017\u0010j\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\bj\u0010\u0006J1\u0010p\u001a\u00020\u00042\u0006\u0010k\u001a\u00020&2\u0006\u0010l\u001a\u00020&2\u0006\u0010m\u001a\u00020&2\b\u0010o\u001a\u0004\u0018\u00010nH&¢\u0006\u0004\bp\u0010qJ\u000f\u0010r\u001a\u00020\u0004H&¢\u0006\u0004\br\u0010\u000eJ\u000f\u0010s\u001a\u00020\u0004H&¢\u0006\u0004\bs\u0010\u000eJ\u000f\u0010t\u001a\u00020\u0004H&¢\u0006\u0004\bt\u0010\u000eJ\u0019\u0010v\u001a\u00020\u00042\b\u0010u\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\bv\u0010\u0006J\u001d\u0010w\u001a\u00020\u00042\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u0018H&¢\u0006\u0004\bw\u0010\u001bJ\u000f\u0010x\u001a\u00020\u0004H&¢\u0006\u0004\bx\u0010\u000eJ\u000f\u0010y\u001a\u00020\u0004H&¢\u0006\u0004\by\u0010\u000eJ6\u0010\u0001\u001a\u00020\u00042\u000e\u0010{\u001a\n\u0012\u0004\u0012\u00020z\u0018\u0001062\b\u0010}\u001a\u0004\u0018\u00010|2\b\u0010\u001a\u0004\u0018\u00010~H&¢\u0006\u0006\b\u0001\u0010\u0001J\u001a\u0010\u0001\u001a\u00020\u00042\u0007\u0010\u0001\u001a\u00020&H&¢\u0006\u0005\b\u0001\u0010)J-\u0010\u0001\u001a\u00020\u00042\t\u0010\u0001\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u000106H&¢\u0006\u0006\b\u0001\u0010\u0001J\u001c\u0010\u0001\u001a\u00020\u00042\t\u0010\u0001\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0005\b\u0001\u0010\u0006J\u001b\u0010\u0001\u001a\u00020\u00042\u0007\u0010\u0019\u001a\u00030\u0001H&¢\u0006\u0006\b\u0001\u0010\u0001J\u001e\u0010\u0001\u001a\u00020\u00042\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H&¢\u0006\u0006\b\u0001\u0010\u0001J\u001c\u0010\u0001\u001a\u00020\u00042\b\u0010\u0001\u001a\u00030\u0001H&¢\u0006\u0006\b\u0001\u0010\u0001J\u0011\u0010\u0001\u001a\u00020\u0004H&¢\u0006\u0005\b\u0001\u0010\u000eJ%\u0010\u0001\u001a\u00020\u00042\b\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\tH&¢\u0006\u0006\b\u0001\u0010\u0001J\u0011\u0010\u0001\u001a\u00020\u0004H&¢\u0006\u0005\b\u0001\u0010\u000eJ?\u0010 \u0001\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00022\u0014\u0010\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020,0\u00012\r\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00040\u0018H&¢\u0006\u0006\b \u0001\u0010¡\u0001J:\u0010¥\u0001\u001a\u00020\u00042\b\u0010£\u0001\u001a\u00030¢\u00012\r\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00040\u00182\r\u0010¤\u0001\u001a\b\u0012\u0004\u0012\u00020\u00040\u0018H&¢\u0006\u0006\b¥\u0001\u0010¦\u0001J+\u0010¨\u0001\u001a\u00020\u00042\b\u0010£\u0001\u001a\u00030§\u00012\r\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00040\u0018H&¢\u0006\u0006\b¨\u0001\u0010©\u0001J\u001e\u0010¬\u0001\u001a\u00020\u00042\n\u0010«\u0001\u001a\u0005\u0018\u00010ª\u0001H&¢\u0006\u0006\b¬\u0001\u0010­\u0001J%\u0010±\u0001\u001a\u00030°\u00012\u0007\u0010®\u0001\u001a\u00020\t2\u0007\u0010¯\u0001\u001a\u00020\tH&¢\u0006\u0006\b±\u0001\u0010²\u0001J$\u0010µ\u0001\u001a\u00020\u00042\u0007\u0010³\u0001\u001a\u00020\u00022\u0007\u0010´\u0001\u001a\u00020\tH&¢\u0006\u0006\bµ\u0001\u0010¶\u0001J\u001c\u0010¹\u0001\u001a\u00020\u00042\b\u0010¸\u0001\u001a\u00030·\u0001H&¢\u0006\u0006\b¹\u0001\u0010º\u0001R\u001a\u0010¾\u0001\u001a\u00030»\u00018&@&X¦\u0004¢\u0006\b\u001a\u0006\b¼\u0001\u0010½\u0001R\u001a\u0010À\u0001\u001a\u00030»\u00018&@&X¦\u0004¢\u0006\b\u001a\u0006\b¿\u0001\u0010½\u0001R\u001a\u0010Â\u0001\u001a\u00030»\u00018&@&X¦\u0004¢\u0006\b\u001a\u0006\bÁ\u0001\u0010½\u0001¨\u0006Ã\u0001"}, d2 = {"Lcom/avito/android/user_advert/advert/MyAdvertDetailsView;", "Lcom/avito/android/user_advert/advert/AdvertActionsView;", "", "title", "", "showToolbarTitle", "(Ljava/lang/String;)V", "price", "showPrice", "", "visible", "setDividerVisibility", "(Z)V", "showDiscount", "()V", "hideDiscount", "showAddressCopied", "Lcom/avito/android/remote/model/badge/Badge;", "badge", "setPriceBadge", "(Lcom/avito/android/remote/model/badge/Badge;)V", "hidePriceBadge", MessengerShareContentUtility.SUBTITLE, "setPriceBadgeSubtitle", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "showPriceBadgeInfoIconWithListener", "(Lkotlin/jvm/functions/Function0;)V", "hidePriceBadgeInfoIconAndRemoveListener", "Lcom/avito/android/deep_linking/links/DetailsSheetLinkBody;", SDKConstants.PARAM_A2U_BODY, "Lcom/avito/android/analytics/provider/clickstream/ParametrizedClickStreamEvent;", "clickEvent", "showInfoBanner", "(Lcom/avito/android/deep_linking/links/DetailsSheetLinkBody;Lcom/avito/android/analytics/provider/clickstream/ParametrizedClickStreamEvent;)V", "bindDiscountTitle", "description", "bindDiscountDescription", "", "colorAttr", "setDescriptionColor", "(I)V", "amount", "bindDiscountAmount", "Lcom/avito/android/image_loader/Picture;", "picture", "setDiscountImage", "(Lcom/avito/android/image_loader/Picture;)V", "drawableRes", "setDiscountImageDrawable", "Lcom/avito/android/remote/model/text/AttributedText;", "discountText", "bindDiscountAttributedText", "(Lcom/avito/android/remote/model/text/AttributedText;)V", "", "Lcom/avito/android/util/ActionMenu;", "actions", "setUpToolbar", "(Ljava/util/List;)V", "Lio/reactivex/rxjava3/core/Observable;", "menuClicks", "()Lio/reactivex/rxjava3/core/Observable;", "upButtonClicks", "showLoadingProblem", "Lcom/avito/android/remote/model/AdvertParameters$Parameter;", "params", "bindAdvertParameters", "Lcom/avito/android/remote/model/AdvertParameters$Group;", "groups", "bindAdvertGroups", "startLoading", "showContent", "message", "showError", "showAppRater", "showDeleteItemDialog", "dismissListener", "showErrorDialog", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "showActionMessage", "showSnackBar", "descriptionExpands", "", "showDescription", "(Ljava/lang/CharSequence;)V", "showAdvertRestoredMessage", "hideDescription", "Lcom/avito/android/remote/model/user_adverts/UserOrderStatus;", "orderStatus", "Lkotlin/Function1;", "Lcom/avito/android/deep_linking/links/DeepLink;", "showOrderStatus", "(Lcom/avito/android/remote/model/user_adverts/UserOrderStatus;Lkotlin/jvm/functions/Function1;)V", "hideOrderStatus", BookingInfoActivity.EXTRA_ITEM_ID, "time", "showAdvertNumber", "(Ljava/lang/String;Ljava/lang/String;)V", "hideAdvertNumber", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "showAddress", "Lcom/avito/android/remote/model/GeoReference;", "geoReferences", "showGeoReference", "addressClicks", "addressLongClicks", "showTitle", "total", "today", FavoritesContract.TABLE_NAME, "Lcom/avito/android/remote/model/AdvertStatsContact;", "contacts", "showMyStats", "(IIILcom/avito/android/remote/model/AdvertStatsContact;)V", "showNewStatsTooltip", "showStatsPadding", "hideMyStats", "stats", "showStats", "setStatsClickListener", "hideRejectReasons", "dismissDialogForced", "Lcom/avito/android/remote/model/Image;", "images", "Lcom/avito/android/remote/model/Video;", "video", "Lcom/avito/android/remote/model/ForegroundImage;", "infoImage", "bindGallery", "(Ljava/util/List;Lcom/avito/android/remote/model/Video;Lcom/avito/android/remote/model/ForegroundImage;)V", VKApiConst.POSITION, "setGalleryCurrentItem", "reasonsTitle", "Lcom/avito/android/remote/model/RejectReason;", "rejectReasons", "renderRejectReasons", "(Ljava/lang/String;Ljava/util/List;)V", "moderationInfo", "bindModerationInfo", "Lcom/avito/android/deep_linking/links/OnDeepLinkClickListener;", "setRejectionDeeplinkClickListener", "(Lcom/avito/android/deep_linking/links/OnDeepLinkClickListener;)V", "Lcom/avito/android/remote/model/AnonymousNumber;", "anonymousNumber", "showAnonymousNumber", "(Lcom/avito/android/remote/model/AnonymousNumber;)V", "Lcom/avito/android/remote/model/ContractInfo;", "contract", "showContractButton", "(Lcom/avito/android/remote/model/ContractInfo;)V", "hideContractButton", "Lcom/avito/android/user_advert/advert/verification/VerificationBlockItem;", "verification", "isOffer", "showVerification", "(Lcom/avito/android/user_advert/advert/verification/VerificationBlockItem;Z)V", "hideVerification", "", "servicesIcons", "clickListener", "showAppliedServices", "(Ljava/lang/String;Ljava/util/Map;Lkotlin/jvm/functions/Function0;)V", "Lcom/avito/android/remote/model/adverts/MyAdvertDetails$VasBundlesBanner;", "banner", "closeClickListener", "showVasBundlesBanner", "(Lcom/avito/android/remote/model/adverts/MyAdvertDetails$VasBundlesBanner;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "Lcom/avito/android/remote/model/adverts/MyAdvertDetails$AlertBanner;", "showAlertBanner", "(Lcom/avito/android/remote/model/adverts/MyAdvertDetails$AlertBanner;Lkotlin/jvm/functions/Function0;)V", "Lcom/avito/android/remote/model/feature_teaser/SafeShow;", "safeShow", "bindSafeShow", "(Lcom/avito/android/remote/model/feature_teaser/SafeShow;)V", "isFirstIndex", "isLastIndex", "Lcom/avito/android/advert_core/feature_teasers/common/FeatureTeaserView;", "createFeatureTeaser", "(ZZ)Lcom/avito/android/advert_core/feature_teasers/common/FeatureTeaserView;", "itemId", "wasForeverDenied", "showPermissionForCallDialogIfNeeded", "(Ljava/lang/String;Z)V", "Lcom/avito/android/remote/model/LimitsInfo;", "limitsInfo", "showLimitsInfoDialog", "(Lcom/avito/android/remote/model/LimitsInfo;)V", "Landroid/view/View;", "getCarMarketPriceChartView", "()Landroid/view/View;", "carMarketPriceChartView", "getCarMarketPriceBadgeView", "carMarketPriceBadgeView", "getCarMarketPriceDescriptionView", "carMarketPriceDescriptionView", "user-advert_release"}, k = 1, mv = {1, 4, 2})
public interface MyAdvertDetailsView extends AdvertActionsView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void showInfoBanner$default(MyAdvertDetailsView myAdvertDetailsView, DetailsSheetLinkBody detailsSheetLinkBody, ParametrizedClickStreamEvent parametrizedClickStreamEvent, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    parametrizedClickStreamEvent = null;
                }
                myAdvertDetailsView.showInfoBanner(detailsSheetLinkBody, parametrizedClickStreamEvent);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showInfoBanner");
        }
    }

    @NotNull
    Observable<Unit> addressClicks();

    @NotNull
    Observable<Unit> addressLongClicks();

    void bindAdvertGroups(@Nullable List<AdvertParameters.Group> list);

    void bindAdvertParameters(@Nullable List<AdvertParameters.Parameter> list);

    void bindDiscountAmount(@NotNull String str);

    void bindDiscountAttributedText(@Nullable AttributedText attributedText);

    void bindDiscountDescription(@Nullable String str);

    void bindDiscountTitle(@NotNull String str);

    void bindGallery(@Nullable List<Image> list, @Nullable Video video, @Nullable ForegroundImage foregroundImage);

    void bindModerationInfo(@Nullable String str);

    void bindSafeShow(@Nullable SafeShow safeShow);

    @NotNull
    FeatureTeaserView createFeatureTeaser(boolean z, boolean z2);

    @NotNull
    Observable<Unit> descriptionExpands();

    void dismissDialogForced();

    @NotNull
    View getCarMarketPriceBadgeView();

    @NotNull
    View getCarMarketPriceChartView();

    @NotNull
    View getCarMarketPriceDescriptionView();

    void hideAdvertNumber();

    void hideContractButton();

    void hideDescription();

    void hideDiscount();

    void hideMyStats();

    void hideOrderStatus();

    void hidePriceBadge();

    void hidePriceBadgeInfoIconAndRemoveListener();

    void hideRejectReasons();

    void hideVerification();

    @NotNull
    Observable<Integer> menuClicks();

    void renderRejectReasons(@Nullable String str, @NotNull List<RejectReason> list);

    void setDescriptionColor(@AttrRes int i);

    void setDiscountImage(@NotNull Picture picture);

    void setDiscountImageDrawable(@DrawableRes int i);

    void setDividerVisibility(boolean z);

    void setGalleryCurrentItem(int i);

    void setPriceBadge(@NotNull Badge badge);

    void setPriceBadgeSubtitle(@Nullable String str);

    void setRejectionDeeplinkClickListener(@NotNull OnDeepLinkClickListener onDeepLinkClickListener);

    void setStatsClickListener(@NotNull Function0<Unit> function0);

    void setUpToolbar(@NotNull List<ActionMenu> list);

    void showActionMessage(@NotNull String str);

    void showAddress(@NotNull String str);

    void showAddressCopied();

    void showAdvertNumber(@NotNull String str, @NotNull String str2);

    void showAdvertRestoredMessage(@NotNull String str);

    void showAlertBanner(@NotNull MyAdvertDetails.AlertBanner alertBanner, @NotNull Function0<Unit> function0);

    void showAnonymousNumber(@Nullable AnonymousNumber anonymousNumber);

    void showAppRater();

    void showAppliedServices(@NotNull String str, @NotNull Map<String, ? extends Picture> map, @NotNull Function0<Unit> function0);

    void showContent();

    void showContractButton(@NotNull ContractInfo contractInfo);

    @CheckResult
    @NotNull
    Observable<Unit> showDeleteItemDialog();

    void showDescription(@NotNull CharSequence charSequence);

    void showDiscount();

    void showError(@NotNull String str);

    void showErrorDialog(@NotNull String str, @NotNull Function0<Unit> function0);

    void showGeoReference(@Nullable List<GeoReference> list);

    void showInfoBanner(@NotNull DetailsSheetLinkBody detailsSheetLinkBody, @Nullable ParametrizedClickStreamEvent parametrizedClickStreamEvent);

    void showLimitsInfoDialog(@NotNull LimitsInfo limitsInfo);

    void showLoadingProblem();

    void showMyStats(int i, int i2, int i3, @Nullable AdvertStatsContact advertStatsContact);

    void showNewStatsTooltip();

    void showOrderStatus(@NotNull UserOrderStatus userOrderStatus, @NotNull Function1<? super DeepLink, Unit> function1);

    void showPermissionForCallDialogIfNeeded(@NotNull String str, boolean z);

    void showPrice(@Nullable String str);

    void showPriceBadgeInfoIconWithListener(@NotNull Function0<Unit> function0);

    void showSnackBar(@NotNull String str);

    void showStats(@Nullable String str);

    void showStatsPadding();

    void showTitle(@NotNull String str);

    void showToolbarTitle(@NotNull String str);

    void showVasBundlesBanner(@NotNull MyAdvertDetails.VasBundlesBanner vasBundlesBanner, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02);

    void showVerification(@NotNull VerificationBlockItem verificationBlockItem, boolean z);

    void startLoading();

    @NotNull
    Observable<Unit> upButtonClicks();
}
