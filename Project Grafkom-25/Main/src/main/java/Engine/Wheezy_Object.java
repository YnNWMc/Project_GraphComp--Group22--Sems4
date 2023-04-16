package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.lwjgl.opengl.GL11.*;

public class Wheezy_Object extends Circle3D{
    float rZ;
    int stackCount;
    int sectorCount;

    public Wheezy_Object(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, double r, ArrayList<Float> centerPoint, float rX, float rY, float rZ, int stackCount, int sectorCount, int option) {
        super(shaderModuleDataList, vertices, color, centerPoint, rX, rY);
        this.rZ = rZ;
        this.stackCount = stackCount;
        this.sectorCount = sectorCount;

       if(option == 1){
           createBody();
       }
       else if (option == 2){
           createBelly();
       }
       else if (option == 3){
           createHand();
       }
       else if (option == 4){
           createEye();
       }
       else if (option == 5){
            createParuh();
       }

        setupVAOVBO();
    }


//    public void createPotatoBody(){
//        vertices.clear();
//        ArrayList<Vector3f> temp = new ArrayList<>();
//
//        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/180){
//            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/180){
//                float x = rX* (float)(Math.cos(v) * Math.cos(u));
//                float y = rY * (float)(Math.cos(v) * Math.sin(u));
//                float z = rZ * (float)(Math.sin(v));
//                temp.add(new Vector3f(x,y,z));
//            }
//        }
//        vertices = temp;
//    }

    public void createParuh(){
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        for (double v = 0; v <= 2 * Math.PI; v += Math.PI / 180) {
            for (double u = -Math.PI; u <= Math.PI; u += Math.PI / 180) {
                float x = (float) (rX * v * Math.cos(u));
                float y = (float) (rY * v * Math.sin(u));
                float z = (float) (rZ * v);
                temp.add(new Vector3f(x, y, z));
            }
        }
        vertices = temp;
    }

    public void createHand() {
        vertices.clear();
        float pi = (float)Math.PI;

        float sectorStep = 2 * (float)Math.PI / sectorCount;
        float stackStep = (float)Math.PI / stackCount;
        float sectorAngle, StackAngle, x, y, z;

        // u stackup angle
        for (int i = 0; i <= stackCount; ++i)
        {
            StackAngle = pi / 2 - i * stackStep;
            x = rX * StackAngle *(float)Math.cos(StackAngle);
            y = rY * StackAngle * (float)Math.sin(StackAngle);
            z = rZ * StackAngle * StackAngle;

            for (int j = 0; j <= sectorCount; ++j)
            {
                sectorAngle = j * sectorStep;
                Vector3f temp_vector = new Vector3f();
                temp_vector.x = centerPoint.get(0) + x;
                temp_vector.y = centerPoint.get(1) + y ;
                temp_vector.z = centerPoint.get(2) + z;
                vertices.add(temp_vector);
            }
        }
    }

    public void createEye(){
        vertices.clear();
        float radiusX = rX;
        float radiusY = rY;
        float radiusZ = rZ;
        List<Float> centerPoint = Arrays.asList(0.0f,0.0f,0.0f);

        float pi = (float)Math.PI;
        float sectorStep = 2 * (float)Math.PI / sectorCount;
        float stackStep = (float)Math.PI / stackCount;
        // Sector/Stackstep bisa bagi 2 buat half object/sphere
        float sectorAngle, StackAngle, stackAngle,xy ,x, y, z;
        for (int i = 0; i <= stackCount; ++i)
        {
            StackAngle = pi / 2 - i * stackStep;
            x = radiusX * (float)Math.cos(StackAngle);
            y = radiusY * (float)Math.cos(StackAngle);
            z = radiusZ * (float)Math.sin(StackAngle);

            for (int j = 0; j <= sectorCount; ++j)
            {
                sectorAngle = j * sectorStep;
                Vector3f temp_vector = new Vector3f();
                temp_vector.x = centerPoint.get(0) + x * (float)Math.cos(sectorAngle);
                temp_vector.y = centerPoint.get(1) + y * (float)Math.sin(sectorAngle);
                temp_vector.z = centerPoint.get(2) + z + 0.2f;
                vertices.add(temp_vector);
            }
        }
    }

    public void createBelly(){
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();
        for (int i = 0; i < 360; i++) {
            float rad = (float) (i * Math.PI / 180);
            float x = (float) (rX * Math.cos(rad) * (1.6 + 0.2 * Math.sin(3 * rad)));
            float y = (float) -(rY * Math.sin(rad) * (1.35 + 0.1 * Math.sin(3 * rad))); // di reverse pake -

            temp.add(new Vector3f(x,y,0f));
            temp.add(new Vector3f(x,y,rZ));
        }
        vertices = temp;
    }

    //mungkin jd hidung
    public void createBody() {
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();
        for (int i = 0; i < 360; i++) {
            float rad = (float) (i * Math.PI / 180);
            float x = (float) (rX * Math.cos(rad) * (1.0 + 0.2 * Math.sin(3 * rad)));
            float y = (float) -(rY * Math.sin(rad) * (1.2 + 0.1 * Math.sin(3 * rad))); // di reverse

            temp.add(new Vector3f(x,y,0f));
            temp.add(new Vector3f(x,y,rZ));
        }
        vertices = temp;
    }

    public void createDasi() {
        vertices.clear();
        int degree = 90;
        for(float i = 0;i<3;i++){
            double rad = degToRad(degree);
            Float x = (float) (centerPoint.get(0)+Math.cos(rad)*rX);
            Float y = (float) (centerPoint.get(1)+Math.sin(rad)*rY);
            vertices.add(new Vector3f(x,y,0f));
            vertices.add(new Vector3f(x,y,0f));
            if(degree == 90){
                degree += 135;
            }
            else{
                degree += 90;
            }
        }
    }

    public void createTabung(){
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();
        for(double i = 0 ; i <= 360 ; i += 0.05f){
            float x = centerPoint.get(0) + rX * (float)Math.cos(Math.toRadians(i));
            float y = centerPoint.get(1) + rY * (float)Math.sin(Math.toRadians(i));

            temp.add(new Vector3f(x,y,0f));
            temp.add(new Vector3f(x,y,-rZ));
        }
        vertices = temp;
    }

    public void createSphere(){
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/240){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/240){
                float x = this.rX * (float)(Math.cos(v) * Math.cos(u));
                float y = this.rY * (float)(Math.cos(v) * Math.sin(u));
                float z = this.rZ * (float)(Math.sin(v));
                temp.add(new Vector3f(x,y,z));
            }
        }
        vertices = temp;
    }


    /*
    public void createHyperboloidParaboloid() {
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();
        for(double v = 0; v<= 100; v+=0.01){
            for(double u = -Math.PI; u<= Math.PI; u+=0.666){
                float x = 0.125f * (float)v * (float)(Math.tan(u));
                float y = 0.25f * (float)v * (float)((1/Math.cos(u)));
                float z = 0.5f * (float)Math.pow(v,2);
                temp.add(new Vector3f(x,y,z));
            }
        }
        vertices = temp;
    }*/
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
