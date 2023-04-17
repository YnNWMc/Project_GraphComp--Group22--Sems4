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

public class Main {

//    KEL 25
//    Christian Phillip T	- C14210057
//    Arron Kurniawan 		- C14210060
//    Yan Nathanael		    - C14210061
//     TOY STORY (HAMM, WHEEZY, LITTLE GREEN MAN)
    private Window window =
            new Window(800, 800, "Main Gabungan");

    ArrayList<Object> BG = new ArrayList<>();
    ArrayList<Object> Babi = new ArrayList<>();
    ArrayList<LGM_Object> LGMO = new ArrayList<>();
    ArrayList<Wheezy_Object> bodyPart = new ArrayList<>();
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

        //BG
        //Meja background
        BG.add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\chris\\PROJEK GRAFKOM\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\chris\\PROJEK GRAFKOM\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.8f, 0.4f, 0.0f, 1.0f),0.0,
                new ArrayList<>(List.of(0f, 0f, 0f)),
                4.0f,
                0.1f,
                8.0f,
                15, // Stack -->
                30, // Sector --> Titik
                0));

        BG.get(0).translateObject(0.0f, -0.33f, 0.0f);
        //vas bunga
        BG.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\chris\\PROJEK GRAFKOM\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\chris\\PROJEK GRAFKOM\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.4f, 0.2f, 0.0f, 1.0f),0.0,
                new ArrayList<>(List.of(0f, 0f, 0f)),
                0.5f,
                0.5f,
                0.5f,
                15, // Stack -->
                30, // Sector --> Titik
                0));
        BG.get(0).getChildObject().get(0).translateObject(-1.0f, -0.03f, -3.0f);
        //Daun
        BG.get(0).getChildObject().get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\chris\\PROJEK GRAFKOM\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\chris\\PROJEK GRAFKOM\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.0f, 0.8f, 0.0f, 1.0f),0.0,
                new ArrayList<>(List.of(0f, 0f, 0f)),
                0.3f,
                0.3f,
                0.3f,
                15, // Stack -->
                30, // Sector --> Titik
                3));
        BG.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject((float)Math.toRadians(90.0f),1.0f, 0.0f, 0.0f);
        BG.get(0).getChildObject().get(0).getChildObject().get(0).translateObject(-1.0f, 0.45f, -3.0f);
        //Kaki Meja
        BG.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\chris\\PROJEK GRAFKOM\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\chris\\PROJEK GRAFKOM\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.4f, 0.2f, 0.0f, 1.0f),0.0,
                new ArrayList<>(List.of(0f, 0f, 0f)),
                0.2f,
                0.2f,
                3.0f,
                15, // Stack -->
                30, // Sector --> Titik
                2));
        BG.get(0).getChildObject().get(1).rotateObject((float) Math.toRadians(270.0f), 1.0f, 0.0f, 0.0f);
        BG.get(0).getChildObject().get(1).translateObject(-1.4f, -0.38f, -3.5f);

        BG.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\chris\\PROJEK GRAFKOM\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\chris\\PROJEK GRAFKOM\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.4f, 0.2f, 0.0f, 1.0f),0.0,
                new ArrayList<>(List.of(0f, 0f, 0f)),
                0.2f,
                0.2f,
                3.0f,
                15, // Stack -->
                30, // Sector --> Titik
                2));
        BG.get(0).getChildObject().get(2).rotateObject((float) Math.toRadians(270.0f), 1.0f, 0.0f, 0.0f);
        BG.get(0).getChildObject().get(2).translateObject(1.4f, -0.38f, -3.5f);

        BG.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\chris\\PROJEK GRAFKOM\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\chris\\PROJEK GRAFKOM\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.4f, 0.2f, 0.0f, 1.0f),0.0,
                new ArrayList<>(List.of(0f, 0f, 0f)),
                0.2f,
                0.2f,
                3.0f,
                15, // Stack -->
                30, // Sector --> Titik
                2));
        BG.get(0).getChildObject().get(3).rotateObject((float) Math.toRadians(270.0f), 1.0f, 0.0f, 0.0f);
        BG.get(0).getChildObject().get(3).translateObject(-1.4f, -0.38f, 3.5f);

        BG.get(0).getChildObject().add(new Sphere(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\chris\\PROJEK GRAFKOM\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\chris\\PROJEK GRAFKOM\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.4f, 0.2f, 0.0f, 1.0f),0.0,
                new ArrayList<>(List.of(0f, 0f, 0f)),
                0.2f,
                0.2f,
                3.0f,
                15, // Stack -->
                30, // Sector --> Titik
                2));
        BG.get(0).getChildObject().get(4).rotateObject((float) Math.toRadians(270.0f), 1.0f, 0.0f, 0.0f);
        BG.get(0).getChildObject().get(4).translateObject(1.4f, -0.38f, 3.5f);

        // HAMM (CELENGAN BABI C14210057 -CHRISTIAN PHILIP T)
        // Badan Babi
        Babi.add(new SphereBabi(
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
        Babi.get(0).scaleObject(1.3f, 1.3f, 1.3f);
        Babi.get(0).rotateObject((float)Math.toRadians(90.0f), 1.0f, 0.0f, 0.0f);

        //Kepala Babi
        Babi.get(0).getChildObject().add(new SphereBabi(
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
        Babi.get(0).getChildObject().get(0).scaleObject(1.0f, 1.0f, 1.0f);
        Babi.get(0).getChildObject().get(0).translateObject(0.0f, 0.075f, 0.43f);

        // Hidung babi
        Babi.get(0).getChildObject().get(0).getChildObject().add(new SphereBabi(
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
        Babi.get(0).getChildObject().get(0).getChildObject().get(0).translateObject(0.0f, 0.1f, 0.68f);
        Babi.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject((float) Math.toRadians(8.0f), 1.0f, 0.0f, 0.0f);

        // lubang hidung
        Babi.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().add(new SphereBabi(
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
        Babi.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).scaleObject(0.075f, 0.1f, 0.03f);
        Babi.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).translateObject(0.05f, 0.12f, 0.695f);
        Babi.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).rotateObject((float) Math.toRadians(8.0f), 1.0f, 0.0f, 0.0f);

        Babi.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().add(new SphereBabi(
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
        Babi.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(1).scaleObject(0.075f, 0.1f, 0.03f);
        Babi.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(1).translateObject(-0.05f, 0.12f, 0.695f);
        Babi.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(1).rotateObject((float) Math.toRadians(8.0f), 1.0f, 0.0f, 0.0f);

        //Mata
        Babi.get(0).getChildObject().get(0).getChildObject().add(new SphereBabi(
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
                50, // Stack -->
                100, // Sector --> Titik
                3));
        Babi.get(0).getChildObject().get(0).getChildObject().get(1).scaleObject(0.1f, 0.1f, 0.1f);
        Babi.get(0).getChildObject().get(0).getChildObject().get(1).translateObject(0.09f, 0.15f, 0.605f);

        Babi.get(0).getChildObject().get(0).getChildObject().add(new SphereBabi(
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
        Babi.get(0).getChildObject().get(0).getChildObject().get(2).scaleObject(0.1f, 0.1f, 0.1f);
        Babi.get(0).getChildObject().get(0).getChildObject().get(2).translateObject(-0.09f, 0.15f, 0.605f);

        //udel
        Babi.get(0).getChildObject().add(new SphereBabi(
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

        Babi.get(0).getChildObject().get(1).rotateObject((float) Math.toRadians(90.0f), 1.0f, 0.0f, 0.0f);
        Babi.get(0).getChildObject().get(1).translateObject(0.0f, -0.275f, 0.0f);

        //EKOR
        Babi.get(0).getChildObject().add(new SphereBabi(
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

        Babi.get(0).getChildObject().get(2).scaleObject(0.1f, 0.1f, 0.1f);
        Babi.get(0).getChildObject().get(2).translateObject(0.0f, 0.0f, -0.43f);

        // LUBANG CELENGAN
        Babi.get(0).getChildObject().add(new SphereBabi(
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

        Babi.get(0).getChildObject().get(3).translateObject(0.0f, 0.17f, 0.0f);
        Babi.get(0).getChildObject().get(3).rotateObject((float)Math.toRadians(90.0f),0.0f, 1.0f,  0.0f);

        //KAKI KIRI DEPAN
        Babi.get(0).getChildObject().add(new SphereBabi(
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
        Babi.get(0).getChildObject().get(4).scaleObject(0.5f, 0.5f, 3.0f);
        Babi.get(0).getChildObject().get(4).rotateObject((float) Math.toRadians(270.0f), 1.0f, 0.0f, 0.0f);
        Babi.get(0).getChildObject().get(4).translateObject(0.1f, -0.01f, 0.25f);
        Babi.get(0).getChildObject().get(4).rotateObject((float) Math.toRadians(30.0f), 0.0f, 0.0f, 1.0f);
        //KAKI KIRI BELAKANG
        Babi.get(0).getChildObject().add(new SphereBabi(
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
        Babi.get(0).getChildObject().get(5).scaleObject(0.5f, 0.5f, 3.0f);
        Babi.get(0).getChildObject().get(5).rotateObject((float) Math.toRadians(270.0f), 1.0f, 0.0f, 0.0f);
        Babi.get(0).getChildObject().get(5).translateObject(0.1f, -0.01f, -0.25f);
        Babi.get(0).getChildObject().get(5).rotateObject((float) Math.toRadians(30.0f), 0.0f, 0.0f, 1.0f);
        // kaki kanan depan
        Babi.get(0).getChildObject().add(new SphereBabi(
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
        Babi.get(0).getChildObject().get(6).scaleObject(0.5f, 0.5f, 3.0f);
        Babi.get(0).getChildObject().get(6).rotateObject((float) Math.toRadians(270.0f), 1.0f, 0.0f, 0.0f);
        Babi.get(0).getChildObject().get(6).translateObject(-0.1f, -0.01f, 0.25f);
        Babi.get(0).getChildObject().get(6).rotateObject((float) Math.toRadians(-30.0f), 0.0f, 0.0f, 1.0f);
        //kaki kanan belakang
        Babi.get(0).getChildObject().add(new SphereBabi(
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
        Babi.get(0).getChildObject().get(7).scaleObject(0.5f, 0.5f, 3.0f);
        Babi.get(0).getChildObject().get(7).rotateObject((float) Math.toRadians(270.0f), 1.0f, 0.0f, 0.0f);
        Babi.get(0).getChildObject().get(7).translateObject(-0.1f, -0.01f, -0.25f);
        Babi.get(0).getChildObject().get(7).rotateObject((float) Math.toRadians(-30.0f), 0.0f, 0.0f, 1.0f);

        // KUKU Kaki kanan belakang
        Babi.get(0).getChildObject().get(7).getChildObject().add(new SphereBabi(
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
        Babi.get(0).getChildObject().get(7).getChildObject().get(0).scaleObject(0.04f, 0.04f, 0.1f);
        Babi.get(0).getChildObject().get(7).getChildObject().get(0).rotateObject((float) Math.toRadians(270.0f), 1.0f, 0.0f, 0.0f);
        Babi.get(0).getChildObject().get(7).getChildObject().get(0).rotateObject((float) Math.toRadians(-50.0f), 0.0f, 0.0f, 1.0f);
        Babi.get(0).getChildObject().get(7).getChildObject().get(0).translateObject(-0.17f, -0.38f, -0.227f);
        Babi.get(0).getChildObject().get(7).getChildObject().get(0).rotateObject((float) Math.toRadians(-30.0f), 0.0f, 0.0f, 1.0f);

        Babi.get(0).getChildObject().get(7).getChildObject().add(new SphereBabi(
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
        Babi.get(0).getChildObject().get(7).getChildObject().get(1).scaleObject(0.04f, 0.04f, 0.1f);
        Babi.get(0).getChildObject().get(7).getChildObject().get(1).rotateObject((float) Math.toRadians(270.0f), 1.0f, 0.0f, 0.0f);
        Babi.get(0).getChildObject().get(7).getChildObject().get(1).rotateObject((float) Math.toRadians(-50.0f), 0.0f, 0.0f, 1.0f);
        Babi.get(0).getChildObject().get(7).getChildObject().get(1).translateObject(-0.17f, -0.38f, -0.25f);
        Babi.get(0).getChildObject().get(7).getChildObject().get(1).rotateObject((float) Math.toRadians(-30.0f), 0.0f, 0.0f, 1.0f);

        Babi.get(0).getChildObject().get(7).getChildObject().add(new SphereBabi(
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
        Babi.get(0).getChildObject().get(7).getChildObject().get(2).scaleObject(0.04f, 0.04f, 0.1f);
        Babi.get(0).getChildObject().get(7).getChildObject().get(2).rotateObject((float) Math.toRadians(270.0f), 1.0f, 0.0f, 0.0f);
        Babi.get(0).getChildObject().get(7).getChildObject().get(2).rotateObject((float) Math.toRadians(-50.0f), 0.0f, 0.0f, 1.0f);
        Babi.get(0).getChildObject().get(7).getChildObject().get(2).translateObject(-0.17f, -0.38f, -0.273f);
        Babi.get(0).getChildObject().get(7).getChildObject().get(2).rotateObject((float) Math.toRadians(-30.0f), 0.0f, 0.0f, 1.0f);

        // KUKU Kaki kanan depan
        Babi.get(0).getChildObject().get(6).getChildObject().add(new SphereBabi(
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
        Babi.get(0).getChildObject().get(6).getChildObject().get(0).scaleObject(0.04f, 0.04f, 0.1f);
        Babi.get(0).getChildObject().get(6).getChildObject().get(0).rotateObject((float) Math.toRadians(270.0f), 1.0f, 0.0f, 0.0f);
        Babi.get(0).getChildObject().get(6).getChildObject().get(0).rotateObject((float) Math.toRadians(-50.0f), 0.0f, 0.0f, 1.0f);
        Babi.get(0).getChildObject().get(6).getChildObject().get(0).translateObject(-0.17f, -0.38f, 0.227f);
        Babi.get(0).getChildObject().get(6).getChildObject().get(0).rotateObject((float) Math.toRadians(-30.0f), 0.0f, 0.0f, 1.0f);

        Babi.get(0).getChildObject().get(6).getChildObject().add(new SphereBabi(
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
        Babi.get(0).getChildObject().get(6).getChildObject().get(1).scaleObject(0.04f, 0.04f, 0.1f);
        Babi.get(0).getChildObject().get(6).getChildObject().get(1).rotateObject((float) Math.toRadians(270.0f), 1.0f, 0.0f, 0.0f);
        Babi.get(0).getChildObject().get(6).getChildObject().get(1).rotateObject((float) Math.toRadians(-50.0f), 0.0f, 0.0f, 1.0f);
        Babi.get(0).getChildObject().get(6).getChildObject().get(1).translateObject(-0.17f, -0.38f, 0.25f);
        Babi.get(0).getChildObject().get(6).getChildObject().get(1).rotateObject((float) Math.toRadians(-30.0f), 0.0f, 0.0f, 1.0f);

        Babi.get(0).getChildObject().get(6).getChildObject().add(new SphereBabi(
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
        Babi.get(0).getChildObject().get(6).getChildObject().get(2).scaleObject(0.04f, 0.04f, 0.1f);
        Babi.get(0).getChildObject().get(6).getChildObject().get(2).rotateObject((float) Math.toRadians(270.0f), 1.0f, 0.0f, 0.0f);
        Babi.get(0).getChildObject().get(6).getChildObject().get(2).rotateObject((float) Math.toRadians(-50.0f), 0.0f, 0.0f, 1.0f);
        Babi.get(0).getChildObject().get(6).getChildObject().get(2).translateObject(-0.17f, -0.38f, 0.273f);
        Babi.get(0).getChildObject().get(6).getChildObject().get(2).rotateObject((float) Math.toRadians(-30.0f), 0.0f, 0.0f, 1.0f);

        // KUKU Kaki kiri belakang
        Babi.get(0).getChildObject().get(5).getChildObject().add(new SphereBabi(
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
        Babi.get(0).getChildObject().get(5).getChildObject().get(0).scaleObject(0.04f, 0.04f, 0.1f);
        Babi.get(0).getChildObject().get(5).getChildObject().get(0).rotateObject((float) Math.toRadians(270.0f), 1.0f, 0.0f, 0.0f);
        Babi.get(0).getChildObject().get(5).getChildObject().get(0).rotateObject((float) Math.toRadians(50.0f), 0.0f, 0.0f, 1.0f);
        Babi.get(0).getChildObject().get(5).getChildObject().get(0).translateObject(0.17f, -0.38f, -0.227f);
        Babi.get(0).getChildObject().get(5).getChildObject().get(0).rotateObject((float) Math.toRadians(30.0f), 0.0f, 0.0f, 1.0f);

        Babi.get(0).getChildObject().get(5).getChildObject().add(new SphereBabi(
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
        Babi.get(0).getChildObject().get(5).getChildObject().get(1).scaleObject(0.04f, 0.04f, 0.1f);
        Babi.get(0).getChildObject().get(5).getChildObject().get(1).rotateObject((float) Math.toRadians(270.0f), 1.0f, 0.0f, 0.0f);
        Babi.get(0).getChildObject().get(5).getChildObject().get(1).rotateObject((float) Math.toRadians(50.0f), 0.0f, 0.0f, 1.0f);
        Babi.get(0).getChildObject().get(5).getChildObject().get(1).translateObject(0.17f, -0.38f, -0.25f);
        Babi.get(0).getChildObject().get(5).getChildObject().get(1).rotateObject((float) Math.toRadians(30.0f), 0.0f, 0.0f, 1.0f);

        Babi.get(0).getChildObject().get(5).getChildObject().add(new SphereBabi(
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
        Babi.get(0).getChildObject().get(5).getChildObject().get(2).scaleObject(0.04f, 0.04f, 0.1f);
        Babi.get(0).getChildObject().get(5).getChildObject().get(2).rotateObject((float) Math.toRadians(270.0f), 1.0f, 0.0f, 0.0f);
        Babi.get(0).getChildObject().get(5).getChildObject().get(2).rotateObject((float) Math.toRadians(50.0f), 0.0f, 0.0f, 1.0f);
        Babi.get(0).getChildObject().get(5).getChildObject().get(2).translateObject(0.17f, -0.38f, -0.273f);
        Babi.get(0).getChildObject().get(5).getChildObject().get(2).rotateObject((float) Math.toRadians(30.0f), 0.0f, 0.0f, 1.0f);

        // KUKU Kaki kiri depan
        Babi.get(0).getChildObject().get(4).getChildObject().add(new SphereBabi(
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
        Babi.get(0).getChildObject().get(4).getChildObject().get(0).scaleObject(0.04f, 0.04f, 0.1f);
        Babi.get(0).getChildObject().get(4).getChildObject().get(0).rotateObject((float) Math.toRadians(270.0f), 1.0f, 0.0f, 0.0f);
        Babi.get(0).getChildObject().get(4).getChildObject().get(0).rotateObject((float) Math.toRadians(50.0f), 0.0f, 0.0f, 1.0f);
        Babi.get(0).getChildObject().get(4).getChildObject().get(0).translateObject(0.17f, -0.38f, 0.227f);
        Babi.get(0).getChildObject().get(4).getChildObject().get(0).rotateObject((float) Math.toRadians(30.0f), 0.0f, 0.0f, 1.0f);

        Babi.get(0).getChildObject().get(4).getChildObject().add(new SphereBabi(
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
        Babi.get(0).getChildObject().get(4).getChildObject().get(1).scaleObject(0.04f, 0.04f, 0.1f);
        Babi.get(0).getChildObject().get(4).getChildObject().get(1).rotateObject((float) Math.toRadians(270.0f), 1.0f, 0.0f, 0.0f);
        Babi.get(0).getChildObject().get(4).getChildObject().get(1).rotateObject((float) Math.toRadians(50.0f), 0.0f, 0.0f, 1.0f);
        Babi.get(0).getChildObject().get(4).getChildObject().get(1).translateObject(0.17f, -0.38f, 0.25f);
        Babi.get(0).getChildObject().get(4).getChildObject().get(1).rotateObject((float) Math.toRadians(30.0f), 0.0f, 0.0f, 1.0f);

        Babi.get(0).getChildObject().get(4).getChildObject().add(new SphereBabi(
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
        Babi.get(0).getChildObject().get(4).getChildObject().get(2).scaleObject(0.04f, 0.04f, 0.1f);
        Babi.get(0).getChildObject().get(4).getChildObject().get(2).rotateObject((float) Math.toRadians(270.0f), 1.0f, 0.0f, 0.0f);
        Babi.get(0).getChildObject().get(4).getChildObject().get(2).rotateObject((float) Math.toRadians(50.0f), 0.0f, 0.0f, 1.0f);
        Babi.get(0).getChildObject().get(4).getChildObject().get(2).translateObject(0.17f, -0.38f, 0.273f);
        Babi.get(0).getChildObject().get(4).getChildObject().get(2).rotateObject((float) Math.toRadians(30.0f), 0.0f, 0.0f, 1.0f);

        //kuping
        Babi.get(0).getChildObject().get(0).getChildObject().add(new SphereBabi(
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
                0.27f,
                0.27f,
                0.27f,
                15, // Stack -->
                30, // Sector --> Titik
                0));
        Babi.get(0).getChildObject().get(0).getChildObject().get(3).scaleObject(0.5f, 0.5f, 0.1f);
        Babi.get(0).getChildObject().get(0).getChildObject().get(3).translateObject(-0.105f, 0.195f, 0.39f);

        Babi.get(0).getChildObject().get(0).getChildObject().add(new SphereBabi(
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
                0.27f,
                0.27f,
                0.27f,
                15, // Stack -->
                30, // Sector --> Titik
                0));
        Babi.get(0).getChildObject().get(0).getChildObject().get(4).scaleObject(0.5f, 0.5f, 0.1f);
        Babi.get(0).getChildObject().get(0).getChildObject().get(4).rotateObject((float)Math.toRadians(-90.0f),0.0f, 0.0f, 1.0f);
        Babi.get(0).getChildObject().get(0).getChildObject().get(4).translateObject(0.105f, 0.195f, 0.39f);

        //dalam kuping
        Babi.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().add(new SphereBabi(
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
                0.24f,
                0.24f,
                0.24f,
                15, // Stack -->
                30, // Sector --> Titik
                0));
        Babi.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().get(0).scaleObject(0.5f, 0.5f, 0.05f);
        Babi.get(0).getChildObject().get(0).getChildObject().get(3).getChildObject().get(0).translateObject(-0.105f, 0.19f, 0.395f);

        Babi.get(0).getChildObject().get(0).getChildObject().get(4).getChildObject().add(new SphereBabi(
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
                0.24f,
                0.24f,
                0.24f,
                15, // Stack -->
                30, // Sector --> Titik
                0));
        Babi.get(0).getChildObject().get(0).getChildObject().get(4).getChildObject().get(0).scaleObject(0.5f, 0.5f, 0.05f);
        Babi.get(0).getChildObject().get(0).getChildObject().get(4).getChildObject().get(0).rotateObject((float)Math.toRadians(-90.0f),0.0f, 0.0f, 1.0f);
        Babi.get(0).getChildObject().get(0).getChildObject().get(4).getChildObject().get(0).translateObject(0.105f, 0.19f, 0.395f);

        //kurva alis
        Babi.get(0).getChildObject().get(0).getChildObject().add(new SphereBabi(
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
                0.24f,
                0.24f,
                Arrays.asList(
                        new Vector3f(-0.14f,0.19f,0.60f),//TITIK1
                        new Vector3f(-0.09f,0.22f,0.60f), //TITIK2
                        new Vector3f(-0.04f,0.19f,0.60f) //TITIK3
                )//kanan

        ));
        Babi.get(0).getChildObject().get(0).getChildObject().add(new SphereBabi(
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
                0.24f,
                0.24f,
                Arrays.asList(
                        new Vector3f(0.14f,0.19f,0.60f),//TITIK1
                        new Vector3f(0.09f,0.22f,0.60f), //TITIK2
                        new Vector3f(0.04f,0.19f,0.60f) //TITIK3
                )

        ));

        Babi.get(0).translateObject(0.0f,0.0f,-2.0f);


        //Arron Kurniawan C14210060

        // badan utama
        bodyPart.add(new Wheezy_Object(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\LEGION\\IdeaProjects\\GrafkomBANG\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.vert"
                                , GL_VERTEX_SHADER),

                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\LEGION\\IdeaProjects\\GrafkomBANG\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.frag"
                                , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new ArrayList<>(
                ),
                new Vector4f(0f, 0f, 0f, 1.0f),// color
                0.00,// radius
                new ArrayList<>(List.of(0f, 0f, 0f)),// center point
                0.32f,// titik x
                0.48f,// titik y
                0.40f,// titik z
                15, // Stack -->
                30, // Sector --> Titik
                1));// option
        bodyPart.get(0).rotateObject(-0.40f, 0f, 1f, 0f);// putar biar bgs kliatannya
        bodyPart.get(0).translateObject(-0.3f, 0f, 0f); // POSISI

        //bagian perut yg putih
        bodyPart.get(0).getChildObject().add(new Wheezy_Object(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\LEGION\\IdeaProjects\\GrafkomBANG\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.vert"
                                , GL_VERTEX_SHADER),

                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\LEGION\\IdeaProjects\\GrafkomBANG\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.frag"
                                , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.89f, 0.87f, 0.74f, 1.0f),// color
                0.00,// radius
                new ArrayList<>(List.of(0f, 0f, 0f)),// center point
                0.16f,// titik x
                0.22f,// titik y
                0.05f,// titik z
                15, // Stack -->
                30, // Sector --> Titik
                2));// option
        bodyPart.get(0).getChildObject().get(0).rotateObject(-0.40f, 0f, 1f, 0f);// putar biar bgs kliatannya
        bodyPart.get(0).getChildObject().get(0).translateObject(-0.41f, -0.18f, 0.33f); // POSISI

        //tangan kanan
        bodyPart.get(0).getChildObject().add(new Wheezy_Object(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\LEGION\\IdeaProjects\\GrafkomBANG\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.vert"
                                , GL_VERTEX_SHADER),

                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\LEGION\\IdeaProjects\\GrafkomBANG\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.frag"
                                , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new ArrayList<>(
                ),
                new Vector4f(0f, 0f, 0f, 1.0f),// color
                0.00,// radius
                new ArrayList<>(List.of(0f, 0f, 0f)),// center point
                0.16f,// titik x
                0.26f,// titik y
                0.2f,// titik z
                15, // Stack -->
                30, // Sector --> Titik
                3));// option
        bodyPart.get(0).getChildObject().get(1).rotateObject(2.2f, 1.3f, 0f, 0f);// putar biar bgs kliatannya
        bodyPart.get(0).getChildObject().get(1).rotateObject(1.2f, 0f, 1f, 0f);// putar biar bgs kliatannya
        bodyPart.get(0).getChildObject().get(1).translateObject(-0.138f, 0.16f, 0.28f); // POSISI

        //tangan Kiri
        bodyPart.get(0).getChildObject().add(new Wheezy_Object(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\LEGION\\IdeaProjects\\GrafkomBANG\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.vert"
                                , GL_VERTEX_SHADER),

                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\LEGION\\IdeaProjects\\GrafkomBANG\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.frag"
                                , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new ArrayList<>(
                ),
                new Vector4f(0f, 0f, 0f, 1.0f),// color
                0.00,// radius
                new ArrayList<>(List.of(0f, 0f, 0f)),// center point
                0.16f,// titik x
                0.26f,// titik y
                0.2f,// titik z
                15, // Stack -->
                30, // Sector --> Titik
                3));// option

        bodyPart.get(0).getChildObject().get(2).rotateObject(2.2f, 1.3f, 0f, 0f);// putar biar bgs kliatannya
        bodyPart.get(0).getChildObject().get(2).rotateObject(4.4f, 0f, 1f, 0f);// putar biar bgs kliatannya
        bodyPart.get(0).getChildObject().get(2).translateObject(-0.57f, 0.16f, 0.08f); // POSISI


        //kelopak mata kanan
        bodyPart.get(0).getChildObject().add(new Wheezy_Object(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\LEGION\\IdeaProjects\\GrafkomBANG\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.vert"
                                , GL_VERTEX_SHADER),

                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\LEGION\\IdeaProjects\\GrafkomBANG\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.frag"
                                , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.95f, 1f, 1f, 1.0f),// color
                0.00,// radius
                new ArrayList<>(List.of(0f, 0f, 0f)),// center point
                0.05f,// titik x
                0.038f,// titik y
                0.02f,// titik z
                15, // Stack -->
                30, // Sector --> Titik
                4));// option

        bodyPart.get(0).getChildObject().get(3).rotateObject(-0.40f, 0f, 1f, 0f);// putar biar bgs kliatannya
        bodyPart.get(0).getChildObject().get(3).translateObject(-0.3f, 0.46f, 0.2f); // POSISI

        //kelopak mata kiri
        bodyPart.get(0).getChildObject().add(new Wheezy_Object(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\LEGION\\IdeaProjects\\GrafkomBANG\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.vert"
                                , GL_VERTEX_SHADER),

                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\LEGION\\IdeaProjects\\GrafkomBANG\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.frag"
                                , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.95f, 1f, 1f, 1.0f),// color
                0.00,// radius
                new ArrayList<>(List.of(0f, 0f, 0f)),// center point
                0.05f,// titik x
                0.038f,// titik y
                0.02f,// titik z
                15, // Stack -->
                30, // Sector --> Titik
                4));// option

        bodyPart.get(0).getChildObject().get(4).rotateObject(-0.40f, 0f, 1f, 0f);// putar biar bgs kliatannya
        bodyPart.get(0).getChildObject().get(4).translateObject(-0.42f, 0.465f, 0.12f); // POSISI

        //mata kanan
        bodyPart.get(0).getChildObject().get(3).getChildObject().add(new Wheezy_Object(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\LEGION\\IdeaProjects\\GrafkomBANG\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.vert"
                                , GL_VERTEX_SHADER),

                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\LEGION\\IdeaProjects\\GrafkomBANG\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.frag"
                                , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new ArrayList<>(
                ),
                new Vector4f(0f, 0f, 0f, 1.0f),// color
                0.00,// radius
                new ArrayList<>(List.of(0f, 0f, 0f)),// center point
                0.03f,// titik x
                0.02f,// titik y
                0.01f,// titik z
                15, // Stack -->
                30, // Sector --> Titik
                4));// option

        bodyPart.get(0).getChildObject().get(3).getChildObject().get(0).rotateObject(-0.40f, 0f, 1f, 0f);// putar biar bgs kliatannya
        bodyPart.get(0).getChildObject().get(3).getChildObject().get(0).translateObject(-0.31f, 0.45f, 0.21f); // POSISI

        //mata kiri
        bodyPart.get(0).getChildObject().get(4).getChildObject().add(new Wheezy_Object(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\LEGION\\IdeaProjects\\GrafkomBANG\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.vert"
                                , GL_VERTEX_SHADER),

                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\LEGION\\IdeaProjects\\GrafkomBANG\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.frag"
                                , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new ArrayList<>(
                ),
                new Vector4f(0f, 0f, 0f, 1.0f),// color
                0.00,// radius
                new ArrayList<>(List.of(0f, 0f, 0f)),// center point
                0.03f,// titik x
                0.02f,// titik y
                0.01f,// titik z
                15, // Stack -->
                30, // Sector --> Titik
                4));// option

        bodyPart.get(0).getChildObject().get(4).getChildObject().get(0).rotateObject(-0.40f, 0f, 1f, 0f);// putar biar bgs kliatannya
        bodyPart.get(0).getChildObject().get(4).getChildObject().get(0).translateObject(-0.43f, 0.455f, 0.13f);// POSISI

        // paruh atas
        bodyPart.get(0).getChildObject().add(new Wheezy_Object(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\LEGION\\IdeaProjects\\GrafkomBANG\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.vert"
                                , GL_VERTEX_SHADER),

                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\LEGION\\IdeaProjects\\GrafkomBANG\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.frag"
                                , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.95f, 0.75f, 0.09f, 1.0f),// color
                0.00,// radius
                new ArrayList<>(List.of(0f, 0f, 0f)),// center point
                0.01f,// titik x
                0.017f,// titik y
                0.023f,// titik z
                15, // Stack -->
                30, // Sector --> TitikW
                5));// option

        bodyPart.get(0).getChildObject().get(5).rotateObject(3.13f, 1f, 0f, 0f);// putar biar bgs kliatannya
        bodyPart.get(0).getChildObject().get(5).translateObject(-0.44f, 0.3f, 0.51f); // POSISI

        // paruh bwh
        bodyPart.get(0).getChildObject().get(5).getChildObject().add(new Wheezy_Object(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\LEGION\\IdeaProjects\\GrafkomBANG\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.vert"
                                , GL_VERTEX_SHADER),

                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\LEGION\\IdeaProjects\\GrafkomBANG\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.frag"
                                , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.95f, 0.75f, 0.09f, 1.0f),// color
                0.00,// radius
                new ArrayList<>(List.of(0f, 0f, 0f)),// center point
                0.008f,// titik x
                0.007f,// titik y
                0.02f,// titik z
                15, // Stack -->
                30, // Sector --> Titik
                5));// option

        bodyPart.get(0).getChildObject().get(5).getChildObject().get(0).rotateObject(3.13f, 1f, 0f, 0f);// putar biar bgs kliatannya
        bodyPart.get(0).getChildObject().get(5).getChildObject().get(0).translateObject(-0.44f, 0.26f, 0.5f); // POSISI

        //buletan dasi
        bodyPart.get(0).getChildObject().get(0).getChildObject().add(new Wheezy_Object(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\LEGION\\IdeaProjects\\GrafkomBANG\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.vert"
                                , GL_VERTEX_SHADER),

                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\LEGION\\IdeaProjects\\GrafkomBANG\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.frag"
                                , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new ArrayList<>(
                ),
                new Vector4f(1f, 0f, 0f, 1.0f),// color
                0.00,// radius
                new ArrayList<>(List.of(0f, 0f, 0f)),// center point
                0.03f,// titik x
                0.02f,// titik y
                0.04f,// titik z
                15, // Stack -->
                30, // Sector --> Titik
                4));// option

        bodyPart.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject(-0.40f, 0f, 1f, 0f);// putar biar bgs kliatannya
        bodyPart.get(0).getChildObject().get(0).getChildObject().get(0).translateObject(-0.35f, -0.009f, 0.2f);// POSISI


        //dasi kanan
        bodyPart.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().add(new Wheezy_Object(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\LEGION\\IdeaProjects\\GrafkomBANG\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.vert"
                                , GL_VERTEX_SHADER),

                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\LEGION\\IdeaProjects\\GrafkomBANG\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.frag"
                                , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new ArrayList<>(
                ),
                new Vector4f(1f, 0f, 0f, 1.0f),// color
                0.00,// radius
                new ArrayList<>(List.of(0f, 0f, 0f)),// center point
                0.07f,// titik x
                0.068f,// titik y
                0.07f,// titik z
                15, // Stack -->
                30, // Sector --> Titik
                6));// option

        bodyPart.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).rotateObject(29.81f, 1f, 0f, 0f);// putar biar bgs kliatannya
        bodyPart.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).rotateObject(-30.40f, 0f, 1f, 0f);// putar biar bgs kliatannya
        bodyPart.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).translateObject(-0.4f, -0.009f, 0.40f);// POSISI

        //dasi kiri
        bodyPart.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().add(new Wheezy_Object(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\LEGION\\IdeaProjects\\GrafkomBANG\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.vert"
                                , GL_VERTEX_SHADER),

                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\LEGION\\IdeaProjects\\GrafkomBANG\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.frag"
                                , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new ArrayList<>(
                ),
                new Vector4f(1f, 0f, 0f, 1.0f),// color
                0.00,// radius
                new ArrayList<>(List.of(0f, 0f, 0f)),// center point
                0.07f,// titik x
                0.068f,// titik y
                0.07f,// titik z
                15, // Stack -->
                30, // Sector --> Titik
                6));// option

        bodyPart.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(1).rotateObject(29.81f, 1f, 0f, 0f);// putar biar bgs kliatannya
        bodyPart.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(1).rotateObject(29.3f, 0f, 1f, 0f);// putar biar bgs kliatannya
        bodyPart.get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(1).translateObject(-0.465f, -0.007f, 0.40f);// POSISI

        //kaki kiri
        bodyPart.get(0).getChildObject().add(new Wheezy_Object(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\LEGION\\IdeaProjects\\GrafkomBANG\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.vert"
                                , GL_VERTEX_SHADER),

                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\LEGION\\IdeaProjects\\GrafkomBANG\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.frag"
                                , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.89f, 0.87f, 0.74f, 1.0f),// color
                0.00,// radius
                new ArrayList<>(List.of(0f, 0f, 0f)),// center point
                0.2f,// titik x
                0.3f,// titik y
                0.11f,// titik z
                150, // Stack -->
                150, // Sector --> Titik
                4));// option

        bodyPart.get(0).getChildObject().get(6).rotateObject(1.57f, 1f, 0f, 0f);// putar biar bgs kliatannya
        bodyPart.get(0).getChildObject().get(6).rotateObject(90f, 0f, 1f, 0f);// putar biar bgs kliatannya
        bodyPart.get(0).getChildObject().get(6).translateObject(-0.5f, -0.41f, 0.1f);

        //kaki kanan
        bodyPart.get(0).getChildObject().add(new Wheezy_Object(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\LEGION\\IdeaProjects\\GrafkomBANG\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.vert"
                                , GL_VERTEX_SHADER),

                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\LEGION\\IdeaProjects\\GrafkomBANG\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.frag"
                                , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.89f, 0.87f, 0.74f, 1.0f),// color
                0.00,// radius
                new ArrayList<>(List.of(0f, 0f, 0f)),// center point
                0.2f,// titik x
                0.3f,// titik y
                0.11f,// titik z
                150, // Stack -->
                150, // Sector --> Titik
                4));// option

        bodyPart.get(0).getChildObject().get(7).rotateObject(1.57f, 1f, 0f, 0f);// putar biar bgs kliatannya
        bodyPart.get(0).getChildObject().get(7).rotateObject(-60f, 0f, 1f, 0f);// putar biar bgs kliatannya
        bodyPart.get(0).getChildObject().get(7).translateObject(-0.2f, -0.41f, 0.3f);

        //pantat penguin
        bodyPart.get(0).getChildObject().add(new Wheezy_Object(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\LEGION\\IdeaProjects\\GrafkomBANG\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.vert"
                                , GL_VERTEX_SHADER),

                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\LEGION\\IdeaProjects\\GrafkomBANG\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.frag"
                                , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new ArrayList<>(
                ),
                new Vector4f(0f, 0f, 0f, 1.0f),// color
                0.00,// radius
                new ArrayList<>(List.of(0f, 0f, 0f)),// center point
                0.2f,// titik x
                0.3f,// titik y
                0.15f,// titik z
                150, // Stack -->
                150, // Sector --> Titik
                4));// option

        bodyPart.get(0).getChildObject().get(8).rotateObject(-0.40f, 0f, 1f, 0f);// putar biar bgs kliatannya
        bodyPart.get(0).getChildObject().get(8).translateObject(-0.23f, -0.21f, -0.14f);

        //alis penguin kanan
        bodyPart.get(0).getChildObject().add(new SphereBabi(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\LEGION\\IdeaProjects\\GrafkomBANG\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.vert"
                                , GL_VERTEX_SHADER),

                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\LEGION\\IdeaProjects\\GrafkomBANG\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.frag"
                                , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(1.0f, 0.0f, 0.0f, 1.0f),
                List.of(0.0f, 0.0f, 0.0f),
                0.24f,
                0.24f,
                Arrays.asList(
                        new Vector3f(-0.095f,0.19f,0.60f),//TITIK1
                        new Vector3f(-0.05f,0.22f,0.60f), //TITIK2
                        new Vector3f(-0.01f,0.19f,0.60f) //TITIK3
                )
        ));
        bodyPart.get(0).getChildObject().get(9).rotateObject(0.6f,1f, 0.0f, 0.0f);
        bodyPart.get(0).getChildObject().get(9).rotateObject(-0.28f,0f, 1.0f, 0.0f);
        bodyPart.get(0).getChildObject().get(9).translateObject(-0.16f, 0.7f, -0.18f);


        //alis penguin Kiri
        bodyPart.get(0).getChildObject().add(new SphereBabi(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\LEGION\\IdeaProjects\\GrafkomBANG\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.vert"
                                , GL_VERTEX_SHADER),

                        new ShaderProgram.ShaderModuleData(
                                "C:\\Users\\LEGION\\IdeaProjects\\GrafkomBANG\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.frag"
                                , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(1.0f, 0.0f, 0.0f, 1.0f),
                List.of(0.0f, 0.0f, 0.0f),
                0.24f,
                0.24f,
                Arrays.asList(
                        new Vector3f(-0.095f,0.19f,0.60f),//TITIK1
                        new Vector3f(-0.05f,0.22f,0.60f), //TITIK2
                        new Vector3f(-0.01f,0.19f,0.60f) //TITIK3
                )
        ));
        bodyPart.get(0).getChildObject().get(10).rotateObject(0.6f,1f, 0.0f, -0.0f);
        bodyPart.get(0).getChildObject().get(10).rotateObject(-0.28f,0f, 1.0f, -0.0f);
        bodyPart.get(0).getChildObject().get(10).translateObject(-0.285f, 0.7f, -0.25f);


    }
    //parameter gerak
    private float countjalan=0;
    private float countnoleh=0;
    private float countngangguk =0;
    private boolean kaki = true;


    float counterParuhArron = 0f;
    boolean cekParuhArron = true;

    float counterMataArron = 0f;
    boolean cekMataArron = true;

    float counterJalanArron = 0f;
    boolean cekJalanArron = true;

    float counterJalanDepanArron = 0f;
    boolean cekJalanDepanArron = true;


    public void input() {
        //animasi Hann c14210057 - Christian Philip Tjahyadi
        // maju
        if(window.isKeyPressed(GLFW_KEY_1)){
            Babi.get(0).translateObject(0.0f,0.0f,0.005f);
            if(kaki) {
                countjalan++;
                Vector3f tempCenterPoint = Babi.get(0).getChildObject().get(7).updateCenterPoint();
                Babi.get(0).getChildObject().get(7).translateObject(tempCenterPoint.x*-1,tempCenterPoint.y*-1,tempCenterPoint.z*-1);
                Babi.get(0).getChildObject().get(7).rotateObject((float) Math.toRadians(1.0f),0.0f, 1.0f, 0.0f);
                Babi.get(0).getChildObject().get(7).translateObject(tempCenterPoint.x*1,tempCenterPoint.y*1,tempCenterPoint.z*1);

                Vector3f tempCenterPoint2 = Babi.get(0).getChildObject().get(6).updateCenterPoint();
                Babi.get(0).getChildObject().get(6).translateObject(tempCenterPoint2.x*-1,tempCenterPoint2.y*-1,tempCenterPoint2.z*-1);
                Babi.get(0).getChildObject().get(6).rotateObject((float) Math.toRadians(1.0f),0.0f, 1.0f, 0.0f);
                Babi.get(0).getChildObject().get(6).translateObject(tempCenterPoint2.x*1,tempCenterPoint2.y*1,tempCenterPoint2.z*1);

                Vector3f tempCenterPoint3 = Babi.get(0).getChildObject().get(5).updateCenterPoint();
                Babi.get(0).getChildObject().get(5).translateObject(tempCenterPoint3.x*-1,tempCenterPoint3.y*-1,tempCenterPoint3.z*-1);
                Babi.get(0).getChildObject().get(5).rotateObject((float) Math.toRadians(1.0f),0.0f, 1.0f, 0.0f);
                Babi.get(0).getChildObject().get(5).translateObject(tempCenterPoint3.x*1,tempCenterPoint3.y*1,tempCenterPoint3.z*1);

                Vector3f tempCenterPoint4 = Babi.get(0).getChildObject().get(4).updateCenterPoint();
                Babi.get(0).getChildObject().get(4).translateObject(tempCenterPoint4.x*-1,tempCenterPoint4.y*-1,tempCenterPoint4.z*-1);
                Babi.get(0).getChildObject().get(4).rotateObject((float) Math.toRadians(1.0f),0.0f, 1.0f, 0.0f);
                Babi.get(0).getChildObject().get(4).translateObject(tempCenterPoint4.x*1,tempCenterPoint4.y*1,tempCenterPoint4.z*1);


                if (countjalan == 15.0f) {
                    kaki = false;
                }
            } else{
                countjalan--;
                Vector3f tempCenterPoint = Babi.get(0).getChildObject().get(7).updateCenterPoint();
                Babi.get(0).getChildObject().get(7).translateObject(tempCenterPoint.x*-1,tempCenterPoint.y*-1,tempCenterPoint.z*-1);
                Babi.get(0).getChildObject().get(7).rotateObject((float) Math.toRadians(-1.0f),0.0f, 1.0f, 0.0f);
                Babi.get(0).getChildObject().get(7).translateObject(tempCenterPoint.x*1,tempCenterPoint.y*1,tempCenterPoint.z*1);

                Vector3f tempCenterPoint2 = Babi.get(0).getChildObject().get(6).updateCenterPoint();
                Babi.get(0).getChildObject().get(6).translateObject(tempCenterPoint2.x*-1,tempCenterPoint2.y*-1,tempCenterPoint2.z*-1);
                Babi.get(0).getChildObject().get(6).rotateObject((float) Math.toRadians(-1.0f),0.0f, 1.0f, 0.0f);
                Babi.get(0).getChildObject().get(6).translateObject(tempCenterPoint2.x*1,tempCenterPoint2.y*1,tempCenterPoint2.z*1);

                Vector3f tempCenterPoint3 = Babi.get(0).getChildObject().get(5).updateCenterPoint();
                Babi.get(0).getChildObject().get(5).translateObject(tempCenterPoint3.x*-1,tempCenterPoint3.y*-1,tempCenterPoint3.z*-1);
                Babi.get(0).getChildObject().get(5).rotateObject((float) Math.toRadians(-1.0f),0.0f, 1.0f, 0.0f);
                Babi.get(0).getChildObject().get(5).translateObject(tempCenterPoint3.x*1,tempCenterPoint3.y*1,tempCenterPoint3.z*1);

                Vector3f tempCenterPoint4 = Babi.get(0).getChildObject().get(4).updateCenterPoint();
                Babi.get(0).getChildObject().get(4).translateObject(tempCenterPoint4.x*-1,tempCenterPoint4.y*-1,tempCenterPoint4.z*-1);
                Babi.get(0).getChildObject().get(4).rotateObject((float) Math.toRadians(-1.0f),0.0f, 1.0f, 0.0f);
                Babi.get(0).getChildObject().get(4).translateObject(tempCenterPoint4.x*1,tempCenterPoint4.y*1,tempCenterPoint4.z*1);

                if(countjalan ==-15.0f){
                    kaki = true;
                }
            }
        }
        // mundur
        if(window.isKeyPressed(GLFW_KEY_2)){
            Babi.get(0).translateObject(0.0f,0.0f,-0.005f);
            if(kaki) {
                countjalan++;
                Vector3f tempCenterPoint = Babi.get(0).getChildObject().get(7).updateCenterPoint();
                Babi.get(0).getChildObject().get(7).translateObject(tempCenterPoint.x*-1,tempCenterPoint.y*-1,tempCenterPoint.z*-1);
                Babi.get(0).getChildObject().get(7).rotateObject((float) Math.toRadians(1.0f),0.0f, 1.0f, 0.0f);
                Babi.get(0).getChildObject().get(7).translateObject(tempCenterPoint.x*1,tempCenterPoint.y*1,tempCenterPoint.z*1);

                Vector3f tempCenterPoint2 = Babi.get(0).getChildObject().get(6).updateCenterPoint();
                Babi.get(0).getChildObject().get(6).translateObject(tempCenterPoint2.x*-1,tempCenterPoint2.y*-1,tempCenterPoint2.z*-1);
                Babi.get(0).getChildObject().get(6).rotateObject((float) Math.toRadians(1.0f),0.0f, 1.0f, 0.0f);
                Babi.get(0).getChildObject().get(6).translateObject(tempCenterPoint2.x*1,tempCenterPoint2.y*1,tempCenterPoint2.z*1);

                Vector3f tempCenterPoint3 = Babi.get(0).getChildObject().get(5).updateCenterPoint();
                Babi.get(0).getChildObject().get(5).translateObject(tempCenterPoint3.x*-1,tempCenterPoint3.y*-1,tempCenterPoint3.z*-1);
                Babi.get(0).getChildObject().get(5).rotateObject((float) Math.toRadians(1.0f),0.0f, 1.0f, 0.0f);
                Babi.get(0).getChildObject().get(5).translateObject(tempCenterPoint3.x*1,tempCenterPoint3.y*1,tempCenterPoint3.z*1);

                Vector3f tempCenterPoint4 = Babi.get(0).getChildObject().get(4).updateCenterPoint();
                Babi.get(0).getChildObject().get(4).translateObject(tempCenterPoint4.x*-1,tempCenterPoint4.y*-1,tempCenterPoint4.z*-1);
                Babi.get(0).getChildObject().get(4).rotateObject((float) Math.toRadians(1.0f),0.0f, 1.0f, 0.0f);
                Babi.get(0).getChildObject().get(4).translateObject(tempCenterPoint4.x*1,tempCenterPoint4.y*1,tempCenterPoint4.z*1);


                if (countjalan == 15.0f) {
                    kaki = false;
                }
            } else{
                countjalan--;
                Vector3f tempCenterPoint = Babi.get(0).getChildObject().get(7).updateCenterPoint();
                Babi.get(0).getChildObject().get(7).translateObject(tempCenterPoint.x*-1,tempCenterPoint.y*-1,tempCenterPoint.z*-1);
                Babi.get(0).getChildObject().get(7).rotateObject((float) Math.toRadians(-1.0f),0.0f, 1.0f, 0.0f);
                Babi.get(0).getChildObject().get(7).translateObject(tempCenterPoint.x*1,tempCenterPoint.y*1,tempCenterPoint.z*1);

                Vector3f tempCenterPoint2 = Babi.get(0).getChildObject().get(6).updateCenterPoint();
                Babi.get(0).getChildObject().get(6).translateObject(tempCenterPoint2.x*-1,tempCenterPoint2.y*-1,tempCenterPoint2.z*-1);
                Babi.get(0).getChildObject().get(6).rotateObject((float) Math.toRadians(-1.0f),0.0f, 1.0f, 0.0f);
                Babi.get(0).getChildObject().get(6).translateObject(tempCenterPoint2.x*1,tempCenterPoint2.y*1,tempCenterPoint2.z*1);

                Vector3f tempCenterPoint3 = Babi.get(0).getChildObject().get(5).updateCenterPoint();
                Babi.get(0).getChildObject().get(5).translateObject(tempCenterPoint3.x*-1,tempCenterPoint3.y*-1,tempCenterPoint3.z*-1);
                Babi.get(0).getChildObject().get(5).rotateObject((float) Math.toRadians(-1.0f),0.0f, 1.0f, 0.0f);
                Babi.get(0).getChildObject().get(5).translateObject(tempCenterPoint3.x*1,tempCenterPoint3.y*1,tempCenterPoint3.z*1);

                Vector3f tempCenterPoint4 = Babi.get(0).getChildObject().get(4).updateCenterPoint();
                Babi.get(0).getChildObject().get(4).translateObject(tempCenterPoint4.x*-1,tempCenterPoint4.y*-1,tempCenterPoint4.z*-1);
                Babi.get(0).getChildObject().get(4).rotateObject((float) Math.toRadians(-1.0f),0.0f, 1.0f, 0.0f);
                Babi.get(0).getChildObject().get(4).translateObject(tempCenterPoint4.x*1,tempCenterPoint4.y*1,tempCenterPoint4.z*1);

                if(countjalan ==-15.0f){
                    kaki = true;
                }
            }
        }
        //JALAN KANAN
        if(window.isKeyPressed(GLFW_KEY_3)){
            Babi.get(0).translateObject(0.005f,0.0f,0.0f);
            if(kaki) {
                countjalan++;
                Vector3f tempCenterPoint = Babi.get(0).getChildObject().get(7).updateCenterPoint();
                Babi.get(0).getChildObject().get(7).translateObject(tempCenterPoint.x*-1,tempCenterPoint.y*-1,tempCenterPoint.z*-1);
                Babi.get(0).getChildObject().get(7).rotateObject((float) Math.toRadians(1.0f),0.0f, 1.0f, 0.0f);
                Babi.get(0).getChildObject().get(7).translateObject(tempCenterPoint.x*1,tempCenterPoint.y*1,tempCenterPoint.z*1);

                Vector3f tempCenterPoint2 = Babi.get(0).getChildObject().get(6).updateCenterPoint();
                Babi.get(0).getChildObject().get(6).translateObject(tempCenterPoint2.x*-1,tempCenterPoint2.y*-1,tempCenterPoint2.z*-1);
                Babi.get(0).getChildObject().get(6).rotateObject((float) Math.toRadians(1.0f),0.0f, 1.0f, 0.0f);
                Babi.get(0).getChildObject().get(6).translateObject(tempCenterPoint2.x*1,tempCenterPoint2.y*1,tempCenterPoint2.z*1);

                Vector3f tempCenterPoint3 = Babi.get(0).getChildObject().get(5).updateCenterPoint();
                Babi.get(0).getChildObject().get(5).translateObject(tempCenterPoint3.x*-1,tempCenterPoint3.y*-1,tempCenterPoint3.z*-1);
                Babi.get(0).getChildObject().get(5).rotateObject((float) Math.toRadians(1.0f),0.0f, 1.0f, 0.0f);
                Babi.get(0).getChildObject().get(5).translateObject(tempCenterPoint3.x*1,tempCenterPoint3.y*1,tempCenterPoint3.z*1);

                Vector3f tempCenterPoint4 = Babi.get(0).getChildObject().get(4).updateCenterPoint();
                Babi.get(0).getChildObject().get(4).translateObject(tempCenterPoint4.x*-1,tempCenterPoint4.y*-1,tempCenterPoint4.z*-1);
                Babi.get(0).getChildObject().get(4).rotateObject((float) Math.toRadians(1.0f),0.0f, 1.0f, 0.0f);
                Babi.get(0).getChildObject().get(4).translateObject(tempCenterPoint4.x*1,tempCenterPoint4.y*1,tempCenterPoint4.z*1);


                if (countjalan == 15.0f) {
                    kaki = false;
                }
            } else{
                countjalan--;
                Vector3f tempCenterPoint = Babi.get(0).getChildObject().get(7).updateCenterPoint();
                Babi.get(0).getChildObject().get(7).translateObject(tempCenterPoint.x*-1,tempCenterPoint.y*-1,tempCenterPoint.z*-1);
                Babi.get(0).getChildObject().get(7).rotateObject((float) Math.toRadians(-1.0f),0.0f, 1.0f, 0.0f);
                Babi.get(0).getChildObject().get(7).translateObject(tempCenterPoint.x*1,tempCenterPoint.y*1,tempCenterPoint.z*1);

                Vector3f tempCenterPoint2 = Babi.get(0).getChildObject().get(6).updateCenterPoint();
                Babi.get(0).getChildObject().get(6).translateObject(tempCenterPoint2.x*-1,tempCenterPoint2.y*-1,tempCenterPoint2.z*-1);
                Babi.get(0).getChildObject().get(6).rotateObject((float) Math.toRadians(-1.0f),0.0f, 1.0f, 0.0f);
                Babi.get(0).getChildObject().get(6).translateObject(tempCenterPoint2.x*1,tempCenterPoint2.y*1,tempCenterPoint2.z*1);

                Vector3f tempCenterPoint3 = Babi.get(0).getChildObject().get(5).updateCenterPoint();
                Babi.get(0).getChildObject().get(5).translateObject(tempCenterPoint3.x*-1,tempCenterPoint3.y*-1,tempCenterPoint3.z*-1);
                Babi.get(0).getChildObject().get(5).rotateObject((float) Math.toRadians(-1.0f),0.0f, 1.0f, 0.0f);
                Babi.get(0).getChildObject().get(5).translateObject(tempCenterPoint3.x*1,tempCenterPoint3.y*1,tempCenterPoint3.z*1);

                Vector3f tempCenterPoint4 = Babi.get(0).getChildObject().get(4).updateCenterPoint();
                Babi.get(0).getChildObject().get(4).translateObject(tempCenterPoint4.x*-1,tempCenterPoint4.y*-1,tempCenterPoint4.z*-1);
                Babi.get(0).getChildObject().get(4).rotateObject((float) Math.toRadians(-1.0f),0.0f, 1.0f, 0.0f);
                Babi.get(0).getChildObject().get(4).translateObject(tempCenterPoint4.x*1,tempCenterPoint4.y*1,tempCenterPoint4.z*1);

                if(countjalan ==-15.0f){
                    kaki = true;
                }
            }
        }
        //JALAN KIRI
        if(window.isKeyPressed(GLFW_KEY_4)){
            Babi.get(0).translateObject(-0.005f,0.0f,0.0f);
            if(kaki) {
                countjalan++;
                Vector3f tempCenterPoint = Babi.get(0).getChildObject().get(7).updateCenterPoint();
                Babi.get(0).getChildObject().get(7).translateObject(tempCenterPoint.x*-1,tempCenterPoint.y*-1,tempCenterPoint.z*-1);
                Babi.get(0).getChildObject().get(7).rotateObject((float) Math.toRadians(1.0f),0.0f, 1.0f, 0.0f);
                Babi.get(0).getChildObject().get(7).translateObject(tempCenterPoint.x*1,tempCenterPoint.y*1,tempCenterPoint.z*1);

                Vector3f tempCenterPoint2 = Babi.get(0).getChildObject().get(6).updateCenterPoint();
                Babi.get(0).getChildObject().get(6).translateObject(tempCenterPoint2.x*-1,tempCenterPoint2.y*-1,tempCenterPoint2.z*-1);
                Babi.get(0).getChildObject().get(6).rotateObject((float) Math.toRadians(1.0f),0.0f, 1.0f, 0.0f);
                Babi.get(0).getChildObject().get(6).translateObject(tempCenterPoint2.x*1,tempCenterPoint2.y*1,tempCenterPoint2.z*1);

                Vector3f tempCenterPoint3 = Babi.get(0).getChildObject().get(5).updateCenterPoint();
                Babi.get(0).getChildObject().get(5).translateObject(tempCenterPoint3.x*-1,tempCenterPoint3.y*-1,tempCenterPoint3.z*-1);
                Babi.get(0).getChildObject().get(5).rotateObject((float) Math.toRadians(1.0f),0.0f, 1.0f, 0.0f);
                Babi.get(0).getChildObject().get(5).translateObject(tempCenterPoint3.x*1,tempCenterPoint3.y*1,tempCenterPoint3.z*1);

                Vector3f tempCenterPoint4 = Babi.get(0).getChildObject().get(4).updateCenterPoint();
                Babi.get(0).getChildObject().get(4).translateObject(tempCenterPoint4.x*-1,tempCenterPoint4.y*-1,tempCenterPoint4.z*-1);
                Babi.get(0).getChildObject().get(4).rotateObject((float) Math.toRadians(1.0f),0.0f, 1.0f, 0.0f);
                Babi.get(0).getChildObject().get(4).translateObject(tempCenterPoint4.x*1,tempCenterPoint4.y*1,tempCenterPoint4.z*1);


                if (countjalan == 15.0f) {
                    kaki = false;
                }
            } else{
                countjalan--;
                Vector3f tempCenterPoint = Babi.get(0).getChildObject().get(7).updateCenterPoint();
                Babi.get(0).getChildObject().get(7).translateObject(tempCenterPoint.x*-1,tempCenterPoint.y*-1,tempCenterPoint.z*-1);
                Babi.get(0).getChildObject().get(7).rotateObject((float) Math.toRadians(-1.0f),0.0f, 1.0f, 0.0f);
                Babi.get(0).getChildObject().get(7).translateObject(tempCenterPoint.x*1,tempCenterPoint.y*1,tempCenterPoint.z*1);

                Vector3f tempCenterPoint2 = Babi.get(0).getChildObject().get(6).updateCenterPoint();
                Babi.get(0).getChildObject().get(6).translateObject(tempCenterPoint2.x*-1,tempCenterPoint2.y*-1,tempCenterPoint2.z*-1);
                Babi.get(0).getChildObject().get(6).rotateObject((float) Math.toRadians(-1.0f),0.0f, 1.0f, 0.0f);
                Babi.get(0).getChildObject().get(6).translateObject(tempCenterPoint2.x*1,tempCenterPoint2.y*1,tempCenterPoint2.z*1);

                Vector3f tempCenterPoint3 = Babi.get(0).getChildObject().get(5).updateCenterPoint();
                Babi.get(0).getChildObject().get(5).translateObject(tempCenterPoint3.x*-1,tempCenterPoint3.y*-1,tempCenterPoint3.z*-1);
                Babi.get(0).getChildObject().get(5).rotateObject((float) Math.toRadians(-1.0f),0.0f, 1.0f, 0.0f);
                Babi.get(0).getChildObject().get(5).translateObject(tempCenterPoint3.x*1,tempCenterPoint3.y*1,tempCenterPoint3.z*1);

                Vector3f tempCenterPoint4 = Babi.get(0).getChildObject().get(4).updateCenterPoint();
                Babi.get(0).getChildObject().get(4).translateObject(tempCenterPoint4.x*-1,tempCenterPoint4.y*-1,tempCenterPoint4.z*-1);
                Babi.get(0).getChildObject().get(4).rotateObject((float) Math.toRadians(-1.0f),0.0f, 1.0f, 0.0f);
                Babi.get(0).getChildObject().get(4).translateObject(tempCenterPoint4.x*1,tempCenterPoint4.y*1,tempCenterPoint4.z*1);

                if(countjalan ==-15.0f){
                    kaki = true;
                }
            }
        }

        // menoleh kanan
        if (window.isKeyPressed(GLFW_KEY_E)) {

            if (countnoleh < 30.0f) {
                Vector3f tempCenterPoint = Babi.get(0).getChildObject().get(0).updateCenterPoint();
                Babi.get(0).getChildObject().get(0).translateObject(tempCenterPoint.x*-1,tempCenterPoint.y*-1,tempCenterPoint.z*-1);
                countnoleh++;
                Babi.get(0).getChildObject().get(0).rotateObject((float) Math.toRadians(1.0f), 0.0f, 1.0f, 0.0f);
                Babi.get(0).getChildObject().get(0).translateObject(tempCenterPoint.x*1,tempCenterPoint.y*1,tempCenterPoint.z*1);
            }
        }
        // menoleh kiri
        if (window.isKeyPressed(GLFW_KEY_Q)) {
            if (countnoleh > -30.0f) {
                Vector3f tempCenterPoint = Babi.get(0).getChildObject().get(0).updateCenterPoint();
                Babi.get(0).getChildObject().get(0).translateObject(tempCenterPoint.x*-1,tempCenterPoint.y*-1,tempCenterPoint.z*-1);
                countnoleh--;
                Babi.get(0).getChildObject().get(0).rotateObject((float) Math.toRadians(-1.0f), 0.0f, 1.0f, 0.0f);
                Babi.get(0).getChildObject().get(0).translateObject(tempCenterPoint.x*1,tempCenterPoint.y*1,tempCenterPoint.z*1);
            }
        }
        // hadap atas
        if (window.isKeyPressed(GLFW_KEY_C)) {

            if (countngangguk < 20.0f) {
                Vector3f tempCenterPoint = Babi.get(0).getChildObject().get(0).updateCenterPoint();
                Babi.get(0).getChildObject().get(0).translateObject(tempCenterPoint.x*-1,tempCenterPoint.y*-1,tempCenterPoint.z*-1);
                countngangguk++;
                Babi.get(0).getChildObject().get(0).rotateObject((float) Math.toRadians(1.0f), 1.0f, 0.0f, 0.0f);
                Babi.get(0).getChildObject().get(0).translateObject(tempCenterPoint.x*1,tempCenterPoint.y*1,tempCenterPoint.z*1);
            }
        }
        // hadap bawah
        if (window.isKeyPressed(GLFW_KEY_Z)) {
            if (countngangguk > -20.0f) {
                Vector3f tempCenterPoint = Babi.get(0).getChildObject().get(0).updateCenterPoint();
                Babi.get(0).getChildObject().get(0).translateObject(tempCenterPoint.x*-1,tempCenterPoint.y*-1,tempCenterPoint.z*-1);
                countngangguk--;
                Babi.get(0).getChildObject().get(0).rotateObject((float) Math.toRadians(-1.0f), 1.0f, 0.0f, 0.0f);
                Babi.get(0).getChildObject().get(0).translateObject(tempCenterPoint.x*1,tempCenterPoint.y*1,tempCenterPoint.z*1);
            }
        }


        //wasd
        // rotate ke atas dan kebawah bikin erorr
        if (window.isKeyPressed(GLFW_KEY_W)) {
            Vector3f tempCenterPointw = Babi.get(0).updateCenterPoint();
            Babi.get(0).translateObject(tempCenterPointw.x*-1,tempCenterPointw.y*-1,tempCenterPointw.z*-1);

            Babi.get(0).rotateObject(0.05f, 1f, 0f, 0f);
            Babi.get(0).translateObject(tempCenterPointw.x*1,tempCenterPointw.y*1,tempCenterPointw.z*1);

//            BG.get(0).rotateObject(0.05f, 1f, 0f, 0f);

        }

        if (window.isKeyPressed(GLFW_KEY_S)) {
            Vector3f tempCenterPoints = Babi.get(0).updateCenterPoint();
            Babi.get(0).translateObject(tempCenterPoints.x*-1,tempCenterPoints.y*-1,tempCenterPoints.z*-1);
            Babi.get(0).rotateObject(-0.05f, 1f, 0f, 0f);
            Babi.get(0).translateObject(tempCenterPoints.x*1,tempCenterPoints.y*1,tempCenterPoints.z*1);

//            BG.get(0).rotateObject(-0.05f, 1f, 0f, 0f);
        }

        if (window.isKeyPressed(GLFW_KEY_A)) {
            Vector3f tempCenterPointsa = Babi.get(0).updateCenterPoint();
            Babi.get(0).translateObject(tempCenterPointsa.x*-1,tempCenterPointsa.y*-1,tempCenterPointsa.z*-1);
            Babi.get(0).rotateObject(-0.05f, 0f, 1f, 0f);
            Babi.get(0).translateObject(tempCenterPointsa.x*1,tempCenterPointsa.y*1,tempCenterPointsa.z*1);


//            BG.get(0).rotateObject(-0.05f, 0f, 1f, 0f);
        }

        if (window.isKeyPressed(GLFW_KEY_D)) {
            Vector3f tempCenterPointsd = Babi.get(0).updateCenterPoint();
            Babi.get(0).translateObject(tempCenterPointsd.x*-1,tempCenterPointsd.y*-1,tempCenterPointsd.z*-1);
            Babi.get(0).rotateObject(0.05f, 0f, 1f, 0f);
            Babi.get(0).translateObject(tempCenterPointsd.x*1,tempCenterPointsd.y*1,tempCenterPointsd.z*1);


//            BG.get(0).rotateObject(0.05f, 0f, 1f, 0f);
        }


        // Arron

        if (window.isKeyPressed(GLFW_KEY_U)) {
            if (cekParuhArron == true) {
                Vector3f tempCenterPoint = bodyPart.get(0).getChildObject().get(5).getChildObject().get(0).updateCenterPoint();
                bodyPart.get(0).getChildObject().get(5).getChildObject().get(0).translateObject(tempCenterPoint.x * -1,tempCenterPoint.y * -1,tempCenterPoint.z *-1);
                counterParuhArron ++;
                bodyPart.get(0).getChildObject().get(5).getChildObject().get(0).rotateObjectOnPoint((float) Math.toRadians(-0.1/1.5f), 1.0f, 0.0f, 0.0f,-0.44f, 0.3f, 0.51f);
                bodyPart.get(0).getChildObject().get(5).getChildObject().get(0).translateObject(tempCenterPoint.x * 1,tempCenterPoint.y * 1,tempCenterPoint.z * 1);
            }
            else {
                Vector3f tempCenterPoint2 = bodyPart.get(0).getChildObject().get(5).getChildObject().get(0).updateCenterPoint();
                bodyPart.get(0).getChildObject().get(5).getChildObject().get(0).translateObject(tempCenterPoint2.x * -1,tempCenterPoint2.y * -1,tempCenterPoint2.z * -1);
                counterParuhArron --;
                bodyPart.get(0).getChildObject().get(5).getChildObject().get(0).rotateObjectOnPoint((float) Math.toRadians(0.1/1.5f), 1.0f, 0.0f, 0.0f,-0.44f, 0.3f, 0.51f);
                bodyPart.get(0).getChildObject().get(5).getChildObject().get(0).translateObject(tempCenterPoint2.x * 1, tempCenterPoint2.y* 1,tempCenterPoint2.z* 1);
            }
            if (counterParuhArron == 40.0f){
                cekParuhArron = false;
            }
            if(counterParuhArron == 0.0f){
                cekParuhArron = true;
            }
        }

        //gerakkin mata
        if (window.isKeyPressed(GLFW_KEY_O)) {
            if (cekMataArron == true) {
                counterMataArron++;
                Vector3f tempCenterPoint = bodyPart.get(0).getChildObject().get(3).getChildObject().get(0).updateCenterPoint();
                bodyPart.get(0).getChildObject().get(3).getChildObject().get(0).translateObject(tempCenterPoint.x*-1,tempCenterPoint.y*-1,tempCenterPoint.z*-1);
                bodyPart.get(0).getChildObject().get(3).getChildObject().get(0).rotateObject((float) Math.toRadians(-1.0f/3),1.0f, 0.0f, 0.0f);
                bodyPart.get(0).getChildObject().get(3).getChildObject().get(0).translateObject(tempCenterPoint.x*1,tempCenterPoint.y*1,tempCenterPoint.z*1);

                Vector3f tempCenterPoint2 = bodyPart.get(0).getChildObject().get(4).getChildObject().get(0).updateCenterPoint();
                bodyPart.get(0).getChildObject().get(4).getChildObject().get(0).translateObject(tempCenterPoint2.x*-1,tempCenterPoint2.y*-1,tempCenterPoint2.z*-1);
                bodyPart.get(0).getChildObject().get(4).getChildObject().get(0).rotateObject((float) Math.toRadians(-1.0f/3),1.0f, -.0f, 0.0f);
                bodyPart.get(0).getChildObject().get(4).getChildObject().get(0).translateObject(tempCenterPoint2.x*1,tempCenterPoint2.y*1,tempCenterPoint2.z*1);
            }
            else {
                counterMataArron--;
                Vector3f tempCenterPoint = bodyPart.get(0).getChildObject().get(3).getChildObject().get(0).updateCenterPoint();
                bodyPart.get(0).getChildObject().get(3).getChildObject().get(0).translateObject(tempCenterPoint.x*-1,tempCenterPoint.y*-1,tempCenterPoint.z*-1);
                bodyPart.get(0).getChildObject().get(3).getChildObject().get(0).rotateObject((float) Math.toRadians(1.0f/3),1.0f, 0.0f, 0.0f);
                bodyPart.get(0).getChildObject().get(3).getChildObject().get(0).translateObject(tempCenterPoint.x*1,tempCenterPoint.y*1,tempCenterPoint.z*1);

                Vector3f tempCenterPoint2 = bodyPart.get(0).getChildObject().get(4).getChildObject().get(0).updateCenterPoint();
                bodyPart.get(0).getChildObject().get(4).getChildObject().get(0).translateObject(tempCenterPoint2.x*-1,tempCenterPoint2.y*-1,tempCenterPoint2.z*-1);
                bodyPart.get(0).getChildObject().get(4).getChildObject().get(0).rotateObject((float) Math.toRadians(1.0f/3),1.0f, -.0f, 0.0f);
                bodyPart.get(0).getChildObject().get(4).getChildObject().get(0).translateObject(tempCenterPoint2.x*1,tempCenterPoint2.y*1,tempCenterPoint2.z*1);
            }
            if (counterMataArron== 12.0f){
                cekMataArron = false;
            }
            if(counterMataArron == 0){
                cekMataArron = true;
            }
        }

        // jalan samping kiri
        if (window.isKeyPressed(GLFW_KEY_9)) {
            bodyPart.get(0).translateObject(-0.002f,0.0f,0.0f);
            if(cekJalanArron == true) {
                counterJalanArron++;
                Vector3f tempCenterPoint = bodyPart.get(0).getChildObject().get(6).updateCenterPoint();
                bodyPart.get(0).getChildObject().get(6).translateObject(tempCenterPoint.x*-1,tempCenterPoint.y*-1,tempCenterPoint.z*-1);
                bodyPart.get(0).getChildObject().get(6).rotateObject((float) Math.toRadians(1.0f),0.0f, 1.0f, 0.0f);
                bodyPart.get(0).getChildObject().get(6).translateObject(tempCenterPoint.x*1,tempCenterPoint.y*1,tempCenterPoint.z*1);

                Vector3f tempCenterPoint2 = bodyPart.get(0).getChildObject().get(7).updateCenterPoint();
                bodyPart.get(0).getChildObject().get(7).translateObject(tempCenterPoint2.x*-1,tempCenterPoint2.y*-1,tempCenterPoint2.z*-1);
                bodyPart.get(0).getChildObject().get(7).rotateObject((float) Math.toRadians(1.0f),0.0f, 1.0f, 0.0f);
                bodyPart.get(0).getChildObject().get(7).translateObject(tempCenterPoint2.x*1,tempCenterPoint2.y*1,tempCenterPoint2.z*1);

            } else{
                Vector3f tempCenterPoint = bodyPart.get(0).getChildObject().get(6).updateCenterPoint();
                bodyPart.get(0).getChildObject().get(6).translateObject(tempCenterPoint.x*-1,tempCenterPoint.y*-1,tempCenterPoint.z*-1);
                bodyPart.get(0).getChildObject().get(6).rotateObject((float) Math.toRadians(-1.0f),0.0f, 1.0f, 0.0f);
                bodyPart.get(0).getChildObject().get(6).translateObject(tempCenterPoint.x*1,tempCenterPoint.y*1,tempCenterPoint.z*1);

                Vector3f tempCenterPoint2 = bodyPart.get(0).getChildObject().get(7).updateCenterPoint();
                bodyPart.get(0).getChildObject().get(7).translateObject(tempCenterPoint2.x*-1,tempCenterPoint2.y*-1,tempCenterPoint2.z*-1);
                bodyPart.get(0).getChildObject().get(7).rotateObject((float) Math.toRadians(-1.0f),0.0f, 1.0f, 0.0f);
                bodyPart.get(0).getChildObject().get(7).translateObject(tempCenterPoint2.x*1,tempCenterPoint2.y*1,tempCenterPoint2.z*1);
            }

            if (counterJalanArron == 800.0f){
                cekJalanArron = false;
            }
            if(counterJalanArron == 0.0f){
                cekJalanArron = true;
            }

        }

        // jalan samping kanan
        if (window.isKeyPressed(GLFW_KEY_0)) {
            bodyPart.get(0).translateObject(0.002f,0.0f,0.0f);
            if(cekJalanArron == true) {
                counterJalanArron++;
                Vector3f tempCenterPoint = bodyPart.get(0).getChildObject().get(6).updateCenterPoint();
                bodyPart.get(0).getChildObject().get(6).translateObject(tempCenterPoint.x*-1,tempCenterPoint.y*-1,tempCenterPoint.z*-1);
                bodyPart.get(0).getChildObject().get(6).rotateObject((float) Math.toRadians(1.0f),0.0f, 1.0f, 0.0f);
                bodyPart.get(0).getChildObject().get(6).translateObject(tempCenterPoint.x*1,tempCenterPoint.y*1,tempCenterPoint.z*1);

                Vector3f tempCenterPoint2 = bodyPart.get(0).getChildObject().get(7).updateCenterPoint();
                bodyPart.get(0).getChildObject().get(7).translateObject(tempCenterPoint2.x*-1,tempCenterPoint2.y*-1,tempCenterPoint2.z*-1);
                bodyPart.get(0).getChildObject().get(7).rotateObject((float) Math.toRadians(1.0f),0.0f, 1.0f, 0.0f);
                bodyPart.get(0).getChildObject().get(7).translateObject(tempCenterPoint2.x*1,tempCenterPoint2.y*1,tempCenterPoint2.z*1);

            } else{
                counterJalanArron--;
                Vector3f tempCenterPoint = bodyPart.get(0).getChildObject().get(6).updateCenterPoint();
                bodyPart.get(0).getChildObject().get(6).translateObject(tempCenterPoint.x*-1,tempCenterPoint.y*-1,tempCenterPoint.z*-1);
                bodyPart.get(0).getChildObject().get(6).rotateObject((float) Math.toRadians(-1.0f),0.0f, 1.0f, 0.0f);
                bodyPart.get(0).getChildObject().get(6).translateObject(tempCenterPoint.x*1,tempCenterPoint.y*1,tempCenterPoint.z*1);

                Vector3f tempCenterPoint2 = bodyPart.get(0).getChildObject().get(7).updateCenterPoint();
                bodyPart.get(0).getChildObject().get(7).translateObject(tempCenterPoint2.x*-1,tempCenterPoint2.y*-1,tempCenterPoint2.z*-1);
                bodyPart.get(0).getChildObject().get(7).rotateObject((float) Math.toRadians(-1.0f),0.0f, 1.0f, 0.0f);
                bodyPart.get(0).getChildObject().get(7).translateObject(tempCenterPoint2.x*1,tempCenterPoint2.y*1,tempCenterPoint2.z*1);
            }

            if (counterJalanArron == 800.0f){
                cekJalanArron = false;
            }
            if(counterJalanArron == 0.0f){
                cekJalanArron = true;
            }

        }

        // jalan depan
        if (window.isKeyPressed(GLFW_KEY_N)) {
            bodyPart.get(0).translateObject(0.0f,0.0f,0.002f);
            if(cekJalanDepanArron == true) {
                counterJalanDepanArron++;
                Vector3f tempCenterPoint = bodyPart.get(0).getChildObject().get(6).updateCenterPoint();
                bodyPart.get(0).getChildObject().get(6).translateObject(tempCenterPoint.x*-1,tempCenterPoint.y*-1,tempCenterPoint.z*-1);
                bodyPart.get(0).getChildObject().get(6).rotateObject((float) Math.toRadians(1.0f),1.0f, 0.0f, 0.0f);
                bodyPart.get(0).getChildObject().get(6).translateObject(tempCenterPoint.x*1,tempCenterPoint.y*1,tempCenterPoint.z*1);

                Vector3f tempCenterPoint2 = bodyPart.get(0).getChildObject().get(7).updateCenterPoint();
                bodyPart.get(0).getChildObject().get(7).translateObject(tempCenterPoint2.x*-1,tempCenterPoint2.y*-1,tempCenterPoint2.z*-1);
                bodyPart.get(0).getChildObject().get(7).rotateObject((float) Math.toRadians(-1.0f),1.0f, 0.0f, 0.0f);
                bodyPart.get(0).getChildObject().get(7).translateObject(tempCenterPoint2.x*1,tempCenterPoint2.y*1,tempCenterPoint2.z*1);

            } else{
                counterJalanDepanArron--;
                Vector3f tempCenterPoint = bodyPart.get(0).getChildObject().get(6).updateCenterPoint();
                bodyPart.get(0).getChildObject().get(6).translateObject(tempCenterPoint.x*-1,tempCenterPoint.y*-1,tempCenterPoint.z*-1);
                bodyPart.get(0).getChildObject().get(6).rotateObject((float) Math.toRadians(-1.0f),1.0f, 0.0f, 0.0f);
                bodyPart.get(0).getChildObject().get(6).translateObject(tempCenterPoint.x*1,tempCenterPoint.y*1,tempCenterPoint.z*1);

                Vector3f tempCenterPoint2 = bodyPart.get(0).getChildObject().get(7).updateCenterPoint();
                bodyPart.get(0).getChildObject().get(7).translateObject(tempCenterPoint2.x*-1,tempCenterPoint2.y*-1,tempCenterPoint2.z*-1);
                bodyPart.get(0).getChildObject().get(7).rotateObject((float) Math.toRadians(1.0f),1.0f, 0.0f, 0.0f);
                bodyPart.get(0).getChildObject().get(7).translateObject(tempCenterPoint2.x*1,tempCenterPoint2.y*1,tempCenterPoint2.z*1);
            }

            if (counterJalanDepanArron == 130.0f){
                cekJalanDepanArron = false;
            }
            if(counterJalanDepanArron == -100.0f){
                cekJalanDepanArron = true;
            }

        }

        if (window.isKeyPressed(GLFW_KEY_M)) {
            bodyPart.get(0).translateObject(0.0f,0.0f,-0.002f);
            if(cekJalanDepanArron == true) {
                counterJalanDepanArron++;
                Vector3f tempCenterPoint = bodyPart.get(0).getChildObject().get(6).updateCenterPoint();
                bodyPart.get(0).getChildObject().get(6).translateObject(tempCenterPoint.x*-1,tempCenterPoint.y*-1,tempCenterPoint.z*-1);
                bodyPart.get(0).getChildObject().get(6).rotateObject((float) Math.toRadians(1.0f),1.0f, 0.0f, 0.0f);
                bodyPart.get(0).getChildObject().get(6).translateObject(tempCenterPoint.x*1,tempCenterPoint.y*1,tempCenterPoint.z*1);

                Vector3f tempCenterPoint2 = bodyPart.get(0).getChildObject().get(7).updateCenterPoint();
                bodyPart.get(0).getChildObject().get(7).translateObject(tempCenterPoint2.x*-1,tempCenterPoint2.y*-1,tempCenterPoint2.z*-1);
                bodyPart.get(0).getChildObject().get(7).rotateObject((float) Math.toRadians(-1.0f),1.0f, 0.0f, 0.0f);
                bodyPart.get(0).getChildObject().get(7).translateObject(tempCenterPoint2.x*1,tempCenterPoint2.y*1,tempCenterPoint2.z*1);

            } else{
                counterJalanDepanArron--;
                Vector3f tempCenterPoint = bodyPart.get(0).getChildObject().get(6).updateCenterPoint();
                bodyPart.get(0).getChildObject().get(6).translateObject(tempCenterPoint.x*-1,tempCenterPoint.y*-1,tempCenterPoint.z*-1);
                bodyPart.get(0).getChildObject().get(6).rotateObject((float) Math.toRadians(-1.0f),1.0f, 0.0f, 0.0f);
                bodyPart.get(0).getChildObject().get(6).translateObject(tempCenterPoint.x*1,tempCenterPoint.y*1,tempCenterPoint.z*1);

                Vector3f tempCenterPoint2 = bodyPart.get(0).getChildObject().get(7).updateCenterPoint();
                bodyPart.get(0).getChildObject().get(7).translateObject(tempCenterPoint2.x*-1,tempCenterPoint2.y*-1,tempCenterPoint2.z*-1);
                bodyPart.get(0).getChildObject().get(7).rotateObject((float) Math.toRadians(1.0f),1.0f, 0.0f, 0.0f);
                bodyPart.get(0).getChildObject().get(7).translateObject(tempCenterPoint2.x*1,tempCenterPoint2.y*1,tempCenterPoint2.z*1);
            }

            if (counterJalanDepanArron == 130.0f){
                cekJalanDepanArron = false;
            }
            if(counterJalanDepanArron == -100.0f){
                cekJalanDepanArron = true;
            }
        }

        if (window.isKeyPressed(GLFW_KEY_I)) {// muter ke atas
            Vector3f tempCenterPoint = bodyPart.get(0).updateCenterPoint();
            bodyPart.get(0).translateObject(tempCenterPoint.x*-1,tempCenterPoint.y*-1,tempCenterPoint.z*-1);
            bodyPart.get(0).rotateObject(0.01f, 1f, 0f, 0f);
            bodyPart.get(0).translateObject(tempCenterPoint.x,tempCenterPoint.y,tempCenterPoint.z);
        }

        if (window.isKeyPressed(GLFW_KEY_K)) {// muter ke bawah
            Vector3f tempCenterPoint = bodyPart.get(0).updateCenterPoint();
            bodyPart.get(0).translateObject(tempCenterPoint.x*-1,tempCenterPoint.y*-1,tempCenterPoint.z*-1);
            bodyPart.get(0).rotateObject(-0.01f, 1f, 0f, 0f);
            bodyPart.get(0).translateObject(tempCenterPoint.x,tempCenterPoint.y,tempCenterPoint.z);
        }

        if (window.isKeyPressed(GLFW_KEY_J)) {// muter ke kiri
            Vector3f tempCenterPoint = bodyPart.get(0).updateCenterPoint();
            bodyPart.get(0).translateObject(tempCenterPoint.x*-1,tempCenterPoint.y*-1,tempCenterPoint.z*-1);
            bodyPart.get(0).rotateObject(-0.01f, 0f, 1f, 0f);
            bodyPart.get(0).translateObject(tempCenterPoint.x,tempCenterPoint.y,tempCenterPoint.z);
        }

        if (window.isKeyPressed(GLFW_KEY_L)) {// muter ke kanan
            Vector3f tempCenterPoint = bodyPart.get(0).updateCenterPoint();
            bodyPart.get(0).translateObject(tempCenterPoint.x*-1,tempCenterPoint.y*-1,tempCenterPoint.z*-1);
            bodyPart.get(0).rotateObject(0.01f, 0f, 1f, 0f);
            bodyPart.get(0).translateObject(tempCenterPoint.x,tempCenterPoint.y,tempCenterPoint.z);
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
            glClearColor(0.5f, 0.3f, 1.0f, 0.0f); // RapidTables.com (RGB color code chart)
            GL.createCapabilities();
            input();

//            Babi.get(0).getChildObject().get(0).getChildObject().get(5).drawLine(camera,projection);
            for (Object objBabi : Babi) {
                objBabi.draw(camera, projection);
            }
            for (Object objBG : BG) {
                objBG.draw(camera, projection);
            }
            for (Object wheezy : bodyPart) {
                wheezy.draw(camera, projection);
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
        new Main().run();
    }
}

