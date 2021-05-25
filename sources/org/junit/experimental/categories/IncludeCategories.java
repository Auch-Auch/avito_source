package org.junit.experimental.categories;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.experimental.categories.Categories;
import org.junit.runner.FilterFactory;
import org.junit.runner.FilterFactoryParams;
import org.junit.runner.manipulation.Filter;
public final class IncludeCategories extends x6.c.a.b.a {

    public static class a extends Categories.CategoryFilter {
        public a(List<Class<?>> list) {
            super(true, (Set<Class<?>>) new HashSet(list), true, (Set<Class<?>>) null);
        }

        @Override // org.junit.experimental.categories.Categories.CategoryFilter, org.junit.runner.manipulation.Filter
        public String describe() {
            StringBuilder L = a2.b.a.a.a.L("includes ");
            L.append(super.describe());
            return L.toString();
        }
    }

    @Override // x6.c.a.b.a, org.junit.runner.FilterFactory
    public /* bridge */ /* synthetic */ Filter createFilter(FilterFactoryParams filterFactoryParams) throws FilterFactory.FilterNotCreatedException {
        return super.createFilter(filterFactoryParams);
    }

    @Override // x6.c.a.b.a
    public Filter createFilter(List<Class<?>> list) {
        return new a(list);
    }
}
