package com.avito.android.messenger.folders;

import com.avito.android.messenger.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ProfileTab;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import t6.c;
import t6.n.x;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R#\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b8F@\u0006X\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0013\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/avito/android/messenger/folders/Folders;", "", "Lcom/avito/android/messenger/folders/Folder;", "c", "Lcom/avito/android/messenger/folders/Folder;", "getBARG_AND_EXCHANGE", "()Lcom/avito/android/messenger/folders/Folder;", "BARG_AND_EXCHANGE", AuthSource.SEND_ABUSE, "getDEFAULT", MessengerShareContentUtility.PREVIEW_DEFAULT, "", "d", "Lkotlin/Lazy;", "getAll", "()Ljava/util/List;", ProfileTab.ALL, AuthSource.BOOKING_ORDER, "getUNSORTED", "UNSORTED", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class Folders {
    @NotNull
    public static final Folders INSTANCE = new Folders();
    @NotNull
    public static final Folder a = new Folder("", 0, TuplesKt.to(x.sortedSetOf(new String[0]), x.sortedSetOf("s")), TuplesKt.to(x.sortedSetOf("s"), x.sortedSetOf(new String[0])), TuplesKt.to(x.sortedSetOf(new String[0]), x.sortedSetOf(new String[0])));
    @NotNull
    public static final Folder b = new Folder("inbox", R.string.messenger_folder_unsorted, TuplesKt.to(x.sortedSetOf("f_i"), x.sortedSetOf("s")), TuplesKt.to(x.sortedSetOf("s"), x.sortedSetOf(new String[0])), TuplesKt.to(x.sortedSetOf("f_i", "s"), x.sortedSetOf(new String[0])));
    @NotNull
    public static final Folder c = new Folder("bargainAndExchange", R.string.messenger_folder_bargaining_and_exchange, TuplesKt.to(x.sortedSetOf("f_b", "f_e"), x.sortedSetOf(new String[0])), null, TuplesKt.to(x.sortedSetOf("f_b", "f_e"), x.sortedSetOf(new String[0])));
    @NotNull
    public static final Lazy d = c.lazy(a.a);

    public static final class a extends Lambda implements Function0<List<? extends Folder>> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public List<? extends Folder> invoke() {
            Folders folders = Folders.INSTANCE;
            return CollectionsKt__CollectionsKt.listOf((Object[]) new Folder[]{folders.getUNSORTED(), folders.getBARG_AND_EXCHANGE()});
        }
    }

    @NotNull
    public final List<Folder> getAll() {
        return (List) d.getValue();
    }

    @NotNull
    public final Folder getBARG_AND_EXCHANGE() {
        return c;
    }

    @NotNull
    public final Folder getDEFAULT() {
        return a;
    }

    @NotNull
    public final Folder getUNSORTED() {
        return b;
    }
}
