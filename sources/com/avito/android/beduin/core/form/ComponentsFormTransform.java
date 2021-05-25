package com.avito.android.beduin.core.form;

import com.avito.android.beduin.core.model.container.component.BeduinModel;
import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/beduin/core/form/ComponentsFormTransform;", "", "<init>", "()V", "Apply", "Replace", "Set", "Lcom/avito/android/beduin/core/form/ComponentsFormTransform$Set;", "Lcom/avito/android/beduin/core/form/ComponentsFormTransform$Replace;", "Lcom/avito/android/beduin/core/form/ComponentsFormTransform$Apply;", "beduin_release"}, k = 1, mv = {1, 4, 2})
public abstract class ComponentsFormTransform {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0002¢\u0006\u0004\b\u000b\u0010\fR+\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/beduin/core/form/ComponentsFormTransform$Apply;", "Lcom/avito/android/beduin/core/form/ComponentsFormTransform;", "", "", "", "Lcom/avito/android/beduin/core/form/BeduinModelTransform;", AuthSource.SEND_ABUSE, "Ljava/util/Map;", "getModelsTransforms", "()Ljava/util/Map;", "modelsTransforms", "<init>", "(Ljava/util/Map;)V", "beduin_release"}, k = 1, mv = {1, 4, 2})
    public static final class Apply extends ComponentsFormTransform {
        @NotNull
        public final Map<String, List<BeduinModelTransform>> a;

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.Map<java.lang.String, ? extends java.util.List<? extends com.avito.android.beduin.core.form.BeduinModelTransform>> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Apply(@NotNull Map<String, ? extends List<? extends BeduinModelTransform>> map) {
            super(null);
            Intrinsics.checkNotNullParameter(map, "modelsTransforms");
            this.a = map;
        }

        @NotNull
        public final Map<String, List<BeduinModelTransform>> getModelsTransforms() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/avito/android/beduin/core/form/ComponentsFormTransform$Replace;", "Lcom/avito/android/beduin/core/form/ComponentsFormTransform;", "Lcom/avito/android/beduin/core/model/container/component/BeduinModel;", AuthSource.SEND_ABUSE, "Lcom/avito/android/beduin/core/model/container/component/BeduinModel;", "getOldModel", "()Lcom/avito/android/beduin/core/model/container/component/BeduinModel;", "oldModel", AuthSource.BOOKING_ORDER, "getNewModel", "newModel", "<init>", "(Lcom/avito/android/beduin/core/model/container/component/BeduinModel;Lcom/avito/android/beduin/core/model/container/component/BeduinModel;)V", "beduin_release"}, k = 1, mv = {1, 4, 2})
    public static final class Replace extends ComponentsFormTransform {
        @NotNull
        public final BeduinModel a;
        @NotNull
        public final BeduinModel b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Replace(@NotNull BeduinModel beduinModel, @NotNull BeduinModel beduinModel2) {
            super(null);
            Intrinsics.checkNotNullParameter(beduinModel, "oldModel");
            Intrinsics.checkNotNullParameter(beduinModel2, "newModel");
            this.a = beduinModel;
            this.b = beduinModel2;
        }

        @NotNull
        public final BeduinModel getNewModel() {
            return this.b;
        }

        @NotNull
        public final BeduinModel getOldModel() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\t\u0010\nR\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/avito/android/beduin/core/form/ComponentsFormTransform$Set;", "Lcom/avito/android/beduin/core/form/ComponentsFormTransform;", "", "Lcom/avito/android/beduin/core/model/container/component/BeduinModel;", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getModels", "()Ljava/util/List;", "models", "<init>", "(Ljava/util/List;)V", "beduin_release"}, k = 1, mv = {1, 4, 2})
    public static final class Set extends ComponentsFormTransform {
        @NotNull
        public final List<BeduinModel> a;

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends com.avito.android.beduin.core.model.container.component.BeduinModel> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Set(@NotNull List<? extends BeduinModel> list) {
            super(null);
            Intrinsics.checkNotNullParameter(list, "models");
            this.a = list;
        }

        @NotNull
        public final List<BeduinModel> getModels() {
            return this.a;
        }
    }

    public ComponentsFormTransform() {
    }

    public ComponentsFormTransform(j jVar) {
    }
}
