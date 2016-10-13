package com.suglob.transport.comparator;

import com.suglob.transport.entity.PassengerCarriage;

import java.util.Comparator;

public class CarriageByComfortComparator implements Comparator<PassengerCarriage> {
    @Override
    public int compare(PassengerCarriage o1, PassengerCarriage o2) {
        return o1.getComfortLevel().compareTo(o2.getComfortLevel());
    }
}
