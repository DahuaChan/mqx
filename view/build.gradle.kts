plugins {
    id("mqx.lib")
    id("mqx.view")
}
dependencies {
    implementation(project(":mq:active"))
    implementation(project(":mq:rabbit"))
    api(files("libs/scenicview.jar"))
}
