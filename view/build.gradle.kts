plugins {
    id("mqx.lib")
    id("mqx.view")
}
dependencies {
    implementation(project(":mq:rabbit"))
}
