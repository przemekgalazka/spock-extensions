package com.geodevv.testing.spockextensions.doomsday

import org.spockframework.runtime.extension.ExtensionAnnotation

import java.lang.annotation.ElementType
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import java.lang.annotation.Target

/**
 * Annotation could be used to skip tests till doomsday - format yyyy-MM-dd
 */
@Retention(RetentionPolicy.RUNTIME)
@Target([ElementType.TYPE, ElementType.METHOD])
@ExtensionAnnotation(DoomsdayExtension)
@interface DoomsDay {

    /**
     * @return date in format yyyy-MM-dd
     */
    String value()
}

