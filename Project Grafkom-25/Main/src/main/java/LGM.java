import Engine.*;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;

public class LGM {
    private Window window = new Window(800, 800, "LGM Main");
    ArrayList<LGM_Object> LGMO = new ArrayList<>();
    Camera camera = new Camera();
    Projection projection = new Projection(window.getWidth(), window.getHeight());

    public void run() {
        init();
        loop();
        // Terminate GLFW and free the error callback
        glfwTerminate();
        glfwSetErrorCallback(null).free();

    }

    public void init() {
        window.init();
        GL.createCapabilities();
        glEnable(GL_DEPTH_TEST);
        glHint(GL_PERSPECTIVE_CORRECTION_HINT, GL_NICEST);
        glDepthMask(true);
        glDepthFunc(GL_LEQUAL);
        glDepthRange(0.0f, 1.0f);
        // code dst jangan ditaruh diatas code diatas
        camera.setPosition(-0.12f, -0.7f, 8.54f);
        camera.setRotation((float) Math.toRadians(0.0f), (float) Math.toRadians(0.0f));

        //Head
        LGMO.add(new LGM_Object(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(188/255f, 209/255f, 75/255f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                1.0f,
                0.5f,
                0.6f,
                90, // Stack -->
                45, // Sector --> Titik
                0));
        LGMO.get(0).translateObject(0.0f, 0.0f, -0.2f);
        //LGMO.get(0).scaleObject(1.0f, 1.0f, 1.0f);


        // Badan Antena
        LGMO.get(0).getChildObject().add(new LGM_Object(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(188/255f, 209/255f, 75/255f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.1f,
                0.1f,
                0.4f,
                15, // Stack -->
                30, // Sector --> Titik
                1));
        LGMO.get(0).getChildObject().get(0).translateObject(0.0f, 0.0f, 0.9f);
        LGMO.get(0).getChildObject().get(0).rotateObject(4.75f, 1f, 0f, 0f);

        // Fondasi Antena
        LGMO.get(0).getChildObject().add(new LGM_Object(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(188/255f, 209/255f, 75/255f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.04f,
                0.04f,
                0.05f,
                15, // Stack -->
                30, // Sector --> Titik
                2));
        LGMO.get(0).getChildObject().get(1).rotateObject(1.55f, 1f, 0f, 0f);
        LGMO.get(0).getChildObject().get(1).translateObject(0.0f, 0.7f, 0.0f);

        // Top of Antena
        LGMO.get(0).getChildObject().add(new LGM_Object(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(188/255f, 209/255f, 75/255f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.15f,
                0.15f,
                0.15f,
                90, // Stack -->
                45, // Sector --> Titik
                0));
        LGMO.get(0).getChildObject().get(2).translateObject(0.00f, 1.4f, -0.15f);

        //White Eye Middle
        LGMO.get(0).getChildObject().add(new LGM_Object(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(255/255f, 255/255f, 255/255f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.25f,
                0.15f,
                0.15f,
                90, // Stack -->
                45, // Sector --> Titik
                0));
        LGMO.get(0).getChildObject().get(3).translateObject(0.00f, 0.25f, 0.35f);

        //Black Eye Middle
        LGMO.get(0).getChildObject().get(3).getChildObject().add(new LGM_Object(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(0/255f, 0/255f, 0/255f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.05f,
                0.05f,
                0.05f,
                90, // Stack -->
                45, // Sector --> Titik
                0));
        LGMO.get(0).getChildObject().get(3).getChildObject().get(0).translateObject(0.00f, 0.2f, 0.50f);

        //White Eye Left
        LGMO.get(0).getChildObject().add(new LGM_Object(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(255/255f, 255/255f, 255/255f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.25f,
                0.15f,
                0.15f,
                90, // Stack -->
                45, // Sector --> Titik
                0));
        LGMO.get(0).getChildObject().get(4).rotateObject(0.4f, 0f, 0f, 1f);
        LGMO.get(0).getChildObject().get(4).translateObject(-0.495f, 0.19f, 0.35f);

        //Black Eye Left
        LGMO.get(0).getChildObject().get(4).getChildObject().add(new LGM_Object(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(0/255f, 0/255f, 0/255f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.05f,
                0.05f,
                0.05f,
                90, // Stack -->
                45, // Sector --> Titik
                0));
        //.rotateObject(0.4f, 0f, 0f, 1f);
        LGMO.get(0).getChildObject().get(4).getChildObject().get(0).translateObject(-0.465f, 0.15f, 0.50f);

        //White Eye Right
        LGMO.get(0).getChildObject().add(new LGM_Object(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(255/255f, 255/255f, 255/255f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.25f,
                0.15f,
                0.15f,
                90, // Stack -->
                45, // Sector --> Titik
                0));
        LGMO.get(0).getChildObject().get(5).rotateObject(-0.4f, 0f, 0f, 1f);
        LGMO.get(0).getChildObject().get(5).translateObject(0.495f, 0.19f, 0.35f);

        //Black Eye Right
        LGMO.get(0).getChildObject().get(5).getChildObject().add(new LGM_Object(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(0/255f, 0/255f, 0/255f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.05f,
                0.05f,
                0.05f,
                90, // Stack -->
                45, // Sector --> Titik
                0));
        //.rotateObject(-0.4f, 0f, 0f, 1f);
        LGMO.get(0).getChildObject().get(5).getChildObject().get(0).translateObject(0.465f, 0.15f, 0.50f);

        //Ear Right
        LGMO.get(0).getChildObject().add(new LGM_Object(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(188/255f, 209/255f, 75/255f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.6f,
                0.6f,
                0.6f,
                15, // Stack -->
                30, // Sector --> Titik
                6));
        LGMO.get(0).getChildObject().get(6).rotateObject(-1.2f, 0f, 0f, 1f);
        LGMO.get(0).getChildObject().get(6).translateObject(0.6f, 0.275f, 0f);
        //Ear Lobe Right
        LGMO.get(0).getChildObject().get(6).getChildObject().add(new LGM_Object(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(150/255f, 160/255f, 75/255f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.3f,
                0.3f,
                0.1f,
                15, // Stack -->
                30, // Sector --> Titik
                6));
        LGMO.get(0).getChildObject().get(6).getChildObject().get(0).rotateObject(-1.2f, 0f, 0f, 1f);
        LGMO.get(0).getChildObject().get(6).getChildObject().get(0).translateObject(0.65f, 0.35f, 0.35f);
        //Ear Left
        LGMO.get(0).getChildObject().add(new LGM_Object(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(188/255f, 209/255f, 75/255f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.6f,
                0.6f,
                0.6f,
                15, // Stack -->
                30, // Sector --> Titik
                6));
        LGMO.get(0).getChildObject().get(7).rotateObject(-0.4f, 0f, 0f, 1f);
        LGMO.get(0).getChildObject().get(7).translateObject(-0.6f, 0.275f, 0f);
        //Ear Lobe Left
        LGMO.get(0).getChildObject().get(7).getChildObject().add(new LGM_Object(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(150/255f, 160/255f, 75/255f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.3f,
                0.3f,
                0.1f,
                15, // Stack -->
                30, // Sector --> Titik
                6));
        LGMO.get(0).getChildObject().get(7).getChildObject().get(0).rotateObject(-0.4f, 0f, 0f, 1f);
        LGMO.get(0).getChildObject().get(7).getChildObject().get(0).translateObject(-0.65f, 0.35f, 0.35f);
        // Mulut
        LGMO.get(0).getChildObject().add(new LGM_Object(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(0/255f, 0/255f, 0/255f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.07f,
                0.01f,
                0.002f,
                100, // Stack -->
                50, // Sector --> Titik
                7));
        LGMO.get(0).getChildObject().get(8).translateObject(0f, -0.25f, 0.52f);

        //Purple Neck
        LGMO.get(0).getChildObject().add(new LGM_Object(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(116/255f, 71/255f, 158/255f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.45f,
                0.225f,
                0.10f,
                90, // Stack -->
                45, // Sector --> Titik
                4));
        LGMO.get(0).getChildObject().get(9).rotateObject(1.55f, 1f, 0f, 0f);
        LGMO.get(0).getChildObject().get(9).translateObject(0.00f, -0.32f, 0.0f);

        // Badan Atas Alien
        LGMO.get(0).getChildObject().add(new LGM_Object(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(23/255f, 114/255f, 255/255f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.8f,
                0.5f,
                0.25f,
                15, // Stack -->
                30, // Sector --> Titik
                1));
        LGMO.get(0).getChildObject().get(10).rotateObject(1.55f, 1f, 0f, 0f);
        LGMO.get(0).getChildObject().get(10).translateObject(0f, -0.67f, 0f);
        // Sabuk Child
        LGMO.get(0).getChildObject().get(10).getChildObject().add(new LGM_Object(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(51/255f, 56/255f, 120/255f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.85f,
                0.60f,
                0.15f,
                15, // Stack -->
                30, // Sector --> Titik
                1));
        LGMO.get(0).getChildObject().get(10).getChildObject().get(0).rotateObject(1.55f, 1f, 0f, 0f);
        LGMO.get(0).getChildObject().get(10).getChildObject().get(0).translateObject(0.0f, -0.95f, 0.0f);
        // Sabuk Child
        LGMO.get(0).getChildObject().get(10).getChildObject().add(new LGM_Object(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(5/255f, 33/255f, 90/255f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.55f,
                0.10f,
                0.3f,
                15, // Stack -->
                30, // Sector --> Titik
                3));
        LGMO.get(0).getChildObject().get(10).getChildObject().get(1).rotateObject(1.55f, 1f, 0f, 0f);
        LGMO.get(0).getChildObject().get(10).getChildObject().get(1).translateObject(0.0f, -0.925f, 0.65f);

        // Gambar Planet Kuning
        LGMO.get(0).getChildObject().get(10).getChildObject().add(new LGM_Object(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(188/255f, 157/255f, 126/255f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.15f,
                0.15f,
                0.025f,
                15, // Stack -->
                30, // Sector --> Titik
                0));
        LGMO.get(0).getChildObject().get(10).getChildObject().get(2).translateObject(0.3f, -0.6f, 0.294f);

        // Gambar Planet Biru
        LGMO.get(0).getChildObject().get(10).getChildObject().add(new LGM_Object(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(23/255f, 114/255f, 255/255f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.137f,
                0.137f,
                0.025f,
                15, // Stack -->
                30, // Sector --> Titik
                0));
        LGMO.get(0).getChildObject().get(10).getChildObject().get(3).translateObject(0.3f, -0.6f, 0.298f);
        // Gambar Ring Planet
        LGMO.get(0).getChildObject().get(10).getChildObject().add(new LGM_Object(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(188/255f, 157/255f, 126/255f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.1f,
                0.025f,
                0.025f,
                15, // Stack -->
                30, // Sector --> Titik
                5));
        LGMO.get(0).getChildObject().get(10).getChildObject().get(4).rotateObject(1.6f, 1f, 0f, 0f);
        LGMO.get(0).getChildObject().get(10).getChildObject().get(4).rotateObject(0.2f, 0f, 0f, 1f);
        LGMO.get(0).getChildObject().get(10).getChildObject().get(4).translateObject(0.3f, -0.6f, 0.45f);


        // Badan Bawah Alien
        LGMO.get(0).getChildObject().add(new LGM_Object(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(23/255f, 114/255f, 255/255f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.80f,
                0.55f,
                0.125f,
                15, // Stack -->
                30, // Sector --> Titik
                1));
        LGMO.get(0).getChildObject().get(11).rotateObject(1.55f, 1f, 0f, 0f);
        LGMO.get(0).getChildObject().get(11).translateObject(0f, -1.135f, 0f);

        // Paha Kiri Besar
        LGMO.get(0).getChildObject().add(new LGM_Object(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(23/255f, 114/255f, 255/255f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.475f,
                0.4f,
                0.2f,
                15, // Stack -->
                30, // Sector --> Titik
                1));
        LGMO.get(0).getChildObject().get(12).rotateObject(1.55f, 1f, 0f, 0f);
        LGMO.get(0).getChildObject().get(12).translateObject(-0.3f, -1.335f, 0f);
        // Kaki Kiri
        LGMO.get(0).getChildObject().get(12).getChildObject().add(new LGM_Object(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(9/255f, 42/255f, 103/255f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.525f,
                0.5f,
                0.125f,
                100, // Stack -->
                50, // Sector --> Titik
                0));
        LGMO.get(0).getChildObject().get(12).getChildObject().get(0).rotateObject(1.55f, 1f, 0f, 0f);
        LGMO.get(0).getChildObject().get(12).getChildObject().get(0).translateObject(-0.3f, -1.635f, 0f);
        // Paha Kiri Kecil
        LGMO.get(0).getChildObject().get(12).getChildObject().add(new LGM_Object(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(23/255f, 114/255f, 255/255f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.425f,
                0.4f,
                0.125f,
                15, // Stack -->
                30, // Sector --> Titik
                1));
        LGMO.get(0).getChildObject().get(12).getChildObject().get(1).rotateObject(1.55f, 1f, 0f, 0f);
        LGMO.get(0).getChildObject().get(12).getChildObject().get(1).translateObject(-0.3f, -1.635f, 0f);

        // Paha Kanan Besar
        LGMO.get(0).getChildObject().add(new LGM_Object(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(23/255f, 114/255f, 255/255f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.475f,
                0.4f,
                0.2f,
                15, // Stack -->
                30, // Sector --> Titik
                1));
        LGMO.get(0).getChildObject().get(13).rotateObject(1.55f, 1f, 0f, 0f);
        LGMO.get(0).getChildObject().get(13).translateObject(0.3f, -1.335f, 0f);
        // Kaki Kanan
        LGMO.get(0).getChildObject().get(13).getChildObject().add(new LGM_Object(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(9/255f, 42/255f, 103/255f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.525f,
                0.5f,
                0.125f,
                100, // Stack -->
                50, // Sector --> Titik
                0));
        LGMO.get(0).getChildObject().get(13).getChildObject().get(0).rotateObject(1.55f, 1f, 0f, 0f);
        LGMO.get(0).getChildObject().get(13).getChildObject().get(0).translateObject(0.3f, -1.635f, 0f);
        // Paha Kanan Kecil
        LGMO.get(0).getChildObject().get(13).getChildObject().add(new LGM_Object(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(23/255f, 114/255f, 255/255f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.425f,
                0.4f,
                0.125f,
                15, // Stack -->
                30, // Sector --> Titik
                1));
        LGMO.get(0).getChildObject().get(13).getChildObject().get(1).rotateObject(1.55f, 1f, 0f, 0f);
        LGMO.get(0).getChildObject().get(13).getChildObject().get(1).translateObject(0.3f, -1.635f, 0f);

        // Lengan Kiri
        LGMO.get(0).getChildObject().add(new LGM_Object(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(23/255f, 114/255f, 255/255f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.2f,
                0.2f,
                0.8f,
                15, // Stack -->
                30, // Sector --> Titik
                1));
        LGMO.get(0).getChildObject().get(14).rotateObject(1.6f, 0f, 1f, 0f);
        LGMO.get(0).getChildObject().get(14).rotateObject(1f, 0f, 0f, -1f);
        LGMO.get(0).getChildObject().get(14).rotateObject(0.3f, 0f, 0f, 1f);
        LGMO.get(0).getChildObject().get(14).translateObject(-1.0f, -0.4f, 0f);
        // Telapak Kiri
        LGMO.get(0).getChildObject().get(14).getChildObject().add(new LGM_Object(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(188/255f, 209/255f, 75/255f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.3f,
                0.3f,
                0.3f,
                100, // Stack -->
                50, // Sector --> Titik
                0));
        LGMO.get(0).getChildObject().get(14).getChildObject().get(0).rotateObject(1.6f, 0f, 1f, 0f);
        LGMO.get(0).getChildObject().get(14).getChildObject().get(0).translateObject(-1.9f, 0.22f, 0f);

        // Jari Kiri1
        LGMO.get(0).getChildObject().get(14).getChildObject().add(new LGM_Object(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(188/255f, 209/255f, 75/255f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.01f,
                0.01f,
                0.005f,
                100, // Stack -->
                50, // Sector --> Titik
                7));
        LGMO.get(0).getChildObject().get(14).getChildObject().get(1).rotateObject(-1.5f, 0f, 0f, 1f);
        LGMO.get(0).getChildObject().get(14).getChildObject().get(1).translateObject(-2.3f, 0.22f, 0f);

        // Jari Kiri2
        LGMO.get(0).getChildObject().get(14).getChildObject().add(new LGM_Object(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(188/255f, 209/255f, 75/255f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.01f,
                0.01f,
                0.005f,
                100, // Stack -->
                50, // Sector --> Titik
                7));
        LGMO.get(0).getChildObject().get(14).getChildObject().get(2).rotateObject(-2.1f, 0f, 0f, 1f);
        LGMO.get(0).getChildObject().get(14).getChildObject().get(2).translateObject(-2.3f, 0.675f, 0f);

        // Jari Kiri3
        LGMO.get(0).getChildObject().get(14).getChildObject().add(new LGM_Object(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(188/255f, 209/255f, 75/255f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.0175f,
                0.0175f,
                0.00425f,
                100, // Stack -->
                50, // Sector --> Titik
                7));
        LGMO.get(0).getChildObject().get(14).getChildObject().get(3).rotateObject(-3.3f, 0f, 0f, 1f);
        LGMO.get(0).getChildObject().get(14).getChildObject().get(3).translateObject(-1.6f, 0.7f, 0f);

        // Lengan Kanan
        LGMO.get(0).getChildObject().add(new LGM_Object(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(23/255f, 114/255f, 255/255f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.2f,
                0.2f,
                0.8f,
                15, // Stack -->
                30, // Sector --> Titik
                1));
        LGMO.get(0).getChildObject().get(15).rotateObject(1.6f, 0f, 1f, 0f);
        LGMO.get(0).getChildObject().get(15).rotateObject(1f, 0f, 0f, 1f);
        LGMO.get(0).getChildObject().get(15).rotateObject(0.3f, 0f, 0f, -1f);
        LGMO.get(0).getChildObject().get(15).translateObject(1.0f, -0.4f, 0f);

        // Telapak Kanan
        LGMO.get(0).getChildObject().get(15).getChildObject().add(new LGM_Object(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(188/255f, 209/255f, 75/255f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.3f,
                0.3f,
                0.3f,
                100, // Stack -->
                50, // Sector --> Titik
                0));
        LGMO.get(0).getChildObject().get(15).getChildObject().get(0).translateObject(1.75f, 0.28f, -0.25f);


        // Jari Kanan1
        LGMO.get(0).getChildObject().get(15).getChildObject().add(new LGM_Object(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(188/255f, 209/255f, 75/255f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.01f,
                0.01f,
                0.005f,
                100, // Stack -->
                50, // Sector --> Titik
                7));
        LGMO.get(0).getChildObject().get(15).getChildObject().get(1).rotateObject(1.9f, 0f, 0f, 1f);
        LGMO.get(0).getChildObject().get(15).getChildObject().get(1).translateObject(2.3f, 0.475f, 0f);

        // Jari Kanan2
        LGMO.get(0).getChildObject().get(15).getChildObject().add(new LGM_Object(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(188/255f, 209/255f, 75/255f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.01f,
                0.01f,
                0.005f,
                100, // Stack -->
                50, // Sector --> Titik
                7));
        LGMO.get(0).getChildObject().get(15).getChildObject().get(2).rotateObject(2.4f, 0f, 0f, 1f);
        LGMO.get(0).getChildObject().get(15).getChildObject().get(2).translateObject(2.1f, 0.8f, 0f);


        // Jari Kanan3
        LGMO.get(0).getChildObject().get(15).getChildObject().add(new LGM_Object(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(188/255f, 209/255f, 75/255f, 1.0f),
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.0175f,
                0.0175f,
                0.00425f,
                100, // Stack -->
                50, // Sector --> Titik
                7));
        LGMO.get(0).getChildObject().get(15).getChildObject().get(3).rotateObject(3.4f, 0f, 0f, 1f);
        LGMO.get(0).getChildObject().get(15).getChildObject().get(3).translateObject(1.55f, 0.75f, 0f);



        /*
        TTSRY.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(0.0f, 0.5f, 0.5f, 1.0f),
                0.00,
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.2f,
                0.2f,
                0.2f,
                15, // Stack -->
                30, // Sector --> Titik
                2));
        TTSRY.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

                ),
                new ArrayList<>(
                ),
                new Vector4f(0.0f, 0.5f, 0.5f, 1.0f),
                0.00,
                new ArrayList<>(List.of(0.0f, 0.0f, 0.0f)),
                0.2f,
                0.2f,
                0.2f,
                15, // Stack -->
                30, // Sector --> Titik
                2));

         */

    }
    boolean kaki = true;
    int countjalan = 0;
    public void input() {

        if(window.isKeyPressed(GLFW_KEY_1)){
            LGMO.get(0).translateObject(0.002f,0.0f,0.0f);
            if(kaki) {
                countjalan++;
                Vector3f tempCenterPoint = LGMO.get(0).getChildObject().get(12).updateCenterPoint();
                LGMO.get(0).getChildObject().get(12).translateObject(-tempCenterPoint.x,-tempCenterPoint.y,-tempCenterPoint.z);
                LGMO.get(0).getChildObject().get(12).rotateObject((float) Math.toRadians(1.0f),1.0f, 1.0f, 0.0f);
                LGMO.get(0).getChildObject().get(12).translateObject(tempCenterPoint.x,tempCenterPoint.y,tempCenterPoint.z);

                Vector3f tempCenterPoint2 = LGMO.get(0).getChildObject().get(13).updateCenterPoint();
                LGMO.get(0).getChildObject().get(13).translateObject(-tempCenterPoint2.x,-tempCenterPoint2.y,-tempCenterPoint2.z);
                LGMO.get(0).getChildObject().get(13).rotateObject((float) Math.toRadians(-1.0f),1.0f, 1.0f, 0.0f);
                LGMO.get(0).getChildObject().get(13).translateObject(tempCenterPoint2.x,tempCenterPoint2.y,tempCenterPoint2.z);
                if (countjalan == 15.0f) {
                    kaki = false;
                }
            }
            else{
                countjalan--;
                Vector3f tempCenterPoint = LGMO.get(0).getChildObject().get(12).updateCenterPoint();
                LGMO.get(0).getChildObject().get(12).translateObject(-tempCenterPoint.x,-tempCenterPoint.y,-tempCenterPoint.z);
                LGMO.get(0).getChildObject().get(12).rotateObject((float) Math.toRadians(-1.0f),1.0f, 1.0f, 0.0f);
                LGMO.get(0).getChildObject().get(12).translateObject(tempCenterPoint.x,tempCenterPoint.y,tempCenterPoint.z);

                Vector3f tempCenterPoint2 = LGMO.get(0).getChildObject().get(13).updateCenterPoint();
                LGMO.get(0).getChildObject().get(13).translateObject(-tempCenterPoint2.x,-tempCenterPoint2.y,-tempCenterPoint2.z);
                LGMO.get(0).getChildObject().get(13).rotateObject((float) Math.toRadians(1.0f),1.0f, 1.0f, 0.0f);
                LGMO.get(0).getChildObject().get(13).translateObject(tempCenterPoint2.x,tempCenterPoint2.y,tempCenterPoint2.z);

                if(countjalan ==-15.0f){
                    kaki = true;
                }
            }
        }
        if(window.isKeyPressed(GLFW_KEY_2)){
            LGMO.get(0).translateObject(-0.002f,0.0f,0.0f);
            if(kaki) {
                countjalan++;
                Vector3f tempCenterPoint = LGMO.get(0).getChildObject().get(12).updateCenterPoint();
                LGMO.get(0).getChildObject().get(12).translateObject(tempCenterPoint.x*-1,tempCenterPoint.y*-1,tempCenterPoint.z*-1);
                LGMO.get(0).getChildObject().get(12).rotateObject((float) Math.toRadians(1.0f),1.0f, 1.0f, 0.0f);
                LGMO.get(0).getChildObject().get(12).translateObject(tempCenterPoint.x*1,tempCenterPoint.y*1,tempCenterPoint.z*1);

                Vector3f tempCenterPoint2 = LGMO.get(0).getChildObject().get(13).updateCenterPoint();
                LGMO.get(0).getChildObject().get(13).translateObject(tempCenterPoint2.x*-1,tempCenterPoint2.y*-1,tempCenterPoint2.z*-1);
                LGMO.get(0).getChildObject().get(13).rotateObject((float) Math.toRadians(-1.0f),1.0f, 1.0f, 0.0f);
                LGMO.get(0).getChildObject().get(13).translateObject(tempCenterPoint2.x*1,tempCenterPoint2.y*1,tempCenterPoint2.z*1);
                if (countjalan == 15.0f) {
                    kaki = false;
                }
            }
            else{
                countjalan--;
                Vector3f tempCenterPoint = LGMO.get(0).getChildObject().get(12).updateCenterPoint();
                LGMO.get(0).getChildObject().get(12).translateObject(tempCenterPoint.x*-1,tempCenterPoint.y*-1,tempCenterPoint.z*-1);
                LGMO.get(0).getChildObject().get(12).rotateObject((float) Math.toRadians(-1.0f),1.0f, 1.0f, 0.0f);
                LGMO.get(0).getChildObject().get(12).translateObject(tempCenterPoint.x*1,tempCenterPoint.y*1,tempCenterPoint.z*1);

                Vector3f tempCenterPoint2 = LGMO.get(0).getChildObject().get(13).updateCenterPoint();
                LGMO.get(0).getChildObject().get(13).translateObject(tempCenterPoint2.x*-1,tempCenterPoint2.y*-1,tempCenterPoint2.z*-1);
                LGMO.get(0).getChildObject().get(13).rotateObject((float) Math.toRadians(1.0f),1.0f, 1.0f, 0.0f);
                LGMO.get(0).getChildObject().get(13).translateObject(tempCenterPoint2.x*1,tempCenterPoint2.y*1,tempCenterPoint2.z*1);

                if(countjalan ==-15.0f){
                    kaki = true;
                }
            }
        }
        if(window.isKeyPressed(GLFW_KEY_3)){
            LGMO.get(0).translateObject(0.0f,0.0f,0.002f);
            if(kaki) {
                countjalan++;
                Vector3f tempCenterPoint = LGMO.get(0).getChildObject().get(12).updateCenterPoint();
                LGMO.get(0).getChildObject().get(12).translateObject(tempCenterPoint.x*-1,tempCenterPoint.y*-1,tempCenterPoint.z*-1);
                LGMO.get(0).getChildObject().get(12).rotateObject((float) Math.toRadians(1.0f),1.0f, 1.0f, 0.0f);
                LGMO.get(0).getChildObject().get(12).translateObject(tempCenterPoint.x*1,tempCenterPoint.y*1,tempCenterPoint.z*1);

                Vector3f tempCenterPoint2 = LGMO.get(0).getChildObject().get(13).updateCenterPoint();
                LGMO.get(0).getChildObject().get(13).translateObject(tempCenterPoint2.x*-1,tempCenterPoint2.y*-1,tempCenterPoint2.z*-1);
                LGMO.get(0).getChildObject().get(13).rotateObject((float) Math.toRadians(-1.0f),1.0f, 1.0f, 0.0f);
                LGMO.get(0).getChildObject().get(13).translateObject(tempCenterPoint2.x*1,tempCenterPoint2.y*1,tempCenterPoint2.z*1);
                if (countjalan == 15.0f) {
                    kaki = false;
                }
            }
            else{
                countjalan--;
                Vector3f tempCenterPoint = LGMO.get(0).getChildObject().get(12).updateCenterPoint();
                LGMO.get(0).getChildObject().get(12).translateObject(tempCenterPoint.x*-1,tempCenterPoint.y*-1,tempCenterPoint.z*-1);
                LGMO.get(0).getChildObject().get(12).rotateObject((float) Math.toRadians(-1.0f),1.0f, 1.0f, 0.0f);
                LGMO.get(0).getChildObject().get(12).translateObject(tempCenterPoint.x*1,tempCenterPoint.y*1,tempCenterPoint.z*1);

                Vector3f tempCenterPoint2 = LGMO.get(0).getChildObject().get(13).updateCenterPoint();
                LGMO.get(0).getChildObject().get(13).translateObject(tempCenterPoint2.x*-1,tempCenterPoint2.y*-1,tempCenterPoint2.z*-1);
                LGMO.get(0).getChildObject().get(13).rotateObject((float) Math.toRadians(1.0f),1.0f, 1.0f, 0.0f);
                LGMO.get(0).getChildObject().get(13).translateObject(tempCenterPoint2.x*1,tempCenterPoint2.y*1,tempCenterPoint2.z*1);

                if(countjalan ==-15.0f){
                    kaki = true;
                }
            }
        }
        if(window.isKeyPressed(GLFW_KEY_4)){
            LGMO.get(0).translateObject(0.0f,0.0f,-0.002f);
            if(kaki) {
                countjalan++;
                Vector3f tempCenterPoint = LGMO.get(0).getChildObject().get(12).updateCenterPoint();
                LGMO.get(0).getChildObject().get(12).translateObject(tempCenterPoint.x*-1,tempCenterPoint.y*-1,tempCenterPoint.z*-1);
                LGMO.get(0).getChildObject().get(12).rotateObject((float) Math.toRadians(1.0f),1.0f, 1.0f, 0.0f);
                LGMO.get(0).getChildObject().get(12).translateObject(tempCenterPoint.x*1,tempCenterPoint.y*1,tempCenterPoint.z*1);

                Vector3f tempCenterPoint2 = LGMO.get(0).getChildObject().get(13).updateCenterPoint();
                LGMO.get(0).getChildObject().get(13).translateObject(tempCenterPoint2.x*-1,tempCenterPoint2.y*-1,tempCenterPoint2.z*-1);
                LGMO.get(0).getChildObject().get(13).rotateObject((float) Math.toRadians(-1.0f),1.0f, 1.0f, 0.0f);
                LGMO.get(0).getChildObject().get(13).translateObject(tempCenterPoint2.x*1,tempCenterPoint2.y*1,tempCenterPoint2.z*1);
                if (countjalan == 15.0f) {
                    kaki = false;
                }
            }
            else{
                countjalan--;
                Vector3f tempCenterPoint = LGMO.get(0).getChildObject().get(12).updateCenterPoint();
                LGMO.get(0).getChildObject().get(12).translateObject(tempCenterPoint.x*-1,tempCenterPoint.y*-1,tempCenterPoint.z*-1);
                LGMO.get(0).getChildObject().get(12).rotateObject((float) Math.toRadians(-1.0f),1.0f, 1.0f, 0.0f);
                LGMO.get(0).getChildObject().get(12).translateObject(tempCenterPoint.x*1,tempCenterPoint.y*1,tempCenterPoint.z*1);

                Vector3f tempCenterPoint2 = LGMO.get(0).getChildObject().get(13).updateCenterPoint();
                LGMO.get(0).getChildObject().get(13).translateObject(tempCenterPoint2.x*-1,tempCenterPoint2.y*-1,tempCenterPoint2.z*-1);
                LGMO.get(0).getChildObject().get(13).rotateObject((float) Math.toRadians(1.0f),1.0f, 1.0f, 0.0f);
                LGMO.get(0).getChildObject().get(13).translateObject(tempCenterPoint2.x*1,tempCenterPoint2.y*1,tempCenterPoint2.z*1);

                if(countjalan ==-15.0f){
                    kaki = true;
                }
            }
        }
        if(window.isKeyPressed(GLFW_KEY_4)){
            LGMO.get(0).translateObject(0.0f,0.0f,-0.002f);
            if(kaki) {
                countjalan++;
                Vector3f tempCenterPoint = LGMO.get(0).getChildObject().get(12).updateCenterPoint();
                LGMO.get(0).getChildObject().get(12).translateObject(tempCenterPoint.x*-1,tempCenterPoint.y*-1,tempCenterPoint.z*-1);
                LGMO.get(0).getChildObject().get(12).rotateObject((float) Math.toRadians(1.0f),0.0f, 0.0f, 1.0f);
                LGMO.get(0).getChildObject().get(12).translateObject(tempCenterPoint.x*1,tempCenterPoint.y*1,tempCenterPoint.z*1);

                Vector3f tempCenterPoint2 = LGMO.get(0).getChildObject().get(13).updateCenterPoint();
                LGMO.get(0).getChildObject().get(13).translateObject(tempCenterPoint2.x*-1,tempCenterPoint2.y*-1,tempCenterPoint2.z*-1);
                LGMO.get(0).getChildObject().get(13).rotateObject((float) Math.toRadians(1.0f),0.0f, 0.0f, 1.0f);
                LGMO.get(0).getChildObject().get(13).translateObject(tempCenterPoint2.x*1,tempCenterPoint2.y*1,tempCenterPoint2.z*1);
                if (countjalan == 15.0f) {
                    kaki = false;
                }
            }
            else{
                countjalan--;
                Vector3f tempCenterPoint = LGMO.get(0).getChildObject().get(12).updateCenterPoint();
                LGMO.get(0).getChildObject().get(12).translateObject(tempCenterPoint.x*-1,tempCenterPoint.y*-1,tempCenterPoint.z*-1);
                LGMO.get(0).getChildObject().get(12).rotateObject((float) Math.toRadians(-1.0f),0.0f, 0.0f, 1.0f);
                LGMO.get(0).getChildObject().get(12).translateObject(tempCenterPoint.x*1,tempCenterPoint.y*1,tempCenterPoint.z*1);

                Vector3f tempCenterPoint2 = LGMO.get(0).getChildObject().get(13).updateCenterPoint();
                LGMO.get(0).getChildObject().get(13).translateObject(tempCenterPoint2.x*-1,tempCenterPoint2.y*-1,tempCenterPoint2.z*-1);
                LGMO.get(0).getChildObject().get(13).rotateObject((float) Math.toRadians(-1.0f),0.0f, 0.0f, 1.0f);
                LGMO.get(0).getChildObject().get(13).translateObject(tempCenterPoint2.x*1,tempCenterPoint2.y*1,tempCenterPoint2.z*1);

                if(countjalan ==-15.0f){
                    kaki = true;
                }
            }
        }
        if (window.isKeyPressed(GLFW_KEY_W)) {
            for (LGM_Object i : LGMO) {
                i.rotateObject(0.01f, 1f, 0f, 0f);
            }
        }
        if (window.isKeyPressed(GLFW_KEY_W)) {
            for (LGM_Object i : LGMO) {
                i.rotateObject(0.01f, 1f, 0f, 0f);
            }
        }
        if (window.isKeyPressed(GLFW_KEY_Q)) {
            for (LGM_Object i : LGMO) {
                i.rotateObject(0.01f, 0f, 0f, 1f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_E)) {
            for (LGM_Object i : LGMO) {
                i.rotateObject(-0.01f, 0f, 0f, 1f);
            }
        }


        if (window.isKeyPressed(GLFW_KEY_S)) {
            for (LGM_Object i : LGMO) {
                i.rotateObject(-0.01f, 1f, 0f, 0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_A)) {
            for (LGM_Object i : LGMO) {
                i.rotateObject(0.01f, 0f, 1f, 0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_D)) {
            for (LGM_Object i : LGMO) {
                i.rotateObject(-0.01f, 0f, 1f, 0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_U)) {
            for (LGM_Object i : LGMO) {
                i.translateObject(0f, 0f, 0.001f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_O)) {
            for (LGM_Object i : LGMO) {
                i.translateObject(0f, 0f, -0.001f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_I)) {
            for (LGM_Object i : LGMO) {
                i.translateObject(0f, 0.001f, 0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_K)) {
            for (LGM_Object i : LGMO) {
                i.translateObject(0f, -0.001f, 0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_J)) {
            for (LGM_Object i : LGMO) {
                i.translateObject(-0.001f, 0f, 0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_L)) {
            for (LGM_Object i : LGMO) {
                i.translateObject(0.001f, 0f, 0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_LEFT_SHIFT)) {
            camera.moveForward(0.12f);
        }

        if (window.isKeyPressed(GLFW_KEY_LEFT_CONTROL)) {
            camera.moveBackwards(0.12f);
        }
        if (window.isKeyPressed(GLFW_KEY_DOWN)) {
            camera.moveDown(0.12f);
        }

        if (window.isKeyPressed(GLFW_KEY_UP)) {
            camera.moveUp(0.12f);
        }
        if (window.isKeyPressed(GLFW_KEY_LEFT)) {
            camera.moveLeft(0.12f);
        }

        if (window.isKeyPressed(GLFW_KEY_RIGHT)) {
            camera.moveRight(0.12f);
        }
    }


    public void loop() {

        while (window.isOpen()) {
            window.update();
            glClearColor(255/255f, 255/255f, 0/255f, 1.0f); // RapidTables.com (RGB color code chart)
            GL.createCapabilities();
            glClearDepth(1.0f);
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
            input();
            LGMO.get(0).updateCenterPoint(true);

            for (LGM_Object obj3D : LGMO) {
                obj3D.draw(camera,projection);
            }
            System.out.println("X"+camera.getPosition().get(0));
            System.out.println("Y"+camera.getPosition().get(1));
            System.out.println("Z"+camera.getPosition().get(2));

            System.out.println("Ngalih kabeh kontol X" + LGMO.get(0).getCenterPoint().get(0));
            System.out.println("Ngalih kabeh kontol Y" + LGMO.get(0).getCenterPoint().get(1));
            System.out.println("Ngalih kabeh kontol Z" + LGMO.get(0).getCenterPoint().get(2));


            //Restore State
            glDisableVertexAttribArray(0);
            // Pull for window events
            // The key callback above will only be
            // invoked during this call
            glfwPollEvents();
        }
    }


    public static void main (String[]args){
        new LGM().run();
    }
}

