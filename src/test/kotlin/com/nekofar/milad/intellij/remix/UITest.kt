package com.nekofar.milad.intellij.remix

import com.automation.remarks.junit5.Video
import com.intellij.remoterobot.RemoteRobot
import com.intellij.remoterobot.search.locators.byXpath
import com.intellij.remoterobot.stepsProcessing.step
import com.intellij.remoterobot.utils.waitFor
import com.nekofar.milad.intellij.remix.fixtures.terminal
import com.nekofar.milad.intellij.remix.pages.dialog
import com.nekofar.milad.intellij.remix.pages.idea
import com.nekofar.milad.intellij.remix.pages.welcomeFrame
import com.nekofar.milad.intellij.remix.utils.RemoteRobotExtension
import com.nekofar.milad.intellij.remix.utils.StepsLogger
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder
import org.junit.jupiter.api.extension.ExtendWith
import java.time.Duration.ofSeconds

@TestMethodOrder(OrderAnnotation::class)
@ExtendWith(RemoteRobotExtension::class)
class UITest {
    init {
        StepsLogger.init()
    }

    @AfterEach
    fun closeProject(remoteRobot: RemoteRobot) = with(remoteRobot) {
        idea {
            menuBar.select("File", "Close Project")
        }
    }

    @Test
    @Video
    @Order(1)
    fun createNewProject(remoteRobot: RemoteRobot) = with(remoteRobot) {
        welcomeFrame {
            createNewProjectLink.click()
            dialog("New Project") {
                findText("JavaScript").click()
                jList(
                    byXpath(
                        "//div[contains(@visible_text_keys, 'create.react.app.name')]"
                    )
                ).clickItem("Remix")
                button("Next").click()
                button("Finish").click()
            }
        }
        idea {
            waitForFinishBackgroundTasks()
            step("Find terminal") {
                terminal().click()
            }
            step("Find config file") {
                with(projectViewTree) {
                    if (hasText("remix.config.js").not()) {
                        findText(projectName).doubleClick()
                        waitFor(ofSeconds(10)) { hasText("remix.config.js") }
                    }
                    findText("remix.config.js").click()
                }
            }
        }
    }
}