package com.google.android.exoplayer2.upstream;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.SlidingPercentile;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.zxing.client.result.ExpandedProductParsedResult;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import ru.sravni.android.bankproduct.utils.NetworkChangeReceiver;
public final class DefaultBandwidthMeter implements BandwidthMeter, TransferListener {
    public static final ImmutableListMultimap<String, Integer> DEFAULT_INITIAL_BITRATE_COUNTRY_GROUPS = a();
    public static final long DEFAULT_INITIAL_BITRATE_ESTIMATE = 1000000;
    public static final ImmutableList<Long> DEFAULT_INITIAL_BITRATE_ESTIMATES_2G = ImmutableList.of(218000L, 159000L, 145000L, 130000L, 112000L);
    public static final ImmutableList<Long> DEFAULT_INITIAL_BITRATE_ESTIMATES_3G = ImmutableList.of(2200000L, 1300000L, 930000L, 730000L, 530000L);
    public static final ImmutableList<Long> DEFAULT_INITIAL_BITRATE_ESTIMATES_4G = ImmutableList.of(4800000L, 2700000L, 1800000L, 1200000L, 630000L);
    public static final ImmutableList<Long> DEFAULT_INITIAL_BITRATE_ESTIMATES_5G_NSA = ImmutableList.of(12000000L, 8800000L, 5900000L, 3500000L, 1800000L);
    public static final ImmutableList<Long> DEFAULT_INITIAL_BITRATE_ESTIMATES_WIFI = ImmutableList.of(6100000L, 3800000L, 2100000L, 1300000L, 590000L);
    public static final int DEFAULT_SLIDING_WINDOW_MAX_WEIGHT = 2000;
    @Nullable
    public static DefaultBandwidthMeter p;
    @Nullable
    public final Context a;
    public final ImmutableMap<Integer, Long> b;
    public final BandwidthMeter.EventListener.EventDispatcher c;
    public final SlidingPercentile d;
    public final Clock e;
    public int f;
    public long g;
    public long h;
    public int i;
    public long j;
    public long k;
    public long l;
    public long m;
    public boolean n;
    public int o;

    public static class a extends BroadcastReceiver {
        public static a c;
        public final Handler a = new Handler(Looper.getMainLooper());
        public final ArrayList<WeakReference<DefaultBandwidthMeter>> b = new ArrayList<>();

        public final void a() {
            for (int size = this.b.size() - 1; size >= 0; size--) {
                if (this.b.get(size).get() == null) {
                    this.b.remove(size);
                }
            }
        }

        @Override // android.content.BroadcastReceiver
        public synchronized void onReceive(Context context, Intent intent) {
            if (!isInitialStickyBroadcast()) {
                a();
                for (int i = 0; i < this.b.size(); i++) {
                    DefaultBandwidthMeter defaultBandwidthMeter = this.b.get(i).get();
                    if (defaultBandwidthMeter != null) {
                        ImmutableListMultimap<String, Integer> immutableListMultimap = DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_COUNTRY_GROUPS;
                        defaultBandwidthMeter.e();
                    }
                }
            }
        }
    }

    @Deprecated
    public DefaultBandwidthMeter() {
        this(null, ImmutableMap.of(), 2000, Clock.DEFAULT, false);
    }

