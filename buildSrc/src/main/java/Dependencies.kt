
object Versions {
    const val kotlin = "1.4.32"
    const val kotlinxCoroutines = "1.4.3-native-mt"
    const val apollo = "2.5.6"

    const val compose = "1.0.0-beta06"
    const val nav_compose = "1.0.0-alpha10"
    const val accompanist = "0.9.0"

    const val junit = "4.13"
}


object AndroidSdk {
    const val min = 24
    const val compile = 29
    const val target = compile
}

object Deps {
    const val apolloRuntime = "com.apollographql.apollo:apollo-runtime-kotlin:${Versions.apollo}"
}

object Compose {
    const val ui = "androidx.compose.ui:ui:${Versions.compose}"
    const val runtime = "androidx.compose.runtime:runtime:${Versions.compose}"
    const val uiGraphics = "androidx.compose.ui:ui-graphics:${Versions.compose}"
    const val uiTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
    const val foundationLayout = "androidx.compose.foundation:foundation-layout:${Versions.compose}"
    const val material = "androidx.compose.material:material:${Versions.compose}"
    const val navigation = "androidx.navigation:navigation-compose:${Versions.nav_compose}"
}

object Google {
    object Accompanist {
        const val coil = "com.google.accompanist:accompanist-coil:${Versions.accompanist}"
        const val insets = "com.google.accompanist:accompanist-insets:${Versions.accompanist}"
    }
}


