package edu.cmu.cs.cs214.rec04;

/**
 * DelegationSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (totalAdded) for this count.
 *
 * @author Nora Shoemaker
 *
 */

 public class DelegationSortedIntList implements IntegerList {
    // Write your implementation below with API documentation
    private SortedIntList list = new SortedIntList();
    private int totalAdded = 0;

    @Override
    public boolean add(int num) {
        totalAdded++; // Тоог нэмэх
        return list.add(num); // Элементийг жагсаалтад нэмэх
    }

    @Override
    public boolean addAll(IntegerList list) {
        boolean added = false;
        for (int i = 0; i < list.size(); i++) {
            added |= this.add(list.get(i)); // Элемент тус бүрийг нэмэх
        }
        return added;
    }

    @Override
    public int get(int index) {
        return list.get(index); // Жагсаалтаас элемент авах
    }

    @Override
    public boolean remove(int num) {
        return list.remove(num); // Элемент устгах
    }

    @Override
    public boolean removeAll(IntegerList list) {
        return this.list.removeAll(list); // Бүгдийг устгах
    }

    @Override
    public int size() {
        return list.size(); // Жагсаалтын хэмжээг буцаах
    }

    public int getTotalAdded() {
        return totalAdded; // Нэмэгдсэн элементийн тоог буцаах
    }
}