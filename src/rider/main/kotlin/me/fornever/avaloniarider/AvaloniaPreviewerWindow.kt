package me.fornever.avaloniarider.me.fornever.avaloniarider

import javafx.application.Platform
import javafx.embed.swing.JFXPanel
import javafx.scene.Scene
import javafx.scene.web.WebView
import java.awt.FlowLayout
import java.net.URI
import javax.swing.JFrame

class AvaloniaPreviewerWindow : JFrame("Avalonia Previewer") {

    private lateinit var webView: WebView
    init {
        layout = FlowLayout()
        contentPane.add(JFXPanel().apply {
            Platform.runLater {
                scene = createScene()
            }
        })
    }

    private fun createScene(): Scene {
        webView = WebView().apply {
            engine.loadContent("Waiting for Avalonia Previewer process…")
        }

        return Scene(webView)
    }

    fun connectTo(uri: URI) {
        Platform.runLater {
            webView.engine.load(uri.toString())
        }
    }
}
