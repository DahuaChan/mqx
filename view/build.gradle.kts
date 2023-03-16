plugins {
    id("mqx.lib")
    id("mqx.view")
}
dependencies {
    implementation(project(":mq:rabbit"))
    api(files("libs/scenicview.jar"))
    implementation("com.github.Stars-One:IconTextFx:1.2")
}