    public static ImmutableListMultimap<String, Integer> a() {
        ImmutableListMultimap.Builder builder = ImmutableListMultimap.builder();
        builder.putAll((ImmutableListMultimap.Builder) "AD", (Object[]) new Integer[]{1, 2, 0, 0, 2});
        builder.putAll((ImmutableListMultimap.Builder) "AE", (Object[]) new Integer[]{1, 4, 4, 4, 1});
        builder.putAll((ImmutableListMultimap.Builder) "AF", (Object[]) new Integer[]{4, 4, 3, 4, 2});
        builder.putAll((ImmutableListMultimap.Builder) "AG", (Object[]) new Integer[]{2, 2, 1, 1, 2});
        builder.putAll((ImmutableListMultimap.Builder) "AI", (Object[]) new Integer[]{1, 2, 2, 2, 2});
        builder.putAll((ImmutableListMultimap.Builder) "AL", (Object[]) new Integer[]{1, 1, 0, 1, 2});
        builder.putAll((ImmutableListMultimap.Builder) "AM", (Object[]) new Integer[]{2, 2, 1, 2, 2});
        builder.putAll((ImmutableListMultimap.Builder) "AO", (Object[]) new Integer[]{3, 4, 4, 2, 2});
        builder.putAll((ImmutableListMultimap.Builder) "AR", (Object[]) new Integer[]{2, 4, 2, 2, 2});
        builder.putAll((ImmutableListMultimap.Builder) "AS", (Object[]) new Integer[]{2, 2, 4, 3, 2});
        builder.putAll((ImmutableListMultimap.Builder) "AT", (Object[]) new Integer[]{0, 3, 0, 0, 2});
        builder.putAll((ImmutableListMultimap.Builder) "AU", (Object[]) new Integer[]{0, 2, 0, 1, 1});
        builder.putAll((ImmutableListMultimap.Builder) "AW", (Object[]) new Integer[]{1, 2, 0, 4, 2});
        builder.putAll((ImmutableListMultimap.Builder) "AX", (Object[]) new Integer[]{0, 2, 2, 2, 2});
        builder.putAll((ImmutableListMultimap.Builder) "AZ", (Object[]) new Integer[]{3, 3, 3, 4, 2});
        builder.putAll((ImmutableListMultimap.Builder) "BA", (Object[]) new Integer[]{1, 1, 0, 1, 2});
        builder.putAll((ImmutableListMultimap.Builder) "BB", (Object[]) new Integer[]{0, 2, 0, 0, 2});
        builder.putAll((ImmutableListMultimap.Builder) "BD", (Object[]) new Integer[]{2, 0, 3, 3, 2});
        builder.putAll((ImmutableListMultimap.Builder) "BE", (Object[]) new Integer[]{0, 1, 2, 3, 2});
        builder.putAll((ImmutableListMultimap.Builder) "BF", (Object[]) new Integer[]{4, 4, 4, 2, 2});
        builder.putAll((ImmutableListMultimap.Builder) "BG", (Object[]) new Integer[]{0, 1, 0, 0, 2});
        builder.putAll((ImmutableListMultimap.Builder) "BH", (Object[]) new Integer[]{1, 0, 2, 4, 2});
        builder.putAll((ImmutableListMultimap.Builder) "BI", (Object[]) new Integer[]{4, 4, 4, 4, 2});
        builder.putAll((ImmutableListMultimap.Builder) "BJ", (Object[]) new Integer[]{4, 4, 3, 4, 2});
        builder.putAll((ImmutableListMultimap.Builder) "BL", (Object[]) new Integer[]{1, 2, 2, 2, 2});
        builder.putAll((ImmutableListMultimap.Builder) "BM", (Object[]) new Integer[]{1, 2, 0, 0, 2});
        builder.putAll((ImmutableListMultimap.Builder) "BN", (Object[]) new Integer[]{4, 0, 1, 1, 2});
        builder.putAll((ImmutableListMultimap.Builder) "BO", (Object[]) new Integer[]{2, 3, 3, 2, 2});
        builder.putAll((ImmutableListMultimap.Builder) "BQ", (Object[]) new Integer[]{1, 2, 1, 2, 2});
        builder.putAll((ImmutableListMultimap.Builder) "BR", (Object[]) new Integer[]{2, 4, 2, 1, 2});
        builder.putAll((ImmutableListMultimap.Builder) "BS", (Object[]) new Integer[]{3, 2, 2, 3, 2});
        builder.putAll((ImmutableListMultimap.Builder) "BT", (Object[]) new Integer[]{3, 0, 3, 2, 2});
        builder.putAll((ImmutableListMultimap.Builder) "BW", (Object[]) new Integer[]{3, 4, 2, 2, 2});
        builder.putAll((ImmutableListMultimap.Builder) "BY", (Object[]) new Integer[]{1, 0, 2, 1, 2});
        builder.putAll((ImmutableListMultimap.Builder) "BZ", (Object[]) new Integer[]{2, 2, 2, 1, 2});
        builder.putAll((ImmutableListMultimap.Builder) "CA", (Object[]) new Integer[]{0, 3, 1, 2, 3});
        builder.putAll((ImmutableListMultimap.Builder) "CD", (Object[]) new Integer[]{4, 3, 2, 2, 2});
        builder.putAll((ImmutableListMultimap.Builder) "CF", (Object[]) new Integer[]{4, 2, 2, 2, 2});
        builder.putAll((ImmutableListMultimap.Builder) "CG", (Object[]) new Integer[]{3, 4, 1, 1, 2});
        builder.putAll((ImmutableListMultimap.Builder) "CH", (Object[]) new Integer[]{0, 1, 0, 0, 0});
        builder.putAll((ImmutableListMultimap.Builder) "CI", (Object[]) new Integer[]{3, 3, 3, 3, 2});
        builder.putAll((ImmutableListMultimap.Builder) "CK", (Object[]) new Integer[]{3, 2, 1, 0, 2});
        builder.putAll((ImmutableListMultimap.Builder) "CL", (Object[]) new Integer[]{1, 1, 2, 3, 2});
        builder.putAll((ImmutableListMultimap.Builder) "CM", (Object[]) new Integer[]{3, 4, 3, 2, 2});
        builder.putAll((ImmutableListMultimap.Builder) "CN", (Object[]) new Integer[]{2, 2, 2, 1, 3});
        builder.putAll((ImmutableListMultimap.Builder) "CO", (Object[]) new Integer[]{2, 4, 3, 2, 2});
        builder.putAll((ImmutableListMultimap.Builder) "CR", (Object[]) new Integer[]{2, 3, 4, 4, 2});
        builder.putAll((ImmutableListMultimap.Builder) "CU", (Object[]) new Integer[]{4, 4, 2, 1, 2});
        builder.putAll((ImmutableListMultimap.Builder) "CV", (Object[]) new Integer[]{2, 3, 3, 3, 2});
        builder.putAll((ImmutableListMultimap.Builder) "CW", (Object[]) new Integer[]{1, 2, 0, 0, 2});
        builder.putAll((ImmutableListMultimap.Builder) "CY", (Object[]) new Integer[]{1, 2, 0, 0, 2});
        builder.putAll((ImmutableListMultimap.Builder) "CZ", (Object[]) new Integer[]{0, 1, 0, 0, 2});
        builder.putAll((ImmutableListMultimap.Builder) "DE", (Object[]) new Integer[]{0, 1, 1, 2, 0});
        builder.putAll((ImmutableListMultimap.Builder) "DJ", (Object[]) new Integer[]{4, 1, 4, 4, 2});
        builder.putAll((ImmutableListMultimap.Builder) "DK", (Object[]) new Integer[]{0, 0, 1, 0, 2});
        builder.putAll((ImmutableListMultimap.Builder) "DM", (Object[]) new Integer[]{1, 2, 2, 2, 2});
        builder.putAll((ImmutableListMultimap.Builder) "DO", (Object[]) new Integer[]{3, 4, 4, 4, 2});
        builder.putAll((ImmutableListMultimap.Builder) "DZ", (Object[]) new Integer[]{3, 2, 4, 4, 2});
        builder.putAll((ImmutableListMultimap.Builder) "EC", (Object[]) new Integer[]{2, 4, 3, 2, 2});
        builder.putAll((ImmutableListMultimap.Builder) "EE", (Object[]) new Integer[]{0, 0, 0, 0, 2});
        builder.putAll((ImmutableListMultimap.Builder) "EG", (Object[]) new Integer[]{3, 4, 2, 1, 2});
        builder.putAll((ImmutableListMultimap.Builder) "EH", (Object[]) new Integer[]{2, 2, 2, 2, 2});
        builder.putAll((ImmutableListMultimap.Builder) "ER", (Object[]) new Integer[]{4, 2, 2, 2, 2});
        builder.putAll((ImmutableListMultimap.Builder) "ES", (Object[]) new Integer[]{0, 1, 2, 1, 2});
        builder.putAll((ImmutableListMultimap.Builder) "ET", (Object[]) new Integer[]{4, 4, 4, 1, 2});
        builder.putAll((ImmutableListMultimap.Builder) "FI", (Object[]) new Integer[]{0, 0, 1, 0, 0});
        builder.putAll((ImmutableListMultimap.Builder) "FJ", (Object[]) new Integer[]{3, 0, 3, 3, 2});
        builder.putAll((ImmutableListMultimap.Builder) "FK", (Object[]) new Integer[]{2, 2, 2, 2, 2});
        builder.putAll((ImmutableListMultimap.Builder) "FM", (Object[]) new Integer[]{4, 2, 4, 3, 2});
        builder.putAll((ImmutableListMultimap.Builder) "FO", (Object[]) new Integer[]{0, 2, 0, 0, 2});
        builder.putAll((ImmutableListMultimap.Builder) "FR", (Object[]) new Integer[]{1, 0, 2, 1, 2});
        builder.putAll((ImmutableListMultimap.Builder) "GA", (Object[]) new Integer[]{3, 3, 1, 0, 2});
        builder.putAll((ImmutableListMultimap.Builder) "GB", (Object[]) new Integer[]{0, 0, 1, 2, 2});
        builder.putAll((ImmutableListMultimap.Builder) "GD", (Object[]) new Integer[]{1, 2, 2, 2, 2});
        builder.putAll((ImmutableListMultimap.Builder) "GE", (Object[]) new Integer[]{1, 0, 1, 3, 2});
        builder.putAll((ImmutableListMultimap.Builder) "GF", (Object[]) new Integer[]{2, 2, 2, 4, 2});
        builder.putAll((ImmutableListMultimap.Builder) "GG", (Object[]) new Integer[]{0, 2, 0, 0, 2});
        builder.putAll((ImmutableListMultimap.Builder) "GH", (Object[]) new Integer[]{3, 2, 3, 2, 2});
        builder.putAll((ImmutableListMultimap.Builder) "GI", (Object[]) new Integer[]{0, 2, 0, 0, 2});
        builder.putAll((ImmutableListMultimap.Builder) "GL", (Object[]) new Integer[]{1, 2, 2, 1, 2});
        builder.putAll((ImmutableListMultimap.Builder) "GM", (Object[]) new Integer[]{4, 3, 2, 4, 2});
        builder.putAll((ImmutableListMultimap.Builder) "GN", (Object[]) new Integer[]{4, 3, 4, 2, 2});
        builder.putAll((ImmutableListMultimap.Builder) "GP", (Object[]) new Integer[]{2, 2, 3, 4, 2});
        builder.putAll((ImmutableListMultimap.Builder) "GQ", (Object[]) new Integer[]{4, 2, 3, 4, 2});
        builder.putAll((ImmutableListMultimap.Builder) "GR", (Object[]) new Integer[]{1, 1, 0, 1, 2});
        builder.putAll((ImmutableListMultimap.Builder) "GT", (Object[]) new Integer[]{3, 2, 3, 2, 2});
        builder.putAll((ImmutableListMultimap.Builder) "GU", (Object[]) new Integer[]{1, 2, 4, 4, 2});
        builder.putAll((ImmutableListMultimap.Builder) "GW", (Object[]) new Integer[]{3, 4, 4, 3, 2});
        builder.putAll((ImmutableListMultimap.Builder) "GY", (Object[]) new Integer[]{3, 3, 1, 0, 2});
        builder.putAll((ImmutableListMultimap.Builder) "HK", (Object[]) new Integer[]{0, 2, 3, 4, 2});
        builder.putAll((ImmutableListMultimap.Builder) "HN", (Object[]) new Integer[]{3, 0, 3, 3, 2});
        builder.putAll((ImmutableListMultimap.Builder) "HR", (Object[]) new Integer[]{1, 1, 0, 1, 2});
        builder.putAll((ImmutableListMultimap.Builder) "HT", (Object[]) new Integer[]{4, 3, 4, 4, 2});
        builder.putAll((ImmutableListMultimap.Builder) "HU", (Object[]) new Integer[]{0, 1, 0, 0, 2});
        builder.putAll((ImmutableListMultimap.Builder) "ID", (Object[]) new Integer[]{3, 2, 2, 3, 2});
        builder.putAll((ImmutableListMultimap.Builder) "IE", (Object[]) new Integer[]{0, 0, 1, 1, 2});
        builder.putAll((ImmutableListMultimap.Builder) "IL", (Object[]) new Integer[]{1, 0, 2, 3, 2});
        builder.putAll((ImmutableListMultimap.Builder) "IM", (Object[]) new Integer[]{0, 2, 0, 1, 2});
        builder.putAll((ImmutableListMultimap.Builder) "IN", (Object[]) new Integer[]{2, 1, 3, 3, 2});
        builder.putAll((ImmutableListMultimap.Builder) "IO", (Object[]) new Integer[]{4, 2, 2, 4, 2});
        builder.putAll((ImmutableListMultimap.Builder) "IQ", (Object[]) new Integer[]{3, 2, 4, 3, 2});
        builder.putAll((ImmutableListMultimap.Builder) "IR", (Object[]) new Integer[]{4, 2, 3, 4, 2});
        builder.putAll((ImmutableListMultimap.Builder) "IS", (Object[]) new Integer[]{0, 2, 0, 0, 2});
        builder.putAll((ImmutableListMultimap.Builder) "IT", (Object[]) new Integer[]{0, 0, 1, 1, 2});
        builder.putAll((ImmutableListMultimap.Builder) "JE", (Object[]) new Integer[]{2, 2, 0, 2, 2});
        builder.putAll((ImmutableListMultimap.Builder) "JM", (Object[]) new Integer[]{3, 3, 4, 4, 2});
        builder.putAll((ImmutableListMultimap.Builder) "JO", (Object[]) new Integer[]{1, 2, 1, 1, 2});
        builder.putAll((ImmutableListMultimap.Builder) "JP", (Object[]) new Integer[]{0, 2, 0, 1, 3});
        builder.putAll((ImmutableListMultimap.Builder) "KE", (Object[]) new Integer[]{3, 4, 2, 2, 2});
        builder.putAll((ImmutableListMultimap.Builder) ExpandedProductParsedResult.KILOGRAM, (Object[]) new Integer[]{1, 0, 2, 2, 2});
        builder.putAll((ImmutableListMultimap.Builder) "KH", (Object[]) new Integer[]{2, 0, 4, 3, 2});
        builder.putAll((ImmutableListMultimap.Builder) "KI", (Object[]) new Integer[]{4, 2, 3, 1, 2});
        builder.putAll((ImmutableListMultimap.Builder) "KM", (Object[]) new Integer[]{4, 2, 2, 3, 2});
        builder.putAll((ImmutableListMultimap.Builder) "KN", (Object[]) new Integer[]{1, 2, 2, 2, 2});
        builder.putAll((ImmutableListMultimap.Builder) "KP", (Object[]) new Integer[]{4, 2, 2, 2, 2});
        builder.putAll((ImmutableListMultimap.Builder) "KR", (Object[]) new Integer[]{0, 2, 1, 1, 1});
        builder.putAll((ImmutableListMultimap.Builder) "KW", (Object[]) new Integer[]{2, 3, 1, 1, 1});
        builder.putAll((ImmutableListMultimap.Builder) "KY", (Object[]) new Integer[]{1, 2, 0, 0, 2});
        builder.putAll((ImmutableListMultimap.Builder) "KZ", (Object[]) new Integer[]{1, 2, 2, 3, 2});
        builder.putAll((ImmutableListMultimap.Builder) "LA", (Object[]) new Integer[]{2, 2, 1, 1, 2});
        builder.putAll((ImmutableListMultimap.Builder) ExpandedProductParsedResult.POUND, (Object[]) new Integer[]{3, 2, 0, 0, 2});
        builder.putAll((ImmutableListMultimap.Builder) "LC", (Object[]) new Integer[]{1, 1, 0, 0, 2});
        builder.putAll((ImmutableListMultimap.Builder) "LI", (Object[]) new Integer[]{0, 2, 2, 2, 2});
        builder.putAll((ImmutableListMultimap.Builder) "LK", (Object[]) new Integer[]{2, 0, 2, 3, 2});
        builder.putAll((ImmutableListMultimap.Builder) "LR", (Object[]) new Integer[]{3, 4, 3, 2, 2});
        builder.putAll((ImmutableListMultimap.Builder) "LS", (Object[]) new Integer[]{3, 3, 2, 3, 2});
        builder.putAll((ImmutableListMultimap.Builder) "LT", (Object[]) new Integer[]{0, 0, 0, 0, 2});
        builder.putAll((ImmutableListMultimap.Builder) "LU", (Object[]) new Integer[]{0, 0, 0, 0, 2});
        builder.putAll((ImmutableListMultimap.Builder) "LV", (Object[]) new Integer[]{0, 0, 0, 0, 2});
        builder.putAll((ImmutableListMultimap.Builder) "LY", (Object[]) new Integer[]{4, 2, 4, 3, 2});
        builder.putAll((ImmutableListMultimap.Builder) "MA", (Object[]) new Integer[]{2, 1, 2, 1, 2});
        builder.putAll((ImmutableListMultimap.Builder) "MC", (Object[]) new Integer[]{0, 2, 2, 2, 2});
        builder.putAll((ImmutableListMultimap.Builder) "MD", (Object[]) new Integer[]{1, 2, 0, 0, 2});
        builder.putAll((ImmutableListMultimap.Builder) "ME", (Object[]) new Integer[]{1, 2, 1, 2, 2});
        builder.putAll((ImmutableListMultimap.Builder) "MF", (Object[]) new Integer[]{1, 2, 1, 0, 2});
        builder.putAll((ImmutableListMultimap.Builder) "MG", (Object[]) new Integer[]{3, 4, 3, 3, 2});
        builder.putAll((ImmutableListMultimap.Builder) "MH", (Object[]) new Integer[]{4, 2, 2, 4, 2});
        builder.putAll((ImmutableListMultimap.Builder) "MK", (Object[]) new Integer[]{1, 0, 0, 0, 2});
        builder.putAll((ImmutableListMultimap.Builder) "ML", (Object[]) new Integer[]{4, 4, 1, 1, 2});
        builder.putAll((ImmutableListMultimap.Builder) "MM", (Object[]) new Integer[]{2, 3, 2, 2, 2});
        builder.putAll((ImmutableListMultimap.Builder) "MN", (Object[]) new Integer[]{2, 4, 1, 1, 2});
        builder.putAll((ImmutableListMultimap.Builder) "MO", (Object[]) new Integer[]{0, 2, 4, 4, 2});
        builder.putAll((ImmutableListMultimap.Builder) "MP", (Object[]) new Integer[]{0, 2, 2, 2, 2});
        builder.putAll((ImmutableListMultimap.Builder) "MQ", (Object[]) new Integer[]{2, 2, 2, 3, 2});
        builder.putAll((ImmutableListMultimap.Builder) "MR", (Object[]) new Integer[]{3, 0, 4, 2, 2});
        builder.putAll((ImmutableListMultimap.Builder) "MS", (Object[]) new Integer[]{1, 2, 2, 2, 2});
        builder.putAll((ImmutableListMultimap.Builder) "MT", (Object[]) new Integer[]{0, 2, 0, 1, 2});
        builder.putAll((ImmutableListMultimap.Builder) "MU", (Object[]) new Integer[]{3, 1, 2, 3, 2});
        builder.putAll((ImmutableListMultimap.Builder) "MV", (Object[]) new Integer[]{4, 3, 1, 4, 2});
        builder.putAll((ImmutableListMultimap.Builder) "MW", (Object[]) new Integer[]{4, 1, 1, 0, 2});
        builder.putAll((ImmutableListMultimap.Builder) "MX", (Object[]) new Integer[]{2, 4, 3, 3, 2});
        builder.putAll((ImmutableListMultimap.Builder) "MY", (Object[]) new Integer[]{2, 0, 3, 3, 2});
        builder.putAll((ImmutableListMultimap.Builder) "MZ", (Object[]) new Integer[]{3, 3, 2, 3, 2});
        builder.putAll((ImmutableListMultimap.Builder) "NA", (Object[]) new Integer[]{4, 3, 2, 2, 2});
        builder.putAll((ImmutableListMultimap.Builder) "NC", (Object[]) new Integer[]{2, 0, 4, 4, 2});
        builder.putAll((ImmutableListMultimap.Builder) "NE", (Object[]) new Integer[]{4, 4, 4, 4, 2});
        builder.putAll((ImmutableListMultimap.Builder) "NF", (Object[]) new Integer[]{2, 2, 2, 2, 2});
        builder.putAll((ImmutableListMultimap.Builder) "NG", (Object[]) new Integer[]{3, 3, 2, 2, 2});
        builder.putAll((ImmutableListMultimap.Builder) "NI", (Object[]) new Integer[]{3, 1, 4, 4, 2});
        builder.putAll((ImmutableListMultimap.Builder) "NL", (Object[]) new Integer[]{0, 2, 4, 2, 0});
        builder.putAll((ImmutableListMultimap.Builder) "NO", (Object[]) new Integer[]{0, 1, 1, 0, 2});
        builder.putAll((ImmutableListMultimap.Builder) "NP", (Object[]) new Integer[]{2, 0, 4, 3, 2});
        builder.putAll((ImmutableListMultimap.Builder) "NR", (Object[]) new Integer[]{4, 2, 3, 1, 2});
        builder.putAll((ImmutableListMultimap.Builder) "NU", (Object[]) new Integer[]{4, 2, 2, 2, 2});
        builder.putAll((ImmutableListMultimap.Builder) "NZ", (Object[]) new Integer[]{0, 2, 1, 2, 4});
        builder.putAll((ImmutableListMultimap.Builder) "OM", (Object[]) new Integer[]{2, 2, 0, 2, 2});
        builder.putAll((ImmutableListMultimap.Builder) "PA", (Object[]) new Integer[]{1, 3, 3, 4, 2});
        builder.putAll((ImmutableListMultimap.Builder) "PE", (Object[]) new Integer[]{2, 4, 4, 4, 2});
        builder.putAll((ImmutableListMultimap.Builder) "PF", (Object[]) new Integer[]{2, 2, 1, 1, 2});
        builder.putAll((ImmutableListMultimap.Builder) "PG", (Object[]) new Integer[]{4, 3, 3, 2, 2});
        builder.putAll((ImmutableListMultimap.Builder) "PH", (Object[]) new Integer[]{3, 0, 3, 4, 4});
        builder.putAll((ImmutableListMultimap.Builder) "PK", (Object[]) new Integer[]{3, 2, 3, 3, 2});
        builder.putAll((ImmutableListMultimap.Builder) "PL", (Object[]) new Integer[]{1, 0, 2, 2, 2});
        builder.putAll((ImmutableListMultimap.Builder) "PM", (Object[]) new Integer[]{0, 2, 2, 2, 2});
        builder.putAll((ImmutableListMultimap.Builder) "PR", (Object[]) new Integer[]{1, 2, 2, 3, 4});
        builder.putAll((ImmutableListMultimap.Builder) "PS", (Object[]) new Integer[]{3, 3, 2, 2, 2});
        builder.putAll((ImmutableListMultimap.Builder) "PT", (Object[]) new Integer[]{1, 1, 0, 0, 2});
        builder.putAll((ImmutableListMultimap.Builder) "PW", (Object[]) new Integer[]{1, 2, 3, 0, 2});
        builder.putAll((ImmutableListMultimap.Builder) "PY", (Object[]) new Integer[]{2, 0, 3, 3, 2});
        builder.putAll((ImmutableListMultimap.Builder) "QA", (Object[]) new Integer[]{2, 3, 1, 2, 2});
        builder.putAll((ImmutableListMultimap.Builder) "RE", (Object[]) new Integer[]{1, 0, 2, 1, 2});
        builder.putAll((ImmutableListMultimap.Builder) "RO", (Object[]) new Integer[]{1, 1, 1, 2, 2});
        builder.putAll((ImmutableListMultimap.Builder) "RS", (Object[]) new Integer[]{1, 2, 0, 0, 2});
        builder.putAll((ImmutableListMultimap.Builder) "RU", (Object[]) new Integer[]{0, 1, 0, 1, 2});
        builder.putAll((ImmutableListMultimap.Builder) "RW", (Object[]) new Integer[]{4, 3, 3, 4, 2});
        builder.putAll((ImmutableListMultimap.Builder) "SA", (Object[]) new Integer[]{2, 2, 2, 1, 2});
        builder.putAll((ImmutableListMultimap.Builder) "SB", (Object[]) new Integer[]{4, 2, 4, 2, 2});
        builder.putAll((ImmutableListMultimap.Builder) BouncyCastleProvider.PROVIDER_NAME, (Object[]) new Integer[]{4, 2, 0, 1, 2});
        builder.putAll((ImmutableListMultimap.Builder) "SD", (Object[]) new Integer[]{4, 4, 4, 3, 2});
        builder.putAll((ImmutableListMultimap.Builder) "SE", (Object[]) new Integer[]{0, 0, 0, 0, 2});
        builder.putAll((ImmutableListMultimap.Builder) "SG", (Object[]) new Integer[]{0, 0, 3, 3, 4});
        builder.putAll((ImmutableListMultimap.Builder) "SH", (Object[]) new Integer[]{4, 2, 2, 2, 2});
        builder.putAll((ImmutableListMultimap.Builder) "SI", (Object[]) new Integer[]{0, 1, 0, 0, 2});
        builder.putAll((ImmutableListMultimap.Builder) "SJ", (Object[]) new Integer[]{2, 2, 2, 2, 2});
        builder.putAll((ImmutableListMultimap.Builder) "SK", (Object[]) new Integer[]{0, 1, 0, 0, 2});
        builder.putAll((ImmutableListMultimap.Builder) "SL", (Object[]) new Integer[]{4, 3, 3, 1, 2});
        builder.putAll((ImmutableListMultimap.Builder) "SM", (Object[]) new Integer[]{0, 2, 2, 2, 2});
        builder.putAll((ImmutableListMultimap.Builder) "SN", (Object[]) new Integer[]{4, 4, 4, 3, 2});
        builder.putAll((ImmutableListMultimap.Builder) "SO", (Object[]) new Integer[]{3, 4, 4, 4, 2});
        builder.putAll((ImmutableListMultimap.Builder) "SR", (Object[]) new Integer[]{3, 2, 3, 1, 2});
        builder.putAll((ImmutableListMultimap.Builder) "SS", (Object[]) new Integer[]{4, 1, 4, 2, 2});
        builder.putAll((ImmutableListMultimap.Builder) "ST", (Object[]) new Integer[]{2, 2, 1, 2, 2});
        builder.putAll((ImmutableListMultimap.Builder) "SV", (Object[]) new Integer[]{2, 1, 4, 4, 2});
        builder.putAll((ImmutableListMultimap.Builder) "SX", (Object[]) new Integer[]{2, 2, 1, 0, 2});
        builder.putAll((ImmutableListMultimap.Builder) "SY", (Object[]) new Integer[]{4, 3, 2, 2, 2});
        builder.putAll((ImmutableListMultimap.Builder) "SZ", (Object[]) new Integer[]{3, 4, 3, 4, 2});
        builder.putAll((ImmutableListMultimap.Builder) "TC", (Object[]) new Integer[]{1, 2, 1, 0, 2});
        builder.putAll((ImmutableListMultimap.Builder) "TD", (Object[]) new Integer[]{4, 4, 4, 4, 2});
        builder.putAll((ImmutableListMultimap.Builder) "TG", (Object[]) new Integer[]{3, 2, 1, 0, 2});
        builder.putAll((ImmutableListMultimap.Builder) "TH", (Object[]) new Integer[]{1, 3, 4, 3, 0});
        builder.putAll((ImmutableListMultimap.Builder) "TJ", (Object[]) new Integer[]{4, 4, 4, 4, 2});
        builder.putAll((ImmutableListMultimap.Builder) "TL", (Object[]) new Integer[]{4, 1, 4, 4, 2});
        builder.putAll((ImmutableListMultimap.Builder) "TM", (Object[]) new Integer[]{4, 2, 1, 2, 2});
        builder.putAll((ImmutableListMultimap.Builder) "TN", (Object[]) new Integer[]{2, 1, 1, 1, 2});
        builder.putAll((ImmutableListMultimap.Builder) "TO", (Object[]) new Integer[]{3, 3, 4, 2, 2});
        builder.putAll((ImmutableListMultimap.Builder) "TR", (Object[]) new Integer[]{1, 2, 1, 1, 2});
        builder.putAll((ImmutableListMultimap.Builder) "TT", (Object[]) new Integer[]{1, 3, 1, 3, 2});
        builder.putAll((ImmutableListMultimap.Builder) "TV", (Object[]) new Integer[]{3, 2, 2, 4, 2});
        builder.putAll((ImmutableListMultimap.Builder) "TW", (Object[]) new Integer[]{0, 0, 0, 0, 1});
        builder.putAll((ImmutableListMultimap.Builder) "TZ", (Object[]) new Integer[]{3, 3, 3, 2, 2});
        builder.putAll((ImmutableListMultimap.Builder) "UA", (Object[]) new Integer[]{0, 3, 0, 0, 2});
        builder.putAll((ImmutableListMultimap.Builder) "UG", (Object[]) new Integer[]{3, 2, 2, 3, 2});
        builder.putAll((ImmutableListMultimap.Builder) "US", (Object[]) new Integer[]{0, 1, 3, 3, 3});
        builder.putAll((ImmutableListMultimap.Builder) "UY", (Object[]) new Integer[]{2, 1, 1, 1, 2});
        builder.putAll((ImmutableListMultimap.Builder) "UZ", (Object[]) new Integer[]{2, 0, 3, 2, 2});
        builder.putAll((ImmutableListMultimap.Builder) "VC", (Object[]) new Integer[]{2, 2, 2, 2, 2});
        builder.putAll((ImmutableListMultimap.Builder) "VE", (Object[]) new Integer[]{4, 4, 4, 4, 2});
        builder.putAll((ImmutableListMultimap.Builder) "VG", (Object[]) new Integer[]{2, 2, 1, 2, 2});
        builder.putAll((ImmutableListMultimap.Builder) "VI", (Object[]) new Integer[]{1, 2, 2, 4, 2});
        builder.putAll((ImmutableListMultimap.Builder) "VN", (Object[]) new Integer[]{0, 1, 4, 4, 2});
        builder.putAll((ImmutableListMultimap.Builder) "VU", (Object[]) new Integer[]{4, 1, 3, 1, 2});
        builder.putAll((ImmutableListMultimap.Builder) "WS", (Object[]) new Integer[]{3, 1, 4, 2, 2});
        builder.putAll((ImmutableListMultimap.Builder) "XK", (Object[]) new Integer[]{1, 1, 1, 0, 2});
        builder.putAll((ImmutableListMultimap.Builder) "YE", (Object[]) new Integer[]{4, 4, 4, 4, 2});
        builder.putAll((ImmutableListMultimap.Builder) "YT", (Object[]) new Integer[]{3, 2, 1, 3, 2});
        builder.putAll((ImmutableListMultimap.Builder) "ZA", (Object[]) new Integer[]{2, 3, 2, 2, 2});
        builder.putAll((ImmutableListMultimap.Builder) "ZM", (Object[]) new Integer[]{3, 2, 2, 3, 2});
        builder.putAll((ImmutableListMultimap.Builder) "ZW", (Object[]) new Integer[]{3, 3, 3, 3, 2});
        return builder.build();
    }

