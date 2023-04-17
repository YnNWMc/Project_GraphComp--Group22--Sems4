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
    ArrayList<ArrayList<Object>> AOB = new ArrayList<ArrayList<Object>>();
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

        /* Yan Nathanael C14210061 */
        //Head
        LGMO.add(new LGM_Object(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Project_GraphComp--Group25--Sems4\\Project Grafkom-25\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)

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
        LGMO.get(0).getChildObject().get(0).getChildObject().add(new LGM_Object(
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
        LGMO.get(0).getChildObject().get(0).getChildObject().get(0).rotateObject(1.55f, 1f, 0f, 0f);
        LGMO.get(0).getChildObject().get(0).getChildObject().get(0).translateObject(0.0f, 0.7f, 0.0f);

        // Top of Antena
        LGMO.get(0).getChildObject().get(0).getChildObject().add(new LGM_Object(
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
                0.2f,
                0.2f,
                0.2f,
                90, // Stack -->
                45, // Sector --> Titik
                0));
        LGMO.get(0).getChildObject().get(0).getChildObject().get(1).translateObject(0.00f, 1.4f, -0.15f);

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
        LGMO.get(0).getChildObject().get(1).translateObject(0.00f, 0.25f, 0.35f);

        //Black Eye Middle
        LGMO.get(0).getChildObject().get(1).getChildObject().add(new LGM_Object(
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
        LGMO.get(0).getChildObject().get(1).getChildObject().get(0).translateObject(0.00f, 0.2f, 0.50f);

        //Kelopak Eye Middle Bawah
        LGMO.get(0).getChildObject().get(1).getChildObject().add(new LGM_Object(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.0f, 0.0f, 0.0f, 1.0f),
                List.of(0.0f, 0.0f, 2.0f),
                0.24f,
                0.24f,
                Arrays.asList(
                        new Vector3f(-0.225f, 0.225f, .7f),//TITIK1
                        new Vector3f(0.00f, 0.1f, .7f), //TITIK2
                        new Vector3f(0.225f, 0.225f, .7f) //TITIK3
                )
        ));
        LGMO.get(0).getChildObject().get(1).getChildObject().get(1).translateObject(0.00f, -0.14f, -0.1f);

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
        LGMO.get(0).getChildObject().get(2).rotateObject(0.4f, 0f, 0f, 1f);
        LGMO.get(0).getChildObject().get(2).translateObject(-0.495f, 0.19f, 0.35f);

        //Black Eye Left
        LGMO.get(0).getChildObject().get(2).getChildObject().add(new LGM_Object(
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
        LGMO.get(0).getChildObject().get(2).getChildObject().get(0).translateObject(-0.465f, 0.15f, 0.50f);

        //Kelopak Eye Left Bawah
        LGMO.get(0).getChildObject().get(2).getChildObject().add(new LGM_Object(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.0f, 0.0f, 0.0f, 1.0f),
                List.of(0.0f, 0.0f, 2.0f),
                0.24f,
                0.24f,
                Arrays.asList(
                        new Vector3f(-0.225f, 0.225f, .7f),//TITIK1
                        new Vector3f(0.00f, 0.1f, .7f), //TITIK2
                        new Vector3f(0.225f, 0.225f, .7f) //TITIK3
                )
        ));
        LGMO.get(0).getChildObject().get(2).getChildObject().get(1).rotateObject(0.35f, 0f, 0f, 1f);

        LGMO.get(0).getChildObject().get(2).getChildObject().get(1).translateObject(-0.35f, -0.15f, -0.1f);

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
        LGMO.get(0).getChildObject().get(3).rotateObject(-0.4f, 0f, 0f, 1f);
        LGMO.get(0).getChildObject().get(3).translateObject(0.495f, 0.19f, 0.35f);

        //Black Eye Right
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
        //.rotateObject(-0.4f, 0f, 0f, 1f);
        LGMO.get(0).getChildObject().get(3).getChildObject().get(0).translateObject(0.465f, 0.15f, 0.50f);

        //Kelopak Eye Right Bawah
        LGMO.get(0).getChildObject().get(3).getChildObject().add(new LGM_Object(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "C:\\File Coding InteliJ JAVA\\Grafika Komputer\\GrafKom-Yan\\Main\\resources\\shaders\\scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                ),
                new Vector4f(0.0f, 0.0f, 0.0f, 1.0f),
                List.of(0.0f, 0.0f, 2.0f),
                0.24f,
                0.24f,
                Arrays.asList(
                        new Vector3f(-0.225f, 0.225f, .7f),//TITIK1
                        new Vector3f(0.00f, 0.1f, .7f), //TITIK2
                        new Vector3f(0.225f, 0.225f, .7f) //TITIK3
                )
        ));
        LGMO.get(0).getChildObject().get(3).getChildObject().get(1).rotateObject(-0.35f, 0f, 0f, 1f);

        LGMO.get(0).getChildObject().get(3).getChildObject().get(1).translateObject(0.35f, -0.15f, -0.1f);
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
        LGMO.get(0).getChildObject().get(4).rotateObject(-1.2f, 0f, 0f, 1f);
        LGMO.get(0).getChildObject().get(4).translateObject(0.6f, 0.275f, 0f);
        //Ear Lobe Right
        LGMO.get(0).getChildObject().get(4).getChildObject().add(new LGM_Object(
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
        LGMO.get(0).getChildObject().get(4).getChildObject().get(0).rotateObject(-1.2f, 0f, 0f, 1f);
        LGMO.get(0).getChildObject().get(4).getChildObject().get(0).translateObject(0.65f, 0.35f, 0.35f);
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
        LGMO.get(0).getChildObject().get(5).rotateObject(-0.4f, 0f, 0f, 1f);
        LGMO.get(0).getChildObject().get(5).translateObject(-0.6f, 0.275f, 0f);
        //Ear Lobe Left
        LGMO.get(0).getChildObject().get(5).getChildObject().add(new LGM_Object(
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
        LGMO.get(0).getChildObject().get(5).getChildObject().get(0).rotateObject(-0.4f, 0f, 0f, 1f);
        LGMO.get(0).getChildObject().get(5).getChildObject().get(0).translateObject(-0.65f, 0.35f, 0.35f);
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
        LGMO.get(0).getChildObject().get(6).translateObject(0f, -0.25f, 0.52f);

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
        LGMO.get(0).getChildObject().get(7).rotateObject(1.55f, 1f, 0f, 0f);
        LGMO.get(0).getChildObject().get(7).translateObject(0.00f, -0.32f, 0.0f);

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
        LGMO.get(0).getChildObject().get(8).rotateObject(1.55f, 1f, 0f, 0f);
        LGMO.get(0).getChildObject().get(8).translateObject(0f, -0.67f, 0f);
        // Sabuk
        LGMO.get(0).getChildObject().get(8).getChildObject().add(new LGM_Object(
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
        LGMO.get(0).getChildObject().get(8).getChildObject().get(0).rotateObject(1.55f, 1f, 0f, 0f);
        LGMO.get(0).getChildObject().get(8).getChildObject().get(0).translateObject(0.0f, -0.95f, 0.0f);
        // Kepala Sabuk
        LGMO.get(0).getChildObject().get(8).getChildObject().add(new LGM_Object(
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
        LGMO.get(0).getChildObject().get(8).getChildObject().get(1).rotateObject(1.55f, 1f, 0f, 0f);
        LGMO.get(0).getChildObject().get(8).getChildObject().get(1).translateObject(0.0f, -0.925f, 0.65f);

        // Gambar Planet Kuning
        LGMO.get(0).getChildObject().get(8).getChildObject().add(new LGM_Object(
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
        LGMO.get(0).getChildObject().get(8).getChildObject().get(2).translateObject(0.3f, -0.6f, 0.294f);

        // Badan Biru
        LGMO.get(0).getChildObject().get(8).getChildObject().add(new LGM_Object(
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
        LGMO.get(0).getChildObject().get(8).getChildObject().get(3).translateObject(0.3f, -0.6f, 0.298f);
        // Gambar Ring Planet
        LGMO.get(0).getChildObject().get(8).getChildObject().add(new LGM_Object(
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
        LGMO.get(0).getChildObject().get(8).getChildObject().get(4).rotateObject(1.6f, 1f, 0f, 0f);
        LGMO.get(0).getChildObject().get(8).getChildObject().get(4).rotateObject(0.2f, 0f, 0f, 1f);
        LGMO.get(0).getChildObject().get(8).getChildObject().get(4).translateObject(0.3f, -0.6f, 0.45f);


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
        LGMO.get(0).getChildObject().get(9).rotateObject(1.55f, 1f, 0f, 0f);
        LGMO.get(0).getChildObject().get(9).translateObject(0f, -1.135f, 0f);

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
        LGMO.get(0).getChildObject().get(10).rotateObject(1.55f, 1f, 0f, 0f);
        LGMO.get(0).getChildObject().get(10).translateObject(-0.3f, -1.335f, 0f);
        // Kaki Kiri
        LGMO.get(0).getChildObject().get(10).getChildObject().add(new LGM_Object(
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
        LGMO.get(0).getChildObject().get(10).getChildObject().get(0).rotateObject(1.55f, 1f, 0f, 0f);
        LGMO.get(0).getChildObject().get(10).getChildObject().get(0).translateObject(-0.3f, -1.635f, 0f);
        // Paha Kiri Kecil
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
                0.425f,
                0.4f,
                0.125f,
                15, // Stack -->
                30, // Sector --> Titik
                1));
        LGMO.get(0).getChildObject().get(10).getChildObject().get(1).rotateObject(1.55f, 1f, 0f, 0f);
        LGMO.get(0).getChildObject().get(10).getChildObject().get(1).translateObject(-0.3f, -1.635f, 0f);

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
        LGMO.get(0).getChildObject().get(11).rotateObject(1.55f, 1f, 0f, 0f);
        LGMO.get(0).getChildObject().get(11).translateObject(0.3f, -1.335f, 0f);
        // Kaki Kanan
        LGMO.get(0).getChildObject().get(11).getChildObject().add(new LGM_Object(
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
        LGMO.get(0).getChildObject().get(11).getChildObject().get(0).rotateObject(1.55f, 1f, 0f, 0f);
        LGMO.get(0).getChildObject().get(11).getChildObject().get(0).translateObject(0.3f, -1.635f, 0f);
        // Paha Kanan Kecil
        LGMO.get(0).getChildObject().get(11).getChildObject().add(new LGM_Object(
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
        LGMO.get(0).getChildObject().get(11).getChildObject().get(1).rotateObject(1.55f, 1f, 0f, 0f);
        LGMO.get(0).getChildObject().get(11).getChildObject().get(1).translateObject(0.3f, -1.635f, 0f);

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
        LGMO.get(0).getChildObject().get(12).rotateObject(1.6f, 0f, 1f, 0f);
        LGMO.get(0).getChildObject().get(12).rotateObject(1f, 0f, 0f, -1f);
        LGMO.get(0).getChildObject().get(12).rotateObject(0.3f, 0f, 0f, 1f);
        LGMO.get(0).getChildObject().get(12).translateObject(-1.0f, -0.4f, 0f);
        // Telapak Kiri
        LGMO.get(0).getChildObject().get(12).getChildObject().add(new LGM_Object(
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
        LGMO.get(0).getChildObject().get(12).getChildObject().get(0).rotateObject(1.6f, 0f, 1f, 0f);
        LGMO.get(0).getChildObject().get(12).getChildObject().get(0).translateObject(-1.9f, 0.22f, 0f);

        // Jari Kiri1
        LGMO.get(0).getChildObject().get(12).getChildObject().add(new LGM_Object(
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
        LGMO.get(0).getChildObject().get(12).getChildObject().get(1).rotateObject(-1.5f, 0f, 0f, 1f);
        LGMO.get(0).getChildObject().get(12).getChildObject().get(1).translateObject(-2.3f, 0.22f, 0f);

        // Jari Kiri2
        LGMO.get(0).getChildObject().get(12).getChildObject().add(new LGM_Object(
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
        LGMO.get(0).getChildObject().get(12).getChildObject().get(2).rotateObject(-2.1f, 0f, 0f, 1f);
        LGMO.get(0).getChildObject().get(12).getChildObject().get(2).translateObject(-2.3f, 0.675f, 0f);

        // Jari Kiri3
        LGMO.get(0).getChildObject().get(12).getChildObject().add(new LGM_Object(
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
        LGMO.get(0).getChildObject().get(12).getChildObject().get(3).rotateObject(-3.3f, 0f, 0f, 1f);
        LGMO.get(0).getChildObject().get(12).getChildObject().get(3).translateObject(-1.6f, 0.7f, 0f);

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
        LGMO.get(0).getChildObject().get(13).rotateObject(1.6f, 0f, 1f, 0f);
        LGMO.get(0).getChildObject().get(13).rotateObject(1f, 0f, 0f, 1f);
        LGMO.get(0).getChildObject().get(13).rotateObject(0.3f, 0f, 0f, -1f);
        LGMO.get(0).getChildObject().get(13).translateObject(1.0f, -0.4f, 0f);

        // Telapak Kanan
        LGMO.get(0).getChildObject().get(13).getChildObject().add(new LGM_Object(
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
        LGMO.get(0).getChildObject().get(13).getChildObject().get(0).translateObject(1.75f, 0.28f, -0.25f);


        // Jari Kanan1
        LGMO.get(0).getChildObject().get(13).getChildObject().add(new LGM_Object(
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
        LGMO.get(0).getChildObject().get(13).getChildObject().get(1).rotateObject(1.9f, 0f, 0f, 1f);
        LGMO.get(0).getChildObject().get(13).getChildObject().get(1).translateObject(2.3f, 0.475f, 0f);

        // Jari Kanan2
        LGMO.get(0).getChildObject().get(13).getChildObject().add(new LGM_Object(
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
        LGMO.get(0).getChildObject().get(13).getChildObject().get(2).rotateObject(2.4f, 0f, 0f, 1f);
        LGMO.get(0).getChildObject().get(13).getChildObject().get(2).translateObject(2.1f, 0.8f, 0f);


        // Jari Kanan3
        LGMO.get(0).getChildObject().get(13).getChildObject().add(new LGM_Object(
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
        LGMO.get(0).getChildObject().get(13).getChildObject().get(3).rotateObject(3.4f, 0f, 0f, 1f);
        LGMO.get(0).getChildObject().get(13).getChildObject().get(3).translateObject(1.55f, 0.75f, 0f);

    }
    //Param Ian
    private float countjalan=0;
    private float countnoleh=0;
    private float countngangguk =0;
    private boolean kaki = true;


    //Param Yan
    private boolean limitKaki = true, limitTanganKanan = true, limitTanganKiri = true, limitAntena = true;
    private int counterKaki = 0, counterTgnKanan = 0, counterTgnKiri = 0, counterAntenna = 0;
    public void input() {
        //animasi Hamm c14210057 - Christian Philip Tjahyadi
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



        /*Yan Nathanael C14210061*/
        // 5678VBN ==> Animasi
        if (window.isKeyPressed(GLFW_KEY_5)) {
            LGMO.get(0).translateObject(0.002f, 0.0f, 0.0f);
            if (limitKaki) {
                counterKaki++;
                Vector3f tempCenterPoint = LGMO.get(0).getChildObject().get(10).updateCenterPoint();
                LGMO.get(0).getChildObject().get(10).translateObject(tempCenterPoint.x * -1, tempCenterPoint.y * -1, tempCenterPoint.z * -1);
                LGMO.get(0).getChildObject().get(10).rotateObject((float) Math.toRadians(1.0f), 0.0f, 0.0f, 1.0f);
                LGMO.get(0).getChildObject().get(10).translateObject(tempCenterPoint.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);

                Vector3f tempCenterPoint2 = LGMO.get(0).getChildObject().get(11).updateCenterPoint();
                LGMO.get(0).getChildObject().get(11).translateObject(tempCenterPoint2.x * -1, tempCenterPoint2.y * -1, tempCenterPoint2.z * -1);
                LGMO.get(0).getChildObject().get(11).rotateObject((float) Math.toRadians(-1.0f), 0.0f, 0.0f, 1.0f);
                LGMO.get(0).getChildObject().get(11).translateObject(tempCenterPoint2.x * 1, tempCenterPoint2.y * 1, tempCenterPoint2.z * 1);


                if (counterKaki == 15.0f) {
                    limitKaki = false;
                }
            } else {
                counterKaki--;
                Vector3f tempCenterPoint = LGMO.get(0).getChildObject().get(10).updateCenterPoint();
                LGMO.get(0).getChildObject().get(10).translateObject(tempCenterPoint.x * -1, tempCenterPoint.y * -1, tempCenterPoint.z * -1);
                LGMO.get(0).getChildObject().get(10).rotateObject((float) Math.toRadians(-1.0f), 0.0f, 0.0f, 1.0f);
                LGMO.get(0).getChildObject().get(10).translateObject(tempCenterPoint.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);

                Vector3f tempCenterPoint2 = LGMO.get(0).getChildObject().get(11).updateCenterPoint();
                LGMO.get(0).getChildObject().get(11).translateObject(tempCenterPoint2.x * -1, tempCenterPoint2.y * -1, tempCenterPoint2.z * -1);
                LGMO.get(0).getChildObject().get(11).rotateObject((float) Math.toRadians(1.0f), 0.0f, 0.0f, 1.0f);
                LGMO.get(0).getChildObject().get(11).translateObject(tempCenterPoint2.x * 1, tempCenterPoint2.y * 1, tempCenterPoint2.z * 1);

                if (counterKaki == -15.0f) {
                    limitKaki = true;
                }
            }
        }
        if (window.isKeyPressed(GLFW_KEY_6)) {
            LGMO.get(0).translateObject(-0.002f, 0.0f, 0.0f);
            if (limitKaki) {
                counterKaki++;
                Vector3f tempCenterPoint = LGMO.get(0).getChildObject().get(10).updateCenterPoint();
                LGMO.get(0).getChildObject().get(10).translateObject(tempCenterPoint.x * -1, tempCenterPoint.y * -1, tempCenterPoint.z * -1);
                LGMO.get(0).getChildObject().get(10).rotateObject((float) Math.toRadians(1.0f), 0.0f, 0.0f, 1.0f);
                LGMO.get(0).getChildObject().get(10).translateObject(tempCenterPoint.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);

                Vector3f tempCenterPoint2 = LGMO.get(0).getChildObject().get(11).updateCenterPoint();
                LGMO.get(0).getChildObject().get(11).translateObject(tempCenterPoint2.x * -1, tempCenterPoint2.y * -1, tempCenterPoint2.z * -1);
                LGMO.get(0).getChildObject().get(11).rotateObject((float) Math.toRadians(-1.0f), 0.0f, 0.0f, 1.0f);
                LGMO.get(0).getChildObject().get(11).translateObject(tempCenterPoint2.x * 1, tempCenterPoint2.y * 1, tempCenterPoint2.z * 1);
                if (counterKaki == 15.0f) {
                    limitKaki = false;
                }
            } else {
                counterKaki--;
                Vector3f tempCenterPoint = LGMO.get(0).getChildObject().get(10).updateCenterPoint();
                LGMO.get(0).getChildObject().get(10).translateObject(tempCenterPoint.x * -1, tempCenterPoint.y * -1, tempCenterPoint.z * -1);
                LGMO.get(0).getChildObject().get(10).rotateObject((float) Math.toRadians(-1.0f), 0.0f, 0.0f, 1.0f);
                LGMO.get(0).getChildObject().get(10).translateObject(tempCenterPoint.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);

                Vector3f tempCenterPoint2 = LGMO.get(0).getChildObject().get(11).updateCenterPoint();
                LGMO.get(0).getChildObject().get(11).translateObject(tempCenterPoint2.x * -1, tempCenterPoint2.y * -1, tempCenterPoint2.z * -1);
                LGMO.get(0).getChildObject().get(11).rotateObject((float) Math.toRadians(1.0f), 0.0f, 0.0f, 1.0f);
                LGMO.get(0).getChildObject().get(11).translateObject(tempCenterPoint2.x * 1, tempCenterPoint2.y * 1, tempCenterPoint2.z * 1);

                if (counterKaki == -15.0f) {
                    limitKaki = true;
                }
            }
        }
        if (window.isKeyPressed(GLFW_KEY_7)) {
            LGMO.get(0).translateObject(0.0f, 0.0f, 0.02f);
            if (limitKaki) {
                counterKaki++;
                Vector3f tempCenterPoint = LGMO.get(0).getChildObject().get(10).updateCenterPoint();
                LGMO.get(0).getChildObject().get(10).translateObject(tempCenterPoint.x * -1, tempCenterPoint.y * -1, tempCenterPoint.z * -1);
                LGMO.get(0).getChildObject().get(10).rotateObject((float) Math.toRadians(1.0f), 1.0f, 1.0f, 0.0f);
                LGMO.get(0).getChildObject().get(10).translateObject(tempCenterPoint.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);

                Vector3f tempCenterPoint2 = LGMO.get(0).getChildObject().get(11).updateCenterPoint();
                LGMO.get(0).getChildObject().get(11).translateObject(tempCenterPoint2.x * -1, tempCenterPoint2.y * -1, tempCenterPoint2.z * -1);
                LGMO.get(0).getChildObject().get(11).rotateObject((float) Math.toRadians(-1.0f), 1.0f, 1.0f, 0.0f);
                LGMO.get(0).getChildObject().get(11).translateObject(tempCenterPoint2.x * 1, tempCenterPoint2.y * 1, tempCenterPoint2.z * 1);
                if (counterKaki == 15.0f) {
                    limitKaki = false;
                }
            } else {
                counterKaki--;
                Vector3f tempCenterPoint = LGMO.get(0).getChildObject().get(10).updateCenterPoint();
                LGMO.get(0).getChildObject().get(10).translateObject(tempCenterPoint.x * -1, tempCenterPoint.y * -1, tempCenterPoint.z * -1);
                LGMO.get(0).getChildObject().get(10).rotateObject((float) Math.toRadians(-1.0f), 1.0f, 1.0f, 0.0f);
                LGMO.get(0).getChildObject().get(10).translateObject(tempCenterPoint.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);

                Vector3f tempCenterPoint2 = LGMO.get(0).getChildObject().get(11).updateCenterPoint();
                LGMO.get(0).getChildObject().get(11).translateObject(tempCenterPoint2.x * -1, tempCenterPoint2.y * -1, tempCenterPoint2.z * -1);
                LGMO.get(0).getChildObject().get(11).rotateObject((float) Math.toRadians(1.0f), 1.0f, 1.0f, 0.0f);
                LGMO.get(0).getChildObject().get(11).translateObject(tempCenterPoint2.x * 1, tempCenterPoint2.y * 1, tempCenterPoint2.z * 1);

                if (counterKaki == -15.0f) {
                    limitKaki = true;
                }
            }
        }
        if (window.isKeyPressed(GLFW_KEY_8)) {
            LGMO.get(0).translateObject(0.0f, 0.0f, -0.02f);
            if (limitKaki) {
                counterKaki++;
                Vector3f tempCenterPoint = LGMO.get(0).getChildObject().get(10).updateCenterPoint();
                LGMO.get(0).getChildObject().get(10).translateObject(tempCenterPoint.x * -1, tempCenterPoint.y * -1, tempCenterPoint.z * -1);
                LGMO.get(0).getChildObject().get(10).rotateObject((float) Math.toRadians(1.0f), 1.0f, 1.0f, 0.0f);
                LGMO.get(0).getChildObject().get(10).translateObject(tempCenterPoint.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);

                Vector3f tempCenterPoint2 = LGMO.get(0).getChildObject().get(11).updateCenterPoint();
                LGMO.get(0).getChildObject().get(11).translateObject(tempCenterPoint2.x * -1, tempCenterPoint2.y * -1, tempCenterPoint2.z * -1);
                LGMO.get(0).getChildObject().get(11).rotateObject((float) Math.toRadians(-1.0f), 1.0f, 1.0f, 0.0f);
                LGMO.get(0).getChildObject().get(11).translateObject(tempCenterPoint2.x * 1, tempCenterPoint2.y * 1, tempCenterPoint2.z * 1);
                if (counterKaki == 15.0f) {
                    limitKaki = false;
                }
            } else {
                counterKaki--;
                Vector3f tempCenterPoint = LGMO.get(0).getChildObject().get(10).updateCenterPoint();
                LGMO.get(0).getChildObject().get(10).translateObject(tempCenterPoint.x * -1, tempCenterPoint.y * -1, tempCenterPoint.z * -1);
                LGMO.get(0).getChildObject().get(10).rotateObject((float) Math.toRadians(-1.0f), 1.0f, 1.0f, 0.0f);
                LGMO.get(0).getChildObject().get(10).translateObject(tempCenterPoint.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);

                Vector3f tempCenterPoint2 = LGMO.get(0).getChildObject().get(11).updateCenterPoint();
                LGMO.get(0).getChildObject().get(11).translateObject(tempCenterPoint2.x * -1, tempCenterPoint2.y * -1, tempCenterPoint2.z * -1);
                LGMO.get(0).getChildObject().get(11).rotateObject((float) Math.toRadians(1.0f), 1.0f, 1.0f, 0.0f);
                LGMO.get(0).getChildObject().get(11).translateObject(tempCenterPoint2.x * 1, tempCenterPoint2.y * 1, tempCenterPoint2.z * 1);

                if (counterKaki == -15.0f) {
                    limitKaki = true;
                }
            }
        }
        if (window.isKeyPressed(GLFW_KEY_V)) {
            if (limitTanganKiri) {
                counterTgnKanan++;
                Vector3f tempCenterPoint = LGMO.get(0).getChildObject().get(12).updateCenterPoint();
                LGMO.get(0).getChildObject().get(12).translateObject(tempCenterPoint.x * -1, tempCenterPoint.y * -1, tempCenterPoint.z * -1);
                LGMO.get(0).getChildObject().get(12).rotateObject((float) Math.toRadians(1f), 1.0f, 0.0f, 0.0f);
                LGMO.get(0).getChildObject().get(12).translateObject(tempCenterPoint.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);
                LGMO.get(0).getChildObject().get(12).translateObject(tempCenterPoint.x * -1, tempCenterPoint.y * -1, tempCenterPoint.z * -1);
                LGMO.get(0).getChildObject().get(12).rotateObject((float) Math.toRadians(1f), 0.0f, 0.0f, 1.0f);
                LGMO.get(0).getChildObject().get(12).translateObject(tempCenterPoint.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);
                if (counterTgnKanan == 10f) {
                    limitTanganKiri = false;
                }
            } else {
                counterTgnKanan--;
                Vector3f tempCenterPoint = LGMO.get(0).getChildObject().get(12).updateCenterPoint();
                LGMO.get(0).getChildObject().get(12).translateObject(tempCenterPoint.x * -1, tempCenterPoint.y * -1, tempCenterPoint.z * -1);
                LGMO.get(0).getChildObject().get(12).rotateObject((float) Math.toRadians(-1f), 1.0f, 0.0f, 0.0f);
                LGMO.get(0).getChildObject().get(12).translateObject(tempCenterPoint.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);
                LGMO.get(0).getChildObject().get(12).translateObject(tempCenterPoint.x * -1, tempCenterPoint.y * -1, tempCenterPoint.z * -1);
                LGMO.get(0).getChildObject().get(12).rotateObject((float) Math.toRadians(-1f), 0.0f, 0.0f, 1.0f);
                LGMO.get(0).getChildObject().get(12).translateObject(tempCenterPoint.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);
                if (counterTgnKanan == -10f) {
                    limitTanganKiri = true;
                }
            }
        }
        if (window.isKeyPressed(GLFW_KEY_N)) {
            if (limitTanganKanan) {
                counterTgnKiri++;
                Vector3f tempCenterPoint = LGMO.get(0).getChildObject().get(13).updateCenterPoint();
                LGMO.get(0).getChildObject().get(13).translateObject(tempCenterPoint.x * -1, tempCenterPoint.y * -1, tempCenterPoint.z * -1);
                LGMO.get(0).getChildObject().get(13).rotateObject((float) Math.toRadians(1f), 1.0f, 0.0f, 0.0f);
                LGMO.get(0).getChildObject().get(13).translateObject(tempCenterPoint.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);
                LGMO.get(0).getChildObject().get(13).translateObject(tempCenterPoint.x * -1, tempCenterPoint.y * -1, tempCenterPoint.z * -1);
                LGMO.get(0).getChildObject().get(13).rotateObject((float) Math.toRadians(1f), 0.0f, 0.0f, 1.0f);
                LGMO.get(0).getChildObject().get(13).translateObject(tempCenterPoint.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);
                if (counterTgnKiri == 10f) {
                    limitTanganKanan = false;
                }
            } else {
                counterTgnKiri--;
                Vector3f tempCenterPoint = LGMO.get(0).getChildObject().get(13).updateCenterPoint();
                LGMO.get(0).getChildObject().get(13).translateObject(tempCenterPoint.x * -1, tempCenterPoint.y * -1, tempCenterPoint.z * -1);
                LGMO.get(0).getChildObject().get(13).rotateObject((float) Math.toRadians(-1f), 1.0f, 0.0f, 0.0f);
                LGMO.get(0).getChildObject().get(13).translateObject(tempCenterPoint.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);
                LGMO.get(0).getChildObject().get(13).translateObject(tempCenterPoint.x * -1, tempCenterPoint.y * -1, tempCenterPoint.z * -1);
                LGMO.get(0).getChildObject().get(13).rotateObject((float) Math.toRadians(-1f), 0.0f, 0.0f, 1.0f);
                LGMO.get(0).getChildObject().get(13).translateObject(tempCenterPoint.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);
                if (counterTgnKiri == -10f) {
                    limitTanganKanan = true;
                }
            }
        }
        if (window.isKeyPressed(GLFW_KEY_B)) {
            if (limitAntena) {
                counterAntenna++;
                Vector3f tempCenterPoint = LGMO.get(0).getChildObject().get(0).updateCenterPoint();
                LGMO.get(0).getChildObject().get(0).translateObject(tempCenterPoint.x * -1, tempCenterPoint.y * -1, tempCenterPoint.z * -1);
                LGMO.get(0).getChildObject().get(0).rotateObject((float) Math.toRadians(-1.0f), 1.0f, 1.0f, 1.0f);
                LGMO.get(0).getChildObject().get(0).translateObject(tempCenterPoint.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);
                if (counterAntenna == 8f) {
                    limitAntena = false;
                }
            }
            else {
                counterAntenna--;
                Vector3f tempCenterPoint = LGMO.get(0).getChildObject().get(0).updateCenterPoint();
                LGMO.get(0).getChildObject().get(0).translateObject(tempCenterPoint.x * -1, tempCenterPoint.y * -1, tempCenterPoint.z * -1);
                LGMO.get(0).getChildObject().get(0).rotateObject((float) Math.toRadians(1.0f), 1.0f, 1.0f, 1.0f);
                LGMO.get(0).getChildObject().get(0).translateObject(tempCenterPoint.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);
                if (counterAntenna == -8f) {
                    limitAntena = true;
                }
            }
        }
        // RTYFGH ==> Rotate
        if (window.isKeyPressed(GLFW_KEY_R)) {
            for (LGM_Object i : LGMO) {
                i.rotateObject(0.01f, 0f, 0f, 1f);
            }
        }
        if (window.isKeyPressed(GLFW_KEY_Y)) {
            for (LGM_Object i : LGMO) {
                i.rotateObject(-0.01f, 0f, 0f, 1f);
            }
        }
        if (window.isKeyPressed(GLFW_KEY_T)) {
            Vector3f tempCenterPointw = LGMO.get(0).updateCenterPoint();
            LGMO.get(0).translateObject(tempCenterPointw.x * -1, tempCenterPointw.y * -1, tempCenterPointw.z * -1);
            LGMO.get(0).rotateObject(0.05f, 1f, 0f, 0f);
            LGMO.get(0).translateObject(tempCenterPointw.x * 1, tempCenterPointw.y * 1, tempCenterPointw.z * 1);
        }
        if (window.isKeyPressed(GLFW_KEY_G)) {
            Vector3f tempCenterPoints = LGMO.get(0).updateCenterPoint();
            LGMO.get(0).translateObject(tempCenterPoints.x * -1, tempCenterPoints.y * -1, tempCenterPoints.z * -1);
            LGMO.get(0).rotateObject(-0.05f, 1f, 0f, 0f);
            LGMO.get(0).translateObject(tempCenterPoints.x * 1, tempCenterPoints.y * 1, tempCenterPoints.z * 1);
        }
        if (window.isKeyPressed(GLFW_KEY_F)) {
            Vector3f tempCenterPointsa = LGMO.get(0).updateCenterPoint();
            LGMO.get(0).translateObject(tempCenterPointsa.x * -1, tempCenterPointsa.y * -1, tempCenterPointsa.z * -1);
            LGMO.get(0).rotateObject(-0.05f, 0f, 1f, 0f);
            LGMO.get(0).translateObject(tempCenterPointsa.x * 1, tempCenterPointsa.y * 1, tempCenterPointsa.z * 1);
        }
        if (window.isKeyPressed(GLFW_KEY_H)) {
            Vector3f tempCenterPointsd = LGMO.get(0).updateCenterPoint();
            LGMO.get(0).translateObject(tempCenterPointsd.x * -1, tempCenterPointsd.y * -1, tempCenterPointsd.z * -1);
            LGMO.get(0).rotateObject(0.05f, 0f, 1f, 0f);
            LGMO.get(0).translateObject(tempCenterPointsd.x * 1, tempCenterPointsd.y * 1, tempCenterPointsd.z * 1);
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
            for (Object objLGM : LGMO) {
                objLGM.draw(camera, projection);
            }
            for (Object objBG : BG) {
                objBG.draw(camera, projection);
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

