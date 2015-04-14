package com.geodevv.testing.spockextensions.doomsday

import org.spockframework.runtime.extension.AbstractAnnotationDrivenExtension
import org.spockframework.runtime.model.FeatureInfo
import org.spockframework.runtime.model.SpecInfo

class DoomsdayExtension extends AbstractAnnotationDrivenExtension<DoomsDay> {

    private DoomsDayCalculator doomsdayCalculator

    DoomsdayExtension() {
        this(new DoomsDayCalculator())
    }

    DoomsdayExtension(DoomsDayCalculator doomsdayCalculator) {
        this.doomsdayCalculator = doomsdayCalculator
    }

    @Override
    void visitFeatureAnnotation(DoomsDay annotation, FeatureInfo feature) {
        def doomsDay = annotation.value()
        def isDoomsDayToday = doomsdayCalculator.isDoomsDayToday(doomsDay)
        feature.setSkipped(!isDoomsDayToday)
    }

    @Override
    void visitSpecAnnotation(DoomsDay annotation, SpecInfo spec) {
        def doomsDay = annotation.value()
        def isDoomsDayToday = doomsdayCalculator.isDoomsDayToday(doomsDay)
        spec.setSkipped(!isDoomsDayToday)
    }

}