    public static boolean c(DataSpec dataSpec, boolean z) {
        return z && !dataSpec.isFlagSet(8);
    }

    public static synchronized DefaultBandwidthMeter getSingletonInstance(Context context) {
        DefaultBandwidthMeter defaultBandwidthMeter;
        synchronized (DefaultBandwidthMeter.class) {
            if (p == null) {
                p = new Builder(context).build();
            }
            defaultBandwidthMeter = p;
        }
        return defaultBandwidthMeter;
    }

    @Override // com.google.android.exoplayer2.upstream.BandwidthMeter
    public void addEventListener(Handler handler, BandwidthMeter.EventListener eventListener) {
        Assertions.checkNotNull(handler);
        Assertions.checkNotNull(eventListener);
        this.c.addListener(handler, eventListener);
    }

    public final long b(int i2) {
        Long l2 = this.b.get(Integer.valueOf(i2));
        if (l2 == null) {
            l2 = this.b.get(0);
        }
        if (l2 == null) {
            l2 = 1000000L;
        }
        return l2.longValue();
    }

    public final void d(int i2, long j2, long j3) {
        if (i2 != 0 || j2 != 0 || j3 != this.m) {
            this.m = j3;
            this.c.bandwidthSample(i2, j2, j3);
        }
    }

    public final synchronized void e() {
        int i2;
        if (this.n) {
            i2 = this.o;
        } else {
            Context context = this.a;
            i2 = context == null ? 0 : Util.getNetworkType(context);
        }
        if (this.i != i2) {
            this.i = i2;
            if (i2 != 1 && i2 != 0 && i2 != 8) {
                this.l = b(i2);
                long elapsedRealtime = this.e.elapsedRealtime();
                d(this.f > 0 ? (int) (elapsedRealtime - this.g) : 0, this.h, this.l);
                this.g = elapsedRealtime;
                this.h = 0;
                this.k = 0;
                this.j = 0;
                this.d.reset();
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.BandwidthMeter
    public synchronized long getBitrateEstimate() {
        return this.l;
    }

    @Override // com.google.android.exoplayer2.upstream.BandwidthMeter
    public TransferListener getTransferListener() {
        return this;
    }

    @Override // com.google.android.exoplayer2.upstream.TransferListener
    public synchronized void onBytesTransferred(DataSource dataSource, DataSpec dataSpec, boolean z, int i2) {
        if (c(dataSpec, z)) {
            this.h += (long) i2;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.TransferListener
    public synchronized void onTransferEnd(DataSource dataSource, DataSpec dataSpec, boolean z) {
        if (c(dataSpec, z)) {
            Assertions.checkState(this.f > 0);
            long elapsedRealtime = this.e.elapsedRealtime();
            int i2 = (int) (elapsedRealtime - this.g);
            this.j += (long) i2;
            long j2 = this.k;
            long j3 = this.h;
            this.k = j2 + j3;
            if (i2 > 0) {
                this.d.addSample((int) Math.sqrt((double) j3), (((float) j3) * 8000.0f) / ((float) i2));
                if (this.j >= 2000 || this.k >= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) {
                    this.l = (long) this.d.getPercentile(0.5f);
                }
                d(i2, this.h, this.l);
                this.g = elapsedRealtime;
                this.h = 0;
            }
            this.f--;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.TransferListener
    public void onTransferInitializing(DataSource dataSource, DataSpec dataSpec, boolean z) {
    }

    @Override // com.google.android.exoplayer2.upstream.TransferListener
    public synchronized void onTransferStart(DataSource dataSource, DataSpec dataSpec, boolean z) {
        if (c(dataSpec, z)) {
            if (this.f == 0) {
                this.g = this.e.elapsedRealtime();
            }
            this.f++;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.BandwidthMeter
    public void removeEventListener(BandwidthMeter.EventListener eventListener) {
        this.c.removeListener(eventListener);
    }

    public synchronized void setNetworkTypeOverride(int i2) {
        this.o = i2;
        this.n = true;
        e();
    }

    public static final class Builder {
        @Nullable
        public final Context a;
        public Map<Integer, Long> b;
        public int c;
        public Clock d;
        public boolean e;

        public Builder(Context context) {
            Context context2;
            if (context == null) {
                context2 = null;
            } else {
                context2 = context.getApplicationContext();
            }
            this.a = context2;
            this.b = a(Util.getCountryCode(context));
            this.c = 2000;
            this.d = Clock.DEFAULT;
            this.e = true;
        }

        public static Map<Integer, Long> a(String str) {
            ImmutableList<Integer> immutableList = DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_COUNTRY_GROUPS.mo118get((ImmutableListMultimap<String, Integer>) str);
            if (immutableList.isEmpty()) {
                immutableList = ImmutableList.of(2, 2, 2, 2, 2);
            }
            HashMap hashMap = new HashMap(6);
            hashMap.put(0, 1000000L);
            ImmutableList<Long> immutableList2 = DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_ESTIMATES_WIFI;
            hashMap.put(2, immutableList2.get(immutableList.get(0).intValue()));
            hashMap.put(3, DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_ESTIMATES_2G.get(immutableList.get(1).intValue()));
            hashMap.put(4, DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_ESTIMATES_3G.get(immutableList.get(2).intValue()));
            hashMap.put(5, DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_ESTIMATES_4G.get(immutableList.get(3).intValue()));
            hashMap.put(9, DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_ESTIMATES_5G_NSA.get(immutableList.get(4).intValue()));
            hashMap.put(7, immutableList2.get(immutableList.get(0).intValue()));
            return hashMap;
        }

        public DefaultBandwidthMeter build() {
            return new DefaultBandwidthMeter(this.a, this.b, this.c, this.d, this.e);
        }

        public Builder setClock(Clock clock) {
            this.d = clock;
            return this;
        }

        public Builder setInitialBitrateEstimate(long j) {
            for (Integer num : this.b.keySet()) {
                setInitialBitrateEstimate(num.intValue(), j);
            }
            return this;
        }

        public Builder setResetOnNetworkTypeChange(boolean z) {
            this.e = z;
            return this;
        }

        public Builder setSlidingWindowMaxWeight(int i) {
            this.c = i;
            return this;
        }

        public Builder setInitialBitrateEstimate(int i, long j) {
            this.b.put(Integer.valueOf(i), Long.valueOf(j));
            return this;
        }

        public Builder setInitialBitrateEstimate(String str) {
            this.b = a(Util.toUpperInvariant(str));
            return this;
        }
    }

    public DefaultBandwidthMeter(@Nullable Context context, Map<Integer, Long> map, int i2, Clock clock, boolean z) {
        Context context2;
        int i3;
        a aVar;
        if (context == null) {
            context2 = null;
        } else {
            context2 = context.getApplicationContext();
        }
        this.a = context2;
        this.b = ImmutableMap.copyOf(map);
        this.c = new BandwidthMeter.EventListener.EventDispatcher();
        this.d = new SlidingPercentile(i2);
        this.e = clock;
        if (context == null) {
            i3 = 0;
        } else {
            i3 = Util.getNetworkType(context);
        }
        this.i = i3;
        this.l = b(i3);
        if (context != null && z) {
            a aVar2 = a.c;
            synchronized (a.class) {
                if (a.c == null) {
                    a.c = new a();
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction(NetworkChangeReceiver.CONNECTIVITY_ACTION);
                    context.registerReceiver(a.c, intentFilter);
                }
                aVar = a.c;
            }
            synchronized (aVar) {
                aVar.a();
                aVar.b.add(new WeakReference<>(this));
                aVar.a.post(new Runnable(this) { // from class: a2.j.b.b.d1.b
                    public final /* synthetic */ DefaultBandwidthMeter b;

                    {
                        this.b = r2;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        DefaultBandwidthMeter.a aVar3 = DefaultBandwidthMeter.a.this;
                        DefaultBandwidthMeter defaultBandwidthMeter = this.b;
                        Objects.requireNonNull(aVar3);
                        ImmutableListMultimap<String, Integer> immutableListMultimap = DefaultBandwidthMeter.DEFAULT_INITIAL_BITRATE_COUNTRY_GROUPS;
                        defaultBandwidthMeter.e();
                    }
                });
            }
        }
    }
}
