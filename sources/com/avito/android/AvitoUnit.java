package com.avito.android;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.preferences.Names;
import com.google.android.gms.ads.AdError;
import com.sumsub.sns.core.common.SNSConstants;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlinx.coroutines.DebugKt;
import org.jetbrains.annotations.NotNull;
import t6.n.d;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\"\n\u0002\b\u001f\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\r\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,¨\u0006-"}, d2 = {"Lcom/avito/android/AvitoUnit;", "", "", "", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "getEmails", "()Ljava/util/List;", "emails", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getUnitName", "()Ljava/lang/String;", "unitName", "", "c", "Ljava/util/Set;", "getDevelopers", "()Ljava/util/Set;", "developers", "UNDEFINED", "BILLING", "JOB", "GEO", "ADV", "BUYER", "MESSENGER", "TARIFFS", "VAS", "RECOMMENDATIONS", "SELLER", "SPEED", "SUPPORT", "AVITO_PRO", "AUTO", "AUTOTEKA", "TRUST_AND_SAFETY", "SAFEDEAL", "DOMOFOND", "PERFORMANCE", "DESIGN_SYSTEM", "COMMUNICATIONS", "REAL_ESTATE", "SELLER_TOOLS", "CALLS", "team"}, k = 1, mv = {1, 4, 2})
public enum AvitoUnit {
    UNDEFINED(AdError.UNDEFINED_DOMAIN, null, null, 6),
    BILLING("billing", d.listOf("iakrygin@avito.ru"), null, 4),
    JOB("job", CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"iakrygin@avito.ru", "dmsurikov@avito.ru"}), null, 4),
    GEO(Names.GEO, CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"dsolodov@avito.ru", "afborodin@avito.ru"}), null, 4),
    ADV("adv", d.listOf("aoglushkov@avito.ru"), null, 4),
    BUYER("buyer-x", CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"ssglotov@avito.ru", "sasvistunov@avito.ru", "afborodin@avito.ru", "myulavrik@avito.ru", "potrikhin@avito.ru"}), null, 4),
    MESSENGER("messenger", d.listOf("bvnesterov@avito.ru"), null, 4),
    TARIFFS("tariffs", d.listOf("ivsosnin@avito.ru"), null, 4),
    VAS("vas", null, null, 6),
    RECOMMENDATIONS("recommendations", CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"sasvistunov@avito.ru", "ssglotov@avito.ru", "afborodin@avito.ru"}), null, 4),
    SELLER("seller-fullbase", CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"ishlotgauer@avito.ru", "kskuznetsova@avito.ru", "nyubabkin@avito.ru", "natoropov@avito.ru"}), null, 4),
    SPEED("speed", CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"dvoronin@avito.ru", "dmerkurev@avito.ru", "ekrivobokov@avito.ru"}), null, 4),
    SUPPORT(SNSConstants.LinkType.SUPPORT, CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"vboldyrev@avito.ru", "dvkulikov@avito.ru"}), null, 4),
    AVITO_PRO("avito-pro", d.listOf("pivanisenko@avito.ru"), null, 4),
    AUTO(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"nvgusarov@avito.ru", "dyuuporov@avito.ru"}), null, 4),
    AUTOTEKA("autoteka", d.listOf("vakovrizhkin@avito.ru"), null, 4),
    TRUST_AND_SAFETY("trust-and-safety", CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"isolkin@avito.ru", "poignatov@avito.ru"}), null, 4),
    SAFEDEAL("safedeal", d.listOf("danazarkov@avito.ru"), null, 4),
    DOMOFOND("domofond", CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"dgvoloshin@avito.ru", "aodanilov@avito.ru"}), null, 4),
    PERFORMANCE("performance", d.listOf("mayudin@avito.ru"), null, 4),
    DESIGN_SYSTEM("design-system", CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"poignatov@avito.ru", "aodanilov@avito.ru"}), null, 4),
    COMMUNICATIONS("communications", null, null, 6),
    REAL_ESTATE("real estate", null, null, 6),
    SELLER_TOOLS("seller_tools", null, null, 6),
    CALLS("in-app-calls", d.listOf("sorpotskiy@avito.ru"), null, 4);
    
    @NotNull
    public final String a;
    @NotNull
    public final List<String> b;
    @NotNull
    public final Set<String> c;

    /* access modifiers changed from: public */
    AvitoUnit(String str, List list, Set set, int i) {
        list = (i & 2) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list;
        Set<String> set2 = (i & 4) != 0 ? CollectionsKt___CollectionsKt.toSet(list) : null;
        this.a = str;
        this.b = list;
        this.c = set2;
    }

    @NotNull
    public final Set<String> getDevelopers() {
        return this.c;
    }

    @NotNull
    public final List<String> getEmails() {
        return this.b;
    }

    @NotNull
    public final String getUnitName() {
        return this.a;
    }
}
