package com.avito.android.user_advert.advert;

import a2.b.a.a.a;
import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.html_formatter.HtmlCharSequence;
import com.avito.android.remote.auth.AuthSource;
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
import com.avito.android.remote.model.Verification;
import com.avito.android.remote.model.Video;
import com.avito.android.remote.model.adverts.MyAdvertDetails;
import com.avito.android.remote.model.feature_teaser.AdvertDetailsFeaturesTeasers;
import com.avito.android.remote.model.feature_teaser.ApartmentFeature;
import com.avito.android.remote.model.my_advert.AppliedServicesInfo;
import com.avito.android.remote.model.user_adverts.UserOrderStatus;
import com.avito.android.util.Constants;
import com.avito.android.util.UrlParams;
import com.facebook.appevents.integrity.IntegrityManager;
import com.vk.sdk.api.VKApiConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¼\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001Bô\u0004\u0012\u0006\u00107\u001a\u00020\u000b\u0012\t\u0010à\u0001\u001a\u0004\u0018\u00010\u000b\u0012\t\u0010\u0001\u001a\u0004\u0018\u00010\u000b\u0012\b\u00104\u001a\u0004\u0018\u00010\u000b\u0012\t\u0010Ó\u0001\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010w\u001a\u0004\u0018\u00010\u000b\u0012\t\u0010ã\u0001\u001a\u0004\u0018\u00010\u000b\u0012\t\u0010¸\u0001\u001a\u0004\u0018\u00010\u000b\u0012\u0011\u0010\u0001\u001a\f\u0012\u0005\u0012\u00030\u0001\u0018\u00010\u0001\u0012\u0007\u0010\u0001\u001a\u00020\u000b\u0012\u0006\u0010h\u001a\u00020\u000b\u0012\n\u0010Ý\u0001\u001a\u0005\u0018\u00010Ø\u0001\u0012\t\u0010\u0001\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010z\u001a\u0004\u0018\u00010\u000b\u0012\n\u0010¾\u0001\u001a\u0005\u0018\u00010¹\u0001\u0012\b\u0010n\u001a\u0004\u0018\u00010i\u0012\u000f\u0010×\u0001\u001a\n\u0012\u0005\u0012\u00030Ô\u00010\u0001\u0012\n\u0010Ä\u0001\u001a\u0005\u0018\u00010¿\u0001\u0012\n\u0010é\u0001\u001a\u0005\u0018\u00010ä\u0001\u0012\u0007\u0010\u0001\u001a\u00020D\u0012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001\u0012\u0007\u0010ì\u0001\u001a\u00020\u000b\u0012\b\u0010%\u001a\u0004\u0018\u00010 \u0012\t\u0010\u0001\u001a\u0004\u0018\u00010\u000b\u0012\n\u0010\u0002\u001a\u0005\u0018\u00010ý\u0001\u0012\b\u0010=\u001a\u0004\u0018\u000108\u0012\n\u0010Ê\u0001\u001a\u0005\u0018\u00010Å\u0001\u0012\b\u0010e\u001a\u0004\u0018\u00010`\u0012\b\u0010+\u001a\u0004\u0018\u00010&\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0011\u0012\u000f\u0010ö\u0001\u001a\n\u0012\u0005\u0012\u00030ó\u00010\u0001\u0012\n\u0010ò\u0001\u001a\u0005\u0018\u00010í\u0001\u0012\u0007\u0010ª\u0001\u001a\u00020\u000b\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0017\u0012\n\u0010\u0002\u001a\u0005\u0018\u00010\u0002\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u000b\u0012\u0011\u0010\u0002\u001a\f\u0012\u0005\u0012\u00030\u0002\u0018\u00010\u0001\u0012\b\u0010S\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010G\u001a\u00020D\u0012\u0006\u0010J\u001a\u00020D\u0012\n\u0010¥\u0001\u001a\u0005\u0018\u00010 \u0001\u0012\n\u0010ü\u0001\u001a\u0005\u0018\u00010÷\u0001\u0012\b\u0010_\u001a\u0004\u0018\u00010Z\u0012\b\u0010t\u001a\u0004\u0018\u00010o\u0012\b\u0010Y\u001a\u0004\u0018\u00010T\u0012\t\u0010\u0001\u001a\u0004\u0018\u00010{\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010,\u0012\u0013\b\u0002\u0010\u0001\u001a\f\u0012\u0005\u0012\u00030\u0001\u0018\u00010\u0001\u0012\n\b\u0002\u0010P\u001a\u0004\u0018\u00010K\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010>\u0012\f\b\u0002\u0010µ\u0001\u001a\u0005\u0018\u00010±\u0001\u0012\f\b\u0002\u0010Ð\u0001\u001a\u0005\u0018\u00010Ë\u0001\u0012\f\b\u0002\u0010°\u0001\u001a\u0005\u0018\u00010«\u0001¢\u0006\u0006\b\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\r\u001a\u0004\b\u001e\u0010\u000fR\u001b\u0010%\u001a\u0004\u0018\u00010 8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001b\u0010+\u001a\u0004\u0018\u00010&8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001b\u00101\u001a\u0004\u0018\u00010,8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u001b\u00104\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b2\u0010\r\u001a\u0004\b3\u0010\u000fR\u0019\u00107\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b5\u0010\r\u001a\u0004\b6\u0010\u000fR\u001b\u0010=\u001a\u0004\u0018\u0001088\u0006@\u0006¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\u001b\u0010C\u001a\u0004\u0018\u00010>8\u0006@\u0006¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR\u0019\u0010G\u001a\u00020D8\u0006@\u0006¢\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010HR\u0019\u0010J\u001a\u00020D8\u0006@\u0006¢\u0006\f\n\u0004\bI\u0010F\u001a\u0004\bJ\u0010HR\u001b\u0010P\u001a\u0004\u0018\u00010K8\u0006@\u0006¢\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bN\u0010OR\u001b\u0010S\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\bQ\u0010\r\u001a\u0004\bR\u0010\u000fR\u001b\u0010Y\u001a\u0004\u0018\u00010T8\u0006@\u0006¢\u0006\f\n\u0004\bU\u0010V\u001a\u0004\bW\u0010XR\u001b\u0010_\u001a\u0004\u0018\u00010Z8\u0006@\u0006¢\u0006\f\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^R\u001b\u0010e\u001a\u0004\u0018\u00010`8\u0006@\u0006¢\u0006\f\n\u0004\ba\u0010b\u001a\u0004\bc\u0010dR\u0019\u0010h\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\bf\u0010\r\u001a\u0004\bg\u0010\u000fR\u001b\u0010n\u001a\u0004\u0018\u00010i8\u0006@\u0006¢\u0006\f\n\u0004\bj\u0010k\u001a\u0004\bl\u0010mR\u001b\u0010t\u001a\u0004\u0018\u00010o8\u0006@\u0006¢\u0006\f\n\u0004\bp\u0010q\u001a\u0004\br\u0010sR\u001b\u0010w\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\bu\u0010\r\u001a\u0004\bv\u0010\u000fR\u001b\u0010z\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\bx\u0010\r\u001a\u0004\by\u0010\u000fR\u001c\u0010\u0001\u001a\u0004\u0018\u00010{8\u0006@\u0006¢\u0006\f\n\u0004\b|\u0010}\u001a\u0004\b~\u0010R\u001c\u0010\u0001\u001a\u00020D8\u0006@\u0006¢\u0006\u000e\n\u0005\b\u0001\u0010F\u001a\u0005\b\u0001\u0010HR\u001e\u0010\u0001\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\u000e\n\u0005\b\u0001\u0010\r\u001a\u0005\b\u0001\u0010\u000fR(\u0010\u0001\u001a\f\u0012\u0005\u0012\u00030\u0001\u0018\u00010\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001R\u001e\u0010\u0001\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\u000e\n\u0005\b\u0001\u0010\r\u001a\u0005\b\u0001\u0010\u000fR(\u0010\u0001\u001a\f\u0012\u0005\u0012\u00030\u0001\u0018\u00010\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001R!\u0010\u0001\u001a\u0005\u0018\u00010\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001R\u001c\u0010\u0001\u001a\u00020\u000b8\u0006@\u0006¢\u0006\u000e\n\u0005\b\u0001\u0010\r\u001a\u0005\b\u0001\u0010\u000fR\u001e\u0010\u0001\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\u000e\n\u0005\b\u0001\u0010\r\u001a\u0005\b\u0001\u0010\u000fR!\u0010¥\u0001\u001a\u0005\u0018\u00010 \u00018\u0006@\u0006¢\u0006\u0010\n\u0006\b¡\u0001\u0010¢\u0001\u001a\u0006\b£\u0001\u0010¤\u0001R'\u0010ª\u0001\u001a\u00020\u000b8\u0006@\u0006X\u000e¢\u0006\u0016\n\u0005\b¦\u0001\u0010\r\u001a\u0005\b§\u0001\u0010\u000f\"\u0006\b¨\u0001\u0010©\u0001R!\u0010°\u0001\u001a\u0005\u0018\u00010«\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\b¬\u0001\u0010­\u0001\u001a\u0006\b®\u0001\u0010¯\u0001R \u0010µ\u0001\u001a\u0005\u0018\u00010±\u00018\u0006@\u0006¢\u0006\u000f\n\u0005\bF\u0010²\u0001\u001a\u0006\b³\u0001\u0010´\u0001R\u001e\u0010¸\u0001\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\u000e\n\u0005\b¶\u0001\u0010\r\u001a\u0005\b·\u0001\u0010\u000fR!\u0010¾\u0001\u001a\u0005\u0018\u00010¹\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\bº\u0001\u0010»\u0001\u001a\u0006\b¼\u0001\u0010½\u0001R!\u0010Ä\u0001\u001a\u0005\u0018\u00010¿\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\bÀ\u0001\u0010Á\u0001\u001a\u0006\bÂ\u0001\u0010Ã\u0001R!\u0010Ê\u0001\u001a\u0005\u0018\u00010Å\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\bÆ\u0001\u0010Ç\u0001\u001a\u0006\bÈ\u0001\u0010É\u0001R!\u0010Ð\u0001\u001a\u0005\u0018\u00010Ë\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\bÌ\u0001\u0010Í\u0001\u001a\u0006\bÎ\u0001\u0010Ï\u0001R\u001e\u0010Ó\u0001\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\u000e\n\u0005\bÑ\u0001\u0010\r\u001a\u0005\bÒ\u0001\u0010\u000fR&\u0010×\u0001\u001a\n\u0012\u0005\u0012\u00030Ô\u00010\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\bÕ\u0001\u0010\u0001\u001a\u0006\bÖ\u0001\u0010\u0001R!\u0010Ý\u0001\u001a\u0005\u0018\u00010Ø\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\bÙ\u0001\u0010Ú\u0001\u001a\u0006\bÛ\u0001\u0010Ü\u0001R\u001e\u0010à\u0001\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\u000e\n\u0005\bÞ\u0001\u0010\r\u001a\u0005\bß\u0001\u0010\u000fR\u001e\u0010ã\u0001\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\u000e\n\u0005\bá\u0001\u0010\r\u001a\u0005\bâ\u0001\u0010\u000fR!\u0010é\u0001\u001a\u0005\u0018\u00010ä\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\bå\u0001\u0010æ\u0001\u001a\u0006\bç\u0001\u0010è\u0001R\u001c\u0010ì\u0001\u001a\u00020\u000b8\u0006@\u0006¢\u0006\u000e\n\u0005\bê\u0001\u0010\r\u001a\u0005\bë\u0001\u0010\u000fR!\u0010ò\u0001\u001a\u0005\u0018\u00010í\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\bî\u0001\u0010ï\u0001\u001a\u0006\bð\u0001\u0010ñ\u0001R&\u0010ö\u0001\u001a\n\u0012\u0005\u0012\u00030ó\u00010\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\bô\u0001\u0010\u0001\u001a\u0006\bõ\u0001\u0010\u0001R!\u0010ü\u0001\u001a\u0005\u0018\u00010÷\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\bø\u0001\u0010ù\u0001\u001a\u0006\bú\u0001\u0010û\u0001R!\u0010\u0002\u001a\u0005\u0018\u00010ý\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\bþ\u0001\u0010ÿ\u0001\u001a\u0006\b\u0002\u0010\u0002R!\u0010\u0002\u001a\u0005\u0018\u00010\u00028\u0006@\u0006¢\u0006\u0010\n\u0006\b\u0002\u0010\u0002\u001a\u0006\b\u0002\u0010\u0002R(\u0010\u0002\u001a\f\u0012\u0005\u0012\u00030\u0002\u0018\u00010\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\b\u0002\u0010\u0001\u001a\u0006\b\u0002\u0010\u0001¨\u0006\u0002"}, d2 = {"Lcom/avito/android/user_advert/advert/MyAdvertDetailsItem;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "f", "Ljava/lang/String;", "getCategoryId", "()Ljava/lang/String;", "categoryId", "Lcom/avito/android/remote/model/AdvertParameters;", ExifInterface.LONGITUDE_EAST, "Lcom/avito/android/remote/model/AdvertParameters;", "getParameters", "()Lcom/avito/android/remote/model/AdvertParameters;", ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, "Lcom/avito/android/remote/model/adverts/MyAdvertDetails$Price;", "I", "Lcom/avito/android/remote/model/adverts/MyAdvertDetails$Price;", "getPrice", "()Lcom/avito/android/remote/model/adverts/MyAdvertDetails$Price;", "price", "K", "getReasonsTitle", "reasonsTitle", "Lcom/avito/android/remote/model/adverts/MyAdvertDetails$Seller;", "x", "Lcom/avito/android/remote/model/adverts/MyAdvertDetails$Seller;", "getSeller", "()Lcom/avito/android/remote/model/adverts/MyAdvertDetails$Seller;", "seller", "Lcom/avito/android/remote/model/adverts/MyAdvertDetails$AlertBanner;", "D", "Lcom/avito/android/remote/model/adverts/MyAdvertDetails$AlertBanner;", "getAlertBanner", "()Lcom/avito/android/remote/model/adverts/MyAdvertDetails$AlertBanner;", "alertBanner", "Lcom/avito/android/remote/model/feature_teaser/AdvertDetailsFeaturesTeasers;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lcom/avito/android/remote/model/feature_teaser/AdvertDetailsFeaturesTeasers;", "getTeasers", "()Lcom/avito/android/remote/model/feature_teaser/AdvertDetailsFeaturesTeasers;", "teasers", "d", "getDistrictName", "districtName", AuthSource.SEND_ABUSE, "getId", "id", "Lcom/avito/android/remote/model/adverts/MyAdvertDetails$ActivationInfo;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/avito/android/remote/model/adverts/MyAdvertDetails$ActivationInfo;", "getActivationInfo", "()Lcom/avito/android/remote/model/adverts/MyAdvertDetails$ActivationInfo;", "activationInfo", "Lcom/avito/android/remote/model/adverts/MyAdvertDetails$AutoBookingSwitcher;", "Y", "Lcom/avito/android/remote/model/adverts/MyAdvertDetails$AutoBookingSwitcher;", "getAutoBooking", "()Lcom/avito/android/remote/model/adverts/MyAdvertDetails$AutoBookingSwitcher;", "autoBooking", "", "N", "Z", "isCompany", "()Z", "O", "isShop", "Lcom/avito/android/remote/model/adverts/MyAdvertDetails$AutoPublishSwitcher;", "X", "Lcom/avito/android/remote/model/adverts/MyAdvertDetails$AutoPublishSwitcher;", "getAutoPublish", "()Lcom/avito/android/remote/model/adverts/MyAdvertDetails$AutoPublishSwitcher;", "autoPublish", "M", "getModerationInfo", "moderationInfo", "Lcom/avito/android/remote/model/Verification;", "T", "Lcom/avito/android/remote/model/Verification;", "getVerification", "()Lcom/avito/android/remote/model/Verification;", "verification", "Lcom/avito/android/remote/model/PriceBadge;", "R", "Lcom/avito/android/remote/model/PriceBadge;", "getPriceBadge", "()Lcom/avito/android/remote/model/PriceBadge;", "priceBadge", "Lcom/avito/android/remote/model/adverts/MyAdvertDetails$VasBundlesBanner;", "C", "Lcom/avito/android/remote/model/adverts/MyAdvertDetails$VasBundlesBanner;", "getVasBundlesBanner", "()Lcom/avito/android/remote/model/adverts/MyAdvertDetails$VasBundlesBanner;", "vasBundlesBanner", "l", "getToolbarTitle", "toolbarTitle", "Lcom/avito/android/remote/model/AdvertSharing;", VKApiConst.Q, "Lcom/avito/android/remote/model/AdvertSharing;", "getSharing", "()Lcom/avito/android/remote/model/AdvertSharing;", "sharing", "Lcom/avito/android/remote/model/ContractInfo;", ExifInterface.LATITUDE_SOUTH, "Lcom/avito/android/remote/model/ContractInfo;", "getContract", "()Lcom/avito/android/remote/model/ContractInfo;", "contract", g.a, "getLocationId", "locationId", "o", "getWizardId", ParameterId.EDIT, "Lcom/avito/android/remote/model/MyAdvertSafeDeal;", "U", "Lcom/avito/android/remote/model/MyAdvertSafeDeal;", "getSafeDealServices", "()Lcom/avito/android/remote/model/MyAdvertSafeDeal;", "safeDealServices", "u", "isDeliveryEnabled", "c", "getMetroName", "metroName", "", "Lcom/avito/android/remote/model/GeoReference;", "j", "Ljava/util/List;", "getGeoReferences", "()Ljava/util/List;", "geoReferences", "n", "getTtlHumanized", "ttlHumanized", "Lcom/avito/android/remote/model/feature_teaser/ApartmentFeature;", ExifInterface.LONGITUDE_WEST, "getApartmentFeatures", "apartmentFeatures", "Lcom/avito/android/remote/model/AdvertDeliveryC2C;", VKApiConst.VERSION, "Lcom/avito/android/remote/model/AdvertDeliveryC2C;", "getDelivery", "()Lcom/avito/android/remote/model/AdvertDeliveryC2C;", "delivery", "k", "getTitle", "title", "y", "getPhone", "phone", "Lcom/avito/android/remote/model/AdvertSellerShortTermRent;", "P", "Lcom/avito/android/remote/model/AdvertSellerShortTermRent;", "getShortTermRent", "()Lcom/avito/android/remote/model/AdvertSellerShortTermRent;", "shortTermRent", "H", "getStatus", "setStatus", "(Ljava/lang/String;)V", "status", "Lcom/avito/android/remote/model/CarMarketPrice;", "b0", "Lcom/avito/android/remote/model/CarMarketPrice;", "getCarMarketPrice", "()Lcom/avito/android/remote/model/CarMarketPrice;", "carMarketPrice", "Lcom/avito/android/remote/model/ForegroundImage;", "Lcom/avito/android/remote/model/ForegroundImage;", "getInfoImage", "()Lcom/avito/android/remote/model/ForegroundImage;", "infoImage", "i", "getAddress", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "Lcom/avito/android/remote/model/Coordinates;", "p", "Lcom/avito/android/remote/model/Coordinates;", "getCoordinates", "()Lcom/avito/android/remote/model/Coordinates;", "coordinates", "Lcom/avito/android/html_formatter/HtmlCharSequence;", "s", "Lcom/avito/android/html_formatter/HtmlCharSequence;", "getDescription", "()Lcom/avito/android/html_formatter/HtmlCharSequence;", "description", "Lcom/avito/android/remote/model/adverts/MyAdvertDetails$Shop;", "B", "Lcom/avito/android/remote/model/adverts/MyAdvertDetails$Shop;", "getShop", "()Lcom/avito/android/remote/model/adverts/MyAdvertDetails$Shop;", ScreenPublicConstsKt.CONTENT_TYPE_SHOP, "Lcom/avito/android/remote/model/user_adverts/UserOrderStatus;", "a0", "Lcom/avito/android/remote/model/user_adverts/UserOrderStatus;", "getOrderStatus", "()Lcom/avito/android/remote/model/user_adverts/UserOrderStatus;", "orderStatus", "e", "getDirectionName", "directionName", "Lcom/avito/android/remote/model/Action;", "r", "getActions", "actions", "", AuthSource.OPEN_CHANNEL_LIST, "Ljava/lang/Long;", "getTime", "()Ljava/lang/Long;", "time", AuthSource.BOOKING_ORDER, "getLocationName", Constants.LOCATION_NAME, "h", "getMetroId", UrlParams.METRO_ID, "Lcom/avito/android/remote/model/AnonymousNumber;", "t", "Lcom/avito/android/remote/model/AnonymousNumber;", "getAnonymousNumber", "()Lcom/avito/android/remote/model/AnonymousNumber;", "anonymousNumber", "w", "getUserType", "userType", "Lcom/avito/android/remote/model/Video;", "G", "Lcom/avito/android/remote/model/Video;", "getVideo", "()Lcom/avito/android/remote/model/Video;", "video", "Lcom/avito/android/remote/model/Image;", "F", "getImages", "images", "Lcom/avito/android/remote/model/my_advert/AppliedServicesInfo;", "Q", "Lcom/avito/android/remote/model/my_advert/AppliedServicesInfo;", "getAppliedServices", "()Lcom/avito/android/remote/model/my_advert/AppliedServicesInfo;", "appliedServices", "Lcom/avito/android/remote/model/MyAdvertVas;", "z", "Lcom/avito/android/remote/model/MyAdvertVas;", "getVas", "()Lcom/avito/android/remote/model/MyAdvertVas;", "vas", "Lcom/avito/android/user_advert/advert/AdvertStats;", "J", "Lcom/avito/android/user_advert/advert/AdvertStats;", "getStats", "()Lcom/avito/android/user_advert/advert/AdvertStats;", "stats", "Lcom/avito/android/remote/model/RejectReason;", "L", "getReasons", "reasons", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Coordinates;Lcom/avito/android/remote/model/AdvertSharing;Ljava/util/List;Lcom/avito/android/html_formatter/HtmlCharSequence;Lcom/avito/android/remote/model/AnonymousNumber;ZLcom/avito/android/remote/model/AdvertDeliveryC2C;Ljava/lang/String;Lcom/avito/android/remote/model/adverts/MyAdvertDetails$Seller;Ljava/lang/String;Lcom/avito/android/remote/model/MyAdvertVas;Lcom/avito/android/remote/model/adverts/MyAdvertDetails$ActivationInfo;Lcom/avito/android/remote/model/adverts/MyAdvertDetails$Shop;Lcom/avito/android/remote/model/adverts/MyAdvertDetails$VasBundlesBanner;Lcom/avito/android/remote/model/adverts/MyAdvertDetails$AlertBanner;Lcom/avito/android/remote/model/AdvertParameters;Ljava/util/List;Lcom/avito/android/remote/model/Video;Ljava/lang/String;Lcom/avito/android/remote/model/adverts/MyAdvertDetails$Price;Lcom/avito/android/user_advert/advert/AdvertStats;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;ZZLcom/avito/android/remote/model/AdvertSellerShortTermRent;Lcom/avito/android/remote/model/my_advert/AppliedServicesInfo;Lcom/avito/android/remote/model/PriceBadge;Lcom/avito/android/remote/model/ContractInfo;Lcom/avito/android/remote/model/Verification;Lcom/avito/android/remote/model/MyAdvertSafeDeal;Lcom/avito/android/remote/model/feature_teaser/AdvertDetailsFeaturesTeasers;Ljava/util/List;Lcom/avito/android/remote/model/adverts/MyAdvertDetails$AutoPublishSwitcher;Lcom/avito/android/remote/model/adverts/MyAdvertDetails$AutoBookingSwitcher;Lcom/avito/android/remote/model/ForegroundImage;Lcom/avito/android/remote/model/user_adverts/UserOrderStatus;Lcom/avito/android/remote/model/CarMarketPrice;)V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
public final class MyAdvertDetailsItem implements Parcelable {
    public static final Parcelable.Creator<MyAdvertDetailsItem> CREATOR = new Creator();
    @Nullable
    public final MyAdvertDetails.ActivationInfo A;
    @Nullable
    public final MyAdvertDetails.Shop B;
    @Nullable
    public final MyAdvertDetails.VasBundlesBanner C;
    @Nullable
    public final MyAdvertDetails.AlertBanner D;
    @Nullable
    public final AdvertParameters E;
    @NotNull
    public final List<Image> F;
    @Nullable
    public final Video G;
    @NotNull
    public String H;
    @Nullable
    public final MyAdvertDetails.Price I;
    @Nullable
    public final AdvertStats J;
    @Nullable
    public final String K;
    @Nullable
    public final List<RejectReason> L;
    @Nullable
    public final String M;
    public final boolean N;
    public final boolean O;
    @Nullable
    public final AdvertSellerShortTermRent P;
    @Nullable
    public final AppliedServicesInfo Q;
    @Nullable
    public final PriceBadge R;
    @Nullable
    public final ContractInfo S;
    @Nullable
    public final Verification T;
    @Nullable
    public final MyAdvertSafeDeal U;
    @Nullable
    public final AdvertDetailsFeaturesTeasers V;
    @Nullable
    public final List<ApartmentFeature> W;
    @Nullable
    public final MyAdvertDetails.AutoPublishSwitcher X;
    @Nullable
    public final MyAdvertDetails.AutoBookingSwitcher Y;
    @Nullable
    public final ForegroundImage Z;
    @NotNull
    public final String a;
    @Nullable
    public final UserOrderStatus a0;
    @Nullable
    public final String b;
    @Nullable
    public final CarMarketPrice b0;
    @Nullable
    public final String c;
    @Nullable
    public final String d;
    @Nullable
    public final String e;
    @Nullable
    public final String f;
    @Nullable
    public final String g;
    @Nullable
    public final String h;
    @Nullable
    public final String i;
    @Nullable
    public final List<GeoReference> j;
    @NotNull
    public final String k;
    @NotNull
    public final String l;
    @Nullable
    public final Long m;
    @Nullable
    public final String n;
    @Nullable
    public final String o;
    @Nullable
    public final Coordinates p;
    @Nullable
    public final AdvertSharing q;
    @NotNull
    public final List<Action> r;
    @Nullable
    public final HtmlCharSequence s;
    @Nullable
    public final AnonymousNumber t;
    public final boolean u;
    @Nullable
    public final AdvertDeliveryC2C v;
    @NotNull
    public final String w;
    @Nullable
    public final MyAdvertDetails.Seller x;
    @Nullable
    public final String y;
    @Nullable
    public final MyAdvertVas z;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<MyAdvertDetailsItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MyAdvertDetailsItem createFromParcel(@NotNull Parcel parcel) {
            ArrayList arrayList;
            ArrayList arrayList2;
            ArrayList arrayList3;
            ArrayList arrayList4;
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            String readString7 = parcel.readString();
            String readString8 = parcel.readString();
            String readString9 = parcel.readString();
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add((GeoReference) parcel.readParcelable(MyAdvertDetailsItem.class.getClassLoader()));
                    readInt--;
                }
            } else {
                arrayList = null;
            }
            String readString10 = parcel.readString();
            String readString11 = parcel.readString();
            Long valueOf = parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null;
            String readString12 = parcel.readString();
            String readString13 = parcel.readString();
            Coordinates coordinates = (Coordinates) parcel.readParcelable(MyAdvertDetailsItem.class.getClassLoader());
            AdvertSharing advertSharing = (AdvertSharing) parcel.readParcelable(MyAdvertDetailsItem.class.getClassLoader());
            int readInt2 = parcel.readInt();
            ArrayList arrayList5 = new ArrayList(readInt2);
            while (readInt2 != 0) {
                arrayList5.add((Action) parcel.readParcelable(MyAdvertDetailsItem.class.getClassLoader()));
                readInt2--;
            }
            HtmlCharSequence htmlCharSequence = (HtmlCharSequence) parcel.readParcelable(MyAdvertDetailsItem.class.getClassLoader());
            AnonymousNumber anonymousNumber = (AnonymousNumber) parcel.readParcelable(MyAdvertDetailsItem.class.getClassLoader());
            boolean z = parcel.readInt() != 0;
            AdvertDeliveryC2C advertDeliveryC2C = (AdvertDeliveryC2C) parcel.readParcelable(MyAdvertDetailsItem.class.getClassLoader());
            String readString14 = parcel.readString();
            MyAdvertDetails.Seller seller = (MyAdvertDetails.Seller) parcel.readParcelable(MyAdvertDetailsItem.class.getClassLoader());
            String readString15 = parcel.readString();
            MyAdvertVas myAdvertVas = (MyAdvertVas) parcel.readParcelable(MyAdvertDetailsItem.class.getClassLoader());
            MyAdvertDetails.ActivationInfo activationInfo = (MyAdvertDetails.ActivationInfo) parcel.readParcelable(MyAdvertDetailsItem.class.getClassLoader());
            MyAdvertDetails.Shop shop = (MyAdvertDetails.Shop) parcel.readParcelable(MyAdvertDetailsItem.class.getClassLoader());
            MyAdvertDetails.VasBundlesBanner vasBundlesBanner = (MyAdvertDetails.VasBundlesBanner) parcel.readParcelable(MyAdvertDetailsItem.class.getClassLoader());
            MyAdvertDetails.AlertBanner alertBanner = (MyAdvertDetails.AlertBanner) parcel.readParcelable(MyAdvertDetailsItem.class.getClassLoader());
            AdvertParameters advertParameters = (AdvertParameters) parcel.readParcelable(MyAdvertDetailsItem.class.getClassLoader());
            int readInt3 = parcel.readInt();
            ArrayList arrayList6 = new ArrayList(readInt3);
            while (readInt3 != 0) {
                arrayList6.add((Image) parcel.readParcelable(MyAdvertDetailsItem.class.getClassLoader()));
                readInt3--;
            }
            Video video = (Video) parcel.readParcelable(MyAdvertDetailsItem.class.getClassLoader());
            String readString16 = parcel.readString();
            MyAdvertDetails.Price price = (MyAdvertDetails.Price) parcel.readParcelable(MyAdvertDetailsItem.class.getClassLoader());
            AdvertStats createFromParcel = parcel.readInt() != 0 ? AdvertStats.CREATOR.createFromParcel(parcel) : null;
            String readString17 = parcel.readString();
            if (parcel.readInt() != 0) {
                int readInt4 = parcel.readInt();
                ArrayList arrayList7 = new ArrayList(readInt4);
                while (readInt4 != 0) {
                    arrayList7.add((RejectReason) parcel.readParcelable(MyAdvertDetailsItem.class.getClassLoader()));
                    readInt4--;
                    arrayList6 = arrayList6;
                }
                arrayList2 = arrayList6;
                arrayList3 = arrayList7;
            } else {
                arrayList2 = arrayList6;
                arrayList3 = null;
            }
            String readString18 = parcel.readString();
            boolean z2 = parcel.readInt() != 0;
            boolean z3 = parcel.readInt() != 0;
            AdvertSellerShortTermRent advertSellerShortTermRent = (AdvertSellerShortTermRent) parcel.readParcelable(MyAdvertDetailsItem.class.getClassLoader());
            AppliedServicesInfo appliedServicesInfo = (AppliedServicesInfo) parcel.readParcelable(MyAdvertDetailsItem.class.getClassLoader());
            PriceBadge priceBadge = (PriceBadge) parcel.readParcelable(MyAdvertDetailsItem.class.getClassLoader());
            ContractInfo contractInfo = (ContractInfo) parcel.readParcelable(MyAdvertDetailsItem.class.getClassLoader());
            Verification verification = (Verification) parcel.readParcelable(MyAdvertDetailsItem.class.getClassLoader());
            MyAdvertSafeDeal myAdvertSafeDeal = (MyAdvertSafeDeal) parcel.readParcelable(MyAdvertDetailsItem.class.getClassLoader());
            AdvertDetailsFeaturesTeasers advertDetailsFeaturesTeasers = (AdvertDetailsFeaturesTeasers) parcel.readParcelable(MyAdvertDetailsItem.class.getClassLoader());
            if (parcel.readInt() != 0) {
                int readInt5 = parcel.readInt();
                ArrayList arrayList8 = new ArrayList(readInt5);
                while (readInt5 != 0) {
                    arrayList8.add((ApartmentFeature) parcel.readParcelable(MyAdvertDetailsItem.class.getClassLoader()));
                    readInt5--;
                }
                arrayList4 = arrayList8;
            } else {
                arrayList4 = null;
            }
            return new MyAdvertDetailsItem(readString, readString2, readString3, readString4, readString5, readString6, readString7, readString8, readString9, arrayList, readString10, readString11, valueOf, readString12, readString13, coordinates, advertSharing, arrayList5, htmlCharSequence, anonymousNumber, z, advertDeliveryC2C, readString14, seller, readString15, myAdvertVas, activationInfo, shop, vasBundlesBanner, alertBanner, advertParameters, arrayList2, video, readString16, price, createFromParcel, readString17, arrayList3, readString18, z2, z3, advertSellerShortTermRent, appliedServicesInfo, priceBadge, contractInfo, verification, myAdvertSafeDeal, advertDetailsFeaturesTeasers, arrayList4, (MyAdvertDetails.AutoPublishSwitcher) parcel.readParcelable(MyAdvertDetailsItem.class.getClassLoader()), (MyAdvertDetails.AutoBookingSwitcher) parcel.readParcelable(MyAdvertDetailsItem.class.getClassLoader()), (ForegroundImage) parcel.readParcelable(MyAdvertDetailsItem.class.getClassLoader()), (UserOrderStatus) parcel.readParcelable(MyAdvertDetailsItem.class.getClassLoader()), (CarMarketPrice) parcel.readParcelable(MyAdvertDetailsItem.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MyAdvertDetailsItem[] newArray(int i) {
            return new MyAdvertDetailsItem[i];
        }
    }

    public MyAdvertDetailsItem(@NotNull String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable List<GeoReference> list, @NotNull String str10, @NotNull String str11, @Nullable Long l2, @Nullable String str12, @Nullable String str13, @Nullable Coordinates coordinates, @Nullable AdvertSharing advertSharing, @NotNull List<Action> list2, @Nullable HtmlCharSequence htmlCharSequence, @Nullable AnonymousNumber anonymousNumber, boolean z2, @Nullable AdvertDeliveryC2C advertDeliveryC2C, @NotNull String str14, @Nullable MyAdvertDetails.Seller seller, @Nullable String str15, @Nullable MyAdvertVas myAdvertVas, @Nullable MyAdvertDetails.ActivationInfo activationInfo, @Nullable MyAdvertDetails.Shop shop, @Nullable MyAdvertDetails.VasBundlesBanner vasBundlesBanner, @Nullable MyAdvertDetails.AlertBanner alertBanner, @Nullable AdvertParameters advertParameters, @NotNull List<Image> list3, @Nullable Video video, @NotNull String str16, @Nullable MyAdvertDetails.Price price, @Nullable AdvertStats advertStats, @Nullable String str17, @Nullable List<RejectReason> list4, @Nullable String str18, boolean z3, boolean z4, @Nullable AdvertSellerShortTermRent advertSellerShortTermRent, @Nullable AppliedServicesInfo appliedServicesInfo, @Nullable PriceBadge priceBadge, @Nullable ContractInfo contractInfo, @Nullable Verification verification, @Nullable MyAdvertSafeDeal myAdvertSafeDeal, @Nullable AdvertDetailsFeaturesTeasers advertDetailsFeaturesTeasers, @Nullable List<ApartmentFeature> list5, @Nullable MyAdvertDetails.AutoPublishSwitcher autoPublishSwitcher, @Nullable MyAdvertDetails.AutoBookingSwitcher autoBookingSwitcher, @Nullable ForegroundImage foregroundImage, @Nullable UserOrderStatus userOrderStatus, @Nullable CarMarketPrice carMarketPrice) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str10, "title");
        Intrinsics.checkNotNullParameter(str11, "toolbarTitle");
        Intrinsics.checkNotNullParameter(list2, "actions");
        Intrinsics.checkNotNullParameter(str14, "userType");
        Intrinsics.checkNotNullParameter(list3, "images");
        Intrinsics.checkNotNullParameter(str16, "status");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.g = str7;
        this.h = str8;
        this.i = str9;
        this.j = list;
        this.k = str10;
        this.l = str11;
        this.m = l2;
        this.n = str12;
        this.o = str13;
        this.p = coordinates;
        this.q = advertSharing;
        this.r = list2;
        this.s = htmlCharSequence;
        this.t = anonymousNumber;
        this.u = z2;
        this.v = advertDeliveryC2C;
        this.w = str14;
        this.x = seller;
        this.y = str15;
        this.z = myAdvertVas;
        this.A = activationInfo;
        this.B = shop;
        this.C = vasBundlesBanner;
        this.D = alertBanner;
        this.E = advertParameters;
        this.F = list3;
        this.G = video;
        this.H = str16;
        this.I = price;
        this.J = advertStats;
        this.K = str17;
        this.L = list4;
        this.M = str18;
        this.N = z3;
        this.O = z4;
        this.P = advertSellerShortTermRent;
        this.Q = appliedServicesInfo;
        this.R = priceBadge;
        this.S = contractInfo;
        this.T = verification;
        this.U = myAdvertSafeDeal;
        this.V = advertDetailsFeaturesTeasers;
        this.W = list5;
        this.X = autoPublishSwitcher;
        this.Y = autoBookingSwitcher;
        this.Z = foregroundImage;
        this.a0 = userOrderStatus;
        this.b0 = carMarketPrice;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final List<Action> getActions() {
        return this.r;
    }

    @Nullable
    public final MyAdvertDetails.ActivationInfo getActivationInfo() {
        return this.A;
    }

    @Nullable
    public final String getAddress() {
        return this.i;
    }

    @Nullable
    public final MyAdvertDetails.AlertBanner getAlertBanner() {
        return this.D;
    }

    @Nullable
    public final AnonymousNumber getAnonymousNumber() {
        return this.t;
    }

    @Nullable
    public final List<ApartmentFeature> getApartmentFeatures() {
        return this.W;
    }

    @Nullable
    public final AppliedServicesInfo getAppliedServices() {
        return this.Q;
    }

    @Nullable
    public final MyAdvertDetails.AutoBookingSwitcher getAutoBooking() {
        return this.Y;
    }

    @Nullable
    public final MyAdvertDetails.AutoPublishSwitcher getAutoPublish() {
        return this.X;
    }

    @Nullable
    public final CarMarketPrice getCarMarketPrice() {
        return this.b0;
    }

    @Nullable
    public final String getCategoryId() {
        return this.f;
    }

    @Nullable
    public final ContractInfo getContract() {
        return this.S;
    }

    @Nullable
    public final Coordinates getCoordinates() {
        return this.p;
    }

    @Nullable
    public final AdvertDeliveryC2C getDelivery() {
        return this.v;
    }

    @Nullable
    public final HtmlCharSequence getDescription() {
        return this.s;
    }

    @Nullable
    public final String getDirectionName() {
        return this.e;
    }

    @Nullable
    public final String getDistrictName() {
        return this.d;
    }

    @Nullable
    public final List<GeoReference> getGeoReferences() {
        return this.j;
    }

    @NotNull
    public final String getId() {
        return this.a;
    }

    @NotNull
    public final List<Image> getImages() {
        return this.F;
    }

    @Nullable
    public final ForegroundImage getInfoImage() {
        return this.Z;
    }

    @Nullable
    public final String getLocationId() {
        return this.g;
    }

    @Nullable
    public final String getLocationName() {
        return this.b;
    }

    @Nullable
    public final String getMetroId() {
        return this.h;
    }

    @Nullable
    public final String getMetroName() {
        return this.c;
    }

    @Nullable
    public final String getModerationInfo() {
        return this.M;
    }

    @Nullable
    public final UserOrderStatus getOrderStatus() {
        return this.a0;
    }

    @Nullable
    public final AdvertParameters getParameters() {
        return this.E;
    }

    @Nullable
    public final String getPhone() {
        return this.y;
    }

    @Nullable
    public final MyAdvertDetails.Price getPrice() {
        return this.I;
    }

    @Nullable
    public final PriceBadge getPriceBadge() {
        return this.R;
    }

    @Nullable
    public final List<RejectReason> getReasons() {
        return this.L;
    }

    @Nullable
    public final String getReasonsTitle() {
        return this.K;
    }

    @Nullable
    public final MyAdvertSafeDeal getSafeDealServices() {
        return this.U;
    }

    @Nullable
    public final MyAdvertDetails.Seller getSeller() {
        return this.x;
    }

    @Nullable
    public final AdvertSharing getSharing() {
        return this.q;
    }

    @Nullable
    public final MyAdvertDetails.Shop getShop() {
        return this.B;
    }

    @Nullable
    public final AdvertSellerShortTermRent getShortTermRent() {
        return this.P;
    }

    @Nullable
    public final AdvertStats getStats() {
        return this.J;
    }

    @NotNull
    public final String getStatus() {
        return this.H;
    }

    @Nullable
    public final AdvertDetailsFeaturesTeasers getTeasers() {
        return this.V;
    }

    @Nullable
    public final Long getTime() {
        return this.m;
    }

    @NotNull
    public final String getTitle() {
        return this.k;
    }

    @NotNull
    public final String getToolbarTitle() {
        return this.l;
    }

    @Nullable
    public final String getTtlHumanized() {
        return this.n;
    }

    @NotNull
    public final String getUserType() {
        return this.w;
    }

    @Nullable
    public final MyAdvertVas getVas() {
        return this.z;
    }

    @Nullable
    public final MyAdvertDetails.VasBundlesBanner getVasBundlesBanner() {
        return this.C;
    }

    @Nullable
    public final Verification getVerification() {
        return this.T;
    }

    @Nullable
    public final Video getVideo() {
        return this.G;
    }

    @Nullable
    public final String getWizardId() {
        return this.o;
    }

    public final boolean isCompany() {
        return this.N;
    }

    public final boolean isDeliveryEnabled() {
        return this.u;
    }

    public final boolean isShop() {
        return this.O;
    }

    public final void setStatus(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.H = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
        parcel.writeString(this.i);
        List<GeoReference> list = this.j;
        if (list != null) {
            Iterator l0 = a.l0(parcel, 1, list);
            while (l0.hasNext()) {
                parcel.writeParcelable((GeoReference) l0.next(), i2);
            }
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.k);
        parcel.writeString(this.l);
        Long l2 = this.m;
        if (l2 != null) {
            a.I0(parcel, 1, l2);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.n);
        parcel.writeString(this.o);
        parcel.writeParcelable(this.p, i2);
        parcel.writeParcelable(this.q, i2);
        Iterator n0 = a.n0(this.r, parcel);
        while (n0.hasNext()) {
            parcel.writeParcelable((Action) n0.next(), i2);
        }
        parcel.writeParcelable(this.s, i2);
        parcel.writeParcelable(this.t, i2);
        parcel.writeInt(this.u ? 1 : 0);
        parcel.writeParcelable(this.v, i2);
        parcel.writeString(this.w);
        parcel.writeParcelable(this.x, i2);
        parcel.writeString(this.y);
        parcel.writeParcelable(this.z, i2);
        parcel.writeParcelable(this.A, i2);
        parcel.writeParcelable(this.B, i2);
        parcel.writeParcelable(this.C, i2);
        parcel.writeParcelable(this.D, i2);
        parcel.writeParcelable(this.E, i2);
        Iterator n02 = a.n0(this.F, parcel);
        while (n02.hasNext()) {
            parcel.writeParcelable((Image) n02.next(), i2);
        }
        parcel.writeParcelable(this.G, i2);
        parcel.writeString(this.H);
        parcel.writeParcelable(this.I, i2);
        AdvertStats advertStats = this.J;
        if (advertStats != null) {
            parcel.writeInt(1);
            advertStats.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.K);
        List<RejectReason> list2 = this.L;
        if (list2 != null) {
            Iterator l02 = a.l0(parcel, 1, list2);
            while (l02.hasNext()) {
                parcel.writeParcelable((RejectReason) l02.next(), i2);
            }
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.M);
        parcel.writeInt(this.N ? 1 : 0);
        parcel.writeInt(this.O ? 1 : 0);
        parcel.writeParcelable(this.P, i2);
        parcel.writeParcelable(this.Q, i2);
        parcel.writeParcelable(this.R, i2);
        parcel.writeParcelable(this.S, i2);
        parcel.writeParcelable(this.T, i2);
        parcel.writeParcelable(this.U, i2);
        parcel.writeParcelable(this.V, i2);
        List<ApartmentFeature> list3 = this.W;
        if (list3 != null) {
            Iterator l03 = a.l0(parcel, 1, list3);
            while (l03.hasNext()) {
                parcel.writeParcelable((ApartmentFeature) l03.next(), i2);
            }
        } else {
            parcel.writeInt(0);
        }
        parcel.writeParcelable(this.X, i2);
        parcel.writeParcelable(this.Y, i2);
        parcel.writeParcelable(this.Z, i2);
        parcel.writeParcelable(this.a0, i2);
        parcel.writeParcelable(this.b0, i2);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MyAdvertDetailsItem(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, List list, String str10, String str11, Long l2, String str12, String str13, Coordinates coordinates, AdvertSharing advertSharing, List list2, HtmlCharSequence htmlCharSequence, AnonymousNumber anonymousNumber, boolean z2, AdvertDeliveryC2C advertDeliveryC2C, String str14, MyAdvertDetails.Seller seller, String str15, MyAdvertVas myAdvertVas, MyAdvertDetails.ActivationInfo activationInfo, MyAdvertDetails.Shop shop, MyAdvertDetails.VasBundlesBanner vasBundlesBanner, MyAdvertDetails.AlertBanner alertBanner, AdvertParameters advertParameters, List list3, Video video, String str16, MyAdvertDetails.Price price, AdvertStats advertStats, String str17, List list4, String str18, boolean z3, boolean z4, AdvertSellerShortTermRent advertSellerShortTermRent, AppliedServicesInfo appliedServicesInfo, PriceBadge priceBadge, ContractInfo contractInfo, Verification verification, MyAdvertSafeDeal myAdvertSafeDeal, AdvertDetailsFeaturesTeasers advertDetailsFeaturesTeasers, List list5, MyAdvertDetails.AutoPublishSwitcher autoPublishSwitcher, MyAdvertDetails.AutoBookingSwitcher autoBookingSwitcher, ForegroundImage foregroundImage, UserOrderStatus userOrderStatus, CarMarketPrice carMarketPrice, int i2, int i3, j jVar) {
        this(str, str2, str3, str4, str5, str6, str7, str8, str9, list, str10, str11, l2, str12, str13, coordinates, advertSharing, list2, htmlCharSequence, anonymousNumber, z2, advertDeliveryC2C, str14, seller, str15, myAdvertVas, activationInfo, shop, vasBundlesBanner, alertBanner, advertParameters, list3, video, str16, price, advertStats, str17, list4, str18, z3, z4, advertSellerShortTermRent, appliedServicesInfo, priceBadge, contractInfo, verification, myAdvertSafeDeal, (i3 & 32768) != 0 ? null : advertDetailsFeaturesTeasers, (i3 & 65536) != 0 ? null : list5, (i3 & 131072) != 0 ? null : autoPublishSwitcher, (i3 & 262144) != 0 ? null : autoBookingSwitcher, (i3 & 524288) != 0 ? null : foregroundImage, (i3 & 1048576) != 0 ? null : userOrderStatus, (i3 & 2097152) != 0 ? null : carMarketPrice);
    }
}
