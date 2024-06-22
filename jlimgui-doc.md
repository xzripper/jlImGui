<h3 align="center">JlImGui Documentation.</h3><hr>

- `JaylibImGui` :<br>ImGui binding for Raylib bindings for Java.
  - `public static String jlImGuiVersion` = `1.2.1` :<br>JlImGui Version.
 
  - `public static void setupImGui(int glslV, String font, int fontSize, boolean useIni)` :<br>Setup ImGui;
    - `glslV` - Integer; GLSL Version (`330` / `100`).
    - `font` - String; Path to font.
    - `fontSize` - Integer; Font size in pixels.
    - `useIni` - String; Use Ini savefiles?

  - `public static void setupImGui(int glslV, String font, int fontSize)` :<br>Setup ImGui; Set `useIni` to `false` by default.
    - `glslV` - Integer; GLSL Version (`330` / `100`).
    - `font` - String; Path to font.
    - `fontSize` - Integer; Font size in pixels.

  - `public static void setupImGui(int glslV)` :<br>Setup ImGui; Set `font` to `null` and `fontSize` to `0` by default; Set `useIni` to `false` by default.
    - `glslV` - Integer; GLSL Version (`330` / `100`).

  - `public static void setupImGui()` :<br>Setup ImGui; Set `glslV` to `330`; Set `font` to `null` and `fontSize` to `0` by default; Set `useIni` to `false` by default.

  - `public static void process()` :<br>Process ImGui things (keyboard/mouse/deltas/etc).

  - `public static void render()` :<br>Render ImGui window & draw data.

  - `public static void image(Image image, float width, float height)` :<br>Draw ImGui image (`ImGui::Image`).
    - `image` - Image (Raylib); Image class.
    - `width` - Float; Image width.
    - `height` - Float; Image height.

  - `public static void image(Image image, float width, float height, float[] tint, float[] border)` :<br>Draw ImGui image (`ImGui::Image`).
    - `image` - Image (Raylib); Image class.
    - `width` - Float; Image width.
    - `height` - Float; Image height.
    - `tint` - Float Array; Image tint color (use `JaylibImGui::color`).
    - `border` - Float Array; Image border color (use `JaylibImGui::color`).

  - `public static void image(Texture texture, float width, float height)` :<br>Draw ImGui image (`ImGui::Image`).
    - `texture` - Texture (Raylib); Texture class.
    - `width` - Float; Image width.
    - `height` - Float; Image height.

  - `public static void image(Texture texture, float width, float height, float[] tint, float[] border)` :<br>Draw ImGui image (`ImGui::Image`).
    - `texture` - Texture (Raylib); Texture class.
    - `width` - Float; Image width.
    - `height` - Float; Image height.
    - `tint` - Float Array; Image tint color (use `JaylibImGui::color`).
    - `border` - Float Array; Image border color (use `JaylibImGui::color`).

  - `public static void imageButton(Image image, float width, float height)` :<br>Draw ImGui image button (`ImGui::ImageButton`).
    - `image` - Image (Raylib); Image class.
    - `width` - Float; Image width.
    - `height` - Float; Image height.

  - `public static void imageButton(Image image, float width, float height, int borderSize, float[] tint, float[] border)` :<br>Draw ImGui image button (`ImGui::ImageButton`).
    - `image` - Image (Raylib); Image class.
    - `width` - Float; Image width.
    - `height` - Float; Image height.
    - `borderSize` - Int; Border size.
    - `tint` - Float Array; Image tint color (use `JaylibImGui::color`).
    - `border` - Float Array; Image border color (use `JaylibImGui::color`).

  - `public static void imageButton(Texture texture, float width, float height)` :<br>Draw ImGui image button (`ImGui::ImageButton`).
    - `texture` - Texture (Raylib); Texture class.
    - `width` - Float; Image width.
    - `height` - Float; Image height.

  - `public static void imageButton(Texture texture, float width, float height, int borderSize, float[] tint, float[] border)` :<br>Draw ImGui image button (`ImGui::ImageButton`).
    - `texture` - Texture (Raylib); Texture class.
    - `width` - Float; Image width.
    - `height` - Float; Image height.
    - `borderSize` - Int; Border size;
    - `tint` - Float Array; Image tint color (use `JaylibImGui::color`).
    - `border` - Float Array; Image border color (use `JaylibImGui::color`).

  - `public static float[] color(int r, int g, int b, int a)` :<br>Create RGBA (0-255) color array translated into GL color space (0.0-1.0).
    - `r` - Int; Red.
    - `g` - Int; Green.
    - `b` - Int; Blue.
    - `a` - Int; Alpha.

  - `public static void disposeNDestroy()` :<br>Disponse and destroy ImGui context.

  - `public static ImGuiIO getIO()` :<br>Get ImGui IO (`imgui-java` class).

  - `public static ImGuiImplGl3 getGl3Impl()` :<br>Get GL ImGui implementation (`imgui-java` class).

  - `public static int[] getKeysMap()` :<br>Get Raylib keys map.

  - `public static String getVersion()` :<br>Get JlImGui version.

<hr><p align="center"><b>JlImGui v1.2.1</b></p>
