import Engine.*;
import Engine.Object;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;

public class BabiCeleng {
    private Window window =
            new Window(600, 600, "IAN BABI Main");
    ArrayList<Object> TTSRY = new ArrayList<>();
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

        camera.setPosition(0.0f, 0.0f, 0.5f);
        camera.setRotation((float) Math.toRadians(0.0f), (float) Math.toRadians(30.0f));
        // code dst jangan ditaruh diatas code diatas

        // Badan Babi
        TTSRY.add(new SphereBabi(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\chris\\PROJEK GRAFKOM\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\chris\\PROJEK GRAFKOM\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(1.0f, 0.6f, 0.89f, 1.0f),
                List.of(0.0f, 0.0f, 0.0f),
                0.2f,
                0.3f,
                0.2f,
                15, // Stack -->
                30, // Sector --> Titik
                3));
        TTSRY.get(0).scaleObject(1.3f, 1.3f, 1.3f);
        TTSRY.get(0).rotateObject((float)Math.toRadians(90.0f), 1.0f, 0.0f, 0.0f);
        //Kepala Babi
        TTSRY.get(0).getChildObject().add(new SphereBabi(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\chris\\PROJEK GRAFKOM\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\chris\\PROJEK GRAFKOM\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(1.0f, 0.6f, 0.89f, 1.0f),
                List.of(0.0f, 0.0f, 0.0f),
                0.2f,
                0.2f,
                0.2f,
                15, // Stack -->
                30, // Sector --> Titik
                3));
        TTSRY.get(0).getChildObject().get(0).scaleObject(1.0f, 1.0f, 1.0f);
        TTSRY.get(0).getChildObject().get(0).translateObject(0.0f, 0.075f, 0.43f);

        // Hidung babi
        TTSRY.get(0).getChildObject().get(0).getChildObject().add(new SphereBabi(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\chris\\PROJEK GRAFKOM\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\chris\\PROJEK GRAFKOM\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(1.0f, 0.6f, 0.89f, 1.0f),
                List.of(0.0f, 0.0f, 0.0f),
                0.1f,
                0.1f,
                0.115f,
                15, // Stack -->
                30, // Sector --> Titik
                2));
        TTSRY.get(0).getChildObject().get(0).getChildObject().get(0).translateObject(0.0f, 0.1f, 0.68f);
        TTSRY.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject((float) Math.toRadians(8.0f), 1.0f, 0.0f, 0.0f);

