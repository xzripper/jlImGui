<h1 align="center">JlImGui.</h1><p align="center"><a href="https://github.com/xzripper/gsdk/tree/main/gsdk/r_utilities/shader_playground"><img src="https://github.com/xzripper/gsdk/blob/main/gsdk/r_utilities/shader_playground/utility.png?raw=true"></a></p>

```java
import com.raylib.Raylib;

import static com.raylib.Jaylib.BLACK;

import jlImGui.JaylibImGui;

import imgui.ImGui;

public class Main {
    public static void main(String[] args) {
        Raylib.InitWindow(1600, 800, "Window!"); // Initialization.

        Raylib.SetTargetFPS(60);

        JaylibImGui.setupImGui(); // Setup ImGui.

        while (!Raylib.WindowShouldClose()) {
            Raylib.BeginDrawing();

            Raylib.ClearBackground(BLACK);

            JaylibImGui.process(); // Process keyboard/mouse/etc.

            ImGui.newFrame(); // Create new ImGui frame.

            ImGui.showDemoWindow(); // Show Demo Window.

            ImGui.endFrame(); // End ImGui frame.

            JaylibImGui.render(); // Render ImGui & draw data.

            Raylib.EndDrawing();
        }

        JaylibImGui.disposeNDestroy(); // Dispose and destroy ImGui context.

        Raylib.CloseWindow();
    }
}
```

<h3>Specification.</h3>
<ul>
  <li>Java version used in jlImGui: <code>8+</code>.</li>
  <li>lwjgl version used in jlImGui: <code>3.3.3</code>.</li>
  <li>Raylib version used in JlImGui: <code>4.5</code> (can be lower/higher).</li>
  <li><a href="https://github.com/SpaiR/imgui-java">imgui-java</a> version used in jlImGui: <code>1.86.11-all</code>.</li>
  <li>ImGui version used (and supported) in jlImGui: <code>1.86</code>.</li>
  <li>JlImGui version: <code>1.2.1</code>.</li>
</ul>

<h3>Integration.</h3>
To integrate <code>jlImGui</code> into your Java project you have to install <a href="https://github.com/violent-studio/jlImGui/releases/latest">latest</a> version of <code>jlImGui</code> (.zip), unzip folder (<code>jlImGui</code>) to your project main directory, after unzip <code>imgui-app-1.86.11-all.jar</code> to your project and add as a dependency in your editor/IDEA/terminal. It's important to add Raylib as a dependency too before running the code.

<h3>Knows issues / TODO.</h3>
<ul>
  <li>No gamepad support: <code>jlImGui</code> does not provide gamepad support for ImGui.</li>
</ul>

<h3>Contribution & License</h3>
Feel free to open issues and pull new requests to this project, we will make this project even better! This project has <code>MIT</code> license, it means you can do everything you want with it.

<hr><p align="center"><b>JlImGui V1.2.1</b></p>
