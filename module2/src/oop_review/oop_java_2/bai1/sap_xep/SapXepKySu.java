package oop_review.oop_java_2.bai1.sap_xep;

import oop_review.oop_java_2.bai1.KySu;

import java.util.Comparator;

public class SapXepKySu implements Comparator<KySu> {
    @Override
    public int compare(KySu o1, KySu o2) {
        return (o1.getHoVaTen().compareTo(o2.getHoVaTen()));
    }
}
