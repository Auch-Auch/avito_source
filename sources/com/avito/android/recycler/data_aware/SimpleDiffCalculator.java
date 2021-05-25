package com.avito.android.recycler.data_aware;

import androidx.recyclerview.widget.DiffUtil;
import com.avito.android.recycler.di.DetectMoves;
import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.blueprint.Item;
import com.avito.konveyor.data_source.DataSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0002\u0016\u001bB1\b\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0003\u0010\u0014\u001a\u00020\u0011\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0019\u0010\u001aJ/\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00022\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0018\u0010\f\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/avito/android/recycler/data_aware/SimpleDiffCalculator;", "Lcom/avito/android/recycler/data_aware/DiffCalculator;", "Lcom/avito/konveyor/data_source/DataSource;", "Lcom/avito/konveyor/blueprint/Item;", "oldList", "newList", "Landroidx/recyclerview/widget/DiffUtil$DiffResult;", "calculateDiff", "(Lcom/avito/konveyor/data_source/DataSource;Lcom/avito/konveyor/data_source/DataSource;)Landroidx/recyclerview/widget/DiffUtil$DiffResult;", "Lcom/avito/android/recycler/data_aware/ChangePayloadCreator;", "d", "Lcom/avito/android/recycler/data_aware/ChangePayloadCreator;", "changePayloadCreator", "Lcom/avito/android/recycler/data_aware/EqualityComparator;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/recycler/data_aware/EqualityComparator;", "equalityComparator", "", "c", "Z", "detectMoves", "Lcom/avito/android/recycler/data_aware/ContentsComparator;", AuthSource.SEND_ABUSE, "Lcom/avito/android/recycler/data_aware/ContentsComparator;", "contentsComparator", "<init>", "(Lcom/avito/android/recycler/data_aware/ContentsComparator;Lcom/avito/android/recycler/data_aware/EqualityComparator;ZLcom/avito/android/recycler/data_aware/ChangePayloadCreator;)V", "Companion", "recycler_release"}, k = 1, mv = {1, 4, 2})
public final class SimpleDiffCalculator implements DiffCalculator {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String DETECT_MOVES = "simple_diff_calculator_detect_moves";
    public final ContentsComparator a;
    public final EqualityComparator b;
    public final boolean c;
    public final ChangePayloadCreator d;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/recycler/data_aware/SimpleDiffCalculator$Companion;", "", "", "DETECT_MOVES", "Ljava/lang/String;", "<init>", "()V", "recycler_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends DiffUtil.Callback {
        public final ContentsComparator a;
        public final EqualityComparator b;
        public final ChangePayloadCreator c;
        public final DataSource<? extends Item> d;
        public final DataSource<? extends Item> e;

        public a(@NotNull ContentsComparator contentsComparator, @NotNull EqualityComparator equalityComparator, @Nullable ChangePayloadCreator changePayloadCreator, @NotNull DataSource<? extends Item> dataSource, @NotNull DataSource<? extends Item> dataSource2) {
            Intrinsics.checkNotNullParameter(contentsComparator, "contentsComparator");
            Intrinsics.checkNotNullParameter(equalityComparator, "equalityComparator");
            Intrinsics.checkNotNullParameter(dataSource, "oldList");
            Intrinsics.checkNotNullParameter(dataSource2, "newList");
            this.a = contentsComparator;
            this.b = equalityComparator;
            this.c = changePayloadCreator;
            this.d = dataSource;
            this.e = dataSource2;
        }

        public final Item a(int i) {
            if (this.e.isEmpty()) {
                return null;
            }
            return (Item) this.e.getItem(i);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areContentsTheSame(int i, int i2) {
            return this.a.areContentsTheSame(b(i), a(i2));
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areItemsTheSame(int i, int i2) {
            return this.b.isEqual(b(i), a(i2));
        }

        public final Item b(int i) {
            if (this.d.isEmpty()) {
                return null;
            }
            return (Item) this.d.getItem(i);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        @Nullable
        public Object getChangePayload(int i, int i2) {
            ChangePayloadCreator changePayloadCreator = this.c;
            if (changePayloadCreator != null) {
                return changePayloadCreator.getChangePayload(b(i), a(i2));
            }
            return null;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getNewListSize() {
            return this.e.getCount();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getOldListSize() {
            return this.d.getCount();
        }
    }

    @Inject
    public SimpleDiffCalculator(@NotNull ContentsComparator contentsComparator, @NotNull EqualityComparator equalityComparator, @DetectMoves boolean z, @Nullable ChangePayloadCreator changePayloadCreator) {
        Intrinsics.checkNotNullParameter(contentsComparator, "contentsComparator");
        Intrinsics.checkNotNullParameter(equalityComparator, "equalityComparator");
        this.a = contentsComparator;
        this.b = equalityComparator;
        this.c = z;
        this.d = changePayloadCreator;
    }

    @Override // com.avito.android.recycler.data_aware.DiffCalculator
    @NotNull
    public DiffUtil.DiffResult calculateDiff(@NotNull DataSource<? extends Item> dataSource, @NotNull DataSource<? extends Item> dataSource2) {
        Intrinsics.checkNotNullParameter(dataSource, "oldList");
        Intrinsics.checkNotNullParameter(dataSource2, "newList");
        DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(new a(this.a, this.b, this.d, dataSource, dataSource2), this.c);
        Intrinsics.checkNotNullExpressionValue(calculateDiff, "DiffUtil.calculateDiff(b…t, newList), detectMoves)");
        return calculateDiff;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SimpleDiffCalculator(ContentsComparator contentsComparator, EqualityComparator equalityComparator, boolean z, ChangePayloadCreator changePayloadCreator, int i, j jVar) {
        this(contentsComparator, (i & 2) != 0 ? new SimpleEqualityComparator() : equalityComparator, (i & 4) != 0 ? false : z, (i & 8) != 0 ? null : changePayloadCreator);
    }
}
