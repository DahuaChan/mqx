plugins {
    id("mqx.common")
    id("org.openjfx.javafxplugin")
}

dependencies {
    implementation("no.tornado:tornadofx:1.7.20")
    implementation("io.github.mkpaz:atlantafx-base:1.2.0")
}

javafx {
    version = "17"
    modules("javafx.controls", "javafx.fxml")
//    configuration = "compileOnly"
}
