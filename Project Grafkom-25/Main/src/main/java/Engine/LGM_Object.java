package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL11.*;

public class LGM_Object extends Circle3D {
    float rZ;
    int stackCount;
    int sectorCount;

    public LGM_Object(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, ArrayList<Float> centerPoint, float rX, float rY, float rZ, int stackCount, int sectorCount, int option) {
        super(shaderModuleDataList, vertices, color, centerPoint, rX, rY);
        this.rZ = rZ;
        this.stackCount = stackCount;
        this.sectorCount = sectorCount;

        if (option == 0) {
            LGM_Head();
        } else if (option == 1) {
            LGM_AntennaeBody();
        } else if (option == 2) {
            LGM_AntennaeFoundation();

        } else if (option == 3) {
            LGM_AntennaeTop();
        } else if (option == 4){
            LGM_Neck();
        }else if (option == 5){
            LGM_Eye();
        }
        setupVAOVBO();
    }

    public void LGM_Head() {
        //Dari Ellipsoid
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        for (double v = -Math.PI / 2; v <= Math.PI / 2; v += Math.PI / 180) {
            for (double u = -Math.PI; u <= Math.PI; u += Math.PI / 180) {
                float x = rX * (float) (Math.cos(v) * Math.cos(u));
                float y = rY * (float) (Math.cos(v) * Math.sin(u));
                float z = rZ * (float) (Math.sin(v));
                temp.add(new Vector3f(x, y, z));
            }
        }
        vertices = temp;
    }

    public void LGM_AntennaeTop() {
        // Ellipsoid
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        for (double v = -Math.PI / 2; v <= Math.PI / 2; v += Math.PI / 180) {
            for (double u = -Math.PI; u <= Math.PI; u += Math.PI / 180) {
                float x = rX * (float) (Math.cos(v) * Math.cos(u));
                float y = rY * (float) (Math.cos(v) * Math.sin(u));
                float z = rZ * (float) (Math.sin(v));
                temp.add(new Vector3f(x, y, z));
            }
        }
        vertices = temp;
    }

    public void LGM_AntennaeBody() {
        // Tabung
        vertices.clear();
        float rxTemp = rX, ryTemp = rY;
        ArrayList<Vector3f> temp = new ArrayList<>();
        for (double i = 0; i <= 360; i += 0.05f) {
            float x = centerPoint.get(0) + rxTemp * (float) Math.cos(Math.toRadians(i));
            float y = centerPoint.get(1) + ryTemp * (float) Math.sin(Math.toRadians(i));

            temp.add(new Vector3f(x, y, rZ));
            temp.add(new Vector3f(x, y, -rZ));
        }
        vertices = temp;
    }

    public void LGM_AntennaeFoundation() {
        // Elliptic Cone
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        for (double v = 0; v <= 2 * Math.PI; v += Math.PI / 60) {
            for (double u = -Math.PI; u <= Math.PI; u += Math.PI / 60) {
                float x = (float) (rX * v * Math.cos(u));
                float y = (float) (rY * v * Math.sin(u));
                float z = (float) (rZ * v);
                temp.add(new Vector3f(x, y, z));
            }
        }
        vertices = temp;

    }
    public void LGM_Neck(){
        // Torus Ring
            vertices.clear();
            ArrayList<Vector3f> temp = new ArrayList<>();
            for(double v = 0; v<= Math.PI*2; v+=Math.PI/60){
                for(double u = 0; u<= Math.PI*2; u+=Math.PI/60){
                    float x = (rZ + rX * (float)(Math.cos(v))) * (float)Math.cos(u);
                    float y = (rZ + rY * (float)(Math.cos(v))) * (float)Math.sin(u);
                    float z = rZ * (float)(Math.sin(v));
                    temp.add(new Vector3f(x,y,z));
                }
            }
            vertices = temp;
    }
    public void LGM_Eye(){
        // Ellipsoid
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();
        for(double v = 0; v<= Math.PI*2; v+=Math.PI/60){
            for(double u = 0; u<= Math.PI*2; u+=Math.PI/60){
                float x = (rZ + rX * (float)(Math.cos(v))) * (float)Math.cos(u);
                float y = (rZ + rY * (float)(Math.cos(v))) * (float)Math.sin(u);
                float z = rZ * (float)(Math.sin(v));
                temp.add(new Vector3f(x,y,z));
            }
        }
        vertices = temp;
    }
    public void createWing(){
//        Vector3f temp = new Vector3f();
//        ArrayList<Vector3f> tempVertices = new ArrayList<>();          //titik 1 depan sayap (0, 1)
//        temp.x = 0;
//        temp.y = 0;
//        temp.z = (float)cpz - radiusZ/2;
//        tempVertices.add(temp);
//        temp = new Vector3f();
//        temp.x = 0;
//        temp.y = -radiusY;
//        temp.z = (float)cpz - radiusZ/2;
//        tempVertices.add(temp);
//        temp = new Vector3f();          //titik 2 belakang sayap (2, 3)
//        temp.x = 0;
//        temp.y = 0;
//        temp.z = (float)cpz + radiusZ/2;
//        tempVertices.add(temp);
//        temp = new Vector3f();
//        temp.x = 0;
//        temp.y = -radiusY;
//        temp.z = (float)cpz + radiusZ/2;
//        tempVertices.add(temp);
//        temp = new Vector3f();          //titik 3 ujung paling jauh sayap (4, 5)
//        temp.x = (float)cpx + radiusX * 1.15f;
//        temp.y = 0;
//        temp.z = (float)cpz + radiusZ/4;
//        tempVertices.add(temp);

    }

    public void draw(Camera camera, Projection projection){
        drawSetup(camera,projection);
        // Draw vertices
        glLineWidth(1);
        glPointSize(1);
        glDrawArrays(GL_POLYGON, 0, vertices.size());
        for(Object child : getChildObject()){
            child.draw(camera,projection);
        }
    }

    public float getrZ() {
        return rZ;
    }

    public void setrZ(float rZ) {
        this.rZ = rZ;
    }

}
