package com.avito.android.remote.social;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SocialNetworkType;
import com.avito.android.social.SocialType;
import com.avito.android.social.SocialTypeToStringMapper;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR(\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/remote/social/AvitoSocialTypeToStringMapper;", "Lcom/avito/android/social/SocialTypeToStringMapper;", "Lcom/avito/android/social/SocialType;", "type", "", "mapToString", "(Lcom/avito/android/social/SocialType;)Ljava/lang/String;", "mapToStringOrNull", "socialType", "mapToSocialType", "(Ljava/lang/String;)Lcom/avito/android/social/SocialType;", "", "Lkotlin/Pair;", AuthSource.SEND_ABUSE, "Ljava/util/List;", "MAPPING", "<init>", "()V", "core_release"}, k = 1, mv = {1, 4, 2})
public final class AvitoSocialTypeToStringMapper implements SocialTypeToStringMapper {
    public final List<Pair<SocialType, String>> a = CollectionsKt__CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(SocialType.FACEBOOK, "fb"), TuplesKt.to(SocialType.GOOGLE, "gp"), TuplesKt.to(SocialType.LIVE_JOURNAL, SocialNetworkType.LIVE_JOURNAL), TuplesKt.to(SocialType.MAIL, SocialNetworkType.MAIL_RU), TuplesKt.to(SocialType.ODNOKLASSNIKI, "ok"), TuplesKt.to(SocialType.TWITTER, SocialNetworkType.TWITTER), TuplesKt.to(SocialType.VKONTAKTE, "vk"), TuplesKt.to(SocialType.APPLE, "apple"), TuplesKt.to(SocialType.ESIA, "esia")});

    @Override // com.avito.android.social.SocialTypeToStringMapper
    @NotNull
    public SocialType mapToSocialType(@Nullable String str) {
        T t;
        SocialType socialType;
        Iterator<T> it = this.a.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (Intrinsics.areEqual((String) t.getSecond(), str)) {
                break;
            }
        }
        T t2 = t;
        if (t2 != null && (socialType = (SocialType) t2.getFirst()) != null) {
            return socialType;
        }
        throw new IllegalStateException("Unknown Social Type");
    }

    @Override // com.avito.android.social.SocialTypeToStringMapper
    @NotNull
    public String mapToString(@Nullable SocialType socialType) {
        T t;
        String str;
        boolean z;
        Iterator<T> it = this.a.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (((SocialType) t.getFirst()) == socialType) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        T t2 = t;
        if (t2 != null && (str = (String) t2.getSecond()) != null) {
            return str;
        }
        throw new IllegalStateException("Unknown Social Type");
    }

    @Override // com.avito.android.social.SocialTypeToStringMapper
    @Nullable
    public String mapToStringOrNull(@Nullable SocialType socialType) {
        T t;
        boolean z;
        Iterator<T> it = this.a.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (((SocialType) t.getFirst()) == socialType) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        T t2 = t;
        if (t2 != null) {
            return (String) t2.getSecond();
        }
        return null;
    }
}
