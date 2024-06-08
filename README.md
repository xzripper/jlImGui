<h1 align="center">jlImGui (Jaylib ImGui).</h1><p align="center"><img src="https://github.com/violent-studio/jlImGui/assets/94743980/be876982-f262-488a-bfa5-6d53ffd31650"></p>

```java
import static com.raylib.Raylib.InitWindow;
import static com.raylib.Raylib.SetTargetFPS;
import static com.raylib.Raylib.WindowShouldClose;
import static com.raylib.Raylib.BeginDrawing;
import static com.raylib.Raylib.ClearBackground;
import static com.raylib.Raylib.EndDrawing;
import static com.raylib.Raylib.CloseWindow;

import static com.raylib.Jaylib.BLACK;

import jlImGui.JaylibImGui;

import imgui.ImGui;

public class SourceBunnyHopSimulator {
    public static void main(String[] args) {
        InitWindow(1600, 800, "Window!"); // Initialization.

        SetTargetFPS(60);

        JaylibImGui.setupImGui(330); // Setup ImGui (330 - GLSL Version).

        while (!WindowShouldClose()) {
            BeginDrawing();

            ClearBackground(BLACK);

            JaylibImGui.process(); // Process keyboard/mouse/etc.

            ImGui.newFrame(); // Create new ImGui frame.

            ImGui.showDemoWindow(); // Show Demo Window.

            ImGui.endFrame(); // End ImGui frame.

            JaylibImGui.render(); // Render ImGui & draw data.

            EndDrawing();
        }

        JaylibImGui.disposeNDestroy(); // Dispose and destroy ImGui context.

        CloseWindow();
    }
}
```

<h3>Specification.</h3>
<ul>
  <li>Java version used in jlImGui: <code>8+</code>.</li>
  <li>lwjgl version used in jlImGui: <code>3.3.3</code>.</li>
  <li>Raylib version used in jlImGui: <code>4.5</code> (can be lower).</li>
  <li><a href="https://github.com/SpaiR/imgui-java">imgui-java</a> version used in jlImGui: <code>1.86.11-all</code>.</li>
  <li>imgui version used (and supported) in jlImGui: <code>1.86</code>.</li>
  <li>jlImGui version: <code>1.0.0</code>.</li>
</ul>

<h3>Integration.</h3>
To integrate <code>jlImGui</code> into your Java project you have to install <a href="https://github.com/violent-studio/jlImGui/releases/latest">latest</a> version of <code>jlImGui</code> (.zip), unzip folder (<code>jlImGui</code>) to your project main directory, after unzip <code>imgui-app-1.86.11-all.jar</code> to your project and add as a depedency in your editor/IDEA/terminal. It's important to add Raylib as a depedency too before running the code.

<h3>Knows issues / TODO.</h3>
<ul>
  <li>Font loading issue: impossible to use custom font in ImGui window (research needed).</li>
  <li>No gamepad support: <code>jlImGui</code> does not provide gamepad support for ImGui.</li>
  <li>Window resize issue: While resizing Raylib window, ImGui window begins to stretch and restores only after resizing operation stopped.</li>
  <li>Window size issue: ImGui mouse Y coordinate is being higher than actual mouse position if Raylib window height is larger than monitor height. Potential fix is to make sure to normalize window size/position in your code.</li>
  <li>No documentation: Create simple project documentation.</li>
</ul>

<h3>Contribution & License</h3>
Feel free to open issues and pull new requests to this project, we will make this project even better! This project has <code>MIT</code> license, it means you can do everything you want with it.

<hr><p align="center">JlImGui V1.0.0</p>
