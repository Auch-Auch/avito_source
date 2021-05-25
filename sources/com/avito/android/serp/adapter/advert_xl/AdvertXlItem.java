package com.avito.android.serp.adapter.advert_xl;

import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.async_phone.AsyncPhoneItem;
import com.avito.android.component.user_advert.PriceTypeBadge;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.AdvertActions;
import com.avito.android.remote.model.AdvertSellerInfo;
import com.avito.android.remote.model.ForegroundImage;
import com.avito.android.remote.model.GeoReference;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.RadiusInfo;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.remote.model.Sort;
import com.avito.android.remote.model.badge_bar.SerpBadgeBar;
import com.avito.android.serp.adapter.DisplayTypeAwareItem;
import com.avito.android.serp.adapter.FavorableItem;
import com.avito.android.serp.adapter.PersistableSerpItem;
import com.avito.android.serp.adapter.SerpViewType;
import com.avito.android.serp.adapter.ViewedAdvertItem;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0010\u0000\n\u0002\bE\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0011\b\b\u0018\u0000 â\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0002â\u0001B\u0003\u0012\u0006\u0010Q\u001a\u00020\u000f\u0012\u0006\u0010R\u001a\u00020\u0012\u0012\u000e\u0010S\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015\u0012\u0006\u0010T\u001a\u00020\u0019\u0012\b\u0010U\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010V\u001a\u00020\b\u0012\u0006\u0010W\u001a\u00020\u001e\u0012\u0006\u0010X\u001a\u00020\u0012\u0012\b\u0010Y\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010Z\u001a\u00020\u0019\u0012\b\u0010[\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\\\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010]\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010^\u001a\u00020\u000f\u0012\b\u0010_\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010`\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010a\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010b\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010c\u001a\u00020,\u0012\u0014\u0010d\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0018\u00010/\u0012\b\u0010e\u001a\u0004\u0018\u000102\u0012\b\u0010f\u001a\u0004\u0018\u000105\u0012\u0006\u0010g\u001a\u00020\u0019\u0012\u0006\u0010h\u001a\u00020\u0019\u0012\u0006\u0010i\u001a\u00020\u0019\u0012\b\u0010j\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010k\u001a\u00020\u0019\u0012\n\b\u0002\u0010l\u001a\u0004\u0018\u00010=\u0012\n\b\u0002\u0010m\u001a\u0004\u0018\u00010@\u0012\n\b\u0002\u0010n\u001a\u0004\u0018\u00010C\u0012\n\b\u0002\u0010o\u001a\u0004\u0018\u00010F\u0012\u0010\b\u0002\u0010p\u001a\n\u0012\u0004\u0012\u00020I\u0018\u00010\u0015\u0012\n\b\u0002\u0010q\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010r\u001a\u00020\u0019\u0012\n\b\u0002\u0010s\u001a\u0004\u0018\u00010M\u0012\b\b\u0002\u0010t\u001a\u00020\u0019¢\u0006\u0006\bà\u0001\u0010á\u0001J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u0014J\u0010\u0010\u001d\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u001d\u0010\u000eJ\u0010\u0010\u001f\u001a\u00020\u001eHÆ\u0003¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u0012HÆ\u0003¢\u0006\u0004\b!\u0010\u0014J\u0012\u0010\"\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\b\"\u0010\u0014J\u0010\u0010#\u001a\u00020\u0019HÆ\u0003¢\u0006\u0004\b#\u0010\u001bJ\u0012\u0010$\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\b$\u0010\u0014J\u0012\u0010%\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\b%\u0010\u0014J\u0012\u0010&\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\b&\u0010\u0014J\u0010\u0010'\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b'\u0010\u0011J\u0012\u0010(\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\b(\u0010\u0014J\u0012\u0010)\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\b)\u0010\u0014J\u0012\u0010*\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\b*\u0010\u0014J\u0012\u0010+\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\b+\u0010\u0014J\u0010\u0010-\u001a\u00020,HÆ\u0003¢\u0006\u0004\b-\u0010.J\u001e\u00100\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0018\u00010/HÆ\u0003¢\u0006\u0004\b0\u00101J\u0012\u00103\u001a\u0004\u0018\u000102HÆ\u0003¢\u0006\u0004\b3\u00104J\u0012\u00106\u001a\u0004\u0018\u000105HÆ\u0003¢\u0006\u0004\b6\u00107J\u0010\u00108\u001a\u00020\u0019HÆ\u0003¢\u0006\u0004\b8\u0010\u001bJ\u0010\u00109\u001a\u00020\u0019HÆ\u0003¢\u0006\u0004\b9\u0010\u001bJ\u0010\u0010:\u001a\u00020\u0019HÆ\u0003¢\u0006\u0004\b:\u0010\u001bJ\u0012\u0010;\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\b;\u0010\u0014J\u0010\u0010<\u001a\u00020\u0019HÆ\u0003¢\u0006\u0004\b<\u0010\u001bJ\u0012\u0010>\u001a\u0004\u0018\u00010=HÆ\u0003¢\u0006\u0004\b>\u0010?J\u0012\u0010A\u001a\u0004\u0018\u00010@HÆ\u0003¢\u0006\u0004\bA\u0010BJ\u0012\u0010D\u001a\u0004\u0018\u00010CHÆ\u0003¢\u0006\u0004\bD\u0010EJ\u0012\u0010G\u001a\u0004\u0018\u00010FHÆ\u0003¢\u0006\u0004\bG\u0010HJ\u0018\u0010J\u001a\n\u0012\u0004\u0012\u00020I\u0018\u00010\u0015HÆ\u0003¢\u0006\u0004\bJ\u0010\u0018J\u0012\u0010K\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\bK\u0010\u0014J\u0010\u0010L\u001a\u00020\u0019HÆ\u0003¢\u0006\u0004\bL\u0010\u001bJ\u0012\u0010N\u001a\u0004\u0018\u00010MHÆ\u0003¢\u0006\u0004\bN\u0010OJ\u0010\u0010P\u001a\u00020\u0019HÆ\u0003¢\u0006\u0004\bP\u0010\u001bJº\u0003\u0010u\u001a\u00020\u00002\b\b\u0002\u0010Q\u001a\u00020\u000f2\b\b\u0002\u0010R\u001a\u00020\u00122\u0010\b\u0002\u0010S\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00152\b\b\u0002\u0010T\u001a\u00020\u00192\n\b\u0002\u0010U\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010V\u001a\u00020\b2\b\b\u0002\u0010W\u001a\u00020\u001e2\b\b\u0002\u0010X\u001a\u00020\u00122\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010Z\u001a\u00020\u00192\n\b\u0002\u0010[\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010]\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010^\u001a\u00020\u000f2\n\b\u0002\u0010_\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010`\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010a\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010b\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010c\u001a\u00020,2\u0016\b\u0002\u0010d\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0018\u00010/2\n\b\u0002\u0010e\u001a\u0004\u0018\u0001022\n\b\u0002\u0010f\u001a\u0004\u0018\u0001052\b\b\u0002\u0010g\u001a\u00020\u00192\b\b\u0002\u0010h\u001a\u00020\u00192\b\b\u0002\u0010i\u001a\u00020\u00192\n\b\u0002\u0010j\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010k\u001a\u00020\u00192\n\b\u0002\u0010l\u001a\u0004\u0018\u00010=2\n\b\u0002\u0010m\u001a\u0004\u0018\u00010@2\n\b\u0002\u0010n\u001a\u0004\u0018\u00010C2\n\b\u0002\u0010o\u001a\u0004\u0018\u00010F2\u0010\b\u0002\u0010p\u001a\n\u0012\u0004\u0012\u00020I\u0018\u00010\u00152\n\b\u0002\u0010q\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010r\u001a\u00020\u00192\n\b\u0002\u0010s\u001a\u0004\u0018\u00010M2\b\b\u0002\u0010t\u001a\u00020\u0019HÆ\u0001¢\u0006\u0004\bu\u0010vJ\u0010\u0010w\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\bw\u0010\u0014J\u0010\u0010x\u001a\u00020\bHÖ\u0001¢\u0006\u0004\bx\u0010\u000eJ\u001a\u0010{\u001a\u00020\u00192\b\u0010z\u001a\u0004\u0018\u00010yHÖ\u0003¢\u0006\u0004\b{\u0010|R\u0019\u0010c\u001a\u00020,8\u0006@\u0006¢\u0006\f\n\u0004\b}\u0010~\u001a\u0004\b\u0010.R\u001c\u0010X\u001a\u00020\u00128\u0006@\u0006¢\u0006\u000f\n\u0006\b\u0001\u0010\u0001\u001a\u0005\b\u0001\u0010\u0014R\u001c\u0010Z\u001a\u00020\u00198\u0006@\u0006¢\u0006\u000f\n\u0006\b\u0001\u0010\u0001\u001a\u0005\b\u0001\u0010\u001bR\u001f\u0010R\u001a\u00020\u00128\u0016@\u0016X\u0004¢\u0006\u000f\n\u0006\b\u0001\u0010\u0001\u001a\u0005\b\u0001\u0010\u0014R\u001e\u0010f\u001a\u0004\u0018\u0001058\u0006@\u0006¢\u0006\u000f\n\u0006\b\u0001\u0010\u0001\u001a\u0005\b\u0001\u00107R\u001e\u0010n\u001a\u0004\u0018\u00010C8\u0006@\u0006¢\u0006\u000f\n\u0006\b\u0001\u0010\u0001\u001a\u0005\b\u0001\u0010ER&\u0010T\u001a\u00020\u00198\u0016@\u0016X\u000e¢\u0006\u0016\n\u0006\b\u0001\u0010\u0001\u001a\u0004\bT\u0010\u001b\"\u0006\b\u0001\u0010\u0001R\u001f\u0010V\u001a\u00020\b8\u0016@\u0016X\u0004¢\u0006\u000f\n\u0006\b\u0001\u0010\u0001\u001a\u0005\b\u0001\u0010\u000eR\u001e\u0010j\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\u000f\n\u0006\b\u0001\u0010\u0001\u001a\u0005\b\u0001\u0010\u0014R\u001b\u0010g\u001a\u00020\u00198\u0006@\u0006¢\u0006\u000e\n\u0006\b\u0001\u0010\u0001\u001a\u0004\bg\u0010\u001bR\u001c\u0010^\u001a\u00020\u000f8\u0006@\u0006¢\u0006\u000f\n\u0006\b\u0001\u0010\u0001\u001a\u0005\b\u0001\u0010\u0011R\u001b\u0010t\u001a\u00020\u00198\u0006@\u0006¢\u0006\u000e\n\u0006\b\u0001\u0010\u0001\u001a\u0004\bt\u0010\u001bR\u001c\u0010r\u001a\u00020\u00198\u0006@\u0006¢\u0006\u000f\n\u0006\b\u0001\u0010\u0001\u001a\u0005\b\u0001\u0010\u001bR*\u0010d\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0018\u00010/8\u0006@\u0006¢\u0006\u000f\n\u0006\b\u0001\u0010\u0001\u001a\u0005\b\u0001\u00101R\u001e\u0010[\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\u000f\n\u0006\b\u0001\u0010\u0001\u001a\u0005\b \u0001\u0010\u0014R'\u0010W\u001a\u00020\u001e8\u0016@\u0016X\u000e¢\u0006\u0017\n\u0006\b¡\u0001\u0010¢\u0001\u001a\u0005\b£\u0001\u0010 \"\u0006\b¤\u0001\u0010¥\u0001R\u001e\u0010Y\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\u000f\n\u0006\b¦\u0001\u0010\u0001\u001a\u0005\b§\u0001\u0010\u0014R\u001b\u0010h\u001a\u00020\u00198\u0006@\u0006¢\u0006\u000e\n\u0006\b¨\u0001\u0010\u0001\u001a\u0004\bh\u0010\u001bR&\u0010k\u001a\u00020\u00198\u0016@\u0016X\u000e¢\u0006\u0016\n\u0006\b©\u0001\u0010\u0001\u001a\u0004\bk\u0010\u001b\"\u0006\bª\u0001\u0010\u0001R$\u0010S\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00158\u0006@\u0006¢\u0006\u000f\n\u0006\b«\u0001\u0010¬\u0001\u001a\u0005\b­\u0001\u0010\u0018R$\u0010p\u001a\n\u0012\u0004\u0012\u00020I\u0018\u00010\u00158\u0006@\u0006¢\u0006\u000f\n\u0006\b®\u0001\u0010¬\u0001\u001a\u0005\b¯\u0001\u0010\u0018R!\u0010U\u001a\u0004\u0018\u00010\u00128\u0016@\u0016X\u0004¢\u0006\u000f\n\u0006\b°\u0001\u0010\u0001\u001a\u0005\b±\u0001\u0010\u0014R\u001e\u0010q\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\u000f\n\u0006\b\u0001\u0010\u0001\u001a\u0005\b²\u0001\u0010\u0014R\u001e\u0010`\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\u000f\n\u0006\b³\u0001\u0010\u0001\u001a\u0005\b´\u0001\u0010\u0014R\u001e\u0010_\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\u000f\n\u0006\bµ\u0001\u0010\u0001\u001a\u0005\b¶\u0001\u0010\u0014R\u001f\u0010Q\u001a\u00020\u000f8\u0016@\u0016X\u0004¢\u0006\u000f\n\u0006\b·\u0001\u0010\u0001\u001a\u0005\b¸\u0001\u0010\u0011R\u001e\u0010o\u001a\u0004\u0018\u00010F8\u0006@\u0006¢\u0006\u000f\n\u0006\b¹\u0001\u0010º\u0001\u001a\u0005\b»\u0001\u0010HR\u001e\u0010m\u001a\u0004\u0018\u00010@8\u0006@\u0006¢\u0006\u000f\n\u0006\b¼\u0001\u0010½\u0001\u001a\u0005\b¾\u0001\u0010BR\"\u0010Ä\u0001\u001a\u00030¿\u00018\u0016@\u0016X\u0004¢\u0006\u0010\n\u0006\bÀ\u0001\u0010Á\u0001\u001a\u0006\bÂ\u0001\u0010Ã\u0001R\u001b\u0010i\u001a\u00020\u00198\u0006@\u0006¢\u0006\u000e\n\u0006\bÅ\u0001\u0010\u0001\u001a\u0004\bi\u0010\u001bR\u001e\u0010\\\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\u000f\n\u0006\bÆ\u0001\u0010\u0001\u001a\u0005\bÇ\u0001\u0010\u0014R\u001e\u0010e\u001a\u0004\u0018\u0001028\u0006@\u0006¢\u0006\u000f\n\u0006\bÈ\u0001\u0010É\u0001\u001a\u0005\bÊ\u0001\u00104R\u001e\u0010l\u001a\u0004\u0018\u00010=8\u0006@\u0006¢\u0006\u000f\n\u0006\bË\u0001\u0010Ì\u0001\u001a\u0005\bÍ\u0001\u0010?R \u0010Î\u0001\u001a\u00020\u00198\u0016@\u0016XD¢\u0006\u000f\n\u0006\bÎ\u0001\u0010\u0001\u001a\u0005\bÎ\u0001\u0010\u001bR\u001e\u0010s\u001a\u0004\u0018\u00010M8\u0006@\u0006¢\u0006\u000f\n\u0006\bÏ\u0001\u0010Ð\u0001\u001a\u0005\bÑ\u0001\u0010OR*\u0010Ù\u0001\u001a\u00030Ò\u00018\u0016@\u0016X\u000e¢\u0006\u0018\n\u0006\bÓ\u0001\u0010Ô\u0001\u001a\u0006\bÕ\u0001\u0010Ö\u0001\"\u0006\b×\u0001\u0010Ø\u0001R\u001e\u0010]\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\u000f\n\u0006\bÚ\u0001\u0010\u0001\u001a\u0005\bÛ\u0001\u0010\u0014R\u001e\u0010a\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\u000f\n\u0006\bÜ\u0001\u0010\u0001\u001a\u0005\bÝ\u0001\u0010\u0014R\u001e\u0010b\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\u000f\n\u0006\bÞ\u0001\u0010\u0001\u001a\u0005\bß\u0001\u0010\u0014¨\u0006ã\u0001"}, d2 = {"Lcom/avito/android/serp/adapter/advert_xl/AdvertXlItem;", "Lcom/avito/android/async_phone/AsyncPhoneItem;", "Lcom/avito/android/serp/adapter/FavorableItem;", "Lcom/avito/android/serp/adapter/PersistableSerpItem;", "Lcom/avito/android/serp/adapter/ViewedAdvertItem;", "Lcom/avito/android/serp/adapter/DisplayTypeAwareItem;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "component1", "()J", "", "component2", "()Ljava/lang/String;", "", "Lcom/avito/android/remote/model/Image;", "component3", "()Ljava/util/List;", "", "component4", "()Z", "component5", "component6", "Lcom/avito/android/remote/model/SerpDisplayType;", "component7", "()Lcom/avito/android/remote/model/SerpDisplayType;", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "Lcom/avito/android/deep_linking/links/DeepLink;", "component19", "()Lcom/avito/android/deep_linking/links/DeepLink;", "", "component20", "()Ljava/util/Map;", "Lcom/avito/android/remote/model/Action;", "component21", "()Lcom/avito/android/remote/model/Action;", "Lcom/avito/android/remote/model/AdvertActions;", "component22", "()Lcom/avito/android/remote/model/AdvertActions;", "component23", "component24", "component25", "component26", "component27", "Lcom/avito/android/component/user_advert/PriceTypeBadge;", "component28", "()Lcom/avito/android/component/user_advert/PriceTypeBadge;", "Lcom/avito/android/remote/model/badge_bar/SerpBadgeBar;", "component29", "()Lcom/avito/android/remote/model/badge_bar/SerpBadgeBar;", "Lcom/avito/android/remote/model/RadiusInfo;", "component30", "()Lcom/avito/android/remote/model/RadiusInfo;", "Lcom/avito/android/remote/model/AdvertSellerInfo;", "component31", "()Lcom/avito/android/remote/model/AdvertSellerInfo;", "Lcom/avito/android/remote/model/GeoReference;", "component32", "component33", "component34", "Lcom/avito/android/remote/model/ForegroundImage;", "component35", "()Lcom/avito/android/remote/model/ForegroundImage;", "component36", "id", "stringId", "imageList", "isFavorite", "analyticsContext", "spanCount", "displayType", "title", "description", "hasDelivery", "shopName", "location", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "time", "price", "priceWithoutDiscount", "previousPrice", "discountPercentage", "deepLink", "analyticParams", "callAction", "contacts", "isHighlighted", "isActive", "isVerifiedSeller", "additionalName", "isViewed", "badge", "badgeBar", "radiusInfo", "sellerInfo", "geoReferences", Sort.DISTANCE, "hasVideo", "infoImage", "isMarketplace", "copy", "(JLjava/lang/String;Ljava/util/List;ZLjava/lang/String;ILcom/avito/android/remote/model/SerpDisplayType;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;Ljava/util/Map;Lcom/avito/android/remote/model/Action;Lcom/avito/android/remote/model/AdvertActions;ZZZLjava/lang/String;ZLcom/avito/android/component/user_advert/PriceTypeBadge;Lcom/avito/android/remote/model/badge_bar/SerpBadgeBar;Lcom/avito/android/remote/model/RadiusInfo;Lcom/avito/android/remote/model/AdvertSellerInfo;Ljava/util/List;Ljava/lang/String;ZLcom/avito/android/remote/model/ForegroundImage;Z)Lcom/avito/android/serp/adapter/advert_xl/AdvertXlItem;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "u", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "j", "Ljava/lang/String;", "getTitle", "l", "Z", "getHasDelivery", "d", "getStringId", "x", "Lcom/avito/android/remote/model/AdvertActions;", "getContacts", "F", "Lcom/avito/android/remote/model/RadiusInfo;", "getRadiusInfo", "f", "setFavorite", "(Z)V", "h", "I", "getSpanCount", "B", "getAdditionalName", "y", "p", "J", "getTime", "L", "getHasVideo", VKApiConst.VERSION, "Ljava/util/Map;", "getAnalyticParams", AuthSource.OPEN_CHANNEL_LIST, "getShopName", "i", "Lcom/avito/android/remote/model/SerpDisplayType;", "getDisplayType", "setDisplayType", "(Lcom/avito/android/remote/model/SerpDisplayType;)V", "k", "getDescription", "z", "C", "setViewed", "e", "Ljava/util/List;", "getImageList", "H", "getGeoReferences", g.a, "getAnalyticsContext", "getDistance", "r", "getPriceWithoutDiscount", VKApiConst.Q, "getPrice", "c", "getId", "G", "Lcom/avito/android/remote/model/AdvertSellerInfo;", "getSellerInfo", ExifInterface.LONGITUDE_EAST, "Lcom/avito/android/remote/model/badge_bar/SerpBadgeBar;", "getBadgeBar", "Lcom/avito/android/serp/adapter/SerpViewType;", AuthSource.SEND_ABUSE, "Lcom/avito/android/serp/adapter/SerpViewType;", "getViewType", "()Lcom/avito/android/serp/adapter/SerpViewType;", "viewType", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "n", "getLocation", "w", "Lcom/avito/android/remote/model/Action;", "getCallAction", "D", "Lcom/avito/android/component/user_advert/PriceTypeBadge;", "getBadge", "isExternalAd", "K", "Lcom/avito/android/remote/model/ForegroundImage;", "getInfoImage", "Lru/avito/component/serp/PhoneLoadingState;", AuthSource.BOOKING_ORDER, "Lru/avito/component/serp/PhoneLoadingState;", "getPhoneLoadingState", "()Lru/avito/component/serp/PhoneLoadingState;", "setPhoneLoadingState", "(Lru/avito/component/serp/PhoneLoadingState;)V", "phoneLoadingState", "o", "getAddress", "s", "getPreviousPrice", "t", "getDiscountPercentage", "<init>", "(JLjava/lang/String;Ljava/util/List;ZLjava/lang/String;ILcom/avito/android/remote/model/SerpDisplayType;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;Ljava/util/Map;Lcom/avito/android/remote/model/Action;Lcom/avito/android/remote/model/AdvertActions;ZZZLjava/lang/String;ZLcom/avito/android/component/user_advert/PriceTypeBadge;Lcom/avito/android/remote/model/badge_bar/SerpBadgeBar;Lcom/avito/android/remote/model/RadiusInfo;Lcom/avito/android/remote/model/AdvertSellerInfo;Ljava/util/List;Ljava/lang/String;ZLcom/avito/android/remote/model/ForegroundImage;Z)V", "Companion", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertXlItem implements AsyncPhoneItem, FavorableItem, PersistableSerpItem, ViewedAdvertItem, DisplayTypeAwareItem {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<AdvertXlItem> CREATOR = Parcels.creator(a.a);
    @NotNull
    public static final Companion Companion = new Companion(null);
    public final boolean A;
    @Nullable
    public final String B;
    public boolean C;
    @Nullable
    public final PriceTypeBadge D;
    @Nullable
    public final SerpBadgeBar E;
    @Nullable
    public final RadiusInfo F;
    @Nullable
    public final AdvertSellerInfo G;
    @Nullable
    public final List<GeoReference> H;
    @Nullable
    public final String I;
    public final boolean J;
    @Nullable
    public final ForegroundImage K;
    public final boolean L;
    @NotNull
    public final SerpViewType a;
    @NotNull
    public PhoneLoadingState b;
    public final long c;
    @NotNull
    public final String d;
    @Nullable
    public final List<Image> e;
    public boolean f;
    @Nullable
    public final String g;
    public final int h;
    @NotNull
    public SerpDisplayType i;
    @NotNull
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
    public final String q;
    @Nullable
    public final String r;
    @Nullable
    public final String s;
    @Nullable
    public final String t;
    @NotNull
    public final DeepLink u;
    @Nullable
    public final Map<String, String> v;
    @Nullable
    public final Action w;
    @Nullable
    public final AdvertActions x;
    public final boolean y;
    public final boolean z;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/serp/adapter/advert_xl/AdvertXlItem$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/serp/adapter/advert_xl/AdvertXlItem;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<Parcel, AdvertXlItem> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public AdvertXlItem invoke(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "$receiver");
            long readLong = parcel2.readLong();
            String u2 = a2.b.a.a.a.u2(parcel2, "readString()!!");
            List createParcelableList = ParcelsKt.createParcelableList(parcel2, Image.class);
            boolean readBool = ParcelsKt.readBool(parcel2);
            String readString = parcel2.readString();
            int readInt = parcel2.readInt();
            SerpDisplayType serpDisplayType = (SerpDisplayType) ParcelsKt.readEnum(parcel2, SerpDisplayType.values());
            String u22 = a2.b.a.a.a.u2(parcel2, "readString()!!");
            String readString2 = parcel2.readString();
            boolean readBool2 = ParcelsKt.readBool(parcel2);
            String readString3 = parcel2.readString();
            String readString4 = parcel2.readString();
            String readString5 = parcel2.readString();
            long readLong2 = parcel2.readLong();
            String readString6 = parcel2.readString();
            String readString7 = parcel2.readString();
            String readString8 = parcel2.readString();
            String readString9 = parcel2.readString();
            DeepLink deepLink = (DeepLink) a2.b.a.a.a.z1(DeepLink.class, parcel2);
            Map createValueMap = ParcelUtils.createValueMap(parcel2, String.class, String.class);
            Object readValue = parcel2.readValue(Action.class.getClassLoader());
            AdvertActions advertActions = null;
            if (!(readValue instanceof Action)) {
                readValue = null;
            }
            Action action = (Action) readValue;
            Object readValue2 = parcel2.readValue(AdvertActions.class.getClassLoader());
            if (readValue2 instanceof AdvertActions) {
                advertActions = readValue2;
            }
            AdvertXlItem advertXlItem = new AdvertXlItem(readLong, u2, createParcelableList, readBool, readString, readInt, serpDisplayType, u22, readString2, readBool2, readString3, readString4, readString5, readLong2, readString6, readString7, readString8, readString9, deepLink, createValueMap, action, advertActions, ParcelsKt.readBool(parcel2), ParcelsKt.readBool(parcel2), ParcelsKt.readBool(parcel2), parcel2.readString(), ParcelsKt.readBool(parcel2), (PriceTypeBadge) parcel2.readParcelable(PriceTypeBadge.class.getClassLoader()), (SerpBadgeBar) parcel2.readParcelable(SerpBadgeBar.class.getClassLoader()), (RadiusInfo) parcel2.readParcelable(RadiusInfo.class.getClassLoader()), (AdvertSellerInfo) parcel2.readParcelable(AdvertSellerInfo.class.getClassLoader()), ParcelsKt.createParcelableList(parcel2, GeoReference.class), parcel2.readString(), ParcelsKt.readBool(parcel2), null, ParcelsKt.readBool(parcel2), 0, 4, null);
            advertXlItem.setPhoneLoadingState((PhoneLoadingState) ParcelsKt.readEnum(parcel2, PhoneLoadingState.values()));
            return advertXlItem;
        }
    }

    public AdvertXlItem(long j2, @NotNull String str, @Nullable List<Image> list, boolean z2, @Nullable String str2, int i2, @NotNull SerpDisplayType serpDisplayType, @NotNull String str3, @Nullable String str4, boolean z3, @Nullable String str5, @Nullable String str6, @Nullable String str7, long j3, @Nullable String str8, @Nullable String str9, @Nullable String str10, @Nullable String str11, @NotNull DeepLink deepLink, @Nullable Map<String, String> map, @Nullable Action action, @Nullable AdvertActions advertActions, boolean z4, boolean z5, boolean z7, @Nullable String str12, boolean z8, @Nullable PriceTypeBadge priceTypeBadge, @Nullable SerpBadgeBar serpBadgeBar, @Nullable RadiusInfo radiusInfo, @Nullable AdvertSellerInfo advertSellerInfo, @Nullable List<GeoReference> list2, @Nullable String str13, boolean z9, @Nullable ForegroundImage foregroundImage, boolean z10) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
        Intrinsics.checkNotNullParameter(str3, "title");
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        this.c = j2;
        this.d = str;
        this.e = list;
        this.f = z2;
        this.g = str2;
        this.h = i2;
        this.i = serpDisplayType;
        this.j = str3;
        this.k = str4;
        this.l = z3;
        this.m = str5;
        this.n = str6;
        this.o = str7;
        this.p = j3;
        this.q = str8;
        this.r = str9;
        this.s = str10;
        this.t = str11;
        this.u = deepLink;
        this.v = map;
        this.w = action;
        this.x = advertActions;
        this.y = z4;
        this.z = z5;
        this.A = z7;
        this.B = str12;
        this.C = z8;
        this.D = priceTypeBadge;
        this.E = serpBadgeBar;
        this.F = radiusInfo;
        this.G = advertSellerInfo;
        this.H = list2;
        this.I = str13;
        this.J = z9;
        this.K = foregroundImage;
        this.L = z10;
        this.a = SerpViewType.BIG;
        this.b = PhoneLoadingState.IDLE;
    }

    public static /* synthetic */ AdvertXlItem copy$default(AdvertXlItem advertXlItem, long j2, String str, List list, boolean z2, String str2, int i2, SerpDisplayType serpDisplayType, String str3, String str4, boolean z3, String str5, String str6, String str7, long j3, String str8, String str9, String str10, String str11, DeepLink deepLink, Map map, Action action, AdvertActions advertActions, boolean z4, boolean z5, boolean z7, String str12, boolean z8, PriceTypeBadge priceTypeBadge, SerpBadgeBar serpBadgeBar, RadiusInfo radiusInfo, AdvertSellerInfo advertSellerInfo, List list2, String str13, boolean z9, ForegroundImage foregroundImage, boolean z10, int i3, int i4, Object obj) {
        return advertXlItem.copy((i3 & 1) != 0 ? advertXlItem.getId() : j2, (i3 & 2) != 0 ? advertXlItem.getStringId() : str, (i3 & 4) != 0 ? advertXlItem.e : list, (i3 & 8) != 0 ? advertXlItem.isFavorite() : z2, (i3 & 16) != 0 ? advertXlItem.getAnalyticsContext() : str2, (i3 & 32) != 0 ? advertXlItem.getSpanCount() : i2, (i3 & 64) != 0 ? advertXlItem.getDisplayType() : serpDisplayType, (i3 & 128) != 0 ? advertXlItem.j : str3, (i3 & 256) != 0 ? advertXlItem.k : str4, (i3 & 512) != 0 ? advertXlItem.l : z3, (i3 & 1024) != 0 ? advertXlItem.m : str5, (i3 & 2048) != 0 ? advertXlItem.n : str6, (i3 & 4096) != 0 ? advertXlItem.o : str7, (i3 & 8192) != 0 ? advertXlItem.p : j3, (i3 & 16384) != 0 ? advertXlItem.q : str8, (32768 & i3) != 0 ? advertXlItem.r : str9, (i3 & 65536) != 0 ? advertXlItem.s : str10, (i3 & 131072) != 0 ? advertXlItem.t : str11, (i3 & 262144) != 0 ? advertXlItem.u : deepLink, (i3 & 524288) != 0 ? advertXlItem.v : map, (i3 & 1048576) != 0 ? advertXlItem.w : action, (i3 & 2097152) != 0 ? advertXlItem.x : advertActions, (i3 & 4194304) != 0 ? advertXlItem.y : z4, (i3 & 8388608) != 0 ? advertXlItem.z : z5, (i3 & 16777216) != 0 ? advertXlItem.A : z7, (i3 & 33554432) != 0 ? advertXlItem.B : str12, (i3 & 67108864) != 0 ? advertXlItem.isViewed() : z8, (i3 & 134217728) != 0 ? advertXlItem.D : priceTypeBadge, (i3 & 268435456) != 0 ? advertXlItem.E : serpBadgeBar, (i3 & 536870912) != 0 ? advertXlItem.F : radiusInfo, (i3 & 1073741824) != 0 ? advertXlItem.G : advertSellerInfo, (i3 & Integer.MIN_VALUE) != 0 ? advertXlItem.H : list2, (i4 & 1) != 0 ? advertXlItem.I : str13, (i4 & 2) != 0 ? advertXlItem.J : z9, (i4 & 4) != 0 ? advertXlItem.K : foregroundImage, (i4 & 8) != 0 ? advertXlItem.L : z10);
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
    public final String component15() {
        return this.q;
    }

    @Nullable
    public final String component16() {
        return this.r;
    }

    @Nullable
    public final String component17() {
        return this.s;
    }

    @Nullable
    public final String component18() {
        return this.t;
    }

    @NotNull
    public final DeepLink component19() {
        return this.u;
    }

    @NotNull
    public final String component2() {
        return getStringId();
    }

    @Nullable
    public final Map<String, String> component20() {
        return this.v;
    }

    @Nullable
    public final Action component21() {
        return this.w;
    }

    @Nullable
    public final AdvertActions component22() {
        return this.x;
    }

    public final boolean component23() {
        return this.y;
    }

    public final boolean component24() {
        return this.z;
    }

    public final boolean component25() {
        return this.A;
    }

    @Nullable
    public final String component26() {
        return this.B;
    }

    public final boolean component27() {
        return isViewed();
    }

    @Nullable
    public final PriceTypeBadge component28() {
        return this.D;
    }

    @Nullable
    public final SerpBadgeBar component29() {
        return this.E;
    }

    @Nullable
    public final List<Image> component3() {
        return this.e;
    }

    @Nullable
    public final RadiusInfo component30() {
        return this.F;
    }

    @Nullable
    public final AdvertSellerInfo component31() {
        return this.G;
    }

    @Nullable
    public final List<GeoReference> component32() {
        return this.H;
    }

    @Nullable
    public final String component33() {
        return this.I;
    }

    public final boolean component34() {
        return this.J;
    }

    @Nullable
    public final ForegroundImage component35() {
        return this.K;
    }

    public final boolean component36() {
        return this.L;
    }

    public final boolean component4() {
        return isFavorite();
    }

    @Nullable
    public final String component5() {
        return getAnalyticsContext();
    }

    public final int component6() {
        return getSpanCount();
    }

    @NotNull
    public final SerpDisplayType component7() {
        return getDisplayType();
    }

    @NotNull
    public final String component8() {
        return this.j;
    }

    @Nullable
    public final String component9() {
        return this.k;
    }

    @NotNull
    public final AdvertXlItem copy(long j2, @NotNull String str, @Nullable List<Image> list, boolean z2, @Nullable String str2, int i2, @NotNull SerpDisplayType serpDisplayType, @NotNull String str3, @Nullable String str4, boolean z3, @Nullable String str5, @Nullable String str6, @Nullable String str7, long j3, @Nullable String str8, @Nullable String str9, @Nullable String str10, @Nullable String str11, @NotNull DeepLink deepLink, @Nullable Map<String, String> map, @Nullable Action action, @Nullable AdvertActions advertActions, boolean z4, boolean z5, boolean z7, @Nullable String str12, boolean z8, @Nullable PriceTypeBadge priceTypeBadge, @Nullable SerpBadgeBar serpBadgeBar, @Nullable RadiusInfo radiusInfo, @Nullable AdvertSellerInfo advertSellerInfo, @Nullable List<GeoReference> list2, @Nullable String str13, boolean z9, @Nullable ForegroundImage foregroundImage, boolean z10) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(serpDisplayType, "displayType");
        Intrinsics.checkNotNullParameter(str3, "title");
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        return new AdvertXlItem(j2, str, list, z2, str2, i2, serpDisplayType, str3, str4, z3, str5, str6, str7, j3, str8, str9, str10, str11, deepLink, map, action, advertActions, z4, z5, z7, str12, z8, priceTypeBadge, serpBadgeBar, radiusInfo, advertSellerInfo, list2, str13, z9, foregroundImage, z10);
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
        if (!(obj instanceof AdvertXlItem)) {
            return false;
        }
        AdvertXlItem advertXlItem = (AdvertXlItem) obj;
        return getId() == advertXlItem.getId() && Intrinsics.areEqual(getStringId(), advertXlItem.getStringId()) && Intrinsics.areEqual(this.e, advertXlItem.e) && isFavorite() == advertXlItem.isFavorite() && Intrinsics.areEqual(getAnalyticsContext(), advertXlItem.getAnalyticsContext()) && getSpanCount() == advertXlItem.getSpanCount() && Intrinsics.areEqual(getDisplayType(), advertXlItem.getDisplayType()) && Intrinsics.areEqual(this.j, advertXlItem.j) && Intrinsics.areEqual(this.k, advertXlItem.k) && this.l == advertXlItem.l && Intrinsics.areEqual(this.m, advertXlItem.m) && Intrinsics.areEqual(this.n, advertXlItem.n) && Intrinsics.areEqual(this.o, advertXlItem.o) && this.p == advertXlItem.p && Intrinsics.areEqual(this.q, advertXlItem.q) && Intrinsics.areEqual(this.r, advertXlItem.r) && Intrinsics.areEqual(this.s, advertXlItem.s) && Intrinsics.areEqual(this.t, advertXlItem.t) && Intrinsics.areEqual(this.u, advertXlItem.u) && Intrinsics.areEqual(this.v, advertXlItem.v) && Intrinsics.areEqual(this.w, advertXlItem.w) && Intrinsics.areEqual(this.x, advertXlItem.x) && this.y == advertXlItem.y && this.z == advertXlItem.z && this.A == advertXlItem.A && Intrinsics.areEqual(this.B, advertXlItem.B) && isViewed() == advertXlItem.isViewed() && Intrinsics.areEqual(this.D, advertXlItem.D) && Intrinsics.areEqual(this.E, advertXlItem.E) && Intrinsics.areEqual(this.F, advertXlItem.F) && Intrinsics.areEqual(this.G, advertXlItem.G) && Intrinsics.areEqual(this.H, advertXlItem.H) && Intrinsics.areEqual(this.I, advertXlItem.I) && this.J == advertXlItem.J && Intrinsics.areEqual(this.K, advertXlItem.K) && this.L == advertXlItem.L;
    }

    @Nullable
    public final String getAdditionalName() {
        return this.B;
    }

    @Nullable
    public final String getAddress() {
        return this.o;
    }

    @Nullable
    public final Map<String, String> getAnalyticParams() {
        return this.v;
    }

    @Override // com.avito.android.serp.adapter.FavorableItem
    @Nullable
    public String getAnalyticsContext() {
        return this.g;
    }

    @Nullable
    public final PriceTypeBadge getBadge() {
        return this.D;
    }

    @Nullable
    public final SerpBadgeBar getBadgeBar() {
        return this.E;
    }

    @Nullable
    public final Action getCallAction() {
        return this.w;
    }

    @Nullable
    public final AdvertActions getContacts() {
        return this.x;
    }

    @NotNull
    public final DeepLink getDeepLink() {
        return this.u;
    }

    @Nullable
    public final String getDescription() {
        return this.k;
    }

    @Nullable
    public final String getDiscountPercentage() {
        return this.t;
    }

    @Override // com.avito.android.serp.adapter.DisplayTypeAwareItem
    @NotNull
    public SerpDisplayType getDisplayType() {
        return this.i;
    }

    @Nullable
    public final String getDistance() {
        return this.I;
    }

    @Nullable
    public final List<GeoReference> getGeoReferences() {
        return this.H;
    }

    public final boolean getHasDelivery() {
        return this.l;
    }

    @Override // com.avito.android.serp.adapter.PersistableSerpItem
    public boolean getHasStablePosition() {
        return PersistableSerpItem.DefaultImpls.getHasStablePosition(this);
    }

    public final boolean getHasVideo() {
        return this.J;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return this.c;
    }

    @Nullable
    public final List<Image> getImageList() {
        return this.e;
    }

    @Nullable
    public final ForegroundImage getInfoImage() {
        return this.K;
    }

    @Nullable
    public final String getLocation() {
        return this.n;
    }

    @Override // com.avito.android.async_phone.AsyncPhoneItem
    @NotNull
    public PhoneLoadingState getPhoneLoadingState() {
        return this.b;
    }

    @Nullable
    public final String getPreviousPrice() {
        return this.s;
    }

    @Nullable
    public final String getPrice() {
        return this.q;
    }

    @Nullable
    public final String getPriceWithoutDiscount() {
        return this.r;
    }

    @Nullable
    public final RadiusInfo getRadiusInfo() {
        return this.F;
    }

    @Nullable
    public final AdvertSellerInfo getSellerInfo() {
        return this.G;
    }

    @Nullable
    public final String getShopName() {
        return this.m;
    }

    @Override // com.avito.android.serp.adapter.SpannedItem
    public int getSpanCount() {
        return this.h;
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
        return this.j;
    }

    @Override // com.avito.android.serp.adapter.ViewTypeSerpItem
    @NotNull
    public SerpViewType getViewType() {
        return this.a;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int a3 = c.a(getId()) * 31;
        String stringId = getStringId();
        int i2 = 0;
        int hashCode = (a3 + (stringId != null ? stringId.hashCode() : 0)) * 31;
        List<Image> list = this.e;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        boolean isFavorite = isFavorite();
        int i3 = 1;
        if (isFavorite) {
            isFavorite = true;
        }
        int i4 = isFavorite ? 1 : 0;
        int i5 = isFavorite ? 1 : 0;
        int i6 = isFavorite ? 1 : 0;
        int i7 = (hashCode2 + i4) * 31;
        String analyticsContext = getAnalyticsContext();
        int spanCount = (getSpanCount() + ((i7 + (analyticsContext != null ? analyticsContext.hashCode() : 0)) * 31)) * 31;
        SerpDisplayType displayType = getDisplayType();
        int hashCode3 = (spanCount + (displayType != null ? displayType.hashCode() : 0)) * 31;
        String str = this.j;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.k;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z2 = this.l;
        if (z2) {
            z2 = true;
        }
        int i8 = z2 ? 1 : 0;
        int i9 = z2 ? 1 : 0;
        int i10 = z2 ? 1 : 0;
        int i11 = (hashCode5 + i8) * 31;
        String str3 = this.m;
        int hashCode6 = (i11 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.n;
        int hashCode7 = (hashCode6 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.o;
        int hashCode8 = (((hashCode7 + (str5 != null ? str5.hashCode() : 0)) * 31) + c.a(this.p)) * 31;
        String str6 = this.q;
        int hashCode9 = (hashCode8 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.r;
        int hashCode10 = (hashCode9 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.s;
        int hashCode11 = (hashCode10 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.t;
        int hashCode12 = (hashCode11 + (str9 != null ? str9.hashCode() : 0)) * 31;
        DeepLink deepLink = this.u;
        int hashCode13 = (hashCode12 + (deepLink != null ? deepLink.hashCode() : 0)) * 31;
        Map<String, String> map = this.v;
        int hashCode14 = (hashCode13 + (map != null ? map.hashCode() : 0)) * 31;
        Action action = this.w;
        int hashCode15 = (hashCode14 + (action != null ? action.hashCode() : 0)) * 31;
        AdvertActions advertActions = this.x;
        int hashCode16 = (hashCode15 + (advertActions != null ? advertActions.hashCode() : 0)) * 31;
        boolean z3 = this.y;
        if (z3) {
            z3 = true;
        }
        int i12 = z3 ? 1 : 0;
        int i13 = z3 ? 1 : 0;
        int i14 = z3 ? 1 : 0;
        int i15 = (hashCode16 + i12) * 31;
        boolean z4 = this.z;
        if (z4) {
            z4 = true;
        }
        int i16 = z4 ? 1 : 0;
        int i17 = z4 ? 1 : 0;
        int i18 = z4 ? 1 : 0;
        int i19 = (i15 + i16) * 31;
        boolean z5 = this.A;
        if (z5) {
            z5 = true;
        }
        int i20 = z5 ? 1 : 0;
        int i21 = z5 ? 1 : 0;
        int i22 = z5 ? 1 : 0;
        int i23 = (i19 + i20) * 31;
        String str10 = this.B;
        int hashCode17 = (i23 + (str10 != null ? str10.hashCode() : 0)) * 31;
        boolean isViewed = isViewed();
        if (isViewed) {
            isViewed = true;
        }
        int i24 = isViewed ? 1 : 0;
        int i25 = isViewed ? 1 : 0;
        int i26 = isViewed ? 1 : 0;
        int i27 = (hashCode17 + i24) * 31;
        PriceTypeBadge priceTypeBadge = this.D;
        int hashCode18 = (i27 + (priceTypeBadge != null ? priceTypeBadge.hashCode() : 0)) * 31;
        SerpBadgeBar serpBadgeBar = this.E;
        int hashCode19 = (hashCode18 + (serpBadgeBar != null ? serpBadgeBar.hashCode() : 0)) * 31;
        RadiusInfo radiusInfo = this.F;
        int hashCode20 = (hashCode19 + (radiusInfo != null ? radiusInfo.hashCode() : 0)) * 31;
        AdvertSellerInfo advertSellerInfo = this.G;
        int hashCode21 = (hashCode20 + (advertSellerInfo != null ? advertSellerInfo.hashCode() : 0)) * 31;
        List<GeoReference> list2 = this.H;
        int hashCode22 = (hashCode21 + (list2 != null ? list2.hashCode() : 0)) * 31;
        String str11 = this.I;
        int hashCode23 = (hashCode22 + (str11 != null ? str11.hashCode() : 0)) * 31;
        boolean z7 = this.J;
        if (z7) {
            z7 = true;
        }
        int i28 = z7 ? 1 : 0;
        int i29 = z7 ? 1 : 0;
        int i30 = z7 ? 1 : 0;
        int i31 = (hashCode23 + i28) * 31;
        ForegroundImage foregroundImage = this.K;
        if (foregroundImage != null) {
            i2 = foregroundImage.hashCode();
        }
        int i32 = (i31 + i2) * 31;
        boolean z8 = this.L;
        if (!z8) {
            i3 = z8 ? 1 : 0;
        }
        return i32 + i3;
    }

    public final boolean isActive() {
        return this.z;
    }

    @Override // com.avito.android.serp.adapter.PersistableSerpItem
    public boolean isExternalAd() {
        return false;
    }

    @Override // com.avito.android.serp.adapter.FavorableItem
    public boolean isFavorite() {
        return this.f;
    }

    public final boolean isHighlighted() {
        return this.y;
    }

    public final boolean isMarketplace() {
        return this.L;
    }

    public final boolean isVerifiedSeller() {
        return this.A;
    }

    @Override // com.avito.android.serp.adapter.ViewedAdvertItem
    public boolean isViewed() {
        return this.C;
    }

    @Override // com.avito.android.serp.adapter.DisplayTypeAwareItem
    public void setDisplayType(@NotNull SerpDisplayType serpDisplayType) {
        Intrinsics.checkNotNullParameter(serpDisplayType, "<set-?>");
        this.i = serpDisplayType;
    }

    @Override // com.avito.android.serp.adapter.FavorableItem
    public void setFavorite(boolean z2) {
        this.f = z2;
    }

    @Override // com.avito.android.async_phone.AsyncPhoneItem
    public void setPhoneLoadingState(@NotNull PhoneLoadingState phoneLoadingState) {
        Intrinsics.checkNotNullParameter(phoneLoadingState, "<set-?>");
        this.b = phoneLoadingState;
    }

    @Override // com.avito.android.serp.adapter.ViewedAdvertItem
    public void setViewed(boolean z2) {
        this.C = z2;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L2 = a2.b.a.a.a.L("AdvertXlItem(id=");
        L2.append(getId());
        L2.append(", stringId=");
        L2.append(getStringId());
        L2.append(", imageList=");
        L2.append(this.e);
        L2.append(", isFavorite=");
        L2.append(isFavorite());
        L2.append(", analyticsContext=");
        L2.append(getAnalyticsContext());
        L2.append(", spanCount=");
        L2.append(getSpanCount());
        L2.append(", displayType=");
        L2.append(getDisplayType());
        L2.append(", title=");
        L2.append(this.j);
        L2.append(", description=");
        L2.append(this.k);
        L2.append(", hasDelivery=");
        L2.append(this.l);
        L2.append(", shopName=");
        L2.append(this.m);
        L2.append(", location=");
        L2.append(this.n);
        L2.append(", address=");
        L2.append(this.o);
        L2.append(", time=");
        L2.append(this.p);
        L2.append(", price=");
        L2.append(this.q);
        L2.append(", priceWithoutDiscount=");
        L2.append(this.r);
        L2.append(", previousPrice=");
        L2.append(this.s);
        L2.append(", discountPercentage=");
        L2.append(this.t);
        L2.append(", deepLink=");
        L2.append(this.u);
        L2.append(", analyticParams=");
        L2.append(this.v);
        L2.append(", callAction=");
        L2.append(this.w);
        L2.append(", contacts=");
        L2.append(this.x);
        L2.append(", isHighlighted=");
        L2.append(this.y);
        L2.append(", isActive=");
        L2.append(this.z);
        L2.append(", isVerifiedSeller=");
        L2.append(this.A);
        L2.append(", additionalName=");
        L2.append(this.B);
        L2.append(", isViewed=");
        L2.append(isViewed());
        L2.append(", badge=");
        L2.append(this.D);
        L2.append(", badgeBar=");
        L2.append(this.E);
        L2.append(", radiusInfo=");
        L2.append(this.F);
        L2.append(", sellerInfo=");
        L2.append(this.G);
        L2.append(", geoReferences=");
        L2.append(this.H);
        L2.append(", distance=");
        L2.append(this.I);
        L2.append(", hasVideo=");
        L2.append(this.J);
        L2.append(", infoImage=");
        L2.append(this.K);
        L2.append(", isMarketplace=");
        return a2.b.a.a.a.B(L2, this.L, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeLong(getId());
        parcel.writeString(getStringId());
        ParcelsKt.writeOptimizedParcelableList$default(parcel, this.e, 0, 2, null);
        ParcelsKt.writeBool(parcel, isFavorite());
        parcel.writeString(getAnalyticsContext());
        parcel.writeInt(getSpanCount());
        ParcelsKt.writeEnum(parcel, getDisplayType());
        parcel.writeString(this.j);
        parcel.writeString(this.k);
        ParcelsKt.writeBool(parcel, this.l);
        parcel.writeString(this.m);
        parcel.writeString(this.n);
        parcel.writeString(this.o);
        parcel.writeLong(this.p);
        parcel.writeString(this.q);
        parcel.writeString(this.r);
        parcel.writeString(this.s);
        parcel.writeString(this.t);
        parcel.writeParcelable(this.u, i2);
        ParcelsKt.writeValueMap(parcel, this.v);
        ParcelsKt.writeNullableValue(parcel, this.w);
        ParcelsKt.writeNullableValue(parcel, this.x);
        ParcelsKt.writeBool(parcel, this.y);
        ParcelsKt.writeBool(parcel, this.z);
        ParcelsKt.writeBool(parcel, this.A);
        parcel.writeString(this.B);
        ParcelsKt.writeBool(parcel, isViewed());
        parcel.writeParcelable(this.D, i2);
        parcel.writeParcelable(this.E, i2);
        parcel.writeParcelable(this.F, i2);
        parcel.writeParcelable(this.G, i2);
        ParcelsKt.writeOptimizedParcelableList(parcel, this.H, i2);
        parcel.writeString(this.I);
        ParcelsKt.writeBool(parcel, this.J);
        ParcelsKt.writeEnum(parcel, getPhoneLoadingState());
        ParcelsKt.writeBool(parcel, this.L);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AdvertXlItem(long j2, String str, List list, boolean z2, String str2, int i2, SerpDisplayType serpDisplayType, String str3, String str4, boolean z3, String str5, String str6, String str7, long j3, String str8, String str9, String str10, String str11, DeepLink deepLink, Map map, Action action, AdvertActions advertActions, boolean z4, boolean z5, boolean z7, String str12, boolean z8, PriceTypeBadge priceTypeBadge, SerpBadgeBar serpBadgeBar, RadiusInfo radiusInfo, AdvertSellerInfo advertSellerInfo, List list2, String str13, boolean z9, ForegroundImage foregroundImage, boolean z10, int i3, int i4, j jVar) {
        this(j2, str, list, z2, str2, i2, serpDisplayType, str3, str4, z3, str5, str6, str7, j3, str8, (i3 & 32768) != 0 ? null : str9, (i3 & 65536) != 0 ? null : str10, (i3 & 131072) != 0 ? null : str11, deepLink, map, action, advertActions, z4, z5, z7, str12, (i3 & 67108864) != 0 ? false : z8, (i3 & 134217728) != 0 ? null : priceTypeBadge, (i3 & 268435456) != 0 ? null : serpBadgeBar, (i3 & 536870912) != 0 ? null : radiusInfo, (i3 & 1073741824) != 0 ? null : advertSellerInfo, (i3 & Integer.MIN_VALUE) != 0 ? null : list2, (i4 & 1) != 0 ? null : str13, (i4 & 2) != 0 ? false : z9, (i4 & 4) != 0 ? null : foregroundImage, (i4 & 8) != 0 ? false : z10);
    }
}
