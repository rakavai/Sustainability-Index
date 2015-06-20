/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rakib
 */
public class Pair<L, R> {

    private final L left;
    private final R right;

    public Pair(L left, R right) {
        this.left = left;
        this.right = right;
    }

    public L getLeft() {
        return left;
    }

    public R getRight() {
        return right;
    }

    @Override
    public int hashCode() {
        return left.hashCode() ^ right.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pair)) {
            return false;
        }
        Pair pairo = (Pair) o;
        return this.left.equals(pairo.getLeft())
                && this.right.equals(pairo.getRight());
    }

    public static List<Pair<?, ?>> combinePair(List<?> allSectionObject) {

        List<Pair<?, ?>> pairKeeper;
        pairKeeper = new ArrayList<>();
        for (int i = 0; i < allSectionObject.size() - 1; i++) {
            for (int j = i + 1; j < allSectionObject.size(); j++) {
                if (j % 2 == 0) {
                    pairKeeper.add(new Pair<>(allSectionObject.get(j), allSectionObject.get(i)));
                } else {
                    pairKeeper.add(new Pair<>(allSectionObject.get(i), allSectionObject.get(j)));
                }
            }
        }
        return pairKeeper;

    }

}
