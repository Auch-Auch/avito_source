package com.avito.android.advert_core.analytics;

import com.avito.android.advert_core.analytics.address.GeoFromBlock;
import com.avito.android.advert_core.analytics.broker.CreditBrokerAnalyticsInteractor;
import com.avito.android.advert_core.analytics.guide.FromGuideBlock;
import com.avito.android.advert_core.analytics.similars.ClickSimilarItemFavoritesAction;
import com.avito.android.advert_core.analytics.toolbar.BackFromPage;
import com.avito.android.advert_core.analytics.toolbar.NoteAction;
import com.avito.android.advert_core.contactbar.SourceScreen;
import com.avito.android.advert_core.sellerprofile.ShowSellersProfileSource;
import com.avito.android.analytics.event.cart.OpenCartEvent;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.autoteka_details.core.analytics.event.FromBlock;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.model.AdvertDetails;
import com.avito.android.remote.model.ParametrizedEvent;
import com.avito.android.remote.model.advert_details.ContactBarData;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.serp.CommercialBannersAnalyticsInteractor;
import com.avito.android.serp.ad.BannerInfo;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.internal.jsonrpc.CommonKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0005H&¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH&¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0012\u0010\u0007J\u001f\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0017\u0010\u0007J\u001f\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aH&¢\u0006\u0004\b\u001c\u0010\u001dJ1\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\t\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b\u001f\u0010 J)\u0010$\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u00132\b\b\u0002\u0010#\u001a\u00020\"H&¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b&\u0010\u0007J\u001f\u0010(\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010'\u001a\u00020\bH&¢\u0006\u0004\b(\u0010\u0011J'\u0010*\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010'\u001a\u00020\b2\u0006\u0010)\u001a\u00020\u0013H&¢\u0006\u0004\b*\u0010+J\u0017\u0010,\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b,\u0010\u0007J\u0017\u0010-\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b-\u0010\u0007J\u0017\u0010.\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b.\u0010\u0007J\u0017\u0010/\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b/\u0010\u0007J)\u00103\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u00101\u001a\u0002002\b\u00102\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b3\u00104J)\u00107\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u00106\u001a\u000205H&¢\u0006\u0004\b7\u00108J\u0017\u00109\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b9\u0010\u0007J\u0017\u0010:\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b:\u0010\u0007J\u001f\u0010=\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010<\u001a\u00020;H&¢\u0006\u0004\b=\u0010>J\u0017\u0010?\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b?\u0010\u0007J\u001f\u0010A\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010@\u001a\u00020\bH&¢\u0006\u0004\bA\u0010BJ\u001f\u0010D\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010C\u001a\u00020\bH&¢\u0006\u0004\bD\u0010BJ\u0017\u0010E\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\bH&¢\u0006\u0004\bE\u0010\u000bJ\u0017\u0010F\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\bF\u0010\u0007J\u001f\u0010H\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020GH&¢\u0006\u0004\bH\u0010IJ\u0017\u0010J\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\bJ\u0010\u0007J\u001f\u0010L\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010K\u001a\u000205H&¢\u0006\u0004\bL\u0010MJ\u0017\u0010N\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\bH&¢\u0006\u0004\bN\u0010\u000bJ\u001f\u0010P\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010O\u001a\u00020\bH&¢\u0006\u0004\bP\u0010BJ'\u0010R\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u00101\u001a\u00020Q2\u0006\u0010O\u001a\u00020\bH&¢\u0006\u0004\bR\u0010SJ!\u0010U\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\b2\b\u0010T\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\bU\u0010\u0011J7\u0010X\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010V\u001a\u00020\b2\u0006\u0010T\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010W\u001a\u00020\u0013H&¢\u0006\u0004\bX\u0010YJK\u0010\\\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010V\u001a\u00020\b2\u0006\u0010T\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010W\u001a\u00020\u00132\b\u0010Z\u001a\u0004\u0018\u00010\b2\b\u0010[\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b\\\u0010]J\u0017\u0010^\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b^\u0010\u0007J\u0017\u0010_\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b_\u0010\u0007J\u001f\u0010b\u001a\u00020\u00052\u0006\u0010a\u001a\u00020`2\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\bb\u0010cJ)\u0010e\u001a\u00020\u00052\u0006\u0010a\u001a\u00020`2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010d\u001a\u0004\u0018\u000105H&¢\u0006\u0004\be\u0010fJ\u001f\u0010g\u001a\u00020\u00052\u0006\u0010a\u001a\u00020`2\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\bg\u0010cJ\u001f\u0010h\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\bH&¢\u0006\u0004\bh\u0010\u0011J\u0017\u0010i\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\bH&¢\u0006\u0004\bi\u0010\u000bJ\u001f\u0010k\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010j\u001a\u00020\bH&¢\u0006\u0004\bk\u0010\u0011J\u0017\u0010l\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\bH&¢\u0006\u0004\bl\u0010\u000bJ\u0017\u0010m\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\bH&¢\u0006\u0004\bm\u0010\u000bJ\u0017\u0010n\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\bH&¢\u0006\u0004\bn\u0010\u000bJ\u0017\u0010o\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\bH&¢\u0006\u0004\bo\u0010\u000bJ=\u0010q\u001a\u00020\u00052\u0006\u0010a\u001a\u00020`2\b\u0010\u000e\u001a\u0004\u0018\u00010\b2\b\u0010T\u001a\u0004\u0018\u00010\b2\b\u0010p\u001a\u0004\u0018\u00010\b2\u0006\u00106\u001a\u000205H&¢\u0006\u0004\bq\u0010rJ\u001f\u0010t\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010s\u001a\u00020\u0013H&¢\u0006\u0004\bt\u0010\u0016J\u0017\u0010u\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\bH&¢\u0006\u0004\bu\u0010\u000bJ\u0017\u0010v\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\bH&¢\u0006\u0004\bv\u0010\u000bJ\u000f\u0010w\u001a\u00020\u0005H&¢\u0006\u0004\bw\u0010\rJ-\u0010|\u001a\u00020\u00052\u0006\u0010x\u001a\u00020\b2\u0006\u0010y\u001a\u0002052\f\u0010{\u001a\b\u0012\u0004\u0012\u0002050zH&¢\u0006\u0004\b|\u0010}J(\u0010\u001a\u00020\u00052\u0006\u0010x\u001a\u00020\b2\u0006\u0010y\u001a\u0002052\u0006\u0010~\u001a\u000205H&¢\u0006\u0005\b\u0010\u0001J%\u0010\u0001\u001a\u00020\u00052\u0007\u0010\u0001\u001a\u00020\b2\b\u0010\u0001\u001a\u00030\u0001H&¢\u0006\u0006\b\u0001\u0010\u0001J\u0013\u0010\u0001\u001a\u00030\u0001H&¢\u0006\u0006\b\u0001\u0010\u0001J\u0014\u0010\u0001\u001a\u0004\u0018\u00010\bH&¢\u0006\u0006\b\u0001\u0010\u0001J\u0019\u0010\u0001\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\bH&¢\u0006\u0005\b\u0001\u0010\u000bJ\u0019\u0010\u0001\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\bH&¢\u0006\u0005\b\u0001\u0010\u000bJ.\u0010\u0001\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\b2\b\u0010T\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH&¢\u0006\u0006\b\u0001\u0010\u0001J\u0019\u0010\u0001\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\bH&¢\u0006\u0005\b\u0001\u0010\u000bJ\u0019\u0010\u0001\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\bH&¢\u0006\u0005\b\u0001\u0010\u000bJ\u0019\u0010\u0001\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\bH&¢\u0006\u0005\b\u0001\u0010\u000bJ\u0011\u0010\u0001\u001a\u00020\u0005H&¢\u0006\u0005\b\u0001\u0010\rJ\u0011\u0010\u0001\u001a\u00020\u0005H&¢\u0006\u0005\b\u0001\u0010\rJ\u0011\u0010\u0001\u001a\u00020\u0005H&¢\u0006\u0005\b\u0001\u0010\rJ\u0011\u0010\u0001\u001a\u00020\u0005H&¢\u0006\u0005\b\u0001\u0010\rJ#\u0010\u0001\u001a\u00020\u00052\u0007\u0010\u0001\u001a\u0002052\u0006\u0010#\u001a\u00020\bH&¢\u0006\u0006\b\u0001\u0010\u0001J,\u0010\u0001\u001a\u00020\u00052\u0007\u0010\u0001\u001a\u0002052\u0007\u0010\u0001\u001a\u0002052\u0006\u0010#\u001a\u00020\bH&¢\u0006\u0006\b\u0001\u0010\u0001J#\u0010\u0001\u001a\u00020\u00052\u0007\u0010\u0001\u001a\u0002052\u0006\u0010#\u001a\u00020\bH&¢\u0006\u0006\b\u0001\u0010\u0001J$\u0010\u0001\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\b2\t\u0010\u0001\u001a\u0004\u0018\u00010\bH&¢\u0006\u0005\b\u0001\u0010\u0011J\u0019\u0010\u0001\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\bH&¢\u0006\u0005\b\u0001\u0010\u000bJ\u0019\u0010 \u0001\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\bH&¢\u0006\u0005\b \u0001\u0010\u000bJ#\u0010¡\u0001\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\b2\b\u0010p\u001a\u0004\u0018\u00010\bH&¢\u0006\u0005\b¡\u0001\u0010\u0011J.\u0010¢\u0001\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\b2\b\u0010T\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH&¢\u0006\u0006\b¢\u0001\u0010\u0001J:\u0010¥\u0001\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\b2\t\u0010\u001b\u001a\u0005\u0018\u00010£\u00012\t\u0010¤\u0001\u001a\u0004\u0018\u0001052\b\u0010\t\u001a\u0004\u0018\u00010\bH&¢\u0006\u0006\b¥\u0001\u0010¦\u0001J*\u0010k\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010j\u001a\u00020\b2\b\u0010\u0001\u001a\u00030§\u0001H&¢\u0006\u0005\bk\u0010¨\u0001J\u001c\u0010«\u0001\u001a\u00020\u00052\b\u0010ª\u0001\u001a\u00030©\u0001H&¢\u0006\u0006\b«\u0001\u0010¬\u0001¨\u0006­\u0001"}, d2 = {"Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;", "Lcom/avito/android/serp/CommercialBannersAnalyticsInteractor;", "Lcom/avito/android/advert_core/analytics/broker/CreditBrokerAnalyticsInteractor;", "Lcom/avito/android/remote/model/AdvertDetails;", "advert", "", "setAdvertDetails", "(Lcom/avito/android/remote/model/AdvertDetails;)V", "", "context", "setSearchContext", "(Ljava/lang/String;)V", "sendEnterScreen", "()V", BookingInfoActivity.EXTRA_ITEM_ID, "itemAppearanceUuid", "sendShowScreenEvent", "(Ljava/lang/String;Ljava/lang/String;)V", "sendLoadAdvertEvent", "", "isBlocked", "sendLoadAdvertErrorEvent", "(Ljava/lang/String;Z)V", "sendShowAdvert", "Lcom/avito/android/remote/model/advert_details/ContactBarData;", "data", "Lcom/avito/android/advert_core/contactbar/SourceScreen;", "source", "sendClickCall", "(Lcom/avito/android/remote/model/advert_details/ContactBarData;Lcom/avito/android/advert_core/contactbar/SourceScreen;)V", "disabled", "sendClickWrite", "(Lcom/avito/android/remote/model/advert_details/ContactBarData;ZLcom/avito/android/advert_core/contactbar/SourceScreen;Ljava/lang/String;)V", "fromActionBar", "Lcom/avito/android/advert_core/analytics/toolbar/BackFromPage;", "fromPage", "sendBackClick", "(Ljava/lang/String;ZLcom/avito/android/advert_core/analytics/toolbar/BackFromPage;)V", "sendDescriptionExpand", "pageType", "sendShowModelSpecificationButton", "isMarketplace", "sendModelSpecificationsClick", "(Ljava/lang/String;Ljava/lang/String;Z)V", "sendGalleryEmbeddedSwipe", "sendGalleryShowFullscreen", "sendVideoClick", "sendClickNote", "Lcom/avito/android/advert_core/analytics/toolbar/NoteAction;", "action", "noteText", "sendNoteAction", "(Lcom/avito/android/remote/model/AdvertDetails;Lcom/avito/android/advert_core/analytics/toolbar/NoteAction;Ljava/lang/String;)V", "", VKApiConst.POSITION, "sendShowSimilars", "(Lcom/avito/android/remote/model/AdvertDetails;Ljava/lang/String;I)V", "sendDescriptionExpandExist", "sendDescriptionCopyText", "Lcom/avito/android/advert_core/analytics/address/GeoFromBlock;", "geoFromBlock", "sendAddressClick", "(Lcom/avito/android/remote/model/AdvertDetails;Lcom/avito/android/advert_core/analytics/address/GeoFromBlock;)V", "sendAddressLongClick", "itemName", "sendFlatsClick", "(Lcom/avito/android/remote/model/AdvertDetails;Ljava/lang/String;)V", "developmentsId", "sendDevelopmentsCatalogClick", "sendAdditionalSellerPhoneButtonClick", "sendGroupsClick", "Lcom/avito/android/advert_core/sellerprofile/ShowSellersProfileSource;", "sendShowSellersProfile", "(Lcom/avito/android/remote/model/AdvertDetails;Lcom/avito/android/advert_core/sellerprofile/ShowSellersProfileSource;)V", "sendShowAbuse", "badgeId", "sendBadgeClicked", "(Ljava/lang/String;I)V", "sendBadgeBarExpandButtonClicked", "targetItemId", "sendClickSimilarItem", "Lcom/avito/android/advert_core/analytics/similars/ClickSimilarItemFavoritesAction;", "sendClickSimilarFavorites", "(Lcom/avito/android/remote/model/AdvertDetails;Lcom/avito/android/advert_core/analytics/similars/ClickSimilarItemFavoritesAction;Ljava/lang/String;)V", "categoryId", "sendDeliveryInfoClick", ChannelContext.Item.USER_ID, "isUserAuth", "sendDeliveryButtonClick", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "safeDealServices", "searchContext", "sendSafeDealBuyButtonClick", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", "sendAutoDealClick", "sendCreditBannerInfoClick", "Lcom/avito/android/serp/ad/BannerInfo;", "bannerInfo", "sendCreditBannerLoaded", "(Lcom/avito/android/serp/ad/BannerInfo;Lcom/avito/android/remote/model/AdvertDetails;)V", CommonKt.TAG_ERROR_CODE, "sendCreditBannerLoadingFailed", "(Lcom/avito/android/serp/ad/BannerInfo;Lcom/avito/android/remote/model/AdvertDetails;Ljava/lang/Integer;)V", "sendCreditBannerClick", "sendShortTermRentButtonClick", "sendAutotekaButtonClick", "url", "sendAutotekaTeaserButtonClick", "sendSafeShowItemClicked", "sendSafeShowDialogContactsButtonClicked", "sendSimilarsButtonClick", "sendClosedAdvertShowDescription", "locationId", "sendCommercialBannerClick", "(Lcom/avito/android/serp/ad/BannerInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "subscribe", "sendClickToPriceSubscription", "sendClickToEnableNotifications", "sendClickToConsultationItemButton", "sendClickToCallDeveloper", "title", "pos", "", "icebreakerIds", "sendShowIcebreakersBlock", "(Ljava/lang/String;ILjava/util/List;)V", "icebreakerId", "sendClickOnIcebreaker", "(Ljava/lang/String;II)V", "iid", "Lcom/avito/android/advert_core/analytics/guide/FromGuideBlock;", BookingInfoActivity.EXTRA_FROM_BLOCK, "sendClickGuide", "(Ljava/lang/String;Lcom/avito/android/advert_core/analytics/guide/FromGuideBlock;)V", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "getParent", "()Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "getRequestId", "()Ljava/lang/String;", "sendClickAdditionalInfoFromCheckedByAvito", "sendClickAdditionalInfoFromApartmentFeature", "sendMarketplaceBuyButtonClick", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "sendInfoBannerClick", "sendFAQButtonClick", "sendInStockInfoClick", "sendSimilarsShowMoreClick", "sendDomotekaFlatNumberRequestClick", "sendDomotekaTeaserButtonClick", "sendDomotekaStubButtonClick", "questionId", "sendQuestionAppear", "(ILjava/lang/String;)V", "answerId", "sendAnswerClick", "(IILjava/lang/String;)V", "sendQuestionClose", "developerId", "sendShowDeveloperPage", "trackBuyGeoReportEvent", "trackShowGeoReportExampleEvent", "trackDeliveryLocationChanged", "sendCartBuyButtonClick", "Lcom/avito/android/analytics/event/cart/OpenCartEvent$Source;", "cartItemsQuantity", "sendOpenCartEvent", "(Ljava/lang/String;Lcom/avito/android/analytics/event/cart/OpenCartEvent$Source;Ljava/lang/Integer;Ljava/lang/String;)V", "Lcom/avito/android/autoteka_details/core/analytics/event/FromBlock;", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/autoteka_details/core/analytics/event/FromBlock;)V", "Lcom/avito/android/remote/model/ParametrizedEvent;", "event", "sendParametrizedEvent", "(Lcom/avito/android/remote/model/ParametrizedEvent;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertDetailsAnalyticsInteractor extends CommercialBannersAnalyticsInteractor, CreditBrokerAnalyticsInteractor {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void sendBackClick$default(AdvertDetailsAnalyticsInteractor advertDetailsAnalyticsInteractor, String str, boolean z, BackFromPage backFromPage, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    backFromPage = BackFromPage.NONE;
                }
                advertDetailsAnalyticsInteractor.sendBackClick(str, z, backFromPage);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendBackClick");
        }
    }

    @NotNull
    TreeClickStreamParent getParent();

    @Nullable
    String getRequestId();

    void sendAdditionalSellerPhoneButtonClick(@NotNull String str);

    void sendAddressClick(@NotNull AdvertDetails advertDetails, @NotNull GeoFromBlock geoFromBlock);

    void sendAddressLongClick(@NotNull AdvertDetails advertDetails);

    void sendAnswerClick(int i, int i2, @NotNull String str);

    void sendAutoDealClick(@NotNull AdvertDetails advertDetails);

    void sendAutotekaButtonClick(@NotNull String str);

    void sendAutotekaTeaserButtonClick(@NotNull String str, @NotNull String str2);

    void sendAutotekaTeaserButtonClick(@NotNull String str, @NotNull String str2, @NotNull FromBlock fromBlock);

    void sendBackClick(@NotNull String str, boolean z, @NotNull BackFromPage backFromPage);

    void sendBadgeBarExpandButtonClicked(@NotNull String str);

    void sendBadgeClicked(@NotNull String str, int i);

    void sendCartBuyButtonClick(@NotNull String str, @Nullable String str2, @Nullable String str3);

    void sendClickAdditionalInfoFromApartmentFeature(@NotNull String str);

    void sendClickAdditionalInfoFromCheckedByAvito(@NotNull String str);

    void sendClickCall(@NotNull ContactBarData contactBarData, @NotNull SourceScreen sourceScreen);

    void sendClickGuide(@NotNull String str, @NotNull FromGuideBlock fromGuideBlock);

    void sendClickNote(@NotNull AdvertDetails advertDetails);

    void sendClickOnIcebreaker(@NotNull String str, int i, int i2);

    void sendClickSimilarFavorites(@NotNull AdvertDetails advertDetails, @NotNull ClickSimilarItemFavoritesAction clickSimilarItemFavoritesAction, @NotNull String str);

    void sendClickSimilarItem(@NotNull AdvertDetails advertDetails, @NotNull String str);

    void sendClickToCallDeveloper();

    void sendClickToConsultationItemButton(@NotNull String str);

    void sendClickToEnableNotifications(@NotNull String str);

    void sendClickToPriceSubscription(@NotNull String str, boolean z);

    void sendClickWrite(@NotNull ContactBarData contactBarData, boolean z, @NotNull SourceScreen sourceScreen, @Nullable String str);

    void sendClosedAdvertShowDescription(@NotNull String str);

    void sendCommercialBannerClick(@NotNull BannerInfo bannerInfo, @Nullable String str, @Nullable String str2, @Nullable String str3, int i);

    void sendCreditBannerClick(@NotNull BannerInfo bannerInfo, @NotNull AdvertDetails advertDetails);

    void sendCreditBannerInfoClick(@NotNull AdvertDetails advertDetails);

    void sendCreditBannerLoaded(@NotNull BannerInfo bannerInfo, @NotNull AdvertDetails advertDetails);

    void sendCreditBannerLoadingFailed(@NotNull BannerInfo bannerInfo, @NotNull AdvertDetails advertDetails, @Nullable Integer num);

    void sendDeliveryButtonClick(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, boolean z);

    void sendDeliveryInfoClick(@NotNull String str, @Nullable String str2);

    void sendDescriptionCopyText(@NotNull AdvertDetails advertDetails);

    void sendDescriptionExpand(@NotNull AdvertDetails advertDetails);

    void sendDescriptionExpandExist(@NotNull AdvertDetails advertDetails);

    void sendDevelopmentsCatalogClick(@NotNull AdvertDetails advertDetails, @NotNull String str);

    void sendDomotekaFlatNumberRequestClick();

    void sendDomotekaStubButtonClick();

    void sendDomotekaTeaserButtonClick();

    void sendEnterScreen();

    void sendFAQButtonClick(@NotNull String str);

    void sendFlatsClick(@NotNull AdvertDetails advertDetails, @NotNull String str);

    void sendGalleryEmbeddedSwipe(@NotNull AdvertDetails advertDetails);

    void sendGalleryShowFullscreen(@NotNull AdvertDetails advertDetails);

    void sendGroupsClick(@NotNull AdvertDetails advertDetails);

    void sendInStockInfoClick(@NotNull String str);

    void sendInfoBannerClick(@NotNull String str);

    void sendLoadAdvertErrorEvent(@NotNull String str, boolean z);

    void sendLoadAdvertEvent(@NotNull AdvertDetails advertDetails);

    void sendMarketplaceBuyButtonClick(@NotNull String str, @Nullable String str2, @Nullable String str3);

    void sendModelSpecificationsClick(@NotNull String str, @NotNull String str2, boolean z);

    void sendNoteAction(@NotNull AdvertDetails advertDetails, @NotNull NoteAction noteAction, @Nullable String str);

    void sendOpenCartEvent(@NotNull String str, @Nullable OpenCartEvent.Source source, @Nullable Integer num, @Nullable String str2);

    void sendParametrizedEvent(@NotNull ParametrizedEvent parametrizedEvent);

    void sendQuestionAppear(int i, @NotNull String str);

    void sendQuestionClose(int i, @NotNull String str);

    void sendSafeDealBuyButtonClick(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, boolean z, @Nullable String str5, @Nullable String str6);

    void sendSafeShowDialogContactsButtonClicked(@NotNull String str);

    void sendSafeShowItemClicked(@NotNull String str);

    void sendShortTermRentButtonClick(@NotNull String str, @NotNull String str2);

    void sendShowAbuse(@NotNull AdvertDetails advertDetails);

    void sendShowAdvert(@NotNull AdvertDetails advertDetails);

    void sendShowDeveloperPage(@NotNull String str, @Nullable String str2);

    void sendShowIcebreakersBlock(@NotNull String str, int i, @NotNull List<Integer> list);

    void sendShowModelSpecificationButton(@NotNull String str, @NotNull String str2);

    void sendShowScreenEvent(@NotNull String str, @NotNull String str2);

    void sendShowSellersProfile(@NotNull AdvertDetails advertDetails, @NotNull ShowSellersProfileSource showSellersProfileSource);

    void sendShowSimilars(@NotNull AdvertDetails advertDetails, @Nullable String str, int i);

    void sendSimilarsButtonClick(@NotNull String str);

    void sendSimilarsShowMoreClick();

    void sendVideoClick(@NotNull AdvertDetails advertDetails);

    void setAdvertDetails(@NotNull AdvertDetails advertDetails);

    void setSearchContext(@Nullable String str);

    void trackBuyGeoReportEvent(@NotNull String str);

    void trackDeliveryLocationChanged(@NotNull String str, @Nullable String str2);

    void trackShowGeoReportExampleEvent(@NotNull String str);
}
