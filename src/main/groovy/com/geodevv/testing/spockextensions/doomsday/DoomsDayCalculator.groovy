package com.geodevv.testing.spockextensions.doomsday

import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat
import org.joda.time.format.DateTimeFormatter

class DoomsDayCalculator {

    public static DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");

    private NowProvider nowProvider

    DoomsDayCalculator(NowProvider nowProvider) {
        this.nowProvider = nowProvider
    }

    DoomsDayCalculator() {
        this({ new DateTime() })
    }

    /**
     * @param doomsday format yyyy-MM-dd
     * @return true if it is after doomsday
     */
    boolean isDoomsDayToday(String doomsday) {
        DateTime dt = formatter.parseDateTime(doomsday);
        return nowProvider.get().isAfter(dt)
    }

    interface NowProvider {
        DateTime get()
    }

}
