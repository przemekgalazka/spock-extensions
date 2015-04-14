package com.geodevv.testing.spockextensions.doomsday

import org.spockframework.runtime.model.FeatureInfo
import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class DoomsdayExtensionSpec extends Specification {

    def "features skip is set to #shouldSkip cos doomsday is #doomsDayValue"(String doomsDayValue, boolean
            shouldSkip) {

        DoomsdayExtension extension = new DoomsdayExtension()
        FeatureInfo featureInfo = Mock(FeatureInfo)
        DoomsDay doomsDay = Mock(DoomsDay)
        doomsDay.value() >> doomsDayValue

        when:
            extension.visitFeatureAnnotation(doomsDay, featureInfo)

        then:
            1 * featureInfo.setSkipped(shouldSkip)

        where:
            doomsDayValue | shouldSkip
            '2985-05-28'  | true
            '1985-05-28'  | false
    }

    def "spec skip is set to #shouldSkip cos doomsday is #doomsDayValue"(String doomsDayValue,
                                                                         boolean shouldSkip) {

        DoomsdayExtension extension = new DoomsdayExtension()
        FeatureInfo featureInfo = Mock(FeatureInfo)
        DoomsDay doomsDay = Mock(DoomsDay)
        doomsDay.value() >> doomsDayValue

        when:
            extension.visitFeatureAnnotation(doomsDay, featureInfo)

        then:
            1 * featureInfo.setSkipped(shouldSkip)

        where:
            doomsDayValue | shouldSkip
            '2985-05-28'  | true
            '1985-05-28'  | false
    }

}
