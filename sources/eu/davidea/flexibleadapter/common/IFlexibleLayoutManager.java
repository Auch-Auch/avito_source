package eu.davidea.flexibleadapter.common;
public interface IFlexibleLayoutManager {
    int findFirstCompletelyVisibleItemPosition();

    int findFirstVisibleItemPosition();

    int findLastCompletelyVisibleItemPosition();

    int findLastVisibleItemPosition();

    int getOrientation();

    int getSpanCount();
}
