plugins {
    id("mqx.application")
    id("mqx.view")
}
dependencies {
    implementation(project(":mq:rabbit"))
    implementation(project(":view"))
}

//application {
//    mainClass.set("xyz.dava.mqx.Main")
//}
