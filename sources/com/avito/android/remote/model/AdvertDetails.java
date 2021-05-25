package com.avito.android.remote.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractorKt;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.item.details.ParameterId;
import com.avito.android.remote.marketplace.AdvertMarketPlace;
import com.avito.android.remote.model.advert_badge_bar.AdvertBadgeBar;
import com.avito.android.remote.model.feature_teaser.AdvertDetailsFeaturesTeasers;
import com.avito.android.remote.model.feature_teaser.ApartmentFeature;
import com.avito.android.remote.model.guide.Guide;
import com.avito.android.util.Constants;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import com.avito.android.util.UrlParams;
import com.facebook.appevents.integrity.IntegrityManager;
import com.google.gson.annotations.SerializedName;
import com.vk.sdk.api.model.VKAttachments;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.d;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 ¶\u00022\u00020\u00012\u00020\u0002:\u0002¶\u0002B\u0006\u0012\u0007\u0010\u0001\u001a\u00020\b\u0012\u0007\u0010\u0002\u001a\u00020\b\u0012\t\u0010\u0002\u001a\u0004\u0018\u00010\b\u0012\t\u0010\u0002\u001a\u0004\u0018\u00010\b\u0012\t\u0010å\u0001\u001a\u0004\u0018\u00010\b\u0012\n\u0010á\u0001\u001a\u0005\u0018\u00010à\u0001\u0012\f\b\u0002\u0010\u0001\u001a\u0005\u0018\u00010\u0001\u0012\u0006\u0010T\u001a\u00020S\u0012\b\u0010)\u001a\u0004\u0018\u00010\b\u0012\t\u0010\u0002\u001a\u0004\u0018\u00010\b\u0012\t\u0010ò\u0001\u001a\u0004\u0018\u00010\b\u0012\t\u0010Ø\u0001\u001a\u0004\u0018\u00010\b\u0012\t\u0010\u0002\u001a\u0004\u0018\u00010\b\u0012\b\u0010-\u001a\u0004\u0018\u00010,\u0012\n\u0010¼\u0001\u001a\u0005\u0018\u00010»\u0001\u0012\n\u0010è\u0001\u001a\u0005\u0018\u00010ç\u0001\u0012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001\u0012\u0007\u0010­\u0002\u001a\u00020\u0003\u0012\t\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\t\u0010Ü\u0001\u001a\u0004\u0018\u00010\b\u0012\b\u0010D\u001a\u0004\u0018\u00010\u0011\u0012\n\u0010©\u0001\u001a\u0005\u0018\u00010¨\u0001\u0012\n\u0010\u0002\u001a\u0005\u0018\u00010ÿ\u0001\u0012\b\u0010x\u001a\u0004\u0018\u00010w\u0012\b\u0010n\u001a\u0004\u0018\u00010m\u0012\n\u0010\u0002\u001a\u0005\u0018\u00010\u0002\u0012\u0011\u0010¡\u0002\u001a\f\u0012\u0005\u0012\u00030 \u0002\u0018\u00010ì\u0001\u0012\t\u0010\u0002\u001a\u0004\u0018\u00010\b\u0012\b\u0010<\u001a\u0004\u0018\u00010;\u0012\t\u0010û\u0001\u001a\u0004\u0018\u00010\u0018\u0012\n\u0010Ô\u0001\u001a\u0005\u0018\u00010Ó\u0001\u0012\b\u0010J\u001a\u0004\u0018\u00010I\u0012\u0014\u00102\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u000101\u0012\u0015\u0010ù\u0001\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u000101\u0012\b\u0010%\u001a\u0004\u0018\u00010$\u0012\n\u0010¤\u0002\u001a\u0005\u0018\u00010£\u0002\u0012\n\u0010¢\u0001\u001a\u0005\u0018\u00010¡\u0001\u0012\b\u0010X\u001a\u0004\u0018\u00010\b\u0012\n\u0010Í\u0001\u001a\u0005\u0018\u00010Ì\u0001\u0012\n\u0010°\u0001\u001a\u0005\u0018\u00010¯\u0001\u0012\u0007\u0010Å\u0001\u001a\u00020\u0003\u0012\u0013\b\u0002\u0010î\u0001\u001a\f\u0012\u0005\u0012\u00030í\u0001\u0018\u00010ì\u0001\u0012\f\b\u0002\u0010õ\u0001\u001a\u0005\u0018\u00010ô\u0001\u0012\u000b\b\u0002\u0010Þ\u0001\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010}\u001a\u0004\u0018\u00010|\u0012\u000b\b\u0002\u0010ý\u0001\u001a\u0004\u0018\u00010\b\u0012\f\b\u0002\u0010·\u0001\u001a\u0005\u0018\u00010¶\u0001\u0012\n\b\u0002\u0010]\u001a\u0004\u0018\u00010\\\u0012\f\b\u0002\u0010\u0001\u001a\u0005\u0018\u00010\u0001\u0012\f\b\u0002\u0010\u0002\u001a\u0005\u0018\u00010\u0002\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u0003\u0012\t\b\u0002\u0010\u0001\u001a\u00020\u0003\u0012\n\b\u0002\u0010s\u001a\u0004\u0018\u00010r\u0012\f\b\u0002\u0010È\u0001\u001a\u0005\u0018\u00010Ç\u0001\u0012\u0013\b\u0002\u0010©\u0002\u001a\f\u0012\u0005\u0012\u00030¨\u0002\u0018\u00010ì\u0001\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u000106\u0012\n\b\u0002\u0010d\u001a\u0004\u0018\u00010c\u0012\f\b\u0002\u0010Á\u0001\u001a\u0005\u0018\u00010À\u0001\u0012\f\b\u0002\u0010\u0001\u001a\u0005\u0018\u00010\u0001\u0012\f\b\u0002\u0010°\u0002\u001a\u0005\u0018\u00010¯\u0002\u0012\n\b\u0002\u0010O\u001a\u0004\u0018\u00010N\u0012\n\b\u0002\u0010i\u001a\u0004\u0018\u00010h\u0012\f\b\u0002\u0010\u0001\u001a\u0005\u0018\u00010\u0001¢\u0006\u0006\b´\u0002\u0010µ\u0002J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\u0005J\u0011\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\u0005J\u000f\u0010\f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\r\u0010\u0005J\r\u0010\u000e\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u0005J\r\u0010\u000f\u001a\u00020\u0003¢\u0006\u0004\b\u000f\u0010\u0005J\r\u0010\u0010\u001a\u00020\u0003¢\u0006\u0004\b\u0010\u0010\u0005J\r\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\b¢\u0006\u0004\b\u0014\u0010\nJ\r\u0010\u0015\u001a\u00020\u0003¢\u0006\u0004\b\u0015\u0010\u0005J\u0017\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010 \u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\"\u0010#R\u001e\u0010%\u001a\u0004\u0018\u00010$8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001e\u0010)\u001a\u0004\u0018\u00010\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010\nR\u001e\u0010-\u001a\u0004\u0018\u00010,8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R*\u00102\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u0001018\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u001e\u00107\u001a\u0004\u0018\u0001068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u001e\u0010<\u001a\u0004\u0018\u00010;8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\u001e\u0010@\u001a\u0004\u0018\u00010\u00038\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR\u001e\u0010D\u001a\u0004\u0018\u00010\u00118\u0006@\u0007X\u0004¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010\u0013R\u0015\u0010H\u001a\u0004\u0018\u00010\u00188F@\u0006¢\u0006\u0006\u001a\u0004\b\u0019\u0010GR\u001e\u0010J\u001a\u0004\u0018\u00010I8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010MR\u001e\u0010O\u001a\u0004\u0018\u00010N8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010RR\u001c\u0010T\u001a\u00020S8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\bT\u0010U\u001a\u0004\bV\u0010WR$\u0010X\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bX\u0010*\u001a\u0004\bY\u0010\n\"\u0004\bZ\u0010[R\u001e\u0010]\u001a\u0004\u0018\u00010\\8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`R\u0018\u0010b\u001a\u0004\u0018\u00010\u00118V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\ba\u0010\u0013R\u001e\u0010d\u001a\u0004\u0018\u00010c8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\bd\u0010e\u001a\u0004\bf\u0010gR\u001e\u0010i\u001a\u0004\u0018\u00010h8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\bi\u0010j\u001a\u0004\bk\u0010lR\u001e\u0010n\u001a\u0004\u0018\u00010m8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\bn\u0010o\u001a\u0004\bp\u0010qR\u001e\u0010s\u001a\u0004\u0018\u00010r8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\bs\u0010t\u001a\u0004\bu\u0010vR\u001e\u0010x\u001a\u0004\u0018\u00010w8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\bx\u0010y\u001a\u0004\bz\u0010{R\u001f\u0010}\u001a\u0004\u0018\u00010|8\u0006@\u0007X\u0004¢\u0006\r\n\u0004\b}\u0010~\u001a\u0005\b\u0010\u0001R \u0010\u0001\u001a\u00020\u00038\u0006@\u0007X\u0004¢\u0006\u000f\n\u0006\b\u0001\u0010\u0001\u001a\u0005\b\u0001\u0010\u0005R\u0018\u0010\u0001\u001a\u00020\b8V@\u0016X\u0004¢\u0006\u0007\u001a\u0005\b\u0001\u0010\nR$\u0010\u0001\u001a\u0005\u0018\u00010\u00018\u0006@\u0007X\u0004¢\u0006\u0010\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001R$\u0010\u0001\u001a\u0005\u0018\u00010\u00018\u0006@\u0007X\u0004¢\u0006\u0010\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001R$\u0010\u0001\u001a\u0005\u0018\u00010\u00018\u0006@\u0007X\u0004¢\u0006\u0010\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001R\u001f\u0010\u0001\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u000e\n\u0005\b\u0001\u0010*\u001a\u0005\b\u0001\u0010\nR$\u0010\u0001\u001a\u0005\u0018\u00010\u00018\u0006@\u0007X\u0004¢\u0006\u0010\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001R$\u0010\u0001\u001a\u0005\u0018\u00010\u00018\u0006@\u0007X\u0004¢\u0006\u0010\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010 \u0001R$\u0010¢\u0001\u001a\u0005\u0018\u00010¡\u00018\u0006@\u0007X\u0004¢\u0006\u0010\n\u0006\b¢\u0001\u0010£\u0001\u001a\u0006\b¤\u0001\u0010¥\u0001R\u0015\u0010§\u0001\u001a\u00020\b8F@\u0006¢\u0006\u0007\u001a\u0005\b¦\u0001\u0010\nR,\u0010©\u0001\u001a\u0005\u0018\u00010¨\u00018\u0006@\u0006X\u000e¢\u0006\u0018\n\u0006\b©\u0001\u0010ª\u0001\u001a\u0006\b«\u0001\u0010¬\u0001\"\u0006\b­\u0001\u0010®\u0001R$\u0010°\u0001\u001a\u0005\u0018\u00010¯\u00018\u0006@\u0007X\u0004¢\u0006\u0010\n\u0006\b°\u0001\u0010±\u0001\u001a\u0006\b²\u0001\u0010³\u0001R\u0018\u0010µ\u0001\u001a\u00020\b8V@\u0016X\u0004¢\u0006\u0007\u001a\u0005\b´\u0001\u0010\nR$\u0010·\u0001\u001a\u0005\u0018\u00010¶\u00018\u0006@\u0007X\u0004¢\u0006\u0010\n\u0006\b·\u0001\u0010¸\u0001\u001a\u0006\b¹\u0001\u0010º\u0001R$\u0010¼\u0001\u001a\u0005\u0018\u00010»\u00018\u0006@\u0007X\u0004¢\u0006\u0010\n\u0006\b¼\u0001\u0010½\u0001\u001a\u0006\b¾\u0001\u0010¿\u0001R$\u0010Á\u0001\u001a\u0005\u0018\u00010À\u00018\u0006@\u0007X\u0004¢\u0006\u0010\n\u0006\bÁ\u0001\u0010Â\u0001\u001a\u0006\bÃ\u0001\u0010Ä\u0001R \u0010Å\u0001\u001a\u00020\u00038\u0006@\u0007X\u0004¢\u0006\u000f\n\u0006\bÅ\u0001\u0010\u0001\u001a\u0005\bÆ\u0001\u0010\u0005R$\u0010È\u0001\u001a\u0005\u0018\u00010Ç\u00018\u0006@\u0007X\u0004¢\u0006\u0010\n\u0006\bÈ\u0001\u0010É\u0001\u001a\u0006\bÊ\u0001\u0010Ë\u0001R,\u0010Í\u0001\u001a\u0005\u0018\u00010Ì\u00018\u0006@\u0006X\u000e¢\u0006\u0018\n\u0006\bÍ\u0001\u0010Î\u0001\u001a\u0006\bÏ\u0001\u0010Ð\u0001\"\u0006\bÑ\u0001\u0010Ò\u0001R$\u0010Ô\u0001\u001a\u0005\u0018\u00010Ó\u00018\u0006@\u0007X\u0004¢\u0006\u0010\n\u0006\bÔ\u0001\u0010Õ\u0001\u001a\u0006\bÖ\u0001\u0010×\u0001R!\u0010Ø\u0001\u001a\u0004\u0018\u00010\b8\u0006@\u0007X\u0004¢\u0006\u000e\n\u0005\bØ\u0001\u0010*\u001a\u0005\bÙ\u0001\u0010\nR\u0018\u0010Û\u0001\u001a\u00020\b8V@\u0016X\u0004¢\u0006\u0007\u001a\u0005\bÚ\u0001\u0010\nR!\u0010Ü\u0001\u001a\u0004\u0018\u00010\b8\u0006@\u0007X\u0004¢\u0006\u000e\n\u0005\bÜ\u0001\u0010*\u001a\u0005\bÝ\u0001\u0010\nR!\u0010Þ\u0001\u001a\u0004\u0018\u00010\b8\u0006@\u0007X\u0004¢\u0006\u000e\n\u0005\bÞ\u0001\u0010*\u001a\u0005\bß\u0001\u0010\nR$\u0010á\u0001\u001a\u0005\u0018\u00010à\u00018\u0006@\u0007X\u0004¢\u0006\u0010\n\u0006\bá\u0001\u0010â\u0001\u001a\u0006\bã\u0001\u0010ä\u0001R!\u0010å\u0001\u001a\u0004\u0018\u00010\b8\u0006@\u0007X\u0004¢\u0006\u000e\n\u0005\bå\u0001\u0010*\u001a\u0005\bæ\u0001\u0010\nR$\u0010è\u0001\u001a\u0005\u0018\u00010ç\u00018\u0006@\u0007X\u0004¢\u0006\u0010\n\u0006\bè\u0001\u0010é\u0001\u001a\u0006\bê\u0001\u0010ë\u0001R+\u0010î\u0001\u001a\f\u0012\u0005\u0012\u00030í\u0001\u0018\u00010ì\u00018\u0006@\u0007X\u0004¢\u0006\u0010\n\u0006\bî\u0001\u0010ï\u0001\u001a\u0006\bð\u0001\u0010ñ\u0001R!\u0010ò\u0001\u001a\u0004\u0018\u00010\b8\u0006@\u0007X\u0004¢\u0006\u000e\n\u0005\bò\u0001\u0010*\u001a\u0005\bó\u0001\u0010\nR$\u0010õ\u0001\u001a\u0005\u0018\u00010ô\u00018\u0006@\u0007X\u0004¢\u0006\u0010\n\u0006\bõ\u0001\u0010ö\u0001\u001a\u0006\b÷\u0001\u0010ø\u0001R-\u0010ù\u0001\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u0001018\u0006@\u0007X\u0004¢\u0006\u000e\n\u0005\bù\u0001\u00103\u001a\u0005\bú\u0001\u00105R\u001b\u0010û\u0001\u001a\u0004\u0018\u00010\u00188\u0002@\u0003X\u0004¢\u0006\b\n\u0006\bû\u0001\u0010ü\u0001R!\u0010ý\u0001\u001a\u0004\u0018\u00010\b8\u0006@\u0007X\u0004¢\u0006\u000e\n\u0005\bý\u0001\u0010*\u001a\u0005\bþ\u0001\u0010\nR,\u0010\u0002\u001a\u0005\u0018\u00010ÿ\u00018\u0006@\u0006X\u000e¢\u0006\u0018\n\u0006\b\u0002\u0010\u0002\u001a\u0006\b\u0002\u0010\u0002\"\u0006\b\u0002\u0010\u0002R$\u0010\u0002\u001a\u0005\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\u0010\n\u0006\b\u0002\u0010\u0002\u001a\u0006\b\u0002\u0010\u0002R$\u0010\u0002\u001a\u0005\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\u0010\n\u0006\b\u0002\u0010\u0002\u001a\u0006\b\u0002\u0010\u0002R!\u0010\u0002\u001a\u0004\u0018\u00010\b8\u0006@\u0007X\u0004¢\u0006\u000e\n\u0005\b\u0002\u0010*\u001a\u0005\b\u0002\u0010\nR!\u0010\u0002\u001a\u0004\u0018\u00010\b8\u0006@\u0007X\u0004¢\u0006\u000e\n\u0005\b\u0002\u0010*\u001a\u0005\b\u0002\u0010\nR!\u0010\u0002\u001a\u0004\u0018\u00010\b8\u0006@\u0007X\u0004¢\u0006\u000e\n\u0005\b\u0002\u0010*\u001a\u0005\b\u0002\u0010\nR!\u0010\u0002\u001a\u0004\u0018\u00010\b8\u0006@\u0007X\u0004¢\u0006\u000e\n\u0005\b\u0002\u0010*\u001a\u0005\b\u0002\u0010\nR(\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u0017\n\u0006\b\u0002\u0010\u0001\u001a\u0005\b\u0002\u0010\u0005\"\u0006\b\u0002\u0010\u0002R\u001f\u0010\u0002\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u000e\n\u0005\b\u0002\u0010*\u001a\u0005\b\u0002\u0010\nR!\u0010\u0002\u001a\u0004\u0018\u00010\b8\u0006@\u0007X\u0004¢\u0006\u000e\n\u0005\b\u0002\u0010*\u001a\u0005\b\u0002\u0010\nR+\u0010¡\u0002\u001a\f\u0012\u0005\u0012\u00030 \u0002\u0018\u00010ì\u00018\u0006@\u0007X\u0004¢\u0006\u0010\n\u0006\b¡\u0002\u0010ï\u0001\u001a\u0006\b¢\u0002\u0010ñ\u0001R$\u0010¤\u0002\u001a\u0005\u0018\u00010£\u00028\u0006@\u0007X\u0004¢\u0006\u0010\n\u0006\b¤\u0002\u0010¥\u0002\u001a\u0006\b¦\u0002\u0010§\u0002R+\u0010©\u0002\u001a\f\u0012\u0005\u0012\u00030¨\u0002\u0018\u00010ì\u00018\u0006@\u0007X\u0004¢\u0006\u0010\n\u0006\b©\u0002\u0010ï\u0001\u001a\u0006\bª\u0002\u0010ñ\u0001R\u0018\u0010¬\u0002\u001a\u00020\b8V@\u0016X\u0004¢\u0006\u0007\u001a\u0005\b«\u0002\u0010\nR(\u0010­\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u0017\n\u0006\b­\u0002\u0010\u0001\u001a\u0005\b­\u0002\u0010\u0005\"\u0006\b®\u0002\u0010\u0002R$\u0010°\u0002\u001a\u0005\u0018\u00010¯\u00028\u0006@\u0007X\u0004¢\u0006\u0010\n\u0006\b°\u0002\u0010±\u0002\u001a\u0006\b²\u0002\u0010³\u0002¨\u0006·\u0002"}, d2 = {"Lcom/avito/android/remote/model/AdvertDetails;", "Landroid/os/Parcelable;", "Lcom/avito/android/remote/model/LocationInfo;", "", "hasLocation", "()Z", "hasMetro", "hasAddress", "", "getAddress", "()Ljava/lang/String;", "hasDirection", "hasDistrict", "hasCoordinates", "isShopAdvert", "isFromCompany", "isMarketplace", "Lcom/avito/android/remote/model/Coordinates;", "advertCoordinates", "()Lcom/avito/android/remote/model/Coordinates;", "advertTitle", "isActive", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/remote/model/AdvertActions;", "getAdvertActions", "(Lcom/avito/android/Features;)Lcom/avito/android/remote/model/AdvertActions;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "Lcom/avito/android/remote/model/DfpBannerItem;", "creditInfo", "Lcom/avito/android/remote/model/DfpBannerItem;", "getCreditInfo", "()Lcom/avito/android/remote/model/DfpBannerItem;", "categoryId", "Ljava/lang/String;", "getCategoryId", "Lcom/avito/android/remote/model/SafeDeal;", "safeDeal", "Lcom/avito/android/remote/model/SafeDeal;", "getSafeDeal", "()Lcom/avito/android/remote/model/SafeDeal;", "", "firebaseParams", "Ljava/util/Map;", "getFirebaseParams", "()Ljava/util/Map;", "Lcom/avito/android/remote/marketplace/AdvertMarketPlace;", "marketplaceData", "Lcom/avito/android/remote/marketplace/AdvertMarketPlace;", "getMarketplaceData", "()Lcom/avito/android/remote/marketplace/AdvertMarketPlace;", "Lcom/avito/android/remote/model/AdvertStats;", "stats", "Lcom/avito/android/remote/model/AdvertStats;", "getStats", "()Lcom/avito/android/remote/model/AdvertStats;", "shouldShowDomotekaTeaser", "Ljava/lang/Boolean;", "getShouldShowDomotekaTeaser", "()Ljava/lang/Boolean;", "coordinatesParam", "Lcom/avito/android/remote/model/Coordinates;", "getCoordinatesParam", "()Lcom/avito/android/remote/model/AdvertActions;", "advertActions", "Lcom/avito/android/remote/model/AnonymousNumber;", "anonymousNumber", "Lcom/avito/android/remote/model/AnonymousNumber;", "getAnonymousNumber", "()Lcom/avito/android/remote/model/AnonymousNumber;", "Lcom/avito/android/remote/model/CarMarketPrice;", "carMarketPrice", "Lcom/avito/android/remote/model/CarMarketPrice;", "getCarMarketPrice", "()Lcom/avito/android/remote/model/CarMarketPrice;", "", "time", "J", "getTime", "()J", VKAttachments.TYPE_NOTE, "getNote", "setNote", "(Ljava/lang/String;)V", "Lcom/avito/android/remote/model/advert_badge_bar/AdvertBadgeBar;", "badgeBar", "Lcom/avito/android/remote/model/advert_badge_bar/AdvertBadgeBar;", "getBadgeBar", "()Lcom/avito/android/remote/model/advert_badge_bar/AdvertBadgeBar;", "getCoordinates", "coordinates", "Lcom/avito/android/remote/model/ForegroundImage;", "infoImage", "Lcom/avito/android/remote/model/ForegroundImage;", "getInfoImage", "()Lcom/avito/android/remote/model/ForegroundImage;", "Lcom/avito/android/remote/model/CREGeoReportTeaser;", "geoReportTeaser", "Lcom/avito/android/remote/model/CREGeoReportTeaser;", "getGeoReportTeaser", "()Lcom/avito/android/remote/model/CREGeoReportTeaser;", "Lcom/avito/android/remote/model/AdvertParameters;", ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, "Lcom/avito/android/remote/model/AdvertParameters;", "getParameters", "()Lcom/avito/android/remote/model/AdvertParameters;", "Lcom/avito/android/remote/model/IceBreakers;", "icebreakers", "Lcom/avito/android/remote/model/IceBreakers;", "getIcebreakers", "()Lcom/avito/android/remote/model/IceBreakers;", "Lcom/avito/android/remote/model/AdvertDisclaimer;", "disclaimer", "Lcom/avito/android/remote/model/AdvertDisclaimer;", "getDisclaimer", "()Lcom/avito/android/remote/model/AdvertDisclaimer;", "Lcom/avito/android/remote/model/SimpleAdvertAction;", "similarAction", "Lcom/avito/android/remote/model/SimpleAdvertAction;", "getSimilarAction", "()Lcom/avito/android/remote/model/SimpleAdvertAction;", "shouldShowDevelopmentsAdvice", "Z", "getShouldShowDevelopmentsAdvice", "getDirectionName", "directionName", "Lcom/avito/android/remote/model/guide/Guide;", "guide", "Lcom/avito/android/remote/model/guide/Guide;", "getGuide", "()Lcom/avito/android/remote/model/guide/Guide;", "Lcom/avito/android/remote/model/Booking;", "booking", "Lcom/avito/android/remote/model/Booking;", "getBooking", "()Lcom/avito/android/remote/model/Booking;", "Lcom/avito/android/remote/model/AdvertDiscounts;", "discounts", "Lcom/avito/android/remote/model/AdvertDiscounts;", "getDiscounts", "()Lcom/avito/android/remote/model/AdvertDiscounts;", "id", "getId", "", "customerValue", "Ljava/lang/Double;", "getCustomerValue", "()Ljava/lang/Double;", "Lcom/avito/android/remote/model/AdvertSharing;", "sharing", "Lcom/avito/android/remote/model/AdvertSharing;", "getSharing", "()Lcom/avito/android/remote/model/AdvertSharing;", "Lcom/avito/android/remote/model/AutotekaTeaserItemResponse;", "autotekaTeaser", "Lcom/avito/android/remote/model/AutotekaTeaserItemResponse;", "getAutotekaTeaser", "()Lcom/avito/android/remote/model/AutotekaTeaserItemResponse;", "getCategoryName", "categoryName", "Lcom/avito/android/remote/model/AdvertSeller;", "seller", "Lcom/avito/android/remote/model/AdvertSeller;", "getSeller", "()Lcom/avito/android/remote/model/AdvertSeller;", "setSeller", "(Lcom/avito/android/remote/model/AdvertSeller;)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "autoCatalogAction", "Lcom/avito/android/deep_linking/links/DeepLink;", "getAutoCatalogAction", "()Lcom/avito/android/deep_linking/links/DeepLink;", "getLocationName", Constants.LOCATION_NAME, "Lcom/avito/android/remote/model/PriceBadge;", "priceBadge", "Lcom/avito/android/remote/model/PriceBadge;", "getPriceBadge", "()Lcom/avito/android/remote/model/PriceBadge;", "Lcom/avito/android/remote/model/AdvertDeliveryC2C;", "delivery", "Lcom/avito/android/remote/model/AdvertDeliveryC2C;", "getDelivery", "()Lcom/avito/android/remote/model/AdvertDeliveryC2C;", "Lcom/avito/android/remote/model/SparePartsParameters;", "sparePartsParams", "Lcom/avito/android/remote/model/SparePartsParameters;", "getSparePartsParams", "()Lcom/avito/android/remote/model/SparePartsParameters;", "needToCheckCreditInfo", "getNeedToCheckCreditInfo", "Lcom/avito/android/remote/model/feature_teaser/AdvertDetailsFeaturesTeasers;", "teasers", "Lcom/avito/android/remote/model/feature_teaser/AdvertDetailsFeaturesTeasers;", "getTeasers", "()Lcom/avito/android/remote/model/feature_teaser/AdvertDetailsFeaturesTeasers;", "Lcom/avito/android/remote/model/AdjustParameters;", "adjustParameters", "Lcom/avito/android/remote/model/AdjustParameters;", "getAdjustParameters", "()Lcom/avito/android/remote/model/AdjustParameters;", "setAdjustParameters", "(Lcom/avito/android/remote/model/AdjustParameters;)V", "Lcom/avito/android/remote/model/References;", "references", "Lcom/avito/android/remote/model/References;", "getReferences", "()Lcom/avito/android/remote/model/References;", UrlParams.DISTRICT_ID, "getDistrictId", "getDistrictName", "districtName", "addressParam", "getAddressParam", "closingReason", "getClosingReason", "Lcom/avito/android/remote/model/AdvertPrice;", "price", "Lcom/avito/android/remote/model/AdvertPrice;", "getPrice", "()Lcom/avito/android/remote/model/AdvertPrice;", "userType", "getUserType", "Lcom/avito/android/remote/model/AdvertShortTermRent;", "shortTermRent", "Lcom/avito/android/remote/model/AdvertShortTermRent;", "getShortTermRent", "()Lcom/avito/android/remote/model/AdvertShortTermRent;", "", "Lcom/avito/android/remote/model/GeoReference;", "geoReferences", "Ljava/util/List;", "getGeoReferences", "()Ljava/util/List;", UrlParams.METRO_ID, "getMetroId", "Lcom/avito/android/remote/model/VehicleType;", "vehicleType", "Lcom/avito/android/remote/model/VehicleType;", "getVehicleType", "()Lcom/avito/android/remote/model/VehicleType;", "viewItemAndBuyerEventsParams", "getViewItemAndBuyerEventsParams", "contacts", "Lcom/avito/android/remote/model/AdvertActions;", "status", "getStatus", "Lcom/avito/android/remote/model/AdditionalSeller;", "additionalSeller", "Lcom/avito/android/remote/model/AdditionalSeller;", "getAdditionalSeller", "()Lcom/avito/android/remote/model/AdditionalSeller;", "setAdditionalSeller", "(Lcom/avito/android/remote/model/AdditionalSeller;)V", "Lcom/avito/android/remote/model/Video;", "video", "Lcom/avito/android/remote/model/Video;", "getVideo", "()Lcom/avito/android/remote/model/Video;", "Lcom/avito/android/remote/model/AdvertVerification;", "verification", "Lcom/avito/android/remote/model/AdvertVerification;", "getVerification", "()Lcom/avito/android/remote/model/AdvertVerification;", "description", "getDescription", "shopId", "getShopId", UrlParams.DIRECTION_ID, "getDirectionId", "descriptionHtml", "getDescriptionHtml", "shouldShowMapPreview", "getShouldShowMapPreview", "setShouldShowMapPreview", "(Z)V", "title", "getTitle", "locationId", "getLocationId", "Lcom/avito/android/remote/model/Image;", "images", "getImages", "Lcom/avito/android/remote/model/AutoDeal;", "autoDeal", "Lcom/avito/android/remote/model/AutoDeal;", "getAutoDeal", "()Lcom/avito/android/remote/model/AutoDeal;", "Lcom/avito/android/remote/model/feature_teaser/ApartmentFeature;", "apartmentFeatures", "getApartmentFeatures", "getMetroName", "metroName", "isFavorite", "setFavorite", "Lcom/avito/android/remote/model/Questionnaire;", "questionnaire", "Lcom/avito/android/remote/model/Questionnaire;", "getQuestionnaire", "()Lcom/avito/android/remote/model/Questionnaire;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/AdvertPrice;Lcom/avito/android/remote/model/AdvertDiscounts;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/SafeDeal;Lcom/avito/android/remote/model/AdvertDeliveryC2C;Lcom/avito/android/remote/model/AdvertShortTermRent;Lcom/avito/android/remote/model/AdvertSharing;ZZLjava/lang/String;Lcom/avito/android/remote/model/Coordinates;Lcom/avito/android/remote/model/AdvertSeller;Lcom/avito/android/remote/model/AdditionalSeller;Lcom/avito/android/remote/model/AdvertDisclaimer;Lcom/avito/android/remote/model/AdvertParameters;Lcom/avito/android/remote/model/Video;Ljava/util/List;Ljava/lang/String;Lcom/avito/android/remote/model/AdvertStats;Lcom/avito/android/remote/model/AdvertActions;Lcom/avito/android/remote/model/References;Lcom/avito/android/remote/model/AnonymousNumber;Ljava/util/Map;Ljava/util/Map;Lcom/avito/android/remote/model/DfpBannerItem;Lcom/avito/android/remote/model/AutoDeal;Lcom/avito/android/remote/model/AutotekaTeaserItemResponse;Ljava/lang/String;Lcom/avito/android/remote/model/AdjustParameters;Lcom/avito/android/deep_linking/links/DeepLink;ZLjava/util/List;Lcom/avito/android/remote/model/VehicleType;Ljava/lang/String;Lcom/avito/android/remote/model/SimpleAdvertAction;Ljava/lang/String;Lcom/avito/android/remote/model/PriceBadge;Lcom/avito/android/remote/model/advert_badge_bar/AdvertBadgeBar;Lcom/avito/android/remote/model/guide/Guide;Lcom/avito/android/remote/model/AdvertVerification;Ljava/lang/Boolean;ZLcom/avito/android/remote/model/IceBreakers;Lcom/avito/android/remote/model/feature_teaser/AdvertDetailsFeaturesTeasers;Ljava/util/List;Lcom/avito/android/remote/marketplace/AdvertMarketPlace;Lcom/avito/android/remote/model/ForegroundImage;Lcom/avito/android/remote/model/SparePartsParameters;Lcom/avito/android/remote/model/Booking;Lcom/avito/android/remote/model/Questionnaire;Lcom/avito/android/remote/model/CarMarketPrice;Lcom/avito/android/remote/model/CREGeoReportTeaser;Ljava/lang/Double;)V", "Companion", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public class AdvertDetails implements Parcelable, LocationInfo {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<AdvertDetails> CREATOR = Parcels.creator(AdvertDetails$Companion$CREATOR$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @SerializedName("additionalSeller")
    @Nullable
    private AdditionalSeller additionalSeller;
    @SerializedName(IntegrityManager.INTEGRITY_TYPE_ADDRESS)
    @Nullable
    private final String addressParam;
    @SerializedName("adjustParams")
    @Nullable
    private AdjustParameters adjustParameters;
    @SerializedName("anonymousNumber")
    @Nullable
    private final AnonymousNumber anonymousNumber;
    @SerializedName("advertOptions")
    @Nullable
    private final List<ApartmentFeature> apartmentFeatures;
    @SerializedName("autoCatalogAction")
    @Nullable
    private final DeepLink autoCatalogAction;
    @SerializedName("autodeal")
    @Nullable
    private final AutoDeal autoDeal;
    @SerializedName("autotekaTeaser")
    @Nullable
    private final AutotekaTeaserItemResponse autotekaTeaser;
    @SerializedName("badgeBar")
    @Nullable
    private final AdvertBadgeBar badgeBar;
    @SerializedName("carBooking")
    @Nullable
    private final Booking booking;
    @SerializedName("carMarketPrice")
    @Nullable
    private final CarMarketPrice carMarketPrice;
    @SerializedName("categoryId")
    @Nullable
    private final String categoryId;
    @SerializedName("closingReason")
    @Nullable
    private final String closingReason;
    @SerializedName("contacts")
    private final AdvertActions contacts;
    @SerializedName(ParameterId.COORDS)
    @Nullable
    private final Coordinates coordinatesParam;
    @SerializedName("creditInfo")
    @Nullable
    private final DfpBannerItem creditInfo;
    @SerializedName("customerValue")
    @Nullable
    private final Double customerValue;
    @SerializedName("deliveryC2C")
    @Nullable
    private final AdvertDeliveryC2C delivery;
    @SerializedName("description")
    @Nullable
    private final String description;
    @SerializedName("descriptionHtml")
    @Nullable
    private final String descriptionHtml;
    @SerializedName(UrlParams.DIRECTION_ID)
    @Nullable
    private final String directionId;
    @SerializedName("disclaimer")
    @Nullable
    private final AdvertDisclaimer disclaimer;
    @SerializedName("discounts")
    @Nullable
    private final AdvertDiscounts discounts;
    @SerializedName(UrlParams.DISTRICT_ID)
    @Nullable
    private final String districtId;
    @SerializedName("firebaseParams")
    @Nullable
    private final Map<String, String> firebaseParams;
    @SerializedName("geoReferences")
    @Nullable
    private final List<GeoReference> geoReferences;
    @SerializedName("CREGeoReportTeaser")
    @Nullable
    private final CREGeoReportTeaser geoReportTeaser;
    @SerializedName("guide")
    @Nullable
    private final Guide guide;
    @SerializedName("icebreakers")
    @Nullable
    private final IceBreakers icebreakers;
    @SerializedName("id")
    @NotNull
    private final String id;
    @SerializedName("images")
    @Nullable
    private final List<Image> images;
    @SerializedName("infoImage")
    @Nullable
    private final ForegroundImage infoImage;
    @SerializedName("isFavorite")
    private boolean isFavorite;
    @SerializedName("locationId")
    @Nullable
    private final String locationId;
    @SerializedName(AdvertDetailsAnalyticsInteractorKt.SAFEDEAL_SERVICE_MARKETPLACE)
    @Nullable
    private final AdvertMarketPlace marketplaceData;
    @SerializedName(UrlParams.METRO_ID)
    @Nullable
    private final String metroId;
    @SerializedName("needToCheckCreditInfo")
    private final boolean needToCheckCreditInfo;
    @SerializedName(VKAttachments.TYPE_NOTE)
    @Nullable
    private String note;
    @SerializedName(ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT)
    @Nullable
    private final AdvertParameters parameters;
    @SerializedName("price")
    @Nullable
    private final AdvertPrice price;
    @SerializedName("priceBadge")
    @Nullable
    private final PriceBadge priceBadge;
    @SerializedName("survey")
    @Nullable
    private final Questionnaire questionnaire;
    @SerializedName("refs")
    @Nullable
    private final References references;
    @SerializedName("safeDeal")
    @Nullable
    private final SafeDeal safeDeal;
    @SerializedName("seller")
    @Nullable
    private AdvertSeller seller;
    @SerializedName("sharing")
    @Nullable
    private final AdvertSharing sharing;
    @SerializedName("shopId")
    @Nullable
    private final String shopId;
    @SerializedName("shortTermRent")
    @Nullable
    private final AdvertShortTermRent shortTermRent;
    @SerializedName("shouldShowDevelopmentsAdvice")
    private final boolean shouldShowDevelopmentsAdvice;
    @SerializedName("shouldShowDomotekaTeaser")
    @Nullable
    private final Boolean shouldShowDomotekaTeaser;
    @SerializedName("shouldShowMapPreview")
    private boolean shouldShowMapPreview;
    @SerializedName("similarAction")
    @Nullable
    private final SimpleAdvertAction similarAction;
    @SerializedName("sparePart")
    @Nullable
    private final SparePartsParameters sparePartsParams;
    @SerializedName("stats")
    @Nullable
    private final AdvertStats stats;
    @SerializedName("status")
    @Nullable
    private final String status;
    @SerializedName("features")
    @Nullable
    private final AdvertDetailsFeaturesTeasers teasers;
    @SerializedName("time")
    private final long time;
    @SerializedName("title")
    @NotNull
    private final String title;
    @SerializedName("userType")
    @Nullable
    private final String userType;
    @SerializedName("vehicleType")
    @Nullable
    private final VehicleType vehicleType;
    @SerializedName("verification")
    @Nullable
    private final AdvertVerification verification;
    @SerializedName("video")
    @Nullable
    private final Video video;
    @SerializedName("viewItemAndBuyerEventsParams")
    @Nullable
    private final Map<String, String> viewItemAndBuyerEventsParams;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/AdvertDetails$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/AdvertDetails;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    public AdvertDetails(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable AdvertPrice advertPrice, @Nullable AdvertDiscounts advertDiscounts, long j, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10, @Nullable SafeDeal safeDeal2, @Nullable AdvertDeliveryC2C advertDeliveryC2C, @Nullable AdvertShortTermRent advertShortTermRent, @Nullable AdvertSharing advertSharing, boolean z, boolean z2, @Nullable String str11, @Nullable Coordinates coordinates, @Nullable AdvertSeller advertSeller, @Nullable AdditionalSeller additionalSeller2, @Nullable AdvertDisclaimer advertDisclaimer, @Nullable AdvertParameters advertParameters, @Nullable Video video2, @Nullable List<Image> list, @Nullable String str12, @Nullable AdvertStats advertStats, @Nullable AdvertActions advertActions, @Nullable References references2, @Nullable AnonymousNumber anonymousNumber2, @Nullable Map<String, String> map, @Nullable Map<String, String> map2, @Nullable DfpBannerItem dfpBannerItem, @Nullable AutoDeal autoDeal2, @Nullable AutotekaTeaserItemResponse autotekaTeaserItemResponse, @Nullable String str13, @Nullable AdjustParameters adjustParameters2, @Nullable DeepLink deepLink, boolean z3, @Nullable List<GeoReference> list2, @Nullable VehicleType vehicleType2, @Nullable String str14, @Nullable SimpleAdvertAction simpleAdvertAction, @Nullable String str15, @Nullable PriceBadge priceBadge2, @Nullable AdvertBadgeBar advertBadgeBar, @Nullable Guide guide2, @Nullable AdvertVerification advertVerification, @Nullable Boolean bool, boolean z4, @Nullable IceBreakers iceBreakers, @Nullable AdvertDetailsFeaturesTeasers advertDetailsFeaturesTeasers, @Nullable List<ApartmentFeature> list3, @Nullable AdvertMarketPlace advertMarketPlace, @Nullable ForegroundImage foregroundImage, @Nullable SparePartsParameters sparePartsParameters, @Nullable Booking booking2, @Nullable Questionnaire questionnaire2, @Nullable CarMarketPrice carMarketPrice2, @Nullable CREGeoReportTeaser cREGeoReportTeaser, @Nullable Double d) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        this.id = str;
        this.title = str2;
        this.description = str3;
        this.descriptionHtml = str4;
        this.userType = str5;
        this.price = advertPrice;
        this.discounts = advertDiscounts;
        this.time = j;
        this.categoryId = str6;
        this.locationId = str7;
        this.metroId = str8;
        this.districtId = str9;
        this.directionId = str10;
        this.safeDeal = safeDeal2;
        this.delivery = advertDeliveryC2C;
        this.shortTermRent = advertShortTermRent;
        this.sharing = advertSharing;
        this.isFavorite = z;
        this.shouldShowMapPreview = z2;
        this.addressParam = str11;
        this.coordinatesParam = coordinates;
        this.seller = advertSeller;
        this.additionalSeller = additionalSeller2;
        this.disclaimer = advertDisclaimer;
        this.parameters = advertParameters;
        this.video = video2;
        this.images = list;
        this.shopId = str12;
        this.stats = advertStats;
        this.contacts = advertActions;
        this.references = references2;
        this.anonymousNumber = anonymousNumber2;
        this.firebaseParams = map;
        this.viewItemAndBuyerEventsParams = map2;
        this.creditInfo = dfpBannerItem;
        this.autoDeal = autoDeal2;
        this.autotekaTeaser = autotekaTeaserItemResponse;
        this.note = str13;
        this.adjustParameters = adjustParameters2;
        this.autoCatalogAction = deepLink;
        this.needToCheckCreditInfo = z3;
        this.geoReferences = list2;
        this.vehicleType = vehicleType2;
        this.closingReason = str14;
        this.similarAction = simpleAdvertAction;
        this.status = str15;
        this.priceBadge = priceBadge2;
        this.badgeBar = advertBadgeBar;
        this.guide = guide2;
        this.verification = advertVerification;
        this.shouldShowDomotekaTeaser = bool;
        this.shouldShowDevelopmentsAdvice = z4;
        this.icebreakers = iceBreakers;
        this.teasers = advertDetailsFeaturesTeasers;
        this.apartmentFeatures = list3;
        this.marketplaceData = advertMarketPlace;
        this.infoImage = foregroundImage;
        this.sparePartsParams = sparePartsParameters;
        this.booking = booking2;
        this.questionnaire = questionnaire2;
        this.carMarketPrice = carMarketPrice2;
        this.geoReportTeaser = cREGeoReportTeaser;
        this.customerValue = d;
    }

    @NotNull
    public final Coordinates advertCoordinates() {
        Coordinates coordinates = getCoordinates();
        return coordinates != null ? coordinates : new Coordinates(0.0d, 0.0d);
    }

    @NotNull
    public final String advertTitle() {
        return this.title;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final AdditionalSeller getAdditionalSeller() {
        return this.additionalSeller;
    }

    @Override // com.avito.android.remote.model.LocationInfo
    @Nullable
    public String getAddress() {
        return this.addressParam;
    }

    @Nullable
    public final String getAddressParam() {
        return this.addressParam;
    }

    @Nullable
    public final AdjustParameters getAdjustParameters() {
        return this.adjustParameters;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0022, code lost:
        if (r1 != null) goto L_0x0029;
     */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.avito.android.remote.model.AdvertActions getAdvertActions(@org.jetbrains.annotations.NotNull com.avito.android.Features r4) {
        /*
            r3 = this;
            java.lang.String r0 = "features"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            com.avito.android.remote.marketplace.AdvertMarketPlace r0 = r3.marketplaceData
            if (r0 == 0) goto L_0x0036
            com.avito.android.remote.model.AdvertAction$Cart r1 = r0.getCartAction()
            r2 = 0
            if (r1 == 0) goto L_0x0025
            com.avito.android.toggle.Feature r4 = r4.getAddToCartOnAdvert()
            java.lang.Object r4 = r4.invoke()
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x0021
            goto L_0x0022
        L_0x0021:
            r1 = r2
        L_0x0022:
            if (r1 == 0) goto L_0x0025
            goto L_0x0029
        L_0x0025:
            com.avito.android.remote.model.AdvertAction$Buy r1 = r0.getBuyAction()
        L_0x0029:
            if (r1 == 0) goto L_0x0035
            com.avito.android.remote.model.AdvertActions r4 = new com.avito.android.remote.model.AdvertActions
            java.util.List r0 = t6.n.d.listOf(r1)
            r4.<init>(r0)
            goto L_0x0038
        L_0x0035:
            return r2
        L_0x0036:
            com.avito.android.remote.model.AdvertActions r4 = r3.contacts
        L_0x0038:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.remote.model.AdvertDetails.getAdvertActions(com.avito.android.Features):com.avito.android.remote.model.AdvertActions");
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
    public final DeepLink getAutoCatalogAction() {
        return this.autoCatalogAction;
    }

    @Nullable
    public final AutoDeal getAutoDeal() {
        return this.autoDeal;
    }

    @Nullable
    public final AutotekaTeaserItemResponse getAutotekaTeaser() {
        return this.autotekaTeaser;
    }

    @Nullable
    public final AdvertBadgeBar getBadgeBar() {
        return this.badgeBar;
    }

    @Nullable
    public final Booking getBooking() {
        return this.booking;
    }

    @Nullable
    public final CarMarketPrice getCarMarketPrice() {
        return this.carMarketPrice;
    }

    @Nullable
    public final String getCategoryId() {
        return this.categoryId;
    }

    @NotNull
    public final String getCategoryName() {
        Map<String, String> category;
        String str;
        References references2 = this.references;
        return (references2 == null || (category = references2.getCategory()) == null || (str = category.get(this.categoryId)) == null) ? "" : str;
    }

    @Nullable
    public final String getClosingReason() {
        return this.closingReason;
    }

    @Override // com.avito.android.remote.model.LocationInfo
    @Nullable
    public Coordinates getCoordinates() {
        return this.coordinatesParam;
    }

    @Nullable
    public final Coordinates getCoordinatesParam() {
        return this.coordinatesParam;
    }

    @Nullable
    public final DfpBannerItem getCreditInfo() {
        return this.creditInfo;
    }

    @Nullable
    public final Double getCustomerValue() {
        return this.customerValue;
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

    @Override // com.avito.android.remote.model.LocationInfo
    @NotNull
    public String getDirectionName() {
        Map<String, String> direction;
        String str;
        References references2 = this.references;
        return (references2 == null || (direction = references2.getDirection()) == null || (str = direction.get(this.directionId)) == null) ? "" : str;
    }

    @Nullable
    public final AdvertDisclaimer getDisclaimer() {
        return this.disclaimer;
    }

    @Nullable
    public final AdvertDiscounts getDiscounts() {
        return this.discounts;
    }

    @Nullable
    public final String getDistrictId() {
        return this.districtId;
    }

    @Override // com.avito.android.remote.model.LocationInfo
    @NotNull
    public String getDistrictName() {
        Map<String, String> district;
        String str;
        References references2 = this.references;
        return (references2 == null || (district = references2.getDistrict()) == null || (str = district.get(this.districtId)) == null) ? "" : str;
    }

    @Nullable
    public final Map<String, String> getFirebaseParams() {
        return this.firebaseParams;
    }

    @Nullable
    public final List<GeoReference> getGeoReferences() {
        return this.geoReferences;
    }

    @Nullable
    public final CREGeoReportTeaser getGeoReportTeaser() {
        return this.geoReportTeaser;
    }

    @Nullable
    public final Guide getGuide() {
        return this.guide;
    }

    @Nullable
    public final IceBreakers getIcebreakers() {
        return this.icebreakers;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final List<Image> getImages() {
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

    @Override // com.avito.android.remote.model.LocationInfo
    @NotNull
    public String getLocationName() {
        Map<String, String> location;
        String str;
        References references2 = this.references;
        return (references2 == null || (location = references2.getLocation()) == null || (str = location.get(this.locationId)) == null) ? "" : str;
    }

    @Nullable
    public final AdvertMarketPlace getMarketplaceData() {
        return this.marketplaceData;
    }

    @Nullable
    public final String getMetroId() {
        return this.metroId;
    }

    @Override // com.avito.android.remote.model.LocationInfo
    @NotNull
    public String getMetroName() {
        Map<String, String> metro;
        String str;
        References references2 = this.references;
        return (references2 == null || (metro = references2.getMetro()) == null || (str = metro.get(this.metroId)) == null) ? "" : str;
    }

    public final boolean getNeedToCheckCreditInfo() {
        return this.needToCheckCreditInfo;
    }

    @Nullable
    public final String getNote() {
        return this.note;
    }

    @Nullable
    public final AdvertParameters getParameters() {
        return this.parameters;
    }

    @Nullable
    public final AdvertPrice getPrice() {
        return this.price;
    }

    @Nullable
    public final PriceBadge getPriceBadge() {
        return this.priceBadge;
    }

    @Nullable
    public final Questionnaire getQuestionnaire() {
        return this.questionnaire;
    }

    @Nullable
    public final References getReferences() {
        return this.references;
    }

    @Nullable
    public final SafeDeal getSafeDeal() {
        return this.safeDeal;
    }

    @Nullable
    public final AdvertSeller getSeller() {
        return this.seller;
    }

    @Nullable
    public final AdvertSharing getSharing() {
        return this.sharing;
    }

    @Nullable
    public final String getShopId() {
        return this.shopId;
    }

    @Nullable
    public final AdvertShortTermRent getShortTermRent() {
        return this.shortTermRent;
    }

    public final boolean getShouldShowDevelopmentsAdvice() {
        return this.shouldShowDevelopmentsAdvice;
    }

    @Nullable
    public final Boolean getShouldShowDomotekaTeaser() {
        return this.shouldShowDomotekaTeaser;
    }

    public final boolean getShouldShowMapPreview() {
        return this.shouldShowMapPreview;
    }

    @Nullable
    public final SimpleAdvertAction getSimilarAction() {
        return this.similarAction;
    }

    @Nullable
    public final SparePartsParameters getSparePartsParams() {
        return this.sparePartsParams;
    }

    @Nullable
    public final AdvertStats getStats() {
        return this.stats;
    }

    @Nullable
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

    @Nullable
    public final String getUserType() {
        return this.userType;
    }

    @Nullable
    public final VehicleType getVehicleType() {
        return this.vehicleType;
    }

    @Nullable
    public final AdvertVerification getVerification() {
        return this.verification;
    }

    @Nullable
    public final Video getVideo() {
        return this.video;
    }

    @Nullable
    public final Map<String, String> getViewItemAndBuyerEventsParams() {
        return this.viewItemAndBuyerEventsParams;
    }

    @Override // com.avito.android.remote.model.LocationInfo
    public boolean hasAddress() {
        String str = this.addressParam;
        return str != null && str.length() > 0;
    }

    @Override // com.avito.android.remote.model.LocationInfo
    public boolean hasCoordinates() {
        Coordinates coordinates = this.coordinatesParam;
        if (coordinates != null) {
            return !coordinates.isEmpty();
        }
        return false;
    }

    @Override // com.avito.android.remote.model.LocationInfo
    public boolean hasDirection() {
        String str = this.directionId;
        return str != null && str.length() > 0;
    }

    @Override // com.avito.android.remote.model.LocationInfo
    public boolean hasDistrict() {
        String str = this.districtId;
        return str != null && str.length() > 0;
    }

    @Override // com.avito.android.remote.model.LocationInfo
    public boolean hasLocation() {
        String str = this.locationId;
        return str != null && str.length() > 0;
    }

    @Override // com.avito.android.remote.model.LocationInfo
    public boolean hasMetro() {
        String str = this.metroId;
        return str != null && str.length() > 0;
    }

    public final boolean isActive() {
        String str = this.status;
        return str == null || Intrinsics.areEqual(str, "active");
    }

    public final boolean isFavorite() {
        return this.isFavorite;
    }

    public final boolean isFromCompany() {
        return Intrinsics.areEqual(this.userType, "company");
    }

    public final boolean isMarketplace() {
        return this.marketplaceData != null;
    }

    public final boolean isShopAdvert() {
        String str = this.shopId;
        return !(str == null || str.length() == 0);
    }

    public final void setAdditionalSeller(@Nullable AdditionalSeller additionalSeller2) {
        this.additionalSeller = additionalSeller2;
    }

    public final void setAdjustParameters(@Nullable AdjustParameters adjustParameters2) {
        this.adjustParameters = adjustParameters2;
    }

    public final void setFavorite(boolean z) {
        this.isFavorite = z;
    }

    public final void setNote(@Nullable String str) {
        this.note = str;
    }

    public final void setSeller(@Nullable AdvertSeller advertSeller) {
        this.seller = advertSeller;
    }

    public final void setShouldShowMapPreview(boolean z) {
        this.shouldShowMapPreview = z;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(this.id);
        parcel.writeString(this.title);
        parcel.writeString(this.description);
        parcel.writeString(this.descriptionHtml);
        parcel.writeString(this.userType);
        parcel.writeParcelable(this.price, i);
        parcel.writeParcelable(this.discounts, i);
        parcel.writeLong(this.time);
        parcel.writeString(this.categoryId);
        parcel.writeString(this.locationId);
        parcel.writeString(this.metroId);
        parcel.writeString(this.districtId);
        parcel.writeString(this.directionId);
        parcel.writeParcelable(this.safeDeal, i);
        parcel.writeParcelable(this.delivery, i);
        parcel.writeParcelable(this.shortTermRent, i);
        parcel.writeParcelable(this.sharing, i);
        ParcelsKt.writeBool(parcel, this.isFavorite);
        ParcelsKt.writeBool(parcel, this.shouldShowMapPreview);
        parcel.writeString(this.addressParam);
        parcel.writeParcelable(this.coordinatesParam, i);
        parcel.writeParcelable(this.seller, i);
        parcel.writeParcelable(this.additionalSeller, i);
        parcel.writeParcelable(this.disclaimer, i);
        parcel.writeParcelable(this.parameters, i);
        parcel.writeParcelable(this.video, i);
        ParcelsKt.writeOptimizedParcelableList(parcel, this.images, i);
        parcel.writeString(this.shopId);
        parcel.writeParcelable(this.stats, i);
        parcel.writeParcelable(this.contacts, i);
        parcel.writeParcelable(this.references, i);
        parcel.writeParcelable(this.anonymousNumber, i);
        parcel.writeMap(this.firebaseParams);
        parcel.writeMap(this.viewItemAndBuyerEventsParams);
        parcel.writeParcelable(this.creditInfo, i);
        parcel.writeParcelable(this.autoDeal, i);
        parcel.writeParcelable(this.autotekaTeaser, i);
        parcel.writeString(this.note);
        parcel.writeParcelable(this.adjustParameters, i);
        parcel.writeParcelable(this.autoCatalogAction, i);
        ParcelsKt.writeBool(parcel, this.needToCheckCreditInfo);
        ParcelsKt.writeOptimizedParcelableList(parcel, this.geoReferences, i);
        VehicleType vehicleType2 = this.vehicleType;
        if (vehicleType2 == null) {
            vehicleType2 = VehicleType.NO_VALUE;
        }
        ParcelsKt.writeEnum(parcel, vehicleType2);
        parcel.writeString(this.closingReason);
        parcel.writeParcelable(this.similarAction, i);
        parcel.writeString(this.status);
        parcel.writeParcelable(this.priceBadge, i);
        parcel.writeParcelable(this.badgeBar, i);
        parcel.writeParcelable(this.guide, i);
        parcel.writeParcelable(this.verification, i);
        ParcelsKt.writeNullableValue(parcel, this.shouldShowDomotekaTeaser);
        ParcelsKt.writeBool(parcel, this.shouldShowDevelopmentsAdvice);
        parcel.writeParcelable(this.teasers, i);
        ParcelsKt.writeOptimizedParcelableList(parcel, this.apartmentFeatures, i);
        parcel.writeParcelable(this.sparePartsParams, i);
        parcel.writeParcelable(this.booking, i);
        parcel.writeParcelable(this.questionnaire, i);
        parcel.writeParcelable(this.carMarketPrice, i);
        ParcelsKt.writeNullableValue(parcel, this.customerValue);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AdvertDetails(String str, String str2, String str3, String str4, String str5, AdvertPrice advertPrice, AdvertDiscounts advertDiscounts, long j, String str6, String str7, String str8, String str9, String str10, SafeDeal safeDeal2, AdvertDeliveryC2C advertDeliveryC2C, AdvertShortTermRent advertShortTermRent, AdvertSharing advertSharing, boolean z, boolean z2, String str11, Coordinates coordinates, AdvertSeller advertSeller, AdditionalSeller additionalSeller2, AdvertDisclaimer advertDisclaimer, AdvertParameters advertParameters, Video video2, List list, String str12, AdvertStats advertStats, AdvertActions advertActions, References references2, AnonymousNumber anonymousNumber2, Map map, Map map2, DfpBannerItem dfpBannerItem, AutoDeal autoDeal2, AutotekaTeaserItemResponse autotekaTeaserItemResponse, String str13, AdjustParameters adjustParameters2, DeepLink deepLink, boolean z3, List list2, VehicleType vehicleType2, String str14, SimpleAdvertAction simpleAdvertAction, String str15, PriceBadge priceBadge2, AdvertBadgeBar advertBadgeBar, Guide guide2, AdvertVerification advertVerification, Boolean bool, boolean z4, IceBreakers iceBreakers, AdvertDetailsFeaturesTeasers advertDetailsFeaturesTeasers, List list3, AdvertMarketPlace advertMarketPlace, ForegroundImage foregroundImage, SparePartsParameters sparePartsParameters, Booking booking2, Questionnaire questionnaire2, CarMarketPrice carMarketPrice2, CREGeoReportTeaser cREGeoReportTeaser, Double d, int i, int i2, j jVar) {
        this(str, str2, str3, str4, str5, advertPrice, (i & 64) != 0 ? null : advertDiscounts, j, str6, str7, str8, str9, str10, safeDeal2, advertDeliveryC2C, advertShortTermRent, advertSharing, z, (i & 262144) != 0 ? false : z2, str11, coordinates, advertSeller, additionalSeller2, advertDisclaimer, advertParameters, video2, list, str12, advertStats, advertActions, references2, anonymousNumber2, map, map2, dfpBannerItem, autoDeal2, autotekaTeaserItemResponse, str13, adjustParameters2, deepLink, z3, (i2 & 512) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list2, (i2 & 1024) != 0 ? VehicleType.NO_VALUE : vehicleType2, (i2 & 2048) != 0 ? null : str14, (i2 & 4096) != 0 ? null : simpleAdvertAction, (i2 & 8192) != 0 ? null : str15, (i2 & 16384) != 0 ? null : priceBadge2, (32768 & i2) != 0 ? null : advertBadgeBar, (65536 & i2) != 0 ? null : guide2, (131072 & i2) != 0 ? null : advertVerification, (262144 & i2) != 0 ? null : bool, (524288 & i2) != 0 ? false : z4, (1048576 & i2) != 0 ? null : iceBreakers, (2097152 & i2) != 0 ? null : advertDetailsFeaturesTeasers, (4194304 & i2) != 0 ? null : list3, (8388608 & i2) != 0 ? null : advertMarketPlace, (16777216 & i2) != 0 ? null : foregroundImage, (33554432 & i2) != 0 ? null : sparePartsParameters, (67108864 & i2) != 0 ? null : booking2, (134217728 & i2) != 0 ? null : questionnaire2, (268435456 & i2) != 0 ? null : carMarketPrice2, (536870912 & i2) != 0 ? null : cREGeoReportTeaser, (i2 & 1073741824) != 0 ? null : d);
    }

    @Nullable
    public final AdvertActions getAdvertActions() {
        Object obj;
        AdvertMarketPlace advertMarketPlace = this.marketplaceData;
        if (advertMarketPlace == null) {
            return this.contacts;
        }
        if (advertMarketPlace.getCartAction() != null) {
            obj = this.marketplaceData.getCartAction();
        } else if (this.marketplaceData.getBuyAction() == null) {
            return null;
        } else {
            obj = this.marketplaceData.getBuyAction();
        }
        return new AdvertActions(d.listOf(obj));
    }
}
