package com.avito.android.beduin.component;

import com.avito.android.beduin.component.button.BeduinButtonComponent;
import com.avito.android.beduin.component.image.BeduinImageComponent;
import com.avito.android.beduin.component.separator.BeduinSeparatorComponent;
import com.avito.android.beduin.component.spacing.BeduinSpacingComponent;
import com.avito.android.beduin.component.text.BeduinTextComponent;
import com.avito.android.beduin.container.equalwidth.BeduinEqualWidthContainer;
import com.avito.android.beduin.container.spread.BeduinSpreadContainer;
import com.avito.android.beduin.container.vertical.BeduinVerticalContainer;
import com.avito.android.beduin.core.component.BeduinComponent;
import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bR/\u0010\t\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00040\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/avito/android/beduin/component/StandardComponents;", "", "", "Lkotlin/reflect/KClass;", "Lcom/avito/android/beduin/core/component/BeduinComponent;", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getList", "()Ljava/util/List;", "list", "<init>", "()V", "beduin_release"}, k = 1, mv = {1, 4, 2})
public final class StandardComponents {
    @NotNull
    public static final StandardComponents INSTANCE = new StandardComponents();
    @NotNull
    public static final List<KClass<? extends BeduinComponent<?, ?>>> a = CollectionsKt__CollectionsKt.listOf((Object[]) new KClass[]{Reflection.getOrCreateKotlinClass(BeduinButtonComponent.class), Reflection.getOrCreateKotlinClass(BeduinTextComponent.class), Reflection.getOrCreateKotlinClass(BeduinSpacingComponent.class), Reflection.getOrCreateKotlinClass(BeduinImageComponent.class), Reflection.getOrCreateKotlinClass(BeduinSeparatorComponent.class), Reflection.getOrCreateKotlinClass(BeduinSpreadContainer.class), Reflection.getOrCreateKotlinClass(BeduinEqualWidthContainer.class), Reflection.getOrCreateKotlinClass(BeduinVerticalContainer.class)});

    @NotNull
    public final List<KClass<? extends BeduinComponent<?, ?>>> getList() {
        return a;
    }
}
