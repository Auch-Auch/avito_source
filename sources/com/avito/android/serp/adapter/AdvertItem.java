package com.avito.android.serp.adapter;

import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.adapter.MoreActionsItem;
import com.avito.android.adapter.MoreActionsItemKt;
import com.avito.android.async_phone.AsyncPhoneItem;
import com.avito.android.component.user_advert.PriceTypeBadge;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.AdvertActions;
import com.avito.android.remote.model.AdvertItemActions;
import com.avito.android.remote.model.AdvertSellerInfo;
import com.avito.android.remote.model.ForegroundImage;
import com.avito.android.remote.model.GeoReference;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.RadiusInfo;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.remote.model.Sort;
import com.avito.android.remote.model.badge_bar.SerpBadgeBar;
import com.avito.android.serp.adapter.PersistableSerpItem;
import com.avito.android.util.ParcelUtils;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import com.facebook.appevents.integrity.IntegrityManager;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.serp.PhoneLoadingState;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Î\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b7\n\u0002\u0010\u0000\n\u0002\bO\n\u0002\u0018\u0002\n\u0002\b/\b\b\u0018\u0000 \u00022\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u0002\u0002B\u0004\u0012\u0006\u0010f\u001a\u00020\u0017\u0012\u0006\u0010g\u001a\u00020\u0014\u0012\u0006\u0010h\u001a\u00020\u0014\u0012\n\b\u0002\u0010i\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010j\u001a\u00020\u001d\u0012\b\u0010k\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010l\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010m\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010n\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010o\u001a\u00020\u001d\u0012\b\u0010p\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010q\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010r\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010s\u001a\u00020\u0017\u0012\b\u0010t\u001a\u0004\u0018\u00010)\u0012\b\u0010u\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010v\u001a\u00020\t\u0012\u0006\u0010w\u001a\u00020.\u0012\u0006\u0010x\u001a\u00020\u001d\u0012\u0006\u0010y\u001a\u000202\u0012\b\b\u0002\u0010z\u001a\u00020\u001d\u0012\b\u0010{\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010|\u001a\u00020\u001d\u0012\b\b\u0002\u0010}\u001a\u00020\u001d\u0012\u0006\u0010~\u001a\u000209\u0012\u0014\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u00010<\u0012\u000b\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0014\u0012\u0011\b\u0002\u0010\u0001\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010@\u0012\u000b\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010C\u0012\u000b\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010F\u0012\u000b\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0014\u0012\u000b\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010J\u0012\u000b\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010M\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\u000b\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0014\u0012\u0011\b\u0002\u0010\u0001\u001a\n\u0012\u0004\u0012\u00020S\u0018\u00010@\u0012\u000b\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010U\u0012\u000b\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010X\u0012\t\b\u0002\u0010\u0001\u001a\u00020\u001d\u0012\u000b\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0014\u0012\u000b\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0014\u0012\t\b\u0002\u0010\u0001\u001a\u00020\u001d\u0012\u000b\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010_\u0012\t\b\u0002\u0010\u0001\u001a\u00020\u001d\u0012\u000b\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\t\u0012\t\b\u0002\u0010\u0001\u001a\u00020\u001d¢\u0006\u0006\b\u0002\u0010\u0002J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0014HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0016J\u0010\u0010\u001b\u001a\u00020\u0014HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0016J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u0016J\u0010\u0010\u001e\u001a\u00020\u001dHÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0012\u0010 \u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0004\b \u0010\u0016J\u0012\u0010!\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0004\b!\u0010\u0016J\u0012\u0010\"\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0004\b\"\u0010\u0016J\u0012\u0010#\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0004\b#\u0010\u0016J\u0010\u0010$\u001a\u00020\u001dHÆ\u0003¢\u0006\u0004\b$\u0010\u001fJ\u0012\u0010%\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0004\b%\u0010\u0016J\u0012\u0010&\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0004\b&\u0010\u0016J\u0012\u0010'\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0004\b'\u0010\u0016J\u0010\u0010(\u001a\u00020\u0017HÆ\u0003¢\u0006\u0004\b(\u0010\u0019J\u0012\u0010*\u001a\u0004\u0018\u00010)HÆ\u0003¢\u0006\u0004\b*\u0010+J\u0012\u0010,\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0004\b,\u0010\u0016J\u0010\u0010-\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b-\u0010\u000fJ\u0010\u0010/\u001a\u00020.HÆ\u0003¢\u0006\u0004\b/\u00100J\u0010\u00101\u001a\u00020\u001dHÆ\u0003¢\u0006\u0004\b1\u0010\u001fJ\u0010\u00103\u001a\u000202HÆ\u0003¢\u0006\u0004\b3\u00104J\u0010\u00105\u001a\u00020\u001dHÆ\u0003¢\u0006\u0004\b5\u0010\u001fJ\u0012\u00106\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0004\b6\u0010\u0016J\u0010\u00107\u001a\u00020\u001dHÆ\u0003¢\u0006\u0004\b7\u0010\u001fJ\u0010\u00108\u001a\u00020\u001dHÆ\u0003¢\u0006\u0004\b8\u0010\u001fJ\u0010\u0010:\u001a\u000209HÆ\u0003¢\u0006\u0004\b:\u0010;J\u001e\u0010=\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u00010<HÆ\u0003¢\u0006\u0004\b=\u0010>J\u0012\u0010?\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0004\b?\u0010\u0016J\u0018\u0010A\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010@HÆ\u0003¢\u0006\u0004\bA\u0010BJ\u0012\u0010D\u001a\u0004\u0018\u00010CHÆ\u0003¢\u0006\u0004\bD\u0010EJ\u0012\u0010G\u001a\u0004\u0018\u00010FHÆ\u0003¢\u0006\u0004\bG\u0010HJ\u0012\u0010I\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0004\bI\u0010\u0016J\u0012\u0010K\u001a\u0004\u0018\u00010JHÆ\u0003¢\u0006\u0004\bK\u0010LJ\u0012\u0010N\u001a\u0004\u0018\u00010MHÆ\u0003¢\u0006\u0004\bN\u0010OJ\u0012\u0010P\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\bP\u0010QJ\u0012\u0010R\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0004\bR\u0010\u0016J\u0018\u0010T\u001a\n\u0012\u0004\u0012\u00020S\u0018\u00010@HÆ\u0003¢\u0006\u0004\bT\u0010BJ\u0012\u0010V\u001a\u0004\u0018\u00010UHÆ\u0003¢\u0006\u0004\bV\u0010WJ\u0012\u0010Y\u001a\u0004\u0018\u00010XHÆ\u0003¢\u0006\u0004\bY\u0010ZJ\u0010\u0010[\u001a\u00020\u001dHÆ\u0003¢\u0006\u0004\b[\u0010\u001fJ\u0012\u0010\\\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0004\b\\\u0010\u0016J\u0012\u0010]\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0004\b]\u0010\u0016J\u0010\u0010^\u001a\u00020\u001dHÆ\u0003¢\u0006\u0004\b^\u0010\u001fJ\u0012\u0010`\u001a\u0004\u0018\u00010_HÆ\u0003¢\u0006\u0004\b`\u0010aJ\u0010\u0010b\u001a\u00020\u001dHÆ\u0003¢\u0006\u0004\bb\u0010\u001fJ\u0012\u0010c\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\bc\u0010dJ\u0010\u0010e\u001a\u00020\u001dHÆ\u0003¢\u0006\u0004\be\u0010\u001fJÂ\u0004\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010f\u001a\u00020\u00172\b\b\u0002\u0010g\u001a\u00020\u00142\b\b\u0002\u0010h\u001a\u00020\u00142\n\b\u0002\u0010i\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010j\u001a\u00020\u001d2\n\b\u0002\u0010k\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010l\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010m\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010n\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010o\u001a\u00020\u001d2\n\b\u0002\u0010p\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010q\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010r\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010s\u001a\u00020\u00172\n\b\u0002\u0010t\u001a\u0004\u0018\u00010)2\n\b\u0002\u0010u\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010v\u001a\u00020\t2\b\b\u0002\u0010w\u001a\u00020.2\b\b\u0002\u0010x\u001a\u00020\u001d2\b\b\u0002\u0010y\u001a\u0002022\b\b\u0002\u0010z\u001a\u00020\u001d2\n\b\u0002\u0010{\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010|\u001a\u00020\u001d2\b\b\u0002\u0010}\u001a\u00020\u001d2\b\b\u0002\u0010~\u001a\u0002092\u0016\b\u0002\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u00010<2\u000b\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u00142\u0011\b\u0002\u0010\u0001\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010@2\u000b\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010C2\u000b\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010F2\u000b\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u00142\u000b\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010J2\u000b\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010M2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u000b\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u00142\u0011\b\u0002\u0010\u0001\u001a\n\u0012\u0004\u0012\u00020S\u0018\u00010@2\u000b\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010U2\u000b\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010X2\t\b\u0002\u0010\u0001\u001a\u00020\u001d2\u000b\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u00142\u000b\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u00142\t\b\u0002\u0010\u0001\u001a\u00020\u001d2\u000b\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010_2\t\b\u0002\u0010\u0001\u001a\u00020\u001d2\u000b\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\t2\t\b\u0002\u0010\u0001\u001a\u00020\u001dHÆ\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\u0012\u0010\u0001\u001a\u00020\u0014HÖ\u0001¢\u0006\u0005\b\u0001\u0010\u0016J\u0012\u0010\u0001\u001a\u00020\tHÖ\u0001¢\u0006\u0005\b\u0001\u0010\u000fJ\u001f\u0010\u0001\u001a\u00020\u001d2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001HÖ\u0003¢\u0006\u0006\b\u0001\u0010\u0001R\u001b\u0010j\u001a\u00020\u001d8\u0006@\u0006¢\u0006\u000e\n\u0006\b\u0001\u0010\u0001\u001a\u0004\bj\u0010\u001fR\u001f\u0010g\u001a\u00020\u00148\u0016@\u0016X\u0004¢\u0006\u000f\n\u0006\b\u0001\u0010\u0001\u001a\u0005\b\u0001\u0010\u0016R\u001c\u0010o\u001a\u00020\u001d8\u0006@\u0006¢\u0006\u000f\n\u0006\b \u0001\u0010\u0001\u001a\u0005\b¡\u0001\u0010\u001fR\u001f\u0010\u0001\u001a\u0004\u0018\u00010J8\u0006@\u0006¢\u0006\u000f\n\u0006\b¢\u0001\u0010£\u0001\u001a\u0005\b¤\u0001\u0010LR%\u0010\u0001\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010@8\u0006@\u0006¢\u0006\u000f\n\u0006\b¥\u0001\u0010¦\u0001\u001a\u0005\b§\u0001\u0010BR\u001e\u0010m\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\u000f\n\u0006\b¨\u0001\u0010\u0001\u001a\u0005\b©\u0001\u0010\u0016R\u001f\u0010\u0001\u001a\u0004\u0018\u00010M8\u0006@\u0006¢\u0006\u000f\n\u0006\bª\u0001\u0010«\u0001\u001a\u0005\b¬\u0001\u0010OR\u001f\u0010\u0001\u001a\u0004\u0018\u00010F8\u0006@\u0006¢\u0006\u000f\n\u0006\b­\u0001\u0010®\u0001\u001a\u0005\b¯\u0001\u0010HR\u001f\u0010\u0001\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\u000f\n\u0006\b°\u0001\u0010\u0001\u001a\u0005\b±\u0001\u0010\u0016R\u001e\u0010t\u001a\u0004\u0018\u00010)8\u0006@\u0006¢\u0006\u000f\n\u0006\b²\u0001\u0010³\u0001\u001a\u0005\b´\u0001\u0010+R\u001d\u0010\u0001\u001a\u00020\u001d8\u0006@\u0006¢\u0006\u000f\n\u0006\bµ\u0001\u0010\u0001\u001a\u0005\b¶\u0001\u0010\u001fR'\u0010y\u001a\u0002028\u0016@\u0016X\u000e¢\u0006\u0017\n\u0006\b·\u0001\u0010¸\u0001\u001a\u0005\b¹\u0001\u00104\"\u0006\bº\u0001\u0010»\u0001R\u001f\u0010f\u001a\u00020\u00178\u0016@\u0016X\u0004¢\u0006\u000f\n\u0006\b¼\u0001\u0010½\u0001\u001a\u0005\b¾\u0001\u0010\u0019R\u001e\u0010n\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\u000f\n\u0006\b¿\u0001\u0010\u0001\u001a\u0005\bÀ\u0001\u0010\u0016R&\u0010z\u001a\u00020\u001d8\u0016@\u0016X\u000e¢\u0006\u0016\n\u0006\bÁ\u0001\u0010\u0001\u001a\u0004\bz\u0010\u001f\"\u0006\bÂ\u0001\u0010Ã\u0001R\u001f\u0010\u0001\u001a\u0004\u0018\u00010U8\u0006@\u0006¢\u0006\u000f\n\u0006\bÄ\u0001\u0010Å\u0001\u001a\u0005\bÆ\u0001\u0010WR\u001c\u0010h\u001a\u00020\u00148\u0006@\u0006¢\u0006\u000f\n\u0006\bÇ\u0001\u0010\u0001\u001a\u0005\bÈ\u0001\u0010\u0016R\u001f\u0010w\u001a\u00020.8\u0016@\u0016X\u0004¢\u0006\u000f\n\u0006\bÉ\u0001\u0010Ê\u0001\u001a\u0005\bË\u0001\u00100R\u001e\u0010k\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\u000f\n\u0006\bÌ\u0001\u0010\u0001\u001a\u0005\bÍ\u0001\u0010\u0016R \u0010Ð\u0001\u001a\u00020\u001d8\u0016@\u0016X\u0004¢\u0006\u000f\n\u0006\bÎ\u0001\u0010\u0001\u001a\u0005\bÏ\u0001\u0010\u001fR\u001f\u0010\u0001\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\u000f\n\u0006\bÑ\u0001\u0010\u0001\u001a\u0005\bÒ\u0001\u0010\u0016R\u001b\u0010|\u001a\u00020\u001d8\u0006@\u0006¢\u0006\u000e\n\u0006\bÓ\u0001\u0010\u0001\u001a\u0004\b|\u0010\u001fR%\u0010\u0001\u001a\n\u0012\u0004\u0012\u00020S\u0018\u00010@8\u0006@\u0006¢\u0006\u000f\n\u0006\bÔ\u0001\u0010¦\u0001\u001a\u0005\bÕ\u0001\u0010BR\u001e\u0010u\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\u000f\n\u0006\bÖ\u0001\u0010\u0001\u001a\u0005\b×\u0001\u0010\u0016R\u001f\u0010\u0001\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\u000f\n\u0006\bØ\u0001\u0010Ù\u0001\u001a\u0005\bÚ\u0001\u0010dR\u001f\u0010\u0001\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\u000f\n\u0006\bÛ\u0001\u0010\u0001\u001a\u0005\bÜ\u0001\u0010\u0016R\u001e\u0010p\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\u000f\n\u0006\bÝ\u0001\u0010\u0001\u001a\u0005\bÞ\u0001\u0010\u0016R&\u0010}\u001a\u00020\u001d8\u0016@\u0016X\u000e¢\u0006\u0016\n\u0006\bß\u0001\u0010\u0001\u001a\u0004\b}\u0010\u001f\"\u0006\bà\u0001\u0010Ã\u0001R(\u0010\u0001\u001a\u00020\u001d8\u0016@\u0016X\u000e¢\u0006\u0017\n\u0006\bá\u0001\u0010\u0001\u001a\u0005\b\u0001\u0010\u001f\"\u0006\bâ\u0001\u0010Ã\u0001R\u001f\u0010\u0001\u001a\u0004\u0018\u00010_8\u0006@\u0006¢\u0006\u000f\n\u0006\bã\u0001\u0010ä\u0001\u001a\u0005\bå\u0001\u0010aR\u001d\u0010\u0001\u001a\u00020\u001d8\u0006@\u0006¢\u0006\u000f\n\u0006\bæ\u0001\u0010\u0001\u001a\u0005\b\u0001\u0010\u001fR*\u0010î\u0001\u001a\u00030ç\u00018\u0016@\u0016X\u000e¢\u0006\u0018\n\u0006\bè\u0001\u0010é\u0001\u001a\u0006\bê\u0001\u0010ë\u0001\"\u0006\bì\u0001\u0010í\u0001R\u001e\u0010i\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\u000f\n\u0006\bï\u0001\u0010\u0001\u001a\u0005\bð\u0001\u0010\u0016R\u001e\u0010r\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\u000f\n\u0006\bñ\u0001\u0010\u0001\u001a\u0005\bò\u0001\u0010\u0016R\u001c\u0010s\u001a\u00020\u00178\u0006@\u0006¢\u0006\u000f\n\u0006\bó\u0001\u0010½\u0001\u001a\u0005\bô\u0001\u0010\u0019R\u001f\u0010\u0001\u001a\u0004\u0018\u00010C8\u0006@\u0006¢\u0006\u000f\n\u0006\bõ\u0001\u0010ö\u0001\u001a\u0005\b÷\u0001\u0010ER!\u0010{\u001a\u0004\u0018\u00010\u00148\u0016@\u0016X\u0004¢\u0006\u000f\n\u0006\bø\u0001\u0010\u0001\u001a\u0005\bù\u0001\u0010\u0016R\u001d\u0010\u0001\u001a\u00020\u001d8\u0006@\u0006¢\u0006\u000f\n\u0006\bú\u0001\u0010\u0001\u001a\u0005\bû\u0001\u0010\u001fR\u001f\u0010\u0001\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\u000f\n\u0006\bü\u0001\u0010\u0001\u001a\u0005\bý\u0001\u0010\u0016R*\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u00010<8\u0006@\u0006¢\u0006\u000f\n\u0006\bþ\u0001\u0010ÿ\u0001\u001a\u0005\b\u0002\u0010>R\u001b\u0010x\u001a\u00020\u001d8\u0006@\u0006¢\u0006\u000e\n\u0006\b\u0002\u0010\u0001\u001a\u0004\bx\u0010\u001fR!\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0016@\u0016X\u0004¢\u0006\u000f\n\u0006\b½\u0001\u0010\u0002\u001a\u0005\b\u0002\u0010QR\u001f\u0010v\u001a\u00020\t8\u0016@\u0016X\u0004¢\u0006\u000f\n\u0006\b\u0002\u0010ª\u0001\u001a\u0005\b\u0002\u0010\u000fR\u001e\u0010l\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\u000f\n\u0006\b\u0002\u0010\u0001\u001a\u0005\b\u0002\u0010\u0016R\u001f\u0010\u0001\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\u000f\n\u0006\b\u0002\u0010\u0001\u001a\u0005\b\u0002\u0010\u0016R \u0010\u0002\u001a\u00020\u001d8\u0016@\u0016XD¢\u0006\u000f\n\u0006\b\u0002\u0010\u0001\u001a\u0005\b\u0002\u0010\u001fR\u001e\u0010q\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\u000f\n\u0006\b\u0002\u0010\u0001\u001a\u0005\b\u0002\u0010\u0016R\u001f\u0010\u0001\u001a\u0004\u0018\u00010X8\u0006@\u0006¢\u0006\u000f\n\u0006\b\u0002\u0010\u0002\u001a\u0005\b\u0002\u0010ZR\u001c\u0010~\u001a\u0002098\u0006@\u0006¢\u0006\u000f\n\u0006\b\u0002\u0010\u0002\u001a\u0005\b\u0002\u0010;¨\u0006\u0002"}, d2 = {"Lcom/avito/android/serp/adapter/AdvertItem;", "Lcom/avito/android/serp/adapter/DisplayTypeAwareItem;", "Lcom/avito/android/serp/adapter/FavorableItem;", "Lcom/avito/android/serp/adapter/PersistableSerpItem;", "Lcom/avito/android/serp/adapter/ViewedAdvertItem;", "Lcom/avito/android/adapter/MoreActionsItem;", "Lcom/avito/android/async_phone/AsyncPhoneItem;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "Lcom/avito/android/remote/model/AdvertItemActions;", "moreActions", "copyWithMoreActions", "(Lcom/avito/android/remote/model/AdvertItemActions;)Lcom/avito/android/serp/adapter/AdvertItem;", "", "getProperLocation", "()Ljava/lang/String;", "", "component1", "()J", "component2", "component3", "component4", "", "component5", "()Z", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "Lcom/avito/android/remote/model/Image;", "component15", "()Lcom/avito/android/remote/model/Image;", "component16", "component17", "Lcom/avito/android/serp/adapter/SerpViewType;", "component18", "()Lcom/avito/android/serp/adapter/SerpViewType;", "component19", "Lcom/avito/android/remote/model/SerpDisplayType;", "component20", "()Lcom/avito/android/remote/model/SerpDisplayType;", "component21", "component22", "component23", "component24", "Lcom/avito/android/deep_linking/links/DeepLink;", "component25", "()Lcom/avito/android/deep_linking/links/DeepLink;", "", "component26", "()Ljava/util/Map;", "component27", "", "component28", "()Ljava/util/List;", "Lcom/avito/android/remote/model/AdvertActions;", "component29", "()Lcom/avito/android/remote/model/AdvertActions;", "Lcom/avito/android/remote/model/Action;", "component30", "()Lcom/avito/android/remote/model/Action;", "component31", "Lcom/avito/android/component/user_advert/PriceTypeBadge;", "component32", "()Lcom/avito/android/component/user_advert/PriceTypeBadge;", "Lcom/avito/android/remote/model/badge_bar/SerpBadgeBar;", "component33", "()Lcom/avito/android/remote/model/badge_bar/SerpBadgeBar;", "component34", "()Lcom/avito/android/remote/model/AdvertItemActions;", "component35", "Lcom/avito/android/remote/model/GeoReference;", "component36", "Lcom/avito/android/remote/model/RadiusInfo;", "component37", "()Lcom/avito/android/remote/model/RadiusInfo;", "Lcom/avito/android/remote/model/AdvertSellerInfo;", "component38", "()Lcom/avito/android/remote/model/AdvertSellerInfo;", "component39", "component40", "component41", "component42", "Lcom/avito/android/remote/model/ForegroundImage;", "component43", "()Lcom/avito/android/remote/model/ForegroundImage;", "component44", "component45", "()Ljava/lang/Integer;", "component46", "id", "stringId", "title", "description", "isHighlighted", "price", "priceWithoutDiscount", "previousPrice", "discountPercentage", "hasDelivery", "location", Sort.DISTANCE, IntegrityManager.INTEGRITY_TYPE_ADDRESS, "time", "image", "shopName", "spanCount", "viewType", "isActive", "displayType", "isFavorite", "analyticsContext", "isVerifiedSeller", "isViewed", "deepLink", "analyticParams", "shortTermRentTag", "imageList", "contacts", "additionalAction", "additionalName", "badge", "badgeBar", "categoryId", "geoReferences", "radiusInfo", "sellerInfo", "hasVideo", "inStock", "trustFactor", "isHidden", "infoImage", "isMarketplace", "locationId", "hidesViewedBadge", "copy", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLcom/avito/android/remote/model/Image;Ljava/lang/String;ILcom/avito/android/serp/adapter/SerpViewType;ZLcom/avito/android/remote/model/SerpDisplayType;ZLjava/lang/String;ZZLcom/avito/android/deep_linking/links/DeepLink;Ljava/util/Map;Ljava/lang/String;Ljava/util/List;Lcom/avito/android/remote/model/AdvertActions;Lcom/avito/android/remote/model/Action;Ljava/lang/String;Lcom/avito/android/component/user_advert/PriceTypeBadge;Lcom/avito/android/remote/model/badge_bar/SerpBadgeBar;Lcom/avito/android/remote/model/AdvertItemActions;Ljava/lang/String;Ljava/util/List;Lcom/avito/android/remote/model/RadiusInfo;Lcom/avito/android/remote/model/AdvertSellerInfo;ZLjava/lang/String;Ljava/lang/String;ZLcom/avito/android/remote/model/ForegroundImage;ZLjava/lang/Integer;Z)Lcom/avito/android/serp/adapter/AdvertItem;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", g.a, "Z", "d", "Ljava/lang/String;", "getStringId", "l", "getHasDelivery", "H", "Lcom/avito/android/component/user_advert/PriceTypeBadge;", "getBadge", "D", "Ljava/util/List;", "getImageList", "j", "getPreviousPrice", "I", "Lcom/avito/android/remote/model/badge_bar/SerpBadgeBar;", "getBadgeBar", "F", "Lcom/avito/android/remote/model/Action;", "getAdditionalAction", "C", "getShortTermRentTag", VKApiConst.Q, "Lcom/avito/android/remote/model/Image;", "getImage", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "getHidesViewedBadge", VKApiConst.VERSION, "Lcom/avito/android/remote/model/SerpDisplayType;", "getDisplayType", "setDisplayType", "(Lcom/avito/android/remote/model/SerpDisplayType;)V", "c", "J", "getId", "k", "getDiscountPercentage", "w", "setFavorite", "(Z)V", "M", "Lcom/avito/android/remote/model/RadiusInfo;", "getRadiusInfo", "e", "getTitle", "t", "Lcom/avito/android/serp/adapter/SerpViewType;", "getViewType", "h", "getPrice", AuthSource.BOOKING_ORDER, "getCanBeHidden", "canBeHidden", "Q", "getTrustFactor", "y", "L", "getGeoReferences", "r", "getShopName", "U", "Ljava/lang/Integer;", "getLocationId", "G", "getAdditionalName", AuthSource.OPEN_CHANNEL_LIST, "getLocation", "z", "setViewed", "R", "setHidden", ExifInterface.LATITUDE_SOUTH, "Lcom/avito/android/remote/model/ForegroundImage;", "getInfoImage", "T", "Lru/avito/component/serp/PhoneLoadingState;", AuthSource.SEND_ABUSE, "Lru/avito/component/serp/PhoneLoadingState;", "getPhoneLoadingState", "()Lru/avito/component/serp/PhoneLoadingState;", "setPhoneLoadingState", "(Lru/avito/component/serp/PhoneLoadingState;)V", "phoneLoadingState", "f", "getDescription", "o", "getAddress", "p", "getTime", ExifInterface.LONGITUDE_EAST, "Lcom/avito/android/remote/model/AdvertActions;", "getContacts", "x", "getAnalyticsContext", "O", "getHasVideo", "P", "getInStock", "B", "Ljava/util/Map;", "getAnalyticParams", "u", "Lcom/avito/android/remote/model/AdvertItemActions;", "getMoreActions", "s", "getSpanCount", "i", "getPriceWithoutDiscount", "K", "getCategoryId", "isExternalAd", "n", "getDistance", "N", "Lcom/avito/android/remote/model/AdvertSellerInfo;", "getSellerInfo", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLcom/avito/android/remote/model/Image;Ljava/lang/String;ILcom/avito/android/serp/adapter/SerpViewType;ZLcom/avito/android/remote/model/SerpDisplayType;ZLjava/lang/String;ZZLcom/avito/android/deep_linking/links/DeepLink;Ljava/util/Map;Ljava/lang/String;Ljava/util/List;Lcom/avito/android/remote/model/AdvertActions;Lcom/avito/android/remote/model/Action;Ljava/lang/String;Lcom/avito/android/component/user_advert/PriceTypeBadge;Lcom/avito/android/remote/model/badge_bar/SerpBadgeBar;Lcom/avito/android/remote/model/AdvertItemActions;Ljava/lang/String;Ljava/util/List;Lcom/avito/android/remote/model/RadiusInfo;Lcom/avito/android/remote/model/AdvertSellerInfo;ZLjava/lang/String;Ljava/lang/String;ZLcom/avito/android/remote/model/ForegroundImage;ZLjava/lang/Integer;Z)V", "Companion", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertItem implements DisplayTypeAwareItem, FavorableItem, PersistableSerpItem, ViewedAdvertItem, MoreActionsItem, AsyncPhoneItem {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<AdvertItem> CREATOR = Parcels.creator(a.a);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public final DeepLink A;
    @Nullable
    public final Map<String, String> B;
    @Nullable
    public final String C;
    @Nullable
    public final List<Image> D;
    @Nullable
    public final AdvertActions E;
    @Nullable
    public final Action F;
    @Nullable
    public final String G;
    @Nullable
    public final PriceTypeBadge H;
    @Nullable
    public final SerpBadgeBar I;
    @Nullable
    public final AdvertItemActions J;
    @Nullable
    public final String K;
    @Nullable
    public final List<GeoReference> L;
    @Nullable
    public final RadiusInfo M;
    @Nullable
    public final AdvertSellerInfo N;
    public final boolean O;
    @Nullable
    public final String P;
    @Nullable
    public final String Q;
    public boolean R;
    @Nullable
    public final ForegroundImage S;
    public final boolean T;
    @Nullable
    public final Integer U;
    public final boolean V;
    @NotNull
    public PhoneLoadingState a;
    public final boolean b;
    public final long c;
    @NotNull
    public final String d;
    @NotNull
    public final String e;
    @Nullable
    public final String f;
    public final boolean g;
    @Nullable
    public final String h;
    @Nullable
    public final String i;
    @Nullable
    public final String j;
    @Nullable
    public final String k;
    public final boolean l;
    @Nullable
    public final String m;
    @Nullable
    public final String n;
    @Nullable
    public final String o;
    public final long p;
    @Nullable
    public final Image q;
    @Nullable
    public final String r;
    public final int s;
    @NotNull
    public final SerpViewType t;
    public final boolean u;
    @NotNull
    public SerpDisplayType v;
    public boolean w;
    @Nullable
    public final String x;
    public final boolean y;
    public boolean z;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/serp/adapter/AdvertItem$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/serp/adapter/AdvertItem;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<Parcel, AdvertItem> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public AdvertItem invoke(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "$receiver");
            long readLong = parcel2.readLong();
            String u2 = a2.b.a.a.a.u2(parcel2, "readString()!!");
            String u22 = a2.b.a.a.a.u2(parcel2, "readString()!!");
            String readString = parcel2.readString();
            boolean readBool = ParcelsKt.readBool(parcel2);
            String readString2 = parcel2.readString();
            String readString3 = parcel2.readString();
            String readString4 = parcel2.readString();
            String readString5 = parcel2.readString();
            boolean readBool2 = ParcelsKt.readBool(parcel2);
            String readString6 = parcel2.readString();
            String readString7 = parcel2.readString();
            String readString8 = parcel2.readString();
            long readLong2 = parcel2.readLong();
            Image image = (Image) parcel2.readParcelable(Image.class.getClassLoader());
            String readString9 = parcel2.readString();
            int readInt = parcel2.readInt();
            SerpViewType serpViewType = (SerpViewType) ParcelsKt.readEnum(parcel2, SerpViewType.values());
            boolean readBool3 = ParcelsKt.readBool(parcel2);
            SerpDisplayType serpDisplayType = (SerpDisplayType) ParcelsKt.readEnum(parcel2, SerpDisplayType.values());
            boolean readBool4 = ParcelsKt.readBool(parcel2);
            String readString10 = parcel2.readString();
            boolean readBool5 = ParcelsKt.readBool(parcel2);
            boolean readBool6 = ParcelsKt.readBool(parcel2);
            DeepLink deepLink = (DeepLink) a2.b.a.a.a.z1(DeepLink.class, parcel2);
            Map createValueMap = ParcelUtils.createValueMap(parcel2, String.class, String.class);
            String readString11 = parcel2.readString();
            List createParcelableList = ParcelsKt.createParcelableList(parcel2, Image.class);
            AdvertActions advertActions = (AdvertActions) parcel2.readParcelable(AdvertActions.class.getClassLoader());
            Action action = (Action) parcel2.readParcelable(Action.class.getClassLoader());
            String readString12 = parcel2.readString();
            PriceTypeBadge priceTypeBadge = (PriceTypeBadge) parcel2.readParcelable(PriceTypeBadge.class.getClassLoader());
            SerpBadgeBar serpBadgeBar = (SerpBadgeBar) parcel2.readParcelable(SerpBadgeBar.class.getClassLoader());
            AdvertItemActions advertItemActions = (AdvertItemActions) parcel2.readParcelable(AdvertItemActions.class.getClassLoader());
            String readString13 = parcel2.readString();
            List createParcelableList2 = ParcelsKt.createParcelableList(parcel2, GeoReference.class);
            RadiusInfo radiusInfo = (RadiusInfo) parcel2.readParcelable(RadiusInfo.class.getClassLoader());
            AdvertSellerInfo advertSellerInfo = (AdvertSellerInfo) parcel2.readParcelable(AdvertSellerInfo.class.getClassLoader());
            boolean readBool7 = ParcelsKt.readBool(parcel2);
            String readString14 = parcel2.readString();
            String readString15 = parcel2.readString();
            boolean readBool8 = ParcelsKt.readBool(parcel2);
            ForegroundImage foregroundImage = (ForegroundImage) parcel2.readParcelable(ForegroundImage.class.getClassLoader());
            boolean readBool9 = ParcelsKt.readBool(parcel2);
            Object readValue = parcel2.readValue(Integer.class.getClassLoader());
            if (!(readValue instanceof Integer)) {
                readValue = null;
            }
            AdvertItem advertItem = new AdvertItem(readLong, u2, u22, readString, readBool, readString2, readString3, readString4, readString5, readBool2, readString6, readString7, readString8, readLong2, image, readString9, readInt, serpViewType, readBool3, serpDisplayType, readBool4, readString10, readBool5, readBool6, deepLink, createValueMap, readString11, createParcelableList, advertActions, action, readString12, priceTypeBadge, serpBadgeBar, advertItemActions, readString13, createParcelableList2, radiusInfo, advertSellerInfo, readBool7, readString14, readString15, readBool8, foregroundImage, readBool9, (Integer) readValue, ParcelsKt.readBool(parcel2));
            advertItem.setPhoneLoadingState((PhoneLoadingState) ParcelsKt.readEnum(parcel2, PhoneLoadingState.values()));
            return advertItem;
        }
    }

    public AdvertItem(long j2, @NotNull String str, @NotNull String str2, @Nullable String str3, boolean z2, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, boolean z3, @Nullable String str8, @Nullable String str9, @Nullable String str10, long j3, @Nullable Image image, @Nullable String str11, int i2, @NotNull SerpViewType serpViewType, boolean z4, @NotNull SerpDisplayType serpDisplayType, boolean z5, @Nullable String str12, boolean z7, boolean z8, @NotNull DeepLink deepLink, @Nullable Map<String, String> map, @Nullable String str13, @Nullable List<Image> list, @Nullable AdvertActions advertActions, @Nullable Action action, @Nullable String str14, @Nullable PriceTypeBadge priceTypeBadge, @Nullable SerpBadgeBar serpBadgeBar, @Nullable AdvertItemActions advertItemActions, @Nullable String str15, @Nullable List<GeoReference> list2, @Nullable RadiusInfo radiusInfo, @Nullable AdvertSellerInfo advertSellerInfo, boolean z9, @Nullable String str16, @Nullable String str17, boolean z10, @Nullable ForegroundImage foregroundImage, boolean z11, @Nullable Integer num, boolean z12) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(serpViewType, "viewType");
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        this.c = j2;
        this.d = str;
        this.e = str2;
        this.f = str3;
        this.g = z2;
        this.h = str4;
        this.i = str5;
        this.j = str6;
        this.k = str7;
        this.l = z3;
        this.m = str8;
        this.n = str9;
        this.o = str10;
        this.p = j3;
        this.q = image;
        this.r = str11;
        this.s = i2;
        this.t = serpViewType;
        this.u = z4;
        this.v = serpDisplayType;
        this.w = z5;
        this.x = str12;
        this.y = z7;
        this.z = z8;
        this.A = deepLink;
        this.B = map;
        this.C = str13;
        this.D = list;
        this.E = advertActions;
        this.F = action;
        this.G = str14;
        this.H = priceTypeBadge;
        this.I = serpBadgeBar;
        this.J = advertItemActions;
        this.K = str15;
        this.L = list2;
        this.M = radiusInfo;
        this.N = advertSellerInfo;
        this.O = z9;
        this.P = str16;
        this.Q = str17;
        this.R = z10;
        this.S = foregroundImage;
        this.T = z11;
        this.U = num;
        this.V = z12;
        this.a = PhoneLoadingState.IDLE;
        this.b = MoreActionsItemKt.canBeHidden(this);
    }

    public static /* synthetic */ AdvertItem copy$default(AdvertItem advertItem, long j2, String str, String str2, String str3, boolean z2, String str4, String str5, String str6, String str7, boolean z3, String str8, String str9, String str10, long j3, Image image, String str11, int i2, SerpViewType serpViewType, boolean z4, SerpDisplayType serpDisplayType, boolean z5, String str12, boolean z7, boolean z8, DeepLink deepLink, Map map, String str13, List list, AdvertActions advertActions, Action action, String str14, PriceTypeBadge priceTypeBadge, SerpBadgeBar serpBadgeBar, AdvertItemActions advertItemActions, String str15, List list2, RadiusInfo radiusInfo, AdvertSellerInfo advertSellerInfo, boolean z9, String str16, String str17, boolean z10, ForegroundImage foregroundImage, boolean z11, Integer num, boolean z12, int i3, int i4, Object obj) {
        return advertItem.copy((i3 & 1) != 0 ? advertItem.getId() : j2, (i3 & 2) != 0 ? advertItem.getStringId() : str, (i3 & 4) != 0 ? advertItem.e : str2, (i3 & 8) != 0 ? advertItem.f : str3, (i3 & 16) != 0 ? advertItem.g : z2, (i3 & 32) != 0 ? advertItem.h : str4, (i3 & 64) != 0 ? advertItem.i : str5, (i3 & 128) != 0 ? advertItem.j : str6, (i3 & 256) != 0 ? advertItem.k : str7, (i3 & 512) != 0 ? advertItem.l : z3, (i3 & 1024) != 0 ? advertItem.m : str8, (i3 & 2048) != 0 ? advertItem.n : str9, (i3 & 4096) != 0 ? advertItem.o : str10, (i3 & 8192) != 0 ? advertItem.p : j3, (i3 & 16384) != 0 ? advertItem.q : image, (32768 & i3) != 0 ? advertItem.r : str11, (i3 & 65536) != 0 ? advertItem.getSpanCount() : i2, (i3 & 131072) != 0 ? advertItem.getViewType() : serpViewType, (i3 & 262144) != 0 ? advertItem.u : z4, (i3 & 524288) != 0 ? advertItem.getDisplayType() : serpDisplayType, (i3 & 1048576) != 0 ? advertItem.isFavorite() : z5, (i3 & 2097152) != 0 ? advertItem.getAnalyticsContext() : str12, (i3 & 4194304) != 0 ? advertItem.y : z7, (i3 & 8388608) != 0 ? advertItem.isViewed() : z8, (i3 & 16777216) != 0 ? advertItem.A : deepLink, (i3 & 33554432) != 0 ? advertItem.B : map, (i3 & 67108864) != 0 ? advertItem.C : str13, (i3 & 134217728) != 0 ? advertItem.D : list, (i3 & 268435456) != 0 ? advertItem.E : advertActions, (i3 & 536870912) != 0 ? advertItem.F : action, (i3 & 1073741824) != 0 ? advertItem.G : str14, (i3 & Integer.MIN_VALUE) != 0 ? advertItem.H : priceTypeBadge, (i4 & 1) != 0 ? advertItem.I : serpBadgeBar, (i4 & 2) != 0 ? advertItem.getMoreActions() : advertItemActions, (i4 & 4) != 0 ? advertItem.K : str15, (i4 & 8) != 0 ? advertItem.L : list2, (i4 & 16) != 0 ? advertItem.M : radiusInfo, (i4 & 32) != 0 ? advertItem.N : advertSellerInfo, (i4 & 64) != 0 ? advertItem.O : z9, (i4 & 128) != 0 ? advertItem.P : str16, (i4 & 256) != 0 ? advertItem.Q : str17, (i4 & 512) != 0 ? advertItem.isHidden() : z10, (i4 & 1024) != 0 ? advertItem.S : foregroundImage, (i4 & 2048) != 0 ? advertItem.T : z11, (i4 & 4096) != 0 ? advertItem.U : num, (i4 & 8192) != 0 ? advertItem.V : z12);
    }

    public final long component1() {
        return getId();
    }

    public final boolean component10() {
        return this.l;
    }

    @Nullable
    public final String component11() {
        return this.m;
    }

    @Nullable
    public final String component12() {
        return this.n;
    }

    @Nullable
    public final String component13() {
        return this.o;
    }

    public final long component14() {
        return this.p;
    }

    @Nullable
    public final Image component15() {
        return this.q;
    }

    @Nullable
    public final String component16() {
        return this.r;
    }

    public final int component17() {
        return getSpanCount();
    }

    @NotNull
    public final SerpViewType component18() {
        return getViewType();
    }

    public final boolean component19() {
        return this.u;
    }

    @NotNull
    public final String component2() {
        return getStringId();
    }

    @NotNull
    public final SerpDisplayType component20() {
        return getDisplayType();
    }

    public final boolean component21() {
        return isFavorite();
    }

    @Nullable
    public final String component22() {
        return getAnalyticsContext();
    }

    public final boolean component23() {
        return this.y;
    }

    public final boolean component24() {
        return isViewed();
    }

    @NotNull
    public final DeepLink component25() {
        return this.A;
    }

    @Nullable
    public final Map<String, String> component26() {
        return this.B;
    }

    @Nullable
    public final String component27() {
        return this.C;
    }

    @Nullable
    public final List<Image> component28() {
        return this.D;
    }

    @Nullable
    public final AdvertActions component29() {
        return this.E;
    }

    @NotNull
    public final String component3() {
        return this.e;
    }

    @Nullable
    public final Action component30() {
        return this.F;
    }

    @Nullable
    public final String component31() {
        return this.G;
    }

    @Nullable
    public final PriceTypeBadge component32() {
        return this.H;
    }

    @Nullable
    public final SerpBadgeBar component33() {
        return this.I;
    }

    @Nullable
    public final AdvertItemActions component34() {
        return getMoreActions();
    }

    @Nullable
    public final String component35() {
        return this.K;
    }

    @Nullable
    public final List<GeoReference> component36() {
        return this.L;
    }

    @Nullable
    public final RadiusInfo component37() {
        return this.M;
    }

    @Nullable
    public final AdvertSellerInfo component38() {
        return this.N;
    }

    public final boolean component39() {
        return this.O;
    }

    @Nullable
    public final String component4() {
        return this.f;
    }

    @Nullable
    public final String component40() {
        return this.P;
    }

    @Nullable
    public final String component41() {
        return this.Q;
    }

    public final boolean component42() {
        return isHidden();
    }

    @Nullable
    public final ForegroundImage component43() {
        return this.S;
    }

    public final boolean component44() {
        return this.T;
    }

    @Nullable
    public final Integer component45() {
        return this.U;
    }

    public final boolean component46() {
        return this.V;
    }

    public final boolean component5() {
        return this.g;
    }

    @Nullable
    public final String component6() {
        return this.h;
    }

    @Nullable
    public final String component7() {
        return this.i;
    }

    @Nullable
    public final String component8() {
        return this.j;
    }

    @Nullable
    public final String component9() {
        return this.k;
    }

    @NotNull
    public final AdvertItem copy(long j2, @NotNull String str, @NotNull String str2, @Nullable String str3, boolean z2, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, boolean z3, @Nullable String str8, @Nullable String str9, @Nullable String str10, long j3, @Nullable Image image, @Nullable String str11, int i2, @NotNull SerpViewType serpViewType, boolean z4, @NotNull SerpDisplayType serpDisplayType, boolean z5, @Nullable String str12, boolean z7, boolean z8, @NotNull DeepLink deepLink, @Nullable Map<String, String> map, @Nullable String str13, @Nullable List<Image> list, @Nullable AdvertActions advertActions, @Nullable Action action, @Nullable String str14, @Nullable PriceTypeBadge priceTypeBadge, @Nullable SerpBadgeBar serpBadgeBar, @Nullable AdvertItemActions advertItemActions, @Nullable String str15, @Nullable List<GeoReference> list2, @Nullable RadiusInfo radiusInfo, @Nullable AdvertSellerInfo advertSellerInfo, boolean z9, @Nullable String str16, @Nullable String str17, boolean z10, @Nullable ForegroundImage foregroundImage, boolean z11, @Nullable Integer num, boolean z12) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(serpViewType, "viewType");
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        return new AdvertItem(j2, str, str2, str3, z2, str4, str5, str6, str7, z3, str8, str9, str10, j3, image, str11, i2, serpViewType, z4, serpDisplayType, z5, str12, z7, z8, deepLink, map, str13, list, advertActions, action, str14, priceTypeBadge, serpBadgeBar, advertItemActions, str15, list2, radiusInfo, advertSellerInfo, z9, str16, str17, z10, foregroundImage, z11, num, z12);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdvertItem)) {
            return false;
        }
        AdvertItem advertItem = (AdvertItem) obj;
        return getId() == advertItem.getId() && Intrinsics.areEqual(getStringId(), advertItem.getStringId()) && Intrinsics.areEqual(this.e, advertItem.e) && Intrinsics.areEqual(this.f, advertItem.f) && this.g == advertItem.g && Intrinsics.areEqual(this.h, advertItem.h) && Intrinsics.areEqual(this.i, advertItem.i) && Intrinsics.areEqual(this.j, advertItem.j) && Intrinsics.areEqual(this.k, advertItem.k) && this.l == advertItem.l && Intrinsics.areEqual(this.m, advertItem.m) && Intrinsics.areEqual(this.n, advertItem.n) && Intrinsics.areEqual(this.o, advertItem.o) && this.p == advertItem.p && Intrinsics.areEqual(this.q, advertItem.q) && Intrinsics.areEqual(this.r, advertItem.r) && getSpanCount() == advertItem.getSpanCount() && Intrinsics.areEqual(getViewType(), advertItem.getViewType()) && this.u == advertItem.u && Intrinsics.areEqual(getDisplayType(), advertItem.getDisplayType()) && isFavorite() == advertItem.isFavorite() && Intrinsics.areEqual(getAnalyticsContext(), advertItem.getAnalyticsContext()) && this.y == advertItem.y && isViewed() == advertItem.isViewed() && Intrinsics.areEqual(this.A, advertItem.A) && Intrinsics.areEqual(this.B, advertItem.B) && Intrinsics.areEqual(this.C, advertItem.C) && Intrinsics.areEqual(this.D, advertItem.D) && Intrinsics.areEqual(this.E, advertItem.E) && Intrinsics.areEqual(this.F, advertItem.F) && Intrinsics.areEqual(this.G, advertItem.G) && Intrinsics.areEqual(this.H, advertItem.H) && Intrinsics.areEqual(this.I, advertItem.I) && Intrinsics.areEqual(getMoreActions(), advertItem.getMoreActions()) && Intrinsics.areEqual(this.K, advertItem.K) && Intrinsics.areEqual(this.L, advertItem.L) && Intrinsics.areEqual(this.M, advertItem.M) && Intrinsics.areEqual(this.N, advertItem.N) && this.O == advertItem.O && Intrinsics.areEqual(this.P, advertItem.P) && Intrinsics.areEqual(this.Q, advertItem.Q) && isHidden() == advertItem.isHidden() && Intrinsics.areEqual(this.S, advertItem.S) && this.T == advertItem.T && Intrinsics.areEqual(this.U, advertItem.U) && this.V == advertItem.V;
    }

    @Nullable
    public final Action getAdditionalAction() {
        return this.F;
    }

    @Nullable
    public final String getAdditionalName() {
        return this.G;
    }

    @Nullable
    public final String getAddress() {
        return this.o;
    }

    @Nullable
    public final Map<String, String> getAnalyticParams() {
        return this.B;
    }

    @Override // com.avito.android.serp.adapter.FavorableItem
    @Nullable
    public String getAnalyticsContext() {
        return this.x;
    }

    @Nullable
    public final PriceTypeBadge getBadge() {
        return this.H;
    }

    @Nullable
    public final SerpBadgeBar getBadgeBar() {
        return this.I;
    }

    @Override // com.avito.android.adapter.HiddenAdvertItem
    public boolean getCanBeHidden() {
        return this.b;
    }

    @Nullable
    public final String getCategoryId() {
        return this.K;
    }

    @Nullable
    public final AdvertActions getContacts() {
        return this.E;
    }

    @NotNull
    public final DeepLink getDeepLink() {
        return this.A;
    }

    @Nullable
    public final String getDescription() {
        return this.f;
    }

    @Nullable
    public final String getDiscountPercentage() {
        return this.k;
    }

    @Override // com.avito.android.serp.adapter.DisplayTypeAwareItem
    @NotNull
    public SerpDisplayType getDisplayType() {
        return this.v;
    }

    @Nullable
    public final String getDistance() {
        return this.n;
    }

    @Nullable
    public final List<GeoReference> getGeoReferences() {
        return this.L;
    }

    public final boolean getHasDelivery() {
        return this.l;
    }

    @Override // com.avito.android.serp.adapter.PersistableSerpItem
    public boolean getHasStablePosition() {
        return PersistableSerpItem.DefaultImpls.getHasStablePosition(this);
    }

    public final boolean getHasVideo() {
        return this.O;
    }

    public final boolean getHidesViewedBadge() {
        return this.V;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return this.c;
    }

    @Nullable
    public final Image getImage() {
        return this.q;
    }

    @Nullable
    public final List<Image> getImageList() {
        return this.D;
    }

    @Nullable
    public final String getInStock() {
        return this.P;
    }

    @Nullable
    public final ForegroundImage getInfoImage() {
        return this.S;
    }

    @Nullable
    public final String getLocation() {
        return this.m;
    }

    @Nullable
    public final Integer getLocationId() {
        return this.U;
    }

    @Override // com.avito.android.adapter.MoreActionsItem
    @Nullable
    public AdvertItemActions getMoreActions() {
        return this.J;
    }

    @Override // com.avito.android.async_phone.AsyncPhoneItem
    @NotNull
    public PhoneLoadingState getPhoneLoadingState() {
        return this.a;
    }

    @Nullable
    public final String getPreviousPrice() {
        return this.j;
    }

    @Nullable
    public final String getPrice() {
        return this.h;
    }

    @Nullable
    public final String getPriceWithoutDiscount() {
        return this.i;
    }

    @Nullable
    public final String getProperLocation() {
        String str = this.m;
        boolean z2 = false;
        if (!(str == null || str.length() == 0)) {
            String str2 = this.n;
            if (str2 == null || str2.length() == 0) {
                z2 = true;
            }
            if (!z2) {
                return a2.b.a.a.a.s(new StringBuilder(), this.m, ',');
            }
        }
        return this.m;
    }

    @Nullable
    public final RadiusInfo getRadiusInfo() {
        return this.M;
    }

    @Nullable
    public final AdvertSellerInfo getSellerInfo() {
        return this.N;
    }

    @Nullable
    public final String getShopName() {
        return this.r;
    }

    @Nullable
    public final String getShortTermRentTag() {
        return this.C;
    }

    @Override // com.avito.android.serp.adapter.SpannedItem
    public int getSpanCount() {
        return this.s;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.d;
    }

    public final long getTime() {
        return this.p;
    }

    @NotNull
    public final String getTitle() {
        return this.e;
    }

    @Nullable
    public final String getTrustFactor() {
        return this.Q;
    }

    @Override // com.avito.android.serp.adapter.ViewTypeSerpItem
    @NotNull
    public SerpViewType getViewType() {
        return this.t;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int a3 = c.a(getId()) * 31;
        String stringId = getStringId();
        int i2 = 0;
        int hashCode = (a3 + (stringId != null ? stringId.hashCode() : 0)) * 31;
        String str = this.e;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z2 = this.g;
        int i3 = 1;
        if (z2) {
            z2 = true;
        }
        int i4 = z2 ? 1 : 0;
        int i5 = z2 ? 1 : 0;
        int i6 = z2 ? 1 : 0;
        int i7 = (hashCode3 + i4) * 31;
        String str3 = this.h;
        int hashCode4 = (i7 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.i;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.j;
        int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.k;
        int hashCode7 = (hashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31;
        boolean z3 = this.l;
        if (z3) {
            z3 = true;
        }
        int i8 = z3 ? 1 : 0;
        int i9 = z3 ? 1 : 0;
        int i10 = z3 ? 1 : 0;
        int i11 = (hashCode7 + i8) * 31;
        String str7 = this.m;
        int hashCode8 = (i11 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.n;
        int hashCode9 = (hashCode8 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.o;
        int hashCode10 = (((hashCode9 + (str9 != null ? str9.hashCode() : 0)) * 31) + c.a(this.p)) * 31;
        Image image = this.q;
        int hashCode11 = (hashCode10 + (image != null ? image.hashCode() : 0)) * 31;
        String str10 = this.r;
        int spanCount = (getSpanCount() + ((hashCode11 + (str10 != null ? str10.hashCode() : 0)) * 31)) * 31;
        SerpViewType viewType = getViewType();
        int hashCode12 = (spanCount + (viewType != null ? viewType.hashCode() : 0)) * 31;
        boolean z4 = this.u;
        if (z4) {
            z4 = true;
        }
        int i12 = z4 ? 1 : 0;
        int i13 = z4 ? 1 : 0;
        int i14 = z4 ? 1 : 0;
        int i15 = (hashCode12 + i12) * 31;
        SerpDisplayType displayType = getDisplayType();
        int hashCode13 = (i15 + (displayType != null ? displayType.hashCode() : 0)) * 31;
        boolean isFavorite = isFavorite();
        if (isFavorite) {
            isFavorite = true;
        }
        int i16 = isFavorite ? 1 : 0;
        int i17 = isFavorite ? 1 : 0;
        int i18 = isFavorite ? 1 : 0;
        int i19 = (hashCode13 + i16) * 31;
        String analyticsContext = getAnalyticsContext();
        int hashCode14 = (i19 + (analyticsContext != null ? analyticsContext.hashCode() : 0)) * 31;
        boolean z5 = this.y;
        if (z5) {
            z5 = true;
        }
        int i20 = z5 ? 1 : 0;
        int i21 = z5 ? 1 : 0;
        int i22 = z5 ? 1 : 0;
        int i23 = (hashCode14 + i20) * 31;
        boolean isViewed = isViewed();
        if (isViewed) {
            isViewed = true;
        }
        int i24 = isViewed ? 1 : 0;
        int i25 = isViewed ? 1 : 0;
        int i26 = isViewed ? 1 : 0;
        int i27 = (i23 + i24) * 31;
        DeepLink deepLink = this.A;
        int hashCode15 = (i27 + (deepLink != null ? deepLink.hashCode() : 0)) * 31;
        Map<String, String> map = this.B;
        int hashCode16 = (hashCode15 + (map != null ? map.hashCode() : 0)) * 31;
        String str11 = this.C;
        int hashCode17 = (hashCode16 + (str11 != null ? str11.hashCode() : 0)) * 31;
        List<Image> list = this.D;
        int hashCode18 = (hashCode17 + (list != null ? list.hashCode() : 0)) * 31;
        AdvertActions advertActions = this.E;
        int hashCode19 = (hashCode18 + (advertActions != null ? advertActions.hashCode() : 0)) * 31;
        Action action = this.F;
        int hashCode20 = (hashCode19 + (action != null ? action.hashCode() : 0)) * 31;
        String str12 = this.G;
        int hashCode21 = (hashCode20 + (str12 != null ? str12.hashCode() : 0)) * 31;
        PriceTypeBadge priceTypeBadge = this.H;
        int hashCode22 = (hashCode21 + (priceTypeBadge != null ? priceTypeBadge.hashCode() : 0)) * 31;
        SerpBadgeBar serpBadgeBar = this.I;
        int hashCode23 = (hashCode22 + (serpBadgeBar != null ? serpBadgeBar.hashCode() : 0)) * 31;
        AdvertItemActions moreActions = getMoreActions();
        int hashCode24 = (hashCode23 + (moreActions != null ? moreActions.hashCode() : 0)) * 31;
        String str13 = this.K;
        int hashCode25 = (hashCode24 + (str13 != null ? str13.hashCode() : 0)) * 31;
        List<GeoReference> list2 = this.L;
        int hashCode26 = (hashCode25 + (list2 != null ? list2.hashCode() : 0)) * 31;
        RadiusInfo radiusInfo = this.M;
        int hashCode27 = (hashCode26 + (radiusInfo != null ? radiusInfo.hashCode() : 0)) * 31;
        AdvertSellerInfo advertSellerInfo = this.N;
        int hashCode28 = (hashCode27 + (advertSellerInfo != null ? advertSellerInfo.hashCode() : 0)) * 31;
        boolean z7 = this.O;
        if (z7) {
            z7 = true;
        }
        int i28 = z7 ? 1 : 0;
        int i29 = z7 ? 1 : 0;
        int i30 = z7 ? 1 : 0;
        int i31 = (hashCode28 + i28) * 31;
        String str14 = this.P;
        int hashCode29 = (i31 + (str14 != null ? str14.hashCode() : 0)) * 31;
        String str15 = this.Q;
        int hashCode30 = (hashCode29 + (str15 != null ? str15.hashCode() : 0)) * 31;
        boolean isHidden = isHidden();
        if (isHidden) {
            isHidden = true;
        }
        int i32 = isHidden ? 1 : 0;
        int i33 = isHidden ? 1 : 0;
        int i34 = isHidden ? 1 : 0;
        int i35 = (hashCode30 + i32) * 31;
        ForegroundImage foregroundImage = this.S;
        int hashCode31 = (i35 + (foregroundImage != null ? foregroundImage.hashCode() : 0)) * 31;
        boolean z8 = this.T;
        if (z8) {
            z8 = true;
        }
        int i36 = z8 ? 1 : 0;
        int i37 = z8 ? 1 : 0;
        int i38 = z8 ? 1 : 0;
        int i39 = (hashCode31 + i36) * 31;
        Integer num = this.U;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i40 = (i39 + i2) * 31;
        boolean z9 = this.V;
        if (!z9) {
            i3 = z9 ? 1 : 0;
        }
        return i40 + i3;
    }

    public final boolean isActive() {
        return this.u;
    }

    @Override // com.avito.android.serp.adapter.PersistableSerpItem
    public boolean isExternalAd() {
        return false;
    }

    @Override // com.avito.android.serp.adapter.FavorableItem
    public boolean isFavorite() {
        return this.w;
    }

    @Override // com.avito.android.adapter.HiddenAdvertItem
    public boolean isHidden() {
        return this.R;
    }

    public final boolean isHighlighted() {
        return this.g;
    }

    public final boolean isMarketplace() {
        return this.T;
    }

    public final boolean isVerifiedSeller() {
        return this.y;
    }

    @Override // com.avito.android.serp.adapter.ViewedAdvertItem
    public boolean isViewed() {
        return this.z;
    }

    @Override // com.avito.android.serp.adapter.DisplayTypeAwareItem
    public void setDisplayType(@NotNull SerpDisplayType serpDisplayType) {
        Intrinsics.checkNotNullParameter(serpDisplayType, "<set-?>");
        this.v = serpDisplayType;
    }

    @Override // com.avito.android.serp.adapter.FavorableItem
    public void setFavorite(boolean z2) {
        this.w = z2;
    }

    @Override // com.avito.android.adapter.HiddenAdvertItem
    public void setHidden(boolean z2) {
        this.R = z2;
    }

    @Override // com.avito.android.async_phone.AsyncPhoneItem
    public void setPhoneLoadingState(@NotNull PhoneLoadingState phoneLoadingState) {
        Intrinsics.checkNotNullParameter(phoneLoadingState, "<set-?>");
        this.a = phoneLoadingState;
    }

    @Override // com.avito.android.serp.adapter.ViewedAdvertItem
    public void setViewed(boolean z2) {
        this.z = z2;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L2 = a2.b.a.a.a.L("AdvertItem(id=");
        L2.append(getId());
        L2.append(", stringId=");
        L2.append(getStringId());
        L2.append(", title=");
        L2.append(this.e);
        L2.append(", description=");
        L2.append(this.f);
        L2.append(", isHighlighted=");
        L2.append(this.g);
        L2.append(", price=");
        L2.append(this.h);
        L2.append(", priceWithoutDiscount=");
        L2.append(this.i);
        L2.append(", previousPrice=");
        L2.append(this.j);
        L2.append(", discountPercentage=");
        L2.append(this.k);
        L2.append(", hasDelivery=");
        L2.append(this.l);
        L2.append(", location=");
        L2.append(this.m);
        L2.append(", distance=");
        L2.append(this.n);
        L2.append(", address=");
        L2.append(this.o);
        L2.append(", time=");
        L2.append(this.p);
        L2.append(", image=");
        L2.append(this.q);
        L2.append(", shopName=");
        L2.append(this.r);
        L2.append(", spanCount=");
        L2.append(getSpanCount());
        L2.append(", viewType=");
        L2.append(getViewType());
        L2.append(", isActive=");
        L2.append(this.u);
        L2.append(", displayType=");
        L2.append(getDisplayType());
        L2.append(", isFavorite=");
        L2.append(isFavorite());
        L2.append(", analyticsContext=");
        L2.append(getAnalyticsContext());
        L2.append(", isVerifiedSeller=");
        L2.append(this.y);
        L2.append(", isViewed=");
        L2.append(isViewed());
        L2.append(", deepLink=");
        L2.append(this.A);
        L2.append(", analyticParams=");
        L2.append(this.B);
        L2.append(", shortTermRentTag=");
        L2.append(this.C);
        L2.append(", imageList=");
        L2.append(this.D);
        L2.append(", contacts=");
        L2.append(this.E);
        L2.append(", additionalAction=");
        L2.append(this.F);
        L2.append(", additionalName=");
        L2.append(this.G);
        L2.append(", badge=");
        L2.append(this.H);
        L2.append(", badgeBar=");
        L2.append(this.I);
        L2.append(", moreActions=");
        L2.append(getMoreActions());
        L2.append(", categoryId=");
        L2.append(this.K);
        L2.append(", geoReferences=");
        L2.append(this.L);
        L2.append(", radiusInfo=");
        L2.append(this.M);
        L2.append(", sellerInfo=");
        L2.append(this.N);
        L2.append(", hasVideo=");
        L2.append(this.O);
        L2.append(", inStock=");
        L2.append(this.P);
        L2.append(", trustFactor=");
        L2.append(this.Q);
        L2.append(", isHidden=");
        L2.append(isHidden());
        L2.append(", infoImage=");
        L2.append(this.S);
        L2.append(", isMarketplace=");
        L2.append(this.T);
        L2.append(", locationId=");
        L2.append(this.U);
        L2.append(", hidesViewedBadge=");
        return a2.b.a.a.a.B(L2, this.V, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeLong(getId());
        parcel.writeString(getStringId());
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        ParcelsKt.writeBool(parcel, this.g);
        parcel.writeString(this.h);
        parcel.writeString(this.i);
        parcel.writeString(this.j);
        parcel.writeString(this.k);
        ParcelsKt.writeBool(parcel, this.l);
        parcel.writeString(this.m);
        parcel.writeString(this.n);
        parcel.writeString(this.o);
        parcel.writeLong(this.p);
        parcel.writeParcelable(this.q, i2);
        parcel.writeString(this.r);
        parcel.writeInt(getSpanCount());
        ParcelsKt.writeEnum(parcel, getViewType());
        ParcelsKt.writeBool(parcel, this.u);
        ParcelsKt.writeEnum(parcel, getDisplayType());
        ParcelsKt.writeBool(parcel, isFavorite());
        parcel.writeString(getAnalyticsContext());
        ParcelsKt.writeBool(parcel, this.y);
        ParcelsKt.writeBool(parcel, isViewed());
        parcel.writeParcelable(this.A, i2);
        ParcelsKt.writeValueMap(parcel, this.B);
        parcel.writeString(this.C);
        ParcelsKt.writeOptimizedParcelableList$default(parcel, this.D, 0, 2, null);
        parcel.writeParcelable(this.E, i2);
        parcel.writeParcelable(this.F, i2);
        parcel.writeString(this.G);
        parcel.writeParcelable(this.H, i2);
        parcel.writeParcelable(this.I, i2);
        parcel.writeParcelable(getMoreActions(), i2);
        parcel.writeString(this.K);
        ParcelsKt.writeOptimizedParcelableList(parcel, this.L, i2);
        parcel.writeParcelable(this.M, i2);
        parcel.writeParcelable(this.N, i2);
        ParcelsKt.writeBool(parcel, this.O);
        parcel.writeString(this.P);
        parcel.writeString(this.Q);
        ParcelsKt.writeBool(parcel, isHidden());
        parcel.writeParcelable(this.S, i2);
        ParcelsKt.writeBool(parcel, this.T);
        ParcelsKt.writeNullableValue(parcel, this.U);
        ParcelsKt.writeEnum(parcel, getPhoneLoadingState());
        ParcelsKt.writeBool(parcel, this.V);
    }

    @Override // com.avito.android.adapter.MoreActionsItem
    @NotNull
    public AdvertItem copyWithMoreActions(@NotNull AdvertItemActions advertItemActions) {
        Intrinsics.checkNotNullParameter(advertItemActions, "moreActions");
        return copy$default(this, 0, null, null, null, false, null, null, null, null, false, null, null, null, 0, null, null, 0, null, false, null, false, null, false, false, null, null, null, null, null, null, null, null, null, advertItemActions, null, null, null, null, false, null, null, false, null, false, null, false, -1, 16381, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AdvertItem(long j2, String str, String str2, String str3, boolean z2, String str4, String str5, String str6, String str7, boolean z3, String str8, String str9, String str10, long j3, Image image, String str11, int i2, SerpViewType serpViewType, boolean z4, SerpDisplayType serpDisplayType, boolean z5, String str12, boolean z7, boolean z8, DeepLink deepLink, Map map, String str13, List list, AdvertActions advertActions, Action action, String str14, PriceTypeBadge priceTypeBadge, SerpBadgeBar serpBadgeBar, AdvertItemActions advertItemActions, String str15, List list2, RadiusInfo radiusInfo, AdvertSellerInfo advertSellerInfo, boolean z9, String str16, String str17, boolean z10, ForegroundImage foregroundImage, boolean z11, Integer num, boolean z12, int i3, int i4, j jVar) {
        this(j2, str, str2, (i3 & 8) != 0 ? null : str3, z2, str4, (i3 & 64) != 0 ? null : str5, (i3 & 128) != 0 ? null : str6, (i3 & 256) != 0 ? null : str7, z3, str8, str9, str10, j3, image, str11, i2, serpViewType, z4, serpDisplayType, (1048576 & i3) != 0 ? false : z5, str12, (4194304 & i3) != 0 ? false : z7, (8388608 & i3) != 0 ? false : z8, deepLink, map, (67108864 & i3) != 0 ? null : str13, (134217728 & i3) != 0 ? null : list, (268435456 & i3) != 0 ? null : advertActions, (536870912 & i3) != 0 ? null : action, (1073741824 & i3) != 0 ? null : str14, (i3 & Integer.MIN_VALUE) != 0 ? null : priceTypeBadge, (i4 & 1) != 0 ? null : serpBadgeBar, (i4 & 2) != 0 ? null : advertItemActions, (i4 & 4) != 0 ? null : str15, (i4 & 8) != 0 ? null : list2, (i4 & 16) != 0 ? null : radiusInfo, (i4 & 32) != 0 ? null : advertSellerInfo, (i4 & 64) != 0 ? false : z9, (i4 & 128) != 0 ? null : str16, (i4 & 256) != 0 ? null : str17, (i4 & 512) != 0 ? false : z10, (i4 & 1024) != 0 ? null : foregroundImage, (i4 & 2048) != 0 ? false : z11, (i4 & 4096) != 0 ? null : num, (i4 & 8192) != 0 ? false : z12);
    }
}
