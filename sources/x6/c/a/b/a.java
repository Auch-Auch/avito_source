package x6.c.a.b;

import java.util.ArrayList;
import java.util.List;
import org.junit.internal.Classes;
import org.junit.runner.FilterFactory;
import org.junit.runner.FilterFactoryParams;
import org.junit.runner.manipulation.Filter;
public abstract class a implements FilterFactory {
    public abstract Filter createFilter(List<Class<?>> list);

    @Override // org.junit.runner.FilterFactory
    public Filter createFilter(FilterFactoryParams filterFactoryParams) throws FilterFactory.FilterNotCreatedException {
        try {
            String args = filterFactoryParams.getArgs();
            ArrayList arrayList = new ArrayList();
            for (String str : args.split(",")) {
                arrayList.add(Classes.getClass(str, getClass()));
            }
            return createFilter(arrayList);
        } catch (ClassNotFoundException e) {
            throw new FilterFactory.FilterNotCreatedException(e);
        }
    }
}
