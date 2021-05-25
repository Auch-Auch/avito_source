package ru.avito.component.animator;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\n\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006J7\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH&¢\u0006\u0004\b\r\u0010\u000eJA\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH&¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0016\u0010\u0015J7\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH&¢\u0006\u0004\b\u0017\u0010\u0018JA\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH&¢\u0006\u0004\b\u0019\u0010\u001aJA\u0010\u001b\u001a\u00020\u00132\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH&¢\u0006\u0004\b\u001b\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u00020\u001c8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u001eR\u0016\u0010#\u001a\u00020\u001c8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u001eR\u0016\u0010%\u001a\u00020\u001c8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\u001e¨\u0006&"}, d2 = {"Lru/avito/component/animator/AnimatorStrategy;", "", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "", "preAnimateRemove", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)Z", "preAnimateAdd", "", "fromX", "fromY", "toX", "toY", "preAnimateMove", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;IIII)Z", "oldHolder", "newHolder", "preAnimateChange", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;IIII)Z", "Lru/avito/component/animator/AnimatorInfo;", "animateRemove", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)Lru/avito/component/animator/AnimatorInfo;", "animateAdd", "animateMove", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;IIII)Lru/avito/component/animator/AnimatorInfo;", "animateChangeOld", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;IIII)Lru/avito/component/animator/AnimatorInfo;", "animateChangeNew", "", "getChangeDurationMs", "()J", "changeDurationMs", "getAddDurationMs", "addDurationMs", "getRemoveDurationMs", "removeDurationMs", "getMoveDurationMs", "moveDurationMs", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface AnimatorStrategy {
    @NotNull
    AnimatorInfo animateAdd(@NotNull RecyclerView.ViewHolder viewHolder);

    @NotNull
    AnimatorInfo animateChangeNew(@Nullable RecyclerView.ViewHolder viewHolder, @NotNull RecyclerView.ViewHolder viewHolder2, int i, int i2, int i3, int i4);

    @NotNull
    AnimatorInfo animateChangeOld(@NotNull RecyclerView.ViewHolder viewHolder, @Nullable RecyclerView.ViewHolder viewHolder2, int i, int i2, int i3, int i4);

    @NotNull
    AnimatorInfo animateMove(@NotNull RecyclerView.ViewHolder viewHolder, int i, int i2, int i3, int i4);

    @NotNull
    AnimatorInfo animateRemove(@NotNull RecyclerView.ViewHolder viewHolder);

    long getAddDurationMs();

    long getChangeDurationMs();

    long getMoveDurationMs();

    long getRemoveDurationMs();

    boolean preAnimateAdd(@NotNull RecyclerView.ViewHolder viewHolder);

    boolean preAnimateChange(@NotNull RecyclerView.ViewHolder viewHolder, @Nullable RecyclerView.ViewHolder viewHolder2, int i, int i2, int i3, int i4);

    boolean preAnimateMove(@NotNull RecyclerView.ViewHolder viewHolder, int i, int i2, int i3, int i4);

    boolean preAnimateRemove(@NotNull RecyclerView.ViewHolder viewHolder);
}
