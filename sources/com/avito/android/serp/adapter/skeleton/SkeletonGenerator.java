package com.avito.android.serp.adapter.skeleton;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.shortcut_navigation_bar.adapter.SkeletonItem;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u000fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H&¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H&¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/avito/android/serp/adapter/skeleton/SkeletonGenerator;", "", "", "columnCount", "", "Lcom/avito/android/serp/adapter/skeleton/SkeletonItem;", "generateSerpSkeleton", "(I)Ljava/util/List;", "Lru/avito/component/shortcut_navigation_bar/adapter/SkeletonItem;", "generateSerpShortcutsSkeleton", "()Ljava/util/List;", "generateHomeShortcutsSkeleton", "Lcom/avito/android/serp/adapter/skeleton/SkeletonSectionTabsItem;", "createHomeSectionTabsItemsSkeleton", "()Lcom/avito/android/serp/adapter/skeleton/SkeletonSectionTabsItem;", "Impl", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface SkeletonGenerator {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/avito/android/serp/adapter/skeleton/SkeletonGenerator$Impl;", "Lcom/avito/android/serp/adapter/skeleton/SkeletonGenerator;", "", "columnCount", "", "Lcom/avito/android/serp/adapter/skeleton/SkeletonItem;", "generateSerpSkeleton", "(I)Ljava/util/List;", "Lru/avito/component/shortcut_navigation_bar/adapter/SkeletonItem;", "generateSerpShortcutsSkeleton", "()Ljava/util/List;", "generateHomeShortcutsSkeleton", "Lcom/avito/android/serp/adapter/skeleton/SkeletonSectionTabsItem;", "createHomeSectionTabsItemsSkeleton", "()Lcom/avito/android/serp/adapter/skeleton/SkeletonSectionTabsItem;", "<init>", "()V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Impl implements SkeletonGenerator {
        @Override // com.avito.android.serp.adapter.skeleton.SkeletonGenerator
        @NotNull
        public SkeletonSectionTabsItem createHomeSectionTabsItemsSkeleton() {
            return new SkeletonSectionTabsItem();
        }

        @Override // com.avito.android.serp.adapter.skeleton.SkeletonGenerator
        @NotNull
        public List<SkeletonItem> generateHomeShortcutsSkeleton() {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new SkeletonItem("1", true));
            for (int i = 2; i <= 10; i++) {
                arrayList.add(new SkeletonItem(String.valueOf(i), false, 2, null));
            }
            return arrayList;
        }

        @Override // com.avito.android.serp.adapter.skeleton.SkeletonGenerator
        @NotNull
        public List<SkeletonItem> generateSerpShortcutsSkeleton() {
            ArrayList arrayList = new ArrayList();
            for (int i = 1; i <= 10; i++) {
                arrayList.add(new SkeletonItem(String.valueOf(i), false, 2, null));
            }
            return arrayList;
        }

        @Override // com.avito.android.serp.adapter.skeleton.SkeletonGenerator
        @NotNull
        public List<SkeletonItem> generateSerpSkeleton(int i) {
            ArrayList arrayList = new ArrayList();
            int i2 = i * 5;
            int i3 = 1;
            if (1 <= i2) {
                while (true) {
                    arrayList.add(new SkeletonItem(String.valueOf(i3)));
                    if (i3 == i2) {
                        break;
                    }
                    i3++;
                }
            }
            return arrayList;
        }
    }

    @NotNull
    SkeletonSectionTabsItem createHomeSectionTabsItemsSkeleton();

    @NotNull
    List<SkeletonItem> generateHomeShortcutsSkeleton();

    @NotNull
    List<SkeletonItem> generateSerpShortcutsSkeleton();

    @NotNull
    List<SkeletonItem> generateSerpSkeleton(int i);
}
