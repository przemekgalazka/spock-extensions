package com.geodevv.testing.spockextensions.doomsday

import org.joda.time.DateTime
import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class DoomsdayCalculatorSpec extends Specification {

    def "Given today is #now and dooms day is #doomsday, are we fucked - #isDoomsday"(String now,
                                                                                      String doomsday,
                                                                                      boolean isDoomsday) {
        given:
            DoomsDayCalculator.NowProvider nowProvider = Mock(DoomsDayCalculator.NowProvider)
            nowProvider.get() >> parse(now)
        and:
            DoomsDayCalculator calculator = new DoomsDayCalculator(nowProvider)

        when:
            def actualResult = calculator.isDoomsDayToday(doomsday)

        then:
            isDoomsday == actualResult

        where:
            now          | doomsday     | isDoomsday
            "2014-10-23" | "2015-10-23" | false
            "2015-10-23" | "2013-10-23" | true
            "2014-10-23" | "2015-10-23" | false
            "2017-10-23" | "2015-10-23" | true
            "2017-10-23" | "2017-10-23" | false
    }

    def "should handle invalid date format #doomsday"(String doomsday) {

        given:
            DoomsDayCalculator calculator = new DoomsDayCalculator()

        when:
            calculator.isDoomsDayToday(doomsday)

        then:
            thrown IllegalArgumentException
        where:
            doomsday << ['dupa', '28-08-1951', '08-28-1985', '', '08-28-1985 12:30']
    }

    DateTime parse(String value) {
        return DoomsDayCalculator.formatter.parseDateTime(value)
    }
}
