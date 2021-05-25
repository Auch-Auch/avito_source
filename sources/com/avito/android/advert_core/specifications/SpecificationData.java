package com.avito.android.advert_core.specifications;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ModelSpecifications;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\b\t\nR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u0001\u0003\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/advert_core/specifications/SpecificationData;", "", "", AuthSource.SEND_ABUSE, "I", "getSpan", "()I", "span", "BlockData", "SchemeData", "TitleData", "Lcom/avito/android/advert_core/specifications/SpecificationData$BlockData;", "Lcom/avito/android/advert_core/specifications/SpecificationData$TitleData;", "Lcom/avito/android/advert_core/specifications/SpecificationData$SchemeData;", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public abstract class SpecificationData {
    public final int a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/avito/android/advert_core/specifications/SpecificationData$BlockData;", "Lcom/avito/android/advert_core/specifications/SpecificationData;", "Lcom/avito/android/remote/model/ModelSpecifications$Block;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/ModelSpecifications$Block;", "getData", "()Lcom/avito/android/remote/model/ModelSpecifications$Block;", "data", "", "span", "<init>", "(Lcom/avito/android/remote/model/ModelSpecifications$Block;I)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class BlockData extends SpecificationData {
        @NotNull
        public final ModelSpecifications.Block b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public BlockData(@NotNull ModelSpecifications.Block block, int i) {
            super(i, null);
            Intrinsics.checkNotNullParameter(block, "data");
            this.b = block;
        }

        @NotNull
        public final ModelSpecifications.Block getData() {
            return this.b;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/avito/android/advert_core/specifications/SpecificationData$SchemeData;", "Lcom/avito/android/advert_core/specifications/SpecificationData;", "Lcom/avito/android/remote/model/ModelSpecifications$Scheme;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/ModelSpecifications$Scheme;", "getData", "()Lcom/avito/android/remote/model/ModelSpecifications$Scheme;", "data", "", "span", "<init>", "(Lcom/avito/android/remote/model/ModelSpecifications$Scheme;I)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class SchemeData extends SpecificationData {
        @NotNull
        public final ModelSpecifications.Scheme b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SchemeData(@NotNull ModelSpecifications.Scheme scheme, int i) {
            super(i, null);
            Intrinsics.checkNotNullParameter(scheme, "data");
            this.b = scheme;
        }

        @NotNull
        public final ModelSpecifications.Scheme getData() {
            return this.b;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/avito/android/advert_core/specifications/SpecificationData$TitleData;", "Lcom/avito/android/advert_core/specifications/SpecificationData;", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getData", "()Ljava/lang/String;", "data", "", "span", "<init>", "(Ljava/lang/String;I)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class TitleData extends SpecificationData {
        @NotNull
        public final String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public TitleData(@NotNull String str, int i) {
            super(i, null);
            Intrinsics.checkNotNullParameter(str, "data");
            this.b = str;
        }

        @NotNull
        public final String getData() {
            return this.b;
        }
    }

    public SpecificationData(int i, j jVar) {
        this.a = i;
    }

    public final int getSpan() {
        return this.a;
    }
}
