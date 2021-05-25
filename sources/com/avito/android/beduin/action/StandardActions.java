package com.avito.android.beduin.action;

import com.avito.android.beduin.core.action.BeduinAction;
import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bR'\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/avito/android/beduin/action/StandardActions;", "", "", "Lkotlin/reflect/KClass;", "Lcom/avito/android/beduin/core/action/BeduinAction;", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getList", "()Ljava/util/List;", "list", "<init>", "()V", "beduin_release"}, k = 1, mv = {1, 4, 2})
public final class StandardActions {
    @NotNull
    public static final StandardActions INSTANCE = new StandardActions();
    @NotNull
    public static final List<KClass<? extends BeduinAction>> a = CollectionsKt__CollectionsKt.listOf((Object[]) new KClass[]{Reflection.getOrCreateKotlinClass(BeduinOpenLinkAction.class), Reflection.getOrCreateKotlinClass(BeduinExecuteRequestAction.class)});

    @NotNull
    public final List<KClass<? extends BeduinAction>> getList() {
        return a;
    }
}
