package kotlin.reflect.jvm.internal.impl.descriptors;

import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.remote.model.UserTypeCode;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.common.internal.ImagesContract;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.q;
public final class Visibilities {
    @NotNull
    public static final Visibilities INSTANCE = new Visibilities();
    @NotNull
    public static final Map<Visibility, Integer> a;

    public static final class Inherited extends Visibility {
        @NotNull
        public static final Inherited INSTANCE = new Inherited();

        public Inherited() {
            super("inherited", false);
        }
    }

    public static final class Internal extends Visibility {
        @NotNull
        public static final Internal INSTANCE = new Internal();

        public Internal() {
            super("internal", false);
        }
    }

    public static final class InvisibleFake extends Visibility {
        @NotNull
        public static final InvisibleFake INSTANCE = new InvisibleFake();

        public InvisibleFake() {
            super("invisible_fake", false);
        }
    }

    public static final class Local extends Visibility {
        @NotNull
        public static final Local INSTANCE = new Local();

        public Local() {
            super(ImagesContract.LOCAL, false);
        }
    }

    public static final class Private extends Visibility {
        @NotNull
        public static final Private INSTANCE = new Private();

        public Private() {
            super(UserTypeCode.PRIVATE, false);
        }
    }

    public static final class PrivateToThis extends Visibility {
        @NotNull
        public static final PrivateToThis INSTANCE = new PrivateToThis();

        public PrivateToThis() {
            super("private_to_this", false);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
        @NotNull
        public String getInternalDisplayName() {
            return "private/*private to this*/";
        }
    }

    public static final class Protected extends Visibility {
        @NotNull
        public static final Protected INSTANCE = new Protected();

        public Protected() {
            super("protected", true);
        }
    }

    public static final class Public extends Visibility {
        @NotNull
        public static final Public INSTANCE = new Public();

        public Public() {
            super("public", true);
        }
    }

    public static final class Unknown extends Visibility {
        @NotNull
        public static final Unknown INSTANCE = new Unknown();

        public Unknown() {
            super("unknown", false);
        }
    }

    static {
        Map createMapBuilder = q.createMapBuilder();
        createMapBuilder.put(PrivateToThis.INSTANCE, 0);
        createMapBuilder.put(Private.INSTANCE, 0);
        createMapBuilder.put(Internal.INSTANCE, 1);
        createMapBuilder.put(Protected.INSTANCE, 1);
        createMapBuilder.put(Public.INSTANCE, 2);
        a = q.build(createMapBuilder);
    }

    @Nullable
    public final Integer compareLocal$compiler_common(@NotNull Visibility visibility, @NotNull Visibility visibility2) {
        Intrinsics.checkNotNullParameter(visibility, InternalConstsKt.FIRST_IMAGE);
        Intrinsics.checkNotNullParameter(visibility2, "second");
        if (visibility == visibility2) {
            return 0;
        }
        Map<Visibility, Integer> map = a;
        Integer num = map.get(visibility);
        Integer num2 = map.get(visibility2);
        if (num == null || num2 == null || Intrinsics.areEqual(num, num2)) {
            return null;
        }
        return Integer.valueOf(num.intValue() - num2.intValue());
    }

    public final boolean isPrivate(@NotNull Visibility visibility) {
        Intrinsics.checkNotNullParameter(visibility, ViewHierarchyConstants.DIMENSION_VISIBILITY_KEY);
        return visibility == Private.INSTANCE || visibility == PrivateToThis.INSTANCE;
    }
}
