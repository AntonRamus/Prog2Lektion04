package opgave03.models;

import java.util.ArrayList;

public class ArrayListRing<E> implements Ring<E> {
    private final ArrayList<E> list = new ArrayList<>();
    private E currentItem;
    private int currentItemIndex = 0;

    @Override
    public void advance() {
        if (!list.isEmpty()) {
            if (currentItemIndex == list.size() - 1) {
                currentItem = list.getFirst();
                currentItemIndex = 0;
            } else {
                currentItemIndex++;
                currentItem = list.get(currentItemIndex);
            }
        }
    }

    @Override
    public E getCurrentItem() {
        return currentItem;
    }

    @Override
    public void add(E item) {
        list.add(item);
        currentItem = item;
        currentItemIndex = list.size() - 1;
    }

    @Override
    public boolean removeItem(E item) {
        if (list.contains(item)) {
            if (item.equals(currentItem)) {
                advance();
            }
            list.remove(item);
            return true;
        }
        return false;
    }

    @Override
    public E removeCurrentItem() {
        E item = currentItem;
        advance();
        return item;
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
