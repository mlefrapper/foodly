// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    dependencies {
        classpath(libs.spotless.plugin.gradle)
        classpath(libs.gradle.versions.plugin)
        classpath(libs.dependency.check.gradle)
    }
}
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    id("com.diffplug.spotless") version "6.19.0" apply false
    id("com.github.ben-manes.versions") version "0.51.0" apply false
    id("com.google.dagger.hilt.android") version "2.52" apply false
    id("org.owasp.dependencycheck") version "8.0.1"
}

subprojects {
    afterEvaluate {
        project.apply("../spotless.gradle")
    }
}

allprojects {
    apply<com.github.benmanes.gradle.versions.VersionsPlugin>()
}