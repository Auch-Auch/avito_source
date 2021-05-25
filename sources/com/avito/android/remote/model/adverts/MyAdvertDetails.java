package com.avito.android.remote.model.adverts;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.db.FavoritesContract;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.payment.SberbankOnlineKt;
import com.avito.android.remote.item.details.ParameterId;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.AdvertDeliveryC2C;
import com.avito.android.remote.model.AdvertParameters;
import com.avito.android.remote.model.AdvertSellerShortTermRent;
import com.avito.android.remote.model.AdvertSharing;
import com.avito.android.remote.model.AnonymousNumber;
import com.avito.android.remote.model.CarMarketPrice;
import com.avito.android.remote.model.ContractInfo;
import com.avito.android.remote.model.Coordinates;
import com.avito.android.remote.model.ForegroundImage;
import com.avito.android.remote.model.GeoReference;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.MyAdvertSafeDeal;
import com.avito.android.remote.model.MyAdvertVas;
import com.avito.android.remote.model.PriceBadge;
import com.avito.android.remote.model.RejectReason;
import com.avito.android.remote.model.UniversalColor;
import com.avito.android.remote.model.UniversalImage;
import com.avito.android.remote.model.Verification;
import com.avito.android.remote.model.Video;
import com.avito.android.remote.model.feature_teaser.AdvertDetailsFeaturesTeasers;
import com.avito.android.remote.model.feature_teaser.ApartmentFeature;
import com.avito.android.remote.model.my_advert.AppliedServicesInfo;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.remote.model.user_adverts.UserOrderStatus;
import com.avito.android.util.Constants;
import com.avito.android.util.UrlParams;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongycastle.i18n.ErrorBundle;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u00002\u00020\u0001:\u001cÐ\u0001Ñ\u0001Ò\u0001Ó\u0001Ô\u0001Õ\u0001Ö\u0001×\u0001Ø\u0001Ù\u0001Ú\u0001Û\u0001Ü\u0001Ý\u0001Bî\u0004\u0012\u0006\u0010b\u001a\u00020\u0015\u0012\b\u0010*\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0015\u0012\t\u0010\u0001\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0015\u0012\u0007\u0010¢\u0001\u001a\u00020\u0015\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010B\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010u\u001a\u0004\u0018\u00010\u0015\u0012\u0010\u0010\u0001\u001a\u000b\u0012\u0005\u0012\u00030\u0001\u0018\u00010\u0002\u0012\u0007\u0010\u0001\u001a\u00020\u0015\u0012\u0006\u0010{\u001a\u00020\u0015\u0012\b\u0010Q\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010@\u001a\u0004\u0018\u00010\u0015\u0012\u0006\u00103\u001a\u000202\u0012\b\u0010,\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\n\u0010´\u0001\u001a\u0005\u0018\u00010³\u0001\u0012\b\u0010o\u001a\u0004\u0018\u00010n\u0012\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0002\u0012\b\u0010.\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010s\u001a\u0004\u0018\u00010\u0015\u0012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001\u0012\u0006\u0010x\u001a\u00020w\u0012\n\u0010ª\u0001\u001a\u0005\u0018\u00010©\u0001\u0012\u0007\u0010¸\u0001\u001a\u00020\u0015\u0012\n\u0010¯\u0001\u001a\u0005\u0018\u00010®\u0001\u0012\t\u0010\u0001\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010j\u001a\u0004\u0018\u00010i\u0012\b\u0010:\u001a\u0004\u0018\u000109\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010!\u001a\u0004\u0018\u00010 \u0012\n\u0010Ê\u0001\u001a\u0005\u0018\u00010É\u0001\u0012\u000e\u0010E\u001a\n\u0012\u0004\u0012\u00020D\u0018\u00010\u0002\u0012\b\u0010H\u001a\u0004\u0018\u00010G\u0012\u0006\u0010>\u001a\u00020\u0015\u0012\b\u0010^\u001a\u0004\u0018\u00010]\u0012\b\u0010~\u001a\u0004\u0018\u00010}\u0012\b\u00100\u001a\u0004\u0018\u00010\u0015\u0012\u0010\u0010\u0001\u001a\u000b\u0012\u0005\u0012\u00030\u0001\u0018\u00010\u0002\u0012\b\u00107\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010&\u001a\u0004\u0018\u00010%\u0012\b\u0010Y\u001a\u0004\u0018\u00010X\u0012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001\u0012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001\u0012\n\b\u0002\u0010M\u001a\u0004\u0018\u00010L\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001\u0012\n\b\u0002\u0010T\u001a\u0004\u0018\u00010S\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\n\b\u0002\u0010»\u0001\u001a\u00030º\u0001\u0012\n\b\u0002\u0010e\u001a\u0004\u0018\u00010d\u0012\f\b\u0002\u0010À\u0001\u001a\u0005\u0018\u00010¿\u0001\u0012\f\b\u0002\u0010Å\u0001\u001a\u0005\u0018\u00010Ä\u0001\u0012\f\b\u0002\u0010¥\u0001\u001a\u0005\u0018\u00010¤\u0001¢\u0006\u0006\bÎ\u0001\u0010Ï\u0001R!\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R!\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\u0007R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0017\u001a\u0004\b\u001b\u0010\u0019R\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u0019R\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0017\u001a\u0004\b\u001f\u0010\u0019R\u001b\u0010!\u001a\u0004\u0018\u00010 8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001b\u0010&\u001a\u0004\u0018\u00010%8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001b\u0010*\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010\u0017\u001a\u0004\b+\u0010\u0019R\u001b\u0010,\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010\u0017\u001a\u0004\b-\u0010\u0019R\u001b\u0010.\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010\u0017\u001a\u0004\b/\u0010\u0019R\u001b\u00100\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b0\u0010\u0017\u001a\u0004\b1\u0010\u0019R\u0019\u00103\u001a\u0002028\u0006@\u0006¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u001b\u00107\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b7\u0010\u0017\u001a\u0004\b8\u0010\u0019R\u001b\u0010:\u001a\u0004\u0018\u0001098\u0006@\u0006¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u0019\u0010>\u001a\u00020\u00158\u0006@\u0006¢\u0006\f\n\u0004\b>\u0010\u0017\u001a\u0004\b?\u0010\u0019R\u001b\u0010@\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\b@\u0010\u0017\u001a\u0004\bA\u0010\u0019R\u001b\u0010B\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\bB\u0010\u0017\u001a\u0004\bC\u0010\u0019R!\u0010E\u001a\n\u0012\u0004\u0012\u00020D\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\bE\u0010\u0005\u001a\u0004\bF\u0010\u0007R\u001b\u0010H\u001a\u0004\u0018\u00010G8\u0006@\u0006¢\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010KR\u001b\u0010M\u001a\u0004\u0018\u00010L8\u0006@\u0006¢\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bO\u0010PR\u001b\u0010Q\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\bQ\u0010\u0017\u001a\u0004\bR\u0010\u0019R\u001b\u0010T\u001a\u0004\u0018\u00010S8\u0006@\u0006¢\u0006\f\n\u0004\bT\u0010U\u001a\u0004\bV\u0010WR\u001b\u0010Y\u001a\u0004\u0018\u00010X8\u0006@\u0006¢\u0006\f\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\R\u001b\u0010^\u001a\u0004\u0018\u00010]8\u0006@\u0006¢\u0006\f\n\u0004\b^\u0010_\u001a\u0004\b`\u0010aR\u0019\u0010b\u001a\u00020\u00158\u0006@\u0006¢\u0006\f\n\u0004\bb\u0010\u0017\u001a\u0004\bc\u0010\u0019R\u001b\u0010e\u001a\u0004\u0018\u00010d8\u0006@\u0006¢\u0006\f\n\u0004\be\u0010f\u001a\u0004\bg\u0010hR\u001b\u0010j\u001a\u0004\u0018\u00010i8\u0006@\u0006¢\u0006\f\n\u0004\bj\u0010k\u001a\u0004\bl\u0010mR\u001b\u0010o\u001a\u0004\u0018\u00010n8\u0006@\u0006¢\u0006\f\n\u0004\bo\u0010p\u001a\u0004\bq\u0010rR\u001b\u0010s\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\bs\u0010\u0017\u001a\u0004\bt\u0010\u0019R\u001b\u0010u\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\f\n\u0004\bu\u0010\u0017\u001a\u0004\bv\u0010\u0019R\u0019\u0010x\u001a\u00020w8\u0006@\u0006¢\u0006\f\n\u0004\bx\u0010y\u001a\u0004\bx\u0010zR\u0019\u0010{\u001a\u00020\u00158\u0006@\u0006¢\u0006\f\n\u0004\b{\u0010\u0017\u001a\u0004\b|\u0010\u0019R\u001d\u0010~\u001a\u0004\u0018\u00010}8\u0006@\u0006¢\u0006\u000e\n\u0004\b~\u0010\u001a\u0006\b\u0001\u0010\u0001R!\u0010\u0001\u001a\u0005\u0018\u00010\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001R%\u0010\u0001\u001a\u000b\u0012\u0005\u0012\u00030\u0001\u0018\u00010\u00028\u0006@\u0006¢\u0006\u000e\n\u0005\b\u0001\u0010\u0005\u001a\u0005\b\u0001\u0010\u0007R!\u0010\u0001\u001a\u0005\u0018\u00010\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001R!\u0010\u0001\u001a\u0005\u0018\u00010\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001R%\u0010\u0001\u001a\u000b\u0012\u0005\u0012\u00030\u0001\u0018\u00010\u00028\u0006@\u0006¢\u0006\u000e\n\u0005\b\u0001\u0010\u0005\u001a\u0005\b\u0001\u0010\u0007R\u001e\u0010\u0001\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\u000e\n\u0005\b\u0001\u0010\u0017\u001a\u0005\b\u0001\u0010\u0019R\u001c\u0010\u0001\u001a\u00020\u00158\u0006@\u0006¢\u0006\u000e\n\u0005\b\u0001\u0010\u0017\u001a\u0005\b\u0001\u0010\u0019R\u001e\u0010\u0001\u001a\u0004\u0018\u00010\u00158\u0006@\u0006¢\u0006\u000e\n\u0005\b\u0001\u0010\u0017\u001a\u0005\b\u0001\u0010\u0019R!\u0010\u0001\u001a\u0005\u0018\u00010\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b \u0001\u0010¡\u0001R\u001c\u0010¢\u0001\u001a\u00020\u00158\u0006@\u0006¢\u0006\u000e\n\u0005\b¢\u0001\u0010\u0017\u001a\u0005\b£\u0001\u0010\u0019R!\u0010¥\u0001\u001a\u0005\u0018\u00010¤\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\b¥\u0001\u0010¦\u0001\u001a\u0006\b§\u0001\u0010¨\u0001R!\u0010ª\u0001\u001a\u0005\u0018\u00010©\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\bª\u0001\u0010«\u0001\u001a\u0006\b¬\u0001\u0010­\u0001R!\u0010¯\u0001\u001a\u0005\u0018\u00010®\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\b¯\u0001\u0010°\u0001\u001a\u0006\b±\u0001\u0010²\u0001R!\u0010´\u0001\u001a\u0005\u0018\u00010³\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\b´\u0001\u0010µ\u0001\u001a\u0006\b¶\u0001\u0010·\u0001R\u001c\u0010¸\u0001\u001a\u00020\u00158\u0006@\u0006¢\u0006\u000e\n\u0005\b¸\u0001\u0010\u0017\u001a\u0005\b¹\u0001\u0010\u0019R\u001f\u0010»\u0001\u001a\u00030º\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\b»\u0001\u0010¼\u0001\u001a\u0006\b½\u0001\u0010¾\u0001R!\u0010À\u0001\u001a\u0005\u0018\u00010¿\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\bÀ\u0001\u0010Á\u0001\u001a\u0006\bÂ\u0001\u0010Ã\u0001R!\u0010Å\u0001\u001a\u0005\u0018\u00010Ä\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\bÅ\u0001\u0010Æ\u0001\u001a\u0006\bÇ\u0001\u0010È\u0001R!\u0010Ê\u0001\u001a\u0005\u0018\u00010É\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\bÊ\u0001\u0010Ë\u0001\u001a\u0006\bÌ\u0001\u0010Í\u0001¨\u0006Þ\u0001"}, d2 = {"Lcom/avito/android/remote/model/adverts/MyAdvertDetails;", "", "", "Lcom/avito/android/remote/model/feature_teaser/ApartmentFeature;", "apartmentFeatures", "Ljava/util/List;", "getApartmentFeatures", "()Ljava/util/List;", "Lcom/avito/android/remote/model/adverts/MyAdvertDetails$VasBundlesBanner;", "vasBundlesBanner", "Lcom/avito/android/remote/model/adverts/MyAdvertDetails$VasBundlesBanner;", "getVasBundlesBanner", "()Lcom/avito/android/remote/model/adverts/MyAdvertDetails$VasBundlesBanner;", "Lcom/avito/android/remote/model/Verification;", "verification", "Lcom/avito/android/remote/model/Verification;", "getVerification", "()Lcom/avito/android/remote/model/Verification;", "Lcom/avito/android/remote/model/Action;", "actions", "getActions", "", ParameterId.EDIT, "Ljava/lang/String;", "getWizardId", "()Ljava/lang/String;", "metroName", "getMetroName", "directionName", "getDirectionName", "locationId", "getLocationId", "Lcom/avito/android/remote/model/adverts/MyAdvertDetails$AlertBanner;", "alertBanner", "Lcom/avito/android/remote/model/adverts/MyAdvertDetails$AlertBanner;", "getAlertBanner", "()Lcom/avito/android/remote/model/adverts/MyAdvertDetails$AlertBanner;", "Lcom/avito/android/remote/model/adverts/MyAdvertDetails$ActivationInfo;", "activationInfo", "Lcom/avito/android/remote/model/adverts/MyAdvertDetails$ActivationInfo;", "getActivationInfo", "()Lcom/avito/android/remote/model/adverts/MyAdvertDetails$ActivationInfo;", Constants.LOCATION_NAME, "getLocationName", "ttlHumanized", "getTtlHumanized", "description", "getDescription", "reasonsTitle", "getReasonsTitle", "", "time", "J", "getTime", "()J", "moderationInfo", "getModerationInfo", "Lcom/avito/android/remote/model/adverts/MyAdvertDetails$Shop;", ScreenPublicConstsKt.CONTENT_TYPE_SHOP, "Lcom/avito/android/remote/model/adverts/MyAdvertDetails$Shop;", "getShop", "()Lcom/avito/android/remote/model/adverts/MyAdvertDetails$Shop;", "status", "getStatus", UrlParams.DISTRICT_ID, "getDistrictId", UrlParams.METRO_ID, "getMetroId", "Lcom/avito/android/remote/model/adverts/MyAdvertDetails$ExtendedImage;", "images", "getImages", "Lcom/avito/android/remote/model/Video;", "video", "Lcom/avito/android/remote/model/Video;", "getVideo", "()Lcom/avito/android/remote/model/Video;", "Lcom/avito/android/remote/model/ContractInfo;", "contract", "Lcom/avito/android/remote/model/ContractInfo;", "getContract", "()Lcom/avito/android/remote/model/ContractInfo;", UrlParams.DIRECTION_ID, "getDirectionId", "Lcom/avito/android/remote/model/feature_teaser/AdvertDetailsFeaturesTeasers;", "teasers", "Lcom/avito/android/remote/model/feature_teaser/AdvertDetailsFeaturesTeasers;", "getTeasers", "()Lcom/avito/android/remote/model/feature_teaser/AdvertDetailsFeaturesTeasers;", "Lcom/avito/android/remote/model/AdvertSellerShortTermRent;", "shortTermRent", "Lcom/avito/android/remote/model/AdvertSellerShortTermRent;", "getShortTermRent", "()Lcom/avito/android/remote/model/AdvertSellerShortTermRent;", "Lcom/avito/android/remote/model/adverts/MyAdvertDetails$Price;", "price", "Lcom/avito/android/remote/model/adverts/MyAdvertDetails$Price;", "getPrice", "()Lcom/avito/android/remote/model/adverts/MyAdvertDetails$Price;", "id", "getId", "Lcom/avito/android/remote/model/adverts/MyAdvertDetails$AutoBooking;", "autoBooking", "Lcom/avito/android/remote/model/adverts/MyAdvertDetails$AutoBooking;", "getAutoBooking", "()Lcom/avito/android/remote/model/adverts/MyAdvertDetails$AutoBooking;", "Lcom/avito/android/remote/model/MyAdvertVas;", "vas", "Lcom/avito/android/remote/model/MyAdvertVas;", "getVas", "()Lcom/avito/android/remote/model/MyAdvertVas;", "Lcom/avito/android/remote/model/AdvertSharing;", "sharing", "Lcom/avito/android/remote/model/AdvertSharing;", "getSharing", "()Lcom/avito/android/remote/model/AdvertSharing;", "descriptionHtml", "getDescriptionHtml", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "getAddress", "", "isDeliveryEnabled", "Z", "()Z", "toolbarTitle", "getToolbarTitle", "Lcom/avito/android/remote/model/adverts/MyAdvertDetails$Stats;", "stats", "Lcom/avito/android/remote/model/adverts/MyAdvertDetails$Stats;", "getStats", "()Lcom/avito/android/remote/model/adverts/MyAdvertDetails$Stats;", "Lcom/avito/android/remote/model/PriceBadge;", "priceBadge", "Lcom/avito/android/remote/model/PriceBadge;", "getPriceBadge", "()Lcom/avito/android/remote/model/PriceBadge;", "Lcom/avito/android/remote/model/RejectReason;", "reasons", "getReasons", "Lcom/avito/android/remote/model/MyAdvertSafeDeal;", "safeDealServices", "Lcom/avito/android/remote/model/MyAdvertSafeDeal;", "getSafeDealServices", "()Lcom/avito/android/remote/model/MyAdvertSafeDeal;", "Lcom/avito/android/remote/model/my_advert/AppliedServicesInfo;", "appliedServices", "Lcom/avito/android/remote/model/my_advert/AppliedServicesInfo;", "getAppliedServices", "()Lcom/avito/android/remote/model/my_advert/AppliedServicesInfo;", "Lcom/avito/android/remote/model/GeoReference;", "geoReferences", "getGeoReferences", "districtName", "getDistrictName", "title", "getTitle", "phone", "getPhone", "Lcom/avito/android/remote/model/AnonymousNumber;", "anonymousNumber", "Lcom/avito/android/remote/model/AnonymousNumber;", "getAnonymousNumber", "()Lcom/avito/android/remote/model/AnonymousNumber;", "categoryId", "getCategoryId", "Lcom/avito/android/remote/model/CarMarketPrice;", "carMarketPrice", "Lcom/avito/android/remote/model/CarMarketPrice;", "getCarMarketPrice", "()Lcom/avito/android/remote/model/CarMarketPrice;", "Lcom/avito/android/remote/model/AdvertDeliveryC2C;", "delivery", "Lcom/avito/android/remote/model/AdvertDeliveryC2C;", "getDelivery", "()Lcom/avito/android/remote/model/AdvertDeliveryC2C;", "Lcom/avito/android/remote/model/adverts/MyAdvertDetails$Seller;", "seller", "Lcom/avito/android/remote/model/adverts/MyAdvertDetails$Seller;", "getSeller", "()Lcom/avito/android/remote/model/adverts/MyAdvertDetails$Seller;", "Lcom/avito/android/remote/model/Coordinates;", "coordinates", "Lcom/avito/android/remote/model/Coordinates;", "getCoordinates", "()Lcom/avito/android/remote/model/Coordinates;", "userType", "getUserType", "Lcom/avito/android/remote/model/adverts/MyAdvertDetails$AutoPublish;", "autoPublish", "Lcom/avito/android/remote/model/adverts/MyAdvertDetails$AutoPublish;", "getAutoPublish", "()Lcom/avito/android/remote/model/adverts/MyAdvertDetails$AutoPublish;", "Lcom/avito/android/remote/model/ForegroundImage;", "infoImage", "Lcom/avito/android/remote/model/ForegroundImage;", "getInfoImage", "()Lcom/avito/android/remote/model/ForegroundImage;", "Lcom/avito/android/remote/model/user_adverts/UserOrderStatus;", "orderStatus", "Lcom/avito/android/remote/model/user_adverts/UserOrderStatus;", "getOrderStatus", "()Lcom/avito/android/remote/model/user_adverts/UserOrderStatus;", "Lcom/avito/android/remote/model/AdvertParameters;", ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, "Lcom/avito/android/remote/model/AdvertParameters;", "getParameters", "()Lcom/avito/android/remote/model/AdvertParameters;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Coordinates;Lcom/avito/android/remote/model/AdvertSharing;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/AnonymousNumber;ZLcom/avito/android/remote/model/AdvertDeliveryC2C;Ljava/lang/String;Lcom/avito/android/remote/model/adverts/MyAdvertDetails$Seller;Ljava/lang/String;Lcom/avito/android/remote/model/MyAdvertVas;Lcom/avito/android/remote/model/adverts/MyAdvertDetails$Shop;Lcom/avito/android/remote/model/adverts/MyAdvertDetails$VasBundlesBanner;Lcom/avito/android/remote/model/adverts/MyAdvertDetails$AlertBanner;Lcom/avito/android/remote/model/AdvertParameters;Ljava/util/List;Lcom/avito/android/remote/model/Video;Ljava/lang/String;Lcom/avito/android/remote/model/adverts/MyAdvertDetails$Price;Lcom/avito/android/remote/model/adverts/MyAdvertDetails$Stats;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/avito/android/remote/model/adverts/MyAdvertDetails$ActivationInfo;Lcom/avito/android/remote/model/AdvertSellerShortTermRent;Lcom/avito/android/remote/model/my_advert/AppliedServicesInfo;Lcom/avito/android/remote/model/PriceBadge;Lcom/avito/android/remote/model/ContractInfo;Lcom/avito/android/remote/model/Verification;Lcom/avito/android/remote/model/MyAdvertSafeDeal;Lcom/avito/android/remote/model/feature_teaser/AdvertDetailsFeaturesTeasers;Ljava/util/List;Lcom/avito/android/remote/model/adverts/MyAdvertDetails$AutoPublish;Lcom/avito/android/remote/model/adverts/MyAdvertDetails$AutoBooking;Lcom/avito/android/remote/model/ForegroundImage;Lcom/avito/android/remote/model/user_adverts/UserOrderStatus;Lcom/avito/android/remote/model/CarMarketPrice;)V", "ActivationInfo", "AlertBanner", "AutoBooking", "AutoBookingSwitcher", "AutoPublish", "AutoPublishSwitcher", "ExtendedImage", "Price", "Seller", "Shop", "Stats", "Style", "Switcher", "VasBundlesBanner", "user-advert_release"}, k = 1, mv = {1, 4, 2})
public final class MyAdvertDetails {
    @Nullable
    private final List<Action> actions;
    @Nullable
    private final ActivationInfo activationInfo;
    @Nullable
    private final String address;
    @Nullable
    private final AlertBanner alertBanner;
    @Nullable
    private final AnonymousNumber anonymousNumber;
    @Nullable
    private final List<ApartmentFeature> apartmentFeatures;
    @Nullable
    private final AppliedServicesInfo appliedServices;
    @Nullable
    private final AutoBooking autoBooking;
    @NotNull
    private final AutoPublish autoPublish;
    @Nullable
    private final CarMarketPrice carMarketPrice;
    @NotNull
    private final String categoryId;
    @Nullable
    private final ContractInfo contract;
    @Nullable
    private final Coordinates coordinates;
    @Nullable
    private final AdvertDeliveryC2C delivery;
    @Nullable
    private final String description;
    @Nullable
    private final String descriptionHtml;
    @Nullable
    private final String directionId;
    @Nullable
    private final String directionName;
    @Nullable
    private final String districtId;
    @Nullable
    private final String districtName;
    @Nullable
    private final List<GeoReference> geoReferences;
    @NotNull
    private final String id;
    @Nullable
    private final List<ExtendedImage> images;
    @Nullable
    private final ForegroundImage infoImage;
    private final boolean isDeliveryEnabled;
    @Nullable
    private final String locationId;
    @Nullable
    private final String locationName;
    @Nullable
    private final String metroId;
    @Nullable
    private final String metroName;
    @Nullable
    private final String moderationInfo;
    @Nullable
    private final UserOrderStatus orderStatus;
    @Nullable
    private final AdvertParameters parameters;
    @Nullable
    private final String phone;
    @Nullable
    private final Price price;
    @Nullable
    private final PriceBadge priceBadge;
    @Nullable
    private final List<RejectReason> reasons;
    @Nullable
    private final String reasonsTitle;
    @Nullable
    private final MyAdvertSafeDeal safeDealServices;
    @Nullable
    private final Seller seller;
    @Nullable
    private final AdvertSharing sharing;
    @Nullable
    private final Shop shop;
    @Nullable
    private final AdvertSellerShortTermRent shortTermRent;
    @Nullable
    private final Stats stats;
    @NotNull
    private final String status;
    @Nullable
    private final AdvertDetailsFeaturesTeasers teasers;
    private final long time;
    @NotNull
    private final String title;
    @NotNull
    private final String toolbarTitle;
    @Nullable
    private final String ttlHumanized;
    @NotNull
    private final String userType;
    @Nullable
    private final MyAdvertVas vas;
    @Nullable
    private final VasBundlesBanner vasBundlesBanner;
    @Nullable
    private final Verification verification;
    @Nullable
    private final Video video;
    @Nullable
    private final String wizardId;

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/avito/android/remote/model/adverts/MyAdvertDetails$ActivationInfo;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/Action;", "primaryAction", "Lcom/avito/android/remote/model/Action;", "getPrimaryAction", "()Lcom/avito/android/remote/model/Action;", "secondaryAction", "getSecondaryAction", "", "hint", "Ljava/lang/String;", "getHint", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/Action;Lcom/avito/android/remote/model/Action;)V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
    public static final class ActivationInfo implements Parcelable {
        public static final Parcelable.Creator<ActivationInfo> CREATOR = new Creator();
        @SerializedName("hint")
        @Nullable
        private final String hint;
        @SerializedName("primaryAction")
        @Nullable
        private final Action primaryAction;
        @SerializedName("secondaryAction")
        @Nullable
        private final Action secondaryAction;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<ActivationInfo> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final ActivationInfo createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new ActivationInfo(parcel.readString(), (Action) parcel.readParcelable(ActivationInfo.class.getClassLoader()), (Action) parcel.readParcelable(ActivationInfo.class.getClassLoader()));
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final ActivationInfo[] newArray(int i) {
                return new ActivationInfo[i];
            }
        }

        public ActivationInfo(@Nullable String str, @Nullable Action action, @Nullable Action action2) {
            this.hint = str;
            this.primaryAction = action;
            this.secondaryAction = action2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Nullable
        public final String getHint() {
            return this.hint;
        }

        @Nullable
        public final Action getPrimaryAction() {
            return this.primaryAction;
        }

        @Nullable
        public final Action getSecondaryAction() {
            return this.secondaryAction;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.hint);
            parcel.writeParcelable(this.primaryAction, i);
            parcel.writeParcelable(this.secondaryAction, i);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0015\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0016\u0010\u000fR\u001c\u0010\u0018\u001a\u00020\u00178\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/avito/android/remote/model/adverts/MyAdvertDetails$AlertBanner;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", SDKConstants.PARAM_A2U_BODY, "Ljava/lang/String;", "getBody", "()Ljava/lang/String;", "Lcom/avito/android/deep_linking/links/DeepLink;", ShareConstants.MEDIA_URI, "Lcom/avito/android/deep_linking/links/DeepLink;", "getUri", "()Lcom/avito/android/deep_linking/links/DeepLink;", "title", "getTitle", "Lcom/avito/android/remote/model/adverts/MyAdvertDetails$Style;", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "Lcom/avito/android/remote/model/adverts/MyAdvertDetails$Style;", "getStyle", "()Lcom/avito/android/remote/model/adverts/MyAdvertDetails$Style;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/adverts/MyAdvertDetails$Style;Lcom/avito/android/deep_linking/links/DeepLink;)V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
    public static final class AlertBanner implements Parcelable {
        public static final Parcelable.Creator<AlertBanner> CREATOR = new Creator();
        @SerializedName(SDKConstants.PARAM_A2U_BODY)
        @Nullable
        private final String body;
        @SerializedName(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE)
        @NotNull
        private final Style style;
        @SerializedName("title")
        @NotNull
        private final String title;
        @SerializedName(ShareConstants.MEDIA_URI)
        @Nullable
        private final DeepLink uri;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<AlertBanner> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final AlertBanner createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new AlertBanner(parcel.readString(), parcel.readString(), (Style) Enum.valueOf(Style.class, parcel.readString()), (DeepLink) parcel.readParcelable(AlertBanner.class.getClassLoader()));
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final AlertBanner[] newArray(int i) {
                return new AlertBanner[i];
            }
        }

        public AlertBanner(@NotNull String str, @Nullable String str2, @NotNull Style style2, @Nullable DeepLink deepLink) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(style2, AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE);
            this.title = str;
            this.body = str2;
            this.style = style2;
            this.uri = deepLink;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Nullable
        public final String getBody() {
            return this.body;
        }

        @NotNull
        public final Style getStyle() {
            return this.style;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        public final DeepLink getUri() {
            return this.uri;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.title);
            parcel.writeString(this.body);
            parcel.writeString(this.style.name());
            parcel.writeParcelable(this.uri, i);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/avito/android/remote/model/adverts/MyAdvertDetails$AutoBooking;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/adverts/MyAdvertDetails$AutoBookingSwitcher;", "switcher", "Lcom/avito/android/remote/model/adverts/MyAdvertDetails$AutoBookingSwitcher;", "getSwitcher", "()Lcom/avito/android/remote/model/adverts/MyAdvertDetails$AutoBookingSwitcher;", "<init>", "(Lcom/avito/android/remote/model/adverts/MyAdvertDetails$AutoBookingSwitcher;)V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
    public static final class AutoBooking implements Parcelable {
        public static final Parcelable.Creator<AutoBooking> CREATOR = new Creator();
        @SerializedName("switcher")
        @Nullable
        private final AutoBookingSwitcher switcher;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<AutoBooking> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final AutoBooking createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new AutoBooking(parcel.readInt() != 0 ? AutoBookingSwitcher.CREATOR.createFromParcel(parcel) : null);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final AutoBooking[] newArray(int i) {
                return new AutoBooking[i];
            }
        }

        public AutoBooking() {
            this(null, 1, null);
        }

        public AutoBooking(@Nullable AutoBookingSwitcher autoBookingSwitcher) {
            this.switcher = autoBookingSwitcher;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Nullable
        public final AutoBookingSwitcher getSwitcher() {
            return this.switcher;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            AutoBookingSwitcher autoBookingSwitcher = this.switcher;
            if (autoBookingSwitcher != null) {
                parcel.writeInt(1);
                autoBookingSwitcher.writeToParcel(parcel, 0);
                return;
            }
            parcel.writeInt(0);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AutoBooking(AutoBookingSwitcher autoBookingSwitcher, int i, j jVar) {
            this((i & 1) != 0 ? null : autoBookingSwitcher);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u001c\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\u00108\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R$\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u00020\u00108\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0012\u001a\u0004\b\u001d\u0010\u0014R\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u00158\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u0017\u001a\u0004\b\u001f\u0010\u0019¨\u0006\""}, d2 = {"Lcom/avito/android/remote/model/adverts/MyAdvertDetails$AutoBookingSwitcher;", "Lcom/avito/android/remote/model/adverts/MyAdvertDetails$Switcher;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/text/AttributedText;", MessengerShareContentUtility.SUBTITLE, "Lcom/avito/android/remote/model/text/AttributedText;", "getSubtitle", "()Lcom/avito/android/remote/model/text/AttributedText;", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "", "value", "Ljava/lang/Boolean;", "getValue", "()Ljava/lang/Boolean;", "setValue", "(Ljava/lang/Boolean;)V", "id", "getId", "areOrdersExist", "getAreOrdersExist", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
    public static final class AutoBookingSwitcher implements Switcher {
        public static final Parcelable.Creator<AutoBookingSwitcher> CREATOR = new Creator();
        @SerializedName("areOrdersExist")
        @Nullable
        private final Boolean areOrdersExist;
        @SerializedName("id")
        @NotNull
        private final String id;
        @SerializedName(MessengerShareContentUtility.SUBTITLE)
        @Nullable
        private final AttributedText subtitle;
        @SerializedName("title")
        @NotNull
        private final String title;
        @SerializedName("value")
        @Nullable
        private Boolean value;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<AutoBookingSwitcher> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final AutoBookingSwitcher createFromParcel(@NotNull Parcel parcel) {
                Boolean bool;
                Boolean bool2;
                Intrinsics.checkNotNullParameter(parcel, "in");
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                AttributedText attributedText = (AttributedText) parcel.readParcelable(AutoBookingSwitcher.class.getClassLoader());
                boolean z = true;
                if (parcel.readInt() != 0) {
                    bool = Boolean.valueOf(parcel.readInt() != 0);
                } else {
                    bool = null;
                }
                if (parcel.readInt() != 0) {
                    if (parcel.readInt() == 0) {
                        z = false;
                    }
                    bool2 = Boolean.valueOf(z);
                } else {
                    bool2 = null;
                }
                return new AutoBookingSwitcher(readString, readString2, attributedText, bool, bool2);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final AutoBookingSwitcher[] newArray(int i) {
                return new AutoBookingSwitcher[i];
            }
        }

        public AutoBookingSwitcher(@NotNull String str, @NotNull String str2, @Nullable AttributedText attributedText, @Nullable Boolean bool, @Nullable Boolean bool2) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "title");
            this.id = str;
            this.title = str2;
            this.subtitle = attributedText;
            this.value = bool;
            this.areOrdersExist = bool2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Nullable
        public final Boolean getAreOrdersExist() {
            return this.areOrdersExist;
        }

        @Override // com.avito.android.remote.model.adverts.MyAdvertDetails.Switcher
        @NotNull
        public String getId() {
            return this.id;
        }

        @Override // com.avito.android.remote.model.adverts.MyAdvertDetails.Switcher
        @Nullable
        public AttributedText getSubtitle() {
            return this.subtitle;
        }

        @Override // com.avito.android.remote.model.adverts.MyAdvertDetails.Switcher
        @NotNull
        public String getTitle() {
            return this.title;
        }

        @Override // com.avito.android.remote.model.adverts.MyAdvertDetails.Switcher
        @Nullable
        public Boolean getValue() {
            return this.value;
        }

        @Override // com.avito.android.remote.model.adverts.MyAdvertDetails.Switcher
        public void setValue(@Nullable Boolean bool) {
            this.value = bool;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.id);
            parcel.writeString(this.title);
            parcel.writeParcelable(this.subtitle, i);
            Boolean bool = this.value;
            if (bool != null) {
                a.G0(parcel, 1, bool);
            } else {
                parcel.writeInt(0);
            }
            Boolean bool2 = this.areOrdersExist;
            if (bool2 != null) {
                a.G0(parcel, 1, bool2);
            } else {
                parcel.writeInt(0);
            }
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/avito/android/remote/model/adverts/MyAdvertDetails$AutoPublish;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/adverts/MyAdvertDetails$AutoPublishSwitcher;", "switcher", "Lcom/avito/android/remote/model/adverts/MyAdvertDetails$AutoPublishSwitcher;", "getSwitcher", "()Lcom/avito/android/remote/model/adverts/MyAdvertDetails$AutoPublishSwitcher;", "<init>", "(Lcom/avito/android/remote/model/adverts/MyAdvertDetails$AutoPublishSwitcher;)V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
    public static final class AutoPublish implements Parcelable {
        public static final Parcelable.Creator<AutoPublish> CREATOR = new Creator();
        @SerializedName("switcher")
        @Nullable
        private final AutoPublishSwitcher switcher;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<AutoPublish> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final AutoPublish createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new AutoPublish(parcel.readInt() != 0 ? AutoPublishSwitcher.CREATOR.createFromParcel(parcel) : null);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final AutoPublish[] newArray(int i) {
                return new AutoPublish[i];
            }
        }

        public AutoPublish() {
            this(null, 1, null);
        }

        public AutoPublish(@Nullable AutoPublishSwitcher autoPublishSwitcher) {
            this.switcher = autoPublishSwitcher;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Nullable
        public final AutoPublishSwitcher getSwitcher() {
            return this.switcher;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            AutoPublishSwitcher autoPublishSwitcher = this.switcher;
            if (autoPublishSwitcher != null) {
                parcel.writeInt(1);
                autoPublishSwitcher.writeToParcel(parcel, 0);
                return;
            }
            parcel.writeInt(0);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AutoPublish(AutoPublishSwitcher autoPublishSwitcher, int i, j jVar) {
            this((i & 1) != 0 ? null : autoPublishSwitcher);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR$\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0013\u001a\u00020\u00128\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u00020\u00128\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0018\u0010\u0016R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lcom/avito/android/remote/model/adverts/MyAdvertDetails$AutoPublishSwitcher;", "Lcom/avito/android/remote/model/adverts/MyAdvertDetails$Switcher;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "value", "Ljava/lang/Boolean;", "getValue", "()Ljava/lang/Boolean;", "setValue", "(Ljava/lang/Boolean;)V", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "id", "getId", "Lcom/avito/android/remote/model/text/AttributedText;", MessengerShareContentUtility.SUBTITLE, "Lcom/avito/android/remote/model/text/AttributedText;", "getSubtitle", "()Lcom/avito/android/remote/model/text/AttributedText;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Ljava/lang/Boolean;)V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
    public static final class AutoPublishSwitcher implements Switcher {
        public static final Parcelable.Creator<AutoPublishSwitcher> CREATOR = new Creator();
        @SerializedName("id")
        @NotNull
        private final String id;
        @SerializedName(MessengerShareContentUtility.SUBTITLE)
        @Nullable
        private final AttributedText subtitle;
        @SerializedName("title")
        @NotNull
        private final String title;
        @SerializedName("value")
        @Nullable
        private Boolean value;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<AutoPublishSwitcher> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final AutoPublishSwitcher createFromParcel(@NotNull Parcel parcel) {
                Boolean bool;
                Intrinsics.checkNotNullParameter(parcel, "in");
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                AttributedText attributedText = (AttributedText) parcel.readParcelable(AutoPublishSwitcher.class.getClassLoader());
                if (parcel.readInt() != 0) {
                    bool = Boolean.valueOf(parcel.readInt() != 0);
                } else {
                    bool = null;
                }
                return new AutoPublishSwitcher(readString, readString2, attributedText, bool);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final AutoPublishSwitcher[] newArray(int i) {
                return new AutoPublishSwitcher[i];
            }
        }

        public AutoPublishSwitcher(@NotNull String str, @NotNull String str2, @Nullable AttributedText attributedText, @Nullable Boolean bool) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "title");
            this.id = str;
            this.title = str2;
            this.subtitle = attributedText;
            this.value = bool;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.avito.android.remote.model.adverts.MyAdvertDetails.Switcher
        @NotNull
        public String getId() {
            return this.id;
        }

        @Override // com.avito.android.remote.model.adverts.MyAdvertDetails.Switcher
        @Nullable
        public AttributedText getSubtitle() {
            return this.subtitle;
        }

        @Override // com.avito.android.remote.model.adverts.MyAdvertDetails.Switcher
        @NotNull
        public String getTitle() {
            return this.title;
        }

        @Override // com.avito.android.remote.model.adverts.MyAdvertDetails.Switcher
        @Nullable
        public Boolean getValue() {
            return this.value;
        }

        @Override // com.avito.android.remote.model.adverts.MyAdvertDetails.Switcher
        public void setValue(@Nullable Boolean bool) {
            this.value = bool;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            boolean z;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.id);
            parcel.writeString(this.title);
            parcel.writeParcelable(this.subtitle, i);
            Boolean bool = this.value;
            if (bool != null) {
                parcel.writeInt(1);
                z = bool.booleanValue();
            } else {
                z = false;
            }
            int i2 = z ? 1 : 0;
            int i3 = z ? 1 : 0;
            int i4 = z ? 1 : 0;
            parcel.writeInt(i2);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u001c\u0010\u0013\u001a\u00020\u00128\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/avito/android/remote/model/adverts/MyAdvertDetails$ExtendedImage;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/Image;", "image", "Lcom/avito/android/remote/model/Image;", "getImage", "()Lcom/avito/android/remote/model/Image;", "originalImage", "getOriginalImage", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/Image;Lcom/avito/android/remote/model/Image;)V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
    public static final class ExtendedImage implements Parcelable {
        public static final Parcelable.Creator<ExtendedImage> CREATOR = new Creator();
        @SerializedName("url")
        @NotNull
        private final Image image;
        @SerializedName("original")
        @Nullable
        private final Image originalImage;
        @SerializedName("id")
        @NotNull
        private final String title;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<ExtendedImage> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final ExtendedImage createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new ExtendedImage(parcel.readString(), (Image) parcel.readParcelable(ExtendedImage.class.getClassLoader()), (Image) parcel.readParcelable(ExtendedImage.class.getClassLoader()));
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final ExtendedImage[] newArray(int i) {
                return new ExtendedImage[i];
            }
        }

        public ExtendedImage(@NotNull String str, @NotNull Image image2, @Nullable Image image3) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(image2, "image");
            this.title = str;
            this.image = image2;
            this.originalImage = image3;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        public final Image getImage() {
            return this.image;
        }

        @Nullable
        public final Image getOriginalImage() {
            return this.originalImage;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.title);
            parcel.writeParcelable(this.image, i);
            parcel.writeParcelable(this.originalImage, i);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B#\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u001c\u0010\u0012\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/avito/android/remote/model/adverts/MyAdvertDetails$Price;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "metric", "getMetric", "value", "getValue", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
    public static final class Price implements Parcelable {
        public static final Parcelable.Creator<Price> CREATOR = new Creator();
        @SerializedName("metric")
        @Nullable
        private final String metric;
        @SerializedName("title")
        @Nullable
        private final String title;
        @SerializedName("value")
        @NotNull
        private final String value;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Price> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Price createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Price(parcel.readString(), parcel.readString(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Price[] newArray(int i) {
                return new Price[i];
            }
        }

        public Price(@Nullable String str, @NotNull String str2, @Nullable String str3) {
            Intrinsics.checkNotNullParameter(str2, "value");
            this.title = str;
            this.value = str2;
            this.metric = str3;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Nullable
        public final String getMetric() {
            return this.metric;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        @NotNull
        public final String getValue() {
            return this.value;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.title);
            parcel.writeString(this.value);
            parcel.writeString(this.metric);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001BC\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000fR\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\r\u001a\u0004\b\u001a\u0010\u000fR\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\r\u001a\u0004\b\u001c\u0010\u000f¨\u0006\u001f"}, d2 = {"Lcom/avito/android/remote/model/adverts/MyAdvertDetails$Seller;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "name", "getName", ErrorBundle.SUMMARY_ENTRY, "getSummary", "Lcom/avito/android/remote/model/Image;", "image", "Lcom/avito/android/remote/model/Image;", "getImage", "()Lcom/avito/android/remote/model/Image;", "postfix", "getPostfix", "manager", "getManager", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;Ljava/lang/String;)V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
    public static final class Seller implements Parcelable {
        public static final Parcelable.Creator<Seller> CREATOR = new Creator();
        @SerializedName("images")
        @Nullable
        private final Image image;
        @SerializedName("manager")
        @Nullable
        private final String manager;
        @SerializedName("name")
        @Nullable
        private final String name;
        @SerializedName("postfix")
        @Nullable
        private final String postfix;
        @SerializedName(ErrorBundle.SUMMARY_ENTRY)
        @Nullable
        private final String summary;
        @SerializedName("title")
        @Nullable
        private final String title;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Seller> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Seller createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Seller(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), (Image) parcel.readParcelable(Seller.class.getClassLoader()), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Seller[] newArray(int i) {
                return new Seller[i];
            }
        }

        public Seller(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Image image2, @Nullable String str5) {
            this.title = str;
            this.name = str2;
            this.manager = str3;
            this.postfix = str4;
            this.image = image2;
            this.summary = str5;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Nullable
        public final Image getImage() {
            return this.image;
        }

        @Nullable
        public final String getManager() {
            return this.manager;
        }

        @Nullable
        public final String getName() {
            return this.name;
        }

        @Nullable
        public final String getPostfix() {
            return this.postfix;
        }

        @Nullable
        public final String getSummary() {
            return this.summary;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.title);
            parcel.writeString(this.name);
            parcel.writeString(this.manager);
            parcel.writeString(this.postfix);
            parcel.writeParcelable(this.image, i);
            parcel.writeString(this.summary);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/avito/android/remote/model/adverts/MyAdvertDetails$Shop;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "id", "getId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
    public static final class Shop implements Parcelable {
        public static final Parcelable.Creator<Shop> CREATOR = new Creator();
        @SerializedName("id")
        @NotNull
        private final String id;
        @SerializedName("name")
        @Nullable
        private final String name;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Shop> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Shop createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Shop(parcel.readString(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Shop[] newArray(int i) {
                return new Shop[i];
            }
        }

        public Shop(@NotNull String str, @Nullable String str2) {
            Intrinsics.checkNotNullParameter(str, "id");
            this.id = str;
            this.name = str2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        public final String getId() {
            return this.id;
        }

        @Nullable
        public final String getName() {
            return this.name;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.id);
            parcel.writeString(this.name);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001:\u0003!\"#B-\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001b\u001a\u00020\u001a8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006$"}, d2 = {"Lcom/avito/android/remote/model/adverts/MyAdvertDetails$Stats;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "Lcom/avito/android/remote/model/adverts/MyAdvertDetails$Stats$Contacts;", "contacts", "Lcom/avito/android/remote/model/adverts/MyAdvertDetails$Stats$Contacts;", "getContacts", "()Lcom/avito/android/remote/model/adverts/MyAdvertDetails$Stats$Contacts;", "Lcom/avito/android/remote/model/adverts/MyAdvertDetails$Stats$Favorites;", FavoritesContract.TABLE_NAME, "Lcom/avito/android/remote/model/adverts/MyAdvertDetails$Stats$Favorites;", "getFavorites", "()Lcom/avito/android/remote/model/adverts/MyAdvertDetails$Stats$Favorites;", "Lcom/avito/android/remote/model/adverts/MyAdvertDetails$Stats$Views;", "views", "Lcom/avito/android/remote/model/adverts/MyAdvertDetails$Stats$Views;", "getViews", "()Lcom/avito/android/remote/model/adverts/MyAdvertDetails$Stats$Views;", "<init>", "(Lcom/avito/android/remote/model/adverts/MyAdvertDetails$Stats$Views;Lcom/avito/android/remote/model/adverts/MyAdvertDetails$Stats$Favorites;Lcom/avito/android/deep_linking/links/DeepLink;Lcom/avito/android/remote/model/adverts/MyAdvertDetails$Stats$Contacts;)V", "Contacts", "Favorites", "Views", "user-advert_release"}, k = 1, mv = {1, 4, 2})
    public static final class Stats implements Parcelable {
        public static final Parcelable.Creator<Stats> CREATOR = new Creator();
        @SerializedName("contacts")
        @Nullable
        private final Contacts contacts;
        @SerializedName(ShareConstants.MEDIA_URI)
        @Nullable
        private final DeepLink deepLink;
        @SerializedName(FavoritesContract.TABLE_NAME)
        @Nullable
        private final Favorites favorites;
        @SerializedName("views")
        @NotNull
        private final Views views;

        @Parcelize
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u0004R\u001c\u0010\u000e\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\f\u001a\u0004\b\u000f\u0010\u0004¨\u0006\u0012"}, d2 = {"Lcom/avito/android/remote/model/adverts/MyAdvertDetails$Stats$Contacts;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "total", "I", "getTotal", "today", "getToday", "<init>", "(II)V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
        public static final class Contacts implements Parcelable {
            public static final Parcelable.Creator<Contacts> CREATOR = new Creator();
            @SerializedName("today")
            private final int today;
            @SerializedName("total")
            private final int total;

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<Contacts> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Contacts createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    return new Contacts(parcel.readInt(), parcel.readInt());
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Contacts[] newArray(int i) {
                    return new Contacts[i];
                }
            }

            public Contacts(int i, int i2) {
                this.total = i;
                this.today = i2;
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public final int getToday() {
                return this.today;
            }

            public final int getTotal() {
                return this.total;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(@NotNull Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.writeInt(this.total);
                parcel.writeInt(this.today);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Stats> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Stats createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                Views createFromParcel = Views.CREATOR.createFromParcel(parcel);
                Contacts contacts = null;
                Favorites createFromParcel2 = parcel.readInt() != 0 ? Favorites.CREATOR.createFromParcel(parcel) : null;
                DeepLink deepLink = (DeepLink) parcel.readParcelable(Stats.class.getClassLoader());
                if (parcel.readInt() != 0) {
                    contacts = Contacts.CREATOR.createFromParcel(parcel);
                }
                return new Stats(createFromParcel, createFromParcel2, deepLink, contacts);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Stats[] newArray(int i) {
                return new Stats[i];
            }
        }

        @Parcelize
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u0004¨\u0006\u0010"}, d2 = {"Lcom/avito/android/remote/model/adverts/MyAdvertDetails$Stats$Favorites;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "total", "I", "getTotal", "<init>", "(I)V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
        public static final class Favorites implements Parcelable {
            public static final Parcelable.Creator<Favorites> CREATOR = new Creator();
            @SerializedName("total")
            private final int total;

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<Favorites> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Favorites createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    return new Favorites(parcel.readInt());
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Favorites[] newArray(int i) {
                    return new Favorites[i];
                }
            }

            public Favorites(int i) {
                this.total = i;
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public final int getTotal() {
                return this.total;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(@NotNull Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.writeInt(this.total);
            }
        }

        @Parcelize
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0004¨\u0006\u0014"}, d2 = {"Lcom/avito/android/remote/model/adverts/MyAdvertDetails$Stats$Views;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "today", "Ljava/lang/Integer;", "getToday", "()Ljava/lang/Integer;", "total", "I", "getTotal", "<init>", "(ILjava/lang/Integer;)V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
        public static final class Views implements Parcelable {
            public static final Parcelable.Creator<Views> CREATOR = new Creator();
            @SerializedName("today")
            @Nullable
            private final Integer today;
            @SerializedName("total")
            private final int total;

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<Views> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Views createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    return new Views(parcel.readInt(), parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null);
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Views[] newArray(int i) {
                    return new Views[i];
                }
            }

            public Views(int i, @Nullable Integer num) {
                this.total = i;
                this.today = num;
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Nullable
            public final Integer getToday() {
                return this.today;
            }

            public final int getTotal() {
                return this.total;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(@NotNull Parcel parcel, int i) {
                int i2;
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.writeInt(this.total);
                Integer num = this.today;
                if (num != null) {
                    parcel.writeInt(1);
                    i2 = num.intValue();
                } else {
                    i2 = 0;
                }
                parcel.writeInt(i2);
            }
        }

        public Stats(@NotNull Views views2, @Nullable Favorites favorites2, @Nullable DeepLink deepLink2, @Nullable Contacts contacts2) {
            Intrinsics.checkNotNullParameter(views2, "views");
            this.views = views2;
            this.favorites = favorites2;
            this.deepLink = deepLink2;
            this.contacts = contacts2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Nullable
        public final Contacts getContacts() {
            return this.contacts;
        }

        @Nullable
        public final DeepLink getDeepLink() {
            return this.deepLink;
        }

        @Nullable
        public final Favorites getFavorites() {
            return this.favorites;
        }

        @NotNull
        public final Views getViews() {
            return this.views;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            this.views.writeToParcel(parcel, 0);
            Favorites favorites2 = this.favorites;
            if (favorites2 != null) {
                parcel.writeInt(1);
                favorites2.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            parcel.writeParcelable(this.deepLink, i);
            Contacts contacts2 = this.contacts;
            if (contacts2 != null) {
                parcel.writeInt(1);
                contacts2.writeToParcel(parcel, 0);
                return;
            }
            parcel.writeInt(0);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/remote/model/adverts/MyAdvertDetails$Style;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", SberbankOnlineKt.RESULT_SUCCESS, "NORMAL", "WARNING", "user-advert_release"}, k = 1, mv = {1, 4, 2})
    public enum Style {
        SUCCESS("success"),
        NORMAL("normal"),
        WARNING("warning");
        
        @NotNull
        private final String value;

        private Style(String str) {
            this.value = str;
        }

        @NotNull
        public final String getValue() {
            return this.value;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00068&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/remote/model/adverts/MyAdvertDetails$Switcher;", "Landroid/os/Parcelable;", "Lcom/avito/android/remote/model/text/AttributedText;", "getSubtitle", "()Lcom/avito/android/remote/model/text/AttributedText;", MessengerShareContentUtility.SUBTITLE, "", "getValue", "()Ljava/lang/Boolean;", "setValue", "(Ljava/lang/Boolean;)V", "value", "", "getId", "()Ljava/lang/String;", "id", "getTitle", "title", "user-advert_release"}, k = 1, mv = {1, 4, 2})
    public interface Switcher extends Parcelable {
        @NotNull
        String getId();

        @Nullable
        AttributedText getSubtitle();

        @NotNull
        String getTitle();

        @Nullable
        Boolean getValue();

        void setValue(@Nullable Boolean bool);
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010)\u001a\u0004\u0018\u00010$\u0012\b\u0010%\u001a\u0004\u0018\u00010$\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b+\u0010,J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0016\u001a\u00020\u00158\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010 \u001a\u00020\u001f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001e\u0010%\u001a\u0004\u0018\u00010$8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001e\u0010)\u001a\u0004\u0018\u00010$8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b)\u0010&\u001a\u0004\b*\u0010(¨\u0006-"}, d2 = {"Lcom/avito/android/remote/model/adverts/MyAdvertDetails$VasBundlesBanner;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "dueDate", "Ljava/lang/Long;", "getDueDate", "()Ljava/lang/Long;", "Lcom/avito/android/remote/model/UniversalImage;", "image", "Lcom/avito/android/remote/model/UniversalImage;", "getImage", "()Lcom/avito/android/remote/model/UniversalImage;", "", "closable", "Z", "getClosable", "()Z", "Lcom/avito/android/deep_linking/links/DeepLink;", ShareConstants.MEDIA_URI, "Lcom/avito/android/deep_linking/links/DeepLink;", "getUri", "()Lcom/avito/android/deep_linking/links/DeepLink;", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/UniversalColor;", "backgroundRippleColor", "Lcom/avito/android/remote/model/UniversalColor;", "getBackgroundRippleColor", "()Lcom/avito/android/remote/model/UniversalColor;", "backgroundColor", "getBackgroundColor", "<init>", "(Ljava/lang/String;ZLjava/lang/Long;Lcom/avito/android/remote/model/UniversalColor;Lcom/avito/android/remote/model/UniversalColor;Lcom/avito/android/deep_linking/links/DeepLink;Lcom/avito/android/remote/model/UniversalImage;)V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
    public static final class VasBundlesBanner implements Parcelable {
        public static final Parcelable.Creator<VasBundlesBanner> CREATOR = new Creator();
        @SerializedName("backgroundColor")
        @Nullable
        private final UniversalColor backgroundColor;
        @SerializedName("backgroundRippleColor")
        @Nullable
        private final UniversalColor backgroundRippleColor;
        @SerializedName("closable")
        private final boolean closable;
        @SerializedName("dueDate")
        @Nullable
        private final Long dueDate;
        @SerializedName("image")
        @Nullable
        private final UniversalImage image;
        @SerializedName("title")
        @NotNull
        private final String title;
        @SerializedName(ShareConstants.MEDIA_URI)
        @Nullable
        private final DeepLink uri;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<VasBundlesBanner> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final VasBundlesBanner createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new VasBundlesBanner(parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null, (UniversalColor) parcel.readParcelable(VasBundlesBanner.class.getClassLoader()), (UniversalColor) parcel.readParcelable(VasBundlesBanner.class.getClassLoader()), (DeepLink) parcel.readParcelable(VasBundlesBanner.class.getClassLoader()), (UniversalImage) parcel.readParcelable(VasBundlesBanner.class.getClassLoader()));
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final VasBundlesBanner[] newArray(int i) {
                return new VasBundlesBanner[i];
            }
        }

        public VasBundlesBanner(@NotNull String str, boolean z, @Nullable Long l, @Nullable UniversalColor universalColor, @Nullable UniversalColor universalColor2, @Nullable DeepLink deepLink, @Nullable UniversalImage universalImage) {
            Intrinsics.checkNotNullParameter(str, "title");
            this.title = str;
            this.closable = z;
            this.dueDate = l;
            this.backgroundColor = universalColor;
            this.backgroundRippleColor = universalColor2;
            this.uri = deepLink;
            this.image = universalImage;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Nullable
        public final UniversalColor getBackgroundColor() {
            return this.backgroundColor;
        }

        @Nullable
        public final UniversalColor getBackgroundRippleColor() {
            return this.backgroundRippleColor;
        }

        public final boolean getClosable() {
            return this.closable;
        }

        @Nullable
        public final Long getDueDate() {
            return this.dueDate;
        }

        @Nullable
        public final UniversalImage getImage() {
            return this.image;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        public final DeepLink getUri() {
            return this.uri;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.title);
            parcel.writeInt(this.closable ? 1 : 0);
            Long l = this.dueDate;
            if (l != null) {
                a.I0(parcel, 1, l);
            } else {
                parcel.writeInt(0);
            }
            parcel.writeParcelable(this.backgroundColor, i);
            parcel.writeParcelable(this.backgroundRippleColor, i);
            parcel.writeParcelable(this.uri, i);
            parcel.writeParcelable(this.image, i);
        }
    }

    public MyAdvertDetails(@NotNull String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @NotNull String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable List<GeoReference> list, @NotNull String str10, @NotNull String str11, @Nullable String str12, @Nullable String str13, long j, @Nullable String str14, @Nullable String str15, @Nullable Coordinates coordinates2, @Nullable AdvertSharing advertSharing, @Nullable List<Action> list2, @Nullable String str16, @Nullable String str17, @Nullable AnonymousNumber anonymousNumber2, boolean z, @Nullable AdvertDeliveryC2C advertDeliveryC2C, @NotNull String str18, @Nullable Seller seller2, @Nullable String str19, @Nullable MyAdvertVas myAdvertVas, @Nullable Shop shop2, @Nullable VasBundlesBanner vasBundlesBanner2, @Nullable AlertBanner alertBanner2, @Nullable AdvertParameters advertParameters, @Nullable List<ExtendedImage> list3, @Nullable Video video2, @NotNull String str20, @Nullable Price price2, @Nullable Stats stats2, @Nullable String str21, @Nullable List<RejectReason> list4, @Nullable String str22, @Nullable ActivationInfo activationInfo2, @Nullable AdvertSellerShortTermRent advertSellerShortTermRent, @Nullable AppliedServicesInfo appliedServicesInfo, @Nullable PriceBadge priceBadge2, @Nullable ContractInfo contractInfo, @Nullable Verification verification2, @Nullable MyAdvertSafeDeal myAdvertSafeDeal, @Nullable AdvertDetailsFeaturesTeasers advertDetailsFeaturesTeasers, @Nullable List<ApartmentFeature> list5, @NotNull AutoPublish autoPublish2, @Nullable AutoBooking autoBooking2, @Nullable ForegroundImage foregroundImage, @Nullable UserOrderStatus userOrderStatus, @Nullable CarMarketPrice carMarketPrice2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str6, "categoryId");
        Intrinsics.checkNotNullParameter(str10, "title");
        Intrinsics.checkNotNullParameter(str11, "toolbarTitle");
        Intrinsics.checkNotNullParameter(str18, "userType");
        Intrinsics.checkNotNullParameter(str20, "status");
        Intrinsics.checkNotNullParameter(autoPublish2, "autoPublish");
        this.id = str;
        this.locationName = str2;
        this.metroName = str3;
        this.districtName = str4;
        this.directionName = str5;
        this.categoryId = str6;
        this.locationId = str7;
        this.metroId = str8;
        this.address = str9;
        this.geoReferences = list;
        this.title = str10;
        this.toolbarTitle = str11;
        this.directionId = str12;
        this.districtId = str13;
        this.time = j;
        this.ttlHumanized = str14;
        this.wizardId = str15;
        this.coordinates = coordinates2;
        this.sharing = advertSharing;
        this.actions = list2;
        this.description = str16;
        this.descriptionHtml = str17;
        this.anonymousNumber = anonymousNumber2;
        this.isDeliveryEnabled = z;
        this.delivery = advertDeliveryC2C;
        this.userType = str18;
        this.seller = seller2;
        this.phone = str19;
        this.vas = myAdvertVas;
        this.shop = shop2;
        this.vasBundlesBanner = vasBundlesBanner2;
        this.alertBanner = alertBanner2;
        this.parameters = advertParameters;
        this.images = list3;
        this.video = video2;
        this.status = str20;
        this.price = price2;
        this.stats = stats2;
        this.reasonsTitle = str21;
        this.reasons = list4;
        this.moderationInfo = str22;
        this.activationInfo = activationInfo2;
        this.shortTermRent = advertSellerShortTermRent;
        this.appliedServices = appliedServicesInfo;
        this.priceBadge = priceBadge2;
        this.contract = contractInfo;
        this.verification = verification2;
        this.safeDealServices = myAdvertSafeDeal;
        this.teasers = advertDetailsFeaturesTeasers;
        this.apartmentFeatures = list5;
        this.autoPublish = autoPublish2;
        this.autoBooking = autoBooking2;
        this.infoImage = foregroundImage;
        this.orderStatus = userOrderStatus;
        this.carMarketPrice = carMarketPrice2;
    }

    @Nullable
    public final List<Action> getActions() {
        return this.actions;
    }

    @Nullable
    public final ActivationInfo getActivationInfo() {
        return this.activationInfo;
    }

    @Nullable
    public final String getAddress() {
        return this.address;
    }

    @Nullable
    public final AlertBanner getAlertBanner() {
        return this.alertBanner;
    }

    @Nullable
    public final AnonymousNumber getAnonymousNumber() {
        return this.anonymousNumber;
    }

    @Nullable
    public final List<ApartmentFeature> getApartmentFeatures() {
        return this.apartmentFeatures;
    }

    @Nullable
    public final AppliedServicesInfo getAppliedServices() {
        return this.appliedServices;
    }

    @Nullable
    public final AutoBooking getAutoBooking() {
        return this.autoBooking;
    }

    @NotNull
    public final AutoPublish getAutoPublish() {
        return this.autoPublish;
    }

    @Nullable
    public final CarMarketPrice getCarMarketPrice() {
        return this.carMarketPrice;
    }

    @NotNull
    public final String getCategoryId() {
        return this.categoryId;
    }

    @Nullable
    public final ContractInfo getContract() {
        return this.contract;
    }

    @Nullable
    public final Coordinates getCoordinates() {
        return this.coordinates;
    }

    @Nullable
    public final AdvertDeliveryC2C getDelivery() {
        return this.delivery;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final String getDescriptionHtml() {
        return this.descriptionHtml;
    }

    @Nullable
    public final String getDirectionId() {
        return this.directionId;
    }

    @Nullable
    public final String getDirectionName() {
        return this.directionName;
    }

    @Nullable
    public final String getDistrictId() {
        return this.districtId;
    }

    @Nullable
    public final String getDistrictName() {
        return this.districtName;
    }

    @Nullable
    public final List<GeoReference> getGeoReferences() {
        return this.geoReferences;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final List<ExtendedImage> getImages() {
        return this.images;
    }

    @Nullable
    public final ForegroundImage getInfoImage() {
        return this.infoImage;
    }

    @Nullable
    public final String getLocationId() {
        return this.locationId;
    }

    @Nullable
    public final String getLocationName() {
        return this.locationName;
    }

    @Nullable
    public final String getMetroId() {
        return this.metroId;
    }

    @Nullable
    public final String getMetroName() {
        return this.metroName;
    }

    @Nullable
    public final String getModerationInfo() {
        return this.moderationInfo;
    }

    @Nullable
    public final UserOrderStatus getOrderStatus() {
        return this.orderStatus;
    }

    @Nullable
    public final AdvertParameters getParameters() {
        return this.parameters;
    }

    @Nullable
    public final String getPhone() {
        return this.phone;
    }

    @Nullable
    public final Price getPrice() {
        return this.price;
    }

    @Nullable
    public final PriceBadge getPriceBadge() {
        return this.priceBadge;
    }

    @Nullable
    public final List<RejectReason> getReasons() {
        return this.reasons;
    }

    @Nullable
    public final String getReasonsTitle() {
        return this.reasonsTitle;
    }

    @Nullable
    public final MyAdvertSafeDeal getSafeDealServices() {
        return this.safeDealServices;
    }

    @Nullable
    public final Seller getSeller() {
        return this.seller;
    }

    @Nullable
    public final AdvertSharing getSharing() {
        return this.sharing;
    }

    @Nullable
    public final Shop getShop() {
        return this.shop;
    }

    @Nullable
    public final AdvertSellerShortTermRent getShortTermRent() {
        return this.shortTermRent;
    }

    @Nullable
    public final Stats getStats() {
        return this.stats;
    }

    @NotNull
    public final String getStatus() {
        return this.status;
    }

    @Nullable
    public final AdvertDetailsFeaturesTeasers getTeasers() {
        return this.teasers;
    }

    public final long getTime() {
        return this.time;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getToolbarTitle() {
        return this.toolbarTitle;
    }

    @Nullable
    public final String getTtlHumanized() {
        return this.ttlHumanized;
    }

    @NotNull
    public final String getUserType() {
        return this.userType;
    }

    @Nullable
    public final MyAdvertVas getVas() {
        return this.vas;
    }

    @Nullable
    public final VasBundlesBanner getVasBundlesBanner() {
        return this.vasBundlesBanner;
    }

    @Nullable
    public final Verification getVerification() {
        return this.verification;
    }

    @Nullable
    public final Video getVideo() {
        return this.video;
    }

    @Nullable
    public final String getWizardId() {
        return this.wizardId;
    }

    public final boolean isDeliveryEnabled() {
        return this.isDeliveryEnabled;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MyAdvertDetails(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, List list, String str10, String str11, String str12, String str13, long j, String str14, String str15, Coordinates coordinates2, AdvertSharing advertSharing, List list2, String str16, String str17, AnonymousNumber anonymousNumber2, boolean z, AdvertDeliveryC2C advertDeliveryC2C, String str18, Seller seller2, String str19, MyAdvertVas myAdvertVas, Shop shop2, VasBundlesBanner vasBundlesBanner2, AlertBanner alertBanner2, AdvertParameters advertParameters, List list3, Video video2, String str20, Price price2, Stats stats2, String str21, List list4, String str22, ActivationInfo activationInfo2, AdvertSellerShortTermRent advertSellerShortTermRent, AppliedServicesInfo appliedServicesInfo, PriceBadge priceBadge2, ContractInfo contractInfo, Verification verification2, MyAdvertSafeDeal myAdvertSafeDeal, AdvertDetailsFeaturesTeasers advertDetailsFeaturesTeasers, List list5, AutoPublish autoPublish2, AutoBooking autoBooking2, ForegroundImage foregroundImage, UserOrderStatus userOrderStatus, CarMarketPrice carMarketPrice2, int i, int i2, j jVar) {
        this(str, str2, str3, str4, str5, str6, str7, str8, str9, list, str10, str11, str12, str13, j, str14, str15, coordinates2, advertSharing, list2, str16, str17, anonymousNumber2, z, advertDeliveryC2C, str18, seller2, str19, myAdvertVas, shop2, vasBundlesBanner2, alertBanner2, advertParameters, list3, video2, str20, price2, stats2, str21, list4, str22, activationInfo2, advertSellerShortTermRent, appliedServicesInfo, priceBadge2, (i2 & 8192) != 0 ? null : contractInfo, (i2 & 16384) != 0 ? null : verification2, myAdvertSafeDeal, (65536 & i2) != 0 ? null : advertDetailsFeaturesTeasers, (131072 & i2) != 0 ? null : list5, (262144 & i2) != 0 ? new AutoPublish(null, 1, null) : autoPublish2, (524288 & i2) != 0 ? null : autoBooking2, (1048576 & i2) != 0 ? null : foregroundImage, (2097152 & i2) != 0 ? null : userOrderStatus, (i2 & 4194304) != 0 ? null : carMarketPrice2);
    }
}