        // lubang hidung
        TTSRY.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().add(new SphereBabi(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\chris\\PROJEK GRAFKOM\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\chris\\PROJEK GRAFKOM\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(1.0f, 0.4f, 0.69f, 1.0f),
                List.of(0.0f, 0.0f, 0.0f),
                0.2f,
                0.2f,
                0.5f,
                15, // Stack -->
                30, // Sector --> Titik
                2));
        TTSRY.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).scaleObject(0.075f, 0.1f, 0.03f);
        TTSRY.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).translateObject(0.05f, 0.12f, 0.695f);
        TTSRY.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).rotateObject((float) Math.toRadians(8.0f), 1.0f, 0.0f, 0.0f);

        TTSRY.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().add(new SphereBabi(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\chris\\PROJEK GRAFKOM\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\chris\\PROJEK GRAFKOM\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(1.0f, 0.4f, 0.69f, 1.0f),
                List.of(0.0f, 0.0f, 0.0f),
                0.2f,
                0.2f,
                0.5f,
                15, // Stack -->
                30, // Sector --> Titik
                2));
        TTSRY.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(1).scaleObject(0.075f, 0.1f, 0.03f);
        TTSRY.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(1).translateObject(-0.05f, 0.12f, 0.695f);
        TTSRY.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(1).rotateObject((float) Math.toRadians(8.0f), 1.0f, 0.0f, 0.0f);

        //Mata
        TTSRY.get(0).getChildObject().get(0).getChildObject().add(new SphereBabi(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\chris\\PROJEK GRAFKOM\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\chris\\PROJEK GRAFKOM\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
                ),
                new Vector4f(0.0f, 0.0f, 0.0f, 1.0f),
                List.of(0.0f, 0.0f, 0.0f),
                0.2f,
                0.2f,
                0.2f,
                50, // Stack -->
                100, // Sector --> Titik
                3));
        TTSRY.get(0).getChildObject().get(0).getChildObject().get(1).scaleObject(0.1f, 0.1f, 0.1f);
        TTSRY.get(0).getChildObject().get(0).getChildObject().get(1).translateObject(0.09f, 0.15f, 0.605f);

        TTSRY.get(0).getChildObject().get(0).getChildObject().add(new SphereBabi(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\chris\\PROJEK GRAFKOM\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\chris\\PROJEK GRAFKOM\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.0f, 0.0f, 0.0f, 1.0f),
                List.of(0.0f, 0.0f, 0.0f),
                0.2f,
                0.2f,
                0.2f,
                15, // Stack -->
                30, // Sector --> Titik
                3));
        TTSRY.get(0).getChildObject().get(0).getChildObject().get(2).scaleObject(0.1f, 0.1f, 0.1f);
        TTSRY.get(0).getChildObject().get(0).getChildObject().get(2).translateObject(-0.09f, 0.15f, 0.605f);

        //udel
        TTSRY.get(0).getChildObject().add(new SphereBabi(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\chris\\PROJEK GRAFKOM\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\chris\\PROJEK GRAFKOM\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(1.0f, 0.6f, 0.89f, 1.0f),
                List.of(0.0f, 0.0f, 0.0f),
                0.08f,
                0.08f,
                0.03f,
                15, // Stack -->
                30, // Sector --> Titik
                2));

        TTSRY.get(0).getChildObject().get(1).rotateObject((float) Math.toRadians(90.0f), 1.0f, 0.0f, 0.0f);
        TTSRY.get(0).getChildObject().get(1).translateObject(0.0f, -0.275f, 0.0f);

        //EKOR
        TTSRY.get(0).getChildObject().add(new SphereBabi(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\chris\\PROJEK GRAFKOM\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\chris\\PROJEK GRAFKOM\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(1.0f, 0.6f, 0.89f, 1.0f),
                List.of(0.0f, 0.0f, 0.0f),
                0.1f,
                0.1f,
                0.1f,
                15, // Stack -->
                30, // Sector --> Titik
                6));

        TTSRY.get(0).getChildObject().get(2).scaleObject(0.1f, 0.1f, 0.1f);
        TTSRY.get(0).getChildObject().get(2).translateObject(0.0f, 0.0f, -0.43f);

        // LUBANG CELENGAN
        TTSRY.get(0).getChildObject().add(new SphereBabi(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\chris\\PROJEK GRAFKOM\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\chris\\PROJEK GRAFKOM\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.0f, 0.0f, 0.0f, 1.0f),
                List.of(0.0f, 0.0f, 0.0f),
                0.15f,
                0.1f,
                0.1f,
                15, // Stack -->
                30, // Sector --> Titik
                31));

        TTSRY.get(0).getChildObject().get(3).translateObject(0.0f, 0.17f, 0.0f);
        TTSRY.get(0).getChildObject().get(3).rotateObject((float)Math.toRadians(90.0f),0.0f, 1.0f,  0.0f);

        //KAKI KIRI DEPAN
        TTSRY.get(0).getChildObject().add(new SphereBabi(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\chris\\PROJEK GRAFKOM\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\chris\\PROJEK GRAFKOM\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(1.0f, 0.6f, 0.89f, 1.0f),
                List.of(0.0f, 0.0f, 0.0f),
                0.1f,
                0.1f,
                0.115f,
                15, // Stack -->
                30, // Sector --> Titik
                2));
        TTSRY.get(0).getChildObject().get(4).scaleObject(0.5f, 0.5f, 3.0f);
        TTSRY.get(0).getChildObject().get(4).rotateObject((float) Math.toRadians(90.0f), 1.0f, 0.0f, 0.0f);
        TTSRY.get(0).getChildObject().get(4).translateObject(0.1f, -0.37f, 0.25f);
        TTSRY.get(0).getChildObject().get(4).rotateObject((float) Math.toRadians(30.0f), 0.0f, 0.0f, 1.0f);
        //KAKI KIRI BELAKANG
        TTSRY.get(0).getChildObject().add(new SphereBabi(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\chris\\PROJEK GRAFKOM\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\chris\\PROJEK GRAFKOM\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(1.0f, 0.6f, 0.89f, 1.0f),
                List.of(0.0f, 0.0f, 0.0f),
                0.1f,
                0.1f,
                0.115f,
                15, // Stack -->
                30, // Sector --> Titik
                2));
        TTSRY.get(0).getChildObject().get(5).scaleObject(0.5f, 0.5f, 3.0f);
        TTSRY.get(0).getChildObject().get(5).rotateObject((float) Math.toRadians(90.0f), 1.0f, 0.0f, 0.0f);
        TTSRY.get(0).getChildObject().get(5).translateObject(0.1f, -0.37f, -0.25f);
        TTSRY.get(0).getChildObject().get(5).rotateObject((float) Math.toRadians(30.0f), 0.0f, 0.0f, 1.0f);
        // kaki kanan depan
        TTSRY.get(0).getChildObject().add(new SphereBabi(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\chris\\PROJEK GRAFKOM\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\chris\\PROJEK GRAFKOM\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(1.0f, 0.6f, 0.89f, 1.0f),
                List.of(0.0f, 0.0f, 0.0f),
                0.1f,
                0.1f,
                0.115f,
                15, // Stack -->
                30, // Sector --> Titik
                2));
        TTSRY.get(0).getChildObject().get(6).scaleObject(0.5f, 0.5f, 3.0f);
        TTSRY.get(0).getChildObject().get(6).rotateObject((float) Math.toRadians(90.0f), 1.0f, 0.0f, 0.0f);
        TTSRY.get(0).getChildObject().get(6).translateObject(-0.1f, -0.37f, 0.25f);
        TTSRY.get(0).getChildObject().get(6).rotateObject((float) Math.toRadians(-30.0f), 0.0f, 0.0f, 1.0f);
        //kaki kanan belakang
        TTSRY.get(0).getChildObject().add(new SphereBabi(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\chris\\PROJEK GRAFKOM\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\chris\\PROJEK GRAFKOM\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(1.0f, 0.6f, 0.89f, 1.0f),
                List.of(0.0f, 0.0f, 0.0f),
                0.1f,
                0.1f,
                0.115f,
                15, // Stack -->
                30, // Sector --> Titik
                2));
        TTSRY.get(0).getChildObject().get(7).scaleObject(0.5f, 0.5f, 3.0f);
        TTSRY.get(0).getChildObject().get(7).rotateObject((float) Math.toRadians(90.0f), 1.0f, 0.0f, 0.0f);
        TTSRY.get(0).getChildObject().get(7).translateObject(-0.1f, -0.37f, -0.25f);
        TTSRY.get(0).getChildObject().get(7).rotateObject((float) Math.toRadians(-30.0f), 0.0f, 0.0f, 1.0f);

        // KUKU Kaki kanan belakang
        TTSRY.get(0).getChildObject().get(7).getChildObject().add(new SphereBabi(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\chris\\PROJEK GRAFKOM\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\chris\\PROJEK GRAFKOM\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.0f, 0.0f, 0.0f, 1.0f),
                List.of(0.0f, 0.0f, 0.0f),
                0.1f,
                0.1f,
                0.1f,
                30, // Stack -->
                0, // Sector --> Titik
                6));
        TTSRY.get(0).getChildObject().get(7).getChildObject().get(0).scaleObject(0.04f, 0.04f, 0.1f);
        TTSRY.get(0).getChildObject().get(7).getChildObject().get(0).rotateObject((float) Math.toRadians(270.0f), 1.0f, 0.0f, 0.0f);
        TTSRY.get(0).getChildObject().get(7).getChildObject().get(0).rotateObject((float) Math.toRadians(-50.0f), 0.0f, 0.0f, 1.0f);
        TTSRY.get(0).getChildObject().get(7).getChildObject().get(0).translateObject(-0.17f, -0.38f, -0.227f);
        TTSRY.get(0).getChildObject().get(7).getChildObject().get(0).rotateObject((float) Math.toRadians(-30.0f), 0.0f, 0.0f, 1.0f);

        TTSRY.get(0).getChildObject().get(7).getChildObject().add(new SphereBabi(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\chris\\PROJEK GRAFKOM\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\chris\\PROJEK GRAFKOM\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.0f, 0.0f, 0.0f, 1.0f),
                List.of(0.0f, 0.0f, 0.0f),
                0.1f,
                0.1f,
                0.1f,
                30, // Stack -->
                0, // Sector --> Titik
                6));
        TTSRY.get(0).getChildObject().get(7).getChildObject().get(1).scaleObject(0.04f, 0.04f, 0.1f);
        TTSRY.get(0).getChildObject().get(7).getChildObject().get(1).rotateObject((float) Math.toRadians(270.0f), 1.0f, 0.0f, 0.0f);
        TTSRY.get(0).getChildObject().get(7).getChildObject().get(1).rotateObject((float) Math.toRadians(-50.0f), 0.0f, 0.0f, 1.0f);
        TTSRY.get(0).getChildObject().get(7).getChildObject().get(1).translateObject(-0.17f, -0.38f, -0.25f);
        TTSRY.get(0).getChildObject().get(7).getChildObject().get(1).rotateObject((float) Math.toRadians(-30.0f), 0.0f, 0.0f, 1.0f);

        TTSRY.get(0).getChildObject().get(7).getChildObject().add(new SphereBabi(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\chris\\PROJEK GRAFKOM\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\chris\\PROJEK GRAFKOM\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.0f, 0.0f, 0.0f, 1.0f),
                List.of(0.0f, 0.0f, 0.0f),
                0.1f,
                0.1f,
                0.1f,
                30, // Stack -->
                0, // Sector --> Titik
                6));
        TTSRY.get(0).getChildObject().get(7).getChildObject().get(2).scaleObject(0.04f, 0.04f, 0.1f);
        TTSRY.get(0).getChildObject().get(7).getChildObject().get(2).rotateObject((float) Math.toRadians(270.0f), 1.0f, 0.0f, 0.0f);
        TTSRY.get(0).getChildObject().get(7).getChildObject().get(2).rotateObject((float) Math.toRadians(-50.0f), 0.0f, 0.0f, 1.0f);
        TTSRY.get(0).getChildObject().get(7).getChildObject().get(2).translateObject(-0.17f, -0.38f, -0.273f);
        TTSRY.get(0).getChildObject().get(7).getChildObject().get(2).rotateObject((float) Math.toRadians(-30.0f), 0.0f, 0.0f, 1.0f);

        // KUKU Kaki kanan depan
        TTSRY.get(0).getChildObject().get(6).getChildObject().add(new SphereBabi(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\chris\\PROJEK GRAFKOM\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\chris\\PROJEK GRAFKOM\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.0f, 0.0f, 0.0f, 1.0f),
                List.of(0.0f, 0.0f, 0.0f),
                0.1f,
                0.1f,
                0.1f,
                30, // Stack -->
                0, // Sector --> Titik
                6));
        TTSRY.get(0).getChildObject().get(6).getChildObject().get(0).scaleObject(0.04f, 0.04f, 0.1f);
        TTSRY.get(0).getChildObject().get(6).getChildObject().get(0).rotateObject((float) Math.toRadians(270.0f), 1.0f, 0.0f, 0.0f);
        TTSRY.get(0).getChildObject().get(6).getChildObject().get(0).rotateObject((float) Math.toRadians(-50.0f), 0.0f, 0.0f, 1.0f);
        TTSRY.get(0).getChildObject().get(6).getChildObject().get(0).translateObject(-0.17f, -0.38f, 0.227f);
        TTSRY.get(0).getChildObject().get(6).getChildObject().get(0).rotateObject((float) Math.toRadians(-30.0f), 0.0f, 0.0f, 1.0f);

        TTSRY.get(0).getChildObject().get(6).getChildObject().add(new SphereBabi(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\chris\\PROJEK GRAFKOM\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\chris\\PROJEK GRAFKOM\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.0f, 0.0f, 0.0f, 1.0f),
                List.of(0.0f, 0.0f, 0.0f),
                0.1f,
                0.1f,
                0.1f,
                30, // Stack -->
                0, // Sector --> Titik
                6));
        TTSRY.get(0).getChildObject().get(6).getChildObject().get(1).scaleObject(0.04f, 0.04f, 0.1f);
        TTSRY.get(0).getChildObject().get(6).getChildObject().get(1).rotateObject((float) Math.toRadians(270.0f), 1.0f, 0.0f, 0.0f);
        TTSRY.get(0).getChildObject().get(6).getChildObject().get(1).rotateObject((float) Math.toRadians(-50.0f), 0.0f, 0.0f, 1.0f);
        TTSRY.get(0).getChildObject().get(6).getChildObject().get(1).translateObject(-0.17f, -0.38f, 0.25f);
        TTSRY.get(0).getChildObject().get(6).getChildObject().get(1).rotateObject((float) Math.toRadians(-30.0f), 0.0f, 0.0f, 1.0f);

        TTSRY.get(0).getChildObject().get(6).getChildObject().add(new SphereBabi(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\chris\\PROJEK GRAFKOM\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\chris\\PROJEK GRAFKOM\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.0f, 0.0f, 0.0f, 1.0f),
                List.of(0.0f, 0.0f, 0.0f),
                0.1f,
                0.1f,
                0.1f,
                30, // Stack -->
                0, // Sector --> Titik
                6));
        TTSRY.get(0).getChildObject().get(6).getChildObject().get(2).scaleObject(0.04f, 0.04f, 0.1f);
        TTSRY.get(0).getChildObject().get(6).getChildObject().get(2).rotateObject((float) Math.toRadians(270.0f), 1.0f, 0.0f, 0.0f);
        TTSRY.get(0).getChildObject().get(6).getChildObject().get(2).rotateObject((float) Math.toRadians(-50.0f), 0.0f, 0.0f, 1.0f);
        TTSRY.get(0).getChildObject().get(6).getChildObject().get(2).translateObject(-0.17f, -0.38f, 0.273f);
        TTSRY.get(0).getChildObject().get(6).getChildObject().get(2).rotateObject((float) Math.toRadians(-30.0f), 0.0f, 0.0f, 1.0f);

        // KUKU Kaki kiri belakang
        TTSRY.get(0).getChildObject().get(5).getChildObject().add(new SphereBabi(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\chris\\PROJEK GRAFKOM\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\chris\\PROJEK GRAFKOM\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.0f, 0.0f, 0.0f, 1.0f),
                List.of(0.0f, 0.0f, 0.0f),
                0.1f,
                0.1f,
                0.1f,
                30, // Stack -->
                0, // Sector --> Titik
                6));
        TTSRY.get(0).getChildObject().get(5).getChildObject().get(0).scaleObject(0.04f, 0.04f, 0.1f);
        TTSRY.get(0).getChildObject().get(5).getChildObject().get(0).rotateObject((float) Math.toRadians(270.0f), 1.0f, 0.0f, 0.0f);
        TTSRY.get(0).getChildObject().get(5).getChildObject().get(0).rotateObject((float) Math.toRadians(50.0f), 0.0f, 0.0f, 1.0f);
        TTSRY.get(0).getChildObject().get(5).getChildObject().get(0).translateObject(0.17f, -0.38f, -0.227f);
        TTSRY.get(0).getChildObject().get(5).getChildObject().get(0).rotateObject((float) Math.toRadians(30.0f), 0.0f, 0.0f, 1.0f);

        TTSRY.get(0).getChildObject().get(5).getChildObject().add(new SphereBabi(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\chris\\PROJEK GRAFKOM\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\chris\\PROJEK GRAFKOM\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.0f, 0.0f, 0.0f, 1.0f),
                List.of(0.0f, 0.0f, 0.0f),
                0.1f,
                0.1f,
                0.1f,
                30, // Stack -->
                0, // Sector --> Titik
                6));
        TTSRY.get(0).getChildObject().get(5).getChildObject().get(1).scaleObject(0.04f, 0.04f, 0.1f);
        TTSRY.get(0).getChildObject().get(5).getChildObject().get(1).rotateObject((float) Math.toRadians(270.0f), 1.0f, 0.0f, 0.0f);
        TTSRY.get(0).getChildObject().get(5).getChildObject().get(1).rotateObject((float) Math.toRadians(50.0f), 0.0f, 0.0f, 1.0f);
        TTSRY.get(0).getChildObject().get(5).getChildObject().get(1).translateObject(0.17f, -0.38f, -0.25f);
        TTSRY.get(0).getChildObject().get(5).getChildObject().get(1).rotateObject((float) Math.toRadians(30.0f), 0.0f, 0.0f, 1.0f);

        TTSRY.get(0).getChildObject().get(5).getChildObject().add(new SphereBabi(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\chris\\PROJEK GRAFKOM\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\chris\\PROJEK GRAFKOM\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.0f, 0.0f, 0.0f, 1.0f),
                List.of(0.0f, 0.0f, 0.0f),
                0.1f,
                0.1f,
                0.1f,
                30, // Stack -->
                0, // Sector --> Titik
                6));
        TTSRY.get(0).getChildObject().get(5).getChildObject().get(2).scaleObject(0.04f, 0.04f, 0.1f);
        TTSRY.get(0).getChildObject().get(5).getChildObject().get(2).rotateObject((float) Math.toRadians(270.0f), 1.0f, 0.0f, 0.0f);
        TTSRY.get(0).getChildObject().get(5).getChildObject().get(2).rotateObject((float) Math.toRadians(50.0f), 0.0f, 0.0f, 1.0f);
        TTSRY.get(0).getChildObject().get(5).getChildObject().get(2).translateObject(0.17f, -0.38f, -0.273f);
        TTSRY.get(0).getChildObject().get(5).getChildObject().get(2).rotateObject((float) Math.toRadians(30.0f), 0.0f, 0.0f, 1.0f);

        // KUKU Kaki kiri depan
        TTSRY.get(0).getChildObject().get(4).getChildObject().add(new SphereBabi(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\chris\\PROJEK GRAFKOM\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\chris\\PROJEK GRAFKOM\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.0f, 0.0f, 0.0f, 1.0f),
                List.of(0.0f, 0.0f, 0.0f),
                0.1f,
                0.1f,
                0.1f,
                30, // Stack -->
                0, // Sector --> Titik
                6));
        TTSRY.get(0).getChildObject().get(4).getChildObject().get(0).scaleObject(0.04f, 0.04f, 0.1f);
        TTSRY.get(0).getChildObject().get(4).getChildObject().get(0).rotateObject((float) Math.toRadians(270.0f), 1.0f, 0.0f, 0.0f);
        TTSRY.get(0).getChildObject().get(4).getChildObject().get(0).rotateObject((float) Math.toRadians(50.0f), 0.0f, 0.0f, 1.0f);
        TTSRY.get(0).getChildObject().get(4).getChildObject().get(0).translateObject(0.17f, -0.38f, 0.227f);
        TTSRY.get(0).getChildObject().get(4).getChildObject().get(0).rotateObject((float) Math.toRadians(30.0f), 0.0f, 0.0f, 1.0f);

        TTSRY.get(0).getChildObject().get(4).getChildObject().add(new SphereBabi(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\chris\\PROJEK GRAFKOM\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\chris\\PROJEK GRAFKOM\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.0f, 0.0f, 0.0f, 1.0f),
                List.of(0.0f, 0.0f, 0.0f),
                0.1f,
                0.1f,
                0.1f,
                30, // Stack -->
                0, // Sector --> Titik
                6));
        TTSRY.get(0).getChildObject().get(4).getChildObject().get(1).scaleObject(0.04f, 0.04f, 0.1f);
        TTSRY.get(0).getChildObject().get(4).getChildObject().get(1).rotateObject((float) Math.toRadians(270.0f), 1.0f, 0.0f, 0.0f);
        TTSRY.get(0).getChildObject().get(4).getChildObject().get(1).rotateObject((float) Math.toRadians(50.0f), 0.0f, 0.0f, 1.0f);
        TTSRY.get(0).getChildObject().get(4).getChildObject().get(1).translateObject(0.17f, -0.38f, 0.25f);
        TTSRY.get(0).getChildObject().get(4).getChildObject().get(1).rotateObject((float) Math.toRadians(30.0f), 0.0f, 0.0f, 1.0f);

        TTSRY.get(0).getChildObject().get(4).getChildObject().add(new SphereBabi(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\chris\\PROJEK GRAFKOM\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\chris\\PROJEK GRAFKOM\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.0f, 0.0f, 0.0f, 1.0f),
                List.of(0.0f, 0.0f, 0.0f),
                0.1f,
                0.1f,
                0.1f,
                30, // Stack -->
                0, // Sector --> Titik
                6));
        TTSRY.get(0).getChildObject().get(4).getChildObject().get(2).scaleObject(0.04f, 0.04f, 0.1f);
        TTSRY.get(0).getChildObject().get(4).getChildObject().get(2).rotateObject((float) Math.toRadians(270.0f), 1.0f, 0.0f, 0.0f);
        TTSRY.get(0).getChildObject().get(4).getChildObject().get(2).rotateObject((float) Math.toRadians(50.0f), 0.0f, 0.0f, 1.0f);
        TTSRY.get(0).getChildObject().get(4).getChildObject().get(2).translateObject(0.17f, -0.38f, 0.273f);
        TTSRY.get(0).getChildObject().get(4).getChildObject().get(2).rotateObject((float) Math.toRadians(30.0f), 0.0f, 0.0f, 1.0f);



    }
    //parameter gerak
    float countjalan=0;
    float countnoleh=0;
    boolean noleh =true;
    boolean kaki = true;

    public void input() {
    //animasi jalan
        // maju
        if(window.isKeyPressed(GLFW_KEY_1)){
            TTSRY.get(0).translateObject(0.002f,0.0f,0.0f);
            if(kaki) {
                countjalan++;
                TTSRY.get(0).getChildObject().get(7).translateObject( 0.0f, 0.0f, 0.005f);
                TTSRY.get(0).getChildObject().get(6).translateObject( 0.0f, 0.0f, 0.005f);
                TTSRY.get(0).getChildObject().get(5).translateObject( 0.0f, 0.0f, -0.005f);
                TTSRY.get(0).getChildObject().get(4).translateObject( 0.0f, 0.0f, -0.005f);
                if (countjalan == 15.0f) {
                    kaki = false;
                }
            } else{
                countjalan--;
                TTSRY.get(0).getChildObject().get(7).translateObject( 0.0f, 0.0f, -0.005f);
                TTSRY.get(0).getChildObject().get(6).translateObject( 0.0f, 0.0f, -0.005f);
                TTSRY.get(0).getChildObject().get(5).translateObject( 0.0f, 0.0f, 0.005f);
                TTSRY.get(0).getChildObject().get(4).translateObject( 0.0f, 0.0f, 0.005f);
                if(countjalan ==-15.0f){
                    kaki = true;
                }
            }
        }
        // mundur
        if(window.isKeyPressed(GLFW_KEY_2)){
            TTSRY.get(0).translateObject(-0.002f,0.0f,0.0f);
            if(kaki) {
                countjalan++;
                TTSRY.get(0).getChildObject().get(7).translateObject( 0.0f, 0.0f, 0.005f);
                TTSRY.get(0).getChildObject().get(6).translateObject( 0.0f, 0.0f, 0.005f);
                TTSRY.get(0).getChildObject().get(5).translateObject( 0.0f, 0.0f, -0.005f);
                TTSRY.get(0).getChildObject().get(4).translateObject( 0.0f, 0.0f, -0.005f);
                if (countjalan == 15.0f) {
                    kaki = false;
                }
            } else{
                countjalan--;
                TTSRY.get(0).getChildObject().get(7).translateObject( 0.0f, 0.0f, -0.005f);
                TTSRY.get(0).getChildObject().get(6).translateObject( 0.0f, 0.0f, -0.005f);
                TTSRY.get(0).getChildObject().get(5).translateObject( 0.0f, 0.0f, 0.005f);
                TTSRY.get(0).getChildObject().get(4).translateObject( 0.0f, 0.0f, 0.005f);
                if(countjalan ==-15.0f){
                    kaki = true;
                }
            }
        }

        // menoleh kanan
        if (window.isKeyPressed(GLFW_KEY_5)) {

            if (countnoleh < 30.0f) {
                countnoleh++;
                TTSRY.get(0).getChildObject().get(0).rotateObject((float) Math.toRadians(1.0f), 0.0f, 1.0f, 0.0f);
            }
        }
        // menoleh kiri
        if (window.isKeyPressed(GLFW_KEY_6)) {

            if (countnoleh > -30.0f) {
                countnoleh--;
                TTSRY.get(0).getChildObject().get(0).rotateObject((float) Math.toRadians(1.0f), 0.0f, -1.0f, 0.0f);
            }
        }


        if (window.isKeyPressed(GLFW_KEY_Q)) {
            for (Object i : TTSRY) {
                i.rotateObject(0.01f, 0f, 0f, 1f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_E)) {
            for (Object i : TTSRY) {
                i.rotateObject(-0.01f, 0f, 0f, 1f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_W)) {
            for (Object i : TTSRY) {
                i.rotateObject(0.1f, 1f, 0f, 0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_S)) {
            for (Object i : TTSRY) {
                i.rotateObject(-0.1f, 1f, 0f, 0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_A)) {
            for (Object i : TTSRY) {
                i.rotateObject(0.1f, 0f, 1f, 0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_D)) {
            for (Object i : TTSRY) {
                i.rotateObject(-0.1f, 0f, 1f, 0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_U)) {
            for (Object i : TTSRY) {
                i.translateObject(0f, 0f, 0.001f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_O)) {
            for (Object i : TTSRY) {
                i.translateObject(0f, 0f, -0.001f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_I)) {
            for (Object i : TTSRY) {
                i.translateObject(0f, 0.001f, 0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_K)) {
            for (Object i : TTSRY) {
                i.translateObject(0f, -0.001f, 0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_J)) {
            for (Object i : TTSRY) {
                i.translateObject(-0.001f, 0f, 0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_L)) {
            for (Object i : TTSRY) {
                i.translateObject(0.001f, 0f, 0f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_LEFT_SHIFT)) {
            camera.moveForward(0.02f);
        }

        if (window.isKeyPressed(GLFW_KEY_LEFT_CONTROL)) {
            camera.moveBackwards(0.05f);
        }
        if (window.isKeyPressed(GLFW_KEY_DOWN)) {
            camera.moveDown(0.05f);
        }

        if (window.isKeyPressed(GLFW_KEY_UP)) {
            camera.moveUp(0.02f);
        }
        if (window.isKeyPressed(GLFW_KEY_LEFT)) {
            camera.moveLeft(0.02f);
        }

        if (window.isKeyPressed(GLFW_KEY_RIGHT)) {
            camera.moveRight(0.02f);
        }
    }

    public void loop() {

        while (window.isOpen()) {
            window.update();
            glClearColor(1.0f, 1.0f, 1.0f, 0.0f); // RapidTables.com (RGB color code chart)
            GL.createCapabilities();
            input();
            for (Object obj3D : TTSRY) {

                obj3D.draw(camera, projection);

            }
            //Restore State
            glDisableVertexAttribArray(0);
            // Pull for window events
            // The key callback above will only be
            // invoked during this call
            glfwPollEvents();

        }
    }


    public static void main (String[]args){
        new BabiCeleng().run();
    }
}


